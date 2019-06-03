package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-03.
 * https://www.acmicpc.net/problem/11047
 * 반드시 해당 가격에 맞춰야한다
 */

public class BOJ_11047_동전0 {

	public static void main(String[] args) {
		int result = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int price = scan.nextInt();
		int[] value = new int[n];

		//오름차순으로 가치 입력
		for (int i = 0; i < n; i++) {
			value[i] = scan.nextInt();
		}

		for(int i = value.length - 1; i >= 0; i--) {
			if(value[i] >= price) {//가격보다 크면
				continue;
			}
			int mok = price / value[i];
			result = result + mok;

			price = price % value[i];
		}

		System.out.println(result);
		scan.close();
	}
}
