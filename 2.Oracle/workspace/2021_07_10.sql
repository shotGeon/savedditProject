---1��-----

SELECT  MEM_ID AS ȸ����ȣ,
        MEM_NAME AS ȸ����,
        MEM_REGNO1||' '||MEM_REGNO2 AS �ֹι�ȣ,
        EXTRACT(YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(MEM_REGNO1,1,2)+1900))AS ����
    FROM MEMBER;
    
---2��-----

SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME||' '||LAST_NAME AS �����, 
       SALARY AS �޿�, 
       NVL(SALARY*COMMISSION_PCT*0.35,0) AS ���ʽ�, --,0�⺻��
       SALARY+NVL(SALARY*COMMISSION_PCT*0.35,0)AS ���޾�
       FROM HR.EMPLOYEES;
       
---3��-----

SELECT MEM_ID AS ȸ����ȣ, 
       MEM_NAME AS ȸ����,
       MEM_JOB AS ����,
       MEM_MILEAGE AS ���ϸ���
   FROM MEMBER
   WHERE MEM_MILEAGE >=4000;
      

---4��-----

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
    
----5��----

SELECT MEM_ID AS ȸ����ȣ,
       MEM_NAME AS ȸ����,  
       MEM_BIR AS �������, 
       MEM_MILEAGE AS ���ϸ���, 
   CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2'OR
             SUBSTR(MEM_REGNO2,1,1)='4'THEN
                         '����ȸ��'
                          END AS ���
                FROM MEMBER
                WHERE SUBSTR(MEM_REGNO2,1,1)='2' 
                OR
                      SUBSTR(MEM_REGNO2,1,1)='4';
             
    
----6��-----

SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME ||' '|| LAST_NAME AS �����,
       SALARY AS �޿�,
       DEPARTMENT_ID AS �μ���ȣ,
       ROUND((SELECT AVG (SALARY)
                   FROM HR.EMPLOYEES),0) AS ��ձ޿�
       
              FROM HR.EMPLOYEES
              WHERE SALARY >= (SELECT AVG(SALARY)
                                FROM HR.EMPLOYEES)
                                 ORDER BY 4;
-------7��--------

SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME||' '||LAST_NAME AS �����,
       DEPARTMENT_ID AS �μ��ڵ�,
       HIRE_DATE AS �Ի���
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID IN(10,30,40,60);
SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME||' '||LAST_NAME AS �����,
       DEPARTMENT_ID AS �μ��ڵ�,
       HIRE_DATE AS �Ի���
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID=10
    OR    DEPARTMENT_ID=30
    OR    DEPARTMENT_ID=40
    OR    DEPARTMENT_ID=60;
SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME||' '||LAST_NAME AS �����,
       DEPARTMENT_ID AS �μ��ڵ�,
       HIRE_DATE AS �Ի���
    FROM HR.EMPLOYEES
    WHERE DEPARTMENT_ID ANY(10,30,40,60);

------8��-------
SELECT EMPLOYEE_ID AS �����ȣ,
       FIRST_NAME||' '||LAST_NAME AS �����,
       SALARY AS �޿�
     FROM HR.EMPLOYEES 
     WHERE SALARY > (SELECT MAX(SALARY)
                      FROM HR.EMPLOYEES
                      WHERE DEPARTMENT_ID IN(20,40,70));
                      
-----9��--------
SELECT BUY_DATE AS ���Գ�¥,
       BUY_PROD AS ��ǰ��ȣ,
       BUY_QTY AS ���Լ���,
       BUY_QTY*BUY_COST AS ���Աݾ�
       FROM BUYPROD
       WHERE BUY_DATE BETWEEN TO_DATE('20050301') AND LAST_DAY(TO_DATE('20050302'));

-------10��---------
SELECT MEM_ID AS ȸ����ȣ,
       MEM_NAME AS ȸ����,
       MEM_MILEAGE AS ���ϸ���
    FROM MEMBER
    WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) BETWEEN 40 AND 49;
    
SELECT MEM_ID AS ȸ����ȣ,
       MEM_NAME AS ȸ����,
       MEM_MILEAGE AS ���ϸ���,
       EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) AS ����
    FROM MEMBER
    WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR)>=40;
    
-----11��------
SELECT PROD_ID AS ��ǰ�ڵ�,
       PROD_NAME AS ��ǰ��,
       PROD_QTYIN AS �Ǹż���,
       PROD_COST�ݾ�


                                
             
              
              
              
            
        
   
        

