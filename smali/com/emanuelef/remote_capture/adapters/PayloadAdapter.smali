.class public Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;,
        Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;,
        Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;,
        Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter;",
        "Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;"
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z = false

.field public static final COLLAPSE_CHUNK_SIZE:I = 0x5dc

.field static final MAX_JSON_FORMAT_SIZE:I = 0x100000

.field private static final TAG:Ljava/lang/String; = "PayloadAdapter"

.field public static final VISUAL_PAGE_SIZE:I = 0xfb4

.field private static final prettyGson:Lcom/google/gson/Gson;


# instance fields
.field private final mChunks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;",
            ">;"
        }
    .end annotation
.end field

.field private final mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

.field private final mContext:Landroid/content/Context;

.field private mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

.field private mHandledChunks:I

.field private final mHttpReq:Lcom/emanuelef/remote_capture/HTTPReassembly;

.field private final mHttpRes:Lcom/emanuelef/remote_capture/HTTPReassembly;

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field private final mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

.field private mShowAsPrintable:Z

.field private final mSingleChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

.field private final mSupportsFileDialog:Z

.field private final mUnrepliedHttpReqs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$3LAchvlv16H4C-rtT0Mv5ACf5PA(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$onCreateViewHolder$2(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$76p8Dx-_kFpzCWboUzJlRFUu7xc(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$6(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$BqwgkR6qyjppnHynKU-Oou6XJQI(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$4(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$PT0FHf8Fg-bttixgXKaDLHJic2E(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$3(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$WvbKXV3jB4b-NU-60nWJ8tGf3uE(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$5(Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$ZhEvm2neRYXjbP5NcNZUC6OnbLw(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;ILandroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p5}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$8(ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;ILandroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$rLeba1UdqIl53ryKIcaaTWQZWik(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$onCreateViewHolder$1(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$rcsfvlWpjych1jb4p0lOwt1GJAY(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$handleCopyExportButtons$7(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$z3m5JbBdj0B8YAod2Zu7a5FEqQc(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmMode(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;)Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmShowAsPrintable(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mShowAsPrintable:Z

    return p0
.end method

.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/gson/GsonBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    sget-object v1, Lcom/google/gson/FormattingStyle;->PRETTY:Lcom/google/gson/FormattingStyle;

    .line 7
    .line 8
    invoke-static {v1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    iput-object v1, v0, Lcom/google/gson/GsonBuilder;->formattingStyle:Lcom/google/gson/FormattingStyle;

    .line 12
    .line 13
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    sput-object v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->prettyGson:Lcom/google/gson/Gson;

    .line 18
    .line 19
    return-void
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

.method public constructor <init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;Z)V
    .locals 6

    .line 21
    iget-object v2, p2, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    sget-object v3, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    const/4 v4, 0x1

    invoke-static {p2, p3}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getChunk(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;Z)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    move-result-object v5

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;ZLcom/emanuelef/remote_capture/model/PayloadChunk;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;Z)V
    .locals 6

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    .line 20
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;ZLcom/emanuelef/remote_capture/model/PayloadChunk;)V

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;ZLcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 2
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 3
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 4
    const-string v1, "layout_inflater"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    iput-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 5
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 6
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 7
    iput-object p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 8
    iput-boolean p4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mShowAsPrintable:Z

    .line 9
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->supportsFileDialog(Landroid/content/Context;)Z

    move-result p1

    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mSupportsFileDialog:Z

    .line 10
    iput-object p5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mSingleChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    const/4 p1, 0x0

    if-nez p5, :cond_1

    .line 11
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getCurPayloadMode()Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    move-result-object p3

    sget-object p4, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->FULL:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    if-ne p3, p4, :cond_0

    const/4 p1, 0x1

    .line 12
    :cond_0
    new-instance p3, Lcom/emanuelef/remote_capture/HTTPReassembly;

    invoke-direct {p3, p1, p0}, Lcom/emanuelef/remote_capture/HTTPReassembly;-><init>(ZLcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;)V

    iput-object p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpReq:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 13
    new-instance p3, Lcom/emanuelef/remote_capture/HTTPReassembly;

    invoke-direct {p3, p1, p0}, Lcom/emanuelef/remote_capture/HTTPReassembly;-><init>(ZLcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;)V

    iput-object p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpRes:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 14
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getNumPayloadChunks()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->handleChunksAdded(I)V

    return-void

    :cond_1
    const/4 p2, 0x0

    .line 15
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpReq:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 16
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpRes:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 17
    iget-object p2, p5, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    array-length p2, p2

    if-lez p2, :cond_2

    .line 18
    new-instance p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    invoke-direct {p2, p0, p5, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/model/PayloadChunk;I)V

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 19
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemInserted(I)V

    :cond_2
    return-void
.end method

.method private findMatchingRequest(Lcom/emanuelef/remote_capture/model/PayloadChunk;)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;
    .locals 7

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    return-object v1

    .line 11
    :cond_0
    iget v0, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->stream_id:I

    .line 12
    .line 13
    const/4 v2, 0x0

    .line 14
    if-nez v0, :cond_1

    .line 15
    .line 16
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 17
    .line 18
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    check-cast p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 23
    .line 24
    return-object p1

    .line 25
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 26
    .line 27
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 28
    .line 29
    .line 30
    move-result v3

    .line 31
    :cond_2
    if-ge v2, v3, :cond_3

    .line 32
    .line 33
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    add-int/lit8 v2, v2, 0x1

    .line 38
    .line 39
    check-cast v4, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 40
    .line 41
    invoke-static {v4}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 42
    .line 43
    .line 44
    move-result-object v5

    .line 45
    iget v5, v5, Lcom/emanuelef/remote_capture/model/PayloadChunk;->stream_id:I

    .line 46
    .line 47
    iget v6, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->stream_id:I

    .line 48
    .line 49
    if-ne v5, v6, :cond_2

    .line 50
    .line 51
    return-object v4

    .line 52
    :cond_3
    return-object v1
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public static formatHttpPayload(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .line 1
    if-eqz p1, :cond_3

    .line 2
    .line 3
    const-string v0, "application/json"

    .line 4
    .line 5
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    if-nez p1, :cond_0

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    .line 13
    .line 14
    .line 15
    move-result p1

    .line 16
    const/high16 v0, 0x100000

    .line 17
    .line 18
    if-le p1, v0, :cond_1

    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_1
    const-string p1, "\r\n\r\n"

    .line 22
    .line 23
    invoke-virtual {p0, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    .line 24
    .line 25
    .line 26
    move-result p1

    .line 27
    if-ltz p1, :cond_3

    .line 28
    .line 29
    add-int/lit8 p1, p1, 0x4

    .line 30
    .line 31
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    .line 32
    .line 33
    .line 34
    move-result v0

    .line 35
    if-lt p1, v0, :cond_2

    .line 36
    .line 37
    goto :goto_0

    .line 38
    :cond_2
    const/4 v0, 0x0

    .line 39
    invoke-virtual {p0, v0, p1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    invoke-virtual {p0, p1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    :try_start_0
    sget-object v1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->prettyGson:Lcom/google/gson/Gson;

    .line 48
    .line 49
    invoke-static {p1}, Lkotlin/LazyKt__LazyJVMKt;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 50
    .line 51
    .line 52
    move-result-object p1

    .line 53
    invoke-virtual {v1, p1}, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    new-instance v1, Ljava/lang/StringBuilder;

    .line 58
    .line 59
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 60
    .line 61
    .line 62
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 63
    .line 64
    .line 65
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 66
    .line 67
    .line 68
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 69
    .line 70
    .line 71
    move-result-object p0
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :catch_0
    :cond_3
    :goto_0
    return-object p0
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

.method private getAdapterPosition(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)I
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    const/4 v1, 0x0

    .line 3
    :goto_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 4
    .line 5
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 6
    .line 7
    .line 8
    move-result v2

    .line 9
    if-ge v0, v2, :cond_1

    .line 10
    .line 11
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 12
    .line 13
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    check-cast v2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 18
    .line 19
    if-ne v2, p1, :cond_0

    .line 20
    .line 21
    goto :goto_1

    .line 22
    :cond_0
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 23
    .line 24
    .line 25
    move-result v2

    .line 26
    add-int/2addr v1, v2

    .line 27
    add-int/lit8 v0, v0, 0x1

    .line 28
    .line 29
    goto :goto_0

    .line 30
    :cond_1
    :goto_1
    return v1
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

.method private static getChunk(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;Z)Lcom/emanuelef/remote_capture/model/PayloadChunk;
    .locals 7

    .line 1
    if-eqz p1, :cond_1

    .line 2
    .line 3
    iget-object p1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 4
    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    iget-object p0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 8
    .line 9
    iget p1, p1, Lcom/emanuelef/remote_capture/HttpLog$HttpReply;->firstChunkPos:I

    .line 10
    .line 11
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpResponseChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 12
    .line 13
    .line 14
    move-result-object p0

    .line 15
    return-object p0

    .line 16
    :cond_0
    new-instance v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 17
    .line 18
    const/4 p0, 0x0

    .line 19
    new-array v1, p0, [B

    .line 20
    .line 21
    sget-object v2, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 22
    .line 23
    const-wide/16 v4, 0x0

    .line 24
    .line 25
    const/4 v6, 0x0

    .line 26
    const/4 v3, 0x1

    .line 27
    invoke-direct/range {v0 .. v6}, Lcom/emanuelef/remote_capture/model/PayloadChunk;-><init>([BLcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;ZJI)V

    .line 28
    .line 29
    .line 30
    return-object v0

    .line 31
    :cond_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 32
    .line 33
    iget p0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->firstChunkPos:I

    .line 34
    .line 35
    invoke-virtual {p1, p0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpRequestChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 36
    .line 37
    .line 38
    move-result-object p0

    .line 39
    return-object p0
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

.method private getHeaderTag(Lcom/emanuelef/remote_capture/model/PayloadChunk;)Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 2
    .line 3
    sget-object v1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 4
    .line 5
    if-ne v0, v1, :cond_1

    .line 6
    .line 7
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 8
    .line 9
    if-eqz p1, :cond_0

    .line 10
    .line 11
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 12
    .line 13
    const v0, 0x7f140268

    .line 14
    .line 15
    .line 16
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    return-object p1

    .line 21
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 22
    .line 23
    const v0, 0x7f14026f

    .line 24
    .line 25
    .line 26
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    return-object p1

    .line 31
    :cond_1
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 32
    .line 33
    if-eqz p1, :cond_2

    .line 34
    .line 35
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 36
    .line 37
    const v0, 0x7f1402ca

    .line 38
    .line 39
    .line 40
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 41
    .line 42
    .line 43
    move-result-object p1

    .line 44
    return-object p1

    .line 45
    :cond_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 46
    .line 47
    const v0, 0x7f14027c

    .line 48
    .line 49
    .line 50
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 51
    .line 52
    .line 53
    move-result-object p1

    .line 54
    return-object p1
    .line 55
    .line 56
    .line 57
.end method

.method private handleCopyExportButtons(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Z)V
    .locals 12

    .line 1
    if-eqz p2, :cond_0

    .line 2
    .line 3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    :goto_0
    move-object p2, p0

    .line 8
    goto/16 :goto_6

    .line 9
    .line 10
    :cond_0
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getAbsoluteAdapterPosition()I

    .line 11
    .line 12
    .line 13
    move-result p1

    .line 14
    if-eqz p2, :cond_1

    .line 15
    .line 16
    const v0, 0x7f140105

    .line 17
    .line 18
    .line 19
    goto :goto_1

    .line 20
    :cond_1
    const v0, 0x7f1400aa

    .line 21
    .line 22
    .line 23
    :goto_1
    if-eqz p2, :cond_2

    .line 24
    .line 25
    const v1, 0x7f140103

    .line 26
    .line 27
    .line 28
    goto :goto_2

    .line 29
    :cond_2
    const v1, 0x7f1400ac

    .line 30
    .line 31
    .line 32
    :goto_2
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    .line 33
    .line 34
    .line 35
    move-result-object v2

    .line 36
    iget-object v8, v2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 37
    .line 38
    if-nez v8, :cond_3

    .line 39
    .line 40
    goto :goto_0

    .line 41
    :cond_3
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 42
    .line 43
    sget-object v3, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 44
    .line 45
    const v4, 0x7f14006d

    .line 46
    .line 47
    .line 48
    const/4 v5, 0x1

    .line 49
    if-ne v2, v3, :cond_c

    .line 50
    .line 51
    const/4 v2, 0x1

    .line 52
    invoke-virtual {v8, v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getExpandedText(Z)Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object v5

    .line 56
    const-string v3, "\r\n\r\n"

    .line 57
    .line 58
    invoke-virtual {v5, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    .line 59
    .line 60
    .line 61
    move-result v6

    .line 62
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 63
    .line 64
    .line 65
    move-result-object v3

    .line 66
    iget-object v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 67
    .line 68
    if-eqz v3, :cond_4

    .line 69
    .line 70
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 71
    .line 72
    .line 73
    move-result-object v3

    .line 74
    iget-object v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 75
    .line 76
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    .line 77
    .line 78
    .line 79
    move-result v3

    .line 80
    if-nez v3, :cond_4

    .line 81
    .line 82
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 83
    .line 84
    .line 85
    move-result-object v3

    .line 86
    iget-object v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 87
    .line 88
    :goto_3
    move-object v9, v3

    .line 89
    goto :goto_4

    .line 90
    :cond_4
    const-string v3, "text/plain"

    .line 91
    .line 92
    goto :goto_3

    .line 93
    :goto_4
    new-instance v3, Ljava/lang/StringBuilder;

    .line 94
    .line 95
    const-string v7, "Export body content type: "

    .line 96
    .line 97
    invoke-direct {v3, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 98
    .line 99
    .line 100
    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    .line 102
    .line 103
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 104
    .line 105
    .line 106
    move-result-object v3

    .line 107
    const-string v7, "PayloadAdapter"

    .line 108
    .line 109
    invoke-static {v7, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    .line 111
    .line 112
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 113
    .line 114
    .line 115
    move-result-object v3

    .line 116
    iget-boolean v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 117
    .line 118
    const-string v10, ""

    .line 119
    .line 120
    if-eqz v3, :cond_5

    .line 121
    .line 122
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 123
    .line 124
    .line 125
    move-result-object v3

    .line 126
    iget-object v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 127
    .line 128
    if-eqz v3, :cond_5

    .line 129
    .line 130
    invoke-static {v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 131
    .line 132
    .line 133
    move-result-object p1

    .line 134
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 135
    .line 136
    goto :goto_5

    .line 137
    :cond_5
    if-lez p1, :cond_6

    .line 138
    .line 139
    sub-int/2addr p1, v2

    .line 140
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    .line 141
    .line 142
    .line 143
    move-result-object p1

    .line 144
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 145
    .line 146
    invoke-static {p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 147
    .line 148
    .line 149
    move-result-object v3

    .line 150
    iget-boolean v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 151
    .line 152
    if-eqz v3, :cond_6

    .line 153
    .line 154
    invoke-static {p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 155
    .line 156
    .line 157
    move-result-object v3

    .line 158
    iget-object v3, v3, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 159
    .line 160
    if-eqz v3, :cond_6

    .line 161
    .line 162
    invoke-static {p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 163
    .line 164
    .line 165
    move-result-object p1

    .line 166
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 167
    .line 168
    goto :goto_5

    .line 169
    :cond_6
    move-object p1, v10

    .line 170
    :goto_5
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 171
    .line 172
    .line 173
    move-result v3

    .line 174
    if-nez v3, :cond_7

    .line 175
    .line 176
    const/16 v3, 0x2f

    .line 177
    .line 178
    invoke-virtual {p1, v3}, Ljava/lang/String;->lastIndexOf(I)I

    .line 179
    .line 180
    .line 181
    move-result v3

    .line 182
    if-ltz v3, :cond_7

    .line 183
    .line 184
    add-int/2addr v3, v2

    .line 185
    invoke-virtual {p1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 186
    .line 187
    .line 188
    move-result-object p1

    .line 189
    :cond_7
    const-string v3, "."

    .line 190
    .line 191
    invoke-virtual {p1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    .line 192
    .line 193
    .line 194
    move-result v3

    .line 195
    if-eqz v3, :cond_8

    .line 196
    .line 197
    const-string v3, "File name: "

    .line 198
    .line 199
    invoke-virtual {v3, p1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 200
    .line 201
    .line 202
    move-result-object v3

    .line 203
    invoke-static {v7, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    .line 205
    .line 206
    move-object v10, p1

    .line 207
    :cond_8
    if-lez v6, :cond_9

    .line 208
    .line 209
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    .line 210
    .line 211
    .line 212
    move-result p1

    .line 213
    add-int/lit8 p1, p1, -0x4

    .line 214
    .line 215
    if-ge v6, p1, :cond_9

    .line 216
    .line 217
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 218
    .line 219
    const v3, 0x7f140128

    .line 220
    .line 221
    .line 222
    invoke-virtual {p1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 223
    .line 224
    .line 225
    move-result-object p1

    .line 226
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 227
    .line 228
    const v7, 0x7f140057

    .line 229
    .line 230
    .line 231
    invoke-virtual {v3, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 232
    .line 233
    .line 234
    move-result-object v3

    .line 235
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 236
    .line 237
    const v11, 0x7f140058

    .line 238
    .line 239
    .line 240
    invoke-virtual {v7, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 241
    .line 242
    .line 243
    move-result-object v7

    .line 244
    filled-new-array {p1, v3, v7}, [Ljava/lang/String;

    .line 245
    .line 246
    .line 247
    move-result-object p1

    .line 248
    new-instance v11, Landroid/app/AlertDialog$Builder;

    .line 249
    .line 250
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 251
    .line 252
    invoke-direct {v11, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 253
    .line 254
    .line 255
    invoke-virtual {v11, v0}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 256
    .line 257
    .line 258
    new-instance v0, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 259
    .line 260
    const/16 v3, 0xa

    .line 261
    .line 262
    invoke-direct {v0, v3}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 263
    .line 264
    .line 265
    invoke-virtual {v11, p1, v2, v0}, Landroid/app/AlertDialog$Builder;->setSingleChoiceItems([Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 266
    .line 267
    .line 268
    new-instance p1, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 269
    .line 270
    const/16 v0, 0xb

    .line 271
    .line 272
    invoke-direct {p1, v0}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 273
    .line 274
    .line 275
    invoke-virtual {v11, v4, p1}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 276
    .line 277
    .line 278
    new-instance v3, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;

    .line 279
    .line 280
    move-object v4, p0

    .line 281
    move v7, p2

    .line 282
    invoke-direct/range {v3 .. v10}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    .line 284
    .line 285
    move-object p2, v4

    .line 286
    invoke-virtual {v11, v1, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 287
    .line 288
    .line 289
    invoke-virtual {v11}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 290
    .line 291
    .line 292
    move-result-object p1

    .line 293
    invoke-virtual {p1}, Landroid/app/Dialog;->show()V

    .line 294
    .line 295
    .line 296
    return-void

    .line 297
    :cond_9
    move v7, p2

    .line 298
    move-object p2, p0

    .line 299
    if-eqz v7, :cond_b

    .line 300
    .line 301
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 302
    .line 303
    if-eqz p1, :cond_a

    .line 304
    .line 305
    invoke-interface {p1, v5}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;->exportPayload(Ljava/lang/String;)V

    .line 306
    .line 307
    .line 308
    :cond_a
    :goto_6
    return-void

    .line 309
    :cond_b
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 310
    .line 311
    invoke-static {p1, v5}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 312
    .line 313
    .line 314
    return-void

    .line 315
    :cond_c
    const/4 v2, 0x1

    .line 316
    move v7, p2

    .line 317
    move-object p2, p0

    .line 318
    new-instance v3, Ljava/util/ArrayList;

    .line 319
    .line 320
    iget-object v5, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 321
    .line 322
    const v6, 0x7f1402be

    .line 323
    .line 324
    .line 325
    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 326
    .line 327
    .line 328
    move-result-object v5

    .line 329
    iget-object v6, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 330
    .line 331
    const v9, 0x7f14012a

    .line 332
    .line 333
    .line 334
    invoke-virtual {v6, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 335
    .line 336
    .line 337
    move-result-object v6

    .line 338
    filled-new-array {v5, v6}, [Ljava/lang/String;

    .line 339
    .line 340
    .line 341
    move-result-object v5

    .line 342
    invoke-static {v5}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 343
    .line 344
    .line 345
    move-result-object v5

    .line 346
    invoke-direct {v3, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 347
    .line 348
    .line 349
    if-eqz v7, :cond_d

    .line 350
    .line 351
    iget-object v5, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 352
    .line 353
    const v6, 0x7f14025e

    .line 354
    .line 355
    .line 356
    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 357
    .line 358
    .line 359
    move-result-object v5

    .line 360
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 361
    .line 362
    .line 363
    :cond_d
    new-instance v5, Landroid/app/AlertDialog$Builder;

    .line 364
    .line 365
    iget-object v6, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 366
    .line 367
    invoke-direct {v5, v6}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 368
    .line 369
    .line 370
    invoke-virtual {v5, v0}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 371
    .line 372
    .line 373
    const/4 v0, 0x0

    .line 374
    new-array v0, v0, [Ljava/lang/String;

    .line 375
    .line 376
    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 377
    .line 378
    .line 379
    move-result-object v0

    .line 380
    check-cast v0, [Ljava/lang/CharSequence;

    .line 381
    .line 382
    iget-boolean v3, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mShowAsPrintable:Z

    .line 383
    .line 384
    xor-int/2addr v2, v3

    .line 385
    new-instance v3, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 386
    .line 387
    const/16 v6, 0xc

    .line 388
    .line 389
    invoke-direct {v3, v6}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 390
    .line 391
    .line 392
    invoke-virtual {v5, v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setSingleChoiceItems([Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 393
    .line 394
    .line 395
    new-instance v0, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 396
    .line 397
    const/16 v2, 0xd

    .line 398
    .line 399
    invoke-direct {v0, v2}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 400
    .line 401
    .line 402
    invoke-virtual {v5, v4, v0}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 403
    .line 404
    .line 405
    new-instance v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;

    .line 406
    .line 407
    invoke-direct {v0, p0, v7, v8, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;I)V

    .line 408
    .line 409
    .line 410
    invoke-virtual {v5, v1, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 411
    .line 412
    .line 413
    invoke-virtual {v5}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 414
    .line 415
    .line 416
    move-result-object p1

    .line 417
    invoke-virtual {p1}, Landroid/app/Dialog;->show()V

    .line 418
    .line 419
    .line 420
    return-void
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
.end method

.method private static synthetic lambda$handleCopyExportButtons$3(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static synthetic lambda$handleCopyExportButtons$4(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private synthetic lambda$handleCopyExportButtons$5(Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    check-cast p7, Landroid/app/AlertDialog;

    .line 2
    .line 3
    invoke-virtual {p7}, Landroid/app/AlertDialog;->getListView()Landroid/widget/ListView;

    .line 4
    .line 5
    .line 6
    move-result-object p7

    .line 7
    invoke-virtual {p7}, Landroid/widget/AbsListView;->getCheckedItemPosition()I

    .line 8
    .line 9
    .line 10
    move-result p7

    .line 11
    const/4 p8, 0x2

    .line 12
    if-eq p7, p8, :cond_1

    .line 13
    .line 14
    if-nez p7, :cond_0

    .line 15
    .line 16
    const/4 p8, 0x0

    .line 17
    invoke-virtual {p1, p8, p2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    goto :goto_0

    .line 22
    :cond_0
    add-int/lit8 p8, p2, 0x4

    .line 23
    .line 24
    invoke-virtual {p1, p8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    :cond_1
    :goto_0
    if-eqz p3, :cond_5

    .line 29
    .line 30
    iget-object p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 31
    .line 32
    if-eqz p3, :cond_4

    .line 33
    .line 34
    const/4 p8, 0x1

    .line 35
    if-ne p7, p8, :cond_3

    .line 36
    .line 37
    invoke-static {p4}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 38
    .line 39
    .line 40
    move-result-object p1

    .line 41
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 42
    .line 43
    array-length p3, p1

    .line 44
    add-int/lit8 p3, p3, -0x4

    .line 45
    .line 46
    if-ge p2, p3, :cond_2

    .line 47
    .line 48
    add-int/lit8 p2, p2, 0x4

    .line 49
    .line 50
    array-length p3, p1

    .line 51
    invoke-static {p1, p2, p3}, Ljava/util/Arrays;->copyOfRange([BII)[B

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    :cond_2
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 56
    .line 57
    invoke-interface {p2, p1, p5, p6}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;->exportPayload([BLjava/lang/String;Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    return-void

    .line 61
    :cond_3
    invoke-interface {p3, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;->exportPayload(Ljava/lang/String;)V

    .line 62
    .line 63
    .line 64
    :cond_4
    return-void

    .line 65
    :cond_5
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 66
    .line 67
    invoke-static {p2, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 68
    .line 69
    .line 70
    return-void
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
.end method

.method private static synthetic lambda$handleCopyExportButtons$6(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static synthetic lambda$handleCopyExportButtons$7(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private synthetic lambda$handleCopyExportButtons$8(ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;ILandroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    check-cast p4, Landroid/app/AlertDialog;

    .line 2
    .line 3
    invoke-virtual {p4}, Landroid/app/AlertDialog;->getListView()Landroid/widget/ListView;

    .line 4
    .line 5
    .line 6
    move-result-object p4

    .line 7
    invoke-virtual {p4}, Landroid/widget/AbsListView;->getCheckedItemPosition()I

    .line 8
    .line 9
    .line 10
    move-result p4

    .line 11
    const/4 p5, 0x2

    .line 12
    if-ne p4, p5, :cond_0

    .line 13
    .line 14
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 15
    .line 16
    if-eqz p1, :cond_2

    .line 17
    .line 18
    invoke-static {p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->-$$Nest$fgetmChunk(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 19
    .line 20
    .line 21
    move-result-object p2

    .line 22
    iget-object p2, p2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 23
    .line 24
    const-string p3, "application/octet-stream"

    .line 25
    .line 26
    const-string p4, ""

    .line 27
    .line 28
    invoke-interface {p1, p2, p3, p4}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;->exportPayload([BLjava/lang/String;Ljava/lang/String;)V

    .line 29
    .line 30
    .line 31
    return-void

    .line 32
    :cond_0
    invoke-virtual {p0, p3}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    .line 33
    .line 34
    .line 35
    move-result-object p2

    .line 36
    iget-object p2, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 37
    .line 38
    if-nez p4, :cond_1

    .line 39
    .line 40
    const/4 p3, 0x1

    .line 41
    goto :goto_0

    .line 42
    :cond_1
    const/4 p3, 0x0

    .line 43
    :goto_0
    invoke-virtual {p2, p3}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getExpandedText(Z)Ljava/lang/String;

    .line 44
    .line 45
    .line 46
    move-result-object p2

    .line 47
    if-eqz p1, :cond_3

    .line 48
    .line 49
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 50
    .line 51
    if-eqz p1, :cond_2

    .line 52
    .line 53
    invoke-interface {p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;->exportPayload(Ljava/lang/String;)V

    .line 54
    .line 55
    .line 56
    :cond_2
    return-void

    .line 57
    :cond_3
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    .line 58
    .line 59
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 60
    .line 61
    .line 62
    return-void
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

.method private synthetic lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getAbsoluteAdapterPosition()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    iget-object v0, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 10
    .line 11
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->isExpanded()Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    iget-object v0, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 18
    .line 19
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    add-int/lit8 v0, v0, -0x1

    .line 24
    .line 25
    sub-int/2addr p1, v0

    .line 26
    iget-object p2, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 27
    .line 28
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->collapse()V

    .line 29
    .line 30
    .line 31
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 32
    .line 33
    .line 34
    add-int/lit8 p1, p1, 0x1

    .line 35
    .line 36
    invoke-virtual {p0, p1, v0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRangeRemoved(II)V

    .line 37
    .line 38
    .line 39
    return-void

    .line 40
    :cond_0
    iget-object v0, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 41
    .line 42
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->expand()V

    .line 43
    .line 44
    .line 45
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 46
    .line 47
    .line 48
    add-int/lit8 p1, p1, 0x1

    .line 49
    .line 50
    iget-object p2, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 51
    .line 52
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 53
    .line 54
    .line 55
    move-result p2

    .line 56
    add-int/lit8 p2, p2, -0x1

    .line 57
    .line 58
    invoke-virtual {p0, p1, p2}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRangeInserted(II)V

    .line 59
    .line 60
    .line 61
    return-void
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

.method private synthetic lambda$onCreateViewHolder$1(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 0

    .line 1
    const/4 p2, 0x0

    .line 2
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->handleCopyExportButtons(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Z)V

    .line 3
    .line 4
    .line 5
    return-void
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

.method private synthetic lambda$onCreateViewHolder$2(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V
    .locals 0

    .line 1
    const/4 p2, 0x1

    .line 2
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->handleCopyExportButtons(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Z)V

    .line 3
    .line 4
    .line 5
    return-void
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


# virtual methods
.method public getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    if-gez p1, :cond_0

    .line 3
    .line 4
    return-object v0

    .line 5
    :cond_0
    const/4 v1, 0x0

    .line 6
    const/4 v2, 0x0

    .line 7
    :goto_0
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 8
    .line 9
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 10
    .line 11
    .line 12
    move-result v3

    .line 13
    if-ge v1, v3, :cond_2

    .line 14
    .line 15
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v3

    .line 21
    check-cast v3, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 22
    .line 23
    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 24
    .line 25
    .line 26
    move-result v3

    .line 27
    add-int/2addr v3, v2

    .line 28
    if-lt p1, v2, :cond_1

    .line 29
    .line 30
    if-ge p1, v3, :cond_1

    .line 31
    .line 32
    goto :goto_1

    .line 33
    :cond_1
    add-int/lit8 v1, v1, 0x1

    .line 34
    .line 35
    move v2, v3

    .line 36
    goto :goto_0

    .line 37
    :cond_2
    :goto_1
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 38
    .line 39
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 40
    .line 41
    .line 42
    move-result v3

    .line 43
    if-lt v1, v3, :cond_3

    .line 44
    .line 45
    return-object v0

    .line 46
    :cond_3
    sub-int/2addr p1, v2

    .line 47
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 48
    .line 49
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    check-cast v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 54
    .line 55
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getPage(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    return-object p1
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
.end method

.method public getItemCount()I
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    const/4 v3, 0x0

    .line 9
    :goto_0
    if-ge v3, v1, :cond_0

    .line 10
    .line 11
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v4

    .line 15
    add-int/lit8 v3, v3, 0x1

    .line 16
    .line 17
    check-cast v4, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 18
    .line 19
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 20
    .line 21
    .line 22
    move-result v4

    .line 23
    add-int/2addr v2, v4

    .line 24
    goto :goto_0

    .line 25
    :cond_0
    return v2
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

.method public handleChunksAdded(I)V
    .locals 9

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isReadingFromPcapFile()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    iget v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHandledChunks:I

    .line 6
    .line 7
    const/4 v2, -0x1

    .line 8
    const/4 v3, -0x1

    .line 9
    :goto_0
    if-ge v1, p1, :cond_7

    .line 10
    .line 11
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 12
    .line 13
    invoke-virtual {v4, v1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getPayloadChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 14
    .line 15
    .line 16
    move-result-object v4

    .line 17
    if-nez v4, :cond_0

    .line 18
    .line 19
    goto :goto_3

    .line 20
    :cond_0
    const/4 v5, 0x1

    .line 21
    if-eqz v0, :cond_1

    .line 22
    .line 23
    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 24
    .line 25
    sget-object v7, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 26
    .line 27
    if-ne v6, v7, :cond_1

    .line 28
    .line 29
    iget-object v6, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 30
    .line 31
    sget-object v7, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 32
    .line 33
    if-eq v6, v7, :cond_1

    .line 34
    .line 35
    const/4 v6, 0x1

    .line 36
    goto :goto_1

    .line 37
    :cond_1
    const/4 v6, 0x0

    .line 38
    :goto_1
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 39
    .line 40
    sget-object v8, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 41
    .line 42
    if-eq v7, v8, :cond_2

    .line 43
    .line 44
    iget-object v8, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 45
    .line 46
    if-eq v7, v8, :cond_2

    .line 47
    .line 48
    if-nez v6, :cond_2

    .line 49
    .line 50
    goto :goto_3

    .line 51
    :cond_2
    sget-object v8, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 52
    .line 53
    if-eq v7, v8, :cond_5

    .line 54
    .line 55
    if-eqz v6, :cond_3

    .line 56
    .line 57
    goto :goto_2

    .line 58
    :cond_3
    if-ne v3, v2, :cond_4

    .line 59
    .line 60
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItemCount()I

    .line 61
    .line 62
    .line 63
    move-result v3

    .line 64
    :cond_4
    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 65
    .line 66
    new-instance v7, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 67
    .line 68
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    .line 69
    .line 70
    .line 71
    move-result v8

    .line 72
    invoke-direct {v7, p0, v4, v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/model/PayloadChunk;I)V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 76
    .line 77
    .line 78
    invoke-virtual {p0, v3}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemInserted(I)V

    .line 79
    .line 80
    .line 81
    add-int/2addr v3, v5

    .line 82
    goto :goto_3

    .line 83
    :cond_5
    :goto_2
    iget-boolean v5, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 84
    .line 85
    if-eqz v5, :cond_6

    .line 86
    .line 87
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpReq:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 88
    .line 89
    invoke-virtual {v5, v4}, Lcom/emanuelef/remote_capture/HTTPReassembly;->handleChunk(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 90
    .line 91
    .line 92
    goto :goto_3

    .line 93
    :cond_6
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHttpRes:Lcom/emanuelef/remote_capture/HTTPReassembly;

    .line 94
    .line 95
    invoke-virtual {v5, v4}, Lcom/emanuelef/remote_capture/HTTPReassembly;->handleChunk(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 96
    .line 97
    .line 98
    :goto_3
    add-int/lit8 v1, v1, 0x1

    .line 99
    .line 100
    goto :goto_0

    .line 101
    :cond_7
    iput p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mHandledChunks:I

    .line 102
    .line 103
    return-void
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
.end method

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 1
    check-cast p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V
    .locals 11

    .line 2
    invoke-virtual {p0, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItem(I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;

    move-result-object p2

    .line 3
    iget-object v0, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getPayloadChunk()Lcom/emanuelef/remote_capture/model/PayloadChunk;

    move-result-object v0

    .line 4
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->isFirst()Z

    move-result v1

    const/16 v2, 0x8

    const/4 v3, 0x0

    if-eqz v1, :cond_2

    .line 5
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->headerLine:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 6
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getPrimaryLocale(Landroid/content/Context;)Ljava/util/Locale;

    move-result-object v1

    .line 7
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v5, "HH:mm:ss.SSS"

    invoke-direct {v4, v5, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    new-instance v5, Ljava/util/Date;

    iget-wide v6, v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;->timestamp:J

    invoke-direct {v5, v6, v7}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v4, v5}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    .line 8
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    sget-object v6, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    if-ne v5, v6, :cond_0

    .line 9
    iget v5, v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpBodyLength:I

    int-to-long v5, v5

    invoke-static {v5, v6}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 10
    :cond_0
    iget-object v5, v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    array-length v5, v5

    int-to-long v5, v5

    invoke-static {v5, v6}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    move-result-object v5

    .line 11
    :goto_0
    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mSingleChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    if-nez v6, :cond_1

    .line 12
    iget-object v6, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->header:Landroid/widget/TextView;

    iget-object v7, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    iget v7, v7, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->incrId:I

    const/4 v8, 0x1

    add-int/2addr v7, v8

    .line 13
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    .line 14
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getHeaderTag(Lcom/emanuelef/remote_capture/model/PayloadChunk;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    aput-object v7, v10, v3

    aput-object v9, v10, v8

    const/4 v7, 0x2

    aput-object v4, v10, v7

    const/4 v4, 0x3

    aput-object v5, v10, v4

    .line 15
    const-string v4, "#%d [%s] %s \u2014 %s"

    invoke-static {v1, v4, v10}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 16
    :cond_1
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->header:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " \u2014 "

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 17
    :cond_2
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->headerLine:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 18
    :goto_1
    iget-boolean v1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->isLast:Z

    if-eqz v1, :cond_4

    iget-object v1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->canBeExpanded()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 19
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->expandButton:Lcom/google/android/material/button/MaterialButton;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 20
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->expandButton:Lcom/google/android/material/button/MaterialButton;

    iget-object v2, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->adaptChunk:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->isExpanded()Z

    move-result v2

    if-eqz v2, :cond_3

    const/high16 v2, 0x43340000    # 180.0f

    goto :goto_2

    :cond_3
    const/4 v2, 0x0

    :goto_2
    invoke-virtual {v1, v2}, Landroid/view/View;->setRotation(F)V

    goto :goto_3

    .line 21
    :cond_4
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->expandButton:Lcom/google/android/material/button/MaterialButton;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 22
    :goto_3
    iget-object v1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->dump:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$Page;->getText()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {v1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 23
    iget-boolean p2, v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    if-eqz p2, :cond_5

    .line 24
    iget-object p2, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->dumpBox:Landroid/view/View;

    const v0, 0x7f0603d3

    invoke-virtual {p2, v0}, Landroid/view/View;->setBackgroundResource(I)V

    .line 25
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->dump:Landroid/widget/TextView;

    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    const v0, 0x7f0603d4

    invoke-static {p2, v0}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setTextColor(I)V

    return-void

    .line 26
    :cond_5
    iget-object p2, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->dumpBox:Landroid/view/View;

    const v0, 0x7f0603cb

    invoke-virtual {p2, v0}, Landroid/view/View;->setBackgroundResource(I)V

    .line 27
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->dump:Landroid/widget/TextView;

    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mContext:Landroid/content/Context;

    const v0, 0x7f0603cc

    invoke-static {p2, v0}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setTextColor(I)V

    return-void
.end method

.method public onChunkReassembled(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 12
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "DefaultLocale"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mMode:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 2
    .line 3
    sget-object v1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 4
    .line 5
    if-eq v0, v1, :cond_0

    .line 6
    .line 7
    iget-object v1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 8
    .line 9
    if-eq v0, v1, :cond_0

    .line 10
    .line 11
    goto/16 :goto_3

    .line 12
    .line 13
    :cond_0
    new-instance v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 14
    .line 15
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 18
    .line 19
    .line 20
    move-result v1

    .line 21
    invoke-direct {v0, p0, p1, v1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/model/PayloadChunk;I)V

    .line 22
    .line 23
    .line 24
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getItemCount()I

    .line 25
    .line 26
    .line 27
    move-result v1

    .line 28
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 29
    .line 30
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 31
    .line 32
    .line 33
    move-result v2

    .line 34
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->isHttp2Rst()Z

    .line 35
    .line 36
    .line 37
    move-result v3

    .line 38
    iget-boolean v4, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 39
    .line 40
    if-eqz v4, :cond_2

    .line 41
    .line 42
    if-eqz v3, :cond_1

    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_1
    if-nez v3, :cond_4

    .line 46
    .line 47
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 48
    .line 49
    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 50
    .line 51
    .line 52
    goto :goto_2

    .line 53
    :cond_2
    :goto_0
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->findMatchingRequest(Lcom/emanuelef/remote_capture/model/PayloadChunk;)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    if-eqz p1, :cond_4

    .line 58
    .line 59
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 60
    .line 61
    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 62
    .line 63
    .line 64
    move-result v4

    .line 65
    const/4 v5, 0x2

    .line 66
    const/4 v6, 0x0

    .line 67
    const/4 v7, 0x1

    .line 68
    const-string v8, "PayloadAdapter"

    .line 69
    .line 70
    if-nez v3, :cond_3

    .line 71
    .line 72
    add-int/lit8 v2, v4, 0x1

    .line 73
    .line 74
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->getAdapterPosition(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;)I

    .line 75
    .line 76
    .line 77
    move-result v1

    .line 78
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->getNumPages()I

    .line 79
    .line 80
    .line 81
    move-result v4

    .line 82
    add-int/2addr v1, v4

    .line 83
    iget v4, v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->incrId:I

    .line 84
    .line 85
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 86
    .line 87
    .line 88
    move-result-object v4

    .line 89
    iget v9, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->incrId:I

    .line 90
    .line 91
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 92
    .line 93
    .line 94
    move-result-object v9

    .line 95
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 96
    .line 97
    .line 98
    move-result-object v10

    .line 99
    const/4 v11, 0x3

    .line 100
    new-array v11, v11, [Ljava/lang/Object;

    .line 101
    .line 102
    aput-object v4, v11, v6

    .line 103
    .line 104
    aput-object v9, v11, v7

    .line 105
    .line 106
    aput-object v10, v11, v5

    .line 107
    .line 108
    const-string v4, "chunk #%d reply of #%d at %d"

    .line 109
    .line 110
    invoke-static {v4, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 111
    .line 112
    .line 113
    move-result-object v4

    .line 114
    invoke-static {v8, v4}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    .line 116
    .line 117
    goto :goto_1

    .line 118
    :cond_3
    iget v4, v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->incrId:I

    .line 119
    .line 120
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 121
    .line 122
    .line 123
    move-result-object v4

    .line 124
    iget v9, p1, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->incrId:I

    .line 125
    .line 126
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 127
    .line 128
    .line 129
    move-result-object v9

    .line 130
    new-array v5, v5, [Ljava/lang/Object;

    .line 131
    .line 132
    aput-object v4, v5, v6

    .line 133
    .line 134
    aput-object v9, v5, v7

    .line 135
    .line 136
    const-string v4, "chunk #%d reset of #%d"

    .line 137
    .line 138
    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 139
    .line 140
    .line 141
    move-result-object v4

    .line 142
    invoke-static {v8, v4}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    .line 144
    .line 145
    :goto_1
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mUnrepliedHttpReqs:Ljava/util/ArrayList;

    .line 146
    .line 147
    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 148
    .line 149
    .line 150
    :cond_4
    :goto_2
    if-nez v3, :cond_5

    .line 151
    .line 152
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 153
    .line 154
    invoke-virtual {p1, v2, v0}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 155
    .line 156
    .line 157
    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemInserted(I)V

    .line 158
    .line 159
    .line 160
    :cond_5
    :goto_3
    return-void
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
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    move-result-object p1

    return-object p1
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;
    .locals 3

    .line 2
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    const v0, 0x7f0d0091

    const/4 v1, 0x0

    invoke-virtual {p2, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    .line 3
    new-instance p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-direct {p2, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;-><init>(Landroid/view/View;)V

    .line 4
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->expandButton:Lcom/google/android/material/button/MaterialButton;

    new-instance v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;

    const/4 v2, 0x0

    invoke-direct {v0, p0, p2, v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 5
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->copybutton:Lcom/google/android/material/button/MaterialButton;

    new-instance v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;

    const/4 v2, 0x1

    invoke-direct {v0, p0, p2, v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 6
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->exportbutton:Lcom/google/android/material/button/MaterialButton;

    new-instance v0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;

    const/4 v2, 0x2

    invoke-direct {v0, p0, p2, v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 7
    iget-object p1, p2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;->exportbutton:Lcom/google/android/material/button/MaterialButton;

    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mSupportsFileDialog:Z

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/16 v1, 0x8

    :goto_0
    invoke-virtual {p1, v1}, Landroid/view/View;->setVisibility(I)V

    return-object p2
.end method

.method public setDisplayAsPrintableText(Z)V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mShowAsPrintable:Z

    .line 2
    .line 3
    if-eq v0, p1, :cond_1

    .line 4
    .line 5
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mShowAsPrintable:Z

    .line 6
    .line 7
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mChunks:Ljava/util/ArrayList;

    .line 8
    .line 9
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    const/4 v1, 0x0

    .line 14
    :goto_0
    if-ge v1, v0, :cond_0

    .line 15
    .line 16
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v2

    .line 20
    add-int/lit8 v1, v1, 0x1

    .line 21
    .line 22
    check-cast v2, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    .line 23
    .line 24
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;->collapse()V

    .line 25
    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 29
    .line 30
    .line 31
    :cond_1
    return-void
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

.method public setExportPayloadHandler(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->mExportHandler:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;

    .line 2
    .line 3
    return-void
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
.end method
