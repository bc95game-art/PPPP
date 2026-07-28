.class public final Landroidx/lifecycle/viewmodel/MutableCreationExtras;
.super Landroidx/lifecycle/viewmodel/CreationExtras;
.source "SourceFile"


# direct methods
.method public synthetic constructor <init>(I)V
    .locals 0

    .line 6
    sget-object p1, Landroidx/lifecycle/viewmodel/CreationExtras$Empty;->INSTANCE:Landroidx/lifecycle/viewmodel/CreationExtras$Empty;

    .line 7
    invoke-direct {p0, p1}, Landroidx/lifecycle/viewmodel/MutableCreationExtras;-><init>(Landroidx/lifecycle/viewmodel/CreationExtras;)V

    return-void
.end method

.method public constructor <init>(Landroidx/lifecycle/viewmodel/CreationExtras;)V
    .locals 1

    const-string v0, "initialExtras"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    iget-object p1, p1, Landroidx/lifecycle/viewmodel/CreationExtras;->extras:Ljava/util/LinkedHashMap;

    .line 2
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    invoke-direct {p0}, Landroidx/lifecycle/viewmodel/CreationExtras;-><init>()V

    .line 4
    iget-object v0, p0, Landroidx/lifecycle/viewmodel/CreationExtras;->extras:Ljava/util/LinkedHashMap;

    .line 5
    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    return-void
.end method


# virtual methods
.method public final get(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/lifecycle/viewmodel/CreationExtras;->extras:Ljava/util/LinkedHashMap;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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
