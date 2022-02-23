/**
 * 
 */

function formcheck(){
//입력 받은 값들을 가져온다. -value
	
  	f = document.ff
	
	idvalue=f.id.value.trim();
	idlen=idvalue.length;
	if(idlen<1){
		alert("Id를 입력하세요");
		return false;
	}
	if(idlen<8||idlen>20){
		alert("Id는 8~20사이로 입력하세요");
		return false;
	}
	
	idreg =/^[a-z][a-zA-Z0-9-_]{7,19}$/;
	
	if(!(idreg.test(idvalue))){
		alert("id형식오류입니다");
		return false;
	}
	
 	
	namevalue=f.name.value.trim();
	namelen=namevalue.length;
	
	if(namelen<1){
		alert("이름을 입력하세요");
		return false;
	}
	if(namelen<2||namelen>5){
		alert("이름은 2~5자입니다.");
		return false;
	}
	manereg =/^[가-힣]{2,5}$/;
	if(!(manereg.test(namevalue))){
		alert("이름형식오류입니다.");
		return false;
	}
	
	
	
	
	telvalue=f.tel.value.trim();
	tellen=telvalue.length;
	
	if(tellen<1){
		alert("전화번호를 입력하세요");
		return false;
	}
	
	telreg =/\d{3}-\d{4}-\d{4}/;
	
	if(!(telreg.test(telvalue))){
		alert("전화번호 형식 오류입니다.");
		return false;
	}
	
	
	emailvalue=f.email.value.trim()
	
	if(emailvalue.length<1){
		alert("이메일 입력하세요");
		return false;
	}
	// .을 사용하고 싶을때는\.을 사용한다.
	//1번 올 수도 있고 2번 올 수도 있을때 {1,2}사용
	emailreg=/^([a-zA-Z0-9]+)@([a-zA-Z0-9]+)(\.[a-z]+){1,2}$/;
	
	
	if(!(emailreg.test(emailvalue))){
		alert("이메일 형식 오류입니다.");
		return false;
	}
 	
	passvalue=f.pass.value.trim()
	
	if(passvalue.length<1){
		alert("비밀번호를 입력하세요");
		return false;
	}
 	
 	if(passvalue.length <8||passvalue.length >20){
 		alert("비밀번호8~20사이 입니다");
 		return false;
 	}
 	
 	passreg =/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[$@#%^&_%-]).{8,20}$/;
 	if(!(passreg.test(passvalue))){
 		alert("비밀번호 형식오류 입니다");
 		return false;
 	}
 	
 	pass2=f.pass2.value.trim();
 	
 	if(passvalue !=pass2){
 		alert("일치하지 않습니다.")
 		return false;
 	}
 	
 	//alert("일치합니다.");
 	
 	return true;
 	
 	
	//전방탐색 \w+(?=찾는문자열) :찾는 문자열을 기준으로 앞의 어떤 문자나 숫자를 검색한다.
	/* //aa="http://www.daum.net";
	aa="https://www.daum.net";
	
	reg = /.+(?=:)/;
	
	bb= aa.match(reg);
	
	alert(bb); */
	
	
	
	/*
	gendervalue=f.gender.value.trim() */
}