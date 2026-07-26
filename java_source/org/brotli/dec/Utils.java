package org.brotli.dec;

import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class Utils {
    public static final int[] LOOKUP = {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 12, 16, 12, 12, 20, 12, 16, 24, 28, 12, 12, 32, 12, 36, 12, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 32, 32, 24, 40, 28, 12, 12, 48, 52, 52, 52, 48, 52, 52, 52, 48, 52, 52, 52, 52, 52, 48, 52, 52, 52, 52, 52, 48, 52, 52, 52, 52, 52, 24, 12, 28, 12, 12, 12, 56, 60, 60, 60, 56, 60, 60, 60, 56, 60, 60, 60, 60, 60, 56, 60, 60, 60, 60, 60, 56, 60, 60, 60, 60, 60, 24, 12, 28, 12, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 
    40, 40, 40, 40, 40, 40, 40, 40, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 56, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 31, 32, 32, 32, 32, 33, 33, 33, 33, 34, 34, 34, 34, 35, 35, 35, 35, 36, 36, 36, 36, 37, 37, 37, 37, 38, 38, 38, 38, 39, 39, 39, 39, 40, 40, 40, 40, 41, 41, 41, 41, 42, 42, 42, 42, 43, 43, 43, 43, 44, 44, 44, 44, 45, 45, 45, 45, 46, 46, 46, 46, 47, 47, 47, 47, 48, 48, 48, 48, 49, 49, 49, 49, 50, 50, 50, 50, 51, 51, 51, 51, 52, 52, 52, 52, 53, 53, 53, 53, 54, 54, 54, 54, 55, 55, 55, 55, 56, 56, 56, 56, 57, 57, 57, 57, 58, 58, 58, 58, 59, 59, 59, 59, 60, 60, 60, 60, 61, 61, 61, 61, 62, 62, 62, 62, 63, 63, 63, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int[] LOOKUP_OFFSETS = {1024, 1536, 1280, 1536, 0, 256, 768, LogviewFragment.MAX_LINES};
    public static final int[] CODE_LENGTH_CODE_ORDER = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    public static final int[] DISTANCE_SHORT_CODE_INDEX_OFFSET = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
    public static final int[] DISTANCE_SHORT_CODE_VALUE_OFFSET = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
    public static final int[] FIXED_TABLE = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    public static final int[] OFFSETS_BY_LENGTH = {0, 0, 0, 0, 0, 4096, 9216, 21504, 35840, 44032, 53248, 63488, 74752, 87040, 93696, 100864, 104704, 106752, 108928, 113536, 115968, 118528, 119872, 121280, 122016};
    public static final int[] SIZE_BITS_BY_LENGTH = {0, 0, 0, 0, 10, 10, 11, 11, 10, 10, 10, 10, 10, 9, 9, 8, 7, 7, 8, 7, 7, 6, 6, 5, 5};
    public static final int[] BLOCK_LENGTH_OFFSET = {1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, 177, 209, 241, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};
    public static final int[] BLOCK_LENGTH_N_BITS = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
    public static final int[] INSERT_LENGTH_OFFSET = {0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594};
    public static final int[] INSERT_LENGTH_N_BITS = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
    public static final int[] COPY_LENGTH_OFFSET = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, 198, 326, 582, 1094, 2118};
    public static final int[] COPY_LENGTH_N_BITS = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
    public static final int[] INSERT_RANGE_LUT = {0, 0, 8, 8, 0, 16, 8, 16, 16};
    public static final int[] COPY_RANGE_LUT = {0, 8, 0, 8, 16, 0, 16, 8, 16};
    public static final byte[] BYTE_ZEROES = new byte[1024];
    public static final int[] INT_ZEROES = new int[1024];

    public static void buildHuffmanTable(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = iArr2[i8];
            iArr4[i9] = iArr4[i9] + 1;
        }
        iArr5[1] = 0;
        int i10 = 1;
        while (i10 < 15) {
            int i11 = i10 + 1;
            iArr5[i11] = iArr5[i10] + iArr4[i10];
            i10 = i11;
        }
        for (int i12 = 0; i12 < i3; i12++) {
            int i13 = iArr2[i12];
            if (i13 != 0) {
                int i14 = iArr5[i13];
                iArr5[i13] = i14 + 1;
                iArr3[i14] = i12;
            }
        }
        int i15 = 1 << i2;
        if (iArr5[15] == 1) {
            for (int i16 = 0; i16 < i15; i16++) {
                iArr[i + i16] = iArr3[0];
            }
            return;
        }
        int i17 = 2;
        int i18 = 0;
        int i19 = 1;
        int i20 = 2;
        while (i19 <= i2) {
            while (iArr4[i19] > 0) {
                int i21 = i + i7;
                int i22 = i18 + 1;
                int i23 = (i19 << 16) | iArr3[i18];
                int i24 = i15;
                do {
                    i24 -= i20;
                    iArr[i21 + i24] = i23;
                } while (i24 > 0);
                int i25 = 1 << (i19 - 1);
                while ((i7 & i25) != 0) {
                    i25 >>= 1;
                }
                i7 = (i7 & (i25 - 1)) + i25;
                iArr4[i19] = iArr4[i19] - 1;
                i18 = i22;
            }
            i19++;
            i20 <<= 1;
        }
        int i26 = i15 - 1;
        int i27 = i2 + 1;
        int i28 = -1;
        int i29 = i;
        while (i27 <= 15) {
            while (iArr4[i27] > 0) {
                int i30 = i7 & i26;
                if (i30 != i28) {
                    int i31 = i29 + i15;
                    int i32 = 1 << (i27 - i2);
                    int i33 = i27;
                    while (i33 < 15) {
                        int i34 = i32 - iArr4[i33];
                        if (i34 <= 0) {
                            break;
                        }
                        i33++;
                        i32 = i34 << 1;
                    }
                    int i35 = i33 - i2;
                    iArr[i + i30] = ((i35 + i2) << 16) | ((i31 - i) - i30);
                    i4 = i30;
                    i5 = i31;
                    i6 = 1 << i35;
                } else {
                    i4 = i28;
                    i6 = i15;
                    i5 = i29;
                }
                int i36 = i5 + (i7 >> i2);
                int i37 = i18 + 1;
                int i38 = ((i27 - i2) << 16) | iArr3[i18];
                int i39 = i6;
                do {
                    i39 -= i17;
                    iArr[i36 + i39] = i38;
                } while (i39 > 0);
                int i40 = 1 << (i27 - 1);
                while ((i7 & i40) != 0) {
                    i40 >>= 1;
                }
                i7 = (i7 & (i40 - 1)) + i40;
                iArr4[i27] = iArr4[i27] - 1;
                i15 = i6;
                i29 = i5;
                i28 = i4;
                i18 = i37;
            }
            i27++;
            i17 <<= 1;
        }
    }

    public static void decodeBlockTypeAndLength(State state, int i) {
        int i2;
        BitReader bitReader = state.f888br;
        int[] iArr = state.blockTypeRb;
        int i3 = i * 2;
        BitReader.fillBitWindow(bitReader);
        int i4 = i * 1080;
        int readSymbol = readSymbol(state.blockTypeTrees, i4, bitReader);
        int[] iArr2 = state.blockLength;
        int[] iArr3 = state.blockLenTrees;
        BitReader.fillBitWindow(bitReader);
        int readSymbol2 = readSymbol(iArr3, i4, bitReader);
        iArr2[i] = BitReader.readBits(bitReader, BLOCK_LENGTH_N_BITS[readSymbol2]) + BLOCK_LENGTH_OFFSET[readSymbol2];
        if (readSymbol == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (readSymbol == 0) {
            i2 = iArr[i3];
        } else {
            i2 = readSymbol - 2;
        }
        int i5 = state.numBlockTypes[i];
        if (i2 >= i5) {
            i2 -= i5;
        }
        int i6 = i3 + 1;
        iArr[i3] = iArr[i6];
        iArr[i6] = i2;
    }

    public static int decodeContextMap(int i, byte[] bArr, BitReader bitReader) {
        int i2;
        int i3;
        BitReader.readMoreInput(bitReader);
        if (BitReader.readBits(bitReader, 1) != 0) {
            int readBits = BitReader.readBits(bitReader, 3);
            if (readBits == 0) {
                i2 = 1;
            } else {
                i2 = BitReader.readBits(bitReader, readBits) + (1 << readBits);
            }
        } else {
            i2 = 0;
        }
        int i4 = i2 + 1;
        if (i4 == 1) {
            int i5 = 0;
            while (i5 < i) {
                int min = Math.min(i5 + 1024, i) - i5;
                System.arraycopy(BYTE_ZEROES, 0, bArr, i5, min);
                i5 += min;
            }
        } else {
            if (BitReader.readBits(bitReader, 1) == 1) {
                i3 = BitReader.readBits(bitReader, 4) + 1;
            } else {
                i3 = 0;
            }
            int[] iArr = new int[1080];
            readHuffmanCode(i4 + i3, iArr, 0, bitReader);
            int i6 = 0;
            while (i6 < i) {
                BitReader.readMoreInput(bitReader);
                BitReader.fillBitWindow(bitReader);
                int readSymbol = readSymbol(iArr, 0, bitReader);
                if (readSymbol == 0) {
                    bArr[i6] = 0;
                } else if (readSymbol <= i3) {
                    for (int readBits2 = BitReader.readBits(bitReader, readSymbol) + (1 << readSymbol); readBits2 != 0; readBits2--) {
                        if (i6 < i) {
                            bArr[i6] = 0;
                            i6++;
                        } else {
                            throw new RuntimeException("Corrupted context map");
                        }
                    }
                    continue;
                } else {
                    bArr[i6] = (byte) (readSymbol - i3);
                }
                i6++;
            }
            if (BitReader.readBits(bitReader, 1) == 1) {
                int[] iArr2 = new int[256];
                for (int i7 = 0; i7 < 256; i7++) {
                    iArr2[i7] = i7;
                }
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = bArr[i8] & 255;
                    int i10 = iArr2[i9];
                    bArr[i8] = (byte) i10;
                    if (i9 != 0) {
                        while (i9 > 0) {
                            iArr2[i9] = iArr2[i9 - 1];
                            i9--;
                        }
                        iArr2[0] = i10;
                    }
                }
            }
        }
        return i4;
    }

    public static void decodeLiteralBlockSwitch(State state) {
        decodeBlockTypeAndLength(state, 0);
        int i = state.blockTypeRb[1];
        int i2 = i << 6;
        state.contextMapSlice = i2;
        state.literalTree = ((int[]) state.hGroup0.trees)[state.contextMap[i2] & 255];
        byte b = state.contextModes[i];
        int[] iArr = LOOKUP_OFFSETS;
        state.contextLookupOffset1 = iArr[b];
        state.contextLookupOffset2 = iArr[b + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0153, code lost:
        throw new java.lang.RuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0442 A[LOOP:13: B:164:0x0442->B:173:0x048b, LOOP_START, PHI: r11 
      PHI: (r11v45 char) = (r11v19 char), (r11v47 char) binds: [B:163:0x0440, B:173:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0613 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void decompress(State state) {
        byte[] bArr;
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        char c;
        int i9;
        int i10;
        int i11;
        int i12;
        char c2;
        int i13;
        int i14;
        int i15;
        int i16 = state.runningState;
        int[] iArr = state.blockTypeRb;
        HuffmanTreeGroup huffmanTreeGroup = state.hGroup2;
        HuffmanTreeGroup huffmanTreeGroup2 = state.hGroup0;
        HuffmanTreeGroup huffmanTreeGroup3 = state.hGroup1;
        BitReader bitReader = state.f888br;
        int[] iArr2 = state.blockLength;
        if (i16 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        } else if (i16 != 11) {
            int i17 = state.ringBufferSize - 1;
            byte[] bArr2 = state.ringBuffer;
            while (true) {
                int i18 = state.runningState;
                if (i18 != 10) {
                    if (i18 != 12) {
                        switch (i18) {
                            case 1:
                                if (state.metaBlockLength >= 0) {
                                    if (state.inputEnd) {
                                        state.nextRunningState = 10;
                                        state.bytesToWrite = state.pos;
                                        state.bytesWritten = 0;
                                        state.runningState = 12;
                                    } else {
                                        huffmanTreeGroup2.codes = null;
                                        huffmanTreeGroup2.trees = null;
                                        huffmanTreeGroup3.codes = null;
                                        huffmanTreeGroup3.trees = null;
                                        huffmanTreeGroup.codes = null;
                                        huffmanTreeGroup.trees = null;
                                        BitReader.readMoreInput(bitReader);
                                        if (BitReader.readBits(bitReader, 1) == 1) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        state.inputEnd = z;
                                        state.metaBlockLength = 0;
                                        state.isUncompressed = false;
                                        state.isMetadata = false;
                                        if (!z || BitReader.readBits(bitReader, 1) == 0) {
                                            int readBits = BitReader.readBits(bitReader, 2) + 4;
                                            if (readBits == 7) {
                                                state.isMetadata = true;
                                                if (BitReader.readBits(bitReader, 1) == 0) {
                                                    int readBits2 = BitReader.readBits(bitReader, 2);
                                                    if (readBits2 != 0) {
                                                        for (int i19 = 0; i19 < readBits2; i19++) {
                                                            int readBits3 = BitReader.readBits(bitReader, 8);
                                                            if (readBits3 == 0 && i19 + 1 == readBits2 && readBits2 > 1) {
                                                                throw new RuntimeException("Exuberant nibble");
                                                            }
                                                            state.metaBlockLength = (readBits3 << (i19 * 8)) | state.metaBlockLength;
                                                        }
                                                    }
                                                } else {
                                                    throw new RuntimeException("Corrupted reserved bit");
                                                }
                                            } else {
                                                for (int i20 = 0; i20 < readBits; i20++) {
                                                    int readBits4 = BitReader.readBits(bitReader, 4);
                                                    if (readBits4 == 0 && i20 + 1 == readBits && readBits > 4) {
                                                        throw new RuntimeException("Exuberant nibble");
                                                    }
                                                    state.metaBlockLength = (readBits4 << (i20 * 4)) | state.metaBlockLength;
                                                }
                                            }
                                            state.metaBlockLength++;
                                            if (!state.inputEnd) {
                                                if (BitReader.readBits(bitReader, 1) == 1) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                state.isUncompressed = z2;
                                            }
                                            if (state.metaBlockLength == 0 || state.isMetadata) {
                                                if (!state.isUncompressed || state.isMetadata) {
                                                    i2 = (64 - bitReader.bitOffset) & 7;
                                                    if (i2 != 0 || BitReader.readBits(bitReader, i2) == 0) {
                                                        if (!state.isMetadata) {
                                                            i3 = 4;
                                                        } else {
                                                            i3 = 5;
                                                        }
                                                        state.runningState = i3;
                                                    } else {
                                                        throw new RuntimeException("Corrupted padding bits");
                                                    }
                                                } else {
                                                    state.runningState = 2;
                                                }
                                                if (!state.isMetadata) {
                                                    long j = state.expectedTotalSize + state.metaBlockLength;
                                                    state.expectedTotalSize = j;
                                                    int i21 = state.ringBufferSize;
                                                    int i22 = state.maxRingBufferSize;
                                                    if (i21 < i22) {
                                                        if (i22 > j) {
                                                            int length = ((int) j) + state.customDictionary.length;
                                                            while (true) {
                                                                int i23 = i22 >> 1;
                                                                if (i23 > length) {
                                                                    i22 = i23;
                                                                } else if (!state.inputEnd && i22 < 16384 && state.maxRingBufferSize >= 16384) {
                                                                    i22 = 16384;
                                                                }
                                                            }
                                                        }
                                                        int i24 = state.ringBufferSize;
                                                        if (i22 > i24) {
                                                            byte[] bArr3 = new byte[i22 + 37];
                                                            byte[] bArr4 = state.ringBuffer;
                                                            if (bArr4 != null) {
                                                                System.arraycopy(bArr4, 0, bArr3, 0, i24);
                                                            } else {
                                                                byte[] bArr5 = state.customDictionary;
                                                                if (bArr5.length != 0) {
                                                                    int length2 = bArr5.length;
                                                                    int i25 = state.maxBackwardDistance;
                                                                    if (length2 > i25) {
                                                                        int i26 = length2 - i25;
                                                                        length2 = i25;
                                                                        i = i26;
                                                                    } else {
                                                                        i = 0;
                                                                    }
                                                                    System.arraycopy(bArr5, i, bArr3, 0, length2);
                                                                    state.pos = length2;
                                                                    state.bytesToIgnore = length2;
                                                                }
                                                            }
                                                            state.ringBuffer = bArr3;
                                                            state.ringBufferSize = i22;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (state.metaBlockLength == 0) {
                                        }
                                        if (!state.isUncompressed) {
                                        }
                                        i2 = (64 - bitReader.bitOffset) & 7;
                                        if (i2 != 0) {
                                        }
                                        if (!state.isMetadata) {
                                        }
                                        state.runningState = i3;
                                        if (!state.isMetadata) {
                                        }
                                    }
                                    i17 = state.ringBufferSize - 1;
                                    bArr2 = state.ringBuffer;
                                    continue;
                                } else {
                                    throw new RuntimeException("Invalid metablock length");
                                }
                                break;
                            case 2:
                                bArr = bArr2;
                                int i27 = 1;
                                int[] iArr3 = state.blockLenTrees;
                                int[] iArr4 = state.numBlockTypes;
                                int i28 = 0;
                                while (i28 < 3) {
                                    if (BitReader.readBits(bitReader, i27) != 0) {
                                        int readBits5 = BitReader.readBits(bitReader, 3);
                                        if (readBits5 == 0) {
                                            i13 = 1;
                                        } else {
                                            i13 = BitReader.readBits(bitReader, readBits5) + (i27 << readBits5);
                                        }
                                    } else {
                                        i13 = 0;
                                    }
                                    iArr4[i28] = i13 + 1;
                                    iArr2[i28] = 268435456;
                                    int i29 = iArr4[i28];
                                    if (i29 > i27) {
                                        int i30 = i28 * 1080;
                                        readHuffmanCode(i29 + 2, state.blockTypeTrees, i30, bitReader);
                                        readHuffmanCode(26, iArr3, i30, bitReader);
                                        BitReader.fillBitWindow(bitReader);
                                        int readSymbol = readSymbol(iArr3, i30, bitReader);
                                        iArr2[i28] = BitReader.readBits(bitReader, BLOCK_LENGTH_N_BITS[readSymbol]) + BLOCK_LENGTH_OFFSET[readSymbol];
                                    }
                                    i28++;
                                    i27 = 1;
                                }
                                BitReader.readMoreInput(bitReader);
                                state.distancePostfixBits = BitReader.readBits(bitReader, 2);
                                int readBits6 = BitReader.readBits(bitReader, 4);
                                int i31 = state.distancePostfixBits;
                                int i32 = (readBits6 << i31) + 16;
                                state.numDirectDistanceCodes = i32;
                                state.distancePostfixMask = (1 << i31) - 1;
                                int i33 = i32 + (48 << i31);
                                char c3 = 0;
                                state.contextModes = new byte[iArr4[0]];
                                int i34 = 0;
                                while (true) {
                                    int i35 = iArr4[c3];
                                    if (i34 < i35) {
                                        int min = Math.min(i34 + 96, i35);
                                        while (i34 < min) {
                                            state.contextModes[i34] = (byte) (BitReader.readBits(bitReader, 2) << 1);
                                            i34++;
                                        }
                                        BitReader.readMoreInput(bitReader);
                                        c3 = 0;
                                    } else {
                                        int i36 = i35 << 6;
                                        byte[] bArr6 = new byte[i36];
                                        state.contextMap = bArr6;
                                        int decodeContextMap = decodeContextMap(i36, bArr6, bitReader);
                                        state.trivialLiteralContext = true;
                                        int i37 = 0;
                                        while (true) {
                                            if (i37 < (iArr4[0] << 6)) {
                                                c2 = 4;
                                                if (state.contextMap[i37] != (i37 >> 6)) {
                                                    state.trivialLiteralContext = false;
                                                } else {
                                                    i37++;
                                                }
                                            } else {
                                                c2 = 4;
                                            }
                                        }
                                        int i38 = iArr4[2] << 2;
                                        byte[] bArr7 = new byte[i38];
                                        state.distContextMap = bArr7;
                                        int decodeContextMap2 = decodeContextMap(i38, bArr7, bitReader);
                                        huffmanTreeGroup2.alphabetSize = 256;
                                        huffmanTreeGroup2.codes = new int[decodeContextMap * 1080];
                                        huffmanTreeGroup2.trees = new int[decodeContextMap];
                                        int i39 = iArr4[1];
                                        huffmanTreeGroup3.alphabetSize = 704;
                                        huffmanTreeGroup3.codes = new int[i39 * 1080];
                                        huffmanTreeGroup3.trees = new int[i39];
                                        huffmanTreeGroup.alphabetSize = i33;
                                        huffmanTreeGroup.codes = new int[decodeContextMap2 * 1080];
                                        huffmanTreeGroup.trees = new int[decodeContextMap2];
                                        HuffmanTreeGroup.decode(huffmanTreeGroup2, bitReader);
                                        HuffmanTreeGroup.decode(huffmanTreeGroup3, bitReader);
                                        HuffmanTreeGroup.decode(huffmanTreeGroup, bitReader);
                                        state.contextMapSlice = 0;
                                        state.distContextMapSlice = 0;
                                        byte b = state.contextModes[0];
                                        int[] iArr5 = LOOKUP_OFFSETS;
                                        state.contextLookupOffset1 = iArr5[b];
                                        i12 = 1;
                                        state.contextLookupOffset2 = iArr5[b + 1];
                                        state.literalTree = ((int[]) huffmanTreeGroup2.trees)[0];
                                        state.treeCommandOffset = ((int[]) huffmanTreeGroup3.trees)[0];
                                        iArr[c2] = 1;
                                        iArr[2] = 1;
                                        iArr[0] = 1;
                                        iArr[5] = 0;
                                        iArr[3] = 0;
                                        iArr[1] = 0;
                                        state.runningState = 3;
                                        if (state.metaBlockLength > 0) {
                                            state.runningState = i12;
                                            break;
                                        } else {
                                            BitReader.readMoreInput(bitReader);
                                            if (iArr2[i12] == 0) {
                                                decodeBlockTypeAndLength(state, i12);
                                                state.treeCommandOffset = ((int[]) huffmanTreeGroup3.trees)[iArr[3]];
                                            }
                                            iArr2[i12] = iArr2[i12] - i12;
                                            BitReader.fillBitWindow(bitReader);
                                            int readSymbol2 = readSymbol((int[]) huffmanTreeGroup3.codes, state.treeCommandOffset, bitReader);
                                            int i40 = readSymbol2 >>> 6;
                                            state.distanceCode = 0;
                                            if (i40 >= 2) {
                                                i40 -= 2;
                                                state.distanceCode = -1;
                                            }
                                            int i41 = INSERT_RANGE_LUT[i40] + ((readSymbol2 >>> 3) & 7);
                                            int i42 = COPY_RANGE_LUT[i40] + (readSymbol2 & 7);
                                            state.insertLength = BitReader.readBits(bitReader, INSERT_LENGTH_N_BITS[i41]) + INSERT_LENGTH_OFFSET[i41];
                                            state.copyLength = BitReader.readBits(bitReader, COPY_LENGTH_N_BITS[i42]) + COPY_LENGTH_OFFSET[i42];
                                            c = 0;
                                            state.f889j = 0;
                                            state.runningState = 6;
                                            if (!state.trivialLiteralContext) {
                                                while (true) {
                                                    if (state.f889j < state.insertLength) {
                                                        BitReader.readMoreInput(bitReader);
                                                        if (iArr2[c] == 0) {
                                                            decodeLiteralBlockSwitch(state);
                                                        }
                                                        iArr2[c] = iArr2[c] - 1;
                                                        BitReader.fillBitWindow(bitReader);
                                                        bArr[state.pos] = (byte) readSymbol((int[]) huffmanTreeGroup2.codes, state.literalTree, bitReader);
                                                        state.f889j++;
                                                        int i43 = state.pos;
                                                        state.pos = i43 + 1;
                                                        if (i43 == i17) {
                                                            state.nextRunningState = 6;
                                                            state.bytesToWrite = state.ringBufferSize;
                                                            state.bytesWritten = 0;
                                                            state.runningState = 12;
                                                        } else {
                                                            c = 0;
                                                        }
                                                    }
                                                }
                                            } else {
                                                int i44 = state.pos;
                                                int i45 = bArr[(i44 - 1) & i17] & 255;
                                                int i46 = bArr[(i44 - 2) & i17] & 255;
                                                while (state.f889j < state.insertLength) {
                                                    BitReader.readMoreInput(bitReader);
                                                    if (iArr2[0] == 0) {
                                                        decodeLiteralBlockSwitch(state);
                                                    }
                                                    byte[] bArr8 = state.contextMap;
                                                    int i47 = state.contextMapSlice;
                                                    int[] iArr6 = LOOKUP;
                                                    int i48 = iArr6[state.contextLookupOffset1 + i45];
                                                    iArr2[0] = iArr2[0] - 1;
                                                    BitReader.fillBitWindow(bitReader);
                                                    int readSymbol3 = readSymbol((int[]) huffmanTreeGroup2.codes, ((int[]) huffmanTreeGroup2.trees)[bArr8[i47 + (iArr6[state.contextLookupOffset2 + i46] | i48)] & 255], bitReader);
                                                    int i49 = state.pos;
                                                    bArr[i49] = (byte) readSymbol3;
                                                    state.f889j++;
                                                    state.pos = i49 + 1;
                                                    if (i49 == i17) {
                                                        i9 = 6;
                                                        state.nextRunningState = 6;
                                                        state.bytesToWrite = state.ringBufferSize;
                                                        state.bytesWritten = 0;
                                                        state.runningState = 12;
                                                        if (state.runningState == i9) {
                                                            int i50 = state.metaBlockLength - state.insertLength;
                                                            state.metaBlockLength = i50;
                                                            if (i50 <= 0) {
                                                                state.runningState = 3;
                                                                break;
                                                            } else {
                                                                if (state.distanceCode < 0) {
                                                                    BitReader.readMoreInput(bitReader);
                                                                    if (iArr2[2] == 0) {
                                                                        decodeBlockTypeAndLength(state, 2);
                                                                        state.distContextMapSlice = iArr[5] << 2;
                                                                    }
                                                                    iArr2[2] = iArr2[2] - 1;
                                                                    BitReader.fillBitWindow(bitReader);
                                                                    int[] iArr7 = (int[]) huffmanTreeGroup.codes;
                                                                    int[] iArr8 = (int[]) huffmanTreeGroup.trees;
                                                                    byte[] bArr9 = state.distContextMap;
                                                                    int i51 = state.distContextMapSlice;
                                                                    int i52 = state.copyLength;
                                                                    int readSymbol4 = readSymbol(iArr7, iArr8[bArr9[i51 + (i52 > 4 ? 3 : i52 - 2)] & 255], bitReader);
                                                                    state.distanceCode = readSymbol4;
                                                                    int i53 = state.numDirectDistanceCodes;
                                                                    if (readSymbol4 >= i53) {
                                                                        int i54 = readSymbol4 - i53;
                                                                        int i55 = state.distancePostfixMask & i54;
                                                                        int i56 = i54 >>> state.distancePostfixBits;
                                                                        state.distanceCode = i56;
                                                                        state.distanceCode = i53 + i55 + ((BitReader.readBits(bitReader, (i56 >>> 1) + 1) + ((((i56 & 1) + 2) << i11) - 4)) << state.distancePostfixBits);
                                                                    }
                                                                }
                                                                int i57 = state.distanceCode;
                                                                int[] iArr9 = state.distRb;
                                                                int i58 = state.distRbIdx;
                                                                int i59 = i57 < 16 ? iArr9[(DISTANCE_SHORT_CODE_INDEX_OFFSET[i57] + i58) & 3] + DISTANCE_SHORT_CODE_VALUE_OFFSET[i57] : i57 - 15;
                                                                state.distance = i59;
                                                                if (i59 >= 0) {
                                                                    int i60 = state.maxDistance;
                                                                    int i61 = state.maxBackwardDistance;
                                                                    if (i60 == i61 || (i10 = state.pos) >= i61) {
                                                                        state.maxDistance = i61;
                                                                    } else {
                                                                        state.maxDistance = i10;
                                                                    }
                                                                    state.copyDst = state.pos;
                                                                    if (i59 > state.maxDistance) {
                                                                        state.runningState = 9;
                                                                        break;
                                                                    } else {
                                                                        if (i57 > 0) {
                                                                            iArr9[i58 & 3] = i59;
                                                                            state.distRbIdx = i58 + 1;
                                                                        }
                                                                        if (state.copyLength <= state.metaBlockLength) {
                                                                            state.f889j = 0;
                                                                            state.runningState = 7;
                                                                            int i62 = state.pos;
                                                                            i4 = (i62 - state.distance) & i17;
                                                                            i5 = state.copyLength - state.f889j;
                                                                            if (i4 + i5 < i17 || i62 + i5 >= i17) {
                                                                                do {
                                                                                    i6 = state.f889j;
                                                                                    if (i6 >= state.copyLength) {
                                                                                        i7 = state.pos;
                                                                                        bArr[i7] = bArr[(i7 - state.distance) & i17];
                                                                                        state.metaBlockLength--;
                                                                                        state.f889j = i6 + 1;
                                                                                        state.pos = i7 + 1;
                                                                                    }
                                                                                } while (i7 != i17);
                                                                                i8 = 7;
                                                                                state.nextRunningState = 7;
                                                                                state.bytesToWrite = state.ringBufferSize;
                                                                                state.bytesWritten = 0;
                                                                                state.runningState = 12;
                                                                                if (state.runningState == i8) {
                                                                                    state.runningState = 3;
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                int i63 = 0;
                                                                                while (i63 < i5) {
                                                                                    bArr[i62] = bArr[i4];
                                                                                    i63++;
                                                                                    i62++;
                                                                                    i4++;
                                                                                }
                                                                                state.f889j += i5;
                                                                                state.metaBlockLength -= i5;
                                                                                state.pos += i5;
                                                                            }
                                                                            i8 = 7;
                                                                            if (state.runningState == i8) {
                                                                            }
                                                                        } else {
                                                                            throw new RuntimeException("Invalid backward reference");
                                                                        }
                                                                    }
                                                                } else {
                                                                    throw new RuntimeException("Negative distance");
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        int i64 = i45;
                                                        i45 = readSymbol3;
                                                        i46 = i64;
                                                    }
                                                }
                                            }
                                            i9 = 6;
                                            if (state.runningState == i9) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 3:
                                bArr = bArr2;
                                i12 = 1;
                                if (state.metaBlockLength > 0) {
                                }
                                break;
                            case 4:
                                bArr = bArr2;
                                while (state.metaBlockLength > 0) {
                                    BitReader.readMoreInput(bitReader);
                                    BitReader.readBits(bitReader, 8);
                                    state.metaBlockLength--;
                                }
                                state.runningState = 1;
                                break;
                            case 5:
                                byte[] bArr10 = state.ringBuffer;
                                int i65 = state.metaBlockLength;
                                if (i65 <= 0) {
                                    if (bitReader.bitOffset == 64) {
                                        BitReader.readMoreInput(bitReader);
                                        BitReader.checkHealth(bitReader, false);
                                        BitReader.fillBitWindow(bitReader);
                                        BitReader.fillBitWindow(bitReader);
                                    }
                                    state.runningState = 1;
                                    bArr = bArr2;
                                    break;
                                } else {
                                    int min2 = Math.min(state.ringBufferSize - state.pos, i65);
                                    int i66 = state.pos;
                                    if ((bitReader.bitOffset & 7) == 0) {
                                        int i67 = min2;
                                        while (true) {
                                            int i68 = bitReader.bitOffset;
                                            if (i68 != 64 && i67 != 0) {
                                                bArr10[i66] = (byte) (bitReader.accumulator >>> i68);
                                                bitReader.bitOffset = i68 + 8;
                                                i67--;
                                                i66++;
                                                min2 = min2;
                                                bArr2 = bArr2;
                                            }
                                        }
                                        int i69 = min2;
                                        bArr = bArr2;
                                        if (i67 != 0) {
                                            int min3 = Math.min(BitReader.intAvailable(bitReader), i67 >> 2);
                                            if (min3 > 0) {
                                                int i70 = min3 << 2;
                                                System.arraycopy(bitReader.byteBuffer, bitReader.intOffset << 2, bArr10, i66, i70);
                                                i66 += i70;
                                                i67 -= i70;
                                                bitReader.intOffset += min3;
                                            }
                                            if (i67 != 0) {
                                                if (BitReader.intAvailable(bitReader) > 0) {
                                                    BitReader.fillBitWindow(bitReader);
                                                    while (i67 != 0) {
                                                        long j2 = bitReader.accumulator;
                                                        int i71 = bitReader.bitOffset;
                                                        bArr10[i66] = (byte) (j2 >>> i71);
                                                        bitReader.bitOffset = i71 + 8;
                                                        i67--;
                                                        i66++;
                                                    }
                                                    BitReader.checkHealth(bitReader, false);
                                                } else {
                                                    while (i67 > 0) {
                                                        try {
                                                            int read = bitReader.input.read(bArr10, i66, i67);
                                                            if (read != -1) {
                                                                i66 += read;
                                                                i67 -= read;
                                                            } else {
                                                                throw new RuntimeException("Unexpected end of input");
                                                            }
                                                        } catch (IOException e) {
                                                            throw new RuntimeException("Failed to read input", e);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        state.metaBlockLength -= i69;
                                        int i72 = state.pos + i69;
                                        state.pos = i72;
                                        int i73 = state.ringBufferSize;
                                        if (i72 == i73) {
                                            state.nextRunningState = 5;
                                            state.bytesToWrite = i73;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                            break;
                                        } else {
                                            if (bitReader.bitOffset == 64) {
                                                BitReader.readMoreInput(bitReader);
                                                BitReader.checkHealth(bitReader, false);
                                                BitReader.fillBitWindow(bitReader);
                                                BitReader.fillBitWindow(bitReader);
                                            }
                                            state.runningState = 1;
                                            break;
                                        }
                                    } else {
                                        throw new RuntimeException("Unaligned copyBytes");
                                    }
                                }
                                break;
                            case 6:
                                bArr = bArr2;
                                c = 0;
                                if (!state.trivialLiteralContext) {
                                }
                                i9 = 6;
                                if (state.runningState == i9) {
                                }
                                break;
                            case 7:
                                bArr = bArr2;
                                int i622 = state.pos;
                                i4 = (i622 - state.distance) & i17;
                                i5 = state.copyLength - state.f889j;
                                if (i4 + i5 < i17) {
                                    break;
                                }
                                do {
                                    i6 = state.f889j;
                                    if (i6 >= state.copyLength) {
                                    }
                                } while (i7 != i17);
                                i8 = 7;
                                state.nextRunningState = 7;
                                state.bytesToWrite = state.ringBufferSize;
                                state.bytesWritten = 0;
                                state.runningState = 12;
                                if (state.runningState == i8) {
                                }
                                break;
                            case 8:
                                int i74 = state.ringBufferSize;
                                System.arraycopy(bArr2, i74, bArr2, 0, state.copyDst - i74);
                                state.runningState = 3;
                                bArr = bArr2;
                                break;
                            case 9:
                                int i75 = state.copyLength;
                                if (i75 >= 4 && i75 <= 24) {
                                    int i76 = OFFSETS_BY_LENGTH[i75];
                                    int i77 = (state.distance - state.maxDistance) - 1;
                                    int i78 = i77 & ((1 << i14) - 1);
                                    int i79 = i77 >>> SIZE_BITS_BY_LENGTH[i75];
                                    int i80 = (i78 * i75) + i76;
                                    Transform[] transformArr = Transform.TRANSFORMS;
                                    if (i79 < transformArr.length) {
                                        int i81 = state.copyDst;
                                        byte[] bArr11 = Dictionary$DataHolder.DATA;
                                        Transform transform = transformArr[i79];
                                        int i82 = i81;
                                        for (byte b2 : transform.prefix) {
                                            bArr2[i82] = b2;
                                            i82++;
                                        }
                                        int i83 = transform.type;
                                        int i84 = i83 >= 12 ? i83 - 11 : 0;
                                        if (i84 > i75) {
                                            i84 = i75;
                                        }
                                        int i85 = i80 + i84;
                                        int i86 = i75 - i84;
                                        if (i83 <= 9) {
                                            i15 = i83;
                                        } else {
                                            i15 = 0;
                                        }
                                        int i87 = i86 - i15;
                                        int i88 = i87;
                                        while (i88 > 0) {
                                            bArr2[i82] = bArr11[i85];
                                            i88--;
                                            i82++;
                                            i85++;
                                        }
                                        if (i83 == 11 || i83 == 10) {
                                            int i89 = i82 - i87;
                                            if (i83 == 10) {
                                                i87 = 1;
                                            }
                                            while (i87 > 0) {
                                                byte b3 = bArr2[i89];
                                                int i90 = b3 & 255;
                                                if (i90 < 192) {
                                                    if (i90 >= 97 && i90 <= 122) {
                                                        bArr2[i89] = (byte) (b3 ^ 32);
                                                    }
                                                    i89++;
                                                    i87--;
                                                } else if (i90 < 224) {
                                                    int i91 = i89 + 1;
                                                    bArr2[i91] = (byte) (bArr2[i91] ^ 32);
                                                    i89 += 2;
                                                    i87 -= 2;
                                                } else {
                                                    int i92 = i89 + 2;
                                                    bArr2[i92] = (byte) (bArr2[i92] ^ 5);
                                                    i89 += 3;
                                                    i87 -= 3;
                                                }
                                            }
                                        }
                                        for (byte b4 : transform.suffix) {
                                            bArr2[i82] = b4;
                                            i82++;
                                        }
                                        int i93 = i82 - i81;
                                        int i94 = state.copyDst + i93;
                                        state.copyDst = i94;
                                        state.pos += i93;
                                        state.metaBlockLength -= i93;
                                        int i95 = state.ringBufferSize;
                                        if (i94 >= i95) {
                                            state.nextRunningState = 8;
                                            state.bytesToWrite = i95;
                                            state.bytesWritten = 0;
                                            state.runningState = 12;
                                        } else {
                                            state.runningState = 3;
                                        }
                                        bArr = bArr2;
                                        break;
                                    } else {
                                        throw new RuntimeException("Invalid backward reference");
                                    }
                                }
                                break;
                            default:
                                throw new RuntimeException("Unexpected state " + state.runningState);
                        }
                    } else {
                        bArr = bArr2;
                        int i96 = state.bytesToIgnore;
                        if (i96 != 0) {
                            state.bytesWritten += i96;
                            state.bytesToIgnore = 0;
                        }
                        int min4 = Math.min(state.outputLength - state.outputUsed, state.bytesToWrite - state.bytesWritten);
                        if (min4 != 0) {
                            System.arraycopy(state.ringBuffer, state.bytesWritten, state.output, state.outputOffset + state.outputUsed, min4);
                            state.outputUsed += min4;
                            state.bytesWritten += min4;
                        }
                        if (state.outputUsed < state.outputLength) {
                            int i97 = state.pos;
                            int i98 = state.maxBackwardDistance;
                            if (i97 >= i98) {
                                state.maxDistance = i98;
                            }
                            state.pos = i97 & i17;
                            state.runningState = state.nextRunningState;
                        } else {
                            return;
                        }
                    }
                    bArr2 = bArr;
                } else if (i18 == 10) {
                    if (state.metaBlockLength >= 0) {
                        int i99 = (64 - bitReader.bitOffset) & 7;
                        if (i99 == 0 || BitReader.readBits(bitReader, i99) == 0) {
                            BitReader.checkHealth(bitReader, true);
                            return;
                        }
                        throw new RuntimeException("Corrupted padding bits");
                    }
                    throw new RuntimeException("Invalid metablock length");
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Can't decompress after close");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0143, code lost:
        if (r9 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0145, code lost:
        r1 = r18 - r6;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0148, code lost:
        if (r3 >= r1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014a, code lost:
        r4 = java.lang.Math.min(r3 + 1024, r1) - r3;
        java.lang.System.arraycopy(org.brotli.dec.Utils.INT_ZEROES, 0, r2, r6 + r3, r4);
        r3 = r3 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0173, code lost:
        throw new java.lang.RuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readHuffmanCode(int i, int[] iArr, int i2, BitReader bitReader) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        BitReader.readMoreInput(bitReader);
        int[] iArr2 = new int[i];
        int readBits = BitReader.readBits(bitReader, 2);
        boolean z2 = false;
        boolean z3 = true;
        if (readBits == 1) {
            int i8 = i - 1;
            int[] iArr3 = new int[4];
            int readBits2 = BitReader.readBits(bitReader, 2) + 1;
            int i9 = 0;
            while (i8 != 0) {
                i8 >>= 1;
                i9++;
            }
            for (int i10 = 0; i10 < readBits2; i10++) {
                int readBits3 = BitReader.readBits(bitReader, i9) % i;
                iArr3[i10] = readBits3;
                iArr2[readBits3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (readBits2 != 1) {
                if (readBits2 == 2) {
                    int i11 = iArr3[0];
                    int i12 = iArr3[1];
                    if (i11 != i12) {
                        z2 = true;
                    }
                    iArr2[i12] = 1;
                } else if (readBits2 != 3) {
                    int i13 = iArr3[0];
                    int i14 = iArr3[1];
                    if (i13 == i14 || i13 == (i6 = iArr3[2]) || i13 == (i7 = iArr3[3]) || i14 == i6 || i14 == i7 || i6 == i7) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (BitReader.readBits(bitReader, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z3 = z;
                } else {
                    int i15 = iArr3[0];
                    int i16 = iArr3[1];
                    if (!(i15 == i16 || i15 == (i5 = iArr3[2]) || i16 == i5)) {
                        z2 = true;
                    }
                }
                z3 = z2;
            }
        } else {
            int[] iArr4 = new int[18];
            int i17 = 32;
            int i18 = 0;
            while (readBits < 18 && i17 > 0) {
                int i19 = CODE_LENGTH_CODE_ORDER[readBits];
                BitReader.fillBitWindow(bitReader);
                long j = bitReader.accumulator;
                int i20 = bitReader.bitOffset;
                int i21 = FIXED_TABLE[((int) (j >>> i20)) & 15];
                bitReader.bitOffset = i20 + (i21 >> 16);
                int i22 = i21 & 65535;
                iArr4[i19] = i22;
                if (i22 != 0) {
                    i17 -= 32 >> i22;
                    i18++;
                }
                readBits++;
            }
            if (!(i18 == 1 || i17 == 0)) {
                z3 = false;
            }
            int[] iArr5 = new int[32];
            buildHuffmanTable(0, 5, iArr5, iArr4, 18);
            int i23 = 0;
            int i24 = 32768;
            int i25 = 8;
            int i26 = 0;
            loop3: while (true) {
                int i27 = 0;
                while (i23 < i && i24 > 0) {
                    BitReader.readMoreInput(bitReader);
                    BitReader.fillBitWindow(bitReader);
                    long j2 = bitReader.accumulator;
                    int i28 = bitReader.bitOffset;
                    int i29 = iArr5[((int) (j2 >>> i28)) & 31];
                    bitReader.bitOffset = i28 + (i29 >> 16);
                    int i30 = i29 & 65535;
                    if (i30 < 16) {
                        int i31 = i23 + 1;
                        iArr2[i23] = i30;
                        if (i30 != 0) {
                            i24 -= 32768 >> i30;
                            i25 = i30;
                        }
                        i23 = i31;
                    } else {
                        int i32 = i30 - 14;
                        if (i30 == 16) {
                            i3 = i25;
                        } else {
                            i3 = 0;
                        }
                        if (i26 != i3) {
                            i26 = i3;
                            i27 = 0;
                        }
                        if (i27 > 0) {
                            i4 = (i27 - 2) << i32;
                        } else {
                            i4 = i27;
                        }
                        int readBits4 = BitReader.readBits(bitReader, i32) + 3 + i4;
                        int i33 = readBits4 - i27;
                        if (i23 + i33 <= i) {
                            int i34 = 0;
                            while (i34 < i33) {
                                iArr2[i23] = i26;
                                i34++;
                                i23++;
                            }
                            if (i26 != 0) {
                                i24 -= i33 << (15 - i26);
                            }
                            i27 = readBits4;
                        } else {
                            throw new RuntimeException("symbol + repeatDelta > numSymbols");
                        }
                    }
                }
            }
        }
        if (z3) {
            buildHuffmanTable(i2, 8, iArr, iArr2, i);
            return;
        }
        throw new RuntimeException("Can't readHuffmanCode");
    }

    public static int readSymbol(int[] iArr, int i, BitReader bitReader) {
        long j = bitReader.accumulator;
        int i2 = bitReader.bitOffset;
        int i3 = (int) (j >>> i2);
        int i4 = i + (i3 & 255);
        int i5 = iArr[i4];
        int i6 = i5 >> 16;
        int i7 = i5 & 65535;
        if (i6 <= 8) {
            bitReader.bitOffset = i2 + i6;
            return i7;
        }
        int i8 = iArr[i4 + i7 + ((i3 & ((1 << i6) - 1)) >>> 8)];
        bitReader.bitOffset = (i8 >> 16) + 8 + i2;
        return i8 & 65535;
    }
}
