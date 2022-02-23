2021-0712-01)������ Ÿ��
- ����Ŭ���� ���Ǵ� ������Ÿ���� ���ڿ�, ����, ��¥, 2���ڷ����� ����
1.���ڿ� �ڷ�--��ҹ��ڰ� ���еȴ�
-����Ŭ�� ���ڿ��� ' '�� ���� ǥ��
-��������(CHAR)�� ��������(VARCHAR,VARCHAR2,LONG,NVARCHAR2(NATIONAL-����ǥ���ڵ�),CLOB(CHARACTER LARGE OBJECT(����������))Ÿ������ ����
-������ ����, Ư�����ڴ� 1BYTE�� �ѱ� �ѱ��ڴ� 3BYTE�� ǥ��
 1)CHAR
 .���ǵ� ũ���� �������� �ڷḦ �����ϰ� ���� ������ �������� ä��
 .�����ʹ� MSB���� LSB������ ����
 (�������)
 �÷��� CHAR(ũ�� [BYTE[CHAR])--�ѱ������������20CHAR�� ����ϸ� 60BYTE�� ����Ѵٴ� ���̴�.������ ����;
  -�ִ� 2000BYTE ���� ���尡��
  -BYTE CHAR: �����ϸ� BYTE�� ��޵Ǹ� 'CHAR'�� ���Ǹ� 'ũ��'�� ���ڼ���
   ��Ÿ��. �ٸ�, CHAR�� ����ص� 2000BYTE�� �ʰ��� �� ����
  -���̰� ������ Į���̳� �⺻Ű �÷��� ������ Ÿ������ �ַ� ���Ǿ�����.
  
(��뿹)
     CREATE TABLE T_CHAR (
     COL1 CHAR(20),
     COL2 CHAR(20 CHAR),
     COL3 CHAR(20 BYTE));
   
    INSERT INTO T_CHAR(COL1,COL2,COL3)
           VALUES('����ȭ ���� ��','����ȭ ���� �Ǿ����ϴ�','����ȭ');
           INSERT INTO T_CHAR(COL1,COL2,COL3)
           VALUES('����ȭ ���� ��','����ȭ ���� ��','����ȭ');
           
    
           SELECT * FROM T_CHAR;
           
           SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3) 
           FROM T_CHAR;
           
2)VARCHAR2
 .�������� �ڷ����忡 ���
 (�������)
  �÷��� VARCHAR2(ũ��[BYTE|CHAR])
   -�ִ� 4000BYTE���� ���� ����
   -����ڰ� ������ ������ ��ŭ ����ϰ� ���� ������ SYSTEM�� ��ȯ
   
(��뿹)
   : CREATE TABLE T_VARCHAR2(
        COL1 VARCHAR2(500),
        COL2 VARCHAR2(50 CHAR),
        COL3 VARCHAR2(50 BYTE))
        
        INSERT INTO T_VARCHAR2 
             VALUES('IL POSTONO', '�ʸ� ���ͷ�', '���ø� Ʈ���̽�');
        INSERT INTO T_VARCHAR2
               VALUES('PERSIMON BANNA APPLE', 'PERSIMON BANNA', 'PERSIMO��');
        SELECT * FROM T_VARCHAR2;
        SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)
          FROM T_VARCHAR2;
             
3)VARCHAR, NVARCHAR, NVARCHAR2
 .�⺻������ NVARCHAR2�� ���� ����� ���� ��
 .NVARCHAR, NVARCHAR2�� UTF-8(��������),UTF-16(��������)����� �ڵ��
  ��ȯ�Ͽ� �ڷ� ����(����ǥ���ڵ� ����)
  
4)LONG
 .�������� �ڷḦ ����
 (�������)
 �÷��� LONG--���̴� ��������
  - �ִ� 2GB���� ���� ����
  - �� ���̺� �ϳ��� �÷��� ��밡��(�������)
  - CLOB�� ��ü��
  - ���ڿ� �Լ�(LENGTH,LENGTHB,SUBSTR)���� ���ѵ�
��뿹)
    CREATE TABLE T_LONG(
       COL1 VARCHAR(100),
       COL2 LONG,
       COL3 CHAR(100));
       
   INSERT INTO T_LONG
          VALUES('PERSIMON BANNA APPLE', 'PERSIMON BANNA', 'PERSIMON��');
          
          SELECT *
           FROM T_LONG;
           
           SELECT COL1,COL2,TRIM(COL3) FROM T_LONG;
           
          SELECT LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)--LONGŸ�԰�CLOBŸ���� LENGTHB,LENGTH�� ���Ǿ����� �ʴ´�.
          FROM T_LONG;
          
5)CLOB(CHAR LARGE OBJECT)--�����ڷῡ����BLOB
 .�������� �ڷḦ ����
 (�������)
 �÷��� CLOB
   -�ִ� 4GB���� ���� ����
   -���� �÷��� �ϳ��� ���̺� ���� ����
   -�Ϻ� ����� DBMS_LOB API�� ������ �޾ƾ� ��� ����(LENGTH,SUBSTR ��)--LENGTHB�� ��������
   
��뿹)
    CREATE TABLE T_CLOB(
       COL1 CLOB,
       COL2 CLOB,
       COL3 VARCHAR2(400),
       COL4 LONG);
   
   INSERT INTO T_CLOB(COL1,COL2,COL4)
          VALUES('������ �߱� ���ﵿ ���κ���','������ �߱� ���ﵿ ���κ���',
                 '������ �߱� ���ﵿ ���κ���');
   
   SELECT *
      FROM T_CLOB;
      
      SELECT DBMS_LOB.GETLENGTH(COL1),
             SUBSTR(COL1,5,6),
             DBMS_LOB.SUBSTR(COL1,5,6)--LOB�������������� �Ű��������ڹٲ��.SUBSTR(5,6)=�߱� ���ﵿ DBMS_LOB.SUBSTR(5,6)=�� ���ﵿ
          FROM T_CLOB;
          
          
2.���� �ڷ�
 -NUMBER Ÿ���� ����
 
 (�������)
 �÷��� NUMBER[(���е�|*[, ������])]
 . ������� : 1.0 x 10^-130 - 9.999...9 x 10^125
 . ���е� : ��ü�ڸ���(1 ~30)
 . ������(���) : �Ҽ��� ������ �ڸ��� 
 . ������(����) : �����κ��� �ڸ���
   ������ ���� 84 ~ 127:
   ---1234.5678(-1-2-3-4.1234)
 . 20 BYTE�� ǥ��
 
 ex) NUMBER, NUMBER(10), NUMBER(10,2), NUMBER(*,2)....
 ---------------------------------------------------------
  �Է°�          ����           ���Ǵ� ��
 --------------------------------------------------------- 
 123456.6789    NUMBER         123456.6789 --NUMBER�� ���Ǵ� ������ ���̶�� �״�� �����ض�
 123456.6789    NUMBER(10)     123457 -- �Ҽ�ù��°�۸����� �ݿø��ؼ� ������ �ٲ�
 123456.6789    NUMBER(7,2)    --�����κп� ������ �ڸ����� 5�ڸ��� ���� (7-2),�ּ�6�ڸ����ʿ�
 123456.6789    NUMBER(*,2)    123456.68
 123456.6789    NUMBER(10,-2)  123500
 ----------------------------------------------------------
 
 CREATE TABLE T_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(10),
    COL3 NUMBER(7,2),
    COL4 NUMBER(*,2),
    COL5 NUMBER(10,-2));
    
    SELECT * FROM T_NUMBER;
    
 INSERT INTO T_NUMBER(COL1)VALUES(123456.6789);  
 INSERT INTO T_NUMBER(COL2)VALUES(123456.6789); 
 INSERT INTO T_NUMBER(COL3)VALUES(12345.6789); 
 INSERT INTO T_NUMBER(COL4)VALUES(1234567.6789); 
 INSERT INTO T_NUMBER(COL5)VALUES(123456.6789); 
 
 **������>���е�
   . ������: �Ҽ��������� ������ ��
   . ������-���е�: �Ҽ������Ͽ� �����ؾ��� 0�� ����
   . ���е�: �Ҽ������Ͽ� 0�� �ƴ� �ڷ��
------------------------------------------------------------
  �Է°�          ����             ���Ǵ� ��
------------------------------------------------------------
  1.234        NUMBER(4,5)       ����: �����κп� 0�� �ƴ� �� ����
  0.23         NUMBER(3,5)       ����: 0.00���� �����ؾ� ��
  0.0023       NUMBER(3,5)       ����: ��ȿ�������� ������ �����ϴ� --(2,4)���Ǹ� �´�
  0.012345     NUMBER(3,4)       0.0123 ��ȿ�����Ͱ� ������ �ݿø��� �Ͼ�� �������.(4���� �ݿø��� �Ͼ)
  
   