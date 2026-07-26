package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.emanuelef.remote_capture.C0130R;
import java.util.Calendar;
/* loaded from: classes.dex */
public final class MonthAdapter extends BaseAdapter {
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final Month month;
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendarOf(null).getMaximum(4);
    public static final int MAXIMUM_GRID_CELLS = (UtcDates.getUtcCalendarOf(null).getMaximum(7) + UtcDates.getUtcCalendarOf(null).getMaximum(5)) - 1;

    public MonthAdapter(Month month, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.calendarConstraints = calendarConstraints;
        throw null;
    }

    public final int firstPositionInMonth() {
        int i = this.calendarConstraints.firstDayOfWeek;
        Month month = this.month;
        Calendar calendar = month.firstOfMonth;
        int i2 = calendar.get(7);
        if (i <= 0) {
            i = calendar.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            return i3 + month.daysInWeek;
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C0130R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            Month month = this.month;
            if (firstPositionInMonth < month.daysInMonth) {
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(firstPositionInMonth + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                UtcDates.getTodayCalendar().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i) == null) {
            textView.getContext();
            UtcDates.getTodayCalendar().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }

    public final int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    @Override // android.widget.Adapter
    public final Long getItem(int i) {
        if (i < firstPositionInMonth() || i > lastPositionInMonth()) {
            return null;
        }
        Calendar dayCopy = UtcDates.getDayCopy(this.month.firstOfMonth);
        dayCopy.set(5, (i - firstPositionInMonth()) + 1);
        return Long.valueOf(dayCopy.getTimeInMillis());
    }
}
