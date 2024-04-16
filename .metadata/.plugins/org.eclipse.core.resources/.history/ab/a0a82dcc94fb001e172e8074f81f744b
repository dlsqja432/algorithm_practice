package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2573번 빙산
public class Ex18 {

	static int n,m;
	static int[][][] board;
	static boolean[][] vis;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Triple> q = new LinkedList<>();
	static int area = 0, count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m][2];
		vis = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(area >= 2) {
			area = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j][0]==0 && vis[i][j]==false) {
						vis[i][j] = true;
						q.add(new Triple(i,j,0));
						while(!q.isEmpty()) {
							Triple cur = q.peek();
							for(int dir=0; dir<4; dir++) {
								int nx = cur.x + dx[dir];
								int ny = cur.y + dy[dir];
								if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
								if((board[nx][ny][0]==0 && board[nx]))
							}
						}
					}
				}
			}
		}
	}
}
