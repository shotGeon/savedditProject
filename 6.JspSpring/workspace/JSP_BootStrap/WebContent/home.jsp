<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>




 <body>
 <div class="row">
          <div class="col-12" >
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">회원 리스트</h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div>
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>이름</th>
                      <th>아이디</th>
                      <th>전화번호</th>
                      <th>이메일</th>
                      <th>재직여부</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:set var="list" value="${requestScope.memberList }"/>
					<c:forEach items="${list}" var="mv">
						<tr class="tr2">
							<td class="mName" name="${mv.id}">${mv.name }</td>
							<td class="mId">${mv.id }</td>
							<td class="mPhone">${mv.phone }</td>
							<td class="mEmail">${mv.email }</td>
							<td class="mEnabledName">${mv.enabledName }</td>
						</tr>
			</c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
 
  		<!-- <form id="searchBar">
			
			<select name = "f">
			<option id="sname" value="name">이름</option>
			<option id="sid" value="id">아이디</option>
			<option id="semail" value="email">이메일</option>
			<option id="sphone" value="phone">전화번호</option>
			</select> 
			<input type="text" name= "q" id ="q" value="">
			<input type="button" id="findbutton" value="검색하기">
			
		</form>-->
		  
			<input type="button" onclick="" id="memInsert" value="등록">
		
			


	
 </body>
		