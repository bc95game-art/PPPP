package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public final boolean mAdjustable;
    public int mMax;
    public int mMin;
    public SeekBar mSeekBar;
    public int mSeekBarIncrement;
    public int mSeekBarValue;
    public TextView mSeekBarValueTextView;
    public final boolean mShowSeekBarValue;
    public boolean mTrackingTouch;
    public final boolean mUpdatesContinuously;
    public final C00931 mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (!z || (!seekBarPreference.mUpdatesContinuously && seekBarPreference.mTrackingTouch)) {
                int i2 = i + seekBarPreference.mMin;
                TextView textView = seekBarPreference.mSeekBarValueTextView;
                if (textView != null) {
                    textView.setText(String.valueOf(i2));
                    return;
                }
                return;
            }
            seekBarPreference.syncValueInternal(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.mTrackingTouch = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            seekBarPreference.mTrackingTouch = false;
            if (seekBar.getProgress() + seekBarPreference.mMin != seekBarPreference.mSeekBarValue) {
                seekBarPreference.syncValueInternal(seekBar);
            }
        }
    };
    public final View$OnKeyListenerC00942 mSeekBarKeyListener = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.mAdjustable && (i == 21 || i == 22)) || i == 23 || i == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.mSeekBar;
            if (seekBar != null) {
                return seekBar.onKeyDown(i, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    };

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.preference.SeekBarPreference$1] */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.preference.SeekBarPreference$2] */
    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SeekBarPreference, C0130R.attr.seekBarPreferenceStyle, 0);
        this.mMin = obtainStyledAttributes.getInt(3, 0);
        int i = obtainStyledAttributes.getInt(1, 100);
        int i2 = this.mMin;
        i = i < i2 ? i2 : i;
        if (i != this.mMax) {
            this.mMax = i;
            notifyChanged();
        }
        int i3 = obtainStyledAttributes.getInt(4, 0);
        if (i3 != this.mSeekBarIncrement) {
            this.mSeekBarIncrement = Math.min(this.mMax - this.mMin, Math.abs(i3));
            notifyChanged();
        }
        this.mAdjustable = obtainStyledAttributes.getBoolean(2, true);
        this.mShowSeekBarValue = obtainStyledAttributes.getBoolean(5, false);
        this.mUpdatesContinuously = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSeekBarKeyListener);
        this.mSeekBar = (SeekBar) preferenceViewHolder.findViewById(C0130R.C0132id.seekbar);
        TextView textView = (TextView) preferenceViewHolder.findViewById(C0130R.C0132id.seekbar_value);
        this.mSeekBarValueTextView = textView;
        if (this.mShowSeekBarValue) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.mSeekBarValueTextView = null;
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        this.mSeekBar.setMax(this.mMax - this.mMin);
        int i = this.mSeekBarIncrement;
        if (i != 0) {
            this.mSeekBar.setKeyProgressIncrement(i);
        } else {
            this.mSeekBarIncrement = this.mSeekBar.getKeyProgressIncrement();
        }
        this.mSeekBar.setProgress(this.mSeekBarValue - this.mMin);
        int i2 = this.mSeekBarValue;
        TextView textView2 = this.mSeekBarValueTextView;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.mSeekBar.setEnabled(isEnabled());
    }

    @Override // androidx.preference.Preference
    public final Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSeekBarValue = savedState.mSeekBarValue;
        this.mMin = savedState.mMin;
        this.mMax = savedState.mMax;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public final Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.mPersistent) {
            return absSavedState;
        }
        SavedState savedState = new SavedState();
        savedState.mSeekBarValue = this.mSeekBarValue;
        savedState.mMin = this.mMin;
        savedState.mMax = this.mMax;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int intValue = ((Integer) obj).intValue();
        if (shouldPersist()) {
            intValue = this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, intValue);
        }
        setValueInternal(intValue, true);
    }

    public final void setValueInternal(int i, boolean z) {
        int i2 = this.mMin;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.mMax;
        if (i > i3) {
            i = i3;
        }
        if (i != this.mSeekBarValue) {
            this.mSeekBarValue = i;
            TextView textView = this.mSeekBarValueTextView;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            if (shouldPersist()) {
                int i4 = ~i;
                boolean shouldPersist = shouldPersist();
                String str = this.mKey;
                if (shouldPersist) {
                    i4 = this.mPreferenceManager.getSharedPreferences().getInt(str, i4);
                }
                if (i != i4) {
                    SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
                    editor.putInt(str, i);
                    if (!this.mPreferenceManager.mNoCommit) {
                        editor.apply();
                    }
                }
            }
            if (z) {
                notifyChanged();
            }
        }
    }

    public final void syncValueInternal(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.mMin;
        if (progress == this.mSeekBarValue) {
            return;
        }
        if (callChangeListener(Integer.valueOf(progress))) {
            setValueInternal(progress, false);
            return;
        }
        seekBar.setProgress(this.mSeekBarValue - this.mMin);
        int i = this.mSeekBarValue;
        TextView textView = this.mSeekBarValueTextView;
        if (textView != null) {
            textView.setText(String.valueOf(i));
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(16);
        public int mMax;
        public int mMin;
        public int mSeekBarValue;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }

        public SavedState() {
            super(AbsSavedState.EMPTY_STATE);
        }
    }
}
