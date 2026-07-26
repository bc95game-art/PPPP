package com.emanuelef.remote_capture.model;
/* loaded from: classes.dex */
public class AppStats implements Cloneable {
    public int numBlockedConnections;
    public int numConnections;
    public long rcvdBytes;
    public long sentBytes;
    private final int uid;

    public AppStats(int i) {
        this.uid = i;
    }

    public int getUid() {
        return this.uid;
    }

    public AppStats clone() {
        AppStats appStats = new AppStats(this.uid);
        appStats.sentBytes = this.sentBytes;
        appStats.rcvdBytes = this.rcvdBytes;
        appStats.numConnections = this.numConnections;
        appStats.numBlockedConnections = this.numBlockedConnections;
        return appStats;
    }
}
