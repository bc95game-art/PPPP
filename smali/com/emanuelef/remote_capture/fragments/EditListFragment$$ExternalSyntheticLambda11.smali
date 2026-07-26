.class public final synthetic Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/views/RuleAddDialog$RuleAddListener;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

.field public final synthetic f$1:[Ljava/lang/String;

.field public final synthetic f$2:[Ljava/lang/String;

.field public final synthetic f$3:Landroid/content/Context;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/EditListFragment;[Ljava/lang/String;[Ljava/lang/String;Landroid/content/Context;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$1:[Ljava/lang/String;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$2:[Ljava/lang/String;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$3:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public final addRule(Ljava/lang/String;Landroid/widget/TextView;)Z
    .locals 6

    .line 1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$2:[Ljava/lang/String;

    iget-object v3, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$3:Landroid/content/Context;

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda11;->f$1:[Ljava/lang/String;

    move-object v4, p1

    move-object v5, p2

    invoke-static/range {v0 .. v5}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$W1lkEBLSgplRT7waqu8CGzEeClg(Lcom/emanuelef/remote_capture/fragments/EditListFragment;[Ljava/lang/String;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)Z

    move-result p1

    return p1
.end method
