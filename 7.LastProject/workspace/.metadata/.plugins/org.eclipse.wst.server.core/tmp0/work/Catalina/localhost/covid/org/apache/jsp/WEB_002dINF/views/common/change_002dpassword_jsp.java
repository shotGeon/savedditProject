/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-01-21 03:29:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class change_002dpassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1639443128000L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/covid_compass/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"card card-info\">\r\n");
      out.write("  <div class=\"card-header\" style=\"background: #1a4f72\">\r\n");
      out.write("    <h3 class=\"card-title\" >비밀번호 변경</h3>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- /.card-header -->\r\n");
      out.write("  <!-- form start -->\r\n");
      out.write("  <form class=\"form-horizontal\" method=\"post\" role=\"form\" action=\"");
      out.print(request.getContextPath());
      out.write("/common/changepass\" style=\"margin-top:15px;\">\r\n");
      out.write("    <div class=\"card-body pb-0 pt-0\">\r\n");
      out.write("      <div class=\"form-group row \">\r\n");
      out.write("        <label for=\"mberPwd\" class=\"col-sm-3 col-form-label\">새로운 비밀번호 입력</label>\r\n");
      out.write("        <div class=\"col-sm-9\">\r\n");
      out.write("          <input type=\"password\" class=\"form-control\" name=\"mberPwd\" id=\"password1\" placeholder=\"New password\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group row\">\r\n");
      out.write("        <div class=\"col-sm-9\" style=\"display: none;\" id=\"regex\">\r\n");
      out.write("\t      <span style=\"color: red;\">*비밀번호는 8~13자리이여야하며,<br/>하나 이상의 영어,숫자,특수문자가 사용되어야합니다.</span>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("      <div class=\"form-group row\">\r\n");
      out.write("        <label for=\"password2\" class=\"col-sm-3 col-form-label pt-0\">새로운 비밀번호 확인</label>\r\n");
      out.write("        <div class=\"col-sm-9\">\r\n");
      out.write("          <input type=\"password\" class=\"form-control\" id=\"password2\" placeholder=\"New password\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group row\">\r\n");
      out.write("      \t<div class=\"col-sm-9\" style=\"display: none;\" id=\"passwordEqual\">\r\n");
      out.write("\t      <span style=\"color: red;\">*비밀번호가 일치하지 않습니다.</span>\r\n");
      out.write("\t    </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.card-body -->\r\n");
      out.write("    <div class=\"card-footer\">\r\n");
      out.write("\t  <button type=\"button\" id=\"submitbutton\" class=\"btn btn-info\" style=\"background-color: #1a4f72; border-color: #1a4f72;\">비밀번호 변경</button>\r\n");
      out.write("      <button type=\"button\" id=\"close\" class=\"btn btn-default float-right\" style=\"background-color: #1a4f72; border-color: #1a4f72; color:white;\">닫기</button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.card-footer -->\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"mberNo\" name=\"mberNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mberNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"mberNo\" name=\"SessionMberNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.mberNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("\t$('#close').on('click', function(){\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("$('#password1').on('change', function(){\r\n");
      out.write("\t\r\n");
      out.write("\tvar regex = new RegExp(\"^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,13}$\");\r\n");
      out.write("\t\r\n");
      out.write("\tvar password = document.getElementById('password1').value;\r\n");
      out.write("\t\r\n");
      out.write("\tif(regex.test(password)){\r\n");
      out.write("\t\t$('#regex').css('display', 'none');\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#regex').css('display', 'block');\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\t\t\r\n");
      out.write("$('#password2').on('change', function(){\r\n");
      out.write("\tvar pass1 = document.getElementById('password1').value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar pass2 = document.getElementById('password2').value;\r\n");
      out.write("\tif(pass1 != pass2){\r\n");
      out.write("\t\t$('#passwordEqual').css('display', 'block');\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#passwordEqual').css('display', 'none');\r\n");
      out.write("\t}\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$('#submitbutton').on('click', function(){\r\n");
      out.write("\tvar regex = new RegExp(\"^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\\\(\\\\)\\-_=+]).{8,13}$\");\r\n");
      out.write("\r\n");
      out.write("\tvar password = document.getElementById('password1').value;\r\n");
      out.write("\tvar pass2 = document.getElementById('password2').value;\r\n");
      out.write("\t\r\n");
      out.write("\tif(regex.test(password)){\r\n");
      out.write("\t\tif(password == pass2){\r\n");
      out.write("\t\t\tvar form = $('form[role=\"form\"]');\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("})\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
