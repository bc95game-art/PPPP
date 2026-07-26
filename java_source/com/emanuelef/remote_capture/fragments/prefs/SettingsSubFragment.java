package com.emanuelef.remote_capture.fragments.prefs;

import android.os.Bundle;
import android.view.View;
import androidx.preference.PreferenceFragmentCompat;
import com.emanuelef.remote_capture.interfaces.FragmentViewCreatedListener;
/* loaded from: classes.dex */
public abstract class SettingsSubFragment extends PreferenceFragmentCompat {
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setFitsSystemWindows(true);
        if (getActivity() instanceof FragmentViewCreatedListener) {
            ((FragmentViewCreatedListener) requireActivity()).onFragmentViewCreated(view);
        }
    }
}
