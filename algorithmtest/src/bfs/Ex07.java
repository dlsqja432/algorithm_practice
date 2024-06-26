package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 10026번 적록색약
public class Ex07 {

	static char[][] board;
	static boolean[][] avis;
	static boolean[][] bvis;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();
	static int asum=0,bsum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		avis = new boolean[n][n];
		bvis = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		// 정상인 bfs
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(avis[i][j] == false) {
					q.add(new Pair(i,j));
					avis[i][j] = true;
					asum++;
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
							if(avis[nx][ny] || board[nx][ny]!=board[cur.x][cur.y]) continue;
							avis[nx][ny] = true;
							q.add(new Pair(nx,ny));
						}
					}
				}
			}
		}
		q.clear();
		// 적록색약 bfs
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if((board[i][j] == 'R' || board[i][j] == 'G') && bvis[i][j] == false) {
					q.add(new Pair(i,j));
					bvis[i][j] = true;
					bsum++;
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
							if(bvis[nx][ny] || board[nx][ny]=='B') continue;
							bvis[nx][ny] = true;
							q.add(new Pair(nx,ny));
						}
					}
				}
				if(board[i][j] == 'B' && bvis[i][j] == false) {
					q.add(new Pair(i,j));
					bvis[i][j] = true;
					bsum++;
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
							if(bvis[nx][ny] || board[nx][ny]!='B') continue;
							bvis[nx][ny] = true;
							q.add(new Pair(nx,ny));
						}
					}
				}
			}
		}
		System.out.println(asum + " " + bsum);
	}
}







