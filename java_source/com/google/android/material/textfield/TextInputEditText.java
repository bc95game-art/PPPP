package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Locale;
/* loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {
    public final Rect parentRect = new Rect();
    public boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, C0130R.attr.editTextStyle, 0), attributeSet);
        ViewUtils.checkCompatibleTheme(context, attributeSet, C0130R.attr.editTextStyle, C0130R.style.Widget_Design_TextInputEditText);
        int[] iArr = R$styleable.TextInputEditText;
        ViewUtils.checkTextAppearance(context, attributeSet, iArr, C0130R.attr.editTextStyle, C0130R.style.Widget_Design_TextInputEditText, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, C0130R.attr.editTextStyle, C0130R.style.Widget_Design_TextInputEditText);
        setTextInputLayoutFocusedRectEnabled(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.textInputLayoutFocusedRectEnabled && rect != null) {
            Rect rect2 = this.parentRect;
            textInputLayout.getFocusedRect(rect2);
            rect.bottom = rect2.bottom;
        }
    }

    @Override // android.view.View
    public final boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.textInputLayoutFocusedRectEnabled) {
            return super.getGlobalVisibleRect(rect, point);
        }
        boolean globalVisibleRect = textInputLayout.getGlobalVisibleRect(rect, point);
        if (globalVisibleRect && point != null) {
            point.offset(-getScrollX(), -getScrollY());
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.isProvidingHint) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        String str;
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.isProvidingHint && super.getHint() == null) {
            String str2 = Build.MANUFACTURER;
            if (str2 != null) {
                str = str2.toLowerCase(Locale.ENGLISH);
            } else {
                str = "";
            }
            if (str.equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            Editable text = getText();
            CharSequence hint = textInputLayout.getHint();
            boolean isEmpty = TextUtils.isEmpty(text);
            String str2 = "";
            if (!TextUtils.isEmpty(hint)) {
                str = hint.toString();
            } else {
                str = str2;
            }
            if (!isEmpty) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) text);
                if (!TextUtils.isEmpty(str)) {
                    str2 = ", " + str;
                }
                sb.append(str2);
                str2 = sb.toString();
            } else if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            accessibilityNodeInfo.setText(str2);
        }
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.textInputLayoutFocusedRectEnabled || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        int height = textInputLayout.getHeight() - getHeight();
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom + height;
        Rect rect2 = this.parentRect;
        rect2.set(i, i2, i3, i4);
        return super.requestRectangleOnScreen(rect2);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.textInputLayoutFocusedRectEnabled = z;
    }
}
