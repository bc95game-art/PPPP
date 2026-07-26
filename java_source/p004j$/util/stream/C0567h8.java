package p004j$.util.stream;
/* renamed from: j$.util.stream.h8 */
/* loaded from: classes2.dex */
public final class C0567h8 extends AbstractC0554g5 implements AbstractC0647p8 {

    /* renamed from: b */
    public long f587b;

    /* renamed from: c */
    public boolean f588c;

    /* renamed from: d */
    public final /* synthetic */ boolean f589d;

    /* renamed from: e */
    public final /* synthetic */ C0557g8 f590e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0567h8(C0557g8 g8Var, AbstractC0594k5 k5Var, boolean z) {
        super(k5Var);
        this.f590e = g8Var;
        this.f589d = z;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        boolean z;
        boolean z2;
        if (!this.f588c) {
            boolean test = this.f590e.f573t.test(obj);
            this.f588c = !test;
            if (test) {
                z = false;
                z2 = this.f589d;
                if (z2 && !z) {
                    this.f587b++;
                }
                if (!z2 || z) {
                    this.f566a.accept((AbstractC0594k5) obj);
                }
                return;
            }
        }
        z = true;
        z2 = this.f589d;
        if (z2) {
            this.f587b++;
        }
        if (!z2) {
        }
        this.f566a.accept((AbstractC0594k5) obj);
    }

    @Override // p004j$.util.stream.AbstractC0647p8
    /* renamed from: h */
    public final long mo166h() {
        return this.f587b;
    }
}
