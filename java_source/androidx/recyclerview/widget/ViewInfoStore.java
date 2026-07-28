package androidx.recyclerview.widget;

import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public final class ViewInfoStore {
    public final SimpleArrayMap mLayoutHolderMap = new SimpleArrayMap(0);
    public final LongSparseArray mOldChangedHolders = new LongSparseArray();

    /* loaded from: classes.dex */
    public final class InfoRecord {
        public static final Pools$SimplePool sPool = new Pools$SimplePool(20);
        public int flags;
        public RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        public RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, androidx.recyclerview.widget.ViewInfoStore$InfoRecord] */
        public static InfoRecord obtain() {
            InfoRecord infoRecord = (InfoRecord) sPool.acquire();
            if (infoRecord == null) {
                return new Object();
            }
            return infoRecord;
        }
    }

    /* loaded from: classes.dex */
    public interface ProcessCallback {
    }

    public final void addToPostLayout(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        InfoRecord infoRecord = (InfoRecord) simpleArrayMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, infoRecord);
        }
        infoRecord.postInfo = itemHolderInfo;
        infoRecord.flags |= 8;
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord infoRecord;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        int indexOfKey = simpleArrayMap.indexOfKey(viewHolder);
        if (indexOfKey >= 0 && (infoRecord = (InfoRecord) simpleArrayMap.valueAt(indexOfKey)) != null) {
            int i2 = infoRecord.flags;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                infoRecord.flags = i3;
                if (i == 4) {
                    itemHolderInfo = infoRecord.preInfo;
                } else if (i == 8) {
                    itemHolderInfo = infoRecord.postInfo;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    simpleArrayMap.removeAt(indexOfKey);
                    infoRecord.flags = 0;
                    infoRecord.preInfo = null;
                    infoRecord.postInfo = null;
                    InfoRecord.sPool.release(infoRecord);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public final void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.mLayoutHolderMap.get(viewHolder);
        if (infoRecord != null) {
            infoRecord.flags &= -2;
        }
    }

    public final void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray longSparseArray = this.mOldChangedHolders;
        int size = longSparseArray.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (viewHolder == longSparseArray.valueAt(size)) {
                Object[] objArr = longSparseArray.values;
                Object obj = objArr[size];
                Object obj2 = ArraySetKt.DELETED;
                if (obj != obj2) {
                    objArr[size] = obj2;
                    longSparseArray.garbage = true;
                }
            } else {
                size--;
            }
        }
        InfoRecord infoRecord = (InfoRecord) this.mLayoutHolderMap.remove(viewHolder);
        if (infoRecord != null) {
            infoRecord.flags = 0;
            infoRecord.preInfo = null;
            infoRecord.postInfo = null;
            InfoRecord.sPool.release(infoRecord);
        }
    }
}
