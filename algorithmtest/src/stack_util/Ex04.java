package stack_util;

import java.util.Scanner;
import java.util.Stack;

//백준 10799번 쇠막대기
public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> stack = new Stack<>();
		int count = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i-1) == '(') {
					count++;
				}
				stack.push(c);
			}
			
			if(c == ')') {
				stack.pop();
				if(c != s.charAt(i-1)) {
					count += stack.size();
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
