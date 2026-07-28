package com.emanuelef.remote_capture.activities;

import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.Preference;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
import com.google.android.material.slider.LabelFormatter;
/* loaded from: classes.dex */
public final /* synthetic */ class BaseActivity$$ExternalSyntheticLambda0 implements Transition.TransitionNotification, OnApplyWindowInsetsListener, LabelFormatter, ActivityResultCallback, Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BaseActivity$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.material.slider.LabelFormatter
    public String getFormattedValue(float f) {
        String lambda$onCreate$1;
        String lambda$onCreate$0;
        switch (this.$r8$classId) {
            case 21:
                lambda$onCreate$1 = EditFilterActivity.lambda$onCreate$1(f);
                return lambda$onCreate$1;
            default:
                lambda$onCreate$0 = HttpLogFilterActivity.lambda$onCreate$0(f);
                return lambda$onCreate$0;
        }
    }

    @Override // androidx.transition.Transition.TransitionNotification
    public void notifyListener(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        switch (this.$r8$classId) {
            case 15:
                transitionListener.onTransitionStart$1(transition);
                return;
            case 16:
                transitionListener.onTransitionEnd$1(transition);
                return;
            case 17:
                transitionListener.onTransitionCancel(transition);
                return;
            case 18:
                transitionListener.onTransitionPause();
                return;
            default:
                transitionListener.onTransitionResume();
                return;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        MainActivity.lambda$new$0((Boolean) obj);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$setContentView$0;
        WindowInsetsCompat lambda$onCreate$0;
        WindowInsetsCompat lambda$onCreate$02;
        WindowInsetsCompat lambda$setupNavigationDrawer$3;
        WindowInsetsCompat lambda$onViewCreated$0;
        switch (this.$r8$classId) {
            case 0:
                lambda$setContentView$0 = BaseActivity.lambda$setContentView$0(view, windowInsetsCompat);
                return lambda$setContentView$0;
            case 20:
                lambda$onCreate$0 = AboutActivity.lambda$onCreate$0(view, windowInsetsCompat);
                return lambda$onCreate$0;
            case 22:
                lambda$onCreate$02 = ErrorActivity.lambda$onCreate$0(view, windowInsetsCompat);
                return lambda$onCreate$02;
            case 25:
                lambda$setupNavigationDrawer$3 = MainActivity.lambda$setupNavigationDrawer$3(view, windowInsetsCompat);
                return lambda$setupNavigationDrawer$3;
            default:
                lambda$onViewCreated$0 = SettingsActivity.SettingsFragment.lambda$onViewCreated$0(view, windowInsetsCompat);
                return lambda$onViewCreated$0;
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean lambda$setupExporterPrefs$3;
        lambda$setupExporterPrefs$3 = SettingsActivity.SettingsFragment.lambda$setupExporterPrefs$3(preference, obj);
        return lambda$setupExporterPrefs$3;
    }
}
