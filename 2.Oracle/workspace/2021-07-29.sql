2021-0729-01)������(RANK �Լ�)
- ����, �޿�, ���� ���� ������ ���Ҷ� ���
- ORDER BY���� ROWNUM�ǻ� �÷��� ����Ŭ�� WHERE���� ORDER BY���� ����
  ���������� ��Ȯ�� ��� ��ȯ�� �Ұ��� ��
- �̸� �ذ��ϱ� ���� RANK�� DENSE_RANK �Լ� ����
- RANK�� DENSE_RANK �Լ��� ������
 . RANK : �ߺ� ������ �߻��ϸ� �ߺ� ���� ��ŭ ���� �������� ����(ex 1,1,1,4,5..)
 . DENSE_RANK : �ߺ� ������ �߻��ص� ���� ������ �������� ���� ����(ex 1,1,1,2,3,4...)
 . ROW_NUMBER : �ߺ��� ������� ���� ������ ����(ex 1,2,3,4,5,..)
-SELECT ������ ���!!!!!!!!!!!!
(�������)
  SELECT �÷�list,
         RANK() OVER(ORDER BY �����÷��� DESC|ASC) AS �÷���Ī,
              :
     FROM ���̺��;
     
     
��뿹) ȸ�����̺��� ���ϸ����� ���� ȸ������ ���ʴ�� ����(���)�� �ο��Ͻÿ�
       ȸ����ȣ, ȸ����, ���ϸ���, ���
       
       SELECT MEM_ID AS ȸ����ȣ, 
              MEM_NAME AS ȸ����,
              MEM_MILEAGE AS ���ϸ���,
              RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS ���
          FROM MEMBER;

��뿹) ȸ�����̺��� ���ϸ����� ���� ȸ������ ���ʴ�� ����(���)�� �ο��ϰ� ���� 5����
       ȸ����ȣ, ȸ����, ���ϸ���, ���
       
       SELECT B.MID AS ȸ����ȣ, 
              A.MEM_NAME AS ȸ����,
              A.MEM_MILEAGE AS ���ϸ���,
              B.MLR AS ���
          FROM (SELECT MEM_ID AS MID,
                       RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS MLR
                       FROM MEMBER)B,MEMBER A
          WHERE A.MEM_ID=B.MID
            AND B.MLR<=5
            ORDER BY 4 ASC;
            
��뿹)��ٱ��� ���̺��� 2005�� 5�� ���űݾ��� ���� ȸ������ ������ �ο��Ͽ�
     ȸ����ȣ, ȸ����, ���űݾ�, ������ ����Ͻÿ�
     SELECT A.CART_MEMBER AS ȸ����ȣ,
            C.MEM_NAME AS ȸ����,
            SUM(A.CART_QTY*D.PROD_PRICE) AS ���űݾ�,
            RANK()OVER(ORDER BY B.SCP DESC) AS ����
       FROM CART A,(SELECT A.CART_MEMBER AS CMM,
                     SUM(A.CART_QTY*B.PROD_PRICE) AS SCP
                    FROM CART A,PROD B
                    GROUP BY A.CART_MEMBER) B,
       MEMBER C, PROD D
       WHERE A.CART_MEMBER=B.CMM
         AND A.CART_PROD=D.PROD_ID
         AND A.CART_NO LIKE '200505%'
         GROUP BY A.CART_MEMBER, C.MEM_NAME 
         ORDER BY 1;
         
         SELECT A.CART_MEMBER AS ȸ����ȣ,
                C.MEM_NAME AS ȸ����,
                SUM(A.CART_QTY*B.PROD_PRICE) AS ���űݾ�,
                RANK() OVER(ORDER BY SUM(A.CART_QTY*B.PROD_PRICE)DESC) AS ����
            FROM CART A,PROD B, MEMBER C
           WHERE A.CART_MEMBER=C.MEM_ID
             AND A.CART_PROD=B.PROD_ID
             AND A.CART_NO LIKE '200505%'
             GROUP BY A.CART_MEMBER,C.MEM_NAME;
             
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_MILEAGE AS ���ϸ���,
               DENSE_RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS ���
            FROM MEMBER;
         
         
         
         
         
         
         
         
         
         
         
         



























