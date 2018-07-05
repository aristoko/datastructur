package com.datstruct.logical.v2;

//https://www.geeksforgeeks.org/count-number-nodes-given-level-using-bfs/
public class CountNumbNodesLevelBsf {

	static int MAX = 5;
	static Vertex[] vertexArr = null;
	static int adjMatrix[][] = null;
	static int vertexCount = 0;
	static int[] queue = null;
	static int[] levels = null;
	static int rear = -1;
	static int front=0;
	static int queueItemCount = 0;

	/*
	 * queue method
	 */

	static void insertQueue(int data) {
		queue[++rear] = data;
		queueItemCount++;
	}

	static int removeQueue() {
		queueItemCount--;
		int x =  queue[front++];
		return x;
	}

	static boolean isEmpty() {
		return queueItemCount == 0;
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

	static int getAdjUnvisitedIndex(int vertexIndex) {

		for (int i = 0; i < vertexCount; i++) {
			if (adjMatrix[vertexIndex][i] == 1 && vertexArr[i].isVisited() == false) {
				return i;
			}
		}

		return -1;
	}

	static void breadthFirstTraversal(int level) {
		vertexArr[0].setVisited(true);
		displayVertex(0);
		insertQueue(0);
		int unvisitedVertex;
		while (!isEmpty()) {
			int tempIndex = removeQueue();
			while((unvisitedVertex = getAdjUnvisitedIndex(tempIndex)) != -1) {
				vertexArr[unvisitedVertex].setVisited(true);
				levels[unvisitedVertex] = levels[tempIndex]+1;
				displayVertex(unvisitedVertex);
				insertQueue(unvisitedVertex);
			}
		 
		 
		}

		// queue is empty, search is complete, reset the visited flag
		int count = 0;
		for (int i = 0; i < vertexCount; i++) {
			vertexArr[i].setVisited(false);
			 if (levels[i] == level)
		            count++;  
		}
		System.out.println("\n Count Number of Nodes on level "+ level +" is "+count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		vertexArr = new Vertex[MAX];
		adjMatrix = new int[MAX][MAX];
		queue = new int[MAX];
		levels = new int[MAX];
		int i, j;
		for (i = 0; i < MAX; i++) // set adjacency {
			for (j = 0; j < MAX; j++) // matrix to 0
				adjMatrix[i][j] = 0;

		addVertex("S");
		addVertex("A");
		addVertex("B");
		addVertex("C");
		addVertex("D");
//		addVertex("E");

		addAdjMatrix(0, 1);
		addAdjMatrix(0, 2);
		addAdjMatrix(0, 3);
		addAdjMatrix(1, 4);
		addAdjMatrix(2, 4);
		addAdjMatrix(3, 4);
//		addAdjMatrix(3, 5);
//		addAdjMatrix(4, 5);
		

		breadthFirstTraversal(1);

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
