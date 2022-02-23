2021-0803-02) 커서(CURSOR)
  -오라클 SQL명령문에 의해 영향받은 행들의 집합
  -SELECT문에 의해 반환된 결과 집합의 행들을 차례대로 접근해야 하는 경우 사용
  -개발자가 결과를 수동적으로 제어할 필요가 있는 경우 사용
  -IMPLICITE, EXPLICITE, CURSOR
  -커서의 사용은 FOR문을 제외하고 생성(선언)->OPEN->FETCH->CLOSE 단계를 차례대로 실행
  (1)익명커서(IMPLICITE CURSOR)
   . 이름이 없는 커서
   . SELECT문이 실행되면 결과(커서)가 자동으로 OPEN된 후 결과 출력이 완료된 직후 자동으로 
     CLOSE 됨(참조 불가능)
   . 커서속성
     SQL%ISOPEN : 커서가 OPEN 상태이면 참(true) 반환- 항상 거짓(익명커서일때)(false),
     SQL%NOTFOUND : 커서에 자료가 남아있지 않으면 참(true) 반환
     SQL%FOUND : 커서에 자료가 남아있으면 참(true) 반환
     SQL%ROWCOUNT : 커서에 존재하는 자료의 갯수
   
   (2)커서(EXPLICITE CURSOR)
    . 이름이 부여된 커서
    . 선언부에서 선언
    
    (선언형식-선언부)
     CURSOR 커서명[(변수명 타입명,[변수명 타입명,...])]--크기는 안쓴다
     IS
       SELECT 문;
     
     (실행부)  
      OPEN 커서명[(매개변수[,매개변수,...])]; --반복문 밖에서 선언
      
      FETCH 커서명 INTO 변수list; --반복문 안에서
      
      CLOSE 커서명; --반복문 밖에서
       
사용예1)2005년 5월 입고상품별 출고현황을 조회하는 블록을 커서를 이용하여 작성하시오.
      Alias는 상품코드,상품명,수량
     
     DECLARE
       V_PID PROD.PROD_ID%TYPE;
       V_PNAME PROD.PROD_NAME%TYPE;
       V_AMT NUMBER:=0;
       V_CNT NUMBER:=0;
       CURSOR CUR_BUY01(PDATE DATE) IS 
        SELECT DISTINCT BUY_PROD
           FROM BUYPROD
           WHERE BUY_DATE BETWEEN PDATE AND LAST_DAY(PDATE);
     BEGIN
      OPEN CUR_BUY01(TO_DATE('20050501'));
      LOOP 
        FETCH CUR_BUY01 INTO V_PID;
        EXIT WHEN CUR_BUY01%NOTFOUND;
        SELECT COUNT(*) INTO V_CNT
          FROM CART
          WHERE CART_PROD=V_PID
            AND CART_NO LIKE '200505%';
            
         IF V_CNT !=0 THEN         
            SELECT PROD_NAME,SUM(CART_QTY) INTO V_PNAME,V_AMT
              FROM CART,PROD
             WHERE CART_PROD=V_PID
               AND CART_PROD=PROD_ID
               AND CART_NO LIKE '200505%'
             GROUP BY PROD_NAME;
            
            DBMS_OUTPUT.PUT_LINE('상품코드 : '||V_PID);
            DBMS_OUTPUT.PUT_LINE('상품명 : '||V_PNAME);
            DBMS_OUTPUT.PUT_LINE('판매수량 : '||V_AMT);
            DBMS_OUTPUT.PUT_LINE('----------------------');
         END IF;  
        END LOOP;       
      CLOSE CUR_BUY01;    
     END;
     
사용예2)2005년도 상품별 입고수량합계를 출력하는 블록을 커서를 이용하여 작성하시오
     Alias는 상품코드, 상품명, 입고수량
     
 
숙제)위1번과 2번을 WHILE문을 사용하여 작성하시오  




1번))2005년 5월 입고상품별 출고현황을 조회하는 블록을 커서를 이용하여 작성하시오.
      Alias는 상품코드,상품명,수량
      
    DECLARE
       V_PID PROD.PROD_ID%TYPE;
       V_PNAME PROD.PROD_NAME%TYPE;
       V_AMT NUMBER:=0;
       V_CNT NUMBER:=0;
       CURSOR CUR_BUY01(PDATE DATE) IS 
        SELECT DISTINCT BUY_PROD
           FROM BUYPROD
           WHERE BUY_DATE BETWEEN PDATE AND LAST_DAY(PDATE);
   BEGIN
     OPEN CUR_BUY01(TO_DATE('20050501'));
     FETCH CUR_BUY01 INTO V_PID;
       WHILE CUR_BUY01%FOUND LOOP 
         SELECT COUNT(*) INTO V_CNT
           FROM CART
           WHERE CART_PROD=V_PID
             AND CART_NO LIKE '200505%';
             
             IF V_CNT!=0 THEN       
             SELECT PROD_NAME,SUM(CART_QTY) INTO V_PNAME,V_AMT
               FROM CART,PROD
              WHERE CART_PROD=V_PID
                AND CART_PROD=PROD_ID
                AND CART_NO LIKE '200505%'
              GROUP BY PROD_NAME;
            
             DBMS_OUTPUT.PUT_LINE('상품코드 : '||V_PID);
             DBMS_OUTPUT.PUT_LINE('상품명 : '||V_PNAME);
             DBMS_OUTPUT.PUT_LINE('판매수량 : '||V_AMT);
             DBMS_OUTPUT.PUT_LINE('----------------------');
          END IF; 
          FETCH CUR_BUY01 INTO V_PID;  
        END LOOP;       
      CLOSE CUR_BUY01;    
     END;   
 
사용예2)2005년도 상품별 입고수량합계를 출력하는 블록을 커서를 이용하여 작성하시오
     Alias는 상품코드, 상품명, 입고수량
      DECLARE
        V_PID PROD.PROD_ID%TYPE;
        V_PNAME PROD.PROD_NAME%TYPE;
        V_AMT NUMBER:=0;
     CURSOR CUR_BUY01 IS 
        SELECT A.PROD_ID,A.PROD_NAME,SUM(B.BUY_QTY) 
          FROM PROD A,BUYPROD B
         WHERE A.PROD_ID=B.BUY_PROD
           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
         GROUP BY A.PROD_ID,A.PROD_NAME;
    BEGIN 
     OPEN CUR_BUY01;
       FETCH CUR_BUY01 INTO V_PID,V_PNAME,V_AMT;
      WHILE CUR_BUY01%FOUND LOOP
       FETCH CUR_BUY01 INTO V_PID,V_PNAME,V_AMT;
     
        DBMS_OUTPUT.PUT_LINE('상품코드 : '||V_PID);
        DBMS_OUTPUT.PUT_LINE('상품명 : '||V_PNAME);
        DBMS_OUTPUT.PUT_LINE('입고수량 : '||V_AMT);
     
      END LOOP;
    CLOSE CUR_BUY01;
    END;
     
     
     
     
     
     
     
  