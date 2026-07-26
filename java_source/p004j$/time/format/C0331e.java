package p004j$.time.format;
/* renamed from: j$.time.format.e */
/* loaded from: classes2.dex */
public final class C0331e implements AbstractC0333g {

    /* renamed from: a */
    public final char f131a;

    public C0331e(char c) {
        this.f131a = c;
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        sb.append(this.f131a);
        return true;
    }

    public final String toString() {
        char c = this.f131a;
        if (c == '\'') {
            return "''";
        }
        return "'" + c + "'";
    }
}
