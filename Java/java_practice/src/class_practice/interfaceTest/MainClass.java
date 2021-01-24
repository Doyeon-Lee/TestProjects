package interfaceTest;

public class MainClass {
	public static void main(String[] args) {
		InterfaceA ia = new InterfaceClass();
		InterfaceB ib = new InterfaceClass();
		
		ia.funcA();
		ib.funcB();
		
		System.out.println(ia.str);
	}
}
