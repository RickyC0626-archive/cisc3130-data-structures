package com.github.rickyc0626;

import java.util.*;

public class BinarySearchTree<E extends Comparable<? super E>>
{
    protected class Node
    {
        E value;
        Node left, right, parent;

        public Node(E element) { this.value = element; }
    }

    Node root;

    public boolean contains(E element)
    {
        return find(element) != null;
    }

    public boolean add(E element)
    {
        Node tnd = root, ttnd = null;

        while(tnd != null)
        {
            ttnd = tnd;
            if(tnd.value.equals(element)) return false;
            if(tnd.value.compareTo(element) < 0) tnd = tnd.right;
            else tnd = tnd.left;
        }
        Node nnd = new Node(element);
        nnd.parent = ttnd;
        if(element.compareTo(ttnd.value) < 0) ttnd.left = nnd;
        else ttnd.right = nnd;
        return true;
    }

    protected Node find(E element)
    {
        Node tnd = root;

        while(tnd != null)
        {
            if(tnd.value.equals(element)) return tnd;
            if(tnd.value.compareTo(element) < 0) tnd = tnd.right;
            else tnd = tnd.left;
        }
        return tnd;
    }

    protected Node findMin()
    {
        if(root == null) return null;

        Node tnd = root;
        while(tnd.left != null) tnd = tnd.left;
        return tnd;
    }

    protected Node findMax()
    {
        if(root == null) return null;

        Node tnd = root;
        while(tnd.right != null) tnd = tnd.right;
        return tnd;
    }

    public boolean remove(E element)
    {
        Node dnd = find(element), rnd;
        if(dnd == null) return false;

        if(dnd.left == null && dnd.right == null) rnd = null;
        else
        {
            if(dnd.left == null) rnd = dnd.right;
            else if(dnd.right == null) rnd = dnd.left;
            else
            {
                rnd = dnd.right;
                while(rnd.left != null) rnd = rnd.left;
                if(rnd.right != null && rnd.parent != dnd)
                {
                    rnd.right.parent = rnd.parent;
                    rnd.parent.left = rnd.right;
                }
            }
        }
        if(dnd.left != null) dnd.left.parent = rnd;
        if(dnd.right != null) dnd.right.parent = rnd;

        if(dnd.parent != null)
        {
            if (dnd.parent.left == dnd) dnd.parent.left = rnd;
            else dnd.parent.right = rnd;
        }
        else root = rnd;

        if(rnd != null) rnd.parent = dnd.parent;
        return true;
    }

    public class BSTListIterator<E> implements ListIterator<E>
    {
        protected Node nextNode, previousNode, lastReturned;
        protected int nextIndex;

        protected BSTListIterator(Node nextNode, int nextIndex)
        {
            this.nextNode = nextNode;
            this.nextIndex = nextIndex;
        }

        public boolean hasNext() { return nextNode != null; }

        public boolean hasPrevious() { return previousNode != null; }

        public E next()
        {
            if(!this.hasNext()) throw new NoSuchElementException();
            E ret = (E) nextNode.value;
            lastReturned = nextNode;
            previousNode = nextNode;
            nextIndex++;

            // Right child, parent has been visited
            // Left child, parent not visited
            if(nextNode.right != null)
            {
                nextNode = nextNode.right;
                while(nextNode.left != null) nextNode = nextNode.left;
            }
            else
            {
                while(nextNode.parent != null && nextNode.parent.right == nextNode) nextNode = nextNode.parent;
                nextNode = nextNode.parent;
            }
            return ret;
        }

        public E previous()
        {
            if(!this.hasPrevious()) throw new NoSuchElementException();
            E ret = (E) previousNode.value;
            lastReturned = previousNode;
            nextNode = previousNode;
            previousNode = previousNode(nextNode);
            nextIndex--;
            return ret;
        }

        public Node previousNode(Node nd)
        {
            if(nd.left != null)
            {
                nd = nd.left;
                while(nd.right != null) nd = nd.right;
            }
            else
            {
                while(nd.parent != null && nd.parent.left == nd) nd = nd.parent;
                nd = nd.parent;
            }
            return nd;
        }

        public int nextIndex() { return nextIndex; }

        public int previousIndex() { return nextIndex - 1; }

        public void remove() {}

        public void add(E element) {}

        public void set(E element)
        {
            if(lastReturned == null) throw new IllegalStateException();
        }
    }
}
