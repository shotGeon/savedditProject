


   ACCEPT P_NUM PROMPT '수 입력: '
   DECLARE
     V_NUM NUMBER:=TO_NUMBER('&P_NUM');
     V_RES VARCHAR2(1000);
   BEGIN 
      IF MOD(V_NUM,2)=1 THEN
       V_RES:=TO_CHAR(V_NUM)||'은 홀수입니다';
      ELSE 
       V_RES:=TO_CHAR(V_NUM)||'은 짝수입니다';
      END IF;
 
       DBMS_OUTPUT.PUT_LINE(V_RES);
     END;
     
      사용예)회원테이블에서 회원들의 마일리지를 조회하여
        그 값이 5000 이상이면 'VIP 회원'을
         "     3000 이상이면 '정회원',
        그 이하이면 '준회원'을 회원번호,회원명,마일리지와 함께 출력하시오
        
        
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
                           
     ACCEPT P_NUM PROMPT '(톤)사용량'
     
     DECLARE
     V_NUM NUMBER:= TO_NUMBER('&P_NUM');
     V_RES VARCHAR(100);
     
     BEGIN
        IF V_NUM<=10 THEN
        V_RES:='총 요금은'||TO_CHAR(275*V_NUM+120*V_NUM)||'입니다.';
     ELSIF V_NUM<=20 THEN
        V_RES:='총 요금은'||TO_CHAR(10*275+(V_NUM-10)*305+120*V_NUM)||'입니다.';
     ELSIF V_NUM<=30 THEN
        V_RES:='총 요금은'||TO_CHAR(10*275+10*305+(V_NUM-20)*350+120*V_NUM)||'입니다.';
     ELSIF V_NUM<=40 THEN
        V_RES:='총 요금은'||TO_CHAR(10*275+10*305+10*350+415*(V_NUM-30)+120*V_NUM)||'입니다.';
       ELSE
        V_RES:='총 요금은'||TO_CHAR(10*275+10*305+10*350+10*415+500*(V_NUM-40)+120*V_NUM)||'입니다.';
        END IF;
         DBMS_OUTPUT.PUT_LINE(V_RES);
     END;
     
     사용예)10-110 사이의 난수를 발생시켜 발생된 난수에 해당하는 부서에 속한 사원중 첫번째 사원의 급여를 조회하여 
      5000이하이면 '저임금 사원',
      10000 이하이면 '평균임금 사원',
      그 이상이면 '고임금 사원'을 사원번호, 사원명, 부서명과 함께 출력하시오
            
      DECLARE
      V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE;
      V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;
      V_DNAME HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE;
      V_SAL HR.EMPLOYEES.SALARY%TYPE;
      V_MESSAGE VARCHAR(20);
      V_DID HR.DEPARTMENTS.DEPARTMENT_ID%TYPE;
     
      BEGIN
         V_DID:= TRUNC(SYS.DBMS_RANDOM.VALUE(10,110),-1);
         SELECT A.EMPLOYEE_ID,A.EMP_NAME,B.DEPARTMENT_NAME,A.SALARY
           INTO V_EID,V_ENAME,V_DNAME,V_SAL
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
          WHERE V_DID=B.DEPARTMENT_ID
            AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
            AND ROWNUM=1;
            
            CASE WHEN V_SAL<=5000 THEN
                     V_MESSAGE:='저임금 사원';
                 WHEN V_SAL<=10000 THEN
                     V_MESSAGE:='평균임금 사원';
                ELSE 
                    V_MESSAGE:='고임금 사원';
            END CASE;
            
          DBMS_OUTPUT.PUT_LINE('부서명: '||V_DNAME);
          DBMS_OUTPUT.PUT_LINE('사원번호: '||V_EID);
          DBMS_OUTPUT.PUT_LINE('사원명: '||V_ENAME);  
          DBMS_OUTPUT.PUT_LINE('비고: '||V_MESSAGE);
      
        END;
        
    DECLARE    
    BEGIN
     FOR I IN 1..9 LOOP
     DBMS_OUTPUT.PUT_LINE(7||'*'||I||'='||7*I);
     END LOOP;
     END;
     
     DECLARE
     V_SUM NUMBER:=0; --총금액합계
     V_DSUM NUMBER:=100; --일별금액
     V_DAYS NUMBER:=0;
     
    BEGIN
        FOR I IN 1..1000LOOP
        V_SUM:=V_SUM+V_DSUM;
        V_DAYS:=I;
        IF V_SUM>2000000 THEN
        EXIT;
        END IF;
        V_DSUM:=V_DSUM*2;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('일수: '||V_DAYS);
        DBMS_OUTPUT.PUT_LINE('총금액: '||V_SUM);
        
      END;
      
 DECLARE
  BEGIN
    FOR FUCK IN(SELECT A.PROD_ID AS PID,
                     A.PROD_NAME AS PNAME,
                    SUM(B.BUY_QTY) AS SBQ
                  FROM PROD A, BUYPROD B
                 WHERE A.PROD_ID=B.BUY_PROD
                   AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
                 GROUP BY A.PROD_ID,A.PROD_NAME)
    LOOP
        DBMS_OUTPUT.PUT_LINE('상품코드: '||FUCK.PID);
        DBMS_OUTPUT.PUT_LINE('상품명: '||FUCK.PNAME);
        DBMS_OUTPUT.PUT_LINE('입고수량: '||FUCK.SBQ);
        DBMS_OUTPUT.PUT_LINE('----------------------');
    END LOOP;
    END;
  
  DECLARE
   BEGIN
     FOR I IN 1..9 LOOP
       FOR J IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(I||'*'||J||'='||I*J);
        END LOOP;
      END LOOP; 
   END;  
    
     
     SELECT A.PROD_ID AS PID,
            A.PROD_NAME AS PNAME,
            SUM(B.BUY_QTY) AS SBQ
        FROM PROD A, BUYPROD B
        WHERE A.PROD_ID=B.BUY_PROD
          AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
      GROUP BY A.PROD_ID,A.PROD_NAME
                           
                           