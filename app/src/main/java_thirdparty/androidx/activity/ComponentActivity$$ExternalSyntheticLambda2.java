package androidx.activity;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.core.provider.FontRequest;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.SavedStateRegistry;
import com.android.billingclient.api.zzca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda2 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Pair[] pairArr;
        Bundle bundle;
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return ComponentActivity.m0$r8$lambda$71Q7mCYu4mmbnahJ05KgHel0((ComponentActivity) obj);
            case 1:
                FontRequest fontRequest = (FontRequest) obj;
                for (Map.Entry entry : MapsKt__MapsKt.toMap((LinkedHashMap) fontRequest.mIdentifier).entrySet()) {
                    fontRequest.set(((StateFlowImpl) ((MutableStateFlow) entry.getValue())).getValue(), (String) entry.getKey());
                }
                for (Map.Entry entry2 : MapsKt__MapsKt.toMap((LinkedHashMap) fontRequest.mProviderPackage).entrySet()) {
                    fontRequest.set(((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState(), (String) entry2.getKey());
                }
                LinkedHashMap linkedHashMap = (LinkedHashMap) fontRequest.mProviderAuthority;
                if (linkedHashMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                        arrayList.add(new Pair((String) entry3.getKey(), entry3.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                return BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            case 2:
                NavHostController navHostController = (NavHostController) obj;
                NavControllerImpl navControllerImpl = navHostController.impl;
                LinkedHashMap linkedHashMap2 = navControllerImpl.backStackStates;
                ArrayDeque arrayDeque = navControllerImpl.backQueue;
                LinkedHashMap linkedHashMap3 = navControllerImpl.backStackMap;
                ArrayList arrayList2 = new ArrayList();
                Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                for (Map.Entry entry4 : MapsKt__MapsKt.toMap(navControllerImpl._navigatorProvider._navigators).entrySet()) {
                    String str = (String) entry4.getKey();
                    Bundle onSaveState = ((Navigator) entry4.getValue()).onSaveState();
                    if (onSaveState != null) {
                        arrayList2.add(str);
                        Navigation.m24putSavedStateimpl(bundleOf, str, onSaveState);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    Navigation.m26putStringListimpl(bundleOf, "android-support-nav:controller:navigatorState:names", arrayList2);
                    Navigation.m24putSavedStateimpl(bundle, "android-support-nav:controller:navigatorState", bundleOf);
                } else {
                    bundle = null;
                }
                if (!arrayDeque.isEmpty()) {
                    if (bundle == null) {
                        bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                    Iterator<E> it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        NavBackStackEntry entry5 = (NavBackStackEntry) it.next();
                        Intrinsics.checkNotNullParameter(entry5, "entry");
                        int i2 = entry5.destination.impl.id;
                        String str2 = entry5.id;
                        NavBackStackEntryImpl navBackStackEntryImpl = entry5.impl;
                        Bundle arguments$navigation_common_release = navBackStackEntryImpl.getArguments$navigation_common_release();
                        Bundle bundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        navBackStackEntryImpl.savedStateRegistryController.performSave(bundleOf2);
                        Bundle bundleOf3 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        Navigation.m25putStringimpl(bundleOf3, "nav-entry-state:id", str2);
                        bundleOf3.putInt("nav-entry-state:destination-id", i2);
                        if (arguments$navigation_common_release == null) {
                            arguments$navigation_common_release = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        }
                        Navigation.m24putSavedStateimpl(bundleOf3, "nav-entry-state:args", arguments$navigation_common_release);
                        Navigation.m24putSavedStateimpl(bundleOf3, "nav-entry-state:saved-state", bundleOf2);
                        arrayList3.add(bundleOf3);
                    }
                    bundle.putParcelableArrayList("android-support-nav:controller:backStack", arrayList3);
                }
                if (!linkedHashMap3.isEmpty()) {
                    if (bundle == null) {
                        bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    int[] iArr = new int[linkedHashMap3.size()];
                    ArrayList arrayList4 = new ArrayList();
                    int i3 = 0;
                    for (Map.Entry entry6 : linkedHashMap3.entrySet()) {
                        int intValue = ((Number) entry6.getKey()).intValue();
                        String str3 = (String) entry6.getValue();
                        int i4 = i3 + 1;
                        iArr[i3] = intValue;
                        if (str3 == null) {
                            str3 = "";
                        }
                        arrayList4.add(str3);
                        i3 = i4;
                    }
                    bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
                    Navigation.m26putStringListimpl(bundle, "android-support-nav:controller:backStackIds", arrayList4);
                }
                if (!linkedHashMap2.isEmpty()) {
                    if (bundle == null) {
                        bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    ArrayList arrayList5 = new ArrayList();
                    for (Map.Entry entry7 : linkedHashMap2.entrySet()) {
                        String str4 = (String) entry7.getKey();
                        arrayList5.add(str4);
                        ArrayList<? extends Parcelable> arrayList6 = new ArrayList<>();
                        Iterator it2 = ((ArrayDeque) entry7.getValue()).iterator();
                        while (it2.hasNext()) {
                            zzca zzcaVar = ((NavBackStackEntryState) it2.next()).impl;
                            zzcaVar.getClass();
                            Bundle bundleOf4 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            Navigation.m25putStringimpl(bundleOf4, "nav-entry-state:id", (String) zzcaVar.zza);
                            bundleOf4.putInt("nav-entry-state:destination-id", zzcaVar.zzd);
                            Bundle bundle2 = (Bundle) zzcaVar.zzb;
                            if (bundle2 == null) {
                                bundle2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            }
                            Navigation.m24putSavedStateimpl(bundleOf4, "nav-entry-state:args", bundle2);
                            Navigation.m24putSavedStateimpl(bundleOf4, "nav-entry-state:saved-state", (Bundle) zzcaVar.zzc);
                            arrayList6.add(bundleOf4);
                        }
                        String key = "android-support-nav:controller:backStackStates:" + str4;
                        Intrinsics.checkNotNullParameter(key, "key");
                        bundle.putParcelableArrayList(key, arrayList6);
                    }
                    Navigation.m26putStringListimpl(bundle, "android-support-nav:controller:backStackStates", arrayList5);
                }
                if (navHostController.deepLinkHandled) {
                    if (bundle == null) {
                        bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    }
                    bundle.putBoolean("android-support-nav:controller:deepLinkHandled", navHostController.deepLinkHandled);
                }
                if (bundle != null) {
                    return bundle;
                }
                Bundle EMPTY = Bundle.EMPTY;
                Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                return EMPTY;
            default:
                int i5 = ((NavHostFragment) obj).graphId;
                if (i5 != 0) {
                    return BundleKt.bundleOf(new Pair("android-support-nav:fragment:graphId", Integer.valueOf(i5)));
                }
                Bundle bundle3 = Bundle.EMPTY;
                Intrinsics.checkNotNull(bundle3);
                return bundle3;
        }
    }
}
