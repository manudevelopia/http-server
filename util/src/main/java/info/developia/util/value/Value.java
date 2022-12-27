package info.developia.util.value;

public class Value {
    public static <T> T valueOr(T value, T or) {
        return value != null ? value : or;
    }
}
