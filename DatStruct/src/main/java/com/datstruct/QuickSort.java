package com.datstruct;

public class QuickSort {
	int[] intArray = { 4, 6, 3, 2, 1, 9, 7 };

	void swap(int num1, int num2) {
		int temp = intArray[num1];
		intArray[num1] = intArray[num2];
		intArray[num2] = temp;
	}

	int partition(int left, int right, int pivot) {
		int leftPointer = left - 1;
		int rightPointer = right;
		while (true) {
			while (intArray[++leftPointer] < pivot) {
				// do nothing
			}
			while (rightPointer > 0 && intArray[--rightPointer] > pivot) {
				// do nothing
			}
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swap(leftPointer, rightPointer);
			}
		}
		swap(leftPointer, right);
		return leftPointer;
	}

	void quickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = intArray[right];
			int partitionPoint = partition(left, right, pivot);
			quickSort(left, partitionPoint - 1);
			quickSort(partitionPoint + 1, right);
		}
	}

	// http://www.java2novice.com/java-sorting-algorithms/quick-sort/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(0, quickSort.intArray.length - 1);
		for (int i = 0; i < quickSort.intArray.length; i++) {
			System.out.println(quickSort.intArray[i]);
		}
	}

}
