package com.github.rickyc0626;

/* Rules
1. Every node is either red or black.
2. Every leaf (NULL) is black.
3. If a node is red, then both its children are black.
4. Every simple path from a node to a descendant leaf contains the same number of black nodes.
 */

public class RedBlackTree<E>
{
    protected class RBNode
    {
        E value;
        int color;
        RBNode left, right, parent;

        public RBNode(E value)
        {
            this.value = value;
            this.color = RED;
        }
    }

    protected RBNode root;

    protected static final int RED = 0, BLACK = 1;

    // x becomes left child of its right child
    protected void leftRotate(RBNode x)
    {
        RBNode y = x.right;
        // turn y's left subtree into x's right subtree
        x.right = y.left;
        if(x.right != null) x.right.parent = x;

        // y's new parent is x's parent
        y.parent = x.parent;
        if(y.parent != null)
        {
            if(y.parent.left == x) y.parent.left = y;
            else y.parent.right = y;
        }
        else root = y;

        // put x on y's left
        y.left = x;
        x.parent = y;
    }

    // x becomes right child of its left child
    protected void rightRotate(RBNode x)
    {

    }

    protected RBNode searchTreeInsert(E value)
    {
        return new RBNode(value);
    }

    public boolean insert(E value)
    {
        // let searchTreeInsert be a method that takes a value,
        // wraps it in a node, and inserts that node into the tree
        // in a way that maintains its search properties
        // It should return a reference to the newly inserted node
        // If the value was already in the tree, it should return null
        RBNode x = searchTreeInsert(value);

        // Restore red/black property
        // New nodes are red
        x.color = RED;

        while(x.parent != null && x.parent.color == RED)
        {
            // Check uncle
            // If parent is a left child
            if(x.parent == x.parent.parent.left)
            {
                RBNode uncle = x.parent.parent.right;
                if(uncle == null || uncle.color == BLACK)
                {
                    // Right-Left Case
                    if(x == x.parent.right)
                    {
                        x = x.parent;
                        leftRotate(x);
                    }
                    // Left-Left Case
                    x.parent.color = BLACK;
                    x.parent.parent.color = RED;
                    rightRotate(x.parent.parent);
                }
                else
                {
                    x.parent.color = BLACK;
                    uncle.color = BLACK;
                    x.parent.parent.color = RED;
                    x = x.parent.parent;
                }
            }
        }
        return true;
    }
}
