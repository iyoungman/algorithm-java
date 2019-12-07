package search;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-12-01.
 * https://www.acmicpc.net/problem/14226
 * 정점이 같더라도 클립보드에 어떤 내용이 들어있는지에 따라 탐색할 수 있는 정점이 달라진다
 */

public class BOJ_14226_이모티콘 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println(getMin(n));
	}

	private static int getMin(int n) {
		LinkedList<Emoticon> emoticons = new LinkedList<>();
		emoticons.add(new Emoticon(1, 0, 0));
		boolean[][] isVisit = new boolean[2002][2002];//[현재 이모티콘 개수][클립 보드 수] = 시간
		isVisit[1][0] = true;//방문 체크

		int result = 0;
		while (emoticons.size() != 0) {
			Emoticon emoticon = emoticons.poll();
			if (emoticon.current == n) {
				result = emoticon.time;
				break;
			}

			int current = emoticon.current;
			int clipBoard = emoticon.clipBoard;
			int time = emoticon.time;

			//2. 복사
			if (current + clipBoard < 2002 && !isVisit[current + clipBoard][clipBoard]) {
				emoticons.add(new Emoticon(current + clipBoard, clipBoard, time + 1));
				isVisit[current + clipBoard][clipBoard] = true;
			}

			//1. 붙여넣기
			if (!isVisit[current][current]) {
				emoticons.add(new Emoticon(current, current, time + 1));
				isVisit[current][current] = true;
			}

			//3. 삭제
			if (current - 1 >= 0 && !isVisit[current - 1][clipBoard]) {
				emoticons.add(new Emoticon(current - 1, clipBoard, time + 1));
				isVisit[current - 1][clipBoard] = true;
			}
		}

		return result;
	}
}

class Emoticon {
	int current;//현재 이모티콘 개수
	int clipBoard;//클립 보드 개수
	int time;//시간

	Emoticon(int current, int clipBoard, int time) {
		this.current = current;
		this.clipBoard = clipBoard;
		this.time = time;
	}
}
