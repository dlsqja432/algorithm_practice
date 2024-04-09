package stack_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 4949번 균형잡힌 세상
public class Ex01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s=br.readLine()) != null) {
			Stack<Character> stack = new Stack<>();
			boolean sw = true;
			if(s.equals(".")) break;
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				
				if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						sb.append("no\n");
						sw = false;
						break;
					} else {
						stack.pop();
					}
				}
				
				if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						sb.append("no\n");
						sw = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(sw) {
				if(stack.isEmpty()) sb.append("yes\n");
				else sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
}
