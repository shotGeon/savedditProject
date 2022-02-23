<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>


<head></head>

<title></title>

<body>

	<div class="content-wrapper" style="background-color:#fff;">
	 	<iframe name="ifr" src="" frameborder="0" style="width:100%;height:85vh;"></iframe>
 	</div>



<!-- REQUIRED SCRIPTS -->
<script>

function goPage(url,mCode){
	//alert(url);
	//alert(mCode);
	$('iframe[name="ifr"]').attr("src",url);
	//document.querySelector('iframe[name="ifr"]').src=url;
	
	
	  // HTML5 지원브라우저에서 사용 가능
	if (typeof(history.pushState) == 'function') {
	    //현재 주소를 가져온다.
	    var renewURL = location.href;
	    //현재 주소 중 .do 뒤 부분이 있다면 날려버린다.
	    renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
	    
	    if (mCode != 'M000000') {
	        renewURL += "?mCode="+mCode;
	    }
	    //페이지를 리로드하지 않고 페이지 주소만 변경할 때 사용
	    history.pushState(mCode, null, renewURL);
	 
	} else {
	    location.hash = "#"+mCode;
	}
}

function subMenu_go(mCode){
	//alert(mCode);
	if(mCode!="M000000"){	
		$.getJSON("<%=request.getContextPath()%>/subMenu.do?mCode="+mCode,function(data){
		//console.log(data);		
			printData(data,$('.subMenuList'),$('#subMenu-list-template'),'.subMenu');
		});
	}else{
		$('.subMenuList').html("");		
	}
}


//handelbars printElement (args : data Array, appent target, handlebar template, remove class)
function printData(dataArr,target,templateObject,removeClass){
	//핸들바 템플릿 가져오기
	var source = templateObject.html();
	//핸들바 템플릿 컴파일 아래 템플릿은 function이다.
	var template=Handlebars.compile(source);
	//핸들바 템플릿에 데이터를 바인딩해서 html생성
	var html = template(dataArr);
	
	$(removeClass).remove();
	//생성된 HTML을 DOM에 주입
	target.append(html);
}


window.onload=function(){
	goPage('<%=request.getContextPath()%>${menu.murl}','${menu.mcode}');
	subMenu_go('${menu.mcode}'.substring(0,3)+"0000");
}



</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" ></script>
<script type="text/x-handlebars-template"  id="subMenu-list-template" >
{{#each .}}
	<li class="nav-item subMenu" >
    	<a href="javascript:goPage('<%=request.getContextPath()%>{{murl}}','{{mcode}}');" 
			class="nav-link">
        	<i class="{{micon}}"></i>
            <p>{{mname}}</p>
       	</a>
	</li>
{{/each}}
</script>
</body>











