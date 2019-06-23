package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-06-03.
 * https://www.acmicpc.net/problem/1931
 * 여러가지 접근할 수 있다..빠른 시간//짧은 시간//빨리 끝나는 시간순
 * 회의 시간을 빨리 끝낼수록 남은 시간이 많다 -> 빨리 끝나는 시간순
 * 종료 시간대로 정렬하며 종료 시간이 같으면 시작 시간으로 정렬하여 푼다
 */

public class BOJ_1931_회의실배정 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] conferences = new int[n][2];
		int temp = -1, result = 0;

		for (int i = 0; i < n; i++) {
			conferences[i][0] = scanner.nextInt();
			conferences[i][1] = scanner.nextInt();
		}

		Arrays.sort(conferences, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] == o2[1]) {
					//종료시간이 같을경우 시작시간으로 정렬
					return Integer.compare(o1[0], o2[0]);//o1과 o2의 위치를 바꾸면 내림차순 정렬, compare = compareTo
				}
				//종료시간으로 정렬
				return Integer.compare(o1[1], o2[1]);
			}
		});

		for (int i = 0; i < n; i++) {
			if (conferences[i][0] >= temp) {//시작시간
				result = result + 1;
				temp = conferences[i][1];
			}
		}

		System.out.println(result);
	}

}
