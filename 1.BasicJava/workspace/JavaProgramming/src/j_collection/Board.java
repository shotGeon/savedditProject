package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;
public class Board {
	
	
 
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판 테이블 컬럼: 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 */	
		
		ArrayList<HashMap<String, Object>> table = new ArrayList<>();	
		HashMap<String,Object> board = new HashMap<>();
					
	while(true){	
	System.out.println("1.조회\t2.등록");
		int check=ScanUtil.nextInt();
		switch(check){
		case 1:
			System.out.println("번호\t제목\t작성자\t날짜");
			for(int i=0; i<table.size(); i++){
				System.out.println(table.get(i).get("번호(PK)")
						 +"\t"+table.get(i).get("제목")
						 +"\t"+table.get(i).get("작성자")
						 +"\t"+table.get(i).get("작성일"));
			}
			System.out.print("조회하실 게시판 번호를 입력해 주세요>");
			int check2=ScanUtil.nextInt();
//			if(check2>table.size()){
//				System.exit(0);
//			}
			for(int i=0; i<table.size(); i++){
				if((Integer)table.get(i).get("번호(PK)")==check2){
					System.out.println("제목: "+table.get(i).get("제목"));
					System.out.println("내용: "+table.get(i).get("내용"));
					System.out.println("작성자: "+table.get(i).get("작성자"));
					System.out.println("작성일: "+table.get(i).get("작성일"));
					
				}
			}
			
			
			System.out.println("1.수정\t2.삭제\t3.돌아가기");	
			int check3=ScanUtil.nextInt();			
			if(check3==1){
				for(int i=0; i<table.size(); i++){
					if((Integer)table.get(i).get("번호(PK)")==check2){				
						System.out.print("수정할 제목을 입력해주세요>");
						String head = ScanUtil.nextLine();
						System.out.print("수정할 내용을 입력해주세요>");
						String story = ScanUtil.nextLine();
						table.get(i).put("제목",head);
						table.get(i).put("내용",story);
						table.get(i).put("작성일",new Date());
					}
				}
			
				System.out.println("수정이 완료되었습니다!!");
				System.out.println();
			break;
							
			}else if(check3==2){
				for(int i=0; i<table.size(); i++){
					if((Integer)table.get(i).get("번호(PK)")==check2){
						table.remove(i);
						System.out.println("삭제가 완료되었습니다.");
					}
				}
			
			break;
			}else if(check3==3){
				
				break;
			}
			
			case 2:
				HashMap<String, Object> temp = new HashMap<>();
				int maxNo=0;
				for(int i=0; i<table.size(); i++){
					int no=(Integer)table.get(i).get("번호(PK)");
					if(maxNo<no){
						maxNo=no;
					}
					
				}
				temp.put("번호(PK)", maxNo+1);
				System.out.print("제목>");
				String head2=ScanUtil.nextLine();
				temp.put("제목",head2);
				System.out.print("내용>");
				String story2=ScanUtil.nextLine();
				temp.put("내용",story2);
				System.out.print("작성자>");
				String name = ScanUtil.nextLine();
				temp.put("작성자", name);
				temp.put("작성일",new Date());
				
				table.add(temp);	
				System.out.println("등록이 완료되었습니다!!");
				System.out.println();
					
	     		break;
			
			
		}
	}
   	      
   
		
   	      
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
