package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.emoji2.text.EmojiCompat;
/* loaded from: classes.dex */
public final class EmojiTextWatcher implements TextWatcher {
    public final EditText mEditText;
    public boolean mEnabled = true;
    public SwitchCompat.EmojiCompatInitCallback mInitCallback;

    public EmojiTextWatcher(EditText editText) {
        this.mEditText = editText;
    }

    public static void processTextOnEnablingEvent(EditText editText, int i) {
        int i2;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (editableText == null) {
                i2 = 0;
            } else {
                emojiCompat.getClass();
                i2 = editableText.length();
            }
            emojiCompat.process(editableText, 0, i2);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText = this.mEditText;
        if (!editText.isInEditMode() && this.mEnabled && EmojiCompat.sInstance != null && i2 <= i3 && (charSequence instanceof Spannable)) {
            int loadState = EmojiCompat.get().getLoadState();
            if (loadState != 0) {
                if (loadState == 1) {
                    EmojiCompat.get().process((Spannable) charSequence, i, i3 + i);
                    return;
                } else if (loadState != 3) {
                    return;
                }
            }
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (this.mInitCallback == null) {
                this.mInitCallback = new SwitchCompat.EmojiCompatInitCallback(editText);
            }
            emojiCompat.registerInitCallback(this.mInitCallback);
        }
    }
}
