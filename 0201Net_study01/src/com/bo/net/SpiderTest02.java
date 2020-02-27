package com.bo.net;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * 网络爬虫原理 + 模拟浏览器
 * 
 * @author 33136
 *
 */

public class SpiderTest02 {
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url = new URL("https://www.bocode.xyz");
		//下载资源
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
		BufferedReader br =new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String msg =null; 
		while(null!=(msg=br.readLine())) {
			System.out.println(msg);
		}
		br.close();
	}
}
