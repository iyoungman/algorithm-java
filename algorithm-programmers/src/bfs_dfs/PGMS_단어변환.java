package bfs_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by YoungMan on 2019-12-07.
 */

public class PGMS_단어변환 {

	public static void main(String[] args) {

	}

	int solution(String begin, String target, String[] words) {
		boolean isContains = false;
		for (String index : words) {
			if (index.equals(target)) {
				isContains = true;
				break;
			}
		}
		if (!isContains) {
			return 0;
		}

		return bfs(begin, target, words);
	}

	private static int bfs(String begin, String target, String[] words) {
		LinkedList<String> queue = new LinkedList();
		queue.offer(begin);
		Map<String, Integer> countMap = new HashMap<>();
		countMap.put(begin, 1);

		int result = 0;
		while (queue.size() != 0) {
			String front = queue.poll();
			int frontNum = countMap.get(front);
			if (front.equals(target)) {
				result = countMap.get(target) - 1;
				break;
			}

			ArrayList<String> nexts = getWords(front, words);
			for (String next : nexts) {
				if (!countMap.containsKey(next)) {
					queue.offer(next);
					countMap.put(next, frontNum + 1);
				}
			}
		}

		return result;
	}

	//현재 글자에서 한 글자만 다른 글자 빼오기
	private static ArrayList<String> getWords(String current, String[] words) {
		ArrayList<String> result = new ArrayList<>();

		char[] currentArray = current.toCharArray();
		for (String word : words) {
			char[] wordArray = word.toCharArray();

			int count = 0;
			for (int i = 0; i < currentArray.length; i++) {
				if (currentArray[i] == wordArray[i]) {
					count++;
				}
			}

			if (count == currentArray.length - 1) {//한글자만 다르면
				result.add(word);
			}
		}

		return result;
	}
}
