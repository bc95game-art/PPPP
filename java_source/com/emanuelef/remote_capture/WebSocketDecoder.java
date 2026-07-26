package com.emanuelef.remote_capture;

import android.util.Log;
import com.emanuelef.remote_capture.model.PayloadChunk;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WebSocketDecoder {
    private static final int MAX_FRAGMENT_SIZE = 67108864;
    private static final int MAX_FRAME_SIZE = 16777216;
    private static final int MAX_PENDING_CHUNKS = 100;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CLOSE = 8;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_PING = 9;
    public static final int OPCODE_PONG = 10;
    public static final int OPCODE_TEXT = 1;
    private static final String TAG = "WebSocketDecoder";
    private ByteArrayOutputStream mFragmentBuffer;
    private int mFragmentStreamId;
    private long mFragmentTimestamp;
    private final DecodedFrameListener mListener;
    private int mPendingOffset;
    private final ArrayList<PayloadChunk> mPendingChunks = new ArrayList<>();
    private int mFragmentOpcode = -1;

    /* loaded from: classes.dex */
    public interface DecodedFrameListener {
        void onWebSocketFrame(PayloadChunk payloadChunk);
    }

    /* loaded from: classes.dex */
    public static class FrameParseResult {
        public int bytesConsumed;
        public String errorMessage;
        public boolean fin;
        public int opcode;
        public byte[] payload;
        public ParseStatus status;

        public static FrameParseResult error(String str) {
            FrameParseResult frameParseResult = new FrameParseResult();
            frameParseResult.status = ParseStatus.ERROR;
            frameParseResult.errorMessage = str;
            return frameParseResult;
        }

        public static FrameParseResult incomplete() {
            FrameParseResult frameParseResult = new FrameParseResult();
            frameParseResult.status = ParseStatus.INCOMPLETE;
            return frameParseResult;
        }

        public static FrameParseResult success(int i, boolean z, byte[] bArr, int i2) {
            FrameParseResult frameParseResult = new FrameParseResult();
            frameParseResult.status = ParseStatus.SUCCESS;
            frameParseResult.opcode = i;
            frameParseResult.fin = z;
            frameParseResult.payload = bArr;
            frameParseResult.bytesConsumed = i2;
            return frameParseResult;
        }
    }

    /* loaded from: classes.dex */
    public enum ParseStatus {
        INCOMPLETE,
        SUCCESS,
        ERROR
    }

    public WebSocketDecoder(DecodedFrameListener decodedFrameListener) {
        this.mListener = decodedFrameListener;
    }

    private void consumeBytes(int i) {
        while (i > 0 && !this.mPendingChunks.isEmpty()) {
            int length = this.mPendingChunks.get(0).payload.length;
            int i2 = this.mPendingOffset;
            int i3 = length - i2;
            if (i >= i3) {
                this.mPendingChunks.remove(0);
                this.mPendingOffset = 0;
                i -= i3;
            } else {
                this.mPendingOffset = i2 + i;
                i = 0;
            }
        }
    }

    private PayloadChunk createDecodedChunk(int i, boolean z, byte[] bArr, boolean z2, boolean z3, long j, int i2) {
        PayloadChunk payloadChunk = new PayloadChunk(bArr, PayloadChunk.ChunkType.WEBSOCKET, z3, j, i2);
        payloadChunk.wsOpcode = i;
        payloadChunk.wsIsFinal = z;
        payloadChunk.wsWasFragmented = z2;
        return payloadChunk;
    }

    private void emitFrame(int i, boolean z, byte[] bArr, boolean z2, PayloadChunk payloadChunk) {
        this.mListener.onWebSocketFrame(createDecodedChunk(i, z, bArr, z2, payloadChunk.is_sent, payloadChunk.timestamp, payloadChunk.stream_id));
    }

    private void emitPendingAsRaw() {
        ArrayList<PayloadChunk> arrayList = this.mPendingChunks;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PayloadChunk payloadChunk = arrayList.get(i);
            i++;
            PayloadChunk payloadChunk2 = payloadChunk;
            payloadChunk2.type = PayloadChunk.ChunkType.RAW;
            payloadChunk2.wsOpcode = -1;
            this.mListener.onWebSocketFrame(payloadChunk2);
        }
        this.mPendingChunks.clear();
        this.mPendingOffset = 0;
    }

    private int getTotalPendingBytes() {
        int i = -this.mPendingOffset;
        ArrayList<PayloadChunk> arrayList = this.mPendingChunks;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            PayloadChunk payloadChunk = arrayList.get(i2);
            i2++;
            i += payloadChunk.payload.length;
        }
        return i;
    }

    private void handleParsedFrame(FrameParseResult frameParseResult, PayloadChunk payloadChunk) {
        int i = frameParseResult.opcode;
        boolean z = frameParseResult.fin;
        byte[] bArr = frameParseResult.payload;
        if (i >= 8) {
            emitFrame(i, z, bArr, false, payloadChunk);
        } else if (i != 0 && !z) {
            if (this.mFragmentBuffer != null) {
                Log.w(TAG, "New fragment started while previous incomplete");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mFragmentBuffer = byteArrayOutputStream;
            this.mFragmentOpcode = i;
            this.mFragmentTimestamp = payloadChunk.timestamp;
            this.mFragmentStreamId = payloadChunk.stream_id;
            try {
                byteArrayOutputStream.write(bArr);
            } catch (Exception e) {
                Log.e(TAG, "Error writing to fragment buffer", e);
            }
        } else if (i == 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = this.mFragmentBuffer;
            if (byteArrayOutputStream2 == null) {
                Log.w(TAG, "Continuation frame without start");
                emitFrame(i, z, bArr, false, payloadChunk);
            } else if (byteArrayOutputStream2.size() + bArr.length > MAX_FRAGMENT_SIZE) {
                Log.w(TAG, "Fragment size limit exceeded");
                this.mFragmentBuffer = null;
            } else {
                try {
                    this.mFragmentBuffer.write(bArr);
                } catch (Exception e2) {
                    Log.e(TAG, "Error writing to fragment buffer", e2);
                }
                if (z) {
                    PayloadChunk createDecodedChunk = createDecodedChunk(this.mFragmentOpcode, true, this.mFragmentBuffer.toByteArray(), true, payloadChunk.is_sent, this.mFragmentTimestamp, this.mFragmentStreamId);
                    this.mFragmentBuffer = null;
                    this.mFragmentOpcode = -1;
                    this.mListener.onWebSocketFrame(createDecodedChunk);
                }
            }
        } else {
            emitFrame(i, z, bArr, false, payloadChunk);
        }
    }

    public static boolean isControlOpcode(int i) {
        return i >= 8;
    }

    public static boolean isValidOpcode(int i) {
        return i == 0 || i == 1 || i == 2 || i == 8 || i == 9 || i == 10;
    }

    private FrameParseResult parseFrame(boolean z) {
        boolean z2;
        byte[] bArr;
        int totalPendingBytes = getTotalPendingBytes();
        int i = 2;
        if (totalPendingBytes < 2) {
            return FrameParseResult.incomplete();
        }
        byte readByte = readByte(0);
        int i2 = readByte & 255;
        boolean z3 = true;
        byte readByte2 = readByte(1);
        if ((readByte & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = (i2 >> 4) & 7;
        int i4 = readByte & 15;
        if ((readByte2 & 128) == 0) {
            z3 = false;
        }
        int i5 = readByte2 & Byte.MAX_VALUE;
        if (i3 != 0) {
            Log.d(TAG, "RSV bits set: " + i3 + " (might be extension)");
        }
        if (z && !z3) {
            Log.w(TAG, "Client frame should be masked but isn't");
        } else if (!z && z3) {
            Log.w(TAG, "Server frame should not be masked but is");
        }
        long j = i5;
        if (i5 == 126) {
            if (totalPendingBytes < 4) {
                return FrameParseResult.incomplete();
            }
            j = ((readByte(2) & 255) << 8) | (readByte(3) & 255);
            i = 4;
        } else if (i5 == 127) {
            if (totalPendingBytes < 10) {
                return FrameParseResult.incomplete();
            }
            long j2 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                j2 = (j2 << 8) | (readByte(i6 + 2) & 255);
            }
            if (j2 < 0) {
                return FrameParseResult.error("Payload length overflow");
            }
            j = j2;
            i = 10;
        }
        if (j > 16777216) {
            return FrameParseResult.error("Payload too large: " + j);
        }
        if (i4 >= 8) {
            if (!z2) {
                Log.w(TAG, "Control frame with FIN=0 (RFC violation: control frames MUST NOT be fragmented)");
            }
            if (j > 125) {
                Log.w(TAG, "Control frame payload " + j + " > 125 bytes (RFC violation)");
            }
        }
        if (z3) {
            int i7 = i + 4;
            if (totalPendingBytes < i7) {
                return FrameParseResult.incomplete();
            }
            bArr = new byte[4];
            for (int i8 = 0; i8 < 4; i8++) {
                bArr[i8] = readByte(i + i8);
            }
            i = i7;
        } else {
            bArr = null;
        }
        int i9 = (int) j;
        int i10 = i + i9;
        if (totalPendingBytes < i10) {
            return FrameParseResult.incomplete();
        }
        byte[] bArr2 = new byte[i9];
        for (int i11 = 0; i11 < j; i11++) {
            bArr2[i11] = readByte(i + i11);
        }
        if (z3) {
            unmaskPayload(bArr2, bArr);
        }
        return FrameParseResult.success(i4, z2, bArr2, i10);
    }

    private byte readByte(int i) {
        int i2;
        ArrayList<PayloadChunk> arrayList = this.mPendingChunks;
        int size = arrayList.size();
        boolean z = true;
        int i3 = i;
        int i4 = 0;
        while (i4 < size) {
            PayloadChunk payloadChunk = arrayList.get(i4);
            i4++;
            PayloadChunk payloadChunk2 = payloadChunk;
            if (z) {
                i2 = this.mPendingOffset;
            } else {
                i2 = 0;
            }
            byte[] bArr = payloadChunk2.payload;
            int length = bArr.length - i2;
            if (i3 < length) {
                return bArr[i2 + i3];
            }
            i3 -= length;
            z = false;
        }
        throw new IndexOutOfBoundsException("Position " + i + " out of bounds");
    }

    private static void unmaskPayload(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i % 4]);
        }
    }

    public void handleChunk(PayloadChunk payloadChunk) {
        byte[] bArr = payloadChunk.payload;
        if (bArr != null && bArr.length != 0) {
            if (this.mPendingChunks.size() >= 100) {
                Log.w(TAG, "Too many pending chunks, emitting as raw");
                emitPendingAsRaw();
            }
            if (getTotalPendingBytes() + payloadChunk.payload.length > MAX_FRAME_SIZE) {
                Log.w(TAG, "Pending bytes limit exceeded, emitting as raw");
                emitPendingAsRaw();
            }
            this.mPendingChunks.add(payloadChunk);
            while (true) {
                FrameParseResult parseFrame = parseFrame(payloadChunk.is_sent);
                ParseStatus parseStatus = parseFrame.status;
                if (parseStatus != ParseStatus.INCOMPLETE) {
                    if (parseStatus == ParseStatus.ERROR) {
                        Log.w(TAG, "Frame parse error: " + parseFrame.errorMessage);
                        emitPendingAsRaw();
                        return;
                    }
                    consumeBytes(parseFrame.bytesConsumed);
                    handleParsedFrame(parseFrame, payloadChunk);
                } else {
                    return;
                }
            }
        }
    }
}
