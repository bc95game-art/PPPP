package com.github.appintro.internal;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class PermissionWrapper implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private String[] permissions;
    private int position;
    private boolean required;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PermissionWrapper(String[] permissions, int i, boolean z) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissions = permissions;
        this.position = i;
        this.required = z;
    }

    public static /* synthetic */ PermissionWrapper copy$default(PermissionWrapper permissionWrapper, String[] strArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            strArr = permissionWrapper.permissions;
        }
        if ((i2 & 2) != 0) {
            i = permissionWrapper.position;
        }
        if ((i2 & 4) != 0) {
            z = permissionWrapper.required;
        }
        return permissionWrapper.copy(strArr, i, z);
    }

    public final String[] component1() {
        return this.permissions;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.required;
    }

    public final PermissionWrapper copy(String[] permissions, int i, boolean z) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new PermissionWrapper(permissions, i, z);
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        if (!PermissionWrapper.class.equals(cls)) {
            return false;
        }
        if (obj != null) {
            PermissionWrapper permissionWrapper = (PermissionWrapper) obj;
            if (Arrays.equals(this.permissions, permissionWrapper.permissions) && this.position == permissionWrapper.position && this.required == permissionWrapper.required) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.github.appintro.internal.PermissionWrapper");
    }

    public final String[] getPermissions() {
        return this.permissions;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        int i;
        int hashCode = ((Arrays.hashCode(this.permissions) * 31) + this.position) * 31;
        if (this.required) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    public final void setPermissions(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.permissions = strArr;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    public String toString() {
        return "PermissionWrapper(permissions=" + Arrays.toString(this.permissions) + ", position=" + this.position + ", required=" + this.required + ')';
    }

    public /* synthetic */ PermissionWrapper(String[] strArr, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr, i, (i2 & 4) != 0 ? true : z);
    }
}
