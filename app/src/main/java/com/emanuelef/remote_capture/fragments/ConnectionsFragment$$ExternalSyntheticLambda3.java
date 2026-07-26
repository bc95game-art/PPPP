package com.emanuelef.remote_capture.fragments;

import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final /* synthetic */ class ConnectionsFragment$$ExternalSyntheticLambda3 implements ChipGroup.OnCheckedStateChangeListener, OnApplyWindowInsetsListener, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ConnectionsFragment f$0;

    public /* synthetic */ ConnectionsFragment$$ExternalSyntheticLambda3(ConnectionsFragment connectionsFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = connectionsFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.csvFileResult((ActivityResult) obj);
                return;
            default:
                this.f$0.filterResult((ActivityResult) obj);
                return;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$onViewCreated$7;
        lambda$onViewCreated$7 = this.f$0.lambda$onViewCreated$7(view, windowInsetsCompat);
        return lambda$onViewCreated$7;
    }

    @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
    public void onCheckedChanged(ChipGroup chipGroup, ArrayList arrayList) {
        this.f$0.lambda$onViewCreated$2(chipGroup, arrayList);
    }
}
