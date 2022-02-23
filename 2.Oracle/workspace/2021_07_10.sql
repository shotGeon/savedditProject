---1번-----

SELECT  MEM_ID AS 회원번호,
        MEM_NAME AS 회원명,
        MEM_REGNO1||' '||MEM_REGNO2 AS 주민번호,
        EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(MEM_REGNO1,1,2)+1900))AS 나이
    FROM MEMBER;
    
---2번-----

SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME||' '||LAST_NAME AS 사원명, 
       SALARY AS 급여, 
       NVL(SALARY*COMMISSION_PCT*0.35,0) AS 보너스, --,0기본값
       SALARY+NVL(SALARY*COMMISSION_PCT*0.35,0)AS 지급액
       FROM HR.EMPLOYEES;
       
---3번-----

SELECT MEM_ID AS 회원번호, 
       MEM_NAME AS 회원명,
       MEM_JOB AS 직업,
       MEM_MILEAGE AS 마일리지
   FROM MEMBER
   WHERE MEM_MILEAGE >=4000;
      

---4번-----

SELECT 

UPDATE MEMBER
   SET MEM_REGNO1='460409',
       MEM_REGNO2='200000',
       MEM_BIR=TO_DATE('19460409')
    WHERE MEM_ID='doo1';
    
UPDATE MEMBER
   SET MEM_REGNO1='750323',
       MEM_REGNO2='1011014',
       MEM_BIR=TO_DATE('19750323')
    WHERE MEM_ID='n001';
    
----5번----

SELECT MEM_ID AS 회원번호,
       MEM_NAME AS 회원명,  
       MEM_BIR AS 생년월일, 
       MEM_MILEAGE AS 마일리지, 
   CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2'OR
             SUBSTR(MEM_REGNO2,1,1)='4'THEN
                         '여성회원'
                          END AS 비고
                FROM MEMBER
                WHERE SUBSTR(MEM_REGNO2,1,1)='2' 
                OR
                      SUBSTR(MEM_REGNO2,1,1)='4';
             
    
----6번-----

SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME ||' '|| LAST_NAME AS 사원명,
       SALARY AS 급여,
       DEPARTMENT_ID AS 부서번호,
       ROUND((SELECT AVG (SALARY)
                   FROM HR.EMPLOYEES),0) AS 평균급여
       
              FROM HR.EMPLOYEES
              WHERE SALARY >= (SELECT AVG(SALARY)
                                FROM HR.EMPLOYEES)
                                 ORDER BY 4;
-------7번--------

SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME||' '||LAST_NAME AS 사원명,
       DEPARTMENT_ID AS 부서코드,
       HIRE_DATE AS 입사일
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID IN(10,30,40,60);
SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME||' '||LAST_NAME AS 사원명,
       DEPARTMENT_ID AS 부서코드,
       HIRE_DATE AS 입사일
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID=10
    OR    DEPARTMENT_ID=30
    OR    DEPARTMENT_ID=40
    OR    DEPARTMENT_ID=60;
SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME||' '||LAST_NAME AS 사원명,
       DEPARTMENT_ID AS 부서코드,
       HIRE_DATE AS 입사일
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID ANY(10,30,40,60);

------8번-------
SELECT EMPLOYEE_ID AS 사원번호,
       FIRST_NAME||' '||LAST_NAME AS 사원명,
       SALARY AS 급여
     FROM HR.EMPLOYEES 
     WHERE SALARY > (SELECT MAX(SALARY)
                      FROM HR.EMPLOYEES
                      WHERE DEPARTMENT_ID IN(20,40,70));
                      
-----9번--------
SELECT BUY_DATE AS 매입날짜,
       BUY_PROD AS 제품번호,
       BUY_QTY AS 매입수량,
       BUY_QTY*BUY_COST AS 매입금액
       FROM BUYPROD
       WHERE BUY_DATE BETWEEN TO_DATE('20050301') AND LAST_DAY(TO_DATE('20050302'));

-------10번---------
SELECT MEM_ID AS 회원번호,
       MEM_NAME AS 회원명,
       MEM_MILEAGE AS 마일리지
    FROM MEMBER
    WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) BETWEEN 40 AND 49;
    
SELECT MEM_ID AS 회원번호,
       MEM_NAME AS 회원명,
       MEM_MILEAGE AS 마일리지,
       EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) AS 나이
    FROM MEMBER
    WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR)>=40;
    
-----11번------
SELECT PROD_ID AS 상품코드,
       PROD_NAME AS 상품명,
       PROD_QTYIN AS 판매수량,
       PROD_COST금액


                                
             
              
              
              
            
        
   
        

