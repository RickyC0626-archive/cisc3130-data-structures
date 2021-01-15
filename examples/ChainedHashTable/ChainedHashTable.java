import java.util.*;

public class ChainedHashTable<E>
{
    protected ArrayList<LinkedList<E>> table;

    public ChainedHashTable(int size)
    {
        table = new ArrayList<LinkedList<E>>(size);

        for(int i = 0; i < size; i++)
        {
            table.add(new LinkedList<E>());
        }
    }

    public boolean add(E key)
    {
        int index = key.hashCode() % table.size();

        if(table.get(index).contains(key)) return false;

        table.get(index).add(key);
        return true;
    }

    public boolean remove(E key)
    {
        int index = key.hashCode() % table.size();

        return table.get(index).remove(key);
    }

    public boolean contains(E key)
    {
        int index = key.hashCode() % table.size();

        return table.get(index).contains(key);
    }
}
