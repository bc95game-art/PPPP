package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.navigation.Navigation;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.Month;
import com.google.android.material.slider.BaseSlider;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.View$BaseSavedState, com.google.android.material.slider.BaseSlider$SliderState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.google.android.material.badge.BadgeState$State] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View$BaseSavedState, com.google.android.material.checkbox.MaterialCheckBox$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int validateObjectHeader = Navigation.validateObjectHeader(parcel);
                long j = -1;
                int i = 0;
                String str = null;
                while (parcel.dataPosition() < validateObjectHeader) {
                    int readInt = parcel.readInt();
                    char c = (char) readInt;
                    if (c == 1) {
                        str = Navigation.createString(parcel, readInt);
                    } else if (c == 2) {
                        i = Navigation.readInt(parcel, readInt);
                    } else if (c != 3) {
                        Navigation.skipUnknownField(parcel, readInt);
                    } else {
                        Navigation.zzb(parcel, readInt, 8);
                        j = parcel.readLong();
                    }
                }
                Navigation.ensureAtEnd(parcel, validateObjectHeader);
                return new Feature(str, i, j);
            case 1:
                ?? obj = new Object();
                obj.alpha = 255;
                obj.number = -2;
                obj.maxCharacterCount = -2;
                obj.maxNumber = -2;
                obj.isVisible = Boolean.TRUE;
                obj.badgeResId = parcel.readInt();
                obj.backgroundColor = (Integer) parcel.readSerializable();
                obj.badgeTextColor = (Integer) parcel.readSerializable();
                obj.badgeTextAppearanceResId = (Integer) parcel.readSerializable();
                obj.badgeShapeAppearanceResId = (Integer) parcel.readSerializable();
                obj.badgeShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
                obj.badgeWithTextShapeAppearanceResId = (Integer) parcel.readSerializable();
                obj.badgeWithTextShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
                obj.alpha = parcel.readInt();
                obj.text = parcel.readString();
                obj.number = parcel.readInt();
                obj.maxCharacterCount = parcel.readInt();
                obj.maxNumber = parcel.readInt();
                obj.contentDescriptionForText = parcel.readString();
                obj.contentDescriptionNumberless = parcel.readString();
                obj.contentDescriptionQuantityStrings = parcel.readInt();
                obj.badgeGravity = (Integer) parcel.readSerializable();
                obj.badgeHorizontalPadding = (Integer) parcel.readSerializable();
                obj.badgeVerticalPadding = (Integer) parcel.readSerializable();
                obj.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
                obj.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
                obj.horizontalOffsetWithText = (Integer) parcel.readSerializable();
                obj.verticalOffsetWithText = (Integer) parcel.readSerializable();
                obj.largeFontVerticalOffsetAdjustment = (Integer) parcel.readSerializable();
                obj.additionalHorizontalOffset = (Integer) parcel.readSerializable();
                obj.additionalVerticalOffset = (Integer) parcel.readSerializable();
                obj.isVisible = (Boolean) parcel.readSerializable();
                obj.numberLocale = (Locale) parcel.readSerializable();
                obj.autoAdjustToWithinGrandparentBounds = (Boolean) parcel.readSerializable();
                obj.badgeFixedEdge = (Integer) parcel.readSerializable();
                return obj;
            case 2:
                ?? baseSavedState = new View.BaseSavedState(parcel);
                baseSavedState.checkedState = ((Integer) parcel.readValue(MaterialCheckBox.SavedState.class.getClassLoader())).intValue();
                return baseSavedState;
            case 3:
                return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidatorPointForward) parcel.readParcelable(DateValidatorPointForward.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt());
            case 4:
                return new DateValidatorPointForward(parcel.readLong());
            case 5:
                return Month.create(parcel.readInt(), parcel.readInt());
            default:
                ?? baseSavedState2 = new View.BaseSavedState(parcel);
                baseSavedState2.valueFrom = parcel.readFloat();
                baseSavedState2.valueTo = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                baseSavedState2.values = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                baseSavedState2.stepSize = parcel.readFloat();
                baseSavedState2.hasFocus = parcel.createBooleanArray()[0];
                return baseSavedState2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new Feature[i];
            case 1:
                return new BadgeState.State[i];
            case 2:
                return new MaterialCheckBox.SavedState[i];
            case 3:
                return new CalendarConstraints[i];
            case 4:
                return new DateValidatorPointForward[i];
            case 5:
                return new Month[i];
            default:
                return new BaseSlider.SliderState[i];
        }
    }
}
