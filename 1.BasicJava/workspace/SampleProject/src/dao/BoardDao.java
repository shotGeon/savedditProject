package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtill;

public class BoardDao {

	//싱글톤 패턴
			private BoardDao(){}
			private static BoardDao instance;
			public static BoardDao getInstance(){
				if(instance==null){
					instance= new BoardDao();
				}
				return instance;
		
	         }
			
			private JDBCUtill jdbc= JDBCUtill.getInstance();
			
			public List<Map<String,Object>> selectBoardList(){
				String sql="SELECT A.BOARD_NO, A.TITLE, B.USER_NAME, A.REG_DATE"
						+ "   FROM TB_JDBC_BOARD A"
						+ "   LEFT OUTER JOIN TB_JDBC_USER B"
						+ "     ON A.USER_ID=B.USER_ID"
						+ "  ORDER BY A.BOARD_NO DESC";
				
				
				return jdbc.selectList(sql);
			}

			
			public int insertBoardContent(Map<String, Object> temp) {
				String sql ="INSERT INTO TB_JDBC_BOARD "
						+ "      VALUES((SELECT NVL(MAX(BOARD_NO),0)+1 FROM TB_JDBC_BOARD)"					 
						  +",'"+temp.get("TITLE")+"'"
						  +",'"+temp.get("CONTENT")+"'"
						  +",'"+Controller.LoginUser.get("USER_ID")+"'"
						  +",SYSDATE)"; 			
				return jdbc.Update(sql);
			}


			public Map<String, Object> BoardContent(int input) {
				String sql="SELECT A.BOARD_NO"
						+ "        ,A.TITLE"
						+ "        ,A.CONTENT"
						+ "        ,B.USER_NAME"
						+ "        ,A.REG_DATE"
						+ "   FROM TB_JDBC_BOARD A"
						+ "   LEFT OUTER JOIN TB_JDBC_USER B ON A.USER_ID=B.USER_ID"
						+ "            WHERE A.BOARD_NO= "+input;
				Map<String, Object> jule=jdbc.selectOne(sql);
				return jule;
			}


			public int BoardUpdate(int input, Map<String, Object> temp) {
				String sql="UPDATE TB_JDBC_BOARD"
						+ "    SET TITLE = '"+temp.get("TITLE")
						+"',"+"CONTENT = '"+temp.get("CONTENT")+"'"
						+" WHERE BOARD_NO="+input
						+"         AND USER_ID= '"+Controller.LoginUser.get("USER_ID")+"'";
						
				
				int result=jdbc.Update(sql);
				return result;
			}


			public int BoardDelete(int input) {
				String sql = "DELETE FROM TB_JDBC_BOARD"
						+ "     WHERE BOARD_NO= "+input
						+ "        AND USER_ID= '"+Controller.LoginUser.get("USER_ID")+"'";
				int result=jdbc.Update(sql);
				return result;
			}
			
	
}
