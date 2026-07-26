package p004j$.util.stream;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.i3 */
/* loaded from: classes2.dex */
public abstract class AbstractC0572i3 implements Spliterator {

    /* renamed from: a */
    public AbstractC0531e2 f597a;

    /* renamed from: b */
    public int f598b;

    /* renamed from: c */
    public Spliterator f599c;

    /* renamed from: d */
    public Spliterator f600d;

    /* renamed from: e */
    public Deque f601e;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 64;
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

    public AbstractC0572i3(AbstractC0531e2 e2Var) {
        this.f597a = e2Var;
    }

    /* renamed from: b */
    public final Deque m194b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int o = this.f597a.mo58o();
        while (true) {
            o--;
            if (o < this.f598b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f597a.mo63a(o));
        }
    }

    /* renamed from: a */
    public static AbstractC0531e2 m195a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            AbstractC0531e2 e2Var = (AbstractC0531e2) arrayDeque.pollFirst();
            if (e2Var == null) {
                return null;
            }
            if (e2Var.mo58o() != 0) {
                for (int o = e2Var.mo58o() - 1; o >= 0; o--) {
                    arrayDeque.addFirst(e2Var.mo63a(o));
                }
            } else if (e2Var.count() > 0) {
                return e2Var;
            }
        }
    }

    /* renamed from: c */
    public final boolean m193c() {
        if (this.f597a == null) {
            return false;
        }
        if (this.f600d != null) {
            return true;
        }
        Spliterator spliterator = this.f599c;
        if (spliterator == null) {
            Deque b = m194b();
            this.f601e = b;
            AbstractC0531e2 a = m195a(b);
            if (a != null) {
                this.f600d = a.mo904spliterator();
                return true;
            }
            this.f597a = null;
            return false;
        }
        this.f600d = spliterator;
        return true;
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        AbstractC0531e2 e2Var = this.f597a;
        if (e2Var == null || this.f600d != null) {
            return null;
        }
        Spliterator spliterator = this.f599c;
        if (spliterator != null) {
            return spliterator.mo899trySplit();
        }
        if (this.f598b < e2Var.mo58o() - 1) {
            AbstractC0531e2 e2Var2 = this.f597a;
            int i = this.f598b;
            this.f598b = i + 1;
            return e2Var2.mo63a(i).mo904spliterator();
        }
        AbstractC0531e2 a = this.f597a.mo63a(this.f598b);
        this.f597a = a;
        if (a.mo58o() == 0) {
            Spliterator spliterator2 = this.f597a.mo904spliterator();
            this.f599c = spliterator2;
            return spliterator2.mo899trySplit();
        }
        AbstractC0531e2 e2Var3 = this.f597a;
        this.f598b = 1;
        return e2Var3.mo63a(0).mo904spliterator();
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        long j = 0;
        if (this.f597a == null) {
            return 0L;
        }
        Spliterator spliterator = this.f599c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i = this.f598b; i < this.f597a.mo58o(); i++) {
            j += this.f597a.mo63a(i).count();
        }
        return j;
    }
}
