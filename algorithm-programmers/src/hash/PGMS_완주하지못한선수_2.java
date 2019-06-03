package hash;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-04-23.
 * 정렬 이용
 * completion 이 아닌 participant 기준으로 검사하는것이 중요
 */

public class PGMS_완주하지못한선수_2 {

	public static void main(String[] args) {

		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println((solution(participant, completion)));
	}

	static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (participant[i].equals(completion[i])) {
				continue;
			}
			return participant[i];
		}
		answer = participant[participant.length - 1];
		return answer;
	}

}
