<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<c:set var="memberList" value="${dataMap.memberList }" />
<c:set var="pageMaker" value="${dataMap.pageMaker }" />


 <body>
 
 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
 
 <div class="row">
          <div class="col-12" >
            <div class="card">
              <div class="card-header" >
                <h3 class="card-title"><span style="color: black">회원 리스트</span></h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 450px;">
                     <!-- sort num -->
					  	<select class="form-control col-md-3" name="perPageNum"
					  				 id="perPageNum" onchange="list_go(1)">					  		  		
					  		<option value="10">정렬개수</option>	
					  		<option value="2" ${pageMaker.cri.perPageNum == 2 ? 'selected' :''}>2개씩</option>	
					  		<option value="3" ${pageMaker.cri.perPageNum == 3 ? 'selected' :''}>3개씩</option>	
					  		<option value="5" ${pageMaker.cri.perPageNum == 5 ? 'selected' :''}>5개씩</option>	
					  	</select>
                    
                    
                    <!-- search bar -->
					 	<select class="form-control col-md-3" name="searchType" id="searchType">
					 		<option value="" ${pageMaker.cri.searchType eq '' ? 'selected' : '' }>검색구분</option>							
					 		<option value="i" ${pageMaker.cri.searchType eq 'i' ? 'selected' : '' }>아이디</option>							
					 		<option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected' : '' }>이 름</option>							
					 		<option value="p" ${pageMaker.cri.searchType eq 'p' ? 'selected' : '' }>전화번호</option>							
					 		<option value="e" ${pageMaker.cri.searchType eq 'e' ? 'selected' : '' }>이메일</option>						
						</select>
					<!-- keyword -->
  					 	<input  class="form-control" type="text" name="keyword" 
									placeholder="검색어를 입력하세요." value="${pageMaker.cri.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" 
									id="searchBtn" data-card-widget="search" onclick="list_go(1)">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
                    <div class="input-group-append">
                      
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
                    <c:set var="list" value="${memberList}"/>
					<c:forEach items="${list}" var="mv">
						<tr class="tr2" name="${mv.id }">
							<td class="mName"  name="${mv.id }">${mv.name }</td>
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
            <div class="card-footer">
    			<%@ include file="/common/pagination.jsp" %>
    		</div>
    		
          </div>
        </div>
        
      </div>
   </div>
 </div>
 	
	
 </body>
 >