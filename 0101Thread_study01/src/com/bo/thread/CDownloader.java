package com.bo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CDownloader implements Callable<Boolean> {
	private String url;//远程路径
	private String name;//存储名字
	
	public CDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CDownloader cd1 = new CDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "1.jpg");
		CDownloader cd2 = new CDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "2.jpg");
		CDownloader cd3 = new CDownloader("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=155168666,572245297&fm=26&gp=0.jpg", "3.jpg");
		
		//创建执行服务
		ExecutorService service = Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> result1 = service.submit(cd1);
		Future<Boolean> result2 = service.submit(cd2);
		Future<Boolean> result3 = service.submit(cd3);
		//获取结果
		boolean r1 = result1.get();
		boolean r2 = result2.get();
		boolean r3 = result3.get();
		//关闭服务
		service.shutdownNow();
	}
}