.class public Lcom/emanuelef/remote_capture/model/CaptureStats;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field public active_conns:I

.field public alloc_summary:Ljava/lang/String;

.field public bytes_rcvd:J

.field public bytes_sent:J

.field public ipv6_bytes_rcvd:J

.field public ipv6_bytes_sent:J

.field public max_fd:I

.field public num_dns_queries:I

.field public num_dropped_conns:I

.field public num_open_sockets:I

.field public pcap_dump_size:J

.field public pkts_dropped:I

.field public pkts_rcvd:I

.field public pkts_sent:I

.field public tot_conns:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method


# virtual methods
.method public setData(Ljava/lang/String;JJJJJIIIIIIIII)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->alloc_summary:Ljava/lang/String;

    .line 2
    iput-wide p2, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->bytes_sent:J

    .line 3
    iput-wide p4, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->bytes_rcvd:J

    .line 4
    iput-wide p6, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->ipv6_bytes_sent:J

    .line 5
    iput-wide p8, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->ipv6_bytes_rcvd:J

    .line 6
    iput-wide p10, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->pcap_dump_size:J

    .line 7
    iput p12, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->pkts_sent:I

    .line 8
    iput p13, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->pkts_rcvd:I

    .line 9
    iput p14, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->pkts_dropped:I

    .line 10
    iput p15, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->num_dropped_conns:I

    move/from16 p1, p16

    .line 11
    iput p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->num_open_sockets:I

    move/from16 p1, p17

    .line 12
    iput p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->max_fd:I

    move/from16 p1, p18

    .line 13
    iput p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->active_conns:I

    move/from16 p1, p19

    .line 14
    iput p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->tot_conns:I

    move/from16 p1, p20

    .line 15
    iput p1, p0, Lcom/emanuelef/remote_capture/model/CaptureStats;->num_dns_queries:I

    return-void
.end method
