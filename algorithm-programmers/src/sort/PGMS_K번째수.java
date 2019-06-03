package sort;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-04-28.
 * 이차원 배열에서 arr.length -> 열의 길이, arr[i].length -> 행의 길이
 */

public class PGMS_K번째수 {

	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] result = solution(array, commands);
		for (int i : result)
			System.out.println(i);
	}

	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(temp);

			answer[i] = temp[commands[i][2] - 1];//문제의 예시는 번째
		}

		return answer;
	}
}
