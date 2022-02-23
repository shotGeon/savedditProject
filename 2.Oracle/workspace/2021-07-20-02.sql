2021-07-20-02)NULL처리 함수
-오라클에서 각 컬럼의 기본 초기값은 모두 NULL임
-NULL 자료에 대한 사칙연산 결과는 모두 NULL임
-NULL 자료에 대한 연산자 및 함수로 IS NULL, IS NOT NULL,
 NVL, NVL2, NULLIF 등이 사용됨
1.IS NULL, IS NOT NULL
 .특정 컬럼이나 계산된 값이 NULL인지 판별하기 위해 사용
 . '='연산자로 NULL값 여부를 판별하지 못함
 
사용예)사원테이블에서 영업실적코드(COMMISSION_PCT)가 NULL이아닌 사원의
      사원번호, 사원명, 입사일, 부서코드, 급여를 조회하시오
      SELECT EMPLOYEE_ID AS 사원번호,
             EMP_NAME AS 사원명,
             HIRE_DATE AS 입사일,
             DEPARTMENT_ID AS 부서코드,
             SALARY AS 급여
        FROM HR.EMPLOYEES
        WHERE COMMISSION_PCT IS NOT NULL;--관계연산자로는 NULL을 확인할 수 없다.(!=,<>)
        
2.NVL(c,val)
.'c'의 값을 판단하여 그 값이 NULL이면 'val'값을 반환하고, NULL이아니면
 'c'의 값을 반환
.'c'와 'val'의 자료형이 동일해야 함.


사용예)상품테이블에서 PROD_SIZE 값이 NULL이면 '상품크기정보 없음' 문자열을 출력하시오
      Alias는 상품코드, 상품명, 크기, 매입단가
      SELECT PROD_ID AS 상품코드,
             PROD_NAME AS 상품명,
             NVL(PROD_SIZE,'상품크기정보 없음') AS 크기,
             PROD_COST AS 매입단가
        FROM PROD;
        
사용예)사원테이블에서 사원번호,사원명,부서코드,직무코드를 출력하시오
   단, 부서코드가 NULL이면 'CEO'를 출력하시오.
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           NVL(TO_CHAR(DEPARTMENT_ID),'CEO') AS 부서코드,
           JOB_ID AS 직무코드
    FROM HR.EMPLOYEES
    
**상품테이블에서 분류코드가 P301인 상품의 판매가를 매입가의 90%로 UPDATE 하시오

 UPDATE PROD
    SET PROD_PRICE = PROD_COST
    WHERE LOWER(PROD_LGU) = 'p3O1';
    
    --컬럼의 대문자가 쓰여있는지 소문자가 쓰여있는지 모를때는 둘을 같은 형태로 써준다.(LOWER(PROD_LGU)='p301')
    commit;
사용예)2005년 7월 모든(아우터조인) 상품에 대한 판매정보를 조회하시오
    Alias는 상품코드, 판매수량합계,판매금액합계
    
    SELECT B.PROD_ID AS 상품코드,--많은쪽 부분을 사용한다.
           NVL(SUM(A.CART_QTY),0) AS 판매수량합계,
           NVL(SUM(A.CART_QTY*B.PROD_PRICE),0) AS 판매금액합계
       FROM CART A
       RIGHT OUTER JOIN PROD B ON(A.CART_PROD=B.PROD_ID
       --WHERE A.CART_PROD(+)=PROD_ID
         AND A.CART_NO LIKE '200507%')--외부조인에서 내부조인이 발생하면 정확한 값을 내보내지못한다. 이때에는 ANSI조인이나서브쿼리로해결해야한다. 
         GROUP BY B.PROD_ID
         ORDER BY 1;
         
3.NVL2(c,val1,val2)--(c,c,val2)로사용하면NVL처럼 사용할 수 있다.
.'c'값을 판단하여 그 값이 NULL이면 'val2'를 반환하고 NULL이 아니면 'vall'값을 반환 함
.'val1'과 'val2'의 데이터 타입이 같아야 함

사용예)사원테이블에서 사원번호,사원명,부서코드,직무코드를 출력하시오
       단, 부서코드가 NULL이면 'CEO'를 출력하시오
       
       SELECT EMPLOYEE_ID AS 사원번호,
              EMP_NAME AS 사원명,
              NVL2(DEPARTMENT_ID,TO_CHAR(DEPARTMENT_ID),'CEO') AS 부서코드,
              JOB_ID AS 직무코드
         FROM HR.EMPLOYEES;
사용예)상품테이블에서 상품의 색상정보를(PROD_COLOR)의 값이 NULL이면 '색상정보 없는 상품'을 
      NULL이 아니면 '색상정보 보유 상품'을 출력하시오.
      
      SELECT PROD_ID,
             PROD_NAME,
             NVL2(PROD_COLOR,'색상정보 보유 상품','색상정보 없는 상품') AS 색상
             FROM PROD;

4.NULLIF(c1,c2)
 .'c1'과'c2'를 비교하여 같으면 NULL을 반환하고, 같지 않으면 c1을 반환 함  
 
 사용예)상품테이블에서 판매가와 매입가를 비교하여 판매가가 같지 않으면'정상상품'
       같으면 '단종상품'을 비고난에 출력하시오.
       Alias는 상품코드,상품명,매입가,판매가,비고
       SELECT  PROD_ID AS 상품코드,
               PROD_NAME AS 상품명,
               PROD_COST AS 매입가,
               PROD_PRICE AS 판매가,
               NVL2(NULLIF(PROD_PRICE,PROD_COST),'정상상품','단종상품')비고
            FROM PROD;
            
            
  사용예)상품테이블에서 판매가와 매입가를 비교하여 판매가와 매입가가 같지 않으면 판매가를,
       같으면 '단종상품'을 판매가난에 출력하시오.
        Alias는 상품코드,상품명,매입가,판매가
        
        SELECT PROD_ID AS 상품코드,
               PROD_NAME AS 상품명,
               PROD_COST AS 매입가,
               NVL(LPAD(TO_CHAR(NULLIF(PROD_PRICE,PROD_COST)),10),LPAD(TRIM('단종상품'),11)) AS 판매가
            FROM PROD;
       