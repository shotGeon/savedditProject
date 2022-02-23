2021-0803-01)
  (2) CASE문
   . 표준 SQL의 SELECT 절에 사용되는 CASE표현식과 동일
   . 다중 분기 기능 제공
   (사용형식 1)
    CASE 변수|수식 WHEN 값1 THEN
                      명령1;
                  WHEN 값2 THEN
                      명령2;
                       .
                       .
                  ELSE 명령n;
    END CASE;
    
    
    (사용형식 2)
    CASE WHEN 조건1 THEN
              명령1;
         WHEN 조건2 THEN
              명령2;
               .
               .
          ELSE 명령n;
    END CASE;
        
사용예)10-110 사이의 난수를 발생시켜 발생된 난수에 해당하는 부서에 속한 사원중 첫번째 사원의 급여를 조회하여 
      5000이하이면 '저임금 사원',
      10000 이하이면 '평균임금 사원',
      그 이상이면 '고임금 사원'을 사원번호, 사원명, 부서명과 함께 출력하시오
      
      DECLARE
        V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE;  --사원번호
        V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;   --사원이름
        V_DNAME HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE;  --부서명
        V_SAL HR.EMPLOYEES.SALARY%TYPE; --급여
        V_MESSAGE VARCHAR2(20);  --비고란
        V_DID HR.EMPLOYEES.DEPARTMENT_ID%TYPE;  --부서번호(난수)
      BEGIN
        V_DID:=TRUNC(SYS.DBMS_RANDOM.VALUE(10,110),-1); --일의자리를 잘라서 0으로 만든다
        SELECT A.EMPLOYEE_ID,A.EMP_NAME,B.DEPARTMENT_NAME,A.SALARY
          INTO V_EID,V_ENAME,V_DNAME,V_SAL 
          FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
         WHERE A.DEPARTMENT_ID=V_DID
           AND B.DEPARTMENT_ID=A.DEPARTMENT_ID
           AND ROWNUM=1;
                
        CASE WHEN V_SAL<=5000 THEN
                  V_MESSAGE:='저임금사원';
             WHEN V_SAL<=10000 THEN
                  V_MESSAGE:='평균임금사원';
             ELSE
                 V_MESSAGE:='고임금사원';
        END CASE;
        
        DBMS_OUTPUT.PUT_LINE('부서명 : '||V_DNAME);
        DBMS_OUTPUT.PUT_LINE('사원번호 :'||V_EID);
        DBMS_OUTPUT.PUT_LINE('사원명 :'||V_ENAME);
        DBMS_OUTPUT.PUT_LINE('비고 :'||V_MESSAGE);  
        END;
    
    2) 반복문
     . 오라클의 반복문은 LOOP, WHILE, FOR문이 제공된다.
    (1)LOOP문 --조건이 참이될때 빠져나온다.
     - 반복문의 기본 구조
     (사용형식)
      LOOP
        반복처리명령문(들);
        [EXIT WHEN 조건;]
      END LOOP;
       . 기본적으로 무한루프
       . 'EXIT WHEN 조건': 조건이 참(true)이면 반복을 벗어남(END LOOP 다음으로 제어 이동)
       
사용예) 구구단의 7단을 출력하는 블록을 작성하시오
     DECLARE 
        V_CNT NUMBER:=1;
        V_RES NUMBER:=0;
       BEGIN
         LOOP
           V_RES:=V_CNT*7;
           EXIT WHEN V_CNT>9;
           DBMS_OUTPUT.PUT_LINE(7||'*'||V_CNT||'='||V_RES);
           V_CNT:=V_CNT+1;
         END LOOP;
       END;
       
       
     (2) WHILE 문
      - 개발언어의 WHILE문과 동일 기능 및 구조
      (사용형식)
      WHILE 조건 LOOP
        반복처리명령문(들);
      END LOOP;
       .'조건'이 참이면 반복 수행
       
사용예)구구단의 7단을 출력하시오
    DECLARE
      V_CNT NUMBER:=0;
      V_RES NUMBER:=0;
    BEGIN
       WHILE V_CNT<9 LOOP
       V_CNT:=V_CNT+1;
       V_RES:=7*V_CNT;
       DBMS_OUTPUT.PUT_LINE(7||'*'||V_CNT||'='||V_RES);
       END LOOP;
      END;
     












        
        
        
        
        
        
        
        
        

         