package com.google.android.gms.common;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.BackStackRecordState;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentState;
import androidx.navigation.Navigation;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SeekBarPreference;
import androidx.preference.TwoStatePreference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zzk;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zzb implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzb(int i) {
        this.$r8$classId = i;
    }

    public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zza = Navigation.zza(parcel, 20293);
        int i2 = getServiceRequest.zzc;
        Navigation.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.zzd;
        Navigation.zzc(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.zze;
        Navigation.zzc(parcel, 3, 4);
        parcel.writeInt(i4);
        Navigation.writeString(parcel, 4, getServiceRequest.zzf);
        IBinder iBinder = getServiceRequest.zzg;
        if (iBinder != null) {
            int zza2 = Navigation.zza(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            Navigation.zzb(parcel, zza2);
        }
        Navigation.writeTypedArray(parcel, 6, getServiceRequest.zzh, i);
        Bundle bundle = getServiceRequest.zzi;
        if (bundle != null) {
            int zza3 = Navigation.zza(parcel, 7);
            parcel.writeBundle(bundle);
            Navigation.zzb(parcel, zza3);
        }
        Navigation.writeParcelable(parcel, 8, getServiceRequest.zzj, i);
        Navigation.writeTypedArray(parcel, 10, getServiceRequest.zzk, i);
        Navigation.writeTypedArray(parcel, 11, getServiceRequest.zzl, i);
        boolean z = getServiceRequest.zzm;
        Navigation.zzc(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i5 = getServiceRequest.zzn;
        Navigation.zzc(parcel, 13, 4);
        parcel.writeInt(i5);
        boolean z2 = getServiceRequest.zzo;
        Navigation.zzc(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        Navigation.writeString(parcel, 15, getServiceRequest.zzp);
        Navigation.zzb(parcel, zza);
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, com.google.android.gms.common.internal.zzk] */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.fragment.app.FragmentManager$LaunchedFragmentInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20, types: [androidx.recyclerview.widget.LinearLayoutManager$SavedState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, androidx.appcompat.widget.ActionMenuPresenter$SavedState] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.view.View$BaseSavedState, androidx.appcompat.widget.AppCompatSpinner$SavedState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View$BaseSavedState, androidx.core.widget.NestedScrollView$SavedState, java.lang.Object] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel inParcel) {
        boolean z;
        boolean z2;
        boolean z3;
        switch (this.$r8$classId) {
            case 0:
                int validateObjectHeader = Navigation.validateObjectHeader(inParcel);
                PendingIntent pendingIntent = null;
                String str = null;
                int i = 0;
                int i2 = 0;
                while (inParcel.dataPosition() < validateObjectHeader) {
                    int readInt = inParcel.readInt();
                    char c = (char) readInt;
                    if (c == 1) {
                        i = Navigation.readInt(inParcel, readInt);
                    } else if (c == 2) {
                        i2 = Navigation.readInt(inParcel, readInt);
                    } else if (c == 3) {
                        pendingIntent = (PendingIntent) Navigation.createParcelable(inParcel, readInt, PendingIntent.CREATOR);
                    } else if (c != 4) {
                        Navigation.skipUnknownField(inParcel, readInt);
                    } else {
                        str = Navigation.createString(inParcel, readInt);
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader);
                return new ConnectionResult(i, i2, pendingIntent, str);
            case 1:
                return new ActivityResult(inParcel);
            case 2:
                Intrinsics.checkNotNullParameter(inParcel, "inParcel");
                Parcelable readParcelable = inParcel.readParcelable(IntentSender.class.getClassLoader());
                Intrinsics.checkNotNull(readParcelable);
                return new IntentSenderRequest((IntentSender) readParcelable, (Intent) inParcel.readParcelable(Intent.class.getClassLoader()), inParcel.readInt(), inParcel.readInt());
            case 3:
                ?? obj = new Object();
                obj.openSubMenuId = inParcel.readInt();
                return obj;
            case 4:
                ?? baseSavedState = new View.BaseSavedState(inParcel);
                if (inParcel.readByte() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                baseSavedState.mShowDropdown = z;
                return baseSavedState;
            case 5:
                ?? baseSavedState2 = new View.BaseSavedState(inParcel);
                baseSavedState2.scrollPosition = inParcel.readInt();
                return baseSavedState2;
            case 6:
                return new BackStackRecordState(inParcel);
            case 7:
                return new BackStackState(inParcel);
            case 8:
                ?? obj2 = new Object();
                obj2.mWho = inParcel.readString();
                obj2.mRequestCode = inParcel.readInt();
                return obj2;
            case 9:
                ?? obj3 = new Object();
                obj3.mPrimaryNavActiveWho = null;
                obj3.mBackStackStateKeys = new ArrayList();
                obj3.mBackStackStates = new ArrayList();
                obj3.mActive = inParcel.createStringArrayList();
                obj3.mAdded = inParcel.createStringArrayList();
                obj3.mBackStack = (BackStackRecordState[]) inParcel.createTypedArray(BackStackRecordState.CREATOR);
                obj3.mBackStackIndex = inParcel.readInt();
                obj3.mPrimaryNavActiveWho = inParcel.readString();
                obj3.mBackStackStateKeys = inParcel.createStringArrayList();
                obj3.mBackStackStates = inParcel.createTypedArrayList(BackStackState.CREATOR);
                obj3.mLaunchedFragments = inParcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
                return obj3;
            case 10:
                return new FragmentState(inParcel);
            case 11:
                return new EditTextPreference.SavedState(inParcel);
            case 12:
                return new ListPreference.SavedState(inParcel);
            case 13:
                return new MultiSelectListPreference.SavedState(inParcel);
            case 14:
                return new Preference.BaseSavedState(inParcel);
            case 15:
                return new PreferenceGroup.SavedState(inParcel);
            case 16:
                return new SeekBarPreference.SavedState(inParcel);
            case 17:
                return new TwoStatePreference.SavedState(inParcel);
            case 18:
                ?? obj4 = new Object();
                obj4.mAnchorPosition = inParcel.readInt();
                obj4.mAnchorOffset = inParcel.readInt();
                boolean z4 = true;
                if (inParcel.readInt() != 1) {
                    z4 = false;
                }
                obj4.mAnchorLayoutFromEnd = z4;
                return obj4;
            case 19:
                ?? obj5 = new Object();
                obj5.mPosition = inParcel.readInt();
                obj5.mGapDir = inParcel.readInt();
                boolean z5 = true;
                if (inParcel.readInt() != 1) {
                    z5 = false;
                }
                obj5.mHasUnwantedGapAfter = z5;
                int readInt2 = inParcel.readInt();
                if (readInt2 > 0) {
                    int[] iArr = new int[readInt2];
                    obj5.mGapPerSpan = iArr;
                    inParcel.readIntArray(iArr);
                }
                return obj5;
            case 20:
                ?? obj6 = new Object();
                obj6.mAnchorPosition = inParcel.readInt();
                obj6.mVisibleAnchorPosition = inParcel.readInt();
                int readInt3 = inParcel.readInt();
                obj6.mSpanOffsetsSize = readInt3;
                if (readInt3 > 0) {
                    int[] iArr2 = new int[readInt3];
                    obj6.mSpanOffsets = iArr2;
                    inParcel.readIntArray(iArr2);
                }
                int readInt4 = inParcel.readInt();
                obj6.mSpanLookupSize = readInt4;
                if (readInt4 > 0) {
                    int[] iArr3 = new int[readInt4];
                    obj6.mSpanLookup = iArr3;
                    inParcel.readIntArray(iArr3);
                }
                boolean z6 = false;
                if (inParcel.readInt() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                obj6.mReverseLayout = z2;
                if (inParcel.readInt() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                obj6.mAnchorLayoutFromEnd = z3;
                if (inParcel.readInt() == 1) {
                    z6 = true;
                }
                obj6.mLastLayoutRTL = z6;
                obj6.mFullSpanItems = inParcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
                return obj6;
            case 21:
                return new ParcelImpl(inParcel);
            case 22:
                int validateObjectHeader2 = Navigation.validateObjectHeader(inParcel);
                String str2 = null;
                int i3 = 0;
                while (inParcel.dataPosition() < validateObjectHeader2) {
                    int readInt5 = inParcel.readInt();
                    char c2 = (char) readInt5;
                    if (c2 == 1) {
                        i3 = Navigation.readInt(inParcel, readInt5);
                    } else if (c2 != 2) {
                        Navigation.skipUnknownField(inParcel, readInt5);
                    } else {
                        str2 = Navigation.createString(inParcel, readInt5);
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader2);
                return new Scope(i3, str2);
            case 23:
                int validateObjectHeader3 = Navigation.validateObjectHeader(inParcel);
                String str3 = null;
                PendingIntent pendingIntent2 = null;
                ConnectionResult connectionResult = null;
                int i4 = 0;
                while (inParcel.dataPosition() < validateObjectHeader3) {
                    int readInt6 = inParcel.readInt();
                    char c3 = (char) readInt6;
                    if (c3 == 1) {
                        i4 = Navigation.readInt(inParcel, readInt6);
                    } else if (c3 == 2) {
                        str3 = Navigation.createString(inParcel, readInt6);
                    } else if (c3 == 3) {
                        pendingIntent2 = (PendingIntent) Navigation.createParcelable(inParcel, readInt6, PendingIntent.CREATOR);
                    } else if (c3 != 4) {
                        Navigation.skipUnknownField(inParcel, readInt6);
                    } else {
                        connectionResult = (ConnectionResult) Navigation.createParcelable(inParcel, readInt6, ConnectionResult.CREATOR);
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader3);
                return new Status(i4, str3, pendingIntent2, connectionResult);
            case 24:
                int validateObjectHeader4 = Navigation.validateObjectHeader(inParcel);
                int i5 = 0;
                while (true) {
                    ArrayList arrayList = null;
                    while (inParcel.dataPosition() < validateObjectHeader4) {
                        int readInt7 = inParcel.readInt();
                        char c4 = (char) readInt7;
                        if (c4 == 1) {
                            i5 = Navigation.readInt(inParcel, readInt7);
                        } else if (c4 != 2) {
                            Navigation.skipUnknownField(inParcel, readInt7);
                        } else {
                            Parcelable.Creator<MethodInvocation> creator = MethodInvocation.CREATOR;
                            int readSize = Navigation.readSize(inParcel, readInt7);
                            int dataPosition = inParcel.dataPosition();
                            if (readSize == 0) {
                                break;
                            }
                            arrayList = inParcel.createTypedArrayList(creator);
                            inParcel.setDataPosition(dataPosition + readSize);
                        }
                    }
                    Navigation.ensureAtEnd(inParcel, validateObjectHeader4);
                    return new TelemetryData(i5, arrayList);
                    break;
                }
            case 25:
                int validateObjectHeader5 = Navigation.validateObjectHeader(inParcel);
                String str4 = null;
                String str5 = null;
                long j = 0;
                long j2 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = -1;
                while (inParcel.dataPosition() < validateObjectHeader5) {
                    int readInt8 = inParcel.readInt();
                    switch ((char) readInt8) {
                        case 1:
                            i6 = Navigation.readInt(inParcel, readInt8);
                            break;
                        case 2:
                            i7 = Navigation.readInt(inParcel, readInt8);
                            break;
                        case 3:
                            i8 = Navigation.readInt(inParcel, readInt8);
                            break;
                        case 4:
                            Navigation.zzb(inParcel, readInt8, 8);
                            j = inParcel.readLong();
                            break;
                        case 5:
                            Navigation.zzb(inParcel, readInt8, 8);
                            j2 = inParcel.readLong();
                            break;
                        case 6:
                            str4 = Navigation.createString(inParcel, readInt8);
                            break;
                        case 7:
                            str5 = Navigation.createString(inParcel, readInt8);
                            break;
                        case '\b':
                            i9 = Navigation.readInt(inParcel, readInt8);
                            break;
                        case '\t':
                            i10 = Navigation.readInt(inParcel, readInt8);
                            break;
                        default:
                            Navigation.skipUnknownField(inParcel, readInt8);
                            break;
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader5);
                return new MethodInvocation(i6, i7, i8, j, j2, str4, str5, i9, i10);
            case 26:
                int validateObjectHeader6 = Navigation.validateObjectHeader(inParcel);
                int i11 = 0;
                boolean z7 = false;
                boolean z8 = false;
                int i12 = 0;
                int i13 = 0;
                while (inParcel.dataPosition() < validateObjectHeader6) {
                    int readInt9 = inParcel.readInt();
                    char c5 = (char) readInt9;
                    if (c5 == 1) {
                        i11 = Navigation.readInt(inParcel, readInt9);
                    } else if (c5 == 2) {
                        z7 = Navigation.readBoolean(inParcel, readInt9);
                    } else if (c5 == 3) {
                        z8 = Navigation.readBoolean(inParcel, readInt9);
                    } else if (c5 == 4) {
                        i12 = Navigation.readInt(inParcel, readInt9);
                    } else if (c5 != 5) {
                        Navigation.skipUnknownField(inParcel, readInt9);
                    } else {
                        i13 = Navigation.readInt(inParcel, readInt9);
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader6);
                return new RootTelemetryConfiguration(i11, z7, z8, i12, i13);
            case 27:
                int validateObjectHeader7 = Navigation.validateObjectHeader(inParcel);
                int i14 = 0;
                Bundle bundle = null;
                Feature[] featureArr = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                while (inParcel.dataPosition() < validateObjectHeader7) {
                    int readInt10 = inParcel.readInt();
                    char c6 = (char) readInt10;
                    if (c6 == 1) {
                        int readSize2 = Navigation.readSize(inParcel, readInt10);
                        int dataPosition2 = inParcel.dataPosition();
                        if (readSize2 == 0) {
                            bundle = null;
                        } else {
                            Bundle readBundle = inParcel.readBundle();
                            inParcel.setDataPosition(dataPosition2 + readSize2);
                            bundle = readBundle;
                        }
                    } else if (c6 == 2) {
                        featureArr = (Feature[]) Navigation.createTypedArray(inParcel, readInt10, Feature.CREATOR);
                    } else if (c6 == 3) {
                        i14 = Navigation.readInt(inParcel, readInt10);
                    } else if (c6 != 4) {
                        Navigation.skipUnknownField(inParcel, readInt10);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) Navigation.createParcelable(inParcel, readInt10, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader7);
                ?? obj7 = new Object();
                obj7.zza = bundle;
                obj7.zzb = featureArr;
                obj7.zzc = i14;
                obj7.zzd = connectionTelemetryConfiguration;
                return obj7;
            case 28:
                int validateObjectHeader8 = Navigation.validateObjectHeader(inParcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArr4 = null;
                int[] iArr5 = null;
                boolean z9 = false;
                boolean z10 = false;
                int i15 = 0;
                while (inParcel.dataPosition() < validateObjectHeader8) {
                    int readInt11 = inParcel.readInt();
                    switch ((char) readInt11) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) Navigation.createParcelable(inParcel, readInt11, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            z9 = Navigation.readBoolean(inParcel, readInt11);
                            break;
                        case 3:
                            z10 = Navigation.readBoolean(inParcel, readInt11);
                            break;
                        case 4:
                            int readSize3 = Navigation.readSize(inParcel, readInt11);
                            int dataPosition3 = inParcel.dataPosition();
                            if (readSize3 != 0) {
                                iArr4 = inParcel.createIntArray();
                                inParcel.setDataPosition(dataPosition3 + readSize3);
                                break;
                            } else {
                                iArr4 = null;
                                break;
                            }
                        case 5:
                            i15 = Navigation.readInt(inParcel, readInt11);
                            break;
                        case 6:
                            int readSize4 = Navigation.readSize(inParcel, readInt11);
                            int dataPosition4 = inParcel.dataPosition();
                            if (readSize4 != 0) {
                                iArr5 = inParcel.createIntArray();
                                inParcel.setDataPosition(dataPosition4 + readSize4);
                                break;
                            } else {
                                iArr5 = null;
                                break;
                            }
                        default:
                            Navigation.skipUnknownField(inParcel, readInt11);
                            break;
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader8);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z9, z10, iArr4, i15, iArr5);
            default:
                int validateObjectHeader9 = Navigation.validateObjectHeader(inParcel);
                Bundle bundle2 = new Bundle();
                Scope[] scopeArr = GetServiceRequest.zza;
                String str6 = null;
                IBinder iBinder = null;
                Account account = null;
                String str7 = null;
                Feature[] featureArr2 = GetServiceRequest.zzb;
                Feature[] featureArr3 = featureArr2;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                boolean z11 = false;
                int i19 = 0;
                boolean z12 = false;
                while (inParcel.dataPosition() < validateObjectHeader9) {
                    int readInt12 = inParcel.readInt();
                    switch ((char) readInt12) {
                        case 1:
                            i16 = Navigation.readInt(inParcel, readInt12);
                            break;
                        case 2:
                            i17 = Navigation.readInt(inParcel, readInt12);
                            break;
                        case 3:
                            i18 = Navigation.readInt(inParcel, readInt12);
                            break;
                        case 4:
                            str6 = Navigation.createString(inParcel, readInt12);
                            break;
                        case 5:
                            int readSize5 = Navigation.readSize(inParcel, readInt12);
                            int dataPosition5 = inParcel.dataPosition();
                            if (readSize5 != 0) {
                                IBinder readStrongBinder = inParcel.readStrongBinder();
                                inParcel.setDataPosition(dataPosition5 + readSize5);
                                iBinder = readStrongBinder;
                                break;
                            } else {
                                iBinder = null;
                                break;
                            }
                        case 6:
                            scopeArr = (Scope[]) Navigation.createTypedArray(inParcel, readInt12, Scope.CREATOR);
                            break;
                        case 7:
                            int readSize6 = Navigation.readSize(inParcel, readInt12);
                            int dataPosition6 = inParcel.dataPosition();
                            if (readSize6 != 0) {
                                Bundle readBundle2 = inParcel.readBundle();
                                inParcel.setDataPosition(dataPosition6 + readSize6);
                                bundle2 = readBundle2;
                                break;
                            } else {
                                bundle2 = null;
                                break;
                            }
                        case '\b':
                            account = (Account) Navigation.createParcelable(inParcel, readInt12, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            Navigation.skipUnknownField(inParcel, readInt12);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) Navigation.createTypedArray(inParcel, readInt12, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) Navigation.createTypedArray(inParcel, readInt12, Feature.CREATOR);
                            break;
                        case '\f':
                            z11 = Navigation.readBoolean(inParcel, readInt12);
                            break;
                        case '\r':
                            i19 = Navigation.readInt(inParcel, readInt12);
                            break;
                        case 14:
                            z12 = Navigation.readBoolean(inParcel, readInt12);
                            break;
                        case 15:
                            str7 = Navigation.createString(inParcel, readInt12);
                            break;
                    }
                }
                Navigation.ensureAtEnd(inParcel, validateObjectHeader9);
                return new GetServiceRequest(i16, i17, i18, str6, iBinder, scopeArr, bundle2, account, featureArr2, featureArr3, z11, i19, z12, str7);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new ConnectionResult[i];
            case 1:
                return new ActivityResult[i];
            case 2:
                return new IntentSenderRequest[i];
            case 3:
                return new ActionMenuPresenter.SavedState[i];
            case 4:
                return new AppCompatSpinner.SavedState[i];
            case 5:
                return new NestedScrollView.SavedState[i];
            case 6:
                return new BackStackRecordState[i];
            case 7:
                return new BackStackState[i];
            case 8:
                return new FragmentManager.LaunchedFragmentInfo[i];
            case 9:
                return new FragmentManagerState[i];
            case 10:
                return new FragmentState[i];
            case 11:
                return new EditTextPreference.SavedState[i];
            case 12:
                return new ListPreference.SavedState[i];
            case 13:
                return new MultiSelectListPreference.SavedState[i];
            case 14:
                return new Preference.BaseSavedState[i];
            case 15:
                return new PreferenceGroup.SavedState[i];
            case 16:
                return new SeekBarPreference.SavedState[i];
            case 17:
                return new TwoStatePreference.SavedState[i];
            case 18:
                return new LinearLayoutManager.SavedState[i];
            case 19:
                return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i];
            case 20:
                return new StaggeredGridLayoutManager.SavedState[i];
            case 21:
                return new ParcelImpl[i];
            case 22:
                return new Scope[i];
            case 23:
                return new Status[i];
            case 24:
                return new TelemetryData[i];
            case 25:
                return new MethodInvocation[i];
            case 26:
                return new RootTelemetryConfiguration[i];
            case 27:
                return new zzk[i];
            case 28:
                return new ConnectionTelemetryConfiguration[i];
            default:
                return new GetServiceRequest[i];
        }
    }
}
