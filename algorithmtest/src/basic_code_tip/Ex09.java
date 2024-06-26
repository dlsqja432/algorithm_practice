package basic_code_tip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 10093번 : 숫자
public class Ex09 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if(a>b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if(a==b || a==b-1) {
			System.out.println(0);
			return;
		}
		long cnt = b - a -1;
		bw.write(cnt + "\n");
		for(long i=a+1; i<b; i++) {
			bw.write(String.valueOf(i) + " ");
		}
		bw.flush();
	}
}
