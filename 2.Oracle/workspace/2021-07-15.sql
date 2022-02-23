2021-0715-01)
3.��¥�Լ�
 1)SYSDATE
  -�ý��ۿ��� �����ϴ� ��¥����(��,��,��,��,��,��) ��ȯ
  -'+','-'������ ���
  -��¥ - ��¥ : �� ��¥ ������ ����(DAYS) ��ȯ
  
��뿹)SELECT SYSDATE-10,
             TO_CHAR(SYSDATE, 'YYYY MM DD HH24:MI:SS'),--������ ���� ���ڿ��� ���
             TRUNC(SYSDATE-TO_DATE('19900715'))
         FROM DUAL;

 2) ADD_MONTHS(d,n)
   -��¥ ������ �ڷ� d�� n��ŭ�� ���� ���� ��¥ ��ȯ
��뿹)����� ���� �Ի����� ���� 3������ ���� ��¥�̴�. �� ����� �� ȸ�翡 ó�� �������� �Ի���
      ��¥�� ���Ͻÿ� (�����ȣ, �����, �Ի���, �����Ի���, �ҼӺμ���)
  --JOIN�� ���谡 �ξ����� ����� �� �ִ�.WHERE���� ������ �� ����.    
      SELECT A.EMPLOYEE_ID AS �����ȣ,
             A.EMP_NAME AS �����,
             A.HIRE_DATE AS �Ի���,
             ADD_MONTHS(A.HIRE_DATE,-3) AS �����Ի���, 
             B.DEPARTMENT_NAME AS �ҼӺμ���             
             FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
             WHERE A.DEPARTMENT_ID=B.DEPARTMENT_ID
             ORDER BY 5;
3)NEXT_DAY(d,expr)
    -�־��� ��¥ d���� �ٰ��� ���� ���� 'expr'������ ��¥ ��ȯ
    -expr : ��,ȭ,....,��,������,ȭ����,...�Ͽ���

��뿹)SELECT NEXT_DAY(SYSDATE,'��'),
             NEXT_DAY(SYSDATE,'��'),
             NEXT_DAY(SYSDATE,'�Ͽ���')
        FROM DUAL;
        
4) LAST_DAY(d)
  -��¥�ڷ� d�� ���Ե� ���� ������ ���� ��ȯ

��뿹)�������̺�(BUYPROD)���� 2���� ���Ե� ���԰Ǽ��� ��ȸ�Ͻÿ�
       SELECT COUNT(*) AS ���԰Ǽ�
       FROM BUYPROD
       WHERE BUY_DATE BETWEEN TO_DATE('20050201') AND LAST_DAY(TO_DATE('20050201'));

5) MONTHS_BETWEEN(d1,d2)
  -�� ��¥ �ڷ� ������ ���� ��ȯ
  
  
��뿹)SELECT EMP_NAME,
             HIRE_DATE,
             TRUNC(MONTHS_BETWEEN (SYSDATE, HIRE_DATE)/12)||'��'||
             MOD(TRUNC(MONTHS_BETWEEN (SYSDATE, HIRE_DATE)),12)||'��' AS �ټӰ�����
        FROM HR.EMPLOYEES;

6) EXTRACT(fmt FROM d)
 - ��¥�ڷ� d ���� 'fmt'�� ����� �ڷḦ ������
 - ��ȯ���� ������ ����������
 - 'fmt': YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
 
��뿹)
      SELECT EXTRACT(HOUR FROM SYSTIMESTAMP),
             EXTRACT(MINUTE FROM SYSTIMESTAMP),
             EXTRACT(SECOND FROM SYSTIMESTAMP)
        FROM DULAL;
        
��뿹)�̹� �޿� ������ �ִ� ȸ�������� ��ȸ�Ͻÿ�
     Ailas�� ȸ����ȣ, ȸ����, ������� �̴�.
     SELECT MEM_ID AS ȸ����ȣ,
            MEM_NAME AS ȸ����,
            MEM_BIR AS �������
         FROM MEMBER
         WHERE EXTRACT(DAY FROM MEM_BIR)= EXTRACT(DAY FROM SYSDATE);







