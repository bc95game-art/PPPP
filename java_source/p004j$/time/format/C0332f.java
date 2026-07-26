package p004j$.time.format;

import java.util.ArrayList;
import java.util.List;
/* renamed from: j$.time.format.f */
/* loaded from: classes2.dex */
public final class C0332f implements AbstractC0333g {

    /* renamed from: a */
    public final AbstractC0333g[] f132a;

    /* renamed from: b */
    public final boolean f133b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0332f(List list, boolean z) {
        this((AbstractC0333g[]) r2.toArray(new AbstractC0333g[r2.size()]), z);
        ArrayList arrayList = (ArrayList) list;
    }

    public C0332f(AbstractC0333g[] gVarArr, boolean z) {
        this.f132a = gVarArr;
        this.f133b = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        return true;
     */
    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        int length = sb.length();
        boolean z = this.f133b;
        if (z) {
            qVar.f165c++;
        }
        try {
            for (AbstractC0333g gVar : this.f132a) {
                if (!gVar.mo423i(qVar, sb)) {
                    sb.setLength(length);
                }
            }
        } finally {
            if (z) {
                qVar.f165c--;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        AbstractC0333g[] gVarArr = this.f132a;
        if (gVarArr != null) {
            boolean z = this.f133b;
            sb.append(z ? "[" : "(");
            for (AbstractC0333g gVar : gVarArr) {
                sb.append(gVar);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }
}
