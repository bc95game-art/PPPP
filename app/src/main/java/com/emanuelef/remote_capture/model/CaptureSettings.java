package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.model.Prefs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class CaptureSettings implements Serializable {
    public boolean api_capture;
    public HashSet<String> app_filter;
    public boolean auto_block_private_dns;
    public Prefs.BlockQuicMode block_quic_mode;
    public String capture_interface;
    public String collector_address;
    public int collector_port;
    public String decryption_rules_json;
    public boolean dump_extensions;
    public Prefs.DumpMode dump_mode;
    public boolean full_payload;
    public int http_server_port;
    public String input_pcap_path;
    public Prefs.IpMode ip_mode;
    public int max_dump_size;
    public int max_pkts_per_flow;
    public String mitmproxy_opts;
    public String pcap_name;
    public String pcap_uri;
    public boolean pcapng_format;
    public boolean root_capture;
    public int snaplen;
    public boolean socks5_enabled;
    public String socks5_password;
    public String socks5_proxy_address;
    public int socks5_proxy_port;
    public String socks5_username;
    public String sslkeylog_name;
    public boolean tls_decryption;

    public CaptureSettings(Context context, SharedPreferences sharedPreferences) {
        String str = "";
        this.decryption_rules_json = str;
        this.pcap_uri = str;
        this.pcap_name = str;
        this.sslkeylog_name = str;
        this.snaplen = 0;
        this.max_pkts_per_flow = 0;
        this.max_dump_size = 0;
        this.dump_mode = Prefs.getDumpMode(sharedPreferences);
        this.app_filter = new HashSet<>(Prefs.getAppFilter(sharedPreferences));
        this.collector_address = Prefs.getCollectorIp(sharedPreferences);
        this.collector_port = Prefs.getCollectorPort(sharedPreferences);
        this.http_server_port = Prefs.getHttpServerPort(sharedPreferences);
        this.socks5_enabled = Prefs.getSocks5Enabled(sharedPreferences);
        this.socks5_proxy_address = Prefs.getSocks5ProxyHost(sharedPreferences);
        this.socks5_proxy_port = Prefs.getSocks5ProxyPort(sharedPreferences);
        this.socks5_username = Prefs.isSocks5AuthEnabled(sharedPreferences) ? Prefs.getSocks5Username(sharedPreferences) : str;
        this.socks5_password = Prefs.isSocks5AuthEnabled(sharedPreferences) ? Prefs.getSocks5Password(sharedPreferences) : str;
        this.ip_mode = Prefs.getIPMode(sharedPreferences);
        this.root_capture = Prefs.isRootCaptureEnabled(sharedPreferences);
        this.dump_extensions = Prefs.isPcapdroidMetadataEnabled(sharedPreferences);
        this.capture_interface = Prefs.getCaptureInterface(sharedPreferences);
        this.tls_decryption = Prefs.getTlsDecryptionEnabled(sharedPreferences);
        this.full_payload = Prefs.getFullPayloadMode(sharedPreferences);
        this.block_quic_mode = Prefs.getBlockQuicMode(sharedPreferences);
        this.auto_block_private_dns = Prefs.isPrivateDnsBlockingEnabled(sharedPreferences);
        this.mitmproxy_opts = Prefs.getMitmproxyOpts(sharedPreferences);
        this.pcapng_format = Prefs.isPcapngEnabled(context, sharedPreferences);
        this.api_capture = false;
    }

    private static boolean getBool(Intent intent, String str, boolean z) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(str);
        if (string != null) {
            return Boolean.parseBoolean(string);
        }
        return extras.getBoolean(str, z);
    }

    private String getDecryptionRulesFromIntent(Intent intent) {
        String string = getString(intent, "decryption_rules", "");
        int length = string.length();
        int i = 0;
        while (i < length) {
            int codePointAt = string.codePointAt(i);
            if (!Character.isWhitespace(codePointAt)) {
                return ViewModelProvider.Factory.CC.m("{\"rules\":", string, "}");
            }
            i += Character.charCount(codePointAt);
        }
        return "";
    }

    private static int getInt(Intent intent, String str, int i) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(str);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return extras.getInt(str, i);
    }

    private static String getString(Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        return str2;
    }

    private static List<String> getStringList(Intent intent, String str) {
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra == null) {
            return new ArrayList();
        }
        if (stringExtra.indexOf(44) >= 0) {
            return Arrays.asList(stringExtra.split(","));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(stringExtra);
        return arrayList;
    }

    public boolean readFromPcap() {
        if (this.input_pcap_path != null) {
            return true;
        }
        return false;
    }

    public CaptureSettings(Context context, Intent intent) {
        this.decryption_rules_json = "";
        this.pcap_uri = "";
        this.pcap_name = "";
        this.sslkeylog_name = "";
        boolean z = false;
        this.snaplen = 0;
        this.max_pkts_per_flow = 0;
        this.max_dump_size = 0;
        this.dump_mode = Prefs.getDumpMode(getString(intent, "pcap_dump_mode", "none"));
        this.app_filter = new HashSet<>(getStringList(intent, Prefs.PREF_APP_FILTER));
        this.collector_address = getString(intent, Prefs.PREF_COLLECTOR_IP_KEY, "127.0.0.1");
        this.collector_port = getInt(intent, Prefs.PREF_COLLECTOR_PORT_KEY, 1234);
        this.http_server_port = getInt(intent, Prefs.PREF_HTTP_SERVER_PORT, 8080);
        this.socks5_enabled = getBool(intent, Prefs.PREF_SOCKS5_ENABLED_KEY, false);
        this.socks5_proxy_address = getString(intent, Prefs.PREF_SOCKS5_PROXY_HOST_KEY, getString(intent, Prefs.PREF_SOCKS5_PROXY_IP_KEY, "0.0.0.0"));
        this.socks5_proxy_port = getInt(intent, Prefs.PREF_SOCKS5_PROXY_PORT_KEY, 8080);
        this.socks5_username = getString(intent, Prefs.PREF_SOCKS5_USERNAME_KEY, "");
        this.socks5_password = getString(intent, Prefs.PREF_SOCKS5_PASSWORD_KEY, "");
        this.ip_mode = Prefs.getIPMode(getString(intent, Prefs.PREF_IP_MODE, "ipv4"));
        this.root_capture = getBool(intent, Prefs.PREF_ROOT_CAPTURE, false);
        this.dump_extensions = getBool(intent, Prefs.PREF_DUMP_EXTENSIONS, false) || getBool(intent, "pcapdroid_trailer", false);
        this.capture_interface = getString(intent, Prefs.PREF_CAPTURE_INTERFACE, "@inet");
        this.pcap_uri = getString(intent, "pcap_uri", "");
        this.pcap_name = getString(intent, "pcap_name", "");
        this.snaplen = getInt(intent, Prefs.PREF_SNAPLEN, 0);
        this.max_pkts_per_flow = getInt(intent, Prefs.PREF_MAX_PKTS_PER_FLOW, 0);
        this.max_dump_size = getInt(intent, Prefs.PREF_MAX_DUMP_SIZE, 0);
        this.tls_decryption = getBool(intent, Prefs.PREF_TLS_DECRYPTION_KEY, false);
        this.full_payload = getBool(intent, Prefs.PREF_FULL_PAYLOAD, false);
        this.block_quic_mode = Prefs.getBlockQuicMode(getString(intent, "block_quic", "never"));
        this.auto_block_private_dns = getBool(intent, Prefs.PREF_AUTO_BLOCK_PRIVATE_DNS, true);
        this.mitmproxy_opts = getString(intent, Prefs.PREF_MITMPROXY_OPTS, "");
        if (getBool(intent, Prefs.PREF_PCAPNG_ENABLED, false) && Billing.newInstance(context).isPurchased(Billing.PCAPNG_SKU)) {
            z = true;
        }
        this.pcapng_format = z;
        this.sslkeylog_name = getString(intent, "sslkeylog_name", "");
        this.decryption_rules_json = getDecryptionRulesFromIntent(intent);
        this.api_capture = true;
    }
}
