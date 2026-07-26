package p004j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
/* renamed from: j$.util.stream.j */
/* loaded from: classes2.dex */
public abstract class AbstractC0578j {

    /* renamed from: a */
    public static final /* synthetic */ int f608a = 0;

    static {
        EnumC0558h hVar = EnumC0558h.CONCURRENT;
        EnumC0558h hVar2 = EnumC0558h.UNORDERED;
        EnumC0558h hVar3 = EnumC0558h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2));
        Collections.unmodifiableSet(EnumSet.of(hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2, hVar3));
        Set set = Collections.EMPTY_SET;
        Collections.unmodifiableSet(EnumSet.of(hVar2));
    }

    /* renamed from: a */
    public static void m192a(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
    }
}
