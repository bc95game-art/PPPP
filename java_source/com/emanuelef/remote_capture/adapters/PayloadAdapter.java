package com.emanuelef.remote_capture.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.p002os.BundleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HTTPReassembly;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.material.button.MaterialButton;
import com.google.gson.FormattingStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.LazyKt__LazyJVMKt;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class PayloadAdapter extends RecyclerView.Adapter implements HTTPReassembly.ReassemblyListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int COLLAPSE_CHUNK_SIZE = 1500;
    static final int MAX_JSON_FORMAT_SIZE = 1048576;
    private static final String TAG = "PayloadAdapter";
    public static final int VISUAL_PAGE_SIZE = 4020;
    private static final Gson prettyGson;
    private final ArrayList<AdapterChunk> mChunks;
    private final ConnectionDescriptor mConn;
    private final Context mContext;
    private ExportPayloadHandler mExportHandler;
    private int mHandledChunks;
    private final HTTPReassembly mHttpReq;
    private final HTTPReassembly mHttpRes;
    private final LayoutInflater mLayoutInflater;
    private final PayloadChunk.ChunkType mMode;
    private boolean mShowAsPrintable;
    private final PayloadChunk mSingleChunk;
    private final boolean mSupportsFileDialog;
    private final ArrayList<AdapterChunk> mUnrepliedHttpReqs;

    /* loaded from: classes.dex */
    public interface ExportPayloadHandler {
        void exportPayload(String str);

        void exportPayload(byte[] bArr, String str, String str2);
    }

    /* loaded from: classes.dex */
    public static class Page {
        AdapterChunk adaptChunk;
        boolean isLast;
        int textEnd;
        int textStart;

        public Page(AdapterChunk adapterChunk, int i, int i2, boolean z) {
            this.adaptChunk = adapterChunk;
            this.textStart = i;
            this.textEnd = i2;
            this.isLast = z;
        }

        public String getText() {
            return this.adaptChunk.getText(this.textStart, this.textEnd);
        }

        public boolean isFirst() {
            if (this.textStart == 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class PayloadViewHolder extends RecyclerView.ViewHolder {
        MaterialButton copybutton;
        TextView dump;
        View dumpBox;
        MaterialButton expandButton;
        MaterialButton exportbutton;
        TextView header;
        View headerLine;

        public PayloadViewHolder(View view) {
            super(view);
            this.headerLine = view.findViewById(C0130R.C0132id.header_line);
            this.header = (TextView) view.findViewById(C0130R.C0132id.header);
            this.dump = (TextView) view.findViewById(C0130R.C0132id.dump);
            this.dumpBox = view.findViewById(C0130R.C0132id.dump_box);
            this.expandButton = (MaterialButton) view.findViewById(C0130R.C0132id.expand_button);
            this.copybutton = (MaterialButton) view.findViewById(C0130R.C0132id.copy_button);
            this.exportbutton = (MaterialButton) view.findViewById(C0130R.C0132id.export_button);
        }
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        FormattingStyle formattingStyle = FormattingStyle.PRETTY;
        Objects.requireNonNull(formattingStyle);
        gsonBuilder.formattingStyle = formattingStyle;
        prettyGson = gsonBuilder.create();
    }

    private PayloadAdapter(Context context, ConnectionDescriptor connectionDescriptor, PayloadChunk.ChunkType chunkType, boolean z, PayloadChunk payloadChunk) {
        this.mUnrepliedHttpReqs = new ArrayList<>();
        ArrayList<AdapterChunk> arrayList = new ArrayList<>();
        this.mChunks = arrayList;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mConn = connectionDescriptor;
        this.mContext = context;
        this.mMode = chunkType;
        this.mShowAsPrintable = z;
        this.mSupportsFileDialog = Utils.supportsFileDialog(context);
        this.mSingleChunk = payloadChunk;
        boolean z2 = false;
        if (payloadChunk == null) {
            z2 = CaptureService.getCurPayloadMode() == Prefs.PayloadMode.FULL ? true : z2;
            this.mHttpReq = new HTTPReassembly(z2, this);
            this.mHttpRes = new HTTPReassembly(z2, this);
            handleChunksAdded(connectionDescriptor.getNumPayloadChunks());
            return;
        }
        this.mHttpReq = null;
        this.mHttpRes = null;
        if (payloadChunk.payload.length > 0) {
            arrayList.add(new AdapterChunk(payloadChunk, 0));
            notifyItemInserted(0);
        }
    }

    private AdapterChunk findMatchingRequest(PayloadChunk payloadChunk) {
        if (this.mUnrepliedHttpReqs.isEmpty()) {
            return null;
        }
        int i = 0;
        if (payloadChunk.stream_id == 0) {
            return this.mUnrepliedHttpReqs.get(0);
        }
        ArrayList<AdapterChunk> arrayList = this.mUnrepliedHttpReqs;
        int size = arrayList.size();
        while (i < size) {
            AdapterChunk adapterChunk = arrayList.get(i);
            i++;
            AdapterChunk adapterChunk2 = adapterChunk;
            if (adapterChunk2.mChunk.stream_id == payloadChunk.stream_id) {
                return adapterChunk2;
            }
        }
        return null;
    }

    public static String formatHttpPayload(String str, String str2) {
        int indexOf;
        int i;
        if (str2 == null || !str2.equals("application/json") || str.length() > MAX_JSON_FORMAT_SIZE || (indexOf = str.indexOf("\r\n\r\n")) < 0 || (i = indexOf + 4) >= str.length()) {
            return str;
        }
        String substring = str.substring(0, i);
        try {
            String json = prettyGson.toJson(LazyKt__LazyJVMKt.parseString(str.substring(i)));
            return substring + json;
        } catch (JsonSyntaxException unused) {
            return str;
        }
    }

    private int getAdapterPosition(AdapterChunk adapterChunk) {
        AdapterChunk adapterChunk2;
        int i = 0;
        for (int i2 = 0; i2 < this.mChunks.size() && (adapterChunk2 = this.mChunks.get(i2)) != adapterChunk; i2++) {
            i += adapterChunk2.getNumPages();
        }
        return i;
    }

    private static PayloadChunk getChunk(HttpLog.HttpRequest httpRequest, boolean z) {
        if (!z) {
            return httpRequest.conn.getHttpRequestChunk(httpRequest.firstChunkPos);
        }
        HttpLog.HttpReply httpReply = httpRequest.reply;
        if (httpReply != null) {
            return httpRequest.conn.getHttpResponseChunk(httpReply.firstChunkPos);
        }
        return new PayloadChunk(new byte[0], PayloadChunk.ChunkType.HTTP, true, 0L, 0);
    }

    private String getHeaderTag(PayloadChunk payloadChunk) {
        if (this.mMode == PayloadChunk.ChunkType.HTTP) {
            if (payloadChunk.is_sent) {
                return this.mContext.getString(C0130R.string.request);
            }
            return this.mContext.getString(C0130R.string.response);
        } else if (payloadChunk.is_sent) {
            return this.mContext.getString(C0130R.string.tx_direction);
        } else {
            return this.mContext.getString(C0130R.string.rx_direction);
        }
    }

    private void handleCopyExportButtons(PayloadViewHolder payloadViewHolder, final boolean z) {
        int i;
        int i2;
        String str;
        String str2;
        int lastIndexOf;
        if (!z || this.mExportHandler != null) {
            final int absoluteAdapterPosition = payloadViewHolder.getAbsoluteAdapterPosition();
            if (z) {
                i = C0130R.string.export_ellipsis;
            } else {
                i = C0130R.string.copy_action;
            }
            if (z) {
                i2 = C0130R.string.export_action;
            } else {
                i2 = C0130R.string.copy_to_clipboard;
            }
            final AdapterChunk adapterChunk = getItem(absoluteAdapterPosition).adaptChunk;
            if (adapterChunk != null) {
                if (this.mMode == PayloadChunk.ChunkType.HTTP) {
                    final String expandedText = adapterChunk.getExpandedText(true);
                    final int indexOf = expandedText.indexOf("\r\n\r\n");
                    if (adapterChunk.mChunk.httpContentType == null || adapterChunk.mChunk.httpContentType.isEmpty()) {
                        str = "text/plain";
                    } else {
                        str = adapterChunk.mChunk.httpContentType;
                    }
                    final String str3 = str;
                    Log.m587d(TAG, "Export body content type: " + str3);
                    final String str4 = "";
                    if (!adapterChunk.mChunk.is_sent || adapterChunk.mChunk.httpPath == null) {
                        if (absoluteAdapterPosition > 0) {
                            AdapterChunk adapterChunk2 = getItem(absoluteAdapterPosition - 1).adaptChunk;
                            if (adapterChunk2.mChunk.is_sent && adapterChunk2.mChunk.httpPath != null) {
                                str2 = adapterChunk2.mChunk.httpPath;
                            }
                        }
                        str2 = str4;
                    } else {
                        str2 = adapterChunk.mChunk.httpPath;
                    }
                    if (!str2.isEmpty() && (lastIndexOf = str2.lastIndexOf(47)) >= 0) {
                        str2 = str2.substring(lastIndexOf + 1);
                    }
                    if (str2.contains(".")) {
                        Log.m587d(TAG, "File name: ".concat(str2));
                        str4 = str2;
                    }
                    if (indexOf > 0 && indexOf < expandedText.length() - 4) {
                        String[] strArr = {this.mContext.getString(C0130R.string.headers), this.mContext.getString(C0130R.string.body), this.mContext.getString(C0130R.string.both)};
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
                        builder.setTitle(i);
                        builder.setSingleChoiceItems(strArr, 1, new Blocklist$$ExternalSyntheticLambda0(10));
                        builder.setNeutralButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(11));
                        builder.setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: com.emanuelef.remote_capture.adapters.PayloadAdapter$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                PayloadAdapter.this.lambda$handleCopyExportButtons$5(expandedText, indexOf, z, adapterChunk, str3, str4, dialogInterface, i3);
                            }
                        });
                        builder.create().show();
                    } else if (z) {
                        ExportPayloadHandler exportPayloadHandler = this.mExportHandler;
                        if (exportPayloadHandler != null) {
                            exportPayloadHandler.exportPayload(expandedText);
                        }
                    } else {
                        Utils.copyToClipboard(this.mContext, expandedText);
                    }
                } else {
                    ArrayList arrayList = new ArrayList(Arrays.asList(this.mContext.getString(C0130R.string.text), this.mContext.getString(C0130R.string.hexdump)));
                    if (z) {
                        arrayList.add(this.mContext.getString(C0130R.string.raw_bytes));
                    }
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this.mContext);
                    builder2.setTitle(i);
                    builder2.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), 1 ^ (this.mShowAsPrintable ? 1 : 0), new Blocklist$$ExternalSyntheticLambda0(12));
                    builder2.setNeutralButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(13));
                    builder2.setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: com.emanuelef.remote_capture.adapters.PayloadAdapter$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            PayloadAdapter.this.lambda$handleCopyExportButtons$8(z, adapterChunk, absoluteAdapterPosition, dialogInterface, i3);
                        }
                    });
                    builder2.create().show();
                }
            }
        }
    }

    public static /* synthetic */ void lambda$handleCopyExportButtons$3(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void lambda$handleCopyExportButtons$4(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$handleCopyExportButtons$5(String str, int i, boolean z, AdapterChunk adapterChunk, String str2, String str3, DialogInterface dialogInterface, int i2) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition != 2) {
            if (checkedItemPosition == 0) {
                str = str.substring(0, i);
            } else {
                str = str.substring(i + 4);
            }
        }
        if (z) {
            ExportPayloadHandler exportPayloadHandler = this.mExportHandler;
            if (exportPayloadHandler == null) {
                return;
            }
            if (checkedItemPosition == 1) {
                byte[] bArr = adapterChunk.mChunk.payload;
                if (i < bArr.length - 4) {
                    bArr = Arrays.copyOfRange(bArr, i + 4, bArr.length);
                }
                this.mExportHandler.exportPayload(bArr, str2, str3);
                return;
            }
            exportPayloadHandler.exportPayload(str);
            return;
        }
        Utils.copyToClipboard(this.mContext, str);
    }

    public static /* synthetic */ void lambda$handleCopyExportButtons$6(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void lambda$handleCopyExportButtons$7(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$handleCopyExportButtons$8(boolean z, AdapterChunk adapterChunk, int i, DialogInterface dialogInterface, int i2) {
        boolean z2;
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 2) {
            ExportPayloadHandler exportPayloadHandler = this.mExportHandler;
            if (exportPayloadHandler != null) {
                exportPayloadHandler.exportPayload(adapterChunk.mChunk.payload, "application/octet-stream", "");
                return;
            }
            return;
        }
        AdapterChunk adapterChunk2 = getItem(i).adaptChunk;
        if (checkedItemPosition == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        String expandedText = adapterChunk2.getExpandedText(z2);
        if (z) {
            ExportPayloadHandler exportPayloadHandler2 = this.mExportHandler;
            if (exportPayloadHandler2 != null) {
                exportPayloadHandler2.exportPayload(expandedText);
                return;
            }
            return;
        }
        Utils.copyToClipboard(this.mContext, expandedText);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0(PayloadViewHolder payloadViewHolder, View view) {
        int absoluteAdapterPosition = payloadViewHolder.getAbsoluteAdapterPosition();
        Page item = getItem(absoluteAdapterPosition);
        if (item.adaptChunk.isExpanded()) {
            int numPages = item.adaptChunk.getNumPages() - 1;
            int i = absoluteAdapterPosition - numPages;
            item.adaptChunk.collapse();
            notifyItemChanged(i);
            notifyItemRangeRemoved(i + 1, numPages);
            return;
        }
        item.adaptChunk.expand();
        notifyItemChanged(absoluteAdapterPosition);
        notifyItemRangeInserted(absoluteAdapterPosition + 1, item.adaptChunk.getNumPages() - 1);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1(PayloadViewHolder payloadViewHolder, View view) {
        handleCopyExportButtons(payloadViewHolder, false);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2(PayloadViewHolder payloadViewHolder, View view) {
        handleCopyExportButtons(payloadViewHolder, true);
    }

    public Page getItem(int i) {
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.mChunks.size()) {
            int numPages = this.mChunks.get(i2).getNumPages() + i3;
            if (i >= i3 && i < numPages) {
                break;
            }
            i2++;
            i3 = numPages;
        }
        if (i2 >= this.mChunks.size()) {
            return null;
        }
        return this.mChunks.get(i2).getPage(i - i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<AdapterChunk> arrayList = this.mChunks;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            AdapterChunk adapterChunk = arrayList.get(i2);
            i2++;
            i += adapterChunk.getNumPages();
        }
        return i;
    }

    public void handleChunksAdded(int i) {
        boolean z;
        boolean isReadingFromPcapFile = CaptureService.isReadingFromPcapFile();
        int i2 = -1;
        for (int i3 = this.mHandledChunks; i3 < i; i3++) {
            PayloadChunk payloadChunk = this.mConn.getPayloadChunk(i3);
            if (payloadChunk != null) {
                if (!isReadingFromPcapFile || this.mMode != PayloadChunk.ChunkType.WEBSOCKET || payloadChunk.type == PayloadChunk.ChunkType.RAW) {
                    z = false;
                } else {
                    z = true;
                }
                PayloadChunk.ChunkType chunkType = this.mMode;
                if (chunkType == PayloadChunk.ChunkType.RAW || chunkType == payloadChunk.type || z) {
                    if (chunkType != PayloadChunk.ChunkType.HTTP && !z) {
                        if (i2 == -1) {
                            i2 = getItemCount();
                        }
                        ArrayList<AdapterChunk> arrayList = this.mChunks;
                        arrayList.add(new AdapterChunk(payloadChunk, arrayList.size()));
                        notifyItemInserted(i2);
                        i2++;
                    } else if (payloadChunk.is_sent) {
                        this.mHttpReq.handleChunk(payloadChunk);
                    } else {
                        this.mHttpRes.handleChunk(payloadChunk);
                    }
                }
            }
        }
        this.mHandledChunks = i;
    }

    @Override // com.emanuelef.remote_capture.HTTPReassembly.ReassemblyListener
    @SuppressLint({"DefaultLocale"})
    public void onChunkReassembled(PayloadChunk payloadChunk) {
        PayloadChunk.ChunkType chunkType = this.mMode;
        if (chunkType == PayloadChunk.ChunkType.RAW || chunkType == payloadChunk.type) {
            AdapterChunk adapterChunk = new AdapterChunk(payloadChunk, this.mChunks.size());
            int itemCount = getItemCount();
            int size = this.mChunks.size();
            boolean isHttp2Rst = payloadChunk.isHttp2Rst();
            if (!payloadChunk.is_sent || isHttp2Rst) {
                AdapterChunk findMatchingRequest = findMatchingRequest(payloadChunk);
                if (findMatchingRequest != null) {
                    int indexOf = this.mChunks.indexOf(findMatchingRequest);
                    if (!isHttp2Rst) {
                        size = indexOf + 1;
                        itemCount = getAdapterPosition(findMatchingRequest) + findMatchingRequest.getNumPages();
                        Log.m587d(TAG, String.format("chunk #%d reply of #%d at %d", Integer.valueOf(adapterChunk.incrId), Integer.valueOf(findMatchingRequest.incrId), Integer.valueOf(size)));
                    } else {
                        Log.m587d(TAG, String.format("chunk #%d reset of #%d", Integer.valueOf(adapterChunk.incrId), Integer.valueOf(findMatchingRequest.incrId)));
                    }
                    this.mUnrepliedHttpReqs.remove(findMatchingRequest);
                }
            } else if (!isHttp2Rst) {
                this.mUnrepliedHttpReqs.add(adapterChunk);
            }
            if (!isHttp2Rst) {
                this.mChunks.add(size, adapterChunk);
                notifyItemInserted(itemCount);
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setDisplayAsPrintableText(boolean z) {
        if (this.mShowAsPrintable != z) {
            this.mShowAsPrintable = z;
            ArrayList<AdapterChunk> arrayList = this.mChunks;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                AdapterChunk adapterChunk = arrayList.get(i);
                i++;
                adapterChunk.collapse();
            }
            notifyDataSetChanged();
        }
    }

    public void setExportPayloadHandler(ExportPayloadHandler exportPayloadHandler) {
        this.mExportHandler = exportPayloadHandler;
    }

    public void onBindViewHolder(PayloadViewHolder payloadViewHolder, int i) {
        String str;
        Page item = getItem(i);
        PayloadChunk payloadChunk = item.adaptChunk.getPayloadChunk();
        if (item.isFirst()) {
            payloadViewHolder.headerLine.setVisibility(0);
            Locale primaryLocale = Utils.getPrimaryLocale(this.mContext);
            String format = new SimpleDateFormat("HH:mm:ss.SSS", primaryLocale).format(new Date(payloadChunk.timestamp));
            if (this.mMode == PayloadChunk.ChunkType.HTTP) {
                str = Utils.formatBytes(payloadChunk.httpBodyLength);
            } else {
                str = Utils.formatBytes(payloadChunk.payload.length);
            }
            if (this.mSingleChunk == null) {
                payloadViewHolder.header.setText(String.format(primaryLocale, "#%d [%s] %s — %s", Integer.valueOf(item.adaptChunk.incrId + 1), getHeaderTag(payloadChunk), format, str));
            } else {
                TextView textView = payloadViewHolder.header;
                textView.setText(format + " — " + str);
            }
        } else {
            payloadViewHolder.headerLine.setVisibility(8);
        }
        if (!item.isLast || !item.adaptChunk.canBeExpanded()) {
            payloadViewHolder.expandButton.setVisibility(8);
        } else {
            payloadViewHolder.expandButton.setVisibility(0);
            payloadViewHolder.expandButton.setRotation(item.adaptChunk.isExpanded() ? 180.0f : 0.0f);
        }
        payloadViewHolder.dump.setText(item.getText());
        if (payloadChunk.is_sent) {
            payloadViewHolder.dumpBox.setBackgroundResource(C0130R.color.sentPayloadBg);
            payloadViewHolder.dump.setTextColor(BundleKt.getColor(this.mContext, C0130R.color.sentPayloadFg));
            return;
        }
        payloadViewHolder.dumpBox.setBackgroundResource(C0130R.color.rcvdPayloadBg);
        payloadViewHolder.dump.setTextColor(BundleKt.getColor(this.mContext, C0130R.color.rcvdPayloadFg));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PayloadViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = 0;
        final PayloadViewHolder payloadViewHolder = new PayloadViewHolder(this.mLayoutInflater.inflate(C0130R.layout.payload_item, viewGroup, false));
        payloadViewHolder.expandButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.PayloadAdapter$$ExternalSyntheticLambda6
            public final /* synthetic */ PayloadAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$onCreateViewHolder$0(payloadViewHolder, view);
                        return;
                    case 1:
                        this.f$0.lambda$onCreateViewHolder$1(payloadViewHolder, view);
                        return;
                    default:
                        this.f$0.lambda$onCreateViewHolder$2(payloadViewHolder, view);
                        return;
                }
            }
        });
        payloadViewHolder.copybutton.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.PayloadAdapter$$ExternalSyntheticLambda6
            public final /* synthetic */ PayloadAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$onCreateViewHolder$0(payloadViewHolder, view);
                        return;
                    case 1:
                        this.f$0.lambda$onCreateViewHolder$1(payloadViewHolder, view);
                        return;
                    default:
                        this.f$0.lambda$onCreateViewHolder$2(payloadViewHolder, view);
                        return;
                }
            }
        });
        payloadViewHolder.exportbutton.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.PayloadAdapter$$ExternalSyntheticLambda6
            public final /* synthetic */ PayloadAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$onCreateViewHolder$0(payloadViewHolder, view);
                        return;
                    case 1:
                        this.f$0.lambda$onCreateViewHolder$1(payloadViewHolder, view);
                        return;
                    default:
                        this.f$0.lambda$onCreateViewHolder$2(payloadViewHolder, view);
                        return;
                }
            }
        });
        MaterialButton materialButton = payloadViewHolder.exportbutton;
        if (!this.mSupportsFileDialog) {
            i2 = 8;
        }
        materialButton.setVisibility(i2);
        return payloadViewHolder;
    }

    /* loaded from: classes.dex */
    public class AdapterChunk {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final int incrId;
        private final PayloadChunk mChunk;
        private boolean mIsExpanded;
        private int mNumPages = 1;
        private String mTheText;

        public AdapterChunk(PayloadChunk payloadChunk, int i) {
            PayloadAdapter.this = r1;
            this.mChunk = payloadChunk;
            this.incrId = i;
        }

        private String makeText(boolean z, boolean z2) {
            int length = z2 ? this.mChunk.payload.length : Math.min(this.mChunk.payload.length, (int) PayloadAdapter.COLLAPSE_CHUNK_SIZE);
            if (!z) {
                return Utils.hexdump(this.mChunk.payload, 0, length);
            }
            return new String(this.mChunk.payload, 0, length, StandardCharsets.UTF_8);
        }

        public boolean canBeExpanded() {
            if (this.mChunk.payload.length > 1500) {
                return true;
            }
            return false;
        }

        public void collapse() {
            this.mIsExpanded = false;
            this.mTheText = null;
            this.mNumPages = 1;
        }

        public void expand() {
            this.mIsExpanded = true;
            String makeText = makeText();
            this.mTheText = makeText;
            this.mNumPages = (makeText.length() + 4019) / PayloadAdapter.VISUAL_PAGE_SIZE;
        }

        public String getExpandedText(boolean z) {
            return makeText(z, true);
        }

        public int getNumPages() {
            return this.mNumPages;
        }

        public Page getPage(int i) {
            if (this.mTheText == null) {
                this.mTheText = makeText();
            }
            boolean z = false;
            if (!this.mIsExpanded) {
                return new Page(this, 0, this.mTheText.length() - 1, true);
            }
            int i2 = i * PayloadAdapter.VISUAL_PAGE_SIZE;
            int min = Math.min(((i + 1) * PayloadAdapter.VISUAL_PAGE_SIZE) - 1, this.mTheText.length() - 1);
            if (i == this.mNumPages - 1) {
                z = true;
            }
            return new Page(this, i2, min, z);
        }

        public PayloadChunk getPayloadChunk() {
            return this.mChunk;
        }

        public String getText(int i, int i2) {
            if (this.mTheText == null) {
                this.mTheText = makeText();
            }
            if (i != 0 || i2 < this.mTheText.length() - 1) {
                return this.mTheText.substring(i, i2);
            }
            return this.mTheText;
        }

        public boolean isExpanded() {
            return this.mIsExpanded;
        }

        private String makeText() {
            String makeText = makeText(PayloadAdapter.this.mShowAsPrintable, this.mIsExpanded);
            return (!PayloadAdapter.this.mShowAsPrintable || PayloadAdapter.this.mMode != PayloadChunk.ChunkType.HTTP) ? makeText : PayloadAdapter.formatHttpPayload(makeText, this.mChunk.httpContentType);
        }
    }

    public PayloadAdapter(Context context, ConnectionDescriptor connectionDescriptor, PayloadChunk.ChunkType chunkType, boolean z) {
        this(context, connectionDescriptor, chunkType, z, null);
    }

    public PayloadAdapter(Context context, HttpLog.HttpRequest httpRequest, boolean z) {
        this(context, httpRequest.conn, PayloadChunk.ChunkType.HTTP, true, getChunk(httpRequest, z));
    }
}
