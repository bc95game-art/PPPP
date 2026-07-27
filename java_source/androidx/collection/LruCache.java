package androidx.collection;

import android.view.View;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    */
    public void trimToSize(int i) {
        while (true) {
            synchronized (((Lock) this.lock)) {
                try {
                    if (this.size < 0 || (((LruHashMap) this.map).map.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size <= i || ((LruHashMap) this.map).map.isEmpty()) {
                        break;
                    }
                    Set entrySet = ((LruHashMap) this.map).map.entrySet();
                    Intrinsics.checkNotNullExpressionValue(entrySet, "map.entries");
                    Object obj = null;
                    if (entrySet instanceof List) {
                        List list = (List) entrySet;
                        if (!list.isEmpty()) {
                            obj = list.get(0);
                        }
                    } else {
                        Iterator it = entrySet.iterator();
                        if (it.hasNext()) {
                            obj = it.next();
                        }
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    if (entry != null) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        LruHashMap lruHashMap = (LruHashMap) this.map;
                        lruHashMap.getClass();
                        Intrinsics.checkNotNullParameter(key, "key");
                        lruHashMap.map.remove(key);
                        int i2 = this.size;
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.size = i2 - 1;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
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
