package ua.opnu;
import java.util.Arrays;
import java.util.function.Predicate;

public class FilterUtil {

    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        Object[] temp = new Object[input.length];
        int counter = 0;

        for (T element : input) {
            if (predicate.test(element)) {
                temp[counter++] = element;
            }
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) java.util.Arrays.copyOf(
                temp,
                counter,
                (Class<? extends T[]>) input.getClass()
        );

        return result;
    }

}