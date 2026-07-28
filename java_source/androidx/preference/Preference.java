package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.CamUtils;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceGroup;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.common.zzb;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public final boolean mAllowDividerAbove;
    public final boolean mAllowDividerBelow;
    public boolean mBaseMethodCalled;
    public final View$OnClickListenerC00891 mClickListener;
    public final Context mContext;
    public final boolean mCopyingEnabled;
    public final Object mDefaultValue;
    public final String mDependencyKey;
    public boolean mDependencyMet;
    public ArrayList mDependents;
    public boolean mEnabled;
    public Bundle mExtras;
    public final String mFragment;
    public boolean mHasId;
    public final boolean mHasSingleLineTitleAttr;
    public Drawable mIcon;
    public int mIconResId;
    public final boolean mIconSpaceReserved;
    public long mId;
    public Intent mIntent;
    public final String mKey;
    public int mLayoutResId;
    public PreferenceGroupAdapter mListener;
    public OnPreferenceChangeListener mOnChangeListener;
    public OnPreferenceClickListener mOnClickListener;
    public OnPreferenceCopyListener mOnCopyListener;
    public int mOrder;
    public boolean mParentDependencyMet;
    public PreferenceGroup mParentGroup;
    public final boolean mPersistent;
    public PreferenceManager mPreferenceManager;
    public final boolean mSelectable;
    public final boolean mShouldDisableView;
    public final boolean mSingleLineTitle;
    public CharSequence mSummary;
    public SummaryProvider mSummaryProvider;
    public CharSequence mTitle;
    public boolean mVisible;
    public final int mWidgetLayoutResId;

    /* loaded from: classes.dex */
    public class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new zzb(14);

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    /* loaded from: classes.dex */
    public final class OnPreferenceCopyListener implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public final Preference mPreference;

        public OnPreferenceCopyListener(Preference preference) {
            this.mPreference = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Preference preference = this.mPreference;
            CharSequence summary = preference.getSummary();
            if (preference.mCopyingEnabled && !TextUtils.isEmpty(summary)) {
                contextMenu.setHeaderTitle(summary);
                contextMenu.add(0, 0, 0, C0130R.string.copy).setOnMenuItemClickListener(this);
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Preference preference = this.mPreference;
            CharSequence summary = preference.getSummary();
            ((ClipboardManager) preference.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", summary));
            Context context = preference.mContext;
            Toast.makeText(context, context.getString(C0130R.string.preference_copied, summary), 0).show();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface SummaryProvider {
        CharSequence provideSummary(Preference preference);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.preference.Preference$1] */
    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.mOrder = Integer.MAX_VALUE;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = C0130R.layout.preference;
        this.mClickListener = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Preference.this.performClick(view);
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, 0);
        this.mIconResId = obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(26);
        this.mKey = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(34);
        this.mTitle = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.mSummary = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.mOrder = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = obtainStyledAttributes.getString(22);
        this.mFragment = string2 == null ? obtainStyledAttributes.getString(13) : string2;
        this.mLayoutResId = obtainStyledAttributes.getResourceId(27, obtainStyledAttributes.getResourceId(3, C0130R.layout.preference));
        this.mWidgetLayoutResId = obtainStyledAttributes.getResourceId(35, obtainStyledAttributes.getResourceId(9, 0));
        this.mEnabled = obtainStyledAttributes.getBoolean(21, obtainStyledAttributes.getBoolean(2, true));
        boolean z = obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(5, true));
        this.mSelectable = z;
        this.mPersistent = obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(1, true));
        String string3 = obtainStyledAttributes.getString(19);
        this.mDependencyKey = string3 == null ? obtainStyledAttributes.getString(10) : string3;
        this.mAllowDividerAbove = obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z));
        this.mAllowDividerBelow = obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z));
        if (obtainStyledAttributes.hasValue(18)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, 11);
        }
        this.mShouldDisableView = obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(12, true));
        boolean hasValue = obtainStyledAttributes.hasValue(32);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = obtainStyledAttributes.getBoolean(32, obtainStyledAttributes.getBoolean(14, true));
        }
        this.mIconSpaceReserved = obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(15, false));
        this.mVisible = obtainStyledAttributes.getBoolean(25, obtainStyledAttributes.getBoolean(25, true));
        this.mCopyingEnabled = obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(20, false));
        obtainStyledAttributes.recycle();
    }

    public static void setEnabledStateOnViews(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final boolean callChangeListener(Serializable serializable) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.mOnChangeListener;
        if (onPreferenceChangeListener == null || onPreferenceChangeListener.onPreferenceChange(this, serializable)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.mOrder;
        int i2 = preference2.mOrder;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference2.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.mTitle.toString());
    }

    public void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        String str = this.mKey;
        if (!TextUtils.isEmpty(str) && (parcelable = bundle.getParcelable(str)) != null) {
            this.mBaseMethodCalled = false;
            onRestoreInstanceState(parcelable);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    public void dispatchSaveInstanceState(Bundle bundle) {
        String str = this.mKey;
        if (!TextUtils.isEmpty(str)) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (onSaveInstanceState != null) {
                bundle.putParcelable(str, onSaveInstanceState);
            }
        }
    }

    public long getId() {
        return this.mId;
    }

    public final String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        return this.mPreferenceManager.getSharedPreferences().getString(this.mKey, str);
    }

    public CharSequence getSummary() {
        SummaryProvider summaryProvider = this.mSummaryProvider;
        if (summaryProvider != null) {
            return summaryProvider.provideSummary(this);
        }
        return this.mSummary;
    }

    public boolean isEnabled() {
        if (!this.mEnabled || !this.mDependencyMet || !this.mParentDependencyMet) {
            return false;
        }
        return true;
    }

    public void notifyChanged() {
        int indexOf;
        PreferenceGroupAdapter preferenceGroupAdapter = this.mListener;
        if (preferenceGroupAdapter != null && (indexOf = preferenceGroupAdapter.mVisiblePreferences.indexOf(this)) != -1) {
            preferenceGroupAdapter.notifyItemChanged(indexOf, this);
        }
    }

    public void notifyDependencyChange(boolean z) {
        ArrayList arrayList = this.mDependents;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) arrayList.get(i);
                if (preference.mDependencyMet == z) {
                    preference.mDependencyMet = !z;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    public void onAttached() {
        PreferenceScreen preferenceScreen;
        String str = this.mDependencyKey;
        if (!TextUtils.isEmpty(str)) {
            PreferenceManager preferenceManager = this.mPreferenceManager;
            Preference preference = null;
            if (!(preferenceManager == null || (preferenceScreen = preferenceManager.mPreferenceScreen) == null)) {
                preference = preferenceScreen.findPreference(str);
            }
            if (preference != null) {
                if (preference.mDependents == null) {
                    preference.mDependents = new ArrayList();
                }
                preference.mDependents.add(this);
                boolean shouldDisableDependents = preference.shouldDisableDependents();
                if (this.mDependencyMet == shouldDisableDependents) {
                    this.mDependencyMet = !shouldDisableDependents;
                    notifyDependencyChange(shouldDisableDependents());
                    notifyChanged();
                    return;
                }
                return;
            }
            StringBuilder m = ViewModelProvider.Factory.CC.m594m("Dependency \"", str, "\" not found for preference \"");
            m.append(this.mKey);
            m.append("\" (title: \"");
            m.append((Object) this.mTitle);
            m.append("\"");
            throw new IllegalStateException(m.toString());
        }
    }

    public final void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        SharedPreferences sharedPreferences;
        this.mPreferenceManager = preferenceManager;
        if (!this.mHasId) {
            this.mId = preferenceManager.getNextId();
        }
        if (shouldPersist()) {
            PreferenceManager preferenceManager2 = this.mPreferenceManager;
            if (preferenceManager2 != null) {
                sharedPreferences = preferenceManager2.getSharedPreferences();
            } else {
                sharedPreferences = null;
            }
            if (sharedPreferences.contains(this.mKey)) {
                onSetInitialValue(null);
                return;
            }
        }
        Object obj = this.mDefaultValue;
        if (obj != null) {
            onSetInitialValue(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        Integer num;
        TextView textView;
        ImageView imageView;
        View findViewById;
        boolean z;
        OnPreferenceCopyListener onPreferenceCopyListener;
        int i;
        View view = preferenceViewHolder.itemView;
        view.setOnClickListener(this.mClickListener);
        view.setId(0);
        TextView textView2 = (TextView) preferenceViewHolder.findViewById(16908304);
        int i2 = 8;
        if (textView2 != null) {
            CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                textView2.setText(summary);
                textView2.setVisibility(0);
                num = Integer.valueOf(textView2.getCurrentTextColor());
                textView = (TextView) preferenceViewHolder.findViewById(16908310);
                boolean z2 = this.mSelectable;
                if (textView != null) {
                    CharSequence charSequence = this.mTitle;
                    if (!TextUtils.isEmpty(charSequence)) {
                        textView.setText(charSequence);
                        textView.setVisibility(0);
                        if (this.mHasSingleLineTitleAttr) {
                            textView.setSingleLine(this.mSingleLineTitle);
                        }
                        if (!z2 && isEnabled() && num != null) {
                            textView.setTextColor(num.intValue());
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                }
                imageView = (ImageView) preferenceViewHolder.findViewById(16908294);
                boolean z3 = this.mIconSpaceReserved;
                if (imageView != null) {
                    int i3 = this.mIconResId;
                    if (!(i3 == 0 && this.mIcon == null)) {
                        if (this.mIcon == null) {
                            this.mIcon = BundleKt.getDrawable(this.mContext, i3);
                        }
                        Drawable drawable = this.mIcon;
                        if (drawable != null) {
                            imageView.setImageDrawable(drawable);
                        }
                    }
                    if (this.mIcon != null) {
                        imageView.setVisibility(0);
                    } else {
                        if (z3) {
                            i = 4;
                        } else {
                            i = 8;
                        }
                        imageView.setVisibility(i);
                    }
                }
                findViewById = preferenceViewHolder.findViewById(C0130R.C0132id.icon_frame);
                if (findViewById == null) {
                    findViewById = preferenceViewHolder.findViewById(16908350);
                }
                if (findViewById != null) {
                    if (this.mIcon != null) {
                        findViewById.setVisibility(0);
                    } else {
                        if (z3) {
                            i2 = 4;
                        }
                        findViewById.setVisibility(i2);
                    }
                }
                if (!this.mShouldDisableView) {
                    setEnabledStateOnViews(view, isEnabled());
                } else {
                    setEnabledStateOnViews(view, true);
                }
                view.setFocusable(z2);
                view.setClickable(z2);
                preferenceViewHolder.mDividerAllowedAbove = this.mAllowDividerAbove;
                preferenceViewHolder.mDividerAllowedBelow = this.mAllowDividerBelow;
                z = this.mCopyingEnabled;
                if (z && this.mOnCopyListener == null) {
                    this.mOnCopyListener = new OnPreferenceCopyListener(this);
                }
                if (!z) {
                    onPreferenceCopyListener = this.mOnCopyListener;
                } else {
                    onPreferenceCopyListener = null;
                }
                view.setOnCreateContextMenuListener(onPreferenceCopyListener);
                view.setLongClickable(z);
                if (z && !z2) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view.setBackground(null);
                    return;
                }
            }
            textView2.setVisibility(8);
        }
        num = null;
        textView = (TextView) preferenceViewHolder.findViewById(16908310);
        boolean z22 = this.mSelectable;
        if (textView != null) {
        }
        imageView = (ImageView) preferenceViewHolder.findViewById(16908294);
        boolean z32 = this.mIconSpaceReserved;
        if (imageView != null) {
        }
        findViewById = preferenceViewHolder.findViewById(C0130R.C0132id.icon_frame);
        if (findViewById == null) {
        }
        if (findViewById != null) {
        }
        if (!this.mShouldDisableView) {
        }
        view.setFocusable(z22);
        view.setClickable(z22);
        preferenceViewHolder.mDividerAllowedAbove = this.mAllowDividerAbove;
        preferenceViewHolder.mDividerAllowedBelow = this.mAllowDividerBelow;
        z = this.mCopyingEnabled;
        if (z) {
            this.mOnCopyListener = new OnPreferenceCopyListener(this);
        }
        if (!z) {
        }
        view.setOnCreateContextMenuListener(onPreferenceCopyListener);
        view.setLongClickable(z);
        if (z) {
        }
    }

    public void onClick() {
    }

    public void onDetached() {
        unregisterDependency();
    }

    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void onSetInitialValue(Object obj) {
    }

    public void performClick(View view) {
        Intent intent;
        PreferenceFragmentCompat preferenceFragmentCompat;
        if (isEnabled() && this.mSelectable) {
            onClick();
            OnPreferenceClickListener onPreferenceClickListener = this.mOnClickListener;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = this.mPreferenceManager;
                if ((preferenceManager == null || (preferenceFragmentCompat = preferenceManager.mOnPreferenceTreeClickListener) == null || !preferenceFragmentCompat.onPreferenceTreeClick(this)) && (intent = this.mIntent) != null) {
                    this.mContext.startActivity(intent);
                }
            }
        }
    }

    public final void persistString(String str) {
        if (shouldPersist() && !TextUtils.equals(str, getPersistedString(null))) {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putString(this.mKey, str);
            if (!this.mPreferenceManager.mNoCommit) {
                editor.apply();
            }
        }
    }

    public void setSummary(CharSequence charSequence) {
        if (this.mSummaryProvider != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.mSummary, charSequence)) {
            this.mSummary = charSequence;
            notifyChanged();
        }
    }

    public final void setVisible(boolean z) {
        if (this.mVisible != z) {
            this.mVisible = z;
            PreferenceGroupAdapter preferenceGroupAdapter = this.mListener;
            if (preferenceGroupAdapter != null) {
                Handler handler = preferenceGroupAdapter.mHandler;
                PreferenceGroup.RunnableC00921 r2 = preferenceGroupAdapter.mSyncRunnable;
                handler.removeCallbacks(r2);
                handler.post(r2);
            }
        }
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public final boolean shouldPersist() {
        if (this.mPreferenceManager == null || !this.mPersistent || TextUtils.isEmpty(this.mKey)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.mTitle;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public final void unregisterDependency() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.mDependencyKey;
        if (str != null) {
            PreferenceManager preferenceManager = this.mPreferenceManager;
            Preference preference = null;
            if (!(preferenceManager == null || (preferenceScreen = preferenceManager.mPreferenceScreen) == null)) {
                preference = preferenceScreen.findPreference(str);
            }
            if (preference != null && (arrayList = preference.mDependents) != null) {
                arrayList.remove(this);
            }
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, CamUtils.getAttr(context, C0130R.attr.preferenceStyle, 16842894));
    }
}
