package array;

import java.util.Scanner;

// 백준 10807번 : 개수 세기
public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[250];
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			if(a<0) {
				a= (-1*a)+100;
			}
			arr[a]++;
		}
		int v = sc.nextInt();
		if(v>=0) {
			System.out.println(arr[v]);
		} else {
			System.out.println(arr[(-1*v)+100]);
		}
	}
}
