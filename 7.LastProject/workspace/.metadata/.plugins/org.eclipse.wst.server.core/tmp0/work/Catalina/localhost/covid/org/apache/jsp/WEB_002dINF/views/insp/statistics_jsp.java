/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-01-13 00:09:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.insp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class statistics_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("<!-- Google Font: Source Sans Pro -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback\">\r\n");
      out.write("  <!-- Font Awesome -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap/plugins/fontawesome-free/css/all.min.css\">\r\n");
      out.write("  <!-- Theme style -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap/dist/css/adminlte.min.css\">\r\n");
      out.write("  \r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"wrapper\" style=\"max-width: 1280px; margin: 0 auto;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<span style=\"font-weight: bold; margin-left: 17px;\">국내 발생현황</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr style=\"text-align: center; font-weight: bold; background-color:#f5fafc \">\r\n");
      out.write("                      <th colspan=\"2\" style=\"width: 120px\">사망</th>\r\n");
      out.write("                      <th colspan=\"2\" style=\"width: 120px\">재원 위중증</th>\r\n");
      out.write("                      <th colspan=\"2\" style=\"width: 120px\">신규입원</th>\r\n");
      out.write("                      <th colspan=\"2\" style=\"width: 120px\">확진</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr style=\"text-align: center; font-weight: bold; \">\r\n");
      out.write("                      <td>일일</td>\r\n");
      out.write("                      <td>인구 10만명당</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td>일일</td>\r\n");
      out.write("                      <td>인구 10만명당</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td >일일</td>\r\n");
      out.write("                      <td>인구 10만명당</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td>일일</td>\r\n");
      out.write("                      <td>인구 10만명당</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr style=\"text-align: center\">\r\n");
      out.write("                      <td>36</td>\r\n");
      out.write("                      <td>0.07</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td>1,015</td>\r\n");
      out.write("                      <td>1.96</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td>347</td>\r\n");
      out.write("                      <td>0.67</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td>3,129</td>\r\n");
      out.write("                      <td>6.04</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                   \r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("        <span style=\"font-weight: bold; margin-left: 17px;\">사망 현황</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr style=\"text-align: center; font-weight: bold; background-color:#f5fafc;\">\r\n");
      out.write("                      <th style=\"width: 90px\">구분</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.28</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.29</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.30</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.31</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.01</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.02</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.02</th>\r\n");
      out.write("                      <th style=\"width: 70px\">주간일평균</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr style=\"text-align: center;\">\r\n");
      out.write("                      <td style=\"font-weight: bold\">일일</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                      <td>46</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr style=\"text-align: center;\">\r\n");
      out.write("                      <td style=\"font-weight: bold\">인구 10만명 당</td>\r\n");
      out.write("                      <td>0.09</td>\r\n");
      out.write("                      <td>0.07</td>\r\n");
      out.write("                      <td>0.14</td>\r\n");
      out.write("                      <td>0.21</td>\r\n");
      out.write("                      <td>0.12</td>\r\n");
      out.write("                      <td>0.13</td>\r\n");
      out.write("                      <td>0.07</td>\r\n");
      out.write("                      <td>0.12</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                   \r\n");
      out.write("                  </tbody> \r\n");
      out.write("                </table>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          <span style=\"font-weight: bold; margin-left: 17px;\">확진 현황</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr style=\"text-align: center; font-weight: bold; background-color:#f5fafc;\">\r\n");
      out.write("                      <th style=\"width: 90px\">구분</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.28</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.29</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.30</th>\r\n");
      out.write("                      <th style=\"width: 40px\">12.31</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.01</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.02</th>\r\n");
      out.write("                      <th style=\"width: 40px\">01.02</th>\r\n");
      out.write("                      <th style=\"width: 70px\">주간일평균</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr style=\"text-align: center;\">\r\n");
      out.write("                      <td style=\"font-weight: bold\">일일</td>\r\n");
      out.write("                      <td>3,864</td>\r\n");
      out.write("                      <td>5,406</td>\r\n");
      out.write("                      <td>5,035</td>\r\n");
      out.write("                      <td>4,874</td>\r\n");
      out.write("                      <td>4,415</td>\r\n");
      out.write("                      <td>3,832</td>\r\n");
      out.write("                      <td>3,129</td>\r\n");
      out.write("                      <td>4,365</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr style=\"text-align: center;\">\r\n");
      out.write("                      <td style=\"font-weight: bold\">인구 10만명 당</td>\r\n");
      out.write("                      <td>7.49</td>\r\n");
      out.write("                      <td>10.43</td>\r\n");
      out.write("                      <td>9.71</td>\r\n");
      out.write("                      <td>9.41</td>\r\n");
      out.write("                      <td>8.52</td>\r\n");
      out.write("                      <td>7.39</td>\r\n");
      out.write("                      <td>6.07</td>\r\n");
      out.write("                      <td>8.42</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                   \r\n");
      out.write("                  </tbody> \r\n");
      out.write("                </table>\r\n");
      out.write("          </div>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          <span style=\"font-weight: bold; margin-left: 17px;\">일일 및 누적 확진환자 추세</span>\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"card-body\">\r\n");
      out.write("          \t\t<canvas id=\"myChart\"></canvas>\r\n");
      out.write("          </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"col-6\" style=\"float:left\">\r\n");
      out.write("\t\t\t  <span style=\"font-weight: bold; margin-left: 17px;\">성별 확진자 현황</span>\r\n");
      out.write("\t\t\t\t  <div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"pieChart\"></canvas>\t\t  \r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t  \t  \r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"col-6\" style=\"float:right\">\r\n");
      out.write("\t\t\t  <span style=\"font-weight: bold; margin-left: 20px;\">연령별 확진자 현황</span>\r\n");
      out.write("\t\t\t\t  <div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<canvas id=\"ageChart\"></canvas>\t\t  \r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t  \t  \r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("            var context = document.getElementById('myChart').getContext('2d');\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            var myChart = new Chart(context, \r\n");
      out.write("            {\r\n");
      out.write("                type: 'line', // 차트의 형태\r\n");
      out.write("                data: { // 차트에 들어갈 데이터\r\n");
      out.write("                \t//x축\r\n");
      out.write("                    labels: ['12.28','12.29','12.30','12.31','01.01','01.02','01.03'],\r\n");
      out.write("                    //데이터\r\n");
      out.write("                    //'rgb(247,12,12)'\r\n");
      out.write("                    datasets: [\r\n");
      out.write("\t\t\t\t                    { \r\n");
      out.write("\t\t\t\t                            label: '일별 확진환자', //차트 제목\r\n");
      out.write("\t\t\t\t                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지\r\n");
      out.write("\t\t\t\t                            backgroundColor:'rgb(247,12,12)',\r\n");
      out.write("\t\t\t\t                            borderColor:'rgba(255, 99, 132, 1)',\r\n");
      out.write("\t\t\t\t                            yAxisID: 'y_left',\r\n");
      out.write("\t\t\t\t                            data: [3864,5406,5035,4874,4415,3832,3129] //x축 label에 대응되는 데이터 값\r\n");
      out.write("\t\t\t\t                    },\r\n");
      out.write("\t\t\t\t                    \r\n");
      out.write("\t\t\t\t                    {\r\n");
      out.write("\t\t\t\t                    \tlabel: '누적 확진환자',\r\n");
      out.write("\t\t\t\t                    \tfill: false,\r\n");
      out.write("\t\t\t\t                        type : 'bar', // 'bar' type, 전체 타입과 같다면 생략가능\r\n");
      out.write("\t\t\t\t                        backgroundColor: 'rgb(111, 121, 255)',\r\n");
      out.write("\t\t\t\t                        borderColor: 'rgb(255, 204, 102)',\r\n");
      out.write("\t\t\t\t                        yAxisID: 'y_right',\r\n");
      out.write("\t\t\t\t                        data: [615515, 620922, 625957, 630831, 635246, 639078, 642207],\r\n");
      out.write("\t\t\t\t                    \t\r\n");
      out.write("\t\t\t\t                    }\r\n");
      out.write("\t\t\t\t                    \r\n");
      out.write("                \t\t\t  ],\r\n");
      out.write("                          \r\n");
      out.write("\t                },\r\n");
      out.write("\t                options: {\r\n");
      out.write("\t                \tresponsive:true,\r\n");
      out.write("\t                    scales: {\r\n");
      out.write("\t                    \ty_left:{\r\n");
      out.write("\t        \t\t\t\t\tticks: {\r\n");
      out.write("\t        \t\t\t\t\t\t\r\n");
      out.write("\t        \t\t\t\t\t\tsuggestedMin: 0,\r\n");
      out.write("\t        \t\t\t\t\t\tsuggestedMax: 10000,\r\n");
      out.write("\t        \t\t\t\t\t\tstepSize : 1000\r\n");
      out.write("\t        \t\t\t\t\t},\r\n");
      out.write("\t        \t\t\t\t\tbeginAtZero:true,\r\n");
      out.write("\t        \t\t\t\t\tposition : 'left'\r\n");
      out.write("\t        \t\t\t\t},\r\n");
      out.write("\t                    \ty_right:{\r\n");
      out.write("\t\t\t\t\t\t\t\tticks: {\r\n");
      out.write("\t        \t\t\t\t\t\tsuggestedMin: 0,\r\n");
      out.write("\t        \t\t\t\t\t\tsuggestedMax: 1000000,\r\n");
      out.write("\t        \t\t\t\t\t\tstepSize : 100000\r\n");
      out.write("\t        \t\t\t\t\t},\r\n");
      out.write("\t        \t\t\t\t\tbeginAtZero:true,\r\n");
      out.write("\t                    \t\tposition: 'right'\r\n");
      out.write("\t                    \t\t\r\n");
      out.write("\t                    \t\t\r\n");
      out.write("\t                    \t},\r\n");
      out.write("\t                    \t\t                    \t\r\n");
      out.write("\t                    },\r\n");
      out.write("\t                    animation:false,\r\n");
      out.write("\t                    showValue:{\r\n");
      out.write("\t                    \tfontStyle:'Helvetica',\r\n");
      out.write("\t                    \tfontSize: 20\r\n");
      out.write("\t                    }\r\n");
      out.write("\t                    \r\n");
      out.write("\t                },\r\n");
      out.write("                \r\n");
      out.write("               \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            });\r\n");
      out.write("           \r\n");
      out.write("            var dataset = { \r\n");
      out.write("            \t\t//라벨별 컬러설정 \r\n");
      out.write("            \t\tbackgroundColor: ['#f74336', '#36302f'],\r\n");
      out.write("            \t\tborderColor: '#22252B',\r\n");
      out.write("            \t\tdata: [50, 45] \r\n");
      out.write("            }\r\n");
      out.write("            var labels=['남성','여성'];\r\n");
      out.write("            var datasets={ datasets:[dataset], labels:labels}\r\n");
      out.write("    \t\t\r\n");
      out.write("            var config = { \r\n");
      out.write("            \t\ttype: 'pie',\r\n");
      out.write("            \t\t//데이터 셋 \r\n");
      out.write("            \t\tdata: datasets,\r\n");
      out.write("            \t\toptions: { \r\n");
      out.write("            \t\t\tresponsive: true, \r\n");
      out.write("            \t\t\t//true 하게 되면 캔버스 width,height에 따라 리사이징된다.\r\n");
      out.write("            \t\t\tmaintainAspectRatio: false,  \r\n");
      out.write("            \t\t\tlegend: { \r\n");
      out.write("            \t\t\t\tposition: 'top', \r\n");
      out.write("            \t\t\t\tfontColor: 'black', \r\n");
      out.write("            \t\t\t\talign: 'center', \r\n");
      out.write("            \t\t\t\tdisplay: true, \r\n");
      out.write("            \t\t\t\tfullWidth: true, \r\n");
      out.write("            \t\t\t\tlabels: { \r\n");
      out.write("            \t\t\t\t\tfontColor: 'rgb(0, 0, 0)' \r\n");
      out.write("            \t\t\t\t} \r\n");
      out.write("            \t\t\t}, \r\n");
      out.write("            \t\t\tplugins: { \r\n");
      out.write("            \t\t\t\tlabels: {//두번째 script태그를 설정하면 각 항목에다가 원하는 데이터 라벨링을 할 수 있다. \r\n");
      out.write("            \t\t\t\t\trender: 'value', \r\n");
      out.write("            \t\t\t\t\tfontColor: 'black', \r\n");
      out.write("            \t\t\t\t\tfontSize: 15, \r\n");
      out.write("            \t\t\t\t\tprecision: 2 \r\n");
      out.write("            \t\t\t\t\t} \r\n");
      out.write("            \t\t\t} \r\n");
      out.write("            \t  } \r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            var contextpie = document.getElementById('pieChart');\r\n");
      out.write("            var pieChart = new Chart(contextpie,config);\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            //연령별 확진자\r\n");
      out.write("             var context = document.getElementById('ageChart').getContext('2d');\r\n");
      out.write("            var myChart = new Chart(context, {\r\n");
      out.write("                type: 'bar', // 차트의 형태\r\n");
      out.write("                data: { // 차트에 들어갈 데이터\r\n");
      out.write("                    labels: [\r\n");
      out.write("                        //x 축\r\n");
      out.write("                        '0~9세','10대','20대','30대','40대','50대','60대','70대','80대이상'\r\n");
      out.write("                    ],\r\n");
      out.write("                    datasets: [\r\n");
      out.write("                        { //데이터\r\n");
      out.write("                            label: '확진자 수', //차트 제목\r\n");
      out.write("                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지\r\n");
      out.write("                            data: [\r\n");
      out.write("                                50834,64376,95818,93403,93897,93010,91227,38886,20756 //x축 label에 대응되는 데이터 값\r\n");
      out.write("                            ],\r\n");
      out.write("                            backgroundColor: [\r\n");
      out.write("                                //색상\r\n");
      out.write("                                'rgba(247, 67, 54)'\r\n");
      out.write("                            ]\r\n");
      out.write("                            \r\n");
      out.write("                        }\r\n");
      out.write("                    ]\r\n");
      out.write("                },\r\n");
      out.write("                options: {\r\n");
      out.write("                \tplugins: {\r\n");
      out.write("\t                \tlegend: {\r\n");
      out.write("\t                \t\tdisplay: false,\r\n");
      out.write("\t                \t},\r\n");
      out.write("                \t},\r\n");
      out.write("                    scales: {\r\n");
      out.write("                        yAxes: [\r\n");
      out.write("                            {\r\n");
      out.write("                                ticks: {\r\n");
      out.write("                                    beginAtZero: true\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                        ]\r\n");
      out.write("                    }\r\n");
      out.write("                    \r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("       \r\n");
      out.write("\t\r\n");
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
