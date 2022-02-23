2021-07-28-01)집합연산자
-집합연산자는 SELECT문의 결과를 대상으로 연산을 수행
-복잡한 서브쿼리나 조인을 줄일수 있음
-여러 개의 SELECT문을 하나로 묶는 역할 수행
-UNION ALL, UNION, INTERSECT, MINUS 제공
** 주의사항
- 각 SELECT문은 같은 갯수, 같은 타입의 컬럼을 조회해야 함
- 각 SELECT 문들이 여러 개의 컬럼을 조회하는 경우 모든 컬럼에 대한 집합연산 수행
- ORDER BY는 사용할 수 있으나 가장 마지막 SELECT문에서만 사용 가능
- 출력은 첫 번째 SELECT문에 의하여 결정 됨

1) UNION
 .합집합의 결과를 반환
 .교집합 부분의 중복은 배제됨
 
 사용예)사원테이블에서 'Seattle'에 근무하는 사원과 'IT'부서에 근무하는 사원의
       사원번호,사원명,부서명,직무명을 조회하시오.
       
       (1)(집합A)'Seattle'에 근무하는 사원의 사원번호,사원명,소재지,직무명
          SELECT A.EMPLOYEE_ID AS 사원번호,
                 A.EMP_NAME AS 사원명,
                 D.CITY AS 소재지,
                 C.JOB_TITLE AS 직무명
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B,HR.JOBS C,HR.LOCATIONS D
           WHERE D.CITY='Seattle'
             AND D.LOCATION_ID=B.LOCATION_ID
             AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
             AND A.JOB_ID=C.JOB_ID
           ORDER BY 1;
           
        (2)(집합B)'IT'부서에 근무하는 사원에 사원번호, 사원명, 직무번호를 구하라
            SELECT A.EMPLOYEE_ID AS 사원번호,
                   A.EMP_NAME AS 사원명,
                   D.CITY AS 소재지,
                   B.JOB_TITLE AS 직무명
            FROM HR.EMPLOYEES A,HR.JOBS B,HR.DEPARTMENTS C,HR.LOCATIONS D
            WHERE C.DEPARTMENT_NAME='IT'
              AND C.DEPARTMENT_ID=A.DEPARTMENT_ID
              AND A.JOB_ID=B.JOB_ID
              AND C.LOCATION_ID=D.LOCATION_ID;
              
              
        (3)(결합 UNION)
              SELECT A.EMPLOYEE_ID AS 사원번호,
                 A.EMP_NAME AS 사원명,
                 D.CITY AS 소재지,
                 C.JOB_TITLE AS 직무명
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B,HR.JOBS C,HR.LOCATIONS D
           WHERE D.CITY='Seattle'
             AND D.LOCATION_ID=B.LOCATION_ID
             AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
             AND A.JOB_ID=C.JOB_ID
           UNION
                SELECT A.EMPLOYEE_ID AS 사원번호,
                   A.EMP_NAME AS 사원명,
                   D.CITY AS 소재지,
                   B.JOB_TITLE AS 직무명
            FROM HR.EMPLOYEES A,HR.JOBS B,HR.DEPARTMENTS C,HR.LOCATIONS D
            WHERE C.DEPARTMENT_NAME='IT'
              AND C.DEPARTMENT_ID=A.DEPARTMENT_ID
              AND A.JOB_ID=B.JOB_ID
              AND C.LOCATION_ID=D.LOCATION_ID
              ORDER BY 1;
              
사용예) 회원테이블에서 마일리지가 3000이상인 회원과 직업이 공무원인 회원의
       회원번호,회원명,주소,마일리지를 조회하시오.
       SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_ADD1||''||MEM_ADD2 AS 주소,
              MEM_MILEAGE AS 마일리지
         FROM MEMBER
        WHERE MEM_MILEAGE>=3000
     UNION   
       SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_ADD1||''||MEM_ADD2 AS 주소,
              MEM_MILEAGE  AS 마일리지                    --TO_NUMBER(MEM_REGNO1) AS 주민번호 서로다른값을가지면 중복되어 나오기
                                                         --때문에 주의하자
         FROM MEMBER
        WHERE MEM_JOB='공무원';
        
2)UNION ALL
 .합집합의 결과를 반환
 .교집합 부분(공통부분)이 중복되어 출력
 
사용예)회원테이블에서 마일리지가 2000이상인 회원과 직업이 주부인 회원의
       회원번호,회원명,주소,마일리지를 조회하시오.
        SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_ADD1||''||MEM_ADD2 AS 주소,
              MEM_MILEAGE AS 마일리지
         FROM MEMBER
        WHERE MEM_MILEAGE>=2000
       UNION ALL
         SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_ADD1||''||MEM_ADD2 AS 주소,
              MEM_MILEAGE AS 마일리지
         FROM MEMBER
        WHERE MEM_JOB='주부'
        
사용예)2005년 4월과 7월에 팔린 상품정보를 조회하시오
     Alias는 상품코드,상품명,판매가,거래처명
     SELECT DISTINCT A.PROD_ID AS 상품코드,
            A.PROD_NAME AS 상품명,
            A.PROD_PRICE AS 판매가,
            B.BUYER_NAME AS 거래처명
        FROM PROD A,BUYER B,CART C
        WHERE C.CART_PROD=A.PROD_ID                       
          AND  A.PROD_BUYER=B.BUYER_ID
          AND SUBSTR(C.CART_NO,1,6)='200504'
       UNION 
           SELECT A.PROD_ID AS 상품코드,
            A.PROD_NAME AS 상품명,
            A.PROD_PRICE AS 판매가,
            B.BUYER_NAME AS 거래처명
        FROM PROD A,BUYER B,CART C
        WHERE A.PROD_BUYER=B.BUYER_ID
          AND C.CART_PROD=A.PROD_ID
          AND SUBSTR(C.CART_NO,1,6)='200507'
          
          
3)INTERSECT
 .교집합(공통부분)의 결과를 반환
 
사용예)2005년 4월과 7월에 모두 팔린 상품정보를 조회하시오
     Alias는 상품코드,상품명,판매가,거래처명
      SELECT DISTINCT A.PROD_ID AS 상품코드,
            A.PROD_NAME AS 상품명,
            A.PROD_PRICE AS 판매가,
            B.BUYER_NAME AS 거래처명
        FROM PROD A,BUYER B,CART C
        WHERE C.CART_PROD=A.PROD_ID                       
          AND  A.PROD_BUYER=B.BUYER_ID
          AND C.CART_NO LIKE '200504%'
    INTERSECT
     SELECT A.PROD_ID AS 상품코드,
            A.PROD_NAME AS 상품명,
            A.PROD_PRICE AS 판매가,
            B.BUYER_NAME AS 거래처명
        FROM PROD A,BUYER B,CART C
        WHERE A.PROD_BUYER=B.BUYER_ID
          AND C.CART_PROD=A.PROD_ID
          AND SUBSTR(C.CART_NO,1,6)='200507';
          
사용예) 부서명이 'shipping'에 속한 사원 중 'Mattew Weiss'사원의 팀에 소속된 사원을 
       조회하시오 (사원번호,사원명,부서명,입사일,급여)
       SELECT A.EMPLOYEE_ID AS 사원번호,
              A.EMP_NAME AS 사원명,
              B.DEPARTMENT_NAME AS 부서명,
              A.HIRE_DATE AS 입사일,
              A.SALARY AS 급여
        FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          AND B.DEPARTMENT_NAME='Shipping'
    INTERSECT
    SELECT A.EMPLOYEE_ID AS 사원번호,
              A.EMP_NAME AS 사원명,
              B.DEPARTMENT_NAME AS 부서명,
              A.HIRE_DATE AS 입사일,
              A.SALARY AS 급여
        FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          AND A.MANAGER_ID=(SELECT EMPLOYEE_ID
            FROM HR.EMPLOYEES
            WHERE EMP_NAME= 'Matthew Weiss');
         
         
4)MINUS
 .MINUS 연산자 앞에 위치한 쿼리의 결과에서 MINUS 뒤에 기술된 쿼리의 결과를
  차감한 결과 반환
  
 사용예) 장바구니테이블에서 4월과 5월에 판매된 상품 중 4월만 판매된 상품의 상품번호, 상품명,
        수량합계, 판매금액합계를 구하시오.--내부조인이기때문에 어느 테이블을 사용해도 상관없다.
        SELECT DISTINCT A.CART_PROD AS 상품번호, 
               B.PROD_NAME AS 상품명
--               SUM(A.CART_QTY) AS 수량합계,
--               SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
          FROM CART A,PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200504%'
--            GROUP BY A.CART_PROD,B.PROD_NAME;
     MINUS
          SELECT DISTINCT A.CART_PROD AS 상품번호, 
               B.PROD_NAME AS 상품명
--               SUM(A.CART_QTY) AS 수량합계,
--               SUM(A.CART_QTY*B.PROD_PRICE) AS 판매금액합계
          FROM CART A,PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200507%'
--            GROUP BY A.CART_PROD,B.PROD_NAME;
         
         
         
         
         
          