package sec3;

import java.util.ArrayList;
import java.util.Scanner;

public class BankExam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Account[] account = new Account[10];
		
		for(int i=0; i<account.length; i++) {
			account[i] = new Account();
			System.out.print("은행명 : ");
			account[i].setBankName(scan.next());
			System.out.print("예금주 : ");
			account[i].setMyName(scan.next());
			System.out.print("계좌번호 : ");
			account[i].setAccountNumber(scan.nextInt());
			System.out.print("잔액 : ");
			account[i].setMoney(scan.nextInt());
			System.out.println("================");
		}
		
		while(true) {
			System.out.println("0. 작업 종료\t1. 계좌 등록\t2. 입금 처리\t3. 출금 처리\t4. 잔액 조회");
			int a = scan.nextInt();
			if(a == 0) {
				System.out.println("작업을 종료합니다.");
				break;
			}
			if(a == 1) {
				
			}
			if(a == 2) {
				System.out.println("입금하실 계좌번호를 입력해주세요.");
				int b = scan.nextInt();
				for(int i=0; i<account.length; i++) {
					if(account[i].getAccountNumber() == b) {
						System.out.print("입금액 : ");
						account[i].inMoney(scan.nextInt());
					}
				}
			}
			if(a == 3) {
				System.out.println("출금하실 계좌번호를 입력해주세요.");
				int b = scan.nextInt();
				for(int i=0; i<account.length; i++) {
					if(account[i].getAccountNumber() == b) {
						System.out.print("출금액 : ");
						account[i].outMoney(scan.nextInt());
					}
				}
			}
			if(a == 4) {
				System.out.println("잔액 조회하실 계좌번호를 입력해주세요.");
				int b = scan.nextInt();
				for(int i=0; i<account.length; i++) {
					if(account[i].getAccountNumber() == b) {
						System.out.println("은행명\t예금주\t계좌번호\t잔액");
						account[i].showInfo();
					}
				}
			}
			System.out.println("================");
		}
	}

}
