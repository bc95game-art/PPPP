.class public final Landroidx/navigation/NavType$EnumType;
.super Landroidx/navigation/NavType$SerializableType;
.source "SourceFile"


# instance fields
.field public final type:Ljava/lang/Class;


# direct methods
.method public constructor <init>(Ljava/lang/Class;)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-direct {p0, v0, p1}, Landroidx/navigation/NavType$SerializableType;-><init>(ILjava/lang/Class;)V

    .line 3
    .line 4
    .line 5
    invoke-virtual {p1}, Ljava/lang/Class;->isEnum()Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    iput-object p1, p0, Landroidx/navigation/NavType$EnumType;->type:Ljava/lang/Class;

    .line 12
    .line 13
    return-void

    .line 14
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 15
    .line 16
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 17
    .line 18
    .line 19
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    const-string p1, " is not an Enum type."

    .line 23
    .line 24
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 32
    .line 33
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 34
    .line 35
    .line 36
    move-result-object p1

    .line 37
    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 38
    .line 39
    .line 40
    throw v0
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
.method public final getName()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/navigation/NavType$EnumType;->type:Ljava/lang/Class;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public final bridge synthetic parseValue(Ljava/lang/String;)Ljava/io/Serializable;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Landroidx/navigation/NavType$EnumType;->parseValue(Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p1

    return-object p1
.end method

.method public final parseValue(Ljava/lang/String;)Ljava/lang/Enum;
    .locals 7

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    iget-object v0, p0, Landroidx/navigation/NavType$EnumType;->type:Ljava/lang/Class;

    invoke-virtual {v0}, Ljava/lang/Class;->getEnumConstants()[Ljava/lang/Object;

    move-result-object v1

    const-string v2, "getEnumConstants(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    array-length v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v2, :cond_2

    aget-object v5, v1, v4

    move-object v6, v5

    check-cast v6, Ljava/lang/Enum;

    .line 5
    invoke-virtual {v6}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_0

    const/4 v6, 0x0

    goto :goto_1

    .line 6
    :cond_0
    invoke-virtual {v6, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    :goto_1
    if-eqz v6, :cond_1

    goto :goto_2

    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_2
    const/4 v5, 0x0

    .line 7
    :goto_2
    check-cast v5, Ljava/lang/Enum;

    if-eqz v5, :cond_3

    return-object v5

    .line 8
    :cond_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    .line 9
    const-string v2, "Enum value "

    const-string v3, " not found for type "

    .line 10
    invoke-static {v2, p1, v3}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    .line 11
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v0, 0x2e

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 12
    invoke-direct {v1, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public final bridge synthetic parseValue(Ljava/lang/String;)Ljava/lang/Object;
    .locals 0

    .line 2
    invoke-virtual {p0, p1}, Landroidx/navigation/NavType$EnumType;->parseValue(Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p1

    return-object p1
.end method
