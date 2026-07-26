package androidx.core.p002os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
/* renamed from: androidx.core.os.LocaleListCompatWrapper */
/* loaded from: classes.dex */
public final class LocaleListCompatWrapper implements LocaleListInterface {
    public static final Locale[] sEmptyList = new Locale[0];
    public final Locale[] mList;
    public final String mStringRepresentation;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        String[] split = "en-Latn".split("-", -1);
        if (split.length > 2) {
            new Locale(split[0], split[1], split[2]);
        } else if (split.length > 1) {
            new Locale(split[0], split[1]);
        } else if (split.length == 1) {
            new Locale(split[0]);
        } else {
            throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
        }
    }

    public LocaleListCompatWrapper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    sb.append(locale2.getLanguage());
                    String country = locale2.getCountry();
                    if (country != null && !country.isEmpty()) {
                        sb.append('-');
                        sb.append(locale2.getCountry());
                    }
                    if (i < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i + "] is null");
            }
        }
        this.mList = (Locale[]) arrayList.toArray(new Locale[0]);
        this.mStringRepresentation = sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).mList;
        Locale[] localeArr2 = this.mList;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i = 0; i < localeArr2.length; i++) {
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final Locale get(int i) {
        if (i < 0) {
            return null;
        }
        Locale[] localeArr = this.mList;
        if (i < localeArr.length) {
            return localeArr[i];
        }
        return null;
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final Object getLocaleList() {
        return null;
    }

    public final int hashCode() {
        int i = 1;
        for (Locale locale : this.mList) {
            i = (i * 31) + locale.hashCode();
        }
        return i;
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final boolean isEmpty() {
        if (this.mList.length == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final int size() {
        return this.mList.length;
    }

    @Override // androidx.core.p002os.LocaleListInterface
    public final String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
