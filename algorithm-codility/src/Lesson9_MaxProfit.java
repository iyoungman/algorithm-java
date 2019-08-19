import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YoungMan on 2019-08-19.
 */

public class Lesson9_MaxProfit {

    public static void main(String[] args) {
        int[] a = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(a));
    }

    private static int solution(int[] a) {
        int[][] all = new int[a.length][2];

        for (int i = 0; i < a.length; i++) {
            all[i][0] = i;
            all[i][1] = a[i];
        }

        Arrays.sort(all, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);//오름 차순
            }
        });

        int max = 0;
        for (int i = 0; i < all.length; i++) {
            for (int j = all.length - 1; j >= i + 1; j--) {
                if (all[i][0] < all[j][0]) {
                    int temp = all[j][1] - all[i][1];
                    max = Math.max(max, temp);
                    break;
                }
            }
        }

        return max;
    }

}
