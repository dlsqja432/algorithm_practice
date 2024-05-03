package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1780번: 종이의 개수
public class Ex05 {
	static int[][] paper;
	static int n;
	static int[] count = new int[3]; //-1, 0, 1의 개수를 저장하는 배열
	
	public static void main(String[] args) throws IOException {
		//1. 함수의 정의
		//void paper(int x, int y, int size)
		
		//2. base condition
		//if(check(x,y,size)) {
		//	count[paper[x][y]+1]++;
		//	return; }
		
		//3. 재귀 식
		//divide(x + i * newSize, y + j * newSize, newSize);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, n);
		
		for(int i : count) {
			System.out.println(i);
		}
	}
	
	static void divide(int x, int y, int size) {
		if(check(x,y,size)) {
			count[paper[x][y]+1]++;
			return;
		}
		
		int newSize = size/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				divide(x + i * newSize, y + j * newSize, newSize);
			}
		}
	}
	
	static boolean check (int x, int y, int size) {
		int num = paper[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(paper[i][j]!=num)
				return false;
			}
		}
		return true;
	}
}