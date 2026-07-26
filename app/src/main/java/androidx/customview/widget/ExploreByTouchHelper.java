package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.Lock;
import androidx.core.p002os.BundleKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.ViewUtilsApi21;
import androidx.viewpager2.widget.FakeDrag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final ViewUtilsApi21 NODE_ADAPTER = new Object();
    public static final Lock SPARSE_VALUES_ADAPTER = new Object();
    public final View mHost;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();
    public final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public final class MyNodeProvider extends FakeDrag {
        public MyNodeProvider() {
        }

        @Override // androidx.viewpager2.widget.FakeDrag
        public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i).mInfo));
        }

        @Override // androidx.viewpager2.widget.FakeDrag
        public final AccessibilityNodeInfoCompat findFocus(int i) {
            int i2;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (i == 2) {
                i2 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId;
            } else {
                i2 = exploreByTouchHelper.mKeyboardFocusedVirtualViewId;
            }
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }

        @Override // androidx.viewpager2.widget.FakeDrag
        public final boolean performAction(int i, int i2, Bundle bundle) {
            int i3;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            View view = exploreByTouchHelper.mHost;
            if (i == -1) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                return view.performAccessibilityAction(i2, bundle);
            } else if (i2 == 1) {
                return exploreByTouchHelper.requestKeyboardFocusForVirtualView(i);
            } else {
                if (i2 == 2) {
                    return exploreByTouchHelper.clearKeyboardFocusForVirtualView(i);
                }
                if (i2 == 64) {
                    AccessibilityManager accessibilityManager = exploreByTouchHelper.mManager;
                    if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId) == i) {
                        return false;
                    }
                    if (i3 != Integer.MIN_VALUE) {
                        exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                        view.invalidate();
                        exploreByTouchHelper.sendEventForVirtualView(i3, 65536);
                    }
                    exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = i;
                    view.invalidate();
                    exploreByTouchHelper.sendEventForVirtualView(i, 32768);
                    return true;
                } else if (i2 != 128) {
                    return exploreByTouchHelper.onPerformActionForVirtualView(i, i2, bundle);
                } else {
                    if (exploreByTouchHelper.mAccessibilityFocusedVirtualViewId != i) {
                        return false;
                    }
                    exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                    view.invalidate();
                    exploreByTouchHelper.sendEventForVirtualView(i, 65536);
                    return true;
                }
            }
        }
    }

    public ExploreByTouchHelper(View view) {
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final AccessibilityEvent createEvent(int i, int i2) {
        View view = this.mHost;
        if (i != -1) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
            obtain.getText().add(obtainAccessibilityNodeInfo.getText());
            AccessibilityNodeInfo accessibilityNodeInfo = obtainAccessibilityNodeInfo.mInfo;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
                obtain.setClassName(accessibilityNodeInfo.getClassName());
                obtain.setSource(view, i);
                obtain.setPackageName(view.getContext().getPackageName());
                return obtain;
            }
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain(i2);
        view.onInitializeAccessibilityEvent(obtain2);
        return obtain2;
    }

    public final AccessibilityNodeInfoCompat createNodeForChild(int i) {
        boolean z;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        accessibilityNodeInfoCompat.setClassName("android.view.View");
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.mHost;
        obtain.setParent(view);
        onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.mTempParentRect;
        accessibilityNodeInfoCompat.getBoundsInParent(rect2);
        if (!rect2.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(view.getContext().getPackageName());
                accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                obtain.setSource(view, i);
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    obtain.setAccessibilityFocused(true);
                    accessibilityNodeInfoCompat.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    accessibilityNodeInfoCompat.addAction(64);
                }
                if (this.mKeyboardFocusedVirtualViewId == i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    accessibilityNodeInfoCompat.addAction(2);
                } else if (obtain.isFocusable()) {
                    accessibilityNodeInfoCompat.addAction(1);
                }
                obtain.setFocused(z);
                int[] iArr = this.mTempGlobalRect;
                view.getLocationOnScreen(iArr);
                Rect rect3 = this.mTempScreenRect;
                obtain.getBoundsInScreen(rect3);
                if (rect3.equals(rect)) {
                    accessibilityNodeInfoCompat.getBoundsInParent(rect3);
                    rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                }
                Rect rect4 = this.mTempVisibleRect;
                if (view.getLocalVisibleRect(rect4)) {
                    rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                    if (rect3.intersect(rect4)) {
                        obtain.setBoundsInScreen(rect3);
                        if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                            ViewParent parent = view.getParent();
                            while (true) {
                                if (parent instanceof View) {
                                    View view2 = (View) parent;
                                    if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                        break;
                                    }
                                    parent = view2.getParent();
                                } else if (parent != null) {
                                    accessibilityNodeInfoCompat.mInfo.setVisibleToUser(true);
                                }
                            }
                        }
                    }
                }
                return accessibilityNodeInfoCompat;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        AccessibilityManager accessibilityManager = this.mManager;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            int i2 = this.mHoveredVirtualViewId;
            if (i2 != virtualViewAt) {
                this.mHoveredVirtualViewId = virtualViewAt;
                sendEventForVirtualView(virtualViewAt, 128);
                sendEventForVirtualView(i2, 256);
            }
            if (virtualViewAt == Integer.MIN_VALUE) {
                return false;
            }
        } else if (action != 10 || (i = this.mHoveredVirtualViewId) == Integer.MIN_VALUE) {
            return false;
        } else {
            if (i != Integer.MIN_VALUE) {
                this.mHoveredVirtualViewId = Integer.MIN_VALUE;
                sendEventForVirtualView(Integer.MIN_VALUE, 128);
                sendEventForVirtualView(i, 256);
                return true;
            }
        }
        return true;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final FakeDrag getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(ArrayList arrayList);

    public final void invalidateVirtualView(int i) {
        View view;
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = (view = this.mHost).getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i, 2048);
            createEvent.setContentChangeTypes(0);
            parent.requestSendAccessibilityEvent(view, createEvent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean moveFocus(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        final boolean z;
        Object obj;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        int i2;
        int i3;
        int i4;
        int size;
        int i5;
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(0);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            sparseArrayCompat.put(((Integer) arrayList.get(i6)).intValue(), createNodeForChild(((Integer) arrayList.get(i6)).intValue()));
        }
        int i7 = this.mKeyboardFocusedVirtualViewId;
        if (i7 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) sparseArrayCompat.get(i7);
        }
        final ViewUtilsApi21 viewUtilsApi21 = NODE_ADAPTER;
        Lock lock = SPARSE_VALUES_ADAPTER;
        View view = this.mHost;
        if (i == 1 || i == 2) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (view.getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            lock.getClass();
            int size2 = sparseArrayCompat.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i8 = 0; i8 < size2; i8++) {
                arrayList2.add((AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i8));
            }
            Collections.sort(arrayList2, new Comparator(z, viewUtilsApi21) { // from class: androidx.customview.widget.FocusStrategy$SequentialComparator
                public final ViewUtilsApi21 mAdapter;
                public final boolean mIsLayoutRtl;
                public final Rect mTemp1 = new Rect();
                public final Rect mTemp2 = new Rect();

                {
                    this.mIsLayoutRtl = z;
                    this.mAdapter = viewUtilsApi21;
                }

                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    this.mAdapter.getClass();
                    Rect rect2 = this.mTemp1;
                    ((AccessibilityNodeInfoCompat) obj2).getBoundsInParent(rect2);
                    Rect rect3 = this.mTemp2;
                    ((AccessibilityNodeInfoCompat) obj3).getBoundsInParent(rect3);
                    int i9 = rect2.top;
                    int i10 = rect3.top;
                    if (i9 < i10) {
                        return -1;
                    }
                    if (i9 > i10) {
                        return 1;
                    }
                    int i11 = rect2.left;
                    int i12 = rect3.left;
                    boolean z2 = this.mIsLayoutRtl;
                    if (i11 < i12) {
                        if (z2) {
                            return 1;
                        }
                        return -1;
                    } else if (i11 <= i12) {
                        int i13 = rect2.bottom;
                        int i14 = rect3.bottom;
                        if (i13 < i14) {
                            return -1;
                        }
                        if (i13 > i14) {
                            return 1;
                        }
                        int i15 = rect2.right;
                        int i16 = rect3.right;
                        if (i15 < i16) {
                            if (z2) {
                                return 1;
                            }
                            return -1;
                        } else if (i15 <= i16) {
                            return 0;
                        } else {
                            if (z2) {
                                return -1;
                            }
                            return 1;
                        }
                    } else if (z2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            if (i == 1) {
                int size3 = arrayList2.size();
                if (accessibilityNodeInfoCompat != null) {
                    size3 = arrayList2.indexOf(accessibilityNodeInfoCompat);
                }
                int i9 = size3 - 1;
                if (i9 >= 0) {
                    obj = arrayList2.get(i9);
                    accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                }
                obj = null;
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
            } else if (i == 2) {
                int size4 = arrayList2.size();
                if (accessibilityNodeInfoCompat == null) {
                    i2 = -1;
                } else {
                    i2 = arrayList2.lastIndexOf(accessibilityNodeInfoCompat);
                }
                int i10 = i2 + 1;
                if (i10 < size4) {
                    obj = arrayList2.get(i10);
                    accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
                }
                obj = null;
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) obj;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i11 = this.mKeyboardFocusedVirtualViewId;
            if (i11 != Integer.MIN_VALUE) {
                obtainAccessibilityNodeInfo(i11).getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                int width = view.getWidth();
                int height = view.getHeight();
                if (i == 17) {
                    rect2.set(width, 0, width, height);
                } else if (i == 33) {
                    rect2.set(0, height, width, height);
                } else if (i == 66) {
                    rect2.set(-1, 0, -1, height);
                } else if (i == 130) {
                    rect2.set(0, -1, width, -1);
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                Rect rect3 = new Rect(rect2);
                if (i != 17) {
                    rect3.offset(rect2.width() + 1, 0);
                } else if (i == 33) {
                    rect3.offset(0, rect2.height() + 1);
                } else if (i == 66) {
                    rect3.offset(-(rect2.width() + 1), 0);
                } else if (i == 130) {
                    rect3.offset(0, -(rect2.height() + 1));
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                lock.getClass();
                size = sparseArrayCompat.size();
                Rect rect4 = new Rect();
                accessibilityNodeInfoCompat2 = null;
                for (i5 = 0; i5 < size; i5++) {
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = (AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i5);
                    if (accessibilityNodeInfoCompat3 != accessibilityNodeInfoCompat) {
                        viewUtilsApi21.getClass();
                        accessibilityNodeInfoCompat3.getBoundsInParent(rect4);
                        if (BundleKt.isCandidate(i, rect2, rect4)) {
                            if (BundleKt.isCandidate(i, rect2, rect3) && !BundleKt.beamBeats(i, rect2, rect4, rect3)) {
                                if (!BundleKt.beamBeats(i, rect2, rect3, rect4)) {
                                    int majorAxisDistance = BundleKt.majorAxisDistance(i, rect2, rect4);
                                    int minorAxisDistance = BundleKt.minorAxisDistance(i, rect2, rect4);
                                    int i12 = (minorAxisDistance * minorAxisDistance) + (majorAxisDistance * 13 * majorAxisDistance);
                                    int majorAxisDistance2 = BundleKt.majorAxisDistance(i, rect2, rect3);
                                    int minorAxisDistance2 = BundleKt.minorAxisDistance(i, rect2, rect3);
                                    if (i12 >= (minorAxisDistance2 * minorAxisDistance2) + (majorAxisDistance2 * 13 * majorAxisDistance2)) {
                                    }
                                }
                            }
                            rect3.set(rect4);
                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat3;
                        }
                    }
                }
            }
            Rect rect32 = new Rect(rect2);
            if (i != 17) {
            }
            lock.getClass();
            size = sparseArrayCompat.size();
            Rect rect42 = new Rect();
            accessibilityNodeInfoCompat2 = null;
            while (i5 < size) {
            }
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat4 = accessibilityNodeInfoCompat2;
        if (accessibilityNodeInfoCompat4 == null) {
            i3 = Integer.MIN_VALUE;
        } else {
            if (sparseArrayCompat.garbage) {
                ArraySetKt.access$gc(sparseArrayCompat);
            }
            int i13 = sparseArrayCompat.size;
            int i14 = 0;
            while (true) {
                if (i14 >= i13) {
                    i4 = -1;
                    break;
                } else if (sparseArrayCompat.values[i14] == accessibilityNodeInfoCompat4) {
                    i4 = i14;
                    break;
                } else {
                    i14++;
                }
            }
            i3 = sparseArrayCompat.keyAt(i4);
        }
        return requestKeyboardFocusForVirtualView(i3);
    }

    public final AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i != -1) {
            return createNodeForChild(i);
        }
        View view = this.mHost;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                accessibilityNodeInfoCompat.mInfo.addChild(view, ((Integer) arrayList.get(i2)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        View view = this.mHost;
        if ((!view.isFocused() && !view.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final void sendEventForVirtualView(int i, int i2) {
        View view;
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = (view = this.mHost).getParent()) != null) {
            parent.requestSendAccessibilityEvent(view, createEvent(i, i2));
        }
    }
}
