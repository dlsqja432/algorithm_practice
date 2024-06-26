package bfs;
// 백준 7576번 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex03 {
	
	static int[][] box = new int[1001][1001];
	static boolean[][] vis = new boolean[1001][1001];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair2> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Pair2> pArr = new ArrayList<>();
		int min_date = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int a = Integer.parseInt(st.nextToken());
				box[i][j] = a;
				if(a == 1) {
					pArr.add(new Pair2(i,j,0));
				}
			}
		}
		
		for(Pair2 p : pArr) {
			queue.add(p);
			vis[p.x][p.y] = true;
		}
		
		while(!queue.isEmpty()) {
			Pair2 cur = queue.peek();
			queue.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(vis[nx][ny] || box[nx][ny] == -1) continue;
				vis[nx][ny] = true;
				box[nx][ny] = 1;
				Pair2 p = new Pair2(nx,ny,cur.len+1);
				queue.add(p);
				min_date = Math.max(min_date, p.len);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(min_date);
	}
}


















