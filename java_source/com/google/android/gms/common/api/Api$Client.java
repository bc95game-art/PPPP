package com.google.android.gms.common.api;

import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzs;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;
/* loaded from: classes.dex */
public interface Api$Client {
    void connect(zzs zzsVar);

    void disconnect();

    void disconnect(String str);

    Feature[] getAvailableFeatures();

    void getEndpointPackageName();

    String getLastDisconnectMessage();

    int getMinApkVersion();

    void getRemoteService(IAccountAccessor iAccountAccessor, Set set);

    Set getScopesForConnectionlessNonSignIn();

    boolean isConnected();

    boolean isConnecting();

    void onUserSignOut(FakeDrag fakeDrag);

    boolean requiresSignIn();
}
