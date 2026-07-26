package com.emanuelef.remote_capture.model;

import android.content.Context;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HTTPReassembly;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import com.emanuelef.remote_capture.model.Geomodel;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.emanuelef.remote_capture.model.Prefs;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class ConnectionDescriptor implements HTTPReassembly.ReassemblyListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONN_STATUS_CLIENT_ERROR = 6;
    public static final int CONN_STATUS_CLOSED = 3;
    public static final int CONN_STATUS_CONNECTED = 2;
    public static final int CONN_STATUS_CONNECTING = 1;
    public static final int CONN_STATUS_ERROR = 4;
    public static final int CONN_STATUS_NEW = 0;
    public static final int CONN_STATUS_RESET = 7;
    public static final int CONN_STATUS_SOCKET_ERROR = 5;
    public static final int CONN_STATUS_UNREACHABLE = 8;
    public static final String TAG = "ConnectionDescriptor";
    public boolean alerted;
    private boolean blacklisted_host;
    private boolean blacklisted_ip;
    public boolean block_accounted;
    public int blocked_pkts;
    public String country;
    public String decryption_error;
    private boolean decryption_ignored;
    public final String dst_ip;
    public final int dst_port;
    private boolean encrypted_l7;
    public boolean encrypted_payload;
    public int error;
    public long first_seen;
    private boolean has_websocket_data;
    public final int ifidx;
    public final int incr_id;
    public String info;
    public final int ipproto;
    public final int ipver;
    public boolean is_blocked;
    public String js_injected_scripts;
    public long last_seen;
    public final int local_port;
    private HTTPReassembly mHttpReplyReassembly;
    private HTTPReassembly mHttpReqReassembly;
    private LinkedList<HttpLog.HttpRequest> mPendingRequests;
    private final boolean mitm_decrypt;
    public boolean netd_block_missed;
    public long payload_length;
    private boolean payload_truncated;
    private boolean port_mapping_applied;
    public long rcvd_bytes;
    public int rcvd_pkts;
    public long sent_bytes;
    public int sent_pkts;
    public final String src_ip;
    public final int src_port;
    public int status;
    private int tcp_flags;
    public final int uid;
    public String url;
    private int mFirstReqChunkPos = -1;
    private int mFirstReplyChunkPos = -1;
    public String l7proto = "";
    public Geomodel.ASN asn = new Geomodel.ASN();
    private final ArrayList<PayloadChunk> payload_chunks = new ArrayList<>();
    private boolean internal_decrypt = false;

    /* loaded from: classes.dex */
    public enum DecryptionStatus {
        INVALID,
        ENCRYPTED,
        CLEARTEXT,
        DECRYPTED,
        NOT_DECRYPTABLE,
        WAITING_DATA,
        ERROR
    }

    /* loaded from: classes.dex */
    public enum FilteringStatus {
        INVALID,
        ALLOWED,
        BLOCKED
    }

    /* loaded from: classes.dex */
    public enum Status {
        STATUS_INVALID,
        STATUS_ACTIVE,
        STATUS_CLOSED,
        STATUS_UNREACHABLE,
        STATUS_ERROR
    }

    public ConnectionDescriptor(int i, int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, int i8, boolean z, long j) {
        this.incr_id = i;
        this.ipver = i2;
        this.ipproto = i3;
        this.src_ip = str;
        this.dst_ip = str2;
        this.src_port = i4;
        this.dst_port = i5;
        this.local_port = i6;
        this.uid = i7;
        this.ifidx = i8;
        this.last_seen = j;
        this.first_seen = j;
        this.country = str3;
        this.mitm_decrypt = z;
    }

    public static String getDecryptionStatusLabel(DecryptionStatus decryptionStatus, Context context) {
        int ordinal = decryptionStatus.ordinal();
        return context.getString(ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? C0130R.string.error : C0130R.string.waiting_application_data : C0130R.string.not_decryptable : C0130R.string.decrypted : C0130R.string.not_encrypted : C0130R.string.status_encrypted);
    }

    private String getHttpAsString(boolean z) {
        PayloadChunk httpChunks = getHttpChunks(z, 0);
        if (httpChunks == null) {
            return "";
        }
        return new String(httpChunks.payload, StandardCharsets.UTF_8);
    }

    private synchronized PayloadChunk getHttpChunks(boolean z, int i) {
        boolean z2;
        try {
            if (getNumPayloadChunks() != 0 && i >= 0) {
                AtomicReference atomicReference = new AtomicReference();
                if (CaptureService.getCurPayloadMode() == Prefs.PayloadMode.FULL) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                HTTPReassembly hTTPReassembly = new HTTPReassembly(z2, new InputConnectionCompat$$ExternalSyntheticLambda0(10, atomicReference));
                while (i < this.payload_chunks.size()) {
                    PayloadChunk payloadChunk = this.payload_chunks.get(i);
                    if (payloadChunk.is_sent == z) {
                        hTTPReassembly.handleChunk(payloadChunk);
                    }
                    if (atomicReference.get() != null) {
                        break;
                    }
                    i++;
                }
                return (PayloadChunk) atomicReference.get();
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static String getStatusLabel(Status status, Context context) {
        int ordinal = status.ordinal();
        return context.getString(ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? C0130R.string.error : C0130R.string.conn_status_unreachable : C0130R.string.conn_status_closed : C0130R.string.conn_status_active);
    }

    private synchronized boolean hasHttp(boolean z) {
        ArrayList<PayloadChunk> arrayList = this.payload_chunks;
        int size = arrayList.size();
        boolean z2 = false;
        int i = 0;
        while (i < size) {
            PayloadChunk payloadChunk = arrayList.get(i);
            i++;
            PayloadChunk payloadChunk2 = payloadChunk;
            if (payloadChunk2.is_sent == z) {
                if (payloadChunk2.type == PayloadChunk.ChunkType.HTTP) {
                    z2 = true;
                }
                return z2;
            }
        }
        return false;
    }

    private void logHttpChunk(PayloadChunk payloadChunk, int i) {
        if (CaptureService.getHttpLog() != null) {
            if (this.mHttpReqReassembly == null) {
                this.mHttpReqReassembly = new HTTPReassembly(true, this, false);
                this.mHttpReplyReassembly = new HTTPReassembly(true, this, false);
                this.mPendingRequests = new LinkedList<>();
            }
            if (payloadChunk.is_sent) {
                if (this.mFirstReqChunkPos == -1 && !payloadChunk.isHttp2Rst()) {
                    this.mFirstReqChunkPos = i;
                }
                this.mHttpReqReassembly.handleChunk(payloadChunk);
                return;
            }
            if (this.mFirstReplyChunkPos == -1 && !payloadChunk.isHttp2Rst()) {
                this.mFirstReplyChunkPos = i;
            }
            this.mHttpReplyReassembly.handleChunk(payloadChunk);
        }
    }

    public synchronized void addPayloadChunkMitm(PayloadChunk payloadChunk) {
        try {
            PayloadChunk.ChunkType chunkType = payloadChunk.type;
            if (chunkType == PayloadChunk.ChunkType.HTTP) {
                logHttpChunk(payloadChunk, this.payload_chunks.size());
            } else if (chunkType == PayloadChunk.ChunkType.WEBSOCKET) {
                this.has_websocket_data = true;
            }
            this.payload_chunks.add(payloadChunk);
            this.payload_length += payloadChunk.payload.length;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void dropPayload() {
        this.payload_chunks.clear();
    }

    public DecryptionStatus getDecryptionStatus() {
        if (isCleartext()) {
            return DecryptionStatus.CLEARTEXT;
        }
        if (this.decryption_error != null) {
            return DecryptionStatus.ERROR;
        }
        if (isNotDecryptable()) {
            return DecryptionStatus.NOT_DECRYPTABLE;
        }
        if (this.decryption_ignored || (PCAPdroid.getInstance().isDecryptingPcap() && !this.internal_decrypt)) {
            return DecryptionStatus.ENCRYPTED;
        }
        if (isDecrypted()) {
            return DecryptionStatus.DECRYPTED;
        }
        return DecryptionStatus.WAITING_DATA;
    }

    public InetAddress getDstAddr() {
        try {
            return InetAddress.getByName(this.dst_ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getHttpRequest() {
        return getHttpAsString(true);
    }

    public PayloadChunk getHttpRequestChunk(int i) {
        return getHttpChunks(true, i);
    }

    public String getHttpResponse() {
        return getHttpAsString(false);
    }

    public PayloadChunk getHttpResponseChunk(int i) {
        return getHttpChunks(false, i);
    }

    public synchronized int getNumPayloadChunks() {
        return this.payload_chunks.size();
    }

    public synchronized PayloadChunk getPayloadChunk(int i) {
        if (getNumPayloadChunks() <= i) {
            return null;
        }
        return this.payload_chunks.get(i);
    }

    public int getRcvdTcpFlags() {
        return this.tcp_flags & 255;
    }

    public int getSentTcpFlags() {
        return this.tcp_flags >> 8;
    }

    public Status getStatus() {
        int i = this.status;
        if (i < 3) {
            return Status.STATUS_ACTIVE;
        }
        if (i == 3 || i == 7) {
            return Status.STATUS_CLOSED;
        }
        if (i != 8) {
            return Status.STATUS_ERROR;
        }
        return Status.STATUS_UNREACHABLE;
    }

    public boolean hasHttpRequest() {
        return hasHttp(true);
    }

    public boolean hasHttpResponse() {
        return hasHttp(false);
    }

    public boolean hasSeenStart() {
        if (this.ipproto == 6 && CaptureService.isCapturingAsRoot() && (getSentTcpFlags() & 2) == 0) {
            return false;
        }
        return true;
    }

    public boolean hasWebsocketData() {
        return this.has_websocket_data;
    }

    public boolean isBlacklisted() {
        if (isBlacklistedIp() || isBlacklistedHost()) {
            return true;
        }
        return false;
    }

    public boolean isBlacklistedHost() {
        return this.blacklisted_host;
    }

    public boolean isBlacklistedIp() {
        return this.blacklisted_ip;
    }

    public boolean isCleartext() {
        if (this.encrypted_payload || this.encrypted_l7) {
            return false;
        }
        return true;
    }

    public boolean isDecrypted() {
        if (this.decryption_ignored || isNotDecryptable()) {
            return false;
        }
        if ((this.mitm_decrypt || this.internal_decrypt) && getNumPayloadChunks() > 0) {
            return true;
        }
        return false;
    }

    public boolean isNotDecryptable() {
        if (this.decryption_ignored) {
            return false;
        }
        if ((this.encrypted_payload || !this.mitm_decrypt) && !PCAPdroid.getInstance().isDecryptingPcap()) {
            return true;
        }
        return false;
    }

    public boolean isPayloadTruncated() {
        return this.payload_truncated;
    }

    public boolean isPortMappingApplied() {
        return this.port_mapping_applied;
    }

    public boolean matches(AppsResolver appsResolver, String str) {
        String lowerCase = str.toLowerCase();
        AppDescriptor appByUid = appsResolver.getAppByUid(this.uid, 0);
        String str2 = this.info;
        if ((str2 == null || !str2.contains(lowerCase)) && !this.dst_ip.contains(lowerCase) && !this.l7proto.toLowerCase().equals(lowerCase) && !Integer.toString(this.uid).equals(lowerCase) && !Integer.toString(this.dst_port).contains(lowerCase) && !Integer.toString(this.src_port).equals(lowerCase) && (appByUid == null || !appByUid.matches(lowerCase, true))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    @Override // com.emanuelef.remote_capture.HTTPReassembly.ReassemblyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onChunkReassembled(PayloadChunk payloadChunk) {
        HttpLog httpLog;
        HttpLog.HttpRequest httpRequest;
        String str;
        if (payloadChunk.type != PayloadChunk.ChunkType.HTTP || (httpLog = CaptureService.getHttpLog()) == null) {
            return;
        }
        if (!payloadChunk.is_sent || payloadChunk.isHttp2Rst()) {
            int i = 0;
            if (payloadChunk.stream_id == 0) {
                if (!this.mPendingRequests.isEmpty()) {
                    httpRequest = this.mPendingRequests.remove(0);
                    if (httpRequest == null) {
                        if (!payloadChunk.isHttp2Rst()) {
                            HttpLog.HttpReply httpReply = new HttpLog.HttpReply(httpRequest, this.mFirstReplyChunkPos);
                            httpReply.responseCode = payloadChunk.httpResponseCode;
                            httpReply.responseStatus = payloadChunk.httpResponseStatus;
                            httpReply.contentType = payloadChunk.httpContentType;
                            httpReply.bodyLength = payloadChunk.httpBodyLength;
                            httpRequest.reply = httpReply;
                            httpLog.addHttpReply(httpReply);
                            this.mFirstReplyChunkPos = -1;
                            return;
                        }
                        httpRequest.httpRst = true;
                        Log.m587d(TAG, "Got RST: " + httpRequest.getUrl());
                        return;
                    } else if (payloadChunk.is_sent) {
                        return;
                    } else {
                        if (payloadChunk.isHttp2Rst()) {
                            Log.m581w(TAG, "Unmatched HTTP RST (sent=" + payloadChunk.is_sent + ", stream=" + payloadChunk.stream_id + ")");
                            return;
                        }
                        Log.m581w(TAG, "Unmatched HTTP reply (sent=" + payloadChunk.is_sent + ", stream=" + payloadChunk.stream_id + ")");
                        return;
                    }
                }
                httpRequest = null;
                if (httpRequest == null) {
                }
            } else {
                Iterator<HttpLog.HttpRequest> it = this.mPendingRequests.iterator();
                while (it.hasNext() && it.next().streamId != payloadChunk.stream_id) {
                    i++;
                }
                if (i < this.mPendingRequests.size()) {
                    httpRequest = this.mPendingRequests.remove(i);
                    if (httpRequest == null) {
                    }
                }
                httpRequest = null;
                if (httpRequest == null) {
                }
            }
        } else {
            HttpLog.HttpRequest httpRequest2 = new HttpLog.HttpRequest(this, this.mFirstReqChunkPos);
            if (!payloadChunk.httpHost.isEmpty()) {
                str = payloadChunk.httpHost;
            } else {
                str = this.info;
            }
            httpRequest2.host = str;
            httpRequest2.method = payloadChunk.httpMethod;
            httpRequest2.path = payloadChunk.httpPath;
            httpRequest2.query = payloadChunk.httpQuery;
            httpRequest2.bodyLength = payloadChunk.httpBodyLength;
            httpRequest2.streamId = payloadChunk.stream_id;
            httpRequest2.timestamp = payloadChunk.timestamp;
            httpLog.addHttpRequest(httpRequest2);
            this.mPendingRequests.add(httpRequest2);
            this.mFirstReqChunkPos = -1;
        }
    }

    public void processUpdate(ConnectionUpdate connectionUpdate) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i = connectionUpdate.update_type;
        int i2 = 0;
        if ((i & 1) != 0) {
            this.sent_bytes = connectionUpdate.sent_bytes;
            this.rcvd_bytes = connectionUpdate.rcvd_bytes;
            this.sent_pkts = connectionUpdate.sent_pkts;
            this.rcvd_pkts = connectionUpdate.rcvd_pkts;
            this.blocked_pkts = connectionUpdate.blocked_pkts;
            int i3 = connectionUpdate.status;
            int i4 = i3 & 255;
            this.status = i4;
            this.error = (16711680 & i3) >> 16;
            if ((i3 & CaptureService.CONNECTIONS_LOG_SIZE) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.port_mapping_applied = z3;
            if ((i3 & 4096) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.decryption_ignored = z4;
            if ((i3 & 2048) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.netd_block_missed = z5;
            if ((i3 & 1024) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.is_blocked = z6;
            if ((i3 & LogviewFragment.MAX_LINES) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.blacklisted_host = z7;
            if ((i3 & 256) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.blacklisted_ip = z8;
            this.last_seen = connectionUpdate.last_seen;
            this.tcp_flags = connectionUpdate.tcp_flags;
            if (i4 == 3 && this.decryption_error != null) {
                this.status = 6;
            }
            if (!this.mitm_decrypt) {
                this.payload_length = connectionUpdate.payload_length;
            }
        }
        if ((i & 2) != 0) {
            this.info = connectionUpdate.info;
            this.url = connectionUpdate.url;
            this.l7proto = connectionUpdate.l7proto;
            if ((connectionUpdate.info_flags & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.encrypted_l7 = z2;
        }
        if ((i & 4) != 0) {
            synchronized (this) {
                try {
                    if (!CaptureService.isLowMemory()) {
                        if (connectionUpdate.payload_chunks != null) {
                            if (CaptureService.getHttpLog() != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int size = this.payload_chunks.size();
                            ArrayList<PayloadChunk> arrayList = connectionUpdate.payload_chunks;
                            int size2 = arrayList.size();
                            while (i2 < size2) {
                                PayloadChunk payloadChunk = arrayList.get(i2);
                                i2++;
                                PayloadChunk payloadChunk2 = payloadChunk;
                                if (z && payloadChunk2.type == PayloadChunk.ChunkType.HTTP) {
                                    logHttpChunk(payloadChunk2, size);
                                }
                                if (payloadChunk2.type == PayloadChunk.ChunkType.WEBSOCKET) {
                                    this.has_websocket_data = true;
                                }
                                size++;
                            }
                            this.payload_chunks.addAll(connectionUpdate.payload_chunks);
                        }
                        this.payload_truncated = connectionUpdate.payload_truncated;
                        this.internal_decrypt = connectionUpdate.payload_decrypted;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void setPayloadTruncatedByAddon() {
        this.payload_truncated = true;
    }

    public String toString() {
        return "[proto=" + this.ipproto + "/" + this.l7proto + "]: " + this.src_ip + ":" + this.src_port + " -> " + this.dst_ip + ":" + this.dst_port + " [" + this.uid + "] " + this.info;
    }

    public String getDecryptionStatusLabel(Context context) {
        return getDecryptionStatusLabel(getDecryptionStatus(), context);
    }

    public String getStatusLabel(Context context) {
        return getStatusLabel(getStatus(), context);
    }
}
