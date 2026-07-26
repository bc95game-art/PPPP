package com.emanuelef.remote_capture.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PayloadChunk implements Serializable {
    public boolean is_sent;
    public byte[] payload;
    public int stream_id;
    public long timestamp;
    public ChunkType type;
    public int httpResponseCode = 0;
    public String httpResponseStatus = "";
    public String httpMethod = "";
    public String httpHost = "";
    public String httpPath = "";
    public String httpQuery = "";
    public String httpContentType = "";
    public String httpVersion = "";
    public int httpBodyLength = 0;
    private boolean mHttpRst = false;
    public int wsOpcode = -1;
    public boolean wsIsFinal = true;
    public boolean wsWasFragmented = false;

    /* loaded from: classes.dex */
    public enum ChunkType implements Serializable {
        RAW,
        HTTP,
        WEBSOCKET
    }

    public PayloadChunk(byte[] bArr, ChunkType chunkType, boolean z, long j, int i) {
        this.payload = bArr;
        this.type = chunkType;
        this.is_sent = z;
        this.timestamp = j;
        this.stream_id = i;
    }

    public boolean isHttp2Rst() {
        byte[] bArr;
        if (this.mHttpRst) {
            return true;
        }
        if (this.type == ChunkType.HTTP && (bArr = this.payload) != null && bArr.length == 0) {
            return true;
        }
        return false;
    }

    public void setHttpRst() {
        this.mHttpRst = true;
    }

    public PayloadChunk subchunk(int i, int i2) {
        byte[] bArr = this.payload;
        if (bArr == null) {
            return this;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new PayloadChunk(bArr2, this.type, this.is_sent, this.timestamp, this.stream_id);
    }

    public PayloadChunk withPayload(byte[] bArr) {
        return new PayloadChunk(bArr, this.type, this.is_sent, this.timestamp, this.stream_id);
    }
}
