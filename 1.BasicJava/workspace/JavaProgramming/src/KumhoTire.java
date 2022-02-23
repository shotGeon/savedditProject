
public class KumhoTire extends Tire {

	public KumhoTire(String location, int MaxRotation) {
		super(location, MaxRotation);
	}
	
	@Override
	public boolean roll(){
		++accumulatedRotaion;
		if(accumulatedRotaion<MaxRotation){
			System.out.println(location+"kumhoTire수명: "+
		                       (MaxRotation-accumulatedRotaion)+"회");
			return true;
			
		}else{
			System.out.println("***"+location+"kumhoTire펑크 ***");
			return false;
		}
	}

}
