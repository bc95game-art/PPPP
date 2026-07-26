package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.transition.Transition;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class EmojiKeyListener implements KeyListener {
    public final Transition.AnonymousClass1 mEmojiCompatHandleKeyDownHelper;
    public final KeyListener mKeyListener;

    public EmojiKeyListener(KeyListener keyListener) {
        Transition.AnonymousClass1 r0 = new Transition.AnonymousClass1(7);
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = r0;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.mKeyListener.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        this.mEmojiCompatHandleKeyDownHelper.getClass();
        if (i == 67) {
            z = MatcherMatchResult.delete(editable, keyEvent, false);
        } else if (i != 112) {
            z = false;
        } else {
            z = MatcherMatchResult.delete(editable, keyEvent, true);
        }
        if (z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || this.mKeyListener.onKeyDown(view, editable, i, keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, i, keyEvent);
    }
}
