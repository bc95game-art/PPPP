package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.activities.HttpDetailsActivity;
import com.emanuelef.remote_capture.adapters.PayloadAdapter;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class HttpPayloadFragment extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ConnectionPayload";
    private HttpDetailsActivity mActivity;
    private PayloadAdapter mAdapter;
    private HttpLog.HttpRequest mHttpReq;
    private EmptyRecyclerView mRecyclerView;

    public static WindowInsetsCompat lambda$onViewCreated$0(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, 0, 0, windowInsetsCompat.mImpl.getInsets(135).bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        Intent intent = new Intent(requireContext(), ConnectionDetailsActivity.class);
        intent.putExtra(ConnectionDetailsActivity.CONN_ID_KEY, this.mHttpReq.conn.incr_id);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$setMenuVisibility$2(DialogInterface dialogInterface) {
        requireActivity().finish();
    }

    public /* synthetic */ void lambda$setMenuVisibility$3(DialogInterface dialogInterface, int i) {
        requireActivity().finish();
    }

    public /* synthetic */ void lambda$setMenuVisibility$4(SharedPreferences sharedPreferences, DialogInterface dialogInterface, int i) {
        this.mRecyclerView.setAdapter(this.mAdapter);
        sharedPreferences.edit().putBoolean(Prefs.PREF_PAYLOAD_NOTICE_ACK, true).apply();
    }

    public static HttpPayloadFragment newInstance(int i, boolean z) {
        HttpPayloadFragment httpPayloadFragment = new HttpPayloadFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("show_reply", Boolean.valueOf(z));
        bundle.putInt(HttpDetailsActivity.HTTP_REQ_POS_KEY, i);
        httpPayloadFragment.setArguments(bundle);
        return httpPayloadFragment;
    }

    private boolean payloadNoticeAcknowledged(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(Prefs.PREF_PAYLOAD_NOTICE_ACK, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        HttpDetailsActivity httpDetailsActivity = (HttpDetailsActivity) context;
        this.mActivity = httpDetailsActivity;
        PayloadAdapter payloadAdapter = this.mAdapter;
        if (payloadAdapter != null) {
            payloadAdapter.setExportPayloadHandler(httpDetailsActivity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0130R.layout.connection_payload, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
        PayloadAdapter payloadAdapter = this.mAdapter;
        if (payloadAdapter != null) {
            payloadAdapter.setExportPayloadHandler(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle arguments = getArguments();
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog == null) {
            this.mActivity.finish();
            return;
        }
        HttpLog.HttpRequest request = httpLog.getRequest(arguments.getInt(HttpDetailsActivity.HTTP_REQ_POS_KEY));
        this.mHttpReq = request;
        if (request == null) {
            Utils.showToast(requireContext(), C0130R.string.item_not_found, new Object[0]);
            this.mActivity.finish();
            return;
        }
        this.mRecyclerView = (EmptyRecyclerView) view.findViewById(C0130R.C0132id.payload);
        this.mRecyclerView.setLayoutManager(new EmptyRecyclerView.MyLinearLayoutManager(requireContext()));
        EmptyRecyclerView emptyRecyclerView = this.mRecyclerView;
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(10);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(emptyRecyclerView, transportImpl$$ExternalSyntheticLambda0);
        this.mRecyclerView.setClipToPadding(false);
        PayloadAdapter payloadAdapter = new PayloadAdapter(requireContext(), this.mHttpReq, arguments.getBoolean("show_reply"));
        this.mAdapter = payloadAdapter;
        payloadAdapter.setDisplayAsPrintableText(true);
        this.mAdapter.setExportPayloadHandler(this.mActivity);
        if (!this.mHttpReq.decryptionError.isEmpty()) {
            ((TextView) view.findViewById(C0130R.C0132id.request_url)).setText(this.mHttpReq.getProtoAndHost());
            ((TextView) view.findViewById(C0130R.C0132id.decryption_error)).setText(this.mHttpReq.decryptionError);
            this.mRecyclerView.setEmptyView((LinearLayout) view.findViewById(C0130R.C0132id.decryption_error_container));
            ((Button) view.findViewById(C0130R.C0132id.show_connection_btn)).setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(5, this));
        } else if (payloadNoticeAcknowledged(PreferenceManager.getDefaultSharedPreferences(requireContext()))) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
    }

    public void setDisplayMode(boolean z) {
        this.mAdapter.setDisplayAsPrintableText(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean z) {
        HttpDetailsActivity httpDetailsActivity;
        super.setMenuVisibility(z);
        Context context = getContext();
        if (context != null) {
            Log.m587d(TAG, "setMenuVisibility : " + z);
            SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(context), 0);
            if (z && !payloadNoticeAcknowledged(sharedPreferences)) {
                zzbv zzbvVar = new zzbv(context);
                zzbvVar.setTitle(C0130R.string.warning);
                zzbvVar.setMessage(C0130R.string.payload_scams_notice);
                ((AlertController.AlertParams) zzbvVar.zza).mOnCancelListener = new AppSelectDialog$$ExternalSyntheticLambda2(3, this);
                zzbvVar.setNegativeButton(C0130R.string.cancel_action, new AppsFragment$$ExternalSyntheticLambda0(6, this));
                zzbvVar.setPositiveButton(C0130R.string.show_data_action, new FirewallStatus$$ExternalSyntheticLambda2(this, 5, sharedPreferences));
                zzbvVar.show().setCanceledOnTouchOutside(false);
            }
            if (z && (httpDetailsActivity = this.mActivity) != null) {
                httpDetailsActivity.updateMenuVisibility();
            }
        }
    }
}
