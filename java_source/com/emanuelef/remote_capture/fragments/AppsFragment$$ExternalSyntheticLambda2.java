package com.emanuelef.remote_capture.fragments;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.emanuelef.remote_capture.activities.EditFilterActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.fragments.mitmwizard.InstallAddon;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.ClearTextEndIconDelegate;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.textfield.PasswordToggleEndIconDelegate;
/* loaded from: classes.dex */
public final /* synthetic */ class AppsFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppsFragment$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                ((AppsFragment) this.f$0).lambda$onViewCreated$0(view);
                return;
            case 1:
                EditFilterActivity.$r8$lambda$ruXj0T2QtTCDv_tY9zHDnRBXXjE((EditFilterActivity) this.f$0, view);
                return;
            case 2:
                ((MainActivity) this.f$0).lambda$setupTabs$8(view);
                return;
            case 3:
                ((ConnectionOverview) this.f$0).lambda$onViewCreated$0(view);
                return;
            case 4:
                ((FirewallStatus) this.f$0).lambda$onViewCreated$0(view);
                return;
            case 5:
                ((HttpPayloadFragment) this.f$0).lambda$onViewCreated$1(view);
                return;
            case 6:
                MalwareStatusFragment.$r8$lambda$Vhn2sIEMBquwtT7igeU4IgEpOc4((MalwareStatusFragment) this.f$0, view);
                return;
            case 7:
                ((InstallAddon) this.f$0).lambda$installAddon$0(view);
                return;
            case 8:
                ((MaterialDatePicker) this.f$0).getDateSelector();
                throw null;
            case 9:
                ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) this.f$0;
                EditText editText = clearTextEndIconDelegate.editText;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    clearTextEndIconDelegate.refreshIconState();
                    return;
                }
                return;
            case 10:
                ((DropdownMenuEndIconDelegate) this.f$0).showHideDropdown();
                return;
            default:
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = (PasswordToggleEndIconDelegate) this.f$0;
                EditText editText2 = passwordToggleEndIconDelegate.editText;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = passwordToggleEndIconDelegate.editText;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        passwordToggleEndIconDelegate.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        passwordToggleEndIconDelegate.editText.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        passwordToggleEndIconDelegate.editText.setSelection(selectionEnd);
                    }
                    passwordToggleEndIconDelegate.refreshIconState();
                    return;
                }
                return;
        }
    }
}
