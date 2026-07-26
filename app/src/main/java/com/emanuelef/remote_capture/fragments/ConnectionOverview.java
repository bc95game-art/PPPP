package com.emanuelef.remote_capture.fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.p002os.BundleKt;
import androidx.fragment.app.Fragment;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.activities.MenuActionHandler;
import com.emanuelef.remote_capture.interfaces.PayloadHostActivity;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.haipq.android.flagkit.FlagImageView;
/* loaded from: classes.dex */
public class ConnectionOverview extends Fragment implements PayloadHostActivity.ConnUpdateListener, MenuActionHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ConnectionOverview";
    private ConnectionDetailsActivity mActivity;
    private ImageView mBlacklistedHost;
    private ImageView mBlacklistedIp;
    private TextView mBlockedPkts;
    private View mBlockedPktsRow;
    private TextView mBytesView;
    private ConnectionDescriptor mConn;
    private ImageView mDecIcon;
    private TextView mDecStatus;
    private TextView mDurationView;
    private TextView mError;
    private TextView mFirstSeen;
    private TextView mLastSeen;
    private TextView mPacketsView;
    private TextView mPayloadLen;
    private TextView mSocketErrno;
    private View mSocketErrnoInfo;
    private View mSocketErrnoRow;
    private TextView mStatus;
    private TableLayout mTable;

    private String getContents() {
        TableLayout tableLayout = this.mTable;
        if (tableLayout == null) {
            return "";
        }
        return Utils.table2Text(tableLayout);
    }

    private Pair<Integer, Integer> getSocketErrnoInfo(int i) {
        if (i == 32) {
            return new Pair<>(Integer.valueOf((int) C0130R.string.errno_epipe), Integer.valueOf((int) C0130R.string.errno_epipe_msg));
        }
        if (i == 113) {
            return new Pair<>(Integer.valueOf((int) C0130R.string.errno_ehostunreach), Integer.valueOf((int) C0130R.string.errno_ehostunreach_msg));
        }
        if (i == 110) {
            return new Pair<>(Integer.valueOf((int) C0130R.string.errno_etimedout), Integer.valueOf((int) C0130R.string.errno_etimedout_msg));
        }
        if (i == 111) {
            return new Pair<>(Integer.valueOf((int) C0130R.string.errno_econnrefused), Integer.valueOf((int) C0130R.string.errno_econnrefused_msg));
        }
        switch (i) {
            case 100:
                return new Pair<>(Integer.valueOf((int) C0130R.string.errno_enetdown), Integer.valueOf((int) C0130R.string.errno_enetdown_msg));
            case 101:
                return new Pair<>(Integer.valueOf((int) C0130R.string.errno_enetunreach), Integer.valueOf((int) C0130R.string.errno_enetunreach_msg));
            case 102:
                return new Pair<>(Integer.valueOf((int) C0130R.string.errno_enetreset), Integer.valueOf((int) C0130R.string.errno_enetreset_msg));
            case 103:
                return new Pair<>(Integer.valueOf((int) C0130R.string.errno_econnaborted), Integer.valueOf((int) C0130R.string.errno_econnaborted_msg));
            case 104:
                return new Pair<>(Integer.valueOf((int) C0130R.string.errno_econnreset), Integer.valueOf((int) C0130R.string.errno_econnreset_msg));
            default:
                return null;
        }
    }

    public /* synthetic */ void lambda$connectionUpdated$2(int i, View view) {
        Context context = getContext();
        if (context != null) {
            Utils.showHelpDialog(context, i);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        Utils.startActivity(this.mActivity, new Intent("android.intent.action.VIEW", Uri.parse("https://search.arin.net/rdap/?query=" + this.mConn.dst_ip)));
    }

    public /* synthetic */ void lambda$onViewCreated$1(CharSequence charSequence, View view) {
        Context context = getContext();
        if (context != null) {
            Utils.showHelpDialog(context, charSequence);
        }
    }

    public static ConnectionOverview newInstance(int i) {
        ConnectionOverview connectionOverview = new ConnectionOverview();
        Bundle bundle = new Bundle();
        bundle.putInt(ConnectionDetailsActivity.CONN_ID_KEY, i);
        connectionOverview.setArguments(bundle);
        return connectionOverview;
    }

    @Override // com.emanuelef.remote_capture.interfaces.PayloadHostActivity.ConnUpdateListener
    public void connectionUpdated() {
        int i;
        int i2;
        int i3;
        Context context = this.mBytesView.getContext();
        this.mPayloadLen.setText(Utils.formatBytes(this.mConn.payload_length));
        this.mBytesView.setText(String.format(getResources().getString(C0130R.string.rcvd_and_sent), Utils.formatBytes(this.mConn.rcvd_bytes), Utils.formatBytes(this.mConn.sent_bytes)));
        this.mPacketsView.setText(String.format(getResources().getString(C0130R.string.rcvd_and_sent), Utils.formatIntShort(this.mConn.rcvd_pkts), Utils.formatIntShort(this.mConn.sent_pkts)));
        if (this.mConn.blocked_pkts > 0) {
            this.mBlockedPkts.setText(String.format(getResources().getString(C0130R.string.n_pkts), Utils.formatIntShort(this.mConn.blocked_pkts)));
            this.mBlockedPktsRow.setVisibility(0);
        }
        TextView textView = this.mDurationView;
        ConnectionDescriptor connectionDescriptor = this.mConn;
        textView.setText(Utils.formatDuration((connectionDescriptor.last_seen - connectionDescriptor.first_seen) / 1000));
        this.mFirstSeen.setText(Utils.formatEpochMillis(this.mActivity, this.mConn.first_seen));
        this.mLastSeen.setText(Utils.formatEpochMillis(this.mActivity, this.mConn.last_seen));
        this.mStatus.setText(this.mConn.getStatusLabel(this.mActivity));
        this.mDecStatus.setText(this.mConn.getDecryptionStatusLabel(this.mActivity));
        Utils.setDecryptionIcon(this.mDecIcon, this.mConn);
        ImageView imageView = this.mBlacklistedIp;
        if (this.mConn.isBlacklistedIp()) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        ImageView imageView2 = this.mBlacklistedHost;
        if (this.mConn.isBlacklistedHost()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
        if (this.mConn.error > 0) {
            this.mSocketErrnoRow.setVisibility(0);
            Pair<Integer, Integer> socketErrnoInfo = getSocketErrnoInfo(this.mConn.error);
            TextView textView2 = this.mSocketErrno;
            if (socketErrnoInfo != null) {
                i3 = ((Integer) socketErrnoInfo.first).intValue();
            } else {
                i3 = C0130R.string.unknown_app;
            }
            textView2.setText(context.getString(C0130R.string.error_code_with_text, context.getString(i3), Integer.valueOf(this.mConn.error)));
            if (socketErrnoInfo != null) {
                this.mSocketErrnoInfo.setOnClickListener(new ConnectionOverview$$ExternalSyntheticLambda0(((Integer) socketErrnoInfo.second).intValue(), 0, this));
            } else {
                this.mSocketErrnoInfo.setVisibility(8);
            }
        }
        ConnectionDescriptor connectionDescriptor2 = this.mConn;
        if (connectionDescriptor2.decryption_error != null) {
            this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.danger));
            this.mError.setText(this.mConn.decryption_error);
            this.mError.setVisibility(0);
        } else if (connectionDescriptor2.is_blocked) {
            this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.warning));
            this.mError.setText(context.getString(C0130R.string.connection_blocked));
            this.mError.setVisibility(0);
        } else if (!connectionDescriptor2.hasSeenStart()) {
            this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.warning));
            this.mError.setText(context.getString(C0130R.string.connection_start_not_seen));
            this.mError.setVisibility(0);
        } else if (this.mConn.isPortMappingApplied()) {
            this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.colorTabText));
            this.mError.setText(context.getString(C0130R.string.connection_redirected_port_map));
            this.mError.setVisibility(0);
        } else {
            ConnectionDescriptor connectionDescriptor3 = this.mConn;
            if (connectionDescriptor3.payload_length == 0) {
                this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.warning));
                this.mError.setText(context.getString(C0130R.string.warn_no_app_data));
                this.mError.setVisibility(0);
            } else if (connectionDescriptor3.netd_block_missed) {
                this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.warning));
                this.mError.setText(context.getString(C0130R.string.netd_block_missed));
                this.mError.setVisibility(0);
            } else if (connectionDescriptor3.getDecryptionStatus() == ConnectionDescriptor.DecryptionStatus.ENCRYPTED) {
                this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.colorTabText));
                this.mError.setText(C0130R.string.decryption_info_no_rule);
                this.mError.setVisibility(0);
            } else if (this.mConn.getDecryptionStatus() != ConnectionDescriptor.DecryptionStatus.NOT_DECRYPTABLE || !this.mConn.l7proto.equals("QUIC") || !CaptureService.isDecryptingTLS()) {
                this.mError.setVisibility(8);
            } else {
                this.mError.setTextColor(BundleKt.getColor(context, C0130R.color.warning));
                this.mError.setText(C0130R.string.decrypt_quic_notice);
                this.mError.setVisibility(0);
            }
        }
    }

    @Override // com.emanuelef.remote_capture.activities.MenuActionHandler
    public boolean handleMenuAction(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.copy_to_clipboard) {
            ((ClipboardManager) this.mActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getString(C0130R.string.connection_details), getContents()));
            Utils.showToast(this.mActivity, C0130R.string.copied, new Object[0]);
            return true;
        } else if (itemId != C0130R.C0132id.share) {
            return false;
        } else {
            Utils.shareText(this.mActivity, getString(C0130R.string.connection_details), getContents());
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        ConnectionDetailsActivity connectionDetailsActivity = (ConnectionDetailsActivity) context;
        this.mActivity = connectionDetailsActivity;
        connectionDetailsActivity.addConnUpdateListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0130R.layout.connection_overview, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity.removeConnUpdateListener(this);
        this.mActivity = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        FlagImageView flagImageView;
        Object obj;
        TextView textView;
        int i;
        int i2;
        TextView textView2 = (TextView) view.findViewById(C0130R.C0132id.detail_app);
        TextView textView3 = (TextView) view.findViewById(C0130R.C0132id.detail_protocol);
        TextView textView4 = (TextView) view.findViewById(C0130R.C0132id.detail_info_label);
        TextView textView5 = (TextView) view.findViewById(C0130R.C0132id.detail_info);
        TextView textView6 = (TextView) view.findViewById(C0130R.C0132id.detail_url);
        View findViewById = view.findViewById(C0130R.C0132id.detail_url_row);
        View findViewById2 = view.findViewById(C0130R.C0132id.detail_info_row);
        TextView textView7 = (TextView) view.findViewById(C0130R.C0132id.detail_source);
        TextView textView8 = (TextView) view.findViewById(C0130R.C0132id.detail_destination);
        TextView textView9 = (TextView) view.findViewById(C0130R.C0132id.country_name);
        FlagImageView flagImageView2 = (FlagImageView) view.findViewById(C0130R.C0132id.country_flag);
        TextView textView10 = (TextView) view.findViewById(C0130R.C0132id.asn);
        this.mTable = (TableLayout) view.findViewById(C0130R.C0132id.table);
        this.mPayloadLen = (TextView) view.findViewById(C0130R.C0132id.detail_payload);
        this.mBytesView = (TextView) view.findViewById(C0130R.C0132id.detail_bytes);
        this.mPacketsView = (TextView) view.findViewById(C0130R.C0132id.detail_packets);
        this.mBlockedPkts = (TextView) view.findViewById(C0130R.C0132id.blocked_pkts);
        this.mBlockedPktsRow = view.findViewById(C0130R.C0132id.blocked_row);
        this.mDurationView = (TextView) view.findViewById(C0130R.C0132id.detail_duration);
        this.mStatus = (TextView) view.findViewById(C0130R.C0132id.detail_status);
        this.mDecStatus = (TextView) view.findViewById(C0130R.C0132id.detail_decryption_status);
        this.mDecIcon = (ImageView) view.findViewById(C0130R.C0132id.decryption_icon);
        this.mFirstSeen = (TextView) view.findViewById(C0130R.C0132id.first_seen);
        this.mLastSeen = (TextView) view.findViewById(C0130R.C0132id.last_seen);
        this.mError = (TextView) view.findViewById(C0130R.C0132id.error_msg);
        this.mSocketErrno = (TextView) view.findViewById(C0130R.C0132id.detail_errno);
        this.mSocketErrnoRow = view.findViewById(C0130R.C0132id.error_row);
        this.mSocketErrnoInfo = view.findViewById(C0130R.C0132id.error_info);
        this.mBlacklistedIp = (ImageView) view.findViewById(C0130R.C0132id.blacklisted_ip);
        this.mBlacklistedHost = (ImageView) view.findViewById(C0130R.C0132id.blacklisted_host);
        ConnectionDescriptor connById = CaptureService.requireConnsRegister().getConnById(getArguments().getInt(ConnectionDetailsActivity.CONN_ID_KEY));
        this.mConn = connById;
        if (connById == null) {
            Utils.showToast(requireContext(), C0130R.string.connection_not_found, new Object[0]);
            this.mActivity.finish();
            return;
        }
        view.findViewById(C0130R.C0132id.whois_ip).setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(3, this));
        ConnectionDescriptor connectionDescriptor = this.mConn;
        if (connectionDescriptor != null) {
            String proto2str = Utils.proto2str(connectionDescriptor.ipproto);
            boolean z = true;
            if (!this.mConn.l7proto.equals(proto2str)) {
                flagImageView = flagImageView2;
                textView3.setText(String.format(getResources().getString(C0130R.string.app_and_proto), this.mConn.l7proto, proto2str));
            } else {
                flagImageView = flagImageView2;
                textView3.setText(this.mConn.l7proto);
            }
            if (this.mConn.l7proto.equals("DNS")) {
                obj = getString(C0130R.string.dns_conn_info);
            } else if (this.mConn.l7proto.equals("TLS") || this.mConn.l7proto.equals("HTTPS")) {
                obj = Utils.getText(view.getContext(), C0130R.string.tls_conn_info, MainActivity.TLS_DECRYPTION_DOCS_URL);
            } else {
                obj = null;
            }
            if (obj != null) {
                View findViewById3 = view.findViewById(C0130R.C0132id.protocol_info);
                findViewById3.setVisibility(0);
                textView = textView9;
                findViewById3.setOnClickListener(new AppOverview$$ExternalSyntheticLambda0(this, 2, obj));
            } else {
                textView = textView9;
            }
            if (proto2str.equals("ICMP")) {
                textView7.setText(this.mConn.src_ip);
                textView8.setText(this.mConn.dst_ip);
            } else if (this.mConn.ipver == 6) {
                String string = getResources().getString(C0130R.string.ipv6_and_port);
                ConnectionDescriptor connectionDescriptor2 = this.mConn;
                textView7.setText(String.format(string, connectionDescriptor2.src_ip, Integer.valueOf(connectionDescriptor2.src_port)));
                String string2 = getResources().getString(C0130R.string.ipv6_and_port);
                ConnectionDescriptor connectionDescriptor3 = this.mConn;
                textView8.setText(String.format(string2, connectionDescriptor3.dst_ip, Integer.valueOf(connectionDescriptor3.dst_port)));
            } else {
                String string3 = getResources().getString(C0130R.string.ip_and_port);
                ConnectionDescriptor connectionDescriptor4 = this.mConn;
                textView7.setText(String.format(string3, connectionDescriptor4.src_ip, Integer.valueOf(connectionDescriptor4.src_port)));
                String string4 = getResources().getString(C0130R.string.ip_and_port);
                ConnectionDescriptor connectionDescriptor5 = this.mConn;
                textView8.setText(String.format(string4, connectionDescriptor5.dst_ip, Integer.valueOf(connectionDescriptor5.dst_port)));
            }
            String str = this.mConn.info;
            if (str == null || str.isEmpty()) {
                findViewById2.setVisibility(8);
            } else {
                if (this.mConn.l7proto.equals("DNS")) {
                    textView4.setText(C0130R.string.query);
                } else if (this.mConn.l7proto.equals("HTTP")) {
                    textView4.setText(C0130R.string.host);
                }
                textView5.setText(this.mConn.info);
            }
            String num = Integer.toString(this.mConn.uid);
            AppDescriptor appByUid = new AppsResolver(this.mActivity).getAppByUid(this.mConn.uid, 0);
            if (appByUid != null) {
                textView2.setText(String.format(getResources().getString(C0130R.string.app_and_proto), appByUid.getName(), num));
            } else {
                textView2.setText(num);
            }
            View findViewById4 = view.findViewById(C0130R.C0132id.decryption_status_row);
            if (CaptureService.isDecryptingTLS()) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById4.setVisibility(i);
            String str2 = this.mConn.js_injected_scripts;
            if (str2 == null || str2.isEmpty()) {
                z = false;
            }
            View findViewById5 = view.findViewById(C0130R.C0132id.injected_scripts_row);
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            findViewById5.setVisibility(i2);
            if (z) {
                ((TextView) view.findViewById(C0130R.C0132id.injected_scripts)).setText(this.mConn.js_injected_scripts);
            }
            if (!this.mConn.url.isEmpty()) {
                textView6.setText(this.mConn.url);
            } else {
                findViewById.setVisibility(8);
            }
            if (!this.mConn.country.isEmpty()) {
                textView.setText(Utils.getCountryName(this.mActivity, this.mConn.country));
                flagImageView.setCountryCode(this.mConn.country);
            } else {
                view.findViewById(C0130R.C0132id.country_row).setVisibility(8);
            }
            if (this.mConn.asn.isKnown()) {
                textView10.setText(this.mConn.asn.toString());
            } else {
                view.findViewById(C0130R.C0132id.asn_row).setVisibility(8);
            }
            int i3 = this.mConn.ifidx;
            if (i3 > 0) {
                String interfaceName = CaptureService.getInterfaceName(i3);
                if (!interfaceName.isEmpty()) {
                    view.findViewById(C0130R.C0132id.interface_row).setVisibility(0);
                    ((TextView) view.findViewById(C0130R.C0132id.capture_interface)).setText(interfaceName);
                }
            }
            connectionUpdated();
        }
    }
}
