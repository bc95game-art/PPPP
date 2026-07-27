package com.google.android.gms.tasks;

import android.os.Parcel;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.internal.base.zac;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.LazyKt__LazyJVMKt;
import p004j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class zzr {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public Object zzb;
    public boolean zzc;

    public zzr() {
        this.$r8$classId = 0;
        this.zza = new Object();
    }

    public static String checkInstantiable(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    /* JADX WARN: Finally extract failed */
    public void doExecute(Api$Client api$Client, TaskCompletionSource taskCompletionSource) {
        FakeDrag fakeDrag = (FakeDrag) ((FakeDrag) this.zzb).mScrollEventAdapter;
        fakeDrag.getClass();
        zai zaiVar = (zai) ((zap) api$Client).getService();
        TelemetryData telemetryData = (TelemetryData) fakeDrag.mScrollEventAdapter;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(zaiVar.zab);
        int i = zac.$r8$clinit;
        if (telemetryData == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            telemetryData.writeToParcel(obtain, 0);
        }
        try {
            zaiVar.zaa.transact(1, obtain, null, 1);
            obtain.recycle();
            zzw zzwVar = taskCompletionSource.zza;
            synchronized (zzwVar.zza) {
                zzwVar.zzh();
                zzwVar.zzc = true;
                zzwVar.zze = null;
            }
            ((zzr) zzwVar.zzb).zzb(zzwVar);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0101, code lost:
        if (com.google.gson.internal.Streams.getRawType(r0[0]) != java.lang.String.class) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectConstructor get(TypeToken typeToken, boolean z) {
        ObjectConstructor objectConstructor;
        final String str;
        ObjectConstructor inputConnectionCompat$$ExternalSyntheticLambda0;
        final Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        Map map = (Map) this.zza;
        if (map.get(type) != null) {
            throw new ClassCastException();
        } else if (map.get(rawType) == null) {
            ObjectConstructor objectConstructor2 = null;
            if (EnumSet.class.isAssignableFrom(rawType)) {
                objectConstructor = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda8
                    @Override // com.google.gson.internal.ObjectConstructor
                    public final Object construct() {
                        switch (r2) {
                            case 0:
                                Type type2 = type;
                                if (type2 instanceof ParameterizedType) {
                                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                                    if (type3 instanceof Class) {
                                        return EnumSet.noneOf((Class) type3);
                                    }
                                    throw new RuntimeException("Invalid EnumSet type: " + type2.toString());
                                }
                                throw new RuntimeException("Invalid EnumSet type: " + type2.toString());
                            default:
                                Type type4 = type;
                                if (type4 instanceof ParameterizedType) {
                                    Type type5 = ((ParameterizedType) type4).getActualTypeArguments()[0];
                                    if (type5 instanceof Class) {
                                        return new EnumMap((Class) type5);
                                    }
                                    throw new RuntimeException("Invalid EnumMap type: " + type4.toString());
                                }
                                throw new RuntimeException("Invalid EnumMap type: " + type4.toString());
                        }
                    }
                };
            } else if (rawType == EnumMap.class) {
                objectConstructor = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda8
                    @Override // com.google.gson.internal.ObjectConstructor
                    public final Object construct() {
                        switch (r2) {
                            case 0:
                                Type type2 = type;
                                if (type2 instanceof ParameterizedType) {
                                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                                    if (type3 instanceof Class) {
                                        return EnumSet.noneOf((Class) type3);
                                    }
                                    throw new RuntimeException("Invalid EnumSet type: " + type2.toString());
                                }
                                throw new RuntimeException("Invalid EnumSet type: " + type2.toString());
                            default:
                                Type type4 = type;
                                if (type4 instanceof ParameterizedType) {
                                    Type type5 = ((ParameterizedType) type4).getActualTypeArguments()[0];
                                    if (type5 instanceof Class) {
                                        return new EnumMap((Class) type5);
                                    }
                                    throw new RuntimeException("Invalid EnumMap type: " + type4.toString());
                                }
                                throw new RuntimeException("Invalid EnumMap type: " + type4.toString());
                        }
                    }
                };
            } else {
                objectConstructor = null;
            }
            if (objectConstructor != null) {
                return objectConstructor;
            }
            Streams.getFilterResult((List) this.zzb);
            if (!Modifier.isAbstract(rawType.getModifiers())) {
                try {
                    Constructor declaredConstructor = rawType.getDeclaredConstructor(null);
                    LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
                    try {
                        declaredConstructor.setAccessible(true);
                        str = null;
                    } catch (Exception e) {
                        str = "Failed making constructor '" + ReflectionHelper.constructorToString(declaredConstructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage() + ReflectionHelper.getInaccessibleTroubleshootingSuffix(e);
                    }
                    if (str != null) {
                        inputConnectionCompat$$ExternalSyntheticLambda0 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda0
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r2) {
                                    case 0:
                                        throw new RuntimeException(str);
                                    case 1:
                                        throw new RuntimeException(str);
                                    case 2:
                                        throw new RuntimeException(str);
                                    default:
                                        throw new RuntimeException(str);
                                }
                            }
                        };
                    } else {
                        inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(18, declaredConstructor);
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (inputConnectionCompat$$ExternalSyntheticLambda0 == null) {
                    return inputConnectionCompat$$ExternalSyntheticLambda0;
                }
                if (Collection.class.isAssignableFrom(rawType)) {
                    if (rawType.isAssignableFrom(ArrayList.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    } else if (rawType.isAssignableFrom(LinkedHashSet.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    } else if (rawType.isAssignableFrom(TreeSet.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    } else if (rawType.isAssignableFrom(ArrayDeque.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    }
                } else if (Map.class.isAssignableFrom(rawType)) {
                    if (rawType.isAssignableFrom(LinkedTreeMap.class)) {
                        if (type instanceof ParameterizedType) {
                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                            if (actualTypeArguments.length != 0) {
                            }
                        }
                        objectConstructor2 = new TransportImpl$$ExternalSyntheticLambda0(28);
                    }
                    if (rawType.isAssignableFrom(LinkedHashMap.class)) {
                        objectConstructor2 = new TransportImpl$$ExternalSyntheticLambda0(29);
                    } else if (rawType.isAssignableFrom(TreeMap.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    } else if (rawType.isAssignableFrom(ConcurrentHashMap.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    } else if (rawType.isAssignableFrom(ConcurrentSkipListMap.class)) {
                        objectConstructor2 = new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda2
                            @Override // com.google.gson.internal.ObjectConstructor
                            public final Object construct() {
                                switch (r1) {
                                    case 0:
                                        return new ArrayList();
                                    case 1:
                                        return new TreeMap();
                                    case 2:
                                        return new ConcurrentHashMap();
                                    case 3:
                                        return new ConcurrentSkipListMap();
                                    case 4:
                                        return new LinkedHashSet();
                                    case 5:
                                        return new TreeSet();
                                    default:
                                        return new ArrayDeque();
                                }
                            }
                        };
                    }
                }
                if (objectConstructor2 != null) {
                    return objectConstructor2;
                }
                final String checkInstantiable = checkInstantiable(rawType);
                if (checkInstantiable != null) {
                    return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda0
                        @Override // com.google.gson.internal.ObjectConstructor
                        public final Object construct() {
                            switch (r2) {
                                case 0:
                                    throw new RuntimeException(checkInstantiable);
                                case 1:
                                    throw new RuntimeException(checkInstantiable);
                                case 2:
                                    throw new RuntimeException(checkInstantiable);
                                default:
                                    throw new RuntimeException(checkInstantiable);
                            }
                        }
                    };
                }
                if (!z) {
                    final String str2 = "Unable to create instance of " + rawType + "; Register an InstanceCreator or a TypeAdapter for this type.";
                    return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda0
                        @Override // com.google.gson.internal.ObjectConstructor
                        public final Object construct() {
                            switch (r2) {
                                case 0:
                                    throw new RuntimeException(str2);
                                case 1:
                                    throw new RuntimeException(str2);
                                case 2:
                                    throw new RuntimeException(str2);
                                default:
                                    throw new RuntimeException(str2);
                            }
                        }
                    };
                } else if (this.zzc) {
                    return new InputConnectionCompat$$ExternalSyntheticLambda0(19, rawType);
                } else {
                    final String str3 = "Unable to create instance of " + rawType + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
                    if (rawType.getDeclaredConstructors().length == 0) {
                        str3 = ViewModelProvider.Factory.CC.m596m(str3, " Or adjust your R8 configuration to keep the no-args constructor of the class.");
                    }
                    return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor$$ExternalSyntheticLambda0
                        @Override // com.google.gson.internal.ObjectConstructor
                        public final Object construct() {
                            switch (r2) {
                                case 0:
                                    throw new RuntimeException(str3);
                                case 1:
                                    throw new RuntimeException(str3);
                                case 2:
                                    throw new RuntimeException(str3);
                                default:
                                    throw new RuntimeException(str3);
                            }
                        }
                    };
                }
            }
            inputConnectionCompat$$ExternalSyntheticLambda0 = null;
            if (inputConnectionCompat$$ExternalSyntheticLambda0 == null) {
            }
        } else {
            throw new ClassCastException();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return ((Map) this.zza).toString();
            default:
                return super.toString();
        }
    }

    public void zzb(zzw zzwVar) {
        zzj zzjVar;
        synchronized (this.zza) {
            if (((ArrayDeque) this.zzb) != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            zzjVar = (zzj) ((ArrayDeque) this.zzb).poll();
                            if (zzjVar == null) {
                                this.zzc = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzjVar.zzd(zzwVar);
                }
            }
        }
    }

    public zzr(FakeDrag fakeDrag, Feature[] featureArr) {
        this.$r8$classId = 1;
        this.zzb = fakeDrag;
        this.zza = featureArr;
        this.zzc = false;
    }

    public zzr(Map map, boolean z, List list) {
        this.$r8$classId = 2;
        this.zza = map;
        this.zzc = z;
        this.zzb = list;
    }
}
