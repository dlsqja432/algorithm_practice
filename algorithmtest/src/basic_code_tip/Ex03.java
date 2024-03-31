package basic_code_tip;

import java.util.Scanner;
//백준 2753번 : 윤년
public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		yunYear(n);
	}
	
	public static void yunYear(int n) {
		if((n%4==0 && n%100!=0) || n%400==0) System.out.println(1);
		else System.out.println(0);
	}
}
