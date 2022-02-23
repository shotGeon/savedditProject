2021-0716-01)
4.변환함수
- 특정시점에서 다른 타입으로 일시적 형변환
- TO_CHAR, TO_DATE, TO_NUMBER, CAST
1)CAST(expr As 타입)
 .'expr'로 정의된 자료를 '타입'형태로 일시적 형 변환
 
사용예)
     SELECT MEM_NAME AS 회원명,
            CAST(SUBSTR(MEM_REGNO1,1,2)AS NUMBER)+1900 AS 출생년도,
            EXTRACT(YEAR FROM SYSDATE)-(CAST(SUBSTR(MEM_REGNO1,1,2)AS NUMBER)+1900) AS 나이
       FROM MEMBER
     WHERE NOT MEM_REGNO1 LIKE '0%';
     
2)TO_CHAR(expr[,fmt])
 . 주어진 자료 expr을 형식지정 문자열 fmt에 맞추어 문자열로 변형하여 반환
 . expr은 숫자, 날짜, 문자열(CHAR, CLOB=>VARCHAR2로) 타입의 자료--고정길이를 바꿀수는 있지만 가변길이 타입은 불가능
 . 영구적 형변환
 --함수는 반환값이 있기때문에 어느 절에서나 쓸 수 있지만 프로시저는 반환값이 없기때문에 독립적으로 사용해야 한다.
-----------------------------------------------------------------------------
  형식지정문자열            의미           사용예
-----------------------------------------------------------------------------
  CC                      세기          SELECT TO_CHAR(SYSDATE,'CC') FROM DUAL;
  AD,BC                   서기          SELECT TO_CHAR(SYSDATE,'CC BC YYYY"년"') FROM DUAL;
  YYYY,YYY,YY,Y           년도          SELECT TO_CHAR(SYSDATE,'CC BC YY"년"') FROM DUAL;
  Q                       분기          SELECT TO_CHAR(SYSDATE, 'CC BC YYYY"년" Q"분기"') FROM DUAL;
  MONTH, MON              월            SELECT TO_CHAR(SYSDATE,'YYYY MON MONTH') FROM DUAL;--"N월"로출력
  MM, RM                  월            SELECT TO_CHAR(SYSDATE,'YYYY MM RM') FROM DUAL; --07,VII
  W, WW, WWW              주차           
  DD, DDD, J              일           SELECT TO_CHAR(SYSDATE,'YYYY MM DD DDD J') FROM DUAL; --DDD1월부터오늘까지 경과된 일수
  DAY DY  D               요일          SELECT TO_CHAR(SYSDATE,'YYYY DAY DD DY D') FROM DUAL;
  AM, PM, A.M, P.M.       오전/오후
  MI                      분
  SS,SSSSS                초             SELECT TO_CHAR(SYSDATE,'YYYY MM DD AM MI SSSS"초"')FROM DUAL;
  "문자열"                 직접정의한 사용자 변환 문자열--컬럼의 별칭에도 사용 (AS "DFDFS")
  -------------------------------------------------------------------------------
  
  .숫자형식지정문자열
  -------------------------------------------------------------------------------
  형식지정문자열             의미                            사용예
  -------------------------------------------------------------------------------
  9                   숫자와 대응되어 유효숫자는 유효숫자를     SELECT TO_CHAR(12345,'99,9999')FROM DUAL;
                      출력하고 무효의 0은 공백처리             
  0                   숫자와 대응되어 유효숫자는 유효숫자를     SELECT TO_CHAR(345,'00,000')FROM DUAL;
                      출력하고 무효의 0은 0을 출력
  $,L                 화폐기호 출력                         SELECT TO_CHAR(12345, '$99,999') FROM DUAL;--자신의 나라의 화폐단위는 L
  PR                  음수를 '<>'로 묶어 출력                SELECT TO_CHAR(-12345, '99,999PR') FROM DUAL;
  ,(COMMA)            자리점
  .(DOT)              소숫점
  X                   16진수로 변환 출력                    SELECT TO_CHAR(255,'XXXX') FROM DUAL;
  ----------------------------------------------------------------------------------
  
  3)TO_NUMBER(expr[,fmt])
  . 주어진 자료 'expr'의 값을 'fmt' 형식에 맞추어 숫자로 변환
  . 'expr'의 타입은 문자열 타입의 자료 --날짜불가능 문자열만 가능
  .'fmt'는 모두 적용되지 않음(숫자로 형변환 가능한 형식만 적용 가능)
  .COMMA(,)사용불가능
  .<>는 변환 불가능('-12345','99999PR')X
사용예)SELECT TO_NUMBER('12345','9999900'),
             --TO_NUMBER('12345','99,999'),
             TO_NUMBER('12345','9999PR'),
             TO_NUMBER('12345')
        FROM DUAL;
             
4)TO_DATE(expr[,fmt])
 . 주어진 자료 'expr'의 값을 'fmt' 형식에 맞추어 숫자로 변환
 . 'expr'의 타입은 문자열 타입의 자료만 가능
 . 'fmt'는 모두 적용되지 않음(날짜로 형변환 가능한 형식만 적용 가능)
 . 원본자료가 날짜형식에 맞도록 제공되어야 함
 
 사용예) SELECT TO_DATE('20200320', 'YYYYMMDD'),
               TO_DATE('20200320', 'YYYY-MM DD')+10, --공백이랑 -기호는 /로저장되어진다.
               --TO_DATE('20200320', 'AM YYYYMMDD'),
               --TO_DATE('20200320', 'YYYY MONTH DD'),
               TO_DATE('20200320')
         FROM DUAL;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  