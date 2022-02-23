package g_oop2;

public abstract class Animal {
	int att=10;
	abstract void sound();
	
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("멍멍!!");
		
	}
}
class Cat extends Animal {

	@Override
	void sound() {
		System.out.println("야옹~");
		
	}
	
}
class Mouse extends Animal{

	@Override
	void sound() {
		System.out.println("찍찍");
		
	}
	
}

