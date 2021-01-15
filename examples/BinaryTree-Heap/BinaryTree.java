package com.github.rickyc0626;

import java.util.*;

public class BinaryTree<E>
{
    protected class Node
    {
        E data;
        Node left, right;
    }

    Node root;

    public BinaryTree() {}

    public boolean isEmpty() { return root == null; }

    // Breadth Traversal - left to right
    // Depth Traversal - top to bottom

    // Infix Notation a*b+(c-d)/e
    // Postfix Notation ab*cd-e/+
    // Prefix Notation +*ab/-cde

    /* Three Components:
       N visit the node
       L recurse on left subtree
       R recurse on right subtree

       Preorder: NLR
       Postorder: LRN
       Inorder: LNR
    */

    public void inOrder(Node nd)
    {
        // 0. base case
        if(nd == null) return;

        // 1. recurse on the left subtree
        inOrder(nd.left);

        // 2. visit this node
        System.out.println(nd.data);

        // 3. recurse on the right subtree
        inOrder(nd.right);
    }

    // count the number of nodes in the tree
    public int countNodes(Node nd)
    {
        // 0. base case
        if(nd == null) return 0;

        return 1 + countNodes(nd.left) + countNodes(nd.right);
    }

    // find element in tree
    // NLR - preorder
    public boolean isInTree(Node nd, Object o)
    {
        if(nd == null) return false;
        return nd.data.equals(o) || isInTree(nd.left, o) || isInTree(nd.right, o);
    }

    // find height/depth of tree
    public int treeDepth(Node nd)
    {
        if(nd == null) return -1;
        return Math.max(treeDepth(nd.left), treeDepth(nd.right)) + 1;
    }

    // LRN - postorder
    public void deleteTree(Node nd)
    {
        if(nd == null) return;
        deleteTree(nd.left);
        deleteTree(nd.right);
        nd = null;
    }

    public void breadthFirstTraversal(Node nd)
    {
        Queue<Node> fringe = new LinkedList<>();
        fringe.offer(nd);

        while(!fringe.isEmpty())
        {
            Node nx = fringe.poll();
            System.out.println(nx.data);
            if(nx.left != null) fringe.offer(nx.left);
            if(nx.right != null) fringe.offer(nx.right);
        }
    }

    public void depthFirstTraversal(Node nd)
    {
        Deque<Node> fringe = new LinkedList<>();
        fringe.push(nd);

        while(!fringe.isEmpty())
        {
            Node nx = fringe.pop();
            System.out.println(nx.data);
            if(nx.left != null) fringe.push(nx.left);
            if(nx.right != null) fringe.push(nx.right);
        }
    }

    public int countNodesIterative(Node nd)
    {
        Queue<Node> fringe = new LinkedList<>();
        fringe.offer(nd);
        int count = 0;

        while(!fringe.isEmpty())
        {
            Node nx = fringe.poll();
            count++;
            if(nx.left != null) fringe.offer(nx.left);
            if(nx.right != null) fringe.offer(nx.right);
        }
        return count;
    }
}
