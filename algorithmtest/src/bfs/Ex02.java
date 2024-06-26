package bfs;
//백준 2178번 미로 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair2 {
	int x;
	int y;
	int len;
	
	public Pair2(int x, int y, int len) {
		this.x = x;
		this.y = y;
		this.len = len;
	}
}

public class Ex02 {
	
	static int[][] maze = new int[101][101];
	static boolean[][] vis = new boolean[101][101];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Pair2> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
				vis[i][j] = false;
			}
		}
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		queue.add(new Pair2(0,0,1));
		vis[0][0] = true;
		while(!queue.isEmpty()) {
			Pair2 cur = queue.peek();
			queue.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(vis[nx][ny] || maze[nx][ny]==0) continue;
				vis[nx][ny] = true;
				Pair2 p = new Pair2(nx,ny,cur.len+1);
				queue.add(p);
				if(nx==n-2 && ny==m-1) a = p.len;
				if(nx==n-1 && ny==m-2) b = p.len;
			}
		}
		
		System.out.println(Math.min(a, b)+1);
	}	
}










