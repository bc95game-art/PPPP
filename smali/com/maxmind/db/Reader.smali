.class public final Lcom/maxmind/db/Reader;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/maxmind/db/Reader$FileMode;
    }
.end annotation


# static fields
.field private static final DATA_SECTION_SEPARATOR_SIZE:I = 0x10

.field private static final METADATA_START_MARKER:[B


# instance fields
.field private final bufferHolderReference:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lcom/maxmind/db/BufferHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final cache:Lcom/maxmind/db/NodeCache;

.field private final constructors:Lj$/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lj$/util/concurrent/ConcurrentHashMap<",
            "Ljava/lang/Class;",
            "Lcom/maxmind/db/CachedConstructor;",
            ">;"
        }
    .end annotation
.end field

.field private final ipV4Start:I

.field private final metadata:Lcom/maxmind/db/Metadata;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    const/16 v0, 0xe

    .line 2
    .line 3
    new-array v0, v0, [B

    .line 4
    .line 5
    fill-array-data v0, :array_0

    .line 6
    .line 7
    .line 8
    sput-object v0, Lcom/maxmind/db/Reader;->METADATA_START_MARKER:[B

    .line 9
    .line 10
    return-void

    .line 11
    :array_0
    .array-data 1
        -0x55t
        -0x33t
        -0x11t
        0x4dt
        0x61t
        0x78t
        0x4dt
        0x69t
        0x6et
        0x64t
        0x2et
        0x63t
        0x6ft
        0x6dt
    .end array-data
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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

.method private constructor <init>(Lcom/maxmind/db/BufferHolder;Ljava/lang/String;Lcom/maxmind/db/NodeCache;)V
    .locals 3

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/maxmind/db/Reader;->bufferHolderReference:Ljava/util/concurrent/atomic/AtomicReference;

    if-eqz p3, :cond_0

    .line 9
    iput-object p3, p0, Lcom/maxmind/db/Reader;->cache:Lcom/maxmind/db/NodeCache;

    .line 10
    invoke-virtual {p1}, Lcom/maxmind/db/BufferHolder;->get()Ljava/nio/ByteBuffer;

    move-result-object p1

    .line 11
    invoke-direct {p0, p1, p2}, Lcom/maxmind/db/Reader;->findMetadataStart(Ljava/nio/ByteBuffer;Ljava/lang/String;)I

    move-result p2

    .line 12
    new-instance v0, Lcom/maxmind/db/Decoder;

    int-to-long v1, p2

    invoke-direct {v0, p3, p1, v1, v2}, Lcom/maxmind/db/Decoder;-><init>(Lcom/maxmind/db/NodeCache;Ljava/nio/ByteBuffer;J)V

    .line 13
    const-class p3, Lcom/maxmind/db/Metadata;

    invoke-virtual {v0, p2, p3}, Lcom/maxmind/db/Decoder;->decode(ILjava/lang/Class;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/maxmind/db/Metadata;

    iput-object p2, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 14
    invoke-direct {p0, p1}, Lcom/maxmind/db/Reader;->findIpV4StartNode(Ljava/nio/ByteBuffer;)I

    move-result p1

    iput p1, p0, Lcom/maxmind/db/Reader;->ipV4Start:I

    .line 15
    new-instance p1, Lj$/util/concurrent/ConcurrentHashMap;

    invoke-direct {p1}, Lj$/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object p1, p0, Lcom/maxmind/db/Reader;->constructors:Lj$/util/concurrent/ConcurrentHashMap;

    return-void

    .line 16
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "Cache cannot be null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 1

    .line 1
    invoke-static {}, Lcom/maxmind/db/NoCache;->getInstance()Lcom/maxmind/db/NoCache;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/maxmind/db/Reader;-><init>(Ljava/io/File;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lcom/maxmind/db/NodeCache;)V
    .locals 1

    .line 2
    sget-object v0, Lcom/maxmind/db/Reader$FileMode;->MEMORY_MAPPED:Lcom/maxmind/db/Reader$FileMode;

    invoke-direct {p0, p1, v0, p2}, Lcom/maxmind/db/Reader;-><init>(Ljava/io/File;Lcom/maxmind/db/Reader$FileMode;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lcom/maxmind/db/Reader$FileMode;)V
    .locals 1

    .line 5
    invoke-static {}, Lcom/maxmind/db/NoCache;->getInstance()Lcom/maxmind/db/NoCache;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/maxmind/db/Reader;-><init>(Ljava/io/File;Lcom/maxmind/db/Reader$FileMode;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Lcom/maxmind/db/Reader$FileMode;Lcom/maxmind/db/NodeCache;)V
    .locals 1

    .line 6
    new-instance v0, Lcom/maxmind/db/BufferHolder;

    invoke-direct {v0, p1, p2}, Lcom/maxmind/db/BufferHolder;-><init>(Ljava/io/File;Lcom/maxmind/db/Reader$FileMode;)V

    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, v0, p1, p3}, Lcom/maxmind/db/Reader;-><init>(Lcom/maxmind/db/BufferHolder;Ljava/lang/String;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 1

    .line 3
    invoke-static {}, Lcom/maxmind/db/NoCache;->getInstance()Lcom/maxmind/db/NoCache;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/maxmind/db/Reader;-><init>(Ljava/io/InputStream;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;Lcom/maxmind/db/NodeCache;)V
    .locals 1

    .line 4
    new-instance v0, Lcom/maxmind/db/BufferHolder;

    invoke-direct {v0, p1}, Lcom/maxmind/db/BufferHolder;-><init>(Ljava/io/InputStream;)V

    const-string p1, "<InputStream>"

    invoke-direct {p0, v0, p1, p2}, Lcom/maxmind/db/Reader;-><init>(Lcom/maxmind/db/BufferHolder;Ljava/lang/String;Lcom/maxmind/db/NodeCache;)V

    return-void
.end method

.method private findIpV4StartNode(Ljava/nio/ByteBuffer;)I
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/maxmind/db/Metadata;->getIpVersion()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x4

    .line 8
    const/4 v2, 0x0

    .line 9
    if-ne v0, v1, :cond_0

    .line 10
    .line 11
    return v2

    .line 12
    :cond_0
    const/4 v0, 0x0

    .line 13
    const/4 v1, 0x0

    .line 14
    :goto_0
    const/16 v3, 0x60

    .line 15
    .line 16
    if-ge v0, v3, :cond_1

    .line 17
    .line 18
    iget-object v3, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 19
    .line 20
    invoke-virtual {v3}, Lcom/maxmind/db/Metadata;->getNodeCount()I

    .line 21
    .line 22
    .line 23
    move-result v3

    .line 24
    if-ge v1, v3, :cond_1

    .line 25
    .line 26
    invoke-direct {p0, p1, v1, v2}, Lcom/maxmind/db/Reader;->readNode(Ljava/nio/ByteBuffer;II)I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    add-int/lit8 v0, v0, 0x1

    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_1
    return v1
    .line 34
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

.method private findMetadataStart(Ljava/nio/ByteBuffer;Ljava/lang/String;)I
    .locals 7

    .line 1
    invoke-virtual {p1}, Ljava/nio/Buffer;->capacity()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const/4 v1, 0x0

    .line 6
    const/4 v2, 0x0

    .line 7
    :goto_0
    sget-object v3, Lcom/maxmind/db/Reader;->METADATA_START_MARKER:[B

    .line 8
    .line 9
    array-length v3, v3

    .line 10
    sub-int v3, v0, v3

    .line 11
    .line 12
    add-int/lit8 v3, v3, 0x1

    .line 13
    .line 14
    if-ge v2, v3, :cond_2

    .line 15
    .line 16
    const/4 v3, 0x0

    .line 17
    :goto_1
    sget-object v4, Lcom/maxmind/db/Reader;->METADATA_START_MARKER:[B

    .line 18
    .line 19
    array-length v5, v4

    .line 20
    if-ge v3, v5, :cond_1

    .line 21
    .line 22
    sub-int v5, v0, v2

    .line 23
    .line 24
    sub-int/2addr v5, v3

    .line 25
    add-int/lit8 v5, v5, -0x1

    .line 26
    .line 27
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    .line 28
    .line 29
    .line 30
    move-result v5

    .line 31
    array-length v6, v4

    .line 32
    sub-int/2addr v6, v3

    .line 33
    add-int/lit8 v6, v6, -0x1

    .line 34
    .line 35
    aget-byte v4, v4, v6

    .line 36
    .line 37
    if-eq v5, v4, :cond_0

    .line 38
    .line 39
    add-int/lit8 v2, v2, 0x1

    .line 40
    .line 41
    goto :goto_0

    .line 42
    :cond_0
    add-int/lit8 v3, v3, 0x1

    .line 43
    .line 44
    goto :goto_1

    .line 45
    :cond_1
    sub-int/2addr v0, v2

    .line 46
    return v0

    .line 47
    :cond_2
    new-instance p1, Lcom/maxmind/db/InvalidDatabaseException;

    .line 48
    .line 49
    const-string v0, "Could not find a MaxMind DB metadata marker in this file ("

    .line 50
    .line 51
    const-string v1, "). Is this a valid MaxMind DB file?"

    .line 52
    .line 53
    invoke-static {v0, p2, v1}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object p2

    .line 57
    invoke-direct {p1, p2}, Lcom/maxmind/db/InvalidDatabaseException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    throw p1
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method private getBufferHolder()Lcom/maxmind/db/BufferHolder;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->bufferHolderReference:Ljava/util/concurrent/atomic/AtomicReference;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lcom/maxmind/db/BufferHolder;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    return-object v0

    .line 12
    :cond_0
    new-instance v0, Lcom/maxmind/db/ClosedDatabaseException;

    .line 13
    .line 14
    invoke-direct {v0}, Lcom/maxmind/db/ClosedDatabaseException;-><init>()V

    .line 15
    .line 16
    .line 17
    throw v0
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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

.method private readNode(Ljava/nio/ByteBuffer;II)I
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/maxmind/db/Metadata;->getNodeByteSize()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    mul-int v0, v0, p2

    .line 8
    .line 9
    iget-object p2, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 10
    .line 11
    invoke-virtual {p2}, Lcom/maxmind/db/Metadata;->getRecordSize()I

    .line 12
    .line 13
    .line 14
    move-result p2

    .line 15
    const/16 v1, 0x18

    .line 16
    .line 17
    const/4 v2, 0x0

    .line 18
    const/4 v3, 0x3

    .line 19
    if-eq p2, v1, :cond_3

    .line 20
    .line 21
    const/16 v1, 0x1c

    .line 22
    .line 23
    const/4 v4, 0x4

    .line 24
    if-eq p2, v1, :cond_1

    .line 25
    .line 26
    const/16 v1, 0x20

    .line 27
    .line 28
    if-ne p2, v1, :cond_0

    .line 29
    .line 30
    mul-int/lit8 p3, p3, 0x4

    .line 31
    .line 32
    add-int/2addr p3, v0

    .line 33
    invoke-virtual {p1, p3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 34
    .line 35
    .line 36
    invoke-static {p1, v2, v4}, Lcom/maxmind/db/Decoder;->decodeInteger(Ljava/nio/ByteBuffer;II)I

    .line 37
    .line 38
    .line 39
    move-result p1

    .line 40
    return p1

    .line 41
    :cond_0
    new-instance p1, Lcom/maxmind/db/InvalidDatabaseException;

    .line 42
    .line 43
    new-instance p2, Ljava/lang/StringBuilder;

    .line 44
    .line 45
    const-string p3, "Unknown record size: "

    .line 46
    .line 47
    invoke-direct {p2, p3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 48
    .line 49
    .line 50
    iget-object p3, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 51
    .line 52
    invoke-virtual {p3}, Lcom/maxmind/db/Metadata;->getRecordSize()I

    .line 53
    .line 54
    .line 55
    move-result p3

    .line 56
    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 57
    .line 58
    .line 59
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 60
    .line 61
    .line 62
    move-result-object p2

    .line 63
    invoke-direct {p1, p2}, Lcom/maxmind/db/InvalidDatabaseException;-><init>(Ljava/lang/String;)V

    .line 64
    .line 65
    .line 66
    throw p1

    .line 67
    :cond_1
    add-int/lit8 p2, v0, 0x3

    .line 68
    .line 69
    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->get(I)B

    .line 70
    .line 71
    .line 72
    move-result p2

    .line 73
    if-nez p3, :cond_2

    .line 74
    .line 75
    and-int/lit16 p2, p2, 0xf0

    .line 76
    .line 77
    ushr-int/2addr p2, v4

    .line 78
    goto :goto_0

    .line 79
    :cond_2
    and-int/lit8 p2, p2, 0xf

    .line 80
    .line 81
    :goto_0
    mul-int/lit8 p3, p3, 0x4

    .line 82
    .line 83
    add-int/2addr p3, v0

    .line 84
    invoke-virtual {p1, p3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 85
    .line 86
    .line 87
    invoke-static {p1, p2, v3}, Lcom/maxmind/db/Decoder;->decodeInteger(Ljava/nio/ByteBuffer;II)I

    .line 88
    .line 89
    .line 90
    move-result p1

    .line 91
    return p1

    .line 92
    :cond_3
    mul-int/lit8 p3, p3, 0x3

    .line 93
    .line 94
    add-int/2addr p3, v0

    .line 95
    invoke-virtual {p1, p3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 96
    .line 97
    .line 98
    invoke-static {p1, v2, v3}, Lcom/maxmind/db/Decoder;->decodeInteger(Ljava/nio/ByteBuffer;II)I

    .line 99
    .line 100
    .line 101
    move-result p1

    .line 102
    return p1
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method

.method private resolveDataPointer(Ljava/nio/ByteBuffer;ILjava/lang/Class;)Ljava/lang/Object;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/nio/ByteBuffer;",
            "I",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/maxmind/db/Metadata;->getNodeCount()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    sub-int/2addr p2, v0

    .line 8
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 9
    .line 10
    invoke-virtual {v0}, Lcom/maxmind/db/Metadata;->getSearchTreeSize()I

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    add-int/2addr v0, p2

    .line 15
    invoke-virtual {p1}, Ljava/nio/Buffer;->capacity()I

    .line 16
    .line 17
    .line 18
    move-result p2

    .line 19
    if-ge v0, p2, :cond_0

    .line 20
    .line 21
    new-instance v1, Lcom/maxmind/db/Decoder;

    .line 22
    .line 23
    iget-object v2, p0, Lcom/maxmind/db/Reader;->cache:Lcom/maxmind/db/NodeCache;

    .line 24
    .line 25
    iget-object p2, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 26
    .line 27
    invoke-virtual {p2}, Lcom/maxmind/db/Metadata;->getSearchTreeSize()I

    .line 28
    .line 29
    .line 30
    move-result p2

    .line 31
    add-int/lit8 p2, p2, 0x10

    .line 32
    .line 33
    int-to-long v4, p2

    .line 34
    iget-object v6, p0, Lcom/maxmind/db/Reader;->constructors:Lj$/util/concurrent/ConcurrentHashMap;

    .line 35
    .line 36
    move-object v3, p1

    .line 37
    invoke-direct/range {v1 .. v6}, Lcom/maxmind/db/Decoder;-><init>(Lcom/maxmind/db/NodeCache;Ljava/nio/ByteBuffer;JLj$/util/concurrent/ConcurrentHashMap;)V

    .line 38
    .line 39
    .line 40
    invoke-virtual {v1, v0, p3}, Lcom/maxmind/db/Decoder;->decode(ILjava/lang/Class;)Ljava/lang/Object;

    .line 41
    .line 42
    .line 43
    move-result-object p1

    .line 44
    return-object p1

    .line 45
    :cond_0
    new-instance p1, Lcom/maxmind/db/InvalidDatabaseException;

    .line 46
    .line 47
    const-string p2, "The MaxMind DB file\'s search tree is corrupt: contains pointer larger than the database."

    .line 48
    .line 49
    invoke-direct {p1, p2}, Lcom/maxmind/db/InvalidDatabaseException;-><init>(Ljava/lang/String;)V

    .line 50
    .line 51
    .line 52
    throw p1
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method

.method private startNode(I)I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/maxmind/db/Metadata;->getIpVersion()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x6

    .line 8
    if-ne v0, v1, :cond_0

    .line 9
    .line 10
    const/16 v0, 0x20

    .line 11
    .line 12
    if-ne p1, v0, :cond_0

    .line 13
    .line 14
    iget p1, p0, Lcom/maxmind/db/Reader;->ipV4Start:I

    .line 15
    .line 16
    return p1

    .line 17
    :cond_0
    const/4 p1, 0x0

    .line 18
    return p1
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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
.method public close()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->bufferHolderReference:Ljava/util/concurrent/atomic/AtomicReference;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 5
    .line 6
    .line 7
    return-void
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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

.method public get(Ljava/net/InetAddress;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/InetAddress;",
            "Ljava/lang/Class<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 1
    invoke-virtual {p0, p1, p2}, Lcom/maxmind/db/Reader;->getRecord(Ljava/net/InetAddress;Ljava/lang/Class;)Lcom/maxmind/db/DatabaseRecord;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p1}, Lcom/maxmind/db/DatabaseRecord;->getData()Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    return-object p1
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method public getMetadata()Lcom/maxmind/db/Metadata;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
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

.method public getRecord(Ljava/net/InetAddress;Ljava/lang/Class;)Lcom/maxmind/db/DatabaseRecord;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/net/InetAddress;",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Lcom/maxmind/db/DatabaseRecord<",
            "TT;>;"
        }
    .end annotation

    .line 1
    invoke-direct {p0}, Lcom/maxmind/db/Reader;->getBufferHolder()Lcom/maxmind/db/BufferHolder;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Lcom/maxmind/db/BufferHolder;->get()Ljava/nio/ByteBuffer;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {p1}, Ljava/net/InetAddress;->getAddress()[B

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    array-length v2, v1

    .line 14
    mul-int/lit8 v2, v2, 0x8

    .line 15
    .line 16
    invoke-direct {p0, v2}, Lcom/maxmind/db/Reader;->startNode(I)I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    iget-object v4, p0, Lcom/maxmind/db/Reader;->metadata:Lcom/maxmind/db/Metadata;

    .line 21
    .line 22
    invoke-virtual {v4}, Lcom/maxmind/db/Metadata;->getNodeCount()I

    .line 23
    .line 24
    .line 25
    move-result v4

    .line 26
    const/4 v5, 0x0

    .line 27
    :goto_0
    if-ge v5, v2, :cond_0

    .line 28
    .line 29
    if-ge v3, v4, :cond_0

    .line 30
    .line 31
    div-int/lit8 v6, v5, 0x8

    .line 32
    .line 33
    aget-byte v6, v1, v6

    .line 34
    .line 35
    and-int/lit16 v6, v6, 0xff

    .line 36
    .line 37
    rem-int/lit8 v7, v5, 0x8

    .line 38
    .line 39
    rsub-int/lit8 v7, v7, 0x7

    .line 40
    .line 41
    shr-int/2addr v6, v7

    .line 42
    and-int/lit8 v6, v6, 0x1

    .line 43
    .line 44
    invoke-direct {p0, v0, v3, v6}, Lcom/maxmind/db/Reader;->readNode(Ljava/nio/ByteBuffer;II)I

    .line 45
    .line 46
    .line 47
    move-result v3

    .line 48
    add-int/lit8 v5, v5, 0x1

    .line 49
    .line 50
    goto :goto_0

    .line 51
    :cond_0
    if-le v3, v4, :cond_1

    .line 52
    .line 53
    invoke-direct {p0, v0, v3, p2}, Lcom/maxmind/db/Reader;->resolveDataPointer(Ljava/nio/ByteBuffer;ILjava/lang/Class;)Ljava/lang/Object;

    .line 54
    .line 55
    .line 56
    move-result-object p2

    .line 57
    goto :goto_1

    .line 58
    :cond_1
    const/4 p2, 0x0

    .line 59
    :goto_1
    new-instance v0, Lcom/maxmind/db/DatabaseRecord;

    .line 60
    .line 61
    invoke-direct {v0, p2, p1, v5}, Lcom/maxmind/db/DatabaseRecord;-><init>(Ljava/lang/Object;Ljava/net/InetAddress;I)V

    .line 62
    .line 63
    .line 64
    return-object v0
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method
