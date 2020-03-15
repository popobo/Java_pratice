package com.bo.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * ��ϤSAX��������
 * 
 * @author 33136
 *
 */
public class XmlTest01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX����
		//1����ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2���ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		//3����д������
		//4�������ĵ�Documentע�ᴦ����
		PHandler handler = new PHandler();
		//5������
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/bo/server/basic/p.xml"), handler);
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("��ʼ�����ĵ�");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("��ʼ����Ԫ��" + qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (content.length() > 0) {
			System.out.println("����Ϊ->" + content);
		}else {
			System.out.println("����Ϊ��");
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("��������Ԫ��" + qName);
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
	}
}
