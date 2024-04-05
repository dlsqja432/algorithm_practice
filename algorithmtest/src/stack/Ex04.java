package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 6198번 : 옥상 정원 꾸미기
public class Ex04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		long result = 0;
		for(int i=0; i<n; i++) {
			int height = Integer.parseInt(br.readLine());
			while(!stack.isEmpty() && stack.peek()<=height) {
				stack.pop();
			}
			result += stack.size();
			stack.push(height);
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
