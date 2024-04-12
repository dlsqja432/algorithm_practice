package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7562번 나이트의 이동
public class Ex09 {
	
	static int t,x,y;
	static int[][] board;
	static int[][] dist;
	static boolean[][] vis;
	static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
	static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int z=0; z<t; z++) {
			int n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			dist = new int[n][n];
			vis = new boolean[n][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;
			q.add(new Pair(x,y));
			vis[x][y] = true;
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(vis[x][y]) {
				System.out.println(0);
				q.clear();
				continue;
			}
			board[x][y] = 1;
			
			
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				for(int dir=0; dir<8; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					if(vis[nx][ny]) continue;
					if(board[nx][ny] == 1 && vis[nx][ny] == false) {
						System.out.println(dist[cur.x][cur.y]+1);
						q.clear();
						break;
					}
					vis[nx][ny] = true;
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					q.add(new Pair(nx,ny));
				}
			}
			q.clear();
		}
	}
}
