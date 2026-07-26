package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.x7 */
/* loaded from: classes2.dex */
public final class C0726x7 extends AbstractC0745z7 implements Spliterator, Consumer {

    /* renamed from: f */
    public Object f845f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f845f = obj;
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (m15f() != EnumC0736y7.NO_MORE && this.f871a.tryAdvance(this)) {
            if (m17a(1L) == 1) {
                consumer.accept(this.f845f);
                this.f845f = null;
                return true;
            }
        }
        return false;
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C0536e7 e7Var = null;
        while (true) {
            EnumC0736y7 f = m15f();
            if (f != EnumC0736y7.NO_MORE) {
                EnumC0736y7 y7Var = EnumC0736y7.MAYBE_MORE;
                Spliterator spliterator = this.f871a;
                if (f == y7Var) {
                    int i = this.f873c;
                    if (e7Var == null) {
                        e7Var = new C0536e7(i);
                    } else {
                        e7Var.f557a = 0;
                    }
                    long j = 0;
                    while (spliterator.tryAdvance(e7Var)) {
                        j++;
                        if (j >= i) {
                            break;
                        }
                    }
                    if (j != 0) {
                        long a = m17a(j);
                        for (int i2 = 0; i2 < a; i2++) {
                            consumer.accept(e7Var.f546b[i2]);
                        }
                    } else {
                        return;
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0745z7
    /* renamed from: b */
    public final Spliterator mo16b(Spliterator spliterator) {
        return new AbstractC0745z7(spliterator, this);
    }
}
