<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<nav aria-label="Navigation">
    				<ul class="pagination justify-content-center m-0">
    					<li class="page-item">
    						<a class="page-link" href="javascript:list_go(1)">
    							<i class="fas fa-angle-double-left"></i>
    						</a>
    					</li>
    						<li class="page-item">
    							<c:if test="${pageMaker.prev}">
    							<a class="page-link" href="javascript:list_go(${ pageMaker.startPage-1})">
    								<i class="fas fa-angle-left"></i>
    							</a>
    							</c:if>
    							
    						</li>
    						
    						<c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" step="1">
    							<li class="page-item
    								<c:if test="${page eq pageMaker.cri.page }">
    								active	
    								</c:if>
    							">
    							<a class="page-link" href="javascript:list_go(${page })" 
    							>${page}</a>
    							</li>
    							
    						</c:forEach>
  						<li class="page-item">
  							<c:if test="${pageMaker.next}">
  							<a class="page-link" href="javascript:list_go(${pageMaker.endPage+1})">
  								<i class="fas fa-angle-right"></i>
  							</a>
  							</c:if>
  						</li>
    						
	    					<li class="page-item">
	    						<a class="page-link" href="javascript:list_go(${pageMaker.realEndPage })">
	    							<i class="fas fa-angle-double-right"></i>
	    						</a>
	    					</li>
    						
    					
    				</ul>
    			</nav>
    			<form id="jobForm">
 		<input type="hidden" name="page" value="" />
 		<input type="hidden" name="perPageNum" value="" />
 		<input type="hidden" name="searchType" value="" />
 		<input type="hidden" name="keyword" value="" />
 	
 	</form>
	<button type="button" class="btn btn-primary" onclick="OpenWindow('regist','회원등록',800,700);" >회원등록</button>
	<input type="button" onclick="location.href='<%=request.getContextPath()%>/member/memberInsert'" id="memInsert" value="등록">
		
 <script>
 
	$(document).on('click','.tr2', function(){
		alert("눌림");
		id=$(this).attr("name");
		alert(id);
	})
	function list_go(page, url){
		if(!url) url="list";
		
		if(page<1){
			page=1;
		}  
		
		
		var jobForm =$('#jobForm');
		
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
		
		jobForm.attr({
			action : url,
			method : 'get'
		}).submit();
	}
	
 </script>
    			