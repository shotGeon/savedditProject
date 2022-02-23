package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;

public class BoardService {

	//싱글톤 패턴
		private BoardService(){}
		private static BoardService instance;
		public static BoardService getInstance(){
			if(instance==null){
				instance= new BoardService();
			}
			return instance;
	
         }
		
		private BoardDao boardDao = BoardDao.getInstance();
		static int input;
		public int boardList(){
			List<Map<String,Object>> boardList=boardDao.selectBoardList();
			
			System.out.println("==================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-----------------------------------");
			for(Map<String, Object> board : boardList){
				System.out.println(board.get("BOARD_NO")+"\t"
						+board.get("TITLE")+"\t"
						+board.get("USER_NAME")+"\t"
						+board.get("REG_DATE"));
			}
			System.out.println("=============================");
			System.out.println("1.조회\t2.등록\t0.로그아웃");
			System.out.print("입력>");
			input=ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				boardSelect();
				
				break;
			case 2:
				
				boardUpdate();
				
				break;
			case 0:
				Controller.LoginUser =null;
				return View.HOME;
				
			}
			return View.BOARD_LIST;
			
			
		}

		public int boardSelect() {
			System.out.println("조회하실 게시글 번호를 입력해주세요");
			System.out.print(">");
			input=ScanUtil.nextInt();
		    Map<String, Object> content =boardDao.BoardContent(input);
			System.out.println("---------------------------------");
			System.out.println("게시글번호> "+content.get("BOARD_NO"));
			System.out.println("제목> "+content.get("TITLE"));
			System.out.println("내용> "+content.get("CONTENT"));
			System.out.println("작성자> "+content.get("USER_NAME"));
			System.out.println("작성일자> "+content.get("REG_DATE"));
			System.out.println("---------------------------------");
			System.out.println("1.수정\t2.삭제\t3.돌아가기");
			int check = ScanUtil.nextInt();
			switch (check) {
			case 1:
				update(input);
				break;
			case 2:
				delete(input);
				break;
			case 3:
				System.out.println("돌아갑니다");
				break;
			}
			return View.BOARD_LIST;
			
		}

		public int delete(int input) {//삭제
			int result=boardDao.BoardDelete(input);
			if(result>0){
				System.out.println("------------------------");
				System.out.println("삭제가 완료되었습니다.");
				System.out.println("------------------------");
			}else{
				System.out.println("------------------------");
				System.out.println("삭제를 실패했습니다.");
				System.out.println("본인계정 게시글이 아닙니다.");
				System.out.println("------------------------");
			}
			return View.BOARD_LIST;
			
		}

		public int update(int input) {//수정
			Map<String,Object> temp = new HashMap<>();
			System.out.print("수정할 제목>");
			String title=ScanUtil.nextLine();
			System.out.print("수정할 내용>");
			String content=ScanUtil.nextLine();
			temp.put("TITLE", title);
			temp.put("CONTENT", content);
			
			int result=boardDao.BoardUpdate(input,temp);
			if(result>0){
				System.out.println("------------------------");
				System.out.println("수정완료");
				System.out.println("------------------------");
			}else{
				System.out.println("------------------------");
				System.out.println("수정실패");
				System.out.println("본인 계정 게시글이 아닙니다.");
				System.out.println("------------------------");
				}
				return View.BOARD_LIST;
					
		}

		public int boardUpdate() {//등록
			
			System.out.print("제목>");
			String title=ScanUtil.nextLine();
			System.out.print("내용>");
			String content=ScanUtil.nextLine();
			
		    Map<String,Object> temp = new HashMap<>();
			
		    temp.put("USER_ID",Controller.LoginUser.get("USER_ID"));
			temp.put("TITLE",title);
			temp.put("CONTENT",content);
			
			int result=boardDao.insertBoardContent(temp);
			
			if(result>0){
				System.out.println("------------------------");
				System.out.println("등록성공");
				System.out.println("------------------------");
			}else{
				System.out.println("------------------------");
				System.out.println("등록실패");
				System.out.println("------------------------");
			}
			return View.BOARD_LIST;
			

			
		}
}






































