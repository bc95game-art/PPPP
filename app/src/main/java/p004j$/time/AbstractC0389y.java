package p004j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.zone.C0396f;
import p004j$.util.Objects;
/* renamed from: j$.time.y */
/* loaded from: classes2.dex */
public abstract class AbstractC0389y implements Serializable {
    private static final long serialVersionUID = 8352817235686L;

    /* renamed from: C */
    public abstract C0396f mo307C();

    /* renamed from: F */
    public abstract void mo306F(DataOutput dataOutput);

    /* renamed from: h */
    public abstract String mo298h();

    static {
        Map.Entry[] entryArr = {AbstractC0279a.m546S("ACT", "Australia/Darwin"), AbstractC0279a.m546S("AET", "Australia/Sydney"), AbstractC0279a.m546S("AGT", "America/Argentina/Buenos_Aires"), AbstractC0279a.m546S("ART", "Africa/Cairo"), AbstractC0279a.m546S("AST", "America/Anchorage"), AbstractC0279a.m546S("BET", "America/Sao_Paulo"), AbstractC0279a.m546S("BST", "Asia/Dhaka"), AbstractC0279a.m546S("CAT", "Africa/Harare"), AbstractC0279a.m546S("CNT", "America/St_Johns"), AbstractC0279a.m546S("CST", "America/Chicago"), AbstractC0279a.m546S("CTT", "Asia/Shanghai"), AbstractC0279a.m546S("EAT", "Africa/Addis_Ababa"), AbstractC0279a.m546S("ECT", "Europe/Paris"), AbstractC0279a.m546S("IET", "America/Indiana/Indianapolis"), AbstractC0279a.m546S("IST", "Asia/Kolkata"), AbstractC0279a.m546S("JST", "Asia/Tokyo"), AbstractC0279a.m546S("MIT", "Pacific/Apia"), AbstractC0279a.m546S("NET", "Asia/Yerevan"), AbstractC0279a.m546S("NST", "Pacific/Auckland"), AbstractC0279a.m546S("PLT", "Asia/Karachi"), AbstractC0279a.m546S("PNT", "America/Phoenix"), AbstractC0279a.m546S("PRT", "America/Puerto_Rico"), AbstractC0279a.m546S("PST", "America/Los_Angeles"), AbstractC0279a.m546S("SST", "Pacific/Guadalcanal"), AbstractC0279a.m546S("VST", "Asia/Ho_Chi_Minh"), AbstractC0279a.m546S("EST", "-05:00"), AbstractC0279a.m546S("MST", "-07:00"), AbstractC0279a.m546S("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        for (int i = 0; i < 28; i++) {
            Map.Entry entry = entryArr[i];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) != null) {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: D */
    public static AbstractC0389y m309D(String str, C0390z zVar) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zVar, "offset");
        if (str.isEmpty()) {
            return zVar;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zVar.f256a != 0) {
                str = str.concat(zVar.f257b);
            }
            return new C0282a0(str, zVar.mo307C());
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
    }

    /* renamed from: E */
    public static AbstractC0389y m308E(String str, int i) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return m309D(substring, C0390z.f253e);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return C0282a0.m496G(str);
        }
        try {
            C0390z G = C0390z.m305G(str.substring(i));
            if (G == C0390z.f253e) {
                return m309D(substring, G);
            }
            return m309D(substring, G);
        } catch (C0281a e) {
            throw new RuntimeException("Invalid ID for offset-based ZoneId: ".concat(str), e);
        }
    }

    public AbstractC0389y() {
        if (getClass() != C0390z.class && getClass() != C0282a0.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractC0389y) {
            return mo298h().equals(((AbstractC0389y) obj).mo298h());
        }
        return false;
    }

    public int hashCode() {
        return mo298h().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return mo298h();
    }

    private Object writeReplace() {
        return new C0363t((byte) 7, this);
    }
}
