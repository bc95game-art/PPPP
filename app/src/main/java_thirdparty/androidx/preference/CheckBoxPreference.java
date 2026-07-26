package androidx.preference;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.preference.SwitchPreference;
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final SwitchPreference.Listener mListener = new SwitchPreference.Listener(this, 1);

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CheckBoxPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130968765(0x7f0400bd, float:1.7546193E38)
            r1 = 16842895(0x101008f, float:2.369396E-38)
            int r0 = androidx.core.content.res.CamUtils.getAttr(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            androidx.preference.SwitchPreference$Listener r1 = new androidx.preference.SwitchPreference$Listener
            r2 = 1
            r1.<init>(r3, r2)
            r3.mListener = r1
            int[] r1 = androidx.preference.R$styleable.CheckBoxPreference
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 5
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L27
            java.lang.String r5 = r4.getString(r2)
        L27:
            r3.mSummaryOn = r5
            boolean r5 = r3.mChecked
            if (r5 == 0) goto L30
            r3.notifyChanged()
        L30:
            r5 = 4
            java.lang.String r5 = r4.getString(r5)
            if (r5 != 0) goto L3c
            r5 = 1
            java.lang.String r5 = r4.getString(r5)
        L3c:
            r3.mSummaryOff = r5
            boolean r5 = r3.mChecked
            if (r5 != 0) goto L45
            r3.notifyChanged()
        L45:
            r5 = 2
            boolean r5 = r4.getBoolean(r5, r2)
            r0 = 3
            boolean r5 = r4.getBoolean(r0, r5)
            r3.mDisableDependentsState = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.CheckBoxPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        syncCheckboxView(preferenceViewHolder.findViewById(16908289));
        syncSummaryView(preferenceViewHolder.findViewById(16908304));
    }

    @Override // androidx.preference.Preference
    public final void performClick(View view) {
        super.performClick(view);
        if (((AccessibilityManager) this.mContext.getSystemService("accessibility")).isEnabled()) {
            syncCheckboxView(view.findViewById(16908289));
            syncSummaryView(view.findViewById(16908304));
        }
    }

    public final void syncCheckboxView(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.mListener);
        }
    }
}
