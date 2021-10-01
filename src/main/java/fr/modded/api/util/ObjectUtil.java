package fr.modded.api.util;

public class ObjectUtil {
    public static <T> T checkNotNull(final T arg, final String text) {
        if (arg == null)
            throw new NullPointerException(text);
        return arg;
    }

    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
