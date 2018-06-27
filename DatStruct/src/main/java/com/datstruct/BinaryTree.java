package com.datstruct;

//Java program to print BST in given range

//A binary tree Nodex
class Nodex {

	int data;
	Nodex left, right;

	Nodex(int d) {
		data = d;
		left = right = null;
	}
}

public class BinaryTree {

	static Nodex root;

	/*
	 * A function that constructs Balanced Binary Search Tree from a sorted array
	 */
	Nodex sortedArrayToBST(int arr[], int start, int end) {

		/* Base Case */
		if (start > end) {
			return null;
		}

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Nodex Nodex = new Nodex(arr[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		Nodex.left = sortedArrayToBST(arr, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of root
		 */
		Nodex.right = sortedArrayToBST(arr, mid + 1, end);

		return Nodex;
	}

	/* A utility function to print preorder traversal of BST */
	void preOrder(Nodex Nodex) {
		if (Nodex == null) {
			return;
		}
		System.out.print(Nodex.data + " ");
		preOrder(Nodex.left);
		preOrder(Nodex.right);
	}
	void inOrder(Nodex Nodex) {
		if (Nodex == null) {
			return;
		}
		inOrder(Nodex.left);
		System.out.print(Nodex.data + " ");
		inOrder(Nodex.right);
	}

	/**
	 * Determines whether a binary tree is balanced.
	 *
	 * @param {BinaryTreeNode}
	 *            root The root of the tree.
	 * @returns Whether the tree is balanced.
	 */
	public  boolean isBinaryTreeBalanced(Nodex root) {
		if (root == null) {
			throw new IllegalArgumentException("The tree root must be non null");
		}

		int max = maxDepth(root);
		int min = minDepth(root);
		return max - min <= 1;
	}

	/**
	 * Determines the minimum depth of a binary tree node.
	 *
	 * @param node
	 *            The node to check.
	 * @return The minimum depth of a binary tree node.
	 */
	private static int minDepth(Nodex node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}
	int x = 0;

	/**
	 * Determines the maximum depth of a binary tree node.
	 *
	 * @param node
	 *            The node to check.
	 * @return The maximum depth of a binary tree node.
	 */
	private  int maxDepth(Nodex node) {
		if (node == null) {
			return 0;
		}
//		x++;
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		int max = Math.max(left, right);
		return 1 + max;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
//		int arr[] = new int[] { 1, 3, 5, 9, 10, 13, 15 };
		int arr[] = new int[] { 6,8,10,11,12,15,16,17,20,25,27};
		int n = arr.length;
		root = tree.sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		tree.preOrder(root);
		System.out.println("Inorder traversal of constructed BST");
		tree.inOrder(root);

		System.out.println(tree.isBinaryTreeBalanced(root));
	}
}

// This code has been contributed by Mayank Jaiswal
