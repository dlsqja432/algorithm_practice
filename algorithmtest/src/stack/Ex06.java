package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 3015번 오아시스 재결합
class Pair {
	int height, cnt;
	
	public Pair(int height, int cnt) {
		this.height = height;
		this.cnt = cnt;
	}
}


public class Ex06 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Pair> stack = new Stack<>();
		long result = 0;
		
		for(int i=0; i<n; ++i) {
			int cur = Integer.parseInt(br.readLine());
			Pair next = new Pair(cur,1);
			
			while(!stack.isEmpty() && stack.peek().height <= cur) {
				Pair p = stack.pop();
				result += p.cnt;
				if(p.height == cur) {
					next.cnt += p.cnt;
				}
			}
			
			if(!stack.isEmpty()) result++;
			
			stack.push(next);
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}