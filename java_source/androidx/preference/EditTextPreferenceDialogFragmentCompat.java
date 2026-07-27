package androidx.preference;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.PreferenceGroup;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
/* loaded from: classes.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public EditText mEditText;
    public CharSequence mText;
    public final PreferenceGroup.RunnableC00921 mShowSoftInputRunnable = new PreferenceGroup.RunnableC00921(2, this);
    public long mShowRequestTime = -1;

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void onBindDialogView(View view) {
        super.onBindDialogView(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.mEditText = editText;
        if (editText != null) {
            editText.requestFocus();
            this.mEditText.setText(this.mText);
            EditText editText2 = this.mEditText;
            editText2.setSelection(editText2.getText().length());
            if (((EditTextPreference) getPreference()).mOnBindEditTextListener != null) {
                TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = ((EditTextPreference) getPreference()).mOnBindEditTextListener;
                EditText editText3 = this.mEditText;
                switch (transportImpl$$ExternalSyntheticLambda0.$r8$classId) {
                    case 3:
                        editText3.setInputType(4098);
                        return;
                    case 15:
                        editText3.setInputType(16);
                        return;
                    default:
                        editText3.setInputType(4098);
                        return;
                }
            }
        } else {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mText = ((EditTextPreference) getPreference()).mText;
        } else {
            this.mText = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void onDialogClosed(boolean z) {
        if (z) {
            String obj = this.mEditText.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) getPreference();
            if (editTextPreference.callChangeListener(obj)) {
                editTextPreference.setText(obj);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.mText);
    }

    public final void scheduleShowSoftInputInner() {
        long j = this.mShowRequestTime;
        if (j != -1 && j + 1000 > SystemClock.currentThreadTimeMillis()) {
            EditText editText = this.mEditText;
            if (editText == null || !editText.isFocused()) {
                this.mShowRequestTime = -1L;
            } else if (((InputMethodManager) this.mEditText.getContext().getSystemService("input_method")).showSoftInput(this.mEditText, 0)) {
                this.mShowRequestTime = -1L;
            } else {
                EditText editText2 = this.mEditText;
                PreferenceGroup.RunnableC00921 r1 = this.mShowSoftInputRunnable;
                editText2.removeCallbacks(r1);
                this.mEditText.postDelayed(r1, 50L);
            }
        }
    }
}
