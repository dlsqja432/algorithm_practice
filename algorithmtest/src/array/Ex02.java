package array;

import java.util.Scanner;

// 백준 2577번 : 숫자의 개수
public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		String s = String.valueOf(a*b*c);
		int[] arr = new int[10];
		
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'0']++;
		}
		
		for(int i : arr) System.out.println(i);
	}
}
