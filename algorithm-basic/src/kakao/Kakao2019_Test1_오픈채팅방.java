package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-08-06.
 */

public class Kakao2019_Test1_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

		//결과 출력
		String[] result = solution(record);
		System.out.println(Arrays.toString(result));
	}

	private static String[] solution(String[] record) {
		Map<String, String> memberInfoMap = new HashMap<>();
		ArrayList<String> commands = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			String[] recordLine = record[i].split(" ");
			if (recordLine[0].equals("Enter")) {
				commands.add(recordLine[0] + " " + recordLine[1]);
				memberInfoMap.put(recordLine[1], recordLine[2]);
			} else if (recordLine[0].equals("Leave")) {
				commands.add(recordLine[0] + " " + recordLine[1]);
			} else {
				memberInfoMap.put(recordLine[1], recordLine[2]);
			}
		}

		String[] answer = new String[commands.size()];
		for (int i = 0; i < commands.size(); i++) {
			String[] line = commands.get(i).split(" ");
			String nickName = memberInfoMap.get(line[1]);
			answer[i] = line[0].equals("Enter") ? getEnterString(nickName) : getLeaveString(nickName);
		}

		return answer;
	}

	private static String getEnterString(String nickName) {
		return nickName + "님이 들어왔습니다.";
	}

	private static String getLeaveString(String nickName) {
		return nickName + "님이 나갔습니다.";
	}
}
