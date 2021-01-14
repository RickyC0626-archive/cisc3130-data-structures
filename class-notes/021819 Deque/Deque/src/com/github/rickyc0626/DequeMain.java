package com.github.rickyc0626;

import java.util.*;

public class DequeMain
{
    public static void main(String[] args)
    {
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 1; i <= 5; i++)
        {
            stack.push(i);
        }
        System.out.println("Size: " + stack.size());

        System.out.println("\nElements: ");
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }

        int n = 85672, b = 16;
        System.out.println(n + " to base " + b + ": " + multibaseConversion(n, b));
    }

    // Number conversion
    public static String multibaseConversion(int n, int b)
    {
        String digitChar = "0123456789ABCDEF";

        StringBuilder outstr = new StringBuilder();
        Deque<Character> outstack = new LinkedList<>();

        while(n != 0)
        {
            outstack.push(digitChar.charAt(n % b));
            n /= b;
        }

        while(!outstack.isEmpty())
        {
            outstr.append(outstack.pop());
        }
        return outstr.toString();
    }

    // Train example
    public static <E> boolean uncouple(Deque<E> stack, E target)
    {
        Deque<E> auxstack = new LinkedList<>();
        boolean found = false;

        while(!stack.isEmpty())
        {
            E x = stack.pop();

            if(x.equals(target))
            {
                found = true;
                break;
            }
            auxstack.push(x);
        }

        while(!auxstack.isEmpty())
        {
            stack.push(auxstack.pop());
        }
        return found;
    }

    // Balancing Brackets
    public static boolean checkBrackets(String text)
    {
        Deque<Character> openLeftStack = new LinkedList<>();
        String leftBrackets = "[{(<", rightBrackets = "]})>";
        boolean wellFormed = true;

        for(int i = 0; i < text.length(); i++)
        {
            Character c = text.charAt(i);
            if(leftBrackets.indexOf(c) >= 0)
            {
                openLeftStack.push(c);
            }
            else
            {
                int rightIndex = rightBrackets.indexOf(c);
                if(rightIndex < 0) continue;

                if(openLeftStack.isEmpty())
                {
                    System.err.println("Error: no open left bracket");
                    wellFormed = false;
                }
                int leftIndex = leftBrackets.indexOf(openLeftStack.peek());
                if(leftIndex != rightIndex) openLeftStack.pop();
                else
                {
                    System.err.println("Error: Attempting to close " + openLeftStack.peek() + " with " + c);
                    wellFormed = false;
                }
            }
        }
        if(!openLeftStack.isEmpty())
        {
            System.err.println("Error: open left brackets remaining.");
            wellFormed = false;
        }
        return wellFormed;
    }
}
