package androidx.emoji2.viewsintegration;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.collection.internal.Lock;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class EmojiInputConnection extends InputConnectionWrapper {
    public final Lock mEmojiCompatDeleteHelper;
    public final EditText mTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.collection.internal.Lock, java.lang.Object] */
    public EmojiInputConnection(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        int i;
        ?? obj = new Object();
        this.mTextView = editText;
        this.mEmojiCompatDeleteHelper = obj;
        if (EmojiCompat.sInstance != null) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() == 1 && editorInfo != null) {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                EmojiCompat.CompatInternal19 compatInternal19 = emojiCompat.mHelper;
                compatInternal19.getClass();
                Bundle bundle = editorInfo.extras;
                MetadataList metadataList = (MetadataList) ((MetadataRepo) compatInternal19.mMetadataRepo).mMetadataList;
                int __offset = metadataList.__offset(4);
                if (__offset != 0) {
                    i = ((ByteBuffer) metadataList.bb).getInt(__offset + metadataList.bb_pos);
                } else {
                    i = 0;
                }
                bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i);
                editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
            }
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        if (Lock.handleDeleteSurroundingText(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2)) {
            return true;
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        if (Lock.handleDeleteSurroundingText(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2)) {
            return true;
        }
        return false;
    }
}
