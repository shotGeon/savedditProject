2021-0720-01)
 4.MAX(column��), MIN(column��)
  .MAX : �־��� �÷��� �� �ִ� ���� ��ȯ
  .MIN : �־��� �÷��� �� �ּ� ���� ��ȯ
  .�����Լ��� �ٸ� �����Լ��� ���� �� �� ����.
  
��뿹)2005�� ���� ���Ծ� �� �ִ� ������ǰ�� �ּ� ������ǰ�� 
       ��,�ִ���Ծ�,�ּҸ��Ծ�
      SELECT EXTRACT(MONTH FROM BUY_DATE)||'��' AS ��,
             MAX(BUY_QTY*BUY_COST) AS �ִ���Ծ�,
             MIN(BUY_QTY*BUY_COST) AS �ּҸ��Ծ�
       FROM BUYPROD
       WHERE EXTRACT(YEAR FROM BUY_DATE)=2005
       GROUP BY EXTRACT(MONTH FROM BUY_DATE);
       
       
��뿹)2005�� 5�� �ִ뱸�� �������� ��ȸ�Ͻÿ�
     Alias�� ȸ����ȣ, ȸ����, ���űݾ�
     SELECT A.CART_MEMBER AS ȸ����ȣ,
            B.MEM_NAME AS ȸ����,
            SUM(A.CART_QTY*C.PROD_PRICE) AS ���űݾ�
     FROM CART A,MEMBER B, PROD C
     WHERE A.CART_MEMBER=B.MEM_ID 
     AND A.CART_PROD=C.PROD_ID 
     AND A.CART_NO LIKE ('200505%')
    GROUP BY A.CART_MEMBER,B.MEM_NAME
   ORDER BY 3 DESC;
   
   (SUBQUARY)
   SELECT D.MID AS ȸ����ȣ,
          D.MNAME AS ȸ����,
          E.MEM_ADD1||' '||MEM_ADD2 AS �ּ�,
          E.MEM_HP AS ����ó,
          D.AMT AS ���űݾ�
     FROM (SELECT A.CART_MEMBER AS MID,
                  B.MEM_NAME AS MNAME,
                  SUM(A.CART_QTY*C.PROD_PRICE) AS AMT
            FROM CART A,MEMBER B, PROD C
            WHERE A.CART_MEMBER=B.MEM_ID 
            AND A.CART_PROD=C.PROD_ID 
            AND A.CART_NO LIKE '200505%'
            GROUP BY A.CART_MEMBER,B.MEM_NAME
            ORDER BY 3 DESC) D, MEMBER E
         WHERE D.MID=E.MEM_ID
           AND ROWNUM=1;
     