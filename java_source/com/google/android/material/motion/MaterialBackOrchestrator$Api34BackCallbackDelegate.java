package com.google.android.material.motion;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import androidx.activity.BackEventCompat;
/* loaded from: classes.dex */
public final class MaterialBackOrchestrator$Api34BackCallbackDelegate extends MaterialBackOrchestrator$Api33BackCallbackDelegate {
    @Override // com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate
    public final OnBackInvokedCallback createOnBackInvokedCallback(final MaterialBackHandler materialBackHandler) {
        return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator$Api34BackCallbackDelegate.1
            public final void onBackCancelled() {
                if (MaterialBackOrchestrator$Api34BackCallbackDelegate.this.onBackInvokedCallback != null) {
                    materialBackHandler.cancelBackProgress();
                }
            }

            public final void onBackInvoked() {
                materialBackHandler.handleBackInvoked();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                if (MaterialBackOrchestrator$Api34BackCallbackDelegate.this.onBackInvokedCallback != null) {
                    materialBackHandler.updateBackProgress(new BackEventCompat(backEvent));
                }
            }

            public final void onBackStarted(BackEvent backEvent) {
                if (MaterialBackOrchestrator$Api34BackCallbackDelegate.this.onBackInvokedCallback != null) {
                    materialBackHandler.startBackProgress(new BackEventCompat(backEvent));
                }
            }
        };
    }
}
