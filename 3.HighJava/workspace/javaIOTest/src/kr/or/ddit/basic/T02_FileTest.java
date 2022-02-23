package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {
	/*File f1 = new File("d:/D_Other"+File.separator+"sample.txt");
	 * 적절하게 운영체제에 맞춰서 슬래시,역슬래시를 해준다.
	 */
	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		
		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath()
					  +"은 존재합니다.");
		}else {
			System.out.println(f1.getAbsolutePath()
					  +"은 업는 파일입니다.");
			try {
				if(f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath()+"파일을 새로 만들었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(f2.exists()) {
			System.out.println(f2.getAbsolutePath()+"은 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath()+"은 없는 파일입니다.");
		}
		System.out.println("------------------------------------------");
		
		File f3 = new File("d:\\D_Other");
		File[] files = f3.listFiles();
		for(File f: files) {
			System.out.print(f.getName()+" =>");
			if(f.isFile()) {
				System.out.println("파일");
			}else if(f.isDirectory()) {
				System.out.println("디렉토리");
			}
		}
		System.out.println("============================================");
		String[] strFiles = f3.list();
		for(String str: strFiles) {
			System.out.println(str);
		}
		System.out.println("----------------------------------------------");
		System.out.println();
		
		//==================================================================
		//출력할 디렉토리 정보를 갖는 File객체 생성
		File f4 = new File("D:\\D_Other");
		
		displayFileList(f4);
	}
	
	/**
	 *지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	 *지정할 디렉토리 
	 */

	private static void displayFileList(File dir) {
		System.out.println("["+dir.getAbsolutePath()+"] 디렉토리의 내용");
		
		//디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		//하위 디렉토리 정보를 저장할 ArrayList 생성(File배열의 첨자 지정)
		List<Integer> subDirList = new ArrayList<>();
		
		//날자를 출력하기 위한 형식 지정
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd a hh:mm");//a는 오전 오후 표시
		
		for(int i=0; i<files.length; i++) {
			//파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String attr = "";
			String size = "";//파일 용량
			
			if(files[i].isDirectory()) {
				attr="<DIR>";
				subDirList.add(i);//첨자를 List에 추가함.
			}else {
				size = files[i].length()+"";
				attr+= files[i].canRead() ? "R":" ";
				attr+= files[i].canWrite() ? "W":" ";
				attr+= files[i].isHidden() ? "H":" ";
			}
			System.out.printf("%s %5s %12s %s\n",//-%5s를 하면 좌측정렬이된다.(기본은 우측정렬)
					 sdf.format(new Date(files[i].lastModified())),
					 attr,size,files[i].getName());
		}
		int dirCount = subDirList.size();//폴더안의 하위폴더 수
		int fileCount = files.length-dirCount;//폴더안 파일 수
		
		System.out.println(fileCount +"개의 파일,"
				          +dirCount +"개의 디렉토리");
		System.out.println();
		
		for(int i=0; i<subDirList.size(); i++) {
			//하위 폴더의 내용들도 출력하기 위해
			//현재 메서드를 재귀호출하여 처리한다.
			displayFileList(files[subDirList.get(i)]);
			
		}
	}
}














































