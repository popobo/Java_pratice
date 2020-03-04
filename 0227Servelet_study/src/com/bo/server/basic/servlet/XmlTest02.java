package com.bo.server.basic.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//SAX解析
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		//3、编写处理器
		//4、加载文档Document注册处理器
		WebHandler handler = new WebHandler();
		//5、解析
		parse.parse(Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("com/bo/server/basic/servlet/web.xml"), handler);
		
		//获取数据
		WebContext context = new WebContext(handler.getEntities(), handler.getMappings());
		//假设你输入了 /login
		String className = context.getClz("/g");
		System.out.println(className);
		Class clz = Class.forName(className);
		Servlet servlet = (Servlet)clz.getConstructor().newInstance();
		System.out.println(servlet);
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;
	private boolean isMapping = false;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析文档");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始解析元素" + qName);
		if (null != qName) {
			tag = qName;
			if (tag.equals("servlet")) {
				entity = new Entity();
				isMapping = false;
			}else if(tag.equals("servlet-mapping")) {
				mapping = new Mapping();
				isMapping = true;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (null != tag) {
			if (isMapping) {//操作servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(content);
				}else if (tag.equals("url-pattern")) {
					mapping.addPattern(content);
				}
			}else {//操作servlet
				if (tag.equals("servlet-name")) {
					entity.setName(content);
				}else if (tag.equals("servlet-class")) {
					entity.setClz(content);
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("结束解析元素" + qName);
		if (null != qName) {
			if (qName.equals("servlet")) {
				entities.add(entity);
			}else if(qName.equals("servlet-mapping")){
				mappings.add(mapping);
			}
		}
		tag = null;//tag丢弃了
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}
	
}
