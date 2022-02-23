2021-0802-01)PL/SQL(Procedual Language SQL)
-표준 SQL의 기능을 확장한 SQL
-서버에 저장된 실행가능한 형태의 모듈화 된 서브프로그램
-block 구조로 구성
-모듈화, 캡슐화
-Anonymous Block, User Defined Function(Function), Stored Procedure(Procedure),--반환값이 있으면FUNCTION,없으면PROCEDURE
 Package, Trigger 등이 제공됨
 
1. 익명블록(Anonymous Block)
 -PL/SQL의 기본구조
 -단순 스크립트에서 실행되는 블록
 -이름이 없기때문에 저장되지 않고, 다시 불러서 쓸수 없다.
 (기술형식)
 DECLARE
   선언부(변수, 상수, 커서 선언); --변수:V_로시작,매개벼수:P_로시작
  BEGIN
   실행부(비지니스 로직 처리를 위한 sql문)
   [EXCEPTION 
      예외처리부;
      ]
   END;
   
   사용예)키보드로 10-110사이의 부서번호를 입력받아 해당부서직원중 가장 입사일이 빠른 사원 정보를
         출력하시오.(ACCEPT를 사용하면 키보드로부터 입력을 받는다.)
         Alias는 사원번호, 사원명, 입사일, 직책코드이다
         
         ACCEPT P_DID PROMPT '부서코드(10-110)'
         DECLARE
           V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE;
           V_NAME HR.EMPLOYEES.EMP_NAME%TYPE;
           V_HIRE HR.EMPLOYEES.HIRE_DATE%TYPE;
           V_JOBID HR.EMPLOYEES.JOB_ID%TYPE;
        BEGIN
          SELECT A.EMPLOYEE_ID,A.EMP_NAME,A.HIRE_DATE,A.JOB_ID
                INTO V_EID,V_NAME,V_HIRE,V_JOBID
                 FROM(SELECT EMPLOYEE_ID,EMP_NAME,HIRE_DATE,JOB_ID
                        FROM HR.EMPLOYEES
                       WHERE DEPARTMENT_ID=TO_NUMBER('&P_DID')
                       ORDER BY 3)A
                WHERE ROWNUM=1;
                
                  DBMS_OUTPUT.PUT_LINE('사원번호 : '||V_EID);
                  DBMS_OUTPUT.PUT_LINE('사원명 : '||V_NAME);
                  DBMS_OUTPUT.PUT_LINE('입사일 : '||V_HIRE);
                  DBMS_OUTPUT.PUT_LINE('직책코드 : '||V_JOBID);
                
                EXCEPTION WITH OTHERS THEN
                   DBMS_OUTPUT.PUT_LINE('예외발생: '||SQLERRM);--SQLERRM(SQL ERROR MESSAGE)
                END;
                
    
    1)변수와 상수
    - 실행부에서 사용할 변수와 상수
    - SCLAR 변수 : 하나의 데이터를 저장하는 변수
     . REFERENCE 변수 : 임의의 테이블에 존재하는 컬럼의 타입과 크기를 참조하는 변수
     . COMPOSITE 변수 : PL/SQL에서 사용하는 배열 변수-RECORD TYPE, TABLE TYPE
     . BIND 변수 : 파라메터로 넘겨지는 IN, OUT에서 사용되는 변수, 리턴값을 전달하기
        위해 사용되는 변수
    (사용형식)--ROWTYPE=테이블 한줄 전체를 참조할 때,데이터타입이 숫자일 경우 반드시 초기값으로 0을 준다
     변수명[CONSTANT] 데이터타입[(크기)]|테이블명.컬럼명%TYPE|테이블명%ROWTYPE[:=초기값];
       -'CONSTANT' : 상수 선언
       -'테이블명.컬럼명%TYPE|테이블명%ROWTYPE' : 참조타입
       - 숫자형 변수인 경우 반드시 초기화 해야함
       - 데이터타입: SQL에서 사용하는 데이터 타입,
         . BINARY_INTEGER, PLS_INTEGER : -2147483648 ~ 2147483647 사이의 정수 취급
         . BOOLEAN : true,false, null을 취급하는 논리형 변수
         
   
    1)분기명령
    - 프로그램의 실행 순서를 변경하는 명령
    -IF,CASE WHEN 등이 제공
    (사용형식 1)
    (1) IF 문
      . 개발언어의 IF문과 동일한 기능 제공
      
      (사용형식 1)
       IF 조건 THEN 
           명령 1;
        [ELSE
           명령 2;]
         END IF;
      
       (사용형식 2)
       IF 조건 THEN
          명령1;
       ELSIF 조건 THEN --마지막 ELSE에만 E가 들어감
          명령 2;]
            .
            .
        ELSE 명령N;
         END IF;
         
        (사용형식 3)
       IF 조건 THEN
        명령1;
         IF 조건 THEN
           명령2;
         ELSE 
           명령3;
         END IF;
       ELSE
         명령N;
       END IF;
       
사용예)임의의 수를 입력 받아 짝수인지 홀수인지 판별하시오
    ACCEPT P_NUM PROMPT '수 입력: '
    DECLARE
         V_NUM NUMBER :=TO_NUMBER('&P_NUM');
         V_RES VARCHAR2(100);
        BEGIN
         IF MOD(V_NUM,2)=0 THEN
           V_RES:=TO_CHAR(V_NUM)||'은 짝수 입니다.';
         ELSE
           V_RES:=TO_CHAR(V_NUM)||'은 홀수 입니다.';
         END IF;
         
         DBMS_OUTPUT.PUT_LINE(V_RES);
      END;
  
  사용예)회원테이블에서 회원들의 마일리지를 조회하여
        그 값이 5000 이상이면 'VIP 회원'을
         "     3000 이상이면 '정회원',
        그 이하이면 '준회원'을 회원번호,회원명,마일리지와 함께 출력하시오
        
        DECLARE
          V_MID MEMBER.MEM_ID%TYPE;
          V_NAME MEMBER.MEM_NAME%TYPE;
          V_MILE MEMBER.MEM_MILEAGE%TYPE;
          V_RES VARCHAR2(100);  
          
          CURSOR CUR_MEM01  IS
            SELECT MEM_ID,MEM_NAME,MEM_MILEAGE
              FROM MEMBER;   
        BEGIN
          OPEN CUR_MEM01;
          LOOP 
            FETCH CUR_MEM01 INTO V_MID,V_NAME,V_MILE;
            EXIT WHEN CUR_MEM01%NOTFOUND;
            IF V_MILE >=5000 THEN
               V_RES:=V_MID||', '||V_NAME||', '||V_MILE||', '||'VIP 회원';
            ELSIF V_MILE>=3000 THEN
               V_RES:=V_MID||', '||V_NAME||', '||V_MILE||', '||'정회원';
            ELSE
               V_RES:=V_MID||', '||V_NAME||', '||V_MILE||', '||'준회원'; 
            END IF;
            
            DBMS_OUTPUT.PUT_LINE(V_RES);
            DBMS_OUTPUT.PUT_LINE('----------------------------------------------');
        END LOOP;
            DBMS_OUTPUT.PUT_LINE('회원수 : '||CUR_MEM01%ROWCOUNT||'명');
           CLOSE CUR_MEMO1;
        END;
        
        
사용예)사용자로부터 수도 사용량(톤 단위)를 입력 받아 수도요금을 계산하여 출력하시오
      사용량(톤)  수도단가
       1-10       275
      11-20      305
      20-30      350
      30-40      415
      41톤 이상   500원
      
      하수도 사용요금: 사용량*120원
      
      EX)27톤을 사용한 경우
      처음 10톤 : 275*10 = 2,750
      11-20    : 305*10 = 3,050
      나머지 7톤 : 350*7 = 2,450
      ---------------------------
      하수도 사용요금: 120*27=3,240
      ---------------------------
                           11,490
                           
      
      ACCEPT P_NUM PROMPT '수도 사용량(톤): ' 
      DECLARE
        V_NUM NUMBER:=TO_NUMBER('&P_NUM'); 
        V_RES VARCHAR(100);
      BEGIN
        IF V_NUM<=10 THEN
           V_RES:='하수도 사용요금:'||TO_CHAR(V_NUM*275+120*V_NUM);
        ELSIF V_NUM<=20 THEN
           V_RES:='하수도 사용요금:'||TO_CHAR(275*10+(V_NUM-10)*305+120*V_NUM);
        ELSIF V_NUM<=30 THEN
           V_RES:='하수도 사용요금:'||TO_CHAR(275*10+305*10+(V_NUM-20)*350+120*V_NUM);
        ELSIF V_NUM<=40 THEN
            V_RES:='하수도 사용요금:'||TO_CHAR(275*10+305*10+350*10+(V_NUM-30)*415+120*V_NUM);
        ELSE
            V_RES:='하수도 사용요금:'||TO_CHAR(275*10+305*10+350*10+415*10+(V_NUM-40)*500+120*V_NUM);
        END IF;
           DBMS_OUTPUT.PUT_LINE('사용량: '||V_NUM||'톤');
           DBMS_OUTPUT.PUT_LINE(V_RES);
         END;
      
      
      
      
      
      
      
      
      
      
      
 사용예)사원테이블에서 사원들의 평균급여보다 더 많은 급여를 받는 사원의 
       사원번호,사원명,급여,부서명을 출력하시오.
         
      
      
                
                
                
                
                
                
                