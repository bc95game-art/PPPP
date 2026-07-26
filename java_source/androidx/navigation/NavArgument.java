package androidx.navigation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final class NavArgument {
    public final Object defaultValue;
    public final boolean isDefaultValuePresent;
    public final boolean isNullable;
    public final NavType type;

    public NavArgument(NavType navType, boolean z, Object obj, boolean z2) {
        if (!navType.isNullableAllowed && z) {
            throw new IllegalArgumentException(navType.getName().concat(" does not allow nullable values").toString());
        } else if (z || !z2 || obj != null) {
            this.type = navType;
            this.isNullable = z;
            this.defaultValue = obj;
            this.isDefaultValuePresent = z2;
        } else {
            throw new IllegalArgumentException(("Argument with type " + navType.getName() + " has null value but is not nullable.").toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavArgument.class == obj.getClass()) {
            NavArgument navArgument = (NavArgument) obj;
            Object obj2 = navArgument.defaultValue;
            if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !Intrinsics.areEqual(this.type, navArgument.type)) {
                return false;
            }
            Object obj3 = this.defaultValue;
            if (obj3 != null) {
                return Intrinsics.areEqual(obj3, obj2);
            }
            if (obj2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(NavArgument.class).getSimpleName());
        sb.append(" Type: " + this.type);
        sb.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb.append(" DefaultValue: " + this.defaultValue);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
