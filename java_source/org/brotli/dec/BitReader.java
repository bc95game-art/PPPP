package org.brotli.dec;

import java.io.ByteArrayInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class BitReader {
    public long accumulator;
    public int bitOffset;
    public boolean endOfStreamReached;
    public ByteArrayInputStream input;
    public int intOffset;
    public final byte[] byteBuffer = new byte[4160];
    public final int[] intBuffer = new int[1040];
    public final IntReader intReader = new Object();
    public int tailBytes = 0;

    public static void checkHealth(BitReader bitReader, boolean z) {
        if (bitReader.endOfStreamReached) {
            int i = ((bitReader.intOffset << 2) + ((bitReader.bitOffset + 7) >> 3)) - 8;
            int i2 = bitReader.tailBytes;
            if (i > i2) {
                throw new RuntimeException("Read after end");
            } else if (z && i != i2) {
                throw new RuntimeException("Unused bytes after end");
            }
        }
    }

    public static void fillBitWindow(BitReader bitReader) {
        int i = bitReader.bitOffset;
        if (i >= 32) {
            int[] iArr = bitReader.intBuffer;
            int i2 = bitReader.intOffset;
            bitReader.intOffset = i2 + 1;
            bitReader.accumulator = (iArr[i2] << 32) | (bitReader.accumulator >>> 32);
            bitReader.bitOffset = i - 32;
        }
    }

    public static int intAvailable(BitReader bitReader) {
        int i;
        if (bitReader.endOfStreamReached) {
            i = (bitReader.tailBytes + 3) >> 2;
        } else {
            i = 1024;
        }
        return i - bitReader.intOffset;
    }

    public static int readBits(BitReader bitReader, int i) {
        fillBitWindow(bitReader);
        long j = bitReader.accumulator;
        int i2 = bitReader.bitOffset;
        int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
        bitReader.bitOffset = i2 + i;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r7.endOfStreamReached = true;
        r7.tailBytes = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = r2 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readMoreInput(BitReader bitReader) {
        int i = bitReader.intOffset;
        byte[] bArr = bitReader.byteBuffer;
        if (i > 1015) {
            if (!bitReader.endOfStreamReached) {
                int i2 = i << 2;
                int i3 = 4096 - i2;
                System.arraycopy(bArr, i2, bArr, 0, i3);
                bitReader.intOffset = 0;
                while (true) {
                    if (i3 >= 4096) {
                        break;
                    }
                    try {
                        int read = bitReader.input.read(bArr, i3, 4096 - i3);
                        if (read <= 0) {
                            break;
                        }
                        i3 += read;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to read input", e);
                    }
                }
                IntReader intReader = bitReader.intReader;
                int i4 = i3 >> 2;
                for (int i5 = 0; i5 < i4; i5++) {
                    byte[] bArr2 = (byte[]) intReader.byteBuffer;
                    int i6 = i5 * 4;
                    ((int[]) intReader.intBuffer)[i5] = ((bArr2[i6 + 3] & 255) << 24) | (bArr2[i6] & 255) | ((bArr2[i6 + 1] & 255) << 8) | ((bArr2[i6 + 2] & 255) << 16);
                }
            } else if (intAvailable(bitReader) < -2) {
                throw new RuntimeException("No more input");
            }
        }
    }
}
