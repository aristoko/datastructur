package com.datstruct;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arrSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int searchNumber = 8;

		int lowerBound = 0;
		int upperBound = arrSort.length - 1;
		int midPoint = -1;
		int comparisons = 0;
		int index = -1;
		

		while (lowerBound <= upperBound) {
			comparisons++;
			midPoint = (upperBound+lowerBound)/2;
		 
			
			if(arrSort[midPoint] == searchNumber) {
				index = midPoint;
				break;
			}else {
				if(arrSort[midPoint] < searchNumber) {
					lowerBound = midPoint+1;
					
				}else if(arrSort[midPoint] > searchNumber) {
					upperBound = midPoint-1;
					
				}
			}
				
		}
		
		
		System.out.println("Find "+searchNumber+" on index "+index);
		System.out.println("loop "+comparisons);
	}
}
