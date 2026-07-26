package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.res.CamUtils;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final Listener mListener = new Listener(this, 0);
    public final String mSwitchOff;
    public final String mSwitchOn;

    /* loaded from: classes.dex */
    public final class Listener implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ TwoStatePreference this$0;

        public /* synthetic */ Listener(TwoStatePreference twoStatePreference, int i) {
            this.$r8$classId = i;
            this.this$0 = twoStatePreference;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            switch (this.$r8$classId) {
                case 0:
                    SwitchPreference switchPreference = (SwitchPreference) this.this$0;
                    if (!switchPreference.callChangeListener(Boolean.valueOf(z))) {
                        compoundButton.setChecked(!z);
                        return;
                    } else {
                        switchPreference.setChecked(z);
                        return;
                    }
                case 1:
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.this$0;
                    if (!checkBoxPreference.callChangeListener(Boolean.valueOf(z))) {
                        compoundButton.setChecked(!z);
                        return;
                    } else {
                        checkBoxPreference.setChecked(z);
                        return;
                    }
                default:
                    SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) this.this$0;
                    if (!switchPreferenceCompat.callChangeListener(Boolean.valueOf(z))) {
                        compoundButton.setChecked(!z);
                        return;
                    } else {
                        switchPreferenceCompat.setChecked(z);
                        return;
                    }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int attr = CamUtils.getAttr(context, C0130R.attr.switchPreferenceStyle, 16843629);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchPreference, attr, 0);
        String string = obtainStyledAttributes.getString(7);
        this.mSummaryOn = string == null ? obtainStyledAttributes.getString(0) : string;
        if (this.mChecked) {
            notifyChanged();
        }
        String string2 = obtainStyledAttributes.getString(6);
        this.mSummaryOff = string2 == null ? obtainStyledAttributes.getString(1) : string2;
        if (!this.mChecked) {
            notifyChanged();
        }
        String string3 = obtainStyledAttributes.getString(9);
        this.mSwitchOn = string3 == null ? obtainStyledAttributes.getString(3) : string3;
        notifyChanged();
        String string4 = obtainStyledAttributes.getString(8);
        this.mSwitchOff = string4 == null ? obtainStyledAttributes.getString(4) : string4;
        notifyChanged();
        this.mDisableDependentsState = obtainStyledAttributes.getBoolean(5, obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView(preferenceViewHolder.findViewById(16908352));
        syncSummaryView(preferenceViewHolder.findViewById(16908304));
    }

    @Override // androidx.preference.Preference
    public final void performClick(View view) {
        super.performClick(view);
        if (((AccessibilityManager) this.mContext.getSystemService("accessibility")).isEnabled()) {
            syncSwitchView(view.findViewById(16908352));
            syncSummaryView(view.findViewById(16908304));
        }
    }

    public final void syncSwitchView(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.mSwitchOn);
            r4.setTextOff(this.mSwitchOff);
            r4.setOnCheckedChangeListener(this.mListener);
        }
    }
}
