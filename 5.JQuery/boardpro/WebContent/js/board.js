/**
 * 
 */

updateBoardServer = function(){
	$.ajax({
		url : '/boardpro/UpdateBoard.do',
		type : 'post',
		data : udatas,
		dataType : 'json',
		success : function(res){
			if(res.flag =="성공"){
				//alert("수정 성공!!");
				//화면을 수정 -//btnupdate : 수정버튼이다.
				parent = $(btnupdate).parents('.panel');
				$(parent).find('a').text(udatas.subject);
				$(parent).find('.mail').text(udatas.mail);
				content = udatas.content.replace(/\r/g,"").replace(/\n/g, "<br>");
				$(parent).find('.bcont').html(content);
				//listPageServer(currentPage);
			}else{
				alert("수정 실패!!");
				//listPageServer(currentPage);
			}
			
		},
		error : function(xhr){
			alert(xhr.status);
		}
		
	})
}

deleteBoardServer = function(){
	$.ajax({
		url : '/boardpro/DeleteBoard.do',
		type : 'get',
		data : {"num" : vidx},
		dataType : 'json',
		success : function(res){
			if(res.flag =="성공"){
				if(res.tpage <currentPage){
					currentPage=res.tpage;
				}
			}
			//다시 리스트 출력
			listPageServer(currentPage);				
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}

increaseHit = function(){
	$.ajax({
		url : '/boardpro/ReplyHit.do',
		type : 'post',
		data : board,
		dataType : 'json',
		success : function(res){
			
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}

replyUpdateServer = function(){
	$.ajax({
		url : '/boardpro/ReplyUpdate.do',
		type : 'post',
		data : reply,
		dataType : 'json',
		success : function(res){
			alert(res.flag);
		},
		error : function(xhr){
			alert(xhr.status);
		} 
	})
}
replyDeleteServer = function(but){
	
	$.ajax({
		url : '/boardpro/ReplyDelete.do' ,
		data : {"renum" : vidx},
		type : 'get',
		dataType : 'json',
		success : function(res){
			
			$(but).parents('.rep').remove();
			
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
	
	
	
	
}

replyListServer = function(t){
	$.ajax({
		url :'/boardpro/ReplyList.do',
		data : {'bonum' : vidx},
		type : 'get',
		dataType : 'json',
		success : function(res){
			
			$(t).parents('.panel').find('.rep').remove();
			rcode = "";
			$.each(res, function(i, v){
				
				rcode+='<div class="panel-body rep">';
				rcode+='<p class="p1">';
				rcode+='작성자 : <span class="name">'+v.name+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				rcode+='작성날짜 : <span class="date">'+v.redate+'</span>&nbsp;&nbsp;&nbsp;&nbsp;';
				rcode+='</p>';
				rcode+='<p class="p2">';
				rcode+='<input type="button" idx="'+v.renum+'" value="댓글수정" name="rmodify" class="action">';
				rcode+='<input type="button" idx="'+v.renum+'" value="댓글삭제" name="rdelete" class="action">';
				rcode+='</p>';
				rcode+='<p class="p3">';
				rcode+=v.cont+'<br>';
				rcode+='</p>';
				
				rcode+='</div>';
			})
			//등록버튼에 조상!을 찾기(pbody) 위해 parents를 사용한다.
			$(t).parents('.panel').find('.pbody').append(rcode);
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}
replySaveServer = function(t){
	$.ajax({
		url  : '/boardpro/ReplySave.do',
		data : reply, //cont, bonum, name
		type : 'post',
		dataType : 'json',
		success : function(res){
			//리스트 출력
			replyListServer(t);
		},
		error : function(xhr){
			alert(xhr.status);
		}
	})
}

listPageServer = function(page){
	
	//페이지별 리스트 출력
	$.ajax({
		url : '/boardpro/List.do',
		type : 'post',
		data : {"page" : page},
		success : function(res){
			code='<div class="panel-group" id="accordion">';
			$.each(res.datas, function(i,v){
				
			code+='	<div class="panel panel-default">';
			code+='<div class="panel-heading">';
			code+='<h4 class="panel-title">';
			code+='<a name="list" class="action" idx="'+v.num+'" data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.num+'">'+v.subject+'</a>';
			code+='</h4>';
			code+='</div>';
			code+='<div id="collapse'+v.num+'" class="panel-collapse collapse">';
			
			code+='<div class="panel-body pbody">';
			code+='<p class="p1">';
			code+='	작성자 : <span class="name2">'+v.writer+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='이메일:<span class="mail">'+v.mail+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='작성날짜 : <span class="date">'+v.wdate+'</span>&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='조회수: <span class="hit">'+v.hit+'</span>';
			code+='</p>';
			code+='<p class="p2">';
			code+='<input type="button" idx="'+v.num+'" value="수정" name="modify" class="action">';
			code+='<input type="button" idx="'+v.num+'" value="삭제" name="delete" class="action">';
			code+='</p>';
			code+='<p class="p3 bcont">';
			code+=v.content+'<br>';
			code+='</p>';
			code+='<p class="p4">';
			code+='<textarea rows="3" cols="80"></textarea>';
			code+='<input type="button" idx="'+v.num+'" value="등록" name="reply" class="action">';
			code+='</p>';
			code+='</div>';
			code+='</div>';
			code+='</div>';
			}) 
			code+='</div>';
			
			$('.box').html(code);
			
			//이전
			pager="";
			if(res.spage>1){
				pager+='<ul class="pager">';
				pager+='<li class="previous"><a href="#">Previous</a></li>';
				pager+='</ul>';				
			}
			
			//페이지 번호
			pager+='<ul class="pagination">';
			  for(i=res.spage; i<=res.epage; i++){
				  if(res.curpage == i){
					 pager+='<li class="active"><a href="#">'+i+'</a></li>'; 
				  }else{
					  pager+='<li><a href="#">'+i+'</a></li>';
				  }
				  
			  }
			
			  pager+='</ul>';
			//다음
			
			if(parseInt(res.epage)<parseInt(res.tpage)){
				pager+='<ul class="pager">';
				pager+='<li class="next"><a href="#">Next</a></li>';
				pager+='</ul>';
				
			}
			
			$('.plist').html(pager);
			
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
}

listServer = function(){

//전체 리스트 출력
	$.ajax({
		url : '/boardpro/List.do',
		type : 'get',
		success : function(res){
			code='<div class="panel-group" id="accordion">';
			$.each(res, function(i,v){
				
			code+='	<div class="panel panel-default">';
			code+='<div class="panel-heading">';
			code+='<h4 class="panel-title">';
			code+='<a data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.num+'">'+v.subject+'</a>';
			code+='</h4>';
			code+='</div>';
			code+='<div id="collapse'+v.num+'" class="panel-collapse collapse">';
			code+='<div class="panel-body">';
			code+='<p class="p1">';
			code+='	작성자 : <span class="name">'+v.writer+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='이메일:<span class="mail">'+v.mail+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='작성날짜 : <span class="date">'+v.wdate+'</span>&nbsp;&nbsp;&nbsp;&nbsp;';
			code+='조회수: <span class="hit">'+v.hit+'</span>';
			code+='</p>';
			code+='<p class="p2">';
			code+='<input type="button" value="수정" name="modify" class="action">';
			code+='<input type="button" value="삭제" name="delete" class="action">';
			code+='</p>';
			code+='<p class="p3">';
			code+=v.content+'<br>';
			code+='</p>';
			code+='<p class="p4">';
			code+='<textarea rows="3" cols="80"></textarea>';
			code+='<input type="button" value="등록" name="reply" class="action">';
			code+='</p>';
			code+='</div>';
			code+='</div>';
			code+='</div>';
			}) 
			code+='</div>';
			
			$('.box').html(code);
			
		},
		error : function(xhr){
			alert("상태: "+xhr.status());
		},
		dataType : 'json'
	})
	
}