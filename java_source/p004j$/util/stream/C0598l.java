package p004j$.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
/* renamed from: j$.util.stream.l */
/* loaded from: classes2.dex */
public final class C0598l extends AbstractC0554g5 {

    /* renamed from: b */
    public final /* synthetic */ int f632b;

    /* renamed from: c */
    public Object f633c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0598l(AbstractC0488a aVar, AbstractC0594k5 k5Var, int i) {
        super(k5Var);
        this.f632b = i;
        this.f633c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0598l(AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f632b = 0;
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    public void end() {
        switch (this.f632b) {
            case 0:
                this.f633c = null;
                this.f566a.end();
                return;
            default:
                super.end();
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        switch (this.f632b) {
            case 0:
                this.f633c = new HashSet();
                this.f566a.mo23c(-1L);
                return;
            case 1:
            default:
                super.mo23c(j);
                return;
            case 2:
                this.f566a.mo23c(-1L);
                return;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f632b) {
            case 0:
                if (!((Set) this.f633c).contains(obj)) {
                    ((Set) this.f633c).add(obj);
                    this.f566a.accept((AbstractC0594k5) obj);
                    return;
                }
                return;
            case 1:
                ((Consumer) ((C0638p) this.f633c).f686t).accept(obj);
                this.f566a.accept((AbstractC0594k5) obj);
                return;
            case 2:
                if (((Predicate) ((C0638p) this.f633c).f686t).test(obj)) {
                    this.f566a.accept((AbstractC0594k5) obj);
                    return;
                }
                return;
            case 3:
                this.f566a.accept((AbstractC0594k5) ((Function) ((C0638p) this.f633c).f686t).apply(obj));
                return;
            case 4:
                this.f566a.accept(((ToIntFunction) ((C0679t0) this.f633c).f760t).applyAsInt(obj));
                return;
            case 5:
                this.f566a.accept(((ToLongFunction) ((C0520d1) this.f633c).f533t).applyAsLong(obj));
                return;
            default:
                this.f566a.accept(((ToDoubleFunction) ((C0688u) this.f633c).f772t).applyAsDouble(obj));
                return;
        }
    }
}
