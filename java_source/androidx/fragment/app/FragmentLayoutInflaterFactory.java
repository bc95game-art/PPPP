package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        final FragmentStateManager fragmentStateManager;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.mFragmentManager;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        Fragment fragment = null;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
            int i = 0;
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    z = Fragment.class.isAssignableFrom(FragmentManager.C00753.loadClass(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    if (view != null) {
                        i = view.getId();
                    }
                    if (i == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    if (resourceId != -1) {
                        fragment = fragmentManager.findFragmentById(resourceId);
                    }
                    if (fragment == null && string != null) {
                        fragment = fragmentManager.findFragmentByTag(string);
                    }
                    if (fragment == null && i != -1) {
                        fragment = fragmentManager.findFragmentById(i);
                    }
                    if (fragment == null) {
                        FragmentManager.C00753 fragmentFactory = fragmentManager.getFragmentFactory();
                        context.getClassLoader();
                        fragment = fragmentFactory.instantiate(attributeValue);
                        fragment.mFromLayout = true;
                        fragment.mFragmentId = resourceId != 0 ? resourceId : i;
                        fragment.mContainerId = i;
                        fragment.mTag = string;
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = fragmentManager;
                        FragmentHostCallback fragmentHostCallback = fragmentManager.mHost;
                        fragment.mHost = fragmentHostCallback;
                        fragment.onInflate((Context) fragmentHostCallback.context, attributeSet, fragment.mSavedFragmentState);
                        fragmentStateManager = fragmentManager.addFragment(fragment);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else if (!fragment.mInLayout) {
                        fragment.mInLayout = true;
                        fragment.mFragmentManager = fragmentManager;
                        FragmentHostCallback fragmentHostCallback2 = fragmentManager.mHost;
                        fragment.mHost = fragmentHostCallback2;
                        fragment.onInflate((Context) fragmentHostCallback2.context, attributeSet, fragment.mSavedFragmentState);
                        fragmentStateManager = fragmentManager.createOrGetFragmentStateManager(fragment);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new Violation(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup));
                    FragmentStrictMode.getNearestPolicy(fragment).getClass();
                    fragment.mContainer = viewGroup;
                    fragmentStateManager.moveToExpectedState();
                    fragmentStateManager.ensureInflatedView();
                    View view2 = fragment.mView;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (fragment.mView.getTag() == null) {
                            fragment.mView.setTag(string);
                        }
                        fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                            @Override // android.view.View.OnAttachStateChangeListener
                            public final void onViewAttachedToWindow(View view3) {
                                FragmentStateManager fragmentStateManager2 = fragmentStateManager;
                                Fragment fragment2 = fragmentStateManager2.mFragment;
                                fragmentStateManager2.moveToExpectedState();
                                DefaultSpecialEffectsController.getOrCreateController((ViewGroup) fragment2.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                            }

                            @Override // android.view.View.OnAttachStateChangeListener
                            public final void onViewDetachedFromWindow(View view3) {
                            }
                        });
                        return fragment.mView;
                    }
                    throw new IllegalStateException(ViewModelProvider.Factory.CC.m595m("Fragment ", attributeValue, " did not create a view."));
                }
            }
        }
        return null;
    }
}
