package basic_code_tip;

import java.util.Scanner;

// 백준 1267번 : 핸드폰 요금
public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int y = 0;
		int m = 0;
		
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			y+=(a/30+1)*10;
			
			m+=(a/60+1)*15;
		}
		
		if(y>m) {
			System.out.println("M " + m);
		} else if(y==m){
			System.out.println("Y M " + y);
		} else {
			System.out.println("Y " + y);
		}
	}
}
