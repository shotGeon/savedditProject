2021-0726-01)
사용예)2005년 1~3월 모든 분류별 매입현황을 조회하시오
    Alias는 분류코드,분류명,매입수량,매입금액

    (일반외부조인)
    SELECT D.LPROD_GU AS 분류코드,
           D.LPROD_NM AS 분류명,
           NVL(TBLA.BCNT,0) AS 매입수량,
           NVL(TBLA.BANT,0) AS 매입금액 
    FROM(SELECT B.LPROD_GU AS BID,
           SUM(A.BUY_QTY) AS BCNT,
           SUM(A.BUY_QTY*C.PROD_COST) AS BANT
       FROM BUYPROD A,LPROD B,PROD C
       WHERE A.BUY_PROD=C.PROD_ID
         AND C.PROD_LGU=B.LPROD_GU
         AND BUY_DATE BETWEEN TO_DATE('20050401')AND TO_DATE('20050630')
         GROUP BY  B.LPROD_GU) TBLA,
        LPROD D
        WHERE TBLA.BID(+)=D.LPROD_GU
        ORDER BY 1;
         
    (ANSI외부조인)
    SELECT B.LPROD_GU AS 분류코드,
           B.LPROD_NM AS 분류명,
           NVL(SUM(A.BUY_QTY),0) AS 매입수량,
           NVL(SUM(A.BUY_QTY*C.PROD_COST),0) AS 매입금액
       FROM BUYPROD A
       RIGHT OUTER JOIN PROD C ON(A.BUY_PROD=C.PROD_ID AND 
            BUY_DATE BETWEEN TO_DATE('20050401')AND TO_DATE('20050630'))
       RIGHT OUTER JOIN LPROD B ON(B.LPROD_GU=C.PROD_LGU)
       GROUP BY B.LPROD_GU,B.LPROD_NM
       ORDER BY 1;
       
       2005년 4~6월 모든 분류별 매출현황을 조회하시오
    Alias는 분류코드,분류명,매출수량,매출금액
     SELECT B.LPROD_GU AS 분류코드,
            B.LPROD_NM AS 분류명,
            NVL(SUM(A.CART_QTY),0) AS 매출수량,
            NVL(SUM(A.CART_QTY*C.PROD_PRICE),0) AS 매출금액
      FROM CART A
      RIGHT OUTER JOIN PROD C ON(A.CART_PROD=C.PROD_ID AND
            SUBSTR(CART_NO,1,6)BETWEEN '200504'AND'200506')
      RIGHT OUTER JOIN LPROD B ON(B.LPROD_GU=C.PROD_LGU)
      GROUP BY B.LPROD_GU,B.LPROD_NM
      ORDER BY 1;
      
       2005년 4~6월 모든 분류별 매입현황과 매출현황을 조회하시오
        Alias는 분류코드,분류명,매입수량,매입금액,매출수량,매출금액
        SELECT A.LPROD_GU AS 분류코드,
               A.LPROD_NM AS 분류명,
               NVL(SUM(B.BUY_QTY),0) AS 매입수량,
               NVL(SUM(B.BUY_QTY*D.PROD_COST),0) AS 매입금액,
               NVL(SUM(C.CART_QTY),0) AS 매출수량,
               NVL(SUM(C.CART_QTY*D.PROD_PRICE),0) AS 매출금액
          FROM LPROD A
          LEFT OUTER JOIN PROD D ON(A.LPROD_GU=D.PROD_LGU)
          LEFT OUTER JOIN BUYPROD B ON(D.PROD_ID=B.BUY_PROD AND
            B.BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050630'))
          LEFT OUTER JOIN CART C ON(C.CART_PROD=D.PROD_ID AND
            SUBSTR(CART_NO,1,6) BETWEEN '200504' AND '200506')
            GROUP BY  A.LPROD_GU, A.LPROD_NM
            ORDER BY 1;

      -- (위에꺼 서브쿼리로)
      
      
사용예)2005년 4월~6월까지 모든 상품별 매입현황/매출현황
     Alias 상품코드,상품명,매입수량,매입금액,매출수량,매출금액
     SELECT A.PROD_ID AS 상품코드,
            A.PROD_NAME AS 상품명,
            NVL(SUM(B.BUY_QTY),0) AS 매입수량,
            NVL(SUM(B.BUY_QTY*A.PROD_COST),0) AS 매입금액,
            NVL(SUM(C.CART_QTY),0) AS 매출수량,
            NVL(SUM(C.CART_QTY*A.PROD_PRICE),0) AS 매출금액
     FROM PROD A
     LEFT OUTER JOIN BUYPROD B ON(A.PROD_ID=B.BUY_PROD
     AND BUY_DATE BETWEEN TO_DATE('20050401') AND TO_DATE('20050630')) 
     LEFT OUTER JOIN CART C ON(A.PROD_ID=C.CART_PROD
     AND SUBSTR(CART_NO,1,6) BETWEEN '200504' AND '200506')
     GROUP BY A.PROD_ID,A.PROD_NAME
     ORDER BY 1;