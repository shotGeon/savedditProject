
public class Tire {
	
	public int MaxRotation; //최대회전수
	public int accumulatedRotaion; //누적회전수
	public String location; //타이어의 위치
	
	public Tire(String location, int MaxRotation){
		this.location=location;
		this.MaxRotation=MaxRotation;
	}
	
	public boolean roll(){
		++accumulatedRotaion;
		if(accumulatedRotaion<MaxRotation){
			System.out.println(location+"수명: "+
		                       (MaxRotation-accumulatedRotaion)+"회");
			return true;
			
		}else{
			System.out.println("***"+location+"Tire펑크 ***");
			return false;
		}
	}
}
