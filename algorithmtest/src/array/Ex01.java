package array;

import java.util.Scanner;

// 백준 10808번 : 알파벳 개수
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			int a = s.charAt(i) - 'a';
			arr[a]++;
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
