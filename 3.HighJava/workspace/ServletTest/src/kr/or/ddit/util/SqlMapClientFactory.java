package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc;
	
	private SqlMapClientFactory() {
	}
	
	public static SqlMapClient getInstance() {
		if(smc==null) {
			
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			try {
				Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
				smc = SqlMapClientBuilder.buildSqlMapClient(rd);
				rd.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return smc;
	}
	
}