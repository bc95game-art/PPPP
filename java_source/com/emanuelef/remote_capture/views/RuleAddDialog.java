package com.emanuelef.remote_capture.views;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class RuleAddDialog implements View.OnClickListener {
    private final RuleAddListener mAdapter;
    private ArrayAdapter<String> mComboAdapter;
    private final TextInputLayout mComboLayout;
    private final AutoCompleteTextView mComboText;
    private final Context mContext;
    private final AlertDialog mDialog;
    private final TextInputEditText mEditText;
    private final TextInputLayout mEditTextLayout;
    private final ViewMode mViewMode;

    /* loaded from: classes.dex */
    public interface RuleAddListener {
        boolean addRule(String str, TextView textView);
    }

    /* loaded from: classes.dex */
    public enum ViewMode {
        RULE_DIALOG_SIMPLE_TEXT,
        RULE_DIALOG_COMBO
    }

    private RuleAddDialog(ViewMode viewMode, Context context, int i, RuleAddListener ruleAddListener) {
        this.mContext = context;
        this.mViewMode = viewMode;
        this.mAdapter = ruleAddListener;
        View inflate = LayoutInflater.from(context).inflate(C0130R.layout.add_rule_dialog, (ViewGroup) null);
        this.mComboLayout = (TextInputLayout) inflate.findViewById(C0130R.C0132id.combo_field);
        this.mEditTextLayout = (TextInputLayout) inflate.findViewById(C0130R.C0132id.text_field);
        this.mComboText = (AutoCompleteTextView) inflate.findViewById(C0130R.C0132id.combo_text);
        this.mEditText = (TextInputEditText) inflate.findViewById(C0130R.C0132id.text_value);
        zzbv zzbvVar = new zzbv(context);
        ((AlertController.AlertParams) zzbvVar.zza).mView = inflate;
        zzbvVar.setTitle(i);
        zzbvVar.setPositiveButton(C0130R.string.add_action, new Blocklist$$ExternalSyntheticLambda0(24));
        zzbvVar.setNegativeButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(25));
        AlertDialog show = zzbvVar.show();
        this.mDialog = show;
        show.setCanceledOnTouchOutside(false);
        show.getButton(-1).setOnClickListener(this);
    }

    public static /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i) {
    }

    public static RuleAddDialog showCombo(Context context, int i, String[] strArr, RuleAddListener ruleAddListener) {
        RuleAddDialog ruleAddDialog = new RuleAddDialog(ViewMode.RULE_DIALOG_COMBO, context, i, ruleAddListener);
        ruleAddDialog.mComboLayout.setVisibility(0);
        ruleAddDialog.mComboAdapter = new ArrayAdapter<>(context, (int) C0130R.layout.dropdown_item, strArr);
        if (strArr.length > 0) {
            ruleAddDialog.mComboText.setText(strArr[0]);
        }
        ruleAddDialog.mComboText.setAdapter(ruleAddDialog.mComboAdapter);
        return ruleAddDialog;
    }

    public static RuleAddDialog showText(Context context, int i, RuleAddListener ruleAddListener) {
        RuleAddDialog ruleAddDialog = new RuleAddDialog(ViewMode.RULE_DIALOG_SIMPLE_TEXT, context, i, ruleAddListener);
        ruleAddDialog.mEditTextLayout.setVisibility(0);
        return ruleAddDialog;
    }

    public TextView getField() {
        if (this.mViewMode == ViewMode.RULE_DIALOG_SIMPLE_TEXT) {
            return this.mEditText;
        }
        return this.mComboText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView field = getField();
        CharSequence text = field.getText();
        Objects.requireNonNull(text);
        String charSequence = text.toString();
        if (charSequence.isEmpty()) {
            field.setError(this.mContext.getString(C0130R.string.required));
            return;
        }
        if (this.mComboAdapter != null) {
            for (int i = 0; i < this.mComboAdapter.getCount(); i++) {
                if (!this.mComboAdapter.getItem(i).equals(charSequence)) {
                }
            }
            field.setError(this.mContext.getString(C0130R.string.invalid));
            return;
        }
        if (this.mAdapter.addRule(charSequence, field)) {
            this.mDialog.dismiss();
        }
    }
}
