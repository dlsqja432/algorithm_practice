package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 백준 5430번 AC
public class Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0; i<n; i++) {
			String ac = br.readLine();
			int leng = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			int reverse = 0;
			StringBuilder sb = new StringBuilder();
			
			arr = arr.substring(1,arr.length()-1);
			StringTokenizer st = new StringTokenizer(arr, ",");
			
			for(int j=0; j<leng; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = false;
			for(int j=0; j<ac.length(); j++) {
				char c = ac.charAt(j);
				if(c == 'R') {
					reverse = (reverse+1)%2;
					continue;
				}
				
				if(c == 'D' && reverse==0) {
					if(deque.isEmpty()) {
						System.out.println("error");
						flag = true;
						break;
					}
					deque.removeFirst();
				}
				
				if(c == 'D' && reverse==1) {
					if(deque.isEmpty()) {
						System.out.println("error");
						flag = true;
						break;
					}
					deque.removeLast();
				}
			}
			
			if(flag == false && reverse == 0) {
				sb.append("[");
				while(!deque.isEmpty()) {
					sb.append(deque.removeFirst());
					if(deque.isEmpty()) {
						break;
					}
					sb.append(",");
				}
				sb.append("]");
				System.out.println(sb);
			}
			
			if(flag == false && reverse == 1) {
				sb.append("[");
				while(!deque.isEmpty()) {
					sb.append(deque.removeLast());
					if(deque.isEmpty()) {
						break;
					}
					sb.append(",");
				}
				sb.append("]");
				System.out.println(sb);
				
			}
			deque.clear();
		}
	}
}