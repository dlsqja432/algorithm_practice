package basic_code_tip;

import java.util.Scanner;
//백준 2562번 : 최댓값
public class Ex13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>max) max=arr[i];
		}
		
		for(int i=0; i<9; i++) {
			if(arr[i] == max) {
				System.out.println(max);
				System.out.println(i+1);
				break;
			}
		}
	}
}
