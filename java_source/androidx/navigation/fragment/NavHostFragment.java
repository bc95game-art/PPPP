package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.R$styleable;
import com.emanuelef.remote_capture.C0130R;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public class NavHostFragment extends Fragment {
    public boolean defaultNavHost;
    public int graphId;
    public final SynchronizedLazyImpl navHostController$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(2, this));
    public View viewParent;

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (this.defaultNavHost) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
            backStackRecord.setPrimaryNavigationFragment(this);
            backStackRecord.commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        NavHostController navHostController = (NavHostController) this.navHostController$delegate.getValue();
        if (bundle != null && bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
            this.defaultNavHost = true;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
            backStackRecord.setPrimaryNavigationFragment(this);
            backStackRecord.commit();
        }
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int id = getId();
        if (id == 0 || id == -1) {
            id = C0130R.C0132id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(id);
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        View view = this.viewParent;
        if (view != null && Navigation.findNavController(view) == ((NavHostController) this.navHostController$delegate.getValue())) {
            view.setTag(C0130R.C0132id.nav_controller_view_tag, null);
        }
        this.viewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onInflate(Context context, AttributeSet attrs, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.onInflate(context, attrs, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R$styleable.NavHost);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.graphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attrs, R$styleable.NavHostFragment);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "obtainStyledAttributes(...)");
        if (obtainStyledAttributes2.getBoolean(0, false)) {
            this.defaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.defaultNavHost) {
            outState.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            SynchronizedLazyImpl synchronizedLazyImpl = this.navHostController$delegate;
            view.setTag(C0130R.C0132id.nav_controller_view_tag, (NavHostController) synchronizedLazyImpl.getValue());
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getParent() != null) {
                ViewParent parent = viewGroup.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) parent;
                this.viewParent = view2;
                if (view2.getId() == getId()) {
                    View view3 = this.viewParent;
                    Intrinsics.checkNotNull(view3);
                    view3.setTag(C0130R.C0132id.nav_controller_view_tag, (NavHostController) synchronizedLazyImpl.getValue());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
    }
}
