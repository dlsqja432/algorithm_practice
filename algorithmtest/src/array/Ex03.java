package array;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1475번 : 방 번호
public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[10];
		
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i)-'0']++;
		}
		
		int a = 0;
		if((arr[6]+arr[9])%2==1) {
			a = (arr[6]+arr[9])/2+1;
		} else a = (arr[6]+arr[9])/2;
		arr[6] = a;
		arr[9] = a;
		Arrays.sort(arr);
		System.out.println(arr[9]);
	}
}
