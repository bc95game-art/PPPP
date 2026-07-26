package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public SwitchPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130969815(0x7f0404d7, float:1.7548323E38)
            r1 = 16843629(0x101036d, float:2.3696016E-38)
            int r0 = androidx.core.content.res.CamUtils.getAttr(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            androidx.preference.SwitchPreference$Listener r1 = new androidx.preference.SwitchPreference$Listener
            r2 = 0
            r1.<init>(r3, r2)
            r3.mListener = r1
            int[] r1 = androidx.preference.R$styleable.SwitchPreference
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 7
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L26
            java.lang.String r5 = r4.getString(r2)
        L26:
            r3.mSummaryOn = r5
            boolean r5 = r3.mChecked
            if (r5 == 0) goto L2f
            r3.notifyChanged()
        L2f:
            r5 = 6
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L3b
            r5 = 1
            java.lang.String r5 = r4.getString(r5)
        L3b:
            r3.mSummaryOff = r5
            boolean r5 = r3.mChecked
            if (r5 != 0) goto L44
            r3.notifyChanged()
        L44:
            r5 = 9
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L51
            r5 = 3
            java.lang.String r5 = r4.getString(r5)
        L51:
            r3.mSwitchOn = r5
            r3.notifyChanged()
            r5 = 8
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L63
            r5 = 4
            java.lang.String r5 = r4.getString(r5)
        L63:
            r3.mSwitchOff = r5
            r3.notifyChanged()
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 5
            boolean r5 = r4.getBoolean(r0, r5)
            r3.mDisableDependentsState = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.SwitchPreference.<init>(android.content.Context, android.util.AttributeSet):void");
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
