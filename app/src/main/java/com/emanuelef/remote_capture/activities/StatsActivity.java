package com.emanuelef.remote_capture.activities;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.view.MenuProvider;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda3;
import com.emanuelef.remote_capture.model.CaptureStats;
import java.util.Locale;
/* loaded from: classes.dex */
public class StatsActivity extends BaseActivity implements MenuProvider {
    private TextView mActiveConns;
    private TextView mAllocStats;
    private TextView mBytesRcvd;
    private TextView mBytesSent;
    private TextView mDnsQueries;
    private TextView mDnsServer;
    private TextView mDroppedConns;
    private TextView mDroppedPkts;
    private TextView mHeapUsage;
    private TextView mIPv6BytesPercentage;
    private TextView mIPv6BytesRcvd;
    private TextView mIPv6BytesSent;
    private TextView mLowMem;
    private TextView mMemUsage;
    private TextView mOpenSocks;
    private TextView mPacketsRcvd;
    private TextView mPacketsSent;
    private TableLayout mTable;
    private TextView mTotConns;

    private String getContents() {
        return Utils.table2Text(this.mTable);
    }

    private void updateMemoryStats() {
        int i;
        Locale primaryLocale = Utils.getPrimaryLocale(this);
        long availableHeap = Utils.getAvailableHeap();
        long maxMemory = Runtime.getRuntime().maxMemory();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) getSystemService("activity")).getMemoryInfo(memoryInfo);
        long j = maxMemory - availableHeap;
        this.mHeapUsage.setText(String.format(primaryLocale, "%s / %s (%d%%)", Utils.formatBytes(j), Utils.formatBytes(maxMemory), Long.valueOf((j * 100) / maxMemory)));
        TextView textView = this.mMemUsage;
        String formatBytes = Utils.formatBytes(memoryInfo.totalMem - memoryInfo.availMem);
        String formatBytes2 = Utils.formatBytes(memoryInfo.totalMem);
        long j2 = memoryInfo.totalMem;
        textView.setText(String.format(primaryLocale, "%s / %s (%d%%)", formatBytes, formatBytes2, Long.valueOf(((j2 - memoryInfo.availMem) * 100) / j2)));
        TextView textView2 = this.mLowMem;
        if (CaptureService.isLowMemory()) {
            i = R.string.yes;
        } else {
            i = R.string.no;
        }
        textView2.setText(getString(i));
    }

    public void updateStats(CaptureStats captureStats) {
        this.mBytesSent.setText(Utils.formatBytes(captureStats.bytes_sent));
        this.mBytesRcvd.setText(Utils.formatBytes(captureStats.bytes_rcvd));
        this.mIPv6BytesSent.setText(Utils.formatBytes(captureStats.ipv6_bytes_sent));
        this.mIPv6BytesRcvd.setText(Utils.formatBytes(captureStats.ipv6_bytes_rcvd));
        long j = captureStats.bytes_sent + captureStats.bytes_rcvd;
        long j2 = 0;
        if (j > 0) {
            j2 = ((captureStats.ipv6_bytes_sent + captureStats.ipv6_bytes_rcvd) * 100) / j;
        }
        this.mIPv6BytesPercentage.setText(String.format(Utils.getPrimaryLocale(this), "%d%%", Long.valueOf(j2)));
        this.mPacketsSent.setText(Utils.formatIntShort(captureStats.pkts_sent));
        this.mPacketsRcvd.setText(Utils.formatIntShort(captureStats.pkts_rcvd));
        this.mActiveConns.setText(Utils.formatNumber(this, captureStats.active_conns));
        this.mDroppedConns.setText(Utils.formatNumber(this, captureStats.num_dropped_conns));
        this.mDroppedPkts.setText(Utils.formatNumber(this, captureStats.pkts_dropped));
        this.mTotConns.setText(Utils.formatNumber(this, captureStats.tot_conns));
        this.mOpenSocks.setText(Utils.formatNumber(this, captureStats.num_open_sockets));
        this.mDnsQueries.setText(Utils.formatNumber(this, captureStats.num_dns_queries));
        updateMemoryStats();
        if (!CaptureService.isDNSEncrypted()) {
            findViewById(R.id.dns_server_row).setVisibility(0);
            findViewById(R.id.dns_queries_row).setVisibility(0);
            this.mDnsServer.setText(CaptureService.getDNSServer());
        } else {
            findViewById(R.id.dns_server_row).setVisibility(8);
            findViewById(R.id.dns_queries_row).setVisibility(8);
        }
        if (captureStats.num_dropped_conns > 0) {
            this.mDroppedConns.setTextColor(-65536);
        }
        if (captureStats.alloc_summary != null) {
            this.mAllocStats.setVisibility(0);
            this.mAllocStats.setText(captureStats.alloc_summary);
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.stats);
        displayBackAction();
        setContentView(R.layout.activity_stats);
        addMenuProvider(this);
        this.mTable = (TableLayout) findViewById(R.id.table);
        this.mBytesSent = (TextView) findViewById(R.id.bytes_sent);
        this.mBytesRcvd = (TextView) findViewById(R.id.bytes_rcvd);
        this.mIPv6BytesSent = (TextView) findViewById(R.id.ipv6_bytes_sent);
        this.mIPv6BytesRcvd = (TextView) findViewById(R.id.ipv6_bytes_rcvd);
        this.mIPv6BytesPercentage = (TextView) findViewById(R.id.ipv6_bytes_percentage);
        this.mPacketsSent = (TextView) findViewById(R.id.packets_sent);
        this.mPacketsRcvd = (TextView) findViewById(R.id.packets_rcvd);
        this.mActiveConns = (TextView) findViewById(R.id.active_connections);
        this.mDroppedConns = (TextView) findViewById(R.id.dropped_connections);
        this.mDroppedPkts = (TextView) findViewById(R.id.pkts_dropped);
        this.mTotConns = (TextView) findViewById(R.id.tot_connections);
        this.mHeapUsage = (TextView) findViewById(R.id.heap_usage);
        this.mMemUsage = (TextView) findViewById(R.id.mem_usage);
        this.mLowMem = (TextView) findViewById(R.id.low_mem_detected);
        this.mOpenSocks = (TextView) findViewById(R.id.open_sockets);
        this.mDnsQueries = (TextView) findViewById(R.id.dns_queries);
        this.mDnsServer = (TextView) findViewById(R.id.dns_server);
        this.mAllocStats = (TextView) findViewById(R.id.alloc_stats);
        if (CaptureService.isCapturingAsRoot()) {
            findViewById(R.id.open_sockets_row).setVisibility(8);
            findViewById(R.id.row_dropped_connections).setVisibility(8);
        } else {
            if (!CaptureService.isReadingFromPcapFile() && !CaptureService.isIPv6Enabled()) {
                findViewById(R.id.ipv6_bytes_sent_row).setVisibility(8);
                findViewById(R.id.ipv6_bytes_rcvd_row).setVisibility(8);
                findViewById(R.id.ipv6_bytes_percentage_row).setVisibility(8);
            }
            findViewById(R.id.row_pkts_dropped).setVisibility(8);
        }
        CaptureService.observeStats(this, new AppsFragment$$ExternalSyntheticLambda3(2, this));
        CaptureService.askStatsDump();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.copy_share_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.copy_to_clipboard) {
            Utils.copyToClipboard(this, getContents());
            return true;
        } else if (itemId != R.id.share) {
            return false;
        } else {
            Utils.shareText(this, getString(R.string.stats), getContents());
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }
}
