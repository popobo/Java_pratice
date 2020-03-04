package com.bo.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class XmlTest02 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX����
		//1����ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2���ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		//3����д������
		//4�������ĵ�Documentע�ᴦ����
		PersonHandler handler = new PersonHandler();
		//5������
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/bo/server/basic/p.xml"), handler);
		
		//��ȡ����
		List<Person> persons = handler.getPersons();
		for(Person p:persons) {
			System.out.println(p.getName() + "-->" + p.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;//�洢������ǩ
	
	public PersonHandler() {
		persons = new ArrayList<Person>();
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("��ʼ�����ĵ�");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("��ʼ����Ԫ��" + qName);
		if (null != qName) {
			tag = qName;
			if (tag.equals("person")) {
				person = new Person();
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
//		if (content.length() > 0) {
//			System.out.println("����Ϊ->" + content);
//		}else {
//			System.out.println("����Ϊ��");
//		}
		if(null != tag) {
			if (tag.equals("name")) {
				person.setName(content);
			}else if(tag.equals("age")){
				if (content.length() > 0) {
					person.setAge(Integer.valueOf(content));
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("��������Ԫ��" + qName);
		if (null != qName) {
			if (qName.equals("person")) {
				persons.add(person);
			}
		}
		tag = null;//tag������
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
	}
	
	public List<Person> getPersons(){
		return persons;
	}
}
