
public class HankookTire extends Tire {

	public HankookTire(String location, int MaxRotation) {
		super(location, MaxRotation);
	}
	
	@Override
	public boolean roll(){
		++accumulatedRotaion;
		if(accumulatedRotaion<MaxRotation){
			System.out.println(location+"HankookTire수명: "+
		                       (MaxRotation-accumulatedRotaion)+"회");
			return true;
			
		}else{
			System.out.println("***"+location+"HankookTire펑크 ***");
			return false;
	 }
	}

}
