package stack_queue;

import java.util.Arrays;

/**
 * Created by YoungMan on 2019-09-16.
 */

public class PGMS_주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    private static int[] solution(int[] prices) {

        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int temp = -1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < price) {
                    temp = j;
                    break;
                }
            }

            if (temp == -1) {
                result[i] = prices.length - (i + 1);
            } else {
                result[i] = temp - i;
            }
        }

        return result;
    }
}
