package com.datstruct;

public class BubleSort {
	public static void main(String[] arfs) {
		int[] list = { 1, 8, 4, 6, 0, 3, 5, 2, 7, 9 };

		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
