package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import androidx.core.content.res.CamUtils;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.p002os.BundleKt;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
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
    */
    public static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr;
        String str;
        int i3;
        AttributeSet attributeSet2;
        PropertyValuesHolder propertyValuesHolder;
        int size;
        float fraction;
        int i4;
        int i5;
        int i6;
        Keyframe ofObject;
        Keyframe keyframe;
        String str2;
        int i7;
        Keyframe keyframe2;
        Resources.Theme theme2;
        int i8;
        AttributeSet attributeSet3;
        Resources resources2;
        XmlPullParser xmlPullParser2;
        ObjectAnimator objectAnimator;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i9 = 3;
            boolean z = false;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i10 = 1;
            if (next == 1) {
                break;
            }
            int i11 = 2;
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator2 = new ObjectAnimator();
                    loadAnimator(context, resources, theme, attributeSet, objectAnimator2, xmlPullParser);
                    objectAnimator = objectAnimator2;
                } else if (name.equals("animator")) {
                    objectAnimator = loadAnimator(context, resources, theme, attributeSet, null, xmlPullParser);
                } else {
                    Resources resources3 = resources;
                    Resources.Theme theme3 = theme;
                    XmlPullParser xmlPullParser3 = xmlPullParser;
                    if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainAttributes = CamUtils.obtainAttributes(resources3, theme3, attributeSet, STYLEABLE_ANIMATOR_SET);
                        if (xmlPullParser3.getAttributeValue("http://schemas.android.com/apk/res/android", "ordering") != null) {
                            theme2 = theme3;
                            i8 = obtainAttributes.getInt(0, 0);
                            attributeSet3 = attributeSet;
                            xmlPullParser2 = xmlPullParser3;
                            resources2 = resources3;
                        } else {
                            theme2 = theme3;
                            i8 = 0;
                            attributeSet3 = attributeSet;
                            resources2 = resources3;
                            xmlPullParser2 = xmlPullParser3;
                        }
                        createAnimatorFromXml(context, resources2, theme2, xmlPullParser2, attributeSet3, animatorSet2, i8);
                        valueAnimator = animatorSet2;
                        obtainAttributes.recycle();
                        i2 = depth;
                        if (animatorSet != null && !z) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(valueAnimator);
                        }
                        depth = i2;
                    } else {
                        String str3 = "propertyValuesHolder";
                        if (name.equals(str3)) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser3);
                            ArrayList arrayList2 = null;
                            while (true) {
                                int eventType = xmlPullParser3.getEventType();
                                if (eventType == i9 || eventType == i10) {
                                    break;
                                } else if (eventType != i11) {
                                    xmlPullParser3.next();
                                } else {
                                    if (xmlPullParser3.getName().equals(str3)) {
                                        TypedArray obtainAttributes2 = CamUtils.obtainAttributes(resources3, theme3, asAttributeSet, STYLEABLE_PROPERTY_VALUES_HOLDER);
                                        String namedString = CamUtils.getNamedString(obtainAttributes2, xmlPullParser3, "propertyName", i9);
                                        int i12 = xmlPullParser3.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null ? obtainAttributes2.getInt(i11, 4) : 4;
                                        attributeSet2 = asAttributeSet;
                                        int i13 = i12;
                                        ArrayList arrayList3 = null;
                                        while (true) {
                                            int next2 = xmlPullParser3.next();
                                            i3 = depth;
                                            if (next2 == 3 || next2 == 1) {
                                                break;
                                            }
                                            if (xmlPullParser3.getName().equals("keyframe")) {
                                                int[] iArr = STYLEABLE_KEYFRAME;
                                                str2 = str3;
                                                if (i13 == 4) {
                                                    TypedArray obtainAttributes3 = CamUtils.obtainAttributes(resources3, theme3, Xml.asAttributeSet(xmlPullParser3), iArr);
                                                    TypedValue peekValue = !CamUtils.hasAttribute(xmlPullParser3, "value") ? null : obtainAttributes3.peekValue(0);
                                                    int i14 = (peekValue == null || !isColorType(peekValue.type)) ? 0 : 3;
                                                    obtainAttributes3.recycle();
                                                    i13 = i14;
                                                }
                                                TypedArray obtainAttributes4 = CamUtils.obtainAttributes(resources3, theme3, Xml.asAttributeSet(xmlPullParser3), iArr);
                                                float f = -1.0f;
                                                if (CamUtils.hasAttribute(xmlPullParser3, "fraction")) {
                                                    f = obtainAttributes4.getFloat(3, -1.0f);
                                                }
                                                TypedValue peekValue2 = !CamUtils.hasAttribute(xmlPullParser3, "value") ? null : obtainAttributes4.peekValue(0);
                                                boolean z2 = peekValue2 != null;
                                                if (i13 == 4) {
                                                    i7 = (!z2 || !isColorType(peekValue2.type)) ? 0 : 3;
                                                } else {
                                                    i7 = i13;
                                                }
                                                if (z2) {
                                                    if (i7 == 0) {
                                                        keyframe2 = Keyframe.ofFloat(f, xmlPullParser3.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? obtainAttributes4.getFloat(0, 0.0f) : 0.0f);
                                                    } else if (i7 == 1 || i7 == 3) {
                                                        keyframe2 = Keyframe.ofInt(f, xmlPullParser3.getAttributeValue("http://schemas.android.com/apk/res/android", "value") != null ? obtainAttributes4.getInt(0, 0) : 0);
                                                    } else {
                                                        keyframe2 = null;
                                                    }
                                                } else if (i7 == 0) {
                                                    keyframe2 = Keyframe.ofFloat(f);
                                                } else {
                                                    keyframe2 = Keyframe.ofInt(f);
                                                }
                                                int resourceId = xmlPullParser3.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null ? obtainAttributes4.getResourceId(1, 0) : 0;
                                                if (resourceId > 0) {
                                                    keyframe2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                                }
                                                obtainAttributes4.recycle();
                                                if (keyframe2 != null) {
                                                    if (arrayList3 == null) {
                                                        arrayList3 = new ArrayList();
                                                    }
                                                    arrayList3.add(keyframe2);
                                                }
                                                xmlPullParser3.next();
                                            } else {
                                                str2 = str3;
                                            }
                                            resources3 = resources;
                                            theme3 = theme;
                                            depth = i3;
                                            str3 = str2;
                                        }
                                        str = str3;
                                        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                            propertyValuesHolder = null;
                                        } else {
                                            Keyframe keyframe3 = (Keyframe) arrayList3.get(0);
                                            Keyframe keyframe4 = (Keyframe) arrayList3.get(size - 1);
                                            float fraction2 = keyframe4.getFraction();
                                            int i15 = size;
                                            Class cls = Integer.TYPE;
                                            Class cls2 = Float.TYPE;
                                            if (fraction2 < 1.0f) {
                                                if (fraction2 < 0.0f) {
                                                    keyframe4.setFraction(1.0f);
                                                } else {
                                                    int size2 = arrayList3.size();
                                                    if (keyframe4.getType() == cls2) {
                                                        keyframe = Keyframe.ofFloat(1.0f);
                                                    } else if (keyframe4.getType() == cls) {
                                                        keyframe = Keyframe.ofInt(1.0f);
                                                    } else {
                                                        keyframe = Keyframe.ofObject(1.0f);
                                                    }
                                                    arrayList3.add(size2, keyframe);
                                                    i15++;
                                                    fraction = keyframe3.getFraction();
                                                    if (fraction != 0.0f) {
                                                        if (fraction < 0.0f) {
                                                            keyframe3.setFraction(0.0f);
                                                        } else {
                                                            if (keyframe3.getType() == cls2) {
                                                                ofObject = Keyframe.ofFloat(0.0f);
                                                            } else if (keyframe3.getType() == cls) {
                                                                ofObject = Keyframe.ofInt(0.0f);
                                                            } else {
                                                                ofObject = Keyframe.ofObject(0.0f);
                                                            }
                                                            arrayList3.add(0, ofObject);
                                                            i15++;
                                                        }
                                                    }
                                                    i4 = i15;
                                                    Keyframe[] keyframeArr = new Keyframe[i4];
                                                    arrayList3.toArray(keyframeArr);
                                                    i5 = 0;
                                                    while (i5 < i4) {
                                                        Keyframe keyframe5 = keyframeArr[i5];
                                                        if (keyframe5.getFraction() < 0.0f) {
                                                            if (i5 == 0) {
                                                                keyframe5.setFraction(0.0f);
                                                            } else {
                                                                int i16 = i4 - 1;
                                                                if (i5 == i16) {
                                                                    keyframe5.setFraction(1.0f);
                                                                } else {
                                                                    int i17 = i5 + 1;
                                                                    int i18 = i5;
                                                                    while (i17 < i16 && keyframeArr[i17].getFraction() < 0.0f) {
                                                                        i17++;
                                                                        i18 = i17;
                                                                    }
                                                                    float fraction3 = (keyframeArr[i18 + 1].getFraction() - keyframeArr[i5 - 1].getFraction()) / ((i18 - i5) + 2);
                                                                    for (int i19 = i5; i19 <= i18; i19++) {
                                                                        i4 = i4;
                                                                        keyframeArr[i19].setFraction(keyframeArr[i19 - 1].getFraction() + fraction3);
                                                                    }
                                                                    i6 = i4;
                                                                    i5++;
                                                                    i4 = i6;
                                                                }
                                                            }
                                                        }
                                                        i6 = i4;
                                                        i5++;
                                                        i4 = i6;
                                                    }
                                                    propertyValuesHolder = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr);
                                                    if (i13 == 3) {
                                                        propertyValuesHolder.setEvaluator(ArgbEvaluator.sInstance);
                                                    }
                                                }
                                            }
                                            fraction = keyframe3.getFraction();
                                            if (fraction != 0.0f) {
                                            }
                                            i4 = i15;
                                            Keyframe[] keyframeArr2 = new Keyframe[i4];
                                            arrayList3.toArray(keyframeArr2);
                                            i5 = 0;
                                            while (i5 < i4) {
                                            }
                                            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr2);
                                            if (i13 == 3) {
                                            }
                                        }
                                        if (propertyValuesHolder == null) {
                                            propertyValuesHolder = getPVH(obtainAttributes2, i12, 0, 1, namedString);
                                        }
                                        if (propertyValuesHolder != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(propertyValuesHolder);
                                        }
                                        obtainAttributes2.recycle();
                                    } else {
                                        attributeSet2 = asAttributeSet;
                                        i3 = depth;
                                        str = str3;
                                    }
                                    xmlPullParser.next();
                                    resources3 = resources;
                                    theme3 = theme;
                                    xmlPullParser3 = xmlPullParser;
                                    asAttributeSet = attributeSet2;
                                    depth = i3;
                                    str3 = str;
                                    i9 = 3;
                                    i10 = 1;
                                    i11 = 2;
                                }
                            }
                            i2 = depth;
                            if (arrayList2 != null) {
                                int size3 = arrayList2.size();
                                propertyValuesHolderArr = new PropertyValuesHolder[size3];
                                for (int i20 = 0; i20 < size3; i20++) {
                                    propertyValuesHolderArr[i20] = (PropertyValuesHolder) arrayList2.get(i20);
                                }
                            } else {
                                propertyValuesHolderArr = null;
                            }
                            if (propertyValuesHolderArr != null && (valueAnimator instanceof ValueAnimator)) {
                                valueAnimator.setValues(propertyValuesHolderArr);
                            }
                            z = true;
                            if (animatorSet != null) {
                                if (arrayList == null) {
                                }
                                arrayList.add(valueAnimator);
                            }
                            depth = i2;
                        } else {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                    }
                }
                valueAnimator = objectAnimator;
                i2 = depth;
                if (animatorSet != null) {
                }
                depth = i2;
            }
        }
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
                    FloatingActionButtonImpl.C01874 r0 = new FloatingActionButtonImpl.C01874(1);
                    if (createNodesFromPathData2 == null) {
                        return PropertyValuesHolder.ofObject(str, r0, createNodesFromPathData);
                    }
                    if (BundleKt.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        return PropertyValuesHolder.ofObject(str, r0, createNodesFromPathData, createNodesFromPathData2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                } else if (createNodesFromPathData2 != null) {
                    return PropertyValuesHolder.ofObject(str, new FloatingActionButtonImpl.C01874(1), createNodesFromPathData2);
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
    */
    public static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator;
        int i;
        int i2;
        int i3;
        int i4;
        ValueAnimator valueAnimator2;
        int i5;
        int i6;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        boolean z;
        int i7;
        boolean z2;
        int i8;
        TypedArray obtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_ANIMATOR);
        TypedArray obtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSet, STYLEABLE_PROPERTY_ANIMATOR);
        if (objectAnimator == null) {
            valueAnimator = new ValueAnimator();
        } else {
            valueAnimator = objectAnimator;
        }
        int i9 = 300;
        if (CamUtils.hasAttribute(xmlPullParser, "duration")) {
            i9 = obtainAttributes.getInt(1, 300);
        }
        long j = i9;
        boolean z3 = false;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null) {
            i = obtainAttributes.getInt(2, 0);
        } else {
            i = 0;
        }
        long j2 = i;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null) {
            i2 = obtainAttributes.getInt(7, 4);
        } else {
            i2 = 4;
        }
        if (!(xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") == null || xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") == null)) {
            if (i2 == 4) {
                TypedValue peekValue = obtainAttributes.peekValue(5);
                if (peekValue != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i7 = peekValue.type;
                } else {
                    i7 = 0;
                }
                TypedValue peekValue2 = obtainAttributes.peekValue(6);
                if (peekValue2 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    i8 = peekValue2.type;
                } else {
                    i8 = 0;
                }
                if ((!z || !isColorType(i7)) && (!z2 || !isColorType(i8))) {
                    i2 = 0;
                } else {
                    i2 = 3;
                }
            }
            PropertyValuesHolder pvh = getPVH(obtainAttributes, i2, 5, 6, "");
            if (pvh != null) {
                valueAnimator.setValues(pvh);
            }
        }
        valueAnimator.setDuration(j);
        valueAnimator.setStartDelay(j2);
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null) {
            i3 = obtainAttributes.getInt(3, 0);
        } else {
            i3 = 0;
        }
        valueAnimator.setRepeatCount(i3);
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null) {
            i4 = obtainAttributes.getInt(4, 1);
        } else {
            i4 = 1;
        }
        valueAnimator.setRepeatMode(i4);
        if (obtainAttributes2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator;
            String namedString = CamUtils.getNamedString(obtainAttributes2, xmlPullParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = CamUtils.getNamedString(obtainAttributes2, xmlPullParser, "propertyXName", 2);
                String namedString3 = CamUtils.getNamedString(obtainAttributes2, xmlPullParser, "propertyYName", 3);
                if (i2 != 2) {
                }
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(obtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path createPathFromPathData = BundleKt.createPathFromPathData(namedString);
                PathMeasure pathMeasure = new PathMeasure(createPathFromPathData, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f = 0.0f;
                while (true) {
                    f += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f));
                    if (!pathMeasure.nextContour()) {
                        break;
                    }
                    z3 = false;
                }
                PathMeasure pathMeasure2 = new PathMeasure(createPathFromPathData, z3);
                int min = Math.min(100, ((int) (f / 0.5f)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f2 = f / (min - 1);
                valueAnimator2 = valueAnimator;
                float f3 = 0.0f;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    propertyValuesHolder = null;
                    if (i10 >= min) {
                        break;
                    }
                    int i12 = min;
                    pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i11)).floatValue(), fArr3, null);
                    fArr[i10] = fArr3[0];
                    fArr2[i10] = fArr3[1];
                    int i13 = i11 + 1;
                    f3 += f2;
                    if (i13 < arrayList.size() && f3 > ((Float) arrayList.get(i13)).floatValue()) {
                        pathMeasure2.nextContour();
                        i11 = i13;
                    }
                    i10++;
                    min = i12;
                }
                if (namedString2 != null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(namedString2, fArr);
                } else {
                    propertyValuesHolder2 = null;
                }
                if (namedString3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(namedString3, fArr2);
                }
                if (propertyValuesHolder2 == null) {
                    objectAnimator2.setValues(propertyValuesHolder);
                } else if (propertyValuesHolder == null) {
                    objectAnimator2.setValues(propertyValuesHolder2);
                } else {
                    objectAnimator2.setValues(propertyValuesHolder2, propertyValuesHolder);
                }
            } else {
                valueAnimator2 = valueAnimator;
                i5 = 0;
                objectAnimator2.setPropertyName(CamUtils.getNamedString(obtainAttributes2, xmlPullParser, "propertyName", 0));
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") == null) {
                    i6 = obtainAttributes.getResourceId(i5, i5);
                } else {
                    i6 = 0;
                }
                if (i6 <= 0) {
                    valueAnimator3 = valueAnimator2;
                    valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i6));
                } else {
                    valueAnimator3 = valueAnimator2;
                }
                obtainAttributes.recycle();
                if (obtainAttributes2 != null) {
                    obtainAttributes2.recycle();
                }
                return valueAnimator3;
            }
        } else {
            valueAnimator2 = valueAnimator;
        }
        i5 = 0;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") == null) {
        }
        if (i6 <= 0) {
        }
        obtainAttributes.recycle();
        if (obtainAttributes2 != null) {
        }
        return valueAnimator3;
    }
}
