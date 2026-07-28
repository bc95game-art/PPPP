package androidx.core.provider;

import com.emanuelef.remote_capture.adapters.CtrlPermissionsAdapter;
import com.emanuelef.remote_capture.model.CtrlPermissions;
import java.util.Comparator;
/* loaded from: classes.dex */
public final /* synthetic */ class FontProvider$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FontProvider$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 1:
                return ((String) obj).compareTo((String) obj2);
            case 2:
                return ((Integer) obj).compareTo((Integer) obj2);
            default:
                return CtrlPermissionsAdapter.$r8$lambda$jQS7R5tbAlNSMjj1VWbtxhBxsek((CtrlPermissions.Rule) obj, (CtrlPermissions.Rule) obj2);
        }
    }
}
