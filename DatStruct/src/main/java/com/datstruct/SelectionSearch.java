package com.datstruct;

import java.util.Iterator;

public class SelectionSearch {
	static int count1 = 0;
	public static void main(String[] arfs) {
		int indexMin;
		int[] list = {  1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9 };
		for (int i = 0; i < list.length; i++) {
			count1++;
			indexMin = i;

			for (int j = i + 1; j < list.length; j++) {
				count1++;
				if (list[indexMin] > list[j]) {
					indexMin = j;
				}
			}

			if (i != indexMin) {
				int temp = list[i];
				list[i] = list[indexMin];
				list[indexMin] = temp;
			}

		}
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		System.out.println("count1 "+count1);
	}
}
