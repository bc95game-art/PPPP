package com.emanuelef.remote_capture;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.AppStats;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.ConnectionUpdate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ConnectionsRegister {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ConnectionsRegister";
    private final AppsResolver mAppsResolver;
    private final Geolocation mGeo;
    private final ConnectionDescriptor[] mItemsRing;
    private long mLastFirewallBlock;
    private int mNumBlocked;
    private int mNumMalicious;
    private final int mSize;
    private int mTail = 0;
    private int mCurItems = 0;
    private int mUntrackedItems = 0;
    private long mMaxBytes = 0;
    private final ArrayList<ConnectionsListener> mListeners = new ArrayList<>();
    private final SparseArray<AppStats> mAppsStats = new SparseArray<>();
    private final SparseIntArray mConnsByIface = new SparseIntArray();

    public ConnectionsRegister(Context context, int i) {
        this.mSize = i;
        this.mGeo = new Geolocation(context);
        this.mItemsRing = new ConnectionDescriptor[i];
        this.mAppsResolver = new AppsResolver(context);
    }

    private synchronized void calculateMaxBytes() {
        long j = 0;
        for (int i = 0; i < this.mCurItems; i++) {
            try {
                ConnectionDescriptor connectionDescriptor = this.mItemsRing[i];
                j = Math.max(j, connectionDescriptor.sent_bytes + connectionDescriptor.rcvd_bytes);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mMaxBytes = j;
    }

    private synchronized int firstPos() {
        int i;
        if (this.mCurItems < this.mSize) {
            i = 0;
        } else {
            i = this.mTail;
        }
        return i;
    }

    private synchronized AppStats getAppsStatsOrCreate(int i) {
        AppStats appStats;
        appStats = this.mAppsStats.get(i);
        if (appStats == null) {
            appStats = new AppStats(i);
            this.mAppsStats.put(i, appStats);
        }
        return appStats;
    }

    private synchronized int lastPos() {
        int i;
        i = this.mSize;
        return ((this.mTail - 1) + i) % i;
    }

    private void processConnectionStatus(ConnectionDescriptor connectionDescriptor, AppStats appStats) {
        boolean isBlacklisted = connectionDescriptor.isBlacklisted();
        boolean z = connectionDescriptor.alerted;
        if (!z && isBlacklisted) {
            CaptureService.requireInstance().notifyBlacklistedConnection(connectionDescriptor);
            connectionDescriptor.alerted = true;
            this.mNumMalicious++;
        } else if (z && !isBlacklisted) {
            connectionDescriptor.alerted = false;
            this.mNumMalicious--;
        }
        boolean z2 = connectionDescriptor.block_accounted;
        if (!z2 && connectionDescriptor.is_blocked) {
            this.mNumBlocked++;
            appStats.numBlockedConnections++;
            connectionDescriptor.block_accounted = true;
        } else if (z2 && !connectionDescriptor.is_blocked) {
            this.mNumBlocked--;
            appStats.numBlockedConnections--;
            connectionDescriptor.block_accounted = false;
        }
        if (connectionDescriptor.is_blocked) {
            this.mLastFirewallBlock = Math.max(connectionDescriptor.last_seen, this.mLastFirewallBlock);
        }
    }

    public synchronized void addListener(ConnectionsListener connectionsListener) {
        this.mListeners.add(connectionsListener);
        connectionsListener.connectionsChanges(this.mCurItems);
        Log.d(TAG, "(add) new connections listeners size: " + this.mListeners.size());
    }

    public synchronized void connectionsUpdates(ConnectionUpdate[] connectionUpdateArr) {
        int i;
        int i2;
        int i3;
        if (this.mCurItems != 0) {
            int firstPos = firstPos();
            int lastPos = lastPos();
            ConnectionDescriptor[] connectionDescriptorArr = this.mItemsRing;
            int i4 = connectionDescriptorArr[firstPos].incr_id;
            int i5 = connectionDescriptorArr[lastPos].incr_id;
            int[] iArr = new int[connectionUpdateArr.length];
            Log.d(TAG, "connectionsUpdates: items=" + this.mCurItems + ", first_id=" + i4 + ", last_id=" + i5);
            int length = connectionUpdateArr.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                ConnectionUpdate connectionUpdate = connectionUpdateArr[i6];
                int i8 = connectionUpdate.incr_id;
                if (i8 < i4 || i8 > i5) {
                    i = length;
                    i2 = firstPos;
                    i3 = i6;
                } else {
                    int i9 = ((i8 - i4) + firstPos) % this.mSize;
                    ConnectionDescriptor connectionDescriptor = this.mItemsRing[i9];
                    AppStats appsStatsOrCreate = getAppsStatsOrCreate(connectionDescriptor.uid);
                    long j = appsStatsOrCreate.sentBytes;
                    i3 = i6;
                    long j2 = connectionUpdate.sent_bytes;
                    i = length;
                    i2 = firstPos;
                    appsStatsOrCreate.sentBytes = (j2 - connectionDescriptor.sent_bytes) + j;
                    long j3 = appsStatsOrCreate.rcvdBytes;
                    long j4 = connectionUpdate.rcvd_bytes;
                    appsStatsOrCreate.rcvdBytes = (j4 - connectionDescriptor.rcvd_bytes) + j3;
                    this.mMaxBytes = Math.max(this.mMaxBytes, j2 + j4);
                    connectionDescriptor.processUpdate(connectionUpdate);
                    processConnectionStatus(connectionDescriptor, appsStatsOrCreate);
                    int i10 = i7 + 1;
                    int i11 = this.mSize;
                    iArr[i7] = ((i9 + i11) - i2) % i11;
                    i7 = i10;
                }
                i6 = i3 + 1;
                firstPos = i2;
                length = i;
            }
            if (i7 != 0) {
                if (i7 != connectionUpdateArr.length) {
                    iArr = Arrays.copyOf(iArr, i7);
                }
                ArrayList<ConnectionsListener> arrayList = this.mListeners;
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    ConnectionsListener connectionsListener = arrayList.get(i12);
                    i12++;
                    connectionsListener.connectionsUpdated(iArr);
                }
            }
        }
    }

    public synchronized AppStats getAppStats(int i) {
        return this.mAppsStats.get(i);
    }

    public synchronized List<AppStats> getAppsStats() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.mAppsStats.size());
        for (int i = 0; i < this.mAppsStats.size(); i++) {
            arrayList.add(this.mAppsStats.valueAt(i).clone());
        }
        return arrayList;
    }

    public synchronized ConnectionDescriptor getConn(int i) {
        if (i >= 0) {
            if (i < this.mCurItems) {
                return this.mItemsRing[(firstPos() + i) % this.mSize];
            }
        }
        return null;
    }

    public synchronized ConnectionDescriptor getConnById(int i) {
        int connPositionById = getConnPositionById(i);
        if (connPositionById < 0) {
            return null;
        }
        return getConn(connPositionById);
    }

    public int getConnCount() {
        return this.mCurItems;
    }

    public synchronized int getConnPositionById(int i) {
        if (this.mCurItems <= 0) {
            return -1;
        }
        ConnectionDescriptor connectionDescriptor = this.mItemsRing[firstPos()];
        ConnectionDescriptor connectionDescriptor2 = this.mItemsRing[lastPos()];
        int i2 = connectionDescriptor.incr_id;
        if (i >= i2) {
            if (i <= connectionDescriptor2.incr_id) {
                return i - i2;
            }
        }
        return -1;
    }

    public long getLastFirewallBlock() {
        return this.mLastFirewallBlock;
    }

    public synchronized long getMaxBytes() {
        return this.mMaxBytes;
    }

    public int getNumBlockedConnections() {
        return this.mNumBlocked;
    }

    public int getNumMaliciousConnections() {
        return this.mNumMalicious;
    }

    public synchronized List<String> getSeenInterfaces() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (int i = 0; i < this.mConnsByIface.size(); i++) {
                String interfaceName = CaptureService.getInterfaceName(this.mConnsByIface.keyAt(i));
                if (!interfaceName.isEmpty()) {
                    arrayList.add(interfaceName);
                }
            }
            Collections.sort(arrayList);
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized Set<Integer> getSeenUids() {
        ArraySet arraySet;
        arraySet = new ArraySet(0);
        for (int i = 0; i < this.mAppsStats.size(); i++) {
            arraySet.add(Integer.valueOf(this.mAppsStats.keyAt(i)));
        }
        return arraySet;
    }

    public int getUntrackedConnCount() {
        return this.mUntrackedItems;
    }

    public synchronized boolean hasSeenMultipleInterfaces() {
        boolean z;
        z = true;
        if (this.mConnsByIface.size() <= 1) {
            z = false;
        }
        return z;
    }

    public synchronized void newConnections(ConnectionDescriptor[] connectionDescriptorArr) {
        boolean z;
        ConnectionDescriptor[] connectionDescriptorArr2;
        ConnectionDescriptor[] connectionDescriptorArr3 = connectionDescriptorArr;
        synchronized (this) {
            try {
                int length = connectionDescriptorArr3.length;
                int i = this.mSize;
                if (length > i) {
                    this.mUntrackedItems = (connectionDescriptorArr3.length - i) + this.mUntrackedItems;
                    connectionDescriptorArr3 = (ConnectionDescriptor[]) Arrays.copyOfRange(connectionDescriptorArr3, connectionDescriptorArr3.length - i, connectionDescriptorArr3.length);
                }
                int length2 = connectionDescriptorArr3.length - Math.min(this.mSize - this.mCurItems, connectionDescriptorArr3.length);
                int i2 = this.mCurItems;
                int i3 = 1;
                if (length2 > 0) {
                    int firstPos = firstPos();
                    connectionDescriptorArr2 = new ConnectionDescriptor[length2];
                    z = false;
                    for (int i4 = 0; i4 < length2; i4++) {
                        ConnectionDescriptor connectionDescriptor = this.mItemsRing[firstPos];
                        if (connectionDescriptor != null) {
                            int i5 = connectionDescriptor.ifidx;
                            if (i5 > 0) {
                                int i6 = this.mConnsByIface.get(i5) - 1;
                                if (i6 <= 0) {
                                    this.mConnsByIface.delete(connectionDescriptor.ifidx);
                                } else {
                                    this.mConnsByIface.put(connectionDescriptor.ifidx, i6);
                                }
                            }
                            if (connectionDescriptor.isBlacklisted()) {
                                this.mNumMalicious--;
                            }
                            if (connectionDescriptor.sent_bytes + connectionDescriptor.rcvd_bytes == this.mMaxBytes) {
                                z = true;
                            }
                        }
                        connectionDescriptorArr2[i4] = connectionDescriptor;
                        firstPos = (firstPos + 1) % this.mSize;
                    }
                } else {
                    connectionDescriptorArr2 = null;
                    z = false;
                }
                int length3 = connectionDescriptorArr3.length;
                int i7 = 0;
                while (i7 < length3) {
                    ConnectionDescriptor connectionDescriptor2 = connectionDescriptorArr3[i7];
                    ConnectionDescriptor[] connectionDescriptorArr4 = this.mItemsRing;
                    int i8 = this.mTail;
                    connectionDescriptorArr4[i8] = connectionDescriptor2;
                    int i9 = this.mSize;
                    this.mTail = (i8 + 1) % i9;
                    this.mCurItems = Math.min(this.mCurItems + i3, i9);
                    AppStats appsStatsOrCreate = getAppsStatsOrCreate(connectionDescriptor2.uid);
                    int i10 = connectionDescriptor2.ifidx;
                    if (i10 > 0) {
                        this.mConnsByIface.put(connectionDescriptor2.ifidx, this.mConnsByIface.get(i10) + i3);
                    }
                    connectionDescriptor2.asn = this.mGeo.getASN(connectionDescriptor2.getDstAddr());
                    AppDescriptor appByUid = this.mAppsResolver.getAppByUid(connectionDescriptor2.uid, 0);
                    if (appByUid != null) {
                        connectionDescriptor2.encrypted_payload = Utils.hasEncryptedPayload(appByUid, connectionDescriptor2);
                    }
                    processConnectionStatus(connectionDescriptor2, appsStatsOrCreate);
                    appsStatsOrCreate.numConnections += i3;
                    long j = appsStatsOrCreate.rcvdBytes;
                    long j2 = connectionDescriptor2.rcvd_bytes;
                    appsStatsOrCreate.rcvdBytes = j + j2;
                    long j3 = appsStatsOrCreate.sentBytes;
                    int i11 = length3;
                    long j4 = connectionDescriptor2.sent_bytes;
                    appsStatsOrCreate.sentBytes = j3 + j4;
                    long j5 = j4 + j2;
                    if (j5 > this.mMaxBytes) {
                        this.mMaxBytes = j5;
                        z = false;
                    }
                    i7++;
                    length3 = i11;
                    i3 = 1;
                }
                this.mUntrackedItems += length2;
                if (z) {
                    calculateMaxBytes();
                }
                ArrayList<ConnectionsListener> arrayList = this.mListeners;
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    ConnectionsListener connectionsListener = arrayList.get(i12);
                    i12++;
                    ConnectionsListener connectionsListener2 = connectionsListener;
                    if (length2 > 0) {
                        connectionsListener2.connectionsRemoved(0, connectionDescriptorArr2);
                    }
                    if (connectionDescriptorArr3.length > 0) {
                        connectionsListener2.connectionsAdded(i2 - length2, connectionDescriptorArr3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void releasePayloadMemory() {
        Log.i(TAG, "releaseFullPayloadMemory called");
        for (int i = 0; i < this.mCurItems; i++) {
            this.mItemsRing[i].dropPayload();
        }
    }

    public synchronized void removeListener(ConnectionsListener connectionsListener) {
        this.mListeners.remove(connectionsListener);
        Log.d(TAG, "(remove) new connections listeners size: " + this.mListeners.size());
    }

    public synchronized void reset() {
        int i = 0;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            try {
                this.mItemsRing[i2] = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCurItems = 0;
        this.mUntrackedItems = 0;
        this.mTail = 0;
        this.mAppsStats.clear();
        ArrayList<ConnectionsListener> arrayList = this.mListeners;
        int size = arrayList.size();
        while (i < size) {
            ConnectionsListener connectionsListener = arrayList.get(i);
            i++;
            connectionsListener.connectionsChanges(this.mCurItems);
        }
    }

    public synchronized void resetAppsStats() {
        this.mAppsStats.clear();
    }
}
