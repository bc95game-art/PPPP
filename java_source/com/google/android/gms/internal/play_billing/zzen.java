package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Locale;
/* loaded from: classes.dex */
public final class zzen extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzen(long j, long j2, int i, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat("Pos: " + j + ", limit: " + j2 + ", len: " + i), indexOutOfBoundsException);
        Locale locale = Locale.US;
    }

    public zzen(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}
