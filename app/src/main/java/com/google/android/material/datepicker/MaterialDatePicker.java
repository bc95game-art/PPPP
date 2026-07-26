package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl20;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.fragment.app.DialogFragment;
import androidx.tracing.Trace;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class MaterialDatePicker<S> extends DialogFragment {
    public MaterialShapeDrawable background;
    public MaterialCalendar calendar;
    public CalendarConstraints calendarConstraints;
    public boolean edgeToEdgeEnabled;
    public CharSequence fullTitleText;
    public boolean fullscreen;
    public TextView headerTitleTextView;
    public CheckableImageButton headerToggleButton;
    public int inputMode;
    public CharSequence negativeButtonContentDescription;
    public int negativeButtonContentDescriptionResId;
    public CharSequence negativeButtonText;
    public int negativeButtonTextResId;
    public final LinkedHashSet onCancelListeners = new LinkedHashSet();
    public final LinkedHashSet onDismissListeners = new LinkedHashSet();
    public int overrideThemeResId;
    public PickerFragment pickerFragment;
    public CharSequence positiveButtonContentDescription;
    public int positiveButtonContentDescriptionResId;
    public CharSequence positiveButtonText;
    public int positiveButtonTextResId;
    public CharSequence singleLineTitleText;
    public CharSequence titleText;
    public int titleTextResId;

    public MaterialDatePicker() {
        new LinkedHashSet();
        new LinkedHashSet();
    }

    public static int getPaddedPickerWidth(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        todayCalendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(todayCalendar);
        dayCopy.get(2);
        dayCopy.get(1);
        int maximum = dayCopy.getMaximum(7);
        dayCopy.getActualMaximum(5);
        dayCopy.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean readMaterialCalendarStyleBoolean(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LazyKt__LazyJVMKt.resolveTypedValueOrThrow(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()).data, new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void getDateSelector() {
        if (getArguments().getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") == null) {
            this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
            if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") == null) {
                this.titleTextResId = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
                this.titleText = bundle.getCharSequence("TITLE_TEXT_KEY");
                this.inputMode = bundle.getInt("INPUT_MODE_KEY");
                this.positiveButtonTextResId = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
                this.positiveButtonText = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
                this.positiveButtonContentDescriptionResId = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
                this.positiveButtonContentDescription = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
                this.negativeButtonTextResId = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
                this.negativeButtonText = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
                this.negativeButtonContentDescriptionResId = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
                this.negativeButtonContentDescription = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
                CharSequence charSequence = this.titleText;
                if (charSequence == null) {
                    charSequence = requireContext().getResources().getText(this.titleTextResId);
                }
                this.fullTitleText = charSequence;
                if (charSequence != null) {
                    CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
                    if (split.length > 1) {
                        charSequence = split[0];
                    }
                } else {
                    charSequence = null;
                }
                this.singleLineTitleText = charSequence;
                return;
            }
            throw new ClassCastException();
        }
        throw new ClassCastException();
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog() {
        Context requireContext = requireContext();
        requireContext();
        int i = this.overrideThemeResId;
        if (i != 0) {
            Dialog dialog = new Dialog(requireContext, i);
            Context context = dialog.getContext();
            this.fullscreen = readMaterialCalendarStyleBoolean(context, 16843277);
            this.background = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialCalendar, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
            int color = obtainStyledAttributes.getColor(1, 0);
            obtainStyledAttributes.recycle();
            this.background.initializeElevationOverlay(context);
            this.background.setFillColor(ColorStateList.valueOf(color));
            this.background.setElevation(dialog.getWindow().getDecorView().getElevation());
            return dialog;
        }
        getDateSelector();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String str;
        if (this.fullscreen) {
            i = R.layout.mtrl_picker_fullscreen;
        } else {
            i = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i, viewGroup);
        Context context = inflate.getContext();
        if (this.fullscreen) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
        }
        ((TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text)).setAccessibilityLiveRegion(1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.headerTitleTextView = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        this.headerToggleButton.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.headerToggleButton;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, BundleKt.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        boolean z = false;
        stateListDrawable.addState(new int[0], BundleKt.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        CheckableImageButton checkableImageButton2 = this.headerToggleButton;
        if (this.inputMode != 0) {
            z = true;
        }
        checkableImageButton2.setChecked(z);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        CheckableImageButton checkableImageButton3 = this.headerToggleButton;
        if (this.inputMode == 1) {
            str = checkableImageButton3.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton3.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(str);
        this.headerToggleButton.setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(8, this));
        Button button = (Button) inflate.findViewById(R.id.confirm_button);
        getDateSelector();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.google.android.material.datepicker.CalendarConstraints$Builder] */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Month month;
        Month month2;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        ?? obj = new Object();
        int i = CalendarConstraints.Builder.$r8$clinit;
        int i2 = CalendarConstraints.Builder.$r8$clinit;
        long j = calendarConstraints.start.timeInMillis;
        long j2 = calendarConstraints.end.timeInMillis;
        obj.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
        int i3 = calendarConstraints.firstDayOfWeek;
        DateValidatorPointForward dateValidatorPointForward = calendarConstraints.validator;
        MaterialCalendar materialCalendar = this.calendar;
        if (materialCalendar == null) {
            month = null;
        } else {
            month = materialCalendar.current;
        }
        if (month != null) {
            obj.openAt = Long.valueOf(month.timeInMillis);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidatorPointForward);
        Month create = Month.create(j);
        Month create2 = Month.create(j2);
        DateValidatorPointForward dateValidatorPointForward2 = (DateValidatorPointForward) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = obj.openAt;
        if (l == null) {
            month2 = null;
        } else {
            month2 = Month.create(l.longValue());
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(create, create2, dateValidatorPointForward2, month2, i3));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
        bundle.putInt("INPUT_MODE_KEY", this.inputMode);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.positiveButtonTextResId);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.positiveButtonText);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.positiveButtonContentDescriptionResId);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.positiveButtonContentDescription);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.negativeButtonTextResId);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.negativeButtonText);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.negativeButtonContentDescriptionResId);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.negativeButtonContentDescription);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        CharSequence charSequence;
        Integer num;
        boolean z;
        int i;
        int i2;
        boolean z2;
        BundleKt bundleKt;
        BundleKt bundleKt2;
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
            if (!this.edgeToEdgeEnabled) {
                final View findViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListOrNull = Trace.getColorStateListOrNull(findViewById.getBackground());
                if (colorStateListOrNull != null) {
                    num = Integer.valueOf(colorStateListOrNull.getDefaultColor());
                } else {
                    num = null;
                }
                boolean z3 = false;
                if (num == null || num.intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                int color = LazyKt__LazyJVMKt.getColor(window.getContext(), 16842801, -16777216);
                if (z) {
                    num = Integer.valueOf(color);
                }
                BundleKt.setDecorFitsSystemWindows(window, false);
                Context context = window.getContext();
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 23) {
                    i = ColorUtils.setAlphaComponent(LazyKt__LazyJVMKt.getColor(context, 16843857, -16777216), 128);
                } else {
                    i = 0;
                }
                Context context2 = window.getContext();
                if (i3 < 27) {
                    i2 = ColorUtils.setAlphaComponent(LazyKt__LazyJVMKt.getColor(context2, 16843858, -16777216), 128);
                } else {
                    i2 = 0;
                }
                window.setStatusBarColor(i);
                window.setNavigationBarColor(i2);
                boolean isColorLight = LazyKt__LazyJVMKt.isColorLight(num.intValue());
                if (LazyKt__LazyJVMKt.isColorLight(i) || (i == 0 && isColorLight)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Transition.AnonymousClass1 r9 = new Transition.AnonymousClass1(window.getDecorView());
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 30) {
                    bundleKt = new WindowInsetsControllerCompat$Impl30(window, r9);
                } else if (i4 >= 26) {
                    bundleKt = new WindowInsetsControllerCompat$Impl20(window, r9);
                } else if (i4 >= 23) {
                    bundleKt = new WindowInsetsControllerCompat$Impl20(window, r9);
                } else {
                    bundleKt = new WindowInsetsControllerCompat$Impl20(window, r9);
                }
                bundleKt.setAppearanceLightStatusBars(z2);
                boolean isColorLight2 = LazyKt__LazyJVMKt.isColorLight(color);
                if (LazyKt__LazyJVMKt.isColorLight(i2) || (i2 == 0 && isColorLight2)) {
                    z3 = true;
                }
                Transition.AnonymousClass1 r5 = new Transition.AnonymousClass1(window.getDecorView());
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 30) {
                    bundleKt2 = new WindowInsetsControllerCompat$Impl30(window, r5);
                } else if (i5 >= 26) {
                    bundleKt2 = new WindowInsetsControllerCompat$Impl20(window, r5);
                } else if (i5 >= 23) {
                    bundleKt2 = new WindowInsetsControllerCompat$Impl20(window, r5);
                } else {
                    bundleKt2 = new WindowInsetsControllerCompat$Impl20(window, r5);
                }
                bundleKt2.setAppearanceLightNavigationBars(z3);
                final int paddingTop = findViewById.getPaddingTop();
                final int paddingLeft = findViewById.getPaddingLeft();
                final int paddingRight = findViewById.getPaddingRight();
                final int i6 = findViewById.getLayoutParams().height;
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        Insets insets = windowInsetsCompat.mImpl.getInsets(7);
                        View view2 = findViewById;
                        int i7 = i6;
                        if (i7 >= 0) {
                            view2.getLayoutParams().height = i7 + insets.top;
                            view2.setLayoutParams(view2.getLayoutParams());
                        }
                        view2.setPadding(paddingLeft + insets.left, paddingTop + insets.top, paddingRight + insets.right, view2.getPaddingBottom());
                        return windowInsetsCompat;
                    }
                };
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, onApplyWindowInsetsListener);
                this.edgeToEdgeEnabled = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        requireContext();
        int i7 = this.overrideThemeResId;
        if (i7 != 0) {
            getDateSelector();
            CalendarConstraints calendarConstraints = this.calendarConstraints;
            MaterialCalendar materialCalendar = new MaterialCalendar();
            Bundle bundle = new Bundle();
            bundle.putInt("THEME_RES_ID_KEY", i7);
            bundle.putParcelable("GRID_SELECTOR_KEY", null);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
            bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
            bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.openAt);
            materialCalendar.setArguments(bundle);
            this.calendar = materialCalendar;
            PickerFragment pickerFragment = materialCalendar;
            if (this.inputMode == 1) {
                getDateSelector();
                CalendarConstraints calendarConstraints2 = this.calendarConstraints;
                PickerFragment materialTextInputPicker = new MaterialTextInputPicker();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("THEME_RES_ID_KEY", i7);
                bundle2.putParcelable("DATE_SELECTOR_KEY", null);
                bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
                materialTextInputPicker.setArguments(bundle2);
                pickerFragment = materialTextInputPicker;
            }
            this.pickerFragment = pickerFragment;
            TextView textView = this.headerTitleTextView;
            if (this.inputMode == 1 && getResources().getConfiguration().orientation == 2) {
                charSequence = this.singleLineTitleText;
            } else {
                charSequence = this.fullTitleText;
            }
            textView.setText(charSequence);
            getDateSelector();
            getContext();
            throw null;
        }
        getDateSelector();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.pickerFragment.onSelectionChangedListeners.clear();
        super.onStop();
    }
}
