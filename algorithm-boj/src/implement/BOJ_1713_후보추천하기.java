package implement;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-08-30.
 * https://www.acmicpc.net/problem/1713
 * 뭐가 잘못된 거지..
 */

public class BOJ_1713_후보추천하기 {

    private static LinkedList<People> candidate = new LinkedList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//사진틀의 개수
        int allCount = scanner.nextInt();//전체학생 수

        People[] peoples = new People[allCount + 1];
        int[] inputs = new int[allCount + 1];
        for (int i = 1; i <= allCount; i++) {
            peoples[i] = new People(i, 0);
            inputs[i] = scanner.nextInt();
        }

        for (int i = 1; i <= allCount; i++) {
            if (isContains(inputs[i])) {
                continue;
            }
            People people = peoples[inputs[i]];
            people.count = people.count + 1;

            if (candidate.size() < n) {
                candidate.add(people);
            } else {
                Collections.sort(candidate, new Comparator<People>() {
                    @Override
                    public int compare(People o1, People o2) {
                        return Integer.compare(o1.count, o2.count);
                    }
                });
                People remove = candidate.removeFirst();//횟수 적은 것 중 가장 오래된 것 삭제
                peoples[remove.num].count = 0;
                candidate.add(people);
            }
        }

        Collections.sort(candidate, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        //결과 출력
        candidate.forEach(p -> System.out.print(p.num + " "));
    }

    private static boolean isContains(int num) {
        for (People people : candidate) {
            if (people.num == num) {
                people.count = people.count + 1;
                return true;
            }
        }
        return false;
    }
}

class People {
    public int num;
    public int count;

    People(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
