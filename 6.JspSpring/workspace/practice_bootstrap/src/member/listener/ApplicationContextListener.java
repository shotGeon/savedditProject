package member.listener;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import member.context.ApplicationContext;

public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String path= context.getInitParameter("contextpath");
		System.out.println("1");
		//배포경로 context객체.getRealPath()
		String contextPath = context.getRealPath("/") + path.replace("classpath:", "WEB-INF/classes/").replace("/", File.separator);
//		System.out.println("cp:"+contextPath);
	    
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(contextPath);
			
			Element root = document.getDocumentElement();
			
			NodeList nList = root.getChildNodes();
			
			for(int i=0; i<nList.getLength(); i++) {
				Node node = nList.item(i);
				//System.out.println("1:"+node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					String id = element.getAttribute("id");
					String classType = element.getAttribute("class");
					//System.out.println("id:"+id);
					//System.out.println("classType:"+classType);
					
					//여기수정!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					System.out.println(2);
					
					Class<?> mola = Class.forName(classType);
					Object obj = mola.newInstance();
					
					//System.out.println("obj:"+obj);
					Map<String, Object> contextMap = ApplicationContext.getApplicationContext();
					
					contextMap.put(id, obj);
					
				}
			}
			
			for(int i=0; i<nList.getLength(); i++) {
				Node node = nList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					NodeList chNode=node.getChildNodes();
					Element eNode = (Element)node;
					if(chNode.getLength()>=1) {
						for(int j=0; j<chNode.getLength(); j++) {
							Node pNode = chNode.item(j);
							
							if(!pNode.getNodeName().equals("property")) continue;
							
							if(pNode.getNodeName().equals("property")) {
								//System.out.println("property:"+pNode.getNodeName());
								Element pEle = (Element)pNode;
								
								String name = pEle.getAttribute("name");
								String refValue = pEle.getAttribute("ref-value");
								//System.out.println("name:"+name);
								//System.out.println("refValue:"+refValue);
								String classType = eNode.getAttribute("class");
								
								Class<?> metaClass = Class.forName(classType);
								System.out.println(classType);
								Method[] methods = metaClass.getMethods();
								String setMethod = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
								for(Method method : methods) {
									if(method.getName().indexOf("set")==0) {
										System.out.println("내꺼:"+method.getName());
										if(method.getName().equals(setMethod)) {
											method.invoke(ApplicationContext.getApplicationContext().get(eNode.getAttribute("id")),
													ApplicationContext.getApplicationContext().get(refValue));
											System.out.println("invoke:"+ApplicationContext.getApplicationContext().get(eNode.getAttribute("id"))
													+"\t"+ApplicationContext.getApplicationContext().get(refValue));
										}
									}
								}
								
							}
						}
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	

}
