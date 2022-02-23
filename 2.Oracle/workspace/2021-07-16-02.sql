2021-0716-02)집계함수
-주어진 자료를 특정 컬럼을 기준으로 그룹으로 나누고 그 그룹별로 자료에 대한 집계를 반환하는 함수
-SUM, AVG, COUNT, MIN, MAX
(사용형식)
SELECT [컬럼list],
       SUM|AVG|MIN|MAX(expr)|COUNT(colum|*),
                  :
    FROM 테이블명
  [WHERE 조건]
  [GROUP BY 컬럼명[,컬럼명,...]]--SELECT절에서 집계함수를 사용하지 않은 컬럼명을 적어야 한다.(왼쪽부터 대그룹순으로 작성)
  [HAVING 조건]
   [ORDER BY 컬럼명|컬럼인덱스[ASC|DESC],...];
   
1.SUM(expr)
 .'expr'로 표현되는 수식 또는 컬럼의 값에 대한 합계를 반환
 
사용예) 사원테이블에서 부서별 급여 합계를 구하시오
     SELECT DEPARTMENT_ID AS 부서코드,
            SUM(SALARY)  AS 급여합계      
        FROM HR.EMPLOYEES
       GROUP BY DEPARTMENT_ID
       ORDER BY 1;
사용예) 사원테이블에서 부서별 급여 합계를 구하되 10000이상인 부서만 구하시오

    SELECT DEPARTMENT_ID AS 부서코드,
            SUM(SALARY)  AS 급여합계      
        FROM HR.EMPLOYEES
       GROUP BY DEPARTMENT_ID
       HAVING SUM(SALARY)>=10000
       ORDER BY 1 DESC;
       
사용예) 2005년 5월 회원별 구매현황(회원번호,구매수량합계,구매금액합계)을 조회하시오

  SELECT A.CART_MEMBER AS 회원번호,
         SUM(A.CART_QTY) AS 구매수량합계,
         SUM(A.CART_QTY*B.PROD_PRICE) AS 구매금액합계
         FROM CART A, PROD B
         WHERE A.CART_PROD=B.PROD_ID AND  A.CART_NO LIKE '200505%'
       GROUP BY A.CART_MEMBER;
     
 사용예) 2005년 월별 회원별 구매현황(월,회원번호,구매수량합계,구매금액합계)을 조회하시오
 
  
  SELECT SUBSTR(A.CART_NO,5,2) AS "월",       
                A.CART_MEMBER AS 회원번호,
                SUM(A.CART_QTY) AS 구매수량합계,
                SUM(A.CART_QTY*B.PROD_PRICE) AS 구매금액합계
                FROM CART A, PROD B
                WHERE A.CART_PROD=B.PROD_ID 
                AND SUBSTR(A.CART_NO,1,4)='2005'
       GROUP BY SUBSTR(A.CART_NO,5,2),A.CART_MEMBER
       ORDER BY 1;
       
  사용예) 회원테이블에서 직업별 마일리지 합계를 구하시오  
     SELECT MEM_JOB  AS 직업,
            SUM(MEM_MILEAGE) AS "마일리지 합계"
            FROM MEMBER
            GROUP BY MEM_JOB
            ORDER BY SUM(MEM_MILEAGE)DESC;
 
 문제]사원테이블에서 근무국가별 급여합계를 수하시오.
 
 
SELECT C.COUNTRY_ID AS "근무국가코드",
       D.COUNTRY_NAME AS "근무국가명",
       COUNT(*) AS 사원수,
       TO_CHAR(SUM(A.SALARY),'999,990') AS "급여합계"
FROM EMPLOYEES A, DEPARTMENTS B,LOCATIONS C,COUNTRIES D
WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID 
  AND B.LOCATION_ID=C.LOCATION_ID 
  AND C.COUNTRY_ID=D.COUNTRY_ID
GROUP BY C.COUNTRY_ID, D.COUNTRY_NAME;


사용예) 사원테이블에서 각 부서별 보너스 합계를 구하시오(부서코드, 부서명, 보너스 합계)(보너스는 영업실적(COMMISSION_PCT)과 급여를 곱한결과의 30%
       SELECT A.DEPARTMENT_ID AS 부서코드,
              A.DEPARTMENT_NAME AS 부서명,
              NVL(SUM(B.COMMISSION_PCT*B.SALARY)*0.3,0) AS "보너스 합계"--NVL널값에의한 결과를 바꾸는 함수이다.
        FROM DEPARTMENTS A,EMPLOYEES B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
        ORDER BY 1;
        
        UPDATE EMPLOYEES
        SET COMMISSION_PCT=0.2
        WHERE EMPLOYEE_ID=107;
COMMIT;
 
 
 
 
 
 
 
 
 
 
 
 
 
  
 
 