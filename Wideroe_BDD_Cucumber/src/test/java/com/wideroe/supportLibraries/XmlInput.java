package com.wideroe.supportLibraries;



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Properties;
public class XmlInput {

	  public String getFromXml(String option) {
		  
		  Properties properties = Settings.getInstance();
		  String environment=properties.getProperty("Environment"); 			
		  String featureName=properties.getProperty("FeatureName"); 	
		  String element=null;
	    try {

		File fXmlFile = new File("D:\\Manajit\\Wideroe\\Automation\\Wideroe_BDD_Cucumber\\src\\test\\resources\\InputFile.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);		
		doc.getDocumentElement().normalize();
		NodeList envList = doc.getElementsByTagName("Environment");
		NodeList featureList = doc.getElementsByTagName("Feature");
		NodeList commonList = doc.getElementsByTagName("Common");
		
		for (int temp = 0; temp < envList.getLength(); temp++) {
			Node node1 = envList.item(temp);						
				Element element1 = (Element) node1;				
				
				if(element1.getAttribute("id").equals(environment)){
					Node node2=featureList.item(temp);
					Element element2 = (Element) node2;				
					
					if(element2.getAttribute("id").equalsIgnoreCase(featureName)){
						try{
						NodeList elementNode= element2.getElementsByTagName(option);
						Element firstElement = (Element)elementNode.item(0);
						NodeList textFNList = firstElement.getChildNodes();
						element= ((Node)textFNList.item(0)).getNodeValue();	
						}catch(Exception e){}
						
					}
				}
		}
		
		if(element==null){
			for (int temp = 0; temp < envList.getLength(); temp++) {
				Node node1 = envList.item(temp);						
					Element element1 = (Element) node1;
					if(element1.getAttribute("id").equals(environment)){
						Node node2=commonList.item(temp);
						Element element2 = (Element) node2;						
							NodeList elementNode= element2.getElementsByTagName(option);
							Element firstElement = (Element)elementNode.item(0);
							NodeList textFNList = firstElement.getChildNodes();
							element= ((Node)textFNList.item(0)).getNodeValue();								
					}
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    return element;
	  }
}
