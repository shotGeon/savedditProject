2021-0714-01)
2. �����Լ�
1) GREATEST(n1,n2[,n3,....]), LEAST(n1,n2[,n3,....])
 -GREATEST : �־��� �� (n1 ~..) �� ���� ū���� ��ȯ
 -LEAST : �־��� �� (n1 ~..) �� ���� ���� ���� ��ȯ
��뿹)SELECT GREATEST(50,70,90),
             LEAST(50,70,90)
        FROM DUAL;
        
��뿹)ȸ�����̺��� ���ϸ����� 1000�̸��� ���ȸ���� ���ϸ����� 1000���� ���� ����Ͻÿ�
     Alias�� ȸ����ȣ, ȸ����,���� ���ϸ���, ���� ���ϸ���
     
     SELECT MEM_ID AS ȸ����ȣ,
            MEM_NAME AS ȸ����,
            MEM_MILEAGE AS "���� ���ϸ���",
            GREATEST(MEM_MILEAGE,1000) AS "���� ���ϸ���"
        FROM MEMBER;
        
    SELECT MAX(MEM_NAME) FROM MEMBER;--MAX�� �������� ���Ҷ�, GREATEST�� �������� ���Ҷ�
    
2)ROUND(n[,i]),TRUNC(n[,i])
 -ROUND : �־��� �� n�� �Ҽ��� ���� i+1��° �ڸ����� �ݿø��Ͽ� i��° ���� ���
          i�� �����̸� �����κ� i ��°���� �ݿø�
          i�� �����Ǹ� 0���� ���ֵ�
 -TRUNC : ROUND�� ���� ����ǳ� �ݿø��� �ƴ϶� ����ó��
 
 ��뿹)������̺��� �޿��� ���޾��� ����Ͽ� ����Ͻÿ�
    Alias�� �����ȣ,�����,�޿�,����,���޾�
    ����=�޿����� 17%
    ���޾��� �޿� - ����
    �Ҽ��� 1�ڸ����� ���
    
    SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����, 
           SALARY AS �޿�, 
           ROUND(SALARY*0.17,1) AS ����,
           SALARY-TRUNC(SALARY*0.17,1)AS ���޾�
       FROM HR.EMPLOYEES;   
       
  ��뿹)2005�� 1��~3�� ��ǰ�з��� ��ո��Ծ��� ��ȸ�Ͻÿ� ---~���̳����� GROUP BY�� ����Ѵ�.
  Alias �з��ڵ�, �з���, ��ո��Աݾ�(�Ҽ�������)
  SELECT C.PROD_LGU AS �з��ڵ�,
         B.LPROD_NM AS �з���,
         ROUND(AVG(A.BUY_QTY*C.PROD_COST)) AS ��ո��Աݾ�
         FROM LPROD B,BUYPROD A, PROD C
         WHERE A.BUY_PROD=C.PROD_ID
           AND C.PROD_LGU=B.LPROD_GU
           AND A.BUY_DATE BETWEEN '20050101' AND '20050331'
           GROUP BY C.PROD_LGU,B.LPROD_NM--�����Լ��� ������������÷���
           ORDER BY 1;
3)FLOOR(n), CEIL(n)
-n�� ����� ������ ��ȯ
-FLOOR:n�� ���ų� ũ������ ���� �� ���� ū ����
-CEIL: n�� ���ų� ū ���� �� ���� ���� ����
-����, �޿� ó�� �ݾװ� ���õ� ���Ŀ� �ַ� ���
��뿹) SELECT FLOOR(12.5), CEIL(12.5),
              FLOOR(12), CEIL(12),
              FLOOR(-12.5), CEIL(-12.5)
          FROM DUAL;
4)MOD(n,i), REMAINDER(n,i)
 -�������� ��ȯ
 -MOD : n�� i�� ���� ������ ��ȯ
        ������= ������ - ����*(FLOOR(������/����))
    ex) 15/6 �� ������ = 15-6*(FLOOR(15/6))
                      = 15-6*(FLOOR(2,5))
                      =15-12
                      =3
                      
 -REMAINDER :n�� i�� ���� �������� i�� ���� ������ ���̸� MOD�� ���� ��������
             ��ȯ�ϰ� �������� �� �̻��� ���̸� �������� �Ǳ����� �������� �� ���� ��ȯ
    ex) 15/6 �� ������ = 15-6*(ROUND(15/6))
                      = 15-6*(ROUND(2,5))
                      =15-12
                      =3

��뿹) SELECT MOD(15,6),REMAINDER(17,6),
              MOD(15,7),REMAINDER(15,7)
           FROM DUAL;   
           
��뿹)������ �⵵�� �Է� �޾� ����� ����� �����Ͻÿ�
      ���� : (4�� ����̸鼭 100�� ����� �ƴϰų�) (400�� ����� �Ǵ� ��)
      
      ACCEPT P_YEAR PROMPT '�⵵ �Է�'
      DECLARE
            V_YEAR NUMBER(4):= TO_NUMBER('&P_YEAR');
            V_RES VARCHAR2(100);
         BEGIN
           IF (MOD(V_YEAR,4)=0 AND MOD(V_YEAR,100)!=0) OR MOD(V_YEAR,400)=0 THEN
              V_RES:=TO_CHAR(V_YEAR)||'�ش� �����Դϴ�.';
           ELSE
              V_RES:=TO_CHAR(V_YEAR)||'�ش� ����Դϴ�.';
           END IF;
           
           DBMS_OUTPUT.PUT_LINE(V_RES);
        END;
              
5)WIDTH_BUCKET(n, min, max b)
-min���� max�� ������ b���� �������� ������ �־��� �� n�� �� ���� �� ��� ������ ���ϴ�����
 �Ǻ��Ͽ� ������ �ε����� ��ȯ��
��뿹) SELECT WIDTH_BUCKET(100,0,100,10)FROM DUAL;

��뿹) ȸ�����̺��� ȸ������ ���ϸ����� 3���� �׷����� ������ �� ȸ������ ���ϸ����� ���� �׷���
       ��ȸ�Ͽ� 1�׷쿡 ���� ȸ���� '����ȸ��', 2�׷쿡 ���� ȸ���� '�� ȸ��', 3�׷쿡 ���� 
       ȸ���� 'VIP ȸ��'�� ������ ����Ͻÿ� (Alias�� ȸ����ȣ,ȸ����,����,���ϸ���,���)
       
       SELECT  MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_JOB AS ����,
               MEM_MILEAGE AS ���ϸ���,
               CASE WHEN WIDTH_BUCKET (MEM_MILEAGE,500,9000,3) =1 THEN
                  '����ȸ��'
                    WHEN WIDTH_BUCKET (MEM_MILEAGE,500,9000,3) =2 THEN
                  '����ȸ��'
               ELSE
                  'VIPȸ��'
              END AS ���            
          FROM MEMBER;
         
��뿹) ȸ�����̺��� ȸ������ ���ϸ����� 5���� �׷����� ������ ����� ����� ���
       Alias�� (ȸ����ȣ,ȸ����,����,���ϸ���,���)�̸� ����� ���ϸ����� ���� ȸ���� 1����̰�,
       ���� ���� ȸ���� 5����̴�.
       
       SELECT  MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_JOB AS ����,
               MEM_MILEAGE AS ���ϸ���,
               WIDTH_BUCKET (MEM_MILEAGE,9000,500,5)||'���' AS ���
        FROM MEMBER;
          
          
          
