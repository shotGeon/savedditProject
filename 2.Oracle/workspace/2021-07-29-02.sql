2021-0729-02)VIEW ��ü
-������ ���̺�
-SELECT ���� ���ӵ��� �ʰ� ������ ��ü
-�ʿ��� �ڷᰡ �������� ���̺� �л�Ǿ� �ִ� ���
-Ư�� ���̺��� ������ �����ϰ� �ʿ��� ������ �����ؾ��ϴ� ��� ���
(�������)
 CREATE [OR REPLACE] VIEW ���̸�[(�÷�list)]
 AS 
  SELECT ��
  [WITH CHECK OPTION]
  [WITH READ ONLY];
  .'OR REPLACE' :���� �̸��� �䰡 �����ϸ� ��ġ�ϰ� ������ ���Ӱ� ����
  .'�÷�list' :�信�� ����� �÷���, �����ϸ� SELECT���� ���� �÷���Ī �Ǵ� �÷����� ����
               �÷������� ����
  .'WITH CHECK OPTION':�並 �����ϴ� SELECT���� ���� ������ üũ�Ͽ� �̸� �����ϴ� 
   DML����� �信 ������� ���ϰ� ��
  .'WITH READ ONLY': �б����� �� ����
  
  
��뿹)ȸ�����̺��� ���ϸ����� 3000 �̻��� ȸ���� ȸ����ȣ, ȸ����, ����, ���ϸ�����
      ��� �����Ͻÿ�.
      
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE(MID,MNAME,MJOB,MMILE)
      AS
       SELECT MEM_ID AS ȸ����ȣ,
                     MEM_NAME AS ȸ����,
                     MEM_JOB AS ����,
                     MEM_MILEAGE AS ���ϸ���
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
                
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE 
      AS
       SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_JOB AS ����,
              MEM_MILEAGE AS ���ϸ���
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
                
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE
      AS
       SELECT MEM_ID ,
              MEM_NAME,
              MEM_JOB,
              MEM_MILEAGE
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
      
                               
      SELECT MEM_ID,
             MEM_NAME,
             MEM_MILEAGE
         FROM MEMBER
         WHERE MEM_ID='e001';
         
  **������ �� 'VIEW_MEM_MILEAGE'���� ȸ����ȣ 'e001'ȸ���� ���ϸ����� 500���� �����Ͻÿ�
  UPDATE VIEW_MEM_MILEAGE
     SET ���ϸ���=500
     WHERE ȸ����ȣ='e001';
     
  **ȸ�����̺��� ȸ����ȣ 'g001'ȸ���� ���ϸ����� 600���� 15000���� �����Ͻÿ�
  UPDATE MEMBER
     SET MEM_MILEAGE=15000
     WHERE MEM_ID='g001';
     
      UPDATE MEMBER
     SET MEM_MILEAGE=15000
     WHERE MEM_ID='g001';
      
  SELECT *
    FROM VIEW_MEM_MILEAGE;
  **VIEW ���� ���ǻ���
   .WITH ���� ���� ��� ORDER BY�� ��� ����
   .�����Լ�, DISTINCT �� ���� VIEW�� ������� DML��� ����� �� ����
   .ǥ����(CASE WHEN-THEN,DECODE ��)�̳� �Ϲ� �Լ��� �����Ͽ� �䰡 ������ ���
    �ش� �÷��� ������� ����,���� �� ������
   .CURRVAL, NEXTVAL �� �ǻ��÷�(Pseudo Column)��� ����
   .ROWNUM, ROWID �� ���� ��Ī�� ����ؾ� ��.
      
��뿹)��ǰ�з��� ��ǰ�� ���� ����ϴ� �����
   ROLLBACK;
   
      CREATE OR REPLACE VIEW VIEW_PROD_LGU
      AS
       SELECT PROD_LGU AS PLGU,
              COUNT(*) AS CNT
         FROM PROD
        GROUP BY PROD_LGU;
      
    SELECT *
      FROM VIEW_PROD_LGU
    
   **�� VIEW_PROD_LGU���� 'P102' �ڷḦ �����Ͻÿ�
     DELETE VIEW_PROD_LGU
       WHERE PLGU='P102';
       --�����Լ��� ���Ǿ� ������ ��� DML��ɾ ����� �� ����.
       
��뿹)ȸ�����̺��� ���ϸ����� 3000�̻��� ȸ����� �����ǰ� ��������(CHECK OPTION)�� �����
      �並 ����
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE 
      AS
       SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_JOB AS ����,
              MEM_MILEAGE AS ���ϸ���
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000
      WITH READ ONLY;
      
      SELECT *
        FROM VIEW_MEM_MILEAGE; 
    **�信�� ������ ȸ���� ���ϸ����� 1500���� ����
    UPDATE VIEW_MEM_MILEAGE
       SET ���ϸ���=1500
       WHERE ȸ����ȣ='e001';
      
      
      UPDATE MEMBER
         SET MEM_MILEAGE=6500
         WHERE MEM_ID='e001';
         
           UPDATE MEMBER
         SET MEM_MILEAGE=800
         WHERE MEM_ID='g001';
      
      
      
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  