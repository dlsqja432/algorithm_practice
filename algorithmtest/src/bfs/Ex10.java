package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 5427번 불
public class Ex10 {
	
	static int t,m,n;
	static char[][] board;
	static int[][] sdist;
	static int[][] fdist;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q1 = new LinkedList<>();
	static Queue<Pair> q2 = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int z=0; z<t; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			board = new char[n][m];
			sdist = new int[n][m];
			fdist = new int[n][m];
			
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					board[i][j] = s.charAt(j);
					sdist[i][j] = -1;
					fdist[i][j] = -1;
					if(s.charAt(j) == '*') {
						fdist[i][j] = 0;
						q1.add(new Pair(i,j));
					}
					if(s.charAt(j) == '@') {
						sdist[i][j] = 0;
						q2.add(new Pair(i,j));
					}
				}
			}
			
			while(!q1.isEmpty()) {
				Pair cur = q1.poll();
				for(int dir=0; dir<4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
					if(fdist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
					fdist[nx][ny] = fdist[cur.x][cur.y] + 1;
					q1.add(new Pair(nx,ny));
				}
			}
			
			a:
			while(!q2.isEmpty()) {
				Pair cur = q2.poll();
				for(int dir=0; dir<4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					if(nx<0 || nx>=n || ny<0 || ny>=m) {
						System.out.println(sdist[cur.x][cur.y]+1);
						q2.add(cur);
						break a;
					}
					if(sdist[nx][ny] != -1 || board[nx][ny] == '#') continue;
					if(sdist[cur.x][cur.y]+1 >= fdist[nx][ny] && fdist[nx][ny] != -1) continue;
					sdist[nx][ny] = sdist[cur.x][cur.y] + 1;
					q2.add(new Pair(nx,ny));
				}
			}
			
			if(q2.isEmpty()) {
				System.out.println("IMPOSSIBLE");
			}
			q1.clear();
			q2.clear();
		}
	}
}
