2021-07013-02)�Լ�(FUNCTION)
-Ư�� ����� ��ȯ�ϱ� ���Ͽ� �̸� �ۼ��Ͽ� �����ϵ� ���
-��ȯ���� ����
-������ ��Ʈ��ũ ���� ��꿡 �⿩
-������ �Լ��� ������ �Լ�(�����Լ�:SUM,AVG,COUNT,MAX,MIN)�� ����
-���ڿ�, ����, ��¥, ����ȯ, NULLó��, �����Լ� ���� ����
-��ø��� �� �� �ִ�.--�Լ��ȿ� �Ǵٸ� �Լ��� ����� �� �ִ�.
SELECT EMP_NAME, SALARY
  FROM HR.EMPLOYEES
  WHERE DEPARTMENT_ID IN(SELECT A.DID
                         FROM (SELECT DEPARTMENT_ID AS DID,
                                      COUNT(*)
                                      FROM HR.EMPLOYEES
                                GROUP BY DEPARTMENT_ID
                                HAVING COUNT(*)>=5) A);

1.)���ڿ� �Լ�
 1) ||:���ڿ� ���� ������
    -�ڹ��� ���ڿ����� ���Ǵ� '+'�� ����
    -�� ���ڿ��� �����Ͽ� ���ο� ���ڿ��� ��ȯ
    
    
��뿹)ȸ�����̺��� �泲�� �����ϴ� ȸ�������� ��ȸ�Ͻÿ�
     Alias�� ȸ����ȣ, ȸ����, �ֹι�ȣ, �ּ��̸� �ֹι�ȣ��'xxxxxx-xxxxxxx'�������� ���
     SELECT  MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             MEM_REGNO1||'-'||MEM_REGNO2 AS �ֹι�ȣ,
             MEM_ADD1||''||MEM_ADD2 AS �ּ�
           FROM MEMBER
           WHERE MEM_ADD1 LIKE '�泲%'
             ORDER BY 1;                   

2)CONCAT(c1,c2)--c=character,n=number(�Ű�����)
-�� ������� �ʴ´�
-�־��� ���ڿ� �ڷ� c1�� c2�� �����Ͽ� ��ȯ
-��뿹)ȸ�����̺��� �泲�� �����ϴ� ȸ�������� ��ȸ�Ͻÿ�
     Alias�� ȸ����ȣ, ȸ����, �ֹι�ȣ, �ּ��̸� �ֹι�ȣ��'xxxxxx-xxxxxxx'�������� ���
      SELECT  MEM_ID AS ȸ����ȣ,
             MEM_NAME AS ȸ����,
             CONCAT(CONCAT(MEM_REGNO1,'-'),MEM_REGNO2) AS �ֹι�ȣ,
             CONCAT(MEM_ADD1,CONCAT(' ',MEM_ADD2)) AS �ּ�
           FROM MEMBER
           WHERE MEM_ADD1 LIKE '�泲%'
             ORDER BY 1;              
3)ASCII(c1), CHR(n1)
 -ASCII(c1) :c1�� �ش��ϴ� ASCII �ڵ尪 ��ȯ
 -CHR(n1) : ���� n1�� �ش��ϴ� ���ڸ� ��ȯ
��뿹)
    SELECT ASCII(PROD_ID), CHR(65) FROM PROD;
��뿹)

DECLARE

BEGIN 
  FOR I IN 1..255 LOOP
    DBMS_OUTPUT.PUT_LINE(I||'='||CHR(I));
  END LOOP;
END;

4)RPAD(c1,n[, c2]), LPA(c1,n[,c2])
-RPAD:������ ���� n�� c1�� �����ϰ� ���� ������ ������ c2�� �����Ѵ�.
-LPAD:������ ���� n�� c1�� �����ϰ� ���� ���� ������ c2�� �����Ѵ�.
-c2�� �����Ǹ� ������ ä��

��뿹)SELECT LPAD('12345',7,'*')AS COL1,
             RPAD('9876',6) AS COL2
        FROM DUAL;
        
        SELECT TO_CHAR(PROD_COST) AS COL1,
            LPAD(PROD_NAME,30) AS COL3,
            LPAD(TO_CHAR(PROD_COST),10) AS COL2,
            LPAD(TO_CHAR(PROD_COST),10,'#') AS "COST"
          FROM PROD;
          
5)RTRIM(c1[, c2]), LTRIM(c1[, c2])
 -RTRIM: �־��� ���ڿ� c1 ���ο� c2 ���ڿ��� �����ʿ��� ã�� ����
 -LTRIM: �־��� ���ڿ� c1 ���ο� c2 ���ڿ��� ���ʿ��� ã�� ����
 - c2 �� �����Ǹ� ������ ����(�ܾ� ���� ���� ���Ŵ� �Ұ���)
 
6)TRIM(c1)
-�ܾ� ���� �Ǵ� �����ʿ� �߻��� ������ ��� ����
-(�ܾ� ���� ���� ���Ŵ� �Ұ���)


SELECT MEM_NAME,MEM_HP,MEM_JOB,MEM_MILEAGE
  FROM MEMBER
  WHERE MEM_NAME = TRIM('������      ');--�ܾ� ���ο� �߻��� ������ ���Ű� �Ұ��� �ϴ� EX('�� �� ��')
  
7)SUBSTR(c,n1[,n2])
 -�־��� ���ڿ� c���� n1��° ���� n2 ���� ��ŭ ���ڸ� �����Ͽ� �κ� ���ڿ��� ��ȯ
 -����� ���ڿ���
 -n1, n2�� 1���� ���۵�
 -n2�� �����ǰų� ������ ������ ū n2�� ����ϸ� n1���� ��� ���ڿ��� ������
 -n1�� �����̸� �������� �������� ó����
 
��뿹)SELECT SUBSTR('������ �߱� ���ﵿ', 2,5),
             SUBSTR('������ �߱� ���ﵿ', 2),
             SUBSTR('������ �߱� ���ﵿ', 2,20),
             SUBSTR('������ �߱� ���ﵿ', -7,5)
        FROM DUAL;
        
��뿹)������ 2005�� 4�� 1���� ��� CART_NO�� �ڵ� �����Ͻÿ�
      SELECT TO_CHAR(SYSDATE, 'YYYYMMDD')||TRIM(TO_CHAR(TO_NUMBER(SUBSTR(MAX(CART_NO),9))+1,'00000'))
              
      FROM CART
      WHERE CART_NO LIKE '20050401%';
      
      SELECT MAX(CART_NO)+1--���ڷ� �ٲ�� �ִ� ���ڿ��� ���ڷ� �ٲ�� �ִ�.
      FROM CART
      WHERE CART_NO LIKE'20050401%'
      
 8) REPLACE(c1,c2[,c3])
   -�־��� ���ڿ� c1�� ���Ե� c2�� ã�� c3�� ġȯ ��Ŵ
   -c3�� �����Ǹ� ã�� c2�� ������Ŵ
   -�ܾ� ������ ���� ���ſ� ���� �� ����
   
��뿹)SELECT REPLACE('���������� �߱� ���ﵿ','��������','����'), 
             REPLACE('���������� �߱� ���ﵿ','����'),
             REPLACE('���������� �߱� ���ﵿ',' '),
             REPLACE('���������� �߱� ���ﵿ','��')
      FROM DUAL;
      
 9) INSTR(c1, c2[,m[,n]])--Ư�������� ��ġ���� ��ȯ ������ ���
  -�־��� ���ڿ� c1���� c2���ڿ��� ó�� ���� ��ġ���� ��ȯ
  -m�� �˻� ������ġ�� ���� ������ �� ���
  -n�� c2���ڿ��� �ݺ� Ƚ���� ���Ͽ� �˻��ϴ� ��� ���
  
  
��뿹)SELECT INSTR('APPLE PERSTMON PEAR BEAR', 'E'),--E�� ó�������� �ε������� ��ȯ(5)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5),--�˻��� ��ġ�� ����(7)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5,2),--2�� �ݺ��Ǿ��� P�� �ε���(16)
             INSTR('APPLE PERSTMON PEAR BEAR', 'P',5,3)--(0)
             FROM DUAL;
             
             
             
       
        
            
        
    