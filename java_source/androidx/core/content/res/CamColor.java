package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
/* loaded from: classes.dex */
public final class CamColor {
    public final float mAstar;
    public final float mBstar;
    public final float mChroma;
    public final float mHue;

    /* renamed from: mJ */
    public final float f5mJ;
    public final float mJstar;

    public CamColor(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mHue = f;
        this.mChroma = f2;
        this.f5mJ = f3;
        this.mJstar = f4;
        this.mAstar = f5;
        this.mBstar = f6;
    }

    public static CamColor fromColor(int i) {
        float f;
        float pow;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        float linearized = CamUtils.linearized(Color.red(i));
        float linearized2 = CamUtils.linearized(Color.green(i));
        float linearized3 = CamUtils.linearized(Color.blue(i));
        float[][] fArr = CamUtils.SRGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f2 = (fArr2[2] * linearized3) + (fArr2[1] * linearized2) + (fArr2[0] * linearized);
        float[] fArr3 = fArr[1];
        float f3 = (fArr3[2] * linearized3) + (fArr3[1] * linearized2) + (fArr3[0] * linearized);
        float[] fArr4 = fArr[2];
        float f4 = (linearized3 * fArr4[2]) + (linearized2 * fArr4[1]) + (linearized * fArr4[0]);
        float[][] fArr5 = CamUtils.XYZ_TO_CAM16RGB;
        float[] fArr6 = fArr5[0];
        float f5 = (fArr6[2] * f4) + (fArr6[1] * f3) + (fArr6[0] * f2);
        float[] fArr7 = fArr5[1];
        float f6 = fArr7[1] * f3;
        float f7 = fArr7[2] * f4;
        float[] fArr8 = fArr5[2];
        float f8 = (f4 * fArr8[2]) + (f3 * fArr8[1]) + (f2 * fArr8[0]);
        float[] fArr9 = viewingConditions.mRgbD;
        float f9 = viewingConditions.mFlRoot;
        float f10 = viewingConditions.f6mC;
        float f11 = viewingConditions.mAw;
        float f12 = fArr9[0] * f5;
        float f13 = fArr9[1] * (f7 + f6 + (fArr7[0] * f2));
        float f14 = fArr9[2] * f8;
        float f15 = viewingConditions.mFl;
        float pow2 = (float) Math.pow((Math.abs(f12) * f15) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f13) * f15) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((Math.abs(f14) * f15) / 100.0d, 0.42d);
        float signum = ((Math.signum(f12) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f13) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f14) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d = signum3;
        float f16 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d)) / 11.0f;
        float f17 = ((float) ((signum + signum2) - (d * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = ((21.0f * signum3) + ((signum * 20.0f) + f18)) / 20.0f;
        float f20 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f21 = (3.1415927f * atan2) / 180.0f;
        float pow5 = ((float) Math.pow((f20 * viewingConditions.mNbb) / f11, viewingConditions.f8mZ * f10)) * 100.0f;
        Math.sqrt(pow5 / 100.0f);
        float f22 = f11 + 4.0f;
        if (atan2 < 20.14d) {
            f = 360.0f + atan2;
        } else {
            f = atan2;
        }
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f7mN), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.mNc) * viewingConditions.mNcb) * ((float) Math.sqrt((f17 * f17) + (f16 * f16)))) / (f19 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        Math.sqrt((pow * f10) / f22);
        float f23 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((f9 * pow6 * 0.0228f) + 1.0f)) * 43.85965f;
        double d2 = f21;
        return new CamColor(atan2, pow6, pow5, f23, log * ((float) Math.cos(d2)), log * ((float) Math.sin(d2)));
    }

    public static CamColor fromJch(float f, float f2, float f3) {
        ViewingConditions viewingConditions;
        double d;
        float f4 = ViewingConditions.DEFAULT.f6mC;
        Math.sqrt(f / 100.0d);
        Math.sqrt(((f2 / ((float) Math.sqrt(d))) * viewingConditions.f6mC) / (viewingConditions.mAw + 4.0f));
        float f5 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((viewingConditions.mFlRoot * f2 * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, f5, log * ((float) Math.cos(d2)), log * ((float) Math.sin(d2)));
    }

    public final int viewed(ViewingConditions viewingConditions) {
        float f;
        float[] fArr;
        float f2 = this.mChroma;
        float f3 = this.f5mJ;
        if (f2 != 0.0d) {
            double d = f3;
            if (d != 0.0d) {
                f = f2 / ((float) Math.sqrt(d / 100.0d));
                float f4 = viewingConditions.f7mN;
                float f5 = viewingConditions.mFl;
                float pow = (float) Math.pow(f / Math.pow(1.64d - Math.pow(0.29d, f4), 0.73d), 1.1111111111111112d);
                double d2 = (this.mHue * 3.1415927f) / 180.0f;
                float pow2 = viewingConditions.mAw * ((float) Math.pow(f3 / 100.0d, (1.0d / viewingConditions.f6mC) / viewingConditions.f8mZ));
                float cos = ((float) (Math.cos(2.0d + d2) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.mNc * viewingConditions.mNcb;
                float f6 = pow2 / viewingConditions.mNbb;
                float sin = (float) Math.sin(d2);
                float cos2 = (float) Math.cos(d2);
                float f7 = (((0.305f + f6) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (cos * 23.0f)));
                float f8 = cos2 * f7;
                float f9 = f7 * sin;
                float f10 = f6 * 460.0f;
                float f11 = ((288.0f * f9) + ((451.0f * f8) + f10)) / 1403.0f;
                float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
                float f13 = ((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f;
                float f14 = 100.0f / f5;
                float signum = Math.signum(f11) * f14 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f11) * 27.13d) / (400.0d - Math.abs(f11))), 2.380952380952381d));
                float signum2 = Math.signum(f12) * f14 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f12) * 27.13d) / (400.0d - Math.abs(f12))), 2.380952380952381d));
                float max = (float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13)));
                float[] fArr2 = viewingConditions.mRgbD;
                float f15 = signum / fArr2[0];
                float f16 = signum2 / fArr2[1];
                float signum3 = ((Math.signum(f13) * f14) * ((float) Math.pow(max, 2.380952380952381d))) / fArr2[2];
                float[][] fArr3 = CamUtils.CAM16RGB_TO_XYZ;
                float[] fArr4 = fArr3[0];
                float f17 = (fArr4[2] * signum3) + (fArr4[1] * f16) + (fArr4[0] * f15);
                float[] fArr5 = fArr3[1];
                float f18 = fArr5[1] * f16;
                float f19 = fArr5[2] * signum3;
                float f20 = f15 * fArr3[2][0];
                return ColorUtils.XYZToColor(f17, f19 + f18 + (fArr5[0] * f15), (signum3 * fArr[2]) + (f16 * fArr[1]) + f20);
            }
        }
        f = 0.0f;
        float f42 = viewingConditions.f7mN;
        float f52 = viewingConditions.mFl;
        float pow3 = (float) Math.pow(f / Math.pow(1.64d - Math.pow(0.29d, f42), 0.73d), 1.1111111111111112d);
        double d22 = (this.mHue * 3.1415927f) / 180.0f;
        float pow22 = viewingConditions.mAw * ((float) Math.pow(f3 / 100.0d, (1.0d / viewingConditions.f6mC) / viewingConditions.f8mZ));
        float cos3 = ((float) (Math.cos(2.0d + d22) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.mNc * viewingConditions.mNcb;
        float f62 = pow22 / viewingConditions.mNbb;
        float sin2 = (float) Math.sin(d22);
        float cos22 = (float) Math.cos(d22);
        float f72 = (((0.305f + f62) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (((11.0f * pow3) * cos22) + (cos3 * 23.0f)));
        float f82 = cos22 * f72;
        float f92 = f72 * sin2;
        float f102 = f62 * 460.0f;
        float f112 = ((288.0f * f92) + ((451.0f * f82) + f102)) / 1403.0f;
        float f122 = ((f102 - (891.0f * f82)) - (261.0f * f92)) / 1403.0f;
        float f132 = ((f102 - (f82 * 220.0f)) - (f92 * 6300.0f)) / 1403.0f;
        float f142 = 100.0f / f52;
        float signum4 = Math.signum(f112) * f142 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f112) * 27.13d) / (400.0d - Math.abs(f112))), 2.380952380952381d));
        float signum22 = Math.signum(f122) * f142 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f122) * 27.13d) / (400.0d - Math.abs(f122))), 2.380952380952381d));
        float max2 = (float) Math.max(0.0d, (Math.abs(f132) * 27.13d) / (400.0d - Math.abs(f132)));
        float[] fArr22 = viewingConditions.mRgbD;
        float f152 = signum4 / fArr22[0];
        float f162 = signum22 / fArr22[1];
        float signum32 = ((Math.signum(f132) * f142) * ((float) Math.pow(max2, 2.380952380952381d))) / fArr22[2];
        float[][] fArr32 = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr42 = fArr32[0];
        float f172 = (fArr42[2] * signum32) + (fArr42[1] * f162) + (fArr42[0] * f152);
        float[] fArr52 = fArr32[1];
        float f182 = fArr52[1] * f162;
        float f192 = fArr52[2] * signum32;
        float f202 = f152 * fArr32[2][0];
        return ColorUtils.XYZToColor(f172, f192 + f182 + (fArr52[0] * f152), (signum32 * fArr[2]) + (f162 * fArr[1]) + f202);
    }
}
