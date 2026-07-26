package com.github.appintro.model;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SliderPagerBuilder {
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

    public final SliderPagerBuilder backgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    public final SliderPagerBuilder backgroundColorRes(int i) {
        this.backgroundColorRes = i;
        return this;
    }

    public final SliderPagerBuilder backgroundDrawable(int i) {
        this.backgroundDrawable = i;
        return this;
    }

    public final SliderPage build() {
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.description;
        int i = this.imageDrawable;
        int i2 = this.backgroundColor;
        int i3 = this.backgroundColorRes;
        int i4 = this.titleColor;
        int i5 = this.titleColorRes;
        int i6 = this.descriptionColor;
        int i7 = this.descriptionColorRes;
        int i8 = this.titleTypefaceFontRes;
        String str = this.descriptionTypeface;
        return new SliderPage(charSequence, charSequence2, i, i2, i4, i6, i3, i5, i7, i8, this.descriptionTypefaceFontRes, this.titleTypeface, str, this.backgroundDrawable);
    }

    public final SliderPagerBuilder description(CharSequence description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
        return this;
    }

    public final SliderPagerBuilder descriptionColor(int i) {
        this.descriptionColor = i;
        return this;
    }

    public final SliderPagerBuilder descriptionColorRes(int i) {
        this.descriptionColorRes = i;
        return this;
    }

    public final SliderPagerBuilder descriptionTypeface(String descriptionTypeface) {
        Intrinsics.checkNotNullParameter(descriptionTypeface, "descriptionTypeface");
        this.descriptionTypeface = descriptionTypeface;
        return this;
    }

    public final SliderPagerBuilder descriptionTypefaceFontRes(int i) {
        this.descriptionTypefaceFontRes = i;
        return this;
    }

    public final SliderPagerBuilder imageDrawable(int i) {
        this.imageDrawable = i;
        return this;
    }

    public final SliderPagerBuilder title(CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }

    public final SliderPagerBuilder titleColor(int i) {
        this.titleColor = i;
        return this;
    }

    public final SliderPagerBuilder titleColorRes(int i) {
        this.titleColorRes = i;
        return this;
    }

    public final SliderPagerBuilder titleTypeface(String titleTypeface) {
        Intrinsics.checkNotNullParameter(titleTypeface, "titleTypeface");
        this.titleTypeface = titleTypeface;
        return this;
    }

    public final SliderPagerBuilder titleTypefaceFontRes(int i) {
        this.titleTypefaceFontRes = i;
        return this;
    }
}
