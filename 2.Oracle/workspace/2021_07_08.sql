2021-0708-01
1)SELECT �� ����
  SELECT DISTINCT �÷���[����]������ [AS]["][��Ī]["]
    'DISTINCT': �ߺ��� ���� ����
    '[AS]["][��Ī]["]': �÷��� �ο��� �Ǵٸ� �̸����� Ư������ ���� " "�� ���� ���
    -��½� �÷��� �������� ���Ǿ� ����.
    
��뿹)�п����̺�(MEMBER)�� �ֹι�ȣ(MEM_REGNO1)�� ����Ͽ� ȸ���� ���̸� 
      ��ȸ�Ͻÿ�.
      Alias�� ȸ����ȣ,ȸ����,�ֹι�ȣ,����
      --SUBSTR����-SUBSTR(MEM_REGNO1,1,2)--1996(96��)
      
      SELECT MEM_ID AS ȸ����ȣ,
                      MEM_NAME AS ȸ����,
                      MEM_REGNO1 ||'-'||MEM_REGNO2 AS "�ֹ� ��ȣ", --" "������ϸ� ���ڿ��� �ν��Ѵ�.EX="FROM"�� ���ڿ��� �ν�
                      EXTRACT (YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(MEM_REGNO1,1,2))+1900)AS ����
                      FROM MEMBER; 
                      
 (1) ������(OPERATER)
     ���������: (+,-,/,*)--MOD,REMINDER(���������Ҷ����)
��뿹)HR������ ������̺��� ���ʽ��� ����Ͽ� �޿��� ���޾��� ��ȸ�Ͻÿ�
      ���ʽ�=�޿�*���������ڵ�(COMMISSION_PCT)�� 35%
      ���޾�=�޿�+���ʽ�
      ���:�����ȣ,�����,�޿�,���ʽ�,���޾�
      
    SELECT EMPLOYEE_ID AS �����ȣ,
           FIRST_NAME||' '||LAST_NAME AS �����,
           SALARY AS �޿�,
           NVL(SALARY*COMMISSION_PCT*035,0) AS ���ʽ�,
           SALARY+NVL(SALARY*COMMISSION_PCT*035,0) AS ���޾�
           FROM HR.EMPLOYEES;
        
      
     
     ���迬����: (>, <, >=, <=, =, !=(<>)) ��Һ�, TRUE/FALSE�� ����� ��ȯ --�ַ� ���ǿ� ���Ǿ� ����.(WHERE ��)
��뿹)ȸ�����̺��� ���ϸ����� 4000�̻��� ȸ���� ȸ����ȣ,ȸ����,����,���ϸ����� ��ȸ�Ͻÿ�   
���ϸ����� ���� ȸ������ ��ȸ
    SELECT MEM_ID AS ȸ����ȣ, --1
           MEM_NAME AS ȸ����, --2
           MEM_JOB AS ����, --3
           MEM_MILEAGE AS ���ϸ��� --4
           FROM MEMBER
           WHERE MEM_MILEAGE >=4000
           ORDER BY 4 DESC;
           --ORDER BY 4 DESC; --�÷��� ��� �÷� �ε����� 4�� �ᵵ �ȴ�. 
           --ORDER BY MEM_ID,MEM_HP DESC �ΰ�쿡�� ���������� �������� ���� MEM_ID�� ASC�� ������ �Ŀ� Ȥ�� ���� ���� ���� �ִٸ� ����å���� 
           --MEM_HP�� �������� DESC�� �����Ѵ�.
           
**ȸ�����̺���������
1)d001ȸ���� �ֹι�ȣ460409 2000000 �������1946/04/09
            �ֹι�ȣ010409 4234565 �������2001/04/09
            
2)n001ȸ���� �ֹι�ȣ750323 1011014 ������� 1975/03/23
            �ֹι�ȣ000409 3011014 ������� 2000/03/23

3)v001ȸ���� �ֹι�ȣ520131 2402712 ������� 1952/01/31
            �ֹι�ȣ020131 4402712 ������� 2002/03/23            

**��������:UPDATE��
  UPDATE ���̺��
     SET �÷���=��[,
         �÷���=��]
  [WHERE ����];
  
  UPDATE MEMBER
     SET MEM_REGNO1='010409',
         MEM_REGNO2='4234565',
         MEM_BIR=TO_DATE('20010409')
     WHERE MEM_ID='d001';    

UPDATE MEMBER
     SET MEM_REGNO1='000323',
         MEM_REGNO2='3011014',
         MEM_BIR=TO_DATE('20000323')
     WHERE MEM_ID='n001';
     
UPDATE MEMBER
     SET MEM_REGNO1='020131',
         MEM_REGNO2='4402712',
         MEM_BIR=TO_DATE('20020131')
     WHERE MEM_ID='v001'; 
     
       SELECT  MEM_ID,MEM_REGNO1,MEM_REGNO2,MEM_BIR
           FROM MEMBER
           WHERE MEM_ID IN('doo1','v001','n001');

��뿹)ȸ�����̺��� ����ȸ�������� ��ȸ�Ѵ�.(ȸ����ȣ, ȸ����, �������, ���ϸ���, ���)
      
    SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_BIR AS �������,
           MEM_MILEAGE AS ���ϸ���,
    CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2' OR
              SUBSTR(MEM_REGNO2,1,1)='4' THEN
                         '����ȸ��'
                   ELSE      
                         '����ȸ��'
            END AS ���
       FROM MEMBER
      WHERE SUBSTR(MEM_REGNO2,1,1)='2' --ANY('2','4')�� ����ص� ��
          OR
            SUBSTR(MEM_REGNO2,1,1)='4';
      
     
     ��������: (NOT, AND, OR)--�켱����NOT-AND-OR
     .NOT: ������
     ------------------------------------
      �Է�         ���
     A   B        (OR)    (AND)   (EX-OR)
     ------------------------------------
     0   1         0        0       0
     0   1         1        0       1
     1   0         1        0       1
     1   1         1        1       0
     ------------------------------------
     
��뿹)������̺��� ��ձ޿� �̻� �޿��� �޴� ����� ��ȸ�Ͻÿ�

    SELECT EMPLOYEE_ID AS �����ȣ,
           FIRST_NAME||' '||LAST_NAME AS �����,
           SALARY AS �޿�,
           DEPARTMENT_ID AS �μ���ȣ,
           ROUND((SELECT AVG(SALARY)
                     FROM HR.EMPLOYEES),0) AS ��ձ޿�
        FROM HR.EMPLOYEES
        WHERE NOT SALARY < (SELECT AVG(SALARY)
                            FROM HR.EMPLOYEES)
        ORDER BY 4;                    
     ��Ÿ������: (IN, ANY, SOME, ALL, EXISTS, BETWEEN(���������Ҷ�)_, LIKE(������ ���Ҷ�)�� ����)
     --IN,ANY,SOME,ALL,EXISTS�� ���������Ͱ� �ϳ��̻� �����ؾ��Ѵ�.
     
     1.IN--���������� �ұ�Ģ�� �����͸� ���Ҷ� ����Ѵ�,
     -�־��� �� �� ��� �ϳ��� ��ġ�ϸ� TRUE�� ��ȯ
     -OR �����ڷ� ġȯ ����
     -NOT �����ڿ� �Բ� ��밡��
     (�������)
    expr IN(��1[,��2,....)

��뿹)������̺��� 10,30,40,60�� �μ��� ���� ������� �����ȣ,�����,�μ��ڵ�,�Ի����� �����Ͻÿ�
  