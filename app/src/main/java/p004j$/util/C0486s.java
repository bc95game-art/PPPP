package p004j$.util;

import java.util.List;
import java.util.RandomAccess;
/* renamed from: j$.util.s */
/* loaded from: classes2.dex */
public final class C0486s extends C0468m implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    @Override // p004j$.util.C0468m, java.util.List
    public final List subList(int i, int i2) {
        return new C0468m(this.f445b.subList(i, i2));
    }

    private Object writeReplace() {
        return new C0468m(this.f445b);
    }
}
