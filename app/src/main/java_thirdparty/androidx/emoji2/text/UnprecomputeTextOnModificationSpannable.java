package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.transition.Transition;
import com.google.android.material.datepicker.DateStrings;
import j$.util.stream.IntStream;
/* loaded from: classes.dex */
public final class UnprecomputeTextOnModificationSpannable implements Spannable {
    public Spannable mDelegate;
    public boolean mSafeToWrite = false;

    /* loaded from: classes.dex */
    public final class PrecomputedTextDetector_28 extends Transition.AnonymousClass1 {
        @Override // androidx.transition.Transition.AnonymousClass1
        public final boolean isPrecomputedText(CharSequence charSequence) {
            if (!(charSequence instanceof PrecomputedText)) {
                return false;
            }
            return true;
        }
    }

    public UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.mDelegate = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.mDelegate.charAt(i);
    }

    public final void ensureSafeWrites() {
        Transition.AnonymousClass1 r1;
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite) {
            if (Build.VERSION.SDK_INT < 28) {
                r1 = new Transition.AnonymousClass1(6);
            } else {
                r1 = new Transition.AnonymousClass1(6);
            }
            if (r1.isPrecomputedText(spannable)) {
                this.mDelegate = new SpannableString(spannable);
            }
        }
        this.mSafeToWrite = true;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i2, Class cls) {
        return this.mDelegate.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.mDelegate.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.mDelegate.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.mDelegate.toString();
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return DateStrings.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return DateStrings.codePoints(this.mDelegate);
    }
}
