package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        LinkedHashMap initialExtras2 = initialExtras.extras;
        Intrinsics.checkNotNullParameter(initialExtras2, "initialExtras");
        this.extras.putAll(initialExtras2);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public final Object get(CreationExtras.Key key) {
        return this.extras.get(key);
    }

    public /* synthetic */ MutableCreationExtras(int i) {
        this(CreationExtras.Empty.INSTANCE);
    }
}
