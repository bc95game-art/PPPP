package com.emanuelef.remote_capture;

import android.content.Context;
import android.util.Base64;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.google.gson.FormattingStyle;
import com.google.gson.stream.JsonWriter;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class HarWriter {
    private static final String TAG = "HarWriter";
    private final Context mContext;
    private final List<HttpLog.HttpRequest> mRequests;

    public HarWriter(Context context, List<HttpLog.HttpRequest> list) {
        this.mContext = context;
        this.mRequests = list;
    }

    private byte[] extractBody(byte[] bArr) {
        int endOfHTTPHeaders = Utils.getEndOfHTTPHeaders(bArr);
        if (endOfHTTPHeaders <= 0 || endOfHTTPHeaders >= bArr.length) {
            return null;
        }
        int length = bArr.length - endOfHTTPHeaders;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, endOfHTTPHeaders, bArr2, 0, length);
        return bArr2;
    }

    private String getHeaderValue(List<String[]> list, String str) {
        for (String[] strArr : list) {
            if (strArr[0].equalsIgnoreCase(str)) {
                return strArr[1];
            }
        }
        return null;
    }

    private int getHeadersSize(byte[] bArr) {
        int endOfHTTPHeaders = Utils.getEndOfHTTPHeaders(bArr);
        if (endOfHTTPHeaders > 0) {
            return endOfHTTPHeaders;
        }
        return -1;
    }

    private boolean isTextContent(byte[] bArr, String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("text/") || lowerCase.contains("json") || lowerCase.contains("xml") || lowerCase.contains("javascript") || lowerCase.contains("html")) {
                return true;
            }
            if (lowerCase.startsWith("image/") || lowerCase.startsWith("audio/") || lowerCase.startsWith("video/") || lowerCase.equals("application/octet-stream")) {
                return false;
            }
        }
        int min = Math.min(bArr.length, 16);
        for (int i = 0; i < min; i++) {
            if (!Utils.isPrintable(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void lambda$writeWebSocketMessages$0(ArrayList arrayList, PayloadChunk payloadChunk) {
        if (payloadChunk.type == PayloadChunk.ChunkType.WEBSOCKET && !WebSocketDecoder.isControlOpcode(payloadChunk.wsOpcode)) {
            arrayList.add(payloadChunk);
        }
    }

    private List<String[]> parseHeaders(String str) {
        ArrayList arrayList = new ArrayList();
        int endOfHTTPHeaders = Utils.getEndOfHTTPHeaders(str.getBytes(StandardCharsets.UTF_8));
        if (endOfHTTPHeaders == 0) {
            endOfHTTPHeaders = str.length();
        }
        String[] split = str.substring(0, Math.min(endOfHTTPHeaders, str.length())).split("\r\n");
        for (int i = 1; i < split.length; i++) {
            int indexOf = split[i].indexOf(58);
            if (indexOf > 0) {
                arrayList.add(new String[]{split[i].substring(0, indexOf), split[i].substring(indexOf + 1).trim()});
            }
        }
        return arrayList;
    }

    private void writeContent(JsonWriter jsonWriter, HttpLog.HttpReply httpReply, PayloadChunk payloadChunk) {
        byte[] bArr;
        byte[] extractBody;
        jsonWriter.beginObject();
        jsonWriter.name("size");
        jsonWriter.value(httpReply.bodyLength);
        String str = httpReply.contentType;
        if (str == null) {
            str = "application/octet-stream";
        }
        jsonWriter.name("mimeType");
        jsonWriter.value(str);
        if (!(payloadChunk == null || (bArr = payloadChunk.payload) == null || (extractBody = extractBody(bArr)) == null || extractBody.length <= 0)) {
            if (isTextContent(extractBody, httpReply.contentType)) {
                jsonWriter.name("text");
                jsonWriter.value(new String(extractBody, StandardCharsets.UTF_8));
            } else {
                jsonWriter.name("text");
                jsonWriter.value(Base64.encodeToString(extractBody, 2));
                jsonWriter.name("encoding");
                jsonWriter.value("base64");
            }
        }
        jsonWriter.endObject();
    }

    private void writeCreator(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("name");
        jsonWriter.value(MainActivity.TELEGRAM_GROUP_NAME);
        jsonWriter.name("version");
        jsonWriter.value(Utils.getAppVersion(this.mContext));
        jsonWriter.endObject();
    }

    private void writeEntries(JsonWriter jsonWriter) {
        jsonWriter.beginArray();
        for (int i = 0; i < this.mRequests.size(); i++) {
            if (!Thread.interrupted()) {
                HttpLog.HttpRequest httpRequest = this.mRequests.get(i);
                if (httpRequest != null) {
                    try {
                        writeEntry(jsonWriter, httpRequest);
                    } catch (Exception e) {
                        StringBuilder m = ViewModelProvider.Factory.CC.m598m("Failed to serialize entry ", i, ": ");
                        m.append(e.getMessage());
                        Log.m581w(TAG, m.toString());
                        e.printStackTrace();
                    }
                }
            } else {
                throw new InterruptedIOException("Export cancelled");
            }
        }
        jsonWriter.endArray();
    }

    private void writeEntry(JsonWriter jsonWriter, HttpLog.HttpRequest httpRequest) {
        long j;
        PayloadChunk httpResponseChunk;
        ConnectionDescriptor connectionDescriptor = httpRequest.conn;
        jsonWriter.beginObject();
        jsonWriter.name("startedDateTime");
        jsonWriter.value(Utils.formatMillisIso8601(this.mContext, httpRequest.timestamp));
        HttpLog.HttpReply httpReply = httpRequest.reply;
        if (httpReply == null || (httpResponseChunk = connectionDescriptor.getHttpResponseChunk(httpReply.firstChunkPos)) == null) {
            j = -1;
        } else {
            j = httpResponseChunk.timestamp - httpRequest.timestamp;
        }
        jsonWriter.name("time");
        jsonWriter.value(j);
        jsonWriter.name("serverIPAddress");
        jsonWriter.value(connectionDescriptor.dst_ip);
        jsonWriter.name("connection");
        jsonWriter.value(String.valueOf(connectionDescriptor.incr_id));
        jsonWriter.name("request");
        writeRequest(jsonWriter, httpRequest);
        jsonWriter.name("response");
        writeResponse(jsonWriter, httpRequest);
        jsonWriter.name("cache");
        jsonWriter.beginObject();
        jsonWriter.endObject();
        jsonWriter.name("timings");
        writeTimings(jsonWriter);
        writeWebSocketMessages(jsonWriter, connectionDescriptor, httpRequest);
        jsonWriter.endObject();
    }

    private void writeHeaders(JsonWriter jsonWriter, List<String[]> list) {
        jsonWriter.beginArray();
        for (String[] strArr : list) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            jsonWriter.value(strArr[0]);
            jsonWriter.name("value");
            jsonWriter.value(strArr[1]);
            jsonWriter.endObject();
        }
        jsonWriter.endArray();
    }

    private void writeLog(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("version");
        jsonWriter.value("1.2");
        jsonWriter.name("creator");
        writeCreator(jsonWriter);
        jsonWriter.name("entries");
        writeEntries(jsonWriter);
        jsonWriter.endObject();
    }

    private void writePostData(JsonWriter jsonWriter, PayloadChunk payloadChunk, List<String[]> list) {
        byte[] bArr;
        byte[] extractBody;
        jsonWriter.beginObject();
        String headerValue = getHeaderValue(list, "content-type");
        jsonWriter.name("mimeType");
        if (headerValue == null) {
            headerValue = "";
        }
        jsonWriter.value(headerValue);
        if (!(payloadChunk == null || (bArr = payloadChunk.payload) == null || (extractBody = extractBody(bArr)) == null || extractBody.length <= 0)) {
            jsonWriter.name("text");
            jsonWriter.value(new String(extractBody, StandardCharsets.UTF_8));
        }
        jsonWriter.name("params");
        jsonWriter.beginArray();
        jsonWriter.endArray();
        jsonWriter.endObject();
    }

    private void writeQueryString(JsonWriter jsonWriter, String str) {
        String[] split;
        String decode;
        String decode2;
        jsonWriter.beginArray();
        if (str != null && !str.isEmpty()) {
            if (str.startsWith("?")) {
                str = str.substring(1);
            }
            for (String str2 : str.split("&")) {
                int indexOf = str2.indexOf(61);
                if (indexOf > 0) {
                    try {
                        decode = URLDecoder.decode(str2.substring(0, indexOf), "UTF-8");
                        decode2 = URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8");
                    } catch (Exception unused) {
                    }
                } else {
                    decode = URLDecoder.decode(str2, "UTF-8");
                    decode2 = "";
                }
                jsonWriter.beginObject();
                jsonWriter.name("name");
                jsonWriter.value(decode);
                jsonWriter.name("value");
                jsonWriter.value(decode2);
                jsonWriter.endObject();
            }
        }
        jsonWriter.endArray();
    }

    private void writeRequest(JsonWriter jsonWriter, HttpLog.HttpRequest httpRequest) {
        ConnectionDescriptor connectionDescriptor = httpRequest.conn;
        jsonWriter.beginObject();
        jsonWriter.name("method");
        String str = httpRequest.method;
        if (str == null) {
            str = "";
        }
        jsonWriter.value(str);
        jsonWriter.name("url");
        jsonWriter.value(httpRequest.getUrl());
        PayloadChunk httpRequestChunk = connectionDescriptor.getHttpRequestChunk(httpRequest.firstChunkPos);
        List<String[]> arrayList = new ArrayList<>();
        String str2 = "HTTP/1.1";
        int i = -1;
        if (httpRequestChunk != null) {
            if (!httpRequestChunk.httpVersion.isEmpty()) {
                str2 = httpRequestChunk.httpVersion;
            }
            byte[] bArr = httpRequestChunk.payload;
            if (bArr != null) {
                arrayList = parseHeaders(new String(bArr, StandardCharsets.UTF_8));
                i = getHeadersSize(httpRequestChunk.payload);
            }
        }
        jsonWriter.name("httpVersion");
        jsonWriter.value(str2);
        jsonWriter.name("cookies");
        writeRequestCookies(jsonWriter, arrayList);
        jsonWriter.name("headers");
        writeHeaders(jsonWriter, arrayList);
        jsonWriter.name("queryString");
        writeQueryString(jsonWriter, httpRequest.query);
        String str3 = httpRequest.method;
        if (str3 != null && (str3.equals("POST") || httpRequest.method.equals("PUT") || httpRequest.method.equals("PATCH"))) {
            jsonWriter.name("postData");
            writePostData(jsonWriter, httpRequestChunk, arrayList);
        }
        jsonWriter.name("headersSize");
        jsonWriter.value(i);
        jsonWriter.name("bodySize");
        jsonWriter.value(httpRequest.bodyLength);
        jsonWriter.endObject();
    }

    private void writeRequestCookies(JsonWriter jsonWriter, List<String[]> list) {
        jsonWriter.beginArray();
        for (String[] strArr : list) {
            if (strArr[0].equalsIgnoreCase("Cookie")) {
                for (String str : strArr[1].split(";")) {
                    String trim = str.trim();
                    int indexOf = trim.indexOf(61);
                    if (indexOf > 0) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name");
                        jsonWriter.value(trim.substring(0, indexOf));
                        jsonWriter.name("value");
                        jsonWriter.value(trim.substring(indexOf + 1));
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    private void writeResponse(JsonWriter jsonWriter, HttpLog.HttpRequest httpRequest) {
        String str;
        HttpLog.HttpReply httpReply = httpRequest.reply;
        ConnectionDescriptor connectionDescriptor = httpRequest.conn;
        jsonWriter.beginObject();
        if (httpReply == null || httpRequest.httpRst) {
            jsonWriter.name("status");
            jsonWriter.value(0L);
            jsonWriter.name("statusText");
            jsonWriter.value("");
            jsonWriter.name("httpVersion");
            jsonWriter.value("");
            jsonWriter.name("cookies");
            jsonWriter.beginArray();
            jsonWriter.endArray();
            jsonWriter.name("headers");
            jsonWriter.beginArray();
            jsonWriter.endArray();
            jsonWriter.name("content");
            jsonWriter.beginObject();
            jsonWriter.endObject();
            jsonWriter.name("redirectURL");
            jsonWriter.value("");
            jsonWriter.name("headersSize");
            jsonWriter.value(-1L);
            jsonWriter.name("bodySize");
            jsonWriter.value(-1L);
            jsonWriter.endObject();
            return;
        }
        jsonWriter.name("status");
        jsonWriter.value(httpReply.responseCode);
        jsonWriter.name("statusText");
        String str2 = httpReply.responseStatus;
        if (str2 == null) {
            str2 = "";
        }
        jsonWriter.value(str2);
        PayloadChunk httpResponseChunk = connectionDescriptor.getHttpResponseChunk(httpReply.firstChunkPos);
        List<String[]> arrayList = new ArrayList<>();
        String str3 = "HTTP/1.1";
        int i = -1;
        if (httpResponseChunk != null) {
            if (!httpResponseChunk.httpVersion.isEmpty()) {
                str3 = httpResponseChunk.httpVersion;
            }
            byte[] bArr = httpResponseChunk.payload;
            if (bArr != null) {
                arrayList = parseHeaders(new String(bArr, StandardCharsets.UTF_8));
                i = getHeadersSize(httpResponseChunk.payload);
            }
        }
        jsonWriter.name("httpVersion");
        jsonWriter.value(str3);
        jsonWriter.name("cookies");
        writeResponseCookies(jsonWriter, arrayList);
        jsonWriter.name("headers");
        writeHeaders(jsonWriter, arrayList);
        jsonWriter.name("content");
        writeContent(jsonWriter, httpReply, httpResponseChunk);
        String headerValue = getHeaderValue(arrayList, "location");
        jsonWriter.name("redirectURL");
        if (headerValue != null) {
            str = headerValue;
        } else {
            str = "";
        }
        jsonWriter.value(str);
        jsonWriter.name("headersSize");
        jsonWriter.value(i);
        jsonWriter.name("bodySize");
        jsonWriter.value(httpReply.bodyLength);
        jsonWriter.endObject();
    }

    private void writeResponseCookies(JsonWriter jsonWriter, List<String[]> list) {
        int indexOf;
        String httpDateToIso8601;
        jsonWriter.beginArray();
        for (String[] strArr : list) {
            boolean z = false;
            if (strArr[0].equalsIgnoreCase("Set-Cookie")) {
                String[] split = strArr[1].split(";");
                if (split.length > 0 && (indexOf = split[0].indexOf(61)) > 0) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name");
                    jsonWriter.value(split[0].substring(0, indexOf).trim());
                    jsonWriter.name("value");
                    jsonWriter.value(split[0].substring(indexOf + 1).trim());
                    String str = "/";
                    String str2 = "";
                    String str3 = null;
                    String str4 = null;
                    boolean z2 = false;
                    for (int i = 1; i < split.length; i++) {
                        String trim = split[i].trim();
                        String lowerCase = trim.toLowerCase();
                        if (lowerCase.startsWith("path=")) {
                            str = trim.substring(5);
                        } else if (lowerCase.startsWith("domain=")) {
                            str2 = trim.substring(7);
                        } else if (lowerCase.equals("httponly")) {
                            z = true;
                        } else if (lowerCase.equals("secure")) {
                            z2 = true;
                        } else if (lowerCase.startsWith("samesite=")) {
                            str3 = trim.substring(9);
                        } else if (lowerCase.startsWith("expires=")) {
                            str4 = trim.substring(8);
                        }
                    }
                    jsonWriter.name("path");
                    jsonWriter.value(str);
                    jsonWriter.name("domain");
                    jsonWriter.value(str2);
                    jsonWriter.name("httpOnly");
                    jsonWriter.value(z);
                    jsonWriter.name("secure");
                    jsonWriter.value(z2);
                    if (str3 != null) {
                        jsonWriter.name("sameSite");
                        jsonWriter.value(str3);
                    }
                    if (!(str4 == null || (httpDateToIso8601 = Utils.httpDateToIso8601(str4)) == null)) {
                        jsonWriter.name("expires");
                        jsonWriter.value(httpDateToIso8601);
                    }
                    jsonWriter.endObject();
                }
            }
        }
        jsonWriter.endArray();
    }

    private void writeTimings(JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        jsonWriter.name("send");
        jsonWriter.value(-1L);
        jsonWriter.name("wait");
        jsonWriter.value(-1L);
        jsonWriter.name("receive");
        jsonWriter.value(-1L);
        jsonWriter.name("blocked");
        jsonWriter.value(-1L);
        jsonWriter.name("dns");
        jsonWriter.value(-1L);
        jsonWriter.name("connect");
        jsonWriter.value(-1L);
        jsonWriter.name("ssl");
        jsonWriter.value(-1L);
        jsonWriter.endObject();
    }

    private void writeWebSocketMessages(JsonWriter jsonWriter, ConnectionDescriptor connectionDescriptor, HttpLog.HttpRequest httpRequest) {
        ArrayList arrayList;
        String str;
        if (httpRequest.reply != null && httpRequest.hasWebsocketData()) {
            if (CaptureService.isReadingFromPcapFile()) {
                arrayList = new ArrayList();
                PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda4 = new PlayBilling$$ExternalSyntheticLambda4(3, arrayList);
                HTTPReassembly hTTPReassembly = new HTTPReassembly(true, playBilling$$ExternalSyntheticLambda4);
                HTTPReassembly hTTPReassembly2 = new HTTPReassembly(true, playBilling$$ExternalSyntheticLambda4);
                synchronized (connectionDescriptor) {
                    for (int i = httpRequest.firstChunkPos; i < connectionDescriptor.getNumPayloadChunks(); i++) {
                        try {
                            PayloadChunk payloadChunk = connectionDescriptor.getPayloadChunk(i);
                            if (!(payloadChunk == null || payloadChunk.type == PayloadChunk.ChunkType.RAW)) {
                                if (payloadChunk.is_sent) {
                                    hTTPReassembly.handleChunk(payloadChunk);
                                } else {
                                    hTTPReassembly2.handleChunk(payloadChunk);
                                }
                            }
                        } finally {
                        }
                    }
                }
            } else {
                arrayList = new ArrayList();
                synchronized (connectionDescriptor) {
                    for (int i2 = httpRequest.reply.firstChunkPos + 1; i2 < connectionDescriptor.getNumPayloadChunks(); i2++) {
                        try {
                            PayloadChunk payloadChunk2 = connectionDescriptor.getPayloadChunk(i2);
                            if (payloadChunk2 != null && payloadChunk2.type == PayloadChunk.ChunkType.WEBSOCKET) {
                                arrayList.add(payloadChunk2);
                            }
                        } finally {
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                jsonWriter.name("_resourceType");
                jsonWriter.value("websocket");
                jsonWriter.name("_webSocketMessages");
                jsonWriter.beginArray();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    PayloadChunk payloadChunk3 = (PayloadChunk) obj;
                    jsonWriter.beginObject();
                    jsonWriter.name("type");
                    if (payloadChunk3.is_sent) {
                        str = "send";
                    } else {
                        str = "receive";
                    }
                    jsonWriter.value(str);
                    jsonWriter.name("time");
                    jsonWriter.value(payloadChunk3.timestamp / 1000.0d);
                    int i4 = payloadChunk3.wsOpcode;
                    if (i4 <= 0) {
                        byte[] bArr = payloadChunk3.payload;
                        if (bArr == null || bArr.length == 0 || isTextContent(bArr, null)) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                    }
                    jsonWriter.name("opcode");
                    jsonWriter.value(i4);
                    byte[] bArr2 = payloadChunk3.payload;
                    if (bArr2 == null || bArr2.length <= 0) {
                        jsonWriter.name("data");
                        jsonWriter.value("");
                    } else if (i4 == 1) {
                        jsonWriter.name("data");
                        jsonWriter.value(new String(payloadChunk3.payload, StandardCharsets.UTF_8));
                    } else {
                        jsonWriter.name("data");
                        jsonWriter.value(Base64.encodeToString(payloadChunk3.payload, 2));
                    }
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
            }
        }
    }

    public void write(OutputStream outputStream) {
        JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        FormattingStyle formattingStyle = FormattingStyle.PRETTY;
        jsonWriter.setFormattingStyle(new FormattingStyle(formattingStyle.newline, "  ", formattingStyle.spaceAfterSeparators));
        jsonWriter.beginObject();
        jsonWriter.name("log");
        writeLog(jsonWriter);
        jsonWriter.endObject();
        jsonWriter.flush();
    }

    public HarWriter(Context context, HttpLog.HttpRequest httpRequest) {
        this.mContext = context;
        this.mRequests = Collections.singletonList(httpRequest);
    }
}
