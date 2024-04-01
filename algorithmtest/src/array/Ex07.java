package array;

import java.util.Arrays;
import java.util.Scanner;

// 백준 11328번 : Strfry
public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			// 문자열의 길이 비교
			if(s1.length() != s2.length()) {
				System.out.println("Impossible");
				continue;
			}
			
			int[] arr = new int[26];
			int[] arr2 = new int[26];
			for(int j=0; j<s1.length(); j++) {
				arr[s1.charAt(j)-'a']++;
				arr2[s2.charAt(j)-'a']++;
			}
			
			if(Arrays.equals(arr, arr2)) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}