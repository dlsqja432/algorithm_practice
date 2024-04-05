package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 3015번 오아시스 재결합
public class Ex06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack= new Stack<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for(int i=0; i<n-1; i++) {
			stack.push(arr[i]);
			
			result += stack.size();
			
			while(!stack.isEmpty() && stack.peek() < arr[i+1]) {
				stack.pop();
			}
		}
		
		System.out.println(result);
	}
}
