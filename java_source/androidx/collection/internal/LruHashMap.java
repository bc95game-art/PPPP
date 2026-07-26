package androidx.collection.internal;

import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.FakeDrag;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class LruHashMap {
    public final LinkedHashMap map;

    public LruHashMap(int i) {
        switch (i) {
            case 1:
                this.map = new LinkedHashMap();
                return;
            default:
                this.map = new LinkedHashMap(0, 0.75f, true);
                return;
        }
    }

    public void addInitializer(ClassReference classReference, Function1 function1) {
        LinkedHashMap linkedHashMap = this.map;
        if (!linkedHashMap.containsKey(classReference)) {
            linkedHashMap.put(classReference, new ViewModelInitializer(classReference, function1));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + Navigation.getCanonicalName(classReference) + '.').toString());
    }

    public FakeDrag build() {
        Collection initializers = this.map.values();
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) initializers.toArray(new ViewModelInitializer[0]);
        return new FakeDrag((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
