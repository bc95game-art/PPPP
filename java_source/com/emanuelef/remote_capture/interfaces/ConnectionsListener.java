package com.emanuelef.remote_capture.interfaces;

import com.emanuelef.remote_capture.model.ConnectionDescriptor;
/* loaded from: classes.dex */
public interface ConnectionsListener {
    void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr);

    void connectionsChanges(int i);

    void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr);

    void connectionsUpdated(int[] iArr);
}
