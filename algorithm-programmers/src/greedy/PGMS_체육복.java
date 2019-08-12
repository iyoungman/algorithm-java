package greedy;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-08-12.
 */

public class PGMS_체육복 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};

		//결과출력
		System.out.println(solution(n, lost, reserve));
	}

	private static int solution(int n, int[] lost, int[] reserve) {
		int lostCount = lost.length;

		//오름차순
		Arrays.sort(lost);
		Arrays.sort(reserve);

		//여분 가지고 있지만 체육복을 잃어버린경우
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					lost[i] = -10;
					reserve[j] = -10;
					lostCount--;
				}
			}
		}

		//빌려주기
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] - reserve[j] == 1) {//핵심
					reserve[j] = -10;
					lostCount--;
					break;
				}
				if (lost[i] - reserve[j] == -1) {//핵심
					reserve[j] = -10;
					lostCount--;
					break;
				}
			}
		}

		return n - lostCount;
	}
}
