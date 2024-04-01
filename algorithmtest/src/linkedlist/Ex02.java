package linkedlist;

class ArrLength {
	int[] arr;
	int length;
	
	public ArrLength(int[] arr, int length) {
		this.arr = arr;
		this.length = length;
	}
}

public class Ex02 {

	public static void main(String[] args) {
		insert_test();
		erase_test();
	}
	
	public static ArrLength insert(int idx, int num, int arr[], int len) {
		for(int i=len-1; i>=idx; i--) {
			arr[i+1] = arr[i];
		}
		arr[idx] = num;
		len++;
		ArrLength al = new ArrLength(arr, len);
		return al;
	}
	
	public static ArrLength erase(int idx, int arr[], int len) {
		for(int i=idx+1; i<len; i++) {
			arr[i-1] = arr[i];
		}
		arr[len-1] = 0;
		len--;
		ArrLength al = new ArrLength(arr, len);
		return al;
	}
	
	public static void insert_test() {
		System.out.println("***** insert_test *****");
		int[] arr = new int[10];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		int len = 3;
		ArrLength al = insert(3, 40, arr, len);	// 10 20 30 40
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
		al = insert(1, 50, arr, len);	// 10 50 20 30 40
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
		al = insert(0, 15, arr, len);	// 15 10 50 20 30 40
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
	}
	
	public static void erase_test() {
		System.out.println("***** erase_test *****");
		int[] arr = new int[10];
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 40;
		arr[3] = 30;
		arr[4] = 70;
		arr[5] = 20;
		int len = 6;
		ArrLength al = erase(4, arr, len);	// 10 50 40 30 20
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
		al = erase(1, arr, len);	// 10 40 30 20
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
		al = erase(3, arr, len);	// 10 40 30
		len = al.length;
		for(int i=0; i<len; i++) System.out.print(al.arr[i] + " ");
		System.out.println("\n" + len);
	}
}
