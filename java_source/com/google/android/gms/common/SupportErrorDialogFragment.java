package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.internal.zzah;
/* loaded from: classes.dex */
public class SupportErrorDialogFragment extends DialogFragment {
    public Dialog zaa;
    public DialogInterface.OnCancelListener zab;
    public AlertDialog zac;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog() {
        Dialog dialog = this.zaa;
        if (dialog != null) {
            return dialog;
        }
        this.mShowsDialog = false;
        if (this.zac == null) {
            Context context = getContext();
            zzah.checkNotNull(context);
            this.zac = new AlertDialog.Builder(context).create();
        }
        return this.zac;
    }
}
