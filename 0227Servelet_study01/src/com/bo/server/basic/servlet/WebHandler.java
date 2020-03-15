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

public class WebHandler extends DefaultHandler {
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;
	private boolean isMapping = false;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("��ʼ�����ĵ�");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("��ʼ����Ԫ��" + qName);
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
			if (isMapping) {//����servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(content);
				}else if (tag.equals("url-pattern")) {
					mapping.addPattern(content);
				}
			}else {//����servlet
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
		System.out.println("��������Ԫ��" + qName);
		if (null != qName) {
			if (qName.equals("servlet")) {
				entities.add(entity);
			}else if(qName.equals("servlet-mapping")){
				mappings.add(mapping);
			}
		}
		tag = null;//tag������
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}
	
}
