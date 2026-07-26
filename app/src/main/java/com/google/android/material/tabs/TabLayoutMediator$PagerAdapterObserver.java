package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.gms.tasks.zzw;
/* loaded from: classes.dex */
public final class TabLayoutMediator$PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ TabLayoutMediator$PagerAdapterObserver(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                ((FragmentStateAdapter.FragmentMaxLifecycleEnforcer) this.this$0).updateFragmentMaxLifecycle(true);
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2) {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                onChanged();
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                onChanged();
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i, int i2, int i3) {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                onChanged();
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                onChanged();
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((zzw) this.this$0).populateTabsFromPagerAdapter();
                return;
            default:
                onChanged();
                return;
        }
    }
}
