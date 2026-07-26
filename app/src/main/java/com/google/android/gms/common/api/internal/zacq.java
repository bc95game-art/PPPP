package com.google.android.gms.common.api.internal;

import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class zacq implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;

    public /* synthetic */ zacq() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                throw null;
            default:
                try {
                    Method method = TraceCompat.sIsTagEnabledMethod;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (EmojiCompat.sInstance != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        EmojiCompat.get().load();
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    Method method2 = TraceCompat.sIsTagEnabledMethod;
                    Trace.endSection();
                    throw th;
                }
        }
    }

    public zacq(zact zactVar) {
    }
}
