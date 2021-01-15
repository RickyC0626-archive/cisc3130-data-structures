package com.github.rickyc0626;

import java.util.*;

public class SpellCheck
{
    private Set<String> dict;

    public SpellCheck(List<String> goodwords)
    {
        // constructor
        dict = new TreeSet<>(goodwords);

        /* other methods
        dict = new TreeSet<>();

        // add all
        dict.addAll(goodwords);

        // loop
        for(String w : goodwords) dict.add(w);
         */
    }

    public boolean checkDocument(List<String> words)
    {
        Scanner reader = new Scanner(System.in);

        for(String w : words)
        {
            if(!dict.contains(w))
            {
                System.out.println(w + " is incorrect. Add to dictionary? (Y/N)");
                String c = reader.next();

                if(c.equals("y") || c.equals("Y")) dict.add(w);
                else return false;
            }
        }
        return true;
    }

    public static Set<Integer> sieve(int n)
    {
        // initialize set with integers between
        // 2 and n (inclusive)
        Set<Integer> s = new TreeSet<>();

        for(int i = 2; i <= n; i++)
        {
            s.add(i);
        }

        // iterate over all integers 2 to sqrt n
        // if the integer is in the set,
        // remove all its multiples from the set
        for(int i = 2; i * i <= n; i++)
        {
            if(!s.contains(i)) continue;
            for(int j = i + i; j <= n; j += i)
            {
                s.remove(j);
            }
        }

        // print out all primes
        System.out.println("The primes between 2 and " + n + " are: " + s.toString());

        return s;
    }

    public static <E> void removeDuplicates(List<E> l)
    {
        Set<E> seen = new TreeSet<>();

        ListIterator<E> it = l.listIterator();

        while(it.hasNext())
        {
            E e = it.next();

            if(seen.contains(e))
            {
                it.remove();
            }
            else seen.add(e);
        }
    }

    public static <E> void removeDuplicatesAndSort(List<E> l)
    {
        Set<E> s = new TreeSet<>(l);
        l.clear();
        l.addAll(s);
    }

    public static <E> E smallestInBoth(Set<E> a, Set<E> b)
    {
        E min = null;

        for(E e : a)
        {
            if(b.contains(e))
            {
                if(min == null || min.compareTo(e) > 0) min = e;
            }
        }
        return min;
    }

    public static <E> E smallestInBoth(TreeSet<E> a, TreeSet<E> b)
    {
        Iterator ait = a.iterator(),
                 bit = b.iterator();
        if(a.isEmpty() || b.isEmpty()) return null;

        E aval = (E) ait.next(), bval = (E) bit.next();

        do
        {
            if(aval.equals(bval)) return aval;
            if(aval.compareTo(bval) < 0) ait.next();
            else bval = (E) bit.next();
        } while(ait.hasNext() && bit.hasNext());

        return null;
    }

    public static void main(String[] args)
    {
        Set<Integer> s = new TreeSet<>();
        s = sieve(50);
    }
}
