package com.github.rickyc0626;

import java.util.*;

public class QueueMain
{
    public static void main(String[] args)
    {
        Queue<Integer> qa = new LinkedList<>();
        Queue<String> qb = new PriorityQueue<>();

        qa.add(1);
        qa.offer(2);

        for(int i = 3; i < 6; i++)
        {
            qa.offer(i);
        }

        Deque<Integer> stk = new LinkedList<>();

        for(int i = 1; i < 6; i++)
        {
            stk.push(i);
        }
        System.out.println(qa.element());
        System.out.println(qa.peek());
        System.out.println(qa.poll());

        System.out.println("Palindome: " + isPalindrome("racecar"));
        System.out.println(qa);
        mirror(qa);
        System.out.println(qa);
    }

    public static <E> void nToFront(Queue<E> q, int n)
    {
        Queue<E> aux = new LinkedList<>();

        for(int i = 0; i < (n - 1); i++)
        {
            aux.offer(q.poll());
            aux.add(q.remove());
        }
        E nth = q.poll();
        while(!q.isEmpty())
        {
            aux.offer(q.poll());
        }
        q.offer(nth);
        while(!aux.isEmpty())
        {
            q.offer(aux.poll());
        }
    }

    public static <E> void cut(Queue<E> q, E e, int pos)
    {
        Queue<E> aux = new LinkedList<>();

        while(!q.isEmpty())
        {
            aux.offer(q.poll());
        }
        for(int i = 0; i < pos; i++)
        {
            q.offer(aux.poll());
        }
        q.offer(e);
        while(!aux.isEmpty())
        {
            q.offer(aux.poll());
        }
    }

    public static boolean isPalindrome(String str)
    {
        Queue<Character> q = new LinkedList<>();
        Deque<Character> stk = new LinkedList<>();

        for(int i = 0; i < str.length(); i++)
        {
            q.offer(str.charAt(i));
            stk.push(str.charAt(i));
        }

        for(int i = 0; i < (str.length()/2) + 1; i++)
        {
            if(!stk.pop().equals(q.poll())) return false;
        }
        return true;
    }

    public static <E> void mirror(Queue<E> q)
    {
        Deque<E> stk = new LinkedList<>();

        int size = q.size();
        for(int i = 0; i < size; i++)
        {
            E e = q.poll();
            stk.push(e);
            q.offer(e);
        }

        while(!stk.isEmpty())
        {
            q.offer(stk.pop());
        }
    }
}
