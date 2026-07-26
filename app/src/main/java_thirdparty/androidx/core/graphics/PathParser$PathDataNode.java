package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.core.os.BundleKt;
/* loaded from: classes.dex */
public final class PathParser$PathDataNode {
    public final float[] mParams;
    public char mType;

    public PathParser$PathDataNode(char c, float[] fArr) {
        this.mType = c;
        this.mParams = fArr;
    }

    public static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = f;
        double d4 = f2;
        double d5 = f5;
        double d6 = ((d4 * sin) + (d3 * cos)) / d5;
        double d7 = f6;
        double d8 = ((d4 * cos) + ((-f) * sin)) / d7;
        double d9 = f4;
        double d10 = ((d9 * sin) + (f3 * cos)) / d5;
        double d11 = ((d9 * cos) + ((-f3) * sin)) / d7;
        double d12 = d6 - d10;
        double d13 = d8 - d11;
        double d14 = (d6 + d10) / 2.0d;
        double d15 = (d8 + d11) / 2.0d;
        double d16 = (d13 * d13) + (d12 * d12);
        if (d16 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d17 = (1.0d / d16) - 0.25d;
        if (d17 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d16);
            float sqrt = (float) (Math.sqrt(d16) / 1.99999d);
            drawArc(path, f, f2, f3, f4, f5 * sqrt, sqrt * f6, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d17);
        double d18 = sqrt2 * d12;
        double d19 = sqrt2 * d13;
        if (z == z2) {
            d2 = d14 - d19;
            d = d15 + d18;
        } else {
            d2 = d14 + d19;
            d = d15 - d18;
        }
        double atan2 = Math.atan2(d8 - d, d6 - d2);
        double atan22 = Math.atan2(d11 - d, d10 - d2) - atan2;
        int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
        if (z2 != (i >= 0)) {
            atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d20 = d2 * d5;
        double d21 = d * d7;
        double d22 = (d20 * cos) - (d21 * sin);
        double d23 = (d21 * cos) + (d20 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d24 = d4;
        double d25 = -d5;
        double d26 = d25 * cos2;
        double d27 = d7 * sin2;
        double d28 = (d26 * sin3) - (d27 * cos3);
        double d29 = d25 * sin2;
        double d30 = d7 * cos2;
        double d31 = (cos3 * d30) + (sin3 * d29);
        double d32 = atan22 / ceil;
        double d33 = atan2;
        int i2 = 0;
        while (i2 < ceil) {
            double d34 = d33 + d32;
            double sin4 = Math.sin(d34);
            double cos4 = Math.cos(d34);
            ceil = ceil;
            d32 = d32;
            double d35 = (((d5 * cos2) * cos4) + d22) - (d27 * sin4);
            double d36 = d29;
            double d37 = (d30 * sin4) + (d5 * sin2 * cos4) + d23;
            double d38 = (d26 * sin4) - (d27 * cos4);
            double d39 = (cos4 * d30) + (sin4 * d36);
            double d40 = d34 - d33;
            double tan = Math.tan(d40 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d40)) / 3.0d;
            d22 = d22;
            cos2 = cos2;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d28 * sqrt3) + d3), (float) ((d31 * sqrt3) + d24), (float) (d35 - (sqrt3 * d38)), (float) (d37 - (sqrt3 * d39)), (float) d35, (float) d37);
            i2++;
            d3 = d35;
            d24 = d37;
            d33 = d34;
            d31 = d39;
            d28 = d38;
            d29 = d36;
        }
    }

    public static void nodesToPath(PathParser$PathDataNode[] pathParser$PathDataNodeArr, Path path) {
        int i;
        int i2;
        float[] fArr;
        int i3;
        char c;
        float f;
        float f2;
        PathParser$PathDataNode pathParser$PathDataNode;
        boolean z;
        boolean z2;
        boolean z3;
        PathParser$PathDataNode pathParser$PathDataNode2;
        boolean z4;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = pathParser$PathDataNodeArr2.length;
        char c2 = 0;
        char c3 = 'm';
        int i4 = 0;
        while (i4 < length) {
            PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArr2[i4];
            char c4 = pathParser$PathDataNode3.mType;
            float[] fArr3 = pathParser$PathDataNode3.mParams;
            float f11 = fArr2[c2];
            float f12 = fArr2[1];
            float f13 = fArr2[2];
            float f14 = fArr2[3];
            float f15 = fArr2[4];
            float f16 = fArr2[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f15, f16);
                    f11 = f15;
                    f13 = f11;
                    f12 = f16;
                    f14 = f12;
                default:
                    i = 2;
                    break;
            }
            float f17 = f15;
            float f18 = f16;
            float f19 = f11;
            float f20 = f12;
            int i5 = 0;
            while (i5 < fArr3.length) {
                if (c4 == 'A') {
                    fArr = fArr3;
                    i2 = i5;
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    float f21 = f19;
                    float f22 = f20;
                    i3 = i4;
                    c = c4;
                    int i6 = i2 + 5;
                    float f23 = fArr[i6];
                    int i7 = i2 + 6;
                    float f24 = fArr[i7];
                    float f25 = fArr[i2];
                    float f26 = fArr[i2 + 1];
                    float f27 = fArr[i2 + 2];
                    if (fArr[i2 + 3] != 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (fArr[i2 + 4] != 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    drawArc(path, f21, f22, f23, f24, f25, f26, f27, z, z2);
                    f13 = fArr[i6];
                    f = fArr[i7];
                    f14 = f;
                    f2 = f13;
                } else if (c4 == 'C') {
                    fArr = fArr3;
                    i2 = i5;
                    i3 = i4;
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    c = c4;
                    int i8 = i2 + 2;
                    int i9 = i2 + 3;
                    int i10 = i2 + 4;
                    int i11 = i2 + 5;
                    path2.cubicTo(fArr[i2], fArr[i2 + 1], fArr[i8], fArr[i9], fArr[i10], fArr[i11]);
                    float f28 = fArr[i10];
                    float f29 = fArr[i11];
                    f13 = fArr[i8];
                    f14 = fArr[i9];
                    f = f29;
                    f2 = f28;
                } else if (c4 == 'H') {
                    fArr = fArr3;
                    i2 = i5;
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    c = c4;
                    f = f20;
                    i3 = i4;
                    path2.lineTo(fArr[i2], f);
                    f2 = fArr[i2];
                } else if (c4 == 'Q') {
                    fArr = fArr3;
                    i2 = i5;
                    i3 = i4;
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    c = c4;
                    int i12 = i2 + 1;
                    int i13 = i2 + 2;
                    int i14 = i2 + 3;
                    path2.quadTo(fArr[i2], fArr[i12], fArr[i13], fArr[i14]);
                    float f30 = fArr[i2];
                    float f31 = fArr[i12];
                    float f32 = fArr[i13];
                    float f33 = fArr[i14];
                    f13 = f30;
                    f14 = f31;
                    f2 = f32;
                    f = f33;
                } else if (c4 == 'V') {
                    fArr = fArr3;
                    i2 = i5;
                    i3 = i4;
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    f2 = f19;
                    c = c4;
                    path2.lineTo(f2, fArr[i2]);
                    f = fArr[i2];
                } else if (c4 != 'a') {
                    if (c4 == 'c') {
                        fArr = fArr3;
                        i2 = i5;
                        int i15 = i2 + 2;
                        int i16 = i2 + 3;
                        int i17 = i2 + 4;
                        int i18 = i2 + 5;
                        path2.rCubicTo(fArr[i2], fArr[i2 + 1], fArr[i15], fArr[i16], fArr[i17], fArr[i18]);
                        float f34 = fArr[i15] + f19;
                        float f35 = fArr[i16] + f20;
                        f19 += fArr[i17];
                        f20 += fArr[i18];
                        f13 = f34;
                        f14 = f35;
                    } else if (c4 != 'h') {
                        if (c4 != 'q') {
                            if (c4 != 'v') {
                                if (c4 == 'L') {
                                    fArr = fArr3;
                                    i2 = i5;
                                    int i19 = i2 + 1;
                                    path2.lineTo(fArr[i2], fArr[i19]);
                                    f2 = fArr[i2];
                                    f = fArr[i19];
                                } else if (c4 == 'M') {
                                    fArr = fArr3;
                                    i2 = i5;
                                    f2 = fArr[i2];
                                    f = fArr[i2 + 1];
                                    if (i2 > 0) {
                                        path2.lineTo(f2, f);
                                    } else {
                                        path2.moveTo(f2, f);
                                        f17 = f2;
                                        f18 = f;
                                    }
                                } else if (c4 != 'S') {
                                    if (c4 == 'T') {
                                        fArr = fArr3;
                                        i2 = i5;
                                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                            f19 = (f19 * 2.0f) - f13;
                                            f20 = (f20 * 2.0f) - f14;
                                        }
                                        int i20 = i2 + 1;
                                        path2.quadTo(f19, f20, fArr[i2], fArr[i20]);
                                        f2 = fArr[i2];
                                        f = fArr[i20];
                                        pathParser$PathDataNode = pathParser$PathDataNode3;
                                        f13 = f19;
                                        f14 = f20;
                                    } else if (c4 == 'l') {
                                        fArr = fArr3;
                                        i2 = i5;
                                        int i21 = i2 + 1;
                                        path2.rLineTo(fArr[i2], fArr[i21]);
                                        f19 += fArr[i2];
                                        f6 = fArr[i21];
                                    } else if (c4 == 'm') {
                                        fArr = fArr3;
                                        i2 = i5;
                                        float f36 = fArr[i2];
                                        f19 += f36;
                                        float f37 = fArr[i2 + 1];
                                        f20 += f37;
                                        if (i2 > 0) {
                                            path2.rLineTo(f36, f37);
                                        } else {
                                            path2.rMoveTo(f36, f37);
                                            pathParser$PathDataNode = pathParser$PathDataNode3;
                                            f2 = f19;
                                            f17 = f2;
                                            f = f20;
                                            f18 = f;
                                        }
                                    } else if (c4 != 's') {
                                        if (c4 != 't') {
                                            fArr = fArr3;
                                            i2 = i5;
                                            pathParser$PathDataNode = pathParser$PathDataNode3;
                                            f2 = f19;
                                        } else {
                                            if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                f9 = f19 - f13;
                                                f10 = f20 - f14;
                                            } else {
                                                f10 = 0.0f;
                                                f9 = 0.0f;
                                            }
                                            int i22 = i5 + 1;
                                            path2.rQuadTo(f9, f10, fArr3[i5], fArr3[i22]);
                                            float f38 = f9 + f19;
                                            float f39 = f10 + f20;
                                            float f40 = f19 + fArr3[i5];
                                            f20 += fArr3[i22];
                                            f14 = f39;
                                            fArr = fArr3;
                                            i2 = i5;
                                            pathParser$PathDataNode = pathParser$PathDataNode3;
                                            f2 = f40;
                                            f13 = f38;
                                        }
                                        f = f20;
                                    } else {
                                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                            f7 = f20 - f14;
                                            f8 = f19 - f13;
                                        } else {
                                            f8 = 0.0f;
                                            f7 = 0.0f;
                                        }
                                        int i23 = i5;
                                        int i24 = i23 + 1;
                                        int i25 = i23 + 2;
                                        int i26 = i23 + 3;
                                        fArr = fArr3;
                                        i2 = i23;
                                        path2.rCubicTo(f8, f7, fArr3[i23], fArr3[i24], fArr3[i25], fArr3[i26]);
                                        f3 = fArr[i2] + f19;
                                        f4 = fArr[i24] + f20;
                                        f19 += fArr[i25];
                                        f5 = fArr[i26];
                                    }
                                    i3 = i4;
                                    c = c4;
                                } else {
                                    fArr = fArr3;
                                    i2 = i5;
                                    if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                        f19 = (f19 * 2.0f) - f13;
                                        f20 = (f20 * 2.0f) - f14;
                                    }
                                    float f41 = f19;
                                    float f42 = f20;
                                    int i27 = i2 + 1;
                                    int i28 = i2 + 2;
                                    int i29 = i2 + 3;
                                    path2.cubicTo(f41, f42, fArr[i2], fArr[i27], fArr[i28], fArr[i29]);
                                    float f43 = fArr[i2];
                                    float f44 = fArr[i27];
                                    f13 = f43;
                                    f14 = f44;
                                    f2 = fArr[i28];
                                    f = fArr[i29];
                                }
                                i3 = i4;
                                pathParser$PathDataNode = pathParser$PathDataNode3;
                                c = c4;
                            } else {
                                fArr = fArr3;
                                i2 = i5;
                                path2.rLineTo(0.0f, fArr[i2]);
                                f6 = fArr[i2];
                            }
                            f20 += f6;
                        } else {
                            fArr = fArr3;
                            i2 = i5;
                            int i30 = i2 + 1;
                            int i31 = i2 + 2;
                            int i32 = i2 + 3;
                            path2.rQuadTo(fArr[i2], fArr[i30], fArr[i31], fArr[i32]);
                            f3 = fArr[i2] + f19;
                            f4 = fArr[i30] + f20;
                            f19 += fArr[i31];
                            f5 = fArr[i32];
                        }
                        f20 += f5;
                        f13 = f3;
                        f14 = f4;
                    } else {
                        fArr = fArr3;
                        i2 = i5;
                        path2.rLineTo(fArr[i2], 0.0f);
                        f19 += fArr[i2];
                    }
                    pathParser$PathDataNode = pathParser$PathDataNode3;
                    f2 = f19;
                    f = f20;
                    i3 = i4;
                    c = c4;
                } else {
                    fArr = fArr3;
                    i2 = i5;
                    int i33 = i2 + 5;
                    float f45 = fArr[i33] + f19;
                    int i34 = i2 + 6;
                    float f46 = fArr[i34] + f20;
                    float f47 = fArr[i2];
                    float f48 = fArr[i2 + 1];
                    float f49 = fArr[i2 + 2];
                    if (fArr[i2 + 3] != 0.0f) {
                        pathParser$PathDataNode2 = pathParser$PathDataNode3;
                        z3 = true;
                    } else {
                        pathParser$PathDataNode2 = pathParser$PathDataNode3;
                        z3 = false;
                    }
                    pathParser$PathDataNode = pathParser$PathDataNode2;
                    float f50 = f19;
                    c = c4;
                    if (fArr[i2 + 4] != 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    float f51 = f20;
                    i3 = i4;
                    drawArc(path, f50, f51, f45, f46, f47, f48, f49, z3, z4);
                    f2 = f50 + fArr[i33];
                    f = f51 + fArr[i34];
                    f13 = f2;
                    f14 = f;
                }
                i5 = i2 + i;
                path2 = path;
                pathParser$PathDataNode3 = pathParser$PathDataNode;
                c4 = c;
                i4 = i3;
                f19 = f2;
                f20 = f;
                c3 = c4;
                fArr3 = fArr;
            }
            fArr2[0] = f19;
            fArr2[1] = f20;
            fArr2[2] = f13;
            fArr2[3] = f14;
            fArr2[4] = f17;
            fArr2[5] = f18;
            c3 = pathParser$PathDataNode3.mType;
            i4++;
            pathParser$PathDataNodeArr2 = pathParser$PathDataNodeArr;
            path2 = path;
            c2 = 0;
        }
    }

    public PathParser$PathDataNode(PathParser$PathDataNode pathParser$PathDataNode) {
        this.mType = pathParser$PathDataNode.mType;
        float[] fArr = pathParser$PathDataNode.mParams;
        this.mParams = BundleKt.copyOfRange(fArr, fArr.length);
    }
}
