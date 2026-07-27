package androidx.preference;
/* loaded from: classes.dex */
public final class ExpandButton extends Preference {
    public long mId;

    @Override // androidx.preference.Preference
    public final long getId() {
        return this.mId;
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.mDividerAllowedAbove = false;
    }
}
