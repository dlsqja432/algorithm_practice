package basic_code_tip;
// 백준 10804번 : 카드 역배치
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[21];
		for(int i=1; i<=20; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			while(a<=b) {
				int tmp = arr[a];
				arr[a] = arr[b];
				arr[b] = tmp;
				a++;
				b--;
			}
		}
		
		for(int i=1; i<=20; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
