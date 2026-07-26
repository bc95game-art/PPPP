package p004j$.util.concurrent;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.concurrent.j */
/* loaded from: classes2.dex */
public final class C0418j extends C0424p implements Spliterator {

    /* renamed from: i */
    public final /* synthetic */ int f341i;

    /* renamed from: j */
    public long f342j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0418j(C0420l[] lVarArr, int i, int i2, int i3, long j, int i4) {
        super(lVarArr, i, i2, i3);
        this.f341i = i4;
        this.f342j = j;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        switch (this.f341i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f341i) {
            case 0:
                return AbstractC0279a.m519p(this);
            default:
                return AbstractC0279a.m519p(this);
        }
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        switch (this.f341i) {
            case 0:
                return AbstractC0279a.m517r(this, i);
            default:
                return AbstractC0279a.m517r(this, i);
        }
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        switch (this.f341i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        switch (this.f341i) {
            case 0:
                int i = this.f359f;
                int i2 = this.f360g;
                int i3 = (i + i2) >>> 1;
                if (i3 <= i) {
                    return null;
                }
                C0420l[] lVarArr = this.f354a;
                this.f360g = i3;
                long j = this.f342j >>> 1;
                this.f342j = j;
                return new C0418j(lVarArr, this.f361h, i3, i2, j, 0);
            default:
                int i4 = this.f359f;
                int i5 = this.f360g;
                int i6 = (i4 + i5) >>> 1;
                if (i6 <= i4) {
                    return null;
                }
                C0420l[] lVarArr2 = this.f354a;
                this.f360g = i6;
                long j2 = this.f342j >>> 1;
                this.f342j = j2;
                return new C0418j(lVarArr2, this.f361h, i6, i5, j2, 1);
        }
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        switch (this.f341i) {
            case 0:
                consumer.getClass();
                while (true) {
                    C0420l a = m249a();
                    if (a != null) {
                        consumer.accept(a.f347b);
                    } else {
                        return;
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    C0420l a2 = m249a();
                    if (a2 != null) {
                        consumer.accept(a2.f348c);
                    } else {
                        return;
                    }
                }
        }
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        switch (this.f341i) {
            case 0:
                consumer.getClass();
                C0420l a = m249a();
                if (a == null) {
                    return false;
                }
                consumer.accept(a.f347b);
                return true;
            default:
                consumer.getClass();
                C0420l a2 = m249a();
                if (a2 == null) {
                    return false;
                }
                consumer.accept(a2.f348c);
                return true;
        }
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        switch (this.f341i) {
            case 0:
                return this.f342j;
            default:
                return this.f342j;
        }
    }
}
