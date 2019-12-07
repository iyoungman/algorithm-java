package sort;

import java.util.*;

/**
 * Created by YoungMan on 2019-08-06.
 * https://www.acmicpc.net/problem/10814
 * Stable Sort : Default
 */

public class BOJ_10814_나이순정렬 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		List<Member> members = new ArrayList<>();

		//입력
		for (int i = 0; i < n; i++) {
			String[] line = scanner.nextLine().split(" ");
			members.add(new Member(Integer.parseInt(line[0]), line[1]));
		}

		members.sort(new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		});

		//결과 출력
		for(Member member : members) {
			System.out.println(member.getAge() + " " + member.getName());
		}
	}
}


class Member {
	private int age;
	private String name;

	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}

	int getAge() {
		return age;
	}

	String getName() {
		return name;
	}
}
