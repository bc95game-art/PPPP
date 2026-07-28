package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModelProvider;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class NavType {
    public final boolean isNullableAllowed;
    public static final IntNavType IntType = new IntNavType(0, false);
    public static final IntNavType ReferenceType = new IntNavType(4, false);
    public static final IntListNavType IntArrayType = new IntListNavType(5, true);
    public static final IntListNavType IntListType = new IntListNavType(0, true);
    public static final IntNavType LongType = new IntNavType(3, false);
    public static final IntListNavType LongArrayType = new IntListNavType(6, true);
    public static final IntListNavType LongListType = new IntListNavType(7, true);
    public static final IntNavType FloatType = new IntNavType(2, false);
    public static final IntListNavType FloatArrayType = new IntListNavType(3, true);
    public static final IntListNavType FloatListType = new IntListNavType(4, true);
    public static final IntNavType BoolType = new IntNavType(1, false);
    public static final IntListNavType BoolArrayType = new IntListNavType(1, true);
    public static final IntListNavType BoolListType = new IntListNavType(2, true);
    public static final IntNavType StringType = new IntNavType(5, true);
    public static final IntListNavType StringArrayType = new IntListNavType(8, true);
    public static final IntListNavType StringListType = new IntListNavType(9, true);

    /* loaded from: classes.dex */
    public final class ParcelableArrayType extends NavType {
        public final Class arrayType;

        public ParcelableArrayType(Class cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.arrayType = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !ParcelableArrayType.class.equals(obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.arrayType, ((ParcelableArrayType) obj).arrayType);
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return (Parcelable[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.arrayType.getName();
        }

        public final int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* renamed from: parseValue */
        public final Object mo649parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String key, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            Intrinsics.checkNotNullParameter(key, "key");
            this.arrayType.cast(parcelableArr);
            bundle.putParcelableArray(key, parcelableArr);
        }
    }

    /* loaded from: classes.dex */
    public final class ParcelableType extends NavType {
        public final Class type;

        public ParcelableType(Class cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !ParcelableType.class.equals(obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.type, ((ParcelableType) obj).type);
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.type.getName();
        }

        public final int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* renamed from: parseValue */
        public final Object mo649parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String key, Object obj) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.type.cast(obj);
            if (obj == null || (obj instanceof Parcelable)) {
                bundle.putParcelable(key, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SerializableArrayType extends NavType {
        public final Class arrayType;

        public SerializableArrayType(Class cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.arrayType = Class.forName("[L" + cls.getName() + ';');
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !SerializableArrayType.class.equals(obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.arrayType, ((SerializableArrayType) obj).arrayType);
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public final String getName() {
            return this.arrayType.getName();
        }

        public final int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        /* renamed from: parseValue */
        public final Object mo649parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String key, Object obj) {
            ?? r4 = (Serializable[]) obj;
            Intrinsics.checkNotNullParameter(key, "key");
            this.arrayType.cast(r4);
            bundle.putSerializable(key, r4);
        }
    }

    /* loaded from: classes.dex */
    public class SerializableType extends NavType {
        public final Class type;

        public SerializableType(Class cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (!cls.isEnum()) {
                this.type = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return Intrinsics.areEqual(this.type, ((SerializableType) obj).type);
        }

        @Override // androidx.navigation.NavType
        public final Object get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return this.type.getName();
        }

        public final int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public final void put(Bundle bundle, String key, Object obj) {
            Serializable value = (Serializable) obj;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.type.cast(value);
            bundle.putSerializable(key, value);
        }

        @Override // androidx.navigation.NavType
        /* renamed from: parseValue */
        public Serializable mo649parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public SerializableType(int i, Class cls) {
            super(false);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    public abstract Object get(Bundle bundle, String str);

    public abstract String getName();

    public Object parseValue(Object obj, String str) {
        return mo649parseValue(str);
    }

    /* renamed from: parseValue */
    public abstract Object mo649parseValue(String str);

    public abstract void put(Bundle bundle, String str, Object obj);

    public String serializeAsValue(Object obj) {
        return String.valueOf(obj);
    }

    public final String toString() {
        return getName();
    }

    /* loaded from: classes.dex */
    public final class EnumType extends SerializableType {
        public final Class type;

        public EnumType(Class cls) {
            super(0, cls);
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public final String getName() {
            return this.type.getName();
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        /* renamed from: parseValue */
        public final Enum mo649parseValue(String value) {
            Enum r5;
            Intrinsics.checkNotNullParameter(value, "value");
            Class cls = this.type;
            Object[] enumConstants = cls.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "getEnumConstants(...)");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    r5 = null;
                    break;
                }
                r5 = enumConstants[i];
                String name = ((Enum) r5).name();
                if (name == null ? false : name.equalsIgnoreCase(value)) {
                    break;
                }
                i++;
            }
            Enum r52 = r5;
            if (r52 != null) {
                return r52;
            }
            StringBuilder m = ViewModelProvider.Factory.CC.m594m("Enum value ", value, " not found for type ");
            m.append(cls.getName());
            m.append('.');
            throw new IllegalArgumentException(m.toString());
        }
    }
}
