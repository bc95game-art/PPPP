package p004j$.util;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.u */
/* loaded from: classes2.dex */
public final class C0748u implements DoubleConsumer {

    /* renamed from: a */
    public double f877a;

    /* renamed from: b */
    public double f878b;
    private long count;
    private double sum;
    private double min = Double.POSITIVE_INFINITY;
    private double max = Double.NEGATIVE_INFINITY;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.count++;
        this.f878b += d;
        m12b(d);
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    /* renamed from: a */
    public final void m13a(C0748u uVar) {
        this.count += uVar.count;
        this.f878b += uVar.f878b;
        m12b(uVar.sum);
        m12b(uVar.f877a);
        this.min = Math.min(this.min, uVar.min);
        this.max = Math.max(this.max, uVar.max);
    }

    /* renamed from: b */
    public final void m12b(double d) {
        double d2 = d - this.f877a;
        double d3 = this.sum;
        double d4 = d3 + d2;
        this.f877a = (d4 - d3) - d2;
        this.sum = d4;
    }

    public final String toString() {
        double d;
        String simpleName = C0748u.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        double d2 = this.sum + this.f877a;
        if (Double.isNaN(d2) && Double.isInfinite(this.f878b)) {
            d2 = this.f878b;
        }
        Double valueOf2 = Double.valueOf(d2);
        Double valueOf3 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d3 = this.sum + this.f877a;
            if (Double.isNaN(d3) && Double.isInfinite(this.f878b)) {
                d3 = this.f878b;
            }
            d = d3 / this.count;
        } else {
            d = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(d), Double.valueOf(this.max));
    }
}
