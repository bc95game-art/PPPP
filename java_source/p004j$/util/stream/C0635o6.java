package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0473n1;
import p004j$.util.Objects;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.o6 */
/* loaded from: classes2.dex */
public final class C0635o6 extends AbstractC0675s6 implements AbstractC0751v0 {

    /* renamed from: g */
    public final /* synthetic */ C0645p6 f684g;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m563B(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: a */
    public final void mo159a(int i, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i]);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: b */
    public final AbstractC0405b1 mo158b(Object obj, int i, int i2) {
        int[] iArr = (int[]) obj;
        int i3 = i2 + i;
        Spliterators.m276a(((int[]) Objects.requireNonNull(iArr)).length, i, i3);
        return new C0473n1(iArr, i, i3, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0635o6(C0645p6 p6Var, int i, int i2, int i3, int i4) {
        super(p6Var, i, i2, i3, i4);
        this.f684g = p6Var;
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: c */
    public final AbstractC0405b1 mo157c(int i, int i2, int i3, int i4) {
        return new C0635o6(this.f684g, i, i2, i3, i4);
    }
}
