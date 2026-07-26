package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppCompatActivity f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda5(AppCompatActivity appCompatActivity, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = appCompatActivity;
        this.f$1 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                ((MainActivity) this.f$0).lambda$setupNavigationDrawer$4((String) this.f$1, view);
                return;
            default:
                ErrorActivity.$r8$lambda$nNwUsVWiKCacab_KmRonihc71g0((ErrorActivity) this.f$0, (Intent) this.f$1, view);
                return;
        }
    }
}
