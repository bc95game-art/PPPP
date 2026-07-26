package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.CamUtils;
import com.android.billingclient.api.zzbv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public abstract class FontProvider {
    public static final FontProvider$$ExternalSyntheticLambda0 sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0(0);

    /* loaded from: classes.dex */
    public final class ContentQueryWrapperApi16Impl {
        public final /* synthetic */ int $r8$classId;
        public final ContentProviderClient mClient;

        public ContentQueryWrapperApi16Impl(Context context, Uri uri, int i) {
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    return;
                default:
                    this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    return;
            }
        }

        public final void close() {
            switch (this.$r8$classId) {
                case 0:
                    ContentProviderClient contentProviderClient = this.mClient;
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                        return;
                    }
                    return;
                default:
                    ContentProviderClient contentProviderClient2 = this.mClient;
                    if (contentProviderClient2 == null) {
                        return;
                    }
                    if (contentProviderClient2 instanceof AutoCloseable) {
                        contentProviderClient2.close();
                        return;
                    } else if (contentProviderClient2 instanceof ExecutorService) {
                        AbstractC0043x6e997f03.m618m((ExecutorService) contentProviderClient2);
                        return;
                    } else {
                        contentProviderClient2.release();
                        return;
                    }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzbv getFontFamilyResult(Context context, FontRequest fontRequest) {
        Cursor cursor;
        ContentQueryWrapperApi16Impl contentQueryWrapperApi16Impl;
        Cursor cursor2;
        int i;
        int i2;
        Uri withAppendedId;
        int i3;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) fontRequest.mProviderAuthority;
        String str2 = (String) fontRequest.mProviderPackage;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
        } else if (resolveContentProvider.packageName.equals(str2)) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            FontProvider$$ExternalSyntheticLambda0 fontProvider$$ExternalSyntheticLambda0 = sByteArrayComparator;
            Collections.sort(arrayList, fontProvider$$ExternalSyntheticLambda0);
            List list = (List) fontRequest.mCertificates;
            if (list == null) {
                list = CamUtils.readCerts(resources, 0);
            }
            int i4 = 0;
            loop1: while (true) {
                cursor = null;
                if (i4 >= list.size()) {
                    resolveContentProvider = null;
                    break;
                }
                ArrayList arrayList2 = new ArrayList((Collection) list.get(i4));
                Collections.sort(arrayList2, fontProvider$$ExternalSyntheticLambda0);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i5), (byte[]) arrayList2.get(i5))) {
                            break;
                        }
                    }
                    break loop1;
                }
                i4++;
            }
            if (resolveContentProvider == null) {
                return new zzbv(1, (FontsContractCompat$FontInfo[]) null);
            }
            String str3 = resolveContentProvider.authority;
            ArrayList arrayList3 = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str3).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str3).appendPath("file").build();
            if (Build.VERSION.SDK_INT < 24) {
                contentQueryWrapperApi16Impl = new ContentQueryWrapperApi16Impl(context, build, 0);
            } else {
                contentQueryWrapperApi16Impl = new ContentQueryWrapperApi16Impl(context, build, 1);
            }
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                String[] strArr2 = {(String) fontRequest.mQuery};
                switch (contentQueryWrapperApi16Impl.$r8$classId) {
                    case 0:
                        ContentProviderClient contentProviderClient = contentQueryWrapperApi16Impl.mClient;
                        cursor2 = null;
                        if (contentProviderClient != null) {
                            try {
                                cursor2 = contentProviderClient.query(build, strArr, "query = ?", strArr2, null, null);
                            } catch (RemoteException e) {
                                Log.w("FontsProvider", "Unable to query the content provider", e);
                            }
                        }
                        cursor = cursor2;
                        if (cursor != null && cursor.getCount() > 0) {
                            int columnIndex = cursor.getColumnIndex("result_code");
                            arrayList3 = new ArrayList();
                            int columnIndex2 = cursor.getColumnIndex("_id");
                            int columnIndex3 = cursor.getColumnIndex("file_id");
                            int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                            int columnIndex5 = cursor.getColumnIndex("font_weight");
                            int columnIndex6 = cursor.getColumnIndex("font_italic");
                            while (cursor.moveToNext()) {
                                if (columnIndex != -1) {
                                    i = cursor.getInt(columnIndex);
                                } else {
                                    i = 0;
                                }
                                if (columnIndex4 != -1) {
                                    i2 = cursor.getInt(columnIndex4);
                                } else {
                                    i2 = 0;
                                }
                                if (columnIndex3 == -1) {
                                    withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                                } else {
                                    withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                                }
                                Uri uri = withAppendedId;
                                if (columnIndex5 != -1) {
                                    i3 = cursor.getInt(columnIndex5);
                                } else {
                                    i3 = 400;
                                }
                                if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                arrayList3.add(new FontsContractCompat$FontInfo(uri, i2, i3, z, i));
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        contentQueryWrapperApi16Impl.close();
                        return new zzbv(0, (FontsContractCompat$FontInfo[]) arrayList3.toArray(new FontsContractCompat$FontInfo[0]));
                    default:
                        ContentProviderClient contentProviderClient2 = contentQueryWrapperApi16Impl.mClient;
                        cursor2 = null;
                        if (contentProviderClient2 != null) {
                            try {
                                cursor2 = contentProviderClient2.query(build, strArr, "query = ?", strArr2, null, null);
                            } catch (RemoteException e2) {
                                Log.w("FontsProvider", "Unable to query the content provider", e2);
                            }
                        }
                        cursor = cursor2;
                        if (cursor != null) {
                            int columnIndex7 = cursor.getColumnIndex("result_code");
                            arrayList3 = new ArrayList();
                            int columnIndex22 = cursor.getColumnIndex("_id");
                            int columnIndex32 = cursor.getColumnIndex("file_id");
                            int columnIndex42 = cursor.getColumnIndex("font_ttc_index");
                            int columnIndex52 = cursor.getColumnIndex("font_weight");
                            int columnIndex62 = cursor.getColumnIndex("font_italic");
                            while (cursor.moveToNext()) {
                            }
                            break;
                        }
                        if (cursor != null) {
                        }
                        contentQueryWrapperApi16Impl.close();
                        return new zzbv(0, (FontsContractCompat$FontInfo[]) arrayList3.toArray(new FontsContractCompat$FontInfo[0]));
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                contentQueryWrapperApi16Impl.close();
                throw th;
            }
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
        }
    }
}
