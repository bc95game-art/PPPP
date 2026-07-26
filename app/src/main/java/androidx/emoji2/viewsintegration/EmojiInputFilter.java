package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class EmojiInputFilter implements InputFilter {
    public InitCallbackImpl mInitCallback;
    public final TextView mTextView;

    /* loaded from: classes.dex */
    public final class InitCallbackImpl extends EmojiCompat.InitCallback {
        public final WeakReference mEmojiInputFilterReference;
        public final WeakReference mViewRef;

        public InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.mViewRef = new WeakReference(textView);
            this.mEmojiInputFilterReference = new WeakReference(emojiInputFilter);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void onInitialized() {
            InputFilter[] filters;
            int i;
            TextView textView = (TextView) this.mViewRef.get();
            InputFilter inputFilter = (InputFilter) this.mEmojiInputFilterReference.get();
            if (!(inputFilter == null || textView == null || (filters = textView.getFilters()) == null)) {
                for (InputFilter inputFilter2 : filters) {
                    if (inputFilter2 == inputFilter) {
                        if (textView.isAttachedToWindow()) {
                            CharSequence text = textView.getText();
                            EmojiCompat emojiCompat = EmojiCompat.get();
                            if (text == null) {
                                i = 0;
                            } else {
                                emojiCompat.getClass();
                                i = text.length();
                            }
                            CharSequence process = emojiCompat.process(text, 0, i);
                            if (text != process) {
                                int selectionStart = Selection.getSelectionStart(process);
                                int selectionEnd = Selection.getSelectionEnd(process);
                                textView.setText(process);
                                if (process instanceof Spannable) {
                                    Spannable spannable = (Spannable) process;
                                    if (selectionStart >= 0 && selectionEnd >= 0) {
                                        Selection.setSelection(spannable, selectionStart, selectionEnd);
                                        return;
                                    } else if (selectionStart >= 0) {
                                        Selection.setSelection(spannable, selectionStart);
                                        return;
                                    } else if (selectionEnd >= 0) {
                                        Selection.setSelection(spannable, selectionEnd);
                                        return;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public EmojiInputFilter(TextView textView) {
        this.mTextView = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.mTextView;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState != 1) {
                if (loadState != 3) {
                    return charSequence;
                }
            } else if ((i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                return charSequence;
            } else {
                if (!(i == 0 && i2 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return EmojiCompat.get().process(charSequence, 0, charSequence.length());
            }
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(textView, this);
        }
        emojiCompat.registerInitCallback(this.mInitCallback);
        return charSequence;
    }
}
