package com.emanuelef.remote_capture.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpDetailsActivity$$ExternalSyntheticLambda0 implements ActivityResultCallback, TabLayoutMediator$TabConfigurationStrategy {
    public final /* synthetic */ HttpDetailsActivity f$0;

    public /* synthetic */ HttpDetailsActivity$$ExternalSyntheticLambda0(HttpDetailsActivity httpDetailsActivity) {
        this.f$0 = httpDetailsActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        this.f$0.harFileResult((ActivityResult) obj);
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        this.f$0.lambda$setupTabs$0(tab, i);
    }
}
