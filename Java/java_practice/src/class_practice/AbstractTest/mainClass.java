package AbstractTest;

public class mainClass {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		AbstractClass ac = new ChildClass(10, "World");
		
		ac.absFunc();
		ac.Print();
		
		cc.absFunc();
		cc.Print();
		cc.Print2();
	}
}
