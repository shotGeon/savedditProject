2021-0712-01)데이터 타입
- 오라클에서 사용되는 데이터타입은 문자열, 숫자, 날짜, 2진자료형이 제공
1.문자열 자료--대소문자가 구분된다
-오라클의 문자열은 ' '로 묶어 표현
-고정길이(CHAR)와 가변길이(VARCHAR,VARCHAR2,LONG,NVARCHAR2(NATIONAL-국제표준코드),CLOB(CHARACTER LARGE OBJECT(가변길이임))타입으로 구분
-영문과 숫자, 특수문자는 1BYTE로 한글 한글자는 3BYTE로 표현
 1)CHAR
 .정의된 크기의 기억공간에 자료를 저장하고 남는 공간은 공백으로 채움
 .데이터는 MSB에서 LSB쪽으로 저장
 (사용형식)
 컬럼명 CHAR(크기 [BYTE[CHAR])--한글을사용했을때20CHAR를 사용하면 60BYTE를 사용한다는 것이다.영문은 동일;
  -최대 2000BYTE 까지 저장가능
  -BYTE CHAR: 생략하면 BYTE로 취급되며 'CHAR'이 사용되면 '크기'는 글자수를
   나타냄. 다만, CHAR를 사용해도 2000BYTE를 초과할 수 없음
  -길이가 고정된 칼럼이나 기본키 컬럼의 데이터 타입으로 주로 사용되어진다.
  
(사용예)
     CREATE TABLE T_CHAR (
     COL1 CHAR(20),
     COL2 CHAR(20 CHAR),
     COL3 CHAR(20 BYTE));
   
    INSERT INTO T_CHAR(COL1,COL2,COL3)
           VALUES('무궁화 꽃이 피','무궁화 꽃이 피었습니다','무궁화');
           INSERT INTO T_CHAR(COL1,COL2,COL3)
           VALUES('무궁화 꽃이 피','무궁화 꽃이 피','무궁화');
           
    
           SELECT * FROM T_CHAR;
           
           SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3) 
           FROM T_CHAR;
           
2)VARCHAR2
 .가변길이 자료저장에 사용
 (사용형식)
  컬럼명 VARCHAR2(크기[BYTE|CHAR])
   -최대 4000BYTE까지 저장 가능
   -사용자가 정의한 데이터 만큼 사용하고 남는 공간은 SYSTEM에 반환
   
(사용예)
   : CREATE TABLE T_VARCHAR2(
        COL1 VARCHAR2(500),
        COL2 VARCHAR2(50 CHAR),
        COL3 VARCHAR2(50 BYTE))
        
        INSERT INTO T_VARCHAR2 
             VALUES('IL POSTONO', '필립 느와래', '마시모 트로이시');
        INSERT INTO T_VARCHAR2
               VALUES('PERSIMON BANNA APPLE', 'PERSIMON BANNA', 'PERSIMO시');
        SELECT * FROM T_VARCHAR2;
        SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)
          FROM T_VARCHAR2;
             
3)VARCHAR, NVARCHAR, NVARCHAR2
 .기본적으로 NVARCHAR2와 저장 방법은 동일 함
 .NVARCHAR, NVARCHAR2는 UTF-8(가변길이),UTF-16(고정길이)방식의 코드로
  변환하여 자료 저장(국제표준코드 적용)
  
4)LONG
 .가변길이 자료를 저장
 (사용형식)
 컬럼명 LONG--길이는 적지않음
  - 최대 2GB까지 저장 가능
  - 한 테이블에 하나의 컬럼만 사용가능(제약사항)
  - CLOB로 대체됨
  - 문자열 함수(LENGTH,LENGTHB,SUBSTR)등이 제한됨
사용예)
    CREATE TABLE T_LONG(
       COL1 VARCHAR(100),
       COL2 LONG,
       COL3 CHAR(100));
       
   INSERT INTO T_LONG
          VALUES('PERSIMON BANNA APPLE', 'PERSIMON BANNA', 'PERSIMON시');
          
          SELECT *
           FROM T_LONG;
           
           SELECT COL1,COL2,TRIM(COL3) FROM T_LONG;
           
          SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)--LONG타입과CLOB타입은 LENGTHB,LENGTH가 허용되어지지 않는다.
          FROM T_LONG;
          
5)CLOB(CHAR LARGE OBJECT)--이진자료에서는BLOB
 .가변길이 자료를 저장
 (사용형식)
 컬럼명 CLOB
   -최대 4GB까지 저장 가능
   -여러 컬럼을 하나의 테이블에 선언 가능
   -일부 기능은 DBMS_LOB API의 지원을 받아야 사용 가능(LENGTH,SUBSTR 등)--LENGTHB는 지원안함
   
사용예)
    CREATE TABLE T_CLOB(
       COL1 CLOB,
       COL2 CLOB,
       COL3 VARCHAR2(400),
       COL4 LONG);
   
   INSERT INTO T_CLOB(COL1,COL2,COL4)
          VALUES('대전시 중구 대흥동 영민빌딩','대전시 중구 대흥동 영민빌딩',
                 '대전시 중구 대흥동 영민빌딩');
   
   SELECT *
      FROM T_CLOB;
      
      SELECT DBMS_LOB.GETLENGTH(COL1),
             SUBSTR(COL1,5,6),
             DBMS_LOB.SUBSTR(COL1,5,6)--LOB에서지원받으면 매개변수가뒤바뀐다.SUBSTR(5,6)=중구 대흥동 DBMS_LOB.SUBSTR(5,6)=구 대흥동
          FROM T_CLOB;
          
          
2.숫자 자료
 -NUMBER 타입이 제공
 
 (사용형식)
 컬럼명 NUMBER[(정밀도|*[, 스케일])]
 . 저장범위 : 1.0 x 10^-130 - 9.999...9 x 10^125
 . 정밀도 : 전체자리수(1 ~30)
 . 스케일(양수) : 소숫점 이하의 자리수 
 . 스케일(음수) : 정수부분의 자리수
   스케일 값은 84 ~ 127:
   ---1234.5678(-1-2-3-4.1234)
 . 20 BYTE로 표현
 
 ex) NUMBER, NUMBER(10), NUMBER(10,2), NUMBER(*,2)....
 ---------------------------------------------------------
  입력값          선언           기억되는 값
 --------------------------------------------------------- 
 123456.6789    NUMBER         123456.6789 --NUMBER가 허용되는 범위의 값이라면 그대로 저장해라
 123456.6789    NUMBER(10)     123457 -- 소수첫번째작리에서 반올림해서 정수로 바꿈
 123456.6789    NUMBER(7,2)    --정수부분에 제공된 자리수가 5자리라서 오류 (7-2),최소6자리가필요
 123456.6789    NUMBER(*,2)    123456.68
 123456.6789    NUMBER(10,-2)  123500
 ----------------------------------------------------------
 
 CREATE TABLE T_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(10),
    COL3 NUMBER(7,2),
    COL4 NUMBER(*,2),
    COL5 NUMBER(10,-2));
    
    SELECT * FROM T_NUMBER;
    
 INSERT INTO T_NUMBER(COL1)VALUES(123456.6789);  
 INSERT INTO T_NUMBER(COL2)VALUES(123456.6789); 
 INSERT INTO T_NUMBER(COL3)VALUES(12345.6789); 
 INSERT INTO T_NUMBER(COL4)VALUES(1234567.6789); 
 INSERT INTO T_NUMBER(COL5)VALUES(123456.6789); 
 
 **스케일>정밀도
   . 스케일: 소숫점이하의 데이터 수
   . 스케일-정밀도: 소숫점이하에 존재해야할 0의 갯수
   . 정밀도: 소숫점이하에 0이 아닌 자료수
------------------------------------------------------------
  입력값          선언             기억되는 값
------------------------------------------------------------
  1.234        NUMBER(4,5)       오류: 정수부분에 0이 아닌 값 존재
  0.23         NUMBER(3,5)       오류: 0.00으로 시작해야 함
  0.0023       NUMBER(3,5)       오류: 유효데이터의 개수가 부족하다 --(2,4)가되면 맞다
  0.012345     NUMBER(3,4)       0.0123 유효데이터가 남으면 반올림이 일어나서 상관없다.(4에서 반올림이 일어남)
  
   