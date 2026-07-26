package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.ViewModelProvider;
import com.android.billingclient.api.zzcl;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class NotificationCompat$Builder {
    public String mCategory;
    public String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public final Notification mNotification;
    public zzcl mStyle;
    public final ArrayList mActions = new ArrayList();
    public final ArrayList mPersonList = new ArrayList();
    public final ArrayList mInvisibleActions = new ArrayList();
    public final boolean mShowWhen = true;
    public boolean mLocalOnly = false;
    public int mColor = 0;
    public int mVisibility = 0;
    public int mPriority = 0;
    public final ArrayList mPeople = new ArrayList();
    public final boolean mAllowSystemGeneratedContextualActions = true;

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        if (charSequence == null) {
            return charSequence;
        }
        if (charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.lang.CharSequence, long[], android.net.Uri, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v26 */
    public final Notification build() {
        Notification.Builder builder;
        boolean z;
        boolean z2;
        boolean z3;
        ?? r6;
        CharSequence charSequence;
        Notification notification;
        Bundle bundle;
        int i;
        Bundle bundle2;
        int i2;
        ArrayList arrayList;
        Notification.Action.Builder builder2;
        Bundle bundle3;
        int i3;
        Icon icon;
        int i4;
        new ArrayList();
        Bundle bundle4 = new Bundle();
        int i5 = Build.VERSION.SDK_INT;
        Context context = this.mContext;
        if (i5 >= 26) {
            builder = NotificationCompatBuilder$Api26Impl.createBuilder(context, this.mChannelId);
        } else {
            builder = new Notification.Builder(context);
        }
        Notification notification2 = this.mNotification;
        Notification.Builder lights = builder.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, null).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS);
        boolean z4 = true;
        if ((notification2.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z);
        if ((notification2.flags & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z2);
        if ((notification2.flags & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z3).setDefaults(notification2.defaults).setContentTitle(this.mContentTitle).setContentText(this.mContentText).setContentInfo(null).setContentIntent(this.mContentIntent).setDeleteIntent(notification2.deleteIntent);
        if ((notification2.flags & 128) == 0) {
            z4 = false;
        }
        deleteIntent.setFullScreenIntent(null, z4).setNumber(0).setProgress(0, 0, false);
        int i6 = 23;
        if (i5 < 23) {
            builder.setLargeIcon((Bitmap) null);
        } else {
            NotificationCompatBuilder$Api23Impl.setLargeIcon(builder, null);
        }
        builder.setSubText(null).setUsesChronometer(false).setPriority(this.mPriority);
        ArrayList arrayList2 = this.mActions;
        int size = arrayList2.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList2.get(i7);
            i7++;
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action) obj;
            int i8 = Build.VERSION.SDK_INT;
            if (notificationCompat$Action.mIcon == null && (i4 = notificationCompat$Action.icon) != 0) {
                notificationCompat$Action.mIcon = IconCompat.createWithResource(i4);
            }
            IconCompat iconCompat = notificationCompat$Action.mIcon;
            boolean z5 = notificationCompat$Action.mAllowGeneratedReplies;
            Bundle bundle5 = notificationCompat$Action.mExtras;
            PendingIntent pendingIntent = notificationCompat$Action.actionIntent;
            CharSequence charSequence2 = notificationCompat$Action.title;
            if (i8 >= i6) {
                if (iconCompat == null) {
                    icon = null;
                } else if (i8 >= i6) {
                    icon = IconCompat.Api23Impl.toIcon(iconCompat, null);
                } else {
                    throw new UnsupportedOperationException("This method is only supported on API level 23+");
                }
                builder2 = NotificationCompatBuilder$Api23Impl.createBuilder(icon, charSequence2, pendingIntent);
            } else {
                if (iconCompat != null) {
                    i3 = iconCompat.getResId();
                } else {
                    i3 = 0;
                }
                builder2 = NotificationCompatBuilder$Api20Impl.createBuilder(i3, charSequence2, pendingIntent);
            }
            if (bundle5 != null) {
                bundle3 = new Bundle(bundle5);
            } else {
                bundle3 = new Bundle();
            }
            bundle3.putBoolean("android.support.allowGeneratedReplies", z5);
            if (i8 >= 24) {
                NotificationCompatBuilder$Api24Impl.setAllowGeneratedReplies(builder2, z5);
            }
            bundle3.putInt("android.support.action.semanticAction", 0);
            if (i8 >= 28) {
                NotificationCompatBuilder$Api28Impl.setSemanticAction(builder2, 0);
            }
            if (i8 >= 29) {
                NotificationCompatBuilder$Api29Impl.setContextual(builder2, false);
            }
            if (i8 >= 31) {
                NotificationCompatBuilder$Api31Impl.setAuthenticationRequired(builder2, false);
            }
            bundle3.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action.mShowsUserInterface);
            NotificationCompatBuilder$Api20Impl.addExtras(builder2, bundle3);
            NotificationCompatBuilder$Api20Impl.addAction(builder, NotificationCompatBuilder$Api20Impl.build(builder2));
            i6 = 23;
        }
        Bundle bundle6 = this.mExtras;
        if (bundle6 != null) {
            bundle4.putAll(bundle6);
        }
        int i9 = Build.VERSION.SDK_INT;
        builder.setShowWhen(this.mShowWhen);
        NotificationCompatBuilder$Api20Impl.setLocalOnly(builder, this.mLocalOnly);
        NotificationCompatBuilder$Api20Impl.setGroup(builder, null);
        NotificationCompatBuilder$Api20Impl.setSortKey(builder, null);
        NotificationCompatBuilder$Api20Impl.setGroupSummary(builder, false);
        NotificationCompatBuilder$Api21Impl.setCategory(builder, this.mCategory);
        NotificationCompatBuilder$Api21Impl.setColor(builder, this.mColor);
        NotificationCompatBuilder$Api21Impl.setVisibility(builder, this.mVisibility);
        NotificationCompatBuilder$Api21Impl.setPublicVersion(builder, null);
        NotificationCompatBuilder$Api21Impl.setSound(builder, notification2.sound, notification2.audioAttributes);
        ArrayList arrayList3 = this.mPeople;
        ArrayList arrayList4 = this.mPersonList;
        if (i9 < 28) {
            if (arrayList4 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList4.size());
                Iterator it = arrayList4.iterator();
                if (it.hasNext()) {
                    throw ViewModelProvider.Factory.CC.m(it);
                }
            }
            if (arrayList != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList;
                } else {
                    ArraySet arraySet = new ArraySet(arrayList3.size() + arrayList.size());
                    arraySet.addAll(arrayList);
                    arraySet.addAll(arrayList3);
                    arrayList3 = new ArrayList(arraySet);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList3.get(i10);
                i10++;
                NotificationCompatBuilder$Api21Impl.addPerson(builder, (String) obj2);
            }
        }
        ArrayList arrayList5 = this.mInvisibleActions;
        if (arrayList5.size() > 0) {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            Bundle bundle7 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle7 == null) {
                bundle7 = new Bundle();
            }
            Bundle bundle8 = new Bundle(bundle7);
            Bundle bundle9 = new Bundle();
            int i11 = 0;
            while (i11 < arrayList5.size()) {
                String num = Integer.toString(i11);
                NotificationCompat$Action notificationCompat$Action2 = (NotificationCompat$Action) arrayList5.get(i11);
                Bundle bundle10 = new Bundle();
                if (notificationCompat$Action2.mIcon == null && (i2 = notificationCompat$Action2.icon) != 0) {
                    notificationCompat$Action2.mIcon = IconCompat.createWithResource(i2);
                }
                IconCompat iconCompat2 = notificationCompat$Action2.mIcon;
                Bundle bundle11 = notificationCompat$Action2.mExtras;
                if (iconCompat2 != null) {
                    i = iconCompat2.getResId();
                } else {
                    i = 0;
                }
                ArrayList arrayList6 = arrayList5;
                bundle10.putInt("icon", i);
                bundle10.putCharSequence(AppIntroBaseFragmentKt.ARG_TITLE, notificationCompat$Action2.title);
                bundle10.putParcelable("actionIntent", notificationCompat$Action2.actionIntent);
                if (bundle11 != null) {
                    bundle2 = new Bundle(bundle11);
                } else {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action2.mAllowGeneratedReplies);
                bundle10.putBundle("extras", bundle2);
                bundle10.putParcelableArray("remoteInputs", null);
                bundle10.putBoolean("showsUserInterface", notificationCompat$Action2.mShowsUserInterface);
                bundle10.putInt("semanticAction", 0);
                bundle9.putBundle(num, bundle10);
                i11++;
                arrayList5 = arrayList6;
            }
            bundle7.putBundle("invisible_actions", bundle9);
            bundle8.putBundle("invisible_actions", bundle9);
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle7);
            bundle4.putBundle("android.car.EXTENSIONS", bundle8);
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 24) {
            builder.setExtras(this.mExtras);
            r6 = 0;
            NotificationCompatBuilder$Api24Impl.setRemoteInputHistory(builder, null);
        } else {
            r6 = 0;
        }
        if (i12 >= 26) {
            NotificationCompatBuilder$Api26Impl.setBadgeIconType(builder, 0);
            NotificationCompatBuilder$Api26Impl.setSettingsText(builder, r6);
            NotificationCompatBuilder$Api26Impl.setShortcutId(builder, r6);
            NotificationCompatBuilder$Api26Impl.setTimeoutAfter(builder, 0L);
            NotificationCompatBuilder$Api26Impl.setGroupAlertBehavior(builder, 0);
            if (!TextUtils.isEmpty(this.mChannelId)) {
                builder.setSound(r6).setDefaults(0).setLights(0, 0, 0).setVibrate(r6);
            }
        }
        if (i12 >= 28) {
            Iterator it2 = arrayList4.iterator();
            if (it2.hasNext()) {
                throw ViewModelProvider.Factory.CC.m(it2);
            }
        }
        if (i12 >= 29) {
            NotificationCompatBuilder$Api29Impl.setAllowSystemGeneratedContextualActions(builder, this.mAllowSystemGeneratedContextualActions);
            charSequence = null;
            NotificationCompatBuilder$Api29Impl.setBubbleMetadata(builder, null);
        } else {
            charSequence = null;
        }
        zzcl zzclVar = this.mStyle;
        if (zzclVar != null) {
            new Notification.BigTextStyle(builder).setBigContentTitle(charSequence).bigText((CharSequence) zzclVar.zzc);
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26) {
            notification = builder.build();
        } else if (i13 >= 24) {
            notification = builder.build();
        } else {
            builder.setExtras(bundle4);
            notification = builder.build();
        }
        if (zzclVar != null) {
            this.mStyle.getClass();
        }
        if (!(zzclVar == null || (bundle = notification.extras) == null)) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
        }
        return notification;
    }

    public final void setFlag(int i, boolean z) {
        Notification notification = this.mNotification;
        if (z) {
            notification.flags = i | notification.flags;
            return;
        }
        notification.flags = (~i) & notification.flags;
    }

    public final void setStyle(zzcl zzclVar) {
        if (this.mStyle != zzclVar) {
            this.mStyle = zzclVar;
            if (((NotificationCompat$Builder) zzclVar.zzb) != this) {
                zzclVar.zzb = this;
                setStyle(zzclVar);
            }
        }
    }
}
