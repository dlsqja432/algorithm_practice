package basic_code_tip;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2309번 : 일곱 난쟁이
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		// 9개 수의 합에서 나올 수 있는 모든 2개 수의 조합을 빼서 100이 나오는 걸 구함
		outerloof:
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-arr[i]-arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break outerloof;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i=2; i<9; i++) {
			System.out.println(arr[i]);
		}
	}
}
