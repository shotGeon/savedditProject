2021-07-27-02)

��뿹)ȸ�����̺��� ��ո��ϸ������� ���� ���ϸ����� ������ ȸ���� ȸ����ȣ,ȸ����
      ���ϸ����� ����Ͻÿ�
      
     SELECT MEM_ID AS ȸ����ȣ,
            MEM_NAME AS ȸ����,
            MEM_MILEAGE AS ���ϸ���,
            (SELECT ROUND(AVG(MEM_MILEAGE))
               FROM MEMBER)AS ��ո��ϸ���
           FROM MEMBER
         WHERE MEM_MILEAGE>=(SELECT ROUND(AVG(MEM_MILEAGE))
                             FROM MEMBER);
            
     SELECT MEM_ID AS ȸ����ȣ,
            MEM_NAME AS ȸ����,
            MEM_MILEAGE AS ���ϸ���,
            A.AMILE AS ��ո��ϸ���
        FROM MEMBER,(SELECT ROUND(AVG(MEM_MILEAGE))AS AMILE
               FROM MEMBER)A 
            WHERE MEM_MILEAGE>=A.AMILE;
            
��뿹)ȸ������ �ڷῡ�� ���� ��ո��ϸ����� ���ϰ� �ڽ��� ���� ��ո��ϸ������� ���� ���ϸ����� ������ ȸ����
      2005�� 4~6�� ������Ȳ�� ��ȸ�Ͻÿ�
      Alias�� ȸ����ȣ,ȸ����,���űݾ��հ�
      SELECT  CART_MEMBER AS ȸ����ȣ,
              TBLB.CNAME AS ȸ����,
              SUM(B.CART_QTY*C.PROD_PRICE) AS ���űݾ��հ�
        FROM CART,PROD,
                (SELECT C.MEM_ID,
                        C.MEM_NAME,
                        B.G1,
                        C.MEM_MILEAGE,
                        ROUND(B.AMILE)
                    FROM (SELECT A   
      
      SELECT A.MEM_ID AS ȸ����ȣ,      
             A.MEM_NAME AS ȸ����,
             SUM(B.CART_QTY*C.PROD_PRICE) AS ���űݾ��հ�
         FROM MEMBER A,CART B,PROD C,(SELECT ROUND(AVG(MEM_MILEAGE)) AS NAMM
                                           FROM MEMBER
                                       WHERE SUBSTR(MEM_REGNO2,1,1)='1'
                                         OR  SUBSTR(MEM_REGNO2,1,1)='3')D,
                                    (SELECT ROUND(AVG(MEM_MILEAGE)) AS GAMM
                                       FROM MEMBER
                                       WHERE SUBSTR(MEM_REGNO2,1,1)='2'
                                          OR SUBSTR(MEM_REGNO2,1,1)='4')F
            WHERE A.MEM_MILEAGE<D.NAMM OR A.MEM_MILEAGE<F.GAMM
              AND SUBSTR(B.CART_NO,1,6) BETWEEN '200504' AND '200506'
              AND A.MEM_ID=B.CART_MEMBER
              AND B.CART_PROD=C.PROD_ID
              GROUP BY A.MEM_ID,A.MEM_NAME; 
              
              