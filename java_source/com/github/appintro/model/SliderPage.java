package com.github.appintro.model;

import android.os.Bundle;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import com.github.appintro.AppIntroBaseFragmentKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SliderPage {
    private int backgroundColor;
    private int backgroundColorRes;
    private int backgroundDrawable;
    private CharSequence description;
    private int descriptionColor;
    private int descriptionColorRes;
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;
    private CharSequence title;
    private int titleColor;
    private int titleColorRes;
    private String titleTypeface;
    private int titleTypefaceFontRes;

    public SliderPage() {
        this(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16383, null);
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getDescriptionColor$annotations() {
    }

    public static /* synthetic */ void getTitleColor$annotations() {
    }

    public final CharSequence component1() {
        return this.title;
    }

    public final int component10() {
        return this.titleTypefaceFontRes;
    }

    public final int component11() {
        return this.descriptionTypefaceFontRes;
    }

    public final String component12() {
        return this.titleTypeface;
    }

    public final String component13() {
        return this.descriptionTypeface;
    }

    public final int component14() {
        return this.backgroundDrawable;
    }

    public final CharSequence component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageDrawable;
    }

    public final int component4() {
        return this.backgroundColor;
    }

    public final int component5() {
        return this.titleColor;
    }

    public final int component6() {
        return this.descriptionColor;
    }

    public final int component7() {
        return this.backgroundColorRes;
    }

    public final int component8() {
        return this.titleColorRes;
    }

    public final int component9() {
        return this.descriptionColorRes;
    }

    public final SliderPage copy(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, int i10) {
        return new SliderPage(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, str2, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPage)) {
            return false;
        }
        SliderPage sliderPage = (SliderPage) obj;
        return Intrinsics.areEqual(this.title, sliderPage.title) && Intrinsics.areEqual(this.description, sliderPage.description) && this.imageDrawable == sliderPage.imageDrawable && this.backgroundColor == sliderPage.backgroundColor && this.titleColor == sliderPage.titleColor && this.descriptionColor == sliderPage.descriptionColor && this.backgroundColorRes == sliderPage.backgroundColorRes && this.titleColorRes == sliderPage.titleColorRes && this.descriptionColorRes == sliderPage.descriptionColorRes && this.titleTypefaceFontRes == sliderPage.titleTypefaceFontRes && this.descriptionTypefaceFontRes == sliderPage.descriptionTypefaceFontRes && Intrinsics.areEqual(this.titleTypeface, sliderPage.titleTypeface) && Intrinsics.areEqual(this.descriptionTypeface, sliderPage.descriptionTypeface) && this.backgroundDrawable == sliderPage.backgroundDrawable;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundColorRes() {
        return this.backgroundColorRes;
    }

    public final int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    public final int getDescriptionColorRes() {
        return this.descriptionColorRes;
    }

    public final String getDescriptionString() {
        CharSequence charSequence = this.description;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public final String getDescriptionTypeface() {
        return this.descriptionTypeface;
    }

    public final int getDescriptionTypefaceFontRes() {
        return this.descriptionTypefaceFontRes;
    }

    public final int getImageDrawable() {
        return this.imageDrawable;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final int getTitleColorRes() {
        return this.titleColorRes;
    }

    public final String getTitleString() {
        CharSequence charSequence = this.title;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public final String getTitleTypeface() {
        return this.titleTypeface;
    }

    public final int getTitleTypefaceFontRes() {
        return this.titleTypefaceFontRes;
    }

    public int hashCode() {
        CharSequence charSequence = this.title;
        int i = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.description;
        int hashCode2 = (((((((((((((((((((hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31) + this.imageDrawable) * 31) + this.backgroundColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.backgroundColorRes) * 31) + this.titleColorRes) * 31) + this.descriptionColorRes) * 31) + this.titleTypefaceFontRes) * 31) + this.descriptionTypefaceFontRes) * 31;
        String str = this.titleTypeface;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.descriptionTypeface;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.backgroundDrawable;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setBackgroundColorRes(int i) {
        this.backgroundColorRes = i;
    }

    public final void setBackgroundDrawable(int i) {
        this.backgroundDrawable = i;
    }

    public final void setDescription(CharSequence charSequence) {
        this.description = charSequence;
    }

    public final void setDescriptionColor(int i) {
        this.descriptionColor = i;
    }

    public final void setDescriptionColorRes(int i) {
        this.descriptionColorRes = i;
    }

    public final void setDescriptionTypeface(String str) {
        this.descriptionTypeface = str;
    }

    public final void setDescriptionTypefaceFontRes(int i) {
        this.descriptionTypefaceFontRes = i;
    }

    public final void setImageDrawable(int i) {
        this.imageDrawable = i;
    }

    public final void setTitle(CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTitleColorRes(int i) {
        this.titleColorRes = i;
    }

    public final void setTitleTypeface(String str) {
        this.titleTypeface = str;
    }

    public final void setTitleTypefaceFontRes(int i) {
        this.titleTypefaceFontRes = i;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE, getTitleString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, this.titleTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, this.titleTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, this.titleColorRes);
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC, getDescriptionString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, this.descriptionTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, this.descriptionTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descriptionColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, this.descriptionColorRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.imageDrawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.backgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES, this.backgroundColorRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.backgroundDrawable);
        return bundle;
    }

    public String toString() {
        return "SliderPage(title=" + ((Object) this.title) + ", description=" + ((Object) this.description) + ", imageDrawable=" + this.imageDrawable + ", backgroundColor=" + this.backgroundColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", backgroundColorRes=" + this.backgroundColorRes + ", titleColorRes=" + this.titleColorRes + ", descriptionColorRes=" + this.descriptionColorRes + ", titleTypefaceFontRes=" + this.titleTypefaceFontRes + ", descriptionTypefaceFontRes=" + this.descriptionTypefaceFontRes + ", titleTypeface=" + ((Object) this.titleTypeface) + ", descriptionTypeface=" + ((Object) this.descriptionTypeface) + ", backgroundDrawable=" + this.backgroundDrawable + ')';
    }

    public SliderPage(CharSequence charSequence) {
        this(charSequence, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16382, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2) {
        this(charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16380, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i) {
        this(charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16376, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        this(charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16368, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3) {
        this(charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 0, 0, null, null, 0, 16352, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        this(charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 0, 0, null, null, 0, 16320, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 0, 0, null, null, 0, 16256, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 0, 0, null, null, 0, 16128, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, 0, 0, null, null, 0, 15872, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, 0, null, null, 0, 15360, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, null, null, 0, 14336, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, null, 0, 12288, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, str2, 0, CaptureService.CONNECTIONS_LOG_SIZE, null);
    }

    public SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, int i10) {
        this.title = charSequence;
        this.description = charSequence2;
        this.imageDrawable = i;
        this.backgroundColor = i2;
        this.titleColor = i3;
        this.descriptionColor = i4;
        this.backgroundColorRes = i5;
        this.titleColorRes = i6;
        this.descriptionColorRes = i7;
        this.titleTypefaceFontRes = i8;
        this.descriptionTypefaceFontRes = i9;
        this.titleTypeface = str;
        this.descriptionTypeface = str2;
        this.backgroundDrawable = i10;
    }

    public /* synthetic */ SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? 0 : i, (i11 & 8) != 0 ? 0 : i2, (i11 & 16) != 0 ? 0 : i3, (i11 & 32) != 0 ? 0 : i4, (i11 & 64) != 0 ? 0 : i5, (i11 & 128) != 0 ? 0 : i6, (i11 & 256) != 0 ? 0 : i7, (i11 & LogviewFragment.MAX_LINES) != 0 ? 0 : i8, (i11 & 1024) != 0 ? 0 : i9, (i11 & 2048) != 0 ? null : str, (i11 & 4096) == 0 ? str2 : null, (i11 & CaptureService.CONNECTIONS_LOG_SIZE) != 0 ? 0 : i10);
    }
}
