package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-08-13.
 */

public class PGMS_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		//결과 출력
		int[] result = solution(genres, plays);
		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		Map<Integer, String> genresMap = new HashMap<>();
		Map<Integer, Integer> playsMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genresMap.put(i, genres[i]);
			playsMap.put(i, plays[i]);
		}



		return answer;
	}
}

class Info implements Comparable<Info> {
	int index;
	String genre;
	int play;

	Info(int index, String genre, int play) {
		this.index = index;
		this.genre = genre;
		this.play = play;
	}

	@Override
	public int compareTo(Info o) {
		int result = this.genre.compareTo(o.genre);
		return result;
	}
}
