package binary_search;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-09-19.
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */

public class PGMS_입국심사 {

	public static void main(String[] args) {
		int n = 1;
		int[] times = {2, 2};
		System.out.println(solution(n, times));
	}

	private static long solution(int n, int[] times) {
		long[] longTimes = new long[times.length];
		int ii = 0;
		for (int time : times) {
			longTimes[ii++] = (long) time;
		}

		Arrays.sort(longTimes);
		long left = 1;
		long right = longTimes[longTimes.length - 1] * n;
		long result = Long.MAX_VALUE;

		while (left <= right) {//중간에 타겟을 찾아 break 되는게 아니라 끝까지 돈다
			long mid = (left + right) / 2;
			long sumPeople = 0;
			for (int i = 0; i < longTimes.length; i++) {
				sumPeople = sumPeople + (mid / longTimes[i]);//몫
			}

			if (sumPeople < n) {//n이 더 클때
				left = mid + 1;
			} else if (sumPeople >= n) {//n보다 클때
				result = Math.min(result, mid);//주의
				right = mid - 1;
			}
		}

		return result;
	}
}
