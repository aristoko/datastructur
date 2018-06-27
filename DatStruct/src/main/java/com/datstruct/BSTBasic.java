package com.datstruct;

public class BSTBasic {

	private Node root = null;

	void insert(int data) {
		Node current = null;
		Node parent = null;

		Node node = new Node();
		node.setData(data);

		if (root == null) {
			root = node;

		} else {
			current = root;
			parent = null;

			while (true) {
				parent = current;

				if (data < parent.getData()) {
					current = current.getLeftChild();
					if (current == null) {
						parent.setLeftChild(node);
						return;
					}
				} else {
					current = current.getRightChild();
					if (current == null) {
						parent.setRightChild(node);
						return;
					}
				}
			}

		}
	}

	Node search(int data) {

		if (root != null) {
			Node current = root;

			while (current.getData() != data) {
				if (data < current.getData()) {
					current = current.getLeftChild();
				} else {
					current = current.getRightChild();

				}
			}

			return current;

		}

		return null;
	}

	void preOrderTranversal(Node root) {

		if (root != null) {
			System.out.println(root.getData());
			preOrderTranversal(root.getLeftChild());
			preOrderTranversal(root.getRightChild());
		}

	}

	void inOrderTranversal(Node root) {

		if (root != null) {
			inOrderTranversal(root.getLeftChild());
			System.out.println(root.getData());
			inOrderTranversal(root.getRightChild());
		}

	}

	void postOrderTranversal(Node root) {

		if (root != null) {
			postOrderTranversal(root.getLeftChild());
			postOrderTranversal(root.getRightChild());
			System.out.println(root.getData());
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
		return 1 + Math.min(minDepth(node.getLeftChild()), minDepth(node.getRightChild()));
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
		return 1 + Math.max(maxDepth(node.getLeftChild()), maxDepth(node.getRightChild()));
	}

	public static void main(String[] args) {
		int[] array = { 27, 14, 35, 10, 19, 31, 42 };
		// int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		BSTBasic basic = new BSTBasic();

		for (int i = 0; i < array.length; i++)
			basic.insert(array[i]);

		System.out.println(isBinaryTreeBalanced(basic.root));
		Node node = basic.search(31);
		System.out.println(node.getData());

		System.out.println("==============");
		basic.preOrderTranversal(basic.root);
		System.out.println("==============");
		basic.inOrderTranversal(basic.root);
		System.out.println("==============");
		basic.postOrderTranversal(basic.root);

	}
}

class Node {
	int data;
	Node leftChild;
	Node rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

}
