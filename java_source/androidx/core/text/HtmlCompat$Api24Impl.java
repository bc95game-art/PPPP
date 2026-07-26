package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
/* loaded from: classes.dex */
public abstract class HtmlCompat$Api24Impl {
    public static Spanned fromHtml(String str, int i) {
        return Html.fromHtml(str, i);
    }

    public static String toHtml(Spanned spanned, int i) {
        return Html.toHtml(spanned, i);
    }

    public static Spanned fromHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Html.fromHtml(str, i, imageGetter, tagHandler);
    }
}
