package kotlin.jvm.internal;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class Lambda implements FunctionBase, Serializable {
    public final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final String toString() {
        Reflection.factory.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "renderLambdaToString(...)");
        return obj;
    }
}
