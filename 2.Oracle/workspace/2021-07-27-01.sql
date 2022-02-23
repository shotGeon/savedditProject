2021-0727-01)
**��� ����ó���� ���� ���̺��� �����Ͻÿ�
1)���̺��: REMAIN
2)�÷���
-------------------------------------------------------
  �÷���       ������Ÿ��       NULL��뿩��    �������
-------------------------------------------------------
REMAIN_YEAR    CHAR(4)         N.N           PK
PROD_ID       VARCHAR2(10)     N.N           PK/FK
REMAIN_J_00   NUMBER(5)                      DEFAULT 0 --�������
REMAIN_I      NUMBER(5)                      DEFAULT 0
REMAIN_O      NUMBER(5)                      DEFAULT 0
REMAIN_J_99   NUMBER(5)                      DEFAULT 0 --�⸻���(�������+�԰�-���)
REMAIN_DATE   DATE                  
-------------------------------------------------------

CREATE TABLE REMAIN(
REMAIN_YEAR    CHAR(4),     
PROD_ID       VARCHAR2(10), 
REMAIN_J_00   NUMBER(5)   DEFAULT 0, 
REMAIN_I      NUMBER(5)   DEFAULT 0,
REMAIN_O      NUMBER(5)   DEFAULT 0,
REMAIN_J_99   NUMBER(5)   DEFAULT 0,
REMAIN_DATE   DATE,

CONSTRAINT pk_remain PRIMARY KEY(REMAIN_YEAR,PROD_ID),
CONSTRAINT fk_remain_prod FOREIGN KEY(PROD_ID)
   REFERENCES PROD(PROD_ID));
   
4)DML ��ɿ� �������� ��� --INSERT�������� ���������� ��ȣ�� �������� �ʴ´�.
 (1)INSERT ���� �������� ���
  . '( )'�� ������� �ʰ� �������� ���
  . INSERT ���� VALUES���� ���� 

��뿹) ���������̺�(REMAIN)�� PROD ���̺��� �ڷḦ �̿��Ͽ� ���ʵ����͸� �Է��Ͻÿ�
      �⵵: '2005'
      ��ǰ�ڵ�: PROD���̺��� ��ǰ�ڵ�(PROD_ID)
      ����������: PROD���̺��� PROD_PROPERSTOCK
      �԰� �� ��� ����: ����
      �⸻������ : PROD���̺��� PROD_PROPERSTOCK
      ��¥ : '2004-12-31'
      
      INSERT INTO REMAIN (REMAIN_YEAR,PROD_ID,REMAIN_J_00,REMAIN_J_99,REMAIN_DATE)
         SELECT '2005',PROD_ID,PROD_PROPERSTOCK,PROD_PROPERSTOCK,TO_DATE('20041231')
           FROM PROD;
        
        
      (2) UPDATE ���� �������� ���
      . �������� �÷��� �����ϴ� ��� '( )'�ȿ� ������ �÷��� ����Ͽ� �ϳ��� SET���� ó��
      
��뿹)2005��1�� ��ǰ�� ���������� �̿��Ͽ� REMAIN���̺��� �����Ͻÿ�

  ��������
     UPDATE REMAIN
         SET REMAIN_I=(��������1),
             REMAIN_J_99=(��������2),
             REMAIN_DATE=TO_DATE('20050131')
        WHERE ����
   ��������:2005�� 1�� ��ǰ�� ��������
    SELECT BUY_PROD,
           SUM(BUY_QTY)
        FROM BUYPROD
        WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
        GROUP BY BUY_PROD;
        
        
(����)--�������� �⺻Ű�� ���Ǿ����� WHERE���� �������� �⺻Ű�� ��� ��޵Ǿ����� �Ѵ�.
       UPDATE REMAIN B
         SET (B.REMAIN_I,B.REMAIN_J_99,B.REMAIN_DATE)=
             (SELECT REMAIN_I+A.AMT,REMAIN_J_99+A.AMT,TO_DATE('20050131') 
              FROM(SELECT BUY_PROD AS BID,
                       SUM(BUY_QTY) AS AMT
                   FROM BUYPROD
                  WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                  GROUP BY BUY_PROD) A
            WHERE B.PROD_ID=A.BID)
        WHERE B.REMAIN_YEAR='2005'
          AND B.PROD_ID IN (SELECT DISTINCT BUY_PROD AS BID
                                FROM BUYPROD
                                WHERE BUY_DATE BETWEEN TO_DATE('20050101')
                                AND TO_DATE('20050131'));    
                COMMIT;
                
        
   SELECT * FROM REMAIN;
   
  (3)DELETE���� �������� ���
    .WHERE �������� IN�̳� EXISTS �����ڸ� ����Ͽ� ������ �ڷḦ �� �� �����ϰ� ���� �� �� ����

��뿹)��ٱ������̺��� 2005�� 5�� ȸ����ȣ�� 'p001'�� �ڷḦ �����Ͻÿ�.
       
��������)  DELETE CART C
     WHERE C.CART_MEMBER='p001'
       AND C.CART_NO LIKE '200505%';  
                      
��뿹)2005�� 6�� ��ǰ 'P302000001'�� �����ڷ� �� �Ǹ� ������ 5�� �̻��� �ڷḸ �����Ͻÿ�
         DELETE FROM CART C
         WHERE EXISTS(SELECT A.CART_MEMBER,
                               A.CART_PROD,
                               A.CART_QTY,
                               A.CART_NO
                               FROM CART A,PROD B
                            WHERE A.CART_PROD=B.PROD_ID
                            AND A.CART_PROD='P302000001'
                            AND A.CART_NO LIKE '200506%'
                            AND A.CART_QTY>=5)
                  AND A.CART_NO LIKE '200506%';
��������)
SELECT A.CART_PROD,
       A.CART_QTY,
       A.CART_NO
  FROM CART A,PROD B
  WHERE A.CART_PROD=B.PROD_ID
    AND A.CART_PROD='P302000001'
    AND A.CART_NO LIKE '200506%'
    AND A.CART_QTY>=5;
    
��뿹)2005�� 4�� �Ǹ��ڷ� �� �Ǹ� �ݾ��� 5���� ������ �ڷḸ �����Ͻÿ�
  (��������:2005�� 4�� �Ǹ��ڷ� �� �Ǹ� �ݾ��� 5���� ������ �ڷ� �˻�)
   DELETE FROM CART A
   WHERE EXISTS (SELECT 1
                   FROM PROD
                  WHERE A.CART_PROD=PROD_ID
                    AND A.CART_QTY*PROD_PRICE<=50000)
          AND A.CART_NO LIKE '200504%';
                  
   ROLLBACK;
   
   
   
   
         
      



