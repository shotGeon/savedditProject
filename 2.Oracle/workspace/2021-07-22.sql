2021-07-22-01)

��뿹)2005�� 5�� ȸ���� �Ǹž��� ����ϰ� ���� 5���� �ڷḦ ����Ͻÿ�
Alias�� ȸ����ȣ, ȸ����,���űݾ��հ�
    SELECT TBLA.CID AS ȸ����ȣ,
           TBLB.MEM_NAME AS ȸ����,
           TBLA.AMT AS ���űݾ��հ�
        FROM(SELECT A.CART_MEMBER AS CID,--FROM������ ���̺� �� �� �ֱ⿡ VIEW(�������̺�)�� ����Ѵ�.(�ζ��� ��������)
                   SUM(A.CART_QTY*B.PROD_PRICE) AS AMT
                FROM CART A, PROD B
                WHERE A.CART_PROD=B.PROD_ID
                  AND A.CART_NO LIKE '200505%'
                GROUP BY A.CART_MEMBER
                ORDER BY 2 DESC) TBLA,
            MEMBER TBLB
        WHERE TBLA.CID=TBLB.MEM_ID
          AND ROWNUM<=5;
          
          
��뿹) 2005�� 5�� ���Ծװ� ������� ��ȸ�Ͻÿ�
       Alias�� ��ǰ�ڵ�, ��ǰ��, ���Ծ��հ�, ������հ�
              
     SELECT C.PROD_ID AS ��ǰ�ڵ�, 
            SUM(A.BUY_QTY*A.BUY_COST) AS ���Ծ��հ�    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID;
       --------------
        SELECT C.PROD_ID AS ��ǰ�ڵ�,
            SUM(B.CART_QTY*C.PROD_PRICE) AS ������հ�       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID;
       
       SELECT PROD_ID AS ��ǰ�ڵ�,
              PROD_NAME AS ��ǰ��,
              NVL(TBLA.BAMT,0) AS �����հ�,
              NVL(TBLB.CAMT,0) AS �����հ�
       FROM(SELECT C.PROD_ID AS BID, 
            SUM(A.BUY_QTY*A.BUY_COST) AS BAMT    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID)TBLA,
       (SELECT C.PROD_ID AS ��ǰ�ڵ�,
            SUM(B.CART_QTY*C.PROD_PRICE) AS ������հ�       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID)TBLB,
     PROD
    WHERE TBLA.BID(+)=PROD_ID
      AND TBLB.CID(+)=PROD_ID
      GROUP BY 1;
      
      
       SELECT A.PROD_ID AS ��ǰ�ڵ�,
              A.PROD_NAME AS ��ǰ��,
              NVL(SUM(A.PROD_COST*B.BUY_QTY),0) AS �����հ�,
              NVL(SUM(A.PROD_PRICE*C.CART_QTY),0) AS �����հ�
         FROM PROD A
         LEFT OUTER JOIN BUYPROD B ON(B.BUY_PROD=A.PROD_ID
         AND B.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531'))
         LEFT OUTER JOIN CART C ON(C.CART_PROD=A.PROD_ID
         AND SUBSTR(C.CART_NO,1,6)='200505')
    GROUP BY A.PROD_ID, A.PROD_NAME
    ORDER BY 1;
    
    
    
    SELECT      
       FROM(SELECT C.PROD_ID AS BID, 
            SUM(A.BUY_QTY*A.BUY_COST) AS BAMT    
     FROM BUYPROD A,PROD C 
     WHERE A.BUY_PROD=C.PROD_ID
       AND A.BUY_DATE BETWEEN TO_DATE('20050501') AND TO_DATE('20050531')
       GROUP BY C.PROD_ID)TBLA,
       (SELECT C.PROD_ID AS ��ǰ�ڵ�,
            SUM(B.CART_QTY*C.PROD_PRICE) AS ������հ�       
     FROM CART B,PROD C 
     WHERE B.CART_PROD=C.PROD_ID
       AND SUBSTR(CART_NO,1,6)='200505'
       GROUP BY C.PROD_ID)TBLB,
     PROD
    WHERE TBLA.BID(+)=PROD_ID
      AND TBLB.CID(+)=PROD_ID
      GROUP BY 1;
      

       
          
��뿹)ȸ���� ���ϸ����� ��ȸ�Ͽ� ���� 20%�� ���� ȸ������ 2005��4~6��
      ������ ������ ��ȸ�Ͻÿ�. Alias�� ȸ����ȣ, ȸ����,���űݾ��հ�
      
      DECLARE--����(����,���,Ŀ��������)
        V_ID MEMBER.MEM_ID%TYPE;--Ÿ���� �𸦶� ���(���� ������ Ÿ������ �����)
        V_NAME MEMBER.MEM_NAME%TYPE;
        V_AMT NUMBER:=0;
        
        CURSOR CUR_MEM01 IS
         SELECT A.MID
          FROM (SELECT MEM_ID AS MID
                  FROM MEMBER
                 ORDER BY MEM_MILEAGE DESC) A
            WHERE ROWNUM<=ROUND((SELECT COUNT(*)
                                FROM MEMBER)*0.2);
      BEGIN
        OPEN CUR_MEM01;
        LOOP
          FETCH CUR_MEM01 INTO V_ID;--Ŀ���� �ִ°Ÿ� ������� ������� ��
          EXIT WHEN CUR_MEM01%NOTFOUND;
          
          SELECT  C.MEM_NAME, SUM(A.CART_QTY*B.PROD_PRICE)
            INTO V_NAME,V_AMT
            FROM CART A, PROD B, MEMBER C
            WHERE A.CART_MEMBER=C.MEM_ID
              AND A.CART_PROD=B.PROD_ID
              AND A.CART_MEMBER=V_ID
              AND SUBSTR(A.CART_NO,1,6) BETWEEN '200504' AND '200506'
             GROUP BY C.MEM_NAME; 
            DBMS_OUTPUT.PUT_LINE('ȸ����ȣ: '||V_ID);
            DBMS_OUTPUT.PUT_LINE('ȸ����: '||V_NAME);
            DBMS_OUTPUT.PUT_LINE('���űݾ�: '||V_AMT);
            DBMS_OUTPUT.PUT_LINE('--------------------------');      
            
      END LOOP;
         CLOSE CUR_MEM01;
        END;
        
 3.Non-Equi Join
  - �������ǹ��� '=' �̿��� �����ڰ� ���� �ܿ�
  - IN, ANY, SOME, ALL, EXISTS ���� ������ ������ ���
  
��뿹)������̺��� ������� ����ӱݺ��� �� ���� �ӱ��� �޴� ����� �����ȣ,�����,�μ���,�޿�,��ձ޿���
      ����Ͻÿ�
      SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             B.DEPARTMENT_NAME AS �μ���,
             A.SALARY AS �޿�,
             C.ASAL AS ��ձ޿�
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B,
           (SELECT ROUND(AVG(SALARY)) AS ASAL
                FROM HR.EMPLOYEES) C
      WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
        AND A.SALARY > C.ASAL
        ORDER BY 4;
        
      SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             B.DEPARTMENT_NAME AS �μ���,
             A.SALARY AS �޿�,
             (SELECT ROUND(AVG(SALARY)) 
                FROM HR.EMPLOYEES) AS ��ձ޿�
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
      WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
        AND A.SALARY >(SELECT ROUND(AVG(SALARY)) 
                FROM HR.EMPLOYEES)
        ORDER BY 4;
      
��뿹)2005�� 6�� ���� ���� ���Ű��� �ּ��� �̿��� �ּ����� �����ϴ� ȸ���� ȸ����ȣ, ȸ����, �ּҸ�
     ��ȸ�Ͻÿ�. 
      
��뿹)����� �� �ڱⰡ ���� �μ��� ��� �޿����� ���� �޿��� �޴� ���������� 
         ��ȸ�Ͻÿ�
     Alias�� �����ȣ,�����,�μ���ȣ,�μ���,�޿�,�μ���ձ޿�      
     
SELECT A.EMPLOYEE_ID AS �����ȣ,
       A.EMP_NAME AS �����,
       A.DEPARTMENT_ID AS �μ���ȣ,
       A.SALARY AS �޿�,
       DAV.DAS AS ��ձ޿�
  FROM(SELECT B.DEPARTMENT_ID AS DID,
          ROUND(AVG(A.SALARY)) AS DAS
          FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
          WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
          GROUP BY B.DEPARTMENT_ID) DAV,   
     HR.EMPLOYEES A
    WHERE A.DEPARTMENT_ID=DAV.DID
      AND A.SALARY<DAV.DAS
      ORDER BY 5 DESC;
      
      
      
      
      
      
      
      
      