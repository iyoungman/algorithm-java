package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-03.
 * https://www.acmicpc.net/problem/11047
 * value 와 남은 가격이 같을때는 비교해야하는데 continue 로 걸렀었다
 */

public class BOJ_11047_동전0 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();//가격
		int[] value = new int[n];
		int result = 0;

		//오름차순으로 가치 입력
		for (int i = 0; i < n; i++) {
			value[i] = scanner.nextInt();
		}

		for (int i = value.length - 1; i >= 0; i--) {
			if (value[i] > k) {//가격보다 크면
				continue;
			}

			int mok = k / value[i];
			result = result + mok;
			k = k - (value[i] * mok);

			if (k == 0) {
				break;
			}
		}

		//결과 출력
		System.out.println(result);
	}
}
