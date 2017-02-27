package com.blossom.tools.dom4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @Description: Dom操作工具
 * @author Blossom
 * @time 2016年12月13日 下午9:31:18
 */
public class Dom4jUtils {

	/**
	 * @Description: 解析url xml文档
	 * @author Blossom
	 * @throws DocumentException 
	 * @time 2016年12月13日 下午9:32:20
	 * @return_type Document
	 *
	 */
	public Document parse(URL url) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}
	
	/**
	 * @Description: 遍历解析文档
	 * @author Blossom
	 * @time 2016年12月13日 下午9:33:59
	 * @return_type void
	 *
	 */
	public void treeWalk(Document document){
		treeWalk(document.getRootElement());
	}
	
	/**
	 * @Description: 遍历解析元素
	 * @author Blossom
	 * @time 2016年12月13日 下午9:35:59
	 * @return_type void
	 *
	 */
	public void treeWalk(Element element){
		int intSize = element.nodeCount();
		for(int i=0; i< intSize ;i++){
			Node node = element.node(i);
			if (node instanceof Element) {
				treeWalk((Element)node);
			}else {
				//处理
			}
		}
	}
	
	/**
	 * @Description: 解析文档获得根元素
	 * @author Blossom
	 * @throws Exception 
	 * @time 2016年12月13日 下午9:36:41
	 * @return_type Element
	 *
	 */
	public Element parse(String xmlPath,String encoding) throws Exception{
		//验证文件是否存在
		File file = new File(xmlPath);
		if (!file.exists()) {
			throw new Exception("找不到xml文件: "+xmlPath);
		}
		
		//解析
		SAXReader reader = new SAXReader(false);
		Document document = reader.read(new FileInputStream(file),encoding);
		Element root = document.getRootElement();
		return root;
	}
	
	/**
	 * @Description: 保存文档
	 * @author Blossom
	 * @throws IOException 
	 * @time 2016年12月13日 下午9:39:20
	 * @return_type void
	 *
	 */
	public void save(Document document,String xmlPath,String encoding) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding(encoding);
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(xmlPath),encoding),format);
		writer.write(document);
		writer.flush();
		writer.close();
	}
	
	/**
	 * @Description: 修改xml某个节点的值
	 * @author Blossom
	 * @throws DocumentException 
	 * @throws IOException 
	 * @time 2016年12月13日 下午9:55:28
	 * @return_type void
	 *
	 */
	@SuppressWarnings("rawtypes")
	public void modifyDocument(File inputXml,String nodes,String attributeName,String value,String outXml) throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputXml);
		List list = document.selectNodes(nodes);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Attribute attribute = (Attribute) iterator.next();
			if (attribute.getName().equals(attributeName)) {
				attribute.setValue(value);
			}
		}
		XMLWriter writer = null;
		if (outXml != null) {  //指定输出文件
			writer = new XMLWriter(new FileWriter(new File(outXml)));
		}else { //输出文件为原文件
			writer = new XMLWriter(new FileWriter(inputXml));
		}
		writer.write(document);
		writer.close();
	}
	
	/**
	 * @Description: 将xml转换为字符串
	 * @author Blossom
	 * @throws IOException 
	 * @time 2016年12月13日 下午10:00:34
	 * @return_type String
	 *
	 */
	public String xmlToString(Document document,String encoding) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding(encoding);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(stream,encoding),format);
		writer.write(document);
		writer.flush();
		writer.close();
		writer = null;
		return stream.toString();
	}
	
	/**
	 * @Description: 字符串转换为Document
	 * @author Blossom
	 * @throws DocumentException 
	 * @time 2016年12月13日 下午10:03:26
	 * @return_type Document
	 *
	 */
	public Document stringToDocument(String text) throws DocumentException{
		Document document = DocumentHelper.parseText(text);
		return document;
		
	}
	
}
