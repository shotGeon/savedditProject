/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-22 05:02:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.ltct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class res_002dsmple_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/views/ltct/./res-detail-module-work.jsp", Long.valueOf(1644798987115L));
    _jspx_dependants.put("/WEB-INF/views/ltct/./res-list-module-work.jsp", Long.valueOf(1645506044806L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1639443128000L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/covid_compass/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/A_TeachingMaterial/7.LastProject/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/covid_compass/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
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

      out.write("<head></head>\r\n");
      out.write("<title></title>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<section class=\"content\">\r\n");
      out.write("\t\t<div class=\"row\" style=\"margin: 1px; margin-top: 5px;\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-6 pl-0\">\r\n");
      out.write("\t\t\t\t<section class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"card\" style=\"margin: 1px; height: 763px; margin-top: 13px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-header d-flex p-0\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"nav nav-pills ml-auto p-2\" role=\"tablist\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"nav-item\"><div class=\"input-group float-right\" style=\"max-width: 600px; width:300px;\">\r\n");
      out.write("\t\t\t\t\t<!-- search bar -->\r\n");
      out.write("\t\t\t\t\t<select class=\"form-control \" name=\"searchType\" id=\"searchType\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageMaker.cri.searchType eq '' ? 'selected':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">검색구분</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"n\"\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageMaker.cri.searchType eq 'n' ? 'selected':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">성 명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"p\"\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageMaker.cri.searchType eq 't' ? 'selected':''}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">연락처</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- keyword -->\r\n");
      out.write("\t\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"keyword\" id=\"keyword\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageMaker.cri.keyword }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style=\"width: 18%; display: inline-block;\" />\r\n");
      out.write("\t\t\t\t\t<span class=\"input-group-append\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn btn-primary\" type=\"button\" id=\"searchBtn\" style=\"background: #1a4f72; color: #ffffff; border-color: #1a4f72; display: inline-block; margin-bottom: 4px;\" data-card-widget=\"search\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"list_go(1, '");
      out.print(request.getContextPath());
      out.write("/rest-ltct/res-list');\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-fw fa-search\"></i>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t<!-- end : search bar -->\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"tab-content\" id=\"custom-tabs-three-tabContent\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"tab-pane fade show active\" id=\"custom-psti-detail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\trole=\"tabpanel\" aria-labelledby=\"custom-tabs-three-home-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js\"></script>\r\n");
      out.write("<script type=\"text/x-handlebars-template\" id=\"res-template\">\r\n");
      out.write("{{#each .}}\r\n");
      out.write("\t<tr style=\"cursor:pointer;\" onclick=\"showDetail('{{manageNo}}')\" class=\"each-res-element\" data-manage-no=\"{{manageNo}}\">\r\n");
      out.write("\t\t<td style=\"text-align:left;\">{{pstiNm}}</td>\r\n");
      out.write("\t\t<td>{{age}}</td>\r\n");
      out.write("\t\t<td>{{fnGender gender}}</td>\r\n");
      out.write("\t\t<td>{{prettifyDate reqYmd}}</td>\r\n");
      out.write("\t\t<td>{{prettifyDate resYmd}}</td>\r\n");
      out.write("\t\t<td>{{ngtvCnt}}</td>\r\n");
      out.write("\t\t<td><span class=\"badge badge-{{fnBadgetPstvYn pstvYn}}\">{{fnPstvYn pstvYn}}</span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("{{/each}}\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/x-handlebars-template\" id=\"res-pagination-template\">\r\n");
      out.write("\t<li class=\"page-item each-res-pagination-element\">\r\n");
      out.write("\t\t<a class=\"page-link\" href=\"1\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-angle-double-left\" style=\"color:#1a4f72;\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</li>\r\n");
      out.write("\r\n");
      out.write("\t<li class=\"page-item each-res-pagination-element\">\r\n");
      out.write("\t\t<a class=\"page-link {{checkDisabled prev}}\" href=\"{{#if prev}}{{prevPageNum}}{{/if}}\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-angle-left\" style=\"color:#1a4f72;\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</li>\r\n");
      out.write("\t\r\n");
      out.write("\t{{#each pageNum}}\r\n");
      out.write("\t\t<li class=\"page-item each-res-pagination-element {{signActive this}}\" >\r\n");
      out.write("\t\t\t<a class=\"page-link\" style=\"{{styleActive this}}\" href=\"{{this}}\">\r\n");
      out.write("\t\t\t\t{{this}}\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t{{/each}}\r\n");
      out.write("\t\r\n");
      out.write("\t<li class=\"page-item each-res-pagination-element\">\r\n");
      out.write("\t\t<a class=\"page-link {{checkDisabled next}}\" href=\"{{#if next}}{{nextPageNum}}{{/if}}\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-angle-right\" style=\"color:#1a4f72;\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</li>\r\n");
      out.write("\r\n");
      out.write("\t<li class=\"page-item each-res-pagination-element\">\r\n");
      out.write("\t\t<a class=\"page-link\" href=\"{{realEndPage}}\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-angle-double-right\" style=\"color:#1a4f72;\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</li>\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("Handlebars.registerHelper({\r\n");
      out.write("\"prettifyDate\" : function(timeValue){\r\n");
      out.write("\tif(timeValue){\r\n");
      out.write("\t\tvar dateObj = new Date(timeValue);\r\n");
      out.write("\t\tvar year = dateObj.getFullYear();\r\n");
      out.write("\t\tvar month = dateObj.getMonth() + 1;\r\n");
      out.write("\t\tmonth += '';\r\n");
      out.write("\t\tif(month.length < 2){\r\n");
      out.write("\t\t\tmonth = '0' + month;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar date = dateObj.getDate();\r\n");
      out.write("\t\tdate += '';\r\n");
      out.write("\t\tif(date.length < 2){\r\n");
      out.write("\t\t\tdate = '0' + date;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn year + \"-\" + month + \"-\" + date;\r\n");
      out.write("\t}\r\n");
      out.write("},\r\n");
      out.write("\"signActive\" : function(pageNum){\r\n");
      out.write("\tif(pageNum == page){\r\n");
      out.write("\t\treturn 'active';\r\n");
      out.write("\t}\r\n");
      out.write("},\r\n");
      out.write("\"styleActive\" : function(pageNum){\r\n");
      out.write("\tif(pageNum == page){\r\n");
      out.write("\t\treturn 'background:#1a4f72; border-color:#1a4f72;';\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn 'color:#1a4f72';\r\n");
      out.write("\t}\r\n");
      out.write("},\r\n");
      out.write("\"fnGender\" : function(gender){\r\n");
      out.write("\tif(gender == \"M\"){\r\n");
      out.write("\t\treturn \"남\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(gender ==\"F\"){\r\n");
      out.write("\t\treturn \"여\";\r\n");
      out.write("\t}\r\n");
      out.write("},\r\n");
      out.write("\"fnBadgetPstvYn\" : function(pstvYn){\r\n");
      out.write("\tif(pstvYn == \"Y\"){\r\n");
      out.write("\t\treturn \"danger\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(pstvYn == \"N\"){\r\n");
      out.write("\t\treturn \"primary\";\r\n");
      out.write("\t}\r\n");
      out.write("\treturn \"secondary\";\r\n");
      out.write("},\r\n");
      out.write("\"fnPstvYn\" : function(pstvYn){\r\n");
      out.write("\tif(pstvYn == \"Y\"){\r\n");
      out.write("\t\treturn \"양성\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(pstvYn == \"N\"){\t\r\n");
      out.write("\t\treturn \"음성\";\r\n");
      out.write("\t}\r\n");
      out.write("\treturn \"대기\"\r\n");
      out.write("},\r\n");
      out.write("\"fnsmplResCode\" : function(smplResCode){\r\n");
      out.write("\tif(smplResCode == \"K101\"){\r\n");
      out.write("\t\treturn \"검사중\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(smplResCode == \"K102\"){\r\n");
      out.write("\t\treturn \"양성\";\r\n");
      out.write("\t}\r\n");
      out.write("\tif(smplResCode == \"K103\"){\r\n");
      out.write("\t\treturn \"음성\";\r\n");
      out.write("\t}\r\n");
      out.write("},\r\n");
      out.write("\"checkDisabled\" : function(flag){\r\n");
      out.write("  if(!flag) return 'disabled';\r\n");
      out.write("}\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("var page = 1;\r\n");
      out.write("\r\n");
      out.write("window.onload = function(){\r\n");
      out.write("\tvar url = '");
      out.print(request.getContextPath());
      out.write("/rest-ltct/res-list';\r\n");
      out.write("\tlist_go(page, url);\r\n");
      out.write("\t$('ul.pagination').on('click', 'li a', function(event){\r\n");
      out.write("\t\tif($(this).attr(\"href\")){\r\n");
      out.write("\t\t\tpage = $(this).attr(\"href\");\r\n");
      out.write("\t\t\tgetPage(url, make_form(page));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function make_form(pageParam){\r\n");
      out.write("\tvar jobForm=$('#jobForm')\r\n");
      out.write("\t\r\n");
      out.write("\tif(!pageParam) page = 1;\r\n");
      out.write("\t\r\n");
      out.write("\tpage = pageParam;\r\n");
      out.write("\t\r\n");
      out.write("\tjobForm.find(\"[name='page']\").val(page);\r\n");
      out.write("\tjobForm.find(\"[name='perPageNum']\").val($('select[name=\"perPageNum\"]').val());\r\n");
      out.write("\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\tjobForm.find(\"[name='keyword']\").val($('#keyword').val());\r\n");
      out.write("\t\r\n");
      out.write("\treturn jobForm;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function list_go(pageParam, url){\r\n");
      out.write("\tgetPage(url, make_form(pageParam));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function getPage(handlebarsProcessingURL, form){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : handlebarsProcessingURL,\r\n");
      out.write("\t\ttype : 'post',\r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\tdata : form.serialize(),\r\n");
      out.write("\t\tsuccess : function(dataMap){\r\n");
      out.write("\t\t\t$('#res-table-tbody').html(\"\");\r\n");
      out.write("\t\t\tif(dataMap.resList.length == 0){\r\n");
      out.write("\t\t\t\t$('#res-table-tbody').html('<tr class=\"each-res-element\"><td colspan=\"7\">데이터가 없습니다.</td></tr>');\r\n");
      out.write("\t\t\t\tdataMap.pageMaker.endPage = 1;\r\n");
      out.write("\t\t\t\tdataMap.pageMaker.realEndPage = 1;\r\n");
      out.write("\t\t\t\tprintPagination(dataMap.pageMaker, $('#res-pagination-ul'), $('#res-pagination-template'), '.each-res-pagination-element');\r\n");
      out.write("\t\t\t\tprintData('', $('#res-detail-module'), $('#res-detail-template'), '.res-detail-element')\r\n");
      out.write("\t\t\t\t$('#enableReadRrn').attr('disabled', true);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tprintData(dataMap.resList, $('#res-table-tbody'), $('#res-template'), '.each-res-element');\r\n");
      out.write("\t\t\t\tprintPagination(dataMap.pageMaker, $('#res-pagination-ul'), $('#res-pagination-template'), '.each-res-pagination-element');\r\n");
      out.write("\t\t\t\t$('#enableReadRrn').data('rrn', dataMap.basicDetail.rrn);\r\n");
      out.write("\t\t\t\t$('#enableReadRrn').data('manageNo', dataMap.basicDetail.manageNo);\r\n");
      out.write("\t\t      \tdataMap.basicDetail.rrn = (dataMap.basicDetail.rrn.substring(0,8) + '******');\r\n");
      out.write("\t\t\t\tprintData(dataMap.basicDetail, $('#res-detail-module'), $('#res-detail-template'), '.res-detail-element')\r\n");
      out.write("\t\t\t\t$('#enableReadRrn').attr('disabled', false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(error){\r\n");
      out.write("\t\t\talert('error' + error.status);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function printData(jsonArray, target, templateObject, removeClass){\r\n");
      out.write("\tvar template = Handlebars.compile(templateObject.html());\r\n");
      out.write("\t\r\n");
      out.write("\tvar html = template(jsonArray);\r\n");
      out.write("\t\r\n");
      out.write("\t$(removeClass).remove();\r\n");
      out.write("\t\r\n");
      out.write("\ttarget.append(html);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function printPagination(pageMaker, target, templateObject, removeClass){\r\n");
      out.write("\tvar pageNum = new Array(pageMaker.endPage-pageMaker.startPage+1);\r\n");
      out.write("\t\r\n");
      out.write("\tfor(var i = 0; i < pageMaker.endPage-pageMaker.startPage+1;i++){\r\n");
      out.write("\t\tpageNum[i] = pageMaker.startPage + i;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tpageMaker.pageNum = pageNum;\r\n");
      out.write("\tpageMaker.prevPageNum = pageMaker.startPage - 1;\r\n");
      out.write("\tpageMaker.nextPageNum = pageMaker.endPage + 1;\r\n");
      out.write("\t\r\n");
      out.write("\tvar template = Handlebars.compile(templateObject.html());\r\n");
      out.write("\tvar html = template(pageMaker);\r\n");
      out.write("\ttarget.html(\"\").html(html);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<section class=\"content\">\r\n");
      out.write("\t\t<div style=\"height: 640px;\">\r\n");
      out.write("\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t<table class=\"table table-hover text-nowrap\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr role=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:20%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-label=\"\">성명</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:10%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"\">나이</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:10%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"\">성별</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:20%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-label=\"\">검사일자</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:20%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-label=\"\">결과일자</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:5%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"\">누적음성수</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th style=\"width:15%;\" tabindex=\"0\" aria-controls=\"example2\" rowspan=\"1\" colspan=\"1\" aria-sort=\"ascending\" aria-label=\"\">재검결과</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody id=\"res-table-tbody\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr class=\"each-res-element\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"7\">페이지 로딩중입니다.</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card-footer clearfix\" style=\"background-color: white;\">\r\n");
      out.write("\t\t\t<ul class=\"pagination justify-content-center m-0\" id=\"res-pagination-ul\">\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form id=\"jobForm\">\r\n");
      out.write("\t\t\t<input type='hidden' name=\"page\" value=\"\" />\r\n");
      out.write("\t\t\t<input type='hidden' name=\"perPageNum\" value=\"\" />\r\n");
      out.write("\t\t\t<input type='hidden' name=\"searchType\" value=\"\" />\r\n");
      out.write("\t\t\t<input type='hidden' name=\"keyword\" value=\"\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("</section>");
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.card -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-lg-6 pr-0\">\r\n");
      out.write("\t\t\t\t<section class=\"content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card\" style=\"margin: 1px; height: 763px; margin-top: 13px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t <table class=\"table table-bordered\" style=\"border-left-color: white; border-right-color: white;\">\r\n");
      out.write("\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th style=\"font-size: 17px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row m-0\" style=\"justify-content: space-between;\">\r\n");
      out.write("\t\t\t\t                    \t\t<label style=\"font-size: 17px; margin: 0px;\">재검결과 상세정보</label>\r\n");
      out.write("\t\t\t\t                    \t\t<button type=\"button\" class=\"btn btn-sm btn-primary\" id=\"enableReadRrn\" onclick=\"enableReadRrn(this);\" data-enable=\"N\" data-rrn=\"\" data-manageNo=\"\">개인정보 열람</button>\r\n");
      out.write("\t\t\t\t                    \t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr class=\"ddoing\" style=\"height: 12px; border : 1px solid white;\"></tr>\r\n");
      out.write("\t\t\t\t\t\t </table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.write("<script type=\"text/x-handlebars-template\" id=\"res-detail-template\">\r\n");
      out.write("<table class=\"table table-bordered res-detail-element\">\r\n");
      out.write("  <tbody>\r\n");
      out.write("    <tr style=\"text-align: left;\">\r\n");
      out.write("      <th class=\"col-md-2\">성명</th>\r\n");
      out.write("      <td class=\"col-md-4\">{{pstiNm}}</td>\r\n");
      out.write("      <th class=\"col-md-2\">국적</th>\r\n");
      out.write("      <td class=\"col-md-4\">{{nlty}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>성별</th>\r\n");
      out.write("      <td>{{fnGender gender}}</td>\r\n");
      out.write("      <th>나이</th>\r\n");
      out.write("      <td>{{age}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>발열여부</th>\r\n");
      out.write("      <td>{{feverYn}}</td>\r\n");
      out.write("      <th>임신여부</th>\r\n");
      out.write("      <td>{{pregnYn}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>검사일자</th>\r\n");
      out.write("      <td>{{prettifyDate reqYmd}}</td>\r\n");
      out.write("      <th>누적음성수</th>\r\n");
      out.write("      <td>{{ngtvCnt}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("\t  <th>결과일자</th>\r\n");
      out.write("\t  <td>{{prettifyDate resYmd}}</td>\r\n");
      out.write("      <th>검사결과</th>\r\n");
      out.write("      <td>{{fnsmplResCode smplResCode}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th style=\"vertical-align: middle; padding: 0px;padding-left: 9px;font-size: 12px;\">주민/외국인<br>등록번호</th>\r\n");
      out.write("      <td id=\"dataRrn\">{{rrn}}</td>\r\n");
      out.write("      <th>연락처</th>\r\n");
      out.write("      <td>{{pstiTelno}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>주소</th>\r\n");
      out.write("      <td colspan=\"3\">{{pstiAdres}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>증상</th>\r\n");
      out.write("      <td colspan=\"3\">{{symptms}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("      <th>확진자 코드</th>\r\n");
      out.write("      <td colspan=\"3\">{{cnfmNo}}</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("  </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<table class=\"table table-bordered  res-detail-element\" style=\"margin-top: 12px;\">\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t<strong>요청기관</strong>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<td class=\"col-md-4\">{{instNm}}</td>\r\n");
      out.write("\t\t\t\t<th class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t<strong>연락처</strong>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<td class=\"col-md-4\">{{instTelno}}</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t<strong>주소</strong>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"5\">{{instAdres}}</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("function showDetail(manageNo){\r\n");
      out.write("\tvar trs = $('tr.each-res-element');\r\n");
      out.write("\t\r\n");
      out.write("\ttrs.removeClass('on');\r\n");
      out.write("\t\r\n");
      out.write("\tvar target = $('tr[data-manage-no=\"'+manageNo+'\"]');\r\n");
      out.write("\t\r\n");
      out.write("\ttarget.addClass('on');\r\n");
      out.write("\r\n");
      out.write("\tvar url = '");
      out.print(request.getContextPath());
      out.write("/rest-ltct/manage-detail?manageNo='+manageNo;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : url,\r\n");
      out.write("\t\ttype : 'post',\r\n");
      out.write("\t\tdataType : 'json',\r\n");
      out.write("\t\tsuccess : function(basicDetail){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#enableReadRrn').data('rrn', basicDetail.rrn);\r\n");
      out.write("\t\t\t$('#enableReadRrn').data('manageNo', manageNo);\r\n");
      out.write("\t      \tbasicDetail.rrn = (basicDetail.rrn.substring(0,8) + '******');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tprintData(basicDetail, $('#res-detail-module'), $('#res-detail-template'), '.res-detail-element')\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(error){\r\n");
      out.write("\t\t\talert('error' + error.status);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\t\t\t<div id=\"res-detail-module\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-bordered res-detail-element\">\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr style=\"text-align: left;\">\r\n");
      out.write("                      <th class=\"col-md-2\">성명</th>\r\n");
      out.write("                      <td class=\"col-md-4\"></td>\r\n");
      out.write("                      <th class=\"col-md-2\">국적</th>\r\n");
      out.write("                      <td class=\"col-md-4\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>검사일자</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                      <th>검사결과</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>성별</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                      <th>나이</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>발열여부</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                      <th>임신여부</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>연락처</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                      <th>누적음성수</th>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>주민/외국인등록번호</th>\r\n");
      out.write("                      <td colspan=\"3\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>주소</th>\r\n");
      out.write("                      <td colspan=\"3\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>증상</th>\r\n");
      out.write("                      <td colspan=\"3\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>확정일자</th>\r\n");
      out.write("                      <td colspan=\"3\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr class=\"shittr\"  style=\"text-align: left;\">\r\n");
      out.write("                      <th>확진자 코드</th>\r\n");
      out.write("                      <td colspan=\"3\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                <table class=\"table table-bordered res-detail-element\" style=\"margin-top: 12px;\">\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong>담당기관</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"col-md-4\" id=\"inst_nm\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<th class=\"col-md-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong>연락처</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"col-md-4\" id=\"inst_telno\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong>주소</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\" id=\"inst_adres\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("           </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- /.card -->\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- search bar -->\r\n");
      out.write("\t\t\t\t</section>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.card-body -->\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
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
