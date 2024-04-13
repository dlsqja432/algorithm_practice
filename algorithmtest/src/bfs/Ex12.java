package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//백준 2667번 단지번호 붙이기
public class Ex12 {
	
	static int n;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		vis = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		int count = 0;
		ArrayList<Integer> areaList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]==1 && vis[i][j]==false) {
					int area = 0;
					count++;
					vis[i][j] = true;
					q.add(new Pair(i,j));
					while(!q.isEmpty()) {
						Pair cur = q.poll();
						area++;
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
							if(vis[nx][ny] || board[nx][ny]==0) continue;
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
			System.out.println(i);
		}
	}
}
