<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
table tr td {
	overflow: hidden;
	white-space: initial;
	text-overflow: ellipsis;
	-webkit-box-orient: vertical;
	word-break: break-all;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="hspt-bookmark-list-template" >
{{#each .}}
          <tr
			data-hspt-no="{{hsptNo}}" data-inst-no="{{instNo}}" data-inst-nm="{{instNm}}" data-inst-telno="{{instTelno}}" data-emp-cnt="{{empCnt}}"
			data-rmnd-sckbd-cnt="{{rmndSckbdCnt}}" data-sckbd-cnt="{{sckbdCnt}}" data-op-rate="{{opRate}}" data-inst-adres="{{instAdres}}"
            onclick="showDetail('{{hsptNo}}', '{{instAdres}}')"
            class="each-hspt-element" style="cursor: pointer;">
            <td style="white-space: nowrap;text-overflow: ellipsis;overflow: hidden;">{{instNm}}</td>
            <td style="white-space: nowrap;text-overflow: ellipsis;overflow: hidden;" data-adres-map="{{instAdres}}">{{instAdres}}</td>
            <td>{{rmndSckbdCnt}}/{{sckbdCnt}}</td>
            <td style="text-align:center;"><span class="badge badge-{{fnBadge opRate}}" style="width: 35px;">{{opRate}}%</span></td>
          </tr>
{{/each}}
</script>
<script type="text/x-handlebars-template"  id="inptnt-pagination-template" >
    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="1"> <i class="fas fa-angle-double-left" style="color:#1a4f72;"></i>
    </a></li>
    <li class="page-item each-inptnt-pagination-element"><a class="page-link {{checkDisabled prev}}" href="{{#if prev}}{{prevPageNum}}{{/if}}"> <i class="fas fa-angle-left" style="color:#1a4f72;"></i>
    </a></li>

{{#each pageNum}}
    <li class="page-item each-inptnt-pagination-element {{signActive this}}" ><a class="page-link" href="{{this}}" >{{this}}</a></li>
{{/each}}

    <li class="page-item each-inptnt-pagination-element"><a class="page-link {{checkDisabled next}}" href="{{#if next}}{{nextPageNum}}{{/if}}"> <i class="fas fa-angle-right" style="color:#1a4f72;"></i>
    </a></li>
    <li class="page-item each-inptnt-pagination-element"><a class="page-link" href="{{realEndPage}}"> <i class="fas fa-angle-double-right" style="color:#1a4f72;"></i>
</a></li>
</script>

<script>
Handlebars.registerHelper({
"prettifyDate" : function(timeValue){
  var dateObj = new Date(timeValue);
  var year = dateObj.getFullYear();
  var month = dateObj.getMonth() + 1;
  var date = dateObj.getDate();
  return year + "-" + month + "-" + date;
},
"checkDisabled" : function(flag){
    if(!flag) return 'disabled';
},
"signActive" : function(pageNum){
  if(pageNum == page) return 'active';
},
"fnBadge" : function(opRate){
	if(opRate > 79){
		return "danger";
	}
	if(opRate < 71){
		return "primary";
	}
	else{
		return "warning";
	}
}
});
</script>

<script>
function process_go(type){
	
	var check = confirm('???????????? ???????????????????');
	if(!check) return;
	
	var closeWindow = false;
	var message = '';
	
	if(type == 'A'){
		process_url = '<%=request.getContextPath()%>/rest-hspt/process-dgnss-sckbdreq-inptnt';
		closeWindow = true;
		message = '??????????????? ?????????????????????.';
    	$(opener.document).find('form[name="processForm"] input[name="closeWindow"]').val(closeWindow);
    	
    	processForm = $(opener.document).find('form[name="processForm"]');
    	
  		$.ajax({
  			url : process_url,
  			type : 'post',
  			data : processForm.serialize(),
  			dataType : 'json',
  			success : function(dataMap) {
  				
  				console.log(dataMap);
  				
  				if(dataMap.msg == 'success'){
  					alert(message);
	  				window.opener.location.reload(true);
	  				window.close();
  				}else{
  					alert(dataMap.msg);
	  				window.opener.location.reload(true);
	  				window.location.reload(true);  
  				}
  				
  				
  			},
  			error : function(error) {
  				alert('error' + error.status);
  			}
  		});
    }
	if(type == 'B'){
		
		process_url = '<%=request.getContextPath()%>/rest-hspt/process-inptnt-sckbdreq-inptnt';
		
// 		$('#go-inptnt-btn').attr('data-hspt-no', hsptNo);
		
		var data = 
		{
			 manageNo : $('#go-inptnt-btn').attr('data-manage-no')
			,toHsptNo : $('#go-inptnt-btn').attr('data-hspt-no')
		};
		
		closeWindow = true;
		message = '??????????????? ?????????????????????.';
		$.ajax({
			url : process_url,
			type : 'post',
			data : data,
			dataType : 'json',
			success : function(dataMap) {
				
				console.log(dataMap);
				
				if(dataMap.msg == 'success'){
					alert(message);
	  				window.opener.location.reload(true);
	  				window.close();	
				}else{
					alert(dataMap.msg);
	  				window.opener.location.reload(true);
	  				window.location.reload(true);
				}
				
  				
			},
			error : function(error) {
				alert('error' + error.status);
			}
		});		
	}
	
	if(type == 'C'){
		
		process_url = '<%=request.getContextPath()%>/rest-hspt/process-rejected-or-cancled-sckbdreq-to-sckbdreq-inptnt';
		
		var data = 
		{
			 manageNo : $('#go-inptnt-btn').attr('data-manage-no')
			,toHsptNo : $('#go-inptnt-btn').attr('data-hspt-no')
			,sckbdreqNo : '${sckbdreqNo}'
		};
		
		closeWindow = true;
		message = '??????????????? ?????????????????????.';
		$.ajax({
			url : process_url,
			type : 'post',
			data : data,
			dataType : 'json',
			success : function(dataMap) {
				
				console.log(dataMap);
				
				if(dataMap.msg == 'success'){
					alert(message);
	  				window.opener.location.reload(true);
	  				window.close();				
				}else{
					alert(dataMap.msg);
	  				window.opener.location.reload(true);
	  				window.location.reload(true);
				}
			},
			error : function(error) {
				alert('error' + error.status);
			}
		});		
	}
}
</script>

<script>

var page = 1;

var targetId = '';

var pagenationId = '';

var instNm ="";

var sckbdCnt ="";

var url = '<%=request.getContextPath() %>/rest-hspt/hspt-list-to-inptnt';
window.onload = function(){
 	
	addEvnetWaitTab();
	addEvnetReqTab();
	
	$('#go-inptnt-btn').attr('disabled', true);
	$('#bookmark-btn').attr('disabled', true);
	
  list_go(url, page, targetId, pagenationId);
	$('ul.pagination').on('click','li a',function(event){
		if($(this).attr("href")) {
			page=$(this).attr("href");
			getPage(url, make_form(page), targetId, pagenationId);
		}
		
		return false;
	});
}
function make_form(pageParam){
  var jobForm=$('#jobForm');
  
  if(!pageParam) page = 1;
  
  page = pageParam;
  
  jobForm.find("[name='page']").val(page);
  jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
  jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
  jobForm.find("[name='keyword']").val($('#keywordId').val());
  
  return jobForm;
}

function list_go(url, pageParam, targetId, pagenationId){
	
	
  getPage(url, make_form(pageParam), targetId, pagenationId);
}

function getPage(handelbarsProcessingURL, form, targetId, pagenationId){
	
	
	if(!targetId) targetId='#hspt-bookmark-list-table-tbody';
	if(!pagenationId) pagenationId = '#inptnt-list-pagination-ul';
	
	
	$.ajax({
    url : handelbarsProcessingURL,
    type : 'get',
    dataType : 'json',
    data : form.serialize(),
    success : function(dataMap){
    	
    	if(dataMap.hsptList.length == 0){
    		
    		$('#hspt-all-list-table-tbody').html('<tr class="each-hspt-element"><td id="initialTd" colspan="4" style="text-align: center;">????????? ????????? ?????????.</td></tr>');
    		$('#hspt-bookmark-list-table-tbody').html('<tr class="each-hspt-element"><td id="initialTd2" colspan="4" style="text-align: center;">????????? ????????? ?????????.</td></tr>');
    		
    		$('#initialTd').html('???????????? ????????????.');
    		$('#initialTd2').html('???????????? ????????????.');
    		dataMap.pageMaker.endPage = 1;
    		printPagination(dataMap.pageMaker, $(pagenationId), $('#inptnt-pagination-template'), '.each-inptnt-pagination-element');
    	}else{
    		
	      printData(dataMap.hsptList, $(targetId), $('#hspt-bookmark-list-template'), '.each-hspt-element');
	      printPagination(dataMap.pageMaker, $(pagenationId), $('#inptnt-pagination-template'), '.each-inptnt-pagination-element');
      
    	}
    	
      initKakaoMap(dataMap.hsptList, dataMap.adres);
      
    },
    error : function(error){
      alert('error' + error.status);
    }
  })
 }



//jsonArray??? ResponseEntity?????? ????????? List??? ???????????? ??????
//target??? handlebars??? ????????? ???????????? append??? ???????????? jquery???????????? ??????????????? ??? ?????? ?????? tbody??? id??? ?????? target?????? ?????????.
//templateObject??? handlebars??? ???????????? ?????? ??????????????? jquery????????????.
//removeClass??? append???????????? ????????? ?????? ?????????<???????????? handlebars??? ?????? ?????? ??????>??? ????????? ????????? '.(???????????????)'??? ?????????.
//?????? ????????? templateObject?????? handlebars??? ?????? ?????? ????????? ????????? class??? ????????? ??????. ???????????? .each-inptnt-element??????,
//tr????????? ????????????.
function printData(jsonArray, target, templateObject, removeClass) {

		// templateObject??? json data??? ????????? ???????????? return?????? function template??? ????????????.
		var template = Handlebars.compile(templateObject.html());

		// ?????? template??? ???????????? jsonArray??? ????????? ???????????? html??? ????????????.
		var html = template(jsonArray);

		// ?????? html????????? append?????? ?????? ????????? ?????? ????????? ?????????. (???????????? ????????? ????????? 10????????? ????????? ??? ????????? 10???, 20???, 30??? ??? ????????? ????????? ????????? 10?????? ???????????????)
		$(removeClass).remove();

		// html????????? append??????.
		target.append(html);
	}

function printPagination(pageMaker, target, templateObject, removeClass) {

	var pageNum = new Array(pageMaker.endPage - pageMaker.startPage + 1);

	for (var i = 0; i < pageMaker.endPage - pageMaker.startPage + 1; i++) {
		pageNum[i] = pageMaker.startPage + i;
	}
	pageMaker.pageNum = pageNum;
	pageMaker.prevPageNum = pageMaker.startPage - 1;
	pageMaker.nextPageNum = pageMaker.endPage + 1;

	var template = Handlebars.compile(templateObject.html());
	var html = template(pageMaker);
	target.html("").html(html);
}
</script>



<script>
function addEvnetWaitTab(){
	var dgnssWaitTab = $('#custom-hspt-bookmark-list-tab');
	dgnssWaitTab.on('click',function(){
		$('#keywordId').val("")
		$('#jobForm').find("[name='typeCode']").val("");
		
		$('#searchType').val('');
		
		targetId = "#hspt-bookmark-list-table-tbody";
		pagenationId = "#inptnt-list-pagination-ul";
		
		$('#bookmark-btn').attr('data-hspt-no', '');
		$('#bookmark-btn').attr('disabled', true);
		$('#go-inptnt-btn').attr('disabled', true);
		
		page = 1;
		list_go(url, page, targetId, pagenationId);
	})
}

function addEvnetReqTab(){
	var dgnssReqTab = $('#custom-hspt-all-list-tab');
	dgnssReqTab.on('click',function(){
		$('#keywordId').val("")
		$('#jobForm').find("[name='typeCode']").val("all");
		
		$('#searchType').val('');
		
		targetId = "#hspt-all-list-table-tbody";
		pagenationId = "#inptnt-all-pagination-template";
		
		$('#bookmark-btn').attr('data-hspt-no', '');
		$('#bookmark-btn').attr('disabled', true);
		$('#go-inptnt-btn').attr('disabled', true);
		
		page = 1;
		list_go(url, page, targetId, pagenationId);
	})
}
function showDetail(hsptNo, instAdres){
	
	$('#go-inptnt-btn').attr('disabled', true);	
	
	var trs = $('tr.each-hspt-element');
	
	trs.removeClass('on');
	
	var target = $('tr[data-hspt-no="'+hsptNo+'"]');
	
	target.addClass('on');	
	
	$('#bookmark-btn').attr('disabled', false);
	$('#bookmark-btn').attr('data-ltct-no', hsptNo);	
	if($(opener.document).find('form[name="processForm"]')){
	   	$(opener.document).find('form[name="processForm"] input[name="toHsptNo"]').val(hsptNo);
	}
	
	$('#go-inptnt-btn').attr('data-hspt-no', hsptNo);

	if(target.attr('data-rmnd-sckbd-cnt') > 0){
		$('#go-inptnt-btn').attr('disabled', false);
	}
	
	var rmndSckbdCnt = target.attr('data-rmnd-sckbd-cnt');
	var sckbdCnt = target.attr('data-sckbd-cnt');
	var parseRmndSckbdCnt = parseInt(rmndSckbdCnt);
	var parseSckbdCnt = parseInt(sckbdCnt);
	var inptnt = parseSckbdCnt - parseRmndSckbdCnt;
	
	$.ajax({
	    url : '<%=request.getContextPath()%>/rest-hspt/get-bookmark-check',
	    type : 'post',
	    dataType : 'json',
	    data : 
	    	{
	    		'toInstNo' :  hsptNo
	    	}
	    	,
	    success : function(dataMap){
	    	
			$('#inst_nm').html(target.attr('data-inst-nm'));
			$('#op_rate').html(target.attr('data-op-rate') + "% (" + inptnt + "/" + parseSckbdCnt + ")");
			$('#inst_telno').html(target.attr('data-inst-telno'));
			$('#emp_cnt').html(target.attr('data-emp-cnt'));
			$('#inst_adres').html(target.attr('data-inst-adres'));
		   	mapOpen(target.attr('data-inst-adres'), target.attr('data-inst-nm'), target.attr('data-rmnd-sckbd-cnt'), target.attr('data-op-rate'), dataMap.bookmarkFlag, hsptNo);
		   	
	    },
	    error : function(error){
	      alert('error' + error.status);
	    }
	  })	
	  
}
</script>

<script>
function rmndSckbdCntCheckBox(){
	
	var url = '<%=request.getContextPath()%>/rest-hspt/hspt-list-to-inptnt';
	
	var check = $("#rmndSckbdCntCheck").is(':checked');
	
		$('#jobForm').find('[name="rmndSckbdCntCheck"]').val(check);
		
		var formCheck = $('#jobForm').find("[name='typeCode']").val();
		
		if(formCheck == "all"){
			targetId = "#hspt-all-list-table-tbody";
			pagenationId = "#inptnt-all-pagination-template";
			page = 1;
			list_go(url, page, targetId, pagenationId);
		}else{
			targetId = "#hspt-bookmark-list-table-tbody";
			pagenationId = "#inptnt-list-pagination-ul";
			page = 1;
			list_go(url, page, targetId, pagenationId);
		}
	
}
</script>
<div class="ddoing" style="height: 455px">
<table class="table table-bordered" style="table-layout: fixed;">
	<thead>
		<tr style="text-align: center;">
			<th class="col-md-2" style="width:20%;overflow: true;">?????????</th>
			<th class="col-md-6">??????</th>
			<th class="col-md-2" style="width:10%;">?????????</th>
			<th class="col-md-2" style="width: 10%;">?????????</th>
		</tr>
	</thead>
	<tbody id="hspt-bookmark-list-table-tbody">
		<tr class="each-hspt-element">
			<td id="initialTd" colspan="4" style="text-align: center;">????????? ????????? ?????????.</td>
		</tr>
	</tbody>
</table>
</div>
<div class="card-footer clearfix pb-0 pt-0" style="background-color: white;">
	<ul class="pagination justify-content-center m-0" id="inptnt-list-pagination-ul">
	</ul>
</div>
