package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import java.util.Locale;
/* loaded from: classes.dex */
public final class YearGridAdapter extends RecyclerView.Adapter {
    public final MaterialCalendar materialCalendar;

    /* loaded from: classes.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.materialCalendar.calendarConstraints.yearSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        MaterialCalendar materialCalendar = this.materialCalendar;
        int i2 = materialCalendar.calendarConstraints.start.year + i;
        viewHolder2.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        TextView textView = viewHolder2.textView;
        Context context = textView.getContext();
        if (UtcDates.getTodayCalendar().get(1) == i2) {
            str = String.format(context.getString(C0130R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2));
        } else {
            str = String.format(context.getString(C0130R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2));
        }
        textView.setContentDescription(str);
        CalendarStyle calendarStyle = materialCalendar.calendarStyle;
        if (UtcDates.getTodayCalendar().get(1) == i2) {
            Transition.C01101 r8 = calendarStyle.todayYear;
        } else {
            Transition.C01101 r82 = calendarStyle.year;
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C0130R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
