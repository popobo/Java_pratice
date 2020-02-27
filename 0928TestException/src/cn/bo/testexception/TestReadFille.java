package cn.bo.testexception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFille {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String string;
		string = new TestReadFille().openFile();
		System.out.println();
	}
	
	String openFile() throws FileNotFoundException, IOException {
		FileReader reader = new FileReader("C:/Users/33136/Desktop/test.txt");
		char c = (char)reader.read();
		System.out.println();
		return "" + c;
	}
	
}
