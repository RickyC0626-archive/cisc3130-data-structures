package com.github.rickyc0626;

import java.util.*;

public class HashTable<E>
{
    protected ArrayList<E> table;

    protected E EMPTY_CONST, DEL_CONST;

    public HashTable(int size)
    {
        table = new ArrayList<E>(size);
        EMPTY_CONST = new E();
        DEL_CONST = new E();

        for(int i = 0; i < size; i++)
        {
            table.add(EMPTY_CONST);
        }
    }

    // return the index of where the key is or where it should be
    // If the table is full and the key is not there, return -1
    protected int probe(E key)
    {
        int index = key.hashCode() % table.size(), i = index, dindex = -1;

        do
        {
            if(table.get(i).equals(DEL_CONST) && dindex < 0) dindex = i;
            else if(table.get(i).equals(key))
            {
                table.set(dindex, key);
                table.set(i, DEL_CONST);
                return dindex;
            }
            else if(table.get(i).equals(EMPTY_CONST)) return dindex;

            i = (i + 1) % table.size();

        } while(i != index);

        return -1;
    }

    public boolean contains(E key)
    {
        int index = probe(key);
        if(index == -1 || table.get(index).equals(EMPTY_CONST)) return false;

        return index != -1 && !table.get(index).equals(EMPTY_CONST) && !table.get(index).equals(DEL_CONST);
    }

    public boolean add(E key)
    {
        int index = probe(key);

        if(index == -1) throw new StackOverflowError();
        if(!table.get(index).equals(EMPTY_CONST) || !table.get(index).equals(DEL_CONST)) return false;
        else table.set(index, key);

        return true;
    }

    public boolean remove(E key)
    {
        int index = probe(key);

        if(index < 0 || !table.get(index).equals(key)) return false;
        table.set(index, DEL_CONST);

        return true;
    }
}
