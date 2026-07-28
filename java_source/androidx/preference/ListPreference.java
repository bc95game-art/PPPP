package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import androidx.core.content.res.CamUtils;
import androidx.preference.Preference;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] mEntries;
    public CharSequence[] mEntryValues;
    public String mSummary;
    public String mValue;
    public boolean mValueSet;

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPreference, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.mEntries = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(3);
        this.mEntryValues = textArray2 == null ? obtainStyledAttributes.getTextArray(1) : textArray2;
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (Transition.C01101.sSimpleSummaryProvider == null) {
                Transition.C01101.sSimpleSummaryProvider = new Transition.C01101(12);
            }
            this.mSummaryProvider = Transition.C01101.sSimpleSummaryProvider;
            notifyChanged();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, 0);
        String string = obtainStyledAttributes2.getString(33);
        this.mSummary = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    public final int findIndexOfValue(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.mEntryValues) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.mEntryValues[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference
    public final CharSequence getSummary() {
        CharSequence charSequence;
        CharSequence[] charSequenceArr;
        Preference.SummaryProvider summaryProvider = this.mSummaryProvider;
        if (summaryProvider != null) {
            return summaryProvider.provideSummary(this);
        }
        int findIndexOfValue = findIndexOfValue(this.mValue);
        if (findIndexOfValue < 0 || (charSequenceArr = this.mEntries) == null) {
            charSequence = null;
        } else {
            charSequence = charSequenceArr[findIndexOfValue];
        }
        CharSequence summary = super.getSummary();
        String str = this.mSummary;
        if (str != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            String format = String.format(str, charSequence);
            if (!TextUtils.equals(format, summary)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return format;
            }
        }
        return summary;
    }

    @Override // androidx.preference.Preference
    public final Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setValue(savedState.mValue);
    }

    @Override // androidx.preference.Preference
    public final Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.mPersistent) {
            return absSavedState;
        }
        SavedState savedState = new SavedState();
        savedState.mValue = this.mValue;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void onSetInitialValue(Object obj) {
        setValue(getPersistedString((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (charSequence == null) {
            this.mSummary = null;
        } else {
            this.mSummary = ((String) charSequence).toString();
        }
    }

    public final void setValue(String str) {
        boolean equals = TextUtils.equals(this.mValue, str);
        if (!equals || !this.mValueSet) {
            this.mValue = str;
            this.mValueSet = true;
            persistString(str);
            if (!equals) {
                notifyChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(12);
        public String mValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mValue = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mValue);
        }

        public SavedState() {
            super(AbsSavedState.EMPTY_STATE);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, CamUtils.getAttr(context, C0130R.attr.dialogPreferenceStyle, 16842897));
    }
}
