package androidx.dynamicanimation.animation;
/* loaded from: classes.dex */
public final class SpringForce {
    public double mDampedFreq;
    public double mDampingRatio;
    public double mFinalPosition;
    public double mGammaMinus;
    public double mGammaPlus;
    public boolean mInitialized;
    public final DynamicAnimation$MassState mMassState;
    public double mNaturalFreq;
    public double mValueThreshold;
    public double mVelocityThreshold;

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, androidx.dynamicanimation.animation.DynamicAnimation$MassState] */
    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new Object();
    }

    public final void setDampingRatio(float f) {
        if (f >= 0.0f) {
            this.mDampingRatio = f;
            this.mInitialized = false;
            return;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public final void setStiffness(float f) {
        if (f > 0.0f) {
            this.mNaturalFreq = Math.sqrt(f);
            this.mInitialized = false;
            return;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public final DynamicAnimation$MassState updateValues(double d, double d2, long j) {
        double d3;
        double d4;
        if (!this.mInitialized) {
            if (this.mFinalPosition != Double.MAX_VALUE) {
                double d5 = this.mDampingRatio;
                if (d5 > 1.0d) {
                    double d6 = this.mNaturalFreq;
                    this.mGammaPlus = (Math.sqrt((d5 * d5) - 1.0d) * d6) + ((-d5) * d6);
                    double d7 = this.mDampingRatio;
                    double d8 = this.mNaturalFreq;
                    this.mGammaMinus = ((-d7) * d8) - (Math.sqrt((d7 * d7) - 1.0d) * d8);
                } else if (d5 >= 0.0d && d5 < 1.0d) {
                    this.mDampedFreq = Math.sqrt(1.0d - (d5 * d5)) * this.mNaturalFreq;
                }
                this.mInitialized = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d9 = j / 1000.0d;
        double d10 = d - this.mFinalPosition;
        double d11 = this.mDampingRatio;
        int i = (d11 > 1.0d ? 1 : (d11 == 1.0d ? 0 : -1));
        if (i > 0) {
            double d12 = this.mGammaMinus;
            double d13 = ((d12 * d10) - d2) / (d12 - this.mGammaPlus);
            double d14 = d10 - d13;
            d3 = (Math.pow(2.718281828459045d, this.mGammaPlus * d9) * d13) + (Math.pow(2.718281828459045d, d12 * d9) * d14);
            double d15 = this.mGammaMinus;
            double pow = Math.pow(2.718281828459045d, d15 * d9) * d14 * d15;
            double d16 = this.mGammaPlus;
            d4 = (Math.pow(2.718281828459045d, d16 * d9) * d13 * d16) + pow;
        } else if (i == 0) {
            double d17 = this.mNaturalFreq;
            double d18 = (d17 * d10) + d2;
            double d19 = (d18 * d9) + d10;
            double pow2 = Math.pow(2.718281828459045d, (-d17) * d9) * d19;
            double pow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d9) * d19;
            double d20 = -this.mNaturalFreq;
            d4 = (Math.pow(2.718281828459045d, d20 * d9) * d18) + (pow3 * d20);
            d3 = pow2;
        } else {
            double d21 = 1.0d / this.mDampedFreq;
            double d22 = this.mNaturalFreq;
            double d23 = ((d11 * d22 * d10) + d2) * d21;
            d3 = ((Math.sin(this.mDampedFreq * d9) * d23) + (Math.cos(this.mDampedFreq * d9) * d10)) * Math.pow(2.718281828459045d, (-d11) * d22 * d9);
            double d24 = this.mNaturalFreq;
            double d25 = this.mDampingRatio;
            double d26 = (-d24) * d3 * d25;
            double pow4 = Math.pow(2.718281828459045d, (-d25) * d24 * d9);
            double d27 = this.mDampedFreq;
            double sin = Math.sin(d27 * d9) * (-d27) * d10;
            double d28 = this.mDampedFreq;
            d4 = (((Math.cos(d28 * d9) * d23 * d28) + sin) * pow4) + d26;
        }
        DynamicAnimation$MassState dynamicAnimation$MassState = this.mMassState;
        dynamicAnimation$MassState.mValue = (float) (d3 + this.mFinalPosition);
        dynamicAnimation$MassState.mVelocity = (float) d4;
        return dynamicAnimation$MassState;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, androidx.dynamicanimation.animation.DynamicAnimation$MassState] */
    public SpringForce(float f) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mMassState = new Object();
        this.mFinalPosition = f;
    }
}
