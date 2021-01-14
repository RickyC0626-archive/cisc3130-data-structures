import java.util.*;

public class RecursiveMaxNode<E>
{
    protected class Node
    {
        E val;
        Node left, right;

        protected Node(E val)
        {
            this.val = val;
        }
    }

    Node root;

    public RecursiveMaxNode() {}

    public Node maxNode(Node nd)
    {
        if(nd == null) return null;

        Node left, right;

        // Node has two children
        if(nd.left != null && nd.right != null)
        {
            left = maxNode(nd.left);
            right = maxNode(nd.right);

            Node max = (left.val.hashCode() > right.val.hashCode()) ? left : right;
            return (nd.val.hashCode() > max.val.hashCode()) ? nd : max;
        }

        // Node has only left child
        if(nd.left != null && nd.right == null)
        {
            left = maxNode(nd.left);
            return (nd.val.hashCode() > left.val.hashCode()) ? nd : left;
        }

        // Node has only right child
        if(nd.left == null && nd.right != null)
        {
            right = maxNode(nd.right);
            return (nd.val.hashCode() > right.val.hashCode()) ? nd : right;
        }

        return nd;
    }

    public boolean flip(Node nd)
    {
        if(nd.val == true) nd.val = false;
        else nd.val = true;

        boolean left, right;
        if(nd.left != null && nd.right != null)
        {
            left = flip(nd.left);
            right = flip(nd.right);

            return (left && right) && nd.val;
        }
        if(nd.left != null && nd.right == null)
        {
            left = flip(nd.left);
            return left && nd.val;
        }
        if(nd.left == null && nd.right != null)
        {
            right = flip(nd.right);
            return right && nd.val;
        }
        return nd.val;

        Integer max = 0;
        E frequent;

        for(Map.Entry<E, Integer> es : e.entrySet())
        {
            if(es.getValue() > max)
            {
                max = es.getValue();
                frequent = es.getKey();
            }
        }
        return frequent;
    }



    public Node findNode(Node nd, E val)
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(nd);

        while(!q.isEmpty())
        {
            Node xnd = q.poll();
            if(xnd.val.equals(val)) return xnd;
            if(xnd.left != null) q.offer(xnd.left);
            if(xnd.right != null) q.offer(xnd.right);
        }
        return null;
    }

    public static void main(String[] args)
    {

    }
}
