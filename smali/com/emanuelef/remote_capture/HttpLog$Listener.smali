.class public interface abstract Lcom/emanuelef/remote_capture/HttpLog$Listener;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/HttpLog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract onHttpRequestAdded(I)V
.end method

.method public abstract onHttpRequestUpdated(I)V
.end method

.method public abstract onHttpRequestsClear()V
.end method
