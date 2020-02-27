package com.bo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;;

/**
 * ת����: InputStreamReader OutputStreamWriter
 * 1�����ַ�������ʽ�����ֽ��������ı��ģ�
 * 2��ָ���ַ���
 */

public class ConvertTest {
	public static void main(String[] args) {
		// ����System.in��System.out
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			// ѭ����ȡ���̵�����(exit�Ƴ�), ���������
			String msg = "";
			while(!msg.equals("exit")) {
				msg = reader.readLine();// ѭ����ȡ
				writer.write(msg);// ѭ��д��
				writer.newLine();
				writer.flush();// ǿ��ˢ��
			}
			
		} catch (IOException e) {
			System.out.println("�����쳣");
		}
	}
}
