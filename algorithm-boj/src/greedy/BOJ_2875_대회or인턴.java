package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-05.
 * https://www.acmicpc.net/problem/2875
 */

public class BOJ_2875_대회or인턴 {

	public static void main(String[] args) {

		int result = 0;//팀
		int temp = 0;//대회 참가후 남는 인원
		Scanner scanner = new Scanner(System.in);

		int woman = scanner.nextInt();
		int man = scanner.nextInt();
		int intern = scanner.nextInt();

		if (woman / 2 < man) {
			result = woman / 2;
			temp = man - result;
		} else if (woman / 2 == man) {
			result = man;
			temp = 0;
		} else {
			result = man;
			temp = woman - (man * 2);
		}

		if (temp < intern) {//남는 인원수가 적을 때
			int mok = (intern - temp) / 3;
			if ((intern - temp) % 3 != 0) {//나머지가 있다면
				mok = mok + 1;
			}
			result = result - mok;
		}

		System.out.println(result);
	}
}
