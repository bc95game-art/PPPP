package com.google.android.gms.tasks;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator$PagerAdapterObserver;
import com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzw {
    public final Object zza;
    public final Object zzb;
    public boolean zzc;
    public Object zze;
    public Object zzf;

    public zzw() {
        this.zza = new Object();
        this.zzb = new zzr();
    }

    public void attach() {
        final TabLayout tabLayout = (TabLayout) this.zza;
        ViewPager2 viewPager2 = (ViewPager2) this.zzb;
        if (!this.zzc) {
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            this.zzf = adapter;
            if (adapter != null) {
                this.zzc = true;
                ((ArrayList) viewPager2.mExternalPageChangeCallbacks.mCallbacks).add(new ViewPager2.OnPageChangeCallback(tabLayout) { // from class: com.google.android.material.tabs.TabLayoutMediator$TabLayoutOnPageChangeCallback
                    public final WeakReference tabLayoutRef;
                    public int scrollState = 0;
                    public int previousScrollState = 0;

                    {
                        this.tabLayoutRef = new WeakReference(tabLayout);
                    }

                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public final void onPageScrollStateChanged(int i) {
                        this.previousScrollState = this.scrollState;
                        this.scrollState = i;
                        TabLayout tabLayout2 = (TabLayout) this.tabLayoutRef.get();
                        if (tabLayout2 != null) {
                            tabLayout2.viewPagerScrollState = this.scrollState;
                        }
                    }

                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public final void onPageScrolled(int i, float f, int i2) {
                        TabLayout tabLayout2 = (TabLayout) this.tabLayoutRef.get();
                        if (tabLayout2 != null) {
                            int i3 = this.scrollState;
                            boolean z = true;
                            if (i3 == 2 && this.previousScrollState != 1) {
                                z = false;
                            }
                            boolean z2 = true;
                            if (i3 == 2 && this.previousScrollState == 0) {
                                z2 = false;
                            }
                            tabLayout2.setScrollPosition(i, f, z, z2, false);
                        }
                    }

                    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                    public final void onPageSelected(int i) {
                        boolean z;
                        TabLayout tabLayout2 = (TabLayout) this.tabLayoutRef.get();
                        if (tabLayout2 != null && tabLayout2.getSelectedTabPosition() != i && i < tabLayout2.getTabCount()) {
                            int i2 = this.scrollState;
                            if (i2 == 0 || (i2 == 2 && this.previousScrollState == 0)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            tabLayout2.selectTab(tabLayout2.getTabAt(i), z);
                        }
                    }
                });
                TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new TabLayout.ViewPagerOnTabSelectedListener(viewPager2, 1);
                ArrayList arrayList = tabLayout.selectedListeners;
                if (!arrayList.contains(viewPagerOnTabSelectedListener)) {
                    arrayList.add(viewPagerOnTabSelectedListener);
                }
                ((RecyclerView.Adapter) this.zzf).registerAdapterDataObserver(new TabLayoutMediator$PagerAdapterObserver(0, this));
                populateTabsFromPagerAdapter();
                tabLayout.setScrollPosition(viewPager2.getCurrentItem(), 0.0f, true, true, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = (Exception) this.zzf;
        }
        return exc;
    }

    public Object getResult() {
        Boolean bool;
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    Exception exc = (Exception) this.zzf;
                    if (exc == null) {
                        bool = (Boolean) this.zze;
                    } else {
                        throw new RuntimeException(exc);
                    }
                } else {
                    throw new IllegalStateException("Task is not yet complete");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bool;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzc && ((Exception) this.zzf) == null) {
                z = true;
            }
        }
        return z;
    }

    public void populateTabsFromPagerAdapter() {
        TabLayout tabLayout = (TabLayout) this.zza;
        tabLayout.removeAllTabs();
        RecyclerView.Adapter adapter = (RecyclerView.Adapter) this.zzf;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.Tab newTab = tabLayout.newTab();
                ((TabLayoutMediator$TabConfigurationStrategy) this.zze).onConfigureTab(newTab, i);
                tabLayout.addTab(newTab, false);
            }
            if (itemCount > 0) {
                int min = Math.min(((ViewPager2) this.zzb).getCurrentItem(), tabLayout.getTabCount() - 1);
                if (min != tabLayout.getSelectedTabPosition()) {
                    tabLayout.selectTab(tabLayout.getTabAt(min), true);
                }
            }
        }
    }

    public void zzh() {
        boolean z;
        String str;
        if (this.zzc) {
            int i = DuplicateTaskCompletionException.$r8$clinit;
            synchronized (this.zza) {
                z = this.zzc;
            }
            if (z) {
                Exception exception = getException();
                if (exception != null) {
                    str = "failure";
                } else if (isSuccessful()) {
                    str = "result ".concat(String.valueOf(getResult()));
                } else {
                    str = "unknown issue";
                }
                throw new IllegalStateException("Complete with: ".concat(str), exception);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public void zzi() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    ((zzr) this.zzb).zzb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzw(TabLayout tabLayout, ViewPager2 viewPager2, TabLayoutMediator$TabConfigurationStrategy tabLayoutMediator$TabConfigurationStrategy) {
        this.zza = tabLayout;
        this.zzb = viewPager2;
        this.zze = tabLayoutMediator$TabConfigurationStrategy;
    }
}
