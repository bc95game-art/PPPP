package androidx.activity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static Field sHField;
    public static Field sNextServedViewField;
    public static int sReflectedFieldsInitialized;
    public static Field sServedViewField;
    public final /* synthetic */ int $r8$classId;
    public ComponentActivity mActivity;

    public /* synthetic */ ImmLeaksCleaner() {
        this.$r8$classId = 0;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        View view;
        OnBackPressedDispatcher onBackPressedDispatcher;
        switch (this.$r8$classId) {
            case 0:
                if (event == Lifecycle.Event.ON_DESTROY) {
                    if (sReflectedFieldsInitialized == 0) {
                        try {
                            sReflectedFieldsInitialized = 2;
                            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                            sServedViewField = declaredField;
                            declaredField.setAccessible(true);
                            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                            sNextServedViewField = declaredField2;
                            declaredField2.setAccessible(true);
                            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                            sHField = declaredField3;
                            declaredField3.setAccessible(true);
                            sReflectedFieldsInitialized = 1;
                        } catch (NoSuchFieldException unused) {
                        }
                    }
                    if (sReflectedFieldsInitialized == 1) {
                        InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService("input_method");
                        try {
                            Object obj = sHField.get(inputMethodManager);
                            if (obj != null) {
                                synchronized (obj) {
                                    try {
                                        View view2 = (View) sServedViewField.get(inputMethodManager);
                                        if (view2 != null) {
                                            if (!view2.isAttachedToWindow()) {
                                                sNextServedViewField.set(inputMethodManager, null);
                                                inputMethodManager.isActive();
                                            }
                                        }
                                    } catch (IllegalAccessException unused2) {
                                    } catch (ClassCastException unused3) {
                                    } catch (IllegalAccessException unused4) {
                                    } finally {
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (IllegalAccessException unused5) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 1:
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.mActivity.mContextAwareHelper.context = null;
                    if (!this.mActivity.isChangingConfigurations()) {
                        this.mActivity.getViewModelStore().clear();
                    }
                    ComponentActivity.ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl = (ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.mActivity.mReportFullyDrawnExecutor;
                    ComponentActivity componentActivity = ComponentActivity.this;
                    componentActivity.getWindow().getDecorView().removeCallbacks(reportFullyDrawnExecutorApi16Impl);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(reportFullyDrawnExecutorApi16Impl);
                    return;
                }
                return;
            case 2:
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = this.mActivity.getWindow();
                    if (window != null) {
                        view = window.peekDecorView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        view.cancelPendingInputEvents();
                        return;
                    }
                    return;
                }
                return;
            case 3:
                ComponentActivity componentActivity2 = this.mActivity;
                componentActivity2.ensureViewModelStore();
                componentActivity2.getLifecycle().removeObserver(this);
                return;
            default:
                if (event == Lifecycle.Event.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                    onBackPressedDispatcher = this.mActivity.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher invoker = ComponentActivity.Api33Impl.getOnBackInvokedDispatcher((ComponentActivity) lifecycleOwner);
                    onBackPressedDispatcher.getClass();
                    Intrinsics.checkNotNullParameter(invoker, "invoker");
                    onBackPressedDispatcher.invokedDispatcher = invoker;
                    onBackPressedDispatcher.updateBackInvokedCallbackState(onBackPressedDispatcher.hasEnabledCallbacks);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ ImmLeaksCleaner(ComponentActivity componentActivity, int i) {
        this.$r8$classId = i;
        this.mActivity = componentActivity;
    }
}
