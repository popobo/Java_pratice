package com.bo.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 熟悉SAX解析流程
 * 
 * @author 33136
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器
		//4、加载文档Document注册处理器
		PHandler handler = new PHandler();
		//5、解析
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/bo/server/basic/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析文档");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始解析元素" + qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (content.length() > 0) {
			System.out.println("内容为->" + content);
		}else {
			System.out.println("内容为空");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("结束解析元素" + qName);
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
}
