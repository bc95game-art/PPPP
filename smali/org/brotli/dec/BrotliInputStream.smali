.class public final Lorg/brotli/dec/BrotliInputStream;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field public final buffer:[B

.field public bufferOffset:I

.field public remainingBufferBytes:I

.field public final state:Lorg/brotli/dec/State;


# direct methods
.method public constructor <init>(Ljava/io/ByteArrayInputStream;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lorg/brotli/dec/State;

    .line 5
    .line 6
    invoke-direct {v0}, Lorg/brotli/dec/State;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lorg/brotli/dec/BrotliInputStream;->state:Lorg/brotli/dec/State;

    .line 10
    .line 11
    const/16 v1, 0x4000

    .line 12
    .line 13
    new-array v1, v1, [B

    .line 14
    .line 15
    iput-object v1, p0, Lorg/brotli/dec/BrotliInputStream;->buffer:[B

    .line 16
    .line 17
    const/4 v1, 0x0

    .line 18
    iput v1, p0, Lorg/brotli/dec/BrotliInputStream;->remainingBufferBytes:I

    .line 19
    .line 20
    iput v1, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    .line 21
    .line 22
    :try_start_0
    invoke-static {v0, p1}, Lorg/brotli/dec/State;->setInput(Lorg/brotli/dec/State;Ljava/io/ByteArrayInputStream;)V
    :try_end_0
    .catch Lorg/brotli/dec/BrotliRuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :catch_0
    move-exception p1

    .line 27
    new-instance v0, Ljava/io/IOException;

    .line 28
    .line 29
    const-string v1, "Brotli decoder initialization failed"

    .line 30
    .line 31
    invoke-direct {v0, v1, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 32
    .line 33
    .line 34
    throw v0
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method


# virtual methods
.method public final close()V
    .locals 3

    .line 1
    iget-object v0, p0, Lorg/brotli/dec/BrotliInputStream;->state:Lorg/brotli/dec/State;

    .line 2
    .line 3
    iget v1, v0, Lorg/brotli/dec/State;->runningState:I

    .line 4
    .line 5
    if-eqz v1, :cond_2

    .line 6
    .line 7
    const/16 v2, 0xb

    .line 8
    .line 9
    if-ne v1, v2, :cond_0

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_0
    iput v2, v0, Lorg/brotli/dec/State;->runningState:I

    .line 13
    .line 14
    iget-object v0, v0, Lorg/brotli/dec/State;->br:Lorg/brotli/dec/BitReader;

    .line 15
    .line 16
    iget-object v1, v0, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 17
    .line 18
    const/4 v2, 0x0

    .line 19
    iput-object v2, v0, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 20
    .line 21
    if-eqz v1, :cond_1

    .line 22
    .line 23
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 24
    .line 25
    .line 26
    :cond_1
    :goto_0
    return-void

    .line 27
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 28
    .line 29
    const-string v1, "State MUST be initialized"

    .line 30
    .line 31
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    throw v0
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method public final read()I
    .locals 3

    .line 1
    iget v0, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    iget v1, p0, Lorg/brotli/dec/BrotliInputStream;->remainingBufferBytes:I

    iget-object v2, p0, Lorg/brotli/dec/BrotliInputStream;->buffer:[B

    if-lt v0, v1, :cond_0

    .line 2
    array-length v0, v2

    const/4 v1, 0x0

    invoke-virtual {p0, v2, v1, v0}, Lorg/brotli/dec/BrotliInputStream;->read([BII)I

    move-result v0

    iput v0, p0, Lorg/brotli/dec/BrotliInputStream;->remainingBufferBytes:I

    .line 3
    iput v1, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    return v1

    .line 4
    :cond_0
    iget v0, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    aget-byte v0, v2, v0

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method public final read([BII)I
    .locals 5

    .line 5
    iget-object v0, p0, Lorg/brotli/dec/BrotliInputStream;->state:Lorg/brotli/dec/State;

    if-ltz p2, :cond_5

    if-ltz p3, :cond_4

    add-int v1, p2, p3

    .line 6
    array-length v2, p1

    if-gt v1, v2, :cond_3

    const/4 v1, 0x0

    if-nez p3, :cond_0

    return v1

    .line 7
    :cond_0
    iget v2, p0, Lorg/brotli/dec/BrotliInputStream;->remainingBufferBytes:I

    iget v3, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    sub-int/2addr v2, v3

    invoke-static {v2, v1}, Ljava/lang/Math;->max(II)I

    move-result v2

    if-eqz v2, :cond_1

    .line 8
    invoke-static {v2, p3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 9
    iget-object v3, p0, Lorg/brotli/dec/BrotliInputStream;->buffer:[B

    iget v4, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    invoke-static {v3, v4, p1, p2, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 10
    iget v3, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    add-int/2addr v3, v2

    iput v3, p0, Lorg/brotli/dec/BrotliInputStream;->bufferOffset:I

    add-int/2addr p2, v2

    sub-int/2addr p3, v2

    if-nez p3, :cond_1

    return v2

    .line 11
    :cond_1
    :try_start_0
    iput-object p1, v0, Lorg/brotli/dec/State;->output:[B

    .line 12
    iput p2, v0, Lorg/brotli/dec/State;->outputOffset:I

    .line 13
    iput p3, v0, Lorg/brotli/dec/State;->outputLength:I

    .line 14
    iput v1, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 15
    invoke-static {v0}, Lorg/brotli/dec/Utils;->decompress(Lorg/brotli/dec/State;)V

    .line 16
    iget p1, v0, Lorg/brotli/dec/State;->outputUsed:I
    :try_end_0
    .catch Lorg/brotli/dec/BrotliRuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    if-nez p1, :cond_2

    const/4 p1, -0x1

    return p1

    :cond_2
    add-int/2addr p1, v2

    return p1

    :catch_0
    move-exception p1

    .line 17
    new-instance p2, Ljava/io/IOException;

    const-string p3, "Brotli stream decoding failed"

    invoke-direct {p2, p3, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw p2

    .line 18
    :cond_3
    new-instance p2, Ljava/lang/IllegalArgumentException;

    const-string p3, "Buffer overflow: "

    const-string v0, " > "

    .line 19
    invoke-static {p3, v1, v0}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p3

    .line 20
    array-length p1, p1

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2

    .line 21
    :cond_4
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Bad length: "

    .line 22
    invoke-static {p3, p2}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(ILjava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 23
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 24
    :cond_5
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p3, "Bad offset: "

    .line 25
    invoke-static {p2, p3}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(ILjava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 26
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
