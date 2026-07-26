package androidx.recyclerview.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AdapterHelper {
    public final RecyclerView.C01045 mCallback;
    public final Pools$SimplePool mUpdateOpPool = new Pools$SimplePool(30);
    public final ArrayList mPendingUpdates = new ArrayList();
    public final ArrayList mPostponedList = new ArrayList();
    public int mExistingUpdateTypes = 0;
    public final OpReorderer mOpReorderer = new OpReorderer(0, this);

    /* loaded from: classes.dex */
    public final class UpdateOp {
        public int cmd;
        public int itemCount;
        public Object payload;
        public int positionStart;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof UpdateOp)) {
                    return false;
                }
                UpdateOp updateOp = (UpdateOp) obj;
                int i = this.cmd;
                if (i != updateOp.cmd) {
                    return false;
                }
                if (!(i == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount)) {
                    if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                        return false;
                    }
                    Object obj2 = this.payload;
                    if (obj2 != null) {
                        if (!obj2.equals(updateOp.payload)) {
                            return false;
                        }
                    } else if (updateOp.payload != null) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.cmd;
            if (i == 1) {
                str = "add";
            } else if (i == 2) {
                str = "rm";
            } else if (i == 4) {
                str = "up";
            } else if (i != 8) {
                str = "??";
            } else {
                str = "mv";
            }
            sb.append(str);
            sb.append(",s:");
            sb.append(this.positionStart);
            sb.append("c:");
            sb.append(this.itemCount);
            sb.append(",p:");
            sb.append(this.payload);
            sb.append("]");
            return sb.toString();
        }
    }

    public AdapterHelper(RecyclerView.C01045 r3) {
        this.mCallback = r3;
    }

    public final boolean canFindInPreLayout(int i) {
        ArrayList arrayList = this.mPostponedList;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = updateOp.positionStart;
                    int i5 = updateOp.itemCount + i4;
                    while (i4 < i5) {
                        if (findPositionOffset(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (findPositionOffset(updateOp.itemCount, i2 + 1) == i) {
                return true;
            }
        }
        return false;
    }

    public final void consumePostponedUpdates() {
        ArrayList arrayList = this.mPostponedList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.mCallback.dispatchUpdate((UpdateOp) arrayList.get(i));
        }
        recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    public final void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        ArrayList arrayList = this.mPendingUpdates;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i);
            int i2 = updateOp.cmd;
            RecyclerView.C01045 r7 = this.mCallback;
            if (i2 == 1) {
                r7.dispatchUpdate(updateOp);
                int i3 = updateOp.positionStart;
                int i4 = updateOp.itemCount;
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.offsetPositionRecordsForInsert(i3, i4);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                r7.dispatchUpdate(updateOp);
                int i5 = updateOp.positionStart;
                int i6 = updateOp.itemCount;
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.offsetPositionRecordsForRemove(i5, i6, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.mDeletedInvisibleItemCountSincePreviousLayout += i6;
            } else if (i2 == 4) {
                r7.dispatchUpdate(updateOp);
                int i7 = updateOp.positionStart;
                int i8 = updateOp.itemCount;
                Object obj = updateOp.payload;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.viewRangeUpdate(i7, i8, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i2 == 8) {
                r7.dispatchUpdate(updateOp);
                int i9 = updateOp.positionStart;
                int i10 = updateOp.itemCount;
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.offsetPositionRecordsForMove(i9, i10);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    public final void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i;
        Pools$SimplePool pools$SimplePool;
        int i2 = updateOp.cmd;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i2);
        int i3 = updateOp.positionStart;
        int i4 = updateOp.cmd;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i5 = 1;
        int i6 = 1;
        while (true) {
            int i7 = updateOp.itemCount;
            pools$SimplePool = this.mUpdateOpPool;
            if (i5 >= i7) {
                break;
            }
            int updatePositionWithPostponed2 = updatePositionWithPostponed((i * i5) + updateOp.positionStart, updateOp.cmd);
            int i8 = updateOp.cmd;
            if (i8 == 2 ? updatePositionWithPostponed2 != updatePositionWithPostponed : !(i8 == 4 && updatePositionWithPostponed2 == updatePositionWithPostponed + 1)) {
                UpdateOp obtainUpdateOp = obtainUpdateOp(updateOp.payload, i8, updatePositionWithPostponed, i6);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i3);
                obtainUpdateOp.payload = null;
                pools$SimplePool.release(obtainUpdateOp);
                if (updateOp.cmd == 4) {
                    i3 += i6;
                }
                updatePositionWithPostponed = updatePositionWithPostponed2;
                i6 = 1;
            } else {
                i6++;
            }
            i5++;
        }
        Object obj = updateOp.payload;
        updateOp.payload = null;
        pools$SimplePool.release(updateOp);
        if (i6 > 0) {
            UpdateOp obtainUpdateOp2 = obtainUpdateOp(obj, updateOp.cmd, updatePositionWithPostponed, i6);
            dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i3);
            obtainUpdateOp2.payload = null;
            pools$SimplePool.release(obtainUpdateOp2);
        }
    }

    public final void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i) {
        RecyclerView.C01045 r0 = this.mCallback;
        r0.dispatchUpdate(updateOp);
        RecyclerView recyclerView = RecyclerView.this;
        int i2 = updateOp.cmd;
        if (i2 == 2) {
            int i3 = updateOp.itemCount;
            recyclerView.offsetPositionRecordsForRemove(i, i3, true);
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i3;
        } else if (i2 == 4) {
            recyclerView.viewRangeUpdate(i, updateOp.itemCount, updateOp.payload);
            recyclerView.mItemsChanged = true;
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final int findPositionOffset(int i, int i2) {
        ArrayList arrayList = this.mPostponedList;
        int size = arrayList.size();
        while (i2 < size) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 == 8) {
                int i4 = updateOp.positionStart;
                if (i4 == i) {
                    i = updateOp.itemCount;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (updateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = updateOp.positionStart;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = updateOp.itemCount;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += updateOp.itemCount;
                }
            }
            i2++;
        }
        return i;
    }

    public final boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.recyclerview.widget.AdapterHelper$UpdateOp, java.lang.Object] */
    public final UpdateOp obtainUpdateOp(Object obj, int i, int i2, int i3) {
        UpdateOp updateOp = (UpdateOp) this.mUpdateOpPool.acquire();
        if (updateOp == null) {
            ?? obj2 = new Object();
            obj2.cmd = i;
            obj2.positionStart = i2;
            obj2.itemCount = i3;
            obj2.payload = obj;
            return obj2;
        }
        updateOp.cmd = i;
        updateOp.positionStart = i2;
        updateOp.itemCount = i3;
        updateOp.payload = obj;
        return updateOp;
    }

    public final void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i = updateOp.cmd;
        RecyclerView.C01045 r1 = this.mCallback;
        if (i == 1) {
            int i2 = updateOp.positionStart;
            int i3 = updateOp.itemCount;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForInsert(i2, i3);
            recyclerView.mItemsAddedOrRemoved = true;
        } else if (i == 2) {
            int i4 = updateOp.positionStart;
            int i5 = updateOp.itemCount;
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.offsetPositionRecordsForRemove(i4, i5, false);
            recyclerView2.mItemsAddedOrRemoved = true;
        } else if (i == 4) {
            int i6 = updateOp.positionStart;
            int i7 = updateOp.itemCount;
            Object obj = updateOp.payload;
            RecyclerView recyclerView3 = RecyclerView.this;
            recyclerView3.viewRangeUpdate(i6, i7, obj);
            recyclerView3.mItemsChanged = true;
        } else if (i == 8) {
            int i8 = updateOp.positionStart;
            int i9 = updateOp.itemCount;
            RecyclerView recyclerView4 = RecyclerView.this;
            recyclerView4.offsetPositionRecordsForMove(i8, i9);
            recyclerView4.mItemsAddedOrRemoved = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0007 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void preProcess() {
        ArrayList arrayList;
        int i;
        int i2;
        boolean z;
        UpdateOp updateOp;
        int i3;
        int i4;
        UpdateOp updateOp2;
        boolean z2;
        boolean z3;
        Object obj;
        UpdateOp updateOp3;
        int i5;
        OpReorderer opReorderer = this.mOpReorderer;
        opReorderer.getClass();
        while (true) {
            arrayList = this.mPendingUpdates;
            i = 1;
            int size = arrayList.size() - 1;
            boolean z4 = false;
            while (true) {
                i2 = 8;
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((UpdateOp) arrayList.get(size)).cmd != 8) {
                    z4 = true;
                } else if (z4) {
                    break;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i6 = size + 1;
            AdapterHelper adapterHelper = (AdapterHelper) opReorderer.mCallback;
            Pools$SimplePool pools$SimplePool = adapterHelper.mUpdateOpPool;
            UpdateOp updateOp4 = (UpdateOp) arrayList.get(size);
            UpdateOp updateOp5 = (UpdateOp) arrayList.get(i6);
            int i7 = updateOp5.cmd;
            if (i7 == 1) {
                int i8 = updateOp4.itemCount;
                int i9 = updateOp5.positionStart;
                if (i8 < i9) {
                    i5 = -1;
                } else {
                    i5 = 0;
                }
                int i10 = updateOp4.positionStart;
                if (i10 < i9) {
                    i5++;
                }
                if (i9 <= i10) {
                    updateOp4.positionStart = i10 + updateOp5.itemCount;
                }
                int i11 = updateOp5.positionStart;
                if (i11 <= i8) {
                    updateOp4.itemCount = i8 + updateOp5.itemCount;
                }
                updateOp5.positionStart = i11 + i5;
                arrayList.set(size, updateOp5);
                arrayList.set(i6, updateOp4);
            } else if (i7 == 2) {
                int i12 = updateOp4.positionStart;
                int i13 = updateOp4.itemCount;
                if (i12 < i13) {
                    if (updateOp5.positionStart == i12 && updateOp5.itemCount == i13 - i12) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = false;
                } else {
                    if (updateOp5.positionStart == i13 + 1 && updateOp5.itemCount == i12 - i13) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = true;
                }
                int i14 = updateOp5.positionStart;
                if (i13 < i14) {
                    updateOp5.positionStart = i14 - 1;
                } else {
                    int i15 = updateOp5.itemCount;
                    if (i13 < i14 + i15) {
                        updateOp5.itemCount = i15 - 1;
                        updateOp4.cmd = 2;
                        updateOp4.itemCount = 1;
                        if (updateOp5.itemCount == 0) {
                            arrayList.remove(i6);
                            updateOp5.payload = null;
                            pools$SimplePool.release(updateOp5);
                        }
                    }
                }
                int i16 = updateOp4.positionStart;
                int i17 = updateOp5.positionStart;
                if (i16 <= i17) {
                    updateOp5.positionStart = i17 + 1;
                } else {
                    int i18 = i17 + updateOp5.itemCount;
                    if (i16 < i18) {
                        obj = null;
                        UpdateOp obtainUpdateOp = adapterHelper.obtainUpdateOp(null, 2, i16 + 1, i18 - i16);
                        updateOp5.itemCount = updateOp4.positionStart - updateOp5.positionStart;
                        updateOp3 = obtainUpdateOp;
                        if (!z3) {
                            arrayList.set(size, updateOp5);
                            arrayList.remove(i6);
                            updateOp4.payload = obj;
                            pools$SimplePool.release(updateOp4);
                        } else {
                            if (z2) {
                                if (updateOp3 != null) {
                                    int i19 = updateOp4.positionStart;
                                    if (i19 > updateOp3.positionStart) {
                                        updateOp4.positionStart = i19 - updateOp3.itemCount;
                                    }
                                    int i20 = updateOp4.itemCount;
                                    if (i20 > updateOp3.positionStart) {
                                        updateOp4.itemCount = i20 - updateOp3.itemCount;
                                    }
                                }
                                int i21 = updateOp4.positionStart;
                                if (i21 > updateOp5.positionStart) {
                                    updateOp4.positionStart = i21 - updateOp5.itemCount;
                                }
                                int i22 = updateOp4.itemCount;
                                if (i22 > updateOp5.positionStart) {
                                    updateOp4.itemCount = i22 - updateOp5.itemCount;
                                }
                            } else {
                                if (updateOp3 != null) {
                                    int i23 = updateOp4.positionStart;
                                    if (i23 >= updateOp3.positionStart) {
                                        updateOp4.positionStart = i23 - updateOp3.itemCount;
                                    }
                                    int i24 = updateOp4.itemCount;
                                    if (i24 >= updateOp3.positionStart) {
                                        updateOp4.itemCount = i24 - updateOp3.itemCount;
                                    }
                                }
                                int i25 = updateOp4.positionStart;
                                if (i25 >= updateOp5.positionStart) {
                                    updateOp4.positionStart = i25 - updateOp5.itemCount;
                                }
                                int i26 = updateOp4.itemCount;
                                if (i26 >= updateOp5.positionStart) {
                                    updateOp4.itemCount = i26 - updateOp5.itemCount;
                                }
                            }
                            arrayList.set(size, updateOp5);
                            if (updateOp4.positionStart != updateOp4.itemCount) {
                                arrayList.set(i6, updateOp4);
                            } else {
                                arrayList.remove(i6);
                            }
                            if (updateOp3 != null) {
                                arrayList.add(size, updateOp3);
                            }
                        }
                    }
                }
                obj = null;
                updateOp3 = null;
                if (!z3) {
                }
            } else if (i7 == 4) {
                int i27 = updateOp4.itemCount;
                int i28 = updateOp5.positionStart;
                if (i27 < i28) {
                    updateOp5.positionStart = i28 - 1;
                } else {
                    int i29 = updateOp5.itemCount;
                    if (i27 < i28 + i29) {
                        updateOp5.itemCount = i29 - 1;
                        updateOp = adapterHelper.obtainUpdateOp(updateOp5.payload, 4, updateOp4.positionStart, 1);
                        i3 = updateOp4.positionStart;
                        i4 = updateOp5.positionStart;
                        if (i3 > i4) {
                            updateOp5.positionStart = i4 + 1;
                        } else {
                            int i30 = i4 + updateOp5.itemCount;
                            if (i3 < i30) {
                                int i31 = i30 - i3;
                                updateOp2 = adapterHelper.obtainUpdateOp(updateOp5.payload, 4, i3 + 1, i31);
                                updateOp5.itemCount -= i31;
                                arrayList.set(i6, updateOp4);
                                if (updateOp5.itemCount > 0) {
                                    arrayList.set(size, updateOp5);
                                } else {
                                    arrayList.remove(size);
                                    updateOp5.payload = null;
                                    pools$SimplePool.release(updateOp5);
                                }
                                if (updateOp != null) {
                                    arrayList.add(size, updateOp);
                                }
                                if (updateOp2 != null) {
                                    arrayList.add(size, updateOp2);
                                }
                            }
                        }
                        updateOp2 = null;
                        arrayList.set(i6, updateOp4);
                        if (updateOp5.itemCount > 0) {
                        }
                        if (updateOp != null) {
                        }
                        if (updateOp2 != null) {
                        }
                    }
                }
                updateOp = null;
                i3 = updateOp4.positionStart;
                i4 = updateOp5.positionStart;
                if (i3 > i4) {
                }
                updateOp2 = null;
                arrayList.set(i6, updateOp4);
                if (updateOp5.itemCount > 0) {
                }
                if (updateOp != null) {
                }
                if (updateOp2 != null) {
                }
            }
        }
        int size2 = arrayList.size();
        int i32 = 0;
        while (i32 < size2) {
            UpdateOp updateOp6 = (UpdateOp) arrayList.get(i32);
            int i33 = updateOp6.cmd;
            if (i33 != i) {
                Pools$SimplePool pools$SimplePool2 = this.mUpdateOpPool;
                RecyclerView.C01045 r12 = this.mCallback;
                if (i33 == 2) {
                    int i34 = updateOp6.positionStart;
                    int i35 = updateOp6.itemCount + i34;
                    int i36 = i34;
                    int i37 = 0;
                    int i38 = -1;
                    while (i36 < i35) {
                        if (r12.findViewHolder(i36) != null || canFindInPreLayout(i36)) {
                            if (i38 == 0) {
                                dispatchAndUpdateViewHolders(obtainUpdateOp(null, 2, i34, i37));
                                z = true;
                            } else {
                                z = false;
                            }
                            i38 = 1;
                        } else {
                            if (i38 == i) {
                                postponeAndUpdateViewHolders(obtainUpdateOp(null, 2, i34, i37));
                                z = true;
                            } else {
                                z = false;
                            }
                            i38 = 0;
                        }
                        if (z) {
                            i36 -= i37;
                            i35 -= i37;
                            i37 = 1;
                        } else {
                            i37++;
                        }
                        i36++;
                        i = 1;
                    }
                    if (i37 != updateOp6.itemCount) {
                        updateOp6.payload = null;
                        pools$SimplePool2.release(updateOp6);
                        updateOp6 = obtainUpdateOp(null, 2, i34, i37);
                    }
                    if (i38 == 0) {
                        dispatchAndUpdateViewHolders(updateOp6);
                    } else {
                        postponeAndUpdateViewHolders(updateOp6);
                    }
                } else if (i33 == 4) {
                    int i39 = updateOp6.positionStart;
                    int i40 = updateOp6.itemCount + i39;
                    int i41 = i39;
                    int i42 = -1;
                    int i43 = 0;
                    while (i39 < i40) {
                        if (r12.findViewHolder(i39) != null || canFindInPreLayout(i39)) {
                            if (i42 == 0) {
                                dispatchAndUpdateViewHolders(obtainUpdateOp(updateOp6.payload, 4, i41, i43));
                                i41 = i39;
                                i43 = 0;
                            }
                            i42 = 1;
                        } else {
                            if (i42 == i) {
                                postponeAndUpdateViewHolders(obtainUpdateOp(updateOp6.payload, 4, i41, i43));
                                i41 = i39;
                                i43 = 0;
                            }
                            i42 = 0;
                        }
                        i43 += i;
                        i39++;
                    }
                    if (i43 != updateOp6.itemCount) {
                        Object obj2 = updateOp6.payload;
                        updateOp6.payload = null;
                        pools$SimplePool2.release(updateOp6);
                        updateOp6 = obtainUpdateOp(obj2, 4, i41, i43);
                    }
                    if (i42 == 0) {
                        dispatchAndUpdateViewHolders(updateOp6);
                    } else {
                        postponeAndUpdateViewHolders(updateOp6);
                    }
                } else if (i33 == i2) {
                    postponeAndUpdateViewHolders(updateOp6);
                }
            } else {
                postponeAndUpdateViewHolders(updateOp6);
            }
            i32++;
            i = 1;
            i2 = 8;
        }
        arrayList.clear();
    }

    public final void recycleUpdateOpsAndClearList(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(i);
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
        arrayList.clear();
    }

    public final int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = this.mPostponedList;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = (UpdateOp) arrayList.get(size);
            int i5 = updateOp.cmd;
            if (i5 == 8) {
                int i6 = updateOp.positionStart;
                int i7 = updateOp.itemCount;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            updateOp.positionStart = i6 + 1;
                            updateOp.itemCount = i7 + 1;
                        } else if (i2 == 2) {
                            updateOp.positionStart = i6 - 1;
                            updateOp.itemCount = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        updateOp.itemCount = i7 + 1;
                    } else if (i2 == 2) {
                        updateOp.itemCount = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        updateOp.positionStart = i6 + 1;
                    } else if (i2 == 2) {
                        updateOp.positionStart = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = updateOp.positionStart;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= updateOp.itemCount;
                    } else if (i5 == 2) {
                        i += updateOp.itemCount;
                    }
                } else if (i2 == 1) {
                    updateOp.positionStart = i8 + 1;
                } else if (i2 == 2) {
                    updateOp.positionStart = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = (UpdateOp) arrayList.get(size2);
            int i9 = updateOp2.cmd;
            Pools$SimplePool pools$SimplePool = this.mUpdateOpPool;
            if (i9 == 8) {
                int i10 = updateOp2.itemCount;
                if (i10 == updateOp2.positionStart || i10 < 0) {
                    arrayList.remove(size2);
                    updateOp2.payload = null;
                    pools$SimplePool.release(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                arrayList.remove(size2);
                updateOp2.payload = null;
                pools$SimplePool.release(updateOp2);
            }
        }
        return i;
    }
}
