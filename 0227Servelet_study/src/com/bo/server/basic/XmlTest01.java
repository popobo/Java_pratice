package com.bo.server.basic;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * ��ϤSAX��������
 * 
 * @author 33136
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		//SAX����
		//1����ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2���ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
	}
}
