package com.github.appintro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AppIntroCustomLayoutFragment extends Fragment {
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    public static final Companion Companion = new Companion(null);
    private int layoutResId;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppIntroCustomLayoutFragment newInstance(int i) {
            AppIntroCustomLayoutFragment appIntroCustomLayoutFragment = new AppIntroCustomLayoutFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AppIntroCustomLayoutFragment.ARG_LAYOUT_RES_ID, i);
            appIntroCustomLayoutFragment.setArguments(bundle);
            return appIntroCustomLayoutFragment;
        }

        private Companion() {
        }
    }

    public static final AppIntroCustomLayoutFragment newInstance(int i) {
        return Companion.newInstance(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            i = 0;
        } else {
            i = arguments.getInt(ARG_LAYOUT_RES_ID);
        }
        this.layoutResId = i;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(this.layoutResId, viewGroup, false);
    }
}
