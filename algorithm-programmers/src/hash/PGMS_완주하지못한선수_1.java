package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by YoungMan on 2019-04-23.
 * 오름차순 정렬하면
 */

public class PGMS_완주하지못한선수_1 {

	static HashMap<String, Integer> participantMap = new HashMap<>();
	static HashMap<String, Integer> completionMap = new HashMap<>();

	public static void main(String[] args) {

		String[] participant = {"mislav", "stanko", "mislav","ana"};
		String[] completion = {"stanko", "ana","mislav"};

		System.out.println(solution(participant, completion));
	}

	static String solution(String[] participant, String[] completion) {
		String answer = "";
		List<String> completionList = Arrays.asList(completion);

		participantMap = convertToHashMap(participant);
		completionMap = convertToHashMap(completion);


		for (int i = 0; i < participant.length; i++) {
			if (completionList.contains(participant[i]) && isEqualDuplicateCount(participant[i]))
				continue;
			answer = participant[i];
		}

		if (answer.isEmpty())
			answer = participant[participant.length - 1];

		return answer;
	}

	static HashMap<String, Integer> convertToHashMap(String[] array) {

		HashMap<String, Integer> map = new HashMap<>();

		for (String name : array) {
			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
				continue;
			}
			map.put(name, 1);
		}
		return map;
	}

	static boolean isEqualDuplicateCount(String name) {
		return participantMap.get(name) == completionMap.get(name);
	}
}
