package stack_util;

import java.util.Scanner;
import java.util.Stack;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> stack = new Stack<>();
		int temp = 1;
		int result = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(c);
				temp *= 2;
			} else if(c == '[') {
				stack.push(c);
				temp *= 3;
			} else if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					System.out.println(0);
					return;
				}
				if(s.charAt(i-1) == '(') {
					result += temp;
				}
				stack.pop();
				temp /= 2;
			} else if(c == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					System.out.println(0);
					return;
				}
				if(s.charAt(i-1) == '[') {
					result += temp;
				}
				stack.pop();
				temp /= 3;
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		System.out.println(result);
	}
}
