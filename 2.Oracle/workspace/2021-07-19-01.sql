2021-07-19-01)

2.AVG(expr)
 .'expr'�� ���ǵ� �÷��̳� ������ ���� ���� ������ ���� ��ȯ
 
��뿹)��� ����ȸ������ ��� ���ϸ����� ��ȸ�Ͻÿ�
SELECT ROUND(AVG(MEM_MILEAGE))
   FROM MEMBER
   WHERE SUBSTR(MEM_REGNO2,1,1) IN('2','4');
   
   
   
��뿹)ȸ������ ���� ��� ���ϸ����� ��ȸ�Ͻÿ� 

SELECT  CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2'
             OR   SUBSTR(MEM_REGNO2,1,1)='4' THEN
                '����ȸ��'
             ELSE
                 '����ȸ��' END AS ����,
      ROUND(AVG(MEM_MILEAGE)) AS ��ո��ϸ���
      FROM MEMBER
      GROUP BY   SUBSTR(MEM_REGNO2,1,1);
   
��뿹) ������̺��� �� �μ��� ��ձ޿��� ��ȸ�Ͻÿ�

     SELECT B.DEPARTMENT_ID AS �μ��ڵ�,
            B.DEPARTMENT_NAME AS �μ���,
            ROUND(AVG(A.SALARY)) AS ��ձ޿�
        FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
        WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        GROUP BY B.DEPARTMENT_ID,B.DEPARTMENT_NAME
        ORDER BY 1;
        
��뿹) 2005�� 1~6�� ���� ��� ���Ծ��� ��ȸ�Ͻÿ�
      SELECT EXTRACT(MONTH FROM BUY_DATE)||'��' AS ��,
            ROUND(AVG(BUY_QTY*BUY_COST)) AS "��� ���Ծ�"
            FROM BUYPROD
            WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050630')
            GROUP BY EXTRACT(MONTH FROM BUY_DATE)
            ORDER BY 1;
            
��뿹) 2005�� 1~6�� ���� ��� ���Ծװ� ���Ծ����� ��ȸ�ϵ� ���Ծ��� 400�����̻��� ���� ��ȸ�Ͻÿ�

      SELECT EXTRACT(MONTH FROM BUY_DATE)||'��' AS ��,
             COUNT(*) AS ���԰Ǽ�,
             ROUND(AVG(BUY_QTY*BUY_COST)) AS "��� ���Ծ�",
             SUM(BUY_QTY*BUY_COST) AS ���Ծ���
             FROM BUYPROD
             WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050630')
             GROUP BY EXTRACT(MONTH FROM BUY_DATE)
             HAVING AVG(BUY_QTY*BUY_COST)>=4000000
             ORDER BY 1;
             
��뿹) 2005�� �з��� ��ձ��űݾ��� ��ȸ�Ͻÿ�.

       SELECT    C.LPROD_GU AS �з��ڵ�,
                C.LPROD_NM AS �з���,
       ROUND(AVG(B.PROD_PRICE*A.CART_QTY)) AS ��ո��Աݾ�
       FROM CART A,PROD B,LPROD C
       WHERE SUBSTR(A.CART_NO,1,4)='2005'
             AND C.LPROD_GU=B.PROD_LGU
       GROUP BY C.LPROD_GU,C.LPROD_NM ; 
       
       
       
       
��뿹) 2005�� ȸ���� ���ɴ뺰 ��ձ��űݾ��� ��ȸ�Ͻÿ�.
      SELECT TRUNC((EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM A.MEM_BIR))/10)*10||'��' AS ���ɴ�, 
             ROUND(AVG(B.PROD_PRICE*C.CART_QTY)) AS ��ձ��űݾ�
      FROM MEMBER A,PROD B, CART C
      WHERE     C.CART_PROD=B.PROD_ID
            AND C.CART_MEMBER=A.MEM_ID
            AND C.CART_NO LIKE '2005%'
      GROUP BY TRUNC((EXTRACT(YEAR FROM SYSDATE)-EXTRACT(YEAR FROM A.MEM_BIR))/10)*10
      ORDER BY 1;
 
��뿹)����� �� �ڱⰡ ���� �μ��� ��� �޿����� ���� �޿��� �޴� ���������� ��ȸ�Ͻÿ�
     Alias�� �����ȣ,�����,�μ���ȣ,�μ���,�޿�,�μ���ձ޿� 
     
     ��������:2021�� 7�� 31�ϱ���
     ������:����� PC ���������� ����(SEM-PC D:\��������\oracle\homework1)
     ����Ÿ�� :�޸��忡�� ����� TEXT����
     ������:�����̸�_0731.TXT
     
3. COUNT(column��|*)
 . �׷쳻�� ���� ��(�ڷ��� ����)�� ��ȯ
 . �ܺ����ο��꿡 ���Ǵ� ��� '*'�� ����ϸ� ����Ȯ�� ����� ��ȯ�ϱ� ������ 
   �ش� ���̺��� �÷����� ����ؾ� ��
   
��뿹)������̺��� �� �μ��� ������� ��ȸ�Ͻÿ�
      SELECT DEPARTMENT_ID AS �μ��ڵ�, 
             COUNT(*) AS �����1,
             COUNT(LAST_NAME) AS �����2
         FROM HR.EMPLOYEES
         GROUP BY DEPARTMENT_ID
         ORDER BY 1;
         
         
           SELECT DEPARTMENT_ID AS �μ��ڵ�, 
             COUNT(*) AS �����1,
             COUNT(LAST_NAME) AS �����2
         FROM HR.EMPLOYEES
         GROUP BY ROLLUP(DEPARTMENT_ID)
         ORDER BY 1;
         
��뿹)2005�� 5�� �з��� �ǸŰǼ��� ��ȸ�Ͻÿ�
    SELECT B.PROD_LGU AS �з��ڵ�,
           COUNT(*) AS �ǸŰǼ�
         FROM CART A, PROD B
        WHERE A.CART_PROD=B.PROD_ID
          AND A.CART_NO LIKE '200505%'
        GROUP BY B.PROD_LGU
        ORDER BY 1;

��뿹)2005�� 5~6�� ȸ���� ����Ƚ���� ��ȸ�Ͻÿ�
     Alias�� ȸ����ȣ, ����Ƚ��
     
     SELECT A.CID AS ȸ����ȣ,
            COUNT(*) AS ����Ƚ��
        FROM (SELECT DISTINCT CART_NO AS CNO,
                     CART_MEMBER AS CID
                FROM CART
                WHERE SUBSTR(CART_NO,1,6) IN('200505','200506')
                ORDER BY 2) A
         GROUP BY A.CID
         ORDER BY 1;

��뿹)��� �μ��� ������� ��ȸ�Ͻÿ�(NULL�μ��ڵ�� �����Ѵ�.)
     SELECT B.DEPARTMENT_ID AS �μ��ڵ�, 
            B.DEPARTMENT_NAME AS �μ���,
             COUNT(EMPLOYEE_ID) AS �����--*���� �÷��������� �ټ��� �����ʰ� 0���� ��Ÿ����.(�ܺ����� ��� �ݵ�� �÷��� �ۼ�)
         FROM HR.EMPLOYEES A,HR.DEPARTMENTS B--�ܺ������� ������ ������ ���� ���̺��� ����.�ȱ׷� �ΰ��� ����.
         WHERE A.DEPARTMENT_ID(+)=B.DEPARTMENT_ID--(+)�ܺ����ο�����(A���̺��� Ȯ���ؼ� B���̺�� �����϶�� ���̴�.)
         GROUP BY B.DEPARTMENT_ID,B.DEPARTMENT_NAME
         ORDER BY 1;
         
         




