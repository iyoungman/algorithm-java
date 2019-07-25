package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-07-24.
 * https://www.acmicpc.net/problem/1449
 */

public class BOJ_1449_수리공항승 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//물이 새는 곳의 개수
		int l = scanner.nextInt();//테이프의 길이
		int[] locations = new int[n];
		int[] counts = new int[n];

		//물이 새는 곳의 위치 입력
		for (int i = 0; i < n; i++) {
			locations[i] = scanner.nextInt();
		}

		//정렬
		Arrays.sort(locations);

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (counts[i] == 0) {
				counts[i] = ++count;
				for (int j = i + 1; j < n; j++) {
					if (locations[j] < locations[i] + l) {
						counts[j] = count;
						continue;
					}
					break;
				}
			}
		}

		count = Arrays.stream(counts)
				.max()
				.getAsInt();

		//결과 출력
		System.out.println(count);
	}

}
