package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	int num;
	int index;
	
	public Node(int num, int index) {
		this.num = num;
		this.index = index;
	}
}

// 백준 11003번 최솟값 찾기
public class Ex03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Node> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(input.nextToken());
			Node node = new Node(x, i);
			
			while(!deque.isEmpty() && deque.peekLast().num > x) {
				deque.pollLast();
			}
			
			if(!deque.isEmpty() && deque.peekFirst().index == i-m) {
				deque.pollFirst();
			}
			
			deque.addLast(node);
			
			sb.append(deque.peekFirst().num + " ");
		}
		System.out.println(sb);
	}
}
