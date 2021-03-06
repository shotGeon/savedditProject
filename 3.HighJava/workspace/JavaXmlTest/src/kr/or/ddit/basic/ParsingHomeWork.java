package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParsingHomeWork  {

	public void parse() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder =
				DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		//서비스키
		String svcKey ="jnO7kWmiB2N9pbk4eTUNlc4eUD3kfNR%2Br3cb34jsKnMY%2FTRb%2BQQygH"
				         + "9%2FT9Mm3xZkQ8jtnOxSlFoaZ7QIpfvC2A%3D%3D";
		
		String noseon ="200000085";
		
		URL url = new URL("http://apis.data.go.kr/6410000/busrouteservice/getBusRouteList?serviceKey="+svcKey +"&keyword=11");
		System.out.println(url);
		
		Document document =builder.parse(url.toString());
		
		Element root = document.getDocumentElement();
		
		NodeList rowNodeList = root.getElementsByTagName("busRouteList");
		
		String resultCode = root.getElementsByTagName("resultCode")
				      .item(0).getTextContent();
		System.out.println("-------------------------------------------resultCode:"+resultCode);
		if(resultCode.equals("0")) {
			
			for(int i=0; i<rowNodeList.getLength(); i++) {
				Element element =(Element) rowNodeList.item(i);
				
				String regionName=element.getElementsByTagName("regionName")
						               .item(0).getTextContent();
				String routeId=element.getElementsByTagName("routeId")
			               .item(0).getTextContent();
				String routeName=element.getElementsByTagName("routeName")
			               .item(0).getTextContent();
				String routeTypeName=element.getElementsByTagName("routeTypeName")
						    .item(0).getTextContent();
				
				String str=String.format("지역: "+"%1s\n"+"노선: "+"%10s\n"+"루트이름: "+" %8s\n"+"타입: "+"%1s" ,
						 regionName,noseon, routeId, routeName, routeTypeName);
				System.out.println(str);
				System.out.println("--------------------------------");
			}
		}
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new ParsingHomeWork().parse();
	}
}
