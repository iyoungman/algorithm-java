package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by YoungMan on 2019-04-18.
 * https://www.acmicpc.net/problem/11656
 */

public class BOJ_11656_접미사배열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.substring(i));
        }

        Collections.sort(list);

        for (String index : list) {
            System.out.println(index);
        }
    }
}
