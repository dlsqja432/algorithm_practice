package stack_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 3986번 좋은 단어
public class Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				if(!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
					continue;
				}
				
				if(stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
				}
			}
			if(stack.isEmpty()) count++;
		}
		System.out.println(count);
	}
}