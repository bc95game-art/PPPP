package androidx.lifecycle.viewmodel;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
/* loaded from: classes.dex */
public final class ViewModelInitializer {
    public final ClassReference clazz;
    public final Function1 initializer;

    public ViewModelInitializer(ClassReference classReference, Function1 function1) {
        this.clazz = classReference;
        this.initializer = function1;
    }
}
