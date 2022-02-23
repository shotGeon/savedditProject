2021-07-28-01)���տ�����
-���տ����ڴ� SELECT���� ����� ������� ������ ����
-������ ���������� ������ ���ϼ� ����
-���� ���� SELECT���� �ϳ��� ���� ���� ����
-UNION ALL, UNION, INTERSECT, MINUS ����
** ���ǻ���
- �� SELECT���� ���� ����, ���� Ÿ���� �÷��� ��ȸ�ؾ� ��
- �� SELECT ������ ���� ���� �÷��� ��ȸ�ϴ� ��� ��� �÷��� ���� ���տ��� ����
- ORDER BY�� ����� �� ������ ���� ������ SELECT�������� ��� ����
- ����� ù ��° SELECT���� ���Ͽ� ���� ��

1) UNION
 .�������� ����� ��ȯ
 .������ �κ��� �ߺ��� ������
 
 ��뿹)������̺��� 'Seattle'�� �ٹ��ϴ� ����� 'IT'�μ��� �ٹ��ϴ� �����
       �����ȣ,�����,�μ���,�������� ��ȸ�Ͻÿ�.
       
       (1)(����A)'Seattle'�� �ٹ��ϴ� ����� �����ȣ,�����,������,������
          SELECT A.EMPLOYEE_ID AS �����ȣ,
                 A.EMP_NAME AS �����,
                 D.CITY AS ������,
                 C.JOB_TITLE AS ������
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B,HR.JOBS C,HR.LOCATIONS D
           WHERE D.CITY='Seattle'
             AND D.LOCATION_ID=B.LOCATION_ID
             AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
             AND A.JOB_ID=C.JOB_ID
           ORDER BY 1;
           
        (2)(����B)'IT'�μ��� �ٹ��ϴ� ����� �����ȣ, �����, ������ȣ�� ���϶�
            SELECT A.EMPLOYEE_ID AS �����ȣ,
                   A.EMP_NAME AS �����,
                   D.CITY AS ������,
                   B.JOB_TITLE AS ������
            FROM HR.EMPLOYEES A,HR.JOBS B,HR.DEPARTMENTS C,HR.LOCATIONS D
            WHERE C.DEPARTMENT_NAME='IT'
              AND C.DEPARTMENT_ID=A.DEPARTMENT_ID
              AND A.JOB_ID=B.JOB_ID
              AND C.LOCATION_ID=D.LOCATION_ID;
              
              
        (3)(���� UNION)
              SELECT A.EMPLOYEE_ID AS �����ȣ,
                 A.EMP_NAME AS �����,
                 D.CITY AS ������,
                 C.JOB_TITLE AS ������
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B,HR.JOBS C,HR.LOCATIONS D
           WHERE D.CITY='Seattle'
             AND D.LOCATION_ID=B.LOCATION_ID
             AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
             AND A.JOB_ID=C.JOB_ID
           UNION
                SELECT A.EMPLOYEE_ID AS �����ȣ,
                   A.EMP_NAME AS �����,
                   D.CITY AS ������,
                   B.JOB_TITLE AS ������
            FROM HR.EMPLOYEES A,HR.JOBS B,HR.DEPARTMENTS C,HR.LOCATIONS D
            WHERE C.DEPARTMENT_NAME='IT'
              AND C.DEPARTMENT_ID=A.DEPARTMENT_ID
              AND A.JOB_ID=B.JOB_ID
              AND C.LOCATION_ID=D.LOCATION_ID
              ORDER BY 1;
              
��뿹) ȸ�����̺��� ���ϸ����� 3000�̻��� ȸ���� ������ �������� ȸ����
       ȸ����ȣ,ȸ����,�ּ�,���ϸ����� ��ȸ�Ͻÿ�.
       SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_ADD1||''||MEM_ADD2 AS �ּ�,
              MEM_MILEAGE AS ���ϸ���
         FROM MEMBER
        WHERE MEM_MILEAGE>=3000
     UNION   
       SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_ADD1||''||MEM_ADD2 AS �ּ�,
              MEM_MILEAGE  AS ���ϸ���                    --TO_NUMBER(MEM_REGNO1) AS �ֹι�ȣ ���δٸ����������� �ߺ��Ǿ� ������
                                                         --������ ��������
         FROM MEMBER
        WHERE MEM_JOB='������';
        
2)UNION ALL
 .�������� ����� ��ȯ
 .������ �κ�(����κ�)�� �ߺ��Ǿ� ���
 
��뿹)ȸ�����̺��� ���ϸ����� 2000�̻��� ȸ���� ������ �ֺ��� ȸ����
       ȸ����ȣ,ȸ����,�ּ�,���ϸ����� ��ȸ�Ͻÿ�.
        SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_ADD1||''||MEM_ADD2 AS �ּ�,
              MEM_MILEAGE AS ���ϸ���
         FROM MEMBER
        WHERE MEM_MILEAGE>=2000
       UNION ALL
         SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_ADD1||''||MEM_ADD2 AS �ּ�,
              MEM_MILEAGE AS ���ϸ���
         FROM MEMBER
        WHERE MEM_JOB='�ֺ�'
        
��뿹)2005�� 4���� 7���� �ȸ� ��ǰ������ ��ȸ�Ͻÿ�
     Alias�� ��ǰ�ڵ�,��ǰ��,�ǸŰ�,�ŷ�ó��
     SELECT DISTINCT A.PROD_ID AS ��ǰ�ڵ�,
            A.PROD_NAME AS ��ǰ��,
            A.PROD_PRICE AS �ǸŰ�,
            B.BUYER_NAME AS �ŷ�ó��
        FROM PROD A,BUYER B,CART C
        WHERE C.CART_PROD=A.PROD_ID                       
          AND  A.PROD_BUYER=B.BUYER_ID
          AND SUBSTR(C.CART_NO,1,6)='200504'
       UNION 
           SELECT A.PROD_ID AS ��ǰ�ڵ�,
            A.PROD_NAME AS ��ǰ��,
            A.PROD_PRICE AS �ǸŰ�,
            B.BUYER_NAME AS �ŷ�ó��
        FROM PROD A,BUYER B,CART C
        WHERE A.PROD_BUYER=B.BUYER_ID
          AND C.CART_PROD=A.PROD_ID
          AND SUBSTR(C.CART_NO,1,6)='200507'
          
          
3)INTERSECT
 .������(����κ�)�� ����� ��ȯ
 
��뿹)2005�� 4���� 7���� ��� �ȸ� ��ǰ������ ��ȸ�Ͻÿ�
     Alias�� ��ǰ�ڵ�,��ǰ��,�ǸŰ�,�ŷ�ó��
      SELECT DISTINCT A.PROD_ID AS ��ǰ�ڵ�,
            A.PROD_NAME AS ��ǰ��,
            A.PROD_PRICE AS �ǸŰ�,
            B.BUYER_NAME AS �ŷ�ó��
        FROM PROD A,BUYER B,CART C
        WHERE C.CART_PROD=A.PROD_ID                       
          AND  A.PROD_BUYER=B.BUYER_ID
          AND C.CART_NO LIKE '200504%'
    INTERSECT
     SELECT A.PROD_ID AS ��ǰ�ڵ�,
            A.PROD_NAME AS ��ǰ��,
            A.PROD_PRICE AS �ǸŰ�,
            B.BUYER_NAME AS �ŷ�ó��
        FROM PROD A,BUYER B,CART C
        WHERE A.PROD_BUYER=B.BUYER_ID
          AND C.CART_PROD=A.PROD_ID
          AND SUBSTR(C.CART_NO,1,6)='200507';
          
��뿹) �μ����� 'shipping'�� ���� ��� �� 'Mattew Weiss'����� ���� �Ҽӵ� ����� 
       ��ȸ�Ͻÿ� (�����ȣ,�����,�μ���,�Ի���,�޿�)
       SELECT A.EMPLOYEE_ID AS �����ȣ,
              A.EMP_NAME AS �����,
              B.DEPARTMENT_NAME AS �μ���,
              A.HIRE_DATE AS �Ի���,
              A.SALARY AS �޿�
        FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          AND B.DEPARTMENT_NAME='Shipping'
    INTERSECT
    SELECT A.EMPLOYEE_ID AS �����ȣ,
              A.EMP_NAME AS �����,
              B.DEPARTMENT_NAME AS �μ���,
              A.HIRE_DATE AS �Ի���,
              A.SALARY AS �޿�
        FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          AND A.MANAGER_ID=(SELECT EMPLOYEE_ID
            FROM HR.EMPLOYEES
            WHERE EMP_NAME= 'Matthew Weiss');
         
         
4)MINUS
 .MINUS ������ �տ� ��ġ�� ������ ������� MINUS �ڿ� ����� ������ �����
  ������ ��� ��ȯ
  
 ��뿹) ��ٱ������̺��� 4���� 5���� �Ǹŵ� ��ǰ �� 4���� �Ǹŵ� ��ǰ�� ��ǰ��ȣ, ��ǰ��,
        �����հ�, �Ǹűݾ��հ踦 ���Ͻÿ�.--���������̱⶧���� ��� ���̺��� ����ص� �������.
        SELECT DISTINCT A.CART_PROD AS ��ǰ��ȣ, 
               B.PROD_NAME AS ��ǰ��
--               SUM(A.CART_QTY) AS �����հ�,
--               SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
          FROM CART A,PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200504%'
--            GROUP BY A.CART_PROD,B.PROD_NAME;
     MINUS
          SELECT DISTINCT A.CART_PROD AS ��ǰ��ȣ, 
               B.PROD_NAME AS ��ǰ��
--               SUM(A.CART_QTY) AS �����հ�,
--               SUM(A.CART_QTY*B.PROD_PRICE) AS �Ǹűݾ��հ�
          FROM CART A,PROD B
          WHERE A.CART_PROD=B.PROD_ID
            AND A.CART_NO LIKE '200507%'
--            GROUP BY A.CART_PROD,B.PROD_NAME;
         
         
         
         
         
          