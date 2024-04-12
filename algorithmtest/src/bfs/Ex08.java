package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7569번 토마토

class Triple {
	int x;
	int y;
	int z;
	
	public Triple(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Ex08 {

	static int n,m,h;
	static int[][][] board;
	static int[][][] dist;
	static boolean[][][] vis;
	static int[] dx = {1, 0, -1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static Queue<Triple> q = new LinkedList<>();
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		board = new int[n][m][h];
		dist = new int[n][m][h];
		vis = new boolean[n][m][h];
		int count = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++) {
					board[j][k][i] = Integer.parseInt(st.nextToken());
					dist[j][k][i] = -1;
					if(board[j][k][i] == 1) {
						q.add(new Triple(j,k,i));
						vis[j][k][i] = true;
						dist[j][k][i] = 0;
					}
					if(board[j][k][i] == 0) {
						count++;
					}
				}
			}
		}
		
		if(count == 0) {
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {
			Triple cur = q.poll();
			for(int dir=0; dir<6; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int nz = cur.z + dz[dir];
				if(nx<0 || nx>=n || ny<0 || ny>=m || nz<0 || nz>=h) continue;
				if(vis[nx][ny][nz] || board[nx][ny][nz]==1 || board[nx][ny][nz]==-1) continue;					
				vis[nx][ny][nz] = true;
				board[nx][ny][nz] = 1;
				q.add(new Triple(nx,ny,nz));
				dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z]+1;
				max = Math.max(max, dist[nx][ny][nz]);
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(board[j][k][i] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(max);
	}
}



















