package AbstractTest;

public class ChildClass extends AbstractClass {
	int anotherNum = 100;
	
	public ChildClass() {
		super();
	}
	
	public ChildClass(int n, String s) {
		super(n, s);
	}
	
	public void absFunc() {
		System.out.println("absFunc exe");
	}
	
	public void Print2() {
		System.out.println(anotherNum);
	}
}
