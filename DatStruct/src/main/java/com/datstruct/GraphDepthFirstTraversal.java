package com.datstruct;

public class GraphDepthFirstTraversal {

	static int MAX = 5;
	static Vertex[] vertexArr = null;
	static int adjMatrix[][] = null;
	static int[] stack = null;
	static int top = -1;
	static int vertexCount = 0;

	/*
	 * stack method
	 */
	static void push(int data) {
		stack[++top] = data;
	}

	static int pop() {
		return stack[top--];
	}

	static int peek() {
		return stack[top];
	}

	static boolean isEmpty() {
		return top == -1;
	}

	/*
	 * Graph method
	 */
	static void addVertex(String label) {
		Vertex vertex = new Vertex(label, false);
		vertexArr[vertexCount] = vertex;
		vertexCount++;
	}

	static void addAdjMatrix(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	// display the vertex
	static void displayVertex(int vertexIndex) {
		System.out.print(" " + vertexArr[vertexIndex].getLabel());
	}

	static int getAdjUnvisitedVertex(int vertexIndex) {

		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[vertexIndex][i] == 1 && vertexArr[i].isVisited() == false) {
				return i;
			}
		}

		return -1;
	}

	static void depthFirstTraversal() {
		vertexArr[0].setVisited(true);
		push(0);
		displayVertex(0);

		while (!isEmpty()) {
			int indexUnvisited = getAdjUnvisitedVertex(peek());
			if (indexUnvisited == -1) {
				pop();
			} else {
				vertexArr[indexUnvisited].setVisited(true);
				push(indexUnvisited);
				displayVertex(indexUnvisited);

			}

		}

		for (int i = 0; i < vertexCount; i++) {
			vertexArr[i].setVisited(false);
		}
	}

	public static void main(String[] args) {
		vertexArr = new Vertex[MAX];
		adjMatrix = new int[MAX][MAX];
		stack = new int[MAX];
		int i, j;
		for (i = 0; i < MAX; i++) // set adjacency {
			for (j = 0; j < MAX; j++) // matrix to 0
				adjMatrix[i][j] = 0;

		addVertex("S");
		addVertex("A");
		addVertex("B");
		addVertex("C");
		addVertex("D");

		addAdjMatrix(0, 1);
		addAdjMatrix(0, 2);
		addAdjMatrix(0, 3);
		addAdjMatrix(1, 4);
		addAdjMatrix(2, 4);
		addAdjMatrix(3, 4);

		depthFirstTraversal();

	}
}

class Vertex {
	private String label;
	private boolean visited;

	public Vertex(String label, boolean visited) {
		super();
		this.label = label;
		this.visited = visited;
	}

	public Vertex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}