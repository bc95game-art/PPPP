package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.view.View;
/* loaded from: classes.dex */
public final /* synthetic */ class InstallCertificate$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ InstallCertificate f$0;

    public /* synthetic */ InstallCertificate$$ExternalSyntheticLambda6(InstallCertificate installCertificate, int i) {
        this.$r8$classId = i;
        this.f$0 = installCertificate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$onMitmGetCaCertificateResult$5(view);
                return;
            default:
                this.f$0.lambda$onViewCreated$2(view);
                return;
        }
    }
}
