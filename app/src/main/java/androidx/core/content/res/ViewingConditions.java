package androidx.core.content.res;
/* loaded from: classes.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT;
    public final float mAw;

    /* renamed from: mC */
    public final float f6mC;
    public final float mFl;
    public final float mFlRoot;

    /* renamed from: mN */
    public final float f7mN;
    public final float mNbb;
    public final float mNc;
    public final float mNcb;
    public final float[] mRgbD;

    /* renamed from: mZ */
    public final float f8mZ;

    static {
        float f;
        float[] fArr;
        float[] fArr2 = CamUtils.WHITE_POINT_D65;
        float yFromLStar = (float) ((CamUtils.yFromLStar() * 63.66197723675813d) / 100.0d);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f2 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f3 = fArr2[1];
        float f4 = fArr4[1] * f3;
        float f5 = fArr2[2];
        float f6 = (fArr4[2] * f5) + f4 + (fArr4[0] * f2);
        float[] fArr5 = fArr3[1];
        float f7 = (fArr5[2] * f5) + (fArr5[1] * f3) + (fArr5[0] * f2);
        float[] fArr6 = fArr3[2];
        float f8 = (f5 * fArr6[2]) + (f3 * fArr6[1]) + (f2 * fArr6[0]);
        if (1.0f >= 0.9d) {
            f = 0.69f;
        } else {
            f = 0.655f;
        }
        float exp = (1.0f - (((float) Math.exp(((-yFromLStar) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < 0.0d) {
            exp = 0.0f;
        }
        float f9 = 1.0f / ((5.0f * yFromLStar) + 1.0f);
        float f10 = f9 * f9 * f9 * f9;
        float f11 = 1.0f - f10;
        float cbrt = (0.1f * f11 * f11 * ((float) Math.cbrt(yFromLStar * 5.0d))) + (f10 * yFromLStar);
        float yFromLStar2 = CamUtils.yFromLStar() / fArr2[1];
        double d2 = yFromLStar2;
        float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr[0] * cbrt) * f6) / 100.0d, 0.42d), (float) Math.pow(((fArr[1] * cbrt) * f7) / 100.0d, 0.42d), (float) Math.pow(((fArr[2] * cbrt) * f8) / 100.0d, 0.42d)};
        float f12 = fArr7[0];
        float f13 = (f12 * 400.0f) / (f12 + 27.13f);
        float f14 = fArr7[1];
        float f15 = (f14 * 400.0f) / (f14 + 27.13f);
        float f16 = fArr7[2];
        float[] fArr8 = {f13, f15, (400.0f * f16) / (f16 + 27.13f)};
        DEFAULT = new ViewingConditions(yFromLStar2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * pow, pow, pow, f, 1.0f, new float[]{(((100.0f / f6) * exp) + 1.0f) - exp, (((100.0f / f7) * exp) + 1.0f) - exp, (((100.0f / f8) * exp) + 1.0f) - exp}, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.f7mN = f;
        this.mAw = f2;
        this.mNbb = f3;
        this.mNcb = f4;
        this.f6mC = f5;
        this.mNc = f6;
        this.mRgbD = fArr;
        this.mFl = f7;
        this.mFlRoot = f8;
        this.f8mZ = f9;
    }
}
