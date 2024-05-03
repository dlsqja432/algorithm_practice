package recursion;

import java.util.Scanner;

//백준2447번: 별 찍기 - 10
public class Ex08 {
	static int n;
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		board = new char[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = ' ';
			}
		}
		
		star(0,0,n);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

	static void star(int x, int y,int size) {
		if(size==1) {
			board[x][y] = '*';
			return;
		}
			
		int curSize = size/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) continue;
				star(x + curSize * i, y + curSize * j, curSize);
			}
		}
	}
}
