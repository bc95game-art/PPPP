package p004j$.util.concurrent;
/* renamed from: j$.util.concurrent.v */
/* loaded from: classes2.dex */
public final class C0430v extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
