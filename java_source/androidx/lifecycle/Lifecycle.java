package androidx.lifecycle;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesList;
/* loaded from: classes.dex */
public abstract class Lifecycle {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public final class Event extends Enum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Event[] $VALUES;
        public static final Companion Companion = new Object();
        public static final Event ON_ANY;
        public static final Event ON_CREATE;
        public static final Event ON_DESTROY;
        public static final Event ON_PAUSE;
        public static final Event ON_RESUME;
        public static final Event ON_START;
        public static final Event ON_STOP;

        /* loaded from: classes.dex */
        public final class Companion {
        }

        /* loaded from: classes.dex */
        public abstract /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.lifecycle.Lifecycle$Event$Companion] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.lifecycle.Lifecycle$Event] */
        static {
            ?? r0 = new Enum("ON_CREATE", 0);
            ON_CREATE = r0;
            ?? r1 = new Enum("ON_START", 1);
            ON_START = r1;
            ?? r3 = new Enum("ON_RESUME", 2);
            ON_RESUME = r3;
            ?? r5 = new Enum("ON_PAUSE", 3);
            ON_PAUSE = r5;
            ?? r7 = new Enum("ON_STOP", 4);
            ON_STOP = r7;
            ?? r9 = new Enum("ON_DESTROY", 5);
            ON_DESTROY = r9;
            ?? r11 = new Enum("ON_ANY", 6);
            ON_ANY = r11;
            Event[] eventArr = {r0, r1, r3, r5, r7, r9, r11};
            $VALUES = eventArr;
            $ENTRIES = new EnumEntriesList(eventArr);
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new RuntimeException();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public final class State extends Enum {
        public static final /* synthetic */ State[] $VALUES;
        public static final State CREATED;
        public static final State DESTROYED;
        public static final State INITIALIZED;
        public static final State RESUMED;
        public static final State STARTED;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v1, types: [androidx.lifecycle.Lifecycle$State, java.lang.Enum] */
        static {
            ?? r0 = new Enum("DESTROYED", 0);
            DESTROYED = r0;
            ?? r1 = new Enum("INITIALIZED", 1);
            INITIALIZED = r1;
            ?? r3 = new Enum("CREATED", 2);
            CREATED = r3;
            ?? r5 = new Enum("STARTED", 3);
            STARTED = r5;
            ?? r7 = new Enum("RESUMED", 4);
            RESUMED = r7;
            $VALUES = new State[]{r0, r1, r3, r5, r7};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    public abstract void removeObserver(LifecycleObserver lifecycleObserver);
}
