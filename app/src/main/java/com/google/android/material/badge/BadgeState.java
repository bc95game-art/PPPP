package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.emanuelef.remote_capture.R;
import com.google.android.gms.common.zzc;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import java.io.IOException;
import java.util.Locale;
import kotlin.LazyKt__LazyJVMKt;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class BadgeState {
    public final int badgeFixedEdge;
    public final float badgeHeight;
    public final float badgeRadius;
    public final float badgeWidth;
    public final float badgeWithTextHeight;
    public final float badgeWithTextRadius;
    public final float badgeWithTextWidth;
    public final State currentState = new State();
    public final int horizontalInset;
    public final int horizontalInsetWithText;
    public final int offsetAlignmentMode;
    public final State overridingState;

    /* loaded from: classes.dex */
    public final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new zzc(1);
        public Integer additionalHorizontalOffset;
        public Integer additionalVerticalOffset;
        public Boolean autoAdjustToWithinGrandparentBounds;
        public Integer backgroundColor;
        public Integer badgeFixedEdge;
        public Integer badgeGravity;
        public Integer badgeHorizontalPadding;
        public int badgeResId;
        public Integer badgeShapeAppearanceOverlayResId;
        public Integer badgeShapeAppearanceResId;
        public Integer badgeTextAppearanceResId;
        public Integer badgeTextColor;
        public Integer badgeVerticalPadding;
        public Integer badgeWithTextShapeAppearanceOverlayResId;
        public Integer badgeWithTextShapeAppearanceResId;
        public int contentDescriptionExceedsMaxBadgeNumberRes;
        public CharSequence contentDescriptionForText;
        public CharSequence contentDescriptionNumberless;
        public int contentDescriptionQuantityStrings;
        public Integer horizontalOffsetWithText;
        public Integer horizontalOffsetWithoutText;
        public Integer largeFontVerticalOffsetAdjustment;
        public Locale numberLocale;
        public String text;
        public Integer verticalOffsetWithText;
        public Integer verticalOffsetWithoutText;
        public int alpha = 255;
        public int number = -2;
        public int maxCharacterCount = -2;
        public int maxNumber = -2;
        public Boolean isVisible = Boolean.TRUE;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            String str;
            parcel.writeInt(this.badgeResId);
            parcel.writeSerializable(this.backgroundColor);
            parcel.writeSerializable(this.badgeTextColor);
            parcel.writeSerializable(this.badgeTextAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceResId);
            parcel.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            parcel.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            parcel.writeInt(this.alpha);
            parcel.writeString(this.text);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeInt(this.maxNumber);
            CharSequence charSequence = this.contentDescriptionForText;
            String str2 = null;
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
            CharSequence charSequence2 = this.contentDescriptionNumberless;
            if (charSequence2 != null) {
                str2 = charSequence2.toString();
            }
            parcel.writeString(str2);
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeSerializable(this.badgeGravity);
            parcel.writeSerializable(this.badgeHorizontalPadding);
            parcel.writeSerializable(this.badgeVerticalPadding);
            parcel.writeSerializable(this.horizontalOffsetWithoutText);
            parcel.writeSerializable(this.verticalOffsetWithoutText);
            parcel.writeSerializable(this.horizontalOffsetWithText);
            parcel.writeSerializable(this.verticalOffsetWithText);
            parcel.writeSerializable(this.largeFontVerticalOffsetAdjustment);
            parcel.writeSerializable(this.additionalHorizontalOffset);
            parcel.writeSerializable(this.additionalVerticalOffset);
            parcel.writeSerializable(this.isVisible);
            parcel.writeSerializable(this.numberLocale);
            parcel.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
            parcel.writeSerializable(this.badgeFixedEdge);
        }
    }

    public BadgeState(Context context) {
        AttributeSet attributeSet;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z2;
        Locale locale;
        int i19;
        int next;
        State state = new State();
        int i20 = state.badgeResId;
        int i21 = 1;
        if (i20 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i20);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                } else if (TextUtils.equals(xml.getName(), "badge")) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    attributeSet = asAttributeSet;
                    i = asAttributeSet.getStyleAttribute();
                } else {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i20));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            i = 0;
        }
        if (i == 0) {
            i2 = R.style.Widget_MaterialComponents_Badge;
        } else {
            i2 = i;
        }
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(context, attributeSet, R$styleable.Badge, R.attr.badgeStyle, i2, new int[0]);
        Resources resources = context.getResources();
        this.badgeRadius = obtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.horizontalInset = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = obtainStyledAttributes.getDimensionPixelSize(15, -1);
        this.badgeWidth = obtainStyledAttributes.getDimension(13, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextWidth = obtainStyledAttributes.getDimension(18, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.badgeHeight = obtainStyledAttributes.getDimension(4, resources.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextHeight = obtainStyledAttributes.getDimension(14, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.offsetAlignmentMode = obtainStyledAttributes.getInt(25, 1);
        this.badgeFixedEdge = obtainStyledAttributes.getInt(2, 0);
        State state2 = this.currentState;
        int i22 = state.alpha;
        state2.alpha = i22 == -2 ? 255 : i22;
        int i23 = state.number;
        if (i23 != -2) {
            state2.number = i23;
        } else if (obtainStyledAttributes.hasValue(24)) {
            this.currentState.number = obtainStyledAttributes.getInt(24, 0);
        } else {
            this.currentState.number = -1;
        }
        String str = state.text;
        if (str != null) {
            this.currentState.text = str;
        } else if (obtainStyledAttributes.hasValue(8)) {
            this.currentState.text = obtainStyledAttributes.getString(8);
        }
        State state3 = this.currentState;
        state3.contentDescriptionForText = state.contentDescriptionForText;
        CharSequence charSequence = state.contentDescriptionNumberless;
        state3.contentDescriptionNumberless = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        State state4 = this.currentState;
        int i24 = state.contentDescriptionQuantityStrings;
        state4.contentDescriptionQuantityStrings = i24 == 0 ? R.plurals.mtrl_badge_content_description : i24;
        int i25 = state.contentDescriptionExceedsMaxBadgeNumberRes;
        state4.contentDescriptionExceedsMaxBadgeNumberRes = i25 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i25;
        Boolean bool = state.isVisible;
        if (bool == null || bool.booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        state4.isVisible = Boolean.valueOf(z);
        State state5 = this.currentState;
        int i26 = state.maxCharacterCount;
        state5.maxCharacterCount = i26 == -2 ? obtainStyledAttributes.getInt(22, -2) : i26;
        State state6 = this.currentState;
        int i27 = state.maxNumber;
        state6.maxNumber = i27 == -2 ? obtainStyledAttributes.getInt(23, -2) : i27;
        State state7 = this.currentState;
        Integer num = state.badgeShapeAppearanceResId;
        if (num == null) {
            i3 = obtainStyledAttributes.getResourceId(6, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        } else {
            i3 = num.intValue();
        }
        state7.badgeShapeAppearanceResId = Integer.valueOf(i3);
        State state8 = this.currentState;
        Integer num2 = state.badgeShapeAppearanceOverlayResId;
        if (num2 == null) {
            i4 = obtainStyledAttributes.getResourceId(7, 0);
        } else {
            i4 = num2.intValue();
        }
        state8.badgeShapeAppearanceOverlayResId = Integer.valueOf(i4);
        State state9 = this.currentState;
        Integer num3 = state.badgeWithTextShapeAppearanceResId;
        if (num3 == null) {
            i5 = obtainStyledAttributes.getResourceId(16, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
        } else {
            i5 = num3.intValue();
        }
        state9.badgeWithTextShapeAppearanceResId = Integer.valueOf(i5);
        State state10 = this.currentState;
        Integer num4 = state.badgeWithTextShapeAppearanceOverlayResId;
        if (num4 == null) {
            i6 = obtainStyledAttributes.getResourceId(17, 0);
        } else {
            i6 = num4.intValue();
        }
        state10.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(i6);
        State state11 = this.currentState;
        Integer num5 = state.backgroundColor;
        if (num5 == null) {
            i7 = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 1).getDefaultColor();
        } else {
            i7 = num5.intValue();
        }
        state11.backgroundColor = Integer.valueOf(i7);
        State state12 = this.currentState;
        Integer num6 = state.badgeTextAppearanceResId;
        if (num6 == null) {
            i8 = obtainStyledAttributes.getResourceId(9, R.style.TextAppearance_MaterialComponents_Badge);
        } else {
            i8 = num6.intValue();
        }
        state12.badgeTextAppearanceResId = Integer.valueOf(i8);
        Integer num7 = state.badgeTextColor;
        if (num7 != null) {
            this.currentState.badgeTextColor = num7;
        } else if (obtainStyledAttributes.hasValue(10)) {
            this.currentState.badgeTextColor = Integer.valueOf(LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 10).getDefaultColor());
        } else {
            int intValue = this.currentState.badgeTextAppearanceResId.intValue();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(intValue, androidx.appcompat.R$styleable.TextAppearance);
            obtainStyledAttributes2.getDimension(0, 0.0f);
            ColorStateList colorStateList = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes2, 3);
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes2, 4);
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes2, 5);
            obtainStyledAttributes2.getInt(2, 0);
            obtainStyledAttributes2.getInt(1, 1);
            if (obtainStyledAttributes2.hasValue(12)) {
                i19 = 12;
            } else {
                i19 = 10;
            }
            obtainStyledAttributes2.getResourceId(i19, 0);
            obtainStyledAttributes2.getString(i19);
            obtainStyledAttributes2.getBoolean(14, false);
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes2, 6);
            obtainStyledAttributes2.getFloat(7, 0.0f);
            obtainStyledAttributes2.getFloat(8, 0.0f);
            obtainStyledAttributes2.getFloat(9, 0.0f);
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(intValue, R$styleable.MaterialTextAppearance);
            obtainStyledAttributes3.hasValue(0);
            obtainStyledAttributes3.getFloat(0, 0.0f);
            if (Build.VERSION.SDK_INT >= 26) {
                obtainStyledAttributes3.getString(obtainStyledAttributes3.hasValue(3) ? 3 : i21);
            }
            obtainStyledAttributes3.recycle();
            this.currentState.badgeTextColor = Integer.valueOf(colorStateList.getDefaultColor());
        }
        State state13 = this.currentState;
        Integer num8 = state.badgeGravity;
        if (num8 == null) {
            i9 = obtainStyledAttributes.getInt(3, 8388661);
        } else {
            i9 = num8.intValue();
        }
        state13.badgeGravity = Integer.valueOf(i9);
        State state14 = this.currentState;
        Integer num9 = state.badgeHorizontalPadding;
        if (num9 == null) {
            i10 = obtainStyledAttributes.getDimensionPixelSize(12, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        } else {
            i10 = num9.intValue();
        }
        state14.badgeHorizontalPadding = Integer.valueOf(i10);
        State state15 = this.currentState;
        Integer num10 = state.badgeVerticalPadding;
        if (num10 == null) {
            i11 = obtainStyledAttributes.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding));
        } else {
            i11 = num10.intValue();
        }
        state15.badgeVerticalPadding = Integer.valueOf(i11);
        State state16 = this.currentState;
        Integer num11 = state.horizontalOffsetWithoutText;
        if (num11 == null) {
            i12 = obtainStyledAttributes.getDimensionPixelOffset(19, 0);
        } else {
            i12 = num11.intValue();
        }
        state16.horizontalOffsetWithoutText = Integer.valueOf(i12);
        State state17 = this.currentState;
        Integer num12 = state.verticalOffsetWithoutText;
        if (num12 == null) {
            i13 = obtainStyledAttributes.getDimensionPixelOffset(26, 0);
        } else {
            i13 = num12.intValue();
        }
        state17.verticalOffsetWithoutText = Integer.valueOf(i13);
        State state18 = this.currentState;
        Integer num13 = state.horizontalOffsetWithText;
        if (num13 == null) {
            i14 = obtainStyledAttributes.getDimensionPixelOffset(20, state18.horizontalOffsetWithoutText.intValue());
        } else {
            i14 = num13.intValue();
        }
        state18.horizontalOffsetWithText = Integer.valueOf(i14);
        State state19 = this.currentState;
        Integer num14 = state.verticalOffsetWithText;
        if (num14 == null) {
            i15 = obtainStyledAttributes.getDimensionPixelOffset(27, state19.verticalOffsetWithoutText.intValue());
        } else {
            i15 = num14.intValue();
        }
        state19.verticalOffsetWithText = Integer.valueOf(i15);
        State state20 = this.currentState;
        Integer num15 = state.largeFontVerticalOffsetAdjustment;
        if (num15 == null) {
            i16 = obtainStyledAttributes.getDimensionPixelOffset(21, 0);
        } else {
            i16 = num15.intValue();
        }
        state20.largeFontVerticalOffsetAdjustment = Integer.valueOf(i16);
        State state21 = this.currentState;
        Integer num16 = state.additionalHorizontalOffset;
        if (num16 == null) {
            i17 = 0;
        } else {
            i17 = num16.intValue();
        }
        state21.additionalHorizontalOffset = Integer.valueOf(i17);
        State state22 = this.currentState;
        Integer num17 = state.additionalVerticalOffset;
        if (num17 == null) {
            i18 = 0;
        } else {
            i18 = num17.intValue();
        }
        state22.additionalVerticalOffset = Integer.valueOf(i18);
        State state23 = this.currentState;
        Boolean bool2 = state.autoAdjustToWithinGrandparentBounds;
        if (bool2 == null) {
            z2 = obtainStyledAttributes.getBoolean(0, false);
        } else {
            z2 = bool2.booleanValue();
        }
        state23.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(z2);
        obtainStyledAttributes.recycle();
        Locale locale2 = state.numberLocale;
        if (locale2 == null) {
            State state24 = this.currentState;
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            state24.numberLocale = locale;
        } else {
            this.currentState.numberLocale = locale2;
        }
        this.overridingState = state;
    }
}
