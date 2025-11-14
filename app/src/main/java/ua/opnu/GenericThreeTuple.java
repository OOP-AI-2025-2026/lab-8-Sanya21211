package ua.opnu;

public class GenericThreeTuple<T, V, S> {

    private final GenericTwoTuple<T, V> pair;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.pair = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    public T getFirst()  { return pair.getFirst(); }
    public V getSecond() { return pair.getSecond(); }
    public S getThree()  { return three; }

    public GenericTwoTuple<T, V> getPair() { return pair; }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + "," + three + ")";
    }
}