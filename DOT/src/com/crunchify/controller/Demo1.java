package com.crunchify.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo1 {
	
	
	public static void main(String args[]) throws Exception{
	    //Get the DOM Builder Factory
	    DocumentBuilderFactory factory = 
	        DocumentBuilderFactory.newInstance();

	    //Get the DOM Builder
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    //Load and Parse the XML document
	    //document contains the complete XML as a Tree.
	    Document document = 
	      builder.parse(
	        ClassLoader.getSystemResourceAsStream("Sample1.xml"));

	    List<log> logList = new ArrayList<>();

	    //Iterating through the nodes and extracting the data.
	    NodeList nodeList = document.getDocumentElement().getChildNodes();

	    for (int i = 0; i < nodeList.getLength(); i++) {

	      //We have encountered an <employee> tag.
	      Node node = nodeList.item(i);
	      if (node instanceof Element) {
	        log log = new log();
	        log.uidWell = node.getAttributes().
	            getNamedItem("uidWell").getNodeValue();
	        log.uidWellbore = node.getAttributes().
		            getNamedItem("uidWellbore").getNodeValue();
	        log.uidLog = node.getAttributes().
		            getNamedItem("uidLog").getNodeValue();
	        log.uidSource = node.getAttributes().
		            getNamedItem("uidSource").getNodeValue();

	        NodeList childNodes = node.getChildNodes();
	        for (int j = 0; j < childNodes.getLength(); j++) {
	          Node cNode = childNodes.item(j);

	          //Identifying the child tag of employee encountered. 
	          if (cNode instanceof Element) {
	            String content = cNode.getLastChild().
	                getTextContent().trim();
	            System.out.println("content : "+content);
	            switch (cNode.getNodeName()) {
	              case "nameWell":
	                log.nameWell = content;
	                break;
	              case "nameWellbore":
	            	  log.nameWellbore = content;
	                break;
	              case "nameLog":
	            	  log.nameLog = content;
	                break;
	              case "logHeader":
	            	  
	            	  
	            	  
	            	  
	            	  
	            	  log.logHeader = null;//content;
	                break;
	                
	            }
	          }
	        }
	       logList.add(log);
	      }

	    }

	    //Printing the Employee list populated.
	    for (log l : logList) {
	      System.out.println(l);
	    }

	  }
}
