package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.appcompat.widget.SearchView;
import androidx.core.os.BundleKt;
import androidx.navigation.internal.NavDestinationImpl;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.R;
import com.google.android.gms.common.zzb;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.WindowUtils$Api30Impl;
import com.google.android.material.navigation.NavigationView;
import j$.util.Objects;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {
    public static final int[] ATTRS_ANDROID_SPINNERMODE = {16843505};
    public int mDropDownWidth;
    public final AnonymousClass1 mForwardingListener;
    public final SpinnerPopup mPopup;
    public final Context mPopupContext;
    public final boolean mPopupSet;
    public SpinnerAdapter mTempAdapter;
    public final Rect mTempRect = new Rect();
    public final NavDestinationImpl mBackgroundTintHelper = new NavDestinationImpl(this);

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass2(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Activity activity;
            Rect rect;
            boolean z5;
            boolean z6;
            boolean z7;
            int i;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) this.this$0;
                    if (!appCompatSpinner.getInternalPopup().isShowing()) {
                        appCompatSpinner.mPopup.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                    }
                    ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                        return;
                    }
                    return;
                case 1:
                    CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.this$0;
                    ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
                    if (cascadingMenuPopup.isShowing() && arrayList.size() > 0) {
                        int i2 = 0;
                        if (!((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(0)).window.mModal) {
                            View view = cascadingMenuPopup.mShownAnchorView;
                            if (view == null || !view.isShown()) {
                                cascadingMenuPopup.dismiss();
                                return;
                            }
                            int size = arrayList.size();
                            while (i2 < size) {
                                Object obj = arrayList.get(i2);
                                i2++;
                                ((CascadingMenuPopup.CascadingMenuInfo) obj).window.show();
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    StandardMenuPopup standardMenuPopup = (StandardMenuPopup) this.this$0;
                    MenuPopupWindow menuPopupWindow = standardMenuPopup.mPopup;
                    if (standardMenuPopup.isShowing() && !menuPopupWindow.mModal) {
                        View view2 = standardMenuPopup.mShownAnchorView;
                        if (view2 == null || !view2.isShown()) {
                            standardMenuPopup.dismiss();
                            return;
                        } else {
                            menuPopupWindow.show();
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    DropdownPopup dropdownPopup = (DropdownPopup) this.this$0;
                    AppCompatSpinner appCompatSpinner2 = AppCompatSpinner.this;
                    dropdownPopup.getClass();
                    if (!appCompatSpinner2.isAttachedToWindow() || !appCompatSpinner2.getGlobalVisibleRect(dropdownPopup.mVisibleRect)) {
                        dropdownPopup.dismiss();
                        return;
                    }
                    dropdownPopup.computeContentWidth();
                    dropdownPopup.show();
                    return;
                default:
                    NavigationView navigationView = (NavigationView) this.this$0;
                    int[] iArr = navigationView.tmpLocation;
                    navigationView.getLocationOnScreen(iArr);
                    boolean z8 = true;
                    if (iArr[1] == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    NavigationMenuPresenter navigationMenuPresenter = navigationView.presenter;
                    if (navigationMenuPresenter.isBehindStatusBar != z) {
                        navigationMenuPresenter.isBehindStatusBar = z;
                        if (navigationMenuPresenter.headerLayout.getChildCount() <= 0 && navigationMenuPresenter.isBehindStatusBar) {
                            i = navigationMenuPresenter.paddingTopDefault;
                        } else {
                            i = 0;
                        }
                        NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
                        navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
                    }
                    if (!z || !navigationView.topInsetScrimEnabled) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    navigationView.setDrawTopInsetForeground(z2);
                    if (navigationView.getLayoutDirection() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i3 = iArr[0];
                    if ((i3 == 0 || navigationView.getWidth() + i3 == 0) && (!z3 ? navigationView.startInsetScrimEnabled : navigationView.endInsetScrimEnabled)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    navigationView.setDrawLeftInsetForeground(z4);
                    Context context = navigationView.getContext();
                    while (true) {
                        if (!(context instanceof ContextWrapper)) {
                            activity = null;
                        } else if (context instanceof Activity) {
                            activity = (Activity) context;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    }
                    if (activity != null) {
                        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                        if (Build.VERSION.SDK_INT >= 30) {
                            rect = WindowUtils$Api30Impl.getCurrentWindowBounds(windowManager);
                        } else {
                            Display defaultDisplay = windowManager.getDefaultDisplay();
                            Point point = new Point();
                            defaultDisplay.getRealSize(point);
                            rect = new Rect();
                            rect.right = point.x;
                            rect.bottom = point.y;
                        }
                        if (rect.height() - navigationView.getHeight() == iArr[1]) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (!z5 || !z6 || !navigationView.bottomInsetScrimEnabled) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        navigationView.setDrawBottomInsetForeground(z7);
                        if (!(rect.width() == iArr[0] || rect.width() - navigationView.getWidth() == iArr[0]) || (!z3 ? !navigationView.endInsetScrimEnabled : !navigationView.startInsetScrimEnabled)) {
                            z8 = false;
                        }
                        navigationView.setDrawRightInsetForeground(z8);
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api23Impl {
        public static void setDropDownViewTheme(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        public DropDownAdapter mListAdapter;
        public AlertDialog mPopup;
        public CharSequence mPrompt;

        public DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void dismiss() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.mPopup = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final boolean isShowing() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, i, this.mListAdapter.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            this.mListAdapter = (DropDownAdapter) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mPrompt = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setVerticalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int i, int i2) {
            if (this.mListAdapter != null) {
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                zzbv zzbvVar = new zzbv(appCompatSpinner.getPopupContext());
                AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
                CharSequence charSequence = this.mPrompt;
                if (charSequence != null) {
                    alertParams.mTitle = charSequence;
                }
                DropDownAdapter dropDownAdapter = this.mListAdapter;
                int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
                alertParams.mAdapter = dropDownAdapter;
                alertParams.mOnClickListener = this;
                alertParams.mCheckedItem = selectedItemPosition;
                alertParams.mIsSingleChoice = true;
                AlertDialog create = zzbvVar.create();
                this.mPopup = create;
                AlertController.RecycleListView recycleListView = create.mAlert.mListView;
                recycleListView.setTextDirection(i);
                recycleListView.setTextAlignment(i2);
                this.mPopup.show();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        public final SpinnerAdapter mAdapter;
        public final ListAdapter mListAdapter;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                Api23Impl.setDropDownViewTheme((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null || !spinnerAdapter.hasStableIds()) {
                return false;
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        public DropDownAdapter mAdapter;
        public CharSequence mHintText;
        public int mOriginalHorizontalOffset;
        public final Rect mVisibleRect = new Rect();

        public DropdownPopup(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, R.attr.spinnerStyle, 0);
            this.mDropDownAnchorView = AppCompatSpinner.this;
            this.mModal = true;
            this.mPopup.setFocusable(true);
            this.mItemClickListener = new SearchView.AnonymousClass8(1, this);
        }

        public final void computeContentWidth() {
            int i;
            int i2;
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            Rect rect = appCompatSpinner.mTempRect;
            AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
            Drawable background = appCompatPopupWindow.getBackground();
            if (background != null) {
                background.getPadding(rect);
                boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
                if (appCompatSpinner.getLayoutDirection() == 1) {
                    i = rect.right;
                } else {
                    i = -rect.left;
                }
            } else {
                i = 0;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i3 = appCompatSpinner.mDropDownWidth;
            if (i3 == -2) {
                int compatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth(this.mAdapter, appCompatPopupWindow.getBackground());
                int i4 = (appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
                if (compatMeasureContentWidth > i4) {
                    compatMeasureContentWidth = i4;
                }
                setContentWidth(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i3);
            }
            boolean z2 = ViewUtils.sInitComputeFitSystemWindowsMethod;
            if (appCompatSpinner.getLayoutDirection() == 1) {
                i2 = (((width - paddingRight) - this.mDropDownWidth) - this.mOriginalHorizontalOffset) + i;
            } else {
                i2 = paddingLeft + this.mOriginalHorizontalOffset + i;
            }
            this.mDropDownHorizontalOffset = i2;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = (DropDownAdapter) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int i) {
            this.mOriginalHorizontalOffset = i;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
            boolean isShowing = appCompatPopupWindow.isShowing();
            computeContentWidth();
            appCompatPopupWindow.setInputMethodMode(2);
            show();
            DropDownListView dropDownListView = this.mDropDownList;
            dropDownListView.setChoiceMode(1);
            dropDownListView.setTextDirection(i);
            dropDownListView.setTextAlignment(i2);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            DropDownListView dropDownListView2 = this.mDropDownList;
            if (appCompatPopupWindow.isShowing() && dropDownListView2 != null) {
                dropDownListView2.setListSelectionHidden(false);
                dropDownListView2.setSelection(selectedItemPosition);
                if (dropDownListView2.getChoiceMode() != 0) {
                    dropDownListView2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing && (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) != null) {
                final AnonymousClass2 r7 = new AnonymousClass2(3, this);
                viewTreeObserver.addOnGlobalLayoutListener(r7);
                appCompatPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver2 != null) {
                            viewTreeObserver2.removeGlobalOnLayoutListener(r7);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(4);
        public boolean mShowDropdown;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes.dex */
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setHorizontalOriginalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show(int i, int i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
        if (r7 == null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.appcompat.widget.AppCompatSpinner$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130969753(0x7f040499, float:1.7548197E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.mTempRect = r1
            android.content.Context r1 = r12.getContext()
            androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(r1, r12)
            int[] r1 = androidx.appcompat.R$styleable.Spinner
            kotlin.text.MatcherMatchResult r2 = kotlin.text.MatcherMatchResult.obtainStyledAttributes(r13, r14, r1, r0)
            java.lang.Object r3 = r2.input
            android.content.res.TypedArray r3 = (android.content.res.TypedArray) r3
            androidx.navigation.internal.NavDestinationImpl r4 = new androidx.navigation.internal.NavDestinationImpl
            r4.<init>(r12)
            r12.mBackgroundTintHelper = r4
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L35
            androidx.appcompat.view.ContextThemeWrapper r6 = new androidx.appcompat.view.ContextThemeWrapper
            r6.<init>(r13, r4)
            r12.mPopupContext = r6
            goto L37
        L35:
            r12.mPopupContext = r13
        L37:
            r4 = -1
            r6 = 0
            int[] r7 = androidx.appcompat.widget.AppCompatSpinner.ATTRS_ANDROID_SPINNERMODE     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            if (r8 == 0) goto L50
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            goto L50
        L4a:
            r13 = move-exception
            r6 = r7
            goto Ld5
        L4e:
            r8 = move-exception
            goto L59
        L50:
            r7.recycle()
            goto L63
        L54:
            r13 = move-exception
            goto Ld5
        L57:
            r8 = move-exception
            r7 = r6
        L59:
            java.lang.String r9 = "AppCompatSpinner"
            java.lang.String r10 = "Could not read android:spinnerMode"
            android.util.Log.i(r9, r10, r8)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L63
            goto L50
        L63:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L9d
            if (r4 == r8) goto L6a
            goto Laa
        L6a:
            androidx.appcompat.widget.AppCompatSpinner$DropdownPopup r4 = new androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
            android.content.Context r9 = r12.mPopupContext
            r4.<init>(r9, r14)
            android.content.Context r9 = r12.mPopupContext
            kotlin.text.MatcherMatchResult r1 = kotlin.text.MatcherMatchResult.obtainStyledAttributes(r9, r14, r1, r0)
            java.lang.Object r9 = r1.input
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r10 = 3
            r11 = -2
            int r9 = r9.getLayoutDimension(r10, r11)
            r12.mDropDownWidth = r9
            android.graphics.drawable.Drawable r9 = r1.getDrawable(r8)
            r4.setBackgroundDrawable(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.mHintText = r7
            r1.recycle()
            r12.mPopup = r4
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r12)
            r12.mForwardingListener = r1
            goto Laa
        L9d:
            androidx.appcompat.widget.AppCompatSpinner$DialogPopup r1 = new androidx.appcompat.widget.AppCompatSpinner$DialogPopup
            r1.<init>()
            r12.mPopup = r1
            java.lang.String r4 = r3.getString(r7)
            r1.mPrompt = r4
        Laa:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131558573(0x7f0d00ad, float:1.8742466E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lc1:
            r2.recycle()
            r12.mPopupSet = r8
            android.widget.SpinnerAdapter r13 = r12.mTempAdapter
            if (r13 == 0) goto Lcf
            r12.setAdapter(r13)
            r12.mTempAdapter = r6
        Lcf:
            androidx.navigation.internal.NavDestinationImpl r13 = r12.mBackgroundTintHelper
            r13.loadFromAttributes(r14, r0)
            return
        Ld5:
            if (r6 == 0) goto Lda
            r6.recycle()
        Lda:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        return rect.left + rect.right + i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.applySupportBackgroundTint();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getHorizontalOffset();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getVerticalOffset();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        return super.getDropDownWidth();
    }

    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getBackground();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            return spinnerPopup.getHintText();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null && spinnerPopup.isShowing()) {
            spinnerPopup.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.mShowDropdown && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new AnonymousClass2(0, this));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, androidx.appcompat.widget.AppCompatSpinner$SavedState] */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null || !spinnerPopup.isShowing()) {
            z = false;
        } else {
            z = true;
        }
        baseSavedState.mShowDropdown = z;
        return baseSavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AnonymousClass1 r0 = this.mForwardingListener;
        if (r0 == null || !r0.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.isShowing()) {
            return true;
        }
        spinnerPopup.show(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setHorizontalOriginalOffset(i);
            spinnerPopup.setHorizontalOffset(i);
            return;
        }
        super.setDropDownHorizontalOffset(i);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setVerticalOffset(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(BundleKt.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            spinnerPopup.setAdapter(new DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }
}
