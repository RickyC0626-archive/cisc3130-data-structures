import java.util.*;

public class Main
{
    public boolean isSorted(List c)
    {
        if(c.size() < 2) return true;
        ListIterator iit = c.listIterator(),
                     jit = c.listIterator();

        while(iit.hasNext() && jit.hasNext())
        {
            if(iit.next().compareTo(jit.next()) > 0) return false;
        }
        return true;
    }

    public boolean isReverse(List c, List cc)
    {
        ListIterator ait = c.listIterator(),
                     bit = cc.listIterator(cc.size());

        while(ait.hasNext() && bit.hasPrevious())
        {
            if(ait.next().equals(bit.previous())) return false;
        }
        return true;
    }

    public boolean isEveryOther(List abc, List ac)
    {
        if(Math.ceil(abc.size() / 2.0) != ac.size()) return false;

        ListIterator ait = abc.listIterator(),
                     bit = ac.listIterator();

        while(ait.hasNext() && bit.hasNext())
        {
            if(!ait.next().equals(bit.next())) return false;
            if(ait.hasNext()) ait.next();
        }
        return true;
    }

    public static void main(String[] args)
    {

    }
}
