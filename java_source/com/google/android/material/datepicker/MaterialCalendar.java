package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceRecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment {
    public AccessibilityManager accessibilityManager;
    public CalendarConstraints calendarConstraints;
    public int calendarSelector;
    public CalendarStyle calendarStyle;
    public Month current;
    public View dayFrame;
    public MaterialButton monthDropSelect;
    public View monthNext;
    public View monthPrev;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$5 */
    /* loaded from: classes.dex */
    public final class C01785 extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas canvas, RecyclerView recyclerView) {
            if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                throw null;
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$6 */
    /* loaded from: classes.dex */
    public final class C01796 extends AccessibilityDelegateCompat {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ C01796(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            switch (this.$r8$classId) {
                case 3:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    accessibilityEvent.setChecked(((CheckableImageButton) this.this$0).checked);
                    return;
                default:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    return;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            int i;
            int i2 = this.$r8$classId;
            View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
            Object obj = this.this$0;
            switch (i2) {
                case 0:
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    MaterialCalendar materialCalendar = (MaterialCalendar) obj;
                    if (materialCalendar.dayFrame.getVisibility() == 0) {
                        str = materialCalendar.getString(C0130R.string.mtrl_picker_toggle_to_year_selection);
                    } else {
                        str = materialCalendar.getString(C0130R.string.mtrl_picker_toggle_to_day_selection);
                    }
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, str));
                    return;
                case 1:
                    PreferenceRecyclerViewAccessibilityDelegate preferenceRecyclerViewAccessibilityDelegate = (PreferenceRecyclerViewAccessibilityDelegate) obj;
                    preferenceRecyclerViewAccessibilityDelegate.mDefaultItemDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    RecyclerView recyclerView = preferenceRecyclerViewAccessibilityDelegate.mRecyclerView;
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter instanceof PreferenceGroupAdapter) {
                        ((PreferenceGroupAdapter) adapter).getItem(childAdapterPosition);
                        return;
                    }
                    return;
                case 2:
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                    int i3 = MaterialButtonToggleGroup.$r8$clinit;
                    if (view instanceof MaterialButton) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < materialButtonToggleGroup.getChildCount(); i5++) {
                            if (materialButtonToggleGroup.getChildAt(i5) == view) {
                                i = i4;
                                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).checked));
                                return;
                            }
                            if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i5).getVisibility() != 8) {
                                i4++;
                            }
                        }
                    }
                    i = -1;
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).checked));
                    return;
                case 3:
                    AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                    accessibilityNodeInfo.setCheckable(checkableImageButton.checkable);
                    accessibilityNodeInfo.setChecked(checkableImageButton.checked);
                    return;
                default:
                    AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.mInfo;
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                    accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).checkable);
                    return;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            switch (this.$r8$classId) {
                case 1:
                    return ((PreferenceRecyclerViewAccessibilityDelegate) this.this$0).mDefaultItemDelegate.performAccessibilityAction(view, i, bundle);
                default:
                    return super.performAccessibilityAction(view, i, bundle);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") == null) {
            this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
            if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") == null) {
                this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
                return;
            }
            throw new ClassCastException();
        }
        throw new ClassCastException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$ItemDecoration] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final int i;
        int i2;
        DaysOfWeekAdapter daysOfWeekAdapter;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.accessibilityManager = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, 16843277)) {
            i2 = C0130R.layout.mtrl_calendar_vertical;
            i = 1;
        } else {
            i2 = C0130R.layout.mtrl_calendar_horizontal;
            i = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C0130R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(C0130R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(C0130R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(C0130R.dimen.mtrl_calendar_days_of_week_height);
        int i3 = MonthAdapter.MAXIMUM_WEEKS;
        int i4 = dimensionPixelOffset + dimensionPixelSize;
        inflate.setMinimumHeight(i4 + (resources.getDimensionPixelOffset(C0130R.dimen.mtrl_calendar_month_vertical_padding) * (i3 - 1)) + (resources.getDimensionPixelSize(C0130R.dimen.mtrl_calendar_day_height) * i3) + resources.getDimensionPixelOffset(C0130R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(C0130R.C0132id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new TextInputLayout.C02112(3));
        int i5 = this.calendarConstraints.firstDayOfWeek;
        if (i5 > 0) {
            daysOfWeekAdapter = new DaysOfWeekAdapter(i5);
        } else {
            daysOfWeekAdapter = new DaysOfWeekAdapter();
        }
        gridView.setAdapter((ListAdapter) daysOfWeekAdapter);
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(C0130R.C0132id.mtrl_calendar_months);
        getContext();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(i) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                int i6 = i;
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (i6 == 0) {
                    iArr[0] = materialCalendar.recyclerView.getWidth();
                    iArr[1] = materialCalendar.recyclerView.getWidth();
                    return;
                }
                iArr[0] = materialCalendar.recyclerView.getHeight();
                iArr[1] = materialCalendar.recyclerView.getHeight();
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i6) {
                CarouselLayoutManager.C01721 r2 = new CarouselLayoutManager.C01721(recyclerView.getContext());
                r2.mTargetPosition = i6;
                startSmoothScroll(r2);
            }
        });
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.calendarConstraints, new FakeDrag(29, this));
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(C0130R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(C0130R.C0132id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager(integer));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            RecyclerView recyclerView2 = this.yearSelector;
            ?? obj = new Object();
            UtcDates.getUtcCalendarOf(null);
            UtcDates.getUtcCalendarOf(null);
            recyclerView2.addItemDecoration(obj);
        }
        View findViewById = inflate.findViewById(C0130R.C0132id.month_navigation_fragment_toggle);
        CalendarConstraints calendarConstraints = monthsPagerAdapter.calendarConstraints;
        if (findViewById != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(C0130R.C0132id.month_navigation_fragment_toggle);
            this.monthDropSelect = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(this.monthDropSelect, new C01796(0, this));
            View findViewById2 = inflate.findViewById(C0130R.C0132id.month_navigation_previous);
            this.monthPrev = findViewById2;
            findViewById2.setTag("NAVIGATION_PREV_TAG");
            View findViewById3 = inflate.findViewById(C0130R.C0132id.month_navigation_next);
            this.monthNext = findViewById3;
            findViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = inflate.findViewById(C0130R.C0132id.mtrl_calendar_year_selector_frame);
            this.dayFrame = inflate.findViewById(C0130R.C0132id.mtrl_calendar_day_selector_frame);
            setSelector$1(1);
            this.monthDropSelect.setText(this.current.getLongName());
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView recyclerView3, int i6, int i7) {
                    int i8;
                    CalendarConstraints calendarConstraints2 = monthsPagerAdapter.calendarConstraints;
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    if (i6 < 0) {
                        i8 = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    } else {
                        i8 = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    }
                    Calendar dayCopy = UtcDates.getDayCopy(calendarConstraints2.start.firstOfMonth);
                    dayCopy.add(2, i8);
                    Month month2 = new Month(dayCopy);
                    materialCalendar.current = month2;
                    MaterialButton materialButton2 = materialCalendar.monthDropSelect;
                    Calendar dayCopy2 = UtcDates.getDayCopy(calendarConstraints2.start.firstOfMonth);
                    dayCopy2.add(2, i8);
                    dayCopy2.set(5, 1);
                    Calendar dayCopy3 = UtcDates.getDayCopy(dayCopy2);
                    dayCopy3.get(2);
                    dayCopy3.get(1);
                    dayCopy3.getMaximum(7);
                    dayCopy3.getActualMaximum(5);
                    dayCopy3.getTimeInMillis();
                    materialButton2.setText(DateStrings.getYearMonth(dayCopy3.getTimeInMillis()));
                    materialCalendar.updateNavigationButtonsEnabled(calendarConstraints2.start.monthsUntil(month2));
                }
            });
            this.monthDropSelect.setOnClickListener(new Toolbar.View$OnClickListenerC00394(4, this));
            this.monthNext.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r3) {
                        case 0:
                            MaterialCalendar materialCalendar = this.this$0;
                            Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                            dayCopy.add(2, ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findFirstVisibleItemPosition() + 1);
                            materialCalendar.setCurrentMonth(new Month(dayCopy));
                            return;
                        default:
                            MaterialCalendar materialCalendar2 = this.this$0;
                            Calendar dayCopy2 = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                            dayCopy2.add(2, ((LinearLayoutManager) materialCalendar2.recyclerView.getLayoutManager()).findLastVisibleItemPosition() - 1);
                            materialCalendar2.setCurrentMonth(new Month(dayCopy2));
                            return;
                    }
                }
            });
            this.monthPrev.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r3) {
                        case 0:
                            MaterialCalendar materialCalendar = this.this$0;
                            Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                            dayCopy.add(2, ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findFirstVisibleItemPosition() + 1);
                            materialCalendar.setCurrentMonth(new Month(dayCopy));
                            return;
                        default:
                            MaterialCalendar materialCalendar2 = this.this$0;
                            Calendar dayCopy2 = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                            dayCopy2.add(2, ((LinearLayoutManager) materialCalendar2.recyclerView.getLayoutManager()).findLastVisibleItemPosition() - 1);
                            materialCalendar2.setCurrentMonth(new Month(dayCopy2));
                            return;
                    }
                }
            });
            updateNavigationButtonsEnabled(calendarConstraints.start.monthsUntil(this.current));
        }
        if (!MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, 16843277)) {
            new PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(calendarConstraints.start.monthsUntil(this.current));
        ViewCompat.setAccessibilityDelegate(this.recyclerView, new TextInputLayout.C02112(4));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void setCurrentMonth(Month month) {
        boolean z;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int monthsUntil = monthsPagerAdapter.calendarConstraints.start.monthsUntil(month);
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int monthsUntil2 = monthsUntil - monthsPagerAdapter.calendarConstraints.start.monthsUntil(this.current);
            boolean z2 = false;
            if (Math.abs(monthsUntil2) > 3) {
                z = true;
            } else {
                z = false;
            }
            if (monthsUntil2 > 0) {
                z2 = true;
            }
            this.current = month;
            if (z && z2) {
                this.recyclerView.scrollToPosition(monthsUntil - 3);
                this.recyclerView.post(new CallbackWithHandler$2(monthsUntil, 4, this));
            } else if (z) {
                this.recyclerView.scrollToPosition(monthsUntil + 3);
                this.recyclerView.post(new CallbackWithHandler$2(monthsUntil, 4, this));
            } else {
                this.recyclerView.post(new CallbackWithHandler$2(monthsUntil, 4, this));
            }
        } else {
            this.current = month;
            this.recyclerView.scrollToPosition(monthsUntil);
        }
        updateNavigationButtonsEnabled(monthsUntil);
    }

    public final void setSelector$1(int i) {
        this.calendarSelector = i;
        if (i == 2) {
            this.yearSelector.getLayoutManager().scrollToPosition(this.current.year - ((YearGridAdapter) this.yearSelector.getAdapter()).materialCalendar.calendarConstraints.start.year);
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
            this.monthPrev.setVisibility(8);
            this.monthNext.setVisibility(8);
        } else if (i == 1) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            this.monthPrev.setVisibility(0);
            this.monthNext.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    public final void updateNavigationButtonsEnabled(int i) {
        boolean z;
        View view = this.monthNext;
        boolean z2 = false;
        if (i + 1 < this.recyclerView.getAdapter().getItemCount()) {
            z = true;
        } else {
            z = false;
        }
        view.setEnabled(z);
        View view2 = this.monthPrev;
        if (i - 1 >= 0) {
            z2 = true;
        }
        view2.setEnabled(z2);
    }
}
