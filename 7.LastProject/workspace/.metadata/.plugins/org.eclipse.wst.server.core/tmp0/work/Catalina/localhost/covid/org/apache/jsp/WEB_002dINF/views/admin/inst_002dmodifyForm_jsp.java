/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-15 05:33:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inst_002dmodifyForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"card\" style=\"width:650px; height:200px; margin-left:10px; margin-top: 15px;\">\r\n");
      out.write("\t<div class=\"card-header\" style=\"background-color: #1a4f72\">\r\n");
      out.write("\t\t<h3 class=\"card-title\"><span style=\"color: white\">????????????</span></h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<form role=\"form\" action=\"./inst-modify\" method=\"get\">\r\n");
      out.write("\t<div class=\"row\" style=\"margin: 10px;\">\r\n");
      out.write("\t\t\t<label for=\"note\">?????????</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"instNm\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inst.instNm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<label style=\"margin-left:60px;\" for=\"sort\">?????????</label>\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t<input name=\"instTelno\" type=\"text\" class=\"form-control\" oninput=\"autoHyphen(this);\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inst.instTelno }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row\" style=\"margin: 10px;\">\r\n");
      out.write("\t\t\t<div class=\"col-10\">\r\n");
      out.write("\t\t\t\t<label style=\"\" for=\"instAdres\">??????</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"instAdres\" name=\"instAdres\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inst.instAdres}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-2\" style=\"margin-top: 26px;\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" onclick=\"address_go();\" class=\"btn btn-secondary\" style=\"float: right; width:100%; background-color: #1a4f72;\">??????</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div style=\"margin-left: 540px;\">\r\n");
      out.write("\t\t\t\t<input id=\"instNoModify\" type=\"hidden\" name=\"instNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${inst.instNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary user-list\" style=\"background: #1a4f72; border-color: #1a4f72;padding-top: 3px; \">\r\n");
      out.write("\t\t\t\t\t<span style=\"display: block;text-align: center; \">??????</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div  style=\"margin-left: 10px;\">\r\n");
      out.write("\t\t\t\t<button onclick=\"closeWind()\" type=\"button\" class=\"btn btn-primary user-list\" style=\"background: #1a4f72; border-color: #1a4f72;padding-top: 3px; \">\r\n");
      out.write("\t\t\t\t\t<span style=\"display: block;text-align: center; \">??????</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t </form>\r\n");
      out.write("</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tfunction closeWind(){\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction address_go(){\r\n");
      out.write("\t\t new daum.Postcode({\r\n");
      out.write("\t\t        oncomplete: function(data) {\r\n");
      out.write("\t\t            // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.\r\n");
      out.write("\r\n");
      out.write("\t\t            // ??? ????????? ?????? ????????? ?????? ????????? ????????????.\r\n");
      out.write("\t\t            // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.\r\n");
      out.write("\t\t            var addr = ''; // ?????? ??????\r\n");
      out.write("\t\t            var extraAddr = ''; // ???????????? ??????\r\n");
      out.write("\r\n");
      out.write("\t\t            //???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.\r\n");
      out.write("\t\t            if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????\r\n");
      out.write("\t\t                addr = data.roadAddress;\r\n");
      out.write("\t\t            } else { // ???????????? ?????? ????????? ???????????? ??????(J)\r\n");
      out.write("\t\t                addr = data.jibunAddress;\r\n");
      out.write("\t\t            }\r\n");
      out.write("\r\n");
      out.write("\t\t            // ???????????? ????????? ????????? ????????? ???????????? ??????????????? ????????????.\r\n");
      out.write("\t\t            if(data.userSelectedType === 'R'){\r\n");
      out.write("\t\t                // ??????????????? ?????? ?????? ????????????. (???????????? ??????)\r\n");
      out.write("\t\t                // ???????????? ?????? ????????? ????????? \"???/???/???\"??? ?????????.\r\n");
      out.write("\t\t                if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){\r\n");
      out.write("\t\t                    extraAddr += data.bname;\r\n");
      out.write("\t\t                }\r\n");
      out.write("\t\t                // ???????????? ??????, ??????????????? ?????? ????????????.\r\n");
      out.write("\t\t                if(data.buildingName !== '' && data.apartment === 'Y'){\r\n");
      out.write("\t\t                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);\r\n");
      out.write("\t\t                }\r\n");
      out.write("\t\t                // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.\r\n");
      out.write("\t\t                if(extraAddr !== ''){\r\n");
      out.write("\t\t                    extraAddr = ' (' + extraAddr + ')';\r\n");
      out.write("\t\t                }\r\n");
      out.write("\t\t                // ????????? ??????????????? ?????? ????????? ?????????.\r\n");
      out.write("\t\t                document.getElementById(\"instAdres\").value = extraAddr;\r\n");
      out.write("\t\t            \r\n");
      out.write("\t\t            } else {\r\n");
      out.write("\t\t                document.getElementById(\"instAdres\").value = '';\r\n");
      out.write("\t\t            }\r\n");
      out.write("\r\n");
      out.write("\t\t            // ??????????????? ?????? ????????? ?????? ????????? ?????????.\r\n");
      out.write("\t\t            document.getElementById(\"instAdres\").value = addr+\" \";\r\n");
      out.write("\t\t            // ????????? ???????????? ????????? ????????????.\r\n");
      out.write("\t\t            document.getElementById(\"instAdres\").focus();\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    }).open();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// ????????? ????????? ?????? ??????\r\n");
      out.write("\tconst autoHyphen = (target) => {\r\n");
      out.write("\t\t//alert(target.value.length);\r\n");
      out.write("\t\tvar targetLength = target.value.length;\r\n");
      out.write("\t\tif(parseInt(targetLength) == 9){\r\n");
      out.write("\t\t\ttarget.value = target.value.replace(/[^0-9]/, '').replace(/^(\\d{2})(\\d{3})(\\d{4})$/,`$1-$2-$3`);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(parseInt(targetLength) == 12){\r\n");
      out.write("\t\t\t//alert(\"check\");\r\n");
      out.write("\t\t\tvar checkTarget = target.value.substr(0,2);\r\n");
      out.write("\t\t\tif(checkTarget == '02'){\r\n");
      out.write("\t\t\t\t target.value = target.value.replace(/-/g,'');\r\n");
      out.write("\t\t\t\t target.value = target.value.replace(/[^0-9]/, '').replace(/^(\\d{2})(\\d{4})(\\d{4})$/,`$1-$2-$3`); \r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t target.value = target.value.replace(/-/g,'');\r\n");
      out.write("\t\t\t\t target.value = target.value.replace(/[^0-9]/, '').replace(/^(\\d{3})(\\d{3})(\\d{4})$/,`$1-$2-$3`);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(parseInt(targetLength) == 13){\r\n");
      out.write("\t\t\t target.value = target.value.replace(/-/g,'');\r\n");
      out.write("\t\t\t target.value = target.value.replace(/[^0-9]/, '').replace(/^(\\d{3})(\\d{4})(\\d{4})$/,`$1-$2-$3`);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t//???????????? ?????? ?????? ??????\r\n");
      out.write("\tmber_bir.max = new Date().toISOString().split(\"T\")[0];\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
