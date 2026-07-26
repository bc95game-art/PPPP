package androidx.navigation;

import androidx.collection.internal.LruHashMap;
import androidx.viewpager2.widget.FakeDrag;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public abstract class NavControllerViewModelKt {
    public static final FakeDrag FACTORY;

    static {
        LruHashMap lruHashMap = new LruHashMap(1);
        lruHashMap.addInitializer(Reflection.getOrCreateKotlinClass(NavControllerViewModel.class), new Navigation$$ExternalSyntheticLambda0(3));
        FACTORY = lruHashMap.build();
    }
}
