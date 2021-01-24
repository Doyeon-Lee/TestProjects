package javaTest;

public abstract class AnimalExample{
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.breath();
		dog.sound();
		
		Cat cat = new Cat();
		cat.breath();
		cat.sound();
		
	}
}
