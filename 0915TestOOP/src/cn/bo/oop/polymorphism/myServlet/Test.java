package cn.bo.oop.polymorphism.myServlet;

public class Test {
	public static void main(String[] args) {
		HttpServlet servlet = new MyServlet();
		servlet.service();
		servlet.doGet();
		((MyServlet)servlet).doPost();
	}
}
