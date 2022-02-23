2021-0720-01)
 4.MAX(column명), MIN(column명)
  .MAX : 주어진 컬럼명 중 최대 값을 반환
  .MIN : 주어진 컬럼명 중 최소 값을 반환
  .집계함수는 다른 집계함수를 포함 할 수 없다.
  
사용예)2005년 월별 매입액 중 최대 매입제품과 최소 매입제품의 
       월,최대매입액,최소매입액
      SELECT EXTRACT(MONTH FROM BUY_DATE)||'월' AS 월,
             MAX(BUY_QTY*BUY_COST) AS 최대매입액,
             MIN(BUY_QTY*BUY_COST) AS 최소매입액
       FROM BUYPROD
       WHERE EXTRACT(YEAR FROM BUY_DATE)=2005
       GROUP BY EXTRACT(MONTH FROM BUY_DATE);
       
       
사용예)2005년 5월 최대구매 고객정보를 조회하시오
     Alias는 회원번호, 회원명, 구매금액
     SELECT A.CART_MEMBER AS 회원번호,
            B.MEM_NAME AS 회원명,
            SUM(A.CART_QTY*C.PROD_PRICE) AS 구매금액
     FROM CART A,MEMBER B, PROD C
     WHERE A.CART_MEMBER=B.MEM_ID 
     AND A.CART_PROD=C.PROD_ID 
     AND A.CART_NO LIKE ('200505%')
    GROUP BY A.CART_MEMBER,B.MEM_NAME
   ORDER BY 3 DESC;
   
   (SUBQUARY)
   SELECT D.MID AS 회원번호,
          D.MNAME AS 회원명,
          E.MEM_ADD1||' '||MEM_ADD2 AS 주소,
          E.MEM_HP AS 연락처,
          D.AMT AS 구매금액
     FROM (SELECT A.CART_MEMBER AS MID,
                  B.MEM_NAME AS MNAME,
                  SUM(A.CART_QTY*C.PROD_PRICE) AS AMT
            FROM CART A,MEMBER B, PROD C
            WHERE A.CART_MEMBER=B.MEM_ID 
            AND A.CART_PROD=C.PROD_ID 
            AND A.CART_NO LIKE '200505%'
            GROUP BY A.CART_MEMBER,B.MEM_NAME
            ORDER BY 3 DESC) D, MEMBER E
         WHERE D.MID=E.MEM_ID
           AND ROWNUM=1;
     