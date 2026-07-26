package com.emanuelef.remote_capture.pcap_dump;

import android.content.Context;
import android.net.Uri;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.interfaces.PcapDumper;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class FileDumper implements PcapDumper {
    public static final String TAG = "FileDumper";
    private final Context mContext;
    private OutputStream mOutputStream;
    private final Uri mPcapUri;
    private boolean mSendHeader = true;

    public FileDumper(Context context, Uri uri) {
        this.mContext = context;
        this.mPcapUri = uri;
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void dumpData(byte[] bArr) {
        if (this.mSendHeader) {
            this.mSendHeader = false;
            this.mOutputStream.write(CaptureService.getPcapHeader());
        }
        this.mOutputStream.write(bArr);
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public String getBpf() {
        return "";
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void startDumper() {
        Log.d(TAG, "PCAP URI: " + this.mPcapUri);
        this.mOutputStream = this.mContext.getContentResolver().openOutputStream(this.mPcapUri, "rwt");
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void stopDumper() {
        this.mOutputStream.close();
    }
}
