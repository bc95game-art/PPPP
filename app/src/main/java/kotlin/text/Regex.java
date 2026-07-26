package kotlin.text;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class Regex implements Serializable {
    public final Pattern nativePattern;

    public Regex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        this.nativePattern = compile;
    }

    public static MatcherMatchResult find$default(Regex regex, String input) {
        regex.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = regex.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        if (!matcher.find(0)) {
            return null;
        }
        return new MatcherMatchResult(matcher, input);
    }

    public final MatcherMatchResult matchEntire(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "toString(...)");
        return pattern;
    }

    public Regex(String pattern, int i) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern, 66);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        this.nativePattern = compile;
    }
}
