.class public interface abstract Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$ExportPayloadHandler;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;
    }
.end annotation


# virtual methods
.method public abstract addConnUpdateListener(Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;)V
.end method

.method public abstract removeConnUpdateListener(Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;)V
.end method

.method public abstract updateMenuVisibility()V
.end method
