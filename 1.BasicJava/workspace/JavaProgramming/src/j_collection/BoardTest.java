package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class BoardTest {

	public static void main(String[] args) {
		
		ArrayList<HashMap<String,Object>> boardTable = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		while(true){
			System.out.println("-------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("--------------------------");
			for(int i=boardTable.size()-1; i>=0; i--){
				HashMap<String,Object> board = boardTable.get(i);
				System.out.println(board.get("NO")
						   +"\t"+board.get("TITLE")
						   +"\t"+board.get("USER")
						   +"\t"+sdf.format(board.get("DAY")));
			}
			System.out.println("--------------------------");
			System.out.println("1.조회\t2.등록\t0.종료");
			System.out.print(">");
			int check = ScanUtil.nextInt();
			switch (check) {
			case 1:
				read(boardTable);
				break;
			case 2:
				insert(boardTable);
				break;
			case 0:
				System.out.println("시스템이 종료되었습니다.");
				System.exit(0);
			}
		}
		
	}
	static void read(ArrayList<HashMap<String,Object>> boardTable){
		
		System.out.print("조회할 게시글 번호입력>");
		int check=ScanUtil.nextInt();
	
		HashMap<String,Object> board = null;
		for(int i=0; i<boardTable.size(); i++){
			if((Integer)boardTable.get(i).get("NO")==check){
				board=boardTable.get(i);
				break;
			}
		}
		System.out.println("-----------------------");
		System.out.println("번호: "+board.get("NO"));
		System.out.println("제목: "+board.get("TITLE"));
		System.out.println("내용: "+board.get("CONTENT"));
		System.out.println("작성일: "+board.get("DAY"));
		System.out.println("-----------------------");
		System.out.println("1.수정\t2.삭제\t3.목록");
		System.out.print(">");
		int num = ScanUtil.nextInt();
		switch(num) {
		case 1:
			update(board);
			break;

		case 2:
			delete(boardTable,board);
			break;
		case 3:
			break;
		}
		
	}
	static void update(HashMap<String,Object> board){
		System.out.print("수정할 제목>");
		String title = ScanUtil.nextLine();
		System.out.print("수정할 내용>");
		String content = ScanUtil.nextLine();
		
		board.put("TITLE", title);
		board.put("CONTENT", content);
		
		System.out.println("수정이 완료되었습니다.");
	}
	static void delete(ArrayList<HashMap<String,Object>> boardTable,
			HashMap<String,Object> board){
		for(int i=0; i<boardTable.size(); i++){
			if(boardTable.get(i).get("NO")==board.get("NO")){
				boardTable.remove(i);
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
		
	}
	
	
	
	
	static void insert(ArrayList<HashMap<String,Object>> boardTable){
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("작성자>");
		String user = ScanUtil.nextLine();
		
		int Maxno=0;
		for(int i=0; i<boardTable.size(); i++){
			int no=(Integer)boardTable.get(i).get("NO");
			if(Maxno<no){
				Maxno=no;
			}
		}
		HashMap<String,Object> temp = new HashMap<>();
		temp.put("NO", Maxno+1);
		temp.put("TITLE", title);
		temp.put("CONTENT", content);
		temp.put("USER", user);	
		temp.put("DAY", new Date());
		boardTable.add(temp);
		System.out.println("게시글 등록이 완료되었습니다.");
		
	}
	

}

