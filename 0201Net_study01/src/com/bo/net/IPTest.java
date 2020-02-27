package com.bo.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点:计算机、路由、通讯设备等
 * InetAddress: 多个静态方法
 * 1、getLocalHost:本机
 * 2、getByName:根据域名DNS |  IP地址 -->IP
 * 
 *  * 两个成员方法
 * 1、getHostAddress: 返回地址
 * 2、getHostName:返回计算机名
 * 
 * @author 33136
 *
 */

public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象、本机
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		
		//根据域名得到InetAddress对象
		address = InetAddress.getByName("www.bocode.xyz");
		System.out.println(address.getHostAddress());//返回 bocode服务器的ip:
		System.out.println(address.getHostName());//输出www.bocode.xyz
		
		//根据IP得到InetAddress对象
		address = InetAddress.getByName("www.bocode.xyz");
		System.out.println(address.getHostAddress());//返回 bocode服务器的ip:
		System.out.println(address.getHostName());//输出ip而不是域名。如果这个IP地 址不存在或DNS服务器不允许进行IP地址和域名的映射
	}
}
