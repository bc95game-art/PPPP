package org.brotli.dec;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class HuffmanTreeGroup {
    public int alphabetSize;
    public Object codes;
    public Object trees;

    public HuffmanTreeGroup(int i, String str, ArrayList arrayList, ArrayList arrayList2) {
        this.alphabetSize = i;
        this.trees = str;
        this.codes = arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f8, code lost:
        if (r11 == 2) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fa, code lost:
        r16 = (int[]) r0.zzb;
        r17 = (float[]) r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0208, code lost:
        if (r10 == 1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x020a, code lost:
        if (r10 == 2) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020c, code lost:
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0219, code lost:
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x021c, code lost:
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x021f, code lost:
        r11 = new android.graphics.LinearGradient(r21, r22, r26, r27, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0223, code lost:
        r11 = new android.graphics.SweepGradient(r8, r9, (int[]) r0.zzb, (float[]) r0.zzc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0235, code lost:
        if (r25 <= 0.0f) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0237, code lost:
        r20 = (int[]) r0.zzb;
        r21 = (float[]) r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0246, code lost:
        if (r10 == 1) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0249, code lost:
        if (r10 == 2) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x024b, code lost:
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0256, code lost:
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0259, code lost:
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x025c, code lost:
        r11 = new android.graphics.RadialGradient(r8, r9, r25, r20, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0268, code lost:
        return new org.brotli.dec.HuffmanTreeGroup(r11, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0270, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01da, code lost:
        if (r13.size() <= 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01dc, code lost:
        r0 = new com.android.billingclient.api.zzcl(r13, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e2, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e3, code lost:
        if (r0 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e7, code lost:
        if (r20 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e9, code lost:
        r0 = new com.android.billingclient.api.zzcl(r6, r5, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ef, code lost:
        r0 = new com.android.billingclient.api.zzcl(r6, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f5, code lost:
        if (r11 == 1) goto L110;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HuffmanTreeGroup createFromXml(Resources resources, int i, Resources.Theme theme) {
        int next;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i2;
        int i3;
        boolean z;
        int i4;
        float f7;
        int i5;
        float f8;
        int i6;
        float f9;
        float f10;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.getClass();
            if (name.equals("gradient")) {
                String name2 = xml.getName();
                if (name2.equals("gradient")) {
                    TypedArray obtainAttributes = CamUtils.obtainAttributes(resources, theme, asAttributeSet, R$styleable.GradientColor);
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null) {
                        f = obtainAttributes.getFloat(8, 0.0f);
                    } else {
                        f = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null) {
                        f2 = obtainAttributes.getFloat(9, 0.0f);
                    } else {
                        f2 = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null) {
                        f3 = obtainAttributes.getFloat(10, 0.0f);
                    } else {
                        f3 = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null) {
                        f4 = obtainAttributes.getFloat(11, 0.0f);
                    } else {
                        f4 = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null) {
                        f5 = obtainAttributes.getFloat(3, 0.0f);
                    } else {
                        f5 = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null) {
                        f6 = obtainAttributes.getFloat(4, 0.0f);
                    } else {
                        f6 = 0.0f;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "type") != null) {
                        i2 = obtainAttributes.getInt(2, 0);
                    } else {
                        i2 = 0;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null) {
                        i3 = obtainAttributes.getColor(0, 0);
                    } else {
                        i3 = 0;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null) {
                        i4 = obtainAttributes.getColor(7, 0);
                    } else {
                        i4 = 0;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null) {
                        f7 = f;
                        i5 = obtainAttributes.getColor(1, 0);
                    } else {
                        f7 = f;
                        i5 = 0;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null) {
                        f8 = f2;
                        i6 = obtainAttributes.getInt(6, 0);
                    } else {
                        f8 = f2;
                        i6 = 0;
                    }
                    if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null) {
                        f9 = obtainAttributes.getFloat(5, 0.0f);
                    } else {
                        f9 = 0.0f;
                    }
                    obtainAttributes.recycle();
                    int depth = xml.getDepth() + 1;
                    ArrayList arrayList = new ArrayList(20);
                    float f11 = f9;
                    ArrayList arrayList2 = new ArrayList(20);
                    while (true) {
                        int next2 = xml.next();
                        float f12 = f3;
                        if (next2 == 1) {
                            f10 = f4;
                            break;
                        }
                        int depth2 = xml.getDepth();
                        f10 = f4;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                            TypedArray obtainAttributes2 = CamUtils.obtainAttributes(resources, theme, asAttributeSet, R$styleable.GradientColorItem);
                            boolean hasValue = obtainAttributes2.hasValue(0);
                            boolean hasValue2 = obtainAttributes2.hasValue(1);
                            if (!hasValue || !hasValue2) {
                                break;
                            }
                            int color = obtainAttributes2.getColor(0, 0);
                            float f13 = obtainAttributes2.getFloat(1, 0.0f);
                            obtainAttributes2.recycle();
                            arrayList2.add(Integer.valueOf(color));
                            arrayList.add(Float.valueOf(f13));
                        }
                        f3 = f12;
                        f4 = f10;
                    }
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
            } else if (name.equals("selector")) {
                ColorStateList createFromXmlInner = ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme);
                return new HuffmanTreeGroup(null, createFromXmlInner, createFromXmlInner.getDefaultColor());
            } else {
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        } else {
            throw new XmlPullParserException("No start tag found");
        }
    }

    public static void decode(HuffmanTreeGroup huffmanTreeGroup, BitReader bitReader) {
        int length = ((int[]) huffmanTreeGroup.trees).length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            ((int[]) huffmanTreeGroup.trees)[i2] = i;
            Utils.readHuffmanCode(huffmanTreeGroup.alphabetSize, (int[]) huffmanTreeGroup.codes, i, bitReader);
            i += 1080;
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        if (((Shader) this.codes) != null || (colorStateList = (ColorStateList) this.trees) == null || !colorStateList.isStateful()) {
            return false;
        }
        return true;
    }

    public HuffmanTreeGroup(Shader shader, ColorStateList colorStateList, int i) {
        this.codes = shader;
        this.trees = colorStateList;
        this.alphabetSize = i;
    }
}
