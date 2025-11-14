package ua.opnu;

public class ContainsUtil {

    public static <T extends Comparable<? super T>, V extends T> boolean contains(T[] array, V element) {
        if (array == null) return false;
        if (element == null) return false;

        for (T item : array) {
            if (item != null && item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}