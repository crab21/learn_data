package com.wpy.practise;

import java.util.Arrays;

public class ArraysTest {

	public static void binarySearch() {
		int []arraysOne = {0,55,1,2,3,4,5,34};
		Arrays.sort(arraysOne);
		int binarySearch = Arrays.binarySearch(arraysOne, 4);
		System.out.println(binarySearch);
	}
	
	public static void main(String[] args) {
		binarySearch();
	}
}
