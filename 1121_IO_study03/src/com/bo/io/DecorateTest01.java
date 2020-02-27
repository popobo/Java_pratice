package com.bo.io;


public class DecorateTest01 {
	public static void main(String[] args) {
		Person person = new Person();
		person.say();
		Amplifier amplifier = new Amplifier(person);
		amplifier.say();
	}
}
interface Say{
	void say();
}


class Person implements Say{
	// Ù–‘
	private int voice = 10;
	@Override
	public void say() {
		System.out.println("voice is " + voice);
	}
	
	public int getVoice() {
		return voice;
	}
	
	public void setVoice(int inVoice) {
		this.voice = inVoice;
	}
}

//∑≈¥Û∆˜
class Amplifier implements Say {
	private Person person;
	Amplifier(Person inPerson){
		this.person = inPerson;
	}
	
	public void say() {
		System.out.println("voice is " + person.getVoice() * 100);
	}
}
