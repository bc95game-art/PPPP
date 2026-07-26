package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class CalendarStyle {
    public final Transition.AnonymousClass1 todayYear;
    public final Transition.AnonymousClass1 year;

    public CalendarStyle(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LazyKt__LazyJVMKt.resolveTypedValueOrThrow(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()).data, R$styleable.MaterialCalendar);
        Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(4, 0));
        Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(2, 0));
        Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(3, 0));
        Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList colorStateList = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 7);
        this.year = Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(9, 0));
        Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(8, 0));
        this.todayYear = Transition.AnonymousClass1.create(context, obtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
