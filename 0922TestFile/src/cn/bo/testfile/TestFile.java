package cn.bo.testfile;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File file = new File("D:/Code/Java/TestFile0922/src/cn/bo/testfile/TestFile.java");
		File file2 = new File("D:/Code/Java/TestFile0922/src/cn/bo/testfile");
		File file3 = new File(file2, "TestFile.java");
		File file4 = new File(file2, "T.java");
		File file5 = new File("D:/Code/Java/TestFile0922/aa/bb/cc/ee/ddd");
		file5.mkdirs();
//		try {
//			file4.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		file4.delete();
		if (file.isFile()) {
			System.out.println("是一个文件");
		}
		if (file.isDirectory()) {
			System.out.println("是一个目录");
		}
	}
}
