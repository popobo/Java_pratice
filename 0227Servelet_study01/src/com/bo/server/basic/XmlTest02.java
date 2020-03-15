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
 * 熟悉SAX解析流程
 * 
 * @author 33136
 *
 */
public class XmlTest02 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器
		//4、加载文档Document注册处理器
		PersonHandler handler = new PersonHandler();
		//5、解析
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/bo/server/basic/p.xml"), handler);
		
		//获取数据
		List<Person> persons = handler.getPersons();
		for(Person p:persons) {
			System.out.println(p.getName() + "-->" + p.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;//存储操作标签
	
	public PersonHandler() {
		persons = new ArrayList<Person>();
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析文档");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始解析元素" + qName);
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
//			System.out.println("内容为->" + content);
//		}else {
//			System.out.println("内容为空");
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
		System.out.println("结束解析元素" + qName);
		if (null != qName) {
			if (qName.equals("person")) {
				persons.add(person);
			}
		}
		tag = null;//tag丢弃了
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
	
	public List<Person> getPersons(){
		return persons;
	}
}
