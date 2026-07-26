package com.google.android.datatransport.runtime.firebase.transport;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class LogSourceMetrics {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final List log_event_dropped_;
    public final String log_source_;

    static {
        DesugarCollections.unmodifiableList(new ArrayList());
    }

    public LogSourceMetrics(List list, String str) {
        this.log_source_ = str;
        this.log_event_dropped_ = list;
    }
}
