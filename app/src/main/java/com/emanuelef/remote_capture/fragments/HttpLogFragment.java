package com.emanuelef.remote_capture.fragments;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.HttpDetailsActivity;
import com.emanuelef.remote_capture.activities.HttpLogFilterActivity;
import com.emanuelef.remote_capture.adapters.HttpLogAdapter;
import com.emanuelef.remote_capture.adapters.HttpLogAdapter$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.HttpLogFilterDescriptor;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.Slider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class HttpLogFragment extends Fragment implements HttpLog.Listener, MenuProvider, SearchView.OnQueryTextListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "HttpLogFragment";
    private boolean autoScroll;
    private boolean listenerSet;
    private ActionMode mActionMode;
    private ChipGroup mActiveFilter;
    private HttpLogAdapter mAdapter;
    private AlertDialog mAlertDialog;
    private AppsResolver mApps;
    private TextView mEmptyText;
    private FloatingActionButton mFabDown;
    private Handler mHandler;
    private Uri mHarFname;
    private MenuItem mMenuItemSearch;
    private String mQueryToApply;
    private EmptyRecyclerView mRecyclerView;
    private MenuItem mSave;
    private MenuItem mSaveAsHar;
    private SearchView mSearchView;
    private Slider mSizeSlider;
    private Uri mTxtFname;
    private int mFabDownMargin = 0;
    private boolean mSizeSliderActive = false;
    private final ActivityResultLauncher filterLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new HttpLogFragment$$ExternalSyntheticLambda9(this, 0));
    private final ActivityResultLauncher txtFileLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new HttpLogFragment$$ExternalSyntheticLambda9(this, 1));
    private final ActivityResultLauncher harFileLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new HttpLogFragment$$ExternalSyntheticLambda9(this, 2));
    private final ActionMode.Callback mActionModeCallback = new ActionMode.Callback() { // from class: com.emanuelef.remote_capture.fragments.HttpLogFragment.3
        {
            HttpLogFragment.this = this;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.select_all) {
                if (HttpLogFragment.this.mAdapter.getSelectedCount() == HttpLogFragment.this.mAdapter.getItemCount()) {
                    actionMode.finish();
                    return true;
                }
                HttpLogFragment.this.mAdapter.selectAll();
                HttpLogFragment.this.updateActionModeTitle();
                return true;
            } else if (itemId == R.id.save) {
                HttpLogFragment.this.openFileSelector();
                return true;
            } else if (itemId != R.id.save_as_har) {
                return false;
            } else {
                HttpLogFragment.this.openHarFileSelector();
                return true;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.http_log_cab, menu);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            HttpLogFragment.this.mAdapter.clearSelection();
            HttpLogFragment.this.mActionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };

    private void dumpHttpLog() {
        boolean z;
        if (this.mTxtFname != null) {
            if (this.mActionMode != null) {
                z = true;
            } else {
                z = false;
            }
            Log.d(TAG, "Writing HTTP log file: " + this.mTxtFname);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.mAdapter.getItemCount(); i++) {
                HttpLog.HttpRequest item = this.mAdapter.getItem(i);
                if (item != null && (!z || this.mAdapter.isSelected(item))) {
                    arrayList.add(item);
                }
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            boolean[] zArr = {false};
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setTitle(R.string.exporting);
            zzbvVar.setMessage(R.string.export_in_progress);
            zzbvVar.setNegativeButton(17039360, new HttpLogFragment$$ExternalSyntheticLambda4(zArr, newSingleThreadExecutor, 2));
            AlertDialog create = zzbvVar.create();
            this.mAlertDialog = create;
            create.setCanceledOnTouchOutside(false);
            this.mAlertDialog.show();
            this.mAlertDialog.setOnCancelListener(new HttpLogFragment$$ExternalSyntheticLambda5(zArr, newSingleThreadExecutor, 2));
            this.mAlertDialog.setOnDismissListener(new HttpLogFragment$$ExternalSyntheticLambda6(this, 1));
            Uri uri = this.mTxtFname;
            this.mTxtFname = null;
            newSingleThreadExecutor.execute(new HttpLogFragment$$ExternalSyntheticLambda7(this, uri, arrayList, zArr, handler, 1));
        }
    }

    private void exportHttpLogHar() {
        boolean z;
        if (this.mHarFname != null) {
            if (this.mActionMode != null) {
                z = true;
            } else {
                z = false;
            }
            Log.d(TAG, "Writing HAR file: " + this.mHarFname);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.mAdapter.getItemCount(); i++) {
                HttpLog.HttpRequest item = this.mAdapter.getItem(i);
                if (item != null && (!z || this.mAdapter.isSelected(item))) {
                    arrayList.add(item);
                }
            }
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            boolean[] zArr = {false};
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setTitle(R.string.exporting);
            zzbvVar.setMessage(R.string.export_in_progress);
            zzbvVar.setNegativeButton(17039360, new HttpLogFragment$$ExternalSyntheticLambda4(zArr, newSingleThreadExecutor, 0));
            AlertDialog create = zzbvVar.create();
            this.mAlertDialog = create;
            create.setCanceledOnTouchOutside(false);
            this.mAlertDialog.show();
            this.mAlertDialog.setOnCancelListener(new HttpLogFragment$$ExternalSyntheticLambda5(zArr, newSingleThreadExecutor, 0));
            this.mAlertDialog.setOnDismissListener(new HttpLogFragment$$ExternalSyntheticLambda6(this, 0));
            Uri uri = this.mHarFname;
            this.mHarFname = null;
            newSingleThreadExecutor.execute(new HttpLogFragment$$ExternalSyntheticLambda7(this, uri, arrayList, zArr, handler, 0));
        }
    }

    public void filterResult(ActivityResult activityResult) {
        Intent intent;
        HttpLogFilterDescriptor httpLogFilterDescriptor;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null && (httpLogFilterDescriptor = (HttpLogFilterDescriptor) Utils.getSerializableExtra(intent, HttpLogFilterActivity.FILTER_DESCRIPTOR, HttpLogFilterDescriptor.class)) != null) {
            HttpLogAdapter httpLogAdapter = this.mAdapter;
            httpLogAdapter.mFilter = httpLogFilterDescriptor;
            httpLogAdapter.refreshFilteredItems();
            refreshActiveFilter();
        }
    }

    private long getMaxPayloadSize() {
        int i;
        HttpLog httpLog = CaptureService.getHttpLog();
        long j = 0;
        if (httpLog == null) {
            return 0L;
        }
        synchronized (httpLog) {
            for (int i2 = 0; i2 < httpLog.getSize(); i2++) {
                try {
                    HttpLog.HttpRequest request = httpLog.getRequest(i2);
                    if (request != null) {
                        HttpLog.HttpReply httpReply = request.reply;
                        if (httpReply != null) {
                            i = request.bodyLength + httpReply.bodyLength;
                        } else {
                            i = request.bodyLength;
                        }
                        long j2 = i;
                        if (j2 > j) {
                            j = j2;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    public void harFileResult(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode != -1 || (intent = activityResult.mData) == null) {
            this.mHarFname = null;
            return;
        }
        this.mHarFname = intent.getData();
        exportHttpLogHar();
    }

    public static /* synthetic */ void lambda$dumpHttpLog$12(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface, int i) {
        Log.i(TAG, "Abort TXT export");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public static /* synthetic */ void lambda$dumpHttpLog$13(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface) {
        Log.i(TAG, "Abort TXT export (back button)");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public /* synthetic */ void lambda$dumpHttpLog$14(DialogInterface dialogInterface) {
        this.mAlertDialog = null;
    }

    public /* synthetic */ void lambda$dumpHttpLog$15(boolean z, Utils.UriStat uriStat) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!z) {
            Utils.showToast(requireContext(), R.string.cannot_write_file, new Object[0]);
        } else if (uriStat != null) {
            Toast.makeText(requireContext(), String.format(getString(R.string.file_saved_with_name), uriStat.name), 0).show();
        } else {
            Utils.showToast(requireContext(), R.string.save_ok, new Object[0]);
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$dumpHttpLog$16(android.net.Uri r16, java.util.ArrayList r17, boolean[] r18, android.os.Handler r19) {
        /*
            r15 = this;
            r1 = r16
            java.lang.String r0 = "]\n"
            java.lang.String r2 = "["
            r3 = 0
            androidx.fragment.app.FragmentActivity r4 = r15.requireActivity()     // Catch: java.io.IOException -> L49
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.io.IOException -> L49
            java.lang.String r5 = "rwt"
            java.io.OutputStream r4 = r4.openOutputStream(r1, r5)     // Catch: java.io.IOException -> L49
            if (r4 == 0) goto Lbb
            int r5 = r17.size()     // Catch: java.io.IOException -> L49
            r6 = 0
        L1c:
            if (r6 >= r5) goto Laf
            r7 = r17
            java.lang.Object r8 = r7.get(r6)     // Catch: java.io.IOException -> L49
            int r6 = r6 + 1
            com.emanuelef.remote_capture.HttpLog$HttpRequest r8 = (com.emanuelef.remote_capture.HttpLog.HttpRequest) r8     // Catch: java.io.IOException -> L49
            boolean r9 = java.lang.Thread.interrupted()     // Catch: java.io.IOException -> L49
            if (r9 == 0) goto L30
            goto Laf
        L30:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L49
            r9.<init>()     // Catch: java.io.IOException -> L49
            com.emanuelef.remote_capture.model.ConnectionDescriptor r10 = r8.conn     // Catch: java.io.IOException -> L49
            int r11 = r8.firstChunkPos     // Catch: java.io.IOException -> L49
            com.emanuelef.remote_capture.model.PayloadChunk r10 = r10.getHttpRequestChunk(r11)     // Catch: java.io.IOException -> L49
            if (r10 == 0) goto L4b
            java.lang.String r11 = new java.lang.String     // Catch: java.io.IOException -> L49
            byte[] r10 = r10.payload     // Catch: java.io.IOException -> L49
            java.nio.charset.Charset r12 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.io.IOException -> L49
            r11.<init>(r10, r12)     // Catch: java.io.IOException -> L49
            goto L4d
        L49:
            r0 = move-exception
            goto Lb4
        L4b:
            java.lang.String r11 = ""
        L4d:
            r9.append(r2)     // Catch: java.io.IOException -> L49
            long r12 = r8.timestamp     // Catch: java.io.IOException -> L49
            r9.append(r12)     // Catch: java.io.IOException -> L49
            r9.append(r0)     // Catch: java.io.IOException -> L49
            boolean r10 = r11.isEmpty()     // Catch: java.io.IOException -> L49
            java.lang.String r12 = "\n"
            if (r10 != 0) goto L6c
            r9.append(r11)     // Catch: java.io.IOException -> L49
            boolean r10 = r11.endsWith(r12)     // Catch: java.io.IOException -> L49
            if (r10 != 0) goto L6c
            r9.append(r12)     // Catch: java.io.IOException -> L49
        L6c:
            r9.append(r12)     // Catch: java.io.IOException -> L49
            com.emanuelef.remote_capture.HttpLog$HttpReply r10 = r8.reply     // Catch: java.io.IOException -> L49
            if (r10 == 0) goto La0
            com.emanuelef.remote_capture.model.ConnectionDescriptor r8 = r8.conn     // Catch: java.io.IOException -> L49
            int r10 = r10.firstChunkPos     // Catch: java.io.IOException -> L49
            com.emanuelef.remote_capture.model.PayloadChunk r8 = r8.getHttpResponseChunk(r10)     // Catch: java.io.IOException -> L49
            if (r8 == 0) goto La0
            java.lang.String r10 = new java.lang.String     // Catch: java.io.IOException -> L49
            byte[] r11 = r8.payload     // Catch: java.io.IOException -> L49
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.io.IOException -> L49
            r10.<init>(r11, r13)     // Catch: java.io.IOException -> L49
            r9.append(r2)     // Catch: java.io.IOException -> L49
            long r13 = r8.timestamp     // Catch: java.io.IOException -> L49
            r9.append(r13)     // Catch: java.io.IOException -> L49
            r9.append(r0)     // Catch: java.io.IOException -> L49
            r9.append(r10)     // Catch: java.io.IOException -> L49
            boolean r8 = r10.endsWith(r12)     // Catch: java.io.IOException -> L49
            if (r8 != 0) goto L9d
            r9.append(r12)     // Catch: java.io.IOException -> L49
        L9d:
            r9.append(r12)     // Catch: java.io.IOException -> L49
        La0:
            java.lang.String r8 = r9.toString()     // Catch: java.io.IOException -> L49
            java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.io.IOException -> L49
            byte[] r8 = r8.getBytes(r9)     // Catch: java.io.IOException -> L49
            r4.write(r8)     // Catch: java.io.IOException -> L49
            goto L1c
        Laf:
            r4.close()     // Catch: java.io.IOException -> L49
            r0 = 1
            goto Lbc
        Lb4:
            boolean r2 = r18[r3]
            if (r2 != 0) goto Lbb
            r0.printStackTrace()
        Lbb:
            r0 = 0
        Lbc:
            boolean r2 = r18[r3]
            if (r2 == 0) goto Lc1
            return
        Lc1:
            if (r0 == 0) goto Lcc
            android.content.Context r2 = r15.requireContext()
            com.emanuelef.remote_capture.Utils$UriStat r1 = com.emanuelef.remote_capture.Utils.getUriStat(r2, r1)
            goto Lcd
        Lcc:
            r1 = 0
        Lcd:
            com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda1 r2 = new com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda1
            r3 = 1
            r2.<init>(r15, r0, r1, r3)
            r1 = r19
            r1.post(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.fragments.HttpLogFragment.lambda$dumpHttpLog$16(android.net.Uri, java.util.ArrayList, boolean[], android.os.Handler):void");
    }

    public static /* synthetic */ void lambda$exportHttpLogHar$17(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface, int i) {
        Log.i(TAG, "Abort HAR export");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public static /* synthetic */ void lambda$exportHttpLogHar$18(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface) {
        Log.i(TAG, "Abort HAR export (back button)");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public /* synthetic */ void lambda$exportHttpLogHar$19(DialogInterface dialogInterface) {
        this.mAlertDialog = null;
    }

    public /* synthetic */ void lambda$exportHttpLogHar$20(boolean z, Utils.UriStat uriStat) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!z) {
            Utils.showToast(requireContext(), R.string.cannot_write_file, new Object[0]);
        } else if (uriStat != null) {
            Toast.makeText(requireContext(), String.format(getString(R.string.file_saved_with_name), uriStat.name), 0).show();
        } else {
            Utils.showToast(requireContext(), R.string.save_ok, new Object[0]);
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$exportHttpLogHar$21(android.net.Uri r5, java.util.ArrayList r6, boolean[] r7, android.os.Handler r8) {
        /*
            r4 = this;
            r0 = 0
            androidx.fragment.app.FragmentActivity r1 = r4.requireActivity()     // Catch: java.io.IOException -> L22
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.io.IOException -> L22
            java.lang.String r2 = "rwt"
            java.io.OutputStream r1 = r1.openOutputStream(r5, r2)     // Catch: java.io.IOException -> L22
            if (r1 == 0) goto L2a
            com.emanuelef.remote_capture.HarWriter r2 = new com.emanuelef.remote_capture.HarWriter     // Catch: java.io.IOException -> L22
            android.content.Context r3 = r4.requireContext()     // Catch: java.io.IOException -> L22
            r2.<init>(r3, r6)     // Catch: java.io.IOException -> L22
            r2.write(r1)     // Catch: java.io.IOException -> L22
            r1.close()     // Catch: java.io.IOException -> L22
            r6 = 1
            goto L2b
        L22:
            r6 = move-exception
            boolean r1 = r7[r0]
            if (r1 != 0) goto L2a
            r6.printStackTrace()
        L2a:
            r6 = 0
        L2b:
            boolean r7 = r7[r0]
            if (r7 == 0) goto L30
            return
        L30:
            if (r6 == 0) goto L3b
            android.content.Context r7 = r4.requireContext()
            com.emanuelef.remote_capture.Utils$UriStat r5 = com.emanuelef.remote_capture.Utils.getUriStat(r7, r5)
            goto L3c
        L3b:
            r5 = 0
        L3c:
            com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda1 r7 = new com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda1
            r0 = 0
            r7.<init>(r4, r6, r5, r0)
            r8.post(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.fragments.HttpLogFragment.lambda$exportHttpLogHar$21(android.net.Uri, java.util.ArrayList, boolean[], android.os.Handler):void");
    }

    public /* synthetic */ void lambda$onHttpRequestAdded$9(int i) {
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            httpLogAdapter.onHttpRequestAdded(i);
            if (this.autoScroll) {
                scrollToBottom();
            }
        }
    }

    public /* synthetic */ void lambda$onHttpRequestUpdated$10(int i) {
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            httpLogAdapter.onHttpRequestUpdated(i);
            if (this.autoScroll) {
                scrollToBottom();
            }
        }
    }

    public /* synthetic */ void lambda$onHttpRequestsClear$11() {
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            httpLogAdapter.onHttpRequestsClear();
        }
    }

    public static /* synthetic */ String lambda$onViewCreated$0(float f) {
        return Utils.formatBytes(f * 1024);
    }

    public /* synthetic */ void lambda$onViewCreated$1(Slider slider, float f, boolean z) {
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            httpLogAdapter.mFilter.minPayloadSize = f * 1024;
            refreshFilteredRequests();
        }
    }

    public /* synthetic */ void lambda$onViewCreated$2(ChipGroup chipGroup, List list) {
        if (this.mAdapter != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.mAdapter.mFilter.clear(((Integer) it.next()).intValue());
            }
            refreshFilteredRequests();
        }
    }

    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        ArrayList<Integer> filteredPositions;
        int childLayoutPosition = this.mRecyclerView.getChildLayoutPosition(view);
        if (this.mActionMode != null) {
            toggleSelection(childLayoutPosition);
            return;
        }
        HttpLog.HttpRequest item = this.mAdapter.getItem(childLayoutPosition);
        if (item != null) {
            Intent intent = new Intent(requireContext(), HttpDetailsActivity.class);
            intent.putExtra(HttpDetailsActivity.HTTP_REQ_POS_KEY, item.getPosition());
            if (this.mAdapter.hasFilter() && (filteredPositions = this.mAdapter.getFilteredPositions()) != null) {
                intent.putIntegerArrayListExtra(HttpDetailsActivity.FILTERED_POSITIONS_KEY, filteredPositions);
            }
            startActivity(intent);
        }
    }

    public /* synthetic */ boolean lambda$onViewCreated$4(View view) {
        int childLayoutPosition = this.mRecyclerView.getChildLayoutPosition(view);
        if (this.mActionMode != null) {
            toggleSelection(childLayoutPosition);
            return true;
        }
        startSelectionMode(childLayoutPosition);
        return true;
    }

    public static WindowInsetsCompat lambda$onViewCreated$5(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        int i = insets.left;
        int i2 = insets.top;
        int i3 = insets.right;
        view.setPadding(i, i2, i3, 0);
        return windowInsetsCompat.mImpl.inset(insets.left, i2, i3, 0);
    }

    public /* synthetic */ void lambda$onViewCreated$6(View view) {
        scrollToBottom();
    }

    public WindowInsetsCompat lambda$onViewCreated$7(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(143);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (this.mFabDownMargin == 0) {
            this.mFabDownMargin = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.bottomMargin = this.mFabDownMargin + insets.bottom;
        view.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.CONSUMED;
    }

    public /* synthetic */ void lambda$onViewCreated$8(CaptureService.ServiceStatus serviceStatus) {
        if (serviceStatus == CaptureService.ServiceStatus.STARTED) {
            unregisterHttpListener();
            registerHttpListener();
            this.autoScroll = true;
            showFabDown(false);
            this.mEmptyText.setText(R.string.no_requests);
            this.mApps.clear();
        }
        refreshMenuIcons();
    }

    public void recheckMaxPayloadSize() {
        if (this.mSizeSlider.getVisibility() == 0 && !this.mSizeSliderActive) {
            float maxPayloadSize = (float) (getMaxPayloadSize() / 1024);
            if (maxPayloadSize > this.mSizeSlider.getValueTo()) {
                this.mSizeSlider.setValueTo(maxPayloadSize);
            }
        }
    }

    public void recheckScroll() {
        boolean z;
        boolean z2;
        EmptyRecyclerView.MyLinearLayoutManager myLinearLayoutManager = (EmptyRecyclerView.MyLinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findFirstCompletelyVisibleItemPosition = myLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (myLinearLayoutManager.findLastCompletelyVisibleItemPosition() >= this.mAdapter.getItemCount() - 1) {
            z = true;
        } else {
            z = false;
        }
        if (findFirstCompletelyVisibleItemPosition != 0 || !z) {
            if (this.mRecyclerView.getScrollState() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                if (z2) {
                    this.autoScroll = true;
                }
                showFabDown(false);
                return;
            }
            if (z2) {
                this.autoScroll = false;
            }
            showFabDown(true);
            return;
        }
        showFabDown(false);
    }

    private void refreshActiveFilter() {
        if (this.mAdapter != null) {
            this.mActiveFilter.removeAllViews();
            this.mAdapter.mFilter.toChips(getLayoutInflater(), this.mActiveFilter);
            long j = this.mAdapter.mFilter.minPayloadSize / 1024;
            if (CaptureService.getHttpLog() != null && j > 0) {
                long max = Math.max(getMaxPayloadSize() / 1024, j);
                if (max >= 2) {
                    this.mSizeSlider.setValueTo((float) max);
                    this.mSizeSlider.setValue((float) j);
                    if (this.mSizeSlider.getVisibility() != 0) {
                        this.mSizeSlider.setVisibility(0);
                        this.mSizeSlider.setLabelBehavior(3);
                    }
                }
            }
        }
    }

    private void refreshEmptyText() {
        int i;
        if (CaptureService.getHttpLog() != null || CaptureService.isServiceActive()) {
            TextView textView = this.mEmptyText;
            if (this.mAdapter.hasFilter()) {
                i = R.string.no_matches_found;
            } else {
                i = R.string.no_requests;
            }
            textView.setText(i);
            return;
        }
        this.mEmptyText.setText(R.string.capture_not_running_status);
    }

    private void refreshFilteredRequests() {
        this.mAdapter.refreshFilteredItems();
        refreshActiveFilter();
        recheckScroll();
    }

    private void refreshMenuIcons() {
        boolean z;
        if (this.mSave != null) {
            if (CaptureService.getHttpLog() != null) {
                z = true;
            } else {
                z = false;
            }
            this.mMenuItemSearch.setVisible(z);
            this.mSave.setEnabled(z);
            MenuItem menuItem = this.mSaveAsHar;
            if (menuItem != null) {
                menuItem.setEnabled(z);
            }
        }
    }

    private void registerHttpListener() {
        HttpLog httpLog;
        if (!this.listenerSet && (httpLog = CaptureService.getHttpLog()) != null) {
            httpLog.setListener(this);
            this.listenerSet = true;
            HttpLogAdapter httpLogAdapter = this.mAdapter;
            if (httpLogAdapter != null) {
                httpLogAdapter.notifyDataSetChanged();
            }
        }
    }

    private void scrollToBottom() {
        this.mRecyclerView.scrollToPosition(this.mAdapter.getItemCount() - 1);
        this.autoScroll = true;
        showFabDown(false);
    }

    private void setQuery(String str) {
        Utils.setSearchQuery(this.mSearchView, this.mMenuItemSearch, str);
    }

    private void showFabDown(boolean z) {
        if (z) {
            this.mFabDown.show(true);
        } else {
            this.mFabDown.hide(true);
        }
    }

    private void startSelectionMode(int i) {
        if (this.mActionMode == null) {
            this.mActionMode = ((AppCompatActivity) requireActivity()).startSupportActionMode(this.mActionModeCallback);
            this.mAdapter.selectItem(i);
            updateActionModeTitle();
        }
    }

    private void toggleSelection(int i) {
        this.mAdapter.toggleSelection(i);
        if (this.mAdapter.getSelectedCount() == 0) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return;
            }
            return;
        }
        updateActionModeTitle();
    }

    public void txtFileResult(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode != -1 || (intent = activityResult.mData) == null) {
            this.mTxtFname = null;
            return;
        }
        this.mTxtFname = intent.getData();
        dumpHttpLog();
    }

    private void unregisterHttpListener() {
        if (this.listenerSet) {
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null) {
                httpLog.setListener(null);
            }
            this.listenerSet = false;
        }
    }

    public void updateActionModeTitle() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.setTitle(getString(R.string.n_selected, Integer.valueOf(this.mAdapter.getSelectedCount())));
        }
    }

    public void clearFilters() {
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            httpLogAdapter.mFilter = new HttpLogFilterDescriptor();
            this.mAdapter.refreshFilteredItems();
            refreshActiveFilter();
        }
    }

    public boolean onBackPressed() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode == null) {
            return Utils.backHandleSearchview(this.mSearchView);
        }
        actionMode.finish();
        return true;
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.http_log_menu, menu);
        this.mSave = menu.findItem(R.id.save);
        this.mSaveAsHar = menu.findItem(R.id.save_as_har);
        MenuItem findItem = menu.findItem(R.id.search);
        this.mMenuItemSearch = findItem;
        SearchView searchView = (SearchView) findItem.getActionView();
        this.mSearchView = searchView;
        searchView.setOnQueryTextListener(this);
        String str = this.mQueryToApply;
        if (str != null && !str.isEmpty()) {
            String str2 = this.mQueryToApply;
            this.mQueryToApply = null;
            setQuery(str2);
        }
        refreshMenuIcons();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!(getParentFragment() instanceof DataViewContainerFragment)) {
            requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        }
        return layoutInflater.inflate(R.layout.connections, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
            clearFilters();
            return;
        }
        EmptyRecyclerView emptyRecyclerView = this.mRecyclerView;
        if (emptyRecyclerView != null) {
            emptyRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestAdded(int i) {
        Utils.runOnUi(new HttpLogFragment$$ExternalSyntheticLambda0(this, i, 1), this.mHandler);
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestUpdated(int i) {
        Utils.runOnUi(new HttpLogFragment$$ExternalSyntheticLambda0(this, i, 0), this.mHandler);
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestsClear() {
        Utils.runOnUi(new HttpLogFragment$$ExternalSyntheticLambda2(this, 0), this.mHandler);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.save) {
            openFileSelector();
            return true;
        } else if (itemId == R.id.save_as_har) {
            openHarFileSelector();
            return true;
        } else if (itemId != R.id.edit_filter) {
            return false;
        } else {
            Intent intent = new Intent(requireContext(), HttpLogFilterActivity.class);
            intent.putExtra(HttpLogFilterActivity.FILTER_DESCRIPTOR, this.mAdapter.mFilter);
            this.filterLauncher.launch(intent);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterHttpListener();
        this.mRecyclerView.setEmptyView(null);
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            this.mQueryToApply = searchView.getQuery().toString();
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.mAdapter.setSearch(str);
        recheckScroll();
        refreshEmptyText();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        int i;
        super.onResume();
        refreshEmptyText();
        registerHttpListener();
        this.mRecyclerView.setEmptyView(this.mEmptyText);
        this.mRecyclerView.post(new HttpLogFragment$$ExternalSyntheticLambda2(this, 1));
        refreshMenuIcons();
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            int i2 = 0;
            if (httpLogAdapter.mFilter.minPayloadSize >= 1024) {
                z = true;
            } else {
                z = false;
            }
            Slider slider = this.mSizeSlider;
            if (!z) {
                i2 = 8;
            }
            slider.setVisibility(i2);
            Slider slider2 = this.mSizeSlider;
            if (z) {
                i = 3;
            } else {
                i = 2;
            }
            slider2.setLabelBehavior(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            bundle.putString("search", searchView.getQuery().toString());
        }
        HttpLogAdapter httpLogAdapter = this.mAdapter;
        if (httpLogAdapter != null) {
            bundle.putSerializable("http_log_filter_desc", httpLogAdapter.mFilter);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mFabDown = (FloatingActionButton) view.findViewById(R.id.fabDown);
        this.mRecyclerView = (EmptyRecyclerView) view.findViewById(R.id.connections_view);
        EmptyRecyclerView.MyLinearLayoutManager myLinearLayoutManager = new EmptyRecyclerView.MyLinearLayoutManager(requireContext());
        this.mRecyclerView.setLayoutManager(myLinearLayoutManager);
        this.mApps = new AppsResolver(requireContext());
        this.mEmptyText = (TextView) view.findViewById(R.id.no_connections);
        Slider slider = (Slider) view.findViewById(R.id.size_slider);
        this.mSizeSlider = slider;
        slider.setLabelFormatter(new TransportImpl$$ExternalSyntheticLambda0(8));
        Slider slider2 = this.mSizeSlider;
        slider2.changeListeners.add(new HttpLogFragment$$ExternalSyntheticLambda14(this, 0));
        Slider slider3 = this.mSizeSlider;
        slider3.touchListeners.add(new BaseOnSliderTouchListener() { // from class: com.emanuelef.remote_capture.fragments.HttpLogFragment.1
            {
                HttpLogFragment.this = this;
            }

            public void onStartTrackingTouch(Slider slider4) {
                HttpLogFragment.this.mSizeSliderActive = true;
            }

            public void onStopTrackingTouch(Slider slider4) {
                if (slider4.getValue() == 0.0f) {
                    slider4.setVisibility(8);
                    slider4.setLabelBehavior(2);
                }
                HttpLogFragment.this.mSizeSliderActive = false;
                HttpLogFragment.this.recheckMaxPayloadSize();
            }
        });
        ChipGroup chipGroup = (ChipGroup) view.findViewById(R.id.active_filter);
        this.mActiveFilter = chipGroup;
        chipGroup.setOnCheckedStateChangeListener(new HttpLogFragment$$ExternalSyntheticLambda9(this, 3));
        HttpLogAdapter httpLogAdapter = new HttpLogAdapter(requireContext(), this.mApps);
        this.mAdapter = httpLogAdapter;
        this.mRecyclerView.setAdapter(httpLogAdapter);
        this.mRecyclerView.addItemDecoration(new DividerItemDecoration(this.mRecyclerView.getContext(), myLinearLayoutManager.getOrientation()));
        this.mAdapter.setClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda16
            public final /* synthetic */ HttpLogFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$3(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$6(view2);
                        return;
                }
            }
        });
        this.mAdapter.setLongClickListener(new HttpLogAdapter$$ExternalSyntheticLambda0(2, this));
        this.autoScroll = true;
        this.listenerSet = false;
        showFabDown(false);
        View findViewById = view.findViewById(R.id.linearlayout);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(9);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, transportImpl$$ExternalSyntheticLambda0);
        this.mFabDown.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda16
            public final /* synthetic */ HttpLogFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$3(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$6(view2);
                        return;
                }
            }
        });
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this.mFabDown, new HttpLogFragment$$ExternalSyntheticLambda9(this, 4));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.emanuelef.remote_capture.fragments.HttpLogFragment.2
            {
                HttpLogFragment.this = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                HttpLogFragment.this.recheckScroll();
            }
        });
        if (bundle != null) {
            String string = bundle.getString("search");
            if (string != null && !string.isEmpty()) {
                this.mQueryToApply = string;
            }
            if (bundle.containsKey("http_log_filter_desc")) {
                this.mAdapter.mFilter = (HttpLogFilterDescriptor) Utils.getSerializable(bundle, "http_log_filter_desc", HttpLogFilterDescriptor.class);
            }
        }
        refreshActiveFilter();
        CaptureService.observeStatus(this, new AppsFragment$$ExternalSyntheticLambda3(5, this));
    }

    public void openFileSelector() {
        String exportFileName = Utils.getExportFileName(requireContext(), "txt");
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", exportFileName);
        if (Utils.supportsFileDialog(requireContext(), intent)) {
            try {
                this.txtFileLauncher.launch(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Log.d(TAG, "No app found to handle file selection");
        Uri downloadsUri = Utils.getDownloadsUri(requireContext(), exportFileName);
        if (downloadsUri != null) {
            this.mTxtFname = downloadsUri;
            dumpHttpLog();
            return;
        }
        Utils.showToastLong(requireContext(), R.string.no_activity_file_selection, new Object[0]);
    }

    public void openHarFileSelector() {
        String exportFileName = Utils.getExportFileName(requireContext(), "har");
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", exportFileName);
        if (Utils.supportsFileDialog(requireContext(), intent)) {
            try {
                this.harFileLauncher.launch(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Log.d(TAG, "No app found to handle file selection");
        Uri downloadsUri = Utils.getDownloadsUri(requireContext(), exportFileName);
        if (downloadsUri != null) {
            this.mHarFname = downloadsUri;
            exportHttpLogHar();
            return;
        }
        Utils.showToastLong(requireContext(), R.string.no_activity_file_selection, new Object[0]);
    }
}
