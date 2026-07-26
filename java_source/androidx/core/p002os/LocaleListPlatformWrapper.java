package androidx.core.p002os;

import android.os.LocaleList;
import java.util.Locale;
/* renamed from: androidx.core.os.LocaleListPlatformWrapper */
/* loaded from: classes.dex */
public final class LocaleListPlatformWrapper implements LocaleListInterface {
    public final LocaleList mLocaleList;

    public LocaleListPlatformWrapper(Object obj) {
        this.mLocaleList = (LocaleList) obj;
    }

    public final boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final Object getLocaleList() {
        return this.mLocaleList;
    }

    public final int hashCode() {
        return this.mLocaleList.hashCode();
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public final String toString() {
        return this.mLocaleList.toString();
    }
}
