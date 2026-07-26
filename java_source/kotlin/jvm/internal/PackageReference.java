package kotlin.jvm.internal;

import androidx.activity.OnBackPressedDispatcher;
/* loaded from: classes.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final boolean equals(Object obj) {
        if (!(obj instanceof PackageReference) || !OnBackPressedDispatcher.class.equals(OnBackPressedDispatcher.class)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return OnBackPressedDispatcher.class;
    }

    public final int hashCode() {
        return OnBackPressedDispatcher.class.hashCode();
    }

    public final String toString() {
        return OnBackPressedDispatcher.class.toString() + " (Kotlin reflection is not available)";
    }
}
