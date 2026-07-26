package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertController;
import com.android.billingclient.api.zzbv;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    public CharSequence[] mEntries;
    public CharSequence[] mEntryValues;
    public final HashSet mNewValues = new HashSet();
    public boolean mPreferenceChanged;

    /* renamed from: androidx.preference.MultiSelectListPreferenceDialogFragmentCompat$1 */
    /* loaded from: classes.dex */
    public final class DialogInterface$OnMultiChoiceClickListenerC00881 implements DialogInterface.OnMultiChoiceClickListener {
        public DialogInterface$OnMultiChoiceClickListenerC00881() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
            MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
            HashSet hashSet = multiSelectListPreferenceDialogFragmentCompat.mNewValues;
            if (z) {
                multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged = hashSet.add(multiSelectListPreferenceDialogFragmentCompat.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged;
                return;
            }
            multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged = hashSet.remove(multiSelectListPreferenceDialogFragmentCompat.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged;
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashSet hashSet = this.mNewValues;
        if (bundle == null) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) getPreference();
            CharSequence[] charSequenceArr = multiSelectListPreference.mEntries;
            CharSequence[] charSequenceArr2 = multiSelectListPreference.mEntryValues;
            if (charSequenceArr == null || charSequenceArr2 == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            hashSet.clear();
            hashSet.addAll(multiSelectListPreference.mValues);
            this.mPreferenceChanged = false;
            this.mEntries = multiSelectListPreference.mEntries;
            this.mEntryValues = charSequenceArr2;
            return;
        }
        hashSet.clear();
        hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.mPreferenceChanged = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.mEntries = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.mEntryValues = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void onDialogClosed(boolean z) {
        if (z && this.mPreferenceChanged) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) getPreference();
            HashSet hashSet = this.mNewValues;
            if (multiSelectListPreference.callChangeListener(hashSet)) {
                multiSelectListPreference.setValues(hashSet);
            }
        }
        this.mPreferenceChanged = false;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public final void onPrepareDialogBuilder(zzbv zzbvVar) {
        int length = this.mEntryValues.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.mNewValues.contains(this.mEntryValues[i].toString());
        }
        CharSequence[] charSequenceArr = this.mEntries;
        DialogInterface$OnMultiChoiceClickListenerC00881 r2 = new DialogInterface$OnMultiChoiceClickListenerC00881();
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mItems = charSequenceArr;
        alertParams.mOnCheckboxClickListener = r2;
        alertParams.mCheckedItems = zArr;
        alertParams.mIsMultiChoice = true;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.mNewValues));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.mPreferenceChanged);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.mEntries);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.mEntryValues);
    }
}
