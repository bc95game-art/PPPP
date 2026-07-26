package p004j$.util;

import java.security.AccessController;
/* renamed from: j$.util.r1 */
/* loaded from: classes2.dex */
public abstract class AbstractC0485r1 {

    /* renamed from: a */
    public static final boolean f472a = ((Boolean) AccessController.doPrivileged(new C0482q1(0))).booleanValue();

    /* renamed from: a */
    public static void m227a(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
