package heap;

import java.util.PriorityQueue;

/**
 * Created by YoungMan on 2019-11-06.
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 * 단순한 배열 + 매 횟수마다 정렬을 해도 답은 나올 것이다
 * 다만 최대값// 최소값을 찾을 때는 우선순위 큐(힙정렬)이 유리하다
 */

public class PGMS_더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;

		System.out.println(solution(scoville, K));
	}

	private static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int i : scoville) {
			priorityQueue.add(i);
		}

		int result = 0;
		while (priorityQueue.size() >= 2) {
			if (priorityQueue.peek() >= K) {
				break;
			}
			int one = priorityQueue.poll();
			int two = priorityQueue.poll();
			int num = getNum(one, two);

			priorityQueue.add(num);
			result++;
		}

		return priorityQueue.peek() >= K ? result : -1;
	}

	private static int getNum(int one, int two) {
		return one + (two * 2);
	}
}
