package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-08-14.
 */

public class PGMS_위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

		//결과 출력
		System.out.println(solution(clothes));
	}

	private static int solution(String[][] clothes) {
		int result = 1;

		Map<String, Integer> kindsMap = new HashMap<>();
		for (String[] cloth : clothes) {
			if(!kindsMap.containsKey(cloth[1])) {
				kindsMap.put(cloth[1], 1);
				continue;
			}
			int count = kindsMap.get(cloth[1]);
			kindsMap.put(cloth[1], ++count);
		}

		//Key 값 추출
		for( String key : kindsMap.keySet() ){
			result = result * (kindsMap.get(key) + 1);//입을수 있는 경우의 수 + 안 입는 경우 1
		}

		return result - 1;//모든것을 안 입는 경우
	}
}
