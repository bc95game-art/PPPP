package com.emanuelef.remote_capture.model;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.UserHandle;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.interfaces.DrawableLoader;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AppDescriptor implements Comparable<AppDescriptor>, Serializable {
    private static final String TAG = "AppDescriptor";
    private static boolean badgedIconFails = false;
    private String mDescription;
    private Drawable mIcon;
    private final DrawableLoader mIconLoader;
    private final boolean mIsSystem;
    private final String mName;
    PackageInfo mPackageInfo;
    private final String mPackageName;
    PackageManager mPm;
    private final int mUid;

    public AppDescriptor(String str, DrawableLoader drawableLoader, String str2, int i, boolean z) {
        this.mName = str;
        this.mIcon = null;
        this.mIconLoader = drawableLoader;
        this.mPackageName = str2;
        this.mUid = i;
        this.mIsSystem = z;
        this.mDescription = "";
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Drawable getIcon() {
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            return drawable;
        }
        DrawableLoader drawableLoader = this.mIconLoader;
        if (drawableLoader != null) {
            Drawable drawable2 = drawableLoader.getDrawable();
            this.mIcon = drawable2;
            return drawable2;
        } else if (this.mPackageInfo == null || this.mPm == null) {
            return null;
        } else {
            if (Build.VERSION.SDK_INT < 24 || !CaptureService.isCapturingAsRoot()) {
                this.mIcon = this.mPackageInfo.applicationInfo.loadIcon(this.mPm);
            } else {
                this.mIcon = this.mPackageInfo.applicationInfo.loadUnbadgedIcon(this.mPm);
                if (!badgedIconFails) {
                    try {
                        this.mIcon = this.mPm.getUserBadgedIcon(this.mIcon, UserHandle.getUserHandleForUid(this.mUid));
                    } catch (SecurityException e) {
                        Log.m581w(TAG, "getUserBadgedIcon failed, using icons without badges: " + e.getMessage());
                        badgedIconFails = true;
                    }
                }
            }
            return this.mIcon;
        }
    }

    public String getName() {
        return this.mName;
    }

    public PackageInfo getPackageInfo() {
        return this.mPackageInfo;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getUid() {
        return this.mUid;
    }

    public boolean isSystem() {
        return this.mIsSystem;
    }

    public boolean isVirtual() {
        if (this.mPackageInfo == null) {
            return true;
        }
        return false;
    }

    public boolean matches(String str, boolean z) {
        String lowerCase = getPackageName().toLowerCase();
        if (getName().toLowerCase().contains(str)) {
            return true;
        }
        if (z && lowerCase.equals(str)) {
            return true;
        }
        if (z || !lowerCase.contains(str)) {
            return false;
        }
        return true;
    }

    public AppDescriptor setDescription(String str) {
        this.mDescription = str;
        return this;
    }

    public int compareTo(AppDescriptor appDescriptor) {
        int compareTo = getName().toLowerCase().compareTo(appDescriptor.getName().toLowerCase());
        return compareTo == 0 ? getPackageName().compareTo(appDescriptor.getPackageName()) : compareTo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppDescriptor(PackageManager packageManager, PackageInfo packageInfo) {
        this(r2, null, r0.packageName, r0.uid, (r0.flags & 1) != 0);
        String charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        this.mPm = packageManager;
        this.mPackageInfo = packageInfo;
    }
}
