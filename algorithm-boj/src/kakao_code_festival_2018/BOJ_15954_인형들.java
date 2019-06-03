/*
package kakao_code_festival_2018;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * Created by YoungMan on 2019-05-06.
 *//*


public class BOJ_15954_인형들 {

	public static void main(String[] args) {

		int k = 3;
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
		double average = values.stream()
				.mapToDouble(s -> s.doubleValue())
				.average()
				.getAsDouble();
		System.out.println(average);

		*/
/*double dispersion = Arrays.stream(values)
				.mapToDouble(value -> Math.pow((value - average), 2))
				.average()
				.getAsDouble();*//*


		List<Double> dispersionList = new ArrayList<>();
		for (int i = 0; i < values.size() - 2; i++) {
			double dispersion = 0;

			for (int j = k; j < values.size() - 2; j++) {
				dispersion = dispersion +


			}
			double dispersion = Math.pow((values[i] - average), 2)
					+ Math.pow((values[i] - average), 2)
					+ Math.pow((values[i] - average), 2);
			dispersionList.add()
		}

		System.out.println(dispersion);

		double standardDeviation = Math.sqrt(dispersion);
		System.out.println(standardDeviation);
	}
}
*/
