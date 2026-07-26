package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.adapters.PayloadAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
/* loaded from: classes.dex */
public class PayloadExportActivity extends BaseActivity implements PayloadAdapter.ExportPayloadHandler {
    private byte[] mRawPayloadToExport;
    private String mStringPayloadToExport;
    private final ActivityResultLauncher payloadExportLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new InputConnectionCompat$$ExternalSyntheticLambda0(5, this));

    public void payloadExportResult(ActivityResult activityResult) {
        if (this.mRawPayloadToExport != null || this.mStringPayloadToExport != null) {
            int i = activityResult.mResultCode;
            Intent intent = activityResult.mData;
            if (!(i != -1 || intent == null || intent.getData() == null)) {
                try {
                    OutputStream openOutputStream = getContentResolver().openOutputStream(intent.getData(), "rwt");
                    if (openOutputStream != null) {
                        if (this.mStringPayloadToExport != null) {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openOutputStream);
                            try {
                                outputStreamWriter.write(this.mStringPayloadToExport);
                                outputStreamWriter.close();
                            } catch (Throwable th) {
                                try {
                                    outputStreamWriter.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } else {
                            openOutputStream.write(this.mRawPayloadToExport);
                        }
                        Utils.showToast(this, R.string.save_ok, new Object[0]);
                    } else {
                        Utils.showToastLong(this, R.string.export_failed, new Object[0]);
                    }
                    if (openOutputStream != null) {
                        openOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Utils.showToastLong(this, R.string.export_failed, new Object[0]);
                }
            }
            this.mRawPayloadToExport = null;
            this.mStringPayloadToExport = null;
        }
    }

    @Override // com.emanuelef.remote_capture.adapters.PayloadAdapter.ExportPayloadHandler
    public void exportPayload(String str) {
        this.mStringPayloadToExport = str;
        this.mRawPayloadToExport = null;
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TITLE", Utils.getUniqueFileName(this, "txt"));
        Utils.launchFileDialog(this, intent, this.payloadExportLauncher);
    }

    @Override // com.emanuelef.remote_capture.adapters.PayloadAdapter.ExportPayloadHandler
    public void exportPayload(byte[] bArr, String str, String str2) {
        String str3;
        this.mStringPayloadToExport = null;
        this.mRawPayloadToExport = bArr;
        if (str2.isEmpty()) {
            str.getClass();
            char c = 65535;
            switch (str.hashCode()) {
                case -1082243251:
                    if (str.equals("text/html")) {
                        c = 0;
                        break;
                    }
                    break;
                case -43840953:
                    if (str.equals("application/json")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1178484637:
                    if (str.equals("application/octet-stream")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str3 = "html";
                    break;
                case 1:
                    str3 = "json";
                    break;
                case 2:
                    str3 = "bin";
                    break;
                default:
                    str3 = "txt";
                    break;
            }
            str2 = Utils.getUniqueFileName(this, str3);
        }
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/http");
        intent.putExtra("android.intent.extra.TITLE", str2);
        Utils.launchFileDialog(this, intent, this.payloadExportLauncher);
    }
}
