package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class IntNavType extends NavType {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntNavType(int i, boolean z) {
        super(z);
        this.$r8$classId = i;
    }

    @Override // androidx.navigation.NavType
    public final Object get(Bundle bundle, String str) {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                return Integer.valueOf(Navigation.m20getIntimpl(bundle, str));
            case 1:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                boolean z = bundle.getBoolean(str, false);
                if (z || !bundle.getBoolean(str, true)) {
                    return Boolean.valueOf(z);
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 2:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                float f = bundle.getFloat(str, Float.MIN_VALUE);
                if (f != Float.MIN_VALUE || bundle.getFloat(str, Float.MAX_VALUE) != Float.MAX_VALUE) {
                    return Float.valueOf(f);
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 3:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                long j = bundle.getLong(str, Long.MIN_VALUE);
                if (j != Long.MIN_VALUE || bundle.getLong(str, Long.MAX_VALUE) != Long.MAX_VALUE) {
                    return Long.valueOf(j);
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 4:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                return Integer.valueOf(Navigation.m20getIntimpl(bundle, str));
            default:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string != null) {
                    return string;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
        }
    }

    @Override // androidx.navigation.NavType
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "integer";
            case 1:
                return "boolean";
            case 2:
                return "float";
            case 3:
                return "long";
            case 4:
                return "reference";
            default:
                return "string";
        }
    }

    @Override // androidx.navigation.NavType
    /* renamed from: parseValue */
    public final Object mo19parseValue(String value) {
        int i;
        boolean z;
        String str;
        long j;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.startsWith("0x")) {
                    String substring = value.substring(2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    i = Integer.parseInt(substring, 16);
                } else {
                    i = Integer.parseInt(value);
                }
                return Integer.valueOf(i);
            case 1:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.equals("true")) {
                    z = true;
                } else if (value.equals("false")) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                }
                return Boolean.valueOf(z);
            case 2:
                Intrinsics.checkNotNullParameter(value, "value");
                return Float.valueOf(Float.parseFloat(value));
            case 3:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.endsWith("L")) {
                    str = value.substring(0, value.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                } else {
                    str = value;
                }
                if (value.startsWith("0x")) {
                    String substring2 = str.substring(2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    j = Long.parseLong(substring2, 16);
                } else {
                    j = Long.parseLong(str);
                }
                return Long.valueOf(j);
            case 4:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.startsWith("0x")) {
                    String substring3 = value.substring(2);
                    Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                    i2 = Integer.parseInt(substring3, 16);
                } else {
                    i2 = Integer.parseInt(value);
                }
                return Integer.valueOf(i2);
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                if (value.equals("null")) {
                    return null;
                }
                return value;
        }
    }

    @Override // androidx.navigation.NavType
    public final void put(Bundle bundle, String key, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int intValue = ((Number) obj).intValue();
                Intrinsics.checkNotNullParameter(key, "key");
                bundle.putInt(key, intValue);
                return;
            case 1:
                boolean booleanValue = ((Boolean) obj).booleanValue();
                Intrinsics.checkNotNullParameter(key, "key");
                bundle.putBoolean(key, booleanValue);
                return;
            case 2:
                float floatValue = ((Number) obj).floatValue();
                Intrinsics.checkNotNullParameter(key, "key");
                bundle.putFloat(key, floatValue);
                return;
            case 3:
                long longValue = ((Number) obj).longValue();
                Intrinsics.checkNotNullParameter(key, "key");
                bundle.putLong(key, longValue);
                return;
            case 4:
                int intValue2 = ((Number) obj).intValue();
                Intrinsics.checkNotNullParameter(key, "key");
                bundle.putInt(key, intValue2);
                return;
            default:
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (str != null) {
                    Navigation.m25putStringimpl(bundle, key, str);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
        }
    }

    @Override // androidx.navigation.NavType
    public String serializeAsValue(Object obj) {
        switch (this.$r8$classId) {
            case 5:
                String s = (String) obj;
                if (s == null) {
                    return "null";
                }
                Intrinsics.checkNotNullParameter(s, "s");
                String encode = Uri.encode(s, null);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
                return encode;
            default:
                return super.serializeAsValue(obj);
        }
    }
}
