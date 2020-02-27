package com.bo.thread;

public class LambdaTest02 {
	public static void main(String[] args) {
		ILove love = (int a)->{
			System.out.println("I like lambda-->" + a);
		};
		love.lambda(100);
		
		//简化
		love = (a)->{
			System.out.println("I like lambda-->" + a);
		};	
		love.lambda(200);
		
		love = a->{
			System.out.println("I like lambda-->" + a);
		};
		love.lambda(300);
		
		love = a->System.out.println("I like lambda-->" + a);
		love.lambda(400);
	}
}

interface ILove {
	void lambda(int a);
}

//外部类
class Love implements ILove {
	@Override
	public void lambda(int a) {
		System.out.println("I like lambda-->" + a);
	}
}