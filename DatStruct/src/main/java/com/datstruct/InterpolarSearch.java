package com.datstruct;

public class InterpolarSearch {

	public static void main(String[] args) {
		int[] arrSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int searchNumber = 3;

		int upperBound = arrSort.length - 1;
		int lowBound = 0;
		int index = -1;
		int midPoint = -1;
		int lopping = 0;

		while (lowBound <= upperBound) {
			lopping++;
			//mid = Lo + ((Hi - Lo) / (A[Hi] - A[Lo])) * (X - A[Lo])

			midPoint = lowBound +( ((upperBound-lowBound)/(arrSort[upperBound]-arrSort[lowBound])) *(searchNumber-arrSort[lowBound]) );
			
			if(arrSort[midPoint] == searchNumber) {
				index = midPoint;
				break;
			}else {
				if(arrSort[midPoint] > searchNumber) {
					upperBound = midPoint-1;
				}else {
					lowBound = midPoint+1;
				}
			}
		}
		
		System.out.println(index);
		System.out.println("loop "+lopping);

	}
}
