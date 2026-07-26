.class public Lcom/maxmind/db/CHMCache;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/maxmind/db/NodeCache;


# static fields
.field private static final DEFAULT_CAPACITY:I = 0x1000


# instance fields
.field private final cache:Lj$/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lj$/util/concurrent/ConcurrentHashMap<",
            "Lcom/maxmind/db/CacheKey;",
            "Lcom/maxmind/db/DecodedValue;",
            ">;"
        }
    .end annotation
.end field

.field private cacheFull:Z

.field private final capacity:I


# direct methods
.method public constructor <init>()V
    .locals 1

    const/16 v0, 0x1000

    .line 1
    invoke-direct {p0, v0}, Lcom/maxmind/db/CHMCache;-><init>(I)V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 1

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 3
    iput-boolean v0, p0, Lcom/maxmind/db/CHMCache;->cacheFull:Z

    .line 4
    iput p1, p0, Lcom/maxmind/db/CHMCache;->capacity:I

    .line 5
    new-instance v0, Lj$/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0, p1}, Lj$/util/concurrent/ConcurrentHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/maxmind/db/CHMCache;->cache:Lj$/util/concurrent/ConcurrentHashMap;

    return-void
.end method


# virtual methods
.method public get(Lcom/maxmind/db/CacheKey;Lcom/maxmind/db/NodeCache$Loader;)Lcom/maxmind/db/DecodedValue;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/CHMCache;->cache:Lj$/util/concurrent/ConcurrentHashMap;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lj$/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lcom/maxmind/db/DecodedValue;

    .line 8
    .line 9
    if-nez v0, :cond_2

    .line 10
    .line 11
    invoke-interface {p2, p1}, Lcom/maxmind/db/NodeCache$Loader;->load(Lcom/maxmind/db/CacheKey;)Lcom/maxmind/db/DecodedValue;

    .line 12
    .line 13
    .line 14
    move-result-object p2

    .line 15
    iget-boolean v0, p0, Lcom/maxmind/db/CHMCache;->cacheFull:Z

    .line 16
    .line 17
    if-nez v0, :cond_1

    .line 18
    .line 19
    iget-object v0, p0, Lcom/maxmind/db/CHMCache;->cache:Lj$/util/concurrent/ConcurrentHashMap;

    .line 20
    .line 21
    invoke-virtual {v0}, Lj$/util/concurrent/ConcurrentHashMap;->size()I

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    iget v1, p0, Lcom/maxmind/db/CHMCache;->capacity:I

    .line 26
    .line 27
    if-ge v0, v1, :cond_0

    .line 28
    .line 29
    iget-object v0, p0, Lcom/maxmind/db/CHMCache;->cache:Lj$/util/concurrent/ConcurrentHashMap;

    .line 30
    .line 31
    invoke-virtual {v0, p1, p2}, Lj$/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    .line 33
    .line 34
    return-object p2

    .line 35
    :cond_0
    const/4 p1, 0x1

    .line 36
    iput-boolean p1, p0, Lcom/maxmind/db/CHMCache;->cacheFull:Z

    .line 37
    .line 38
    :cond_1
    return-object p2

    .line 39
    :cond_2
    return-object v0
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
