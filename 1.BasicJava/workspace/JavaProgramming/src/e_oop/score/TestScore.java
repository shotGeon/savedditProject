package e_oop.score;

public class TestScore {

	public static void main(String[] args) {
		String[] studentNames = {"이단비","김노을","정현욱","박소현","김수진","이희현",
                "강건","이민영","허기재","이윤우","김미희","김혜윤",
               "신승철","이광효","김진혁","마창수","양기옥","이동근", 
                "석기현", "류인성", "이미정", "임나리", "송민섭","김지윤", "조명석"};		
		TestStudent[] name = new TestStudent[studentNames.length];	
		TestStudent temp =new TestStudent();
		
		for(int i=0; i<name.length; i++){			
			name[i]=temp.input(studentNames[i]);	
		}
		for(int i=0; i<name.length; i++){
			name[i].rank++;
			for(int j=0; j<name.length; j++){
				if(name[i].avg<name[j].avg){
					name[i].rank++;
				}
			}
		}
		for(int i=0; i<name.length; i++){
			int min=i;
			for(int j=i+1; j<name.length; j++){
				if(name[min].rank>name[j].rank){
					min=j;
				}
			}
			TestStudent swiss=name[min];
			name[min]=name[i];
			name[i]=swiss;
		}
		for(int i=0; i<temp.allsum.length; i++){
			for(int j=0; j<name.length; j++){
				temp.allsum[i]+=name[j].score[i];
			}
			
		}
		for(int i=0; i<temp.allavg.length; i++){
			temp.allavg[i]=Math.round((double)temp.allsum[i]/25.0*100)/100.0;
		}
		
		for(int i=0; i<name.length; i++){
			System.out.println(name[i].print());
		}
		
		System.out.println("과목총합");
	    for(int i=0; i<temp.allsum.length; i++){
	    	System.out.print("\t"+temp.allsum[i]);
	    }
	    System.out.println();
		System.out.println("과목총평균");
		 for(int i=0; i<temp.allavg.length; i++){
		    	System.out.print("\t"+temp.allavg[i]);
		    }
		
		
		
		
		
		
		
		
		
		
		

	}

}
