package com.emanuelef.remote_capture;

import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class HttpLog {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "HttpLog";
    private Listener mListener;
    private final ArrayList<HttpRequest> mHttpRequests = new ArrayList<>();
    private final ArrayList<HttpRequest> mPendingHttpRequests = new ArrayList<>();
    private final ArrayList<HttpReply> mPendingHttpReplies = new ArrayList<>();
    private boolean mConnUpdateInProgress = false;

    /* loaded from: classes.dex */
    public static class HttpReply {
        public String contentType;
        public final int firstChunkPos;
        public final HttpRequest request;
        public String responseStatus;
        public int responseCode = 0;
        public int bodyLength = 0;

        public HttpReply(HttpRequest httpRequest, int i) {
            this.request = httpRequest;
            this.firstChunkPos = i;
        }

        public String toString() {
            return "HTTP reply: " + this.responseCode + " " + this.responseStatus + " - " + this.contentType + " - " + this.bodyLength + " B";
        }
    }

    /* loaded from: classes.dex */
    public static class HttpRequest implements Comparable<HttpRequest> {
        public final ConnectionDescriptor conn;
        public final int firstChunkPos;
        public HttpReply reply;
        public String method = "";
        public String host = "";
        public String path = "";
        public String query = "";
        public String decryptionError = "";
        public int bodyLength = 0;
        public int streamId = 0;
        public long timestamp = 0;
        public boolean httpRst = false;
        private int idx = -1;

        public HttpRequest(ConnectionDescriptor connectionDescriptor, int i) {
            this.conn = connectionDescriptor;
            this.firstChunkPos = i;
        }

        public int getPosition() {
            return this.idx;
        }

        public String getProtoAndHost() {
            String str;
            String str2 = "";
            if (!this.host.isEmpty()) {
                str = this.host;
            } else {
                str = (String) Objects.requireNonNullElse(this.conn.info, str2);
            }
            if (this.conn.l7proto.toLowerCase().startsWith("http")) {
                if (this.conn.isCleartext()) {
                    str2 = "http://";
                } else {
                    str2 = "https://";
                }
            }
            return ViewModelProvider.Factory.CC.m(str2, str);
        }

        public String getUrl() {
            String protoAndHost = getProtoAndHost();
            String str = this.path;
            String str2 = this.query;
            return protoAndHost + str + str2;
        }

        public boolean hasWebsocketData() {
            return this.conn.hasWebsocketData();
        }

        public boolean matches(String str) {
            String lowerCase = str.toLowerCase();
            if (getUrl().toLowerCase().contains(lowerCase)) {
                return true;
            }
            HttpReply httpReply = this.reply;
            if (httpReply == null || !httpReply.contentType.toLowerCase().contains(lowerCase)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "HTTP request: " + this.method + " " + getUrl();
        }

        public int compareTo(HttpRequest httpRequest) {
            return Long.compare(this.timestamp, httpRequest.timestamp);
        }
    }

    /* loaded from: classes.dex */
    public interface Listener {
        void onHttpRequestAdded(int i);

        void onHttpRequestUpdated(int i);

        void onHttpRequestsClear();
    }

    public synchronized void addDecryptionError(ConnectionDescriptor connectionDescriptor, long j, String str) {
        HttpRequest httpRequest = new HttpRequest(connectionDescriptor, 0);
        httpRequest.timestamp = j;
        httpRequest.decryptionError = str;
        addHttpRequest(httpRequest);
    }

    public synchronized void addHttpReply(HttpReply httpReply) {
        if (this.mConnUpdateInProgress) {
            this.mPendingHttpReplies.add(httpReply);
            return;
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onHttpRequestUpdated(httpReply.request.idx);
        }
    }

    public synchronized void addHttpRequest(HttpRequest httpRequest) {
        if (this.mConnUpdateInProgress) {
            this.mPendingHttpRequests.add(httpRequest);
            return;
        }
        httpRequest.idx = this.mHttpRequests.size();
        this.mHttpRequests.add(httpRequest);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onHttpRequestAdded(httpRequest.idx);
        }
    }

    public synchronized void clear() {
        this.mHttpRequests.clear();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onHttpRequestsClear();
        }
    }

    public synchronized HttpRequest getRequest(int i) {
        if (i >= 0) {
            if (i < this.mHttpRequests.size()) {
                return this.mHttpRequests.get(i);
            }
        }
        return null;
    }

    public synchronized int getSize() {
        return this.mHttpRequests.size();
    }

    public synchronized void setListener(Listener listener) {
        this.mListener = listener;
    }

    public synchronized void startConnectionsUpdates() {
        Log.d(TAG, "startConnectionsUpdates");
        this.mConnUpdateInProgress = true;
    }

    public synchronized void stopConnectionsUpdates() {
        try {
            Log.d(TAG, "stopConnectionsUpdates");
            int i = 0;
            this.mConnUpdateInProgress = false;
            Collections.sort(this.mPendingHttpRequests);
            ArrayList<HttpRequest> arrayList = this.mPendingHttpRequests;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                HttpRequest httpRequest = arrayList.get(i2);
                i2++;
                addHttpRequest(httpRequest);
            }
            this.mPendingHttpRequests.clear();
            ArrayList<HttpReply> arrayList2 = this.mPendingHttpReplies;
            int size2 = arrayList2.size();
            while (i < size2) {
                HttpReply httpReply = arrayList2.get(i);
                i++;
                addHttpReply(httpReply);
            }
            this.mPendingHttpReplies.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
