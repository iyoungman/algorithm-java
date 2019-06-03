package 우아한테크코스;

/**
 * Created by YoungMan on 2019-05-19.
 * 이미 분양된 토지와 겹치지 않고, 식수원을 포함하고 있어야한다
 * x1 y1 x2 y2
 */

public class Quiz2 {

	public static void main(String[] args) {

		int[][] lands = {{10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};//이미 분양된 토지
		int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};//식수원
		int[] point = {10, 10, 30, 30};//새로운 토지

		System.out.println(solution(lands, wells, point));
	}

	public static boolean solution(int[][] lands, int[][] wells, int[] point) {
		boolean answer = true;

		for (int i = 0; i < lands.length; i++) {
			if(point[0] < lands[i][2] || point[2] > lands[i][0]) {
					if(point[1] < lands[i][3] || point[3] > lands[i][1]) {
						answer = false;
						break;
					}
			}
		}

		for (int i = 0; i < wells.length; i++) {
			if(point[1] > lands[i][1] || point[3] < lands[i][3]) {
				answer = false;
				break;
			}

			if(point[0] > lands[i][0] || point[2] < lands[i][2]) {
				answer = false;
				break;
			}
		}

		return answer;
	}
}
