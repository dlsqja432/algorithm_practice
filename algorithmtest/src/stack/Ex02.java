package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 1874번 스택 수열
public class Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> reverse_stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=n; i>=1; i--) {
			reverse_stack.push(i);
		}
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(stack.isEmpty() || stack.peek() < x) {
				while(reverse_stack.peek() != x) {
					stack.push(reverse_stack.pop());
					sb.append("+\n");
				}
				stack.push(reverse_stack.pop());
				sb.append("+\n");
			}
			
			if(stack.peek() == x) {
				stack.pop();
				sb.append("-\n");
			}
			
			if(!stack.isEmpty()) {
				if(stack.peek() > x) {
					bw.write("NO");
					bw.flush();
					return;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}