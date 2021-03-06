package kr.or.ddit.basic;

public class Hang {

	public enum Planet{
		수성(2439),금성(6052),지구(6371),
		화성(3390),목성(69911),토성(58232),
		천완성(25362),해왕성(24622);
		
		private int km;
		
		Planet(int km){
			this.km=km;
		}
		public int getKm() {
			return km;
		}
//		public double getArea() {
//			return 4*3.14*this.km*this.km;
//		}
	}
	public static void main(String[] args) {
		double radius=4*3.14;
		System.out.println("행성들의 면적");
		System.out.println("===========================");
//		System.out.println(radius);
		Planet[] pl=Planet.values();
		for(int i=0; i<pl.length; i++) {
			System.out.println((i+1)+pl[i].name()
					       +": "+ Math.round((double)pl[i].getKm()*pl[i].getKm()*radius)+"km²");
		}
		
//		System.out.println("행성들의 면적");
//		System.out.println("====================");
//		Planet[] pl=Planet.values();
//		for(int i=0; i<pl.length; i++) {
//			System.out.println((i+1)+pl[i].name()+": "+String.format("%.0f", pl[i].getArea())+"km²");
//		}
		
   }
	
}