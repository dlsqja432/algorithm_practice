package recursion;

import java.util.Scanner;

//백준 1074번 : Z
public class Ex03 {

	public static void main(String[] args) {
		//1. 함수의 정의
		//int func(int n, int r, int c)
		//2^n X 2^n 배열에서 (r,c)를 방문하는 순서를 반환하는 함수
		
		//2. base condition
		//n=0일 때 return 0;
		
		//3. 재귀 식
		//(r,c)가 1번 사각형일 때 : return func(n-1, int r, int c);
		//(r,c)가 2번 사각형일 때 : return half*half + func(n-1, r, c-half);
		//(r,c)가 3번 사각형일 때 : return 2*half*half + func(n-1, r-half, c);
		//(r,c)가 4번 사각형일 때 : return 3*half*half + func(n-1, r-half, c-half);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(visit(n,r,c));
	}
	
	static int visit(int n, int r, int c) {
		if(n==0) return 0;
		int half =(int) Math.pow(2, n-1);
		if(r<half && c<half) {
			return visit(n-1, r,c);
		} if(r<half && c>=half) {
			return half*half + visit(n-1,r,c-half);
		} if(r>=half && c<half) {
			return 2*half*half + visit(n-1,r-half,c);
		} 
		return 3*half*half + visit(n-1, r-half, c-half);
	}
}
