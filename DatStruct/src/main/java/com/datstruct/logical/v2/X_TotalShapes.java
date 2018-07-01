package com.datstruct.logical.v2;

import java.util.Scanner;

public class X_TotalShapes {

	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt();
		for (int i = 0; i < o; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] ar = new char[n][m];
			for (int j = 0; j < n; j++) {
				char[] ca = sc.next().toCharArray();
				for (int k = 0; k < m; k++) {
					ar[j][k] = ca[k];
				}
			}

			int res = calc(n, m, ar);
			System.out.println(res);
		}
	}

	static int calc(int n, int m, char[][] ar) {
		int xcount = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ar[i][j] == 'X') {
					if (visited[i][j])
						continue;
					check(n, m, i, j, ar, visited);
					xcount++;
				}
			}
		}
		return xcount;
	}

	static void check(int n, int m, int i, int j, char[][] ar, boolean[][] visited) {
		if (ar[i][j] == 'X' && !visited[i][j]) {
			visited[i][j] = true;
			if (i + 1 < n) {
				check(n, m, i + 1, j, ar, visited);
			}
			if (i - 1 >= 0) {
				check(n, m, i - 1, j, ar, visited);
			}
			if (j + 1 < m) {
				check(n, m, i, j + 1, ar, visited);
			}
			if (j - 1 >= 0) {
				check(n, m, i, j - 1, ar, visited);
			}
		}
	}

}
