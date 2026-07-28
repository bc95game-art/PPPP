package com.emanuelef.remote_capture;

import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Cidr {
    private static final String TAG = "CIDR";
    private InetAddress endAddress;
    private BigInteger endAddressBigInt;
    private final InetAddress inetAddress;
    private final int prefixLength;
    private InetAddress startAddress;
    private BigInteger startAddressBigInt;
    private final String stringCidr;

    public Cidr(String str) {
        this.stringCidr = str;
        if (str.contains("/")) {
            int indexOf = str.indexOf("/");
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            this.inetAddress = InetAddress.getByName(substring);
            this.prefixLength = Integer.parseInt(substring2);
            calculate();
            return;
        }
        Log.m581w(TAG, "Invalid CIDR: ".concat(str));
        throw new IllegalArgumentException("not an valid CIDR format!");
    }

    private void calculate() {
        ByteBuffer byteBuffer;
        int i = 4;
        if (this.inetAddress.getAddress().length == 4) {
            byteBuffer = ByteBuffer.allocate(4).putInt(-1);
        } else {
            i = 16;
            byteBuffer = ByteBuffer.allocate(16).putLong(-1L).putLong(-1L);
        }
        BigInteger shiftRight = new BigInteger(1, byteBuffer.array()).not().shiftRight(this.prefixLength);
        BigInteger and = new BigInteger(1, ByteBuffer.wrap(this.inetAddress.getAddress()).array()).and(shiftRight);
        BigInteger add = and.add(shiftRight.not());
        byte[] bytes = toBytes(and.toByteArray(), i);
        byte[] bytes2 = toBytes(add.toByteArray(), i);
        this.startAddress = InetAddress.getByAddress(bytes);
        this.startAddressBigInt = new BigInteger(1, this.startAddress.getAddress());
        this.endAddress = InetAddress.getByAddress(bytes2);
        this.endAddressBigInt = new BigInteger(1, this.endAddress.getAddress());
    }

    private byte[] toBytes(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i && (bArr.length - 1) - i2 >= 0; i2++) {
            arrayList.add(0, Byte.valueOf(bArr[(bArr.length - 1) - i2]));
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < i - size; i3++) {
            arrayList.add(0, (byte) 0);
        }
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            bArr2[i4] = ((Byte) arrayList.get(i4)).byteValue();
        }
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cidr)) {
            return super.equals(obj);
        }
        Cidr cidr = (Cidr) obj;
        if (!cidr.startAddress.equals(this.startAddress) || !cidr.endAddress.equals(this.endAddress)) {
            return false;
        }
        return true;
    }

    public String getBroadcastAddress() {
        return this.endAddress.getHostAddress();
    }

    public String getNetworkAddress() {
        return this.startAddress.getHostAddress();
    }

    public boolean isInRange(String str) {
        return isInRange(InetAddress.getByName(str));
    }

    public String toString() {
        return this.stringCidr;
    }

    public boolean isInRange(InetAddress inetAddress) {
        BigInteger bigInteger = this.startAddressBigInt;
        BigInteger bigInteger2 = this.endAddressBigInt;
        BigInteger bigInteger3 = new BigInteger(1, inetAddress.getAddress());
        return bigInteger.compareTo(bigInteger3) <= 0 && bigInteger2.compareTo(bigInteger3) >= 0;
    }
}
