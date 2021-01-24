package javaTest;

public abstract class Animal {
	String kind;
	public void breath() {
		System.out.println("Breathing");
	}
	
	public abstract void sound();
}
