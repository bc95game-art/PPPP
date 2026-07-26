package com.emanuelef.remote_capture.fragments;

import com.emanuelef.remote_capture.model.ConnectionDescriptor;
/* loaded from: classes.dex */
public final /* synthetic */ class ConnectionsFragment$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ConnectionsFragment f$0;
    public final /* synthetic */ ConnectionDescriptor[] f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ConnectionsFragment$$ExternalSyntheticLambda2(ConnectionsFragment connectionsFragment, ConnectionDescriptor[] connectionDescriptorArr, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = connectionsFragment;
        this.f$1 = connectionDescriptorArr;
        this.f$2 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$connectionsRemoved$14(this.f$1, this.f$2);
                return;
            default:
                this.f$0.lambda$connectionsAdded$13(this.f$1, this.f$2);
                return;
        }
    }
}
