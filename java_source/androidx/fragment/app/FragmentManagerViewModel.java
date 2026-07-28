package androidx.fragment.app;

import android.util.Log;
import androidx.collection.internal.Lock;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class FragmentManagerViewModel extends ViewModel {
    public static final Lock FACTORY = new Object();
    public final boolean mStateAutomaticallySaved;
    public final HashMap mRetainedFragments = new HashMap();
    public final HashMap mChildNonConfigs = new HashMap();
    public final HashMap mViewModelStores = new HashMap();
    public boolean mHasBeenCleared = false;
    public boolean mIsStateSaved = false;

    public FragmentManagerViewModel(boolean z) {
        this.mStateAutomaticallySaved = z;
    }

    public final void addRetainedFragment(Fragment fragment) {
        if (!this.mIsStateSaved) {
            String str = fragment.mWho;
            HashMap hashMap = this.mRetainedFragments;
            if (!hashMap.containsKey(str)) {
                hashMap.put(fragment.mWho, fragment);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
                }
            }
        } else if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
        }
    }

    public final void clearNonConfigState(Fragment fragment, boolean z) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        clearNonConfigStateInternal(fragment.mWho, z);
    }

    public final void clearNonConfigStateInternal(String str, boolean z) {
        HashMap hashMap = this.mChildNonConfigs;
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) hashMap.get(str);
        if (fragmentManagerViewModel != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(fragmentManagerViewModel.mChildNonConfigs.keySet());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    fragmentManagerViewModel.clearNonConfigState((String) obj, true);
                }
            }
            fragmentManagerViewModel.onCleared();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.mViewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) hashMap2.get(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
            hashMap2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && FragmentManagerViewModel.class == obj.getClass()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
            if (this.mRetainedFragments.equals(fragmentManagerViewModel.mRetainedFragments) && this.mChildNonConfigs.equals(fragmentManagerViewModel.mChildNonConfigs) && this.mViewModelStores.equals(fragmentManagerViewModel.mViewModelStores)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.mChildNonConfigs.hashCode();
        return this.mViewModelStores.hashCode() + ((hashCode + (this.mRetainedFragments.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.mHasBeenCleared = true;
    }

    public final void removeRetainedFragment(Fragment fragment) {
        if (this.mIsStateSaved) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.mRetainedFragments.remove(fragment.mWho) != null && FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.mRetainedFragments.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.mChildNonConfigs.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.mViewModelStores.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final void clearNonConfigState(String str, boolean z) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        clearNonConfigStateInternal(str, z);
    }
}
