package com.github.appintro;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p002os.BundleKt;
import androidx.fragment.app.Fragment;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class AppIntroBaseFragment extends Fragment implements SlideSelectionListener, SlideBackgroundColorHolder {
    private int bgDrawable;
    private int defaultBackgroundColor;
    private int defaultBackgroundColorRes;
    private int descColor;
    private int descColorRes;
    private TypefaceContainer descTypeface;
    private String description;
    private int drawable;
    private final String logTAG = LogHelper.makeLogTag(AppIntroBaseFragment.class);
    private String title;
    private int titleColor;
    private int titleColorRes;
    private TypefaceContainer titleTypeface;

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColorRes() {
        return this.defaultBackgroundColorRes;
    }

    public abstract int getLayoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.drawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE);
            this.description = bundle.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.titleTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, 0));
            this.descTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, 0));
            this.defaultBackgroundColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.defaultBackgroundColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES);
            this.bgDrawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            this.titleColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR);
            this.titleColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES);
            this.descColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR);
            this.descColorRes = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() != 0) {
            this.drawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE);
            this.description = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.bgDrawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            String string = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE);
            String string2 = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE);
            int i = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES);
            int i2 = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES);
            this.titleTypeface = new TypefaceContainer(string, i);
            this.descTypeface = new TypefaceContainer(string2, i2);
            this.defaultBackgroundColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.defaultBackgroundColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES);
            this.titleColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, 0);
            this.titleColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, 0);
            this.descColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, 0);
            this.descColorRes = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(getLayoutId(), viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0161R.C0163id.title);
        TextView textView2 = (TextView) inflate.findViewById(C0161R.C0163id.description);
        ImageView imageView = (ImageView) inflate.findViewById(C0161R.C0163id.image);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(C0161R.C0163id.main);
        textView.setText(this.title);
        textView2.setText(this.description);
        if (this.titleColorRes != 0) {
            textView.setTextColor(BundleKt.getColor(requireContext(), this.titleColorRes));
        } else {
            int i = this.titleColor;
            if (i != 0) {
                textView.setTextColor(i);
            }
        }
        if (this.descColorRes != 0) {
            textView2.setTextColor(BundleKt.getColor(requireContext(), this.descColorRes));
        } else {
            int i2 = this.descColor;
            if (i2 != 0) {
                textView2.setTextColor(i2);
            }
        }
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            typefaceContainer.applyTo(textView);
        }
        TypefaceContainer typefaceContainer2 = this.descTypeface;
        if (typefaceContainer2 != null) {
            typefaceContainer2.applyTo(textView2);
        }
        imageView.setImageResource(this.drawable);
        int i3 = this.bgDrawable;
        if (i3 != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(i3);
            }
        } else if (this.defaultBackgroundColorRes != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundColor(BundleKt.getColor(requireContext(), this.defaultBackgroundColorRes));
            }
        } else if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(this.defaultBackgroundColor);
        }
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView2.setMovementMethod(new ScrollingMovementMethod());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ImageView imageView;
        super.onPause();
        View view = getView();
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(C0161R.C0163id.image);
        }
        if (imageView instanceof Animatable) {
            ((Animatable) imageView).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ImageView imageView;
        super.onResume();
        View view = getView();
        if (view == null) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(C0161R.C0163id.image);
        }
        if (imageView instanceof Animatable) {
            ((Animatable) imageView).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.drawable);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.bgDrawable);
        outState.putString(AppIntroBaseFragmentKt.ARG_TITLE, this.title);
        outState.putString(AppIntroBaseFragmentKt.ARG_DESC, this.description);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.defaultBackgroundColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES, this.defaultBackgroundColorRes);
        outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, this.titleColorRes);
        outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, this.descColorRes);
        TypefaceContainer typefaceContainer = this.titleTypeface;
        int i2 = 0;
        String str2 = null;
        if (typefaceContainer != null) {
            if (typefaceContainer == null) {
                str = null;
            } else {
                str = typefaceContainer.getTypeFaceUrl();
            }
            outState.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, str);
            TypefaceContainer typefaceContainer2 = this.titleTypeface;
            if (typefaceContainer2 == null) {
                i = 0;
            } else {
                i = typefaceContainer2.getTypeFaceResource();
            }
            outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, i);
        }
        TypefaceContainer typefaceContainer3 = this.descTypeface;
        if (typefaceContainer3 != null) {
            if (typefaceContainer3 != null) {
                str2 = typefaceContainer3.getTypeFaceUrl();
            }
            outState.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, str2);
            TypefaceContainer typefaceContainer4 = this.descTypeface;
            if (typefaceContainer4 != null) {
                i2 = typefaceContainer4.getTypeFaceResource();
            }
            outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, i2);
        }
        super.onSaveInstanceState(outState);
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        String str = this.logTAG;
        LogHelper.m577d(str, "Slide " + ((Object) this.title) + " has been deselected.");
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        String str = this.logTAG;
        LogHelper.m577d(str, "Slide " + ((Object) this.title) + " has been selected.");
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public void setBackgroundColor(int i) {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view != null && (constraintLayout = (ConstraintLayout) view.findViewById(C0161R.C0163id.main)) != null) {
            constraintLayout.setBackgroundColor(i);
        }
    }
}
