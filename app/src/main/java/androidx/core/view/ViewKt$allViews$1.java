package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Function;
import kotlin.Result$Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.ModuleNameRetriever;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequenceBuilderIterator;
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 implements FunctionBase, Function, Continuation, Serializable {
    public final /* synthetic */ View $this_allViews;
    public /* synthetic */ SequenceBuilderIterator L$0;
    public final int arity = 2;
    public final Continuation completion;
    public int label;

    public ViewKt$allViews$1(View view, SequenceBuilderIterator sequenceBuilderIterator) {
        this.$this_allViews = view;
        this.completion = sequenceBuilderIterator;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.arity;
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons;
        Unit unit = Unit.INSTANCE;
        int i = this.label;
        View view = this.$this_allViews;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i != 0) {
            if (i == 1) {
                SequenceBuilderIterator sequenceBuilderIterator = this.L$0;
                if (obj instanceof Result$Failure) {
                    throw ((Result$Failure) obj).exception;
                } else if (view instanceof ViewGroup) {
                    this.L$0 = null;
                    this.label = 2;
                    sequenceBuilderIterator.getClass();
                    TreeIterator treeIterator = new TreeIterator(new ArrayIterator(2, (ViewGroup) view));
                    if (!treeIterator.iterator.hasNext()) {
                        coroutineSingletons = unit;
                    } else {
                        sequenceBuilderIterator.nextIterator = treeIterator;
                        sequenceBuilderIterator.state = 2;
                        sequenceBuilderIterator.nextStep = this;
                        coroutineSingletons = coroutineSingletons2;
                    }
                    if (coroutineSingletons != coroutineSingletons2) {
                        coroutineSingletons = unit;
                    }
                    if (coroutineSingletons == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                }
            } else if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Result$Failure) {
                throw ((Result$Failure) obj).exception;
            }
            return unit;
        } else if (!(obj instanceof Result$Failure)) {
            SequenceBuilderIterator sequenceBuilderIterator2 = this.L$0;
            this.L$0 = sequenceBuilderIterator2;
            this.label = 1;
            sequenceBuilderIterator2.nextValue = view;
            sequenceBuilderIterator2.state = 3;
            sequenceBuilderIterator2.nextStep = this;
            return coroutineSingletons2;
        } else {
            throw ((Result$Failure) obj).exception;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Continuation continuation = this;
        while (true) {
            ViewKt$allViews$1 viewKt$allViews$1 = (ViewKt$allViews$1) continuation;
            Continuation continuation2 = viewKt$allViews$1.completion;
            Intrinsics.checkNotNull(continuation2);
            try {
                obj = viewKt$allViews$1.invokeSuspend(obj);
                if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return;
                }
            } catch (Throwable th) {
                obj = new Result$Failure(th);
            }
            if (continuation2 instanceof ViewKt$allViews$1) {
                continuation = continuation2;
            } else {
                continuation2.resumeWith(obj);
                return;
            }
        }
    }

    public final String toString() {
        if (this.completion != null) {
            return toString$kotlin$coroutines$jvm$internal$BaseContinuationImpl();
        }
        Reflection.factory.getClass();
        String obj = ViewKt$allViews$1.class.getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        Intrinsics.checkNotNullExpressionValue(obj, "renderLambdaToString(...)");
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StackTraceElement] */
    public final String toString$kotlin$coroutines$jvm$internal$BaseContinuationImpl() {
        int i;
        String str;
        Object obj;
        Object obj2;
        Object obj3;
        Integer num;
        int i2;
        StringBuilder sb = new StringBuilder("Continuation at ");
        DebugMetadata debugMetadata = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String str2 = null;
        if (debugMetadata != null) {
            int v = debugMetadata.m1v();
            if (v <= 1) {
                int i3 = -1;
                try {
                    Field declaredField = getClass().getDeclaredField("label");
                    declaredField.setAccessible(true);
                    Object obj4 = declaredField.get(this);
                    if (obj4 instanceof Integer) {
                        num = (Integer) obj4;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 0;
                    }
                    i = i2 - 1;
                } catch (Exception unused) {
                    i = -1;
                }
                if (i >= 0) {
                    i3 = debugMetadata.m3l()[i];
                }
                ModuleNameRetriever.Cache cache = ModuleNameRetriever.cache;
                ModuleNameRetriever.Cache cache2 = ModuleNameRetriever.notOnJava9;
                if (cache == null) {
                    try {
                        ModuleNameRetriever.Cache cache3 = new ModuleNameRetriever.Cache(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                        ModuleNameRetriever.cache = cache3;
                        cache = cache3;
                    } catch (Exception unused2) {
                        ModuleNameRetriever.cache = cache2;
                        cache = cache2;
                    }
                }
                if (cache != cache2) {
                    Method method = cache.getModuleMethod;
                    if (method != null) {
                        obj = method.invoke(getClass(), null);
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        Method method2 = cache.getDescriptorMethod;
                        if (method2 != null) {
                            obj2 = method2.invoke(obj, null);
                        } else {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            Method method3 = cache.nameMethod;
                            if (method3 != null) {
                                obj3 = method3.invoke(obj2, null);
                            } else {
                                obj3 = null;
                            }
                            if (obj3 instanceof String) {
                                str2 = obj3;
                            }
                        }
                    }
                }
                if (str2 == null) {
                    str = debugMetadata.m5c();
                } else {
                    str = str2 + '/' + debugMetadata.m5c();
                }
                str2 = new StackTraceElement(str, debugMetadata.m2m(), debugMetadata.m4f(), i3);
            } else {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v + ". Please update the Kotlin standard library.").toString());
            }
        }
        if (str2 == null) {
            str2 = getClass().getName();
        }
        sb.append((Object) str2);
        return sb.toString();
    }
}
