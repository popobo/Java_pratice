package com.bo.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:��λһ���ڵ�:�������·�ɡ�ͨѶ�豸��
 * InetAddress: �����̬����
 * 1��getLocalHost:����
 * 2��getByName:��������DNS |  IP��ַ -->IP
 * 
 *  * ������Ա����
 * 1��getHostAddress: ���ص�ַ
 * 2��getHostName:���ؼ������
 * 
 * @author 33136
 *
 */

public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress���󡢱���
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		
		//���������õ�InetAddress����
		address = InetAddress.getByName("www.bocode.xyz");
		System.out.println(address.getHostAddress());//���� bocode��������ip:
		System.out.println(address.getHostName());//���www.bocode.xyz
		
		//����IP�õ�InetAddress����
		address = InetAddress.getByName("www.bocode.xyz");
		System.out.println(address.getHostAddress());//���� bocode��������ip:
		System.out.println(address.getHostName());//���ip������������������IP�� ַ�����ڻ�DNS���������������IP��ַ��������ӳ��
	}
}
