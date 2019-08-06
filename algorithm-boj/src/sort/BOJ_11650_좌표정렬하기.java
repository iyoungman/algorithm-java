package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-06.
 * https://www.acmicpc.net/problem/11650
 */

public class BOJ_11650_좌표정렬하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] coordinates = new int[n][2];

		//좌표 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				coordinates[i][j] = scanner.nextInt();
			}
		}

		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o2[1], o1[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});

		//결과 출력
		for(int[] line : coordinates) {
			System.out.println(line[0] + " "  + line[1]);
		}
	}
}
