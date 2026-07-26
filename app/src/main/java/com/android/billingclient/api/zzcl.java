package com.android.billingclient.api;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.SolverVariable;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.provider.FontRequestWorker;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.NestedScrollView;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.transition.Transition;
import androidx.transition.ViewUtilsApi21;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.service.zan;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjg;
import com.google.android.gms.internal.play_billing.zzji;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.snackbar.SnackbarManager;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Provider;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class zzcl implements NestedScrollView.OnScrollChangeListener, ActionMode.Callback, EmojiProcessor$EmojiProcessCallback, Preference.OnPreferenceClickListener, OnApplyWindowInsetsListener, zzch, Factory {
    public final /* synthetic */ int $r8$classId;
    public Object zzb;
    public Object zzc;

    public /* synthetic */ zzcl(int i, Object obj) {
        this.$r8$classId = i;
        this.zzc = obj;
    }

    public static int getSpanGroupIndex(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        if (i3 + 1 > i2) {
            return i4 + 1;
        }
        return i4;
    }

    public void add(Object obj, String str) {
        String valueOf = String.valueOf(obj);
        ((ArrayList) this.zzb).add(str + "=" + valueOf);
    }

    public void clear() {
        int[] iArr = (int[]) this.zzb;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.zzc = null;
    }

    public void ensureSize(int i) {
        int[] iArr = (int[]) this.zzb;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.zzb = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.zzb = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.zzb;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 20:
                return new MetadataBackendRegistry((Context) ((SnackbarManager) this.zzb).lock, (MatcherMatchResult) ((FakeDrag) this.zzc).get());
            default:
                ?? obj = new Object();
                ?? obj2 = new Object();
                SchemaManager schemaManager = (SchemaManager) ((Provider) this.zzb).get();
                return new SQLiteEventStore(obj, obj2, AutoValue_EventStoreConfig.DEFAULT, schemaManager, (Provider) this.zzc);
        }
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return (UnprecomputeTextOnModificationSpannable) this.zzb;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Spannable spannable;
        if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
            return true;
        }
        if (((UnprecomputeTextOnModificationSpannable) this.zzb) == null) {
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                spannable = new SpannableString(charSequence);
            }
            this.zzb = new UnprecomputeTextOnModificationSpannable(spannable);
        }
        ((ViewUtilsApi21) this.zzc).getClass();
        ((UnprecomputeTextOnModificationSpannable) this.zzb).setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    public void invalidateSpanIndexCache() {
        ((SparseIntArray) this.zzb).clear();
    }

    public void offsetForAddition(int i, int i2) {
        int[] iArr = (int[]) this.zzb;
        if (iArr != null && i < iArr.length) {
            int i3 = i + i2;
            ensureSize(i3);
            int[] iArr2 = (int[]) this.zzb;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill((int[]) this.zzb, i, i3, -1);
            ArrayList arrayList = (ArrayList) this.zzc;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.zzc).get(size);
                    int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
                    if (i4 >= i) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 + i2;
                    }
                }
            }
        }
    }

    public void offsetForRemoval(int i, int i2) {
        int[] iArr = (int[]) this.zzb;
        if (iArr != null && i < iArr.length) {
            int i3 = i + i2;
            ensureSize(i3);
            int[] iArr2 = (int[]) this.zzb;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = (int[]) this.zzb;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            ArrayList arrayList = (ArrayList) this.zzc;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.zzc).get(size);
                    int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            ((ArrayList) this.zzc).remove(size);
                        } else {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 - i2;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((ActionMode.Callback) this.zzb).onActionItemClicked(actionMode, menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r20, androidx.core.view.WindowInsetsCompat r21) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzcl.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return ((ActionMode.Callback) this.zzb).onCreateActionMode(actionMode, menu);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((ActionMode.Callback) this.zzb).onDestroyActionMode(actionMode);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.zzc;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
        }
        if (appCompatDelegateImpl.mActionModeView != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
            animate.alpha(0.0f);
            appCompatDelegateImpl.mFadeAnim = animate;
            animate.setListener(new AppCompatDelegateImpl.AnonymousClass7(2, this));
        }
        appCompatDelegateImpl.mAppCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl.mActionMode);
        appCompatDelegateImpl.mActionMode = null;
        ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        appCompatDelegateImpl.updateBackInvokedCallbackState();
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        ((PreferenceGroup) this.zzb).mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        PreferenceGroupAdapter preferenceGroupAdapter = (PreferenceGroupAdapter) this.zzc;
        Handler handler = preferenceGroupAdapter.mHandler;
        PreferenceGroup.AnonymousClass1 r2 = preferenceGroupAdapter.mSyncRunnable;
        handler.removeCallbacks(r2);
        handler.post(r2);
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewGroup viewGroup = ((AppCompatDelegateImpl) this.zzc).mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        return ((ActionMode.Callback) this.zzb).onPrepareActionMode(actionMode, menu);
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        Handler handler = (Handler) this.zzc;
        FakeDrag fakeDrag = (FakeDrag) this.zzb;
        int i = typefaceResult.mResult;
        if (i == 0) {
            handler.post(new zzi(fakeDrag, 4, typefaceResult.mTypeface));
        } else {
            handler.post(new CallbackWithHandler$2(i, 0, fakeDrag));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0209, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0109 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2 {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks: (B:19:0x0062, B:27:0x0074, B:28:0x0082, B:30:0x0087, B:37:0x0097, B:40:0x00a0, B:43:0x00a9, B:45:0x00b1, B:46:0x00bf, B:49:0x00ce, B:51:0x00d6, B:52:0x00e0, B:55:0x00e9, B:57:0x00f1, B:58:0x00ff, B:61:0x0109, B:62:0x0110, B:63:0x0128, B:64:0x0129, B:66:0x0131, B:67:0x013f, B:70:0x0149, B:71:0x0154, B:72:0x016c, B:73:0x016d, B:76:0x0177, B:77:0x0182, B:78:0x019a, B:79:0x019b, B:81:0x01a3, B:82:0x01ac, B:85:0x01b6, B:86:0x01c0, B:87:0x01d8, B:88:0x01d9, B:91:0x01e3, B:92:0x01ed, B:93:0x0205, B:94:0x0206, B:95:0x0209), top: B:102:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseConstraintSet(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzcl.parseConstraintSet(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void setShadowPadding(int i, int i2, int i3, int i4) {
        CardView cardView = (CardView) this.zzc;
        cardView.mShadowBounds.set(i, i2, i3, i4);
        Rect rect = cardView.mContentPadding;
        CardView.access$001(cardView, i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                String str = "[ ";
                if (((SolverVariable) this.zzb) != null) {
                    for (int i = 0; i < 9; i++) {
                        str = str + ((SolverVariable) this.zzb).mGoalStrengthVector[i] + " ";
                    }
                }
                return str + "] " + ((SolverVariable) this.zzb);
            case 9:
                return "Bounds{lower=" + ((Insets) this.zzb) + " upper=" + ((Insets) this.zzc) + "}";
            case 26:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.zzc.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.zzb;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append((String) arrayList.get(i2));
                    if (i2 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zah(boolean r5, com.google.android.gms.common.api.Status r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzb
            java.util.Map r0 = (java.util.Map) r0
            monitor-enter(r0)
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L84
            java.lang.Object r2 = r4.zzb     // Catch: java.lang.Throwable -> L84
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L84
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L84
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r0 = r4.zzc
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2
            monitor-enter(r2)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = r4.zzc     // Catch: java.lang.Throwable -> L81
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> L81
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L81
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L81
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L27:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L4f
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            if (r5 != 0) goto L42
            java.lang.Object r3 = r2.getValue()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L42
            goto L27
        L42:
            java.lang.Object r5 = r2.getKey()
            r5.getClass()
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L4f:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L57:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L80
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r5 != 0) goto L71
            java.lang.Object r2 = r1.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L57
        L71:
            java.lang.Object r1 = r1.getKey()
            com.google.android.gms.tasks.TaskCompletionSource r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1
            com.google.android.gms.common.api.ApiException r2 = new com.google.android.gms.common.api.ApiException
            r2.<init>(r6)
            r1.trySetException(r2)
            goto L57
        L80:
            return
        L81:
            r5 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L81
            throw r5
        L84:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzcl.zah(boolean, com.google.android.gms.common.api.Status):void");
    }

    public void zza(zzhx zzhxVar) {
        try {
            zzl(zzhxVar, (zzis) this.zzb);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zzc(zzhx zzhxVar, int i, long j) {
        try {
            zziq zziqVar = (zziq) ((zzis) this.zzb).zzm();
            zziqVar.zzi();
            zzis.zzC((zzis) zziqVar.zza, i);
            zzis zzisVar = (zzis) zziqVar.zze();
            this.zzb = zzisVar;
            if (j != 0) {
                zziq zziqVar2 = (zziq) zzisVar.zzm();
                zziqVar2.zzi();
                zzis.zzE((zzis) zziqVar2.zza, j);
                zzisVar = (zzis) zziqVar2.zze();
            }
            zzl(zzhxVar, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zzd(zzhx zzhxVar, long j, boolean z) {
        zzis zzisVar;
        try {
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zzi();
            zzjf.zzA((zzjf) zzjaVar.zza, z);
            zzhvVar.zzi();
            zzhx.zzF((zzhx) zzhvVar.zza, (zzjf) zzjaVar.zze());
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j == 0) {
                zzisVar = (zzis) this.zzb;
            } else {
                zziq zziqVar = (zziq) ((zzis) this.zzb).zzm();
                zziqVar.zzi();
                zzis.zzE((zzis) zziqVar.zza, j);
                zzisVar = (zzis) zziqVar.zze();
            }
            zzl(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zze(zzhx zzhxVar, int i, long j, boolean z) {
        zzis zzisVar;
        try {
            zziq zziqVar = (zziq) ((zzis) this.zzb).zzm();
            zziqVar.zzi();
            zzis.zzC((zzis) zziqVar.zza, i);
            this.zzb = (zzis) zziqVar.zze();
            zzhv zzhvVar = (zzhv) zzhxVar.zzm();
            zzja zzjaVar = (zzja) zzhxVar.zzB().zzm();
            zzjaVar.zzi();
            zzjf.zzA((zzjf) zzjaVar.zza, z);
            zzhvVar.zzi();
            zzhx.zzF((zzhx) zzhvVar.zza, (zzjf) zzjaVar.zze());
            zzhx zzhxVar2 = (zzhx) zzhvVar.zze();
            if (j == 0) {
                zzisVar = (zzis) this.zzb;
            } else {
                zziq zziqVar2 = (zziq) ((zzis) this.zzb).zzm();
                zziqVar2.zzi();
                zzis.zzE((zzis) zziqVar2.zza, j);
                zzisVar = (zzis) zziqVar2.zze();
            }
            zzl(zzhxVar2, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zzi(zzij zzijVar) {
        try {
            zzjg zzc = zzji.zzc();
            zzc.zzn((zzis) this.zzb);
            zzc.zzi();
            zzji.zzC((zzji) zzc.zza, zzijVar);
            ((zzcn) this.zzc).zza((zzji) zzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zzj(zzjo zzjoVar) {
        try {
            zzjg zzc = zzji.zzc();
            zzc.zzn((zzis) this.zzb);
            zzc.zzi();
            zzji.zzE((zzji) zzc.zza, zzjoVar);
            ((zzcn) this.zzc).zza((zzji) zzc.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    public void zzk(zzjs zzjsVar) {
        if (zzjsVar != null) {
            try {
                zzjg zzc = zzji.zzc();
                zzc.zzn((zzis) this.zzb);
                zzc.zzi();
                zzji.zzF((zzji) zzc.zza, zzjsVar);
                ((zzcn) this.zzc).zza((zzji) zzc.zze());
            } catch (Throwable th) {
                zzc.zzo("BillingLogger", "Unable to log.", th);
            }
        }
    }

    public void zzl(zzhx zzhxVar, zzis zzisVar) {
        if (zzhxVar != null) {
            try {
                zzjg zzc = zzji.zzc();
                zzc.zzn(zzisVar);
                zzc.zzi();
                zzji.zzA((zzji) zzc.zza, zzhxVar);
                ((zzcn) this.zzc).zza((zzji) zzc.zze());
            } catch (Throwable th) {
                zzc.zzo("BillingLogger", "Unable to log.", th);
            }
        }
    }

    public void zzm(zzib zzibVar, zzis zzisVar) {
        if (zzibVar != null) {
            try {
                zzjg zzc = zzji.zzc();
                zzc.zzn(zzisVar);
                zzc.zzi();
                zzji.zzB((zzji) zzc.zza, zzibVar);
                ((zzcn) this.zzc).zza((zzji) zzc.zze());
            } catch (Throwable th) {
                zzc.zzo("BillingLogger", "Unable to log.", th);
            }
        }
    }

    public /* synthetic */ zzcl(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.zzc = obj;
        this.zzb = obj2;
    }

    public /* synthetic */ zzcl(int i, boolean z) {
        this.$r8$classId = i;
    }

    public /* synthetic */ zzcl(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zzc = obj2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.android.billingclient.api.zzcn] */
    public zzcl(Context context, zzis zzisVar) {
        MatcherMatchResult newFactory;
        Encoding encoding;
        Transition.AnonymousClass1 r3;
        Set set;
        this.$r8$classId = 0;
        ?? obj = new Object();
        try {
            TransportRuntime.initialize(context);
            newFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
            encoding = new Encoding("proto");
            r3 = new Transition.AnonymousClass1(15);
            set = (Set) newFactory.matcher;
        } catch (Throwable unused) {
            obj.zza = true;
        }
        if (set.contains(encoding)) {
            obj.zzb = new MatcherMatchResult((AutoValue_TransportContext) newFactory.input, encoding, r3, (TransportRuntime) newFactory.groups);
            this.zzc = obj;
            this.zzb = zzisVar;
            return;
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory get(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzcl.get(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public zzcl(zan zanVar, Transition.AnonymousClass1 r2) {
        this.$r8$classId = 22;
        this.zzc = "ClientTelemetry.API";
        this.zzb = zanVar;
    }

    public /* synthetic */ zzcl(Object obj) {
        this.$r8$classId = 26;
        this.zzc = obj;
        this.zzb = new ArrayList();
    }

    public zzcl(Context context) {
        this.$r8$classId = 19;
        this.zzc = null;
        this.zzb = context;
    }

    public zzcl(ArrayList arrayList, ArrayList arrayList2) {
        this.$r8$classId = 7;
        int size = arrayList.size();
        this.zzb = new int[size];
        this.zzc = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.zzb)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.zzc)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public zzcl(int i, int i2) {
        this.$r8$classId = 7;
        this.zzb = new int[]{i, i2};
        this.zzc = new float[]{0.0f, 1.0f};
    }

    public zzcl(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 14:
                this.zzb = new SparseIntArray();
                this.zzc = new SparseIntArray();
                return;
            case 24:
                this.zzb = DesugarCollections.synchronizedMap(new WeakHashMap());
                this.zzc = DesugarCollections.synchronizedMap(new WeakHashMap());
                return;
            case 27:
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
                this.zzb = new SparseIntArray();
                this.zzc = googleApiAvailability;
                return;
            case 28:
                this.zzb = new Rect();
                this.zzc = new Rect();
                return;
            default:
                this.zzb = Choreographer.getInstance();
                this.zzc = Looper.myLooper();
                return;
        }
    }

    public zzcl(int i, int i2, int i3) {
        this.$r8$classId = 7;
        this.zzb = new int[]{i, i2, i3};
        this.zzc = new float[]{0.0f, 0.5f, 1.0f};
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.text.Editable$Factory, androidx.emoji2.viewsintegration.EmojiEditableFactory] */
    public zzcl(EditText editText) {
        this.$r8$classId = 12;
        this.zzb = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.zzc = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        if (EmojiEditableFactory.sInstance == null) {
            synchronized (EmojiEditableFactory.INSTANCE_LOCK) {
                try {
                    if (EmojiEditableFactory.sInstance == null) {
                        ?? factory = new Editable.Factory();
                        try {
                            EmojiEditableFactory.sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        EmojiEditableFactory.sInstance = factory;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(EmojiEditableFactory.sInstance);
    }

    public zzcl(ViewPager viewPager) {
        this.$r8$classId = 16;
        this.zzc = viewPager;
        this.zzb = new Rect();
    }
}
