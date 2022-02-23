package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.StringTokenizer;

/**
 * 간단한 웹서버 예제
 * @author PC-04
 *
 */
public class MyHttpServer {
	private final int port = 80;
	private final String encoding = "UTF-8";
	
	/**
	 * 서버 시작
	 */
	public void start() {
		
		System.out.println("HTTP 서버가 시작되었습니다.");
		
		try(ServerSocket server = new ServerSocket(port)){
			while(true) {
				try {
					Socket socket = server.accept();
					
					HttpHandler handler = new HttpHandler(socket);
					
					new Thread(handler).start();//요청 처리 시작....
					
				}catch(IOException ex) {
					System.out.println("커넥션 오류!!!");
					ex.printStackTrace();
				}catch(RuntimeException ex) {
					System.out.println("알수 없는 오류!!!");
					ex.printStackTrace();
				}
			}
			
		}catch(IOException ex) {
			System.out.println("서버 시작 오류!!!");
			ex.printStackTrace();
		}
	}
	
	
	/*
	 * HTTP 요청 처리를 위한 Runnable 클래스
	 */
	private class HttpHandler implements Runnable{
		private final Socket socket;
		
		public HttpHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			
			OutputStream out = null;
			BufferedReader br = null;
			
			try {
				out = new BufferedOutputStream
						(socket.getOutputStream());
				br = new BufferedReader
						(new InputStreamReader(
								socket.getInputStream()));
				
				//요청헤더 정보 파싱하기,StringBuilder란?
				StringBuilder request = new StringBuilder();
				while(true) {
					String str = br.readLine();
					
					if(str.equals("")) break;// empty line 체크
					
					request.append(str + "\n");
				}
				
				System.out.println("요청헤더\n"+request.toString());
				System.out.println("------------------------------");
				
				String reqPath = "";
				
				//요청 페이지 정보 가져오기(requestLine),StringTokenizer란?
				StringTokenizer st = new StringTokenizer
						     (request.toString());
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(token.startsWith("/")) {
						reqPath = token;
					}
				}
				//경로 디코딩
				reqPath = URLDecoder.decode(reqPath, "utf-8");
				
				//상대경로(프로젝트 폴더기준) 설정
				String filePath = "./WebContent" +reqPath;
				
				//해당 파일이름을 이용하여Content-type 정보 추출하기
				String contentType = URLConnection
						 .getFileNameMap().getContentTypeFor(filePath);
				
				//CSS파일인 경우 인식이 안되서 추가함...
				if(contentType == null && filePath.endsWith(".css")) {
					contentType ="text/css";
				}
				
				System.out.println("ContentType => "+contentType);
				
				File file = new File(filePath);
				//file이 존재하지 않을때
				if(!file.exists()) {
					makeErrorPage(out, 404, "Not Found");
					return;
				}
				
				byte[] body = makeResponseBody(filePath);
				
				byte[] header = makeResponseHeader(body.length, contentType);
				
				//요청 헤더가 HTTP/1.0이나 그 이후의 버전을 지원할 경우 MIME 헤더를
				//전송한다.
				if(request.toString().indexOf("HTTP/")!=-1) {
					out.write(header);//응답헤더 보내기
				}
				
				System.out.println("응답헤더:\n" + new String(header));
				System.out.println("--------------------------------");
				
				out.write(body);
				out.flush();
				
			}catch(IOException ex){
				System.out.println("입출력 오류!!!");
				ex.printStackTrace();
			}finally {
				try {
					socket.close();//소켓닫기(연결 끊기)
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	/**
	 * 응답 헤더 생성하기
	 * @param length 응답내용 크기	
	 * @param contentType 마임타입
	 * @return 바이트 배열
	 */
	private byte[] makeResponseHeader
	            (int length, String contentType) {
		//운영체제인window는줄바꿈이 \r\n이다.(r=처음으로 돌아가는 것)
		//네트워크에서 한줄 내린다는 의미로 \r\n을 많이 쓴다.
		String header = "HTTP/1.1 200 OK\r\n"
				+ "Server: MyHTTPServer 1.0\r\n"
				+ "Content-length: "+length + "\r\n"
				+ "Content-Type: "+contentType
				+ "; charset="+this.encoding + "\r\n\r\n";//empty Line
		
		return header.getBytes();
	}
	
	private byte[] makeResponseBody(String filePath) {
		FileInputStream fis = null;
		byte[] data =null;
		
		try {
			
			File file = new File(filePath);
			data = new byte[(int) file.length()];
			
			fis = new FileInputStream(file);
			fis.read(data);
		
		}catch(IOException ex) {
			System.out.println("입출력 오류!!!");
			ex.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
	
	
	/**
	 * 에러페이지 생성
	 * @param out
	 * @param statusCode
	 * @param errMsg
	 */
	private void makeErrorPage(
			OutputStream out, int statusCode, String errMsg) {
		String statusLine ="HTTP/1.1"+" "+statusCode
				        +" "+errMsg;
		try {
			out.write(statusLine.getBytes());
			out.flush();
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new MyHttpServer().start();
	}
}














