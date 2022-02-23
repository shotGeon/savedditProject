2021-0805-01)User Defined Function(�Լ�)
    - ���ν����� ���� ���� ����
    - ��ȯ ���� ����
    - ���� ���Ǵ� �������� �Ǵ� ������ ����� ���� �Լ��� ����
    - SELECT ���� SELECT��, WHERE ���� ��� ����
    
    (�������)
    CREATE [OR REPLACE] FUNCTION �Լ���[(
    �Ű����� [MODE] Ÿ�� [:=��][,
                .
                .
    �Ű����� [MODE] Ÿ�� [:=��]])]
    RETURN ������ Ÿ��
  IS|AS
    ���𿵿�
  BEGIN ---RETURN ��ɿ� ���ؼ� ������ ��ȯ�Ǵ� ���̴�.
    ���࿵��
    RETURN ��|expr;
  END;
   'RETURN ������ Ÿ��' : ��ȯ�� ������ Ÿ��
   'RETURN ��|expr' : ��ȯ�ؾ��ϴ� ���̳� ���� �����ϴ� ���� ������ �ݵ�� 1�� �̻� ���� �ؾ���
   
��뿹)'����'�� ȸ����ȣ�� �Է¹޾� �ش�ȸ���� 2005�� 6�� ���űݾ��� ����ϴ� 
     �Լ��� �ۼ��Ͻÿ�.
     
    (�Լ�)
      CREATE OR REPLACE FUNCTION FN_SUM01(
        P_MID MEMBER.MEM_ID%TYPE)--DEFAULT�� IN �̱⶧���� �����ϸ� IN�̴�. OUT�� �ݵ�� ���
        RETURN NUMBER
      IS 
        V_SUM NUMBER:=0; --���űݾ� �հ�
        V_CNT NUMBER:=0; --�ش�ȸ���� �ڷ�(CART) ��������
                
      BEGIN
        SELECT COUNT(*) INTO V_CNT
          FROM CART
         WHERE CART_NO LIKE '200506%'
           AND CART_MEMBER=P_MID;
           
        IF V_CNT!=0 THEN
           SELECT SUM(A.CART_QTY*B.PROD_PRICE) INTO V_SUM
             FROM CART A, PROD B
            WHERE A.CART_NO LIKE '200506%' 
              AND A.CART_MEMBER=P_MID
              AND A.CART_PROD=B.PROD_ID;
        ELSE
          V_SUM:=0;
        END IF;
        RETURN V_SUM;
      END;
   
   
   (����)
       SELECT MEM_ID AS ȸ����ȣ,
              MEM_NAME AS ȸ����,
              MEM_ADD1||''||MEM_ADD2 AS �ּ�,
              FN_SUM01(MEM_ID) AS ���űݾ� 
         FROM MEMBER
        WHERE MEM_ADD1 LIKE '����%'
        ORDER BY 1;
 
 ��뿹)��ǰ�ڵ�� �⵵ �� ���� �Է¹޾� �ش� ��ǰ�� ���ż����� ���űݾ��� ����ϴ� �Լ��� 
       �ۼ��Ͻÿ�
       
      (�Լ�) : FN_BUY01
      
        CREATE OR REPLACE FUNCTION FN_BUY01(
          P_PID PROD.PROD_ID%TYPE,
          P_YEAR CHAR,
          P_MONTH CHAR)
          RETURN VARCHAR2
        IS
          V_DATE DATE:=TO_DATE(P_YEAR||P_MONTH||'01');
          V_AMT NUMBER:=0; --���Լ���
          V_SUM NUMBER:=0; --���űݾ��հ�
          V_CNT NUMBER:=0; --�ڷ��(�ڷ����� �Ǵ�)
          V_RES VARCHAR2(100);
        BEGIN
          SELECT COUNT(*) INTO V_CNT
            FROM BUYPROD
           WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
             AND BUY_PROD=P_PID;
             
           IF V_CNT != 0 THEN
             SELECT SUM(BUY_QTY),SUM(BUY_QTY*BUY_COST) 
               INTO V_AMT,V_SUM
               FROM BUYPROD
               WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
                 AND BUY_PROD=P_PID;
           ELSE
              V_SUM:=0;
              V_AMT:=0;
           END IF;
           V_RES:='���ż���: '||V_AMT||','||'���űݾ�'||V_SUM;
           RETURN V_RES;
        END;
        
        (����)
          SELECT '2005-05',PROD_ID,PROD_NAME,FN_BUY01(PROD_ID,'2005','05')
            FROM PROD;
          
   
        (�ٸ�����) --������ OUT�Ű������� ���� ��ȯ,�ݾ��� ���Ͻðܼ� 
        CREATE OR REPLACE FUNCTION FN_BUY02(
          P_PID PROD.PROD_ID%TYPE,
          P_YEAR CHAR,
          P_MONTH CHAR,
          P_AMT OUT NUMBER)
          RETURN NUMBER
        IS
          V_DATE DATE:=TO_DATE(P_YEAR||P_MONTH||'01');
          V_AMT NUMBER:=0; --���Լ���
          V_SUM NUMBER:=0; --���űݾ��հ�
          V_CNT NUMBER:=0; --�ڷ��(�ڷ����� �Ǵ�)
        BEGIN
          SELECT COUNT(*) INTO V_CNT
            FROM BUYPROD
           WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
             AND BUY_PROD=P_PID;
            
            IF V_CNT != 0 THEN
             SELECT SUM(BUY_QTY),SUM(BUY_QTY*BUY_COST) 
               INTO V_AMT,V_SUM
               FROM BUYPROD
               WHERE BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE)
                 AND BUY_PROD=P_PID;
            ELSE
              V_SUM:=0;
              V_AMT:=0;
            END IF;
            P_AMT:=V_AMT;
            RETURN V_SUM;
          END;
        
        (����)
            DECLARE
              V_AMT NUMBER:=0;
              V_SUM NUMBER:=0;
              CURSOR CUR_PROD IS
                SELECT PROD_ID,PROD_NAME
                  FROM PROD;
            BEGIN
              FOR REC IN CUR_PROD LOOP
                 V_SUM:=FN_BUY02(REC.PROD_ID,'2005','05',V_AMT);--�Լ��� ��𼭳� ���� �ִ�. ������ SELECT ���� �����ϰ� 
                                                                --����Ҷ��� �ݵ�� ���� ���� ������ ������ �־�� �Ѵ�.
                 DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||REC.PROD_ID);
                 DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ� : '||REC.PROD_NAME);
                 DBMS_OUTPUT.PUT_LINE('���Լ��� : '||V_AMT);
                 DBMS_OUTPUT.PUT_LINE('���Աݾ� : '||V_SUM);
                 DBMS_OUTPUT.PUT_LINE('----------------------------');
              END LOOP;
            END;
   
   
��뿹)�⵵�� ���� 6�ڸ� ���ڿ� �Է� �޾� �ش���� ���� ���� ��ǰ�� ����(�ݾױ���)�� ȸ���� �̸���
      ���űݾ��� ����ϴ� �Լ��� �ۼ��Ͻÿ�
      �Լ���:FN_MAXMEM
      
      CREATE OR REPLACE FUNCTION FN_MAXMEM(
      P_DAY CHAR)
      RETURN VARCHAR2
      IS
--       V_DATE CHAR(7):=P_DAY||'%';
       V_MNAME MEMBER.MEM_NAME%TYPE;
       V_SUM NUMBER:=0;
       V_RES VARCHAR(100);
     BEGIN
     SELECT A.MNM,A.SCP INTO V_MNAME,V_SUM
       FROM(SELECT SUM(A.CART_QTY*B.PROD_PRICE) AS SCP,
                   C.MEM_NAME AS MNM
              FROM CART A,PROD B,MEMBER C
             WHERE A.CART_NO LIKE P_DAY||'%'
               AND A.CART_PROD=B.PROD_ID
               AND A.CART_MEMBER=C.MEM_ID
           GROUP BY C.MEM_NAME
           ORDER BY 1 DESC)A
        WHERE ROWNUM=1;
        
        V_RES:='����ȸ����: '||V_MNAME||','||'���űݾ�: '||TO_CHAR(V_SUM);
        RETURN V_RES;
        END;
        
        SELECT FN_MAXMEM('200506')FROM DUAL;
        
        (Ű����� �Է� ������)
        
        ACCEPT P_DAY PROMPT '���(YYYYMM) :'
        DECLARE
         V_RES VARCHAR2(100); 
         BEGIN
         V_RES:=FN_MAXMEM('&P_DAY');  
         DBMS_OUTPUT.PUT_LINE(V_RES);
         END;
        
        
        (����)
          SELECT B.MEM_NAME,SUM(A.CART_QTY*C.PROD_PRICE),FN_MAXMEM('200504')
            FROM CART A,MEMBER B,PROD C
            GROUP BY B.MEM_NAME;
       
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   
   
   
   
   
   
   
   
   
   