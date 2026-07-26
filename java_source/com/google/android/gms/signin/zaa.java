package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import androidx.navigation.Navigation;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public abstract class zaa extends Navigation {
    public abstract Api$Client buildClient(Context context, Looper looper, MatcherMatchResult matcherMatchResult, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
}
