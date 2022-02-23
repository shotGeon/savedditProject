2021-08-09-02)PACKAGE
  -논리적 연관성이 있는 PL/SQL의 변수,상수커서,서브프로그램(함수,프로시져) 들의 항목을
   묶어 놓은 객체 
  -다른 객체에서 패키지 항목들을 공유,실행
  -모듈화 기능 제공
  -프로그램 설계의 용이성 제공
  -캡슐화 기능 제공
  -선언부와 본문부로 구성
  1)패키지 선언부
   . 패키지에서 사용할 변수,상수,함수 등의 선언 영역(명세)
   (사용형식)
   
   CREATE [OR REPLACE] PACKAGE 패키지명 IS
     변수, 상수, 커서 선언;
     FUNCTION 함수명[(매개변수 list)]
       RETURN 반환타입;
                 :
     PROCEDURE 프로시져명(매개변수list);
                 :
    END 패키지명;
    
    2)패키지 본문부
    . 선언부에서 선언된 PL/SQL객체들의 구현내용 기술
    (사용형식)
     CREATE [OR REPLACE] PACKAGE BODY 패키지명 IS
       변수명 타입;
       상수명 CONSTANT 타입;
       커서 정의;
       
       FUNCTION 함수명[(매개변수list)]
         RETURN 타입
       IS 
         선언부;
       BEGIN
         실행부;
         RETURN expr;
       END 함수명;
                    :
       PROCEDURE 프로시저명[(매개변수list)]
       IS 
         선언부;
       BEGIN
         실행부;
       END 프로시저명;
     END 패키지명;  
      
사용예)
     사원관리에 필요한 함수 등을 관리
     - 패키지명 :PKG_EMP
     - FN_GET_NAME: 사원번호를 입력받아 이름을 반환하는 함수
     - PROC_NEW_EMP: 신규사원정보 입력 프로시저(사원번호,LAST_NAME,이메일,입사일,JOB_ID)
     - 