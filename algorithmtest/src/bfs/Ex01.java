package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


//백준 1926번 그림
public class Ex01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Pair> queue = new LinkedList<>();
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int[][] board = new int[n][m];
		boolean[][] visited = new boolean[n][m];  
		
		
		// 2차원 배열에 값 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		
		// 그림을 찾고 그림의 넓이 구하기
		int count = 0;	// 그림의 개수
		int max = 0;	// 가장 큰 그림 넓이
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1 && visited[i][j] == false) {
					int area = 0;	// 그림 넓이
					count++;
					queue.add(new Pair(i,j));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Pair cur = queue.peek();
						queue.poll();
						area++;
						for(int dir=0; dir<4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
							if(visited[nx][ny] || board[nx][ny] == 0) continue;
							visited[nx][ny] = true;
							queue.add(new Pair(nx,ny));
						}
					}
					max = Math.max(max, area);
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
}