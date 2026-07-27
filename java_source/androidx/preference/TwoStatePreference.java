package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean mChecked;
    public boolean mCheckedSet;
    public boolean mDisableDependentsState;
    public CharSequence mSummaryOff;
    public CharSequence mSummaryOn;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // androidx.preference.Preference
    public final void onClick() {
        boolean z = !this.mChecked;
        if (callChangeListener(Boolean.valueOf(z))) {
            setChecked(z);
        }
    }

    @Override // androidx.preference.Preference
    public final Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.mChecked);
    }

    @Override // androidx.preference.Preference
    public final Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.mPersistent) {
            return absSavedState;
        }
        SavedState savedState = new SavedState();
        savedState.mChecked = this.mChecked;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (shouldPersist()) {
            booleanValue = this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, booleanValue);
        }
        setChecked(booleanValue);
    }

    public final void setChecked(boolean z) {
        boolean z2;
        if (this.mChecked != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || !this.mCheckedSet) {
            this.mChecked = z;
            this.mCheckedSet = true;
            if (shouldPersist()) {
                boolean z3 = !z;
                boolean shouldPersist = shouldPersist();
                String str = this.mKey;
                if (shouldPersist) {
                    z3 = this.mPreferenceManager.getSharedPreferences().getBoolean(str, z3);
                }
                if (z != z3) {
                    SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
                    editor.putBoolean(str, z);
                    if (!this.mPreferenceManager.mNoCommit) {
                        editor.apply();
                    }
                }
            }
            if (z2) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final boolean shouldDisableDependents() {
        boolean z;
        if (this.mDisableDependentsState) {
            z = this.mChecked;
        } else if (!this.mChecked) {
            z = true;
        } else {
            z = false;
        }
        if (z || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void syncSummaryView(View view) {
        boolean z;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            int i = 0;
            if (this.mChecked && !TextUtils.isEmpty(this.mSummaryOn)) {
                textView.setText(this.mSummaryOn);
            } else if (this.mChecked || TextUtils.isEmpty(this.mSummaryOff)) {
                z = true;
                if (z) {
                    CharSequence summary = getSummary();
                    if (!TextUtils.isEmpty(summary)) {
                        textView.setText(summary);
                        z = false;
                    }
                }
                if (z) {
                    i = 8;
                }
                if (i == textView.getVisibility()) {
                    textView.setVisibility(i);
                    return;
                }
                return;
            } else {
                textView.setText(this.mSummaryOff);
            }
            z = false;
            if (z) {
            }
            if (z) {
            }
            if (i == textView.getVisibility()) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(17);
        public boolean mChecked;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mChecked = parcel.readInt() != 1 ? false : true;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mChecked ? 1 : 0);
        }

        public SavedState() {
            super(AbsSavedState.EMPTY_STATE);
        }
    }
}
