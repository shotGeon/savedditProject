package j_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		ArrayList<String> name= new ArrayList<>();
	    name.add("이단비");
	    name.add("김노을");
	    name.add("정현욱");
	    name.add("박소현");
	    name.add("김수진");
	    name.add("이희현");
	    name.add("강건");
	    name.add("이민영");
	    name.add("허기재");
	    name.add("이윤우");
	    name.add("김미희");
	    name.add("김혜윤");
	    name.add("신승철");
	    name.add("이광효");
	    name.add("김진혁");
	    name.add("마창수");
	    name.add("양기옥");
	    name.add("이동근");
	    name.add("석기현");
	    name.add("류인성");
	    name.add("이미정");
	    name.add("임나리");
	    name.add("송민섭");
	    name.add("김지윤");
	    name.add("조명석");

	    ArrayList<String> subject=new ArrayList<>();
	    subject.add("국어");
	    subject.add("영어");
	    subject.add("수학");
	    subject.add("사회");
	    subject.add("과학");
	    subject.add("Oracle");
	    subject.add("Java");
	    
	    ArrayList<ArrayList<Integer>> score = new ArrayList<>();
	    
	    for(int i=0; i<name.size(); i++){
	    	ArrayList<Integer> score1 = new ArrayList<>();
	    	for(int j=0; j<subject.size(); j++){
	    		score1.add((int)(Math.random()*100)+1);	
	    	}
	    	score.add(score1);
	    }
	
	    ArrayList<Integer> sum= new ArrayList<>();
	    int sum2=0;
	    for(int i=0; i<score.size(); i++){
	    	ArrayList<Integer> sum3= new ArrayList<>();
	    	sum3=score.get(i);
	    	for(int j=0; j<subject.size(); j++){
	    		sum2+=sum3.get(j);
	    	}
	    	sum.add(sum2);
	    	sum2=0;
	    
	    }
	   
	    ArrayList<Double> avg= new ArrayList<>();
	    double avg2=0;
	    for(int i=0; i<sum.size(); i++){
	      avg2=Math.round((double)sum.get(i)/subject.size()*100)/100.0;
	      avg.add(avg2);
	      avg2=0;
	    }
	    
	    
	    ArrayList<Integer>rank = new ArrayList<>();
	    int rank2=1;
	    for(int i=0; i<avg.size(); i++){
	    	for(int j=0; j<avg.size(); j++){
	    		if(avg.get(i)<avg.get(j)){
	    			rank2++;
	    		}
	    		
	    	}
	    	rank.add(rank2);
	    	rank2=1;
	    }
	    
        ArrayList<Integer> allsum = new ArrayList<>();
        ArrayList<Double> allavg = new ArrayList<>();
	    for(int i = 0; i < subject.size(); i++){
	    	int allsum2 = 0;
	    	double allavg2 = 0;
	    	for(int j = 0; j < name.size(); j++){
	    		allsum2 += score.get(j).get(i);
	    		allavg2=Math.round((double)allsum2/name.size()*100)/100.0;
	    	}
	    	allsum.add(allsum2);
	    	allavg.add(allavg2);
	    }
	    
	    for(int i=0; i<rank.size(); i++){
	      int min=i;
	      for(int j=i+1; j<rank.size(); j++){
	    	  if(rank.get(min)>rank.get(j)){
	    		  min=j;
	    	  }
	      }
	      String tempname=name.get(i);
	      name.set(i,name.get(min));
	      name.set(min,tempname);
	      
	      ArrayList<Integer>tempscore=score.get(i);
	      score.set(i,score.get(min));
	      score.set(min,tempscore);
	      
	      int tempsum=sum.get(i);
	      sum.set(i,sum.get(min));
	      sum.set(min,tempsum);
	      
	      double tempavg=avg.get(i);
	      avg.set(i,avg.get(min));
	      avg.set(min,tempavg);
	      
	      int temprank=rank.get(i);
	      rank.set(i,rank.get(min));
	      rank.set(min,temprank);
	    }
	    
	   
	    
	   System.out.println("  이름\t국어\t영어\t수학\t사회\t과학\tOracle\tJava\t합계\t평균\t석차");
	  for(int i=0; i<score.size(); i++){
		  System.out.print(i+1+"."+name.get(i));
		  for(int j=0; j<subject.size(); j++){
			  System.out.print("\t"+score.get(i).get(j));
		  }
		  System.out.println("\t"+sum.get(i)+"\t"+avg.get(i)+"\t"+rank.get(i));
		  System.out.println();

	  }
	  System.out.print("  과목총합    ");
	  for(int i=0; i<allsum.size(); i++){
		  System.out.print("\t"+allsum.get(i));
	  }
	  System.out.println();
	  System.out.print("  과목평균   ");
	  for(int i=0; i<allavg.size(); i++){
		  System.out.print("\t"+allavg.get(i));
	  }
	  
	    
	    

	    

	    
	    
		

	}

}
