package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.AbsSavedState;
import androidx.collection.SimpleArrayMap;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.zzb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public boolean mAttachedToHierarchy;
    public final RunnableC00921 mClearRecycleCacheRunnable;
    public int mCurrentPreferenceOrder;
    public final Handler mHandler;
    public final SimpleArrayMap mIdRecycleCache;
    public int mInitialExpandedChildrenCount;
    public boolean mOrderingAsAdded;
    public final ArrayList mPreferences;

    /* renamed from: androidx.preference.PreferenceGroup$1 */
    /* loaded from: classes.dex */
    public final class RunnableC00921 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ RunnableC00921(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    synchronized (this) {
                        ((PreferenceGroup) this.this$0).mIdRecycleCache.clear();
                    }
                    return;
                case 1:
                    RecyclerView recyclerView = ((PreferenceFragmentCompat) this.this$0).mList;
                    recyclerView.focusableViewAvailable(recyclerView);
                    return;
                case 2:
                    ((EditTextPreferenceDialogFragmentCompat) this.this$0).scheduleShowSoftInputInner();
                    return;
                default:
                    ((PreferenceGroupAdapter) this.this$0).updatePreferences();
                    return;
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mIdRecycleCache = new SimpleArrayMap(0);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mClearRecycleCacheRunnable = new RunnableC00921(0, this);
        this.mPreferences = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PreferenceGroup, i, 0);
        this.mOrderingAsAdded = obtainStyledAttributes.getBoolean(2, obtainStyledAttributes.getBoolean(2, true));
        if (obtainStyledAttributes.hasValue(1)) {
            int i3 = obtainStyledAttributes.getInt(1, obtainStyledAttributes.getInt(1, Integer.MAX_VALUE));
            if (i3 != Integer.MAX_VALUE && TextUtils.isEmpty(this.mKey)) {
                Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
            }
            this.mInitialExpandedChildrenCount = i3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int size = this.mPreferences.size();
        for (int i = 0; i < size; i++) {
            getPreference(i).dispatchRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int size = this.mPreferences.size();
        for (int i = 0; i < size; i++) {
            getPreference(i).dispatchSaveInstanceState(bundle);
        }
    }

    public final Preference findPreference(CharSequence charSequence) {
        Preference findPreference;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        } else if (TextUtils.equals(this.mKey, charSequence)) {
            return this;
        } else {
            int size = this.mPreferences.size();
            for (int i = 0; i < size; i++) {
                Preference preference = getPreference(i);
                if (TextUtils.equals(preference.mKey, charSequence)) {
                    return preference;
                }
                if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                    return findPreference;
                }
            }
            return null;
        }
    }

    public final Preference getPreference(int i) {
        return (Preference) this.mPreferences.get(i);
    }

    @Override // androidx.preference.Preference
    public final void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int size = this.mPreferences.size();
        for (int i = 0; i < size; i++) {
            Preference preference = getPreference(i);
            if (preference.mParentDependencyMet == z) {
                preference.mParentDependencyMet = !z;
                preference.notifyDependencyChange(preference.shouldDisableDependents());
                preference.notifyChanged();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int size = this.mPreferences.size();
        for (int i = 0; i < size; i++) {
            getPreference(i).onAttached();
        }
    }

    @Override // androidx.preference.Preference
    public final void onDetached() {
        unregisterDependency();
        this.mAttachedToHierarchy = false;
        int size = this.mPreferences.size();
        for (int i = 0; i < size; i++) {
            getPreference(i).onDetached();
        }
    }

    @Override // androidx.preference.Preference
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mInitialExpandedChildrenCount = savedState.mInitialExpandedChildrenCount;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        return new SavedState(this.mInitialExpandedChildrenCount);
    }

    /* loaded from: classes.dex */
    public final class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(15);
        public final int mInitialExpandedChildrenCount;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mInitialExpandedChildrenCount = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mInitialExpandedChildrenCount);
        }

        public SavedState(int i) {
            super(AbsSavedState.EMPTY_STATE);
            this.mInitialExpandedChildrenCount = i;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
