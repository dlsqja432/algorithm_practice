package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 18258번 큐2
public class Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int back = -1;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
			case "push": 
				int a = Integer.parseInt(st.nextToken());
				queue.add(a);
				back = a;
				break;
			case "pop":
				if(queue.isEmpty()) sb.append(-1).append("\n");
				else sb.append(queue.poll()).append("\n");
				break;
			case "front":
				if(queue.isEmpty()) sb.append(-1).append("\n");
				else sb.append(queue.peek()).append("\n");
				break;
			case "back":
				if(queue.isEmpty()) sb.append(-1).append("\n");
				else sb.append(back).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if(queue.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}