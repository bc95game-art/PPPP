package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.activity.ComponentDialog;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p002os.BundleKt;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.C0130R;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class AlertDialog extends ComponentDialog implements DialogInterface, AppCompatCallback {
    public final AlertController mAlert;
    public AppCompatDelegateImpl mDelegate;
    public final AppCompatDialog$$ExternalSyntheticLambda0 mKeyDispatcher;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appcompat.app.AppCompatDialog$$ExternalSyntheticLambda0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AlertDialog(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, r2);
        int i2;
        int resolveDialogTheme = resolveDialogTheme(contextThemeWrapper, i);
        if (resolveDialogTheme == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(C0130R.attr.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = resolveDialogTheme;
        }
        this.mKeyDispatcher = new KeyEventDispatcher$Component() { // from class: androidx.appcompat.app.AppCompatDialog$$ExternalSyntheticLambda0
            @Override // androidx.core.view.KeyEventDispatcher$Component
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return AlertDialog.this.superDispatchKeyEvent(keyEvent);
            }
        };
        AppCompatDelegate delegate = getDelegate();
        if (resolveDialogTheme == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(C0130R.attr.dialogTheme, typedValue2, true);
            resolveDialogTheme = typedValue2.resourceId;
        }
        ((AppCompatDelegateImpl) delegate).mThemeResId = resolveDialogTheme;
        delegate.onCreate();
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public static int resolveDialogTheme(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0130R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        ((ViewGroup) appCompatDelegateImpl.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        appCompatDelegateImpl.mAppCompatWindowCallback.bypassOnContentChanged(appCompatDelegateImpl.mWindow.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return BundleKt.dispatchKeyEvent(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public final Button getButton(int i) {
        AlertController alertController = this.mAlert;
        if (i == -3) {
            return alertController.mButtonNeutral;
        }
        if (i == -2) {
            return alertController.mButtonNegative;
        }
        if (i == -1) {
            return alertController.mButtonPositive;
        }
        alertController.getClass();
        return null;
    }

    public final AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            AppCompatDelegate.SerialExecutor serialExecutor = AppCompatDelegate.sSerialExecutorForLocalesStorage;
            this.mDelegate = new AppCompatDelegateImpl(getContext(), getWindow(), this, this);
        }
        return this.mDelegate;
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        ListAdapter listAdapter;
        int i2;
        final View view;
        int i3;
        int i4;
        View view2;
        View findViewById;
        onCreate$androidx$appcompat$app$AppCompatDialog(bundle);
        final AlertController alertController = this.mAlert;
        alertController.mDialog.setContentView(alertController.mAlertDialogLayout);
        Context context = alertController.mContext;
        Window window = alertController.mWindow;
        View findViewById2 = window.findViewById(C0130R.C0132id.parentPanel);
        View findViewById3 = findViewById2.findViewById(C0130R.C0132id.topPanel);
        View findViewById4 = findViewById2.findViewById(C0130R.C0132id.contentPanel);
        View findViewById5 = findViewById2.findViewById(C0130R.C0132id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C0130R.C0132id.customPanel);
        View view3 = alertController.mView;
        if (view3 == null) {
            view3 = null;
        }
        if (view3 != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !AlertController.canTextInput(view3)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(C0130R.C0132id.custom);
            frameLayout.addView(view3, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.mViewSpacingSpecified) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (alertController.mListView != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(C0130R.C0132id.topPanel);
        View findViewById7 = viewGroup.findViewById(C0130R.C0132id.contentPanel);
        View findViewById8 = viewGroup.findViewById(C0130R.C0132id.buttonPanel);
        ViewGroup resolvePanel = AlertController.resolvePanel(findViewById6, findViewById3);
        ViewGroup resolvePanel2 = AlertController.resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel3 = AlertController.resolvePanel(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(C0130R.C0132id.scrollView);
        alertController.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) resolvePanel2.findViewById(16908299);
        alertController.mMessageView = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.mScrollView.removeView(alertController.mMessageView);
                if (alertController.mListView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.mScrollView.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.mScrollView);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    resolvePanel2.setVisibility(8);
                }
            }
        }
        Button button = (Button) resolvePanel3.findViewById(16908313);
        alertController.mButtonPositive = button;
        Toolbar.View$OnClickListenerC00394 r9 = alertController.mButtonHandler;
        button.setOnClickListener(r9);
        if (TextUtils.isEmpty(alertController.mButtonPositiveText)) {
            alertController.mButtonPositive.setVisibility(8);
            z2 = false;
        } else {
            alertController.mButtonPositive.setText(alertController.mButtonPositiveText);
            alertController.mButtonPositive.setVisibility(0);
            z2 = true;
        }
        Button button2 = (Button) resolvePanel3.findViewById(16908314);
        alertController.mButtonNegative = button2;
        button2.setOnClickListener(r9);
        if (TextUtils.isEmpty(alertController.mButtonNegativeText)) {
            alertController.mButtonNegative.setVisibility(8);
        } else {
            alertController.mButtonNegative.setText(alertController.mButtonNegativeText);
            alertController.mButtonNegative.setVisibility(0);
            z2 |= true;
        }
        Button button3 = (Button) resolvePanel3.findViewById(16908315);
        alertController.mButtonNeutral = button3;
        button3.setOnClickListener(r9);
        if (TextUtils.isEmpty(alertController.mButtonNeutralText)) {
            alertController.mButtonNeutral.setVisibility(8);
        } else {
            alertController.mButtonNeutral.setText(alertController.mButtonNeutralText);
            alertController.mButtonNeutral.setVisibility(0);
            z2 |= true;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0130R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z2) {
                Button button4 = alertController.mButtonPositive;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (z2) {
                Button button5 = alertController.mButtonNegative;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (z2) {
                Button button6 = alertController.mButtonNeutral;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (!z2) {
            resolvePanel3.setVisibility(8);
        }
        if (alertController.mCustomTitleView != null) {
            resolvePanel.addView(alertController.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(C0130R.C0132id.title_template).setVisibility(8);
        } else {
            alertController.mIconView = (ImageView) window.findViewById(16908294);
            if (TextUtils.isEmpty(alertController.mTitle) || !alertController.mShowTitle) {
                window.findViewById(C0130R.C0132id.title_template).setVisibility(8);
                alertController.mIconView.setVisibility(8);
                resolvePanel.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(C0130R.C0132id.alertTitle);
                alertController.mTitleView = textView2;
                textView2.setText(alertController.mTitle);
                Drawable drawable = alertController.mIcon;
                if (drawable != null) {
                    alertController.mIconView.setImageDrawable(drawable);
                } else {
                    alertController.mTitleView.setPadding(alertController.mIconView.getPaddingLeft(), alertController.mIconView.getPaddingTop(), alertController.mIconView.getPaddingRight(), alertController.mIconView.getPaddingBottom());
                    alertController.mIconView.setVisibility(8);
                }
            }
        }
        if (viewGroup.getVisibility() != 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (resolvePanel == null || resolvePanel.getVisibility() == 8) {
            i = 0;
        } else {
            i = 1;
        }
        if (resolvePanel3.getVisibility() != 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && (findViewById = resolvePanel2.findViewById(C0130R.C0132id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i != 0) {
            NestedScrollView nestedScrollView2 = alertController.mScrollView;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (alertController.mMessage == null && alertController.mListView == null) {
                view2 = null;
            } else {
                view2 = resolvePanel.findViewById(C0130R.C0132id.titleDividerNoCustom);
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            View findViewById9 = resolvePanel2.findViewById(C0130R.C0132id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.mListView;
        if (recycleListView != null) {
            recycleListView.getClass();
            if (!z4 || i == 0) {
                int paddingLeft = recycleListView.getPaddingLeft();
                if (i != 0) {
                    i3 = recycleListView.getPaddingTop();
                } else {
                    i3 = recycleListView.mPaddingTopNoTitle;
                }
                int paddingRight = recycleListView.getPaddingRight();
                if (z4) {
                    i4 = recycleListView.getPaddingBottom();
                } else {
                    i4 = recycleListView.mPaddingBottomNoButtons;
                }
                recycleListView.setPadding(paddingLeft, i3, paddingRight, i4);
            }
        }
        if (!z3) {
            View view4 = alertController.mListView;
            if (view4 == null) {
                view4 = alertController.mScrollView;
            }
            if (view4 != null) {
                if (z4) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                int i5 = i | i2;
                final View findViewById10 = window.findViewById(C0130R.C0132id.scrollIndicatorUp);
                View findViewById11 = window.findViewById(C0130R.C0132id.scrollIndicatorDown);
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 23) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (i6 >= 23) {
                        ViewCompat.Api23Impl.setScrollIndicators(view4, i5, 3);
                    }
                    if (findViewById10 != null) {
                        resolvePanel2.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        resolvePanel2.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (i5 & 1) == 0) {
                        resolvePanel2.removeView(findViewById10);
                        findViewById10 = null;
                    }
                    if (findViewById11 == null || (i5 & 2) != 0) {
                        view = findViewById11;
                    } else {
                        resolvePanel2.removeView(findViewById11);
                        view = null;
                    }
                    if (!(findViewById10 == null && view == null)) {
                        if (alertController.mMessage != null) {
                            alertController.mScrollView.setOnScrollChangeListener(new zzcl(findViewById10, 1, view));
                            alertController.mScrollView.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (r4) {
                                        case 0:
                                            AlertController.manageScrollIndicators(alertController.mScrollView, findViewById10, view);
                                            return;
                                        default:
                                            AlertController.manageScrollIndicators(alertController.mListView, findViewById10, view);
                                            return;
                                    }
                                }
                            });
                        } else {
                            AlertController.RecycleListView recycleListView2 = alertController.mListView;
                            if (recycleListView2 != null) {
                                recycleListView2.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                                    @Override // android.widget.AbsListView.OnScrollListener
                                    public final void onScroll(AbsListView absListView, int i7, int i8, int i9) {
                                        AlertController.manageScrollIndicators(absListView, findViewById10, view);
                                    }

                                    @Override // android.widget.AbsListView.OnScrollListener
                                    public final void onScrollStateChanged(AbsListView absListView, int i7) {
                                    }
                                });
                                alertController.mListView.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (r4) {
                                            case 0:
                                                AlertController.manageScrollIndicators(alertController.mScrollView, findViewById10, view);
                                                return;
                                            default:
                                                AlertController.manageScrollIndicators(alertController.mListView, findViewById10, view);
                                                return;
                                        }
                                    }
                                });
                            } else {
                                if (findViewById10 != null) {
                                    resolvePanel2.removeView(findViewById10);
                                }
                                if (view != null) {
                                    resolvePanel2.removeView(view);
                                }
                            }
                        }
                    }
                }
            }
        }
        AlertController.RecycleListView recycleListView3 = alertController.mListView;
        if (recycleListView3 != null && (listAdapter = alertController.mAdapter) != null) {
            recycleListView3.setAdapter(listAdapter);
            int i7 = alertController.mCheckedItem;
            if (i7 > -1) {
                recycleListView3.setItemChecked(i7, true);
                recycleListView3.setSelection(i7);
            }
        }
    }

    public final void onCreate$androidx$appcompat$app$AppCompatDialog(Bundle bundle) {
        getDelegate().installViewFactory();
        super.onCreate(bundle);
        getDelegate().onCreate();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mAlert.mScrollView;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public final ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(int i) {
        initializeViewTreeOwners();
        getDelegate().setContentView(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        getDelegate().setTitle(getContext().getString(i));
    }

    public final void setTitle$androidx$appcompat$app$AppCompatDialog(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View view) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        setTitle$androidx$appcompat$app$AppCompatDialog(charSequence);
        AlertController alertController = this.mAlert;
        alertController.mTitle = charSequence;
        TextView textView = alertController.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public final void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public final void onSupportActionModeStarted(ActionMode actionMode) {
    }
}
