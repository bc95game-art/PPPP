package androidx.core.p002os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;
/* renamed from: androidx.core.os.LocaleListCompat */
/* loaded from: classes.dex */
public final class LocaleListCompat {
    public static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    public final LocaleListInterface mImpl;

    /* renamed from: androidx.core.os.LocaleListCompat$Api21Impl */
    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean matchesLanguageAndScript(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (locale.getLanguage().equals(locale2.getLanguage())) {
                Locale[] localeArr = PSEUDO_LOCALE;
                int length = localeArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        int length2 = localeArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                                if (!maximizeAndGetScript.isEmpty()) {
                                    return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
                                }
                                String country = locale.getCountry();
                                if (country.isEmpty() || country.equals(locale2.getCountry())) {
                                    return true;
                                }
                            } else if (localeArr[i2].equals(locale2)) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    } else if (localeArr[i].equals(locale)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: androidx.core.os.LocaleListCompat$Api24Impl */
    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static LocaleList createLocaleList(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    public LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new LocaleListCompat(new LocaleListPlatformWrapper(Api24Impl.createLocaleList(localeArr)));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    public static LocaleListCompat forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return sEmptyLocaleList;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Api21Impl.forLanguageTag(split[i]);
        }
        return create(localeArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocaleListCompat)) {
            return false;
        }
        if (this.mImpl.equals(((LocaleListCompat) obj).mImpl)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    public final String toString() {
        return this.mImpl.toString();
    }
}
