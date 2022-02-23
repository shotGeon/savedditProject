2021-0716-01)
4.��ȯ�Լ�
- Ư���������� �ٸ� Ÿ������ �Ͻ��� ����ȯ
- TO_CHAR, TO_DATE, TO_NUMBER, CAST
1)CAST(expr As Ÿ��)
 .'expr'�� ���ǵ� �ڷḦ 'Ÿ��'���·� �Ͻ��� �� ��ȯ
 
��뿹)
     SELECT MEM_NAME AS ȸ����,
            CAST(SUBSTR(MEM_REGNO1,1,2)AS NUMBER)+1900 AS ����⵵,
            EXTRACT(YEAR FROM SYSDATE)-(CAST(SUBSTR(MEM_REGNO1,1,2)AS NUMBER)+1900) AS ����
       FROM MEMBER
     WHERE NOT MEM_REGNO1 LIKE '0%';
     
2)TO_CHAR(expr[,fmt])
 . �־��� �ڷ� expr�� �������� ���ڿ� fmt�� ���߾� ���ڿ��� �����Ͽ� ��ȯ
 . expr�� ����, ��¥, ���ڿ�(CHAR, CLOB=>VARCHAR2��) Ÿ���� �ڷ�--�������̸� �ٲܼ��� ������ �������� Ÿ���� �Ұ���
 . ������ ����ȯ
 --�Լ��� ��ȯ���� �ֱ⶧���� ��� �������� �� �� ������ ���ν����� ��ȯ���� ���⶧���� ���������� ����ؾ� �Ѵ�.
-----------------------------------------------------------------------------
  �����������ڿ�            �ǹ�           ��뿹
-----------------------------------------------------------------------------
  CC                      ����          SELECT TO_CHAR(SYSDATE,'CC') FROM DUAL;
  AD,BC                   ����          SELECT TO_CHAR(SYSDATE,'CC BC YYYY"��"') FROM DUAL;
  YYYY,YYY,YY,Y           �⵵          SELECT TO_CHAR(SYSDATE,'CC BC YY"��"') FROM DUAL;
  Q                       �б�          SELECT TO_CHAR(SYSDATE, 'CC BC YYYY"��" Q"�б�"') FROM DUAL;
  MONTH, MON              ��            SELECT TO_CHAR(SYSDATE,'YYYY MON MONTH') FROM DUAL;--"N��"�����
  MM, RM                  ��            SELECT TO_CHAR(SYSDATE,'YYYY MM RM') FROM DUAL; --07,VII
  W, WW, WWW              ����           
  DD, DDD, J              ��           SELECT TO_CHAR(SYSDATE,'YYYY MM DD DDD J') FROM DUAL; --DDD1�����Ϳ��ñ��� ����� �ϼ�
  DAY DY  D               ����          SELECT TO_CHAR(SYSDATE,'YYYY DAY DD DY D') FROM DUAL;
  AM, PM, A.M, P.M.       ����/����
  MI                      ��
  SS,SSSSS                ��             SELECT TO_CHAR(SYSDATE,'YYYY MM DD AM MI SSSS"��"')FROM DUAL;
  "���ڿ�"                 ���������� ����� ��ȯ ���ڿ�--�÷��� ��Ī���� ��� (AS "DFDFS")
  -------------------------------------------------------------------------------
  
  .���������������ڿ�
  -------------------------------------------------------------------------------
  �����������ڿ�             �ǹ�                            ��뿹
  -------------------------------------------------------------------------------
  9                   ���ڿ� �����Ǿ� ��ȿ���ڴ� ��ȿ���ڸ�     SELECT TO_CHAR(12345,'99,9999')FROM DUAL;
                      ����ϰ� ��ȿ�� 0�� ����ó��             
  0                   ���ڿ� �����Ǿ� ��ȿ���ڴ� ��ȿ���ڸ�     SELECT TO_CHAR(345,'00,000')FROM DUAL;
                      ����ϰ� ��ȿ�� 0�� 0�� ���
  $,L                 ȭ���ȣ ���                         SELECT TO_CHAR(12345, '$99,999') FROM DUAL;--�ڽ��� ������ ȭ������� L
  PR                  ������ '<>'�� ���� ���                SELECT TO_CHAR(-12345, '99,999PR') FROM DUAL;
  ,(COMMA)            �ڸ���
  .(DOT)              �Ҽ���
  X                   16������ ��ȯ ���                    SELECT TO_CHAR(255,'XXXX') FROM DUAL;
  ----------------------------------------------------------------------------------
  
  3)TO_NUMBER(expr[,fmt])
  . �־��� �ڷ� 'expr'�� ���� 'fmt' ���Ŀ� ���߾� ���ڷ� ��ȯ
  . 'expr'�� Ÿ���� ���ڿ� Ÿ���� �ڷ� --��¥�Ұ��� ���ڿ��� ����
  .'fmt'�� ��� ������� ����(���ڷ� ����ȯ ������ ���ĸ� ���� ����)
  .COMMA(,)���Ұ���
  .<>�� ��ȯ �Ұ���('-12345','99999PR')X
��뿹)SELECT TO_NUMBER('12345','9999900'),
             --TO_NUMBER('12345','99,999'),
             TO_NUMBER('12345','9999PR'),
             TO_NUMBER('12345')
        FROM DUAL;
             
4)TO_DATE(expr[,fmt])
 . �־��� �ڷ� 'expr'�� ���� 'fmt' ���Ŀ� ���߾� ���ڷ� ��ȯ
 . 'expr'�� Ÿ���� ���ڿ� Ÿ���� �ڷḸ ����
 . 'fmt'�� ��� ������� ����(��¥�� ����ȯ ������ ���ĸ� ���� ����)
 . �����ڷᰡ ��¥���Ŀ� �µ��� �����Ǿ�� ��
 
 ��뿹) SELECT TO_DATE('20200320', 'YYYYMMDD'),
               TO_DATE('20200320', 'YYYY-MM DD')+10, --�����̶� -��ȣ�� /������Ǿ�����.
               --TO_DATE('20200320', 'AM YYYYMMDD'),
               --TO_DATE('20200320', 'YYYY MONTH DD'),
               TO_DATE('20200320')
         FROM DUAL;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  