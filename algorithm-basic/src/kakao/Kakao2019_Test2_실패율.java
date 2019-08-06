package kakao;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YoungMan on 2019-08-06.
 * double, int 형의 클래스로 만들었으면 더 나았을지도 모르겠다
 */

public class Kakao2019_Test2_실패율 {

	public static void main(String[] args) {
		int n = 5;//스테이지 개수
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};//멈춰있는 스테이지

		//결과 출력
		int[] result = solution(n, stages);
		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(int n, int[] stages) {
		double[][] failCount = new double[n][2];
		for (int i = 0; i < n; i++) {
			failCount[i][0] = i + 1;
		}

		//StageCount
		for (int stage : stages) {
			if (stage == n + 1) {
				continue;
			}
			failCount[stage - 1][1] = failCount[stage - 1][1] + 1;
		}

		double remain = stages.length;
		for (int i = 0; i < failCount.length; i++) {
			double count = failCount[i][1];
			double failRate = count / remain;
			failCount[i][1] = failRate;
			remain = remain - count;
		}

		Arrays.sort(failCount, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				if (o1[1] == o2[1]) {
					return Double.compare(o1[0], o2[0]);
				}
				return Double.compare(o2[1], o1[1]);
			}
		});

		int[] answer = new int[n];
		int i = 0;
		for (double[] stage : failCount) {
			answer[i] = (int) stage[0];
			i = i + 1;
		}
		return answer;
	}

}

