package basic_code_tip;

import java.util.Scanner;

// 백준 2490번 : 윷놀이
public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int sum = a+b+c+d;
			switch(sum) {
				case 0:
					System.out.println("D");
					break;
				case 1:
					System.out.println("C");
					break;
				case 2:
					System.out.println("B");
					break;
				case 3:
					System.out.println("A");
					break;
				default :
					System.out.println("E");
			}		
		}
	}
}
