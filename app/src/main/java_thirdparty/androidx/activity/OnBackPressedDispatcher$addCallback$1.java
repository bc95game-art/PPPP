package androidx.activity;

import java.io.Serializable;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final /* synthetic */ class OnBackPressedDispatcher$addCallback$1 implements Function0, FunctionBase, Serializable, Function {
    public final /* synthetic */ int $r8$classId;
    public final Object receiver;
    public transient OnBackPressedDispatcher$addCallback$1 reflected;
    public final boolean isTopLevel = false;
    public final int flags = 0;

    public OnBackPressedDispatcher$addCallback$1(int i, Object obj) {
        this.$r8$classId = i;
        this.receiver = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OnBackPressedDispatcher$addCallback$1) {
            OnBackPressedDispatcher$addCallback$1 onBackPressedDispatcher$addCallback$1 = (OnBackPressedDispatcher$addCallback$1) obj;
            if (this.flags != onBackPressedDispatcher$addCallback$1.flags || !this.receiver.equals(onBackPressedDispatcher$addCallback$1.receiver) || !getOwner().equals(onBackPressedDispatcher$addCallback$1.getOwner())) {
                return false;
            }
            return true;
        } else if (!(obj instanceof OnBackPressedDispatcher$addCallback$1)) {
            return false;
        } else {
            OnBackPressedDispatcher$addCallback$1 onBackPressedDispatcher$addCallback$12 = this.reflected;
            if (onBackPressedDispatcher$addCallback$12 == null) {
                Reflection.factory.getClass();
                this.reflected = this;
                onBackPressedDispatcher$addCallback$12 = this;
            }
            return obj.equals(onBackPressedDispatcher$addCallback$12);
        }
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.jvm.internal.ClassBasedDeclarationContainer, java.lang.Object] */
    public final ClassBasedDeclarationContainer getOwner() {
        if (!this.isTopLevel) {
            return Reflection.getOrCreateKotlinClass(OnBackPressedDispatcher.class);
        }
        Reflection.factory.getClass();
        return new Object();
    }

    public final int hashCode() {
        getOwner();
        return (((getOwner().hashCode() * 31) + 986734966) * 31) + 1065238079;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
                return Unit.INSTANCE;
            default:
                ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
                return Unit.INSTANCE;
        }
    }

    public final String toString() {
        OnBackPressedDispatcher$addCallback$1 onBackPressedDispatcher$addCallback$1 = this.reflected;
        if (onBackPressedDispatcher$addCallback$1 == null) {
            Reflection.factory.getClass();
            this.reflected = this;
            onBackPressedDispatcher$addCallback$1 = this;
        }
        if (onBackPressedDispatcher$addCallback$1 != this) {
            return onBackPressedDispatcher$addCallback$1.toString();
        }
        return "function updateEnabledCallbacks (Kotlin reflection is not available)";
    }
}
