package com.github.rickyc0626;

public class TreeSet<E>
{
    protected class Node
    {
        E value;
        Node left, right, parent;

        public Node(E element) { this.value = element; }
    }

    public E higher(E e)
    {
        // return the smallest element larger than e

    }

    protected E higher(Node nd , E e)
    {
        if(nd == null) return null;
        E left = higher(nd.left, e);
        if(left != null) return left;
        if(nd.value.compareTo(e) > 0) return nd.value;
        return higher(nd.right, e);
    }
}
