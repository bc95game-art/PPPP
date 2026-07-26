package androidx.vectordrawable.graphics.drawable;

import android.animation.PropertyValuesHolder;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.InflateException;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.os.BundleKt;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
/* loaded from: classes.dex */
public abstract class AndroidResources {
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY = {16842755, 16843041, 16843093, 16843097, 16843551, 16843754, 16843771, 16843778, 16843779};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_GROUP = {16842755, 16843189, 16843190, 16843556, 16843557, 16843558, 16843866, 16843867};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_PATH = {16842755, 16843780, 16843781, 16843782, 16843783, 16843784, 16843785, 16843786, 16843787, 16843788, 16843789, 16843979, 16843980, 16844062};
    public static final int[] STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH = {16842755, 16843781, 16844062};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE = {16843161};
    public static final int[] STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET = {16842755, 16843213};
    public static final int[] STYLEABLE_ANIMATOR = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    public static final int[] STYLEABLE_ANIMATOR_SET = {16843490};
    public static final int[] STYLEABLE_PROPERTY_VALUES_HOLDER = {16843486, 16843487, 16843488, 16843489};
    public static final int[] STYLEABLE_KEYFRAME = {16842788, 16843073, 16843488, 16843992};
    public static final int[] STYLEABLE_PROPERTY_ANIMATOR = {16843489, 16843781, 16843892, 16843893};

    /* JADX WARN: Code restructure failed: missing block: B:200:0x0398, code lost:
        if (r31 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x039a, code lost:
        if (r10 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x039c, code lost:
        r2 = new android.animation.Animator[r10.size()];
        r3 = r10.size();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03a7, code lost:
        if (r1 >= r3) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03a9, code lost:
        r4 = r10.get(r1);
        r1 = r1 + 1;
        r11 = r11 + 1;
        r2[r11] = (android.animation.Animator) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x03b7, code lost:
        if (r32 != 0) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03b9, code lost:
        r31.playTogether(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03bc, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03bd, code lost:
        r31.playSequentially(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03c0, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0370 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0374  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator createAnimatorFromXml(android.content.Context r26, android.content.res.Resources r27, android.content.res.Resources.Theme r28, org.xmlpull.v1.XmlPullParser r29, android.util.AttributeSet r30, android.animation.AnimatorSet r31, int r32) {
        /*
            Method dump skipped, instructions count: 961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AndroidResources.createAnimatorFromXml(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static PropertyValuesHolder getPVH(TypedArray typedArray, int i, int i2, int i3, String str) {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        ArgbEvaluator argbEvaluator;
        int i6;
        int i7;
        int i8;
        float f;
        PropertyValuesHolder ofFloat;
        float f2;
        float f3;
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i4 = peekValue.type;
        } else {
            i4 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i3);
        if (peekValue2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i5 = peekValue2.type;
        } else {
            i5 = 0;
        }
        if (i == 4) {
            if ((!z || !isColorType(i4)) && (!z2 || !isColorType(i5))) {
                i = 0;
            } else {
                i = 3;
            }
        }
        if (i == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser$PathDataNode[] createNodesFromPathData = BundleKt.createNodesFromPathData(string);
            PathParser$PathDataNode[] createNodesFromPathData2 = BundleKt.createNodesFromPathData(string2);
            if (!(createNodesFromPathData == null && createNodesFromPathData2 == null)) {
                if (createNodesFromPathData != null) {
                    FloatingActionButtonImpl.AnonymousClass4 r0 = new FloatingActionButtonImpl.AnonymousClass4(1);
                    if (createNodesFromPathData2 == null) {
                        return PropertyValuesHolder.ofObject(str, r0, createNodesFromPathData);
                    }
                    if (BundleKt.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        return PropertyValuesHolder.ofObject(str, r0, createNodesFromPathData, createNodesFromPathData2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                } else if (createNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new FloatingActionButtonImpl.AnonymousClass4(1), createNodesFromPathData2);
                }
            }
            return null;
        }
        if (i == 3) {
            argbEvaluator = ArgbEvaluator.sInstance;
        } else {
            argbEvaluator = null;
        }
        if (z3) {
            if (z) {
                if (i4 == 5) {
                    f2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i5 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i5 == 5) {
                    f = typedArray.getDimension(i3, 0.0f);
                } else {
                    f = typedArray.getFloat(i3, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i4 == 5) {
                i7 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (isColorType(i4)) {
                i7 = typedArray.getColor(i2, 0);
            } else {
                i7 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    i8 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (isColorType(i5)) {
                    i8 = typedArray.getColor(i3, 0);
                } else {
                    i8 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i7, i8);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i7);
            }
        } else if (z2) {
            if (i5 == 5) {
                i6 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (isColorType(i5)) {
                i6 = typedArray.getColor(i3, 0);
            } else {
                i6 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
        }
        if (!(propertyValuesHolder == null || argbEvaluator == null)) {
            propertyValuesHolder.setEvaluator(argbEvaluator);
        }
        return propertyValuesHolder;
    }

    public static boolean isColorType(int i) {
        if (i < 28 || i > 31) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.ValueAnimator loadAnimator(android.content.Context r20, android.content.res.Resources r21, android.content.res.Resources.Theme r22, android.util.AttributeSet r23, android.animation.ObjectAnimator r24, org.xmlpull.v1.XmlPullParser r25) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AndroidResources.loadAnimator(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.util.AttributeSet, android.animation.ObjectAnimator, org.xmlpull.v1.XmlPullParser):android.animation.ValueAnimator");
    }
}
