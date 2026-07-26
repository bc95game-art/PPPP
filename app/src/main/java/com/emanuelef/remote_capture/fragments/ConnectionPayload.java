package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.adapters.PayloadAdapter;
import com.emanuelef.remote_capture.interfaces.PayloadHostActivity;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class ConnectionPayload extends Fragment implements PayloadHostActivity.ConnUpdateListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ConnectionPayload";
    private PayloadHostActivity mActivity;
    private PayloadAdapter mAdapter;
    private ConnectionDescriptor mConn;
    private int mCurChunks;
    private WindowInsetsCompat mInsets;
    private EmptyRecyclerView mRecyclerView;
    private boolean mShowAsPrintable;
    private TextView mTruncatedWarning;

    private void applyTruncatedWarningInsets(WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTruncatedWarning.getLayoutParams();
        marginLayoutParams.bottomMargin = insets.bottom;
        this.mTruncatedWarning.setLayoutParams(marginLayoutParams);
    }

    public static WindowInsetsCompat lambda$onViewCreated$0(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, 0, 0, windowInsetsCompat.mImpl.getInsets(135).bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public /* synthetic */ WindowInsetsCompat lambda$onViewCreated$1(View view, WindowInsetsCompat windowInsetsCompat) {
        if (this.mConn.isPayloadTruncated()) {
            applyTruncatedWarningInsets(windowInsetsCompat);
            return WindowInsetsCompat.CONSUMED;
        }
        this.mInsets = windowInsetsCompat;
        return windowInsetsCompat;
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

    public static ConnectionPayload newInstance(PayloadChunk.ChunkType chunkType, int i) {
        ConnectionPayload connectionPayload = new ConnectionPayload();
        Bundle bundle = new Bundle();
        bundle.putSerializable("mode", chunkType);
        bundle.putInt(ConnectionDetailsActivity.CONN_ID_KEY, i);
        connectionPayload.setArguments(bundle);
        return connectionPayload;
    }

    private boolean payloadNoticeAcknowledged(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean(Prefs.PREF_PAYLOAD_NOTICE_ACK, false);
    }

    @Override // com.emanuelef.remote_capture.interfaces.PayloadHostActivity.ConnUpdateListener
    public void connectionUpdated() {
        TextView textView;
        PayloadHostActivity payloadHostActivity;
        if (this.mCurChunks == 0 && (payloadHostActivity = this.mActivity) != null) {
            payloadHostActivity.updateMenuVisibility();
        }
        if (this.mConn.getNumPayloadChunks() > this.mCurChunks) {
            this.mAdapter.handleChunksAdded(this.mConn.getNumPayloadChunks());
            this.mCurChunks = this.mConn.getNumPayloadChunks();
        }
        if (this.mConn.isPayloadTruncated() && (textView = this.mTruncatedWarning) != null) {
            textView.setVisibility(0);
        }
        WindowInsetsCompat windowInsetsCompat = this.mInsets;
        if (windowInsetsCompat != null) {
            applyTruncatedWarningInsets(windowInsetsCompat);
        }
    }

    public boolean guessDisplayAsPrintable() {
        ConnectionDescriptor connectionDescriptor = this.mConn;
        if (connectionDescriptor == null) {
            return false;
        }
        if (connectionDescriptor.getNumPayloadChunks() == 0) {
            return this.mConn.l7proto.equals("HTTPS");
        }
        PayloadChunk payloadChunk = this.mConn.getPayloadChunk(0);
        if (!(payloadChunk == null || payloadChunk.type == PayloadChunk.ChunkType.HTTP)) {
            int min = Math.min(payloadChunk.payload.length, 16);
            for (int i = 0; i < min; i++) {
                if (!Utils.isPrintable(payloadChunk.payload[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        PayloadHostActivity payloadHostActivity = (PayloadHostActivity) context;
        this.mActivity = payloadHostActivity;
        payloadHostActivity.addConnUpdateListener(this);
        PayloadAdapter payloadAdapter = this.mAdapter;
        if (payloadAdapter != null) {
            payloadAdapter.setExportPayloadHandler(this.mActivity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0130R.layout.connection_payload, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity.removeConnUpdateListener(this);
        this.mActivity = null;
        PayloadAdapter payloadAdapter = this.mAdapter;
        if (payloadAdapter != null) {
            payloadAdapter.setExportPayloadHandler(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle arguments = getArguments();
        ConnectionsRegister requireConnsRegister = CaptureService.requireConnsRegister();
        PayloadChunk.ChunkType chunkType = (PayloadChunk.ChunkType) Utils.getSerializable(arguments, "mode", PayloadChunk.ChunkType.class);
        ConnectionDescriptor connById = requireConnsRegister.getConnById(arguments.getInt(ConnectionDetailsActivity.CONN_ID_KEY));
        this.mConn = connById;
        if (connById == null) {
            Utils.showToast(requireContext(), C0130R.string.connection_not_found, new Object[0]);
            requireActivity().finish();
            return;
        }
        this.mRecyclerView = (EmptyRecyclerView) view.findViewById(C0130R.C0132id.payload);
        this.mRecyclerView.setLayoutManager(new EmptyRecyclerView.MyLinearLayoutManager(requireContext()));
        TextView textView = (TextView) view.findViewById(C0130R.C0132id.truncated_warning);
        this.mTruncatedWarning = textView;
        textView.setText(String.format(getString(C0130R.string.payload_truncated), getString(C0130R.string.full_payload)));
        if (this.mConn.isPayloadTruncated()) {
            this.mTruncatedWarning.setVisibility(0);
        }
        EmptyRecyclerView emptyRecyclerView = this.mRecyclerView;
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(5);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(emptyRecyclerView, transportImpl$$ExternalSyntheticLambda0);
        this.mRecyclerView.setClipToPadding(false);
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this.mTruncatedWarning, new InputConnectionCompat$$ExternalSyntheticLambda0(7, this));
        this.mCurChunks = this.mConn.getNumPayloadChunks();
        this.mShowAsPrintable = true;
        PayloadAdapter payloadAdapter = new PayloadAdapter(requireContext(), this.mConn, chunkType, this.mShowAsPrintable);
        this.mAdapter = payloadAdapter;
        payloadAdapter.setExportPayloadHandler(this.mActivity);
        if (payloadNoticeAcknowledged(PreferenceManager.getDefaultSharedPreferences(requireContext()))) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
    }

    public void setDisplayMode(boolean z) {
        this.mShowAsPrintable = z;
        this.mAdapter.setDisplayAsPrintableText(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean z) {
        PayloadHostActivity payloadHostActivity;
        super.setMenuVisibility(z);
        Context context = getContext();
        if (context != null) {
            Log.m587d(TAG, "setMenuVisibility : " + z);
            SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(context), 0);
            if (z && !payloadNoticeAcknowledged(sharedPreferences)) {
                zzbv zzbvVar = new zzbv(context);
                zzbvVar.setTitle(C0130R.string.warning);
                zzbvVar.setMessage(C0130R.string.payload_scams_notice);
                ((AlertController.AlertParams) zzbvVar.zza).mOnCancelListener = new AppSelectDialog$$ExternalSyntheticLambda2(2, this);
                zzbvVar.setNegativeButton(C0130R.string.cancel_action, new AppsFragment$$ExternalSyntheticLambda0(4, this));
                zzbvVar.setPositiveButton(C0130R.string.show_data_action, new FirewallStatus$$ExternalSyntheticLambda2(this, 2, sharedPreferences));
                zzbvVar.show().setCanceledOnTouchOutside(false);
            }
            if (z && (payloadHostActivity = this.mActivity) != null && this.mConn != null) {
                payloadHostActivity.updateMenuVisibility();
            }
        }
    }
}
