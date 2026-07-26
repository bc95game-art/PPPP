package android.support.p000v4.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
/* renamed from: android.support.v4.app.INotificationSideChannel */
/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: android.support.v4.app.INotificationSideChannel$Stub */
    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements INotificationSideChannel {
        public static final /* synthetic */ int $r8$clinit = 0;

        /* renamed from: android.support.v4.app.INotificationSideChannel$Stub$Proxy */
        /* loaded from: classes.dex */
        public final class Proxy implements INotificationSideChannel {
            public IBinder mRemote;

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }
        }
    }
}
