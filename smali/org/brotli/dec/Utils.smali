.class public abstract Lorg/brotli/dec/Utils;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final BLOCK_LENGTH_N_BITS:[I

.field public static final BLOCK_LENGTH_OFFSET:[I

.field public static final BYTE_ZEROES:[B

.field public static final CODE_LENGTH_CODE_ORDER:[I

.field public static final COPY_LENGTH_N_BITS:[I

.field public static final COPY_LENGTH_OFFSET:[I

.field public static final COPY_RANGE_LUT:[I

.field public static final DISTANCE_SHORT_CODE_INDEX_OFFSET:[I

.field public static final DISTANCE_SHORT_CODE_VALUE_OFFSET:[I

.field public static final FIXED_TABLE:[I

.field public static final INSERT_LENGTH_N_BITS:[I

.field public static final INSERT_LENGTH_OFFSET:[I

.field public static final INSERT_RANGE_LUT:[I

.field public static final INT_ZEROES:[I

.field public static final LOOKUP:[I

.field public static final LOOKUP_OFFSETS:[I

.field public static final OFFSETS_BY_LENGTH:[I

.field public static final SIZE_BITS_BY_LENGTH:[I


# direct methods
.method static synthetic constructor <clinit>()V
    .locals 2

    .line 1
    const/16 v0, 0x700

    .line 2
    .line 3
    new-array v0, v0, [I

    .line 4
    .line 5
    fill-array-data v0, :array_0

    .line 6
    .line 7
    .line 8
    sput-object v0, Lorg/brotli/dec/Utils;->LOOKUP:[I

    .line 9
    .line 10
    const/16 v0, 0x8

    .line 11
    .line 12
    new-array v0, v0, [I

    .line 13
    .line 14
    fill-array-data v0, :array_1

    .line 15
    .line 16
    .line 17
    sput-object v0, Lorg/brotli/dec/Utils;->LOOKUP_OFFSETS:[I

    .line 18
    .line 19
    const/16 v0, 0x12

    .line 20
    .line 21
    new-array v0, v0, [I

    .line 22
    .line 23
    fill-array-data v0, :array_2

    .line 24
    .line 25
    .line 26
    sput-object v0, Lorg/brotli/dec/Utils;->CODE_LENGTH_CODE_ORDER:[I

    .line 27
    .line 28
    const/16 v0, 0x10

    .line 29
    .line 30
    new-array v1, v0, [I

    .line 31
    .line 32
    fill-array-data v1, :array_3

    .line 33
    .line 34
    .line 35
    sput-object v1, Lorg/brotli/dec/Utils;->DISTANCE_SHORT_CODE_INDEX_OFFSET:[I

    .line 36
    .line 37
    new-array v1, v0, [I

    .line 38
    .line 39
    fill-array-data v1, :array_4

    .line 40
    .line 41
    .line 42
    sput-object v1, Lorg/brotli/dec/Utils;->DISTANCE_SHORT_CODE_VALUE_OFFSET:[I

    .line 43
    .line 44
    new-array v0, v0, [I

    .line 45
    .line 46
    fill-array-data v0, :array_5

    .line 47
    .line 48
    .line 49
    sput-object v0, Lorg/brotli/dec/Utils;->FIXED_TABLE:[I

    .line 50
    .line 51
    const/16 v0, 0x19

    .line 52
    .line 53
    new-array v0, v0, [I

    .line 54
    .line 55
    fill-array-data v0, :array_6

    .line 56
    .line 57
    .line 58
    sput-object v0, Lorg/brotli/dec/Utils;->OFFSETS_BY_LENGTH:[I

    .line 59
    .line 60
    const/16 v0, 0x19

    .line 61
    .line 62
    new-array v0, v0, [I

    .line 63
    .line 64
    fill-array-data v0, :array_7

    .line 65
    .line 66
    .line 67
    sput-object v0, Lorg/brotli/dec/Utils;->SIZE_BITS_BY_LENGTH:[I

    .line 68
    .line 69
    const/16 v0, 0x1a

    .line 70
    .line 71
    new-array v0, v0, [I

    .line 72
    .line 73
    fill-array-data v0, :array_8

    .line 74
    .line 75
    .line 76
    sput-object v0, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_OFFSET:[I

    .line 77
    .line 78
    const/16 v0, 0x1a

    .line 79
    .line 80
    new-array v0, v0, [I

    .line 81
    .line 82
    fill-array-data v0, :array_9

    .line 83
    .line 84
    .line 85
    sput-object v0, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_N_BITS:[I

    .line 86
    .line 87
    const/16 v0, 0x18

    .line 88
    .line 89
    new-array v1, v0, [I

    .line 90
    .line 91
    fill-array-data v1, :array_a

    .line 92
    .line 93
    .line 94
    sput-object v1, Lorg/brotli/dec/Utils;->INSERT_LENGTH_OFFSET:[I

    .line 95
    .line 96
    new-array v1, v0, [I

    .line 97
    .line 98
    fill-array-data v1, :array_b

    .line 99
    .line 100
    .line 101
    sput-object v1, Lorg/brotli/dec/Utils;->INSERT_LENGTH_N_BITS:[I

    .line 102
    .line 103
    new-array v1, v0, [I

    .line 104
    .line 105
    fill-array-data v1, :array_c

    .line 106
    .line 107
    .line 108
    sput-object v1, Lorg/brotli/dec/Utils;->COPY_LENGTH_OFFSET:[I

    .line 109
    .line 110
    new-array v0, v0, [I

    .line 111
    .line 112
    fill-array-data v0, :array_d

    .line 113
    .line 114
    .line 115
    sput-object v0, Lorg/brotli/dec/Utils;->COPY_LENGTH_N_BITS:[I

    .line 116
    .line 117
    const/16 v0, 0x9

    .line 118
    .line 119
    new-array v1, v0, [I

    .line 120
    .line 121
    fill-array-data v1, :array_e

    .line 122
    .line 123
    .line 124
    sput-object v1, Lorg/brotli/dec/Utils;->INSERT_RANGE_LUT:[I

    .line 125
    .line 126
    new-array v0, v0, [I

    .line 127
    .line 128
    fill-array-data v0, :array_f

    .line 129
    .line 130
    .line 131
    sput-object v0, Lorg/brotli/dec/Utils;->COPY_RANGE_LUT:[I

    .line 132
    .line 133
    const/16 v0, 0x400

    .line 134
    .line 135
    new-array v1, v0, [B

    .line 136
    .line 137
    sput-object v1, Lorg/brotli/dec/Utils;->BYTE_ZEROES:[B

    .line 138
    .line 139
    new-array v0, v0, [I

    .line 140
    .line 141
    sput-object v0, Lorg/brotli/dec/Utils;->INT_ZEROES:[I

    .line 142
    .line 143
    return-void

    .line 144
    nop

    .line 145
    :array_0
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x4
        0x4
        0x0
        0x0
        0x4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x8
        0xc
        0x10
        0xc
        0xc
        0x14
        0xc
        0x10
        0x18
        0x1c
        0xc
        0xc
        0x20
        0xc
        0x24
        0xc
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x2c
        0x20
        0x20
        0x18
        0x28
        0x1c
        0xc
        0xc
        0x30
        0x34
        0x34
        0x34
        0x30
        0x34
        0x34
        0x34
        0x30
        0x34
        0x34
        0x34
        0x34
        0x34
        0x30
        0x34
        0x34
        0x34
        0x34
        0x34
        0x30
        0x34
        0x34
        0x34
        0x34
        0x34
        0x18
        0xc
        0x1c
        0xc
        0xc
        0xc
        0x38
        0x3c
        0x3c
        0x3c
        0x38
        0x3c
        0x3c
        0x3c
        0x38
        0x3c
        0x3c
        0x3c
        0x3c
        0x3c
        0x38
        0x3c
        0x3c
        0x3c
        0x3c
        0x3c
        0x38
        0x3c
        0x3c
        0x3c
        0x3c
        0x3c
        0x18
        0xc
        0x1c
        0xc
        0x0
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x0
        0x1
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x2
        0x3
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x1
        0x1
        0x1
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x0
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x1
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x4
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x5
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x6
        0x7
        0x0
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x8
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x10
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x18
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x20
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x28
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x30
        0x38
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
        0x10
        0x11
        0x12
        0x13
        0x14
        0x15
        0x16
        0x17
        0x18
        0x19
        0x1a
        0x1b
        0x1c
        0x1d
        0x1e
        0x1f
        0x20
        0x21
        0x22
        0x23
        0x24
        0x25
        0x26
        0x27
        0x28
        0x29
        0x2a
        0x2b
        0x2c
        0x2d
        0x2e
        0x2f
        0x30
        0x31
        0x32
        0x33
        0x34
        0x35
        0x36
        0x37
        0x38
        0x39
        0x3a
        0x3b
        0x3c
        0x3d
        0x3e
        0x3f
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
        0x10
        0x11
        0x12
        0x13
        0x14
        0x15
        0x16
        0x17
        0x18
        0x19
        0x1a
        0x1b
        0x1c
        0x1d
        0x1e
        0x1f
        0x20
        0x21
        0x22
        0x23
        0x24
        0x25
        0x26
        0x27
        0x28
        0x29
        0x2a
        0x2b
        0x2c
        0x2d
        0x2e
        0x2f
        0x30
        0x31
        0x32
        0x33
        0x34
        0x35
        0x36
        0x37
        0x38
        0x39
        0x3a
        0x3b
        0x3c
        0x3d
        0x3e
        0x3f
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
        0x10
        0x11
        0x12
        0x13
        0x14
        0x15
        0x16
        0x17
        0x18
        0x19
        0x1a
        0x1b
        0x1c
        0x1d
        0x1e
        0x1f
        0x20
        0x21
        0x22
        0x23
        0x24
        0x25
        0x26
        0x27
        0x28
        0x29
        0x2a
        0x2b
        0x2c
        0x2d
        0x2e
        0x2f
        0x30
        0x31
        0x32
        0x33
        0x34
        0x35
        0x36
        0x37
        0x38
        0x39
        0x3a
        0x3b
        0x3c
        0x3d
        0x3e
        0x3f
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
        0x10
        0x11
        0x12
        0x13
        0x14
        0x15
        0x16
        0x17
        0x18
        0x19
        0x1a
        0x1b
        0x1c
        0x1d
        0x1e
        0x1f
        0x20
        0x21
        0x22
        0x23
        0x24
        0x25
        0x26
        0x27
        0x28
        0x29
        0x2a
        0x2b
        0x2c
        0x2d
        0x2e
        0x2f
        0x30
        0x31
        0x32
        0x33
        0x34
        0x35
        0x36
        0x37
        0x38
        0x39
        0x3a
        0x3b
        0x3c
        0x3d
        0x3e
        0x3f
        0x0
        0x0
        0x0
        0x0
        0x1
        0x1
        0x1
        0x1
        0x2
        0x2
        0x2
        0x2
        0x3
        0x3
        0x3
        0x3
        0x4
        0x4
        0x4
        0x4
        0x5
        0x5
        0x5
        0x5
        0x6
        0x6
        0x6
        0x6
        0x7
        0x7
        0x7
        0x7
        0x8
        0x8
        0x8
        0x8
        0x9
        0x9
        0x9
        0x9
        0xa
        0xa
        0xa
        0xa
        0xb
        0xb
        0xb
        0xb
        0xc
        0xc
        0xc
        0xc
        0xd
        0xd
        0xd
        0xd
        0xe
        0xe
        0xe
        0xe
        0xf
        0xf
        0xf
        0xf
        0x10
        0x10
        0x10
        0x10
        0x11
        0x11
        0x11
        0x11
        0x12
        0x12
        0x12
        0x12
        0x13
        0x13
        0x13
        0x13
        0x14
        0x14
        0x14
        0x14
        0x15
        0x15
        0x15
        0x15
        0x16
        0x16
        0x16
        0x16
        0x17
        0x17
        0x17
        0x17
        0x18
        0x18
        0x18
        0x18
        0x19
        0x19
        0x19
        0x19
        0x1a
        0x1a
        0x1a
        0x1a
        0x1b
        0x1b
        0x1b
        0x1b
        0x1c
        0x1c
        0x1c
        0x1c
        0x1d
        0x1d
        0x1d
        0x1d
        0x1e
        0x1e
        0x1e
        0x1e
        0x1f
        0x1f
        0x1f
        0x1f
        0x20
        0x20
        0x20
        0x20
        0x21
        0x21
        0x21
        0x21
        0x22
        0x22
        0x22
        0x22
        0x23
        0x23
        0x23
        0x23
        0x24
        0x24
        0x24
        0x24
        0x25
        0x25
        0x25
        0x25
        0x26
        0x26
        0x26
        0x26
        0x27
        0x27
        0x27
        0x27
        0x28
        0x28
        0x28
        0x28
        0x29
        0x29
        0x29
        0x29
        0x2a
        0x2a
        0x2a
        0x2a
        0x2b
        0x2b
        0x2b
        0x2b
        0x2c
        0x2c
        0x2c
        0x2c
        0x2d
        0x2d
        0x2d
        0x2d
        0x2e
        0x2e
        0x2e
        0x2e
        0x2f
        0x2f
        0x2f
        0x2f
        0x30
        0x30
        0x30
        0x30
        0x31
        0x31
        0x31
        0x31
        0x32
        0x32
        0x32
        0x32
        0x33
        0x33
        0x33
        0x33
        0x34
        0x34
        0x34
        0x34
        0x35
        0x35
        0x35
        0x35
        0x36
        0x36
        0x36
        0x36
        0x37
        0x37
        0x37
        0x37
        0x38
        0x38
        0x38
        0x38
        0x39
        0x39
        0x39
        0x39
        0x3a
        0x3a
        0x3a
        0x3a
        0x3b
        0x3b
        0x3b
        0x3b
        0x3c
        0x3c
        0x3c
        0x3c
        0x3d
        0x3d
        0x3d
        0x3d
        0x3e
        0x3e
        0x3e
        0x3e
        0x3f
        0x3f
        0x3f
        0x3f
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

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
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
    :array_1
    .array-data 4
        0x400
        0x600
        0x500
        0x600
        0x0
        0x100
        0x300
        0x200
    .end array-data

    :array_2
    .array-data 4
        0x1
        0x2
        0x3
        0x4
        0x0
        0x5
        0x11
        0x6
        0x10
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0xe
        0xf
    .end array-data

    :array_3
    .array-data 4
        0x3
        0x2
        0x1
        0x0
        0x3
        0x3
        0x3
        0x3
        0x3
        0x3
        0x2
        0x2
        0x2
        0x2
        0x2
        0x2
    .end array-data

    :array_4
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        -0x1
        0x1
        -0x2
        0x2
        -0x3
        0x3
        -0x1
        0x1
        -0x2
        0x2
        -0x3
        0x3
    .end array-data

    :array_5
    .array-data 4
        0x20000
        0x20004
        0x20003
        0x30002
        0x20000
        0x20004
        0x20003
        0x40001
        0x20000
        0x20004
        0x20003
        0x30002
        0x20000
        0x20004
        0x20003
        0x40005
    .end array-data

    :array_6
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x1000
        0x2400
        0x5400
        0x8c00
        0xac00
        0xd000
        0xf800
        0x12400
        0x15400
        0x16e00
        0x18a00
        0x19900
        0x1a100
        0x1a980
        0x1bb80
        0x1c500
        0x1cf00
        0x1d440
        0x1d9c0
        0x1dca0
    .end array-data

    :array_7
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0xa
        0xa
        0xb
        0xb
        0xa
        0xa
        0xa
        0xa
        0xa
        0x9
        0x9
        0x8
        0x7
        0x7
        0x8
        0x7
        0x7
        0x6
        0x6
        0x5
        0x5
    .end array-data

    :array_8
    .array-data 4
        0x1
        0x5
        0x9
        0xd
        0x11
        0x19
        0x21
        0x29
        0x31
        0x41
        0x51
        0x61
        0x71
        0x91
        0xb1
        0xd1
        0xf1
        0x131
        0x171
        0x1f1
        0x2f1
        0x4f1
        0x8f1
        0x10f1
        0x20f1
        0x40f1
    .end array-data

    :array_9
    .array-data 4
        0x2
        0x2
        0x2
        0x2
        0x3
        0x3
        0x3
        0x3
        0x4
        0x4
        0x4
        0x4
        0x5
        0x5
        0x5
        0x5
        0x6
        0x6
        0x7
        0x8
        0x9
        0xa
        0xb
        0xc
        0xd
        0x18
    .end array-data

    :array_a
    .array-data 4
        0x0
        0x1
        0x2
        0x3
        0x4
        0x5
        0x6
        0x8
        0xa
        0xe
        0x12
        0x1a
        0x22
        0x32
        0x42
        0x62
        0x82
        0xc2
        0x142
        0x242
        0x442
        0x842
        0x1842
        0x5842
    .end array-data

    :array_b
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x1
        0x1
        0x2
        0x2
        0x3
        0x3
        0x4
        0x4
        0x5
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xc
        0xe
        0x18
    .end array-data

    :array_c
    .array-data 4
        0x2
        0x3
        0x4
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0xc
        0xe
        0x12
        0x16
        0x1e
        0x26
        0x36
        0x46
        0x66
        0x86
        0xc6
        0x146
        0x246
        0x446
        0x846
    .end array-data

    :array_d
    .array-data 4
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x1
        0x1
        0x2
        0x2
        0x3
        0x3
        0x4
        0x4
        0x5
        0x5
        0x6
        0x7
        0x8
        0x9
        0xa
        0x18
    .end array-data

    :array_e
    .array-data 4
        0x0
        0x0
        0x8
        0x8
        0x0
        0x10
        0x8
        0x10
        0x10
    .end array-data

    :array_f
    .array-data 4
        0x0
        0x8
        0x0
        0x8
        0x10
        0x0
        0x10
        0x8
        0x10
    .end array-data
.end method

.method public static buildHuffmanTable(II[I[II)V
    .locals 20

    .line 1
    move/from16 v0, p1

    .line 2
    .line 3
    move/from16 v1, p4

    .line 4
    .line 5
    new-array v2, v1, [I

    .line 6
    .line 7
    const/16 v3, 0x10

    .line 8
    .line 9
    new-array v4, v3, [I

    .line 10
    .line 11
    new-array v5, v3, [I

    .line 12
    .line 13
    const/4 v6, 0x0

    .line 14
    const/4 v7, 0x0

    .line 15
    :goto_0
    const/4 v8, 0x1

    .line 16
    if-ge v7, v1, :cond_0

    .line 17
    .line 18
    aget v9, p3, v7

    .line 19
    .line 20
    aget v10, v4, v9

    .line 21
    .line 22
    add-int/2addr v10, v8

    .line 23
    aput v10, v4, v9

    .line 24
    .line 25
    add-int/lit8 v7, v7, 0x1

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    aput v6, v5, v8

    .line 29
    .line 30
    const/4 v7, 0x1

    .line 31
    :goto_1
    const/16 v9, 0xf

    .line 32
    .line 33
    if-ge v7, v9, :cond_1

    .line 34
    .line 35
    add-int/lit8 v9, v7, 0x1

    .line 36
    .line 37
    aget v10, v5, v7

    .line 38
    .line 39
    aget v7, v4, v7

    .line 40
    .line 41
    add-int/2addr v10, v7

    .line 42
    aput v10, v5, v9

    .line 43
    .line 44
    move v7, v9

    .line 45
    goto :goto_1

    .line 46
    :cond_1
    const/4 v7, 0x0

    .line 47
    :goto_2
    if-ge v7, v1, :cond_3

    .line 48
    .line 49
    aget v10, p3, v7

    .line 50
    .line 51
    if-eqz v10, :cond_2

    .line 52
    .line 53
    aget v11, v5, v10

    .line 54
    .line 55
    add-int/lit8 v12, v11, 0x1

    .line 56
    .line 57
    aput v12, v5, v10

    .line 58
    .line 59
    aput v7, v2, v11

    .line 60
    .line 61
    :cond_2
    add-int/lit8 v7, v7, 0x1

    .line 62
    .line 63
    goto :goto_2

    .line 64
    :cond_3
    shl-int v1, v8, v0

    .line 65
    .line 66
    aget v5, v5, v9

    .line 67
    .line 68
    if-ne v5, v8, :cond_4

    .line 69
    .line 70
    const/4 v0, 0x0

    .line 71
    :goto_3
    if-ge v0, v1, :cond_f

    .line 72
    .line 73
    add-int v3, p0, v0

    .line 74
    .line 75
    aget v4, v2, v6

    .line 76
    .line 77
    aput v4, p2, v3

    .line 78
    .line 79
    add-int/lit8 v0, v0, 0x1

    .line 80
    .line 81
    goto :goto_3

    .line 82
    :cond_4
    const/4 v5, 0x2

    .line 83
    const/4 v7, 0x0

    .line 84
    const/4 v10, 0x1

    .line 85
    const/4 v11, 0x2

    .line 86
    :goto_4
    if-gt v10, v0, :cond_8

    .line 87
    .line 88
    :goto_5
    aget v12, v4, v10

    .line 89
    .line 90
    if-lez v12, :cond_7

    .line 91
    .line 92
    add-int v12, p0, v6

    .line 93
    .line 94
    shl-int/lit8 v13, v10, 0x10

    .line 95
    .line 96
    add-int/lit8 v14, v7, 0x1

    .line 97
    .line 98
    aget v7, v2, v7

    .line 99
    .line 100
    or-int/2addr v13, v7

    .line 101
    move v7, v1

    .line 102
    :cond_5
    sub-int/2addr v7, v11

    .line 103
    add-int v15, v12, v7

    .line 104
    .line 105
    aput v13, p2, v15

    .line 106
    .line 107
    if-gtz v7, :cond_5

    .line 108
    .line 109
    add-int/lit8 v7, v10, -0x1

    .line 110
    .line 111
    shl-int v7, v8, v7

    .line 112
    .line 113
    :goto_6
    and-int v12, v6, v7

    .line 114
    .line 115
    if-eqz v12, :cond_6

    .line 116
    .line 117
    shr-int/lit8 v7, v7, 0x1

    .line 118
    .line 119
    goto :goto_6

    .line 120
    :cond_6
    add-int/lit8 v12, v7, -0x1

    .line 121
    .line 122
    and-int/2addr v6, v12

    .line 123
    add-int/2addr v6, v7

    .line 124
    aget v7, v4, v10

    .line 125
    .line 126
    sub-int/2addr v7, v8

    .line 127
    aput v7, v4, v10

    .line 128
    .line 129
    move v7, v14

    .line 130
    goto :goto_5

    .line 131
    :cond_7
    add-int/lit8 v10, v10, 0x1

    .line 132
    .line 133
    shl-int/lit8 v11, v11, 0x1

    .line 134
    .line 135
    goto :goto_4

    .line 136
    :cond_8
    add-int/lit8 v10, v1, -0x1

    .line 137
    .line 138
    add-int/lit8 v11, v0, 0x1

    .line 139
    .line 140
    const/4 v12, -0x1

    .line 141
    move/from16 v13, p0

    .line 142
    .line 143
    :goto_7
    if-gt v11, v9, :cond_f

    .line 144
    .line 145
    :goto_8
    aget v14, v4, v11

    .line 146
    .line 147
    if-lez v14, :cond_e

    .line 148
    .line 149
    and-int v14, v6, v10

    .line 150
    .line 151
    if-eq v14, v12, :cond_b

    .line 152
    .line 153
    add-int/2addr v13, v1

    .line 154
    sub-int v1, v11, v0

    .line 155
    .line 156
    shl-int v1, v8, v1

    .line 157
    .line 158
    move v12, v11

    .line 159
    :goto_9
    if-ge v12, v9, :cond_a

    .line 160
    .line 161
    aget v15, v4, v12

    .line 162
    .line 163
    sub-int/2addr v1, v15

    .line 164
    if-gtz v1, :cond_9

    .line 165
    .line 166
    goto :goto_a

    .line 167
    :cond_9
    add-int/lit8 v12, v12, 0x1

    .line 168
    .line 169
    shl-int/lit8 v1, v1, 0x1

    .line 170
    .line 171
    goto :goto_9

    .line 172
    :cond_a
    :goto_a
    sub-int/2addr v12, v0

    .line 173
    shl-int v1, v8, v12

    .line 174
    .line 175
    add-int v15, p0, v14

    .line 176
    .line 177
    add-int/2addr v12, v0

    .line 178
    shl-int/2addr v12, v3

    .line 179
    sub-int v16, v13, p0

    .line 180
    .line 181
    sub-int v16, v16, v14

    .line 182
    .line 183
    or-int v12, v12, v16

    .line 184
    .line 185
    aput v12, p2, v15

    .line 186
    .line 187
    move/from16 v16, v14

    .line 188
    .line 189
    move v15, v13

    .line 190
    move v14, v1

    .line 191
    goto :goto_b

    .line 192
    :cond_b
    move/from16 v16, v12

    .line 193
    .line 194
    move v14, v1

    .line 195
    move v15, v13

    .line 196
    :goto_b
    shr-int v1, v6, v0

    .line 197
    .line 198
    add-int v17, v15, v1

    .line 199
    .line 200
    sub-int v1, v11, v0

    .line 201
    .line 202
    shl-int/2addr v1, v3

    .line 203
    add-int/lit8 v18, v7, 0x1

    .line 204
    .line 205
    aget v7, v2, v7

    .line 206
    .line 207
    or-int v19, v1, v7

    .line 208
    .line 209
    move v1, v14

    .line 210
    :cond_c
    sub-int/2addr v1, v5

    .line 211
    add-int v7, v17, v1

    .line 212
    .line 213
    aput v19, p2, v7

    .line 214
    .line 215
    if-gtz v1, :cond_c

    .line 216
    .line 217
    add-int/lit8 v1, v11, -0x1

    .line 218
    .line 219
    shl-int v1, v8, v1

    .line 220
    .line 221
    :goto_c
    and-int v7, v6, v1

    .line 222
    .line 223
    if-eqz v7, :cond_d

    .line 224
    .line 225
    shr-int/lit8 v1, v1, 0x1

    .line 226
    .line 227
    goto :goto_c

    .line 228
    :cond_d
    add-int/lit8 v7, v1, -0x1

    .line 229
    .line 230
    and-int/2addr v6, v7

    .line 231
    add-int/2addr v6, v1

    .line 232
    aget v1, v4, v11

    .line 233
    .line 234
    sub-int/2addr v1, v8

    .line 235
    aput v1, v4, v11

    .line 236
    .line 237
    move v1, v14

    .line 238
    move v13, v15

    .line 239
    move/from16 v12, v16

    .line 240
    .line 241
    move/from16 v7, v18

    .line 242
    .line 243
    goto :goto_8

    .line 244
    :cond_e
    add-int/lit8 v11, v11, 0x1

    .line 245
    .line 246
    shl-int/lit8 v5, v5, 0x1

    .line 247
    .line 248
    goto :goto_7

    .line 249
    :cond_f
    return-void
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
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
    .line 672
    .line 673
    .line 674
    .line 675
    .line 676
    .line 677
    .line 678
    .line 679
    .line 680
    .line 681
    .line 682
    .line 683
    .line 684
    .line 685
    .line 686
    .line 687
    .line 688
    .line 689
    .line 690
    .line 691
    .line 692
    .line 693
    .line 694
    .line 695
    .line 696
    .line 697
    .line 698
    .line 699
    .line 700
    .line 701
    .line 702
    .line 703
    .line 704
    .line 705
    .line 706
    .line 707
    .line 708
    .line 709
    .line 710
    .line 711
    .line 712
    .line 713
    .line 714
    .line 715
    .line 716
    .line 717
    .line 718
    .line 719
    .line 720
    .line 721
    .line 722
    .line 723
    .line 724
    .line 725
    .line 726
    .line 727
    .line 728
    .line 729
    .line 730
    .line 731
    .line 732
    .line 733
    .line 734
    .line 735
    .line 736
    .line 737
    .line 738
    .line 739
    .line 740
    .line 741
    .line 742
    .line 743
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
    .line 749
    .line 750
    .line 751
    .line 752
    .line 753
    .line 754
    .line 755
    .line 756
    .line 757
    .line 758
    .line 759
    .line 760
    .line 761
    .line 762
    .line 763
    .line 764
    .line 765
    .line 766
    .line 767
    .line 768
    .line 769
    .line 770
    .line 771
    .line 772
    .line 773
    .line 774
    .line 775
    .line 776
    .line 777
    .line 778
    .line 779
    .line 780
    .line 781
    .line 782
    .line 783
    .line 784
    .line 785
    .line 786
    .line 787
    .line 788
    .line 789
    .line 790
    .line 791
    .line 792
    .line 793
    .line 794
    .line 795
    .line 796
    .line 797
    .line 798
    .line 799
    .line 800
    .line 801
    .line 802
    .line 803
    .line 804
    .line 805
    .line 806
    .line 807
    .line 808
    .line 809
    .line 810
.end method

.method public static decodeBlockTypeAndLength(Lorg/brotli/dec/State;I)V
    .locals 8

    .line 1
    iget-object v0, p0, Lorg/brotli/dec/State;->br:Lorg/brotli/dec/BitReader;

    .line 2
    .line 3
    iget-object v1, p0, Lorg/brotli/dec/State;->blockTypeRb:[I

    .line 4
    .line 5
    mul-int/lit8 v2, p1, 0x2

    .line 6
    .line 7
    invoke-static {v0}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 8
    .line 9
    .line 10
    iget-object v3, p0, Lorg/brotli/dec/State;->blockTypeTrees:[I

    .line 11
    .line 12
    mul-int/lit16 v4, p1, 0x438

    .line 13
    .line 14
    invoke-static {v3, v4, v0}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 15
    .line 16
    .line 17
    move-result v3

    .line 18
    iget-object v5, p0, Lorg/brotli/dec/State;->blockLength:[I

    .line 19
    .line 20
    iget-object v6, p0, Lorg/brotli/dec/State;->blockLenTrees:[I

    .line 21
    .line 22
    invoke-static {v0}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 23
    .line 24
    .line 25
    invoke-static {v6, v4, v0}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 26
    .line 27
    .line 28
    move-result v4

    .line 29
    sget-object v6, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_N_BITS:[I

    .line 30
    .line 31
    aget v6, v6, v4

    .line 32
    .line 33
    sget-object v7, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_OFFSET:[I

    .line 34
    .line 35
    aget v4, v7, v4

    .line 36
    .line 37
    invoke-static {v0, v6}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 38
    .line 39
    .line 40
    move-result v0

    .line 41
    add-int/2addr v0, v4

    .line 42
    aput v0, v5, p1

    .line 43
    .line 44
    const/4 v0, 0x1

    .line 45
    if-ne v3, v0, :cond_0

    .line 46
    .line 47
    add-int/lit8 v3, v2, 0x1

    .line 48
    .line 49
    aget v3, v1, v3

    .line 50
    .line 51
    add-int/2addr v3, v0

    .line 52
    goto :goto_0

    .line 53
    :cond_0
    if-nez v3, :cond_1

    .line 54
    .line 55
    aget v3, v1, v2

    .line 56
    .line 57
    goto :goto_0

    .line 58
    :cond_1
    add-int/lit8 v3, v3, -0x2

    .line 59
    .line 60
    :goto_0
    iget-object p0, p0, Lorg/brotli/dec/State;->numBlockTypes:[I

    .line 61
    .line 62
    aget p0, p0, p1

    .line 63
    .line 64
    if-lt v3, p0, :cond_2

    .line 65
    .line 66
    sub-int/2addr v3, p0

    .line 67
    :cond_2
    add-int/lit8 p0, v2, 0x1

    .line 68
    .line 69
    aget p1, v1, p0

    .line 70
    .line 71
    aput p1, v1, v2

    .line 72
    .line 73
    aput v3, v1, p0

    .line 74
    .line 75
    return-void
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

.method public static decodeContextMap(I[BLorg/brotli/dec/BitReader;)I
    .locals 8

    .line 1
    invoke-static {p2}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x1

    .line 5
    invoke-static {p2, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    const/4 v2, 0x0

    .line 10
    if-eqz v1, :cond_1

    .line 11
    .line 12
    const/4 v1, 0x3

    .line 13
    invoke-static {p2, v1}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 14
    .line 15
    .line 16
    move-result v1

    .line 17
    if-nez v1, :cond_0

    .line 18
    .line 19
    const/4 v3, 0x1

    .line 20
    goto :goto_0

    .line 21
    :cond_0
    invoke-static {p2, v1}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 22
    .line 23
    .line 24
    move-result v3

    .line 25
    shl-int v1, v0, v1

    .line 26
    .line 27
    add-int/2addr v3, v1

    .line 28
    goto :goto_0

    .line 29
    :cond_1
    const/4 v3, 0x0

    .line 30
    :goto_0
    add-int/2addr v3, v0

    .line 31
    if-ne v3, v0, :cond_2

    .line 32
    .line 33
    const/4 p2, 0x0

    .line 34
    :goto_1
    if-ge p2, p0, :cond_c

    .line 35
    .line 36
    add-int/lit16 v0, p2, 0x400

    .line 37
    .line 38
    invoke-static {v0, p0}, Ljava/lang/Math;->min(II)I

    .line 39
    .line 40
    .line 41
    move-result v0

    .line 42
    sub-int/2addr v0, p2

    .line 43
    sget-object v1, Lorg/brotli/dec/Utils;->BYTE_ZEROES:[B

    .line 44
    .line 45
    invoke-static {v1, v2, p1, p2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 46
    .line 47
    .line 48
    add-int/2addr p2, v0

    .line 49
    goto :goto_1

    .line 50
    :cond_2
    invoke-static {p2, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 51
    .line 52
    .line 53
    move-result v1

    .line 54
    if-ne v1, v0, :cond_3

    .line 55
    .line 56
    const/4 v1, 0x4

    .line 57
    invoke-static {p2, v1}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 58
    .line 59
    .line 60
    move-result v1

    .line 61
    add-int/2addr v1, v0

    .line 62
    goto :goto_2

    .line 63
    :cond_3
    const/4 v1, 0x0

    .line 64
    :goto_2
    const/16 v4, 0x438

    .line 65
    .line 66
    new-array v4, v4, [I

    .line 67
    .line 68
    add-int v5, v3, v1

    .line 69
    .line 70
    invoke-static {v5, v4, v2, p2}, Lorg/brotli/dec/Utils;->readHuffmanCode(I[IILorg/brotli/dec/BitReader;)V

    .line 71
    .line 72
    .line 73
    const/4 v5, 0x0

    .line 74
    :cond_4
    :goto_3
    if-ge v5, p0, :cond_8

    .line 75
    .line 76
    invoke-static {p2}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 77
    .line 78
    .line 79
    invoke-static {p2}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 80
    .line 81
    .line 82
    invoke-static {v4, v2, p2}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 83
    .line 84
    .line 85
    move-result v6

    .line 86
    if-nez v6, :cond_5

    .line 87
    .line 88
    aput-byte v2, p1, v5

    .line 89
    .line 90
    :goto_4
    add-int/lit8 v5, v5, 0x1

    .line 91
    .line 92
    goto :goto_3

    .line 93
    :cond_5
    if-gt v6, v1, :cond_7

    .line 94
    .line 95
    shl-int v7, v0, v6

    .line 96
    .line 97
    invoke-static {p2, v6}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 98
    .line 99
    .line 100
    move-result v6

    .line 101
    add-int/2addr v6, v7

    .line 102
    :goto_5
    if-eqz v6, :cond_4

    .line 103
    .line 104
    if-ge v5, p0, :cond_6

    .line 105
    .line 106
    aput-byte v2, p1, v5

    .line 107
    .line 108
    add-int/lit8 v5, v5, 0x1

    .line 109
    .line 110
    add-int/lit8 v6, v6, -0x1

    .line 111
    .line 112
    goto :goto_5

    .line 113
    :cond_6
    new-instance p0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 114
    .line 115
    const-string p1, "Corrupted context map"

    .line 116
    .line 117
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 118
    .line 119
    .line 120
    throw p0

    .line 121
    :cond_7
    sub-int/2addr v6, v1

    .line 122
    int-to-byte v6, v6

    .line 123
    aput-byte v6, p1, v5

    .line 124
    .line 125
    goto :goto_4

    .line 126
    :cond_8
    invoke-static {p2, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 127
    .line 128
    .line 129
    move-result p2

    .line 130
    if-ne p2, v0, :cond_c

    .line 131
    .line 132
    const/16 p2, 0x100

    .line 133
    .line 134
    new-array v0, p2, [I

    .line 135
    .line 136
    const/4 v1, 0x0

    .line 137
    :goto_6
    if-ge v1, p2, :cond_9

    .line 138
    .line 139
    aput v1, v0, v1

    .line 140
    .line 141
    add-int/lit8 v1, v1, 0x1

    .line 142
    .line 143
    goto :goto_6

    .line 144
    :cond_9
    const/4 p2, 0x0

    .line 145
    :goto_7
    if-ge p2, p0, :cond_c

    .line 146
    .line 147
    aget-byte v1, p1, p2

    .line 148
    .line 149
    and-int/lit16 v1, v1, 0xff

    .line 150
    .line 151
    aget v4, v0, v1

    .line 152
    .line 153
    int-to-byte v5, v4

    .line 154
    aput-byte v5, p1, p2

    .line 155
    .line 156
    if-eqz v1, :cond_b

    .line 157
    .line 158
    :goto_8
    if-lez v1, :cond_a

    .line 159
    .line 160
    add-int/lit8 v5, v1, -0x1

    .line 161
    .line 162
    aget v5, v0, v5

    .line 163
    .line 164
    aput v5, v0, v1

    .line 165
    .line 166
    add-int/lit8 v1, v1, -0x1

    .line 167
    .line 168
    goto :goto_8

    .line 169
    :cond_a
    aput v4, v0, v2

    .line 170
    .line 171
    :cond_b
    add-int/lit8 p2, p2, 0x1

    .line 172
    .line 173
    goto :goto_7

    .line 174
    :cond_c
    return v3
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

.method public static decodeLiteralBlockSwitch(Lorg/brotli/dec/State;)V
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-static {p0, v0}, Lorg/brotli/dec/Utils;->decodeBlockTypeAndLength(Lorg/brotli/dec/State;I)V

    .line 3
    .line 4
    .line 5
    iget-object v0, p0, Lorg/brotli/dec/State;->blockTypeRb:[I

    .line 6
    .line 7
    const/4 v1, 0x1

    .line 8
    aget v0, v0, v1

    .line 9
    .line 10
    shl-int/lit8 v2, v0, 0x6

    .line 11
    .line 12
    iput v2, p0, Lorg/brotli/dec/State;->contextMapSlice:I

    .line 13
    .line 14
    iget-object v3, p0, Lorg/brotli/dec/State;->contextMap:[B

    .line 15
    .line 16
    aget-byte v2, v3, v2

    .line 17
    .line 18
    and-int/lit16 v2, v2, 0xff

    .line 19
    .line 20
    iget-object v3, p0, Lorg/brotli/dec/State;->hGroup0:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 21
    .line 22
    iget-object v3, v3, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v3, [I

    .line 25
    .line 26
    aget v2, v3, v2

    .line 27
    .line 28
    iput v2, p0, Lorg/brotli/dec/State;->literalTree:I

    .line 29
    .line 30
    iget-object v2, p0, Lorg/brotli/dec/State;->contextModes:[B

    .line 31
    .line 32
    aget-byte v0, v2, v0

    .line 33
    .line 34
    sget-object v2, Lorg/brotli/dec/Utils;->LOOKUP_OFFSETS:[I

    .line 35
    .line 36
    aget v3, v2, v0

    .line 37
    .line 38
    iput v3, p0, Lorg/brotli/dec/State;->contextLookupOffset1:I

    .line 39
    .line 40
    add-int/2addr v0, v1

    .line 41
    aget v0, v2, v0

    .line 42
    .line 43
    iput v0, p0, Lorg/brotli/dec/State;->contextLookupOffset2:I

    .line 44
    .line 45
    return-void
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

.method public static decompress(Lorg/brotli/dec/State;)V
    .locals 30

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget v1, v0, Lorg/brotli/dec/State;->runningState:I

    .line 4
    .line 5
    iget-object v2, v0, Lorg/brotli/dec/State;->blockTypeRb:[I

    .line 6
    .line 7
    iget-object v3, v0, Lorg/brotli/dec/State;->hGroup2:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 8
    .line 9
    iget-object v4, v0, Lorg/brotli/dec/State;->hGroup0:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 10
    .line 11
    iget-object v5, v0, Lorg/brotli/dec/State;->hGroup1:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 12
    .line 13
    iget-object v6, v0, Lorg/brotli/dec/State;->br:Lorg/brotli/dec/BitReader;

    .line 14
    .line 15
    iget-object v7, v0, Lorg/brotli/dec/State;->blockLength:[I

    .line 16
    .line 17
    if-eqz v1, :cond_63

    .line 18
    .line 19
    const/16 v8, 0xb

    .line 20
    .line 21
    if-eq v1, v8, :cond_62

    .line 22
    .line 23
    iget v1, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 24
    .line 25
    const/4 v9, 0x1

    .line 26
    sub-int/2addr v1, v9

    .line 27
    iget-object v10, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 28
    .line 29
    :goto_0
    iget v11, v0, Lorg/brotli/dec/State;->runningState:I

    .line 30
    .line 31
    const-string v12, "Invalid metablock length"

    .line 32
    .line 33
    const-string v13, "Corrupted padding bits"

    .line 34
    .line 35
    const/16 v15, 0xa

    .line 36
    .line 37
    const/16 v16, 0x1

    .line 38
    .line 39
    if-eq v11, v15, :cond_5d

    .line 40
    .line 41
    const/16 v17, 0x7

    .line 42
    .line 43
    const/16 v9, 0xc

    .line 44
    .line 45
    if-eq v11, v9, :cond_58

    .line 46
    .line 47
    const/16 v20, 0x10

    .line 48
    .line 49
    const-string v15, "Invalid backward reference"

    .line 50
    .line 51
    const/16 v24, 0x5

    .line 52
    .line 53
    const/4 v8, 0x4

    .line 54
    const/16 v25, 0x6

    .line 55
    .line 56
    const/16 v26, 0x2

    .line 57
    .line 58
    packed-switch v11, :pswitch_data_0

    .line 59
    .line 60
    .line 61
    new-instance v1, Lorg/brotli/dec/BrotliRuntimeException;

    .line 62
    .line 63
    new-instance v2, Ljava/lang/StringBuilder;

    .line 64
    .line 65
    const-string v3, "Unexpected state "

    .line 66
    .line 67
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 68
    .line 69
    .line 70
    iget v0, v0, Lorg/brotli/dec/State;->runningState:I

    .line 71
    .line 72
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v0

    .line 79
    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    throw v1

    .line 83
    :pswitch_0
    iget v11, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 84
    .line 85
    if-lt v11, v8, :cond_e

    .line 86
    .line 87
    const/16 v8, 0x18

    .line 88
    .line 89
    if-gt v11, v8, :cond_e

    .line 90
    .line 91
    sget-object v8, Lorg/brotli/dec/Utils;->OFFSETS_BY_LENGTH:[I

    .line 92
    .line 93
    aget v8, v8, v11

    .line 94
    .line 95
    iget v12, v0, Lorg/brotli/dec/State;->distance:I

    .line 96
    .line 97
    iget v13, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 98
    .line 99
    sub-int/2addr v12, v13

    .line 100
    add-int/lit8 v12, v12, -0x1

    .line 101
    .line 102
    sget-object v13, Lorg/brotli/dec/Utils;->SIZE_BITS_BY_LENGTH:[I

    .line 103
    .line 104
    aget v13, v13, v11

    .line 105
    .line 106
    shl-int v17, v16, v13

    .line 107
    .line 108
    add-int/lit8 v17, v17, -0x1

    .line 109
    .line 110
    and-int v17, v12, v17

    .line 111
    .line 112
    ushr-int/2addr v12, v13

    .line 113
    mul-int v17, v17, v11

    .line 114
    .line 115
    add-int v17, v17, v8

    .line 116
    .line 117
    sget-object v8, Lorg/brotli/dec/Transform;->TRANSFORMS:[Lorg/brotli/dec/Transform;

    .line 118
    .line 119
    array-length v13, v8

    .line 120
    if-ge v12, v13, :cond_d

    .line 121
    .line 122
    iget v13, v0, Lorg/brotli/dec/State;->copyDst:I

    .line 123
    .line 124
    sget-object v15, Lorg/brotli/dec/Dictionary$DataHolder;->DATA:[B

    .line 125
    .line 126
    aget-object v8, v8, v12

    .line 127
    .line 128
    iget-object v12, v8, Lorg/brotli/dec/Transform;->prefix:[B

    .line 129
    .line 130
    array-length v14, v12

    .line 131
    move/from16 v18, v13

    .line 132
    .line 133
    const/4 v9, 0x0

    .line 134
    :goto_1
    if-ge v9, v14, :cond_0

    .line 135
    .line 136
    add-int/lit8 v20, v18, 0x1

    .line 137
    .line 138
    add-int/lit8 v22, v9, 0x1

    .line 139
    .line 140
    aget-byte v9, v12, v9

    .line 141
    .line 142
    aput-byte v9, v10, v18

    .line 143
    .line 144
    move/from16 v18, v20

    .line 145
    .line 146
    move/from16 v9, v22

    .line 147
    .line 148
    goto :goto_1

    .line 149
    :cond_0
    iget v9, v8, Lorg/brotli/dec/Transform;->type:I

    .line 150
    .line 151
    const/16 v12, 0xc

    .line 152
    .line 153
    if-lt v9, v12, :cond_1

    .line 154
    .line 155
    add-int/lit8 v12, v9, -0xb

    .line 156
    .line 157
    goto :goto_2

    .line 158
    :cond_1
    const/4 v12, 0x0

    .line 159
    :goto_2
    if-le v12, v11, :cond_2

    .line 160
    .line 161
    move v12, v11

    .line 162
    :cond_2
    add-int v17, v17, v12

    .line 163
    .line 164
    sub-int/2addr v11, v12

    .line 165
    const/16 v12, 0x9

    .line 166
    .line 167
    if-gt v9, v12, :cond_3

    .line 168
    .line 169
    move v12, v9

    .line 170
    goto :goto_3

    .line 171
    :cond_3
    const/4 v12, 0x0

    .line 172
    :goto_3
    sub-int/2addr v11, v12

    .line 173
    move v12, v11

    .line 174
    :goto_4
    if-lez v12, :cond_4

    .line 175
    .line 176
    add-int/lit8 v14, v18, 0x1

    .line 177
    .line 178
    add-int/lit8 v20, v17, 0x1

    .line 179
    .line 180
    aget-byte v17, v15, v17

    .line 181
    .line 182
    aput-byte v17, v10, v18

    .line 183
    .line 184
    add-int/lit8 v12, v12, -0x1

    .line 185
    .line 186
    move/from16 v18, v14

    .line 187
    .line 188
    move/from16 v17, v20

    .line 189
    .line 190
    goto :goto_4

    .line 191
    :cond_4
    const/16 v14, 0xb

    .line 192
    .line 193
    const/16 v12, 0xa

    .line 194
    .line 195
    if-eq v9, v14, :cond_5

    .line 196
    .line 197
    if-ne v9, v12, :cond_a

    .line 198
    .line 199
    :cond_5
    sub-int v15, v18, v11

    .line 200
    .line 201
    if-ne v9, v12, :cond_6

    .line 202
    .line 203
    const/4 v11, 0x1

    .line 204
    :cond_6
    :goto_5
    if-lez v11, :cond_a

    .line 205
    .line 206
    aget-byte v9, v10, v15

    .line 207
    .line 208
    and-int/lit16 v12, v9, 0xff

    .line 209
    .line 210
    const/16 v14, 0xc0

    .line 211
    .line 212
    if-ge v12, v14, :cond_8

    .line 213
    .line 214
    const/16 v14, 0x61

    .line 215
    .line 216
    if-lt v12, v14, :cond_7

    .line 217
    .line 218
    const/16 v14, 0x7a

    .line 219
    .line 220
    if-gt v12, v14, :cond_7

    .line 221
    .line 222
    xor-int/lit8 v9, v9, 0x20

    .line 223
    .line 224
    int-to-byte v9, v9

    .line 225
    aput-byte v9, v10, v15

    .line 226
    .line 227
    :cond_7
    add-int/lit8 v15, v15, 0x1

    .line 228
    .line 229
    add-int/lit8 v11, v11, -0x1

    .line 230
    .line 231
    :goto_6
    const/16 v14, 0xb

    .line 232
    .line 233
    goto :goto_5

    .line 234
    :cond_8
    const/16 v9, 0xe0

    .line 235
    .line 236
    if-ge v12, v9, :cond_9

    .line 237
    .line 238
    add-int/lit8 v9, v15, 0x1

    .line 239
    .line 240
    aget-byte v12, v10, v9

    .line 241
    .line 242
    xor-int/lit8 v12, v12, 0x20

    .line 243
    .line 244
    int-to-byte v12, v12

    .line 245
    aput-byte v12, v10, v9

    .line 246
    .line 247
    add-int/lit8 v15, v15, 0x2

    .line 248
    .line 249
    add-int/lit8 v11, v11, -0x2

    .line 250
    .line 251
    goto :goto_6

    .line 252
    :cond_9
    add-int/lit8 v9, v15, 0x2

    .line 253
    .line 254
    aget-byte v12, v10, v9

    .line 255
    .line 256
    xor-int/lit8 v12, v12, 0x5

    .line 257
    .line 258
    int-to-byte v12, v12

    .line 259
    aput-byte v12, v10, v9

    .line 260
    .line 261
    add-int/lit8 v15, v15, 0x3

    .line 262
    .line 263
    add-int/lit8 v11, v11, -0x3

    .line 264
    .line 265
    goto :goto_6

    .line 266
    :cond_a
    iget-object v8, v8, Lorg/brotli/dec/Transform;->suffix:[B

    .line 267
    .line 268
    array-length v9, v8

    .line 269
    const/4 v11, 0x0

    .line 270
    :goto_7
    if-ge v11, v9, :cond_b

    .line 271
    .line 272
    add-int/lit8 v12, v18, 0x1

    .line 273
    .line 274
    add-int/lit8 v14, v11, 0x1

    .line 275
    .line 276
    aget-byte v11, v8, v11

    .line 277
    .line 278
    aput-byte v11, v10, v18

    .line 279
    .line 280
    move/from16 v18, v12

    .line 281
    .line 282
    move v11, v14

    .line 283
    goto :goto_7

    .line 284
    :cond_b
    sub-int v18, v18, v13

    .line 285
    .line 286
    iget v8, v0, Lorg/brotli/dec/State;->copyDst:I

    .line 287
    .line 288
    add-int v8, v8, v18

    .line 289
    .line 290
    iput v8, v0, Lorg/brotli/dec/State;->copyDst:I

    .line 291
    .line 292
    iget v9, v0, Lorg/brotli/dec/State;->pos:I

    .line 293
    .line 294
    add-int v9, v9, v18

    .line 295
    .line 296
    iput v9, v0, Lorg/brotli/dec/State;->pos:I

    .line 297
    .line 298
    iget v9, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 299
    .line 300
    sub-int v9, v9, v18

    .line 301
    .line 302
    iput v9, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 303
    .line 304
    iget v9, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 305
    .line 306
    if-lt v8, v9, :cond_c

    .line 307
    .line 308
    const/16 v8, 0x8

    .line 309
    .line 310
    iput v8, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 311
    .line 312
    iput v9, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 313
    .line 314
    const/4 v8, 0x0

    .line 315
    iput v8, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 316
    .line 317
    const/16 v12, 0xc

    .line 318
    .line 319
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 320
    .line 321
    :goto_8
    move-object/from16 v21, v10

    .line 322
    .line 323
    goto/16 :goto_32

    .line 324
    .line 325
    :cond_c
    const/4 v8, 0x3

    .line 326
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 327
    .line 328
    goto :goto_8

    .line 329
    :cond_d
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 330
    .line 331
    invoke-direct {v0, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 332
    .line 333
    .line 334
    throw v0

    .line 335
    :cond_e
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 336
    .line 337
    invoke-direct {v0, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 338
    .line 339
    .line 340
    throw v0

    .line 341
    :pswitch_1
    iget v8, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 342
    .line 343
    iget v9, v0, Lorg/brotli/dec/State;->copyDst:I

    .line 344
    .line 345
    sub-int/2addr v9, v8

    .line 346
    const/4 v11, 0x0

    .line 347
    invoke-static {v10, v8, v10, v11, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 348
    .line 349
    .line 350
    const/4 v8, 0x3

    .line 351
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 352
    .line 353
    goto :goto_8

    .line 354
    :pswitch_2
    move-object/from16 v21, v10

    .line 355
    .line 356
    goto/16 :goto_1d

    .line 357
    .line 358
    :pswitch_3
    move-object/from16 v21, v10

    .line 359
    .line 360
    const/4 v11, 0x0

    .line 361
    const/16 v28, 0x4

    .line 362
    .line 363
    goto/16 :goto_16

    .line 364
    .line 365
    :pswitch_4
    const/4 v11, 0x0

    .line 366
    iget-object v8, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 367
    .line 368
    iget v9, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 369
    .line 370
    if-gtz v9, :cond_10

    .line 371
    .line 372
    iget v8, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 373
    .line 374
    const/16 v9, 0x40

    .line 375
    .line 376
    if-ne v8, v9, :cond_f

    .line 377
    .line 378
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 379
    .line 380
    .line 381
    invoke-static {v6, v11}, Lorg/brotli/dec/BitReader;->checkHealth(Lorg/brotli/dec/BitReader;Z)V

    .line 382
    .line 383
    .line 384
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 385
    .line 386
    .line 387
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 388
    .line 389
    .line 390
    :cond_f
    const/4 v8, 0x1

    .line 391
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 392
    .line 393
    goto :goto_8

    .line 394
    :cond_10
    iget v11, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 395
    .line 396
    iget v12, v0, Lorg/brotli/dec/State;->pos:I

    .line 397
    .line 398
    sub-int/2addr v11, v12

    .line 399
    invoke-static {v11, v9}, Ljava/lang/Math;->min(II)I

    .line 400
    .line 401
    .line 402
    move-result v9

    .line 403
    iget v11, v0, Lorg/brotli/dec/State;->pos:I

    .line 404
    .line 405
    iget v12, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 406
    .line 407
    and-int/lit8 v12, v12, 0x7

    .line 408
    .line 409
    if-nez v12, :cond_1b

    .line 410
    .line 411
    move v12, v9

    .line 412
    :goto_9
    iget v13, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 413
    .line 414
    const/16 v14, 0x40

    .line 415
    .line 416
    if-eq v13, v14, :cond_11

    .line 417
    .line 418
    if-eqz v12, :cond_11

    .line 419
    .line 420
    add-int/lit8 v14, v11, 0x1

    .line 421
    .line 422
    move v15, v9

    .line 423
    move-object/from16 v21, v10

    .line 424
    .line 425
    iget-wide v9, v6, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 426
    .line 427
    ushr-long/2addr v9, v13

    .line 428
    long-to-int v10, v9

    .line 429
    int-to-byte v9, v10

    .line 430
    aput-byte v9, v8, v11

    .line 431
    .line 432
    add-int/lit8 v13, v13, 0x8

    .line 433
    .line 434
    iput v13, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 435
    .line 436
    add-int/lit8 v12, v12, -0x1

    .line 437
    .line 438
    move v11, v14

    .line 439
    move v9, v15

    .line 440
    move-object/from16 v10, v21

    .line 441
    .line 442
    goto :goto_9

    .line 443
    :cond_11
    move v15, v9

    .line 444
    move-object/from16 v21, v10

    .line 445
    .line 446
    if-nez v12, :cond_12

    .line 447
    .line 448
    goto :goto_c

    .line 449
    :cond_12
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->intAvailable(Lorg/brotli/dec/BitReader;)I

    .line 450
    .line 451
    .line 452
    move-result v9

    .line 453
    shr-int/lit8 v10, v12, 0x2

    .line 454
    .line 455
    invoke-static {v9, v10}, Ljava/lang/Math;->min(II)I

    .line 456
    .line 457
    .line 458
    move-result v9

    .line 459
    if-lez v9, :cond_13

    .line 460
    .line 461
    iget v10, v6, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 462
    .line 463
    shl-int/lit8 v10, v10, 0x2

    .line 464
    .line 465
    iget-object v13, v6, Lorg/brotli/dec/BitReader;->byteBuffer:[B

    .line 466
    .line 467
    shl-int/lit8 v14, v9, 0x2

    .line 468
    .line 469
    invoke-static {v13, v10, v8, v11, v14}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 470
    .line 471
    .line 472
    add-int/2addr v11, v14

    .line 473
    sub-int/2addr v12, v14

    .line 474
    iget v10, v6, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 475
    .line 476
    add-int/2addr v10, v9

    .line 477
    iput v10, v6, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 478
    .line 479
    :cond_13
    if-nez v12, :cond_14

    .line 480
    .line 481
    goto :goto_c

    .line 482
    :cond_14
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->intAvailable(Lorg/brotli/dec/BitReader;)I

    .line 483
    .line 484
    .line 485
    move-result v9

    .line 486
    if-lez v9, :cond_16

    .line 487
    .line 488
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 489
    .line 490
    .line 491
    :goto_a
    if-eqz v12, :cond_15

    .line 492
    .line 493
    add-int/lit8 v9, v11, 0x1

    .line 494
    .line 495
    iget-wide v13, v6, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 496
    .line 497
    iget v10, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 498
    .line 499
    ushr-long/2addr v13, v10

    .line 500
    long-to-int v14, v13

    .line 501
    int-to-byte v13, v14

    .line 502
    aput-byte v13, v8, v11

    .line 503
    .line 504
    const/16 v23, 0x8

    .line 505
    .line 506
    add-int/lit8 v10, v10, 0x8

    .line 507
    .line 508
    iput v10, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 509
    .line 510
    add-int/lit8 v12, v12, -0x1

    .line 511
    .line 512
    move v11, v9

    .line 513
    goto :goto_a

    .line 514
    :cond_15
    const/4 v11, 0x0

    .line 515
    invoke-static {v6, v11}, Lorg/brotli/dec/BitReader;->checkHealth(Lorg/brotli/dec/BitReader;Z)V

    .line 516
    .line 517
    .line 518
    goto :goto_c

    .line 519
    :cond_16
    :goto_b
    if-lez v12, :cond_18

    .line 520
    .line 521
    :try_start_0
    iget-object v9, v6, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 522
    .line 523
    invoke-virtual {v9, v8, v11, v12}, Ljava/io/InputStream;->read([BII)I

    .line 524
    .line 525
    .line 526
    move-result v9

    .line 527
    const/4 v10, -0x1

    .line 528
    if-eq v9, v10, :cond_17

    .line 529
    .line 530
    add-int/2addr v11, v9

    .line 531
    sub-int/2addr v12, v9

    .line 532
    goto :goto_b

    .line 533
    :cond_17
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 534
    .line 535
    const-string v1, "Unexpected end of input"

    .line 536
    .line 537
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 538
    .line 539
    .line 540
    throw v0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 541
    :catch_0
    move-exception v0

    .line 542
    new-instance v1, Lorg/brotli/dec/BrotliRuntimeException;

    .line 543
    .line 544
    const-string v2, "Failed to read input"

    .line 545
    .line 546
    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 547
    .line 548
    .line 549
    throw v1

    .line 550
    :cond_18
    :goto_c
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 551
    .line 552
    sub-int/2addr v8, v15

    .line 553
    iput v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 554
    .line 555
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 556
    .line 557
    add-int/2addr v8, v15

    .line 558
    iput v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 559
    .line 560
    iget v9, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 561
    .line 562
    if-ne v8, v9, :cond_19

    .line 563
    .line 564
    const/4 v8, 0x5

    .line 565
    iput v8, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 566
    .line 567
    iput v9, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 568
    .line 569
    const/4 v11, 0x0

    .line 570
    iput v11, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 571
    .line 572
    const/16 v12, 0xc

    .line 573
    .line 574
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 575
    .line 576
    goto/16 :goto_32

    .line 577
    .line 578
    :cond_19
    const/4 v11, 0x0

    .line 579
    iget v8, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 580
    .line 581
    const/16 v9, 0x40

    .line 582
    .line 583
    if-ne v8, v9, :cond_1a

    .line 584
    .line 585
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 586
    .line 587
    .line 588
    invoke-static {v6, v11}, Lorg/brotli/dec/BitReader;->checkHealth(Lorg/brotli/dec/BitReader;Z)V

    .line 589
    .line 590
    .line 591
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 592
    .line 593
    .line 594
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 595
    .line 596
    .line 597
    :cond_1a
    const/4 v8, 0x1

    .line 598
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 599
    .line 600
    goto/16 :goto_32

    .line 601
    .line 602
    :cond_1b
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 603
    .line 604
    const-string v1, "Unaligned copyBytes"

    .line 605
    .line 606
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 607
    .line 608
    .line 609
    throw v0

    .line 610
    :pswitch_5
    move-object/from16 v21, v10

    .line 611
    .line 612
    :goto_d
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 613
    .line 614
    if-lez v8, :cond_1c

    .line 615
    .line 616
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 617
    .line 618
    .line 619
    const/16 v8, 0x8

    .line 620
    .line 621
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 622
    .line 623
    .line 624
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 625
    .line 626
    const/4 v9, 0x1

    .line 627
    sub-int/2addr v8, v9

    .line 628
    iput v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 629
    .line 630
    goto :goto_d

    .line 631
    :cond_1c
    const/4 v9, 0x1

    .line 632
    iput v9, v0, Lorg/brotli/dec/State;->runningState:I

    .line 633
    .line 634
    goto/16 :goto_32

    .line 635
    .line 636
    :pswitch_6
    move-object/from16 v21, v10

    .line 637
    .line 638
    const/4 v12, 0x1

    .line 639
    const/16 v28, 0x4

    .line 640
    .line 641
    goto/16 :goto_15

    .line 642
    .line 643
    :pswitch_7
    move-object/from16 v21, v10

    .line 644
    .line 645
    const/4 v9, 0x1

    .line 646
    iget-object v10, v0, Lorg/brotli/dec/State;->blockLenTrees:[I

    .line 647
    .line 648
    iget-object v11, v0, Lorg/brotli/dec/State;->numBlockTypes:[I

    .line 649
    .line 650
    const/4 v12, 0x0

    .line 651
    :goto_e
    const/4 v13, 0x3

    .line 652
    if-ge v12, v13, :cond_20

    .line 653
    .line 654
    invoke-static {v6, v9}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 655
    .line 656
    .line 657
    move-result v14

    .line 658
    if-eqz v14, :cond_1e

    .line 659
    .line 660
    invoke-static {v6, v13}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 661
    .line 662
    .line 663
    move-result v14

    .line 664
    if-nez v14, :cond_1d

    .line 665
    .line 666
    const/16 v16, 0x1

    .line 667
    .line 668
    goto :goto_f

    .line 669
    :cond_1d
    invoke-static {v6, v14}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 670
    .line 671
    .line 672
    move-result v13

    .line 673
    shl-int v14, v9, v14

    .line 674
    .line 675
    add-int v16, v13, v14

    .line 676
    .line 677
    goto :goto_f

    .line 678
    :cond_1e
    const/16 v16, 0x0

    .line 679
    .line 680
    :goto_f
    add-int/lit8 v16, v16, 0x1

    .line 681
    .line 682
    aput v16, v11, v12

    .line 683
    .line 684
    const/high16 v13, 0x10000000

    .line 685
    .line 686
    aput v13, v7, v12

    .line 687
    .line 688
    aget v13, v11, v12

    .line 689
    .line 690
    if-le v13, v9, :cond_1f

    .line 691
    .line 692
    add-int/lit8 v13, v13, 0x2

    .line 693
    .line 694
    iget-object v9, v0, Lorg/brotli/dec/State;->blockTypeTrees:[I

    .line 695
    .line 696
    mul-int/lit16 v14, v12, 0x438

    .line 697
    .line 698
    invoke-static {v13, v9, v14, v6}, Lorg/brotli/dec/Utils;->readHuffmanCode(I[IILorg/brotli/dec/BitReader;)V

    .line 699
    .line 700
    .line 701
    const/16 v9, 0x1a

    .line 702
    .line 703
    invoke-static {v9, v10, v14, v6}, Lorg/brotli/dec/Utils;->readHuffmanCode(I[IILorg/brotli/dec/BitReader;)V

    .line 704
    .line 705
    .line 706
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 707
    .line 708
    .line 709
    invoke-static {v10, v14, v6}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 710
    .line 711
    .line 712
    move-result v9

    .line 713
    sget-object v13, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_N_BITS:[I

    .line 714
    .line 715
    aget v13, v13, v9

    .line 716
    .line 717
    sget-object v14, Lorg/brotli/dec/Utils;->BLOCK_LENGTH_OFFSET:[I

    .line 718
    .line 719
    aget v9, v14, v9

    .line 720
    .line 721
    invoke-static {v6, v13}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 722
    .line 723
    .line 724
    move-result v13

    .line 725
    add-int/2addr v13, v9

    .line 726
    aput v13, v7, v12

    .line 727
    .line 728
    :cond_1f
    add-int/lit8 v12, v12, 0x1

    .line 729
    .line 730
    const/4 v9, 0x1

    .line 731
    goto :goto_e

    .line 732
    :cond_20
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 733
    .line 734
    .line 735
    const/4 v9, 0x2

    .line 736
    invoke-static {v6, v9}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 737
    .line 738
    .line 739
    move-result v10

    .line 740
    iput v10, v0, Lorg/brotli/dec/State;->distancePostfixBits:I

    .line 741
    .line 742
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 743
    .line 744
    .line 745
    move-result v9

    .line 746
    iget v10, v0, Lorg/brotli/dec/State;->distancePostfixBits:I

    .line 747
    .line 748
    shl-int/2addr v9, v10

    .line 749
    add-int/lit8 v9, v9, 0x10

    .line 750
    .line 751
    iput v9, v0, Lorg/brotli/dec/State;->numDirectDistanceCodes:I

    .line 752
    .line 753
    const/16 v16, 0x1

    .line 754
    .line 755
    shl-int v12, v16, v10

    .line 756
    .line 757
    add-int/lit8 v12, v12, -0x1

    .line 758
    .line 759
    iput v12, v0, Lorg/brotli/dec/State;->distancePostfixMask:I

    .line 760
    .line 761
    const/16 v12, 0x30

    .line 762
    .line 763
    shl-int v10, v12, v10

    .line 764
    .line 765
    add-int/2addr v9, v10

    .line 766
    const/16 v19, 0x0

    .line 767
    .line 768
    aget v10, v11, v19

    .line 769
    .line 770
    new-array v10, v10, [B

    .line 771
    .line 772
    iput-object v10, v0, Lorg/brotli/dec/State;->contextModes:[B

    .line 773
    .line 774
    const/4 v10, 0x0

    .line 775
    :goto_10
    aget v12, v11, v19

    .line 776
    .line 777
    if-ge v10, v12, :cond_22

    .line 778
    .line 779
    add-int/lit8 v13, v10, 0x60

    .line 780
    .line 781
    invoke-static {v13, v12}, Ljava/lang/Math;->min(II)I

    .line 782
    .line 783
    .line 784
    move-result v12

    .line 785
    :goto_11
    if-ge v10, v12, :cond_21

    .line 786
    .line 787
    iget-object v13, v0, Lorg/brotli/dec/State;->contextModes:[B

    .line 788
    .line 789
    const/4 v14, 0x2

    .line 790
    invoke-static {v6, v14}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 791
    .line 792
    .line 793
    move-result v18

    .line 794
    const/16 v16, 0x1

    .line 795
    .line 796
    shl-int/lit8 v14, v18, 0x1

    .line 797
    .line 798
    int-to-byte v14, v14

    .line 799
    aput-byte v14, v13, v10

    .line 800
    .line 801
    add-int/lit8 v10, v10, 0x1

    .line 802
    .line 803
    goto :goto_11

    .line 804
    :cond_21
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 805
    .line 806
    .line 807
    const/16 v19, 0x0

    .line 808
    .line 809
    goto :goto_10

    .line 810
    :cond_22
    shl-int/lit8 v10, v12, 0x6

    .line 811
    .line 812
    new-array v12, v10, [B

    .line 813
    .line 814
    iput-object v12, v0, Lorg/brotli/dec/State;->contextMap:[B

    .line 815
    .line 816
    invoke-static {v10, v12, v6}, Lorg/brotli/dec/Utils;->decodeContextMap(I[BLorg/brotli/dec/BitReader;)I

    .line 817
    .line 818
    .line 819
    move-result v10

    .line 820
    const/4 v12, 0x1

    .line 821
    iput-boolean v12, v0, Lorg/brotli/dec/State;->trivialLiteralContext:Z

    .line 822
    .line 823
    const/4 v12, 0x0

    .line 824
    :goto_12
    const/4 v13, 0x0

    .line 825
    aget v14, v11, v13

    .line 826
    .line 827
    shl-int/lit8 v14, v14, 0x6

    .line 828
    .line 829
    if-ge v12, v14, :cond_24

    .line 830
    .line 831
    iget-object v14, v0, Lorg/brotli/dec/State;->contextMap:[B

    .line 832
    .line 833
    aget-byte v14, v14, v12

    .line 834
    .line 835
    const/16 v28, 0x4

    .line 836
    .line 837
    shr-int/lit8 v8, v12, 0x6

    .line 838
    .line 839
    if-eq v14, v8, :cond_23

    .line 840
    .line 841
    iput-boolean v13, v0, Lorg/brotli/dec/State;->trivialLiteralContext:Z

    .line 842
    .line 843
    :goto_13
    const/16 v26, 0x2

    .line 844
    .line 845
    goto :goto_14

    .line 846
    :cond_23
    add-int/lit8 v12, v12, 0x1

    .line 847
    .line 848
    const/4 v8, 0x4

    .line 849
    goto :goto_12

    .line 850
    :cond_24
    const/16 v28, 0x4

    .line 851
    .line 852
    goto :goto_13

    .line 853
    :goto_14
    aget v8, v11, v26

    .line 854
    .line 855
    shl-int/lit8 v8, v8, 0x2

    .line 856
    .line 857
    new-array v12, v8, [B

    .line 858
    .line 859
    iput-object v12, v0, Lorg/brotli/dec/State;->distContextMap:[B

    .line 860
    .line 861
    invoke-static {v8, v12, v6}, Lorg/brotli/dec/Utils;->decodeContextMap(I[BLorg/brotli/dec/BitReader;)I

    .line 862
    .line 863
    .line 864
    move-result v8

    .line 865
    const/16 v12, 0x100

    .line 866
    .line 867
    iput v12, v4, Lorg/brotli/dec/HuffmanTreeGroup;->alphabetSize:I

    .line 868
    .line 869
    mul-int/lit16 v12, v10, 0x438

    .line 870
    .line 871
    new-array v12, v12, [I

    .line 872
    .line 873
    iput-object v12, v4, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 874
    .line 875
    new-array v10, v10, [I

    .line 876
    .line 877
    iput-object v10, v4, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 878
    .line 879
    const/16 v16, 0x1

    .line 880
    .line 881
    aget v10, v11, v16

    .line 882
    .line 883
    const/16 v11, 0x2c0

    .line 884
    .line 885
    iput v11, v5, Lorg/brotli/dec/HuffmanTreeGroup;->alphabetSize:I

    .line 886
    .line 887
    mul-int/lit16 v11, v10, 0x438

    .line 888
    .line 889
    new-array v11, v11, [I

    .line 890
    .line 891
    iput-object v11, v5, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 892
    .line 893
    new-array v10, v10, [I

    .line 894
    .line 895
    iput-object v10, v5, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 896
    .line 897
    iput v9, v3, Lorg/brotli/dec/HuffmanTreeGroup;->alphabetSize:I

    .line 898
    .line 899
    mul-int/lit16 v9, v8, 0x438

    .line 900
    .line 901
    new-array v9, v9, [I

    .line 902
    .line 903
    iput-object v9, v3, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 904
    .line 905
    new-array v8, v8, [I

    .line 906
    .line 907
    iput-object v8, v3, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 908
    .line 909
    invoke-static {v4, v6}, Lorg/brotli/dec/HuffmanTreeGroup;->decode(Lorg/brotli/dec/HuffmanTreeGroup;Lorg/brotli/dec/BitReader;)V

    .line 910
    .line 911
    .line 912
    invoke-static {v5, v6}, Lorg/brotli/dec/HuffmanTreeGroup;->decode(Lorg/brotli/dec/HuffmanTreeGroup;Lorg/brotli/dec/BitReader;)V

    .line 913
    .line 914
    .line 915
    invoke-static {v3, v6}, Lorg/brotli/dec/HuffmanTreeGroup;->decode(Lorg/brotli/dec/HuffmanTreeGroup;Lorg/brotli/dec/BitReader;)V

    .line 916
    .line 917
    .line 918
    const/4 v11, 0x0

    .line 919
    iput v11, v0, Lorg/brotli/dec/State;->contextMapSlice:I

    .line 920
    .line 921
    iput v11, v0, Lorg/brotli/dec/State;->distContextMapSlice:I

    .line 922
    .line 923
    iget-object v8, v0, Lorg/brotli/dec/State;->contextModes:[B

    .line 924
    .line 925
    aget-byte v8, v8, v11

    .line 926
    .line 927
    sget-object v9, Lorg/brotli/dec/Utils;->LOOKUP_OFFSETS:[I

    .line 928
    .line 929
    aget v10, v9, v8

    .line 930
    .line 931
    iput v10, v0, Lorg/brotli/dec/State;->contextLookupOffset1:I

    .line 932
    .line 933
    const/4 v12, 0x1

    .line 934
    add-int/2addr v8, v12

    .line 935
    aget v8, v9, v8

    .line 936
    .line 937
    iput v8, v0, Lorg/brotli/dec/State;->contextLookupOffset2:I

    .line 938
    .line 939
    iget-object v8, v4, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 940
    .line 941
    check-cast v8, [I

    .line 942
    .line 943
    aget v8, v8, v11

    .line 944
    .line 945
    iput v8, v0, Lorg/brotli/dec/State;->literalTree:I

    .line 946
    .line 947
    iget-object v8, v5, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 948
    .line 949
    check-cast v8, [I

    .line 950
    .line 951
    aget v8, v8, v11

    .line 952
    .line 953
    iput v8, v0, Lorg/brotli/dec/State;->treeCommandOffset:I

    .line 954
    .line 955
    aput v12, v2, v28

    .line 956
    .line 957
    const/16 v26, 0x2

    .line 958
    .line 959
    aput v12, v2, v26

    .line 960
    .line 961
    aput v12, v2, v11

    .line 962
    .line 963
    const/16 v24, 0x5

    .line 964
    .line 965
    aput v11, v2, v24

    .line 966
    .line 967
    const/4 v8, 0x3

    .line 968
    aput v11, v2, v8

    .line 969
    .line 970
    aput v11, v2, v12

    .line 971
    .line 972
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 973
    .line 974
    :goto_15
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 975
    .line 976
    if-gtz v8, :cond_25

    .line 977
    .line 978
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 979
    .line 980
    goto/16 :goto_32

    .line 981
    .line 982
    :cond_25
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 983
    .line 984
    .line 985
    aget v8, v7, v12

    .line 986
    .line 987
    if-nez v8, :cond_26

    .line 988
    .line 989
    invoke-static {v0, v12}, Lorg/brotli/dec/Utils;->decodeBlockTypeAndLength(Lorg/brotli/dec/State;I)V

    .line 990
    .line 991
    .line 992
    iget-object v8, v5, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 993
    .line 994
    check-cast v8, [I

    .line 995
    .line 996
    const/16 v27, 0x3

    .line 997
    .line 998
    aget v9, v2, v27

    .line 999
    .line 1000
    aget v8, v8, v9

    .line 1001
    .line 1002
    iput v8, v0, Lorg/brotli/dec/State;->treeCommandOffset:I

    .line 1003
    .line 1004
    :cond_26
    aget v8, v7, v12

    .line 1005
    .line 1006
    sub-int/2addr v8, v12

    .line 1007
    aput v8, v7, v12

    .line 1008
    .line 1009
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 1010
    .line 1011
    .line 1012
    iget-object v8, v5, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1013
    .line 1014
    check-cast v8, [I

    .line 1015
    .line 1016
    iget v9, v0, Lorg/brotli/dec/State;->treeCommandOffset:I

    .line 1017
    .line 1018
    invoke-static {v8, v9, v6}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 1019
    .line 1020
    .line 1021
    move-result v8

    .line 1022
    ushr-int/lit8 v9, v8, 0x6

    .line 1023
    .line 1024
    const/4 v11, 0x0

    .line 1025
    iput v11, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1026
    .line 1027
    const/4 v14, 0x2

    .line 1028
    if-lt v9, v14, :cond_27

    .line 1029
    .line 1030
    add-int/lit8 v9, v9, -0x2

    .line 1031
    .line 1032
    const/4 v10, -0x1

    .line 1033
    iput v10, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1034
    .line 1035
    :cond_27
    sget-object v10, Lorg/brotli/dec/Utils;->INSERT_RANGE_LUT:[I

    .line 1036
    .line 1037
    aget v10, v10, v9

    .line 1038
    .line 1039
    ushr-int/lit8 v11, v8, 0x3

    .line 1040
    .line 1041
    and-int/lit8 v11, v11, 0x7

    .line 1042
    .line 1043
    add-int/2addr v10, v11

    .line 1044
    sget-object v11, Lorg/brotli/dec/Utils;->COPY_RANGE_LUT:[I

    .line 1045
    .line 1046
    aget v9, v11, v9

    .line 1047
    .line 1048
    and-int/lit8 v8, v8, 0x7

    .line 1049
    .line 1050
    add-int/2addr v9, v8

    .line 1051
    sget-object v8, Lorg/brotli/dec/Utils;->INSERT_LENGTH_OFFSET:[I

    .line 1052
    .line 1053
    aget v8, v8, v10

    .line 1054
    .line 1055
    sget-object v11, Lorg/brotli/dec/Utils;->INSERT_LENGTH_N_BITS:[I

    .line 1056
    .line 1057
    aget v10, v11, v10

    .line 1058
    .line 1059
    invoke-static {v6, v10}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1060
    .line 1061
    .line 1062
    move-result v10

    .line 1063
    add-int/2addr v10, v8

    .line 1064
    iput v10, v0, Lorg/brotli/dec/State;->insertLength:I

    .line 1065
    .line 1066
    sget-object v8, Lorg/brotli/dec/Utils;->COPY_LENGTH_OFFSET:[I

    .line 1067
    .line 1068
    aget v8, v8, v9

    .line 1069
    .line 1070
    sget-object v10, Lorg/brotli/dec/Utils;->COPY_LENGTH_N_BITS:[I

    .line 1071
    .line 1072
    aget v9, v10, v9

    .line 1073
    .line 1074
    invoke-static {v6, v9}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1075
    .line 1076
    .line 1077
    move-result v9

    .line 1078
    add-int/2addr v9, v8

    .line 1079
    iput v9, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 1080
    .line 1081
    const/4 v11, 0x0

    .line 1082
    iput v11, v0, Lorg/brotli/dec/State;->j:I

    .line 1083
    .line 1084
    const/4 v8, 0x6

    .line 1085
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1086
    .line 1087
    :goto_16
    iget-boolean v8, v0, Lorg/brotli/dec/State;->trivialLiteralContext:Z

    .line 1088
    .line 1089
    if-eqz v8, :cond_2b

    .line 1090
    .line 1091
    :goto_17
    iget v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1092
    .line 1093
    iget v9, v0, Lorg/brotli/dec/State;->insertLength:I

    .line 1094
    .line 1095
    if-ge v8, v9, :cond_29

    .line 1096
    .line 1097
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 1098
    .line 1099
    .line 1100
    aget v8, v7, v11

    .line 1101
    .line 1102
    if-nez v8, :cond_28

    .line 1103
    .line 1104
    invoke-static {v0}, Lorg/brotli/dec/Utils;->decodeLiteralBlockSwitch(Lorg/brotli/dec/State;)V

    .line 1105
    .line 1106
    .line 1107
    :cond_28
    aget v8, v7, v11

    .line 1108
    .line 1109
    const/16 v16, 0x1

    .line 1110
    .line 1111
    add-int/lit8 v8, v8, -0x1

    .line 1112
    .line 1113
    aput v8, v7, v11

    .line 1114
    .line 1115
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 1116
    .line 1117
    .line 1118
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1119
    .line 1120
    iget-object v9, v4, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1121
    .line 1122
    check-cast v9, [I

    .line 1123
    .line 1124
    iget v10, v0, Lorg/brotli/dec/State;->literalTree:I

    .line 1125
    .line 1126
    invoke-static {v9, v10, v6}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 1127
    .line 1128
    .line 1129
    move-result v9

    .line 1130
    int-to-byte v9, v9

    .line 1131
    aput-byte v9, v21, v8

    .line 1132
    .line 1133
    iget v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1134
    .line 1135
    add-int/lit8 v8, v8, 0x1

    .line 1136
    .line 1137
    iput v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1138
    .line 1139
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1140
    .line 1141
    add-int/lit8 v9, v8, 0x1

    .line 1142
    .line 1143
    iput v9, v0, Lorg/brotli/dec/State;->pos:I

    .line 1144
    .line 1145
    if-ne v8, v1, :cond_2a

    .line 1146
    .line 1147
    const/4 v8, 0x6

    .line 1148
    iput v8, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 1149
    .line 1150
    iget v8, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1151
    .line 1152
    iput v8, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 1153
    .line 1154
    const/4 v11, 0x0

    .line 1155
    iput v11, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 1156
    .line 1157
    const/16 v12, 0xc

    .line 1158
    .line 1159
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1160
    .line 1161
    :cond_29
    const/4 v10, 0x6

    .line 1162
    goto/16 :goto_19

    .line 1163
    .line 1164
    :cond_2a
    const/4 v11, 0x0

    .line 1165
    goto :goto_17

    .line 1166
    :cond_2b
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1167
    .line 1168
    add-int/lit8 v9, v8, -0x1

    .line 1169
    .line 1170
    and-int/2addr v9, v1

    .line 1171
    aget-byte v9, v21, v9

    .line 1172
    .line 1173
    and-int/lit16 v9, v9, 0xff

    .line 1174
    .line 1175
    const/16 v26, 0x2

    .line 1176
    .line 1177
    add-int/lit8 v8, v8, -0x2

    .line 1178
    .line 1179
    and-int/2addr v8, v1

    .line 1180
    aget-byte v8, v21, v8

    .line 1181
    .line 1182
    and-int/lit16 v8, v8, 0xff

    .line 1183
    .line 1184
    :goto_18
    iget v10, v0, Lorg/brotli/dec/State;->j:I

    .line 1185
    .line 1186
    iget v11, v0, Lorg/brotli/dec/State;->insertLength:I

    .line 1187
    .line 1188
    if-ge v10, v11, :cond_29

    .line 1189
    .line 1190
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 1191
    .line 1192
    .line 1193
    const/16 v19, 0x0

    .line 1194
    .line 1195
    aget v10, v7, v19

    .line 1196
    .line 1197
    if-nez v10, :cond_2c

    .line 1198
    .line 1199
    invoke-static {v0}, Lorg/brotli/dec/Utils;->decodeLiteralBlockSwitch(Lorg/brotli/dec/State;)V

    .line 1200
    .line 1201
    .line 1202
    :cond_2c
    iget-object v10, v0, Lorg/brotli/dec/State;->contextMap:[B

    .line 1203
    .line 1204
    iget v11, v0, Lorg/brotli/dec/State;->contextMapSlice:I

    .line 1205
    .line 1206
    iget v12, v0, Lorg/brotli/dec/State;->contextLookupOffset1:I

    .line 1207
    .line 1208
    add-int/2addr v12, v9

    .line 1209
    sget-object v13, Lorg/brotli/dec/Utils;->LOOKUP:[I

    .line 1210
    .line 1211
    aget v12, v13, v12

    .line 1212
    .line 1213
    iget v14, v0, Lorg/brotli/dec/State;->contextLookupOffset2:I

    .line 1214
    .line 1215
    add-int/2addr v14, v8

    .line 1216
    aget v8, v13, v14

    .line 1217
    .line 1218
    or-int/2addr v8, v12

    .line 1219
    add-int/2addr v11, v8

    .line 1220
    aget-byte v8, v10, v11

    .line 1221
    .line 1222
    and-int/lit16 v8, v8, 0xff

    .line 1223
    .line 1224
    const/16 v19, 0x0

    .line 1225
    .line 1226
    aget v10, v7, v19

    .line 1227
    .line 1228
    const/16 v16, 0x1

    .line 1229
    .line 1230
    add-int/lit8 v10, v10, -0x1

    .line 1231
    .line 1232
    aput v10, v7, v19

    .line 1233
    .line 1234
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 1235
    .line 1236
    .line 1237
    iget-object v10, v4, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1238
    .line 1239
    check-cast v10, [I

    .line 1240
    .line 1241
    iget-object v11, v4, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 1242
    .line 1243
    check-cast v11, [I

    .line 1244
    .line 1245
    aget v8, v11, v8

    .line 1246
    .line 1247
    invoke-static {v10, v8, v6}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 1248
    .line 1249
    .line 1250
    move-result v8

    .line 1251
    iget v10, v0, Lorg/brotli/dec/State;->pos:I

    .line 1252
    .line 1253
    int-to-byte v11, v8

    .line 1254
    aput-byte v11, v21, v10

    .line 1255
    .line 1256
    iget v11, v0, Lorg/brotli/dec/State;->j:I

    .line 1257
    .line 1258
    const/16 v16, 0x1

    .line 1259
    .line 1260
    add-int/lit8 v11, v11, 0x1

    .line 1261
    .line 1262
    iput v11, v0, Lorg/brotli/dec/State;->j:I

    .line 1263
    .line 1264
    add-int/lit8 v11, v10, 0x1

    .line 1265
    .line 1266
    iput v11, v0, Lorg/brotli/dec/State;->pos:I

    .line 1267
    .line 1268
    if-ne v10, v1, :cond_2d

    .line 1269
    .line 1270
    const/4 v10, 0x6

    .line 1271
    iput v10, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 1272
    .line 1273
    iget v8, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1274
    .line 1275
    iput v8, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 1276
    .line 1277
    const/4 v11, 0x0

    .line 1278
    iput v11, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 1279
    .line 1280
    const/16 v12, 0xc

    .line 1281
    .line 1282
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1283
    .line 1284
    goto :goto_19

    .line 1285
    :cond_2d
    move/from16 v29, v9

    .line 1286
    .line 1287
    move v9, v8

    .line 1288
    move/from16 v8, v29

    .line 1289
    .line 1290
    goto :goto_18

    .line 1291
    :goto_19
    iget v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1292
    .line 1293
    if-eq v8, v10, :cond_2e

    .line 1294
    .line 1295
    goto/16 :goto_32

    .line 1296
    .line 1297
    :cond_2e
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1298
    .line 1299
    iget v9, v0, Lorg/brotli/dec/State;->insertLength:I

    .line 1300
    .line 1301
    sub-int/2addr v8, v9

    .line 1302
    iput v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1303
    .line 1304
    if-gtz v8, :cond_2f

    .line 1305
    .line 1306
    const/4 v8, 0x3

    .line 1307
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1308
    .line 1309
    goto/16 :goto_32

    .line 1310
    .line 1311
    :cond_2f
    iget v8, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1312
    .line 1313
    if-gez v8, :cond_32

    .line 1314
    .line 1315
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 1316
    .line 1317
    .line 1318
    const/4 v14, 0x2

    .line 1319
    aget v8, v7, v14

    .line 1320
    .line 1321
    if-nez v8, :cond_30

    .line 1322
    .line 1323
    invoke-static {v0, v14}, Lorg/brotli/dec/Utils;->decodeBlockTypeAndLength(Lorg/brotli/dec/State;I)V

    .line 1324
    .line 1325
    .line 1326
    const/16 v24, 0x5

    .line 1327
    .line 1328
    aget v8, v2, v24

    .line 1329
    .line 1330
    shl-int/2addr v8, v14

    .line 1331
    iput v8, v0, Lorg/brotli/dec/State;->distContextMapSlice:I

    .line 1332
    .line 1333
    :cond_30
    aget v8, v7, v14

    .line 1334
    .line 1335
    const/16 v16, 0x1

    .line 1336
    .line 1337
    add-int/lit8 v8, v8, -0x1

    .line 1338
    .line 1339
    aput v8, v7, v14

    .line 1340
    .line 1341
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 1342
    .line 1343
    .line 1344
    iget-object v8, v3, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1345
    .line 1346
    check-cast v8, [I

    .line 1347
    .line 1348
    iget-object v9, v3, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 1349
    .line 1350
    check-cast v9, [I

    .line 1351
    .line 1352
    iget-object v10, v0, Lorg/brotli/dec/State;->distContextMap:[B

    .line 1353
    .line 1354
    iget v11, v0, Lorg/brotli/dec/State;->distContextMapSlice:I

    .line 1355
    .line 1356
    iget v12, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 1357
    .line 1358
    const/4 v13, 0x4

    .line 1359
    if-le v12, v13, :cond_31

    .line 1360
    .line 1361
    const/4 v12, 0x3

    .line 1362
    goto :goto_1a

    .line 1363
    :cond_31
    add-int/lit8 v12, v12, -0x2

    .line 1364
    .line 1365
    :goto_1a
    add-int/2addr v11, v12

    .line 1366
    aget-byte v10, v10, v11

    .line 1367
    .line 1368
    and-int/lit16 v10, v10, 0xff

    .line 1369
    .line 1370
    aget v9, v9, v10

    .line 1371
    .line 1372
    invoke-static {v8, v9, v6}, Lorg/brotli/dec/Utils;->readSymbol([IILorg/brotli/dec/BitReader;)I

    .line 1373
    .line 1374
    .line 1375
    move-result v8

    .line 1376
    iput v8, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1377
    .line 1378
    iget v9, v0, Lorg/brotli/dec/State;->numDirectDistanceCodes:I

    .line 1379
    .line 1380
    if-lt v8, v9, :cond_32

    .line 1381
    .line 1382
    sub-int/2addr v8, v9

    .line 1383
    iget v10, v0, Lorg/brotli/dec/State;->distancePostfixMask:I

    .line 1384
    .line 1385
    and-int/2addr v10, v8

    .line 1386
    iget v11, v0, Lorg/brotli/dec/State;->distancePostfixBits:I

    .line 1387
    .line 1388
    ushr-int/2addr v8, v11

    .line 1389
    iput v8, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1390
    .line 1391
    ushr-int/lit8 v11, v8, 0x1

    .line 1392
    .line 1393
    const/16 v16, 0x1

    .line 1394
    .line 1395
    add-int/lit8 v11, v11, 0x1

    .line 1396
    .line 1397
    and-int/lit8 v8, v8, 0x1

    .line 1398
    .line 1399
    const/16 v26, 0x2

    .line 1400
    .line 1401
    add-int/lit8 v8, v8, 0x2

    .line 1402
    .line 1403
    shl-int/2addr v8, v11

    .line 1404
    const/16 v28, 0x4

    .line 1405
    .line 1406
    add-int/lit8 v8, v8, -0x4

    .line 1407
    .line 1408
    add-int/2addr v9, v10

    .line 1409
    invoke-static {v6, v11}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1410
    .line 1411
    .line 1412
    move-result v10

    .line 1413
    add-int/2addr v10, v8

    .line 1414
    iget v8, v0, Lorg/brotli/dec/State;->distancePostfixBits:I

    .line 1415
    .line 1416
    shl-int v8, v10, v8

    .line 1417
    .line 1418
    add-int/2addr v9, v8

    .line 1419
    iput v9, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1420
    .line 1421
    :cond_32
    iget v8, v0, Lorg/brotli/dec/State;->distanceCode:I

    .line 1422
    .line 1423
    iget-object v9, v0, Lorg/brotli/dec/State;->distRb:[I

    .line 1424
    .line 1425
    iget v10, v0, Lorg/brotli/dec/State;->distRbIdx:I

    .line 1426
    .line 1427
    const/16 v11, 0x10

    .line 1428
    .line 1429
    if-ge v8, v11, :cond_33

    .line 1430
    .line 1431
    sget-object v11, Lorg/brotli/dec/Utils;->DISTANCE_SHORT_CODE_INDEX_OFFSET:[I

    .line 1432
    .line 1433
    aget v11, v11, v8

    .line 1434
    .line 1435
    add-int/2addr v11, v10

    .line 1436
    const/16 v27, 0x3

    .line 1437
    .line 1438
    and-int/lit8 v11, v11, 0x3

    .line 1439
    .line 1440
    aget v11, v9, v11

    .line 1441
    .line 1442
    sget-object v12, Lorg/brotli/dec/Utils;->DISTANCE_SHORT_CODE_VALUE_OFFSET:[I

    .line 1443
    .line 1444
    aget v12, v12, v8

    .line 1445
    .line 1446
    add-int/2addr v11, v12

    .line 1447
    goto :goto_1b

    .line 1448
    :cond_33
    add-int/lit8 v11, v8, -0xf

    .line 1449
    .line 1450
    :goto_1b
    iput v11, v0, Lorg/brotli/dec/State;->distance:I

    .line 1451
    .line 1452
    if-ltz v11, :cond_3b

    .line 1453
    .line 1454
    iget v12, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 1455
    .line 1456
    iget v13, v0, Lorg/brotli/dec/State;->maxBackwardDistance:I

    .line 1457
    .line 1458
    if-eq v12, v13, :cond_34

    .line 1459
    .line 1460
    iget v12, v0, Lorg/brotli/dec/State;->pos:I

    .line 1461
    .line 1462
    if-ge v12, v13, :cond_34

    .line 1463
    .line 1464
    iput v12, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 1465
    .line 1466
    goto :goto_1c

    .line 1467
    :cond_34
    iput v13, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 1468
    .line 1469
    :goto_1c
    iget v12, v0, Lorg/brotli/dec/State;->pos:I

    .line 1470
    .line 1471
    iput v12, v0, Lorg/brotli/dec/State;->copyDst:I

    .line 1472
    .line 1473
    iget v12, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 1474
    .line 1475
    if-le v11, v12, :cond_35

    .line 1476
    .line 1477
    const/16 v12, 0x9

    .line 1478
    .line 1479
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1480
    .line 1481
    goto/16 :goto_32

    .line 1482
    .line 1483
    :cond_35
    if-lez v8, :cond_36

    .line 1484
    .line 1485
    and-int/lit8 v8, v10, 0x3

    .line 1486
    .line 1487
    aput v11, v9, v8

    .line 1488
    .line 1489
    add-int/lit8 v10, v10, 0x1

    .line 1490
    .line 1491
    iput v10, v0, Lorg/brotli/dec/State;->distRbIdx:I

    .line 1492
    .line 1493
    :cond_36
    iget v8, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 1494
    .line 1495
    iget v9, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1496
    .line 1497
    if-gt v8, v9, :cond_3a

    .line 1498
    .line 1499
    const/4 v11, 0x0

    .line 1500
    iput v11, v0, Lorg/brotli/dec/State;->j:I

    .line 1501
    .line 1502
    const/4 v8, 0x7

    .line 1503
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1504
    .line 1505
    :goto_1d
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1506
    .line 1507
    iget v9, v0, Lorg/brotli/dec/State;->distance:I

    .line 1508
    .line 1509
    sub-int v9, v8, v9

    .line 1510
    .line 1511
    and-int/2addr v9, v1

    .line 1512
    iget v10, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 1513
    .line 1514
    iget v11, v0, Lorg/brotli/dec/State;->j:I

    .line 1515
    .line 1516
    sub-int/2addr v10, v11

    .line 1517
    add-int v11, v9, v10

    .line 1518
    .line 1519
    if-ge v11, v1, :cond_39

    .line 1520
    .line 1521
    add-int v11, v8, v10

    .line 1522
    .line 1523
    if-ge v11, v1, :cond_39

    .line 1524
    .line 1525
    const/4 v14, 0x0

    .line 1526
    :goto_1e
    if-ge v14, v10, :cond_37

    .line 1527
    .line 1528
    add-int/lit8 v11, v8, 0x1

    .line 1529
    .line 1530
    add-int/lit8 v12, v9, 0x1

    .line 1531
    .line 1532
    aget-byte v9, v21, v9

    .line 1533
    .line 1534
    aput-byte v9, v21, v8

    .line 1535
    .line 1536
    add-int/lit8 v14, v14, 0x1

    .line 1537
    .line 1538
    move v8, v11

    .line 1539
    move v9, v12

    .line 1540
    goto :goto_1e

    .line 1541
    :cond_37
    iget v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1542
    .line 1543
    add-int/2addr v8, v10

    .line 1544
    iput v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1545
    .line 1546
    iget v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1547
    .line 1548
    sub-int/2addr v8, v10

    .line 1549
    iput v8, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1550
    .line 1551
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1552
    .line 1553
    add-int/2addr v8, v10

    .line 1554
    iput v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1555
    .line 1556
    :cond_38
    const/4 v8, 0x7

    .line 1557
    goto :goto_1f

    .line 1558
    :cond_39
    iget v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1559
    .line 1560
    iget v9, v0, Lorg/brotli/dec/State;->copyLength:I

    .line 1561
    .line 1562
    if-ge v8, v9, :cond_38

    .line 1563
    .line 1564
    iget v9, v0, Lorg/brotli/dec/State;->pos:I

    .line 1565
    .line 1566
    iget v10, v0, Lorg/brotli/dec/State;->distance:I

    .line 1567
    .line 1568
    sub-int v10, v9, v10

    .line 1569
    .line 1570
    and-int/2addr v10, v1

    .line 1571
    aget-byte v10, v21, v10

    .line 1572
    .line 1573
    aput-byte v10, v21, v9

    .line 1574
    .line 1575
    iget v10, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1576
    .line 1577
    const/16 v16, 0x1

    .line 1578
    .line 1579
    add-int/lit8 v10, v10, -0x1

    .line 1580
    .line 1581
    iput v10, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1582
    .line 1583
    add-int/lit8 v8, v8, 0x1

    .line 1584
    .line 1585
    iput v8, v0, Lorg/brotli/dec/State;->j:I

    .line 1586
    .line 1587
    add-int/lit8 v8, v9, 0x1

    .line 1588
    .line 1589
    iput v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 1590
    .line 1591
    if-ne v9, v1, :cond_39

    .line 1592
    .line 1593
    const/4 v8, 0x7

    .line 1594
    iput v8, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 1595
    .line 1596
    iget v9, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1597
    .line 1598
    iput v9, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 1599
    .line 1600
    const/4 v11, 0x0

    .line 1601
    iput v11, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 1602
    .line 1603
    const/16 v12, 0xc

    .line 1604
    .line 1605
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1606
    .line 1607
    :goto_1f
    iget v9, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1608
    .line 1609
    if-ne v9, v8, :cond_5c

    .line 1610
    .line 1611
    const/4 v8, 0x3

    .line 1612
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1613
    .line 1614
    goto/16 :goto_32

    .line 1615
    .line 1616
    :cond_3a
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1617
    .line 1618
    invoke-direct {v0, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1619
    .line 1620
    .line 1621
    throw v0

    .line 1622
    :cond_3b
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1623
    .line 1624
    const-string v1, "Negative distance"

    .line 1625
    .line 1626
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1627
    .line 1628
    .line 1629
    throw v0

    .line 1630
    :pswitch_8
    iget v1, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1631
    .line 1632
    if-ltz v1, :cond_57

    .line 1633
    .line 1634
    iget-boolean v1, v0, Lorg/brotli/dec/State;->inputEnd:Z

    .line 1635
    .line 1636
    if-eqz v1, :cond_3c

    .line 1637
    .line 1638
    const/16 v12, 0xa

    .line 1639
    .line 1640
    iput v12, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 1641
    .line 1642
    iget v1, v0, Lorg/brotli/dec/State;->pos:I

    .line 1643
    .line 1644
    iput v1, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 1645
    .line 1646
    const/4 v11, 0x0

    .line 1647
    iput v11, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 1648
    .line 1649
    const/16 v12, 0xc

    .line 1650
    .line 1651
    iput v12, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1652
    .line 1653
    goto/16 :goto_30

    .line 1654
    .line 1655
    :cond_3c
    const/4 v1, 0x0

    .line 1656
    iput-object v1, v4, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1657
    .line 1658
    iput-object v1, v4, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 1659
    .line 1660
    iput-object v1, v5, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1661
    .line 1662
    iput-object v1, v5, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 1663
    .line 1664
    iput-object v1, v3, Lorg/brotli/dec/HuffmanTreeGroup;->codes:Ljava/lang/Object;

    .line 1665
    .line 1666
    iput-object v1, v3, Lorg/brotli/dec/HuffmanTreeGroup;->trees:Ljava/lang/Object;

    .line 1667
    .line 1668
    invoke-static {v6}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 1669
    .line 1670
    .line 1671
    const/4 v8, 0x1

    .line 1672
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1673
    .line 1674
    .line 1675
    move-result v1

    .line 1676
    if-ne v1, v8, :cond_3d

    .line 1677
    .line 1678
    const/4 v1, 0x1

    .line 1679
    goto :goto_20

    .line 1680
    :cond_3d
    const/4 v1, 0x0

    .line 1681
    :goto_20
    iput-boolean v1, v0, Lorg/brotli/dec/State;->inputEnd:Z

    .line 1682
    .line 1683
    const/4 v11, 0x0

    .line 1684
    iput v11, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1685
    .line 1686
    iput-boolean v11, v0, Lorg/brotli/dec/State;->isUncompressed:Z

    .line 1687
    .line 1688
    iput-boolean v11, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1689
    .line 1690
    if-eqz v1, :cond_3e

    .line 1691
    .line 1692
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1693
    .line 1694
    .line 1695
    move-result v1

    .line 1696
    if-eqz v1, :cond_3e

    .line 1697
    .line 1698
    :goto_21
    const/4 v10, 0x4

    .line 1699
    goto/16 :goto_28

    .line 1700
    .line 1701
    :cond_3e
    const/4 v14, 0x2

    .line 1702
    invoke-static {v6, v14}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1703
    .line 1704
    .line 1705
    move-result v1

    .line 1706
    const/16 v28, 0x4

    .line 1707
    .line 1708
    add-int/lit8 v1, v1, 0x4

    .line 1709
    .line 1710
    const-string v9, "Exuberant nibble"

    .line 1711
    .line 1712
    const/4 v10, 0x7

    .line 1713
    if-ne v1, v10, :cond_44

    .line 1714
    .line 1715
    iput-boolean v8, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1716
    .line 1717
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1718
    .line 1719
    .line 1720
    move-result v1

    .line 1721
    if-nez v1, :cond_43

    .line 1722
    .line 1723
    invoke-static {v6, v14}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1724
    .line 1725
    .line 1726
    move-result v1

    .line 1727
    if-nez v1, :cond_3f

    .line 1728
    .line 1729
    goto :goto_21

    .line 1730
    :cond_3f
    const/4 v8, 0x0

    .line 1731
    :goto_22
    if-ge v8, v1, :cond_42

    .line 1732
    .line 1733
    const/16 v10, 0x8

    .line 1734
    .line 1735
    invoke-static {v6, v10}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1736
    .line 1737
    .line 1738
    move-result v11

    .line 1739
    if-nez v11, :cond_41

    .line 1740
    .line 1741
    add-int/lit8 v12, v8, 0x1

    .line 1742
    .line 1743
    if-ne v12, v1, :cond_41

    .line 1744
    .line 1745
    const/4 v12, 0x1

    .line 1746
    if-gt v1, v12, :cond_40

    .line 1747
    .line 1748
    goto :goto_23

    .line 1749
    :cond_40
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1750
    .line 1751
    invoke-direct {v0, v9}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1752
    .line 1753
    .line 1754
    throw v0

    .line 1755
    :cond_41
    :goto_23
    iget v12, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1756
    .line 1757
    mul-int/lit8 v14, v8, 0x8

    .line 1758
    .line 1759
    shl-int/2addr v11, v14

    .line 1760
    or-int/2addr v11, v12

    .line 1761
    iput v11, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1762
    .line 1763
    add-int/lit8 v8, v8, 0x1

    .line 1764
    .line 1765
    goto :goto_22

    .line 1766
    :cond_42
    const/4 v10, 0x4

    .line 1767
    goto :goto_26

    .line 1768
    :cond_43
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1769
    .line 1770
    const-string v1, "Corrupted reserved bit"

    .line 1771
    .line 1772
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1773
    .line 1774
    .line 1775
    throw v0

    .line 1776
    :cond_44
    const/4 v8, 0x0

    .line 1777
    :goto_24
    if-ge v8, v1, :cond_42

    .line 1778
    .line 1779
    const/4 v10, 0x4

    .line 1780
    invoke-static {v6, v10}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1781
    .line 1782
    .line 1783
    move-result v11

    .line 1784
    if-nez v11, :cond_46

    .line 1785
    .line 1786
    add-int/lit8 v12, v8, 0x1

    .line 1787
    .line 1788
    if-ne v12, v1, :cond_46

    .line 1789
    .line 1790
    if-gt v1, v10, :cond_45

    .line 1791
    .line 1792
    goto :goto_25

    .line 1793
    :cond_45
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1794
    .line 1795
    invoke-direct {v0, v9}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1796
    .line 1797
    .line 1798
    throw v0

    .line 1799
    :cond_46
    :goto_25
    iget v12, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1800
    .line 1801
    mul-int/lit8 v14, v8, 0x4

    .line 1802
    .line 1803
    shl-int/2addr v11, v14

    .line 1804
    or-int/2addr v11, v12

    .line 1805
    iput v11, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1806
    .line 1807
    add-int/lit8 v8, v8, 0x1

    .line 1808
    .line 1809
    goto :goto_24

    .line 1810
    :goto_26
    iget v1, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1811
    .line 1812
    const/4 v8, 0x1

    .line 1813
    add-int/2addr v1, v8

    .line 1814
    iput v1, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1815
    .line 1816
    iget-boolean v1, v0, Lorg/brotli/dec/State;->inputEnd:Z

    .line 1817
    .line 1818
    if-nez v1, :cond_48

    .line 1819
    .line 1820
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1821
    .line 1822
    .line 1823
    move-result v1

    .line 1824
    if-ne v1, v8, :cond_47

    .line 1825
    .line 1826
    const/4 v1, 0x1

    .line 1827
    goto :goto_27

    .line 1828
    :cond_47
    const/4 v1, 0x0

    .line 1829
    :goto_27
    iput-boolean v1, v0, Lorg/brotli/dec/State;->isUncompressed:Z

    .line 1830
    .line 1831
    :cond_48
    :goto_28
    iget v1, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1832
    .line 1833
    if-nez v1, :cond_49

    .line 1834
    .line 1835
    iget-boolean v1, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1836
    .line 1837
    if-nez v1, :cond_49

    .line 1838
    .line 1839
    goto/16 :goto_30

    .line 1840
    .line 1841
    :cond_49
    iget-boolean v1, v0, Lorg/brotli/dec/State;->isUncompressed:Z

    .line 1842
    .line 1843
    if-nez v1, :cond_4b

    .line 1844
    .line 1845
    iget-boolean v1, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1846
    .line 1847
    if-eqz v1, :cond_4a

    .line 1848
    .line 1849
    goto :goto_29

    .line 1850
    :cond_4a
    const/4 v14, 0x2

    .line 1851
    iput v14, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1852
    .line 1853
    goto :goto_2c

    .line 1854
    :cond_4b
    :goto_29
    iget v1, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 1855
    .line 1856
    const/16 v18, 0x40

    .line 1857
    .line 1858
    rsub-int/lit8 v14, v1, 0x40

    .line 1859
    .line 1860
    const/16 v17, 0x7

    .line 1861
    .line 1862
    and-int/lit8 v1, v14, 0x7

    .line 1863
    .line 1864
    if-eqz v1, :cond_4d

    .line 1865
    .line 1866
    invoke-static {v6, v1}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 1867
    .line 1868
    .line 1869
    move-result v1

    .line 1870
    if-nez v1, :cond_4c

    .line 1871
    .line 1872
    goto :goto_2a

    .line 1873
    :cond_4c
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1874
    .line 1875
    invoke-direct {v0, v13}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 1876
    .line 1877
    .line 1878
    throw v0

    .line 1879
    :cond_4d
    :goto_2a
    iget-boolean v1, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1880
    .line 1881
    if-eqz v1, :cond_4e

    .line 1882
    .line 1883
    const/4 v8, 0x4

    .line 1884
    goto :goto_2b

    .line 1885
    :cond_4e
    const/4 v8, 0x5

    .line 1886
    :goto_2b
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 1887
    .line 1888
    :goto_2c
    iget-boolean v1, v0, Lorg/brotli/dec/State;->isMetadata:Z

    .line 1889
    .line 1890
    if-eqz v1, :cond_4f

    .line 1891
    .line 1892
    goto :goto_30

    .line 1893
    :cond_4f
    iget-wide v8, v0, Lorg/brotli/dec/State;->expectedTotalSize:J

    .line 1894
    .line 1895
    iget v1, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 1896
    .line 1897
    int-to-long v10, v1

    .line 1898
    add-long/2addr v8, v10

    .line 1899
    iput-wide v8, v0, Lorg/brotli/dec/State;->expectedTotalSize:J

    .line 1900
    .line 1901
    iget v1, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1902
    .line 1903
    iget v10, v0, Lorg/brotli/dec/State;->maxRingBufferSize:I

    .line 1904
    .line 1905
    if-ge v1, v10, :cond_56

    .line 1906
    .line 1907
    int-to-long v11, v10

    .line 1908
    cmp-long v1, v11, v8

    .line 1909
    .line 1910
    if-lez v1, :cond_51

    .line 1911
    .line 1912
    long-to-int v1, v8

    .line 1913
    iget-object v8, v0, Lorg/brotli/dec/State;->customDictionary:[B

    .line 1914
    .line 1915
    array-length v8, v8

    .line 1916
    add-int/2addr v1, v8

    .line 1917
    :goto_2d
    shr-int/lit8 v8, v10, 0x1

    .line 1918
    .line 1919
    if-le v8, v1, :cond_50

    .line 1920
    .line 1921
    move v10, v8

    .line 1922
    goto :goto_2d

    .line 1923
    :cond_50
    iget-boolean v1, v0, Lorg/brotli/dec/State;->inputEnd:Z

    .line 1924
    .line 1925
    if-nez v1, :cond_51

    .line 1926
    .line 1927
    const/16 v1, 0x4000

    .line 1928
    .line 1929
    if-ge v10, v1, :cond_51

    .line 1930
    .line 1931
    iget v8, v0, Lorg/brotli/dec/State;->maxRingBufferSize:I

    .line 1932
    .line 1933
    if-lt v8, v1, :cond_51

    .line 1934
    .line 1935
    const/16 v10, 0x4000

    .line 1936
    .line 1937
    :cond_51
    iget v1, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1938
    .line 1939
    if-gt v10, v1, :cond_52

    .line 1940
    .line 1941
    goto :goto_30

    .line 1942
    :cond_52
    add-int/lit8 v8, v10, 0x25

    .line 1943
    .line 1944
    new-array v8, v8, [B

    .line 1945
    .line 1946
    iget-object v9, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 1947
    .line 1948
    if-eqz v9, :cond_53

    .line 1949
    .line 1950
    const/4 v11, 0x0

    .line 1951
    invoke-static {v9, v11, v8, v11, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1952
    .line 1953
    .line 1954
    goto :goto_2f

    .line 1955
    :cond_53
    const/4 v11, 0x0

    .line 1956
    iget-object v1, v0, Lorg/brotli/dec/State;->customDictionary:[B

    .line 1957
    .line 1958
    array-length v9, v1

    .line 1959
    if-eqz v9, :cond_55

    .line 1960
    .line 1961
    array-length v9, v1

    .line 1962
    iget v12, v0, Lorg/brotli/dec/State;->maxBackwardDistance:I

    .line 1963
    .line 1964
    if-le v9, v12, :cond_54

    .line 1965
    .line 1966
    sub-int v19, v9, v12

    .line 1967
    .line 1968
    move v9, v12

    .line 1969
    move/from16 v12, v19

    .line 1970
    .line 1971
    goto :goto_2e

    .line 1972
    :cond_54
    const/4 v12, 0x0

    .line 1973
    :goto_2e
    invoke-static {v1, v12, v8, v11, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1974
    .line 1975
    .line 1976
    iput v9, v0, Lorg/brotli/dec/State;->pos:I

    .line 1977
    .line 1978
    iput v9, v0, Lorg/brotli/dec/State;->bytesToIgnore:I

    .line 1979
    .line 1980
    :cond_55
    :goto_2f
    iput-object v8, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 1981
    .line 1982
    iput v10, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1983
    .line 1984
    :cond_56
    :goto_30
    iget v1, v0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 1985
    .line 1986
    const/16 v16, 0x1

    .line 1987
    .line 1988
    add-int/lit8 v1, v1, -0x1

    .line 1989
    .line 1990
    iget-object v10, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 1991
    .line 1992
    :goto_31
    const/16 v8, 0xb

    .line 1993
    .line 1994
    const/4 v9, 0x1

    .line 1995
    goto/16 :goto_0

    .line 1996
    .line 1997
    :cond_57
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 1998
    .line 1999
    invoke-direct {v0, v12}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 2000
    .line 2001
    .line 2002
    throw v0

    .line 2003
    :cond_58
    move-object/from16 v21, v10

    .line 2004
    .line 2005
    iget v8, v0, Lorg/brotli/dec/State;->bytesToIgnore:I

    .line 2006
    .line 2007
    if-eqz v8, :cond_59

    .line 2008
    .line 2009
    iget v9, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2010
    .line 2011
    add-int/2addr v9, v8

    .line 2012
    iput v9, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2013
    .line 2014
    const/4 v11, 0x0

    .line 2015
    iput v11, v0, Lorg/brotli/dec/State;->bytesToIgnore:I

    .line 2016
    .line 2017
    :cond_59
    iget v8, v0, Lorg/brotli/dec/State;->outputLength:I

    .line 2018
    .line 2019
    iget v9, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 2020
    .line 2021
    sub-int/2addr v8, v9

    .line 2022
    iget v9, v0, Lorg/brotli/dec/State;->bytesToWrite:I

    .line 2023
    .line 2024
    iget v10, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2025
    .line 2026
    sub-int/2addr v9, v10

    .line 2027
    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    .line 2028
    .line 2029
    .line 2030
    move-result v8

    .line 2031
    if-eqz v8, :cond_5a

    .line 2032
    .line 2033
    iget-object v9, v0, Lorg/brotli/dec/State;->ringBuffer:[B

    .line 2034
    .line 2035
    iget v10, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2036
    .line 2037
    iget-object v11, v0, Lorg/brotli/dec/State;->output:[B

    .line 2038
    .line 2039
    iget v12, v0, Lorg/brotli/dec/State;->outputOffset:I

    .line 2040
    .line 2041
    iget v13, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 2042
    .line 2043
    add-int/2addr v12, v13

    .line 2044
    invoke-static {v9, v10, v11, v12, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2045
    .line 2046
    .line 2047
    iget v9, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 2048
    .line 2049
    add-int/2addr v9, v8

    .line 2050
    iput v9, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 2051
    .line 2052
    iget v9, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2053
    .line 2054
    add-int/2addr v9, v8

    .line 2055
    iput v9, v0, Lorg/brotli/dec/State;->bytesWritten:I

    .line 2056
    .line 2057
    :cond_5a
    iget v8, v0, Lorg/brotli/dec/State;->outputUsed:I

    .line 2058
    .line 2059
    iget v9, v0, Lorg/brotli/dec/State;->outputLength:I

    .line 2060
    .line 2061
    if-ge v8, v9, :cond_61

    .line 2062
    .line 2063
    iget v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 2064
    .line 2065
    iget v9, v0, Lorg/brotli/dec/State;->maxBackwardDistance:I

    .line 2066
    .line 2067
    if-lt v8, v9, :cond_5b

    .line 2068
    .line 2069
    iput v9, v0, Lorg/brotli/dec/State;->maxDistance:I

    .line 2070
    .line 2071
    :cond_5b
    and-int/2addr v8, v1

    .line 2072
    iput v8, v0, Lorg/brotli/dec/State;->pos:I

    .line 2073
    .line 2074
    iget v8, v0, Lorg/brotli/dec/State;->nextRunningState:I

    .line 2075
    .line 2076
    iput v8, v0, Lorg/brotli/dec/State;->runningState:I

    .line 2077
    .line 2078
    :cond_5c
    :goto_32
    move-object/from16 v10, v21

    .line 2079
    .line 2080
    goto :goto_31

    .line 2081
    :cond_5d
    const/16 v1, 0xa

    .line 2082
    .line 2083
    if-ne v11, v1, :cond_61

    .line 2084
    .line 2085
    iget v0, v0, Lorg/brotli/dec/State;->metaBlockLength:I

    .line 2086
    .line 2087
    if-ltz v0, :cond_60

    .line 2088
    .line 2089
    iget v0, v6, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 2090
    .line 2091
    const/16 v18, 0x40

    .line 2092
    .line 2093
    rsub-int/lit8 v14, v0, 0x40

    .line 2094
    .line 2095
    const/16 v17, 0x7

    .line 2096
    .line 2097
    and-int/lit8 v0, v14, 0x7

    .line 2098
    .line 2099
    if-eqz v0, :cond_5e

    .line 2100
    .line 2101
    invoke-static {v6, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 2102
    .line 2103
    .line 2104
    move-result v0

    .line 2105
    if-nez v0, :cond_5f

    .line 2106
    .line 2107
    :cond_5e
    const/4 v8, 0x1

    .line 2108
    goto :goto_33

    .line 2109
    :cond_5f
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 2110
    .line 2111
    invoke-direct {v0, v13}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 2112
    .line 2113
    .line 2114
    throw v0

    .line 2115
    :goto_33
    invoke-static {v6, v8}, Lorg/brotli/dec/BitReader;->checkHealth(Lorg/brotli/dec/BitReader;Z)V

    .line 2116
    .line 2117
    .line 2118
    return-void

    .line 2119
    :cond_60
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 2120
    .line 2121
    invoke-direct {v0, v12}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 2122
    .line 2123
    .line 2124
    throw v0

    .line 2125
    :cond_61
    return-void

    .line 2126
    :cond_62
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 2127
    .line 2128
    const-string v1, "Can\'t decompress after close"

    .line 2129
    .line 2130
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 2131
    .line 2132
    .line 2133
    throw v0

    .line 2134
    :cond_63
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 2135
    .line 2136
    const-string v1, "Can\'t decompress until initialized"

    .line 2137
    .line 2138
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 2139
    .line 2140
    .line 2141
    throw v0

    .line 2142
    nop

    :pswitch_data_0
    .packed-switch 0x1
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

.method public static readHuffmanCode(I[IILorg/brotli/dec/BitReader;)V
    .locals 18

    .line 1
    move/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p3

    .line 4
    .line 5
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 6
    .line 7
    .line 8
    new-array v2, v0, [I

    .line 9
    .line 10
    const/4 v3, 0x2

    .line 11
    invoke-static {v1, v3}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 12
    .line 13
    .line 14
    move-result v4

    .line 15
    const/16 v5, 0x8

    .line 16
    .line 17
    const/4 v6, 0x3

    .line 18
    const/4 v7, 0x0

    .line 19
    const/4 v8, 0x1

    .line 20
    if-ne v4, v8, :cond_8

    .line 21
    .line 22
    add-int/lit8 v4, v0, -0x1

    .line 23
    .line 24
    const/4 v9, 0x4

    .line 25
    new-array v9, v9, [I

    .line 26
    .line 27
    invoke-static {v1, v3}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 28
    .line 29
    .line 30
    move-result v10

    .line 31
    add-int/2addr v10, v8

    .line 32
    const/4 v11, 0x0

    .line 33
    :goto_0
    if-eqz v4, :cond_0

    .line 34
    .line 35
    shr-int/lit8 v4, v4, 0x1

    .line 36
    .line 37
    add-int/lit8 v11, v11, 0x1

    .line 38
    .line 39
    goto :goto_0

    .line 40
    :cond_0
    const/4 v4, 0x0

    .line 41
    :goto_1
    if-ge v4, v10, :cond_1

    .line 42
    .line 43
    invoke-static {v1, v11}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 44
    .line 45
    .line 46
    move-result v12

    .line 47
    rem-int/2addr v12, v0

    .line 48
    aput v12, v9, v4

    .line 49
    .line 50
    aput v3, v2, v12

    .line 51
    .line 52
    add-int/lit8 v4, v4, 0x1

    .line 53
    .line 54
    goto :goto_1

    .line 55
    :cond_1
    aget v4, v9, v7

    .line 56
    .line 57
    aput v8, v2, v4

    .line 58
    .line 59
    if-eq v10, v8, :cond_16

    .line 60
    .line 61
    if-eq v10, v3, :cond_6

    .line 62
    .line 63
    if-eq v10, v6, :cond_4

    .line 64
    .line 65
    aget v4, v9, v7

    .line 66
    .line 67
    aget v10, v9, v8

    .line 68
    .line 69
    if-eq v4, v10, :cond_2

    .line 70
    .line 71
    aget v11, v9, v3

    .line 72
    .line 73
    if-eq v4, v11, :cond_2

    .line 74
    .line 75
    aget v12, v9, v6

    .line 76
    .line 77
    if-eq v4, v12, :cond_2

    .line 78
    .line 79
    if-eq v10, v11, :cond_2

    .line 80
    .line 81
    if-eq v10, v12, :cond_2

    .line 82
    .line 83
    if-eq v11, v12, :cond_2

    .line 84
    .line 85
    const/4 v4, 0x1

    .line 86
    goto :goto_2

    .line 87
    :cond_2
    const/4 v4, 0x0

    .line 88
    :goto_2
    invoke-static {v1, v8}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 89
    .line 90
    .line 91
    move-result v1

    .line 92
    if-ne v1, v8, :cond_3

    .line 93
    .line 94
    aget v1, v9, v3

    .line 95
    .line 96
    aput v6, v2, v1

    .line 97
    .line 98
    aget v1, v9, v6

    .line 99
    .line 100
    aput v6, v2, v1

    .line 101
    .line 102
    goto :goto_3

    .line 103
    :cond_3
    aget v1, v9, v7

    .line 104
    .line 105
    aput v3, v2, v1

    .line 106
    .line 107
    :goto_3
    move v8, v4

    .line 108
    goto/16 :goto_d

    .line 109
    .line 110
    :cond_4
    aget v1, v9, v7

    .line 111
    .line 112
    aget v4, v9, v8

    .line 113
    .line 114
    if-eq v1, v4, :cond_5

    .line 115
    .line 116
    aget v3, v9, v3

    .line 117
    .line 118
    if-eq v1, v3, :cond_5

    .line 119
    .line 120
    if-eq v4, v3, :cond_5

    .line 121
    .line 122
    const/4 v7, 0x1

    .line 123
    :cond_5
    :goto_4
    move v8, v7

    .line 124
    goto/16 :goto_d

    .line 125
    .line 126
    :cond_6
    aget v1, v9, v7

    .line 127
    .line 128
    aget v3, v9, v8

    .line 129
    .line 130
    if-eq v1, v3, :cond_7

    .line 131
    .line 132
    const/4 v7, 0x1

    .line 133
    :cond_7
    aput v8, v2, v3

    .line 134
    .line 135
    goto :goto_4

    .line 136
    :cond_8
    const/16 v3, 0x12

    .line 137
    .line 138
    new-array v9, v3, [I

    .line 139
    .line 140
    const/16 v10, 0x20

    .line 141
    .line 142
    const/16 v11, 0x20

    .line 143
    .line 144
    const/4 v12, 0x0

    .line 145
    :goto_5
    if-ge v4, v3, :cond_a

    .line 146
    .line 147
    if-lez v11, :cond_a

    .line 148
    .line 149
    sget-object v14, Lorg/brotli/dec/Utils;->CODE_LENGTH_CODE_ORDER:[I

    .line 150
    .line 151
    aget v14, v14, v4

    .line 152
    .line 153
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 154
    .line 155
    .line 156
    move/from16 v16, v14

    .line 157
    .line 158
    const v15, 0xffff

    .line 159
    .line 160
    .line 161
    iget-wide v13, v1, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 162
    .line 163
    const/16 v17, 0x3

    .line 164
    .line 165
    iget v6, v1, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 166
    .line 167
    ushr-long/2addr v13, v6

    .line 168
    long-to-int v14, v13

    .line 169
    and-int/lit8 v13, v14, 0xf

    .line 170
    .line 171
    sget-object v14, Lorg/brotli/dec/Utils;->FIXED_TABLE:[I

    .line 172
    .line 173
    aget v13, v14, v13

    .line 174
    .line 175
    shr-int/lit8 v14, v13, 0x10

    .line 176
    .line 177
    add-int/2addr v6, v14

    .line 178
    iput v6, v1, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 179
    .line 180
    and-int v6, v13, v15

    .line 181
    .line 182
    aput v6, v9, v16

    .line 183
    .line 184
    if-eqz v6, :cond_9

    .line 185
    .line 186
    shr-int v6, v10, v6

    .line 187
    .line 188
    sub-int/2addr v11, v6

    .line 189
    add-int/lit8 v12, v12, 0x1

    .line 190
    .line 191
    :cond_9
    add-int/lit8 v4, v4, 0x1

    .line 192
    .line 193
    const/4 v6, 0x3

    .line 194
    goto :goto_5

    .line 195
    :cond_a
    const v15, 0xffff

    .line 196
    .line 197
    .line 198
    const/16 v17, 0x3

    .line 199
    .line 200
    if-eq v12, v8, :cond_c

    .line 201
    .line 202
    if-nez v11, :cond_b

    .line 203
    .line 204
    goto :goto_6

    .line 205
    :cond_b
    const/4 v8, 0x0

    .line 206
    :cond_c
    :goto_6
    new-array v4, v10, [I

    .line 207
    .line 208
    const/4 v6, 0x5

    .line 209
    invoke-static {v7, v6, v4, v9, v3}, Lorg/brotli/dec/Utils;->buildHuffmanTable(II[I[II)V

    .line 210
    .line 211
    .line 212
    const/4 v6, 0x0

    .line 213
    const v9, 0x8000

    .line 214
    .line 215
    .line 216
    const/16 v10, 0x8

    .line 217
    .line 218
    const/4 v11, 0x0

    .line 219
    :goto_7
    const/4 v12, 0x0

    .line 220
    :goto_8
    if-ge v6, v0, :cond_15

    .line 221
    .line 222
    if-lez v9, :cond_15

    .line 223
    .line 224
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 225
    .line 226
    .line 227
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 228
    .line 229
    .line 230
    iget-wide v13, v1, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 231
    .line 232
    const v16, 0x8000

    .line 233
    .line 234
    .line 235
    iget v3, v1, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 236
    .line 237
    ushr-long/2addr v13, v3

    .line 238
    long-to-int v14, v13

    .line 239
    and-int/lit8 v13, v14, 0x1f

    .line 240
    .line 241
    aget v13, v4, v13

    .line 242
    .line 243
    shr-int/lit8 v14, v13, 0x10

    .line 244
    .line 245
    add-int/2addr v3, v14

    .line 246
    iput v3, v1, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 247
    .line 248
    and-int v3, v13, v15

    .line 249
    .line 250
    const/16 v13, 0x10

    .line 251
    .line 252
    if-ge v3, v13, :cond_e

    .line 253
    .line 254
    add-int/lit8 v12, v6, 0x1

    .line 255
    .line 256
    aput v3, v2, v6

    .line 257
    .line 258
    if-eqz v3, :cond_d

    .line 259
    .line 260
    shr-int v6, v16, v3

    .line 261
    .line 262
    sub-int/2addr v9, v6

    .line 263
    move v10, v3

    .line 264
    :cond_d
    move v6, v12

    .line 265
    goto :goto_7

    .line 266
    :cond_e
    add-int/lit8 v14, v3, -0xe

    .line 267
    .line 268
    if-ne v3, v13, :cond_f

    .line 269
    .line 270
    move v3, v10

    .line 271
    goto :goto_9

    .line 272
    :cond_f
    const/4 v3, 0x0

    .line 273
    :goto_9
    if-eq v11, v3, :cond_10

    .line 274
    .line 275
    move v11, v3

    .line 276
    const/4 v12, 0x0

    .line 277
    :cond_10
    if-lez v12, :cond_11

    .line 278
    .line 279
    add-int/lit8 v3, v12, -0x2

    .line 280
    .line 281
    shl-int/2addr v3, v14

    .line 282
    goto :goto_a

    .line 283
    :cond_11
    move v3, v12

    .line 284
    :goto_a
    invoke-static {v1, v14}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 285
    .line 286
    .line 287
    move-result v13

    .line 288
    add-int/lit8 v13, v13, 0x3

    .line 289
    .line 290
    add-int/2addr v13, v3

    .line 291
    sub-int v3, v13, v12

    .line 292
    .line 293
    add-int v12, v6, v3

    .line 294
    .line 295
    if-gt v12, v0, :cond_14

    .line 296
    .line 297
    const/4 v12, 0x0

    .line 298
    :goto_b
    if-ge v12, v3, :cond_12

    .line 299
    .line 300
    add-int/lit8 v14, v6, 0x1

    .line 301
    .line 302
    aput v11, v2, v6

    .line 303
    .line 304
    add-int/lit8 v12, v12, 0x1

    .line 305
    .line 306
    move v6, v14

    .line 307
    goto :goto_b

    .line 308
    :cond_12
    if-eqz v11, :cond_13

    .line 309
    .line 310
    rsub-int/lit8 v12, v11, 0xf

    .line 311
    .line 312
    shl-int/2addr v3, v12

    .line 313
    sub-int/2addr v9, v3

    .line 314
    :cond_13
    move v12, v13

    .line 315
    goto :goto_8

    .line 316
    :cond_14
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 317
    .line 318
    const-string v1, "symbol + repeatDelta > numSymbols"

    .line 319
    .line 320
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 321
    .line 322
    .line 323
    throw v0

    .line 324
    :cond_15
    if-nez v9, :cond_18

    .line 325
    .line 326
    sub-int v1, v0, v6

    .line 327
    .line 328
    const/4 v3, 0x0

    .line 329
    :goto_c
    if-ge v3, v1, :cond_16

    .line 330
    .line 331
    add-int/lit16 v4, v3, 0x400

    .line 332
    .line 333
    invoke-static {v4, v1}, Ljava/lang/Math;->min(II)I

    .line 334
    .line 335
    .line 336
    move-result v4

    .line 337
    sub-int/2addr v4, v3

    .line 338
    sget-object v9, Lorg/brotli/dec/Utils;->INT_ZEROES:[I

    .line 339
    .line 340
    add-int v10, v6, v3

    .line 341
    .line 342
    invoke-static {v9, v7, v2, v10, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 343
    .line 344
    .line 345
    add-int/2addr v3, v4

    .line 346
    goto :goto_c

    .line 347
    :cond_16
    :goto_d
    if-eqz v8, :cond_17

    .line 348
    .line 349
    move-object/from16 v1, p1

    .line 350
    .line 351
    move/from16 v3, p2

    .line 352
    .line 353
    invoke-static {v3, v5, v1, v2, v0}, Lorg/brotli/dec/Utils;->buildHuffmanTable(II[I[II)V

    .line 354
    .line 355
    .line 356
    return-void

    .line 357
    :cond_17
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 358
    .line 359
    const-string v1, "Can\'t readHuffmanCode"

    .line 360
    .line 361
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 362
    .line 363
    .line 364
    throw v0

    .line 365
    :cond_18
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 366
    .line 367
    const-string v1, "Unused space"

    .line 368
    .line 369
    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 370
    .line 371
    .line 372
    throw v0
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method public static readSymbol([IILorg/brotli/dec/BitReader;)I
    .locals 6

    .line 1
    iget-wide v0, p2, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 2
    .line 3
    iget v2, p2, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 4
    .line 5
    ushr-long/2addr v0, v2

    .line 6
    long-to-int v1, v0

    .line 7
    and-int/lit16 v0, v1, 0xff

    .line 8
    .line 9
    add-int/2addr p1, v0

    .line 10
    aget v0, p0, p1

    .line 11
    .line 12
    shr-int/lit8 v3, v0, 0x10

    .line 13
    .line 14
    const v4, 0xffff

    .line 15
    .line 16
    .line 17
    and-int/2addr v0, v4

    .line 18
    const/16 v5, 0x8

    .line 19
    .line 20
    if-gt v3, v5, :cond_0

    .line 21
    .line 22
    add-int/2addr v2, v3

    .line 23
    iput v2, p2, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 24
    .line 25
    return v0

    .line 26
    :cond_0
    add-int/2addr p1, v0

    .line 27
    const/4 v0, 0x1

    .line 28
    shl-int v3, v0, v3

    .line 29
    .line 30
    sub-int/2addr v3, v0

    .line 31
    and-int v0, v1, v3

    .line 32
    .line 33
    ushr-int/2addr v0, v5

    .line 34
    add-int/2addr p1, v0

    .line 35
    aget p0, p0, p1

    .line 36
    .line 37
    shr-int/lit8 p1, p0, 0x10

    .line 38
    .line 39
    add-int/2addr p1, v5

    .line 40
    add-int/2addr p1, v2

    .line 41
    iput p1, p2, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 42
    .line 43
    and-int/2addr p0, v4

    .line 44
    return p0
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
