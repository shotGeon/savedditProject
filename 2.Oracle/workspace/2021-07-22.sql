2021-07-22-01)

사용예)2005년 5월 회원별 판매액을 계산하고 상위 5명의 자료를 출력하시오
Alias는 회원번호, 회원명,구매금액합계
    SELECT TBLA.CID AS 회원번호,
           TBLB.MEM_NAME AS 회원명,
           TBLA.AMT AS 구매금액합계
        FROM(SELECT A.CART_MEMBER AS CID,--FROM절에는 테이블만 올 수 있기에 VIEW(가상테이블)를 사용한다.(인라인 서브쿼리)
                   SUM(A.CART_QTY*B.PROD_PRICE) AS AMT
                FROM CART A, PROD B
                WHERE A.CART_PROD=B.PROD_ID
                  AND A.CART_NO LIKE '200505%'
                GROUP BY A.CART_MEMBER
                ORDER BY 2 DESC) TBLA,
            MEMBER TBLB
        WHERE TBLA.CID=TBLB.MEM_ID
          AND ROWNUM<=5;
          
          
사용예) 2005년 5월 매입액과 매출액을 조회하시오
       Alias는 상품코드, 상품명, 매입액합계, 매출액합계
              
     SELECT C.PROD_ID AS 상품코드, 
            SUM(A.BUY_QTY*A.BUY_COST) AS 매입액합계    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID;
       --------------
        SELECT C.PROD_ID AS 상품코드,
            SUM(B.CART_QTY*C.PROD_PRICE) AS 매출액합계       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID;
       
       SELECT PROD_ID AS 상품코드,
              PROD_NAME AS 상품명,
              NVL(TBLA.BAMT,0) AS 매입합계,
              NVL(TBLB.CAMT,0) AS 매출합계
       FROM(SELECT C.PROD_ID AS BID, 
            SUM(A.BUY_QTY*A.BUY_COST) AS BAMT    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID)TBLA,
       (SELECT C.PROD_ID AS 상품코드,
            SUM(B.CART_QTY*C.PROD_PRICE) AS 매출액합계       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID)TBLB,
     PROD
    WHERE TBLA.BID(+)=PROD_ID
      AND TBLB.CID(+)=PROD_ID
      GROUP BY 1;
      
      
       SELECT A.PROD_ID AS 상품코드,
              A.PROD_NAME AS 상품명,
              NVL(SUM(A.PROD_COST*B.BUY_QTY),0) AS 매입합계,
              NVL(SUM(A.PROD_PRICE*C.CART_QTY),0) AS 매출합계
         FROM PROD A
         LEFT OUTER JOIN BUYPROD B ON(B.BUY_PROD=A.PROD_ID
         AND B.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531'))
         LEFT OUTER JOIN CART C ON(C.CART_PROD=A.PROD_ID
         AND SUBSTR(C.CART_NO,1,6)='200505')
    GROUP BY A.PROD_ID, A.PROD_NAME
    ORDER BY 1;
    
    
    
    SELECT      
       FROM(SELECT C.PROD_ID AS BID, 
            SUM(A.BUY_QTY*A.BUY_COST) AS BAMT    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID)TBLA,
       (SELECT C.PROD_ID AS 상품코드,
            SUM(B.CART_QTY*C.PROD_PRICE) AS 매출액합계       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID)TBLB,
     PROD
    WHERE TBLA.BID(+)=PROD_ID
      AND TBLB.CID(+)=PROD_ID
      GROUP BY 1;
      

       
          
사용예)회원의 마일리지를 조회하여 상위 20%에 속한 회원들이 2005년4~6월
      구매한 정보를 조회하시오. Alias는 회원번호, 회원명,구매금액합계
      
      DECLARE--선언(변수,상수,커서만가능)
        V_ID MEMBER.MEM_ID%TYPE;--타입을 모를때 사용(같은 데이터 타입으로 만든다)
        V_NAME MEMBER.MEM_NAME%TYPE;
        V_AMT NUMBER:=0;
        
        CURSOR CUR_MEM01 IS
         SELECT A.MID
          FROM (SELECT MEM_ID AS MID
                  FROM MEMBER
                 ORDER BY MEM_MILEAGE DESC) A
            WHERE ROWNUM<=ROUND((SELECT COUNT(*)
                                FROM MEMBER)*0.2);
      BEGIN
        OPEN CUR_MEM01;
        LOOP
          FETCH CUR_MEM01 INTO V_ID;--커서에 있는거를 순서대로 읽으라는 뜻
          EXIT WHEN CUR_MEM01%NOTFOUND;
          
          SELECT  C.MEM_NAME, SUM(A.CART_QTY*B.PROD_PRICE)
            INTO V_NAME,V_AMT
            FROM CART A, PROD B, MEMBER C
            WHERE A.CART_MEMBER=C.MEM_ID
              AND A.CART_PROD=B.PROD_ID
              AND A.CART_MEMBER=V_ID
              AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
             GROUP BY C.MEM_NAME; 
            DBMS_OUTPUT.PUT_LINE('회원번호: '||V_ID);
            DBMS_OUTPUT.PUT_LINE('회원명: '||V_NAME);
            DBMS_OUTPUT.PUT_LINE('구매금액: '||V_AMT);
            DBMS_OUTPUT.PUT_LINE('--------------------------');      
            
      END LOOP;
         CLOSE CUR_MEM01;
        END;
        
 3.Non-Equi Join
  - 조인조건문이 '=' 이외의 연산자가 사용된 겨우
  - IN, ANY, SOME, ALL, EXISTS 등의 복수행 연산자 사용
  
사용예)사원테이블에서 사원들의 평균임금보다 더 많은 임금을 받는 사원의 사원번호,사원명,부서명,급여,평균급여를
      출력하시오
      SELECT A.EMPLOYEE_ID AS 사원번호,
             A.EMP_NAME AS 사원명,
             B.DEPARTMENT_NAME AS 부서명,
             A.SALARY AS 급여,
             C.ASAL AS 평균급여
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B,
           (SELECT ROUND(AVG(SALARY)) AS ASAL
                FROM HR.EMPLOYEES) C
      WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
        AND A.SALARY > C.ASAL
        ORDER BY 4;
        
      SELECT A.EMPLOYEE_ID AS 사원번호,
             A.EMP_NAME AS 사원명,
             B.DEPARTMENT_NAME AS 부서명,
             A.SALARY AS 급여,
             (SELECT ROUND(AVG(SALARY)) 
                FROM HR.EMPLOYEES) AS 평균급여
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
      WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        AND A.SALARY >(SELECT ROUND(AVG(SALARY)) 
                FROM HR.EMPLOYEES)
        ORDER BY 4;
      
사용예)2005년 6월 가장 많은 구매고객의 주소지 이외의 주소지에 거주하는 회원의 회원번호, 회원명, 주소를
     조회하시오. 
      
사용예)사원들 중 자기가 속한 부서의 평균 급여보다 적은 급여를 받는 직원정보를 
         조회하시오
     Alias는 사원번호,사원명,부서번호,부서명,급여,부서평균급여      
     
SELECT A.EMPLOYEE_ID AS 사원번호,
       A.EMP_NAME AS 사원명,
       A.DEPARTMENT_ID AS 부서번호,
       A.SALARY AS 급여,
       DAV.DAS AS 평균급여
  FROM(SELECT B.DEPARTMENT_ID AS DID,
          ROUND(AVG(A.SALARY)) AS DAS
          FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
          WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          GROUP BY B.DEPARTMENT_ID) DAV,   
     HR.EMPLOYEES A
    WHERE A.DEPARTMENT_ID=DAV.DID
      AND A.SALARY<DAV.DAS
      ORDER BY 5 DESC;
      
      
      
      
      
      
      
      
      