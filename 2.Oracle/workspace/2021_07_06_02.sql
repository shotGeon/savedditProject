2021_07_06_02)SQL ����� ����
 1)Query
   ���� �� ��ȸ
   SELECT ��
   
 2)DML(Data Manipulation Language:������ ���۾�)
  INSERT, UPDATE, DELETE ��
  
 3)DCL(Data Control Language:������ �����)
  COMMIT, ROLLBACK, SAVEPOINT, GRANT

 4)DDL(Data Definition Language:������ ���Ǿ�)
  CREATE, DROP, ALTER
  
 (1) CREATE
  . ����Ŭ ��ü�� ����
  (�������)
  CREATE ��üŸ�� ��ü��;
   - ��üŸ��: �����Ϸ� �ϴ� ��ü�� ������ USER,VIEW,INDEX,SYNONYM,TABLE...etc
   **���̺� �������
  CREATE TABLE ���̺��(
    �÷��� ������Ÿ��[(ũ��)] [NOT NULL] [DEFAULT ��][,]
    
    �÷��� ������Ÿ��[(ũ��)] [NOT NULL] [DEFAULT ��][,]
    
    [CONSTRAINT �⺻Ű������(PK_���̺��,(�ε��������� ���ֱ� ������ ���� �ߺ��Ǿ�� �ȵȴ�.)) PRIMARY KEY(�÷���[,�÷���,...])][,]
    [CONSTRAINT �ܷ�Ű������(FK_���̺��,(�ε��������� ���ֱ� ������ ���� �ߺ��Ǿ�� �ȵȴ�.)) FOREIGN KEY(�÷���[,�÷���,...])]
        REFERENCE ���̺��(�÷���)[,]
        
    [CONSTRAINT �⺻Ű������ FOREIGN KEY(�÷���[,�÷���,...])]
        REFERENCE ���̺��(�÷���)]);
        
         '������Ÿ��' : CHAR, VARCHAR, DATE, NUMBER, CLOB, BLOB �� ���
         'DEFAULT ��' : ����ڰ� ������ �Է½�(INSERT��)�����͸� ������� �������
         ����Ǵ� ��
         '�⺻Ű����','�ܷ�Ű����': �⺻Ű �� �ܷ�Ű ������ �����ϱ����� �ο���
         �ε��������� ������ �ĺ��� �̾�� ��
         'REFERENCES ���̺��(�÷���)' : �������̺��(�θ����̺��)�� �װ����� ����
         �÷���

(������̺�)
1)���̺��:EMPLOYEE
2)�÷�
---------------------------------
�÷��� ������Ÿ��(ũ��) N.N PK/FK
---------------------------------
EMP_ID CHAR(4) N.N PK
EMP_NAME VARCHAR2(30)N.N 
E_ADDR VARCHAR2(80)--�ּ�
E_TEL VARCHAR2(20)--��ȭ��ȣ
E_POSITION VARCHAR2(30)--����
E_DEPT VARCHAR2(50)
----------------------------------

CREATE TABLE EMPLOYEE(
EMP_ID CHAR(4) NOT NULL,
EMP_NAME VARCHAR2(30) NOT NULL,
E_ADDR VARCHAR2(80),
E_TEL VARCHAR2(20),
E_POSITION VARCHAR(30),
E_DEPT VARCHAR2(50),
CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_ID));
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         


        
    