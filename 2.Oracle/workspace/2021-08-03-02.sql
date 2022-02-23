2021-0803-02) Ŀ��(CURSOR)
  -����Ŭ SQL��ɹ��� ���� ������� ����� ����
  -SELECT���� ���� ��ȯ�� ��� ������ ����� ���ʴ�� �����ؾ� �ϴ� ��� ���
  -�����ڰ� ����� ���������� ������ �ʿ䰡 �ִ� ��� ���
  -IMPLICITE, EXPLICITE, CURSOR
  -Ŀ���� ����� FOR���� �����ϰ� ����(����)->OPEN->FETCH->CLOSE �ܰ踦 ���ʴ�� ����
  (1)�͸�Ŀ��(IMPLICITE CURSOR)
   . �̸��� ���� Ŀ��
   . SELECT���� ����Ǹ� ���(Ŀ��)�� �ڵ����� OPEN�� �� ��� ����� �Ϸ�� ���� �ڵ����� 
     CLOSE ��(���� �Ұ���)
   . Ŀ���Ӽ�
     SQL%ISOPEN : Ŀ���� OPEN �����̸� ��(true) ��ȯ- �׻� ����(�͸�Ŀ���϶�)(false),
     SQL%NOTFOUND : Ŀ���� �ڷᰡ �������� ������ ��(true) ��ȯ
     SQL%FOUND : Ŀ���� �ڷᰡ ���������� ��(true) ��ȯ
     SQL%ROWCOUNT : Ŀ���� �����ϴ� �ڷ��� ����
   
   (2)Ŀ��(EXPLICITE CURSOR)
    . �̸��� �ο��� Ŀ��
    . ����ο��� ����
    
    (��������-�����)
     CURSOR Ŀ����[(������ Ÿ�Ը�,[������ Ÿ�Ը�,...])]--ũ��� �Ⱦ���
     IS
       SELECT ��;
     
     (�����)  
      OPEN Ŀ����[(�Ű�����[,�Ű�����,...])]; --�ݺ��� �ۿ��� ����
      
      FETCH Ŀ���� INTO ����list; --�ݺ��� �ȿ���
      
      CLOSE Ŀ����; --�ݺ��� �ۿ���
       
��뿹1)2005�� 5�� �԰��ǰ�� �����Ȳ�� ��ȸ�ϴ� ����� Ŀ���� �̿��Ͽ� �ۼ��Ͻÿ�.
      Alias�� ��ǰ�ڵ�,��ǰ��,����
     
     DECLARE
       V_PID PROD.PROD_ID%TYPE;
       V_PNAME PROD.PROD_NAME%TYPE;
       V_AMT NUMBER:=0;
       V_CNT NUMBER:=0;
       CURSOR CUR_BUY01(PDATE DATE) IS 
        SELECT DISTINCT BUY_PROD
           FROM BUYPROD
           WHERE BUY_DATE BETWEEN PDATE AND LAST_DAY(PDATE);
     BEGIN
      OPEN CUR_BUY01(TO_DATE('20050501'));
      LOOP 
        FETCH CUR_BUY01 INTO V_PID;
        EXIT WHEN CUR_BUY01%NOTFOUND;
        SELECT COUNT(*) INTO V_CNT
          FROM CART
          WHERE CART_PROD=V_PID
            AND CART_NO LIKE '200505%';
            
         IF V_CNT !=0 THEN         
            SELECT PROD_NAME,SUM(CART_QTY) INTO V_PNAME,V_AMT
              FROM CART,PROD
             WHERE CART_PROD=V_PID
               AND CART_PROD=PROD_ID
               AND CART_NO LIKE '200505%'
             GROUP BY PROD_NAME;
            
            DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||V_PID);
            DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_PNAME);
            DBMS_OUTPUT.PUT_LINE('�Ǹż��� : '||V_AMT);
            DBMS_OUTPUT.PUT_LINE('----------------------');
         END IF;  
        END LOOP;       
      CLOSE CUR_BUY01;    
     END;
     
��뿹2)2005�⵵ ��ǰ�� �԰�����հ踦 ����ϴ� ����� Ŀ���� �̿��Ͽ� �ۼ��Ͻÿ�
     Alias�� ��ǰ�ڵ�, ��ǰ��, �԰����
     
 
����)��1���� 2���� WHILE���� ����Ͽ� �ۼ��Ͻÿ�  




1��))2005�� 5�� �԰��ǰ�� �����Ȳ�� ��ȸ�ϴ� ����� Ŀ���� �̿��Ͽ� �ۼ��Ͻÿ�.
      Alias�� ��ǰ�ڵ�,��ǰ��,����
      
    DECLARE
       V_PID PROD.PROD_ID%TYPE;
       V_PNAME PROD.PROD_NAME%TYPE;
       V_AMT NUMBER:=0;
       V_CNT NUMBER:=0;
       CURSOR CUR_BUY01(PDATE DATE) IS 
        SELECT DISTINCT BUY_PROD
           FROM BUYPROD
           WHERE BUY_DATE BETWEEN PDATE AND LAST_DAY(PDATE);
   BEGIN
     OPEN CUR_BUY01(TO_DATE('20050501'));
     FETCH CUR_BUY01 INTO V_PID;
       WHILE CUR_BUY01%FOUND LOOP 
         SELECT COUNT(*) INTO V_CNT
           FROM CART
           WHERE CART_PROD=V_PID
             AND CART_NO LIKE '200505%';
             
             IF V_CNT!=0 THEN       
             SELECT PROD_NAME,SUM(CART_QTY) INTO V_PNAME,V_AMT
               FROM CART,PROD
              WHERE CART_PROD=V_PID
                AND CART_PROD=PROD_ID
                AND CART_NO LIKE '200505%'
              GROUP BY PROD_NAME;
            
             DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||V_PID);
             DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_PNAME);
             DBMS_OUTPUT.PUT_LINE('�Ǹż��� : '||V_AMT);
             DBMS_OUTPUT.PUT_LINE('----------------------');
          END IF; 
          FETCH CUR_BUY01 INTO V_PID;  
        END LOOP;       
      CLOSE CUR_BUY01;    
     END;   
 
��뿹2)2005�⵵ ��ǰ�� �԰�����հ踦 ����ϴ� ����� Ŀ���� �̿��Ͽ� �ۼ��Ͻÿ�
     Alias�� ��ǰ�ڵ�, ��ǰ��, �԰����
      DECLARE
        V_PID PROD.PROD_ID%TYPE;
        V_PNAME PROD.PROD_NAME%TYPE;
        V_AMT NUMBER:=0;
     CURSOR CUR_BUY01 IS 
        SELECT A.PROD_ID,A.PROD_NAME,SUM(B.BUY_QTY) 
          FROM PROD A,BUYPROD B
         WHERE A.PROD_ID=B.BUY_PROD
           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
         GROUP BY A.PROD_ID,A.PROD_NAME;
    BEGIN 
     OPEN CUR_BUY01;
       FETCH CUR_BUY01 INTO V_PID,V_PNAME,V_AMT;
      WHILE CUR_BUY01%FOUND LOOP
       FETCH CUR_BUY01 INTO V_PID,V_PNAME,V_AMT;
     
        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||V_PID);
        DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||V_PNAME);
        DBMS_OUTPUT.PUT_LINE('�԰���� : '||V_AMT);
     
      END LOOP;
    CLOSE CUR_BUY01;
    END;
     
     
     
     
     
     
     
  