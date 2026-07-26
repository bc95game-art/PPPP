package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.OpGenerator {
    public boolean mBeingSaved;
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    public BackStackRecord(FragmentManager fragmentManager) {
        fragmentManager.getFragmentFactory();
        FragmentHostCallback fragmentHostCallback = fragmentManager.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.context.getClassLoader();
        }
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = fragmentManager;
    }

    public final void bumpBackStackNesting(int i) {
        FragmentTransaction.C0079Op op;
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.mOps;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = ((FragmentTransaction.C0079Op) arrayList.get(i2)).mFragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.mFragment + " to " + op.mFragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void collapseOps() {
        ArrayList arrayList = this.mOps;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            FragmentTransaction.C0079Op op = (FragmentTransaction.C0079Op) arrayList.get(size);
            if (op.mFromExpandedOp) {
                if (op.mCmd == 8) {
                    op.mFromExpandedOp = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = op.mFragment.mContainerId;
                    op.mCmd = 2;
                    op.mFromExpandedOp = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        FragmentTransaction.C0079Op op2 = (FragmentTransaction.C0079Op) arrayList.get(i2);
                        if (op2.mFromExpandedOp && op2.mFragment.mContainerId == i) {
                            arrayList.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final int commit() {
        return commitInternal(false, true);
    }

    public final int commitInternal(boolean z, boolean z2) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter());
                dump("  ", printWriter, true);
                printWriter.close();
            }
            this.mCommitted = true;
            boolean z3 = this.mAddToBackStack;
            FragmentManager fragmentManager = this.mManager;
            if (z3) {
                this.mIndex = fragmentManager.mBackStackIndex.getAndIncrement();
            } else {
                this.mIndex = -1;
            }
            if (z2) {
                fragmentManager.enqueueAction(this, z);
            }
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void doAddOp(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 == null || str.equals(str3)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = fragment.mFragmentId;
                if (i3 == 0 || i3 == i) {
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        addOp(new FragmentTransaction.C0079Op(fragment, i2));
        fragment.mFragmentManager = this.mManager;
    }

    public final void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        ArrayList arrayList = this.mOps;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                FragmentTransaction.C0079Op op = (FragmentTransaction.C0079Op) arrayList.get(i);
                switch (op.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.mCmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.mFragment);
                if (z) {
                    if (!(op.mEnterAnim == 0 && op.mExitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.mExitAnim));
                    }
                    if (op.mPopEnterAnim != 0 || op.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.mPopExitAnim));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.mManager.mBackStack.add(this);
        return true;
    }

    public final BackStackRecord hide(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            addOp(new FragmentTransaction.C0079Op(fragment, 4));
            return this;
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final BackStackRecord remove(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            addOp(new FragmentTransaction.C0079Op(fragment, 3));
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.fragment.app.FragmentTransaction$Op, java.lang.Object] */
    @Override // androidx.fragment.app.FragmentTransaction
    public final BackStackRecord setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        FragmentManager fragmentManager2 = this.mManager;
        if (fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + fragmentManager2);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            ?? obj = new Object();
            obj.mCmd = 10;
            obj.mFragment = fragment;
            obj.mFromExpandedOp = false;
            obj.mOldMaxState = fragment.mMaxState;
            obj.mCurrentMaxState = state;
            addOp(obj);
            return this;
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public final BackStackRecord setPrimaryNavigationFragment(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            addOp(new FragmentTransaction.C0079Op(fragment, 8));
            return this;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final BackStackRecord show(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            addOp(new FragmentTransaction.C0079Op(fragment, 5));
            return this;
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.fragment.app.FragmentTransaction$Op, java.lang.Object] */
    public BackStackRecord(BackStackRecord backStackRecord) {
        backStackRecord.mManager.getFragmentFactory();
        FragmentHostCallback fragmentHostCallback = backStackRecord.mManager.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.context.getClassLoader();
        }
        ArrayList arrayList = backStackRecord.mOps;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            FragmentTransaction.C0079Op op = (FragmentTransaction.C0079Op) obj;
            ArrayList arrayList2 = this.mOps;
            ?? obj2 = new Object();
            obj2.mCmd = op.mCmd;
            obj2.mFragment = op.mFragment;
            obj2.mFromExpandedOp = op.mFromExpandedOp;
            obj2.mEnterAnim = op.mEnterAnim;
            obj2.mExitAnim = op.mExitAnim;
            obj2.mPopEnterAnim = op.mPopEnterAnim;
            obj2.mPopExitAnim = op.mPopExitAnim;
            obj2.mOldMaxState = op.mOldMaxState;
            obj2.mCurrentMaxState = op.mCurrentMaxState;
            arrayList2.add(obj2);
        }
        this.mEnterAnim = backStackRecord.mEnterAnim;
        this.mExitAnim = backStackRecord.mExitAnim;
        this.mPopEnterAnim = backStackRecord.mPopEnterAnim;
        this.mPopExitAnim = backStackRecord.mPopExitAnim;
        this.mTransition = backStackRecord.mTransition;
        this.mAddToBackStack = backStackRecord.mAddToBackStack;
        this.mAllowAddToBackStack = backStackRecord.mAllowAddToBackStack;
        this.mName = backStackRecord.mName;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        if (backStackRecord.mSharedElementSourceNames != null) {
            ArrayList arrayList3 = new ArrayList();
            this.mSharedElementSourceNames = arrayList3;
            arrayList3.addAll(backStackRecord.mSharedElementSourceNames);
        }
        if (backStackRecord.mSharedElementTargetNames != null) {
            ArrayList arrayList4 = new ArrayList();
            this.mSharedElementTargetNames = arrayList4;
            arrayList4.addAll(backStackRecord.mSharedElementTargetNames);
        }
        this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = backStackRecord.mManager;
        this.mCommitted = backStackRecord.mCommitted;
        this.mIndex = backStackRecord.mIndex;
        this.mBeingSaved = backStackRecord.mBeingSaved;
    }
}
