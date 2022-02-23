package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestParsing {
	
	//tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue =(Node)nlList.item(0);
		if(nValue ==null) {
			return null;
			
		}
		return nValue.getNodeValue();
	}
	
	public void test() {
		try {
			String url ="http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo?year=2020&pageNo=1&numOfRows=100&returnType=xml&serviceKey=";
			String serviceKey="jnO7kWmiB2N9pbk4eTUNlc4eUD3kfNR%2Br3cb34jsKnMY%2FTRb%2BQQygH9%2FT9Mm3xZkQ8jtnOxSlFoaZ7QIpfvC2A%3D%3D";
			
			URL urle = new URL(url+serviceKey);
			
			Document documentInfo = DocumentBuilderFactory
					         .newInstance().newDocumentBuilder().parse(urle.toString());
			//root tag
			documentInfo.getDocumentElement().normalize();
			//System.out.println("Root Element:"+documentInfo.getDocumentElement().getNodeName());
			
			//파싱할 tag
			NodeList nList = documentInfo.getElementsByTagName("item");
			
			for(int temp=0; temp<nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					System.out.println("##########################");
					System.out.println("districtName:"+getTagValue("districtName", eElement));
					System.out.println("dataDate:"+getTagValue("dataDate", eElement));
					System.out.println("issueVal:"+getTagValue("issueVal", eElement));
					System.out.println("issueTime:"+getTagValue("issueTime", eElement));
					System.out.println("clearDate:"+getTagValue("clearDate", eElement));
					System.out.println("issueDate:"+getTagValue("issueDate", eElement));
					System.out.println("moveName:"+getTagValue("moveName", eElement));
					System.out.println("clearTime:"+getTagValue("clearTime", eElement));
					System.out.println("issueGbn:"+getTagValue("issueGbn", eElement));
					System.out.println("itemCode:"+getTagValue("itemCode", eElement));
					
				}
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestParsing().test();
	}
		
	

}
