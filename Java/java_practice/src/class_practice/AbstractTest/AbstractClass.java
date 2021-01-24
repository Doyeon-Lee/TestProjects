package AbstractTest;

public abstract class AbstractClass {
	int num;
	String str;
	
	public AbstractClass() {
		num = 10;
		str = "Hello";
	}
	
	public AbstractClass(int n, String s) {
		num = n;
		str = s;
	}
	
	public void Print() {
		System.out.println(num + " " + str);
	}
	
	public abstract void absFunc();
}
