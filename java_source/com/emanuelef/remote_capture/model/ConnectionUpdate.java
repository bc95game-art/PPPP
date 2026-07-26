package com.emanuelef.remote_capture.model;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConnectionUpdate {
    public static final int UPDATE_INFO = 2;
    public static final int UPDATE_INFO_FLAG_ENCRYPTED_L7 = 1;
    public static final int UPDATE_PAYLOAD = 4;
    public static final int UPDATE_STATS = 1;
    public int blocked_pkts;
    public final int incr_id;
    public String info;
    public int info_flags;
    public String l7proto;
    public long last_seen;
    public ArrayList<PayloadChunk> payload_chunks;
    public boolean payload_decrypted;
    public long payload_length;
    public boolean payload_truncated;
    public long rcvd_bytes;
    public int rcvd_pkts;
    public long sent_bytes;
    public int sent_pkts;
    public int status;
    public int tcp_flags;
    public int update_type;
    public String url;

    public ConnectionUpdate(int i) {
        this.incr_id = i;
    }

    public void setInfo(String str, String str2, String str3, int i) {
        this.update_type |= 2;
        this.info = str;
        this.url = str2;
        this.l7proto = str3;
        this.info_flags = i;
    }

    public void setPayload(ArrayList<PayloadChunk> arrayList, int i) {
        boolean z;
        this.update_type |= 4;
        this.payload_chunks = arrayList;
        boolean z2 = false;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.payload_truncated = z;
        if ((i & 2) != 0) {
            z2 = true;
        }
        this.payload_decrypted = z2;
    }

    public void setStats(long j, long j2, long j3, long j4, int i, int i2, int i3, int i4, int i5) {
        this.update_type |= 1;
        this.last_seen = j;
        this.payload_length = j2;
        this.sent_bytes = j3;
        this.rcvd_bytes = j4;
        this.sent_pkts = i;
        this.blocked_pkts = i3;
        this.rcvd_pkts = i2;
        this.tcp_flags = i4;
        this.status = i5;
    }
}
