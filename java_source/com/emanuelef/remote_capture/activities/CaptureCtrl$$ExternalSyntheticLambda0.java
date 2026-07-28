package com.emanuelef.remote_capture.activities;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.emanuelef.remote_capture.PersistableUriPermission;
import com.emanuelef.remote_capture.activities.AppDetailsActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.activities.MalwareDetection;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy;
/* loaded from: classes.dex */
public final /* synthetic */ class CaptureCtrl$$ExternalSyntheticLambda0 implements TabLayoutMediator$TabConfigurationStrategy, PersistableUriPermission.PupListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ CaptureCtrl$$ExternalSyntheticLambda0(AppCompatActivity appCompatActivity, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = appCompatActivity;
        this.f$1 = obj;
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        switch (this.$r8$classId) {
            case 1:
                AppDetailsActivity.$r8$lambda$CGX3VITiN4i297VroONm6WEAySE((AppDetailsActivity) this.f$0, (AppDetailsActivity.StateAdapter) this.f$1, tab, i);
                return;
            case 2:
                ((MainActivity) this.f$0).lambda$setupTabs$7((MainActivity.MainStateAdapter) this.f$1, tab, i);
                return;
            default:
                MalwareDetection.$r8$lambda$Lrm2amkgIMBz63lBejkUz7itAjg((MalwareDetection) this.f$0, (MalwareDetection.StateAdapter) this.f$1, tab, i);
                return;
        }
    }

    @Override // com.emanuelef.remote_capture.PersistableUriPermission.PupListener
    public void onUriChecked(Uri uri) {
        ((CaptureCtrl) this.f$0).lambda$processRequest$4((CaptureSettings) this.f$1, uri);
    }
}
