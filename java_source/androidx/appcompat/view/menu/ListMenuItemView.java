package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuView;
import com.emanuelef.remote_capture.C0130R;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    public final Drawable mBackground;
    public CheckBox mCheckBox;
    public LinearLayout mContent;
    public boolean mForceShowIcon;
    public ImageView mGroupDivider;
    public final boolean mHasListDivider;
    public ImageView mIconView;
    public LayoutInflater mInflater;
    public MenuItemImpl mItemData;
    public boolean mPreserveIconSpacing;
    public RadioButton mRadioButton;
    public TextView mShortcutView;
    public final Drawable mSubMenuArrow;
    public ImageView mSubMenuArrowView;
    public final int mTextAppearance;
    public final Context mTextAppearanceContext;
    public TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MenuView, C0130R.attr.listMenuViewStyle);
        this.mBackground = obtainStyledAttributes.getDrawable(5);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        this.mTextAppearance = typedArray.getResourceId(1, -1);
        this.mPreserveIconSpacing = typedArray.getBoolean(7, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = obtainStyledAttributes.getDrawable(8);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, C0130R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int i;
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
            rect.top = this.mGroupDivider.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (r0 == false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011d  */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initialize(MenuItemImpl menuItemImpl) {
        int i;
        boolean z;
        char c;
        String str;
        int i2;
        boolean z2;
        char c2;
        char c3;
        this.mItemData = menuItemImpl;
        boolean isVisible = menuItemImpl.isVisible();
        MenuBuilder menuBuilder = menuItemImpl.mMenu;
        int i3 = 0;
        if (isVisible) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
        setTitle(menuItemImpl.mTitle);
        setCheckable(menuItemImpl.isCheckable());
        if (menuBuilder.isShortcutsVisible()) {
            if (menuBuilder.isQwertyMode()) {
                c3 = menuItemImpl.mShortcutAlphabeticChar;
            } else {
                c3 = menuItemImpl.mShortcutNumericChar;
            }
            if (c3 != 0) {
                z = true;
                menuBuilder.isQwertyMode();
                if (z) {
                    MenuItemImpl menuItemImpl2 = this.mItemData;
                    MenuBuilder menuBuilder2 = menuItemImpl2.mMenu;
                    if (menuBuilder2.isShortcutsVisible()) {
                        if (menuBuilder2.isQwertyMode()) {
                            c2 = menuItemImpl2.mShortcutAlphabeticChar;
                        } else {
                            c2 = menuItemImpl2.mShortcutNumericChar;
                        }
                        if (c2 != 0) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                i3 = 8;
                if (i3 == 0) {
                    TextView textView = this.mShortcutView;
                    MenuItemImpl menuItemImpl3 = this.mItemData;
                    MenuBuilder menuBuilder3 = menuItemImpl3.mMenu;
                    Context context = menuBuilder3.mContext;
                    if (menuBuilder3.isQwertyMode()) {
                        c = menuItemImpl3.mShortcutAlphabeticChar;
                    } else {
                        c = menuItemImpl3.mShortcutNumericChar;
                    }
                    if (c == 0) {
                        str = "";
                    } else {
                        Resources resources = context.getResources();
                        StringBuilder sb = new StringBuilder();
                        if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                            sb.append(resources.getString(C0130R.string.abc_prepend_shortcut_label));
                        }
                        if (menuBuilder3.isQwertyMode()) {
                            i2 = menuItemImpl3.mShortcutAlphabeticModifiers;
                        } else {
                            i2 = menuItemImpl3.mShortcutNumericModifiers;
                        }
                        MenuItemImpl.appendModifier(i2, 65536, resources.getString(C0130R.string.abc_menu_meta_shortcut_label), sb);
                        MenuItemImpl.appendModifier(i2, 4096, resources.getString(C0130R.string.abc_menu_ctrl_shortcut_label), sb);
                        MenuItemImpl.appendModifier(i2, 2, resources.getString(C0130R.string.abc_menu_alt_shortcut_label), sb);
                        MenuItemImpl.appendModifier(i2, 1, resources.getString(C0130R.string.abc_menu_shift_shortcut_label), sb);
                        MenuItemImpl.appendModifier(i2, 4, resources.getString(C0130R.string.abc_menu_sym_shortcut_label), sb);
                        MenuItemImpl.appendModifier(i2, 8, resources.getString(C0130R.string.abc_menu_function_shortcut_label), sb);
                        if (c == '\b') {
                            sb.append(resources.getString(C0130R.string.abc_menu_delete_shortcut_label));
                        } else if (c == '\n') {
                            sb.append(resources.getString(C0130R.string.abc_menu_enter_shortcut_label));
                        } else if (c != ' ') {
                            sb.append(c);
                        } else {
                            sb.append(resources.getString(C0130R.string.abc_menu_space_shortcut_label));
                        }
                        str = sb.toString();
                    }
                    textView.setText(str);
                }
                if (this.mShortcutView.getVisibility() != i3) {
                    this.mShortcutView.setVisibility(i3);
                }
                setIcon(menuItemImpl.getIcon());
                setEnabled(menuItemImpl.isEnabled());
                setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
                setContentDescription(menuItemImpl.mContentDescription);
            }
        }
        z = false;
        menuBuilder.isQwertyMode();
        if (z) {
        }
        i3 = 8;
        if (i3 == 0) {
        }
        if (this.mShortcutView.getVisibility() != i3) {
        }
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.mContentDescription);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.mBackground);
        TextView textView = (TextView) findViewById(C0130R.C0132id.title);
        this.mTitleView = textView;
        int i = this.mTextAppearance;
        if (i != -1) {
            textView.setTextAppearance(this.mTextAppearanceContext, i);
        }
        this.mShortcutView = (TextView) findViewById(C0130R.C0132id.shortcut);
        ImageView imageView = (ImageView) findViewById(C0130R.C0132id.submenuarrow);
        this.mSubMenuArrowView = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mSubMenuArrow);
        }
        this.mGroupDivider = (ImageView) findViewById(C0130R.C0132id.group_divider);
        this.mContent = (LinearLayout) findViewById(C0130R.C0132id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        View view;
        CompoundButton compoundButton;
        if (z || this.mRadioButton != null || this.mCheckBox != null) {
            if ((this.mItemData.mFlags & 4) != 0) {
                if (this.mRadioButton == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(C0130R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                    this.mRadioButton = radioButton;
                    LinearLayout linearLayout = this.mContent;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.mRadioButton;
                view = this.mCheckBox;
            } else {
                if (this.mCheckBox == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(C0130R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                    this.mCheckBox = checkBox;
                    LinearLayout linearLayout2 = this.mContent;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.mCheckBox;
                view = this.mRadioButton;
            }
            if (z) {
                compoundButton.setChecked(this.mItemData.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.mCheckBox;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.mRadioButton;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.mItemData.mFlags & 4) != 0) {
            if (this.mRadioButton == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(C0130R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.mRadioButton = radioButton;
                LinearLayout linearLayout = this.mContent;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.mRadioButton;
        } else {
            if (this.mCheckBox == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(C0130R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.mCheckBox = checkBox;
                LinearLayout linearLayout2 = this.mContent;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.mCheckBox;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        this.mPreserveIconSpacing = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        int i;
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            if (this.mHasListDivider || !z) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        MenuBuilder menuBuilder = this.mItemData.mMenu;
        boolean z = this.mForceShowIcon;
        if (z || this.mPreserveIconSpacing) {
            ImageView imageView = this.mIconView;
            if (imageView != null || drawable != null || this.mPreserveIconSpacing) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(C0130R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.mIconView = imageView2;
                    LinearLayout linearLayout = this.mContent;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable != null || this.mPreserveIconSpacing) {
                    ImageView imageView3 = this.mIconView;
                    if (!z) {
                        drawable = null;
                    }
                    imageView3.setImageDrawable(drawable);
                    if (this.mIconView.getVisibility() != 0) {
                        this.mIconView.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.mIconView.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mTitleView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        } else if (this.mTitleView.getVisibility() != 8) {
            this.mTitleView.setVisibility(8);
        }
    }
}
