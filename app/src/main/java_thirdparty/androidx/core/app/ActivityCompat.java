package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class ActivityCompat extends BundleKt {

    /* renamed from: androidx.core.app.ActivityCompat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$activity;
        public final /* synthetic */ Object val$permissionsArray;
        public final /* synthetic */ int val$requestCode;

        public /* synthetic */ AnonymousClass1(int i, int i2, Object obj, Object obj2) {
            this.$r8$classId = i2;
            this.val$permissionsArray = obj;
            this.val$activity = obj2;
            this.val$requestCode = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityResultCallback activityResultCallback;
            switch (this.$r8$classId) {
                case 0:
                    String[] strArr = (String[]) this.val$permissionsArray;
                    int[] iArr = new int[strArr.length];
                    Activity activity = (Activity) this.val$activity;
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(this.val$requestCode, strArr, iArr);
                    return;
                case 1:
                    ComponentActivity.AnonymousClass1 r0 = (ComponentActivity.AnonymousClass1) this.val$activity;
                    Serializable serializable = (Serializable) ((FakeDrag) this.val$permissionsArray).mScrollEventAdapter;
                    String str = (String) r0.mRcToKey.get(Integer.valueOf(this.val$requestCode));
                    if (str != null) {
                        ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) r0.mKeyToCallback.get(str);
                        if (callbackAndContract == null || (activityResultCallback = callbackAndContract.mCallback) == null) {
                            r0.mPendingResults.remove(str);
                            r0.mParsedPendingResults.put(str, serializable);
                            return;
                        } else if (r0.mLaunchedKeys.remove(str)) {
                            activityResultCallback.onActivityResult(serializable);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    ((ComponentActivity.AnonymousClass1) this.val$activity).dispatchResult(this.val$requestCode, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.val$permissionsArray));
                    return;
                case 3:
                    ((TextView) this.val$permissionsArray).setTypeface((Typeface) this.val$activity, this.val$requestCode);
                    return;
                default:
                    ((BottomSheetBehavior) this.val$activity).startSettling((View) this.val$permissionsArray, this.val$requestCode, false);
                    return;
            }
        }

        public /* synthetic */ AnonymousClass1(ComponentActivity.AnonymousClass1 r1, int i, Object obj, int i2) {
            this.$r8$classId = i2;
            this.val$activity = r1;
            this.val$requestCode = i;
            this.val$permissionsArray = obj;
        }

        public AnonymousClass1(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.$r8$classId = 4;
            this.val$activity = bottomSheetBehavior;
            this.val$permissionsArray = view;
            this.val$requestCode = i;
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api23Impl {
        public static void onSharedElementsReady(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void requestPermissions(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api31Impl {
        public static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api32Impl {
        public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!TextUtils.isEmpty(strArr[i2])) {
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i2));
                }
            } else {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size != strArr.length) {
                int i3 = 0;
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    if (!hashSet.contains(Integer.valueOf(i4))) {
                        strArr2[i3] = strArr[i4];
                        i3++;
                    }
                }
            } else {
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            Api23Impl.requestPermissions(activity, strArr, i);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(i, 0, strArr2, activity));
        }
    }

    public static boolean shouldShowRequestPermissionRationale(AppCompatActivity appCompatActivity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i >= 32) {
            return Api32Impl.shouldShowRequestPermissionRationale(appCompatActivity, str);
        }
        if (i == 31) {
            return Api31Impl.shouldShowRequestPermissionRationale(appCompatActivity, str);
        }
        if (i >= 23) {
            return Api23Impl.shouldShowRequestPermissionRationale(appCompatActivity, str);
        }
        return false;
    }
}
