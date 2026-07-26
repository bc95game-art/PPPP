package p004j$.util.stream;

import java.util.EnumMap;
import java.util.Map;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.format.C0345s;
import p004j$.util.Spliterator;
/* JADX WARN: Init of enum DISTINCT can be incorrect */
/* JADX WARN: Init of enum ORDERED can be incorrect */
/* JADX WARN: Init of enum SHORT_CIRCUIT can be incorrect */
/* JADX WARN: Init of enum SIZED can be incorrect */
/* JADX WARN: Init of enum SORTED can be incorrect */
/* renamed from: j$.util.stream.x6 */
/* loaded from: classes2.dex */
public enum EnumC0725x6 {
    DISTINCT(0, r2),
    SORTED(1, r7),
    ORDERED(2, r12),
    SIZED(3, r14),
    SHORT_CIRCUIT(12, r14);
    

    /* renamed from: f */
    public static final int f823f;

    /* renamed from: g */
    public static final int f824g;

    /* renamed from: h */
    public static final int f825h;

    /* renamed from: i */
    public static final int f826i;

    /* renamed from: j */
    public static final int f827j;

    /* renamed from: k */
    public static final int f828k;

    /* renamed from: l */
    public static final int f829l;

    /* renamed from: m */
    public static final int f830m;

    /* renamed from: n */
    public static final int f831n;

    /* renamed from: o */
    public static final int f832o;

    /* renamed from: p */
    public static final int f833p;

    /* renamed from: q */
    public static final int f834q;

    /* renamed from: r */
    public static final int f835r;

    /* renamed from: s */
    public static final int f836s;

    /* renamed from: t */
    public static final int f837t;

    /* renamed from: u */
    public static final int f838u;

    /* renamed from: a */
    public final Map f840a;

    /* renamed from: b */
    public final int f841b;

    /* renamed from: c */
    public final int f842c;

    /* renamed from: d */
    public final int f843d;

    /* renamed from: e */
    public final int f844e;

    static {
        EnumC0715w6 w6Var = EnumC0715w6.SPLITERATOR;
        C0345s o = m65o(w6Var);
        EnumC0715w6 w6Var2 = EnumC0715w6.STREAM;
        o.m408b(w6Var2);
        EnumC0715w6 w6Var3 = EnumC0715w6.f809OP;
        ((EnumMap) o.f166a).put((EnumMap) w6Var3, (EnumC0715w6) 3);
        C0345s o2 = m65o(w6Var);
        o2.m408b(w6Var2);
        ((EnumMap) o2.f166a).put((EnumMap) w6Var3, (EnumC0715w6) 3);
        C0345s o3 = m65o(w6Var);
        o3.m408b(w6Var2);
        ((EnumMap) o3.f166a).put((EnumMap) w6Var3, (EnumC0715w6) 3);
        EnumC0715w6 w6Var4 = EnumC0715w6.TERMINAL_OP;
        ((EnumMap) o3.f166a).put((EnumMap) w6Var4, (EnumC0715w6) 2);
        EnumC0715w6 w6Var5 = EnumC0715w6.UPSTREAM_TERMINAL_OP;
        ((EnumMap) o3.f166a).put((EnumMap) w6Var5, (EnumC0715w6) 2);
        C0345s o4 = m65o(w6Var);
        o4.m408b(w6Var2);
        ((EnumMap) o4.f166a).put((EnumMap) w6Var3, (EnumC0715w6) 2);
        m65o(w6Var3).m408b(w6Var4);
        int i = 0;
        f823f = m68j(w6Var);
        f824g = m68j(w6Var2);
        f825h = m68j(w6Var3);
        m68j(w6Var4);
        m68j(w6Var5);
        for (EnumC0725x6 x6Var : values()) {
            i |= x6Var.f844e;
        }
        f826i = i;
        int i2 = f824g;
        f827j = i2;
        int i3 = i2 << 1;
        f828k = i3;
        f829l = i2 | i3;
        EnumC0725x6 x6Var2 = DISTINCT;
        f830m = x6Var2.f842c;
        f831n = x6Var2.f843d;
        EnumC0725x6 x6Var3 = SORTED;
        f832o = x6Var3.f842c;
        f833p = x6Var3.f843d;
        EnumC0725x6 x6Var4 = ORDERED;
        f834q = x6Var4.f842c;
        f835r = x6Var4.f843d;
        EnumC0725x6 x6Var5 = SIZED;
        f836s = x6Var5.f842c;
        f837t = x6Var5.f843d;
        f838u = SHORT_CIRCUIT.f842c;
    }

    /* renamed from: o */
    public static C0345s m65o(EnumC0715w6 w6Var) {
        C0345s sVar = new C0345s(1, new EnumMap(EnumC0715w6.class));
        sVar.m408b(w6Var);
        return sVar;
    }

    EnumC0725x6(int i, C0345s sVar) {
        for (EnumC0715w6 w6Var : EnumC0715w6.values()) {
            AbstractC0279a.m537a0(sVar.f166a, w6Var, 0);
        }
        this.f840a = sVar.f166a;
        int i2 = i * 2;
        this.f841b = i2;
        this.f842c = 1 << i2;
        this.f843d = 2 << i2;
        this.f844e = 3 << i2;
    }

    /* renamed from: l */
    public final boolean m66l(int i) {
        return (i & this.f844e) == this.f842c;
    }

    /* renamed from: j */
    public static int m68j(EnumC0715w6 w6Var) {
        EnumC0725x6[] values;
        int i = 0;
        for (EnumC0725x6 x6Var : values()) {
            i |= ((Integer) x6Var.f840a.get(w6Var)).intValue() << x6Var.f841b;
        }
        return i;
    }

    /* renamed from: i */
    public static int m69i(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = f826i;
        } else {
            i3 = ~(((f827j & i) << 1) | i | ((f828k & i) >> 1));
        }
        return i | (i2 & i3);
    }

    /* renamed from: k */
    public static int m67k(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        int i = characteristics & 4;
        int i2 = f823f;
        return (i == 0 || spliterator.getComparator() == null) ? characteristics & i2 : characteristics & i2 & (-5);
    }
}
