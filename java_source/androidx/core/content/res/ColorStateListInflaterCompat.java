package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.p002os.BundleKt;
import com.emanuelef.remote_capture.C0130R;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public abstract class ColorStateListInflaterCompat {
    public static final ThreadLocal sTempTypedValue = new ThreadLocal();

    public static ColorStateList createFromXml(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlResourceParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0137  */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i;
        float f;
        float f2;
        int attributeCount;
        int i2;
        boolean z;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        float f3;
        TypedValue typedValue;
        int i7;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            ?? r4 = 1;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr2 = new int[20];
            int[] iArr3 = new int[20];
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == r4 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                } else if (next != 2 || depth > depth2 || !xmlPullParser.getName().equals("item")) {
                    depth2 = depth2;
                    resources2 = resources;
                    attributeSet2 = attributeSet;
                    theme2 = theme;
                    r4 = 1;
                    i8 = 0;
                } else {
                    int[] iArr4 = R$styleable.ColorStateListItem;
                    TypedArray obtainAttributes = theme2 == null ? resources2.obtainAttributes(attributeSet2, iArr4) : theme2.obtainStyledAttributes(attributeSet2, iArr4, i8, i8);
                    int resourceId = obtainAttributes.getResourceId(i8, -1);
                    if (resourceId != -1) {
                        ThreadLocal threadLocal = sTempTypedValue;
                        TypedValue typedValue2 = (TypedValue) threadLocal.get();
                        if (typedValue2 == null) {
                            typedValue = new TypedValue();
                            threadLocal.set(typedValue);
                        } else {
                            typedValue = typedValue2;
                        }
                        resources2.getValue(resourceId, typedValue, r4);
                        int i10 = typedValue.type;
                        if (i10 < 28 || i10 > 31) {
                            try {
                                i = createFromXml(resources2, resources2.getXml(resourceId), theme2).getDefaultColor();
                            } catch (Exception unused) {
                                i = obtainAttributes.getColor(i8, -65281);
                            }
                            i7 = r4 == true ? 1 : 0;
                            int i11 = r4 == true ? 1 : 0;
                            int i12 = r4 == true ? 1 : 0;
                            int i13 = r4 == true ? 1 : 0;
                            if (!obtainAttributes.hasValue(i7)) {
                                f = obtainAttributes.getFloat(r4, 1.0f);
                            } else {
                                f = obtainAttributes.hasValue(3) ? obtainAttributes.getFloat(3, 1.0f) : 1.0f;
                            }
                            if (Build.VERSION.SDK_INT >= 31 || !obtainAttributes.hasValue(2)) {
                                f2 = obtainAttributes.getFloat(4, -1.0f);
                            } else {
                                f2 = obtainAttributes.getFloat(2, -1.0f);
                            }
                            obtainAttributes.recycle();
                            attributeCount = attributeSet2.getAttributeCount();
                            int[] iArr5 = new int[attributeCount];
                            int i14 = 0;
                            for (i2 = 0; i2 < attributeCount; i2++) {
                                int attributeNameResource = attributeSet2.getAttributeNameResource(i2);
                                if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == C0130R.attr.alpha || attributeNameResource == C0130R.attr.lStar)) {
                                    i14++;
                                    if (!attributeSet2.getAttributeBooleanValue(i2, false)) {
                                        attributeNameResource = -attributeNameResource;
                                    }
                                    iArr5[i14] = attributeNameResource;
                                }
                            }
                            int[] trimStateSet = StateSet.trimStateSet(iArr5, i14);
                            z = f2 < 0.0f && f2 <= 100.0f;
                            if (f == 1.0f || z) {
                                int clamp = BundleKt.clamp((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
                                if (!z) {
                                    CamColor fromColor = CamColor.fromColor(i);
                                    float f4 = fromColor.mHue;
                                    float f5 = fromColor.mChroma;
                                    ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
                                    if (f5 < 1.0d || Math.round(f2) <= 0.0d || Math.round(f2) >= 100.0d) {
                                        iArr = trimStateSet;
                                        i3 = depth2;
                                        i5 = CamUtils.intFromLStar(f2);
                                    } else {
                                        float min = f4 < 0.0f ? 0.0f : Math.min(360.0f, f4);
                                        float f6 = f5;
                                        CamColor camColor = null;
                                        boolean z2 = true;
                                        float f7 = 0.0f;
                                        while (true) {
                                            if (Math.abs(f7 - f5) >= 0.4f) {
                                                float f8 = 1000.0f;
                                                float f9 = 1000.0f;
                                                float f10 = 0.0f;
                                                float f11 = 100.0f;
                                                CamColor camColor2 = null;
                                                while (true) {
                                                    if (Math.abs(f10 - f11) <= 0.01f) {
                                                        iArr = trimStateSet;
                                                        i3 = depth2;
                                                        break;
                                                    }
                                                    float f12 = ((f11 - f10) / 2.0f) + f10;
                                                    iArr = trimStateSet;
                                                    int viewed = CamColor.fromJch(f12, f6, min).viewed(ViewingConditions.DEFAULT);
                                                    float linearized = CamUtils.linearized(Color.red(viewed));
                                                    float linearized2 = CamUtils.linearized(Color.green(viewed));
                                                    float linearized3 = CamUtils.linearized(Color.blue(viewed));
                                                    float[] fArr = CamUtils.SRGB_TO_XYZ[1];
                                                    float f13 = ((linearized3 * fArr[2]) + ((linearized2 * fArr[1]) + (linearized * fArr[0]))) / 100.0f;
                                                    if (f13 <= 0.008856452f) {
                                                        f3 = f13 * 903.2963f;
                                                        i6 = viewed;
                                                    } else {
                                                        i6 = viewed;
                                                        f3 = (((float) Math.cbrt(f13)) * 116.0f) - 16.0f;
                                                    }
                                                    float abs = Math.abs(f2 - f3);
                                                    if (abs < 0.2f) {
                                                        CamColor fromColor2 = CamColor.fromColor(i6);
                                                        CamColor fromJch = CamColor.fromJch(fromColor2.f5mJ, fromColor2.mChroma, min);
                                                        float f14 = fromColor2.mJstar - fromJch.mJstar;
                                                        float f15 = fromColor2.mAstar - fromJch.mAstar;
                                                        float f16 = fromColor2.mBstar - fromJch.mBstar;
                                                        i3 = depth2;
                                                        float pow = (float) (Math.pow(Math.sqrt((f16 * f16) + (f15 * f15) + (f14 * f14)), 0.63d) * 1.41d);
                                                        if (pow <= 1.0f) {
                                                            f9 = pow;
                                                            f8 = abs;
                                                            camColor2 = fromColor2;
                                                        }
                                                    } else {
                                                        i3 = depth2;
                                                    }
                                                    if (f8 == 0.0f && f9 == 0.0f) {
                                                        break;
                                                    }
                                                    if (f3 < f2) {
                                                        f10 = f12;
                                                    } else {
                                                        f11 = f12;
                                                    }
                                                    trimStateSet = iArr;
                                                    depth2 = i3;
                                                }
                                                CamColor camColor3 = camColor2;
                                                if (!z2) {
                                                    if (camColor3 == null) {
                                                        f5 = f6;
                                                    } else {
                                                        camColor = camColor3;
                                                        f7 = f6;
                                                    }
                                                    f6 = ((f5 - f7) / 2.0f) + f7;
                                                    trimStateSet = iArr;
                                                    depth2 = i3;
                                                } else if (camColor3 != null) {
                                                    i5 = camColor3.viewed(viewingConditions);
                                                    break;
                                                } else {
                                                    f6 = ((f5 - f7) / 2.0f) + f7;
                                                    trimStateSet = iArr;
                                                    depth2 = i3;
                                                    z2 = false;
                                                }
                                            } else {
                                                iArr = trimStateSet;
                                                i3 = depth2;
                                                if (camColor == null) {
                                                    i5 = CamUtils.intFromLStar(f2);
                                                } else {
                                                    i5 = camColor.viewed(viewingConditions);
                                                }
                                            }
                                        }
                                    }
                                    i = i5;
                                } else {
                                    iArr = trimStateSet;
                                    i3 = depth2;
                                }
                                i = (16777215 & i) | (clamp << 24);
                            } else {
                                iArr = trimStateSet;
                                i3 = depth2;
                            }
                            i4 = i9 + 1;
                            int i15 = 8;
                            if (i4 > iArr3.length) {
                                int[] iArr6 = new int[i9 <= 4 ? 8 : i9 * 2];
                                System.arraycopy(iArr3, 0, iArr6, 0, i9);
                                iArr3 = iArr6;
                            }
                            iArr3[i9] = i;
                            if (i4 > iArr2.length) {
                                Class<?> componentType = iArr2.getClass().getComponentType();
                                if (i9 > 4) {
                                    i15 = i9 * 2;
                                }
                                ?? r1 = (Object[]) Array.newInstance(componentType, i15);
                                System.arraycopy(iArr2, 0, r1, 0, i9);
                                iArr2 = r1;
                            }
                            iArr2[i9] = iArr;
                            iArr2 = iArr2;
                            attributeSet2 = attributeSet;
                            theme2 = theme;
                            i9 = i4;
                            depth2 = i3;
                            r4 = 1;
                            i8 = 0;
                            resources2 = resources;
                        }
                    }
                    i = obtainAttributes.getColor(i8, -65281);
                    i7 = r4 == true ? 1 : 0;
                    int i112 = r4 == true ? 1 : 0;
                    int i122 = r4 == true ? 1 : 0;
                    int i132 = r4 == true ? 1 : 0;
                    if (!obtainAttributes.hasValue(i7)) {
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                    }
                    f2 = obtainAttributes.getFloat(4, -1.0f);
                    obtainAttributes.recycle();
                    attributeCount = attributeSet2.getAttributeCount();
                    int[] iArr52 = new int[attributeCount];
                    int i142 = 0;
                    while (i2 < attributeCount) {
                    }
                    int[] trimStateSet2 = StateSet.trimStateSet(iArr52, i142);
                    if (f2 < 0.0f) {
                    }
                    if (f == 1.0f) {
                    }
                    int clamp2 = BundleKt.clamp((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
                    if (!z) {
                    }
                    i = (16777215 & i) | (clamp2 << 24);
                    i4 = i9 + 1;
                    int i152 = 8;
                    if (i4 > iArr3.length) {
                    }
                    iArr3[i9] = i;
                    if (i4 > iArr2.length) {
                    }
                    iArr2[i9] = iArr;
                    iArr2 = iArr2;
                    attributeSet2 = attributeSet;
                    theme2 = theme;
                    i9 = i4;
                    depth2 = i3;
                    r4 = 1;
                    i8 = 0;
                    resources2 = resources;
                }
            }
            int[] iArr7 = new int[i9];
            int[][] iArr8 = new int[i9];
            System.arraycopy(iArr3, 0, iArr7, 0, i9);
            System.arraycopy(iArr2, 0, iArr8, 0, i9);
            return new ColorStateList(iArr8, iArr7);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }
}
