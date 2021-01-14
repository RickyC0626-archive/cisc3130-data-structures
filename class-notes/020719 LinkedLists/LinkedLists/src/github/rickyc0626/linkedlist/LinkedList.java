package github.rickyc0626.linkedlist;

import java.util.*;

public class LinkedList<E> implements List<E>
{
    protected class Node<E>
    {
        protected E data;
        protected Node next, prev;
        public Node() {}
        public Node(E element) { data = element; }
    }

    protected Node head, tail;
    protected Node sentinel;

    public LinkedList()
    {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public boolean isEmpty() { return sentinel.next == sentinel; }

    public int size()
    {
        int s = 0;

        for(Node trackerNode = sentinel.next; trackerNode != sentinel; trackerNode = trackerNode.next)
        {
            s++;
        }
        return s;
    }

    public void addFirst(E element)
    {
        Node newNode = new Node(element);
        newNode.next = sentinel.next;
        newNode.next.prev = newNode;
        sentinel.next = newNode;
        newNode.prev = sentinel;
    }

    public boolean add(E element)
    {
        Node newNode = new Node(element);

        if(this.isEmpty())
        {
            head = newNode;
            tail = newNode;
            return true;
        }
        newNode.prev = sentinel.prev;
        newNode.prev.next = newNode;

        newNode.next = sentinel;
        newNode.next.prev = newNode;
        return true;
    }

    public void add(int index, E element)
    {
        if(index < 0) throw new IndexOutOfBoundsException();
        if(index == 0) { addFirst(element); return; }

        Node newNode = new Node(element);
        Node trackerNode = sentinel.next;

        for(int i = 0; i < index - 1; i++)
        {
            if(trackerNode != sentinel) trackerNode = trackerNode.next;
            else throw new IndexOutOfBoundsException();
        }
        newNode.next = trackerNode.next;
        newNode.next.prev = newNode;

        newNode.prev = trackerNode;
        newNode.prev.next = newNode;
    }

    public E remove()
    {
        if(this.isEmpty()) throw new NoSuchElementException();
        E element = (E) sentinel.next.data;

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return element;
    }

    public E remove(int index)
    {
        if(index < 0) throw new IndexOutOfBoundsException();
        if(index == 0) return remove();

        Node trackerNode = head;
        int i = 0;

        while(i < index - 1)
        {
            if(trackerNode != null) trackerNode = trackerNode.next;
            else throw new IndexOutOfBoundsException();
            i++;
        }
        if(trackerNode.next != null)
        {
            trackerNode.next = trackerNode.next.next;
            if(trackerNode.next != null) trackerNode.next.prev = trackerNode;
            else tail = trackerNode;
        }
        else throw new IndexOutOfBoundsException();
        return (E) trackerNode.data;
    }

//    public E set(int index, E element)
//    {
//
//    }

    public E get(int index)
    {
        if(index < 0) throw new IndexOutOfBoundsException();
        Node trackerNode = sentinel.next;

        int i = 0;
        while(i != index && trackerNode != sentinel)
        {
            i++;
            trackerNode = trackerNode.next;
        }
        if(trackerNode == sentinel) throw new IndexOutOfBoundsException();
        return (E) trackerNode.data;
    }

    public class LinkedListIterator<E> implements ListIterator<E>
    {
        protected Node nextNode, lastReturned;
        protected int nextIndex;

        protected LinkedListIterator(Node nextNode, int nextIndex)
        {
            this.nextNode = nextNode;
            this.nextIndex = nextIndex;
        }

        public ListIterator listIterator(int index)
        {
            Node trackerNode = sentinel.next;

            int i = 0;
            while(trackerNode != sentinel && i != index)
            {
                trackerNode = trackerNode.next;
                i++;
            }
            if(trackerNode == sentinel) throw new IndexOutOfBoundsException();

            return new LinkedListIterator(trackerNode, index);
        }

        public ListIterator listIterator()
        {
            Node n = sentinel.next;
            return new LinkedListIterator(n, 0);
        }

        public boolean hasNext() { return nextNode != sentinel; }

        public boolean hasPrevious() { return nextNode.prev != sentinel; }

        public E next()
        {
            if(!this.hasNext()) throw new NoSuchElementException();

            E ret = (E) nextNode.data;
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return ret;
        }

        public E previous()
        {
            if(!this.hasPrevious()) throw new NoSuchElementException();

            E ret = (E) nextNode.prev.data;
            lastReturned = nextNode.prev;
            nextNode = nextNode.prev;
            nextIndex--;
            return ret;
        }

        public int nextIndex() { return nextIndex; }

        public int previousIndex() { return nextIndex - 1; }

        public void remove()
        {
            if(lastReturned == null) throw new IllegalStateException();

            lastReturned.prev.next = lastReturned.next;
            lastReturned.next.prev = lastReturned.prev;
            lastReturned = null;
        }

        public void add(E element)
        {
            Node newNode = new Node(element);
            newNode.next = nextNode;
            newNode.prev = nextNode.prev;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
            nextIndex++;
            lastReturned = null;
        }

        public void set(E element)
        {
            if(lastReturned == null) throw new IllegalStateException();
            lastReturned.data = element;
        }
    }
}
