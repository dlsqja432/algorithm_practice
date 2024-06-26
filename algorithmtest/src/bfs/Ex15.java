package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 6593번 상범 빌딩
public class Ex15 {
	
	static int h,n,m;
	static char[][][] board;
	static int[][][] dist;
	static int[] dx = {1, 0, -1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static Queue<Triple> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine()) != null) {
			if(s.equals("0 0 0")) return;
			
			StringTokenizer st = new StringTokenizer(s);
			h = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			board = new char[h][n][m];
			dist = new int[h][n][m];
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<n; j++) {
					String input = br.readLine();
					if(input.isEmpty()) {
						j--;
						continue;
					}
					for(int k=0; k<m; k++) {
						board[i][j][k] = input.charAt(k);
						dist[i][j][k] = -1;
						if(board[i][j][k] == 'S') {
							q.add(new Triple(j,k,i));
							dist[i][j][k] = 0;
						}
					}
				}
			}
			br.readLine();
			a:
			while(!q.isEmpty()) {
				Triple cur = q.poll();
				for(int dir=0; dir<6; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					int nz = cur.z + dz[dir];
					if(nx<0 || nx>=n || ny<0 || ny>=m || nz<0 || nz>=h) continue;
					if(dist[nz][nx][ny]>=0 || board[nz][nx][ny]=='#') continue;
					if(board[nz][nx][ny]=='E') {
						System.out.println("Escaped in " + (dist[cur.z][cur.x][cur.y]+1) + " minute(s).");
						q.add(new Triple(nx,ny,nz));
						break a;
					}
					dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
					q.add(new Triple(nx,ny,nz));
				}
			}
			
			if(q.isEmpty()) {
				System.out.println("Trapped!");
			}
			q.clear();
		}
	}
}
