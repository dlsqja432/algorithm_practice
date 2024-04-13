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
	static int[][] dist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Triple> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		dist = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
				dist[i][j] = -1;
			}
		}
		
		dist[0][0] = 1;
		q.add(new Triple(0,0,0));
		while(!q.isEmpty()) {
			Triple cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(dist[nx][ny]>=1 || (board[nx][ny]==1 && cur.z==1)) continue;
				if(nx==n-1 && ny==m-1) {
					System.out.println(dist[cur.x][cur.y]+1);
					return;
				}
				if(board[nx][ny]==1 && cur.z==0) {
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					q.add(new Triple(nx,ny,1));
				}
				if(board[nx][ny]==0) {
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					q.add(new Triple(nx,ny,cur.z));
				}
			}
		}
		System.out.println(-1);
	}
}
