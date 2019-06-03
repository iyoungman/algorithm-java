package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by YoungMan on 2019-04-28.
 * PriorityQueue는 우선순위에 따라 자동 정렬된다(default는 오름차순)
 * offer(뒤에 삽입), peek(가장 작은값 리턴), poll(맨 앞에값 반환 후 삭제)
 */

public class PGMS_더맵게_2 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;

		System.out.println(solution(scoville, k));
	}

	static int solution(int[] scoville, int K) {
		int answer = 0;
		int temp = 0;
		Queue<Integer> queue = new PriorityQueue<>(scoville.length);

		for (int i : scoville) {
			queue.offer(i);
		}

		while (true) {
			if (queue.peek() >= K) {//모두다 기준보다 크면
				break;
			}
			temp = queue.poll() + (queue.poll() * 2);
			queue.offer(temp);
			answer = answer + 1;
		}

		return answer;
	}
}
