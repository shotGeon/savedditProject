2021-07-27-02)

사용예)회원테이블에서 평균마일리지보다 많은 마일리지를 보유한 회원의 회원번호,회원명
      마일리지를 출력하시오
      
     SELECT MEM_ID AS 회원번호,
            MEM_NAME AS 회원명,
            MEM_MILEAGE AS 마일리지,
            (SELECT ROUND(AVG(MEM_MILEAGE))
               FROM MEMBER)AS 평균마일리지
           FROM MEMBER
         WHERE MEM_MILEAGE>=(SELECT ROUND(AVG(MEM_MILEAGE))
                             FROM MEMBER);
            
     SELECT MEM_ID AS 회원번호,
            MEM_NAME AS 회원명,
            MEM_MILEAGE AS 마일리지,
            A.AMILE AS 평균마일리지
        FROM MEMBER,(SELECT ROUND(AVG(MEM_MILEAGE))AS AMILE
               FROM MEMBER)A 
            WHERE MEM_MILEAGE>=A.AMILE;
            
사용예)회원들의 자료에서 성별 평균마일리지를 구하고 자신의 성별 평균마일리지보다 적은 마일리지를 보유한 회원의
      2005년 4~6월 구매현황을 조회하시오
      Alias는 회원번호,회원명,구매금액합계
      SELECT  CART_MEMBER AS 회원번호,
              TBLB.CNAME AS 회원명,
              SUM(B.CART_QTY*C.PROD_PRICE) AS 구매금액합계
        FROM CART,PROD,
                (SELECT C.MEM_ID,
                        C.MEM_NAME,
                        B.G1,
                        C.MEM_MILEAGE,
                        ROUND(B.AMILE)
                    FROM (SELECT A   
      
      SELECT A.MEM_ID AS 회원번호,      
             A.MEM_NAME AS 회원명,
             SUM(B.CART_QTY*C.PROD_PRICE) AS 구매금액합계
         FROM MEMBER A,CART B,PROD C,(SELECT ROUND(AVG(MEM_MILEAGE)) AS NAMM
                                           FROM MEMBER
                                       WHERE SUBSTR(MEM_REGNO2,1,1)='1'
                                         OR  SUBSTR(MEM_REGNO2,1,1)='3')D,
                                    (SELECT ROUND(AVG(MEM_MILEAGE)) AS GAMM
                                       FROM MEMBER
                                       WHERE SUBSTR(MEM_REGNO2,1,1)='2'
                                          OR SUBSTR(MEM_REGNO2,1,1)='4')F
            WHERE A.MEM_MILEAGE<D.NAMM OR A.MEM_MILEAGE<F.GAMM
              AND SUBSTR(B.CART_NO,1,6) BETWEEN '200504' AND '200506'
              AND A.MEM_ID=B.CART_MEMBER
              AND B.CART_PROD=C.PROD_ID
              GROUP BY A.MEM_ID,A.MEM_NAME; 
              
              