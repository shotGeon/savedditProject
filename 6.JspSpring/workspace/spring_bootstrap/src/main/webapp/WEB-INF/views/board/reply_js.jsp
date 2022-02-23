<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="reply-list-template" >
{{#each .}}
<div class="replyLi" >
	<div class="user-block">
		<img src="<%=request.getContextPath()%>/member/getPictureById.do/{{replyer}}" class="img-circle img-bordered-sm"/>
    </div>
	
 	<div class="timeline-item" >
  		<span class="time">
    		<i class="fa fa-clock"></i>{{prettifyDate regdate}}
	 		<a class="btn btn-primary btn-xs {{rno}}-a" id="modifyReplyBtn" data-rno={{rno}}
				onclick="replyModifyModal_go('{{rno}}');"				
				style="display:{{VisibleByLoginCheck replyer}};"
	    		data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
  		</span>
	
  		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
  		<div class="timeline-body" id="{{rno}}-replytext">{{replytext}} </div>
	</div>
</div>
{{/each}}
</script>

<script type="text/x-handlebars-template"  id="reply-pagination-template" >
<li class="paginate_button page-item">
	<a href="1" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">
		<i class='fas fa-angle-double-left'></i>
	</a>
</li>
<li class="paginate_button page-item">
	<a href="{{#if prev}}{{prevPageNum}}{{/if}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">
		<i class='fas fa-angle-left'></i>
	</a>
</li>
{{#each pageNum}}
<li class="paginate_button page-item {{signActive this}} ">
	<a href="{{this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">
		{{this}}
	</a>
</li>
{{/each}}

<li class="paginate_button page-item ">
	<a href="{{#if next}}{{nextPageNum}}{{/if}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">
		<i class='fas fa-angle-right'></i>
	</a>
</li>
<li class="paginate_button page-item">
	<a href="{{realEndPage}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">
		<i class='fas fa-angle-double-right'></i>
	</a>
</li>	
</script>
<script>

window.onload=function(){
	getPage("<%=request.getContextPath()%>/replies/${board.bno}/"+replyPage);
	

	//타고가는거                                      //나오는거 캐치. 'li a' 로 나올때만 하겠다.  li a를 element로 잡으면 안먹음. 그렇기 때문에 누르면 반사되는걸로 잡아서 쓴다.
	$('ul.pagination').on('click', 'li a', function(event){ 
// 		alert("ul click");
		// 페이지 받아서 페이지 넘겨줌.
		if($(this).attr("href")){
			replyPage=$(this).attr("href");
			getPage("<%=request.getContextPath()%>/replies/${board.bno}/"+replyPage);
		}
		
		return false;
	});

}

var replyPage=1;

//handlebars printElement (args : data Array, append target, handler template)
function printData(replyArr, target, templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);
	$('.replyLi').remove();
	target.after(html);
}

function printPagination(pageMaker, target, templateObject){
	
	var pageNum = new Array(pageMaker.endPage-pageMaker.startPage+1);
	
	for(var i=0; i<pageMaker.endPage-pageMaker.startPage+1;i++){
		pageNum[i]=pageMaker.startPage+i;0  
	}
	pageMaker.pageNum = pageNum;
	pageMaker.prevPageNum = pageMaker.startPage-1;
	pageMaker.nextPageNum = pageMaker.endPage+1;
	
	var template=Handlebars.compile(templateObject.html());
	var html = template(pageMaker);
	target.html("").html(html);
}

function getPage(pageInfo){
	
	$.ajax({
		url : pageInfo,
		type : "get",
		success : function(data){
			printData(data.replyList, $('#repliesDiv'), $('#reply-list-template'));
			printPagination(data.pageMaker, $('ul#pagination'), $('#reply-pagination-template'));
		},
		error: function(error){
			AjaxErrorSecurityRedirectHandler(error.status);
		}
	})
	
	/* $.getJSON(pageInfo, function(data){
		printData(data.replyList, $('#repliesDiv'), $('#reply-list-template'));
		printPagination(data.pageMaker, $('ul#pagination'), $('#reply-pagination-template'));
	}); */
}

Handlebars.registerHelper({
	"prettifyDate":function(timeValue){ // 날짜함수 등록
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date=dateObj.getDate();
		return year+"/"+month+"/"+date;
	},
	"VisibleByLoginCheck":function(replyer){
		var result="none";
		if(replyer == "${loginUser.id}") result="visible";
		return result;
	},
	"signActive":function(pageNum){
		if(pageNum == replyPage) return 'active';
	}
});

function replyRegist_go(){
// 	alert("add reply");
	
	var replytext = $('#newReplyText').val();
	var bno = $('input[name="bno"]').val();
	
	if(!replytext){
		alert("내용은 필수입니다.");
		return;
	}
	
	//alert(replyer+":"+replytext+":"+bno);
	// ""+bno+"" << stringify()로 가져왔기때문에 bno로 해줘도됨.
	var data={
			"bno":""+ bno + "",
			"replyer":"${loginUser.id}",
			"replytext":replytext
	}
	// url ajax로 보낼때 어느부분부터 써야하나..
	$.ajax({
		url:"<%=request.getContextPath()%>/replies",
		type:"post",
		data:JSON.stringify(data),
		contentType:'application/json',
		success:function(data){
			alert('댓글이 등록되었습니다.\n마지막페이지로 이동합니다.');
			replyPage=data // 페이지 이동
			
			getPage("<%=request.getContextPath()%>/replies/"+bno+"/"+data);
			$('#newReplyText').val("");
		},
		error:function(){
// 			alert("댓글등록을 실패하였습니다.");
			AjaxErrorSecurityRedirectHandler(error.status);
		}
	});
}

//댓글 수정
function replyModifyModal_go(rno){
	$('div#modifyModal div.modal-body #replytext').val($('div#'+rno+'-replytext').text());
	$('div#modifyModal div.modal-header h4.modal-title').text(rno);
}

function replyModify_go(){ // ajax event 화면이 새로고침 되지 않는다!
// 	alert("!!!!");
	var rno=$('.modal-title').text();
	var replytext=$('#replytext').val();
	
	var sendData={
			rno:rno,
			replytext:replytext
	}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/replies/"+rno,
		type:"put",
		data:JSON.stringify(sendData),
		headers:{
			"X-HTTP-Method-Override":"PUT"
		},
		contentType:"application/json",
		success:function(result){
			alert("수정되었습니다.");
			getPage("<%=request.getContextPath()%>/replies/${board.bno}/"+replyPage);
		},
		error:function(){
// 			alert('수정 실패했습니다.');
			AjaxErrorSecurityRedirectHandler(error.status);
		},
		complete:function(){
			$('#modifyModal').modal('hide');
		}
	});
}

function replyRemove_go(){
// 	alert("delete reply");
	var rno = $('.modal-title').text();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/replies/${board.bno}/"+rno+"/"+replyPage,
		type:"delete",
		headers:{
			"X-HTTP-Method-Override":"DELETE"
		},
		success:function(page){
			alert("삭제되었습니다.");
			getPage("<%=request.getContextPath()%>/replies/${board.bno}/"+page);
			replyPage=page;
		},
		error:function(error){
// 			alert("삭제 실패했습니다.");
			AjaxErrorSecurityRedirectHandler(error.status);
		},
		complete:function(){
			$('#modifyModal').modal('hide');
		}
	});
}

</script>