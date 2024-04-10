package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex05 {
	
	static int n,k;
	static int[] dist = new int[100001];
	static int[] dx = {-1, 1, 2};
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n==k) {
			System.out.println(0);
			return;
		}
		
		dist[n] = 0;
		q.add(n);
		while(!q.isEmpty()) {
			int cur = q.poll();
			int x = 0;
			for(int dir=0; dir<3; dir++) {
				if(dir==2) {
					x = cur*dx[dir];
				} else {
					x = cur + dx[dir];
				}
				if(x == k) {
					System.out.println(dist[cur]+1);
					return;
				}
				if(x<0 || x>=100001) continue;
				if(dist[x] >= 1) continue; 
				dist[x] = dist[cur] + 1;
				q.add(x);
			}
		}
	}
}