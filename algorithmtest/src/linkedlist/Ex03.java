package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		int index = 0;
		for(int i=0; i<n; i++) {
			index = (index+k-1)%(list.size());
			if(i==0) {
				System.out.print("<" + list.remove(index));
			} else {
				System.out.print(", " + list.remove(index));
			}
		}
		System.out.print(">");
	}
}
