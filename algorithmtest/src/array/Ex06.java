package array;

import java.util.Scanner;

// 백준 13300번 : 방 배정
public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[2][7];
		
		for(int i=0; i<n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			arr[s][y]++;
		}
		
		int sum = 0;
		for(int i=0; i<2; i++) {
			for(int j=1; j<=6; j++) {
				sum += (arr[i][j]+k-1)/k;
			}
		}
		System.out.println(sum);
	}
}
