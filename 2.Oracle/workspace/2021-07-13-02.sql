2021-07013-02)함수(FUNCTION)
-특정 결과를 반환하기 위하여 미리 작성하여 컴파일된 모듈
-반환값이 존재
-서버와 네트워크 성능 계산에 기여
-단일행 함수와 복수행 함수(집계함수:SUM,AVG,COUNT,MAX,MIN)로 구분
-문자열, 숫자, 날짜, 형변환, NULL처리, 집계함수 등이 있음
-중첩사용 할 수 있다.--함수안에 또다른 함수를 사용할 수 있다.
SELECT EMP_NAME, SALARY
  FROM HR.EMPLOYEES
  WHERE DEPARTMENT_ID IN(SELECT A.DID
                         FROM (SELECT DEPARTMENT_ID AS DID,
                                      COUNT(*)
                                      FROM HR.EMPLOYEES
                                GROUP BY DEPARTMENT_ID
                                HAVING COUNT(*)>=5) A);

1.)문자열 함수
 1) ||:문자열 결합 연산자
    -자바의 문자열에서 사용되는 '+'와 같음
    -두 문자열을 결합하여 새로운 문자열을 반환
    
    
사용예)회원테이블에서 충남에 거주하는 회원정보를 조회하시오
     Alias는 회원번호, 회원명, 주민번호, 주소이며 주민번호는'xxxxxx-xxxxxxx'형식으로 출력
     SELECT  MEM_ID AS 회원번호,
             MEM_NAME AS 회원명,
             MEM_REGNO1||'-'||MEM_REGNO2 AS 주민번호,
             MEM_ADD1||''||MEM_ADD2 AS 주소
           FROM MEMBER
           WHERE MEM_ADD1 LIKE '충남%'
             ORDER BY 1;                   

2)CONCAT(c1,c2)--c=character,n=number(매개변수)
-잘 사용하지 않는다
-주어진 문자열 자료 c1과 c2를 결합하여 반환
-사용예)회원테이블에서 충남에 거주하는 회원정보를 조회하시오
     Alias는 회원번호, 회원명, 주민번호, 주소이며 주민번호는'xxxxxx-xxxxxxx'형식으로 출력
      SELECT  MEM_ID AS 회원번호,
             MEM_NAME AS 회원명,
             CONCAT(CONCAT(MEM_REGNO1,'-'),MEM_REGNO2) AS 주민번호,
             CONCAT(MEM_ADD1,CONCAT(' ',MEM_ADD2)) AS 주소
           FROM MEMBER
           WHERE MEM_ADD1 LIKE '충남%'
             ORDER BY 1;              
3)ASCII(c1), CHR(n1)
 -ASCII(c1) :c1에 해당하는 ASCII 코드값 반환
 -CHR(n1) : 숫자 n1에 해당하는 문자를 반환
사용예)
    SELECT ASCII(PROD_ID), CHR(65) FROM PROD;
사용예)

DECLARE

BEGIN 
  FOR I IN 1..255 LOOP
    DBMS_OUTPUT.PUT_LINE(I||'='||CHR(I));
  END LOOP;
END;

4)RPAD(c1,n[, c2]), LPA(c1,n[,c2])
-RPAD:지정된 길이 n에 c1을 저장하고 남는 오른쪽 공간에 c2를 삽입한다.
-LPAD:지정된 길이 n에 c1을 저장하고 남는 왼쪽 공간에 c2를 삽입한다.
-c2가 생략되면 공백을 채움

사용예)SELECT LPAD('12345',7,'*')AS COL1,
             RPAD('9876',6) AS COL2
        FROM DUAL;
        
        SELECT TO_CHAR(PROD_COST) AS COL1,
            LPAD(PROD_NAME,30) AS COL3,
            LPAD(TO_CHAR(PROD_COST),10) AS COL2,
            LPAD(TO_CHAR(PROD_COST),10,'#') AS "COST"
          FROM PROD;
          
5)RTRIM(c1[, c2]), LTRIM(c1[, c2])
 -RTRIM: 주어진 문자열 c1 내부에 c2 문자열을 오른쪽에서 찾아 삭제
 -LTRIM: 주어진 문자열 c1 내부에 c2 문자열을 왼쪽에서 찾아 삭제
 - c2 가 생략되면 공백을 제거(단어 내부 공백 제거는 불가능)
 
6)TRIM(c1)
-단어 왼쪽 또는 오른쪽에 발생된 공백을 모두 제거
-(단어 내부 공백 제거는 불가능)


SELECT MEM_NAME,MEM_HP,MEM_JOB,MEM_MILEAGE
  FROM MEMBER
  WHERE MEM_NAME = TRIM('이혜나      ');--단어 내부에 발생된 공백은 제거가 불가는 하다 EX('이 혜 나')
  
7)SUBSTR(c,n1[,n2])
 -주어진 문자열 c에서 n1번째 부터 n2 갯수 만큼 글자를 추출하여 부분 문자열을 반환
 -결과도 문자열임
 -n1, n2는 1부터 시작됨
 -n2가 생략되거나 문자의 수보다 큰 n2를 사용하면 n1이후 모든 문자열을 추출함
 -n1이 음수이면 오른쪽을 기준으로 처리됨
 
사용예)SELECT SUBSTR('대전시 중구 대흥동', 2,5),
             SUBSTR('대전시 중구 대흥동', 2),
             SUBSTR('대전시 중구 대흥동', 2,20),
             SUBSTR('대전시 중구 대흥동', -7,5)
        FROM DUAL;
        
사용예)오늘이 2005년 4월 1일인 경우 CART_NO를 자동 생성하시오
      SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')||TRIM(TO_CHAR(TO_NUMBER(SUBSTR(MAX(CART_NO),9))+1,'00000'))
              
      FROM CART
      WHERE CART_NO LIKE '20050401%';
      
      SELECT MAX(CART_NO)+1--숫자로 바뀔수 있는 문자열은 숫자로 바뀔수 있다.
      FROM CART
      WHERE CART_NO LIKE'20050401%'
      
 8) REPLACE(c1,c2[,c3])
   -주어진 문자열 c1에 포함된 c2를 찾아 c3로 치환 시킴
   -c3가 생략되면 찾은 c2를 삭제시킴
   -단어 내부의 공백 제거에 사용될 수 있음
   
사용예)SELECT REPLACE('대전광역시 중구 대흥동','전광역시','전시'), 
             REPLACE('대전광역시 중구 대흥동','광역'),
             REPLACE('대전광역시 중구 대흥동',' '),
             REPLACE('대전광역시 중구 대흥동','대')
      FROM DUAL;
      
 9) INSTR(c1, c2[,m[,n]])--특정문자의 위치값을 반환 받을때 사용
  -주어진 문자열 c1에서 c2문자열이 처음 나온 위치값을 반환
  -m은 검색 시작위치를 직접 지정할 때 사용
  -n은 c2문자열의 반복 횟수를 정하여 검색하는 경우 사용
  
  
사용예)SELECT INSTR('APPLE PERSTMON PEAR BEAR', 'E'),--E가 처음나오는 인덱스값을 반환(5)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5),--검색할 위치를 지정(7)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5,2),--2번 반복되어진 P의 인덱스(16)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5,3)--(0)
             FROM DUAL;
             
             
             
       
        
            
        
    