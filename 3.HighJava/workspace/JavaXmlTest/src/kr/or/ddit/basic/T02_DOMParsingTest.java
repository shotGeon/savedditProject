package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class T02_DOMParsingTest {
	
	public void parse() throws ParserConfigurationException, SAXException, IOException {		
		//DOM document객체를 생성하기 위한 메서드
		DocumentBuilderFactory dbf 
		        = DocumentBuilderFactory.newInstance();
		
		//DocumentBuilder 객체 생성하기
		
		DocumentBuilder builder = dbf.newDocumentBuilder();
		
		//DOM 파서로부터 입력받은 파일을 파싱하도록 요청
		//file객체의 toURI()메소드를 통해 URL정보를 가져온다.(url이란??)
		//toURL()은 이제 쓰지마라 URI로 다 커버가 가능한다.
		String url = new File("./src/new_book.xml").toURI().toString();
		//빌더에 parse메소드에url을 넣어주면 빌더가 분석해서 도규먼트객체를 반환해 준다.
		Document document = builder.parse(url);
		
		//DOM Document 객체로부터 루트 앨리먼트 및 자식 객체 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트 앨리먼트 태그명: "+root.getTagName());
		
		//하위 앨리먼트 접근방법1 : getElementsByTagName() 메서드 이용
		NodeList bookNodeList = root.getElementsByTagName("book");
		Node firstBookNode = bookNodeList.item(0);
		Element firstBookElement = (Element) firstBookNode;
		
		//속성 접근방법 1: 앨리먼트 객체의 getAttribute() 이용
		System.out.println("앨리먼트 객체의 getAttribute()이용=>"
				+firstBookElement.getAttribute("isbn"));
		
		//속성 접근방법2: 노드 객체의 getAttributes()메서드 이용(속성노드를 접근)
		NamedNodeMap nodeMap = firstBookNode.getAttributes();
		System.out.println("노드 객체의 getAttributes() 이용=>"
				+nodeMap.getNamedItem("isbn").getNodeValue());
		
		//하위 앨리먼트 접근 방법2: getChildNodes()메서드 이용
		NodeList firstBookChildNodeList = firstBookNode.getChildNodes();
		//#text노드(공백문자)때문에 인덱스 값을 1로 설정해야 함
		Node titleNode = firstBookChildNodeList.item(1);
		Element titleElement =(Element)titleNode;
		System.out.println("titleElement.getTagName()=>"
				+titleElement.getTagName());
		System.out.println("titleElement.getTextContent()=>"
				+titleElement.getTextContent());
		
		//전체 출력하기
		System.out.println("--------------------------------------");
		System.out.printf("%8s %8s %15s %10s %8s\n",
				"ISBN","분류","제목","저자","가격");
		System.out.println("--------------------------------------");
		for(int i=0; i<bookNodeList.getLength(); i++) {
			Node bookNode = bookNodeList.item(i);
			Element element = (Element)bookNode;
			String isbn = element.getAttribute("isbn");
			String kind = element.getAttribute("kind");
			String title = element.getElementsByTagName("title")
					.item(0).getTextContent().trim();
			String author = element.getElementsByTagName("author")
					.item(0).getTextContent().trim();
			String price = element.getElementsByTagName("price")
					.item(0).getTextContent().trim();
			String str = String.format("%8s %8s %15s %10s %8s",
					 isbn, kind, title, author, price);
			System.out.println(str);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		new T02_DOMParsingTest().parse();
	}
}


















