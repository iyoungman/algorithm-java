package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-03.
 * https://www.acmicpc.net/problem/2217
 * N개가 있으면 N개중 작은것을 기준으로 구한다
 */

public class BOJ_2217_로프 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int result = 0, count = 0, n = scan.nextInt();
		int[] lope = new int[n];

		//lope 중량 입력
		for (int i = 0; i < n; i++) {
			lope[i] = scan.nextInt();
		}

		//오름차순 정렬
		Arrays.sort(lope);

		for (int i = n - 1; i >= 0; i--) {
			count = count + 1;
			int temp = lope[i] * count;
			if(result < temp) {
				result = temp;
			}
		}

		System.out.println(result);
	}
}
