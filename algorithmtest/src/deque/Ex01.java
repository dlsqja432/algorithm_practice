package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 백준 1021번 회전하는 큐
public class Ex01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			deque.add(i+1);
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int resultSum = 0;
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st2.nextToken());
			int result = 0;
			while(x != deque.getFirst()) {
				deque.addLast(deque.removeFirst());
				result++;
			}
			if(result >= deque.size()-result) {
				result = deque.size()-result;
			}
			resultSum += result;
			deque.removeFirst();
		}
		System.out.println(resultSum);
	}
}






