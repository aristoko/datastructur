package com.datstruct;

import java.util.Arrays;
import java.util.List;

public class Apps {
	public static void main(String[] args) {
		Integer[] x = {1,2,3,4,5,6,7,8,9,10};
		
		List<Integer> integers = Arrays.asList(x);
		integers.remove(new Integer(5));
		for(Integer integer : integers) {
			System.out.println(integer);
		}
	}
}
