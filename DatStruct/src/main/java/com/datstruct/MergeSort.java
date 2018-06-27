package com.datstruct;

public class MergeSort {
//	int[] a = { 1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9,1, 8, 4, 6, 0, 3, 5, 2, 7, 9};
//	int[] b = new int[100];
	int[] a = {38,27,43,3,9,82,10};
	int[] b = new int[7];
	
	static int count1 = 0;
	static int count2 = 0;

	void merging(int low, int mid, int high) {
		int l1, l2, i;
		for (l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
			count1++;
			if (a[l1] <= a[l2])
				b[i] = a[l1++];
			else
				b[i] = a[l2++];
		}
		while (l1 <= mid) {
			count1++;
			b[i++] = a[l1++];
		}
		while (l2 <= high) {
			count1++;
			b[i++] = a[l2++];
			}
		for (i = low; i <= high; i++) {
			count1++;
			a[i] = b[i];
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			b[i] = a[i];
			count2++;
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			count2++;
			if (b[i] <= b[j]) {
				a[k] = b[i];
				i++;
			} else {
				a[k] = b[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			count2++;
			a[k] = b[i];
			k++;
			i++;
		}
		
		System.out.println();

	}

	void sort(int low, int high) {
		int mid;

		if (low < high) {

			mid = (low + high) / 2;
			sort(low, mid);
			sort(mid + 1, high);
			mergeParts(low, mid, high);
		} else {
			return;
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(0, mergeSort.a.length - 1);

		System.out.println("count1 "+count1);
		System.out.println("count2 "+count2);
		for (int i = 0; i < mergeSort.a.length; i++) {
			System.out.println(mergeSort.a[i]);
		}

	}
}
