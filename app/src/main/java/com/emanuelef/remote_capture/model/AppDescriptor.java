package com.emanuelef.remote_capture.model;

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
                        Log.w(TAG, "getUserBadgedIcon failed, using icons without badges: " + e.getMessage());
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
        To view partially-correct add '--show-bad-code' argument
    */
    public AppDescriptor(android.content.pm.PackageManager r8, android.content.pm.PackageInfo r9) {
        /*
            r7 = this;
            android.content.pm.ApplicationInfo r0 = r9.applicationInfo
            java.lang.CharSequence r0 = r0.loadLabel(r8)
            java.lang.String r2 = r0.toString()
            android.content.pm.ApplicationInfo r0 = r9.applicationInfo
            java.lang.String r4 = r0.packageName
            int r5 = r0.uid
            int r0 = r0.flags
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L18
            r6 = 1
            goto L1a
        L18:
            r1 = 0
            r6 = 0
        L1a:
            r3 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r1.mPm = r8
            r1.mPackageInfo = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.model.AppDescriptor.<init>(android.content.pm.PackageManager, android.content.pm.PackageInfo):void");
    }
}
