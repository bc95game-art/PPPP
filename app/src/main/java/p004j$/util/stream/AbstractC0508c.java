package p004j$.util.stream;
/* renamed from: j$.util.stream.c */
/* loaded from: classes2.dex */
public abstract class AbstractC0508c {

    /* renamed from: a */
    public final int f505a;

    /* renamed from: b */
    public int f506b;

    /* renamed from: c */
    public int f507c;

    /* renamed from: d */
    public long[] f508d;

    public abstract void clear();

    public AbstractC0508c() {
        this.f505a = 4;
    }

    public AbstractC0508c(int i) {
        if (i >= 0) {
            this.f505a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    public final long count() {
        int i = this.f507c;
        if (i == 0) {
            return this.f506b;
        }
        return this.f508d[i] + this.f506b;
    }
}
