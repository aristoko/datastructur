package com.datstruct;

public class MergeSort2 {

	int[] array = { 38, 27, 43, 3, 9, 82, 10 };
	int[] temp = new int[7];

	void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			temp[i] = array[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				array[k] = temp[i];
				i++;
			} else {
				array[k] = temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid) {
			array[k] = temp[i];
			i++;
			k++;
		}
	}

	void sort(int low, int high) {

		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			sort(low, mid);
			sort(mid + 1, high);
			merge(low, mid, high);
		}

	}

	//http://www.java2novice.com/java-sorting-algorithms/merge-sort/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort2 sort2 = new MergeSort2();
		sort2.sort(0, sort2.array.length-1);
		for (int i = 0; i < sort2.array.length; i++) {
			System.out.println(sort2.array[i]);
		}
	}

}
