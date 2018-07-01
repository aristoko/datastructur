package com.datstruct.logical.v2;

import java.util.Scanner;

public class X_TotalShapesOfMe {

	public static void DFS(boolean visited[][], char arr[][], int i, int j, int n, int k) {
		if (arr[i][j] == 'X' && !visited[i][j]) {
			visited[i][j] = true;

			if (i + 1 < n) {
				DFS(visited, arr, i + 1, j, n, k);
			}

			if (i - 1 > 0) {
				DFS(visited, arr, i - 1, j, n, k);

			}

			if (j + 1 < n) {
				DFS(visited, arr, i, j + 1, n, k);
			}

			if (j - 1 > 0) {
				DFS(visited, arr, i, j-1, n, k);
			}

		} else {
			return;
		}
	}

	public static void main(String[] args) {
		Scanner ab = new Scanner(System.in);
		int l = ab.nextInt();
		while (l-- > 0) {
			int count = 0;
			int n = ab.nextInt();
			int k = ab.nextInt();
			char arr[][] = new char[n][k];
			for (int i = 0; i < n; i++) {
				String tm = new String(ab.next());
				for (int j = 0; j < k; j++) {
					char c = tm.charAt(j);
					arr[i][j] = c;
				}
			}

			boolean[][] visited = new boolean[n][k];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < k; j++) {
					if (arr[i][j] == 'X' && !visited[i][j]) {
						DFS(visited, arr, i, j, n, k);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}
}
