package basic_code_tip;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2587번 : 대표값2
public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}
}
