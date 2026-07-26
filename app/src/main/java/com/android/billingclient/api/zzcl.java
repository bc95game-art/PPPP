package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.Choreographer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.provider.FontRequestWorker;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
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
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
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
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.snackbar.SnackbarManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Provider;
import kotlin.text.MatcherMatchResult;
import org.xmlpull.v1.XmlPullParserException;
import p004j$.util.DesugarCollections;
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
    */
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        switch (this.$r8$classId) {
            case 16:
                ViewPager viewPager = (ViewPager) this.zzc;
                WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (onApplyWindowInsets.mImpl.isConsumed()) {
                    return onApplyWindowInsets;
                }
                Rect rect = (Rect) this.zzb;
                rect.left = onApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = onApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = onApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = onApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = viewPager.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(viewPager.getChildAt(i2), onApplyWindowInsets);
                    rect.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return onApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            default:
                zzcn zzcnVar = (zzcn) this.zzb;
                ViewUtils.RelativePadding relativePadding = (ViewUtils.RelativePadding) this.zzc;
                int i3 = relativePadding.start;
                int i4 = relativePadding.end;
                int i5 = relativePadding.bottom;
                WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
                Insets insets = impl.getInsets(7);
                Insets insets2 = impl.getInsets(32);
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) zzcnVar.zzb;
                int i6 = insets.top;
                int i7 = insets.right;
                int i8 = insets.left;
                bottomSheetBehavior.insetTop = i6;
                if (view.getLayoutDirection() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                int paddingBottom = view.getPaddingBottom();
                int paddingLeft = view.getPaddingLeft();
                int paddingRight = view.getPaddingRight();
                boolean z5 = bottomSheetBehavior.paddingBottomSystemWindowInsets;
                if (z5) {
                    int systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                    bottomSheetBehavior.insetBottom = systemWindowInsetBottom;
                    paddingBottom = systemWindowInsetBottom + i5;
                }
                if (bottomSheetBehavior.paddingLeftSystemWindowInsets) {
                    if (z) {
                        i = i4;
                    } else {
                        i = i3;
                    }
                    paddingLeft = i + i8;
                }
                int i9 = paddingLeft;
                if (bottomSheetBehavior.paddingRightSystemWindowInsets) {
                    if (!z) {
                        i3 = i4;
                    }
                    paddingRight = i3 + i7;
                }
                int i10 = paddingRight;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (!bottomSheetBehavior.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams.leftMargin = i8;
                    z2 = true;
                }
                if (bottomSheetBehavior.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != i7) {
                    marginLayoutParams.rightMargin = i7;
                    z2 = true;
                }
                if (bottomSheetBehavior.marginTopSystemWindowInsets) {
                    int i11 = marginLayoutParams.topMargin;
                    int i12 = insets.top;
                    if (i11 != i12) {
                        marginLayoutParams.topMargin = i12;
                        z3 = true;
                        if (z3) {
                            view.setLayoutParams(marginLayoutParams);
                        }
                        view.setPadding(i9, view.getPaddingTop(), i10, paddingBottom);
                        z4 = zzcnVar.zza;
                        if (z4) {
                            bottomSheetBehavior.gestureInsetBottom = insets2.bottom;
                        }
                        if (!z5 || z4) {
                            bottomSheetBehavior.updatePeekHeight();
                        }
                        return windowInsetsCompat;
                    }
                }
                z3 = z2;
                if (z3) {
                }
                view.setPadding(i9, view.getPaddingTop(), i10, paddingBottom);
                z4 = zzcnVar.zza;
                if (z4) {
                }
                if (!z5) {
                }
                bottomSheetBehavior.updatePeekHeight();
                return windowInsetsCompat;
        }
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
            animate.setListener(new AppCompatDelegateImpl.C00167(2, this));
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
        PreferenceGroup.RunnableC00921 r2 = preferenceGroupAdapter.mSyncRunnable;
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
    */
    public void parseConstraintSet(Context context, XmlResourceParser xmlResourceParser) {
        int i;
        int eventType;
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlResourceParser.getAttributeName(i2);
            String attributeValue = xmlResourceParser.getAttributeValue(i2);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue.length() > 1) {
                        i = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    eventType = xmlResourceParser.getEventType();
                    constraint = null;
                } catch (IOException e) {
                    Log.e("ConstraintSet", "Error parsing XML resource", e);
                } catch (XmlPullParserException e2) {
                    Log.e("ConstraintSet", "Error parsing XML resource", e2);
                }
                while (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xmlResourceParser.getName();
                            switch (name.hashCode()) {
                                case -2025855158:
                                    if (!name.equals("Layout")) {
                                        continue;
                                    } else if (constraint != null) {
                                        constraint.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                case -1984451626:
                                    if (!name.equals("Motion")) {
                                        continue;
                                    } else if (constraint != null) {
                                        constraint.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                case -1962203927:
                                    if (name.equals("ConstraintOverride")) {
                                        constraint = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser), true);
                                        break;
                                    } else {
                                        break;
                                    }
                                case -1269513683:
                                    if (!name.equals("PropertySet")) {
                                        continue;
                                    } else if (constraint != null) {
                                        constraint.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                case -1238332596:
                                    if (!name.equals("Transform")) {
                                        continue;
                                    } else if (constraint != null) {
                                        constraint.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                case -71750448:
                                    if (name.equals("Guideline")) {
                                        constraint = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser), false);
                                        constraint.layout.mIsGuideline = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 366511058:
                                    if (!name.equals("CustomMethod")) {
                                        continue;
                                    }
                                    if (constraint == null) {
                                        ConstraintAttribute.parse(context, xmlResourceParser, constraint.mCustomConstraints);
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                case 1331510167:
                                    if (name.equals("Barrier")) {
                                        constraint = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser), false);
                                        constraint.layout.mHelperType = 1;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1791837707:
                                    if (!name.equals("CustomAttribute")) {
                                        continue;
                                    } else if (constraint == null) {
                                    }
                                    break;
                                case 1803088381:
                                    if (name.equals("Constraint")) {
                                        constraint = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser), false);
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else if (eventType == 3) {
                            String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (!lowerCase.equals("guideline")) {
                                        break;
                                    }
                                    constraintSet.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                                    constraint = null;
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        constraintSet.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                                        constraint = null;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        constraintSet.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                                        constraint = null;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2146106725:
                                    if (!lowerCase.equals("constraintset")) {
                                        break;
                                    } else {
                                        ((SparseArray) this.zzc).put(i, constraintSet);
                                        return;
                                    }
                            }
                        }
                    } else {
                        xmlResourceParser.getName();
                    }
                    eventType = xmlResourceParser.next();
                }
                ((SparseArray) this.zzc).put(i, constraintSet);
                return;
            }
        }
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
    */
    public void zah(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (((Map) this.zzb)) {
            hashMap = new HashMap((Map) this.zzb);
        }
        synchronized (((Map) this.zzc)) {
            hashMap2 = new HashMap((Map) this.zzc);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
            while (r1.hasNext()) {
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
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
        Transition.C01101 r3;
        Set set;
        this.$r8$classId = 0;
        ?? obj = new Object();
        try {
            TransportRuntime.initialize(context);
            newFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
            encoding = new Encoding("proto");
            r3 = new Transition.C01101(15);
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
    */
    public CctBackendFactory get(String str) {
        Bundle bundle;
        Map map;
        PackageManager packageManager;
        if (((Map) this.zzc) == null) {
            Context context = (Context) this.zzb;
            try {
                packageManager = context.getPackageManager();
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            if (packageManager == null) {
                Log.w("BackendRegistry", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo == null) {
                    Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                    if (bundle != null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        map = Collections.EMPTY_MAP;
                    } else {
                        HashMap hashMap = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            Object obj = bundle.get(str2);
                            if ((obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String trim = str3.trim();
                                    if (!trim.isEmpty()) {
                                        hashMap.put(trim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        map = hashMap;
                    }
                    this.zzc = map;
                }
            }
            bundle = null;
            if (bundle != null) {
            }
            this.zzc = map;
        }
        String str4 = (String) ((Map) this.zzc).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e5);
            return null;
        }
    }

    public zzcl(zan zanVar, Transition.C01101 r2) {
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
