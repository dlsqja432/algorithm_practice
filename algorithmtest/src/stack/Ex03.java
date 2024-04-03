package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 2493번 탑
public class Ex03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n+1];
		int[] result = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 탑의 높이 입력 
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i+1] = x;
		}
		
		for(int i=1; i<=n; i++) {
			// 현재 탑의 높이가 스택에 있는 탑들의 높이보다 높을 때까지 스택에서 제거
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            // 스택이 비어있지 않으면 수신하는 탑의 번호는 스택의 가장 위에 있는 탑의 번호
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else { // 스택이 비어있으면 수신하는 탑이 없음
                result[i] = 0;
            }
            // 현재 탑의 인덱스를 스택에 추가
            stack.push(i);
		}
		
		for(int i=1; i<=n; i++) {
			sb.append(result[i] + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
			
	}
}