2021-0723-01)
4.SELF JOIN
-�ϳ��� ���̺� ���� �ٸ� ��Ī�� �ο��Ͽ� �����ϴ� ����
��뿹)�ŷ�ó '������'�� ������ ����(�����õ�)�� �����ϰ� �ִ� �ŷ�ó ������ 
      ��ȸ�Ͻÿ�.
      Alias�� �ŷ�ó�ڵ�, ��äó��, �ּ�, ������̴�.
      SELECT B.BUYER_ID AS �ŷ�ó�ڵ�,
             B.BUYER_NAME AS ��äó��,
             B.BUYER_ADD1||''||B.BUYER_ADD2 AS �ּ�,
             B.BUYER_CHARGER AS �����
        FROM BUYER A, BUYER B
        WHERE A.BUYER_NAME='������'
          AND SUBSTR(A.BUYER_ADD1,1,2)=SUBSTR(B.BUYER_ADD1,1,2);
          
��뿹)�����ȣ 108���� ����� ���� �μ��� ���� ����� �����ȣ,�����,�μ���,�����ڵ带
      ��ȸ�Ͻÿ�
      SELECT B.EMPLOYEE_ID AS �����ȣ,
             B.EMP_NAME AS �����,
             C.DEPARTMENT_NAME AS �μ��ڵ�,
             B.JOB_ID AS �����ڵ�
      FROM HR.EMPLOYEES A,HR.EMPLOYEES B,HR.DEPARTMENTS C
      WHERE A.EMPLOYEE_ID=108
        AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
        AND A.DEPARTMENT_ID=C.DEPARTMENT_ID;
5.�ܺ�����(OUTER JOIN)
 -���������� ���������� �����ϴ� �����͸� �������� ����� ��ȯ
 -�ܺ������� ���������� �������� ���ϴ� �����͸� �������� ������ ���̺�
  NULL ������ ä���� ���� �����Ͽ� ���� ����
 -������ �����͸� ������ �ִ� ���̺� ���� ���̸� ������ '(+)'�����ڸ� �߰���
 -���� ���������� �ܺ������� ����Ǿ�� �ϴ� ��� ���'(+)'�����ڸ� ����ؾ� ��
 -���ÿ� �� ���̺� �������� '(+)'�����ڸ� ����� �� ����. ��, A,B,C���̺���
  �ܺ����ο� ������ �� A�� �������� B�� Ȯ���԰� ���ÿ� C�� �������� B�� 
  Ȯ���� �� ����(WHERE A=B(+) AND C=B(+)=>���ȵ�)
 -�Ϲ� �ܺ������� ��� �Ϲ������� ���Ǹ� �������� ����� ��ȯ(�ذ��� : ANSI
  �ܺ����� �Ǵ� �������� ���)
 -�ܺ������� ����� ó���ӵ��� ���ϸ� ����
 
 (�Ϲݿܺ����� �������)
   SELECT �÷�list
    FROM ���̺��1, ���̺��2[,���̺��3,....]
   WHERE ���̺��1.�÷���[(+)]=���̺��2.�÷���[(+)]
   
   .���� ��� ������ �ܺ������� ���ȵ�( WHERE A.COL(+)=B.COL(+))
   
   (ANSI�ܺ����� �������)
   SELECT �÷�list
    FROM ���̺��1
   LEFT|RIGHT\FULL OUTER JOIN ���̺��2 ON(��������1 [AND �Ϲ�����1])
  [LEFT|RIGHT\FULL OUTER JOIN ���̺��2 ON(��������1 [AND �Ϲ�����1])]
   
  [WHERE �Ϲ�����n]
 .���̺��1�� ���̺��2�� �ݵ�� ���� ���� �Ұ�
 .�Ϲ�����1�� ���̺��1 �Ǵ� ���̺��2�� ���ѵ� ����
 .�Ϲ�����n�� ��ü ���̺� ����Ǵ� �������� ������ ��� ���� �� �� �����
 .LEFT|RIGHT\FULL : ���̺��1�� ������ ������ �� ���� ��� LEFT, �ݴ��� ���
  RIGHT, ���� ��� ������ ��� FULL ���
  
��뿹)2005�� 1�� ���(OUTER) ��ǰ�� ������Ȳ�� ��ȸ�Ͻÿ�.
      ����� �÷��� ��ǰ�ڵ�,��ǰ��,���Լ���,���Աݾ��̴�.
      
      SELECT B.PROD_ID AS ��ǰ�ڵ�, --���ʿ� ���ÿ� �����ϴ� �÷��� ��쿡 �����ʰŸ� ���
             B.PROD_NAME AS ��ǰ��,
             NVL(SUM(A.BUY_QTY),0) AS ���Լ���,
             NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS ���Աݾ�
      FROM BUYPROD A,PROD B
      WHERE A.BUY_PROD(+)=B.PROD_ID
      AND BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
      GROUP BY B.PROD_ID,B.PROD_NAME
      ORDER BY 1;
      
      SELECT B.PROD_ID AS ��ǰ�ڵ�, 
             B.PROD_NAME AS ��ǰ��,
             NVL(SUM(A.BUY_QTY),0) AS ���Լ���,
             NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS ���Աݾ�
      FROM BUYPROD A
      RIGHT OUTER JOIN PROD B ON(A.BUY_PROD=B.PROD_ID 
      AND BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131'))
      GROUP BY B.PROD_ID,B.PROD_NAME
      ORDER BY 1;
      
      ��������+�Ϲݿܺ�����
      SELECT B.PROD_ID AS ��ǰ�ڵ�,
              B.PROD_NAME AS ��ǰ��,
              NVL(A.BPO,0) AS ���Լ���,
              NVL(A.BDT,0) AS ���Աݾ�
    FROM PROD B, (SELECT BUY_PROD AS BPD, 
                       SUM(BUY_QTY) AS BPO,
                       SUM(BUY_QTY*BUY_COST)AS BDT
                       FROM BUYPROD 
                       WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                       GROUP BY BUY_PROD) A
                  WHERE B.PROD_ID=A.BPD(+) 
                  ORDER BY 1;
                  
��뿹) ��� �μ��� ������� ��ȸ�Ͻÿ�.

    SELECT LPAD(NVL(TO_CHAR(B.DEPARTMENT_ID),'����'),4) AS �μ��ڵ�,
           NVL(B.DEPARTMENT_NAME,'����') AS �μ���,
           COUNT(A.EMPLOYEE_ID) AS �����
    FROM  HR.EMPLOYEES A 
    FULL OUTER JOIN HR.DEPARTMENTS B ON(A.DEPARTMENT_ID=B.DEPARTMENT_ID)
    GROUP BY  B.DEPARTMENT_ID,B.DEPARTMENT_NAME
    ORDER BY 1;
    
��뿹)2005�� 4�� ��� ��ǰ�� ���� �Ǹ���Ȳ�� ��ȸ�Ͻÿ�
     ����� ������ ��ǰ�ڵ�, ��ǰ��, �Ǹż���, �Ǹűݾ��̴�.
     
     SELECT B.PROD_ID AS ��ǰ�ڵ�,
            B.PROD_NAME AS ��ǰ��,
            NVL(SUM(A.CART_QTY),0) AS �Ǹż���,
            NVL(SUM(A.CART_QTY*B.PROD_PRICE),0) AS �Ǹűݾ�
     FROM CART A
     RIGHT OUTER JOIN PROD B ON(A.CART_PROD=B.PROD_ID
     AND CART_NO LIKE '200504%')
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
     
     ��뿹)2005�� 4�� ��� ��ǰ�� ���� ������Ȳ�� �Ǹ���Ȳ�� ��ȸ�Ͻÿ�
     ����� ������ ��ǰ�ڵ�, ��ǰ��, ���Լ���, ���Աݾ�, �Ǹż���, �Ǹűݾ��̴�.
     
      SELECT B.PROD_ID AS ��ǰ�ڵ�,
            B.PROD_NAME AS ��ǰ��,
            NVL(SUM(A.CART_QTY),0) AS �Ǹż���,
            NVL(SUM(A.CART_QTY*C.PROD_PRICE),0) AS �Ǹűݾ�,
            NVL(SUM(B.BUY_QTY),0) AS ���Լ���,
            NVL(SUM(B.BUY_QTY*C.PROD_PRICE),0) AS ���Աݾ�
     FROM CART A 
     RIGHT OUTER JOIN PROD C ON(A.CART_PROD=C.PROD_ID)
     LEFT OUTER JOIN BUYPROD B ON(B.BUY_PROD=C.PROD_ID
     AND CART_NO LIKE '200504%')
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
  