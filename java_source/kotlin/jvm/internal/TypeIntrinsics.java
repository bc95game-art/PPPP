package kotlin.jvm.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
/* loaded from: classes.dex */
public abstract class TypeIntrinsics {
    public static Map asMutableMap(LinkedHashMap linkedHashMap) {
        if (!(linkedHashMap instanceof KMappedMarker) || (linkedHashMap instanceof KMutableMap)) {
            return linkedHashMap;
        }
        throwCce(linkedHashMap, "kotlin.collections.MutableMap");
        throw null;
    }

    public static void throwCce(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        ClassCastException classCastException = new ClassCastException(str2 + " cannot be cast to " + str);
        Intrinsics.sanitizeStackTrace(classCastException, TypeIntrinsics.class.getName());
        throw classCastException;
    }
}
