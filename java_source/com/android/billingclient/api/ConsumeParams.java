package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
/* loaded from: classes.dex */
public final class ConsumeParams implements EmojiProcessor$EmojiProcessCallback {
    public String zza;

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.zza)) {
            return true;
        }
        typefaceEmojiRasterizer.mCache = (typefaceEmojiRasterizer.mCache & 3) | 4;
        return false;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return this;
    }
}
