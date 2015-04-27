package com.crunchify.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
 

public class XmlReader {
	
	private static final Logger logger = Logger.getLogger(XmlReader.class);
	// ...
	 
	protected static Node getNode(String tagName, NodeList nodes) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            return node;
	        }
	    }
	 
	    return null;
	}
	
	protected static List<Node> getNodes(String tagName, NodeList nodes) {
		List<Node> nodeList=new ArrayList<Node>();
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	        	nodeList.add(node);
	        }
	    }
	 
	    return nodeList;
	}
	
	 
	 
	protected static String getNodeValue( Node node ) {
	    NodeList childNodes = node.getChildNodes();
	    for (int x = 0; x < childNodes.getLength(); x++ ) {
	        Node data = childNodes.item(x);
	        if ( data.getNodeType() == Node.TEXT_NODE )
	            return data.getNodeValue();
	    }
	    return "";
	}
	
	 
	protected static String getNodeValue(String tagName, NodeList nodes ) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            NodeList childNodes = node.getChildNodes();
	            for (int y = 0; y < childNodes.getLength(); y++ ) {
	                Node data = childNodes.item(y);
	                if ( data.getNodeType() == Node.TEXT_NODE )
	                    return data.getNodeValue();
	            }
	        }
	    }
	    return "";
	}
	 
	protected static String getNodeAttr(String attrName, Node node ) {
	    NamedNodeMap attrs = node.getAttributes();
	    for (int y = 0; y < attrs.getLength(); y++ ) {
	        Node attr = attrs.item(y);
	        if (attr.getNodeName().equalsIgnoreCase(attrName)) {
	            return attr.getNodeValue();
	        }
	    }
	    return "";
	}
	 
	protected String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
	    for ( int x = 0; x < nodes.getLength(); x++ ) {
	        Node node = nodes.item(x);
	        if (node.getNodeName().equalsIgnoreCase(tagName)) {
	            NodeList childNodes = node.getChildNodes();
	            for (int y = 0; y < childNodes.getLength(); y++ ) {
	                Node data = childNodes.item(y);
	                if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
	                    if ( data.getNodeName().equalsIgnoreCase(attrName) )
	                        return data.getNodeValue();
	                }
	            }
	        }
	    }
	 
	    return "";

}
	
	public static void main(String args[]){
		
		try {
		    DOMParser parser = new DOMParser();
		    parser.parse("./resources/CementData.xml");
		    Document doc = parser.getDocument();
		 
		    // Get the document's root XML node
		    NodeList root = doc.getChildNodes();
		 
		    // Navigate down the hierarchy to get to the CEO node
		    Node witslogs = getNode("logs", root);
		    Node witslog = getNode("log", witslogs.getChildNodes() );
		    
		    String uidWell = getNodeAttr("uidWell", witslog);
		    String uidWellbore= getNodeAttr("uidWellbore", witslog);
		    String uidLog= getNodeAttr("uidLog", witslog);
		    String uidSource= getNodeAttr("uidSource", witslog);
		    
		    logger.info("uidWell : "+uidWell+" uidWellbore :"+uidWellbore+" uidLog : "+uidLog+" uidSource : "+uidSource);
		 
		    String nameWell = getNodeValue("nameWell", witslog.getChildNodes() );
		    String nameWellbore = getNodeValue("nameWellbore", witslog.getChildNodes() );
		    String nameLog=getNodeValue("nameLog", witslog.getChildNodes() );
		   
		    logger.info("nameWell : " +nameWell+" nameWellbore : "+nameWellbore+" nameLog : "+nameLog);
		    Node witslogHeader=getNode("logHeader", witslog.getChildNodes() );
		    
		    Node commonData=getNode("commonData", witslog.getChildNodes() );
		    String nameSource=getNodeValue("nameSource", commonData.getChildNodes() );
		    String dTimStamp=getNodeValue("dTimStamp", commonData.getChildNodes() );
		    String dTimCreation=getNodeValue("dTimCreation", commonData.getChildNodes() );
		    String dTimLastChange=getNodeValue("dTimLastChange", commonData.getChildNodes() );
		    String itemState=getNodeValue("itemState", commonData.getChildNodes() );
		    
		    logger.info("commonData -> nameSource : "+nameSource+" dTimStamp : "+dTimStamp+" dTimCreation : "+dTimCreation+" dTimLastChange : "+dTimLastChange
		    		+"itemState : "+itemState);
	
		  
		    
		    String serviceCompany=getNodeValue("serviceCompany", witslogHeader.getChildNodes());
		    String runNumber=getNodeValue("runNumber", witslogHeader.getChildNodes());
		    String creationDate=getNodeValue("creationDate", witslogHeader.getChildNodes());
		    String indexType=getNodeValue("indexType", witslogHeader.getChildNodes());
		    String startIndex=getNodeValue("startIndex", witslogHeader.getChildNodes());
		    String endIndex=getNodeValue("endIndex", witslogHeader.getChildNodes());
		    String direction=getNodeValue("direction", witslogHeader.getChildNodes());
		    String indexCurve=getNodeValue("indexCurve", witslogHeader.getChildNodes());
		    String stepIncrement=getNodeValue("stepIncrement", witslogHeader.getChildNodes());
		    String indexUnits=getNodeValue("indexUnits", witslogHeader.getChildNodes());
		    String nullValue=getNodeValue("nullValue", witslogHeader.getChildNodes());
		    String uomNamingSystem=getNodeValue("uomNamingSystem", witslogHeader.getChildNodes());
		    
		    logger.info("serviceCompany : "+serviceCompany+" runNumber : "+runNumber+" creationDate : "+creationDate+" indexType : "
		    +indexType+" startIndex : "+startIndex+" endIndex : "+endIndex+" direction : "+direction+" indexCurve : "+indexCurve+" stepIncrement : "+stepIncrement+
		    " indexUnits : "+indexUnits+" nullValue : "+nullValue+" uomNamingSystem : "+uomNamingSystem);
		    
		    
		    List<Node> witslogCurveInfoList=getNodes("logCurveInfo", witslogHeader.getChildNodes());
		    
		    int i=0;
		    List<logCurveInfo> curveInfoList=new ArrayList<logCurveInfo>(); 
		    for(Node witslogCurveInfo:witslogCurveInfoList){
		    	
		    	logCurveInfo logCurveInfoObj=new logCurveInfo();
		    	
		    	logCurveInfoObj.setMnemonic(getNodeValue("mnemonic", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setUnit(getNodeValue("unit", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setMnemAlias(getNodeValue("mnemAlias", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setStartIndex(getNodeValue("startIndex", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setEndIndex(getNodeValue("endIndex", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setColumnIndex(getNodeValue("columnIndex", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setCurveDescription(getNodeValue("curveDescription", witslogCurveInfo.getChildNodes()));
		    	logCurveInfoObj.setTypeLogData(getNodeValue("typeLogData", witslogCurveInfo.getChildNodes()));
		    	
		    	
		    	
		    	/*
		    	String mnemonic=getNodeValue("mnemonic", witslogCurveInfo.getChildNodes());
		        String unit=getNodeValue("unit", witslogCurveInfo.getChildNodes());
		        String mnemAlias=getNodeValue("mnemAlias", witslogCurveInfo.getChildNodes());
		        String logCurveInfoStartIndex=getNodeValue("startIndex", witslogCurveInfo.getChildNodes());
		        String logCurveInfoEndIndex=getNodeValue("endIndex", witslogCurveInfo.getChildNodes());
		        String columnIndex=getNodeValue("columnIndex", witslogCurveInfo.getChildNodes());
		        String curveDescription=getNodeValue("curveDescription", witslogCurveInfo.getChildNodes());
		        String typeLogData=getNodeValue("typeLogData", witslogCurveInfo.getChildNodes());
		       
		    	
		        logger.info(i+". mnemonic : " +mnemonic+" unit : "+unit+" mnemAlias : "+mnemAlias+" logCurveInfoStartIndex : "+logCurveInfoStartIndex+
		        		" logCurveInfoEndIndex : "+logCurveInfoEndIndex+ " columnIndex : "+columnIndex+ " curveDescription : "+curveDescription+
		        		" typeLogData : "+typeLogData);
		        		
		        		 */
		    	curveInfoList.add(logCurveInfoObj);
		    	logger.info(i+". "+logCurveInfoObj.toString());
		        i++;
		    }
		   
		  
		    Node witslogData=getNode("logData", witslog.getChildNodes() );
		    List<Node> witslogDataList=getNodes("data", witslogData.getChildNodes());
		    for(Node witsData:witslogDataList){
		    	String data=getNodeValue(witsData);
		    	String[] tokens = data.split(",");
		    	if(tokens!=null&&tokens.length==curveInfoList.size()){
		    	for(int k=0;k<tokens.length;k++){
		    			if(curveInfoList.get(k).getMnemonic().equalsIgnoreCase("BLOCKCOMP")){
		    	 		logger.info(k+". "+curveInfoList.get(k).getMnemonic()+" "+tokens[k]);
		    			}
		    			if(curveInfoList.get(k).getMnemonic().equalsIgnoreCase("Time")){
			    	 		logger.info(k+". "+curveInfoList.get(k).getMnemonic()+" "+tokens[k]);
			    			}
		       	}
		    	}
		    	else{
		    		
		    		logger.info("xml is not proper format.");
		    	}
		    			    //	logger.info(j+". data : "+data);

		    } 
		    
		}
		catch ( Exception e ) {
		    e.printStackTrace();
		}
		
		
	}
}