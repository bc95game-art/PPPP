package p004j$.util;

import java.security.PrivilegedAction;
/* renamed from: j$.util.q1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0482q1 implements PrivilegedAction {

    /* renamed from: a */
    public final /* synthetic */ int f466a;

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f466a) {
            case 0:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
            case 1:
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            default:
                return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    }
}
