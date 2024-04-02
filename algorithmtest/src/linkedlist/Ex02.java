package linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

// 백준 5397번 키로거
public class Ex02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Character> list;
		ListIterator<Character> iter;
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			list = new LinkedList<Character>();
			iter = list.listIterator();
			
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				switch(c) {
				case '<':
					if(iter.hasPrevious()) iter.previous();
					break;
				case '>':
					if(iter.hasNext()) iter.next();
					break;
				case '-':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default :
					iter.add(c);
				}
			}
			for(char c : list) bw.write(c);
			bw.newLine();
		}
		bw.flush();
	}
}
