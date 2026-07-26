package com.emanuelef.remote_capture;

import com.emanuelef.remote_capture.model.PayloadChunk;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.brotli.dec.BrotliInputStream;
/* loaded from: classes.dex */
public class HTTPReassembly {
    private static final int MAX_HEADERS_SIZE = 1024;
    private static final String TAG = "HTTPReassembly";
    private final ArrayList<PayloadChunk> mBody;
    private int mBodySize;
    private boolean mChunkedEncoding;
    private ContentEncoding mContentEncoding;
    private int mContentLength;
    private final boolean mDumpPayload;
    private PayloadChunk mFirstChunk;
    private final ArrayList<PayloadChunk> mHeaders;
    private int mHeadersSize;
    private boolean mInvalidHttp;
    private final ReassemblyListener mListener;
    private boolean mReadingHeaders;
    private boolean mReassembleChunks;
    private boolean mSwitchingProtocols;
    private WebSocketDecoder mWebSocketDecoder;
    private boolean mWebsocketUpgrade;

    /* loaded from: classes.dex */
    public enum ContentEncoding {
        UNKNOWN,
        GZIP,
        DEFLATE,
        BROTLI,
        ZSTD
    }

    /* loaded from: classes.dex */
    public interface ReassemblyListener {
        void onChunkReassembled(PayloadChunk payloadChunk);
    }

    public HTTPReassembly(boolean z, ReassemblyListener reassemblyListener, boolean z2) {
        this.mHeaders = new ArrayList<>();
        this.mBody = new ArrayList<>();
        this.mSwitchingProtocols = false;
        this.mWebsocketUpgrade = false;
        this.mListener = reassemblyListener;
        this.mReassembleChunks = z;
        this.mDumpPayload = z2;
        reset();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #5 {all -> 0x0024, blocks: (B:4:0x0008, B:13:0x001b, B:16:0x0026, B:18:0x002d, B:19:0x0038, B:21:0x0040, B:28:0x005d, B:23:0x0047, B:24:0x0049, B:26:0x0050, B:27:0x0057), top: B:46:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void decodeBody(PayloadChunk payloadChunk) {
        InputStream gZIPInputStream;
        InputStream inputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(payloadChunk.payload);
                try {
                    int ordinal = this.mContentEncoding.ordinal();
                    if (ordinal == 1) {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    } else if (ordinal == 2) {
                        gZIPInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater(true));
                    } else if (ordinal != 3) {
                        if (ordinal == 4) {
                            payloadChunk.payload = ZstdDecoder.decompress(payloadChunk.payload);
                        }
                        if (inputStream != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[MAX_HEADERS_SIZE];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            payloadChunk.payload = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        }
                        byteArrayInputStream.close();
                    } else {
                        gZIPInputStream = new BrotliInputStream(byteArrayInputStream);
                    }
                    inputStream = gZIPInputStream;
                    if (inputStream != null) {
                    }
                    byteArrayInputStream.close();
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                log_d(this.mContentEncoding.name().toLowerCase() + " decoding failed");
            }
        } finally {
            Utils.safeClose(null);
        }
    }

    private boolean isTx() {
        PayloadChunk payloadChunk = this.mFirstChunk;
        if (payloadChunk == null || !payloadChunk.is_sent) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChunk$0(PayloadChunk payloadChunk) {
        if (!WebSocketDecoder.isControlOpcode(payloadChunk.wsOpcode)) {
            this.mListener.onChunkReassembled(payloadChunk);
        }
    }

    private void log_d(String str) {
        String str2;
        StringBuilder sb = new StringBuilder("HTTPReassembly(");
        if (isTx()) {
            str2 = "TX";
        } else {
            str2 = "RX";
        }
        sb.append(str2);
        sb.append(")");
        Log.m587d(sb.toString(), str);
    }

    private PayloadChunk reassembleChunks(ArrayList<PayloadChunk> arrayList) {
        if (arrayList.size() == 1) {
            return arrayList.get(0);
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            PayloadChunk payloadChunk = arrayList.get(i2);
            i2++;
            i += payloadChunk.payload.length;
        }
        byte[] bArr = new byte[i];
        int size2 = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size2) {
            PayloadChunk payloadChunk2 = arrayList.get(i4);
            i4++;
            PayloadChunk payloadChunk3 = payloadChunk2;
            byte[] bArr2 = payloadChunk3.payload;
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += payloadChunk3.payload.length;
        }
        return arrayList.get(0).withPayload(bArr);
    }

    private void reset() {
        this.mReadingHeaders = true;
        this.mContentEncoding = ContentEncoding.UNKNOWN;
        this.mChunkedEncoding = false;
        this.mContentLength = -1;
        this.mFirstChunk = null;
        this.mHeadersSize = 0;
        this.mHeaders.clear();
        this.mBody.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x02e8, code lost:
        if (r12.mContentLength == 0) goto L224;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:248:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleChunk(PayloadChunk payloadChunk) {
        int i;
        boolean z;
        int i2;
        PayloadChunk payloadChunk2;
        String str;
        int i3;
        boolean z2;
        int indexOf;
        int i4;
        if (!this.mSwitchingProtocols) {
            byte[] bArr = payloadChunk.payload;
            PayloadChunk payloadChunk3 = null;
            if (this.mFirstChunk == null) {
                this.mFirstChunk = payloadChunk.withPayload(null);
            }
            boolean z3 = true;
            if (this.mReadingHeaders) {
                i = Utils.getEndOfHTTPHeaders(bArr);
                if (i == 0) {
                    i3 = bArr.length;
                } else {
                    i3 = i;
                }
                int i5 = this.mHeadersSize;
                if (i5 == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.mHeadersSize = i5 + i3;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, i3)));
                    String readLine = bufferedReader.readLine();
                    if (z2 && readLine != null) {
                        if (payloadChunk.is_sent) {
                            int indexOf2 = readLine.indexOf(32);
                            int i6 = indexOf2 + 1;
                            int indexOf3 = readLine.indexOf(32, i6);
                            if (indexOf2 > 0 && indexOf3 > 0) {
                                this.mFirstChunk.httpMethod = readLine.substring(0, indexOf2).toUpperCase();
                                this.mFirstChunk.httpVersion = readLine.substring(indexOf3 + 1);
                                String substring = readLine.substring(i6, indexOf3);
                                if (!substring.startsWith("/")) {
                                    int indexOf4 = substring.indexOf("://");
                                    if (indexOf4 > 0) {
                                        substring = substring.substring(indexOf4 + 3);
                                    }
                                    int indexOf5 = substring.indexOf(47);
                                    if (indexOf5 > 0) {
                                        this.mFirstChunk.httpHost = substring.substring(0, indexOf5);
                                        substring = substring.substring(indexOf5);
                                    }
                                }
                                int indexOf6 = substring.indexOf(63);
                                if (indexOf6 >= 0) {
                                    this.mFirstChunk.httpQuery = substring.substring(indexOf6);
                                    substring = substring.substring(0, indexOf6);
                                }
                                this.mFirstChunk.httpPath = substring;
                            }
                        } else if (readLine.startsWith("HTTP/") && (indexOf = readLine.indexOf(32)) > 0) {
                            this.mFirstChunk.httpVersion = readLine.substring(0, indexOf);
                            int i7 = indexOf + 1;
                            try {
                                int indexOf7 = readLine.indexOf(32, i7);
                                PayloadChunk payloadChunk4 = this.mFirstChunk;
                                if (indexOf7 > 0) {
                                    i4 = indexOf7;
                                } else {
                                    i4 = readLine.length();
                                }
                                payloadChunk4.httpResponseCode = Integer.parseInt(readLine.substring(i7, i4));
                                if (indexOf7 > 0) {
                                    this.mFirstChunk.httpResponseStatus = readLine.substring(indexOf7 + 1);
                                }
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                    while (readLine != null && !readLine.isEmpty()) {
                        String lowerCase = readLine.toLowerCase();
                        if (lowerCase.startsWith("content-encoding: ")) {
                            String substring2 = lowerCase.substring(18);
                            log_d("Content-Encoding: " + substring2);
                            int hashCode = substring2.hashCode();
                            if (hashCode != 3152) {
                                if (hashCode != 3189082) {
                                    if (hashCode != 3748713) {
                                        if (hashCode == 1545112619 && substring2.equals("deflate")) {
                                            this.mContentEncoding = ContentEncoding.DEFLATE;
                                        }
                                    } else if (substring2.equals("zstd")) {
                                        this.mContentEncoding = ContentEncoding.ZSTD;
                                    }
                                } else if (substring2.equals("gzip")) {
                                    this.mContentEncoding = ContentEncoding.GZIP;
                                }
                            } else if (substring2.equals("br")) {
                                this.mContentEncoding = ContentEncoding.BROTLI;
                            }
                        } else if (lowerCase.startsWith("content-type: ")) {
                            int indexOf8 = lowerCase.indexOf(";");
                            PayloadChunk payloadChunk5 = this.mFirstChunk;
                            if (indexOf8 <= 0) {
                                indexOf8 = lowerCase.length();
                            }
                            payloadChunk5.httpContentType = lowerCase.substring(14, indexOf8);
                            log_d("Content-Type: " + this.mFirstChunk.httpContentType);
                        } else if (lowerCase.startsWith("content-length: ")) {
                            try {
                                this.mContentLength = Integer.parseInt(lowerCase.substring(16));
                                log_d("Content-Length: " + this.mContentLength);
                            } catch (NumberFormatException unused2) {
                            }
                        } else if (lowerCase.startsWith("upgrade: ")) {
                            log_d("Upgrade found, stop parsing");
                            this.mSwitchingProtocols = true;
                            this.mReassembleChunks = false;
                            if (lowerCase.startsWith("upgrade: websocket")) {
                                log_d("websocket upgrade");
                                this.mWebsocketUpgrade = true;
                            }
                        } else if (lowerCase.equals("transfer-encoding: chunked")) {
                            log_d("Detected chunked encoding");
                            this.mChunkedEncoding = true;
                        } else if (lowerCase.startsWith("host: ")) {
                            log_d("Detected HTTP host");
                            this.mFirstChunk.httpHost = lowerCase.substring(6);
                        }
                        readLine = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                if (i > 0) {
                    this.mReadingHeaders = false;
                    if (this.mDumpPayload) {
                        this.mHeaders.add(payloadChunk.subchunk(0, i));
                    }
                } else {
                    if (this.mHeadersSize > MAX_HEADERS_SIZE) {
                        log_d("Assuming not HTTP");
                        this.mReadingHeaders = false;
                        this.mReassembleChunks = false;
                        this.mInvalidHttp = true;
                    }
                    if (this.mDumpPayload) {
                        this.mHeaders.add(payloadChunk);
                    }
                    i = bArr.length;
                }
            } else {
                i = 0;
            }
            if (!this.mReassembleChunks) {
                this.mReadingHeaders = false;
            }
            if (!this.mReadingHeaders || !payloadChunk.isHttp2Rst()) {
                z = false;
            } else {
                this.mReadingHeaders = false;
                z = true;
            }
            if (!this.mReadingHeaders) {
                int length = bArr.length - i;
                if (this.mChunkedEncoding && this.mContentLength < 0 && length > 0) {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i, length)));
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 != null) {
                            try {
                                this.mContentLength = Integer.parseInt(readLine2, 16);
                                i += readLine2.length() + 2;
                                length -= readLine2.length() + 2;
                                log_d("Chunk length: " + this.mContentLength);
                            } catch (NumberFormatException unused4) {
                            }
                        }
                        z3 = false;
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused5) {
                        }
                    } catch (IOException unused6) {
                    }
                    i2 = -1;
                    if (length > 0) {
                        int i8 = this.mContentLength;
                        if (i8 > 0) {
                            if (length < i8) {
                                this.mContentLength = i8 - length;
                            } else {
                                int i9 = i + i8;
                                this.mContentLength = -1;
                                if (this.mChunkedEncoding) {
                                    i2 = i9 + 2;
                                } else {
                                    i2 = i9;
                                }
                                length = i8;
                            }
                        }
                        if (this.mDumpPayload) {
                            if (i == 0 && length == payloadChunk.payload.length) {
                                this.mBody.add(payloadChunk);
                            } else {
                                this.mBody.add(payloadChunk.subchunk(i, length));
                            }
                        }
                        this.mBodySize += length;
                    }
                    if (!z3 || !this.mReassembleChunks) {
                        this.mChunkedEncoding = false;
                    }
                    if ((this.mContentLength > 0 || !this.mReassembleChunks) && !this.mChunkedEncoding) {
                        if (!this.mDumpPayload) {
                            payloadChunk2 = reassembleChunks(this.mHeaders);
                            if (!this.mBody.isEmpty()) {
                                payloadChunk3 = reassembleChunks(this.mBody);
                            }
                            if (!(payloadChunk3 == null || this.mContentEncoding == ContentEncoding.UNKNOWN)) {
                                decodeBody(payloadChunk3);
                            }
                            if (payloadChunk3 != null) {
                                byte[] bArr2 = payloadChunk2.payload;
                                byte[] bArr3 = new byte[bArr2.length + payloadChunk3.payload.length];
                                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                                byte[] bArr4 = payloadChunk3.payload;
                                System.arraycopy(bArr4, 0, bArr3, payloadChunk2.payload.length, bArr4.length);
                                payloadChunk2 = payloadChunk3.withPayload(bArr3);
                            }
                        } else {
                            payloadChunk2 = this.mFirstChunk;
                        }
                        if (!this.mInvalidHttp) {
                            payloadChunk2.type = PayloadChunk.ChunkType.RAW;
                        } else {
                            PayloadChunk payloadChunk6 = this.mFirstChunk;
                            payloadChunk2.httpContentType = payloadChunk6.httpContentType;
                            payloadChunk2.httpResponseCode = payloadChunk6.httpResponseCode;
                            payloadChunk2.httpResponseStatus = payloadChunk6.httpResponseStatus;
                            payloadChunk2.httpMethod = payloadChunk6.httpMethod;
                            payloadChunk2.httpHost = payloadChunk6.httpHost;
                            payloadChunk2.httpPath = payloadChunk6.httpPath;
                            payloadChunk2.httpQuery = payloadChunk6.httpQuery;
                            payloadChunk2.httpVersion = payloadChunk6.httpVersion;
                            payloadChunk2.httpBodyLength = this.mBodySize;
                            if (z) {
                                payloadChunk2.setHttpRst();
                            }
                        }
                        this.mBodySize = 0;
                        if (payloadChunk2.type == PayloadChunk.ChunkType.HTTP) {
                            StringBuilder sb = new StringBuilder("Reassembled HTTP ");
                            if (payloadChunk2.isHttp2Rst()) {
                                str = "RST";
                            } else if (payloadChunk2.is_sent) {
                                str = "request";
                            } else {
                                str = "response";
                            }
                            sb.append(str);
                            Log.m587d(TAG, sb.toString());
                        }
                        this.mListener.onChunkReassembled(payloadChunk2);
                        reset();
                    }
                    if (i2 <= 0) {
                        byte[] bArr5 = payloadChunk.payload;
                        if (bArr5.length > i2) {
                            handleChunk(payloadChunk.subchunk(i2, bArr5.length - i2));
                            return;
                        }
                        return;
                    }
                    return;
                }
                z3 = false;
                i2 = -1;
                if (length > 0) {
                }
                if (!z3) {
                }
                this.mChunkedEncoding = false;
                if (this.mContentLength > 0) {
                }
                if (!this.mDumpPayload) {
                }
                if (!this.mInvalidHttp) {
                }
                this.mBodySize = 0;
                if (payloadChunk2.type == PayloadChunk.ChunkType.HTTP) {
                }
                this.mListener.onChunkReassembled(payloadChunk2);
                reset();
                if (i2 <= 0) {
                }
            }
        } else if (this.mWebsocketUpgrade) {
            payloadChunk.type = PayloadChunk.ChunkType.WEBSOCKET;
            if (this.mDumpPayload) {
                if (this.mWebSocketDecoder == null) {
                    this.mWebSocketDecoder = new WebSocketDecoder(new PlayBilling$$ExternalSyntheticLambda4(2, this));
                }
                this.mWebSocketDecoder.handleChunk(payloadChunk);
            }
        }
    }

    public HTTPReassembly(boolean z, ReassemblyListener reassemblyListener) {
        this(z, reassemblyListener, true);
    }
}
