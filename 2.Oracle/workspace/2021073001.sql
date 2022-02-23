2021-0730-01)SEQUENCE ��ü
-���������� �����ϴ� ���� ��ȯ�ϴ� ��ü
-���̺�� ������
-������ ���̺��� �⺻Ű�� ������ ������ �÷��� ���� ���, �ڵ����� �ο��Ǵ�
 �������� ���� ���� �ʿ��� ��� ���
-�ַ� INSERT���� ��� 
 �������)
 CREATE SEQUENCE ��������
   [START WITH n] -- ���� ��, �����ϸ� �ּҰ�(MINVALUE)
   [INCREMENT BY n] -- ������, �����ϸ� 1 
   [MAXVALUE n|NOMAXVALUE] -- �ִ밪, �⺻�� NOMAXVALUE�̸� 10^27
   [MINVALUE n|NOMINVALUE] -- �ּҰ�, �⺻�� NOMINVALUE�̰� ���� 1
   [CYCLE | NOCYCLE] -- �ּ�[�ִ�]�� ������ ���������� �ٽ� �������� ���� �⺻�� NOCYCLE
   [CACHE n | NOCACHE] -- ������ ���� ĳ���� �̸� �����ϰ� ������� ����, �⺻�� CACHE 20
   [ORDER | NOORDER] -- ������ ���Ǵ�� ������ ������ ����, �⺻�� NOORDER
   
**�ǻ��÷�
  ��������.CURRVAL : '������' �� ������ �ִ� ���簪 ��ȯ
  ��������.NEXTVAL : '������'�� ������ ��ȯ
  ** ������ ��ü�� ������ �� �� ó�� ����� �ݵ�� '��������.NEXTVAL'�̾�� ��
  ** ��������.NEXTVAL�� ����Ͽ� ������ ���� �ٽ� ������� �� ����
  
��뿹)���̺� LPROD�� LPROD_ID�� ����� �������� �����Ͻÿ�
  SELECT MAX(LPROD_ID) FROM LPROD;
  
  CREATE SEQUENCE SEQ_LPROD
    START WITH 10; --9�� �̹������ϱ� ������ 10���� �����ϴ°� ���ϴ�.
  
  
  INSERT INTO LPROD
    VALUES(SEQ_LPROD.NEXTVAL, 'P501','��깰');
    
    SELECT *
       FROM LPROD;
  
��뿹)������ 2005�� 4�� 18���̶� �����ϰ� CART_NO�� �����Ͻÿ� 
    SELECT TO_CHAR(TO_DATE('2005/04/18'),'YYYYMMDD')||
    TRIM(TO_CHAR(TO_NUMBER(SUBSTR(MAX(CART_NO),9))+1,'00000'))                
      FROM CART
      WHERE CART_NO LIKE('20050418%');
      
  **�������� ����� ���ѵǴ� ���
   .SELECT,DELETE,UPDATE���� ���Ǵ� ��������
   .VIEW�� ��������ϴ� QUERY
   .DISTINCT�� ���Ǵ� SELECT��
   .GROUP BY, ORDER BY���� ���Ǵ� SELECT��
   .���տ���(UNION,UNION ALL,INTERSECT,MINUS)�� ���Ǵ� SELECT��
   .WHERE ��
   
3.SYNONYM ��ü
-���Ǿ�(��Ī)�� �ǹ�
-����Ŭ���� ���Ǵ� ��ü�� ������ �̸��� �ο��Ͽ� ���� ��� ����
-�ַ� ���̸��� ��ü���� ����ϱ� ���� ��ü������ ��ü �� �����

(�������)
  CREATE [OR REPLACE] SYNONYM �ó봽�� FOR ��ü��
  .'��ü��'�� ������ �̸��� '�ó봽��'�� �ο�
  .�÷��� ��Ī�� ���̺��� ��Ī���� ������
   -'�ó봽��'�� �ش� ���̺� �����̽� ��ü���� ���
   -'�÷��� ��Ī�� ���̺��� ��Ī'�� �ش� ���������� ��� ����
   
��뿹)HR�� ���̺� EMPLOYEES,DEPARTMENTS, JOB_HISTORY�� EMP,DEPT,JOBH��Ī�� �ο��Ͻÿ�
   CREATE OR REPLACE SYNONYM EMP FOR HR.EMPLOYEES;
   CREATE OR REPLACE SYNONYM DPT FOR HR.DEPARTMENTS;
   CREATE OR REPLACE SYNONYM JOBH FOR HR.JOB_HISTORY;
   
   SELECT * FROM DPT;
   SELECT * FROM EMP;
   SELECT * FROM JOBH;
  
   