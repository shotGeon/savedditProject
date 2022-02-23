2021-07-19-01)

2.AVG(expr)
 .'expr'로 정의된 컬럼이나 수식의 값에 대한 산술평균 값을 반환
 
사용예)모든 여성회원들의 평균 마일리지를 조회하시오
SELECT ROUND(AVG(MEM_MILEAGE))
   FROM MEMBER
   WHERE SUBSTR(MEM_REGNO2,1,1) IN('2','4');
   
   
   
사용예)회원들의 성별 평균 마일리지를 조회하시오 

SELECT  CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2'
             OR   SUBSTR(MEM_REGNO2,1,1)='4' THEN
                '여성회원'
             ELSE
                 '남성회원' END AS 구분,
      ROUND(AVG(MEM_MILEAGE)) AS 평균마일리지
      FROM MEMBER
      GROUP BY   SUBSTR(MEM_REGNO2,1,1);
   
사용예) 사원테이블에서 각 부서별 평균급여를 조회하시오

     SELECT B.DEPARTMENT_ID AS 부서코드,
            B.DEPARTMENT_NAME AS 부서명,
            ROUND(AVG(A.SALARY)) AS 평균급여
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        GROUP BY B.DEPARTMENT_ID,B.DEPARTMENT_NAME
        ORDER BY 1;
        
사용예) 2005년 1~6월 월별 평균 매입액을 조회하시오
      SELECT EXTRACT(MONTH FROM BUY_DATE)||'월' AS 월,
            ROUND(AVG(BUY_QTY*BUY_COST)) AS "평균 매입액"
            FROM BUYPROD
            WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050630')
            GROUP BY EXTRACT(MONTH FROM BUY_DATE)
            ORDER BY 1;
            
사용예) 2005년 1~6월 월별 평균 매입액과 매입액합을 조회하되 매입액이 400만원이상인 월만 조회하시오

      SELECT EXTRACT(MONTH FROM BUY_DATE)||'월' AS 월,
             COUNT(*) AS 매입건수,
             ROUND(AVG(BUY_QTY*BUY_COST)) AS "평균 매입액",
             SUM(BUY_QTY*BUY_COST) AS 매입액합
             FROM BUYPROD
             WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050630')
             GROUP BY EXTRACT(MONTH FROM BUY_DATE)
             HAVING AVG(BUY_QTY*BUY_COST)>=4000000
             ORDER BY 1;
             
사용예) 2005년 분류별 평균구매금액을 조회하시오.

       SELECT    C.LPROD_GU AS 분류코드,
                C.LPROD_NM AS 분류명,
       ROUND(AVG(B.PROD_PRICE*A.CART_QTY)) AS 평균매입금액
       FROM CART A,PROD B,LPROD C
       WHERE SUBSTR(A.CART_NO,1,4)='2005'
             AND C.LPROD_GU=B.PROD_LGU
       GROUP BY C.LPROD_GU,C.LPROD_NM ; 
       
       
       
       
사용예) 2005년 회원의 연령대별 평균구매금액을 조회하시오.
      SELECT TRUNC((EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM A.MEM_BIR))/10)*10||'대' AS 연령대, 
             ROUND(AVG(B.PROD_PRICE*C.CART_QTY)) AS 평균구매금액
      FROM MEMBER A,PROD B, CART C
      WHERE     C.CART_PROD=B.PROD_ID
            AND C.CART_MEMBER=A.MEM_ID
            AND C.CART_NO LIKE '2005%'
      GROUP BY TRUNC((EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM A.MEM_BIR))/10)*10
      ORDER BY 1;
 
사용예)사원들 중 자기가 속한 부서의 평균 급여보다 적은 급여를 받는 직원정보를 조회하시오
     Alias는 사원번호,사원명,부서번호,부서명,급여,부서평균급여 
     
     제출일자:2021년 7월 31일까지
     제출방법:교사용 PC 공용폴더에 전송(SEM-PC D:\공유폴더\oracle\homework1)
     문서타입 :메모장에서 저장된 TEXT문서
     문서명:본인이름_0731.TXT
     
3. COUNT(column명|*)
 . 그룹내의 행의 수(자료의 갯수)를 반환
 . 외부조인연산에 사용되는 경우 '*'를 사용하면 부정확한 결과를 반환하기 때문에 
   해당 테이블의 컬럼명을 기술해야 함
   
사용예)사원테이블에서 각 부서별 사원수를 조회하시오
      SELECT DEPARTMENT_ID AS 부서코드, 
             COUNT(*) AS 사원수1,
             COUNT(LAST_NAME) AS 사원수2
         FROM HR.EMPLOYEES
         GROUP BY DEPARTMENT_ID
         ORDER BY 1;
         
         
           SELECT DEPARTMENT_ID AS 부서코드, 
             COUNT(*) AS 사원수1,
             COUNT(LAST_NAME) AS 사원수2
         FROM HR.EMPLOYEES
         GROUP BY ROLLUP(DEPARTMENT_ID)
         ORDER BY 1;
         
사용예)2005년 5월 분류별 판매건수를 조회하시오
    SELECT B.PROD_LGU AS 분류코드,
           COUNT(*) AS 판매건수
         FROM CART A, PROD B
        WHERE A.CART_PROD=B.PROD_ID
          AND A.CART_NO LIKE '200505%'
        GROUP BY B.PROD_LGU
        ORDER BY 1;

사용예)2005년 5~6월 회원별 매입횟수를 조회하시오
     Alias는 회원번호, 매입횟수
     
     SELECT A.CID AS 회원번호,
            COUNT(*) AS 매입횟수
        FROM (SELECT DISTINCT CART_NO AS CNO,
                     CART_MEMBER AS CID
                FROM CART
                WHERE SUBSTR(CART_NO,1,6) IN('200505','200506')
                ORDER BY 2) A
         GROUP BY A.CID
         ORDER BY 1;

사용예)모든 부서별 사원수를 조회하시오(NULL부서코드는 무시한다.)
     SELECT B.DEPARTMENT_ID AS 부서코드, 
            B.DEPARTMENT_NAME AS 부서명,
             COUNT(EMPLOYEE_ID) AS 사원수--*말고 컬럼명을쓰면 줄수를 세지않고 0으로 나타낸다.(외부조인 경우 반드시 컬럼명 작성)
         FROM HR.EMPLOYEES A,HR.DEPARTMENTS B--외부조인을 쓸때는 종류가 많은 테이블을 쓴다.안그럼 널값이 들어간다.
         WHERE A.DEPARTMENT_ID(+)=B.DEPARTMENT_ID--(+)외부조인연산자(A테이블을 확장해서 B테이블과 조인하라는 뜻이다.)
         GROUP BY B.DEPARTMENT_ID,B.DEPARTMENT_NAME
         ORDER BY 1;
         
         




