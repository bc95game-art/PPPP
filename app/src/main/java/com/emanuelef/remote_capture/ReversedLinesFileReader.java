package com.emanuelef.remote_capture;

import androidx.lifecycle.ViewModelProvider;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    /* loaded from: classes.dex */
    public class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long no;

        public /* synthetic */ FilePart(ReversedLinesFileReader reversedLinesFileReader, long j, int i) {
            this(j, i, null);
        }

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                byte[] bArr = new byte[i];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            byte[][] bArr2;
            boolean z;
            for (byte[] bArr3 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z2 = true;
                for (int length = bArr3.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr3.length - 1);
                    if (length2 < 0 || bArr[length2] != bArr3[length]) {
                        z = false;
                    } else {
                        z = true;
                    }
                    z2 &= z;
                }
                if (z2) {
                    return bArr3.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() {
            boolean z;
            String str;
            byte[] bArr;
            if (this.no == 1) {
                z = true;
            } else {
                z = false;
            }
            int i = this.currentLastBytePos;
            while (true) {
                if (i > -1) {
                    if (!z && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount <= 0) {
                        i -= ReversedLinesFileReader.this.byteDecrement;
                        if (i < 0) {
                            createLeftOver();
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 >= 0) {
                            byte[] bArr2 = new byte[i3];
                            System.arraycopy(this.data, i2, bArr2, 0, i3);
                            str = new String(bArr2, ReversedLinesFileReader.this.encoding);
                            this.currentLastBytePos = i - newLineMatchByteCount;
                        } else {
                            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(i3, "Unexpected negative line length="));
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z || (bArr = this.leftOver) == null) {
                return str;
            }
            String str2 = new String(bArr, ReversedLinesFileReader.this.encoding);
            this.leftOver = null;
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() {
            if (this.currentLastBytePos <= -1) {
                long j = this.no;
                if (j > 1) {
                    ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                    return new FilePart(j - 1, reversedLinesFileReader.blockSize, this.leftOver);
                } else if (this.leftOver == null) {
                    return null;
                } else {
                    throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=".concat(new String(this.leftOver, ReversedLinesFileReader.this.encoding)));
                }
            } else {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
        }

        private FilePart(long j, int i, byte[] bArr) {
            this.no = j;
            int length = (bArr != null ? bArr.length : 0) + i;
            byte[] bArr2 = new byte[length];
            this.data = bArr2;
            long j2 = (j - 1) * ReversedLinesFileReader.this.blockSize;
            if (j > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j2);
                if (ReversedLinesFileReader.this.randomAccessFile.read(bArr2, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
            }
            this.currentLastBytePos = length - 1;
            this.leftOver = null;
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) {
        this(file, 4096, Charset.defaultCharset());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.randomAccessFile.close();
    }

    public String readLine() {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            FilePart rollOver = this.currentFilePart.rollOver();
            this.currentFilePart = rollOver;
            if (rollOver == null) {
                break;
            }
            readLine = rollOver.readLine();
        }
        if (!"".equals(readLine) || this.trailingNewlineOfFileSkipped) {
            return readLine;
        }
        this.trailingNewlineOfFileSkipped = true;
        return readLine();
    }

    public ReversedLinesFileReader(File file, Charset charset) {
        this(file, 4096, charset);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
        if (r1 > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ReversedLinesFileReader(java.io.File r8, int r9, java.nio.charset.Charset r10) {
        /*
            r7 = this;
            r7.<init>()
            r0 = 0
            r7.trailingNewlineOfFileSkipped = r0
            r7.blockSize = r9
            r7.encoding = r10
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r8, r2)
            r7.randomAccessFile = r1
            long r1 = r1.length()
            r7.totalByteLength = r1
            long r3 = (long) r9
            long r5 = r1 % r3
            int r8 = (int) r5
            if (r8 <= 0) goto L26
            long r1 = r1 / r3
            r3 = 1
            long r1 = r1 + r3
            r7.totalBlockCount = r1
            goto L31
        L26:
            long r3 = r1 / r3
            r7.totalBlockCount = r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L31
            goto L32
        L31:
            r9 = r8
        L32:
            com.emanuelef.remote_capture.ReversedLinesFileReader$FilePart r8 = new com.emanuelef.remote_capture.ReversedLinesFileReader$FilePart
            long r1 = r7.totalBlockCount
            r8.<init>(r7, r1, r9)
            r7.currentFilePart = r8
            java.nio.charset.CharsetEncoder r8 = r10.newEncoder()
            float r8 = r8.maxBytesPerChar()
            r9 = 1065353216(0x3f800000, float:1.0)
            r1 = 2
            r2 = 1
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 != 0) goto L4e
            r7.byteDecrement = r2
            goto L90
        L4e:
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8
            if (r10 != r8) goto L55
            r7.byteDecrement = r2
            goto L90
        L55:
            java.lang.String r8 = "Shift_JIS"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)
            if (r10 != r8) goto L60
            r7.byteDecrement = r2
            goto L90
        L60:
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_16BE
            if (r10 == r8) goto L8e
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_16LE
            if (r10 != r8) goto L69
            goto L8e
        L69:
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_16
            if (r10 != r8) goto L75
            java.io.UnsupportedEncodingException r8 = new java.io.UnsupportedEncodingException
            java.lang.String r9 = "For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)"
            r8.<init>(r9)
            throw r8
        L75:
            java.io.UnsupportedEncodingException r8 = new java.io.UnsupportedEncodingException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Encoding "
            r9.<init>(r0)
            r9.append(r10)
            java.lang.String r10 = " is not supported yet (feel free to submit a patch)"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L8e:
            r7.byteDecrement = r1
        L90:
            java.lang.String r8 = "\r\n"
            byte[] r8 = r8.getBytes(r10)
            java.lang.String r9 = "\n"
            byte[] r9 = r9.getBytes(r10)
            java.lang.String r3 = "\r"
            byte[] r10 = r3.getBytes(r10)
            r3 = 3
            byte[][] r3 = new byte[r3]
            r3[r0] = r8
            r3[r2] = r9
            r3[r1] = r10
            r7.newLineSequences = r3
            r8 = r3[r0]
            int r8 = r8.length
            r7.avoidNewlineSplitBufferSize = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.ReversedLinesFileReader.<init>(java.io.File, int, java.nio.charset.Charset):void");
    }
}
