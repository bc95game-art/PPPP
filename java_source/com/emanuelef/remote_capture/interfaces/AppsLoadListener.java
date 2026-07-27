package com.emanuelef.remote_capture.interfaces;

import com.emanuelef.remote_capture.model.AppDescriptor;
import java.util.List;
/* loaded from: classes.dex */
public interface AppsLoadListener {
    void onAppsInfoLoaded(List<AppDescriptor> list);
}
