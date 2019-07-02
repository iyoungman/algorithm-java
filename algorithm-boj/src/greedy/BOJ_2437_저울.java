package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-01.
 * https://www.acmicpc.net/problem/2437
 * ex) 1,2,4 <-> 1,2,5
 */

public class BOJ_2437_저울 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] weights = new int[n];
		int sum = 0;

		//입력
		for (int i = 0; i < n; i++) {
			weights[i] = scanner.nextInt();
		}

		//오름차순 정렬
		Arrays.sort(weights);

		for (int i = 0; i < n; i++) {
			if(weights[i] >= sum + 2) {
				break;
			}
			sum = sum + weights[i];
		}

		//출력
		System.out.println(sum + 1);

	}
}
