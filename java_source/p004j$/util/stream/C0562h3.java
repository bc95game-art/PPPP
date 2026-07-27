package p004j$.util.stream;

import java.util.Deque;
import java.util.function.Consumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.h3 */
/* loaded from: classes2.dex */
public final class C0562h3 extends AbstractC0572i3 {
    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        AbstractC0531e2 a;
        if (!m193c()) {
            return false;
        }
        boolean tryAdvance = this.f600d.tryAdvance(consumer);
        if (!tryAdvance) {
            if (this.f599c != null || (a = AbstractC0572i3.m195a(this.f601e)) == null) {
                this.f597a = null;
            } else {
                Spliterator spliterator = a.mo904spliterator();
                this.f600d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
        }
        return tryAdvance;
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f597a != null) {
            if (this.f600d == null) {
                Spliterator spliterator = this.f599c;
                if (spliterator == null) {
                    Deque b = m194b();
                    while (true) {
                        AbstractC0531e2 a = AbstractC0572i3.m195a(b);
                        if (a != null) {
                            a.forEach(consumer);
                        } else {
                            this.f597a = null;
                            return;
                        }
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                }
            } else {
                do {
                } while (tryAdvance(consumer));
            }
        }
    }
}
