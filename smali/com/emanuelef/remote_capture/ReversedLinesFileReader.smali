.class public Lcom/emanuelef/remote_capture/ReversedLinesFileReader;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;
    }
.end annotation


# instance fields
.field private final avoidNewlineSplitBufferSize:I

.field private final blockSize:I

.field private final byteDecrement:I

.field private currentFilePart:Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

.field private final encoding:Ljava/nio/charset/Charset;

.field private final newLineSequences:[[B

.field private final randomAccessFile:Ljava/io/RandomAccessFile;

.field private final totalBlockCount:J

.field private final totalByteLength:J

.field private trailingNewlineOfFileSkipped:Z


# direct methods
.method public static bridge synthetic -$$Nest$fgetavoidNewlineSplitBufferSize(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I
    .locals 0

    .line 1
    iget p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->avoidNewlineSplitBufferSize:I

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetblockSize(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I
    .locals 0

    .line 1
    iget p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->blockSize:I

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetbyteDecrement(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I
    .locals 0

    .line 1
    iget p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->byteDecrement:I

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetencoding(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/nio/charset/Charset;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->encoding:Ljava/nio/charset/Charset;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetnewLineSequences(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)[[B
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->newLineSequences:[[B

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetrandomAccessFile(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/io/RandomAccessFile;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->randomAccessFile:Ljava/io/RandomAccessFile;

    return-object p0
.end method

.method public constructor <init>(Ljava/io/File;)V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    const/16 v0, 0x1000

    .line 1
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;-><init>(Ljava/io/File;ILjava/nio/charset/Charset;)V

    return-void
.end method

.method public constructor <init>(Ljava/io/File;ILjava/nio/charset/Charset;)V
    .locals 7

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 4
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->trailingNewlineOfFileSkipped:Z

    .line 5
    iput p2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->blockSize:I

    .line 6
    iput-object p3, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->encoding:Ljava/nio/charset/Charset;

    .line 7
    new-instance v1, Ljava/io/RandomAccessFile;

    const-string v2, "r"

    invoke-direct {v1, p1, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->randomAccessFile:Ljava/io/RandomAccessFile;

    .line 8
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->totalByteLength:J

    int-to-long v3, p2

    .line 9
    rem-long v5, v1, v3

    long-to-int p1, v5

    if-lez p1, :cond_0

    .line 10
    div-long/2addr v1, v3

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->totalBlockCount:J

    goto :goto_0

    .line 11
    :cond_0
    div-long v3, v1, v3

    iput-wide v3, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->totalBlockCount:J

    const-wide/16 v3, 0x0

    cmp-long v5, v1, v3

    if-lez v5, :cond_1

    goto :goto_1

    :cond_1
    :goto_0
    move p2, p1

    .line 12
    :goto_1
    new-instance p1, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    iget-wide v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->totalBlockCount:J

    invoke-direct {p1, p0, v1, v2, p2}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;-><init>(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;JI)V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->currentFilePart:Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 13
    invoke-virtual {p3}, Ljava/nio/charset/Charset;->newEncoder()Ljava/nio/charset/CharsetEncoder;

    move-result-object p1

    .line 14
    invoke-virtual {p1}, Ljava/nio/charset/CharsetEncoder;->maxBytesPerChar()F

    move-result p1

    const/high16 p2, 0x3f800000    # 1.0f

    const/4 v1, 0x2

    const/4 v2, 0x1

    cmpl-float p1, p1, p2

    if-nez p1, :cond_2

    .line 15
    iput v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->byteDecrement:I

    goto :goto_3

    .line 16
    :cond_2
    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    if-ne p3, p1, :cond_3

    .line 17
    iput v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->byteDecrement:I

    goto :goto_3

    .line 18
    :cond_3
    const-string p1, "Shift_JIS"

    invoke-static {p1}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object p1

    if-ne p3, p1, :cond_4

    .line 19
    iput v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->byteDecrement:I

    goto :goto_3

    .line 20
    :cond_4
    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_16BE:Ljava/nio/charset/Charset;

    if-eq p3, p1, :cond_7

    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_16LE:Ljava/nio/charset/Charset;

    if-ne p3, p1, :cond_5

    goto :goto_2

    .line 21
    :cond_5
    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_16:Ljava/nio/charset/Charset;

    if-ne p3, p1, :cond_6

    .line 22
    new-instance p1, Ljava/io/UnsupportedEncodingException;

    const-string p2, "For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)"

    invoke-direct {p1, p2}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 23
    :cond_6
    new-instance p1, Ljava/io/UnsupportedEncodingException;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string v0, "Encoding "

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p3, " is not supported yet (feel free to submit a patch)"

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/io/UnsupportedEncodingException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 24
    :cond_7
    :goto_2
    iput v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->byteDecrement:I

    .line 25
    :goto_3
    const-string p1, "\r\n"

    invoke-virtual {p1, p3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    const-string p2, "\n"

    invoke-virtual {p2, p3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p2

    const-string v3, "\r"

    invoke-virtual {v3, p3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p3

    const/4 v3, 0x3

    new-array v3, v3, [[B

    aput-object p1, v3, v0

    aput-object p2, v3, v2

    aput-object p3, v3, v1

    iput-object v3, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->newLineSequences:[[B

    .line 26
    aget-object p1, v3, v0

    array-length p1, p1

    iput p1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->avoidNewlineSplitBufferSize:I

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/nio/charset/Charset;)V
    .locals 1

    const/16 v0, 0x1000

    .line 2
    invoke-direct {p0, p1, v0, p2}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;-><init>(Ljava/io/File;ILjava/nio/charset/Charset;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->randomAccessFile:Ljava/io/RandomAccessFile;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V

    .line 4
    .line 5
    .line 6
    return-void
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

.method public readLine()Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->currentFilePart:Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->-$$Nest$mreadLine(Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    :goto_0
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->currentFilePart:Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 10
    .line 11
    invoke-static {v1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->-$$Nest$mrollOver(Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;)Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    iput-object v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->currentFilePart:Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 16
    .line 17
    if-eqz v1, :cond_0

    .line 18
    .line 19
    invoke-static {v1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->-$$Nest$mreadLine(Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    goto :goto_0

    .line 24
    :cond_0
    const-string v1, ""

    .line 25
    .line 26
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    if-eqz v1, :cond_1

    .line 31
    .line 32
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->trailingNewlineOfFileSkipped:Z

    .line 33
    .line 34
    if-nez v1, :cond_1

    .line 35
    .line 36
    const/4 v0, 0x1

    .line 37
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->trailingNewlineOfFileSkipped:Z

    .line 38
    .line 39
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->readLine()Ljava/lang/String;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    :cond_1
    return-object v0
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
