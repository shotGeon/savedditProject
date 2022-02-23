��Ÿ������: (IN, ANY, SOME, ALL, EXISTS, BETWEEN(���������Ҷ�)_, LIKE(������ ���Ҷ�)�� ����)
     --IN,ANY,SOME,ALL,EXISTS�� ���������Ͱ� �ϳ��̻� �����ؾ��Ѵ�.
     
     1.IN--���������� �ұ�Ģ�� �����͸� ���Ҷ� ����Ѵ�,
     -�־��� �� �� ��� �ϳ��� ��ġ�ϸ� TRUE�� ��ȯ
     -OR �����ڷ� ġȯ ����
     -NOT �����ڿ� �Բ� ��밡��
     (�������)
    expr IN(��1[,��2,....)
    
**������̺��� EMP_NAME VARCHAR(80) �÷��� �߰�
--ALTER TABLE ���̺��
--ADD(�÷��� ������ Ÿ��[(ũ��)] [DEFAULT �ʱⰪ)]
  ALTER TABLE HR.EMPLOYEES 
         ADD(EMP_NAME VARCHAR(80));
  COMMIT;
         
 **FIRST_NAME�� LAST_NAME�� ���� EMP_NAME�� ����
 UPDATE HR.EMPLOYEES 
    SET EMP_NAME=FIRST_NAME||' '||LAST_NAME;
    COMMIT;
         
 **�÷��� �̸��� �����Ҷ�
 ALTER TABLE ���̺�� RENAME COLUMN �����÷��� TO ���ο��÷���;
 **�÷��� �����Ҷ�
 ALTER TABLE ���̺�� DROP COLUMN �÷���;
 **�÷��� Ÿ���� �����Ҷ�
 ALTER TABLE ���̺�� 
         MODIFY(�÷��� ������ Ÿ��[(ũ��)] [DEFAULT �ʱⰪ)]--���� �ٲ� Ÿ�Ը� ������ �ȴ�.

��뿹)������̺��� 10,30,40,60�� �μ��� ���� ������� �����ȣ,�����,�μ��ڵ�,�Ի����� ��ȸ�Ͻÿ�
    (OR ������ ���)
    SELECT EMPLOYEE_ID AS �����ȣ, 
           EMP_NAME AS �����, 
           DEPARTMENT_ID AS �μ��ڵ�, 
           HIRE_DATE AS �Ի���
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=10
           OR DEPARTMENT_ID=30
           OR DEPARTMENT_ID=40
           OR DEPARTMENT_ID=60
           ORDER BY 3;
           
    (IN ������ ���)
    SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����,
           DEPARTMENT_ID AS �μ��ڵ�,
           HIRE_DATE AS �Ի���
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID IN(10,30,40,60);
        
    (ANY ������ ���=SOME������ ����)
    SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����,
           DEPARTMENT_ID AS �μ��ڵ�,
           HIRE_DATE AS �Ի���
        FROM HR.EMPLOYEES
        WHERE DEPARTMENT_ID=ANY(10,30,40,60);
  
     (2)ALL
     .( )�ȿ� �־��� ������ ��� �����ؾ� ����� ��(TRUE)�� ��
     . AND�� ġȯ ����
     (�������)
        �÷��� ���迬����ALL[��1[,��,....]]
     (��뿹)������̺��� 20,40,70�� �μ��� ���� ������� �޿����� �޿��� ���� ����� �����ȣ, �����,
            �޿��� ��ȸ�Ͻÿ�.
            
            SELECT EMPLOYEE_ID AS �����ȣ,
                   EMP_NAME AS �����,
                   SALARY AS �޿�
                   FROM HR.EMPLOYEES
                WHERE SALARY >ALL(SELECT SALARY
                                    FROM HR.EMPLOYEES
                                    WHERE DEPARTMENT_ID IN(20,40,70));
                (WHERE SALARY >(SELECT MAX(SALARY) ---����QUERY�� ����,����GROUP BY�� ����Ҷ� ���
                                    FROM HR.EMPLOYEES
                                    WHERE DEPARTMENT_ID IN(20,40,70));)
                    
      (3)BETWEEN -AND --��¥���ٴ� LIKE���� BETWEEN�� ����
      . ������ �����Ͽ� ���� ��ȸ�ϴ� ���ǹ� ������ ���
      . �� ������ 'AND'�� ġȯ ����
      
      
��뿹)�����������̺�(BUYPROD)���� 2005�� 3�� ������Ȳ�� Ǯ���Ͻÿ�
     (AND������ ���)
     
       SELECT BUY_DATE AS ��¥, 
              BUY_PROD AS ��ǰ�ڵ�, 
              BUY_QTY AS ���Լ���, 
              BUY_QTY*BUY_COST AS ���Աݾ�
        FROM BUYPROD
        WHERE BUY_DATE >=TO_DATE('20050301')
          AND BUY_DATE <=LAST_DAY(TO_DATE('20050301'));
          
       (BETWEEN������ ���)
       
       SELECT BUY_DATE AS ��¥,
              BUY_PROD AS ��ǰ�ڵ�,
              BUY_QTY AS ���Լ���,
              BUY_QTY*BUY_COST AS ���Աݾ�
          FROM BUYPROD
          WHERE BUY_DATE BETWEEN TO_DATE('20050301') AND LAST_DAY(TO_DATE('20050302'));
          
        
        --ȸ�����̺��� 40�� ȸ���� ȸ����ȣ,ȸ����,���ϸ����� ��ȸ�Ͻÿ�    
       SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����, 
               MEM_MILEAGE AS ���ϸ���
            FROM MEMBER     
            WHERE EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM MEM_BIR) BETWEEN 40 AND 49; --EXTRACT�� ��¥����
        --ȸ���� ������� �÷����� ���� �����Ͻÿ�   
           SELECT EXTRACT(MONTH FROM MEM_BIR); 
        --ȸ�����̺��� �̹��޿� ������ �ִ� ȸ���� ȸ����ȣ,ȸ����
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
             FROM MEMBER
             WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR);
             
        ��뿹)�з����̺�(PROD)���� �з��ڵ尡P2�� �����ϴ� ��ǰ�� ���Ͽ� 2005�� 5�� ��������� ��ȸ�Ͻÿ�
             ��ǰ�ڵ�,��ǰ��,�Ǹż���,�ݾ�
           SELECT A.PID AS ��ǰ�ڵ�,
                  A.PNAME AS ��ǰ��,
                  LPROD_GU AS �з��ڵ�,
                  LPROD_NM AS �з���,
                  A.QANT AS �Ǹż���,
                  A.MANT AS �ݾ�
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
               
            