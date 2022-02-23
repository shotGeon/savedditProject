/**
 * 
 */

function changeBorder(){
	   const arr=["solid","double","dotted","dashed","inset","outset"];
	   width = parseInt(Math.random()*10+1);
	   idx =parseInt(Math.random()*arr.length);
	   style =arr[idx];
	   
	   cr=parseInt(Math.random()*256);
	   cg=parseInt(Math.random()*256);
	   cb=parseInt(Math.random()*256);
	   
	   //10진수
	   color ="rgb("+cr+","+cg+","+cb+")"; 
	   
	   //16진수로 변경
	   cr=cr.toString(16);
	   cg=cg.toString(16);
	   cb=cb.toString(16);
	   
	   color ="#"+cr+cg+cb;
	   
	   vdiv.style.borderWidth=width+"px";//'${width}px'
	   vdiv.style.borderStyle=style;
	   vdiv.style.borderColor=color;
	   
	   //백틱사용
	   //vdiv.style.border='${width}px ${style} ${color}';
   }
   
   
   changeColor=function(){
	   //0~255를 발생시키고 정수로 변환
	   cr=parseInt(Math.random()*256);
	   cg=parseInt(Math.random()*256);
	   cb=parseInt(Math.random()*256);
	   
	   //div요소에 접근 var를 붙이면 지역변수 var가 없으면 전역변수
	   var vdiv=document.getElementsByTagName('div')[0];
	   
	   //vdiv.style.color="rgb("+cr+","+cg+","+cb+")";
	   
	   //벡틱(`)사용
	   vdiv.style.color=`rgb(${cr},${cg},${cb})`;
   }
   
   //람다 함수 -es6
   changeSize=()=>{
	   //15px~40px까지
	   size=parseInt(Math.random()*26+15);
	   vdiv.style.fontSize =size +"px";
   }