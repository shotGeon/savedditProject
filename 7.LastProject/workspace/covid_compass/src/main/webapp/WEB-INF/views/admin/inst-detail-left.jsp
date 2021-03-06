<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="inst-list-template" >
{{#each .}}
		<tr style="cursor: pointer;" class="each-inst-element" instNo='{{instNo}}' data-instNo="{{instNo}}" onclick="detail_go('{{instNo}}')">
		<td onclick="event.cancelBubble=true" style="cursor: default;">
		<input type="checkbox" name="instCheckBox" value="{{instNo}}" onclick="cancleAll()"></td>
				<td><span class="badge badge-{{styleBadge division}}">{{division}}</span></td>
				<td title="{{instNm}}" style="text-align:left; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">{{instNm}}</td>
				<td title="{{instAdres}}" style="text-align:left; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">{{instAdres}}</td>
				<td title="{{instTelNO}}">{{instTelno}}</td>
		<td>{{empNo}}</td>
		</tr>

{{/each}}
</script>

<script type="text/x-handlebars-template"  id="inst-pagination-template" >
    <li class="page-item each-inst-pagination-element">
		<a class="page-link" href="1"> 
			<i class="fas fa-angle-double-left" style="color:#1a4f72;"></i>
    	</a>
    </li>
    <li class="page-item each-inst-pagination-element">
		<a class="page-link" href="{{#if prev}}{{prevPageNum}}{{/if}}"> 
			<i class="fas fa-angle-left" style="color:#1a4f72;"></i>
    	</a>
	</li>

{{#each pageNum}}
    <li class="page-item each-inst-pagination-element {{signActive this}}" >
		<a class="page-link" href="{{this}}" >{{this}}
		</a>
	</li>
{{/each}}

    <li class="page-item each-inst-pagination-element">
		<a class="page-link" href="{{#if next}}{{nextPageNum}}{{/if}}"> 
			<i class="fas fa-angle-right" style="color:#1a4f72;"></i>
    	</a>
	</li>
    <li class="page-item each-inst-pagination-element">
		<a class="page-link" href="{{realEndPage}}"> 
			<i class="fas fa-angle-double-right" style="color:#1a4f72;"></i>
		</a>
	</li>
</script>


<script type="text/x-handlebars-template"  id="inst-detail-template" >
<div class="delete-detail-tm">
 <div class="row" style="margin: 10px;">
		<label style="text-align: right; margin: auto;" class="col-sm-2" for="note">?????????</label>
		<div class="col-sm-4">
			<input style="width: 220px;" type="text" class="form-control" readonly value="{{instNm}}">
		</div>
		
		<label style="text-align: right; margin: auto;" class="col-sm-2" for="sort">??????</label>
		<div class="col-sm-4">
			<input id="division" type="text" class="form-control" readonly="readonly" value="{{division}}">
		</div>
	</div>
	
	
	<div class="row" style="margin: 10px;">
		<label style="text-align: right; margin: auto;" class="col-sm-2" for="sort">??????</label>
		<div class="col-sm-10 input-group-append">
			<input type="text" class="form-control" readonly="readonly" value="{{instAdres}}">
	
		</div>
	
	
	</div>
	
	<div class="row" style="margin: 10px;">
		<label style="text-align: right; margin: auto;" class="col-sm-2" for="sort">?????????</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" readonly="readonly" value="{{instTelno}}">
		</div>
	
		<label style="text-align: right; margin: auto;" class="col-sm-2" for="note">??????</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" readonly value="??????????????? ??????">
		</div>
	</div>
</div>
</script>

<script type="text/x-handlebars-template"  id="inst-empList-template" >
{{#each .}}
	<div class="deleteEmpListtmp">
			<div class="row">
				<div class="col-3" title="{{mberNm}}">
					<input type="hidden" id="passwordResetValue" value="{{mberNo}}"/>
					<input type="text" readonly class="form-control user-list" placeholder="?????????1" value="{{mberNm}}">
				</div>
				<div class="col-4" title="{{mberId}}">
					<input type="text" readonly class="form-control user-list" placeholder="?????????" value="{{mberId}}">
				</div>
				<div class="col-2" style="padding: 0px;" title="{{mberTelno}}">
					<input type="text" readonly class="form-control user-list" placeholder="010-1234-5678" value="{{mberTelno}}">
				</div>
				<div class="col-3" style="text-align: center; ">
					<button type="button" onclick="password_reset('{{mberNo}}')" class="btn btn-primary user-list" style="background: #1a4f72; border-color: #1a4f72;padding-top: 3px; ">
					<span style="display: block;display:inline-block; ">?????????</span>
					</button>
				</div>
			</div>
		</div>
{{/each}}
</script>


<script>
Handlebars.registerHelper({
		"signActive" : function(pageNum){
		  if(pageNum == page) return 'active';
		},
		"styleActive" : function(pageNum){
			if(pageNum == page){
				return 'background:#1a4f72; border-color:#1a4f72;';
			}else{
				return 'color:#1a4f72';
		}
		
	},
	"styleBadge" : function(division){
		if(division=="?????????"){
			return "primary";
		}
		if(division=="?????????"){
			return "success";
		}
		if(division=="??????"){
			return "danger";
		}
		if(division=="??????????????????"){
			return "warning";
		}
		
	}
		
})
</script>

<script>

var page =1;

window.onload = function(){
	var url='<%=request.getContextPath()%>/rest-inst/inst-list';
	list_go(page, url);
		$('ul.pagination').on('click', 'li a', function(event){
			if($(this).attr("href")){
			page = $(this).attr("href");
			getPage(url, make_form(page));
		}
		return false;
	});
}
function make_form(pageParam){
	var jobForm=$('#jobForm');
	//alert(pageParam);
	if(!pageParam) page =1;
	
	page = pageParam;
	
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='searchType2']").val($('select[name="searchType2"]').val());
	jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
	
	return jobForm;
}

function list_go(pageParam, url){
	
	getPage(url, make_form(pageParam));
}
function getPage(handlebarsProcessingURL, form){
	
	$.ajax({
		url : handlebarsProcessingURL,
		type : 'post',
		dataType : 'json',
		data : form.serialize(),
		success : function(dataMap){
			var len = dataMap.instList.length;
			$('#inst-list-table-tbody').html('');
			if(len == 0){
				$('#inst-list-table-tbody').html('<tr class="each-inst-element"> <td id="initialTd" colspan="6">???????????? ????????????.</td> </tr>');
				dataMap.pageMaker.endPage=1;
				dataMap.pageMaker.realEndPage=1;
				printPagination(dataMap.pageMaker,$('#inst-list-pagination-ul'), $('#inst-pagination-template'), '.each-inst-pagination-element');
				printDetail('',$('#inst-detail-tm'),$('#inst-detail-template'), '.delete-detail-tm');
				printEmp('', $('#appendEmpListtmp'),$('#inst-empList-template'),'.deleteEmpListtmp');
			}else{
				printData(dataMap.instList, $('#inst-list-table-tbody'),$('#inst-list-template'),'.each-inst-element');
				printPagination(dataMap.pageMaker,$('#inst-list-pagination-ul'), $('#inst-pagination-template'), '.each-inst-pagination-element');
				printDetail(dataMap.firstInst,$('#inst-detail-tm'),$('#inst-detail-template'), '.delete-detail-tm');
				printEmp(dataMap.firstMberList, $('#appendEmpListtmp'),$('#inst-empList-template'),'.deleteEmpListtmp');
				$('#instModifyButton').val(dataMap.firstInst.instNo);
			}
		},
		error : function(error){
			alert('error'+error.status);
		}
	})
}

 function detail_go(instNo){
	 
	 var trs = $('.each-inst-element');
	 
	 trs.removeClass('on');
	 
	 var target = $('.each-inst-element[data-instNo='+instNo+']');
	 
	 target.addClass('on');
	 
	 $('#instModifyButton').val(instNo);
	 $.ajax({
		url : '<%=request.getContextPath()%>/admin/inst-detail',
		type : 'get',
		data : {"instNo": instNo},
		success : function(instMap){
			printDetail(instMap.inst,$('#inst-detail-tm'),$('#inst-detail-template'), '.delete-detail-tm');
			printEmp(instMap.mber, $('#appendEmpListtmp'),$('#inst-empList-template'),'.deleteEmpListtmp');
		},
		error : function(xhr){
			alert('error'+xhr.status);
		}
	}) 
} 

//jsonArray??? ResponseEntity?????? ????????? List??? ???????????? ??????
//target??? handlebars??? ????????? ???????????? append??? ???????????? jquery???????????? ??????????????? ??? ?????? ?????? tbody??? id??? ?????? target?????? ?????????.
//templateObject??? handlebars??? ???????????? ?????? ??????????????? jquery????????????.
//removeClass??? append???????????? ????????? ?????? ?????????<???????????? handlebars??? ?????? ?????? ??????>??? ????????? ????????? '.(???????????????)'??? ?????????.
//?????? ????????? templateObject?????? handlebars??? ?????? ?????? ????????? ????????? class??? ????????? ??????. ???????????? .each-inptnt-element??????,
//tr????????? ????????????.

function printEmp(jsonArray, target, templateObject, removeClass){
	var template = Handlebars.compile(templateObject.html());
	
	var html = template(jsonArray);
	
	$(removeClass).remove();
	
	target.append(html);
	
}

function printDetail(jsonArray, target, templateObject, removeClass){
	var template = Handlebars.compile(templateObject.html());
	
	var html = template(jsonArray);
	
	$(removeClass).remove();
	
	target.append(html);
	
}

function printData(jsonArray, target, templateObject, removeClass){

	//templateObject??? json data??? ????????? ???????????? return?????? function template??? ????????????.
	var template = Handlebars.compile(templateObject.html());
	
	//?????? template??? ???????????? jsonArray??? ????????? ???????????? html??? ????????????.
	var html = template(jsonArray);
	
	//?????? html????????? append?????? ?????? ????????? ?????? ????????? ?????????. (???????????? ????????? ????????? 10????????? ????????? ??? ????????? 10???, 20???, 30??? ??? ????????? ????????? ????????? 10?????? ???????????????)
	$(removeClass).remove();
	
	//html????????? append??????.
	target.append(html);
	}

function printPagination(pageMaker, target, templateObject, removeClass){
	var pageNum = new Array(pageMaker.endPage-pageMaker.startPage+1);
	
	for(var i=0;i<pageMaker.endPage-pageMaker.startPage+1;i++){
		pageNum[i]=pageMaker.startPage+i;
	}	
	pageMaker.pageNum=pageNum;  
	pageMaker.prevPageNum=pageMaker.startPage-1;
	pageMaker.nextPageNum=pageMaker.endPage+1;
	
	var template=Handlebars.compile(templateObject.html());	
	var html = template(pageMaker);	
	target.html("").html(html);
}

</script>

<section class="content">
	<div style="height: 640px;">
		<div class="table-responsive">
			<table class="table table-hover text-nowrap"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr role="row">
						<th style="width: 5%;"><input type="checkbox" name="inst" id="selectAll"
							onclick="selectAll()"></th>
						<th tabindex="0" aria-controls="example2" rowspan="1"
							style="text-align: center; width: 20%;" colspan="1">??????</th>
						<th tabindex="0" aria-controls="example2" rowspan="1"
							style="text-align: center; width: 30%;" colspan="1">?????????</th>
						<th tabindex="0" aria-controls="example2" rowspan="1"
							style="text-align: center; width: 32%;" colspan="1">??????</th>
						<th tabindex="0" aria-controls="example2" rowspan="1"
							style="text-align: center; width: 15%;" colspan="1">?????????</th>
						<th tabindex="0" aria-controls="example2" rowspan="1"
							style="text-align: center; width: 15%;" colspan="1">?????????</th>
					</tr>
				</thead>
				<tbody id="inst-list-table-tbody">
					<tr class="each-inst-element">
						<td id="initialTd" colspan="6">????????? ????????? ?????????.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- /.card-body -->
	<div class="card-footer clearfix" style="background-color: white;">
		<ul class="pagination justify-content-center m-0" id="inst-list-pagination-ul">
    	</ul>
	</div>
</section>

<form id="jobForm">
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="searchType2" value="" />
	<input type='hidden' name="keyword" value="" />
</form>


<script>
		function selectAll(checkBox){
			var length = document.getElementsByName("instCheckBox").length;
			if(document.getElementById('selectAll').checked==true){
				for(var i=0; i<length; i++) document.getElementsByName("instCheckBox")[i].checked=true;
			}

			if(document.getElementById('selectAll').checked==false){
				for(var i=0; i<length; i++) document.getElementsByName("instCheckBox")[i].checked=false;
			}


		}
		function cancleAll(){

			if(document.getElementById('selectAll').checked==true){
				document.getElementById('selectAll').checked=false;
			}
		}
				
</script>


