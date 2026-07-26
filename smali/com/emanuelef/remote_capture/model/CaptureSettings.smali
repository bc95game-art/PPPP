.class public Lcom/emanuelef/remote_capture/model/CaptureSettings;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field public api_capture:Z

.field public app_filter:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public auto_block_private_dns:Z

.field public block_quic_mode:Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

.field public capture_interface:Ljava/lang/String;

.field public collector_address:Ljava/lang/String;

.field public collector_port:I

.field public decryption_rules_json:Ljava/lang/String;

.field public dump_extensions:Z

.field public dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

.field public full_payload:Z

.field public http_server_port:I

.field public input_pcap_path:Ljava/lang/String;

.field public ip_mode:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

.field public max_dump_size:I

.field public max_pkts_per_flow:I

.field public mitmproxy_opts:Ljava/lang/String;

.field public pcap_name:Ljava/lang/String;

.field public pcap_uri:Ljava/lang/String;

.field public pcapng_format:Z

.field public root_capture:Z

.field public snaplen:I

.field public socks5_enabled:Z

.field public socks5_password:Ljava/lang/String;

.field public socks5_proxy_address:Ljava/lang/String;

.field public socks5_proxy_port:I

.field public socks5_username:Ljava/lang/String;

.field public sslkeylog_name:Ljava/lang/String;

.field public tls_decryption:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const-string v0, ""

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->decryption_rules_json:Ljava/lang/String;

    .line 32
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 33
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_name:Ljava/lang/String;

    .line 34
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->sslkeylog_name:Ljava/lang/String;

    const/4 v1, 0x0

    .line 35
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->snaplen:I

    .line 36
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_pkts_per_flow:I

    .line 37
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_dump_size:I

    .line 38
    const-string v2, "pcap_dump_mode"

    const-string v3, "none"

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/emanuelef/remote_capture/model/Prefs;->getDumpMode(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 39
    new-instance v2, Ljava/util/HashSet;

    const-string v3, "app_filter"

    invoke-static {p2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getStringList(Landroid/content/Intent;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 40
    const-string v2, "collector_ip_address"

    const-string v3, "127.0.0.1"

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_address:Ljava/lang/String;

    .line 41
    const-string v2, "collector_port"

    const/16 v3, 0x4d2

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_port:I

    .line 42
    const-string v2, "http_server_port"

    const/16 v3, 0x1f90

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->http_server_port:I

    .line 43
    const-string v2, "socks5_enabled"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_enabled:Z

    .line 44
    const-string v2, "socks5_proxy_ip_address"

    const-string v4, "0.0.0.0"

    .line 45
    invoke-static {p2, v2, v4}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 46
    const-string v4, "socks5_proxy_host"

    invoke-static {p2, v4, v2}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_address:Ljava/lang/String;

    .line 47
    const-string v2, "socks5_proxy_port"

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_port:I

    .line 48
    const-string v2, "socks5_username"

    invoke-static {p2, v2, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_username:Ljava/lang/String;

    .line 49
    const-string v2, "socks5_password"

    invoke-static {p2, v2, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_password:Ljava/lang/String;

    .line 50
    const-string v2, "ip_mode"

    const-string v3, "ipv4"

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/emanuelef/remote_capture/model/Prefs;->getIPMode(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->ip_mode:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 51
    const-string v2, "root_capture"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 52
    const-string v2, "dump_extensions"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    const/4 v3, 0x1

    if-nez v2, :cond_1

    const-string v2, "pcapdroid_trailer"

    .line 53
    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v2, 0x1

    :goto_1
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_extensions:Z

    .line 54
    const-string v2, "capture_interface"

    const-string v4, "@inet"

    invoke-static {p2, v2, v4}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->capture_interface:Ljava/lang/String;

    .line 55
    const-string v2, "pcap_uri"

    invoke-static {p2, v2, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 56
    const-string v2, "pcap_name"

    invoke-static {p2, v2, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_name:Ljava/lang/String;

    .line 57
    const-string v2, "snaplen"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->snaplen:I

    .line 58
    const-string v2, "max_pkts_per_flow"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_pkts_per_flow:I

    .line 59
    const-string v2, "max_dump_size"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getInt(Landroid/content/Intent;Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_dump_size:I

    .line 60
    const-string v2, "tls_decryption"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 61
    const-string v2, "full_payload"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 62
    const-string v2, "block_quic"

    const-string v4, "never"

    invoke-static {p2, v2, v4}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/emanuelef/remote_capture/model/Prefs;->getBlockQuicMode(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->block_quic_mode:Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

    .line 63
    const-string v2, "auto_block_private_dns"

    invoke-static {p2, v2, v3}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->auto_block_private_dns:Z

    .line 64
    const-string v2, "mitmproxy_opts"

    invoke-static {p2, v2, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->mitmproxy_opts:Ljava/lang/String;

    .line 65
    const-string v2, "pcapng_format"

    invoke-static {p2, v2, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {p1}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    move-result-object p1

    const-string v2, "pcapng"

    invoke-virtual {p1, v2}, Lcom/emanuelef/remote_capture/PlayBilling;->isPurchased(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_2

    const/4 v1, 0x1

    :cond_2
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 66
    const-string p1, "sslkeylog_name"

    invoke-static {p2, p1, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->sslkeylog_name:Ljava/lang/String;

    .line 67
    invoke-direct {p0, p2}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getDecryptionRulesFromIntent(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->decryption_rules_json:Ljava/lang/String;

    .line 68
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->api_capture:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/content/SharedPreferences;)V
    .locals 4

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    const-string v0, ""

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->decryption_rules_json:Ljava/lang/String;

    .line 3
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 4
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_name:Ljava/lang/String;

    .line 5
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->sslkeylog_name:Ljava/lang/String;

    const/4 v1, 0x0

    .line 6
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->snaplen:I

    .line 7
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_pkts_per_flow:I

    .line 8
    iput v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_dump_size:I

    .line 9
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getDumpMode(Landroid/content/SharedPreferences;)Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 10
    new-instance v2, Ljava/util/HashSet;

    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getAppFilter(Landroid/content/SharedPreferences;)Ljava/util/Set;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 11
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getCollectorIp(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_address:Ljava/lang/String;

    .line 12
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getCollectorPort(Landroid/content/SharedPreferences;)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_port:I

    .line 13
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getHttpServerPort(Landroid/content/SharedPreferences;)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->http_server_port:I

    .line 14
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getSocks5Enabled(Landroid/content/SharedPreferences;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_enabled:Z

    .line 15
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getSocks5ProxyHost(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_address:Ljava/lang/String;

    .line 16
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getSocks5ProxyPort(Landroid/content/SharedPreferences;)I

    move-result v2

    iput v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_port:I

    .line 17
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isSocks5AuthEnabled(Landroid/content/SharedPreferences;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getSocks5Username(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    :cond_0
    move-object v2, v0

    :goto_0
    iput-object v2, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_username:Ljava/lang/String;

    .line 18
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isSocks5AuthEnabled(Landroid/content/SharedPreferences;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getSocks5Password(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v0

    :cond_1
    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_password:Ljava/lang/String;

    .line 19
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getIPMode(Landroid/content/SharedPreferences;)Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    move-result-object v0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->ip_mode:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 20
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isRootCaptureEnabled(Landroid/content/SharedPreferences;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 21
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isPcapdroidMetadataEnabled(Landroid/content/SharedPreferences;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_extensions:Z

    .line 22
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getCaptureInterface(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->capture_interface:Ljava/lang/String;

    .line 23
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getTlsDecryptionEnabled(Landroid/content/SharedPreferences;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 24
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getFullPayloadMode(Landroid/content/SharedPreferences;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 25
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getBlockQuicMode(Landroid/content/SharedPreferences;)Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

    move-result-object v0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->block_quic_mode:Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

    .line 26
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isPrivateDnsBlockingEnabled(Landroid/content/SharedPreferences;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->auto_block_private_dns:Z

    .line 27
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getMitmproxyOpts(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->mitmproxy_opts:Ljava/lang/String;

    .line 28
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/model/Prefs;->isPcapngEnabled(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    move-result p1

    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 29
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->api_capture:Z

    return-void
.end method

.method private static getBool(Landroid/content/Intent;Ljava/lang/String;Z)Z
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-virtual {p0, p1}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    .line 12
    .line 13
    .line 14
    move-result p0

    .line 15
    return p0

    .line 16
    :cond_0
    invoke-virtual {p0, p1, p2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    .line 17
    .line 18
    .line 19
    move-result p0

    .line 20
    return p0
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method

.method private getDecryptionRulesFromIntent(Landroid/content/Intent;)Ljava/lang/String;
    .locals 5

    .line 1
    const-string v0, "decryption_rules"

    .line 2
    .line 3
    const-string v1, ""

    .line 4
    .line 5
    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    const/4 v2, 0x0

    .line 14
    :goto_0
    if-ge v2, v0, :cond_1

    .line 15
    .line 16
    invoke-virtual {p1, v2}, Ljava/lang/String;->codePointAt(I)I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    invoke-static {v3}, Ljava/lang/Character;->isWhitespace(I)Z

    .line 21
    .line 22
    .line 23
    move-result v4

    .line 24
    if-nez v4, :cond_0

    .line 25
    .line 26
    const-string v0, "{\"rules\":"

    .line 27
    .line 28
    const-string v1, "}"

    .line 29
    .line 30
    invoke-static {v0, p1, v1}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 31
    .line 32
    .line 33
    move-result-object p1

    .line 34
    return-object p1

    .line 35
    :cond_0
    invoke-static {v3}, Ljava/lang/Character;->charCount(I)I

    .line 36
    .line 37
    .line 38
    move-result v3

    .line 39
    add-int/2addr v2, v3

    .line 40
    goto :goto_0

    .line 41
    :cond_1
    return-object v1
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
.end method

.method private static getInt(Landroid/content/Intent;Ljava/lang/String;I)I
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-virtual {p0, p1}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 12
    .line 13
    .line 14
    move-result p0

    .line 15
    return p0

    .line 16
    :cond_0
    invoke-virtual {p0, p1, p2}, Landroid/os/BaseBundle;->getInt(Ljava/lang/String;I)I

    .line 17
    .line 18
    .line 19
    move-result p0

    .line 20
    return p0
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method

.method private static getString(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    if-eqz p0, :cond_0

    .line 6
    .line 7
    return-object p0

    .line 8
    :cond_0
    return-object p2
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method

.method private static getStringList(Landroid/content/Intent;Ljava/lang/String;)Ljava/util/List;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1
    invoke-virtual {p0, p1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    if-eqz p0, :cond_1

    .line 6
    .line 7
    const/16 p1, 0x2c

    .line 8
    .line 9
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(I)I

    .line 10
    .line 11
    .line 12
    move-result p1

    .line 13
    if-gez p1, :cond_0

    .line 14
    .line 15
    new-instance p1, Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 18
    .line 19
    .line 20
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 21
    .line 22
    .line 23
    return-object p1

    .line 24
    :cond_0
    const-string p1, ","

    .line 25
    .line 26
    invoke-virtual {p0, p1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object p0

    .line 30
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 31
    .line 32
    .line 33
    move-result-object p0

    .line 34
    return-object p0

    .line 35
    :cond_1
    new-instance p0, Ljava/util/ArrayList;

    .line 36
    .line 37
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .line 39
    .line 40
    return-object p0
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method


# virtual methods
.method public readFromPcap()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->input_pcap_path:Ljava/lang/String;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x1

    .line 6
    return v0

    .line 7
    :cond_0
    const/4 v0, 0x0

    .line 8
    return v0
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
