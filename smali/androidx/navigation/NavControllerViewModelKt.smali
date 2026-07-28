.class public abstract Landroidx/navigation/NavControllerViewModelKt;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final FACTORY:Landroidx/viewpager2/widget/FakeDrag;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Landroidx/collection/internal/LruHashMap;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-direct {v0, v1}, Landroidx/collection/internal/LruHashMap;-><init>(I)V

    .line 5
    .line 6
    .line 7
    new-instance v1, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;

    .line 8
    .line 9
    const/4 v2, 0x3

    .line 10
    invoke-direct {v1, v2}, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;-><init>(I)V

    .line 11
    .line 12
    .line 13
    const-class v2, Landroidx/navigation/NavControllerViewModel;

    .line 14
    .line 15
    invoke-static {v2}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/jvm/internal/ClassReference;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    invoke-virtual {v0, v2, v1}, Landroidx/collection/internal/LruHashMap;->addInitializer(Lkotlin/jvm/internal/ClassReference;Lkotlin/jvm/functions/Function1;)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {v0}, Landroidx/collection/internal/LruHashMap;->build()Landroidx/viewpager2/widget/FakeDrag;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    sput-object v0, Landroidx/navigation/NavControllerViewModelKt;->FACTORY:Landroidx/viewpager2/widget/FakeDrag;

    .line 27
    .line 28
    return-void
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
