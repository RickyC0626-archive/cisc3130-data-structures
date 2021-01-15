import java.util.*;

public class Stack<E>
{
    private ArrayList<E> arr;

    public Stack()
    {
        arr = new ArrayList<E>();
    }

    public void push(E element)
    {
        arr.add(element);
    }

    public E pop()
    {
        return arr.remove(arr.size() - 1);
    }

    public E peek()
    {
        return arr.get(arr.size() - 1);
    }

    public boolean isEmpty()
    {
        return arr.isEmpty();
    }

    void printTwoInts(int k)
    {
        if(k <= 0) return;
        System.out.println("From before recursion: " + k);
        printTwoInts(k-1);
        printTwoInts(k-2);
        System.out.println("From after recursion: " + k);
    }
}
