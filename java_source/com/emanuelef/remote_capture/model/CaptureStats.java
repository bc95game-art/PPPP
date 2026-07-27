package com.emanuelef.remote_capture.model;

import java.io.Serializable;
/* loaded from: classes.dex */
public class CaptureStats implements Serializable {
    public int active_conns;
    public String alloc_summary;
    public long bytes_rcvd;
    public long bytes_sent;
    public long ipv6_bytes_rcvd;
    public long ipv6_bytes_sent;
    public int max_fd;
    public int num_dns_queries;
    public int num_dropped_conns;
    public int num_open_sockets;
    public long pcap_dump_size;
    public int pkts_dropped;
    public int pkts_rcvd;
    public int pkts_sent;
    public int tot_conns;

    public void setData(String str, long j, long j2, long j3, long j4, long j5, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.alloc_summary = str;
        this.bytes_sent = j;
        this.bytes_rcvd = j2;
        this.ipv6_bytes_sent = j3;
        this.ipv6_bytes_rcvd = j4;
        this.pcap_dump_size = j5;
        this.pkts_sent = i;
        this.pkts_rcvd = i2;
        this.pkts_dropped = i3;
        this.num_dropped_conns = i4;
        this.num_open_sockets = i5;
        this.max_fd = i6;
        this.active_conns = i7;
        this.tot_conns = i8;
        this.num_dns_queries = i9;
    }
}
