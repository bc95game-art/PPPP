package com.google.android.material.motion;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import j$.util.Objects;
/* loaded from: classes.dex */
public class MaterialBackOrchestrator$Api33BackCallbackDelegate {
    public OnBackInvokedCallback onBackInvokedCallback;

    public OnBackInvokedCallback createOnBackInvokedCallback(MaterialBackHandler materialBackHandler) {
        Objects.requireNonNull(materialBackHandler);
        return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(3, materialBackHandler);
    }

    public void startListeningForBackCallbacks(MaterialBackHandler materialBackHandler, View view, boolean z) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        int i;
        if (this.onBackInvokedCallback == null && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
            OnBackInvokedCallback createOnBackInvokedCallback = createOnBackInvokedCallback(materialBackHandler);
            this.onBackInvokedCallback = createOnBackInvokedCallback;
            if (z) {
                i = 1000000;
            } else {
                i = 0;
            }
            findOnBackInvokedDispatcher.registerOnBackInvokedCallback(i, createOnBackInvokedCallback);
        }
    }

    public void stopListeningForBackCallbacks(View view) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher;
        if (this.onBackInvokedCallback != null && (findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
            findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.onBackInvokedCallback = null;
        }
    }
}
