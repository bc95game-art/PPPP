package com.emanuelef.remote_capture.fragments;

import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda9 implements ActivityResultCallback, ChipGroup.OnCheckedStateChangeListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda9(HttpLogFragment httpLogFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = httpLogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.filterResult((ActivityResult) obj);
                return;
            case 1:
                this.f$0.txtFileResult((ActivityResult) obj);
                return;
            default:
                this.f$0.harFileResult((ActivityResult) obj);
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
