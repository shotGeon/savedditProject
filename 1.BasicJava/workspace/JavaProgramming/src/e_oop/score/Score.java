package e_oop.score;
import java.util.Arrays;
public class Score {

	public static void main(String[] args) {
		String[] studentNames = {"이단비","김노을","정현욱","박소현","김수진","이희현",
                                  "강건","이민영","허기재","이윤우","김미희","김혜윤",
                                 "신승철","이광효","김진혁","마창수","양기옥","이동근", 
                                  "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};
		Student[] students = new Student[studentNames.length];
		
		System.out.println("\t"+"이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총합"+"\t"+"평균"+"\t"+"석차");
		
		for(int i=0; i<students.length; i++){
			Student student = new Student();
			
			student.name=studentNames[i];
			student.rank=1;
			student.kor=(int)(Math.random()*101);
			student.eng=(int)(Math.random()*101);
			student.math=(int)(Math.random()*101);
			
			students[i]=student;
			
			   
		   	        
		}
		for(int i=0; i<students.length; i++){
			students[i].sum=students[i].kor+students[i].eng+students[i].math;
			students[i].avg=Math.round((double)students[i].sum/3*100)/100.0;
		}
		for(int i=0; i<students.length; i++){
			for(int j=0; j<students.length; j++){
				if(students[i].avg<students[j].avg){
					students[i].rank++;
				}
			}
		}
		 
		 
		for(int i=0; i<students.length; i++){
			int min=i;
			for(int j=i+1; j<students.length; j++ ){
				if(students[min].rank>students[j].rank){
					min=j;
				}
			}
			Student temp=students[min];
			students[min]=students[i];
			students[i]=temp;
		}
	
		
		
		for(int i=0; i<students.length; i++){
			System.out.println(i+1+"\t"+students[i].name+"\t"+students[i].kor+"\t"+students[i].eng
				+"\t"+students[i].math+"\t"+students[i].sum+"\t"+students[i].avg+"\t"+students[i].rank);
		}
	
	    int korsum=0;
	    int engsum=0;
	    int mathsum=0;
		
		for(int i=0; i<students.length; i++){
			korsum+=students[i].kor;
		}
		for(int i=0; i<students.length; i++){
			engsum+=students[i].eng;
		}
		for(int i=0; i<students.length; i++){
			mathsum+=students[i].math;
		}
		
		System.out.println("과목총합");
		System.out.println("\t"+"\t"+korsum+"\t"+engsum+"\t"+mathsum);
		
		double koravg=0;
		double engavg=0;
		double mathavg=0;
		for(int i=0; i<students.length; i++){
			koravg=Math.round((double)korsum/3*100)/100.0;
		}
		for(int i=0; i<students.length; i++){
			engavg=Math.round((double)engsum/3*100)/100.0;;
		}
		for(int i=0; i<students.length; i++){
			mathavg=Math.round((double)mathsum/3*100)/100.0;
		}
		System.out.println("과목총평균");
		System.out.println("\t"+"\t"+koravg+"\t"+engavg+"\t"+mathavg);
		
		
	
	}
}
