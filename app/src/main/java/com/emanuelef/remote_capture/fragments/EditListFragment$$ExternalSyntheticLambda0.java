package com.emanuelef.remote_capture.fragments;

import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.emanuelef.remote_capture.views.RuleAddDialog;
/* loaded from: classes.dex */
public final /* synthetic */ class EditListFragment$$ExternalSyntheticLambda0 implements RuleAddDialog.RuleAddListener, ActivityResultCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ EditListFragment f$0;

    public /* synthetic */ EditListFragment$$ExternalSyntheticLambda0(EditListFragment editListFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = editListFragment;
    }

    @Override // com.emanuelef.remote_capture.views.RuleAddDialog.RuleAddListener
    public boolean addRule(String str, TextView textView) {
        boolean lambda$showAddProtoRule$3;
        boolean lambda$showAddIpRule$2;
        boolean lambda$showAddHostRule$5;
        switch (this.$r8$classId) {
            case 0:
                lambda$showAddProtoRule$3 = this.f$0.lambda$showAddProtoRule$3(str, textView);
                return lambda$showAddProtoRule$3;
            case 1:
            default:
                lambda$showAddHostRule$5 = this.f$0.lambda$showAddHostRule$5(str, textView);
                return lambda$showAddHostRule$5;
            case 2:
                lambda$showAddIpRule$2 = this.f$0.lambda$showAddIpRule$2(str, textView);
                return lambda$showAddIpRule$2;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                this.f$0.importResult((ActivityResult) obj);
                return;
            default:
                this.f$0.exportResult((ActivityResult) obj);
                return;
        }
    }
}
