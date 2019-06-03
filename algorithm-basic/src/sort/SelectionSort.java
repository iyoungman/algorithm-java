package sort;

/**
 * Created by YoungMan on 2019-06-02.
 */

public class SelectionSort {

	public static void main(String[] args) {

		int min = 0, index = 0, temp = 0;
		int[] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

		for (int i = 0; i < array.length; i++) {
			min = 9999;//초기값은 가장 크게
			for (int j = i; j < array.length; j++)
				if (min > array[j]) {
					min = array[j];
					index = j;
				}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}

		for(int i : array) {
			System.out.println(array);
		}

	}

}
