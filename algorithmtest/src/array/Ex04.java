package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 3273번 : 두 수의 합
public class Ex04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(Arrays.binarySearch(arr, x-arr[i]) >= 0) {
				cnt++;
			}
		}
		System.out.println(cnt/2);
	}
}
