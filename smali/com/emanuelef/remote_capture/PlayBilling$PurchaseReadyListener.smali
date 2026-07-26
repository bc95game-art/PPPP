.class public interface abstract Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/PlayBilling;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PurchaseReadyListener"
.end annotation


# virtual methods
.method public abstract onPurchasesError()V
.end method

.method public abstract onPurchasesReady()V
.end method

.method public abstract onSKUStateUpdate(Ljava/lang/String;I)V
.end method
