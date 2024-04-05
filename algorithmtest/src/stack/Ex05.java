package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 17298번 오큰수
public class Ex05 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i + " ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}