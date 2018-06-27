package com.datstruct;

public class PowRecursif {
	static int pow(int x, int y) {
		if(y==0) {
			return 1;
		} 
		int temp = pow(x, y/2);
		if(y%2==0) {
			return temp*temp;
		}
		return x * temp * temp;
	}
	
	static int pow1(int x, int y) {
		if(y==0) {
			return 1;
		}else if(y%2==0) {
			return pow1(x, y/2) * pow1(x, y/2);
		}else {
			return x * pow1(x, y/2) * pow1(x, y/2);
		}
	}
	public static void main(String[] args) {
//		System.out.println(pow1(2, 5));
		System.out.println(pow(2, 3));
	}
}
