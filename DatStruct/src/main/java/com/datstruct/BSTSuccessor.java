package com.datstruct;

public class BSTSuccessor {

	private static NodeSuc root;

	static NodeSuc insert(NodeSuc root, int data) {
		if (root == null) {
			NodeSuc temp = new NodeSuc(data, null, null);
			root = temp;
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}

		return root;
	}
	
	static NodeSuc findMin(NodeSuc root) {
		if(root==null) {
			return null;
		}else {
			while(root.left!=null) {
				root = root.left;
			}
		}
		return root;
	}

	static NodeSuc find(NodeSuc root, int data) {
		if (root == null) {
			return null;
		} else {
			if (data == root.data) {
				return root;
			} else if (data < root.data) {
				return find(root.left, data);
			} else {
				return find(root.right, data);
			}
		}
	}

	static void printInOrder(NodeSuc suc) {
		if (suc != null) {
			printInOrder(suc.left);
			System.out.print(suc.data + " ");
			printInOrder(suc.right);
		}
	}
	
	static NodeSuc getSuccessor(NodeSuc root,int data) {
		
		NodeSuc current  = find(root, data);
		if(current == null) {
			return null;
		}else {
			if(current.right!=null) {
				return findMin(current.right);
			}else {
				NodeSuc ancestor = root;
				NodeSuc successor = null;
				
				while(current.data!=ancestor.data) {
					if( ancestor.data > current.data ) {
						successor = ancestor;
						ancestor = ancestor.left;
					}else {
						ancestor = ancestor.right;
					}
				}
				
				return successor;
			}
		}
		
	}

	public static void main(String[] arg) {
		root = insert(root, 5);
		root = insert(root, 10);
		root = insert(root, 3);
		root = insert(root, 4);
		root = insert(root, 1);
		root = insert(root, 11);

		printInOrder(root);
		System.out.println();
		NodeSuc suc = find(root, 4);
		System.out.println(suc.data);
		
		NodeSuc nodeSuc = getSuccessor(root, 4);
		System.out.println(nodeSuc.data);
		
	}
}

class NodeSuc {
	int data;
	NodeSuc left;
	NodeSuc right;

	public NodeSuc(int data, NodeSuc left, NodeSuc right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
