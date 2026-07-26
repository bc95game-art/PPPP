package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.view.View;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.emanuelef.remote_capture.fragments.mitmwizard.InstallAddon;
/* loaded from: classes.dex */
public final /* synthetic */ class AppOverview$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AppOverview$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                AppOverview.m789$r8$lambda$FzT3UFLC8p5Wvysj7yOE85lDs((AppOverview) obj2, (Context) obj, view);
                return;
            case 1:
                DefaultErrorActivity defaultErrorActivity = (DefaultErrorActivity) obj2;
                int i2 = DefaultErrorActivity.$r8$clinit;
                defaultErrorActivity.getClass();
                CustomActivityOnCrash.restartApplication(defaultErrorActivity, (CaocConfig) obj);
                return;
            case 2:
                ConnectionOverview.$r8$lambda$6FYQi1jKYtYgvlFAAIMQFNTAjQ0((ConnectionOverview) obj2, (CharSequence) obj, view);
                return;
            default:
                InstallAddon.m848$r8$lambda$ICwRMro1xkU7JLXdXwpGXdbwlo((InstallAddon) obj2, (String) obj, view);
                return;
        }
    }
}
