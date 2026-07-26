package androidx.viewpager2.widget;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
/* loaded from: classes.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ int $r8$classId;
    public final Object mCallbacks;

    public CompositeOnPageChangeCallback() {
        this.$r8$classId = 0;
        this.mCallbacks = new ArrayList(3);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int i) {
        switch (this.$r8$classId) {
            case 0:
                try {
                    ArrayList arrayList = (ArrayList) this.mCallbacks;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((ViewPager2.OnPageChangeCallback) obj).onPageScrollStateChanged(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                ((FragmentStateAdapter.FragmentMaxLifecycleEnforcer) this.mCallbacks).updateFragmentMaxLifecycle(false);
                return;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        switch (this.$r8$classId) {
            case 0:
                try {
                    ArrayList arrayList = (ArrayList) this.mCallbacks;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((ViewPager2.OnPageChangeCallback) obj).onPageScrolled(i, f, i2);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                super.onPageScrolled(i, f, i2);
                return;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int i) {
        switch (this.$r8$classId) {
            case 0:
                try {
                    ArrayList arrayList = (ArrayList) this.mCallbacks;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((ViewPager2.OnPageChangeCallback) obj).onPageSelected(i);
                    }
                    return;
                } catch (ConcurrentModificationException e) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
                }
            default:
                ((FragmentStateAdapter.FragmentMaxLifecycleEnforcer) this.mCallbacks).updateFragmentMaxLifecycle(false);
                return;
        }
    }

    public CompositeOnPageChangeCallback(FragmentStateAdapter.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer) {
        this.$r8$classId = 1;
        this.mCallbacks = fragmentMaxLifecycleEnforcer;
    }
}
