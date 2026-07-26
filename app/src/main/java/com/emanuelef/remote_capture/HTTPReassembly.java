package com.emanuelef.remote_capture;

import com.emanuelef.remote_capture.model.PayloadChunk;
import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    private void decodeBody(com.emanuelef.remote_capture.model.PayloadChunk r7) {
        /*
            r6 = this;
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
            byte[] r2 = r7.payload     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
            com.emanuelef.remote_capture.HTTPReassembly$ContentEncoding r2 = r6.mContentEncoding     // Catch: java.lang.Throwable -> L24
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L24
            r3 = 1
            if (r2 == r3) goto L38
            r4 = 2
            if (r2 == r4) goto L2d
            r3 = 3
            if (r2 == r3) goto L26
            r3 = 4
            if (r2 == r3) goto L1b
            goto L3e
        L1b:
            byte[] r2 = r7.payload     // Catch: java.lang.Throwable -> L24
            byte[] r2 = com.emanuelef.remote_capture.ZstdDecoder.decompress(r2)     // Catch: java.lang.Throwable -> L24
            r7.payload = r2     // Catch: java.lang.Throwable -> L24
            goto L3e
        L24:
            r7 = move-exception
            goto L73
        L26:
            org.brotli.dec.BrotliInputStream r2 = new org.brotli.dec.BrotliInputStream     // Catch: java.lang.Throwable -> L24
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L24
        L2b:
            r0 = r2
            goto L3e
        L2d:
            java.util.zip.InflaterInputStream r2 = new java.util.zip.InflaterInputStream     // Catch: java.lang.Throwable -> L24
            java.util.zip.Inflater r4 = new java.util.zip.Inflater     // Catch: java.lang.Throwable -> L24
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L24
            r2.<init>(r1, r4)     // Catch: java.lang.Throwable -> L24
            goto L2b
        L38:
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L24
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L24
            goto L2b
        L3e:
            if (r0 == 0) goto L6a
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L55
        L49:
            int r4 = r0.read(r3)     // Catch: java.lang.Throwable -> L55
            r5 = -1
            if (r4 == r5) goto L57
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L55
            goto L49
        L55:
            r7 = move-exception
            goto L61
        L57:
            byte[] r3 = r2.toByteArray()     // Catch: java.lang.Throwable -> L55
            r7.payload = r3     // Catch: java.lang.Throwable -> L55
            r2.close()     // Catch: java.lang.Throwable -> L24
            goto L6a
        L61:
            r2.close()     // Catch: java.lang.Throwable -> L65
            goto L69
        L65:
            r2 = move-exception
            r7.addSuppressed(r2)     // Catch: java.lang.Throwable -> L24
        L69:
            throw r7     // Catch: java.lang.Throwable -> L24
        L6a:
            r1.close()     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
            com.emanuelef.remote_capture.Utils.safeClose(r0)
            return
        L71:
            r7 = move-exception
            goto L9e
        L73:
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r1 = move-exception
            r7.addSuppressed(r1)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
        L7b:
            throw r7     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L7c
        L7c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r7.<init>()     // Catch: java.lang.Throwable -> L71
            com.emanuelef.remote_capture.HTTPReassembly$ContentEncoding r1 = r6.mContentEncoding     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.name()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Throwable -> L71
            r7.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = " decoding failed"
            r7.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L71
            r6.log_d(r7)     // Catch: java.lang.Throwable -> L71
            com.emanuelef.remote_capture.Utils.safeClose(r0)
            return
        L9e:
            com.emanuelef.remote_capture.Utils.safeClose(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.HTTPReassembly.decodeBody(com.emanuelef.remote_capture.model.PayloadChunk):void");
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
        Log.d(sb.toString(), str);
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleChunk(com.emanuelef.remote_capture.model.PayloadChunk r13) {
        /*
            Method dump skipped, instructions count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.HTTPReassembly.handleChunk(com.emanuelef.remote_capture.model.PayloadChunk):void");
    }

    public HTTPReassembly(boolean z, ReassemblyListener reassemblyListener) {
        this(z, reassemblyListener, true);
    }
}
