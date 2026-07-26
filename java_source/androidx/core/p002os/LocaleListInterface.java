package androidx.core.p002os;

import java.util.Locale;
/* renamed from: androidx.core.os.LocaleListInterface */
/* loaded from: classes.dex */
public interface LocaleListInterface {
    Locale get(int i);

    Object getLocaleList();

    boolean isEmpty();

    int size();

    String toLanguageTags();
}
