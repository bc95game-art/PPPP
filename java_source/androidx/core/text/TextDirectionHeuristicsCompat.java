package androidx.core.text;

import com.android.billingclient.api.zzcn;
/* loaded from: classes.dex */
public abstract class TextDirectionHeuristicsCompat {
    public static final zzcn FIRSTSTRONG_LTR;
    public static final zzcn FIRSTSTRONG_RTL;
    public static final zzcn LTR = new zzcn((FirstStrong) null, false);
    public static final zzcn RTL = new zzcn((FirstStrong) null, true);

    /* loaded from: classes.dex */
    public final class FirstStrong {
        public static final FirstStrong INSTANCE = new Object();
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new zzcn(firstStrong, false);
        FIRSTSTRONG_RTL = new zzcn(firstStrong, true);
    }
}
