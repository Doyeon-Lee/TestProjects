package ToyTest;

public class MainClass {
	public static void main(String[] args) {
		ToyClass car = new ToyClass();
		ToyClass airplane = new ToyClass();
		
		ToyClass Toys[] = {car, airplane};
		
		car.createA();
		airplane.createB();
		
		for(int i = 0;i < Toys.length;i++) {
			Toys[i].Print();
		}
	}
}
