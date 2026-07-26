package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.z6 */
/* loaded from: classes2.dex */
public abstract class AbstractC0744z6 implements Spliterator {

    /* renamed from: a */
    public final boolean f862a;

    /* renamed from: b */
    public final AbstractC0488a f863b;

    /* renamed from: c */
    public Supplier f864c;

    /* renamed from: d */
    public Spliterator f865d;

    /* renamed from: e */
    public AbstractC0594k5 f866e;

    /* renamed from: f */
    public BooleanSupplier f867f;

    /* renamed from: g */
    public long f868g;

    /* renamed from: h */
    public AbstractC0508c f869h;

    /* renamed from: i */
    public boolean f870i;

    /* renamed from: d */
    public abstract void mo19d();

    /* renamed from: e */
    public abstract AbstractC0744z6 mo18e(Spliterator spliterator);

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    public AbstractC0744z6(AbstractC0488a aVar, Supplier supplier, boolean z) {
        this.f863b = aVar;
        this.f864c = supplier;
        this.f865d = null;
        this.f862a = z;
    }

    public AbstractC0744z6(AbstractC0488a aVar, Spliterator spliterator, boolean z) {
        this.f863b = aVar;
        this.f864c = null;
        this.f865d = spliterator;
        this.f862a = z;
    }

    /* renamed from: c */
    public final void m20c() {
        if (this.f865d == null) {
            this.f865d = (Spliterator) this.f864c.get();
            this.f864c = null;
        }
    }

    /* renamed from: a */
    public final boolean m22a() {
        AbstractC0508c cVar = this.f869h;
        boolean z = false;
        if (cVar != null) {
            long j = this.f868g + 1;
            this.f868g = j;
            if (j < cVar.count()) {
                z = true;
            }
            if (z) {
                return z;
            }
            this.f868g = 0L;
            this.f869h.clear();
            return m21b();
        } else if (this.f870i) {
            return false;
        } else {
            m20c();
            mo19d();
            this.f868g = 0L;
            this.f866e.mo23c(this.f865d.getExactSizeIfKnown());
            return m21b();
        }
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public Spliterator mo899trySplit() {
        if (!this.f862a || this.f869h != null || this.f870i) {
            return null;
        }
        m20c();
        Spliterator trySplit = this.f865d.mo899trySplit();
        if (trySplit == null) {
            return null;
        }
        return mo18e(trySplit);
    }

    /* renamed from: b */
    public final boolean m21b() {
        while (this.f869h.count() == 0) {
            if (this.f866e.mo27e() || !this.f867f.getAsBoolean()) {
                if (this.f870i) {
                    return false;
                }
                this.f866e.end();
                this.f870i = true;
            }
        }
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        m20c();
        return this.f865d.estimateSize();
    }

    @Override // p004j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        m20c();
        if (EnumC0725x6.SIZED.m66l(this.f863b.f481m)) {
            return this.f865d.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        m20c();
        int i = this.f863b.f481m;
        int i2 = i & ((~i) >> 1) & EnumC0725x6.f827j & EnumC0725x6.f823f;
        return (i2 & 64) != 0 ? (i2 & (-16449)) | (this.f865d.characteristics() & 16448) : i2;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f865d);
    }
}
