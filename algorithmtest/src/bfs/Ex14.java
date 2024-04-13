package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2468번 안전 영역
public class Ex14 {
	
	static int n;
	static Pair[][] board;
	static boolean[][] vis;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int maxArea = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new Pair[n][n];
		vis = new boolean[n][n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				board[i][j] = new Pair(a,0);
				min = Math.min(min, a);
				max = Math.max(max, a);
			}
		}
		
		if(max == min) {
			System.out.println(1);
			return;
		}

		for(int z=min; z<max; z++) {
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j].x == z) {
						board[i][j].y = 1;
					}
					vis[i][j] = false;
				}
			}
			
			int area = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j].y == 0 && vis[i][j]==false) {
						area++;
						q.add(new Pair(i,j));
						vis[i][j] = true;
						while(!q.isEmpty()) {
							Pair cur = q.poll();
							for(int dir=0; dir<4; dir++) {
								int nx = cur.x + dx[dir];
								int ny = cur.y + dy[dir];
								if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
								if(vis[nx][ny] || board[nx][ny].y == 1) continue;
								vis[nx][ny] = true;
								q.add(new Pair(nx,ny));
							}
						}
					}
				}
			}
			maxArea = Math.max(area, maxArea);
		}
		System.out.println(maxArea);
	}
}
