package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.FakeDrag;
/* loaded from: classes.dex */
public final class AppCompatEmojiTextHelper {
    public final FakeDrag mEmojiTextViewHelper;
    public final TextView mView;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new FakeDrag(textView);
    }

    public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return ((Navigation) this.mEmojiTextViewHelper.mScrollEventAdapter).getFilters(inputFilterArr);
    }

    /* JADX WARN: Finally extract failed */
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        try {
            boolean z = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setAllCaps(boolean z) {
        ((Navigation) this.mEmojiTextViewHelper.mScrollEventAdapter).setAllCaps(z);
    }

    public final void setEnabled(boolean z) {
        ((Navigation) this.mEmojiTextViewHelper.mScrollEventAdapter).setEnabled(z);
    }
}
