package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.res.CamUtils;
import androidx.preference.SwitchPreference;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final SwitchPreference.Listener mListener = new SwitchPreference.Listener(this, 1);

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, r0);
        int attr = CamUtils.getAttr(context, C0130R.attr.checkBoxPreferenceStyle, 16842895);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CheckBoxPreference, attr, 0);
        String string = obtainStyledAttributes.getString(5);
        this.mSummaryOn = string == null ? obtainStyledAttributes.getString(0) : string;
        if (this.mChecked) {
            notifyChanged();
        }
        String string2 = obtainStyledAttributes.getString(4);
        this.mSummaryOff = string2 == null ? obtainStyledAttributes.getString(1) : string2;
        if (!this.mChecked) {
            notifyChanged();
        }
        this.mDisableDependentsState = obtainStyledAttributes.getBoolean(3, obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
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
