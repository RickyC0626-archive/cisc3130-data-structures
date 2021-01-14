package com.github.rickyc0626;

import java.util.*;

public class PriorityQueueExample
{
    PriorityQueue<String> pql = new PriorityQueue<>(new Comparator<String>()
    {
        @Override
        public int compare(String s1, String s2)
        {
            return s1.length() - s2.length();
        }
    });
    PriorityQueue<String> pqn = new PriorityQueue<>();

    Queue<String> q = new LinkedList<>();
    String[] names = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };


}
