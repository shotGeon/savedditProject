


   ACCEPT P_NUM PROMPT '�� �Է�: '
   DECLARE
     V_NUM NUMBER:=TO_NUMBER('&P_NUM');
     V_RES VARCHAR2(1000);
   BEGIN 
      IF MOD(V_NUM,2)=1 THEN
       V_RES:=TO_CHAR(V_NUM)||'�� Ȧ���Դϴ�';
      ELSE 
       V_RES:=TO_CHAR(V_NUM)||'�� ¦���Դϴ�';
      END IF;
 
       DBMS_OUTPUT.PUT_LINE(V_RES);
     END;
     
      ��뿹)ȸ�����̺��� ȸ������ ���ϸ����� ��ȸ�Ͽ�
        �� ���� 5000 �̻��̸� 'VIP ȸ��'��
         "     3000 �̻��̸� '��ȸ��',
        �� �����̸� '��ȸ��'�� ȸ����ȣ,ȸ����,���ϸ����� �Բ� ����Ͻÿ�
        
        
     ��뿹)����ڷκ��� ���� ��뷮(�� ����)�� �Է� �޾� ��������� ����Ͽ� ����Ͻÿ�
      ��뷮(��)  �����ܰ�
       1-10       275
      11-20      305
      20-30      350
      30-40      415
      41�� �̻�   500��
      
      �ϼ��� �����: ��뷮*120��
      
      EX)27���� ����� ���
      ó�� 10�� : 275*10 = 2,750
      11-20    : 305*10 = 3,050
      ������ 7�� : 350*7 = 2,450
      ---------------------------
      �ϼ��� �����: 120*27=3,240
      ---------------------------
                           11,490                     
                           
     ACCEPT P_NUM PROMPT '(��)��뷮'
     
     DECLARE
     V_NUM NUMBER:= TO_NUMBER('&P_NUM');
     V_RES VARCHAR(100);
     
     BEGIN
        IF V_NUM<=10 THEN
        V_RES:='�� �����'||TO_CHAR(275*V_NUM+120*V_NUM)||'�Դϴ�.';
     ELSIF V_NUM<=20 THEN
        V_RES:='�� �����'||TO_CHAR(10*275+(V_NUM-10)*305+120*V_NUM)||'�Դϴ�.';
     ELSIF V_NUM<=30 THEN
        V_RES:='�� �����'||TO_CHAR(10*275+10*305+(V_NUM-20)*350+120*V_NUM)||'�Դϴ�.';
     ELSIF V_NUM<=40 THEN
        V_RES:='�� �����'||TO_CHAR(10*275+10*305+10*350+415*(V_NUM-30)+120*V_NUM)||'�Դϴ�.';
       ELSE
        V_RES:='�� �����'||TO_CHAR(10*275+10*305+10*350+10*415+500*(V_NUM-40)+120*V_NUM)||'�Դϴ�.';
        END IF;
         DBMS_OUTPUT.PUT_LINE(V_RES);
     END;
     
     ��뿹)10-110 ������ ������ �߻����� �߻��� ������ �ش��ϴ� �μ��� ���� ����� ù��° ����� �޿��� ��ȸ�Ͽ� 
      5000�����̸� '���ӱ� ���',
      10000 �����̸� '����ӱ� ���',
      �� �̻��̸� '���ӱ� ���'�� �����ȣ, �����, �μ���� �Բ� ����Ͻÿ�
            
      DECLARE
      V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE;
      V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;
      V_DNAME HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE;
      V_SAL HR.EMPLOYEES.SALARY%TYPE;
      V_MESSAGE VARCHAR(20);
      V_DID HR.DEPARTMENTS.DEPARTMENT_ID%TYPE;
     
      BEGIN
         V_DID:= TRUNC(SYS.DBMS_RANDOM.VALUE(10,110),-1);
         SELECT A.EMPLOYEE_ID,A.EMP_NAME,B.DEPARTMENT_NAME,A.SALARY
           INTO V_EID,V_ENAME,V_DNAME,V_SAL
           FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
          WHERE V_DID=B.DEPARTMENT_ID
            AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
            AND ROWNUM=1;
            
            CASE WHEN V_SAL<=5000 THEN
                     V_MESSAGE:='���ӱ� ���';
                 WHEN V_SAL<=10000 THEN
                     V_MESSAGE:='����ӱ� ���';
                ELSE 
                    V_MESSAGE:='���ӱ� ���';
            END CASE;
            
          DBMS_OUTPUT.PUT_LINE('�μ���: '||V_DNAME);
          DBMS_OUTPUT.PUT_LINE('�����ȣ: '||V_EID);
          DBMS_OUTPUT.PUT_LINE('�����: '||V_ENAME);  
          DBMS_OUTPUT.PUT_LINE('���: '||V_MESSAGE);
      
        END;
        
    DECLARE    
    BEGIN
     FOR I IN 1..9 LOOP
     DBMS_OUTPUT.PUT_LINE(7||'*'||I||'='||7*I);
     END LOOP;
     END;
     
     DECLARE
     V_SUM NUMBER:=0; --�ѱݾ��հ�
     V_DSUM NUMBER:=100; --�Ϻ��ݾ�
     V_DAYS NUMBER:=0;
     
    BEGIN
        FOR I IN 1..1000LOOP
        V_SUM:=V_SUM+V_DSUM;
        V_DAYS:=I;
        IF V_SUM>2000000 THEN
        EXIT;
        END IF;
        V_DSUM:=V_DSUM*2;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('�ϼ�: '||V_DAYS);
        DBMS_OUTPUT.PUT_LINE('�ѱݾ�: '||V_SUM);
        
      END;
      
 DECLARE
  BEGIN
    FOR FUCK IN(SELECT A.PROD_ID AS PID,
                     A.PROD_NAME AS PNAME,
                    SUM(B.BUY_QTY) AS SBQ
                  FROM PROD A, BUYPROD B
                 WHERE A.PROD_ID=B.BUY_PROD
                   AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
                 GROUP BY A.PROD_ID,A.PROD_NAME)
    LOOP
        DBMS_OUTPUT.PUT_LINE('��ǰ�ڵ�: '||FUCK.PID);
        DBMS_OUTPUT.PUT_LINE('��ǰ��: '||FUCK.PNAME);
        DBMS_OUTPUT.PUT_LINE('�԰����: '||FUCK.SBQ);
        DBMS_OUTPUT.PUT_LINE('----------------------');
    END LOOP;
    END;
  
  DECLARE
   BEGIN
     FOR I IN 1..9 LOOP
       FOR J IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(I||'*'||J||'='||I*J);
        END LOOP;
      END LOOP; 
   END;  
    
     
     SELECT A.PROD_ID AS PID,
            A.PROD_NAME AS PNAME,
            SUM(B.BUY_QTY) AS SBQ
        FROM PROD A, BUYPROD B
        WHERE A.PROD_ID=B.BUY_PROD
          AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
      GROUP BY A.PROD_ID,A.PROD_NAME
                           
                           