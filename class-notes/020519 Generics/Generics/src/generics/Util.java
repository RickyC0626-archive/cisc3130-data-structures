package generics;

public class Util
{
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2)
    {
        return p1.equals(p2);
    }

    Pair<Integer, String> p1 = new OrderedPair<>(1, "Apple"),
                          p2 = new OrderedPair<>(2, "Orange");
    boolean same = Util.compare(p1, p2);
    boolean same2= Util.<Integer, String>compare(p1, p2);
}
