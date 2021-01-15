package generics;

import java.util.*;

public class OrderedPair<E, F> implements Pair<E, F>
{
    private E key;
    private F value;

    public OrderedPair(E key, F value)
    {
        this.key = key;
        this.value = value;
    }

    public E getKey() { return key; }
    public F getValue() { return value; }

    Pair<String, Integer> p1 = new OrderedPair<>("Key", 0);
    Pair<String, String> p2 = new OrderedPair<>("Key", "Value");
    Pair<String, Box<Integer>> p3 = new OrderedPair<>("Numbers", new Box<>(5));
    Box<String> stringBox = new Box<>();
    Box rawBox = stringBox;
}
