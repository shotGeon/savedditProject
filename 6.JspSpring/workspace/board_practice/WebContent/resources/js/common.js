


function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight){
	winleft = (screen.width - WinWidth) /2 ;
	wintop = (screen.height - WinHeight) /2;
	var win = window.open(UrlStr, WinTitle, "scrollbars=yes, width="+WinWidth +", "
			  			  +"height"+WinHeight +", top="+wintop+", left="
			  			   +winleft +", resizable=yes, status=yes");
	win.focus();
}

function CloseWindow(parentURL){
	
	window.opener.location.reload(true);
	window.close();
	
}

//사용자 사진 출력
function MemberPictureThumb(targetObj, fileName, contextPath){
	if(!contextPath) contextPath="";
	
	targetObj.style.backgroundImage="url('"+contextPath+"/member/getPicture?picture="+fileName+"')"
	targetObj.style.backgroundPosition="center";
	targetObj.style.backgroundRepeat="no-repeat";
	targetObj.style.backgroundSize="cover";
	
}