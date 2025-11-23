package ua.opnu;

public class GenericTwoTuple<T, V> {

    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst()  { return first; }
    public V getSecond() { return second; }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}