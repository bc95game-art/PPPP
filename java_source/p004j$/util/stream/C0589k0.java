package p004j$.util.stream;

import java.util.function.IntFunction;
import java.util.function.LongFunction;
import p004j$.util.C0440f;
import p004j$.util.stream.IntStream;
/* renamed from: j$.util.stream.k0 */
/* loaded from: classes2.dex */
public final class C0589k0 implements IntFunction, LongFunction {

    /* renamed from: a */
    public IntFunction f625a;

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        Object apply = this.f625a.apply(i);
        if (apply == null) {
            return null;
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        C0440f.m235a(apply.getClass(), "java.util.stream.IntStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        return AbstractC0692u3.m119Z(j, this.f625a);
    }
}
