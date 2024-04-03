package stack;

import java.util.Scanner;
import java.util.Stack;

// 백준 10773번 제로
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			int x =  sc.nextInt();
			if(x==0 && !stack.isEmpty()) {
				stack.pop();
			}
			
			if(x!=0) {
				stack.push(x);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
