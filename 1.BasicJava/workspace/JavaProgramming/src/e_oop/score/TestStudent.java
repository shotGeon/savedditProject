package e_oop.score;

public class TestStudent {
	int[] score= new int[3];
	int rank;
	int sum;
	double avg;
	String name;
	int[] allsum = new int[score.length];
	double[] allavg= new double[score.length];
	
	TestStudent input(String name){
		TestStudent temp = new TestStudent();
		temp.name=name;
		for(int i=0; i<temp.score.length; i++){
			temp.score[i]=(int)(Math.random()*101);
			temp.sum+=temp.score[i];
			temp.avg=Math.round((double)temp.sum/3*100)/100.0;
		}
		
		return temp;
		
	}
	String print(){
		return name+"\t"+score[0]+"\t"+score[1]+"\t"+score[2]+"\t"+sum+"\t"
	            +avg+"\t"+rank;
	}


}
