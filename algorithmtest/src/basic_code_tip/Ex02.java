package basic_code_tip;

import java.util.Arrays;
import java.util.Scanner;
//백준 2752번 : 세 수 정렬	
public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = {a,b,c};
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				int tmp = 0;
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}

//		Arrays.sort 메소드를 활용한 오름차순 정렬
//		Arrays.sort(arr);
		
		for(int i : arr) System.out.print(i + " ");
	}
}
