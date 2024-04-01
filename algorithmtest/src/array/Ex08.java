package array;

import java.util.Scanner;

// 백준 1919번 : 애너그램 만들기
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		
		for(int i=0; i<s1.length(); i++) {
			arr1[s1.charAt(i)-'a']++;
		}
		
		for(int i=0; i<s2.length(); i++) {
			arr2[s2.charAt(i)-'a']++;
		}
		
		int sum = 0;
		for(int i=0; i<26; i++) {
			if(arr1[i]!=0 && arr2[i]!=0) {
				sum += Math.min(arr1[i],arr2[i]);
			}
		}
		
		System.out.println((s1.length()-sum) + (s2.length()-sum));
	}
}