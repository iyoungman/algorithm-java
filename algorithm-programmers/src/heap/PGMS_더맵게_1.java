package heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by YoungMan on 2019-04-28.
 * List remove 시간복잡도 해결
 */

public class PGMS_더맵게_1 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;

		System.out.println(solution(scoville, k));
	}

	static int solution(int[] scoville, int K) {
		int answer = 0;
		ArrayList<Integer> scovilleList = new ArrayList<>(scoville.length);
		for (int i : scoville)
			scovilleList.add(i);

		label:
		while (true) {
			Collections.sort(scovilleList);
			for (int i = 0; i < scovilleList.size(); i++) {
				if ((int) (scovilleList.get(i)) < K)
					break;
				if (i == scovilleList.size() - 1)
					break label;
			}
			int scovilleValue = (int) scovilleList.get(0) + ((int) scovilleList.get(1) * 2);
			scovilleList.remove(0);//1번째 인덱스 제거
			scovilleList.remove(0);//2번째 인덱스 제거
			scovilleList.add(scovilleValue);
			answer = answer + 1;
		}

		return answer;
	}
}
