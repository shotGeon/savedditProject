/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-16 03:06:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class notice_002dmodifyForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head></head>\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("\r\n");
      out.write("<body class=\"hold-transition sidebar-mini\">\r\n");
      out.write("   <section class=\"content\">\r\n");
      out.write("      <div class=\"card card-success\" style=\"margin-top: 15px;\">\r\n");
      out.write("               <div class=\"card-body\" style=\"height: 750px;\">\r\n");
      out.write("               <form role=\"form\" action=\"notice-modify\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t               \t<input type=\"hidden\" id=\"deleteFileName\" name=\"deleteFileName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fileName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t                <input type=\"hidden\" id=\"deleteFileCheck\" name=\"deleteFileCheck\" value=\"NO\">\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t <input type=\"hidden\" name=\"noticeNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.noticeNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                     <label for=\"inputTitle\">??????</label> \r\n");
      out.write("                     <input type=\"text\" id=\"inputTitle\" name=\"noticeTitle\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                     <label for=\"inputWriter\">?????????</label> <input type=\"text\"\r\n");
      out.write("                        id=\"inputWriter\" class=\"form-control\" name=\"noticeWriter\"  value=\"??????????????????\" readonly=\"readonly\">\r\n");
      out.write("                  </div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"form-group\" style=\"margin-top: 1%;\">\r\n");
      out.write("                     <label for=\"inputDescription\">??????</label>\r\n");
      out.write("                     <textarea name=\"noticeContent\" id=\"summernote\" style=\"height: 320px;\" class=\"form-control\" rows=\"3\"\r\n");
      out.write("                        placeholder=\"??????\" >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"form-group\" style=\"border: none;\">\r\n");
      out.write("                     <label for=\"inputClientCompany\">????????? ??????</label><br>\r\n");
      out.write("                     <input type=\"file\" id=\"noticeModifyFile\" name=\"noticeModifyFile\" onclick=\"checkFiles()\">\r\n");
      out.write("\r\n");
      out.write("                     \r\n");
      out.write("                     <div class=\"fileGroup\">\r\n");
      out.write("                     ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"form-group\" style=\"border: none; text-align: right;\">\r\n");
      out.write("                     <button type=\"button\" onclick=\"modify_go()\" class=\"btn btn-success\" style=\" border-color:#1A4F72; background: #1A4F72;\">??????</button>\r\n");
      out.write("                     <button type=\"button\" class=\"btn btn-success\"\r\n");
      out.write("                        style=\"margin-left: 1%; border-color:#1A4F72; background: #1A4F72;\"\r\n");
      out.write("                        onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/admin/notice-detail?noticeNo=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.noticeNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\">??????</button>\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("               </form>\r\n");
      out.write("               </div>\r\n");
      out.write("               \r\n");
      out.write("               <!-- /.card-body -->\r\n");
      out.write("               <!-- /.card -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.col-->\r\n");
      out.write("   </section>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\twindow.onload = function() {\r\n");
      out.write("\t\t\t// Summernote\r\n");
      out.write("\t\t\t$('#summernote').summernote({\r\n");
      out.write("\t\t\t\theight : 320\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction removeFile_go(){\r\n");
      out.write("\t\t\t$('div[class=\"fileGroup\"]').remove();\r\n");
      out.write("\t\t\t$('#noticeModifyFile').removeAttr('disabled');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar check=$('#deleteFileCheck').val();\r\n");
      out.write("\t\t\t$('#deleteFileCheck').val(\"YES\");\r\n");
      out.write("\t\t\tcheck=$('#deleteFileCheck').val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction checkFiles(){\r\n");
      out.write("\t\t\t//alert(\"??????\");\r\n");
      out.write("\t\t\tvar checkData=$('#hiddenFile').val();\r\n");
      out.write("\t\t\tif(checkData){\r\n");
      out.write("\t\t\t\talert(\"?????? ????????? ??????????????????.\");\r\n");
      out.write("\t\t\t\t$('#noticeModifyFile').attr('disabled','disabled');\r\n");
      out.write("\t\t\t\t//$('#noticeModifyFile').removeAttr('disabled');\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction modify_go(){\r\n");
      out.write("\t\t\t$('form[role=\"form\"]').submit();\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction checkPopUp(){\r\n");
      out.write("\t\t\tvar checkValue = document.getElementById('popUp').value;\r\n");
      out.write("\t\t\tif(checkValue==\"Y\"){\r\n");
      out.write("\t\t\t\tdocument.getElementById('popUp').value=\"N\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('startDate').value=\"2999-12-31\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('endDate').value=\"2999-12-31\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkValue==\"N\"){\r\n");
      out.write("\t\t\t\tvar startDateValue = document.getElementById('startDateval').value;\r\n");
      out.write("\t\t\t\tvar endDateValue = document.getElementById('endDateval').value;\r\n");
      out.write("\t\t\t\tdocument.getElementById('popUp').value=\"Y\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('startDate').value=startDateValue;\r\n");
      out.write("\t\t\t\tdocument.getElementById('endDate').value=endDateValue;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction checkPopUp2(){\r\n");
      out.write("\t\t\t//alert(\"??????\");\r\n");
      out.write("\t\t\tvar checkValue = document.getElementById('popUp').value;\r\n");
      out.write("\t\t\tif(checkValue==\"NE\"){\r\n");
      out.write("\t\t\t\tdocument.getElementById('popUp').value=\"YE\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('startDate').value=\"\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('endDate').value=\"\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(checkValue==\"YE\"){\r\n");
      out.write("\t\t\t\tdocument.getElementById('popUp').value=\"NE\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('startDate').value=\"2999-12-31\";\r\n");
      out.write("\t\t\t\tdocument.getElementById('endDate').value=\"2999-12-31\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/admin/notice-modifyForm.jsp(78,21) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fileName ne null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                     <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${originalFileName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" name=\"hiddenModifyFile\" id=\"hiddenFile\">\r\n");
          out.write("                     <a href=\"getFile?fileName=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fileName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\"><span style=\"font-weight: bold;\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${originalFileName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span></a> \r\n");
          out.write("                     ");
          out.write("\r\n");
          out.write("                     <button type=\"button\" onclick=\"removeFile_go();\" style=\"border:0;outline:0;\" \r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"badge bg-red\">X</button>\r\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
