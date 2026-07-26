package androidx.preference;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class PreferenceGroupAdapter extends RecyclerView.Adapter {
    public final PreferenceGroup mPreferenceGroup;
    public final PreferenceGroup.AnonymousClass1 mSyncRunnable = new PreferenceGroup.AnonymousClass1(3, this);
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public ArrayList mPreferences = new ArrayList();
    public ArrayList mVisiblePreferences = new ArrayList();
    public final ArrayList mPreferenceResourceDescriptors = new ArrayList();

    /* loaded from: classes.dex */
    public final class PreferenceResourceDescriptor {
        public final String mClassName;
        public final int mLayoutResId;
        public final int mWidgetLayoutResId;

        public PreferenceResourceDescriptor(Preference preference) {
            this.mClassName = preference.getClass().getName();
            this.mLayoutResId = preference.mLayoutResId;
            this.mWidgetLayoutResId = preference.mWidgetLayoutResId;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            if (this.mLayoutResId == preferenceResourceDescriptor.mLayoutResId && this.mWidgetLayoutResId == preferenceResourceDescriptor.mWidgetLayoutResId && TextUtils.equals(this.mClassName, preferenceResourceDescriptor.mClassName)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.mClassName.hashCode() + ((((527 + this.mLayoutResId) * 31) + this.mWidgetLayoutResId) * 31);
        }
    }

    public PreferenceGroupAdapter(PreferenceScreen preferenceScreen) {
        this.mPreferenceGroup = preferenceScreen;
        preferenceScreen.mListener = this;
        setHasStableIds(preferenceScreen.mShouldUseGeneratedIds);
        updatePreferences();
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.preference.ExpandButton, java.lang.Object, androidx.preference.Preference] */
    public final ArrayList createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        char c;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = preferenceGroup.mPreferences.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Preference preference = preferenceGroup.getPreference(i2);
            if (preference.mVisible) {
                int i3 = preferenceGroup.mInitialExpandedChildrenCount;
                if (i3 == Integer.MAX_VALUE || i < i3) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (preferenceGroup2 instanceof PreferenceScreen) {
                        continue;
                    } else if (preferenceGroup.mInitialExpandedChildrenCount == Integer.MAX_VALUE || preferenceGroup2.mInitialExpandedChildrenCount == Integer.MAX_VALUE) {
                        ArrayList createVisiblePreferencesList = createVisiblePreferencesList(preferenceGroup2);
                        int size2 = createVisiblePreferencesList.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj = createVisiblePreferencesList.get(i4);
                            i4++;
                            Preference preference2 = (Preference) obj;
                            int i5 = preferenceGroup.mInitialExpandedChildrenCount;
                            if (i5 == Integer.MAX_VALUE || i < i5) {
                                arrayList.add(preference2);
                            } else {
                                arrayList2.add(preference2);
                            }
                            i++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        int i6 = preferenceGroup.mInitialExpandedChildrenCount;
        if (i6 != Integer.MAX_VALUE && i > i6) {
            Context context = preferenceGroup.mContext;
            long j = preferenceGroup.mId;
            String str = null;
            ?? preference3 = new Preference(context, null);
            preference3.mLayoutResId = R.layout.expand_button;
            Context context2 = preference3.mContext;
            Drawable drawable = BundleKt.getDrawable(context2, R.drawable.ic_arrow_down_24dp);
            if (preference3.mIcon != drawable) {
                preference3.mIcon = drawable;
                preference3.mIconResId = 0;
                preference3.notifyChanged();
            }
            preference3.mIconResId = R.drawable.ic_arrow_down_24dp;
            String string = context2.getString(R.string.expand_button_title);
            if (!TextUtils.equals(string, preference3.mTitle)) {
                preference3.mTitle = string;
                preference3.notifyChanged();
            }
            if (999 != preference3.mOrder) {
                preference3.mOrder = 999;
                PreferenceGroupAdapter preferenceGroupAdapter = preference3.mListener;
                if (preferenceGroupAdapter != null) {
                    Handler handler = preferenceGroupAdapter.mHandler;
                    PreferenceGroup.AnonymousClass1 r10 = preferenceGroupAdapter.mSyncRunnable;
                    handler.removeCallbacks(r10);
                    handler.post(r10);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size3 = arrayList2.size();
            int i7 = 0;
            while (i7 < size3) {
                Object obj2 = arrayList2.get(i7);
                i7++;
                Preference preference4 = (Preference) obj2;
                CharSequence charSequence = preference4.mTitle;
                boolean z = preference4 instanceof PreferenceGroup;
                if (!z || TextUtils.isEmpty(charSequence)) {
                    c = 0;
                } else {
                    c = 0;
                    arrayList3.add((PreferenceGroup) preference4);
                }
                if (arrayList3.contains(preference4.mParentGroup)) {
                    if (z) {
                        arrayList3.add((PreferenceGroup) preference4);
                    }
                } else if (!TextUtils.isEmpty(charSequence)) {
                    if (str == null) {
                        str = charSequence;
                    } else {
                        Object[] objArr = new Object[2];
                        objArr[c] = str;
                        objArr[1] = charSequence;
                        str = context2.getString(R.string.summary_collapsed_preference_list, objArr);
                    }
                }
            }
            preference3.setSummary(str);
            preference3.mId = j + 1000000;
            preference3.mOnClickListener = new zzcl(13, this, preferenceGroup, false);
            arrayList.add(preference3);
        }
        return arrayList;
    }

    public final void flattenPreferenceGroup(ArrayList arrayList, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.mPreferences);
        }
        int size = preferenceGroup.mPreferences.size();
        for (int i = 0; i < size; i++) {
            Preference preference = preferenceGroup.getPreference(i);
            arrayList.add(preference);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preference);
            if (!this.mPreferenceResourceDescriptors.contains(preferenceResourceDescriptor)) {
                this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    flattenPreferenceGroup(arrayList, preferenceGroup2);
                }
            }
            preference.mListener = this;
        }
    }

    public final Preference getItem(int i) {
        if (i < 0 || i >= this.mVisiblePreferences.size()) {
            return null;
        }
        return (Preference) this.mVisiblePreferences.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        if (!hasStableIds()) {
            return -1L;
        }
        return getItem(i).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(getItem(i));
        ArrayList arrayList = this.mPreferenceResourceDescriptors;
        int indexOf = arrayList.indexOf(preferenceResourceDescriptor);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = arrayList.size();
        arrayList.add(preferenceResourceDescriptor);
        return size;
    }

    public final int getPreferenceAdapterPosition(String str) {
        int size = this.mVisiblePreferences.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str, ((Preference) this.mVisiblePreferences.get(i)).mKey)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PreferenceViewHolder preferenceViewHolder = (PreferenceViewHolder) viewHolder;
        Preference item = getItem(i);
        ColorStateList colorStateList = preferenceViewHolder.mTitleTextColors;
        Drawable background = preferenceViewHolder.itemView.getBackground();
        Drawable drawable = preferenceViewHolder.mBackground;
        if (background != drawable) {
            View view = preferenceViewHolder.itemView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            view.setBackground(drawable);
        }
        TextView textView = (TextView) preferenceViewHolder.findViewById(16908310);
        if (!(textView == null || colorStateList == null || textView.getTextColors().equals(colorStateList))) {
            textView.setTextColor(colorStateList);
        }
        item.onBindViewHolder(preferenceViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) this.mPreferenceResourceDescriptors.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = BundleKt.getDrawable(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceResourceDescriptor.mLayoutResId, viewGroup, false);
        if (inflate.getBackground() == null) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            inflate.setBackground(drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i2 = preferenceResourceDescriptor.mWidgetLayoutResId;
            if (i2 != 0) {
                from.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public final void updatePreferences() {
        ArrayList arrayList = this.mPreferences;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Preference) obj).mListener = null;
        }
        ArrayList arrayList2 = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList2;
        PreferenceGroup preferenceGroup = this.mPreferenceGroup;
        flattenPreferenceGroup(arrayList2, preferenceGroup);
        this.mVisiblePreferences = createVisiblePreferencesList(preferenceGroup);
        notifyDataSetChanged();
        ArrayList arrayList3 = this.mPreferences;
        int size2 = arrayList3.size();
        while (i < size2) {
            Object obj2 = arrayList3.get(i);
            i++;
            ((Preference) obj2).getClass();
        }
    }

    public final int getPreferenceAdapterPosition(Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i = 0; i < size; i++) {
            Preference preference2 = (Preference) this.mVisiblePreferences.get(i);
            if (preference2 != null && preference2.equals(preference)) {
                return i;
            }
        }
        return -1;
    }
}
