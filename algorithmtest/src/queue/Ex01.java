package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 10845번 큐
public class Ex01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
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
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.poll());
				break;
			case "front":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peek());
				break;
			case "back":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(back);
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if(queue.isEmpty()) System.out.println("1");
				else System.out.println("0");
				break;
			}
		}
	}
}