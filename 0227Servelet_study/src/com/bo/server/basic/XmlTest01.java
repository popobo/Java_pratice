package com.bo.server.basic;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 熟悉SAX解析流程
 * 
 * @author 33136
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
	}
}
