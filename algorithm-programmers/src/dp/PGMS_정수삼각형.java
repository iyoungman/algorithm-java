package dp;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_정수삼각형 {

	public static void main(String[] args) {

	}

	private static int solution(int[][] triangle) {
		int[][] d = new int[triangle.length][triangle[triangle.length - 1].length];
		d[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					d[i][j] = d[i - 1][j] + triangle[i][j];
				} else if (j == triangle[i].length - 1) {
					d[i][j] = d[i - 1][j - 1] + triangle[i][j];
				} else {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + triangle[i][j];
				}
			}
		}

		int max = 0;
		for(int last : d[triangle.length -1]) {
			max = Math.max(max, last);
		}

		return max;
	}
}
