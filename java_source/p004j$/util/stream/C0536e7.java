package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.e7 */
/* loaded from: classes2.dex */
public final class C0536e7 extends AbstractC0546f7 implements Consumer {

    /* renamed from: b */
    public final Object[] f546b;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public C0536e7(int i) {
        this.f546b = new Object[i];
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f557a;
        this.f557a = i + 1;
        this.f546b[i] = obj;
    }
}
