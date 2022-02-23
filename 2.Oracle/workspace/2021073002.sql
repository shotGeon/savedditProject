2021-0730-02)
1. INDEX ��ü
 -�������� �˻� ȿ������ �����ϱ� ���� ��ü
 -WHERE �������� ���Ǵ� �÷�, SORT�� GROUP�� �����÷� ���� �÷��� ��������
  INDEX�� �����ϸ� DBMS�� ���ϸ� �ٿ� ��ü ���� ���
 -������ ������ �ҿ�(INDEX FILE), �ε��� ������ ���������� ���� �ý��� �ڿ� �ʿ�,
  ������ ���� � ���� �ð��� �ҿ�
 -�ε��� ����
  .Unique Index : �ߺ� ���� ������� �ʴ� �ε���(�⺻Ű �ε��� ��)
  .Non-Unique : �ߺ� ���� ����ϴ� �ε����� Null���� ����ϳ� �ϳ��� ���
  .Single Index : �ε��� ������ �ϳ��� �÷��� ��� 
  .Composite Index : �ε��� ������ �������� �÷��� ���Ǹ�, WHERE���� ����
   ��� �׸�(�ε��� �����׸�)�� ������ ȿ������ �����Ŵ
  .Normal Index : �⺻ �ε���(Ʈ������ ���-��� ����� ��� �˻�Ƚ���� ����)��
   ROWID�� �÷� ������ �ּ� ����
  .Function-Based Normal Index : �ε��� ���� �÷��� �Լ��� ���� ����
   where ������ ���� ���� �Լ� ����� ȿ���� ���� ���
  . Bitmap Index ROWID�� �÷� ���� ����(binary)���� �������� �ּ� ����,
    Cardinality�� ���� ��� ȿ�����̸�, �߰�,����,������ ���� ��� ��ȿ����

(�������)
  CREATE [UNIQUE|BITMAP] INDEX �ε�����
      ON ���̺��(�÷���1[,�÷���2,...][ASC|DESC]);

��뿹)ȸ�����̺��� �ֹι�ȣ�������� �ε����� �����Ͻÿ�
     CREATE INDEX IDX_MEM_REGNO
         ON MEMBER(MEM_REGNO1,MEM_REGNO2);
         
        CREATE INDEX IDX_MEM_NAME
          ON MEMBER(MEM_NAME);
          
          
          
  SELECT * FROM MEMBER 
     WHERE MEM_ADD1 LIKE '����%';
  
 ��뿹)ȸ�����̺��� MEM_REGNO2�� �ֹε�Ϲ�ȣ �� 2~5��° ���ڷ� ������ �ε�����
       �����Ͻÿ�
       
       CREATE INDEX IDX_MEM_REGNO_SUBSTR
          ON MEMBER(SUBSTR(MEM_REGNO2,2,4));
  
        SELECT * FROM MEMBER
         WHERE SUBSTR(MEM_REGNO2,2,4)='4489';
  
  
  
  
  
  **�ε����� �� ����
  -�ش� ���̺��� �ڷᰡ ���� ������ ���
  -�ε����� �ٸ� ���̺����̽��� �̵� ��Ų ��
  
  ALTER INDEX �ε����� REBUILD; 
  
  
  
  
  
  
  
  
  
  
  
  