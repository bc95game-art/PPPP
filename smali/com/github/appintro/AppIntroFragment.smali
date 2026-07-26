.class public final Lcom/github/appintro/AppIntroFragment;
.super Lcom/github/appintro/AppIntroBaseFragment;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/github/appintro/AppIntroFragment$Companion;
    }
.end annotation


# static fields
.field public static final Companion:Lcom/github/appintro/AppIntroFragment$Companion;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/github/appintro/AppIntroFragment$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/github/appintro/AppIntroFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/github/appintro/AppIntroBaseFragment;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
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

.method public static final createInstance()Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 1
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance()Lcom/github/appintro/AppIntroFragment;

    move-result-object v0

    return-object v0
.end method

.method public static final createInstance(Lcom/github/appintro/model/SliderPage;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 2
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Lcom/github/appintro/model/SliderPage;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 3
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 4
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 5
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1, p2}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 6
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;III)Lcom/github/appintro/AppIntroFragment;
    .locals 6

    .line 7
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;III)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)Lcom/github/appintro/AppIntroFragment;
    .locals 7

    .line 8
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 8

    .line 9
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 9

    .line 10
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-virtual/range {v0 .. v8}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 10

    .line 11
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    invoke-virtual/range {v0 .. v9}, Lcom/github/appintro/AppIntroFragment$Companion;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance()Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 1
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance()Lcom/github/appintro/AppIntroFragment;

    move-result-object v0

    return-object v0
.end method

.method public static final newInstance(Lcom/github/appintro/model/SliderPage;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 2
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Lcom/github/appintro/model/SliderPage;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 3
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 4
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 5
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1, p2}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;I)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)Lcom/github/appintro/AppIntroFragment;
    .locals 1

    .line 6
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;III)Lcom/github/appintro/AppIntroFragment;
    .locals 6

    .line 7
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;III)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)Lcom/github/appintro/AppIntroFragment;
    .locals 7

    .line 8
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 8

    .line 9
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 9

    .line 10
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    move/from16 v8, p7

    invoke-virtual/range {v0 .. v8}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method

.method public static final newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIIII)Lcom/github/appintro/AppIntroFragment;
    .locals 10

    .line 11
    sget-object v0, Lcom/github/appintro/AppIntroFragment;->Companion:Lcom/github/appintro/AppIntroFragment$Companion;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    invoke-virtual/range {v0 .. v9}, Lcom/github/appintro/AppIntroFragment$Companion;->newInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIIIIII)Lcom/github/appintro/AppIntroFragment;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public getLayoutId()I
    .locals 1

    .line 1
    sget v0, Lcom/github/appintro/R$layout;->appintro_fragment_intro:I

    .line 2
    .line 3
    return v0
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
