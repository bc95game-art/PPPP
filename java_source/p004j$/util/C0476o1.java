package p004j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.o1 */
/* loaded from: classes2.dex */
public class C0476o1 implements Spliterator {

    /* renamed from: a */
    public final Collection f454a;

    /* renamed from: b */
    public Iterator f455b = null;

    /* renamed from: c */
    public final int f456c;

    /* renamed from: d */
    public long f457d;

    /* renamed from: e */
    public int f458e;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    public C0476o1(Collection collection, int i) {
        this.f454a = collection;
        this.f456c = (i & 4096) == 0 ? i | 16448 : i;
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        long j;
        Iterator it = this.f455b;
        if (it == null) {
            it = this.f454a.iterator();
            this.f455b = it;
            j = this.f454a.size();
            this.f457d = j;
        } else {
            j = this.f457d;
        }
        if (j <= 1 || !it.hasNext()) {
            return null;
        }
        int i = this.f458e + 1024;
        if (i > j) {
            i = (int) j;
        }
        if (i > 33554432) {
            i = 33554432;
        }
        Object[] objArr = new Object[i];
        int i2 = 0;
        do {
            objArr[i2] = it.next();
            i2++;
            if (i2 >= i) {
                break;
            }
        } while (it.hasNext());
        this.f458e = i2;
        long j2 = this.f457d;
        if (j2 != Long.MAX_VALUE) {
            this.f457d = j2 - i2;
        }
        return new C0455h1(objArr, 0, i2, this.f456c);
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f455b;
        if (it == null) {
            it = this.f454a.iterator();
            this.f455b = it;
            this.f457d = this.f454a.size();
        }
        AbstractC0279a.m551N(it, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        if (this.f455b == null) {
            this.f455b = this.f454a.iterator();
            this.f457d = this.f454a.size();
        }
        if (!this.f455b.hasNext()) {
            return false;
        }
        consumer.accept(this.f455b.next());
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        if (this.f455b != null) {
            return this.f457d;
        }
        this.f455b = this.f454a.iterator();
        long size = this.f454a.size();
        this.f457d = size;
        return size;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f456c;
    }

    @Override // p004j$.util.Spliterator
    public Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
