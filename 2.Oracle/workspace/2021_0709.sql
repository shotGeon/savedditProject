기타연산자: (IN, ANY, SOME, ALL, EXISTS, BETWEEN(범위를비교할때)_, LIKE(패턴을 비교할때)등 제공)
     --IN,ANY,SOME,ALL,EXISTS는 우측데이터가 하나이상 존재해야한다.
     
     1.IN--범위내에서 불규칙한 데이터를 비교할때 사용한다,
     -주어진 값 중 어는 하나와 일치하면 TRUE를 반환
     -OR 연산자로 치환 가능
     -NOT 연산자와 함께 사용가능
     (사용형식)
    expr IN(값1[,값2,....)
    
**사원테이블에서 EMP_NAME VARCHAR(80) 컬럼을 추가
--ALTER TABLE 테이블명
--ADD(컬럼명 데이터 타입[(크기)] [DEFAULT 초기값)]
  ALTER TABLE HR.EMPLOYEES 
         ADD(EMP_NAME VARCHAR(80));
  COMMIT;
         
 **FIRST_NAME과 LAST_NAME의 값을 EMP_NAME에 저장
 UPDATE HR.EMPLOYEES 
    SET EMP_NAME=FIRST_NAME||' '||LAST_NAME;
    COMMIT;
         
 **컬럼의 이름을 변경할때
 ALTER TABLE 테이블명 RENAME COLUMN 원래컬럼명 TO 새로운컬럼명;
 **컬럼을 삭제할때
 ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
 **컬럼의 타입을 변경할때
 ALTER TABLE 테이블명 
         MODIFY(컬럼명 데이터 타입[(크기)] [DEFAULT 초기값)]--새로 바꿀 타입만 적으면 된다.

사용예)사원테이블에서 10,30,40,60번 부서에 속한 사람들의 사원번호,사원명,부서코드,입사일을 조회하시오
    (OR 연산자 사용)
    SELECT EMPLOYEE_ID AS 사원번호, 
           EMP_NAME AS 사원명, 
           DEPARTMENT_ID AS 부서코드, 
           HIRE_DATE AS 입사일
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=10
           OR DEPARTMENT_ID=30
           OR DEPARTMENT_ID=40
           OR DEPARTMENT_ID=60
           ORDER BY 3;
           
    (IN 연산자 사용)
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           DEPARTMENT_ID AS 부서코드,
           HIRE_DATE AS 입사일
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID IN(10,30,40,60);
        
    (ANY 연산자 사용=SOME연산자 동일)
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           DEPARTMENT_ID AS 부서코드,
           HIRE_DATE AS 입사일
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=ANY(10,30,40,60);
  
     (2)ALL
     .( )안에 주어진 값들을 모두 만족해야 결과가 참(TRUE)이 됨
     . AND로 치환 가능
     (사용형식)
        컬럼명 관계연산자ALL[값1[,값,....]]
     (사용예)사원테이블에서 20,40,70번 부서에 속한 사원들의 급여보다 급여가 많은 사원의 사원번호, 사원명,
            급여를 조회하시오.
            
            SELECT EMPLOYEE_ID AS 사원번호,
                   EMP_NAME AS 사원명,
                   SALARY AS 급여
                   FROM HR.EMPLOYEES
                WHERE SALARY >ALL(SELECT SALARY
                                    FROM HR.EMPLOYEES
                                    WHERE DEPARTMENT_ID IN(20,40,70));
                (WHERE SALARY >(SELECT MAX(SALARY) ---위에QUERY랑 동일,보통GROUP BY를 사용할때 사용
                                    FROM HR.EMPLOYEES
                                    WHERE DEPARTMENT_ID IN(20,40,70));)
                    
      (3)BETWEEN -AND --날짜에다는 LIKE말고 BETWEEN을 쓰자
      . 범위를 지정하여 값을 조회하는 조건문 구성에 사용
      . 논리 연산자 'AND'로 치환 가능
      
      
사용예)매입정보테이블(BUYPROD)에서 2005년 3월 매입현황을 풀력하시오
     (AND연산자 사용)
     
       SELECT BUY_DATE AS 날짜, 
              BUY_PROD AS 제품코드, 
              BUY_QTY AS 매입수량, 
              BUY_QTY*BUY_COST AS 매입금액
        FROM BUYPROD
        WHERE BUY_DATE >=TO_DATE('20050301')
          AND BUY_DATE <=LAST_DAY(TO_DATE('20050301'));
          
       (BETWEEN연산자 사용)
       
       SELECT BUY_DATE AS 날짜,
              BUY_PROD AS 제품코드,
              BUY_QTY AS 매입수량,
              BUY_QTY*BUY_COST AS 매입금액
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050301') AND LAST_DAY(TO_DATE('20050302'));
          
        
        --회원테이블에서 40대 회원의 회원번호,회원명,마일리지를 조회하시오    
       SELECT MEM_ID AS 회원번호,
               MEM_NAME AS 회원명, 
               MEM_MILEAGE AS 마일리지
            FROM MEMBER     
            WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) BETWEEN 40 AND 49; --EXTRACT는 날짜에만
        --회원의 생년월일 컬럼에서 월을 추출하시오   
           SELECT EXTRACT(MONTH FROM MEM_BIR); 
        --회원테이블에서 이번달에 생일이 있는 회원의 회원번호,회원명
        SELECT MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
             FROM MEMBER
             WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR);
             
        사용예)분류테이블(PROD)에서 분류코드가P2로 시작하는 상품에 대하여 2005년 5월 매출실적을 조회하시오
             상품코드,상품명,판매수량,금액
           SELECT A.PID AS 상품코드,
                  A.PNAME AS 상품명,
                  LPROD_GU AS 분류코드,
                  LPROD_NM AS 분류명,
                  A.QANT AS 판매수량,
                  A.MANT AS 금액
             FROM LPROD, (SELECT CART_PROD AS PID,
                                 PROD_NAME AS PNAME,
                                 SUM(CART_QTY) AS QANT,
                                 SUM(CART_QTY*PROD_PRICE) AS MANT
                           FROM CART, PROD
                           WHERE CART_PROD=PROD_ID
                             AND CART_NO LIKE '200505%'
                             AND PROD_LGU BETWEEN 'P200' AND 'P299'
                             GROUP BY CART_PROD,PROD_NAME) A,
                      PROD
                  WHERE PROD_ID=A.PID
                    AND PROD_LGU=LPROD_GU
                  ORDER BY 1;
               
            