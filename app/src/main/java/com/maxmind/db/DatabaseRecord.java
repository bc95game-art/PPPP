package com.maxmind.db;

import java.net.InetAddress;
/* loaded from: classes.dex */
public final class DatabaseRecord<T> {
    private final T data;
    private final Network network;

    public DatabaseRecord(T t, InetAddress inetAddress, int i) {
        this.data = t;
        this.network = new Network(inetAddress, i);
    }

    public T getData() {
        return this.data;
    }

    public Network getNetwork() {
        return this.network;
    }
}
