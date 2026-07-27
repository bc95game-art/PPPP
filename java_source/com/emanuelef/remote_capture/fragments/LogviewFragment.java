package com.emanuelef.remote_capture.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.ReversedLinesFileReader;
import com.emanuelef.remote_capture.Utils;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class LogviewFragment extends Fragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_LINES = 512;
    private static final String TAG = "LogviewFragment";
    private String mLogPath;
    private String mLogText;
    private TextView mLogView;

    public static WindowInsetsCompat lambda$onViewCreated$0(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, 0, 0, windowInsetsCompat.mImpl.getInsets(135).bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public static LogviewFragment newInstance(String str) {
        LogviewFragment logviewFragment = new LogviewFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("path", str);
        logviewFragment.setArguments(bundle);
        return logviewFragment;
    }

    public String getLog() {
        return this.mLogText;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0130R.layout.logview_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mLogPath = getArguments().getString("path");
        ScrollView scrollView = (ScrollView) view.findViewById(C0130R.C0132id.scrollView);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(11);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(scrollView, transportImpl$$ExternalSyntheticLambda0);
        scrollView.setClipToPadding(false);
        if (Utils.isTv(view.getContext())) {
            scrollView.setDescendantFocusability(393216);
        }
        this.mLogView = (TextView) view.findViewById(C0130R.C0132id.log);
        reloadLog();
    }

    public void reloadLog() {
        String str;
        try {
            ReversedLinesFileReader reversedLinesFileReader = new ReversedLinesFileReader(new File(this.mLogPath), StandardCharsets.US_ASCII);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                String readLine = reversedLinesFileReader.readLine();
                if (readLine == null || i >= 512) {
                    break;
                }
                sb.insert(0, "\n");
                sb.insert(0, readLine);
                i++;
            }
            this.mLogText = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            this.mLogText = "";
        }
        TextView textView = this.mLogView;
        if (!this.mLogText.isEmpty()) {
            str = this.mLogText;
        } else {
            str = getString(C0130R.string.no_data);
        }
        textView.setText(str);
    }
}
