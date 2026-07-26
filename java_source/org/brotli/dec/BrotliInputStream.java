package org.brotli.dec;

import androidx.lifecycle.ViewModelProvider;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class BrotliInputStream extends InputStream {
    public final State state;
    public final byte[] buffer = new byte[16384];
    public int remainingBufferBytes = 0;
    public int bufferOffset = 0;

    public BrotliInputStream(ByteArrayInputStream byteArrayInputStream) {
        State state = new State();
        this.state = state;
        try {
            State.setInput(state, byteArrayInputStream);
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        State state = this.state;
        int i = state.runningState;
        if (i == 0) {
            throw new IllegalStateException("State MUST be initialized");
        } else if (i != 11) {
            state.runningState = 11;
            BitReader bitReader = state.f888br;
            ByteArrayInputStream byteArrayInputStream = bitReader.input;
            bitReader.input = null;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        int i = this.bufferOffset;
        int i2 = this.remainingBufferBytes;
        byte[] bArr = this.buffer;
        if (i >= i2) {
            int read = read(bArr, 0, bArr.length);
            this.remainingBufferBytes = read;
            this.bufferOffset = 0;
            if (read == -1) {
                return -1;
            }
        }
        int i3 = this.bufferOffset;
        this.bufferOffset = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        State state = this.state;
        if (i < 0) {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "Bad offset: "));
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                StringBuilder m = ViewModelProvider.Factory.CC.m598m("Buffer overflow: ", i3, " > ");
                m.append(bArr.length);
                throw new IllegalArgumentException(m.toString());
            } else if (i2 == 0) {
                return 0;
            } else {
                int max = Math.max(this.remainingBufferBytes - this.bufferOffset, 0);
                if (max != 0) {
                    max = Math.min(max, i2);
                    System.arraycopy(this.buffer, this.bufferOffset, bArr, i, max);
                    this.bufferOffset += max;
                    i += max;
                    i2 -= max;
                    if (i2 == 0) {
                        return max;
                    }
                }
                try {
                    state.output = bArr;
                    state.outputOffset = i;
                    state.outputLength = i2;
                    state.outputUsed = 0;
                    Utils.decompress(state);
                    int i4 = state.outputUsed;
                    if (i4 == 0) {
                        return -1;
                    }
                    return i4 + max;
                } catch (BrotliRuntimeException e) {
                    throw new IOException("Brotli stream decoding failed", e);
                }
            }
        } else {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i2, "Bad length: "));
        }
    }
}
