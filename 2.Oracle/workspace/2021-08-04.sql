2021-0804-01)
  (3)FOR ��
   . ���߾���� FOR���� ������ ����
   . �Ϲ� �ݺ�ó���� ���� FOR���� CURSORó���� ���� FOR���� ����
   (�Ϲ� FOR�� �������)
     FOR �ε��� IN [REVERSE] �ʱⰪ..�ִ밪  LOOP
      �ݺ�ó����ɹ�(��);
     END LOOP;
     - '�ε���' : ������� ���� �ε����� �ý��ۿ��� �ڵ� ����
     - 'REVERSE' : �������� �ݺ�ó���� ���
     
��뿹) �������� 7���� ����Ͻÿ�

DECLARE
  BEGIN
   FOR I IN 1..9 LOOP
      DBMS_OUTPUT.PUT_LINE(7||'*'||I||'='||7*I);
     END LOOP; 
   END;
   
 
��뿹)
DECLARE
  V_SUM NUMBER:=0; --���� �� �հ�
  V_DSUM NUMBER:=100; --�Ϻ� ����ݾ�
  V_DAYS NUMBER:=0;
  BEGIN
   FOR I IN 1..1000 LOOP
    V_SUM:=V_SUM+V_DSUM;
      V_DAYS:=I;
     IF V_SUM >=2000000 THEN
       EXIT;
     END IF;
     V_DSUM:=V_DSUM*2;
     END LOOP;
     DBMS_OUTPUT.PUT_LINE('�ϼ�: '||V_DAYS);
     DBMS_OUTPUT.PUT_LINE('�ݾ�: '||V_SUM);
  END;
  
  (CURSOR�� ���� FOR�� �������)
     FOR ���ڵ�� IN Ŀ����|Ŀ������  LOOP
      �ݺ�ó����ɹ�(��);
     END LOOP;
      .'���ڵ��' : Ŀ���� ����Ű�� ���� ���� ������ �ִ� ������ �ý��ۿ��� ����
      . Ŀ������ ����(�÷�)�� ������ '���ڵ��.Ŀ���� �÷���' �������� ���
      . Ŀ���� OPEN, FETCH, CLOSE ��� ����
      . 'Ŀ������':���𿵿����� �����ؾ��� Ŀ������ �� 'SELECCT'���� ���������������� ���  
      
      
  1��))2005�� 5�� �԰��ǰ�� �����Ȳ�� ��ȸ�ϴ� ����� �ۼ��Ͻÿ�.
      Alias�� ��ǰ�ڵ�,��ǰ��,����    
  
   DECLARE
     CURSOR CUR_BUY01 IS 
        SELECT B.BUY_PROD AS BID,
               A.PROD_NAME AS PNAME,
               SUM(B.BUY_QTY) AS AMT 
          FROM PROD A,BUYPROD B
         WHERE A.PROD_ID=B.BUY_PROD
           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
         GROUP BY B.BUY_PROD,A.PROD_NAME;
    BEGIN 
      FOR REC1 IN CUR_BUY01 LOOP 
        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||REC1.BID);
        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||REC1.PNAME);
        DBMS_OUTPUT.PUT_LINE('�԰���� : '||REC1.AMT);
        DBMS_OUTPUT.PUT_LINE('---------------------');
      END LOOP;
    END;
     
   DECLARE  
    BEGIN 
      FOR REC1 IN(SELECT B.BUY_PROD AS BID,
                         A.PROD_NAME AS PNAME,
                         SUM(B.BUY_QTY) AS AMT 
                         FROM PROD A,BUYPROD B
                         WHERE A.PROD_ID=B.BUY_PROD
                           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
                         GROUP BY B.BUY_PROD,A.PROD_NAME) 
      LOOP 
        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||REC1.BID);
        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||REC1.PNAME);
        DBMS_OUTPUT.PUT_LINE('�԰���� : '||REC1.AMT);
        DBMS_OUTPUT.PUT_LINE('---------------------');
      END LOOP;
    END;  
  
  
  
  
  
  
  
  
  
  
  
  
  