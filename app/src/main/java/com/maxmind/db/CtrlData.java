package com.maxmind.db;
/* loaded from: classes.dex */
final class CtrlData {
    private final int ctrlByte;
    private final int offset;
    private final int size;
    private final Type type;

    public CtrlData(Type type, int i, int i2, int i3) {
        this.type = type;
        this.ctrlByte = i;
        this.offset = i2;
        this.size = i3;
    }

    public int getCtrlByte() {
        return this.ctrlByte;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public Type getType() {
        return this.type;
    }
}
