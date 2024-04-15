package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2206번 벽 부수고 이동하기
public class Ex16 {
	
	static  int n,m;
	static int[][] board;
	static int[][][] dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Triple> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		dist = new int[n][m][2];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(n==1 && m==1 && Integer.parseInt(s)==0) {
				System.out.println(1);
				return;
			}
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		dist[0][0][0] = 1;
		q.add(new Triple(0,0,0));
		while(!q.isEmpty()) {
			Triple cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				if(board[nx][ny]==0) {
					if(dist[nx][ny][cur.z] == 0) {
						q.add(new Triple(nx,ny,cur.z));
						dist[nx][ny][cur.z] = dist[cur.x][cur.y][cur.z] + 1;
						if(nx == n-1 && ny == m-1) {
							System.out.println(dist[nx][ny][cur.z]);
							return;
						}
					}
				}
				
				if(board[nx][ny]==1) {
					if(cur.z == 0) {
						if(dist[nx][ny][1] == 0) {
							q.add(new Triple(nx,ny,1));
							dist[nx][ny][1] = dist[cur.x][cur.y][cur.z] + 1;
							if(nx == n-1 && ny == m-1) {
								System.out.println(dist[nx][ny][cur.z]);
								return;
							}
						}
					}
				}
			}
		}
		if(q.isEmpty()) System.out.println(-1);
	}
}