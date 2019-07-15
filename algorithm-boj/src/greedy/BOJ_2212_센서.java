package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-15.
 * https://www.acmicpc.net/problem/2212
 */

public class BOJ_2212_센서 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//입력
		int n = scanner.nextInt();//센서의 개수
		int k = scanner.nextInt();//집중국의 개수
		int[] location = new int[n];
		Integer[] distance = new Integer[n - 1];

		for (int i = 0; i < n; i++) {
			location[i] = scanner.nextInt();
		}

		//오름차순 정렬
		Arrays.sort(location);

		for (int i = 0; i < n - 1; i++) {
			distance[i] = location[i + 1] - location[i];
		}

		//내림차순 정렬
		Arrays.sort(distance, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < distance.length; i++) {
			if (i < k - 1) {
				continue;
			}
			sum = sum + distance[i];
		}

		//출력
		System.out.println(sum);
	}
}
