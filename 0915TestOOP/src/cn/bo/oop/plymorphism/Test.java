package cn.bo.oop.plymorphism;

public class Test {
	public static void testAnimalVoice(Animal animal) {
		animal.voice();
		if (animal instanceof Cat) {
			((Cat) animal).catchMouse();
		}
	}
	
	public static void main(String[] args) {
		Animal animal = new Cat();
		Cat cat = (Cat)animal;
		testAnimalVoice(animal);
	}
}
