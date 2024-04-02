package linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

// 백준 1406번 에디터
public class Ex01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		LinkedList<Character> list = new LinkedList<>();
		
		// 연결리스트에 s의 문자열 삽입
		for(int i=0; i<s.length(); i++) {
			list.add(s.charAt(i));
		}
		
		// iterator 메소드 호출
		ListIterator<Character> iter = list.listIterator();
		
		// 처음 커서가 문장의 맨 뒤에 있어야 하기 때문에 커서를 맨 뒤로 이동
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String sw = st.nextToken();
			switch(sw) {
				case "L":
					if(iter.hasPrevious()) iter.previous();
					break;
				case "D":
					if(iter.hasNext()) iter.next();
					break;
				case "B":
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case "P":
					char t = st.nextToken().charAt(0);
					iter.add(t);
					break;
			}
		}
		for(char c : list) bw.write(c);
		bw.flush();
	}
}
