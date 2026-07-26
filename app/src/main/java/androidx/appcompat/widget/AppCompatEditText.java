package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements OnReceiveContentViewBehavior, TintableCompoundDrawablesView {
    public final AppCompatProgressBarHelper mAppCompatEmojiEditTextHelper;
    public final NavDestinationImpl mBackgroundTintHelper;
    public final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener = new Object();
    public SuperCaller mSuperCaller;
    public final AppCompatProgressBarHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    /* loaded from: classes.dex */
    public final class SuperCaller {
        public SuperCaller() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.core.widget.TextViewOnReceiveContentListener, java.lang.Object] */
    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.editTextStyle);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        NavDestinationImpl navDestinationImpl = new NavDestinationImpl(this);
        this.mBackgroundTintHelper = navDestinationImpl;
        navDestinationImpl.loadFromAttributes(attributeSet, C0130R.attr.editTextStyle);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, C0130R.attr.editTextStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper();
        appCompatProgressBarHelper.mView = this;
        this.mTextClassifierHelper = appCompatProgressBarHelper;
        AppCompatProgressBarHelper appCompatProgressBarHelper2 = new AppCompatProgressBarHelper(this);
        this.mAppCompatEmojiEditTextHelper = appCompatProgressBarHelper2;
        appCompatProgressBarHelper2.loadFromAttributes(attributeSet, C0130R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListener2 = appCompatProgressBarHelper2.getKeyListener(keyListener);
            if (keyListener2 != keyListener) {
                super.setKeyListener(keyListener2);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    private SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            this.mSuperCaller = new SuperCaller();
        }
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        AppCompatProgressBarHelper appCompatProgressBarHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatProgressBarHelper = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) appCompatProgressBarHelper.mSampleTile;
        if (textClassifier == null) {
            return AppCompatTextClassifierHelper$Api26Impl.getTextClassifier((TextView) appCompatProgressBarHelper.mView);
        }
        return textClassifier;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] onReceiveContentMimeTypes;
        InputConnectionWrapper inputConnectionCompat$2;
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.getClass();
        AppCompatTextHelper.populateSurroundingTextIfNeeded(editorInfo, onCreateInputConnection, this);
        BundleKt.onCreateInputConnection(editorInfo, onCreateInputConnection, this);
        if (!(onCreateInputConnection == null || (i = Build.VERSION.SDK_INT) > 30 || (onReceiveContentMimeTypes = ViewCompat.getOnReceiveContentMimeTypes(this)) == null)) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, onReceiveContentMimeTypes);
            final InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(0, this);
            if (i >= 25) {
                inputConnectionCompat$2 = new InputConnectionWrapper(onCreateInputConnection) { // from class: androidx.core.view.inputmethod.InputConnectionCompat$1
                    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                    public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
                        FakeDrag fakeDrag = null;
                        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
                            fakeDrag = new FakeDrag(12, new InputContentInfoCompat$InputContentInfoCompatApi25Impl(inputContentInfo));
                        }
                        if (inputConnectionCompat$$ExternalSyntheticLambda0.onCommitContent(fakeDrag, i2, bundle)) {
                            return true;
                        }
                        return super.commitContent(inputContentInfo, i2, bundle);
                    }
                };
            } else if (EditorInfoCompat.getContentMimeTypes(editorInfo).length != 0) {
                inputConnectionCompat$2 = new InputConnectionWrapper(onCreateInputConnection) { // from class: androidx.core.view.inputmethod.InputConnectionCompat$2
                    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                    public final boolean performPrivateCommand(String str, Bundle bundle) {
                        boolean z;
                        String str2;
                        Throwable th;
                        ResultReceiver resultReceiver;
                        String str3;
                        String str4;
                        String str5;
                        String str6;
                        String str7;
                        InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda02 = inputConnectionCompat$$ExternalSyntheticLambda0;
                        boolean z2 = false;
                        z2 = false;
                        z2 = false;
                        z2 = false;
                        if (bundle != null) {
                            if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                                z = false;
                            } else if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                                z = true;
                            }
                            if (z) {
                                str2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
                            } else {
                                str2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
                            }
                            try {
                                resultReceiver = (ResultReceiver) bundle.getParcelable(str2);
                                if (z) {
                                    str3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
                                } else {
                                    str3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
                                }
                                try {
                                    Uri uri = (Uri) bundle.getParcelable(str3);
                                    if (z) {
                                        str4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
                                    } else {
                                        str4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
                                    }
                                    ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(str4);
                                    if (z) {
                                        str5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
                                    } else {
                                        str5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
                                    }
                                    Uri uri2 = (Uri) bundle.getParcelable(str5);
                                    if (z) {
                                        str6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
                                    } else {
                                        str6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
                                    }
                                    int i2 = bundle.getInt(str6);
                                    if (z) {
                                        str7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
                                    } else {
                                        str7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
                                    }
                                    Bundle bundle2 = (Bundle) bundle.getParcelable(str7);
                                    if (!(uri == null || clipDescription == null)) {
                                        z2 = inputConnectionCompat$$ExternalSyntheticLambda02.onCommitContent(new FakeDrag(uri, clipDescription, uri2), i2, bundle2);
                                    }
                                    if (resultReceiver != null) {
                                        int i3 = z2 ? 1 : 0;
                                        int i4 = z2 ? 1 : 0;
                                        int i5 = z2 ? 1 : 0;
                                        int i6 = z2 ? 1 : 0;
                                        int i7 = z2 ? 1 : 0;
                                        int i8 = z2 ? 1 : 0;
                                        resultReceiver.send(i3, null);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (resultReceiver != null) {
                                        resultReceiver.send(0, null);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                resultReceiver = null;
                            }
                        }
                        if (z2) {
                            return true;
                        }
                        return super.performPrivateCommand(str, bundle);
                    }
                };
            }
            onCreateInputConnection = inputConnectionCompat$2;
        }
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 33) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AppCompatReceiveContentHelper$OnDropApi24Impl.onDropForTextView(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, contentInfoCompat);
    }

    @Override // android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        ClipData clipData;
        ContentInfoCompat.Compat31Impl compat31Impl;
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31 || ViewCompat.getOnReceiveContentMimeTypes(this) == null || (i != 16908322 && i != 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            clipData = null;
        } else {
            clipData = clipboardManager.getPrimaryClip();
        }
        if (clipData != null && clipData.getItemCount() > 0) {
            if (i3 >= 31) {
                compat31Impl = new ContentInfoCompat.Compat31Impl(clipData, 1);
            } else {
                ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl();
                compatImpl.mClip = clipData;
                compatImpl.mSource = 1;
                compat31Impl = compatImpl;
            }
            if (i == 16908322) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            compat31Impl.setFlags(i2);
            ViewCompat.performReceiveContent(this, compat31Impl.build());
        }
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

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(keyListener));
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

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintList(colorStateList);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintMode(mode);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatProgressBarHelper appCompatProgressBarHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatProgressBarHelper = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            appCompatProgressBarHelper.mSampleTile = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}
