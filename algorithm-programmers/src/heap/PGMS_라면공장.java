package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_라면공장 {

	public static void main(String[] args) {

	}

	private static int solution(int stock, int[] dates, int[] supplies, int k) {
		int result = 0;

		Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

		int index = 0;
		for (int i = 0; i < k; i++) {
			if(index < dates.length && i == dates[index])
				priorityQueue.add(supplies[index++]);

			if(stock == 0) {
				stock = stock + priorityQueue.poll();
				result++;
			}
			stock = stock - 1;
		}

		return result;
	}
}
