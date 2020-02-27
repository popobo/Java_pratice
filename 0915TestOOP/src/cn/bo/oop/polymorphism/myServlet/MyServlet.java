package cn.bo.oop.polymorphism.myServlet;

public class MyServlet extends HttpServlet {
	public void doGet() {
		super.doGet();
		System.out.println("MyServlet.doGet()");
	}
	
	public void doPost() {
		System.out.println("MyServlet.doPost()");
	}
}
