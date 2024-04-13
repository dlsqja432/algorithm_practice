package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 5014번 스타트링크
public class Ex13 {

	static int f, s, g, u, d;
	static int[] board;
	static boolean[] vis;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		if(s==g) {
			System.out.println(0);
			return;
		}
		
		int[] dx = {u, d*(-1)};
		vis = new boolean[f];
		board = new int[f];
		board[s-1] = 1;
		board[g-1] = 1;
		vis[s-1] = true;
		q.add(new Pair(s-1, 0));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int dir=0; dir<2; dir++) {
				int nx = cur.x + dx[dir];
				if(nx<0 || nx>=f) continue;
				if(vis[nx]) continue;
				if(board[nx]==1 && vis[nx]==false) {
					System.out.println(cur.y + 1);
					return;
				}
				vis[nx] = true;
				q.add(new Pair(nx, cur.y+1));
			}
		}
		
		System.out.println("use the stairs");
	}	
}
