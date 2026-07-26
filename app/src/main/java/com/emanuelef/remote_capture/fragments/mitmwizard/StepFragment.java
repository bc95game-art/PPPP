package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.fragments.ConnectionOverview$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlin.Pair;
/* loaded from: classes.dex */
public class StepFragment extends Fragment {
    protected int mDangerColor;
    protected NavController mNavController;
    protected int mOkColor;
    protected Button mSkipButton;
    protected Button mStepButton;
    protected ImageView mStepIcon;
    protected TextView mStepLabel;
    protected int mWarnColor;

    public /* synthetic */ void lambda$nextStep$0(int i, View view) {
        gotoStep(i);
    }

    public void gotoStep(int i) {
        NavDestination navDestination;
        Bundle bundle;
        int i2;
        NavOptions navOptions;
        if (i <= 0) {
            requireActivity().finish();
            return;
        }
        NavController navController = this.mNavController;
        NavContext navContext = navController.navContext;
        NavControllerImpl navControllerImpl = navController.impl;
        if (navControllerImpl.backQueue.isEmpty()) {
            navDestination = navControllerImpl._graph;
        } else {
            navDestination = ((NavBackStackEntry) navControllerImpl.backQueue.last()).destination;
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i);
            if (action != null) {
                navOptions = action.navOptions;
                i2 = action.destinationId;
                Bundle bundle2 = action.defaultArguments;
                if (bundle2 != null) {
                    bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    bundle.putAll(bundle2);
                } else {
                    bundle = null;
                }
            } else {
                i2 = i;
                navOptions = null;
                bundle = null;
            }
            if (i2 == 0 && navOptions != null) {
                boolean z = navOptions.popUpToInclusive;
                int i3 = navOptions.popUpToId;
                if (i3 != -1) {
                    if (i3 != -1 && navControllerImpl.popBackStackInternal$navigation_runtime_release(i3, z, false)) {
                        navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release();
                        return;
                    }
                    return;
                }
            }
            if (i2 != 0) {
                NavDestination findDestination$navigation_runtime_release = navControllerImpl.findDestination$navigation_runtime_release(i2, null);
                if (findDestination$navigation_runtime_release == null) {
                    int i4 = NavDestination.$r8$clinit;
                    String displayName = Navigation.getDisplayName(navContext, i2);
                    if (action == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + navDestination);
                    }
                    StringBuilder m = ViewModelProvider.Factory.CC.m15m("Navigation destination ", displayName, " referenced from action ");
                    m.append(Navigation.getDisplayName(navContext, i));
                    m.append(" cannot be found from the current destination ");
                    m.append(navDestination);
                    throw new IllegalArgumentException(m.toString().toString());
                }
                navControllerImpl.navigate$navigation_runtime_release(findDestination$navigation_runtime_release, bundle, navOptions);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("No current destination found. Ensure a navigation graph has been set for NavController " + navController + '.');
    }

    public void nextStep(int i) {
        boolean z;
        int i2;
        Context requireContext = requireContext();
        if (i <= 0) {
            z = true;
        } else {
            z = false;
        }
        this.mStepIcon.setImageDrawable(BundleKt.getDrawable(requireContext, R.drawable.ic_check_solid));
        this.mStepIcon.setColorFilter(this.mOkColor);
        this.mSkipButton.setVisibility(8);
        this.mStepButton.setEnabled(true);
        Button button = this.mStepButton;
        if (!z) {
            i2 = R.string.app_intro_next_button;
        } else {
            i2 = R.string.app_intro_done_button;
        }
        button.setText(i2);
        this.mStepButton.setOnClickListener(new ConnectionOverview$$ExternalSyntheticLambda0(i, 1, this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_mitm_wizard, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mNavController = Navigation.findNavController(view);
        this.mStepLabel = (TextView) view.findViewById(R.id.step_label);
        this.mStepIcon = (ImageView) view.findViewById(R.id.step_status);
        this.mStepButton = (Button) view.findViewById(R.id.step_button);
        this.mSkipButton = (Button) view.findViewById(R.id.skip_button);
        Context requireContext = requireContext();
        this.mOkColor = BundleKt.getColor(requireContext, R.color.ok);
        this.mWarnColor = BundleKt.getColor(requireContext, R.color.warning);
        this.mDangerColor = BundleKt.getColor(requireContext, R.color.danger);
    }

    public void showSkipButton(View.OnClickListener onClickListener) {
        this.mSkipButton.setVisibility(0);
        this.mSkipButton.setOnClickListener(onClickListener);
    }
}
