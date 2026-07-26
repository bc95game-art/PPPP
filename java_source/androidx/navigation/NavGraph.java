package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R$styleable;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.internal.NavGraphImpl$iterator$1;
import com.android.billingclient.api.zzca;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class NavGraph extends NavDestination implements Iterable, KMappedMarker {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final zzca impl = new zzca(this);

    public NavGraph(NavGraphNavigator navGraphNavigator) {
        super(navGraphNavigator);
    }

    public final void addDestination(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        zzca zzcaVar = this.impl;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) zzcaVar.zzb;
        NavGraph navGraph = (NavGraph) zzcaVar.zza;
        NavDestinationImpl navDestinationImpl = node.impl;
        int i = navDestinationImpl.f12id;
        String str = (String) navDestinationImpl.route;
        if (i == 0 && str == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        String str2 = (String) ((NavDestination) navGraph).impl.route;
        if (str2 != null && Intrinsics.areEqual(str, str2)) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + navGraph).toString());
        } else if (i != ((NavDestination) navGraph).impl.f12id) {
            NavDestination navDestination = (NavDestination) sparseArrayCompat.get(i);
            if (navDestination != node) {
                if (node.parent == null) {
                    if (navDestination != null) {
                        navDestination.parent = null;
                    }
                    node.parent = navGraph;
                    sparseArrayCompat.put(navDestinationImpl.f12id, node);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
        } else {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + navGraph).toString());
        }
    }

    @Override // androidx.navigation.NavDestination
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavGraph) || !super.equals(obj)) {
            return false;
        }
        zzca zzcaVar = this.impl;
        int size = ((SparseArrayCompat) zzcaVar.zzb).size();
        zzca zzcaVar2 = ((NavGraph) obj).impl;
        if (!(size == ((SparseArrayCompat) zzcaVar2.zzb).size() && zzcaVar.zzd == zzcaVar2.zzd)) {
            return false;
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) zzcaVar.zzb;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        for (NavDestination navDestination : SequencesKt.asSequence(new ArrayIterator(1, sparseArrayCompat))) {
            if (!navDestination.equals(((SparseArrayCompat) zzcaVar2.zzb).get(navDestination.impl.f12id))) {
                return false;
            }
        }
        return true;
    }

    public final NavDestination findNode(int i) {
        zzca zzcaVar = this.impl;
        return zzcaVar.findNodeComprehensive$navigation_common_release(i, (NavGraph) zzcaVar.zza, null, false);
    }

    @Override // androidx.navigation.NavDestination
    public final int hashCode() {
        zzca zzcaVar = this.impl;
        int i = zzcaVar.zzd;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) zzcaVar.zzb;
        int size = sparseArrayCompat.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + sparseArrayCompat.keyAt(i2)) * 31) + ((NavDestination) sparseArrayCompat.valueAt(i2)).hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        zzca zzcaVar = this.impl;
        zzcaVar.getClass();
        return new NavGraphImpl$iterator$1(zzcaVar);
    }

    @Override // androidx.navigation.NavDestination
    public final NavDestination.DeepLinkMatch matchDeepLink(MatcherMatchResult matcherMatchResult) {
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(matcherMatchResult);
        zzca zzcaVar = this.impl;
        zzcaVar.getClass();
        return zzcaVar.matchDeepLinkComprehensive$navigation_common_release(matchDeepLink, matcherMatchResult, false, (NavGraph) zzcaVar.zza);
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(MatcherMatchResult matcherMatchResult, NavDestination navDestination) {
        return this.impl.matchDeepLinkComprehensive$navigation_common_release(super.matchDeepLink(matcherMatchResult), matcherMatchResult, true, navDestination);
    }

    @Override // androidx.navigation.NavDestination
    public final void onInflate(Context context, AttributeSet attributeSet) {
        String valueOf;
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        int resourceId = obtainAttributes.getResourceId(0, 0);
        zzca zzcaVar = this.impl;
        NavGraph navGraph = (NavGraph) zzcaVar.zza;
        if (resourceId != ((NavDestination) navGraph).impl.f12id) {
            zzcaVar.zzd = resourceId;
            zzcaVar.zzc = null;
            if (resourceId <= 16777215) {
                valueOf = String.valueOf(resourceId);
            } else {
                try {
                    valueOf = context.getResources().getResourceName(resourceId);
                    Intrinsics.checkNotNull(valueOf);
                } catch (Resources.NotFoundException unused) {
                    valueOf = String.valueOf(resourceId);
                }
            }
            zzcaVar.zzc = valueOf;
            obtainAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException(("Start destination " + resourceId + " cannot use the same id as the graph " + navGraph).toString());
    }

    @Override // androidx.navigation.NavDestination
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        zzca zzcaVar = this.impl;
        zzcaVar.getClass();
        zzcaVar.getClass();
        NavDestination findNode = findNode(zzcaVar.zzd);
        sb.append(" startDestination=");
        if (findNode == null) {
            String str = (String) zzcaVar.zzc;
            if (str != null) {
                sb.append(str);
            } else {
                sb.append("0x" + Integer.toHexString(zzcaVar.zzd));
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
