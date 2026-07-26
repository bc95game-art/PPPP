package org.brotli.dec;

import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public final class State {
    public int bytesToWrite;
    public int bytesWritten;
    public int contextLookupOffset1;
    public int contextLookupOffset2;
    public byte[] contextMap;
    public int contextMapSlice;
    public byte[] contextModes;
    public int copyDst;
    public int copyLength;
    public byte[] distContextMap;
    public int distContextMapSlice;
    public int distance;
    public int distanceCode;
    public int distancePostfixBits;
    public int distancePostfixMask;
    public boolean inputEnd;
    public int insertLength;
    public boolean isMetadata;
    public boolean isUncompressed;

    /* renamed from: j */
    public int f889j;
    public int literalTree;
    public int maxBackwardDistance;
    public int maxRingBufferSize;
    public int metaBlockLength;
    public int nextRunningState;
    public int numDirectDistanceCodes;
    public byte[] output;
    public int outputLength;
    public int outputOffset;
    public int outputUsed;
    public byte[] ringBuffer;
    public int treeCommandOffset;
    public int runningState = 0;

    /* renamed from: br */
    public final BitReader f888br = new BitReader();
    public final int[] blockTypeTrees = new int[3240];
    public final int[] blockLenTrees = new int[3240];
    public final HuffmanTreeGroup hGroup0 = new Object();
    public final HuffmanTreeGroup hGroup1 = new Object();
    public final HuffmanTreeGroup hGroup2 = new Object();
    public final int[] blockLength = new int[3];
    public final int[] numBlockTypes = new int[3];
    public final int[] blockTypeRb = new int[6];
    public final int[] distRb = {16, 15, 11, 4};
    public int pos = 0;
    public int maxDistance = 0;
    public int distRbIdx = 0;
    public boolean trivialLiteralContext = false;
    public int ringBufferSize = 0;
    public long expectedTotalSize = 0;
    public final byte[] customDictionary = new byte[0];
    public int bytesToIgnore = 0;

    public static void setInput(State state, ByteArrayInputStream byteArrayInputStream) {
        int i;
        int i2 = state.runningState;
        BitReader bitReader = state.f888br;
        if (i2 != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        } else if (bitReader.input == null) {
            IntReader intReader = bitReader.intReader;
            byte[] bArr = bitReader.byteBuffer;
            int[] iArr = bitReader.intBuffer;
            intReader.byteBuffer = bArr;
            intReader.intBuffer = iArr;
            bitReader.input = byteArrayInputStream;
            bitReader.accumulator = 0L;
            bitReader.bitOffset = 64;
            bitReader.intOffset = 1024;
            bitReader.endOfStreamReached = false;
            BitReader.readMoreInput(bitReader);
            BitReader.checkHealth(bitReader, false);
            BitReader.fillBitWindow(bitReader);
            BitReader.fillBitWindow(bitReader);
            if (BitReader.readBits(bitReader, 1) == 0) {
                i = 16;
            } else {
                int readBits = BitReader.readBits(bitReader, 3);
                i = 17;
                if (readBits != 0) {
                    i = 17 + readBits;
                } else {
                    int readBits2 = BitReader.readBits(bitReader, 3);
                    if (readBits2 != 0) {
                        i = readBits2 + 8;
                    }
                }
            }
            if (i != 9) {
                int i3 = 1 << i;
                state.maxRingBufferSize = i3;
                state.maxBackwardDistance = i3 - 16;
                state.runningState = 1;
                return;
            }
            throw new RuntimeException("Invalid 'windowBits' code");
        } else {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }
}
