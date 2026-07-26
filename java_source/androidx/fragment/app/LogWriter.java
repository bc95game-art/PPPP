package androidx.fragment.app;

import android.util.Log;
import com.google.gson.internal.Streams$AppendableWriter$CurrentWrite;
import java.io.Writer;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class LogWriter extends Writer {
    public final /* synthetic */ int $r8$classId;
    public final StringBuilder mBuilder;
    public final CharSequence mTag;

    public LogWriter() {
        this.$r8$classId = 0;
        this.mBuilder = new StringBuilder(128);
        this.mTag = "FragmentManager";
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        switch (this.$r8$classId) {
            case 1:
                this.mBuilder.append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.$r8$classId) {
            case 0:
                flushBuilder();
                return;
            default:
                return;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        switch (this.$r8$classId) {
            case 0:
                flushBuilder();
                return;
            default:
                return;
        }
    }

    public void flushBuilder() {
        StringBuilder sb = this.mBuilder;
        if (sb.length() > 0) {
            Log.d((String) this.mTag, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) {
        switch (this.$r8$classId) {
            case 0:
                for (int i3 = 0; i3 < i2; i3++) {
                    char c = cArr[i + i3];
                    if (c == '\n') {
                        flushBuilder();
                    } else {
                        this.mBuilder.append(c);
                    }
                }
                return;
            default:
                Streams$AppendableWriter$CurrentWrite streams$AppendableWriter$CurrentWrite = (Streams$AppendableWriter$CurrentWrite) this.mTag;
                streams$AppendableWriter$CurrentWrite.chars = cArr;
                streams$AppendableWriter$CurrentWrite.cachedString = null;
                this.mBuilder.append((CharSequence) streams$AppendableWriter$CurrentWrite, i, i2 + i);
                return;
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo644append(CharSequence charSequence) {
        switch (this.$r8$classId) {
            case 1:
                this.mBuilder.append(charSequence);
                return this;
            default:
                return super.append(charSequence);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        switch (this.$r8$classId) {
            case 1:
                this.mBuilder.append(charSequence, i, i2);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.CharSequence, java.lang.Object] */
    public LogWriter(StringBuilder sb) {
        this.$r8$classId = 1;
        this.mTag = new Object();
        this.mBuilder = sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable mo645append(CharSequence charSequence, int i, int i2) {
        switch (this.$r8$classId) {
            case 1:
                this.mBuilder.append(charSequence, i, i2);
                return this;
            default:
                return super.append(charSequence, i, i2);
        }
    }

    @Override // java.io.Writer
    public void write(int i) {
        switch (this.$r8$classId) {
            case 1:
                this.mBuilder.append((char) i);
                return;
            default:
                super.write(i);
                return;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        switch (this.$r8$classId) {
            case 1:
                Objects.requireNonNull(str);
                this.mBuilder.append((CharSequence) str, i, i2 + i);
                return;
            default:
                super.write(str, i, i2);
                return;
        }
    }

    private final void close$com$google$gson$internal$Streams$AppendableWriter() {
    }

    private final void flush$com$google$gson$internal$Streams$AppendableWriter() {
    }
}
