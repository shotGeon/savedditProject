2021-0729-01)등수계산(RANK 함수)
- 성적, 급여, 매출 등의 순위를 구할때 사용
- ORDER BY절과 ROWNUM의사 컬럼은 오라클의 WHERE절과 ORDER BY절의 실행
  순서때문에 정확한 결과 반환이 불가능 함
- 이를 해결하기 위해 RANK와 DENSE_RANK 함수 제공
- RANK와 DENSE_RANK 함수의 차이점
 . RANK : 중복 순위가 발생하면 중복 갯수 만큼 다음 순위값을 증가(ex 1,1,1,4,5..)
 . DENSE_RANK : 중복 순위가 발생해도 다음 순위는 순자적인 값을 배정(ex 1,1,1,2,3,4...)
 . ROW_NUMBER : 중복에 관계없이 순차 순위값 배정(ex 1,2,3,4,5,..)
-SELECT 절에서 사용!!!!!!!!!!!!
(사용형식)
  SELECT 컬럼list,
         RANK() OVER(ORDER BY 기준컬럼명 DESC|ASC) AS 컬럼별칭,
              :
     FROM 테이블명;
     
     
사용예) 회원테이블에서 마일리지가 많은 회원부터 차례대로 순위(등수)를 부여하시오
       회원번호, 회원명, 마일리지, 등수
       
       SELECT MEM_ID AS 회원번호, 
              MEM_NAME AS 회원명,
              MEM_MILEAGE AS 마일리지,
              RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS 등수
          FROM MEMBER;

사용예) 회원테이블에서 마일리지가 많은 회원부터 차례대로 순위(등수)를 부여하고 상위 5명의
       회원번호, 회원명, 마일리지, 등수
       
       SELECT B.MID AS 회원번호, 
              A.MEM_NAME AS 회원명,
              A.MEM_MILEAGE AS 마일리지,
              B.MLR AS 등수
          FROM (SELECT MEM_ID AS MID,
                       RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS MLR
                       FROM MEMBER)B,MEMBER A
          WHERE A.MEM_ID=B.MID
            AND B.MLR<=5
            ORDER BY 4 ASC;
            
사용예)장바구니 테이블에서 2005년 5월 구매금액이 많은 회원부터 순위를 부여하여
     회원번호, 회원명, 구매금액, 순위를 출력하시오
     SELECT A.CART_MEMBER AS 회원번호,
            C.MEM_NAME AS 회원명,
            SUM(A.CART_QTY*D.PROD_PRICE) AS 구매금액,
            RANK()OVER(ORDER BY B.SCP DESC) AS 순위
       FROM CART A,(SELECT A.CART_MEMBER AS CMM,
                     SUM(A.CART_QTY*B.PROD_PRICE) AS SCP
                    FROM CART A,PROD B
                    GROUP BY A.CART_MEMBER) B,
       MEMBER C, PROD D
       WHERE A.CART_MEMBER=B.CMM
         AND A.CART_PROD=D.PROD_ID
         AND A.CART_NO LIKE '200505%'
         GROUP BY A.CART_MEMBER, C.MEM_NAME 
         ORDER BY 1;
         
         SELECT A.CART_MEMBER AS 회원번호,
                C.MEM_NAME AS 회원명,
                SUM(A.CART_QTY*B.PROD_PRICE) AS 구매금액,
                RANK() OVER(ORDER BY SUM(A.CART_QTY*B.PROD_PRICE)DESC) AS 순위
            FROM CART A,PROD B, MEMBER C
           WHERE A.CART_MEMBER=C.MEM_ID
             AND A.CART_PROD=B.PROD_ID
             AND A.CART_NO LIKE '200505%'
             GROUP BY A.CART_MEMBER,C.MEM_NAME;
             
        SELECT MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
               MEM_MILEAGE AS 마일리지,
               DENSE_RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS 등수
            FROM MEMBER;
         
         
         
         
         
         
         
         
         
         
         
         



























