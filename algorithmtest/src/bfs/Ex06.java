package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1012번 유기농 배추
public class Ex06 {
	
	static int t;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int p=0; p<t; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][m];
			boolean[][] vis = new boolean[n][m];
			int area = 0;
			Queue<Pair> q = new LinkedList<>();
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				board[b][a] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] == 1 && vis[i][j] == false) {
						q.add(new Pair(i,j));
						vis[i][j] = true;
						area++;
						while(!q.isEmpty()) {
							Pair cur = q.poll();
							for(int dir=0; dir<4; dir++) {
								int nx = cur.x + dx[dir];
								int ny = cur.y + dy[dir];
								if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
								if(vis[nx][ny] || board[nx][ny]==0) continue;
								vis[nx][ny] = true;
								q.add(new Pair(nx,ny));
							}
						}
					}
				}
			}
			System.out.println(area);
		}
	}
}