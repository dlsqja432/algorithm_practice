package basic_code_tip;

import java.util.Scanner;
//백준 10871번 : X보다 작은 수
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			if(a<x) System.out.print(a + " ");
		}
	}
}
