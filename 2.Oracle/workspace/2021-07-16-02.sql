2021-0716-02)�����Լ�
-�־��� �ڷḦ Ư�� �÷��� �������� �׷����� ������ �� �׷캰�� �ڷῡ ���� ���踦 ��ȯ�ϴ� �Լ�
-SUM, AVG, COUNT, MIN, MAX
(�������)
SELECT [�÷�list],
       SUM|AVG|MIN|MAX(expr)|COUNT(colum|*),
                  :
    FROM ���̺��
  [WHERE ����]
  [GROUP BY �÷���[,�÷���,...]]--SELECT������ �����Լ��� ������� ���� �÷����� ����� �Ѵ�.(���ʺ��� ��׷������ �ۼ�)
  [HAVING ����]
   [ORDER BY �÷���|�÷��ε���[ASC|DESC],...];
   
1.SUM(expr)
 .'expr'�� ǥ���Ǵ� ���� �Ǵ� �÷��� ���� ���� �հ踦 ��ȯ
 
��뿹) ������̺��� �μ��� �޿� �հ踦 ���Ͻÿ�
     SELECT DEPARTMENT_ID AS �μ��ڵ�,
            SUM(SALARY)  AS �޿��հ�      
        FROM HR.EMPLOYEES
       GROUP BY DEPARTMENT_ID
       ORDER BY 1;
��뿹) ������̺��� �μ��� �޿� �հ踦 ���ϵ� 10000�̻��� �μ��� ���Ͻÿ�

    SELECT DEPARTMENT_ID AS �μ��ڵ�,
            SUM(SALARY)  AS �޿��հ�      
        FROM HR.EMPLOYEES
       GROUP BY DEPARTMENT_ID
       HAVING SUM(SALARY)>=10000
       ORDER BY 1 DESC;
       
��뿹) 2005�� 5�� ȸ���� ������Ȳ(ȸ����ȣ,���ż����հ�,���űݾ��հ�)�� ��ȸ�Ͻÿ�

  SELECT A.CART_MEMBER AS ȸ����ȣ,
         SUM(A.CART_QTY) AS ���ż����հ�,
         SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ��հ�
         FROM CART A, PROD B
         WHERE A.CART_PROD=B.PROD_ID AND  A.CART_NO LIKE '200505%'
       GROUP BY A.CART_MEMBER;
     
 ��뿹) 2005�� ���� ȸ���� ������Ȳ(��,ȸ����ȣ,���ż����հ�,���űݾ��հ�)�� ��ȸ�Ͻÿ�
 
  
  SELECT SUBSTR(A.CART_NO,5,2) AS "��",       
                A.CART_MEMBER AS ȸ����ȣ,
                SUM(A.CART_QTY) AS ���ż����հ�,
                SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ��հ�
                FROM CART A, PROD B
                WHERE A.CART_PROD=B.PROD_ID 
                AND SUBSTR(A.CART_NO,1,4)='2005'
       GROUP BY SUBSTR(A.CART_NO,5,2),A.CART_MEMBER
       ORDER BY 1;
       
  ��뿹) ȸ�����̺��� ������ ���ϸ��� �հ踦 ���Ͻÿ�  
     SELECT MEM_JOB  AS ����,
            SUM(MEM_MILEAGE) AS "���ϸ��� �հ�"
            FROM MEMBER
            GROUP BY MEM_JOB
            ORDER BY SUM(MEM_MILEAGE)DESC;
 
 ����]������̺��� �ٹ������� �޿��հ踦 ���Ͻÿ�.
 
 
SELECT C.COUNTRY_ID AS "�ٹ������ڵ�",
       D.COUNTRY_NAME AS "�ٹ�������",
       COUNT(*) AS �����,
       TO_CHAR(SUM(A.SALARY),'999,990') AS "�޿��հ�"
FROM EMPLOYEES A, DEPARTMENTS B,LOCATIONS C,COUNTRIES D
WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID 
  AND B.LOCATION_ID=C.LOCATION_ID 
  AND C.COUNTRY_ID=D.COUNTRY_ID
GROUP BY C.COUNTRY_ID, D.COUNTRY_NAME;


��뿹) ������̺��� �� �μ��� ���ʽ� �հ踦 ���Ͻÿ�(�μ��ڵ�, �μ���, ���ʽ� �հ�)(���ʽ��� ��������(COMMISSION_PCT)�� �޿��� ���Ѱ���� 30%
       SELECT A.DEPARTMENT_ID AS �μ��ڵ�,
              A.DEPARTMENT_NAME AS �μ���,
              NVL(SUM(B.COMMISSION_PCT*B.SALARY)*0.3,0) AS "���ʽ� �հ�"--NVL�ΰ������� ����� �ٲٴ� �Լ��̴�.
        FROM DEPARTMENTS A,EMPLOYEES B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
        ORDER BY 1;
        
        UPDATE EMPLOYEES
        SET COMMISSION_PCT=0.2
        WHERE EMPLOYEE_ID=107;
COMMIT;
 
 
 
 
 
 
 
 
 
 
 
 
 
  
 
 