package p004j$.time.format;
/* renamed from: j$.time.format.m */
/* loaded from: classes2.dex */
public final class C0339m implements AbstractC0333g {

    /* renamed from: a */
    public final String f148a;

    public C0339m(String str) {
        this.f148a = str;
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        sb.append(this.f148a);
        return true;
    }

    public final String toString() {
        String replace = this.f148a.replace("'", "''");
        return "'" + replace + "'";
    }
}
