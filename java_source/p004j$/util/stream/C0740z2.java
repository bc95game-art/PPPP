package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.z2 */
/* loaded from: classes2.dex */
public final class C0740z2 extends C0571i2 implements AbstractC0710w1 {
    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0710w1
    /* renamed from: build */
    public final AbstractC0531e2 mo903build() {
        int i = this.f596b;
        Object[] objArr = this.f595a;
        if (i >= objArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.f596b), Integer.valueOf(objArr.length)));
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        Object[] objArr = this.f595a;
        if (j == objArr.length) {
            this.f596b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(objArr.length)));
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f596b;
        Object[] objArr = this.f595a;
        if (i < objArr.length) {
            this.f596b = i + 1;
            objArr[i] = obj;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(objArr.length)));
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int i = this.f596b;
        Object[] objArr = this.f595a;
        if (i < objArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.f596b), Integer.valueOf(objArr.length)));
        }
    }

    @Override // p004j$.util.stream.C0571i2
    public final String toString() {
        Object[] objArr = this.f595a;
        return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(objArr.length - this.f596b), Arrays.toString(objArr));
    }
}
