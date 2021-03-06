package kr.or.ddit.admin.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.admin.service.AdminServiceImpl;
import kr.or.ddit.admin.service.IAdminService;
import kr.or.ddit.admin.vo.AdminVO;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UpdateMember.do")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		AdminVO vo = new AdminVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		IAdminService service = AdminServiceImpl.GetService();
		
		System.out.println(vo.getMem_addr1());
		System.out.println(vo.getMem_addr2());
		System.out.println(vo.getMem_hp());
		System.out.println(vo.getMem_id());
		int cnt = service.updateMember(vo);
		
		System.out.println("cnt : " + cnt);
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("/whole/admin/admin_jsp/result.jsp").forward(request, response);
	}

}
