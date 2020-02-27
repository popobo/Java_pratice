package com.bo.thread;

public class LambdaTest03 {
	public static void main(String[] args) {
		IInterest interest = (int a, int b)->{
			System.out.println("I like lambda-->" + (a + b));
			return a + b;
		};
		interest.lambda(1, 2);
		
		interest = (a, b)->{
			System.out.println("I like lambda-->" + (a + b));
			return a + b;
		};
		interest.lambda(3, 4);
		
		interest = (a, b)->{
			return a + b;
		};
		
		interest = (a, b)-> a + b;
		
		interest = (a, b)-> 100;
		
		System.out.println(interest.lambda(4, 5));
	}
}

interface IInterest {
	int lambda(int a, int b);
}

//Íâ²¿Àà
class Interest implements IInterest {
	@Override
	public int lambda(int a, int b) {
		System.out.println("I like lambda-->" + (a + b));
		return a + b;
	}
}