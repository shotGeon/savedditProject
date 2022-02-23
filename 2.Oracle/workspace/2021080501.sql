2021-0805-01)User Defined Function(함수)
    - 프로시져와 장점 등이 유사
    - 반환 값이 있음
    - 자주 사용되는 서브쿼리 또는 복잡한 산술식 등을 함수로 구현
    - SELECT 문의 SELECT절, WHERE 절에 사용 가능
    
    (사용형식)
    CREATE [OR REPLACE] FUNCTION 함수명[(
    매개변수 [MODE] 타입 [:=값][,
                .
                .
    매개변수 [MODE] 타입 [:=값]])]
    RETURN 데이터 타입
  IS|AS
    선언영역
  BEGIN ---RETURN 명령에 의해서 실제로 반환되는 곳이다.
    실행영역
    RETURN 값|expr;
  END;
   'RETURN 데이터 타임' : 반환할 데이터 타입
   'RETURN 값|expr' : 반환해야하는 값이나 값을 산출하는 수식 등으로 반드시 1개 이상 존재 해야함
   
사용예)'대전'에 회원번호를 입력받아 해당회원의 2005년 6월 구매금액을 출력하는 
     함수를 작성하시오.
     
    (함수)
      CREATE OR REPLACE FUNCTION FN_SUM01(
        P_MID MEMBER.MEM_ID%TYPE)--DEFAULT가 IN 이기때문에 생략하면 IN이다. OUT은 반드시 기술
        RETURN NUMBER
      IS 
        V_SUM NUMBER:=0; --구매금액 합계
        V_CNT NUMBER:=0; --해당회원의 자료(CART) 존재유무
                
      BEGIN
        SELECT COUNT(*) INTO V_CNT
          FROM CART
         WHERE CART_NO LIKE '200506%'
           AND CART_MEMBER=P_MID;
           
        IF V_CNT!=0 THEN
           SELECT SUM(A.CART_QTY*B.PROD_PRICE) INTO V_SUM
             FROM CART A, PROD B
            WHERE A.CART_NO LIKE '200506%' 
              AND A.CART_MEMBER=P_MID
              AND A.CART_PROD=B.PROD_ID;
        ELSE
          V_SUM:=0;
        END IF;
        RETURN V_SUM;
      END;
   
   
   (실행)
       SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_ADD1||''||MEM_ADD2 AS 주소,
              FN_SUM01(MEM_ID) AS 구매금액 
         FROM MEMBER
        WHERE MEM_ADD1 LIKE '대전%'
        ORDER BY 1;
 
 사용예)상품코드와 년도 및 월을 입력받아 해당 상품의 구매수량과 구매금액을 출력하는 함수를 
       작성하시오
       
      (함수) : FN_BUY01
      
        CREATE OR REPLACE FUNCTION FN_BUY01(
          P_PID PROD.PROD_ID%TYPE,
          P_YEAR CHAR,
          P_MONTH CHAR)
          RETURN VARCHAR2
        IS
          V_DATE DATE:=TO_DATE(P_YEAR||P_MONTH||'01');
          V_AMT NUMBER:=0; --매입수량
          V_SUM NUMBER:=0; --구매금액합계
          V_CNT NUMBER:=0; --자료수(자료유무 판단)
          V_RES VARCHAR2(100);
        BEGIN
          SELECT COUNT(*) INTO V_CNT
            FROM BUYPROD
           WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
             AND BUY_PROD=P_PID;
             
           IF V_CNT != 0 THEN
             SELECT SUM(BUY_QTY),SUM(BUY_QTY*BUY_COST) 
               INTO V_AMT,V_SUM
               FROM BUYPROD
               WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
                 AND BUY_PROD=P_PID;
           ELSE
              V_SUM:=0;
              V_AMT:=0;
           END IF;
           V_RES:='구매수량: '||V_AMT||','||'구매금액'||V_SUM;
           RETURN V_RES;
        END;
        
        (실행)
          SELECT '2005-05',PROD_ID,PROD_NAME,FN_BUY01(PROD_ID,'2005','05')
            FROM PROD;
          
   
        (다른버전) --수량은 OUT매개변수를 통해 반환,금액은 리턴시겨서 
        CREATE OR REPLACE FUNCTION FN_BUY02(
          P_PID PROD.PROD_ID%TYPE,
          P_YEAR CHAR,
          P_MONTH CHAR,
          P_AMT OUT NUMBER)
          RETURN NUMBER
        IS
          V_DATE DATE:=TO_DATE(P_YEAR||P_MONTH||'01');
          V_AMT NUMBER:=0; --매입수량
          V_SUM NUMBER:=0; --구매금액합계
          V_CNT NUMBER:=0; --자료수(자료유무 판단)
        BEGIN
          SELECT COUNT(*) INTO V_CNT
            FROM BUYPROD
           WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
             AND BUY_PROD=P_PID;
            
            IF V_CNT != 0 THEN
             SELECT SUM(BUY_QTY),SUM(BUY_QTY*BUY_COST) 
               INTO V_AMT,V_SUM
               FROM BUYPROD
               WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
                 AND BUY_PROD=P_PID;
            ELSE
              V_SUM:=0;
              V_AMT:=0;
            END IF;
            P_AMT:=V_AMT;
            RETURN V_SUM;
          END;
        
        (실행)
            DECLARE
              V_AMT NUMBER:=0;
              V_SUM NUMBER:=0;
              CURSOR CUR_PROD IS
                SELECT PROD_ID,PROD_NAME
                  FROM PROD;
            BEGIN
              FOR REC IN CUR_PROD LOOP
                 V_SUM:=FN_BUY02(REC.PROD_ID,'2005','05',V_AMT);--함수는 어디서나 쓸수 있다. 하지만 SELECT 절을 제외하고 
                                                                --사용할때는 반드시 왼편에 값을 저장할 변수가 있어야 한다.
                 DBMS_OUTPUT.PUT_LINE('상품코드 : '||REC.PROD_ID);
                 DBMS_OUTPUT.PUT_LINE('상품코드 : '||REC.PROD_NAME);
                 DBMS_OUTPUT.PUT_LINE('매입수량 : '||V_AMT);
                 DBMS_OUTPUT.PUT_LINE('매입금액 : '||V_SUM);
                 DBMS_OUTPUT.PUT_LINE('----------------------------');
              END LOOP;
            END;
   
   
사용예)년도와 월을 6자리 문자열 입력 받아 해당월에 가장 많은 상품을 구매(금액기준)한 회원의 이름과
      구매금액을 출력하는 함수를 작성하시오
      함수명:FN_MAXMEM
      
      CREATE OR REPLACE FUNCTION FN_MAXMEM(
      P_DAY CHAR)
      RETURN VARCHAR2
      IS
--       V_DATE CHAR(7):=P_DAY||'%';
       V_MNAME MEMBER.MEM_NAME%TYPE;
       V_SUM NUMBER:=0;
       V_RES VARCHAR(100);
     BEGIN
     SELECT A.MNM,A.SCP INTO V_MNAME,V_SUM
       FROM(SELECT SUM(A.CART_QTY*B.PROD_PRICE) AS SCP,
                   C.MEM_NAME AS MNM
              FROM CART A,PROD B,MEMBER C
             WHERE A.CART_NO LIKE P_DAY||'%'
               AND A.CART_PROD=B.PROD_ID
               AND A.CART_MEMBER=C.MEM_ID
           GROUP BY C.MEM_NAME
           ORDER BY 1 DESC)A
        WHERE ROWNUM=1;
        
        V_RES:='구매회원명: '||V_MNAME||','||'구매금액: '||TO_CHAR(V_SUM);
        RETURN V_RES;
        END;
        
        SELECT FN_MAXMEM('200506')FROM DUAL;
        
        (키보드로 입력 받을때)
        
        ACCEPT P_DAY PROMPT '년월(YYYYMM) :'
        DECLARE
         V_RES VARCHAR2(100); 
         BEGIN
         V_RES:=FN_MAXMEM('&P_DAY');  
         DBMS_OUTPUT.PUT_LINE(V_RES);
         END;
        
        
        (실행)
          SELECT B.MEM_NAME,SUM(A.CART_QTY*C.PROD_PRICE),FN_MAXMEM('200504')
            FROM CART A,MEMBER B,PROD C
            GROUP BY B.MEM_NAME;
       
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   
   
   
   
   
   
   
   
   
   