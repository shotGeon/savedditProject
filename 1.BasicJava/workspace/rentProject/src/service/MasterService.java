package service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import utill.ScanUtil;
import utill.View;
import dao.CarDao;
import dao.MasterDao;

public class MasterService {

	//싱글톤 패턴
			private MasterService(){}
			private static MasterService instance;
			public static MasterService getInstance(){
				if(instance==null){
					instance= new MasterService();
				}
				return instance;
			}
		
			private CarDao cardao = CarDao.getInstance();
			private CarService carservice = CarService.getInstance();
			private MasterDao masterdao=MasterDao.getInstance();
			private BoardService boardservice=BoardService.getInstance();
			
			//사업자 기본화면
			public int mastermain(){
				System.out.println("=============== 사업자메인 ==================");
				System.out.println("1.차량\t2.게시판\t3.개인정보\t4.매출정보\t0.로그아웃");
				System.out.print(">");
				int input=ScanUtil.nextInt();
				switch(input){
				case 1:
					return View.MASTER_MCARLIST;//차량기능
					
				case 2:
					return View.MASTER_MBOARD;
				case 3:
					return facilselect();//개인정보
					
				case 4:
					return saleselect();//매출정보	
				case 0:
					return View.HOME;
				}
				return mastermain();
			}
			
			
			public int mboard() {
			 System.out.println("1.Q&A\t2.FAQ\t3.공지사항\t0.돌아가기");
			 System.out.print(">");
			 int put = ScanUtil.nextInt();
			 switch(put){
			 case 1:
				 return View.MASTER_QNA;
			 case 2:
				return mfaq();
			 case 3:
				 return mnotice();
				 
			 case 0:
				 return View.MASTER_MAIN;
			 }	
				return mboard();
			}
			
			//사업자로그인상황에서 NOTICE
			public int mnotice() {
				return boardservice.noticelist();
			}


			//사업자로그인상황에서 faqlist
			public int mfaq() {
				return boardservice.faqlist();
			}


			//사업자로그인상황에서 qnalist
			public int mqna() {
				boardservice.qnalist();
				System.out.println("1.조회  0.돌아가기");
				System.out.print(">");
				int check = ScanUtil.nextInt();
				if(check==1){
				System.out.println("조회하실 게시글번호를 입력하세요");
				System.out.print(">");
				int input=ScanUtil.nextInt();
				boardservice.qnarelist(input);
				}else if(check==0){
					return View.MASTER_MBOARD;
				}
				return View.MASTER_QNA;
			}


			public int mcarlist() {
				System.out.println("==========================================");
				System.out.println("1.차량조회\t2.차량등록\t3.차량삭제\t0.돌아가기");
				System.out.print("번호입력>");
				int input=ScanUtil.nextInt();
				switch (input) {
				case 1:
					return carselect();//차량조회
				case 2:
					return carinsert();//차량등록
					
				case 3:
					return cardelete();//차량삭제
					
				case 0:
					return View.MASTER_MAIN;
				}
				return mcarlist();
			}

			//차량조회
			public int carselect() {
				System.out.println("1.소형\t2.준중형\t3.중형\t4.준대형\t5.대형\t0.돌아가기");
				System.out.print(">");
				int check=ScanUtil.nextInt();
				switch (check) {
				case 1:
					return masterscarlist();
				case 2:
					return mastermidcarlist();
				case 3:
					return mastermmccarlist();
				case 4:
					return masterlcarlist();
				case 5:
					return masterxlcarlist();
				case 0:
					return View.MASTER_MCARLIST;
				}
				return carselect();
			}
			
			//중형차리스트
			public int mastermmccarlist() {
				carservice.mmcarlist();
				System.out.println("1.조회\t0.돌아가기");
				System.out.print(">");
				int back=ScanUtil.nextInt();
				if(back==1){
					System.out.println("조회할 차량번호를 입력해주세요");
					System.out.print(">");
					int select=ScanUtil.nextInt();
					Map<String,Object> carimfo=cardao.carimport(select);
					System.out.println("차량번호>"+carimfo.get("CAR_NO"));
					System.out.println("모델형>"+carimfo.get("CAR_MNO"));
					System.out.println("모델명>"+carimfo.get("CAR_MNAME"));
					if(carimfo.get("CAR_AIR").equals("y")){
						System.out.println("옵션>에어백");
					}
					if(carimfo.get("CAR_SUN").equals("y")){
						System.out.println("옵션>선루프");
					}
					if(carimfo.get("CAR_BACK").equals("y")){
						System.out.println("옵션>후방카메라");
					}
					if(carimfo.get("CAR_NAVI").equals("y")){
						System.out.println("옵션>내비게이션");
					}
					if(carimfo.get("CAR_NSMOKE").equals("y")){
						System.out.println("옵션>금연차량");
					}
					if(carimfo.get("CAR_OPEN").equals("y")){
						System.out.println("옵션>오픈카");
					}
					System.out.println("연료>"+carimfo.get("CAR_FUEL"));
					System.out.println("인승>"+carimfo.get("CAR_PEO"));
					System.out.println("시간당차량금액>"+carimfo.get("CAR_PRICE"));
					System.out.print("금액수정(y/n)>");
					String eng=ScanUtil.nextLine();
					if(eng.equals("y")){
						System.out.print("금액>");
						int pay=ScanUtil.nextInt();
						int result=cardao.update(pay,select);
						if(result>0){
							System.out.println("금액수정성공");
							return View.MASTER_MMCCARLIST;
						}else{
							System.out.println("금액수정실패");
						}
					}else{
						return View.MASTER_MMCCARLIST; 
					}
					
				}else{
					return View.MASTER_MCARSELECT;
				}
				return masterscarlist();
			}

			//소형차리스트
			public int masterscarlist(){
				carservice.scarlist();
				System.out.println("1.조회\t0.돌아가기");
				System.out.print(">");
				int back=ScanUtil.nextInt();
				if(back==1){
					System.out.println("조회할 차량번호를 입력해주세요");
					System.out.print(">");
					int select=ScanUtil.nextInt();
					Map<String,Object> carimfo=cardao.carimport(select);
					System.out.println("차량번호>"+carimfo.get("CAR_NO"));
					System.out.println("모델형>"+carimfo.get("CAR_MNO"));
					System.out.println("모델명>"+carimfo.get("CAR_MNAME"));
					if(carimfo.get("CAR_AIR").equals("y")){
						System.out.println("옵션>에어백");
					}
					if(carimfo.get("CAR_SUN").equals("y")){
						System.out.println("옵션>선루프");
					}
					if(carimfo.get("CAR_BACK").equals("y")){
						System.out.println("옵션>후방카메라");
					}
					if(carimfo.get("CAR_NAVI").equals("y")){
						System.out.println("옵션>내비게이션");
					}
					if(carimfo.get("CAR_NSMOKE").equals("y")){
						System.out.println("옵션>금연차량");
					}
					if(carimfo.get("CAR_OPEN").equals("y")){
						System.out.println("옵션>오픈카");
					}
					System.out.println("연료>"+carimfo.get("CAR_FUEL"));
					System.out.println("인승>"+carimfo.get("CAR_PEO"));
					System.out.println("시간당차량금액>"+carimfo.get("CAR_PRICE"));
					System.out.print("금액수정(y/n)>");
					String eng=ScanUtil.nextLine();
					if(eng.equals("y")){
						System.out.print("금액>");
						int pay=ScanUtil.nextInt();
						int result=cardao.update(pay,select);
						if(result>0){
							System.out.println("금액수정성공");
							return View.MASTER_SCARLIST;
						}else{
							System.out.println("금액수정실패");
						}
					}else{
						return View.MASTER_SCARLIST; 
					}
					
				}else{
					return View.MASTER_MCARSELECT;
				}
				return masterscarlist();
			}
			
			public int mastermidcarlist(){
				carservice.mcarlist();
				System.out.println("1.조회\t0.돌아가기");
				System.out.print(">");
				int back=ScanUtil.nextInt();
				if(back==1){
					System.out.println("조회할 차량번호를 입력해주세요");
					System.out.print(">");
					int select2=ScanUtil.nextInt();
					Map<String,Object> carimfo2=cardao.carimport(select2);
					System.out.println("차량번호>"+carimfo2.get("CAR_NO"));
					System.out.println("모델형>"+carimfo2.get("CAR_MNO"));
					System.out.println("모델명>"+carimfo2.get("CAR_MNAME"));
					if(carimfo2.get("CAR_AIR").equals("y")){
						System.out.println("옵션>에어백");
					}
					if(carimfo2.get("CAR_SUN").equals("y")){
						System.out.println("옵션>선루프");
					}
					if(carimfo2.get("CAR_BACK").equals("y")){
						System.out.println("옵션>후방카메라");
					}
					if(carimfo2.get("CAR_NAVI").equals("y")){
						System.out.println("옵션>내비게이션");
					}
					if(carimfo2.get("CAR_NSMOKE").equals("y")){
						System.out.println("옵션>금연차량");
					}
					if(carimfo2.get("CAR_OPEN").equals("y")){
						System.out.println("옵션>오픈카");
					}
					System.out.println("연료>"+carimfo2.get("CAR_FUEL"));
					System.out.println("인승>"+carimfo2.get("CAR_PEO"));
					System.out.println("시간당차량금액>"+carimfo2.get("CAR_PRICE"));
					System.out.print("금액수정(y/n)>");
					String eng2=ScanUtil.nextLine();
					if(eng2.equals("y")){
						System.out.print("금액>");
						int pay=ScanUtil.nextInt();
						int result=cardao.update(pay,select2);
						if(result>0){
							System.out.println("금액수정성공");
							return View.MASTER_MCARLIST;
						}else{
							System.out.println("금액수정실패");
						}
					}else{
						return View.MASTER_MIDCARLIST; 
					}		
				}else{
					return View.MASTER_MCARSELECT;
				}
				return mastermidcarlist();
			}
			
			public int masterlcarlist(){
				carservice.lcarlist();
				System.out.println("1.조회\t0.돌아가기");
				System.out.print(">");
				int back=ScanUtil.nextInt();
				if(back==1){
					System.out.println("조회할 차량번호를 입력해주세요");
					System.out.print(">");
					int select2=ScanUtil.nextInt();
					Map<String,Object> carimfo2=cardao.carimport(select2);
					System.out.println("차량번호>"+carimfo2.get("CAR_NO"));
					System.out.println("모델형>"+carimfo2.get("CAR_MNO"));
					System.out.println("모델명>"+carimfo2.get("CAR_MNAME"));
					if(carimfo2.get("CAR_AIR").equals("y")){
						System.out.println("옵션>에어백");
					}
					if(carimfo2.get("CAR_SUN").equals("y")){
						System.out.println("옵션>선루프");
					}
					if(carimfo2.get("CAR_BACK").equals("y")){
						System.out.println("옵션>후방카메라");
					}
					if(carimfo2.get("CAR_NAVI").equals("y")){
						System.out.println("옵션>내비게이션");
					}
					if(carimfo2.get("CAR_NSMOKE").equals("y")){
						System.out.println("옵션>금연차량");
					}
					if(carimfo2.get("CAR_OPEN").equals("y")){
						System.out.println("옵션>오픈카");
					}
					System.out.println("연료>"+carimfo2.get("CAR_FUEL"));
					System.out.println("인승>"+carimfo2.get("CAR_PEO"));
					System.out.println("시간당차량금액>"+carimfo2.get("CAR_PRICE"));
					System.out.print("금액수정(y/n)>");
					String eng2=ScanUtil.nextLine();
					if(eng2.equals("y")){
						System.out.print("금액>");
						int pay=ScanUtil.nextInt();
						int result=cardao.update(pay,select2);
						if(result>0){
							System.out.println("금액수정성공");
							return View.MASTER_LCARLIST;
						}else{
							System.out.println("금액수정실패");
						}
					}else{
						return View.MASTER_LCARLIST; 
					}		
				}else{
					return View.MASTER_MCARSELECT;
				}
				return masterlcarlist();
				
			}
			
			public int masterxlcarlist(){
				carservice.xlcarlist();
				System.out.println("1.조회\t0.돌아가기");
				System.out.print(">");
				int back=ScanUtil.nextInt();
				if(back==1){
					System.out.println("조회할 차량번호를 입력해주세요");
					System.out.print(">");
					int select2=ScanUtil.nextInt();
					Map<String,Object> carimfo2=cardao.carimport(select2);
					System.out.println("차량번호>"+carimfo2.get("CAR_NO"));
					System.out.println("모델형>"+carimfo2.get("CAR_MNO"));
					System.out.println("모델명>"+carimfo2.get("CAR_MNAME"));
					if(carimfo2.get("CAR_AIR").equals("y")){
						System.out.println("옵션>에어백");
					}
					if(carimfo2.get("CAR_SUN").equals("y")){
						System.out.println("옵션>선루프");
					}
					if(carimfo2.get("CAR_BACK").equals("y")){
						System.out.println("옵션>후방카메라");
					}
					if(carimfo2.get("CAR_NAVI").equals("y")){
						System.out.println("옵션>내비게이션");
					}
					if(carimfo2.get("CAR_NSMOKE").equals("y")){
						System.out.println("옵션>금연차량");
					}
					if(carimfo2.get("CAR_OPEN").equals("y")){
						System.out.println("옵션>오픈카");
					}
					System.out.println("연료>"+carimfo2.get("CAR_FUEL"));
					System.out.println("인승>"+carimfo2.get("CAR_PEO"));
					System.out.println("시간당차량금액>"+carimfo2.get("CAR_PRICE"));
					System.out.print("금액수정(y/n)>");
					String eng2=ScanUtil.nextLine();
					if(eng2.equals("y")){
						System.out.print("금액>");
						int pay=ScanUtil.nextInt();
						int result=cardao.update(pay,select2);
						if(result>0){
							System.out.println("금액수정성공");
							return View.MASTER_XLCARLIST;
						}else{
							System.out.println("금액수정실패");
						}
					}else{
						return View.MASTER_XLCARLIST; 
					}		
				}else{
					return View.MASTER_MCARSELECT;
				}
				return masterlcarlist();
			}
		
			

			//매출정보
			public int saleselect() {
				//렌트예약된 정보
				SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
				System.out.println("예약번호\t차량번호\t\t차량명\t인수일\t\t인수시간\t반납일\t\t반납시간\t실제반납일\t\t실제반납시간\t결제금액\t\t추가결제금액");
				List<Map<String, Object>> priceinfo = masterdao.priceinfo();
				for(Map<String,Object> priceinfo2 :priceinfo){
					System.out.println(priceinfo2.get("RES_NO")
							+ "\t" + priceinfo2.get("RES_CAR_NO")
							+ "\t\t" + priceinfo2.get("CAR_MNAME")
							+ "\t" + format.format(priceinfo2.get("RES_INSU"))
							+ "\t" + priceinfo2.get("RES_TIME") + "시"
							+ "\t" + format.format(priceinfo2.get("RES_YBAN"))
							+ "\t" + priceinfo2.get("RES_TIME") + "시"
							+ "\t" + format.format(priceinfo2.get("RES_RBAN"))
							+ "\t" + priceinfo2.get("NVL(A.RES_RTIME,0)") + "시"
							+ "\t\t" + priceinfo2.get("RES_PRICE") + "원"
							+ "\t\t" + priceinfo2.get("NVL(A.RES_PAYMENT,0)") + "원");
					
				}
				//렌트결제매출
				int rentprice = 0;
				List<Map<String, Object>> saleprice = masterdao.saleprice();
				for(Map<String, Object> sp :saleprice){
					rentprice += Integer.parseInt(String.valueOf(sp.get("RES_PRICE")));
				}
				//반납완료된 정보
				
				//추가결제매출
				int payment = 0;
				List<Map<String, Object>> paymentprice = masterdao.paymentprice();
				for(Map<String, Object> pmp : paymentprice){
					payment += Integer.parseInt(String.valueOf(pmp.get("RES_PAYMENT")));
				}
				System.out.println("============================================================================================================================================");
				System.out.println("결제매출 : " + rentprice + "원");
				System.out.println("추가결제매출 : " + payment + "원");
				System.out.println("============================================================================================================================================");
				int allprice = rentprice+payment;
				
				
				System.out.println("총 매출 금액 : " + allprice + "원");
				System.out.println();
				System.out.print("돌아가기(0)>");
				int back=ScanUtil.nextInt();
				if(back==0){
					return View.MASTER_MAIN;
				}
				return saleselect();
				
			}
			

			//개인정보
			private int facilselect() {
				Map<String,Object> temp=new HashMap<>();
				System.out.println("================== 개인정보 =================");
				Map<String,Object> place =masterdao.placelist();
				System.out.println("사이트아이디> "+place.get("CEO_ID"));
				System.out.println("사이트비밀번호> "+place.get("CEO_PASS"));
				System.out.println("회사명> "+place.get("CEO_CNAME"));
				System.out.println("사업자이름> "+place.get("CEO_NAME"));
				System.out.println("사업자번호>"+place.get("CEO_NO"));
				System.out.println("회사주소> "+place.get("CEO_ADDR"));
				System.out.println("회사번호> "+place.get("CEO_TEL"));
				System.out.println("회사이메일> "+place.get("CEO_EMAIL"));
				System.out.println("1.수정\t0.돌아가기");
				System.out.print(">");
				int check=ScanUtil.nextInt();
				if(check==1){
					System.out.print("사이트아이디>");
					String id=ScanUtil.nextLine();
					System.out.print("사이트비밀번호>");
					String ps=ScanUtil.nextLine();
					System.out.print("회사명>");
					String cn=ScanUtil.nextLine();
					System.out.print("사업자이름>");
					String mn=ScanUtil.nextLine();
					System.out.println("사업자번호>");
					String no=ScanUtil.nextLine();
					System.out.print("회사주소>");
					String cadd=ScanUtil.nextLine();
					System.out.print("회사번호>");
					String ccall=ScanUtil.nextLine();
					System.out.print("회사이메일>");
					String cemail=ScanUtil.nextLine();
					temp.put("CEO_ID", id);
					temp.put("CEO_PASS", ps);
					temp.put("CEO_CNAME", cn);
					temp.put("CEO_NO", no);
					temp.put("CEO_NAME", mn);
					temp.put("CEO_ADDR", cadd);
					temp.put("CEO_TEL", ccall);
					temp.put("CEO_EMAIL", cemail);
					int result=masterdao.masterupdate(temp);
					if(result>0){
						System.out.println("수정완료");
						return View.MASTER_MAIN;
					}else{
						System.out.println("수정실패");
						return View.MASTER_MAIN;
					}
				}else{
					return View.MASTER_MAIN;
				}
				
				
			}
				

			//차량삭제
			public int cardelete() {
			 System.out.println("1.소형\t2.준중형\t3.준대형\t4.대형\t0.돌아가기");
			 System.out.print(">");
			 int check=ScanUtil.nextInt();
			 switch (check) {
			case 1:
			    return scardelete();
			case 2:
				return mcardelete();
			case 3:
				return lcardelete();
			case 4:
				return xlcardelete();
			case 0:
				return View.MASTER_MCARLIST;
			 }
			 
			 return cardelete();
				
			}
			//대형차 차량삭제
			public int xlcardelete(){
				carservice.xlcarlist();
				System.out.print("1.삭제\t0.돌아가기");
				System.out.print(">");
				 int num=ScanUtil.nextInt();
				 if(num==1){
					 System.out.println("삭제할 차량번호를 입력해주세요");
					 System.out.print(">");
					 int select=ScanUtil.nextInt();
					 int result=cardao.cardelete(select);
					 if(result>0){
						 System.out.println("==========================================");
						 System.out.println("차량삭제완료");
						 System.out.println("=========================================="); 
					 }else{
						 System.out.println("==========================================");
						 System.out.println("차량삭제실패");
						 System.out.println("==========================================");
					 }
					 return View.MASTER_XLCARDELETE;
					 
				 }else if(num==0){
					 return View.MASTER_CARDELETE;
				 }
				 return xlcardelete();
			}
			
			//준대형차 차량삭제
			public int lcardelete(){
				carservice.lcarlist();
				System.out.println("1.삭제\t0.돌아가기");
				System.out.print(">");
				 int num=ScanUtil.nextInt();
				 if(num==1){
					 System.out.println("삭제할 차량번호를 입력해주세요");
					 System.out.print(">");
					 int select=ScanUtil.nextInt();
					 int result=cardao.cardelete(select);
					 if(result>0){
						 System.out.println("==========================================");
						 System.out.println("차량삭제완료");
						 System.out.println("=========================================="); 
					 }else{
						 System.out.println("==========================================");
						 System.out.println("차량삭제실패");
						 System.out.println("==========================================");
					 }
					 return View.MASTER_LCARDELETE;
					 
				 }else if(num==0){
					 return View.MASTER_CARDELETE;
				 }
				 return lcardelete();
			}
			//소형차 차량삭제
			public int scardelete(){
				carservice.scarlist();
				System.out.print("1.삭제\t0.돌아가기");
				System.out.print(">");
				 int num=ScanUtil.nextInt();
				 if(num==1){
					 System.out.println("삭제할 차량번호를 입력해주세요");
					 System.out.print(">");
					 int select=ScanUtil.nextInt();
					 int result=cardao.cardelete(select);
					 if(result>0){
						 System.out.println("==========================================");
						 System.out.println("차량삭제완료");
						 System.out.println("=========================================="); 
					 }else{
						 System.out.println("==========================================");
						 System.out.println("차량삭제실패");
						 System.out.println("==========================================");
					 }
					 return View.MASTER_SCARDELETE;
					 
				 }else if(num==0){
					 return View.MASTER_CARDELETE;
				 }
				 return scardelete();
			}
			
			
			//준중형차 차량삭제
			public int mcardelete(){
				carservice.mcarlist();
				System.out.print("1.삭제\t0.돌아가기");
				System.out.print(">");
				 int num=ScanUtil.nextInt();
				 if(num==1){
					 System.out.println("삭제할 차량번호를 입력해주세요");
					 System.out.print(">");
					 int select=ScanUtil.nextInt();
					 int result=cardao.cardelete(select);
					 if(result>0){
						 System.out.println("==========================================");
						 System.out.println("차량삭제완료");
						 System.out.println("==========================================");
					 }else{
						 System.out.println("==========================================");
						 System.out.println("차량삭제실패");
						 System.out.println("==========================================");
					 }	 
					 return View.MASTER_MCARDELETE;
				 }else if(num==0){
					 return View.MASTER_CARDELETE;
				 }
				 return mcardelete();
			}
			

			//차량등록
			public int carinsert() {
				System.out.println("================== 차량등록 =================");
				System.out.print("차량번호>");
				String carno=ScanUtil.nextLine();
				System.out.print("모델명>");
				String carmname = ScanUtil.nextLine();
				System.out.print("모델형>");
				String mno = ScanUtil.nextLine();
				System.out.print("인승>");
				int peo = ScanUtil.nextInt();
				System.out.print("연료>");
				String fuel = ScanUtil.nextLine();
				System.out.print("에어백(y/n)>");
				String airback = ScanUtil.nextLine();
				System.out.print("선루프(y/n)>");
				String sun = ScanUtil.nextLine();
				System.out.print("후방카메라(y/n)>");
				String back = ScanUtil.nextLine();
				System.out.print("내비게이션(y/n)>");
				String navi = ScanUtil.nextLine();
				System.out.print("금연(y/n)>");
				String smoke = ScanUtil.nextLine();
				System.out.print("오픈카(y/n)>");
				String open = ScanUtil.nextLine();
				System.out.print("차량금액>");
				int price = ScanUtil.nextInt();
				System.out.print("차량브랜드>");
				String brand=ScanUtil.nextLine();
				Map<String, Object> carin = new HashMap<>();
				
				carin.put("CAR_NO", carno);
				carin.put("CAR_MNO", mno);
				carin.put("CAR_MNAME", carmname);
				carin.put("CAR_AIR", airback);
				carin.put("CAR_SUN", sun);
				carin.put("CAR_BACK", back);
				carin.put("CAR_NAVI", navi);
				carin.put("CAR_NSMOKE", smoke);
				carin.put("CAR_OPEN", open);
				carin.put("CAR_FUEL", fuel);
				carin.put("CAR_PEO", peo);
				carin.put("CAR_PRICE", price);
				carin.put("CAR_BRAND", brand);
				int result =cardao.carinsert(carin);
				if(result>0){
					System.out.println("차량등록이 완료되었습니다.");
					return View.MASTER_MCARLIST;
				}else{
					System.out.println("차량등록에 실패하였습니다.");
					return View.MASTER_MCARLIST;
				}
						
			}


		
			

	
}
