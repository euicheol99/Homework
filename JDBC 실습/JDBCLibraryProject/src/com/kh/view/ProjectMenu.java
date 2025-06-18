package com.kh.view;

import java.security.PublicKey;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.controller.RootMemberController;

public class ProjectMenu {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	BookController bc = new BookController();
	RootMemberController rc = new RootMemberController();

	public void memberMenu() {
		while (true) {
			System.out.println("==========kh 도서관=========");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 관리자 로그인");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				this.insertMember();
				break;
			case 2:
				this.memberLogin();
				break;
			case 3:
				this.updateMember();
				break;
			case 4:
				this.rootMember();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
	}

	public void insertMember() {

		System.out.println("==========회원가입=========");
		String id;
		while (true) {
			System.out.print("1. 아이디 : ");
			id = sc.next();
			if (mc.checkId(id)) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요.");
			} else {
				break;
			}
		}
		System.out.print("2. 비밀번호 : ");
		String password = sc.next();

		System.out.print("3. 이름 : ");
		String name = sc.next();

		mc.insertMember(id, password, name);
	}

	public void memberLogin() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.println();

		if (mc.memberCheck(id, password)) {
			this.libraryMenu(id);
		} else {
			return;
		}
	}

	public void updateMember() {
		System.out.println("==========회원정보 수정=========");
		System.out.println("수정할 회원의 아이디를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.println("수정할 회원의 비밀번호를 입력하세요.");
		System.out.print("비밀번호 : ");
		String password = sc.next();
		if (!mc.memberCheck(id, password)) {
			System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
			return;
		}

		System.out.print("수정할 비밀번호 : ");
		String newpassword = sc.next();
		System.out.print("수정할 회원이름 : ");
		String newname = sc.next();

		mc.updateMember(id, newpassword, newname);

	}

	public void rootMember() {
		System.out.println("==========관리자 계정 로그인=========");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();

		if (rc.checkRootMember(id, password)) {
			this.rootMenu();
		} else {
			return;
		}

	}

	public void rootMenu() {
		while (true) {
			System.out.println("==========관리자 메뉴=========");
			System.out.println("1. 새로운 책 추가");
			System.out.println("2. 기존 책 삭제");
			System.out.println("3. 나가기");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				this.insertBook();
				break;
			case 2:
				this.deleteBook();
				break;
			case 3:
				System.out.println("메인 메뉴로 이동합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}

	}

	public void insertBook() {
		while (true) {
			System.out.println("==========책 추가=========");
			System.out.print("책 제목 : ");
			String bookName = sc.next();
			System.out.print("책 저자 : ");
			String bookAuthor = sc.next();
			rc.insertBook(bookName, bookAuthor);

			System.out.print("메뉴로 나가시겠습니까? (Y/N) :");
			char choice = sc.next().toUpperCase().charAt(0);
			if (choice == 'Y') {
				return;
			}
		}
	}

	public void deleteBook() {
		while (true) {
			System.out.println("==========책 삭제=========");
			System.out.print("책 제목 : ");
			String bookName = sc.next();

			rc.deleteBook(bookName);

			System.out.print("메뉴로 나가시겠습니까? (Y/N) : ");
			char choice = sc.next().toUpperCase().charAt(0);
			if (choice == 'Y') {
				return;
			}
		}
	}

	public void libraryMenu(String id) {
		while(true) {
		System.out.println("==========도서관 메뉴=========");
		System.out.println("1. 책 대여 하기");
		System.out.println("2. 책 반납하기");
		System.out.println("3. 책 검색");
		System.out.println("4. 전체 책 조회");
		System.out.println("5. 로그인 메뉴로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice = sc.nextInt();

		switch (choice) {
		case 1 : this.rentBook(id);
			break;
		case 2 : this.returnBook(id);
			break;
		case 3 : this.searchBook();
			break;
		case 4 : this.printAll();
			break;
		case 5 : System.out.println("로그인 메뉴로 돌아갑니다.");
			return;
		
		}
		}
	}
	
	public void rentBook(String id) {
		if(bc.checkRentList(id)) {
			return;
		}
		System.out.println("==========책 대여=========");
		this.printAll();
		System.out.println("대여하실 책의 제목을 입력해주세요.");
		System.out.print("책 제목 : ");
		String bookname = sc.next();
		bc.rentBook(id,bookname);
	}
	
	public void returnBook(String id) {
		bc.showRentList(id);
		System.out.println("==========책 반납=========");
		System.out.println("반납하실 책의 번호를 입력해주세요.");
		System.out.print("책 번호 : ");
		int booknum =sc.nextInt();
		bc.returnBook(booknum);
	}
	
	public void searchBook() {
		System.out.println("==========책 검색=========");
		System.out.println("검색하실 책의 제목이나 저자를 적어주세요.");
		System.out.print("검색 : ");
		String search = sc.next();
		bc.searchBook(search);
	}
	
	public void printAll() {
		System.out.println("==========전체 책 조회=========");
		bc.printAll();
	}

}
