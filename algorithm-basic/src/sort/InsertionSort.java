package sort;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-06-02.
 */

public class InsertionSort {

	public static void main(String[] args) {

		int temp = 0;
		int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

		for (int i = 1; i < array.length; i++) {//첫 원소와 마지막 원소는 필요X
			for(int j = i; j > 0; j--) {
				if(array[j-1] > array[j]) {
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}

		for (int i : array) {
			System.out.println(i);
		}
	}
}
