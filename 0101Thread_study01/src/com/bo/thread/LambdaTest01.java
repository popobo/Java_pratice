package com.bo.thread;


/**
 * lamba推导
 * @author 33136
 *
 */

public class LambdaTest01 {
	//内部类
	static class Like2 implements ILike {
		@Override
		public void lambda() {
			System.out.println("I like lambda2");
		}
	}
	
	public static void main(String[] args) {
		ILike like = new Like();
		like.lambda();
		
		like = new Like2();
		like.lambda();
		
		class Like3 implements ILike {
			@Override
			public void lambda() {
				System.out.println("I like lambda3");
			}
		}
		
		like = new Like3();
		like.lambda();
		
		//匿名内部类
		like = new ILike() {
			
			@Override
			public void lambda() {
				System.out.println("I like lambda4");
			}
		};
		like.lambda();
		//lambda
		like = ()->{
			System.out.println("I like lambda5");
		};
		like.lambda();
		
//		lambda推导必须存在类型
//		()->{
//			System.out.println("I like lambda5");
//		}.lambda();
	}
}

interface ILike{
	void lambda();
}

//外部类
class Like implements ILike {
	@Override
	public void lambda() {
		System.out.println("I like lambda");
	}
}