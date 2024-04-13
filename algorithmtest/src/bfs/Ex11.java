package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2583번 영역구하기
public class Ex11 {
	
	static int n,m,k;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		vis = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=0; j<y2-y1; j++) {
				for(int t=0; t<x2-x1; t++) {
					board[n-y1-j-1][x1+t] = 1;
				}
			}
		}
		
		ArrayList<Integer> areaList = new ArrayList<>();
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j]==0 && vis[i][j]==false) {
					int area = 0;
					count++;
					q.add(new Pair(i,j));
					vis[i][j] = true;
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						area++;
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
							if(vis[nx][ny] || board[nx][ny]==1) continue;
							vis[nx][ny] = true;
							q.add(new Pair(nx,ny));
						}
					}
					areaList.add(area);
				}
			}
		}
		
		int[] arr = new int[count];
		for(int i=0; i<count; i++) {
			arr[i] = areaList.get(i);
		}
		Arrays.sort(arr);
		System.out.println(count);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
