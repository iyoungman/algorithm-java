package heap;

import java.util.*;

/**
 * Created by YoungMan on 2019-11-06.
 */

public class PGMS_이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] result = solution(operations);

		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(String[] operations) {
		PriorityQueue<Integer> bigPriorityQueue = new PriorityQueue<>((x, y) -> y - x);//큰순
		PriorityQueue<Integer> smallPriorityQueue = new PriorityQueue<>();//작은순

		for (String operation : operations) {
			String[] split = operation.split(" ");
			int num = Integer.valueOf(split[1]);
			if (split[0].equals("I")) {
				bigPriorityQueue.add(num);
				smallPriorityQueue.add(num);
			} else {//D
				if (num < 0 && !smallPriorityQueue.isEmpty()) {
					int small = smallPriorityQueue.poll();
					bigPriorityQueue.remove(small);
				} else if (num > 0 && !bigPriorityQueue.isEmpty()) {
					int big = bigPriorityQueue.poll();
					smallPriorityQueue.remove(big);
				}
			}
		}

		return getResult(bigPriorityQueue, smallPriorityQueue);
	}

	private static int[] getResult(PriorityQueue<Integer> big, PriorityQueue<Integer> small) {
		if ((big.isEmpty() || small.isEmpty())) {
			return new int[]{0, 0};
		} else {//공통으로 남은 것을 추리기
			return new int[]{big.peek(), small.peek()};
		}
	}
}
