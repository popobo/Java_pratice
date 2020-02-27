package com.bo.thread;

public class TDownloader extends Thread{
	private String url;//远程路径
	private String name;//存储名字
	
	public TDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		TDownloader td1 = new TDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "1.jpg");
		TDownloader td2 = new TDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "2.jpg");
		TDownloader td3 = new TDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "3.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}
