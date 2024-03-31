package basic_code_tip;

import java.util.Scanner;

// 백준 2576번 : 홀수
public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int min = 101;
		for(int i=0; i<7; i++) {
			int a = sc.nextInt();
			if(a%2 ==1) {
				sum+=a;
				if(a<min) min = a;
			}
		}
		if(min==101) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
	}
}
