package com.maxmind.db;

import androidx.lifecycle.ViewModelProvider;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
public final class Network {
    private final InetAddress ipAddress;
    private InetAddress networkAddress = null;
    private final int prefixLength;

    public Network(InetAddress inetAddress, int i) {
        this.ipAddress = inetAddress;
        this.prefixLength = i;
    }

    public InetAddress getNetworkAddress() {
        InetAddress inetAddress = this.networkAddress;
        if (inetAddress != null) {
            return inetAddress;
        }
        byte[] address = this.ipAddress.getAddress();
        int length = address.length;
        byte[] bArr = new byte[length];
        int i = this.prefixLength;
        for (int i2 = 0; i2 < address.length && i > 0; i2++) {
            byte b = address[i2];
            if (i < 8) {
                int i3 = 8 - i;
                b = (byte) ((b >> i3) << i3);
            }
            bArr[i2] = b;
            i -= 8;
        }
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            this.networkAddress = byAddress;
            return byAddress;
        } catch (UnknownHostException unused) {
            throw new RuntimeException(ViewModelProvider.Factory.CC.m(length, "Illegal network address byte length of "));
        }
    }

    public int getPrefixLength() {
        return this.prefixLength;
    }

    public String toString() {
        return getNetworkAddress().getHostAddress() + "/" + this.prefixLength;
    }
}
