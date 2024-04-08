package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 2164번 카드2
public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		for(int i=0; i<n-1; i++) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
