package ToyTest;

public class ToyClass implements ToyInterfaceA, ToyInterfaceB {
	String kind;
	int modelNum;
	
	public void createA() {
		this.kind = "ToyA";
		modelNum = 100;
	}
	
	public void createB() {
		kind = "ToyB";
		this.modelNum = 200;
	}
	
	public void Print() {
		System.out.println(kind + " " + modelNum);
	}
}
