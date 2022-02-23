package kr.or.ddit.member.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.portable.ValueBase;

import kr.or.ddit.member.service.GaesiServiceimpl;
import kr.or.ddit.member.service.IGaesiService;
import kr.or.ddit.member.vo.GaesiVO;

public class GaesiMain {
	
	
	private IGaesiService gsi = GaesiServiceimpl.getInstance();
	Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		new GaesiMain().start();
	}
		
	
	private void start() {
		int input=0;
	do {		
		System.out.println("1.전체 목록 출력\t2.새글작성,\t3.수정\t4.삭제\t5.검색\t6.종료");
		System.out.print(">>");
		input= Integer.parseInt(s.nextLine());
		switch (input) {
		case 1:
			displayAllBoard();
			break;
		case 2:
			insertBoard();
			break;
		case 3:
			updateBoard();
			break;
		case 4:
			deleteBoard();
			break;
		case 5:
			selectBoard();
			break;
		case 6:
			System.out.println("----------------------------");
			System.out.println("프로그램을 종료 합니다.");
			System.out.println("----------------------------");
			break;
		}
	}while(input!=6);
		
	}
	

	private void selectBoard() {
		
		GaesiVO gv = new GaesiVO();
		while(true) {
			displayAllBoard();
			System.out.println("검색할 정보를 입력해주세요");
					
			System.out.print("게시글 제목>>");
			String title = s.nextLine();
			System.out.print("게시글 내용>>");
			String content = s.nextLine();
			System.out.print("작성자>>");
			String writer = s.nextLine();			
			
			gv.setTitle(title);
			gv.setContent(content);
			gv.setWriter(writer);
			
			GaesiVO gv2=gsi.checkBoard(gv);
			
			if(gv2==null) {
				System.out.println("등록된 게시글이 아닙니다.");
			}else {		
				System.out.println("게시글번호: "+gv2.getNum());
				System.out.println("게시글제목: "+gv2.getTitle());
				System.out.println("게시글내용: "+gv2.getContent());
				System.out.println("작성자: "+gv2.getWriter());
				System.out.println("작성일자: "+gv2.getDay());
				
				break;
			}
			
		}
		
	}



	private void displayAllBoard() {
		System.out.println("1.번호\t2.제목\t3.작성자\t4.작성일자");
		List<GaesiVO> gaesiList = new ArrayList<>();
		
		gaesiList=gsi.displayAllBoard();
		
		for(GaesiVO gv:gaesiList) {
			System.out.println(gv.getNum()+"\t"
		                     +gv.getTitle()+"\t"
		                     +gv.getWriter()+"\t"
		                     +gv.getDay());
		}
		System.out.println("-----------------------------------");
		System.out.println("출력끝......");
		
		
	}

	private void deleteBoard() {
		System.out.println("삭제할 게시글 번호를 입력해 주세요");
		System.out.print(">>");
		int num = Integer.parseInt(s.nextLine());
		
		int result=gsi.deleteBoard(num);
		
		if(result>0) {
			System.out.println("게시글 삭제 완료");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}

	private void updateBoard() {
		System.out.println("수정할 게시글 번호를 입력해 주세요");
		System.out.print(">>");
		int num = Integer.parseInt(s.nextLine());
		
		System.out.print("제목:");
		String title =s.nextLine();
		System.out.print("내용:");
		String content=s.nextLine();
		
		GaesiVO gv = new GaesiVO();
		
		gv.setTitle(title);
		gv.setContent(content);
		
		int result=gsi.updateBoard(num, gv);
		if(result>0) {
			System.out.println("게시글 수정 완료");
		}else {
			System.out.println("게시슬 수정 실패");
		}
	}

	private void insertBoard() {
		System.out.println("----------------------------");
		System.out.print("제목:");
		String title=s.nextLine();
		System.out.print("내용:");
		String content = s.nextLine();
		System.out.print("작성자:");
		String writer= s.nextLine();
		
		GaesiVO gv = new GaesiVO();
		
		gv.setTitle(title);
		gv.setContent(content);
		gv.setWriter(writer);
		
		int result=gsi.insertBoard(gv);
		if(result>0) {
			System.out.println("게시글 등록 완료");
		}else {
			System.out.println("게시글 등록 실패");
		}
		
	}
}

























