package bfs;
//백준 4179번 불!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex04 {
	
	static char[][] maze;
	static int[][] fdist; 
	static int[][] jdist; 
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q1 = new LinkedList<>();
	static Queue<Pair> q2 = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		maze = new char[n][m];
		fdist = new int[n][m]; 
		jdist = new int[n][m];
		
		// 배열 초기화
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = s.charAt(j);
				fdist[i][j] = -1;
				jdist[i][j] = -1;
				if(maze[i][j] == 'F') {
					q1.add(new Pair(i,j));
					fdist[i][j] = 0;
				}
				if(maze[i][j] == 'J') {
					q2.add(new Pair(i,j));
					jdist[i][j] = 0;
				}
			}
		}
		
		// 불에 대한 BFS
		while(!q1.isEmpty()) {
			Pair cur = q1.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(fdist[nx][ny]>=0 || maze[nx][ny]=='#') continue;
				fdist[nx][ny] = fdist[cur.x][cur.y]+1;
				q1.add(new Pair(nx,ny));
			}
		}
		
		// 지훈이에 대한 BFS
		while(!q2.isEmpty()) {
			Pair cur = q2.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				// 범위를 벗어났다는 것은 탈출에 성공했다는 의미
				if(nx<0 || nx>=n || ny<0 || ny>=m) {
					System.out.println(jdist[cur.x][cur.y]+1);
					return;
				}
				if(jdist[nx][ny]>=0 || maze[nx][ny] =='#') continue;
				// 불의 전파 시간을 조건에 추가
				if(jdist[cur.x][cur.y]+1 >= fdist[nx][ny] && fdist[nx][ny] != -1) continue;
				jdist[nx][ny] = jdist[cur.x][cur.y] + 1;
				q2.add(new Pair(nx, ny));
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}

















