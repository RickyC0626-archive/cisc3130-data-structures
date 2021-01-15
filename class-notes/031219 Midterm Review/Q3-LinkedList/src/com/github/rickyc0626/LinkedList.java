package com.github.rickyc0626;

public class LinkedList<E>
{
    protected class Node
    {
        E data;
        Node next;

        public Node(E data) { this.data = data; }
    }

    protected Node head;

    public LinkedList() { head = null; }

    public void repeat()
    {
        if(head == null) return;

        Node element = head, addHere = head;
        int count = 1;

        while(addHere.next != null)
        {
            addHere = addHere.next;
            count++;
        }

        for(int i = 0; i < count; i++)
        {
            Node node = new Node(element.data);
            addHere.next = node;
            addHere = node;
            element = element.next;
        }
    }
}
