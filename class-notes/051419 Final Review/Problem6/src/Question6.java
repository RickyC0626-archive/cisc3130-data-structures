import java.util.*;

public class Question6<E>
{
    protected class Node
    {
        E value;
        Node left;
        Node right;

        public Node(E value) { this.value = value; }
    }

    protected Node root;

    // Recursive replacement, depth first search
    public int replaceRecursive(Node nd, E findVal, E repVal)
    {
        if(nd == null) return 0;
        int count = replaceRecursive(nd.left, findVal, repVal) + replaceRecursive(nd.right, findVal, repVal);

        if(nd.value.equals(findVal))
        {
            nd.value = repVal;
            count++;
        }
        return count;
    }

    // Iterative replacement, breadth first search
    public int replaceIterative(Node nd, E findVal, E repVal)
    {
        if(nd == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(nd);

        int count = 0;
        while(!q.isEmpty())
        {
            Node xnd = q.poll();
            if(xnd.value.equals(findVal))
            {
                xnd.value = repVal;
                count++;
            }
            if(xnd.left != null) q.add(xnd.left);
            if(xnd.right != null) q.add(xnd.right);
        }
        return count;
    }
}
