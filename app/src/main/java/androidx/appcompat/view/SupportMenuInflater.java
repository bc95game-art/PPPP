package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.MenuItemCompat$Api26Impl;
import androidx.lifecycle.ViewModelProvider;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.text.MatcherMatchResult;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class SupportMenuInflater extends MenuInflater {
    public static final Class[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public final Context mContext;
    public Object mRealOwner;

    /* loaded from: classes.dex */
    public final class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static final Class[] PARAM_TYPES = {MenuItem.class};
        public Method mMethod;
        public Object mRealOwner;

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            Object obj = this.mRealOwner;
            Method method = this.mMethod;
            try {
                if (method.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                }
                method.invoke(obj, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class MenuState {
        public MenuItemWrapperICS.ActionProviderWrapper itemActionProvider;
        public String itemActionViewClassName;
        public int itemActionViewLayout;
        public boolean itemAdded;
        public int itemAlphabeticModifiers;
        public char itemAlphabeticShortcut;
        public int itemCategoryOrder;
        public int itemCheckable;
        public boolean itemChecked;
        public CharSequence itemContentDescription;
        public boolean itemEnabled;
        public int itemIconResId;
        public int itemId;
        public String itemListenerMethodName;
        public int itemNumericModifiers;
        public char itemNumericShortcut;
        public int itemShowAsAction;
        public CharSequence itemTitle;
        public CharSequence itemTitleCondensed;
        public CharSequence itemTooltipText;
        public boolean itemVisible;
        public final Menu menu;
        public ColorStateList itemIconTintList = null;
        public PorterDuff.Mode itemIconTintMode = null;
        public int groupId = 0;
        public int groupCategory = 0;
        public int groupOrder = 0;
        public int groupCheckable = 0;
        public boolean groupVisible = true;
        public boolean groupEnabled = true;

        public MenuState(Menu menu) {
            this.menu = menu;
        }

        public final Object newInstance(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v14, types: [android.view.MenuItem$OnMenuItemClickListener, androidx.appcompat.view.SupportMenuInflater$InflatedOnMenuItemClickListener, java.lang.Object] */
        public final void setItem(MenuItem menuItem) {
            boolean z;
            SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
            Context context = supportMenuInflater.mContext;
            MenuItem enabled = menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean z2 = false;
            if (this.itemCheckable >= 1) {
                z = true;
            } else {
                z = false;
            }
            enabled.setCheckable(z).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int i = this.itemShowAsAction;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.itemListenerMethodName != null) {
                if (!context.isRestricted()) {
                    if (supportMenuInflater.mRealOwner == null) {
                        supportMenuInflater.mRealOwner = SupportMenuInflater.findRealOwner(context);
                    }
                    Object obj = supportMenuInflater.mRealOwner;
                    String str = this.itemListenerMethodName;
                    ?? obj2 = new Object();
                    obj2.mRealOwner = obj;
                    Class<?> cls = obj.getClass();
                    try {
                        obj2.mMethod = cls.getMethod(str, InflatedOnMenuItemClickListener.PARAM_TYPES);
                        menuItem.setOnMenuItemClickListener(obj2);
                    } catch (Exception e) {
                        StringBuilder m = ViewModelProvider.Factory.CC.m594m("Couldn't resolve menu item onClick handler ", str, " in class ");
                        m.append(cls.getName());
                        InflateException inflateException = new InflateException(m.toString());
                        inflateException.initCause(e);
                        throw inflateException;
                    }
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.itemCheckable >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    SupportMenuItem supportMenuItem = menuItemWrapperICS.mWrappedObject;
                    try {
                        if (menuItemWrapperICS.mSetExclusiveCheckableMethod == null) {
                            menuItemWrapperICS.mSetExclusiveCheckableMethod = supportMenuItem.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemWrapperICS.mSetExclusiveCheckableMethod.invoke(supportMenuItem, Boolean.TRUE);
                    } catch (Exception e2) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
                    }
                }
            }
            String str2 = this.itemActionViewClassName;
            if (str2 != null) {
                menuItem.setActionView((View) newInstance(str2, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, supportMenuInflater.mActionViewConstructorArguments));
                z2 = true;
            }
            int i2 = this.itemActionViewLayout;
            if (i2 > 0) {
                if (!z2) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper = this.itemActionProvider;
            if (actionProviderWrapper != null) {
                if (menuItem instanceof SupportMenuItem) {
                    ((SupportMenuItem) menuItem).setSupportActionProvider(actionProviderWrapper);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.itemContentDescription;
            boolean z3 = menuItem instanceof SupportMenuItem;
            if (z3) {
                ((SupportMenuItem) menuItem).mo632setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setContentDescription(menuItem, charSequence);
            }
            CharSequence charSequence2 = this.itemTooltipText;
            if (z3) {
                ((SupportMenuItem) menuItem).mo633setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setTooltipText(menuItem, charSequence2);
            }
            char c = this.itemAlphabeticShortcut;
            int i3 = this.itemAlphabeticModifiers;
            if (z3) {
                ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setAlphabeticShortcut(menuItem, c, i3);
            }
            char c2 = this.itemNumericShortcut;
            int i4 = this.itemNumericModifiers;
            if (z3) {
                ((SupportMenuItem) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setNumericShortcut(menuItem, c2, i4);
            }
            PorterDuff.Mode mode = this.itemIconTintMode;
            if (mode != null) {
                if (z3) {
                    ((SupportMenuItem) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    MenuItemCompat$Api26Impl.setIconTintMode(menuItem, mode);
                }
            }
            ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                MenuItemCompat$Api26Impl.setIconTintList(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objArr = {context};
        this.mActionViewConstructorArguments = objArr;
        this.mActionProviderConstructorArguments = objArr;
    }

    public static Object findRealOwner(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return findRealOwner(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof MenuBuilder)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z = false;
        try {
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof MenuBuilder) {
                    MenuBuilder menuBuilder = (MenuBuilder) menu;
                    if (!menuBuilder.mPreventDispatchingItemsChanged) {
                        menuBuilder.stopDispatchingItemsChanged();
                        z = true;
                    }
                }
                parseMenu(xmlResourceParser, asAttributeSet, menu);
                if (z) {
                    ((MenuBuilder) menu).startDispatchingItemsChanged();
                }
                xmlResourceParser.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (z) {
                ((MenuBuilder) menu).startDispatchingItemsChanged();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public final void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        int i;
        XmlPullParser xmlPullParser2;
        char c;
        char c2;
        boolean z;
        ColorStateList colorStateList;
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            } else if (eventType != i) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z3 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        menuState.groupId = 0;
                        menuState.groupCategory = 0;
                        menuState.groupOrder = 0;
                        menuState.groupCheckable = 0;
                        menuState.groupVisible = true;
                        menuState.groupEnabled = true;
                    } else if (name2.equals("item")) {
                        if (!menuState.itemAdded) {
                            MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper = menuState.itemActionProvider;
                            if (actionProviderWrapper == null || !actionProviderWrapper.mInner.hasSubMenu()) {
                                menuState.itemAdded = true;
                                menuState.setItem(menuState.menu.add(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle));
                            } else {
                                menuState.itemAdded = true;
                                menuState.setItem(menuState.menu.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        xmlPullParser2 = xmlPullParser;
                        z2 = true;
                    }
                    eventType = xmlPullParser2.next();
                    i = 2;
                }
                xmlPullParser2 = xmlPullParser;
                eventType = xmlPullParser2.next();
                i = 2;
            } else {
                if (!z3) {
                    String name3 = xmlPullParser.getName();
                    boolean equals = name3.equals("group");
                    Context context = this.mContext;
                    if (equals) {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MenuGroup);
                        menuState.groupId = obtainStyledAttributes.getResourceId(1, 0);
                        menuState.groupCategory = obtainStyledAttributes.getInt(3, 0);
                        menuState.groupOrder = obtainStyledAttributes.getInt(4, 0);
                        menuState.groupCheckable = obtainStyledAttributes.getInt(5, 0);
                        menuState.groupVisible = obtainStyledAttributes.getBoolean(2, true);
                        menuState.groupEnabled = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            MatcherMatchResult obtainStyledAttributes2 = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, R$styleable.MenuItem);
                            TypedArray typedArray = (TypedArray) obtainStyledAttributes2.input;
                            menuState.itemId = typedArray.getResourceId(2, 0);
                            menuState.itemCategoryOrder = (typedArray.getInt(5, menuState.groupCategory) & (-65536)) | (typedArray.getInt(6, menuState.groupOrder) & 65535);
                            menuState.itemTitle = typedArray.getText(7);
                            menuState.itemTitleCondensed = typedArray.getText(8);
                            menuState.itemIconResId = typedArray.getResourceId(0, 0);
                            String string = typedArray.getString(9);
                            if (string == null) {
                                c = 0;
                            } else {
                                c = string.charAt(0);
                            }
                            menuState.itemAlphabeticShortcut = c;
                            menuState.itemAlphabeticModifiers = typedArray.getInt(16, 4096);
                            String string2 = typedArray.getString(10);
                            if (string2 == null) {
                                c2 = 0;
                            } else {
                                c2 = string2.charAt(0);
                            }
                            menuState.itemNumericShortcut = c2;
                            menuState.itemNumericModifiers = typedArray.getInt(20, 4096);
                            if (typedArray.hasValue(11)) {
                                menuState.itemCheckable = typedArray.getBoolean(11, false) ? 1 : 0;
                            } else {
                                menuState.itemCheckable = menuState.groupCheckable;
                            }
                            menuState.itemChecked = typedArray.getBoolean(3, false);
                            menuState.itemVisible = typedArray.getBoolean(4, menuState.groupVisible);
                            menuState.itemEnabled = typedArray.getBoolean(1, menuState.groupEnabled);
                            menuState.itemShowAsAction = typedArray.getInt(21, -1);
                            menuState.itemListenerMethodName = typedArray.getString(12);
                            menuState.itemActionViewLayout = typedArray.getResourceId(13, 0);
                            menuState.itemActionViewClassName = typedArray.getString(15);
                            String string3 = typedArray.getString(14);
                            if (string3 != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && menuState.itemActionViewLayout == 0 && menuState.itemActionViewClassName == null) {
                                menuState.itemActionProvider = (MenuItemWrapperICS.ActionProviderWrapper) menuState.newInstance(string3, ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.mActionProviderConstructorArguments);
                            } else {
                                if (z) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                menuState.itemActionProvider = null;
                            }
                            menuState.itemContentDescription = typedArray.getText(17);
                            menuState.itemTooltipText = typedArray.getText(22);
                            if (typedArray.hasValue(19)) {
                                menuState.itemIconTintMode = DrawableUtils.parseTintMode(typedArray.getInt(19, -1), menuState.itemIconTintMode);
                                colorStateList = null;
                            } else {
                                colorStateList = null;
                                menuState.itemIconTintMode = null;
                            }
                            if (typedArray.hasValue(18)) {
                                menuState.itemIconTintList = obtainStyledAttributes2.getColorStateList(18);
                            } else {
                                menuState.itemIconTintList = colorStateList;
                            }
                            obtainStyledAttributes2.recycle();
                            menuState.itemAdded = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            menuState.itemAdded = true;
                            SubMenu addSubMenu = menuState.menu.addSubMenu(menuState.groupId, menuState.itemId, menuState.itemCategoryOrder, menuState.itemTitle);
                            menuState.setItem(addSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            parseMenu(xmlPullParser2, attributeSet, addSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z3 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i = 2;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                eventType = xmlPullParser2.next();
                i = 2;
            }
        }
    }
}
