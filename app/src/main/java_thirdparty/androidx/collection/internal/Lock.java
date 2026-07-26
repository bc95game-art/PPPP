package androidx.collection.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import com.emanuelef.remote_capture.R;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzk;
import com.google.android.gms.common.zzm;
import com.google.android.gms.common.zzn;
import com.google.android.gms.tasks.zzu;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.ClassReference;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public class Lock implements ViewModelProvider.Factory, CreationExtras.Key, Preference.SummaryProvider, ProfileInstaller$DiagnosticsCallback, Factory, Clock {
    public static Lock sSimpleSummaryProvider;
    public static Lock zza;

    public Lock(View view) {
    }

    public static RectF calculateIndicatorWidthForTab(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.tabIndicatorFullWidth || !(view instanceof TabLayout.TabView)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        TabLayout.TabView tabView = (TabLayout.TabView) view;
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int dpToPx = (int) ViewUtils.dpToPx(tabView.getContext(), 24);
        if (contentWidth < dpToPx) {
            contentWidth = dpToPx;
        }
        int right = (tabView.getRight() + tabView.getLeft()) / 2;
        int bottom = (tabView.getBottom() + tabView.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.collection.internal.Lock, java.lang.Object] */
    public static void getInstance(Context context) {
        zzah.checkNotNull(context);
        synchronized (Lock.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    ?? obj = new Object();
                    context.getApplicationContext();
                    zza = obj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0075, code lost:
        if (r11 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a2, code lost:
        if (r10 != (-1)) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean handleDeleteSurroundingText(androidx.emoji2.viewsintegration.EmojiInputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.internal.Lock.handleDeleteSurroundingText(androidx.emoji2.viewsintegration.EmojiInputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo) {
        boolean z;
        PackageInfo packageInfo2;
        zzj zzjVar;
        boolean z2;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                z = z2;
            } else {
                z = true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
            z = true;
        }
        if (!(packageInfo == null || packageInfo2.signatures == null)) {
            if (z) {
                zzjVar = zza(packageInfo2, zzm.zza);
            } else {
                zzjVar = zza(packageInfo2, zzm.zza[0]);
            }
            if (zzjVar != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        ViewModel create;
        create = create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
        return create;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new zzu(Executors.newSingleThreadExecutor());
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override // androidx.preference.Preference.SummaryProvider
    public CharSequence provideSummary(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (TextUtils.isEmpty(editTextPreference.mText)) {
            return editTextPreference.mContext.getString(R.string.not_set);
        }
        return editTextPreference.mText;
    }

    public void updateIndicatorForOffset(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = calculateIndicatorWidthForTab(tabLayout, view2);
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, f, (int) calculateIndicatorWidthForTab2.left), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, f, (int) calculateIndicatorWidthForTab2.right), drawable.getBounds().bottom);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class cls) {
        return new FragmentManagerViewModel(true);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        return create(cls);
    }
}
