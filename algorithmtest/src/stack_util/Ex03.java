package stack_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean sw = true;
			
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				if(c == '(') {
					stack.push(c);
				}
				if(c == ')') {
					if(!stack.isEmpty() && stack.peek()=='(') {
						stack.pop();
					} else {
						sb.append("NO\n");
						sw = false;
						break;
					}
				}
			}
			if(sw) {
				if(stack.isEmpty()) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
}
