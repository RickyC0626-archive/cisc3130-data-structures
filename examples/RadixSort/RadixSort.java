package com.github.rickyc0626;

import java.util.*;

public class RadixSort
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        list.add(37);
        list.add(61);
        list.add(84);
        list.add(22);
        list.add(16);
        list.add(73);
        list.add(89);
        list.add(58);
        System.out.println("Before Sort: " + list);
        radixSort(list, 2);
        System.out.println("After Sort: " + list);
    }

    public static <Integer> void radixSort(List<Integer> lst, int d)
    {
        Queue<Integer>[] bins = new LinkedList[10];

        for(int i = 0; i < 10; i++)
        {
            bins[i] = new LinkedList<Integer>();
        }

        ListIterator<Integer> it = lst.listIterator();

        // loop over digits
        for(int p = 0; p < d; p++)
        {
            // distribute
            while(it.hasNext())
            {
                Integer x = it.next();
                String xstr = x.toString();
                int digit = Character.getNumericValue(xstr.charAt(xstr.length() - p - 1));
                bins[digit].offer(x);
            }

            // collect
            it = lst.listIterator();
            for(int i = 0; i < bins.length; i++)
            {
                while(!bins[i].isEmpty())
                {
                    it.next();
                    it.set(bins[i].remove());
                }
            }
        }
    }
}
