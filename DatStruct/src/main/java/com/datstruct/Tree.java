package com.datstruct;
//https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
public class Tree {
	Node root;
	 
    // Tree Node
    static class Node {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
	 * Determines whether a binary tree is balanced.
	 *
	 * @param {BinaryTreeNode}
	 *            root The root of the tree.
	 * @returns Whether the tree is balanced.
	 */
	public static boolean isBinaryTreeBalanced(Node root) {
		if (root == null) {
			throw new IllegalArgumentException("The tree root must be non null");
		}
		return maxDepth(root) - minDepth(root) <= 1;
	}

	/**
	 * Determines the minimum depth of a binary tree node.
	 *
	 * @param node
	 *            The node to check.
	 * @return The minimum depth of a binary tree node.
	 */
	private static int minDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	/**
	 * Determines the maximum depth of a binary tree node.
	 *
	 * @param node
	 *            The node to check.
	 * @return The maximum depth of a binary tree node.
	 */
	private static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}
 
    // Function to insert nodes in level order
    public Node insertLevelOrder(int[] arr, Node root,
                                                int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;
 
            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                                             2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                                               2 * i + 2);
        }
        return root;
    }
 
    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
        Tree t2 = new Tree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
        
        System.out.println(isBinaryTreeBalanced(t2.root));
    }
}
