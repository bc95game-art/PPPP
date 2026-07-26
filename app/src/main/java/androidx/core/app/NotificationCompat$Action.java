package androidx.core.app;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NotificationCompat$Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat iconCompat;
        int i2;
        if (i == 0) {
            iconCompat = null;
        } else {
            iconCompat = IconCompat.createWithResource(i);
        }
        Bundle bundle = new Bundle();
        this.mShowsUserInterface = true;
        this.mIcon = iconCompat;
        if (iconCompat != null) {
            int i3 = iconCompat.mType;
            if (i3 == -1 && (i2 = Build.VERSION.SDK_INT) >= 23) {
                Object obj = iconCompat.mObj1;
                if (i2 >= 28) {
                    i3 = IconCompat.Api28Impl.getType(obj);
                } else {
                    try {
                        i3 = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                    } catch (IllegalAccessException e) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e);
                        i3 = -1;
                        if (i3 == 2) {
                        }
                        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
                        this.actionIntent = pendingIntent;
                        this.mExtras = bundle;
                        this.mAllowGeneratedReplies = true;
                        this.mShowsUserInterface = true;
                    } catch (NoSuchMethodException e2) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                        i3 = -1;
                        if (i3 == 2) {
                        }
                        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
                        this.actionIntent = pendingIntent;
                        this.mExtras = bundle;
                        this.mAllowGeneratedReplies = true;
                        this.mShowsUserInterface = true;
                    } catch (InvocationTargetException e3) {
                        Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                        i3 = -1;
                        if (i3 == 2) {
                        }
                        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
                        this.actionIntent = pendingIntent;
                        this.mExtras = bundle;
                        this.mAllowGeneratedReplies = true;
                        this.mShowsUserInterface = true;
                    }
                }
            }
            if (i3 == 2) {
                this.icon = iconCompat.getResId();
            }
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
    }
}
