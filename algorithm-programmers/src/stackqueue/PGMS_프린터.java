package stackqueue;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by YoungMan on 2019-04-23.
 * 링크드리스트의 특성 이용
 * 인덱스(location)을 저장하고 출력하는 것이 관건
 * 따라서 인덱스와 우선순위를 구조화(Class) 시켜서 풀었다
 */

public class PGMS_프린터 {

	public static void main(String[] args) {

		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		System.out.println(solution(priorities, location));
	}

	static int solution(int[] priorities, int location) {

		int answer = 0;
		LinkedList<Info> list = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(
					new Info(i, priorities[i])
			);
		}

		while (list.size() > 0) {
			int currentPriority = list.peek().priority;

			for (int i = 0; i < list.size(); i++) {
				if (currentPriority < list.get(i).priority) {
					list.addLast(
							list.getFirst()
					);
					list.removeFirst();
					break;
				}
				if (i == list.size() - 1) {
					answer++;
					map.put(list.peek().location, answer);
					list.removeFirst();
				}
			}

		}
		answer = map.get(location);
		return answer;
	}


	//검증 메소드
	static void outputMap(HashMap<Integer, Integer> map) {

		for (int key : map.keySet()) {
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
	}
}

class Info {

	int location;
	int priority;

	Info(int location, int priority) {
		this.location = location;
		this.priority = priority;
	}
}
