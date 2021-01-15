import java.util.*;

public class Question8<E>
{
    public <E> Set<E> f(Set<E> a, Set<E> b)
    {
        Set<E> c = new TreeSet<>();
        for(E x : a)
        {
            if(!b.contains(x)) c.add(x);
        }
        return c;
    }
}
