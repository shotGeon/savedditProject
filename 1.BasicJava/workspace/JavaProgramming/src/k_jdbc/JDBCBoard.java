package k_jdbc;



import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCBoard {

	public static void main(String[] args) {
		new JDBCBoard().start();
		
	}
	JDBCUtill jdbc = JDBCUtill.getInstance();
	
	void start(){
		while(true){
		String sql="SELECT A.BOARD_NO,"
				+ "        A.TITLE,"
				+ "        B.MEM_NAME AS USER_NAME,"
				+ "        TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE "
				+ "        FROM TB_JDBC_BOARD A"
				+ "        LEFT OUTER JOIN MEMBER B ON A.USER_ID=B.MEM_ID"
				+ "        ORDER BY A.BOARD_NO DESC";
		List<Map<String, Object>> boardList = jdbc.selectList(sql);
		
		System.out.println("--------------------------");
		System.out.println("번호\t제목\t작성자\t날짜");
		System.out.println("--------------------------");
		for(Map<String,Object> board : boardList){
			System.out.println(board.get("BOARD_NO")
					+"\t"+board.get("TITLE")
					+"\t"+board.get("USER_NAME")
					+"\t"+board.get("REG_DATE"));
		}
		System.out.println("--------------------------");
		System.out.println("1.조회\t2.등록\t0.종료");
		int check=ScanUtil.nextInt();
		switch (check) {
		case 1:
			read();
			break;

		case 2:
			insert();
			break;
		case 0:
			System.out.println("종료되었습니다.");
			System.exit(0);
		}
		}
			
	}
	void read(){
		System.out.println("조회하실 게시글 번호를 입력해주세요");
		System.out.print(">");
		int num=ScanUtil.nextInt();
		String sql="SELECT A.BOARD_NO"
				+ "        ,A.TITLE"
				+ "        ,A.CONTENT"
				+ "        ,B.MEM_NAME AS USER_NAME"
				+ "        ,TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "        FROM TB_JDBC_BOARD A"
				+ "        LEFT OUTER JOIN MEMBER B ON A.USER_ID=B.MEM_ID"
				+ "        WHERE A.BOARD_NO = "+num;
		Map<String, Object> jule = jdbc.selectOne(sql);
		System.out.println("----------------------------");
		System.out.println("번호: "+jule.get("BOARD_NO"));
		System.out.println("작성자: "+jule.get("USER_NAME"));
		System.out.println("제목: "+jule.get("TITLE"));
		System.out.println("내용: "+jule.get("CONTENT"));
		System.out.println("작성일자: "+jule.get("REG_DATE"));
		System.out.println("----------------------------");
		System.out.println("1.수정\t2.삭제\t3.돌아가기");
		int check = ScanUtil.nextInt();
		switch (check) {
		case 1:
			update(num);
			break;
		case 2:
			delete(num);
			break;
		
		}
	}
	 void update(int num) {
		System.out.print("수정할 제목: ");
		String title=ScanUtil.nextLine();
		System.out.print("수정할 내용: ");
		String content=ScanUtil.nextLine();
		
		String sql="UPDATE TB_JDBC_BOARD"
				+ "    SET TITLE = '"+title+"'"
				+ "      ,CONTENT = '"+content+"'"
				+ "WHERE BOARD_NO="+num;
		if(0<jdbc.Update(sql)){
			System.out.println("수정이 완료되었습니다.");		
     	}else{
		System.out.println("수정이 실패되었습니다.");
    	}
		
	}
	 void delete(int num){
		 String sql="DELETE FROM TB_JDBC_BOARD"
		 		+ "   WHERE BOARD_NO="+num;
		 if(0<jdbc.Update(sql)){
			 System.out.println("삭제가 완료되었습니다.");
		 }else{
			 System.out.println("삭제가 실패되었습니다.");
		 }
	 }
	 void insert(){
		 System.out.print("제목:");
		 String title=ScanUtil.nextLine();
		 System.out.print("내용:");
		 String content=ScanUtil.nextLine();
		 System.out.print("아이디:");
		 String user=ScanUtil.nextLine();
		 
		 String sql="INSERT INTO TB_JDBC_BOARD"
		 		+ " VALUES("
		 		+ "(SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD)"
		 		+ ", '"+title+"'"
		 		+ ", '"+content+"'"
		 		+ ", '"+user+"'"
		 		+ ", SYSDATE)";
		 if(0< jdbc.Update(sql)){
			 System.out.println("등록이 완료되었습니다.");
		 }else{
			 System.out.println("등록에 실패하셨습니다.");
		 }
	 }
	
	


}
