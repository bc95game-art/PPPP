package com.emanuelef.remote_capture.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.MitmReceiver;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.AppFilterActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.interfaces.AppStateListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.AppState;
import com.emanuelef.remote_capture.model.CaptureStats;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.PrefSpinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class StatusFragment extends Fragment implements AppStateListener, MenuProvider {
    private static final String TAG = "StatusFragment";
    private MainActivity mActivity;
    private Set<String> mAppFilter;
    private SwitchCompat mAppFilterSwitch;
    private TextView mCaptureStatus;
    private ImageView mCollectorInfoIcon;
    private View mCollectorInfoLayout;
    private TextView mCollectorInfoText;
    private MenuItem mDecryptPcap;
    private TextView mFilterDescription;
    private ImageView mFilterIcon;
    private TextView mFilterRootDecryptionWarning;
    private TextView mInterfaceInfo;
    private Menu mMenu;
    private MenuItem mMenuSettings;
    private MenuItem mOpenPcap;
    private SharedPreferences mPrefs;
    private View mQuickSettings;
    private MenuItem mStartBtn;
    private MenuItem mStopBtn;

    /* renamed from: com.emanuelef.remote_capture.fragments.StatusFragment$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C01571 {
        static final /* synthetic */ int[] $SwitchMap$com$emanuelef$remote_capture$model$AppState;
        static final /* synthetic */ int[] $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode;

        static {
            int[] iArr = new int[AppState.values().length];
            $SwitchMap$com$emanuelef$remote_capture$model$AppState = iArr;
            try {
                iArr[AppState.ready.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$AppState[AppState.starting.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$AppState[AppState.stopping.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$AppState[AppState.running.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Prefs.DumpMode.values().length];
            $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode = iArr2;
            try {
                iArr2[Prefs.DumpMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode[Prefs.DumpMode.HTTP_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode[Prefs.DumpMode.PCAP_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode[Prefs.DumpMode.UDP_EXPORTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode[Prefs.DumpMode.TCP_EXPORTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private Pair<String, Drawable> getAppFilterTextAndIcon(Context context) {
        Set<String> set = this.mAppFilter;
        Drawable drawable = null;
        String str = "";
        if (set != null && !set.isEmpty()) {
            if (this.mAppFilter.size() == 1) {
                AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(requireContext().getPackageManager(), this.mAppFilter.iterator().next(), 0);
                if (!(resolveInstalledApp == null || resolveInstalledApp.getIcon() == null)) {
                    drawable = resolveInstalledApp.getIcon();
                    str = resolveInstalledApp.getName() + " (" + resolveInstalledApp.getPackageName() + ")";
                }
            } else {
                drawable = ContextCompat$Api21Impl.getDrawable(context, C0130R.C0131drawable.ic_image);
                ArrayList arrayList = new ArrayList();
                for (String str2 : this.mAppFilter) {
                    AppDescriptor resolveInstalledApp2 = AppsResolver.resolveInstalledApp(requireContext().getPackageManager(), str2, 0);
                    if (resolveInstalledApp2 != null) {
                        str2 = resolveInstalledApp2.getName();
                    }
                    arrayList.add(str2);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb.append((CharSequence) it.next());
                        if (!it.hasNext()) {
                            break;
                        }
                        sb.append((CharSequence) ", ");
                    }
                }
                str = Utils.shorten(sb.toString(), 48);
            }
        }
        return new Pair<>(str, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        SwitchCompat switchCompat = this.mAppFilterSwitch;
        switchCompat.setChecked(!switchCompat.isChecked());
        openAppFilterSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        if (this.mActivity.getState() == AppState.ready) {
            this.mActivity.startCapture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(MitmReceiver.Status status) {
        refreshDecryptionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatsUpdate(CaptureStats captureStats) {
        Log.m587d("MainReceiver", "Got StatsUpdate: bytes_sent=" + captureStats.pkts_sent + ", bytes_rcvd=" + captureStats.bytes_rcvd + ", pkts_sent=" + captureStats.pkts_sent + ", pkts_rcvd=" + captureStats.pkts_rcvd);
        this.mCaptureStatus.setText(Utils.formatBytes(captureStats.bytes_sent + captureStats.bytes_rcvd));
    }

    private void openAppFilterSelector() {
        startActivity(new Intent(requireContext(), AppFilterActivity.class));
    }

    private void recheckFilterWarning() {
        boolean z;
        Set<String> set = this.mAppFilter;
        int i = 0;
        if (set == null || set.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        TextView textView = this.mFilterRootDecryptionWarning;
        if (!Prefs.getTlsDecryptionEnabled(this.mPrefs) || !Prefs.isRootCaptureEnabled(this.mPrefs) || z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    private void refreshDecryptionStatus() {
        int i;
        MitmReceiver.Status mitmProxyStatus = CaptureService.getMitmProxyStatus();
        Context context = getContext();
        if (mitmProxyStatus == MitmReceiver.Status.START_ERROR && context != null) {
            Utils.showToastLong(context, C0130R.string.mitm_addon_error, new Object[0]);
        }
        TextView textView = this.mInterfaceInfo;
        if (mitmProxyStatus == MitmReceiver.Status.RUNNING) {
            i = C0130R.string.mitm_addon_running;
        } else {
            i = C0130R.string.mitm_addon_starting;
        }
        textView.setText(i);
    }

    private void refreshFilterInfo() {
        Context context = getContext();
        if (context != null) {
            Set<String> set = this.mAppFilter;
            if (set == null || set.isEmpty()) {
                this.mFilterDescription.setText(C0130R.string.capture_all_apps);
                this.mFilterIcon.setVisibility(8);
                this.mAppFilterSwitch.setChecked(false);
                return;
            }
            this.mAppFilterSwitch.setChecked(true);
            Pair<String, Drawable> appFilterTextAndIcon = getAppFilterTextAndIcon(context);
            this.mFilterDescription.setText((CharSequence) appFilterTextAndIcon.first);
            Object obj = appFilterTextAndIcon.second;
            if (obj != null) {
                this.mFilterIcon.setImageDrawable((Drawable) obj);
                this.mFilterIcon.setVisibility(0);
            }
        }
    }

    private void refreshPcapDumpInfo(Context context) {
        String str;
        Drawable drawable;
        int i = C01571.$SwitchMap$com$emanuelef$remote_capture$model$Prefs$DumpMode[CaptureService.getDumpMode().ordinal()];
        if (i == 1) {
            str = getString(C0130R.string.no_dump_info);
        } else if (i == 2) {
            str = String.format(getResources().getString(C0130R.string.http_server_status), Utils.getLocalIPAddress(this.mActivity), Integer.valueOf(CaptureService.getHTTPServerPort()));
        } else if (i == 3) {
            str = getString(C0130R.string.pcap_file_info);
            String pcapFname = CaptureService.getPcapFname();
            if (pcapFname != null) {
                str = pcapFname;
            }
        } else if (i == 4) {
            str = String.format(getResources().getString(C0130R.string.collector_info), CaptureService.getCollectorAddress(), Integer.valueOf(CaptureService.getCollectorPort()));
        } else if (i != 5) {
            str = "";
        } else {
            str = String.format(getResources().getString(C0130R.string.tcp_collector_info), CaptureService.getCollectorAddress(), Integer.valueOf(CaptureService.getCollectorPort()));
        }
        this.mCollectorInfoText.setText(str);
        Set<String> set = this.mAppFilter;
        if (set == null || set.isEmpty()) {
            drawable = null;
        } else {
            drawable = (Drawable) getAppFilterTextAndIcon(context).second;
        }
        if (drawable != null) {
            this.mCollectorInfoIcon.setImageDrawable(drawable);
            this.mCollectorInfoIcon.setVisibility(0);
            return;
        }
        this.mCollectorInfoIcon.setVisibility(8);
    }

    private void refreshStatus() {
        MainActivity mainActivity = this.mActivity;
        if (mainActivity != null) {
            appStateChanged(mainActivity.getState());
        }
        recheckFilterWarning();
    }

    @Override // com.emanuelef.remote_capture.interfaces.AppStateListener
    public void appStateChanged(AppState appState) {
        Context context = getContext();
        if (context != null) {
            if (this.mMenu != null) {
                if (appState == AppState.running || appState == AppState.stopping) {
                    this.mStartBtn.setVisible(false);
                    this.mStopBtn.setEnabled(true);
                    this.mStopBtn.setVisible(!CaptureService.isAlwaysOnVPN());
                    this.mMenuSettings.setEnabled(false);
                    this.mOpenPcap.setEnabled(false);
                    this.mDecryptPcap.setEnabled(false);
                } else {
                    this.mStopBtn.setVisible(false);
                    this.mStartBtn.setEnabled(true);
                    this.mStartBtn.setVisible(!CaptureService.isAlwaysOnVPN());
                    this.mMenuSettings.setEnabled(true);
                    this.mOpenPcap.setEnabled(true);
                    this.mDecryptPcap.setEnabled(true);
                }
            }
            int i = C01571.$SwitchMap$com$emanuelef$remote_capture$model$AppState[appState.ordinal()];
            if (i == 1) {
                this.mCaptureStatus.setText(C0130R.string.ready);
                this.mCollectorInfoLayout.setVisibility(8);
                this.mInterfaceInfo.setVisibility(8);
                this.mQuickSettings.setVisibility(0);
                this.mAppFilter = Prefs.getAppFilter(this.mPrefs);
                refreshFilterInfo();
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.mCaptureStatus.setText(Utils.formatBytes(CaptureService.getBytes()));
                        this.mCollectorInfoLayout.setVisibility(0);
                        this.mQuickSettings.setVisibility(8);
                        CaptureService requireInstance = CaptureService.requireInstance();
                        if (CaptureService.isDecryptingTLS()) {
                            refreshDecryptionStatus();
                            this.mInterfaceInfo.setVisibility(0);
                        } else if (CaptureService.isCapturingAsRoot()) {
                            String captureInterface = requireInstance.getCaptureInterface();
                            if (captureInterface.equals("@inet")) {
                                captureInterface = getString(C0130R.string.internet);
                            } else if (captureInterface.equals("any")) {
                                captureInterface = getString(C0130R.string.all_interfaces);
                            }
                            this.mInterfaceInfo.setText(String.format(getResources().getString(C0130R.string.capturing_from), captureInterface));
                            this.mInterfaceInfo.setVisibility(0);
                        } else if (requireInstance.getSocks5Enabled() == 1) {
                            this.mInterfaceInfo.setText(String.format(getResources().getString(C0130R.string.socks5_info), requireInstance.getSocks5ProxyAddress(), Integer.valueOf(requireInstance.getSocks5ProxyPort())));
                            this.mInterfaceInfo.setVisibility(0);
                        } else {
                            this.mInterfaceInfo.setVisibility(8);
                        }
                        this.mAppFilter = CaptureService.getAppFilter();
                        refreshPcapDumpInfo(context);
                    }
                } else if (this.mMenu != null) {
                    this.mStopBtn.setEnabled(false);
                }
            } else if (this.mMenu != null) {
                this.mStartBtn.setEnabled(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (MainActivity) context;
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.main_menu, menu);
        this.mMenu = menu;
        this.mStartBtn = menu.findItem(C0130R.C0132id.action_start);
        this.mStopBtn = this.mMenu.findItem(C0130R.C0132id.action_stop);
        this.mMenuSettings = this.mMenu.findItem(C0130R.C0132id.action_settings);
        this.mOpenPcap = this.mMenu.findItem(C0130R.C0132id.open_pcap);
        MenuItem findItem = this.mMenu.findItem(C0130R.C0132id.decrypt_pcap);
        this.mDecryptPcap = findItem;
        findItem.setVisible(PCAPdroid.getInstance().isUsharkAvailable());
        refreshStatus();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(C0130R.layout.status, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity.setAppStateListener(null);
        this.mActivity = null;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CaptureService.checkAlwaysOnVpnActivated();
        refreshStatus();
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void onViewCreated(View view, Bundle bundle) {
        this.mInterfaceInfo = (TextView) view.findViewById(C0130R.C0132id.interface_info);
        View findViewById = view.findViewById(C0130R.C0132id.collector_info_layout);
        this.mCollectorInfoLayout = findViewById;
        this.mCollectorInfoText = (TextView) findViewById.findViewById(C0130R.C0132id.collector_info_text);
        this.mCollectorInfoIcon = (ImageView) this.mCollectorInfoLayout.findViewById(C0130R.C0132id.collector_info_icon);
        this.mCaptureStatus = (TextView) view.findViewById(C0130R.C0132id.status_view);
        this.mQuickSettings = view.findViewById(C0130R.C0132id.quick_settings);
        this.mFilterRootDecryptionWarning = (TextView) view.findViewById(C0130R.C0132id.app_filter_root_decryption_warning);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
        this.mPrefs = defaultSharedPreferences;
        this.mAppFilter = Prefs.getAppFilter(defaultSharedPreferences);
        PrefSpinner.init((Spinner) view.findViewById(C0130R.C0132id.dump_mode_spinner), C0130R.array.pcap_dump_modes, C0130R.array.pcap_dump_modes_labels, C0130R.array.pcap_dump_modes_descriptions, Prefs.PREF_PCAP_DUMP_MODE, "none");
        this.mAppFilterSwitch = (SwitchCompat) view.findViewById(C0130R.C0132id.app_filter_switch);
        View findViewById2 = view.findViewById(C0130R.C0132id.app_filter_text);
        this.mFilterDescription = (TextView) findViewById2.findViewById(C0130R.C0132id.description);
        this.mFilterIcon = (ImageView) findViewById2.findViewById(C0130R.C0132id.icon);
        ((TextView) findViewById2.findViewById(C0130R.C0132id.title)).setText(C0130R.string.target_apps);
        this.mAppFilterSwitch.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.StatusFragment$$ExternalSyntheticLambda0
            public final /* synthetic */ StatusFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$0(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$1(view2);
                        return;
                }
            }
        });
        refreshFilterInfo();
        this.mCaptureStatus.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.StatusFragment$$ExternalSyntheticLambda0
            public final /* synthetic */ StatusFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$0(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$1(view2);
                        return;
                }
            }
        });
        MitmReceiver.observeStatus(this, new Observer(this) { // from class: com.emanuelef.remote_capture.fragments.StatusFragment$$ExternalSyntheticLambda2
            public final /* synthetic */ StatusFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$2((MitmReceiver.Status) obj);
                        return;
                    default:
                        this.f$0.onStatsUpdate((CaptureStats) obj);
                        return;
                }
            }
        });
        CaptureService.observeStats(this, new Observer(this) { // from class: com.emanuelef.remote_capture.fragments.StatusFragment$$ExternalSyntheticLambda2
            public final /* synthetic */ StatusFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$2((MitmReceiver.Status) obj);
                        return;
                    default:
                        this.f$0.onStatsUpdate((CaptureStats) obj);
                        return;
                }
            }
        });
        this.mCollectorInfoText.setMovementMethod(LinkMovementMethod.getInstance());
        this.mActivity.setAppStateListener(this);
        refreshStatus();
    }
}
