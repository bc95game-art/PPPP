package com.emanuelef.remote_capture.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.ArraySet;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.Utils;
import java.util.Set;
/* loaded from: classes.dex */
public class Prefs {
    public static final String BLOCK_QUIC_MODE_ALWAYS = "always";
    public static final String BLOCK_QUIC_MODE_DEFAULT = "never";
    public static final String BLOCK_QUIC_MODE_NEVER = "never";
    public static final String BLOCK_QUIC_MODE_TO_DECRYPT = "to_decrypt";
    public static final String DEFAULT_DUMP_MODE = "none";
    public static final String DEFAULT_PAYLOAD_MODE = "minimal";
    public static final String DUMP_HTTP_SERVER = "http_server";
    public static final String DUMP_NONE = "none";
    public static final String DUMP_PCAP_FILE = "pcap_file";
    public static final String DUMP_TCP_EXPORTER = "tcp_exporter";
    public static final String DUMP_UDP_EXPORTER = "udp_exporter";
    public static final int FIREWALL_WHITELIST_INIT_VER = 1;
    public static final String IP_MODE_BOTH = "both";
    public static final String IP_MODE_DEFAULT = "ipv4";
    public static final String IP_MODE_IPV4_ONLY = "ipv4";
    public static final String IP_MODE_IPV6_ONLY = "ipv6";
    public static final String PAYLOAD_MODE_FULL = "full";
    public static final String PAYLOAD_MODE_MINIMAL = "minimal";
    public static final String PAYLOAD_MODE_NONE = "none";
    public static final String PREF_API_KEY = "api_key";
    public static final String PREF_APP_FILTER = "app_filter";
    public static final String PREF_APP_LANGUAGE = "app_language";
    public static final String PREF_APP_VERSION = "appver";
    public static final String PREF_AUTO_BLOCK_PRIVATE_DNS = "auto_block_private_dns";
    public static final String PREF_BLOCKLIST = "bl";
    public static final String PREF_BLOCK_NEW_APPS = "block_new_apps";
    public static final String PREF_BLOCK_QUIC = "block_quic_mode";
    public static final String PREF_CAPTURE_INTERFACE = "capture_interface";
    public static final String PREF_CA_INSTALLATION_SKIPPED = "ca_install_skipped";
    public static final String PREF_COLLECTOR_IP_KEY = "collector_ip_address";
    public static final String PREF_COLLECTOR_PORT_KEY = "collector_port";
    public static final String PREF_DECRYPTION_LIST = "decryption_list";
    public static final String PREF_DNS_SERVER_V4 = "dns_v4";
    public static final String PREF_DNS_SERVER_V6 = "dns_v6";
    public static final String PREF_DUMP_EXTENSIONS = "dump_extensions";
    public static final String PREF_FILENAME_PREFIX = "filename_prefix";
    public static final String PREF_FIREWALL = "firewall";
    public static final String PREF_FIREWALL_WHITELIST = "firewall_whitelist";
    public static final String PREF_FIREWALL_WHITELIST_INIT_VER = "firewall_wl_init";
    public static final String PREF_FIREWALL_WHITELIST_MODE = "firewall_wl_mode";
    public static final String PREF_FULL_PAYLOAD = "full_payload";
    public static final String PREF_HTTP_SERVER_PORT = "http_server_port";
    public static final String PREF_IGNORED_MITM_VERSION = "ignored_mitm_version";
    public static final String PREF_IP_MODE = "ip_mode";
    public static final String PREF_LOCKDOWN_VPN_NOTICE_SHOWN = "vpn_lockdown_notice";
    public static final String PREF_MALWARE_DETECTION = "malware_detection";
    public static final String PREF_MALWARE_WHITELIST = "malware_whitelist";
    public static final String PREF_MAX_DUMP_SIZE = "max_dump_size";
    public static final String PREF_MAX_PKTS_PER_FLOW = "max_pkts_per_flow";
    public static final String PREF_MITMPROXY_OPTS = "mitmproxy_opts";
    public static final String PREF_PAYLOAD_NOTICE_ACK = "payload_notice";
    public static final String PREF_PCAPNG_ENABLED = "pcapng_format";
    public static final String PREF_PCAP_DUMP_MODE = "pcap_dump_mode_v2";
    public static final String PREF_PORT_MAPPING = "port_mapping";
    public static final String PREF_PORT_MAPPING_ENABLED = "port_mapping_enabled";
    public static final String PREF_REMOTE_COLLECTOR_ACK = "remote_collector_notice";
    public static final String PREF_RESTART_ON_DISCONNECT = "restart_on_disconnect";
    public static final String PREF_ROOT_CAPTURE = "root_capture";
    public static final String PREF_SNAPLEN = "snaplen";
    public static final String PREF_SOCKS5_AUTH_ENABLED_KEY = "socks5_auth_enabled";
    public static final String PREF_SOCKS5_ENABLED_KEY = "socks5_enabled";
    public static final String PREF_SOCKS5_PASSWORD_KEY = "socks5_password";
    public static final String PREF_SOCKS5_PROXY_HOST_KEY = "socks5_proxy_host";
    public static final String PREF_SOCKS5_PROXY_IP_KEY = "socks5_proxy_ip_address";
    public static final String PREF_SOCKS5_PROXY_PORT_KEY = "socks5_proxy_port";
    public static final String PREF_SOCKS5_USERNAME_KEY = "socks5_username";
    public static final String PREF_START_AT_BOOT = "start_at_boot";
    public static final String PREF_TLS_DECRYPTION_KEY = "tls_decryption";
    public static final String PREF_TLS_DECRYPTION_SETUP_DONE = "tls_decryption_setup_ok";
    public static final String PREF_USE_SYSTEM_DNS = "system_dns";
    public static final String PREF_VISUALIZATION_MASK = "vis_mask";
    public static final String PREF_VPN_EXCEPTIONS = "vpn_exceptions";

    /* loaded from: classes.dex */
    public enum BlockQuicMode {
        NEVER,
        ALWAYS,
        TO_DECRYPT
    }

    /* loaded from: classes.dex */
    public enum DumpMode {
        NONE,
        HTTP_SERVER,
        PCAP_FILE,
        UDP_EXPORTER,
        TCP_EXPORTER
    }

    /* loaded from: classes.dex */
    public enum IpMode {
        IPV4_ONLY,
        IPV6_ONLY,
        BOTH
    }

    /* loaded from: classes.dex */
    public enum PayloadMode {
        NONE,
        MINIMAL,
        FULL
    }

    public static String asString(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return "DumpMode: " + getDumpMode(defaultSharedPreferences) + "\nFullPayload: " + getFullPayloadMode(defaultSharedPreferences) + "\nTLSDecryption: " + getTlsDecryptionEnabled(defaultSharedPreferences) + "\nTLSSetupOk: " + isTLSDecryptionSetupDone(defaultSharedPreferences) + "\nCAInstallSkipped: " + MitmAddon.isCAInstallationSkipped(context) + "\nBlockQuic: " + getBlockQuicMode(defaultSharedPreferences) + "\nRootCapture: " + isRootCaptureEnabled(defaultSharedPreferences) + "\nSocks5: " + getSocks5Enabled(defaultSharedPreferences) + "\nBlockPrivateDns: " + isPrivateDnsBlockingEnabled(defaultSharedPreferences) + "\nCaptureInterface: " + getCaptureInterface(defaultSharedPreferences) + "\nMalwareDetection: " + isMalwareDetectionEnabled(context, defaultSharedPreferences) + "\nFirewall: " + isFirewallEnabled(context, defaultSharedPreferences) + "\nPCAPNG: " + isPcapngEnabled(context, defaultSharedPreferences) + "\nBlockNewApps: " + blockNewApps(defaultSharedPreferences) + "\nTargetApps: " + getAppFilter(defaultSharedPreferences) + "\nIpMode: " + getIPMode(defaultSharedPreferences) + "\nDumpExtensions: " + isPcapdroidMetadataEnabled(defaultSharedPreferences) + "\nStartAtBoot: " + startAtBoot(defaultSharedPreferences);
    }

    public static boolean blockNewApps(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_BLOCK_NEW_APPS, false);
    }

    public static String getApiKey(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_API_KEY, "");
    }

    public static Set<String> getAppFilter(SharedPreferences sharedPreferences) {
        return getStringSet(sharedPreferences, PREF_APP_FILTER);
    }

    public static String getAppLocale(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(PREF_APP_LANGUAGE, "system");
        if ("system".equals(string)) {
            return null;
        }
        return string;
    }

    public static int getAppVersion(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt(PREF_APP_VERSION, 0);
    }

    public static BlockQuicMode getBlockQuicMode(String str) {
        str.getClass();
        if (str.equals(BLOCK_QUIC_MODE_ALWAYS)) {
            return BlockQuicMode.ALWAYS;
        }
        if (!str.equals(BLOCK_QUIC_MODE_TO_DECRYPT)) {
            return BlockQuicMode.NEVER;
        }
        return BlockQuicMode.TO_DECRYPT;
    }

    public static String getCaptureInterface(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_CAPTURE_INTERFACE, "@inet");
    }

    public static String getCollectorIp(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_COLLECTOR_IP_KEY, "127.0.0.1");
    }

    public static int getCollectorPort(SharedPreferences sharedPreferences) {
        return Integer.parseInt(sharedPreferences.getString(PREF_COLLECTOR_PORT_KEY, "1234"));
    }

    public static String getDnsServerV4(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_DNS_SERVER_V4, "1.1.1.1");
    }

    public static String getDnsServerV6(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_DNS_SERVER_V6, "2606:4700:4700::1111");
    }

    public static DumpMode getDumpMode(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2086026753:
                if (str.equals(DUMP_TCP_EXPORTER)) {
                    c = 0;
                    break;
                }
                break;
            case -641019335:
                if (str.equals(DUMP_PCAP_FILE)) {
                    c = 1;
                    break;
                }
                break;
            case 541071903:
                if (str.equals(DUMP_UDP_EXPORTER)) {
                    c = 2;
                    break;
                }
                break;
            case 992475866:
                if (str.equals(DUMP_HTTP_SERVER)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return DumpMode.TCP_EXPORTER;
            case 1:
                return DumpMode.PCAP_FILE;
            case 2:
                return DumpMode.UDP_EXPORTER;
            case 3:
                return DumpMode.HTTP_SERVER;
            default:
                return DumpMode.NONE;
        }
    }

    public static String getFilenamePrefix(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_FILENAME_PREFIX, "PCAPdroid_");
    }

    public static boolean getFullPayloadMode(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_FULL_PAYLOAD, false);
    }

    public static int getHttpServerPort(SharedPreferences sharedPreferences) {
        return Integer.parseInt(sharedPreferences.getString(PREF_HTTP_SERVER_PORT, "8080"));
    }

    public static IpMode getIPMode(String str) {
        str.getClass();
        if (str.equals(IP_MODE_BOTH)) {
            return IpMode.BOTH;
        }
        if (!str.equals(IP_MODE_IPV6_ONLY)) {
            return IpMode.IPV4_ONLY;
        }
        return IpMode.IPV6_ONLY;
    }

    public static String getMitmproxyOpts(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_MITMPROXY_OPTS, "");
    }

    public static PayloadMode getPayloadMode(String str) {
        str.getClass();
        if (str.equals(PAYLOAD_MODE_FULL)) {
            return PayloadMode.FULL;
        }
        if (!str.equals("minimal")) {
            return PayloadMode.NONE;
        }
        return PayloadMode.MINIMAL;
    }

    public static boolean getSocks5Enabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_SOCKS5_ENABLED_KEY, false);
    }

    public static String getSocks5Password(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_SOCKS5_PASSWORD_KEY, "");
    }

    public static String getSocks5ProxyHost(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_SOCKS5_PROXY_IP_KEY, "0.0.0.0");
    }

    public static int getSocks5ProxyPort(SharedPreferences sharedPreferences) {
        return Integer.parseInt(sharedPreferences.getString(PREF_SOCKS5_PROXY_PORT_KEY, "8080"));
    }

    public static String getSocks5Username(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(PREF_SOCKS5_USERNAME_KEY, "");
    }

    @SuppressLint({"MutatingSharedPrefs"})
    public static Set<String> getStringSet(SharedPreferences sharedPreferences, String str) {
        Set<String> set = null;
        try {
            set = sharedPreferences.getStringSet(str, null);
        } catch (ClassCastException unused) {
            String string = sharedPreferences.getString(str, "");
            if (!string.isEmpty()) {
                set = new ArraySet(0);
                set.add(string);
            }
        }
        if (set == null) {
            return new ArraySet(0);
        }
        return set;
    }

    public static boolean getTlsDecryptionEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_TLS_DECRYPTION_KEY, false);
    }

    public static boolean isFirewallEnabled(Context context, SharedPreferences sharedPreferences) {
        if (!Billing.newInstance(context).isFirewallVisible() || !sharedPreferences.getBoolean(PREF_FIREWALL, true)) {
            return false;
        }
        return true;
    }

    public static boolean isFirewallWhitelistInitialized(SharedPreferences sharedPreferences) {
        if (sharedPreferences.getInt(PREF_FIREWALL_WHITELIST_INIT_VER, 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFirewallWhitelistMode(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_FIREWALL_WHITELIST_MODE, false);
    }

    public static boolean isIgnoredMitmVersion(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getString(PREF_IGNORED_MITM_VERSION, "").equals(str);
    }

    public static boolean isMalwareDetectionEnabled(Context context, SharedPreferences sharedPreferences) {
        if (!Billing.newInstance(context).isPurchased("malware_detection") || !sharedPreferences.getBoolean("malware_detection", true)) {
            return false;
        }
        return true;
    }

    public static boolean isPcapdroidMetadataEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_DUMP_EXTENSIONS, false);
    }

    public static boolean isPcapngEnabled(Context context, SharedPreferences sharedPreferences) {
        if (!Billing.newInstance(context).isPurchased(Billing.PCAPNG_SKU) || !sharedPreferences.getBoolean(PREF_PCAPNG_ENABLED, true)) {
            return false;
        }
        return true;
    }

    public static boolean isPortMappingEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_PORT_MAPPING_ENABLED, true);
    }

    public static boolean isPrivateDnsBlockingEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_AUTO_BLOCK_PRIVATE_DNS, true);
    }

    public static boolean isRootCaptureEnabled(SharedPreferences sharedPreferences) {
        if (!Utils.isRootAvailable() || !sharedPreferences.getBoolean(PREF_ROOT_CAPTURE, false)) {
            return false;
        }
        return true;
    }

    public static boolean isSocks5AuthEnabled(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_SOCKS5_AUTH_ENABLED_KEY, false);
    }

    public static boolean isTLSDecryptionSetupDone(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_TLS_DECRYPTION_SETUP_DONE, false);
    }

    public static boolean lockdownVpnNoticeShown(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_LOCKDOWN_VPN_NOTICE_SHOWN, false);
    }

    public static void refreshAppVersion(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putInt(PREF_APP_VERSION, 91).apply();
    }

    public static boolean restartOnDisconnect(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_RESTART_ON_DISCONNECT, false);
    }

    public static void setFirewallWhitelistInitialized(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putInt(PREF_FIREWALL_WHITELIST_INIT_VER, 1).apply();
    }

    public static void setLockdownVpnNoticeShown(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putBoolean(PREF_LOCKDOWN_VPN_NOTICE_SHOWN, true).apply();
    }

    public static void setPortMappingEnabled(SharedPreferences sharedPreferences, boolean z) {
        sharedPreferences.edit().putBoolean(PREF_PORT_MAPPING_ENABLED, z).apply();
    }

    public static boolean startAtBoot(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_START_AT_BOOT, false);
    }

    public static boolean useSystemDns(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(PREF_USE_SYSTEM_DNS, true);
    }

    public static BlockQuicMode getBlockQuicMode(SharedPreferences sharedPreferences) {
        return getBlockQuicMode(sharedPreferences.getString(PREF_BLOCK_QUIC, "never"));
    }

    public static IpMode getIPMode(SharedPreferences sharedPreferences) {
        return getIPMode(sharedPreferences.getString(PREF_IP_MODE, "ipv4"));
    }

    public static DumpMode getDumpMode(SharedPreferences sharedPreferences) {
        return getDumpMode(sharedPreferences.getString(PREF_PCAP_DUMP_MODE, "none"));
    }
}
