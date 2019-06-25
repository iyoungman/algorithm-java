package greedy;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-24.
 * https://www.acmicpc.net/problem/1946
 * A의 서류 성적과 면접 성적이 집단의 한 사람보다 두개 다 낮으면 안된다
 */

public class BOJ_1946_신입사원_TimeOut {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int n = scanner.nextInt();//지원자 숫자
			int[] one = new int[n];//면접 순위
			int[] two = new int[n];//서류 순위
			int count = 0;

			for (int j = 0; j < n; j++) {
				one[j] = scanner.nextInt();
				two[j] = scanner.nextInt();
			}

			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (x == y) {//자기자신
						continue;
					}

					if (one[x] > one[y] && two[x] > two[y]) {//둘다 성적이 낮다면
						count++;
						break;
					}
				}
			}

			//결과 출력
			System.out.println(n - count);
		}
	}
}
