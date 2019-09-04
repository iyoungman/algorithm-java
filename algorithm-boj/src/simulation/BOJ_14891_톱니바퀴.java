package simulation;

import java.util.Scanner;

/**
 * Created by YoungMan on 2019-09-01.
 * https://www.acmicpc.net/problem/14891
 */

public class BOJ_14891_톱니바퀴 {

    private static int[][] gearWheelState = new int[4][8];

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                gearWheelState[i][j] = stoi(input.substring(j, j + 1));
            }
        }

        int num = scanner.nextInt();//회전 수
        for (int i = 0; i < num; i++) {
            int gearWheels = scanner.nextInt();//회전 톱니바퀴
            int direction = scanner.nextInt();//방향

            checkLeft(gearWheels, -direction);
            checkRight(gearWheels, -direction);
            if (direction == 1) {//자기자신 회전
                rotationRight(gearWheels - 1);
            } else {
                rotationLeft(gearWheels - 1);
            }
        }

        //결과 출력
        System.out.println(getScore());
    }

    private static void checkLeft(int gearWheels, int direction) {
        int num = gearWheels - 1;
        if (num == 0) {
            return;
        }
        if (gearWheelState[num][6] != gearWheelState[num - 1][2]) {
            checkLeft(gearWheels - 1, -direction);
            if (direction == 1) {
                rotationRight(num - 1);
            } else {
                rotationLeft(num - 1);
            }
        }
    }

    private static void checkRight(int gearWheels, int direction) {
        int num = gearWheels - 1;
        if (num == 3) {
            return;
        }
        if (gearWheelState[num][2] != gearWheelState[num + 1][6]) {
            checkRight(gearWheels + 1, -direction);
            if (direction == 1) {
                rotationRight(num + 1);
            } else {
                rotationLeft(num + 1);
            }
        }
    }

    //반 시계
    private static void rotationLeft(int num) {
        int temp = gearWheelState[num][0];
        for (int i = 0; i < 7; i++) {
            gearWheelState[num][i] = gearWheelState[num][i + 1];
        }
        gearWheelState[num][7] = temp;
    }

    //시계
    private static void rotationRight(int num) {
        int temp = gearWheelState[num][7];
        for (int i = 7; i > 0; i--) {
            gearWheelState[num][i] = gearWheelState[num][i - 1];
        }
        gearWheelState[num][0] = temp;
    }

    private static int getScore() {
        int score = 0;
        int[] list = {1, 2, 4, 8};

        for (int i = 0; i < 4; i++) {
            if (gearWheelState[i][0] == 1) {//S극이면
                score = score + list[i];
            }
        }
        return score;
    }

}
