.class public final Lj$/time/t;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Externalizable;


# static fields
.field private static final serialVersionUID:J = -0x6aa27b45e4ddb74eL


# instance fields
.field public a:B

.field public b:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(BLjava/lang/Object;)V
    .locals 0

    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 129
    iput-byte p1, p0, Lj$/time/t;->a:B

    .line 130
    iput-object p2, p0, Lj$/time/t;->b:Ljava/lang/Object;

    return-void
.end method

.method public static a(BLjava/io/ObjectInput;)Ljava/lang/Object;
    .locals 6

    packed-switch p0, :pswitch_data_0

    .line 271
    new-instance p0, Ljava/io/StreamCorruptedException;

    const-string p1, "Unknown serialized type"

    invoke-direct {p0, p1}, Ljava/io/StreamCorruptedException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 269
    :pswitch_0
    sget-object p0, Lj$/time/s;->d:Lj$/time/s;

    .line 1080
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 1081
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result v0

    .line 1082
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p1

    or-int v1, p0, v0

    or-int/2addr v1, p1

    if-nez v1, :cond_0

    .line 404
    sget-object p0, Lj$/time/s;->d:Lj$/time/s;

    return-object p0

    .line 406
    :cond_0
    new-instance v1, Lj$/time/s;

    invoke-direct {v1, p0, v0, p1}, Lj$/time/s;-><init>(III)V

    return-object v1

    .line 268
    :pswitch_1
    sget p0, Lj$/time/o;->c:I

    .line 787
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result p0

    .line 788
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result p1

    .line 244
    invoke-static {p0}, Lj$/time/m;->F(I)Lj$/time/m;

    move-result-object p0

    .line 218
    const-string v0, "month"

    invoke-static {p0, v0}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 219
    sget-object v0, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Lj$/time/temporal/a;->s(J)V

    .line 220
    invoke-virtual {p0}, Lj$/time/m;->E()I

    move-result v0

    if-gt p1, v0, :cond_1

    .line 224
    new-instance v0, Lj$/time/o;

    invoke-virtual {p0}, Lj$/time/m;->getValue()I

    move-result p0

    invoke-direct {v0, p0, p1}, Lj$/time/o;-><init>(II)V

    return-object v0

    .line 221
    :cond_1
    new-instance v0, Lj$/time/a;

    .line 222
    invoke-virtual {p0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object p0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Illegal value for DayOfMonth field, value "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, " is not valid for month "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 88
    invoke-direct {v0, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 222
    throw v0

    .line 267
    :pswitch_2
    sget p0, Lj$/time/x;->c:I

    .line 1245
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 1246
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result p1

    .line 226
    sget-object v0, Lj$/time/temporal/a;->YEAR:Lj$/time/temporal/a;

    int-to-long v1, p0

    invoke-virtual {v0, v1, v2}, Lj$/time/temporal/a;->s(J)V

    .line 227
    sget-object v0, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Lj$/time/temporal/a;->s(J)V

    .line 228
    new-instance v0, Lj$/time/x;

    invoke-direct {v0, p0, p1}, Lj$/time/x;-><init>(II)V

    return-object v0

    .line 266
    :pswitch_3
    sget p0, Lj$/time/v;->b:I

    .line 1119
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    invoke-static {p0}, Lj$/time/v;->C(I)Lj$/time/v;

    move-result-object p0

    return-object p0

    .line 265
    :pswitch_4
    sget p0, Lj$/time/q;->c:I

    .line 2008
    sget-object p0, Lj$/time/g;->d:Lj$/time/g;

    .line 2224
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 2225
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v0

    .line 2226
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v1

    .line 2227
    invoke-static {p0, v0, v1}, Lj$/time/g;->K(III)Lj$/time/g;

    move-result-object p0

    .line 2009
    invoke-static {p1}, Lj$/time/k;->M(Ljava/io/DataInput;)Lj$/time/k;

    move-result-object v0

    .line 2010
    invoke-static {p0, v0}, Lj$/time/i;->F(Lj$/time/g;Lj$/time/k;)Lj$/time/i;

    move-result-object p0

    .line 1949
    invoke-static {p1}, Lj$/time/z;->K(Ljava/io/DataInput;)Lj$/time/z;

    move-result-object p1

    .line 276
    new-instance v0, Lj$/time/q;

    invoke-direct {v0, p0, p1}, Lj$/time/q;-><init>(Lj$/time/i;Lj$/time/z;)V

    return-object v0

    .line 264
    :pswitch_5
    sget p0, Lj$/time/r;->c:I

    .line 1433
    invoke-static {p1}, Lj$/time/k;->M(Ljava/io/DataInput;)Lj$/time/k;

    move-result-object p0

    .line 1434
    invoke-static {p1}, Lj$/time/z;->K(Ljava/io/DataInput;)Lj$/time/z;

    move-result-object p1

    .line 213
    new-instance v0, Lj$/time/r;

    invoke-direct {v0, p0, p1}, Lj$/time/r;-><init>(Lj$/time/k;Lj$/time/z;)V

    return-object v0

    .line 262
    :pswitch_6
    invoke-static {p1}, Lj$/time/z;->K(Ljava/io/DataInput;)Lj$/time/z;

    move-result-object p0

    return-object p0

    .line 263
    :pswitch_7
    sget p0, Lj$/time/a0;->c:I

    .line 217
    invoke-interface {p1}, Ljava/io/DataInput;->readUTF()Ljava/lang/String;

    move-result-object p0

    .line 401
    const-string p1, "zoneId"

    invoke-static {p0, p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 402
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p1

    const/4 v0, 0x1

    if-le p1, v0, :cond_6

    const-string p1, "+"

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_6

    const-string p1, "-"

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_2

    goto :goto_1

    .line 404
    :cond_2
    const-string p1, "UTC"

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_5

    const-string p1, "GMT"

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_3

    goto :goto_0

    .line 406
    :cond_3
    const-string p1, "UT"

    invoke-virtual {p0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_4

    const/4 p1, 0x2

    .line 407
    invoke-static {p0, p1}, Lj$/time/y;->E(Ljava/lang/String;I)Lj$/time/y;

    move-result-object p0

    return-object p0

    .line 409
    :cond_4
    invoke-static {p0}, Lj$/time/a0;->G(Ljava/lang/String;)Lj$/time/a0;

    move-result-object p0

    return-object p0

    :cond_5
    :goto_0
    const/4 p1, 0x3

    .line 405
    invoke-static {p0, p1}, Lj$/time/y;->E(Ljava/lang/String;I)Lj$/time/y;

    move-result-object p0

    return-object p0

    .line 403
    :cond_6
    :goto_1
    invoke-static {p0}, Lj$/time/z;->G(Ljava/lang/String;)Lj$/time/z;

    move-result-object p0

    return-object p0

    .line 2259
    :pswitch_8
    sget-object p0, Lj$/time/i;->c:Lj$/time/i;

    .line 2008
    sget-object p0, Lj$/time/g;->d:Lj$/time/g;

    .line 2224
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 2225
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v0

    .line 2226
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v1

    .line 2227
    invoke-static {p0, v0, v1}, Lj$/time/g;->K(III)Lj$/time/g;

    move-result-object p0

    .line 2009
    invoke-static {p1}, Lj$/time/k;->M(Ljava/io/DataInput;)Lj$/time/k;

    move-result-object v0

    .line 2010
    invoke-static {p0, v0}, Lj$/time/i;->F(Lj$/time/g;Lj$/time/k;)Lj$/time/i;

    move-result-object p0

    .line 2260
    invoke-static {p1}, Lj$/time/z;->K(Ljava/io/DataInput;)Lj$/time/z;

    move-result-object v0

    .line 250
    invoke-interface {p1}, Ljava/io/ObjectInput;->readByte()B

    move-result v1

    .line 251
    invoke-static {v1, p1}, Lj$/time/t;->a(BLjava/io/ObjectInput;)Ljava/lang/Object;

    move-result-object p1

    .line 2261
    check-cast p1, Lj$/time/y;

    .line 517
    const-string v1, "localDateTime"

    invoke-static {p0, v1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 518
    const-string v1, "offset"

    invoke-static {v0, v1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 519
    const-string v1, "zone"

    invoke-static {p1, v1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 520
    instance-of v1, p1, Lj$/time/z;

    if-eqz v1, :cond_8

    invoke-virtual {v0, p1}, Lj$/time/z;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    goto :goto_2

    .line 521
    :cond_7
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "ZoneId must match ZoneOffset"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 523
    :cond_8
    :goto_2
    new-instance v1, Lj$/time/c0;

    invoke-direct {v1, p0, p1, v0}, Lj$/time/c0;-><init>(Lj$/time/i;Lj$/time/y;Lj$/time/z;)V

    return-object v1

    .line 259
    :pswitch_9
    sget-object p0, Lj$/time/i;->c:Lj$/time/i;

    .line 2008
    sget-object p0, Lj$/time/g;->d:Lj$/time/g;

    .line 2224
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 2225
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v0

    .line 2226
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v1

    .line 2227
    invoke-static {p0, v0, v1}, Lj$/time/g;->K(III)Lj$/time/g;

    move-result-object p0

    .line 2009
    invoke-static {p1}, Lj$/time/k;->M(Ljava/io/DataInput;)Lj$/time/k;

    move-result-object p1

    .line 2010
    invoke-static {p0, p1}, Lj$/time/i;->F(Lj$/time/g;Lj$/time/k;)Lj$/time/i;

    move-result-object p0

    return-object p0

    .line 260
    :pswitch_a
    invoke-static {p1}, Lj$/time/k;->M(Ljava/io/DataInput;)Lj$/time/k;

    move-result-object p0

    return-object p0

    .line 258
    :pswitch_b
    sget-object p0, Lj$/time/g;->d:Lj$/time/g;

    .line 2224
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    .line 2225
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result v0

    .line 2226
    invoke-interface {p1}, Ljava/io/DataInput;->readByte()B

    move-result p1

    .line 2227
    invoke-static {p0, v0, p1}, Lj$/time/g;->K(III)Lj$/time/g;

    move-result-object p0

    return-object p0

    .line 257
    :pswitch_c
    sget-object p0, Lj$/time/e;->c:Lj$/time/e;

    .line 1366
    invoke-interface {p1}, Ljava/io/DataInput;->readLong()J

    move-result-wide v0

    .line 1367
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    int-to-long p0, p0

    .line 1368
    invoke-static {v0, v1, p0, p1}, Lj$/time/e;->D(JJ)Lj$/time/e;

    move-result-object p0

    return-object p0

    .line 256
    :pswitch_d
    sget-object p0, Lj$/time/Duration;->c:Lj$/time/Duration;

    .line 1552
    invoke-interface {p1}, Ljava/io/DataInput;->readLong()J

    move-result-wide v0

    .line 1553
    invoke-interface {p1}, Ljava/io/DataInput;->readInt()I

    move-result p0

    int-to-long p0, p0

    const-wide/32 v2, 0x3b9aca00

    .line 247
    invoke-static {p0, p1, v2, v3}, Lj$/com/android/tools/r8/a;->V(JJ)J

    move-result-wide v4

    invoke-static {v0, v1, v4, v5}, Lj$/com/android/tools/r8/a;->R(JJ)J

    move-result-wide v0

    .line 248
    invoke-static {p0, p1, v2, v3}, Lj$/com/android/tools/r8/a;->U(JJ)J

    move-result-wide p0

    long-to-int p1, p0

    .line 249
    invoke-static {v0, v1, p1}, Lj$/time/Duration;->i(JI)Lj$/time/Duration;

    move-result-object p0

    return-object p0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private readResolve()Ljava/lang/Object;
    .locals 1

    .line 281
    iget-object v0, p0, Lj$/time/t;->b:Ljava/lang/Object;

    return-object v0
.end method


# virtual methods
.method public final readExternal(Ljava/io/ObjectInput;)V
    .locals 1

    .line 245
    invoke-interface {p1}, Ljava/io/ObjectInput;->readByte()B

    move-result v0

    iput-byte v0, p0, Lj$/time/t;->a:B

    .line 246
    invoke-static {v0, p1}, Lj$/time/t;->a(BLjava/io/ObjectInput;)Ljava/lang/Object;

    move-result-object p1

    iput-object p1, p0, Lj$/time/t;->b:Ljava/lang/Object;

    return-void
.end method

.method public final writeExternal(Ljava/io/ObjectOutput;)V
    .locals 4

    .line 162
    iget-byte v0, p0, Lj$/time/t;->a:B

    iget-object v1, p0, Lj$/time/t;->b:Ljava/lang/Object;

    .line 166
    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeByte(I)V

    packed-switch v0, :pswitch_data_0

    .line 211
    new-instance p1, Ljava/io/InvalidClassException;

    const-string v0, "Unknown serialized type"

    invoke-direct {p1, v0}, Ljava/io/InvalidClassException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 208
    :pswitch_0
    check-cast v1, Lj$/time/s;

    .line 1074
    iget v0, v1, Lj$/time/s;->a:I

    .line 1074
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    .line 1075
    iget v0, v1, Lj$/time/s;->b:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    .line 1076
    iget v0, v1, Lj$/time/s;->c:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    return-void

    .line 205
    :pswitch_1
    check-cast v1, Lj$/time/o;

    .line 782
    iget v0, v1, Lj$/time/o;->a:I

    .line 782
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    .line 783
    iget v0, v1, Lj$/time/o;->b:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    return-void

    .line 202
    :pswitch_2
    check-cast v1, Lj$/time/x;

    .line 1240
    iget v0, v1, Lj$/time/x;->a:I

    .line 1240
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    .line 1241
    iget v0, v1, Lj$/time/x;->b:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    return-void

    .line 199
    :pswitch_3
    check-cast v1, Lj$/time/v;

    .line 1115
    iget v0, v1, Lj$/time/v;->a:I

    .line 1115
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    return-void

    .line 196
    :pswitch_4
    check-cast v1, Lj$/time/q;

    .line 1943
    iget-object v0, v1, Lj$/time/q;->a:Lj$/time/i;

    .line 2003
    iget-object v2, v0, Lj$/time/i;->a:Lj$/time/g;

    .line 2218
    iget v3, v2, Lj$/time/g;->a:I

    .line 2218
    invoke-interface {p1, v3}, Ljava/io/DataOutput;->writeInt(I)V

    .line 2219
    iget-short v3, v2, Lj$/time/g;->b:S

    invoke-interface {p1, v3}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2220
    iget-short v2, v2, Lj$/time/g;->c:S

    invoke-interface {p1, v2}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2004
    iget-object v0, v0, Lj$/time/i;->b:Lj$/time/k;

    invoke-virtual {v0, p1}, Lj$/time/k;->R(Ljava/io/DataOutput;)V

    .line 1944
    iget-object v0, v1, Lj$/time/q;->b:Lj$/time/z;

    invoke-virtual {v0, p1}, Lj$/time/z;->L(Ljava/io/DataOutput;)V

    return-void

    .line 193
    :pswitch_5
    check-cast v1, Lj$/time/r;

    .line 1428
    iget-object v0, v1, Lj$/time/r;->a:Lj$/time/k;

    .line 1428
    invoke-virtual {v0, p1}, Lj$/time/k;->R(Ljava/io/DataOutput;)V

    .line 1429
    iget-object v0, v1, Lj$/time/r;->b:Lj$/time/z;

    invoke-virtual {v0, p1}, Lj$/time/z;->L(Ljava/io/DataOutput;)V

    return-void

    .line 187
    :pswitch_6
    check-cast v1, Lj$/time/z;

    invoke-virtual {v1, p1}, Lj$/time/z;->L(Ljava/io/DataOutput;)V

    return-void

    .line 184
    :pswitch_7
    check-cast v1, Lj$/time/a0;

    .line 213
    iget-object v0, v1, Lj$/time/a0;->a:Ljava/lang/String;

    .line 213
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeUTF(Ljava/lang/String;)V

    return-void

    .line 190
    :pswitch_8
    check-cast v1, Lj$/time/c0;

    .line 2253
    iget-object v0, v1, Lj$/time/c0;->a:Lj$/time/i;

    .line 2003
    iget-object v2, v0, Lj$/time/i;->a:Lj$/time/g;

    .line 2218
    iget v3, v2, Lj$/time/g;->a:I

    .line 2218
    invoke-interface {p1, v3}, Ljava/io/DataOutput;->writeInt(I)V

    .line 2219
    iget-short v3, v2, Lj$/time/g;->b:S

    invoke-interface {p1, v3}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2220
    iget-short v2, v2, Lj$/time/g;->c:S

    invoke-interface {p1, v2}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2004
    iget-object v0, v0, Lj$/time/i;->b:Lj$/time/k;

    invoke-virtual {v0, p1}, Lj$/time/k;->R(Ljava/io/DataOutput;)V

    .line 2254
    iget-object v0, v1, Lj$/time/c0;->b:Lj$/time/z;

    invoke-virtual {v0, p1}, Lj$/time/z;->L(Ljava/io/DataOutput;)V

    .line 2255
    iget-object v0, v1, Lj$/time/c0;->c:Lj$/time/y;

    invoke-virtual {v0, p1}, Lj$/time/y;->F(Ljava/io/DataOutput;)V

    return-void

    .line 178
    :pswitch_9
    check-cast v1, Lj$/time/i;

    .line 2003
    iget-object v0, v1, Lj$/time/i;->a:Lj$/time/g;

    .line 2218
    iget v2, v0, Lj$/time/g;->a:I

    .line 2218
    invoke-interface {p1, v2}, Ljava/io/DataOutput;->writeInt(I)V

    .line 2219
    iget-short v2, v0, Lj$/time/g;->b:S

    invoke-interface {p1, v2}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2220
    iget-short v0, v0, Lj$/time/g;->c:S

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2004
    iget-object v0, v1, Lj$/time/i;->b:Lj$/time/k;

    invoke-virtual {v0, p1}, Lj$/time/k;->R(Ljava/io/DataOutput;)V

    return-void

    .line 181
    :pswitch_a
    check-cast v1, Lj$/time/k;

    invoke-virtual {v1, p1}, Lj$/time/k;->R(Ljava/io/DataOutput;)V

    return-void

    .line 175
    :pswitch_b
    check-cast v1, Lj$/time/g;

    .line 2218
    iget v0, v1, Lj$/time/g;->a:I

    .line 2218
    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    .line 2219
    iget-short v0, v1, Lj$/time/g;->b:S

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    .line 2220
    iget-short v0, v1, Lj$/time/g;->c:S

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeByte(I)V

    return-void

    .line 172
    :pswitch_c
    check-cast v1, Lj$/time/e;

    .line 1361
    iget-wide v2, v1, Lj$/time/e;->a:J

    .line 1361
    invoke-interface {p1, v2, v3}, Ljava/io/DataOutput;->writeLong(J)V

    .line 1362
    iget v0, v1, Lj$/time/e;->b:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    return-void

    .line 169
    :pswitch_d
    check-cast v1, Lj$/time/Duration;

    .line 1547
    iget-wide v2, v1, Lj$/time/Duration;->a:J

    .line 1547
    invoke-interface {p1, v2, v3}, Ljava/io/DataOutput;->writeLong(J)V

    .line 1548
    iget v0, v1, Lj$/time/Duration;->b:I

    invoke-interface {p1, v0}, Ljava/io/DataOutput;->writeInt(I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
