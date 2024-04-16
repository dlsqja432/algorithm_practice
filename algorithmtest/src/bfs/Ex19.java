package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2146번 다리 만들기
public class Ex19 {
	
	static int n;
	static int[][][] board;
	static boolean[][] vis;
	static int[][] dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Triple> q = new LinkedList<>(); 
	static int area = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n][10001];
		vis = new boolean[n][n];
		dist = new int[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j][0] == 1 && vis[i][j]==false) {
					area++;
					vis[i][j] = true;
					q.add(new Triple(i,j,area));
					
				}
				
				while(!q.isEmpty()) {
				}
			}
		}
	}
}
