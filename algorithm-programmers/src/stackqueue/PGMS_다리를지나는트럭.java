package stackqueue;

import java.util.LinkedList;

/**
 * Created by YoungMan on 2019-04-26.
 * 마지막 건너는 것은 + 1
 * 건널 수 있는게 1개면 2초, 2개면 3초..
 * While 은 조건 틀어지는 순간 바로 break 되는지? 바로 끝내지는 않고 마지막 구문까지는 돈다
 */

public class PGMS_다리를지나는트럭 {

	public static void main(String[] args) {

		int bridgeLength = 3;
		int weight = 10;
		int[] truckWeights = {7,4,5,6};

		System.out.println(solution(bridgeLength, weight, truckWeights));
	}

	static int solution(int bridgeLength, int weight, int[] truckWeights) {

		int answer = 0;
		LinkedList<Integer> linkedList = new LinkedList<>();//대기트럭
		int currentIndex = 0;

		for (int truckWeight : truckWeights) {
			linkedList.add(
					truckWeight
			);
		}

		while (linkedList.size() > 0) {

			int currentWeight = 0;
			int currentCount = linkedList.size();

			for (int i = 0; i < currentCount; i++) {
				if (currentWeight + linkedList.getFirst() > weight) {
					currentIndex = i + (bridgeLength - 1);
					break;
				}

				if (linkedList.size() != 1) {
					currentWeight = currentWeight + linkedList.getFirst();
					linkedList.removeFirst();
				} else {//마지막 남은 원소이면 + 1
					currentIndex = i + (bridgeLength);
					linkedList.removeFirst();
				}
			}
			answer = answer + currentIndex;
		}
		return answer + 1;
	}
}
