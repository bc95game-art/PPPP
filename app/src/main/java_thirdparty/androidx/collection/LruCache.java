package androidx.collection;

import android.view.View;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public class LruCache {
    public final /* synthetic */ int $r8$classId;
    public int hitCount;
    public final Object lock;
    public final Object map;
    public int maxSize;
    public int missCount;
    public int size;

    public LruCache(int i) {
        this.$r8$classId = 0;
        this.maxSize = i;
        if (i > 0) {
            this.map = new LruHashMap(0);
            this.lock = new Object();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void calculateCachedEnd() {
        ArrayList arrayList = (ArrayList) this.map;
        View view = (View) arrayList.get(arrayList.size() - 1);
        this.size = ((StaggeredGridLayoutManager) this.lock).mPrimaryOrientation.getDecoratedEnd(view);
        ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getClass();
    }

    public void clear() {
        ((ArrayList) this.map).clear();
        this.maxSize = Integer.MIN_VALUE;
        this.size = Integer.MIN_VALUE;
        this.hitCount = 0;
    }

    public int findFirstPartiallyVisibleItemPosition() {
        ArrayList arrayList = (ArrayList) this.map;
        if (((StaggeredGridLayoutManager) this.lock).mReverseLayout) {
            return findOnePartiallyVisibleChild(arrayList.size() - 1, -1);
        }
        return findOnePartiallyVisibleChild(0, arrayList.size());
    }

    public int findLastPartiallyVisibleItemPosition() {
        ArrayList arrayList = (ArrayList) this.map;
        if (((StaggeredGridLayoutManager) this.lock).mReverseLayout) {
            return findOnePartiallyVisibleChild(0, arrayList.size());
        }
        return findOnePartiallyVisibleChild(arrayList.size() - 1, -1);
    }

    public int findOnePartiallyVisibleChild(int i, int i2) {
        int i3;
        boolean z;
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.lock;
        int startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
        if (i2 > i) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (i != i2) {
            View view = (View) ((ArrayList) this.map).get(i);
            int decoratedStart = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedStart(view);
            int decoratedEnd = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedEnd(view);
            boolean z2 = false;
            if (decoratedStart <= endAfterPadding) {
                z = true;
            } else {
                z = false;
            }
            if (decoratedEnd >= startAfterPadding) {
                z2 = true;
            }
            if (z && z2 && (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding)) {
                return staggeredGridLayoutManager.getPosition(view);
            }
            i += i3;
        }
        return -1;
    }

    public Object get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (((Lock) this.lock)) {
            LruHashMap lruHashMap = (LruHashMap) this.map;
            lruHashMap.getClass();
            Object obj = lruHashMap.map.get(key);
            if (obj != null) {
                this.hitCount++;
                return obj;
            }
            this.missCount++;
            return null;
        }
    }

    public int getEndLine(int i) {
        int i2 = this.size;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.map).size() == 0) {
            return i;
        }
        calculateCachedEnd();
        return this.size;
    }

    public View getFocusableViewAfter(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.lock;
        ArrayList arrayList = (ArrayList) this.map;
        View view = null;
        if (i2 == -1) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                View view2 = (View) arrayList.get(i3);
                if ((staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) <= i) || ((!staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i) || !view2.hasFocusable())) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size() - 1;
        while (size2 >= 0) {
            View view3 = (View) arrayList.get(size2);
            if ((staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view3) >= i) || ((!staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view3) <= i) || !view3.hasFocusable())) {
                break;
            }
            size2--;
            view = view3;
        }
        return view;
    }

    public int getStartLine(int i) {
        ArrayList arrayList = (ArrayList) this.map;
        int i2 = this.maxSize;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (arrayList.size() == 0) {
            return i;
        }
        View view = (View) arrayList.get(0);
        this.maxSize = ((StaggeredGridLayoutManager) this.lock).mPrimaryOrientation.getDecoratedStart(view);
        ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getClass();
        return this.maxSize;
    }

    public Object put(Object key, Object obj) {
        Object put;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (((Lock) this.lock)) {
            this.size++;
            LruHashMap lruHashMap = (LruHashMap) this.map;
            lruHashMap.getClass();
            put = lruHashMap.map.put(key, obj);
            if (put != null) {
                this.size--;
            }
        }
        trimToSize(this.maxSize);
        return put;
    }

    public String toString() {
        int i;
        String str;
        switch (this.$r8$classId) {
            case 0:
                synchronized (((Lock) this.lock)) {
                    try {
                        int i2 = this.hitCount;
                        int i3 = this.missCount + i2;
                        if (i3 != 0) {
                            i = (i2 * 100) / i3;
                        } else {
                            i = 0;
                        }
                        str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L0:
            java.lang.Object r0 = r5.lock
            androidx.collection.internal.Lock r0 = (androidx.collection.internal.Lock) r0
            monitor-enter(r0)
            int r1 = r5.size     // Catch: java.lang.Throwable -> L1a
            if (r1 < 0) goto L8f
            java.lang.Object r1 = r5.map     // Catch: java.lang.Throwable -> L1a
            androidx.collection.internal.LruHashMap r1 = (androidx.collection.internal.LruHashMap) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.map     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1d
            int r1 = r5.size     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L8f
            goto L1d
        L1a:
            r6 = move-exception
            goto L97
        L1d:
            int r1 = r5.size     // Catch: java.lang.Throwable -> L1a
            if (r1 <= r6) goto L8d
            java.lang.Object r1 = r5.map     // Catch: java.lang.Throwable -> L1a
            androidx.collection.internal.LruHashMap r1 = (androidx.collection.internal.LruHashMap) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.map     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2e
            goto L8d
        L2e:
            java.lang.Object r1 = r5.map     // Catch: java.lang.Throwable -> L1a
            androidx.collection.internal.LruHashMap r1 = (androidx.collection.internal.LruHashMap) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.map     // Catch: java.lang.Throwable -> L1a
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "map.entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            if (r2 == 0) goto L51
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L4b
            goto L60
        L4b:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L1a
            goto L60
        L51:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L5c
            goto L60
        L5c:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L1a
        L60:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L66
            monitor-exit(r0)
            return
        L66:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r5.map     // Catch: java.lang.Throwable -> L1a
            androidx.collection.internal.LruHashMap r3 = (androidx.collection.internal.LruHashMap) r3     // Catch: java.lang.Throwable -> L1a
            r3.getClass()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r3 = r3.map     // Catch: java.lang.Throwable -> L1a
            r3.remove(r1)     // Catch: java.lang.Throwable -> L1a
            int r1 = r5.size     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)     // Catch: java.lang.Throwable -> L1a
            int r1 = r1 + (-1)
            r5.size = r1     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r0)
            goto L0
        L8d:
            monitor-exit(r0)
            return
        L8f:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L1a
            throw r1     // Catch: java.lang.Throwable -> L1a
        L97:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }

    public LruCache(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.$r8$classId = 1;
        this.lock = staggeredGridLayoutManager;
        this.map = new ArrayList();
        this.maxSize = Integer.MIN_VALUE;
        this.size = Integer.MIN_VALUE;
        this.hitCount = 0;
        this.missCount = i;
    }
}
