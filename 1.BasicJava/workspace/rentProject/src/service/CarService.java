package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utill.ScanUtil;
import utill.View;
import dao.CarDao;

public class CarService {

	private CarService(){}
	private static CarService instance;
	public static CarService getInstance(){
		if(instance==null){
			instance= new CarService();
		}
		return instance;
	}
	
	private CarDao cardao = CarDao.getInstance();
	
	//비회원차량조회
	public int carselect() {
		System.out.println("1.소형\t2.준중형\t3.중형\t4.준대형\t5.대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		switch (check) {
		case 1:
			return unusersclist();
		case 2:
			return unusermclist();
		case 3:
			return unusermmclist();
		case 4:
			return unuserlclist();
		case 5:
			return unuserxlclist();
		case 0:
			return View.HOME;
		}
		return carselect();
	}
	//비회원 소형차조회
	public int unusersclist(){
		scarlist();
		System.out.println("1.조회\t2.준중형\t3.중형\t4.준대형\t5.대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		if(check==1){
			System.out.println("조회할 차량의 번호를 입력해주세요");
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
			System.out.print("돌아가기(0)>");
			int back=ScanUtil.nextInt();
			if(back==0){
				return View.SCAR_LIST;
			}
		}else if(check==2){	
			return View.MCAR_LIST;
		}else if(check==3){
			return View.MMCAR_LIST;
		}else if(check==4){
			return View.LCAR_LIST;
		}else if(check==5){
			return View.XLCAR_LIST;			
		}
		else{
			return View.HOME;
		}
		return unusersclist();
	}
	//비회원 준중형차조회
	public int unusermclist(){
		mcarlist();
		System.out.println("1.조회\t2.소형\t3.중형\t4.준대형\t5.대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		if(check==1){
			System.out.println("조회할 차량의 번호를 입력해주세요");
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
			System.out.print("돌아가기(0)>");
			int back=ScanUtil.nextInt();
			if(back==0){
				return View.MCAR_LIST;
			}
		}else if(check==2){	
			return View.SCAR_LIST;
		}else if(check==3){
			return View.MMCAR_LIST;
		}else if(check==4){
			return View.LCAR_LIST;
		}else if(check==5){			
			return View.XLCAR_LIST;
		}
		else{
			return View.HOME;
		}
		return unusermclist();
	}
	public int unusermmclist() {
		mmcarlist();
		System.out.println("1.조회\t2.소형\t3.준중형\t4.준대형\t5.대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		if(check==1){
			System.out.println("조회할 차량의 번호를 입력해주세요");
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
			System.out.print("돌아가기(0)>");
			int back=ScanUtil.nextInt();
			if(back==0){
				return View.XLCAR_LIST;
			}
		}else if(check==2){	
			return View.SCAR_LIST;
		}else if(check==3){
			return View.MCAR_LIST;
		}else if(check==4){
			return View.LCAR_LIST;
		}else if(check==5){
			return View.XLCAR_LIST;
		}
		else{
			return View.HOME;
		}
		return unusermmclist();
	}
	//비회원준대형차리스트
	public int unuserlclist(){
		lcarlist();
		System.out.println("1.조회\t2.소형\t3.준중형\t4.중형\t5.대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		if(check==1){
			System.out.println("조회할 차량의 번호를 입력해주세요");
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
			System.out.print("돌아가기(0)>");
			int back=ScanUtil.nextInt();
			if(back==0){
				return View.LCAR_LIST;
			}
		}else if(check==2){	
			return View.SCAR_LIST;
		}else if(check==3){
			return View.MCAR_LIST;
		}else if(check==4){
			return View.MMCAR_LIST;
		}else if(check==5){
			return View.XLCAR_LIST;			
		}
		else{
			return View.HOME;
		}
		return unuserlclist();
	}
	//비회원대형차리스트
	public int unuserxlclist(){
		xlcarlist();
		System.out.println("1.조회\t2.소형\t3.준중형\t4.중형\t5.준대형\t0.돌아가기");
		System.out.print(">");
		int check=ScanUtil.nextInt();
		if(check==1){
			System.out.println("조회할 차량의 번호를 입력해주세요");
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
			System.out.print("돌아가기(0)>");
			int back=ScanUtil.nextInt();
			if(back==0){
				return View.XLCAR_LIST;
			}
		}else if(check==2){	
			return View.SCAR_LIST;
		}else if(check==3){
			return View.MCAR_LIST;
		}else if(check==4){
			return View.MMCAR_LIST;
		}else if(check==5){
					return View.LCAR_LIST;
		}
		else{
			return View.HOME;
		}
		return unuserlclist();
	}
	

	//소형차리스트
	public void scarlist() {
		System.out.println("===================소형====================");
		System.out.println("번호\t차량명\t브랜드\t인승\t연료");
		List<Map<String, Object>> scarlist = cardao.scarlist();
		for(Map<String, Object> slist : scarlist){
			System.out.println(slist.get("CAR_COUNT")+"\t"+  
		                       slist.get("CAR_MNAME")+"\t"+
		                       slist.get("CAR_BRAND")+"\t"+
					           slist.get("CAR_PEO")+"\t"+
		                       slist.get("CAR_FUEL"));
		}
		System.out.println("==========================================");
		
	}
	
	//준중형차리스트
	public void mcarlist() {
		System.out.println("==================준중형=====================");
		System.out.println("번호\t차량명\t브랜드\t인승\t연료");
		List<Map<String, Object>> scarlist = cardao.mcarlist();
		
		for(Map<String, Object> slist : scarlist){
			System.out.println(slist.get("CAR_COUNT")+"\t"+
		                       slist.get("CAR_MNAME")+"\t"+
		                       slist.get("CAR_BRAND")+"\t"+
					           slist.get("CAR_PEO")+"\t"+
		                       slist.get("CAR_FUEL"));
		}
		System.out.println("==========================================");
		
	}
	//중형차리스트
	public void mmcarlist() {
		System.out.println("===================중형=====================");
		System.out.println("번호\t차량명\t브랜드\t인승\t연료");
		List<Map<String, Object>> scarlist = cardao.mmcarlist();
		
		for(Map<String, Object> slist : scarlist){
			System.out.println(slist.get("CAR_COUNT")+"\t"+
		                       slist.get("CAR_MNAME")+"\t"+
		                       slist.get("CAR_BRAND")+"\t"+
					           slist.get("CAR_PEO")+"\t"+
		                       slist.get("CAR_FUEL"));
		}
		System.out.println("==========================================");
		
	}
	
	//준대형차리스트
	public void lcarlist() {
		System.out.println("==================준대형====================");
		System.out.println("번호\t차량명\t브랜드\t인승\t연료");
		List<Map<String, Object>> scarlist = cardao.lcarlist();
		
		for(Map<String, Object> slist : scarlist){
			System.out.println(slist.get("CAR_COUNT")+"\t"+
		                       slist.get("CAR_MNAME")+"\t"+
		                       slist.get("CAR_BRAND")+"\t"+
					           slist.get("CAR_PEO")+"\t"+
		                       slist.get("CAR_FUEL"));
		}
		System.out.println("==========================================");
	
	}
	
	//대형리스트
	public void xlcarlist() {
		System.out.println("==================대형=====================");
		System.out.println("번호\t차량명\t브랜드\t인승\t연료");
		List<Map<String, Object>> scarlist = cardao.xlcarlist();
		
		for(Map<String, Object> slist : scarlist){	
			System.out.println(slist.get("CAR_COUNT")+"\t"+
		                       slist.get("CAR_MNAME")+"\t"+
		                       slist.get("CAR_BRAND")+"\t"+
					           slist.get("CAR_PEO")+"\t"+
	                           slist.get("CAR_FUEL"));
		}
		System.out.println("==========================================");
	}
			
	
	
}
