package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
	static int n;
	static int[][] paper;
	static int[] count = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,n);
		
		System.out.println(count[0]);
		System.out.println(count[1]);
	}
	
	static void divide(int x, int y, int size) {
		if(check(x,y,size)) {
			count[paper[x][y]]++;
			return;
		}
		
		int curSize = size / 2;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				divide(x + i * curSize, y + j * curSize, curSize);
			}
		}
	}
	
	static boolean check(int x, int y, int size) {
		int curNum = paper[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(paper[i][j] != curNum) {
					return false;
				}
			}
		}
		return true;
	}
}
