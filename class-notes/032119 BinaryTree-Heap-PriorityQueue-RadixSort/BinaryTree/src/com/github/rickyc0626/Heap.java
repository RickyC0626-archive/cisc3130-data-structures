package com.github.rickyc0626;

import java.util.*;

public class Heap<E extends Comparable<? super E>>
{
    protected ArrayList<E> arr;

    public Heap() { arr = new ArrayList<>(); }

    protected int parentIndex(int i) { return (int) Math.floor((i-1)/2); }

    protected void heapifyUp()
    {
        int i = arr.size() - 1;
        while(arr.get(i).compareTo(arr.get(parentIndex(i))) > 0)
        {
            E temp = arr.get(i);
            arr.set(i, arr.get(parentIndex(i)));
            arr.set(parentIndex(i), temp);
            i = parentIndex(i);
        }
    }

    public void heapifyDown(int i, int end)
    {
        int leftIndex = i * 2 + 1,
            rightIndex = i * 2 + 2;
        boolean hasLeftChild = leftIndex < end,
                hasRightChild = rightIndex < end;
        E leftVal = hasLeftChild ? arr.get(leftIndex) : null,
          rightVal = hasRightChild ? arr.get(rightIndex) : null,
          currVal = arr.get(i);

        if(currVal.compareTo(leftVal) < 0 ||
           currVal.compareTo(rightVal) < 0)
        {
            int check = leftVal.compareTo(rightVal);
            int swapTo = check < 0 ? rightIndex : leftIndex;
            E swapVal = check < 0 ? rightVal : leftVal;

            arr.set(swapTo, currVal);
            arr.set(i, swapVal);
            heapifyDown(0, swapTo);
        }
    }

    public void buildHeap()
    {
        for(int i = ((arr.size() - 1)/2); i >= 0; i--)
        {
            heapifyDown(0, i);
        }
    }

    public void heapSort()
    {
        buildHeap();
        for(int i = arr.size() - 1; i > 0; i--)
        {
            E temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            heapifyDown(0, i);
        }
    }

    public void add(E element)
    {
        arr.add(element);
        heapifyUp();
    }

    public E remove()
    {
        E val = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        heapifyDown(0, arr.size() - 1);
        return val;
    }

    public E getMax() { return arr.get(0); }
}