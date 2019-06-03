/**
 * Created by YoungMan on 2019-04-15.
 */

public class Kakao1_1 {

	public static void main(String[] args) {

		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};

		String[] str1 = new String[n];
		String[] str2 = new String[n];

		for(int i=0; i<n; i++) {
			str1[i] = String.format("%05d",Integer.parseInt(Integer.toBinaryString(arr1[i])));
			str2[i] = String.format("%05d",Integer.parseInt(Integer.toBinaryString(arr2[i])));
			System.out.println(str1[i]);
		}

		String[] result = new String[n];

		for(int i=0; i<n; i++) {
			String tmp = "";
			for(int j=0; j<n; j++) {
				if(str1[i].charAt(j) == '0' && str2[i].charAt(j) == '0') {
					tmp = tmp.concat(" ");
					continue;
				}
				tmp = tmp.concat("#");
			}
			result[i] = tmp;
		}

		for(String arr : result) {
			System.out.println(arr);
		}
	}
}
