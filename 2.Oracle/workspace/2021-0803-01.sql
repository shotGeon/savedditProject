2021-0803-01)
  (2) CASE��
   . ǥ�� SQL�� SELECT ���� ���Ǵ� CASEǥ���İ� ����
   . ���� �б� ��� ����
   (������� 1)
    CASE ����|���� WHEN ��1 THEN
                      ���1;
                  WHEN ��2 THEN
                      ���2;
                       .
                       .
                  ELSE ���n;
    END CASE;
    
    
    (������� 2)
    CASE WHEN ����1 THEN
              ���1;
         WHEN ����2 THEN
              ���2;
               .
               .
          ELSE ���n;
    END CASE;
        
��뿹)10-110 ������ ������ �߻����� �߻��� ������ �ش��ϴ� �μ��� ���� ����� ù��° ����� �޿��� ��ȸ�Ͽ� 
      5000�����̸� '���ӱ� ���',
      10000 �����̸� '����ӱ� ���',
      �� �̻��̸� '���ӱ� ���'�� �����ȣ, �����, �μ���� �Բ� ����Ͻÿ�
      
      DECLARE
        V_EID HR.EMPLOYEES.EMPLOYEE_ID%TYPE;  --�����ȣ
        V_ENAME HR.EMPLOYEES.EMP_NAME%TYPE;   --����̸�
        V_DNAME HR.DEPARTMENTS.DEPARTMENT_NAME%TYPE;  --�μ���
        V_SAL HR.EMPLOYEES.SALARY%TYPE; --�޿�
        V_MESSAGE VARCHAR2(20);  --����
        V_DID HR.EMPLOYEES.DEPARTMENT_ID%TYPE;  --�μ���ȣ(����)
      BEGIN
        V_DID:=TRUNC(SYS.DBMS_RANDOM.VALUE(10,110),-1); --�����ڸ��� �߶� 0���� �����
        SELECT A.EMPLOYEE_ID,A.EMP_NAME,B.DEPARTMENT_NAME,A.SALARY
          INTO V_EID,V_ENAME,V_DNAME,V_SAL 
          FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
         WHERE A.DEPARTMENT_ID=V_DID
           AND B.DEPARTMENT_ID=A.DEPARTMENT_ID
           AND ROWNUM=1;
                
        CASE WHEN V_SAL<=5000 THEN
                  V_MESSAGE:='���ӱݻ��';
             WHEN V_SAL<=10000 THEN
                  V_MESSAGE:='����ӱݻ��';
             ELSE
                 V_MESSAGE:='���ӱݻ��';
        END CASE;
        
        DBMS_OUTPUT.PUT_LINE('�μ��� : '||V_DNAME);
        DBMS_OUTPUT.PUT_LINE('�����ȣ :'||V_EID);
        DBMS_OUTPUT.PUT_LINE('����� :'||V_ENAME);
        DBMS_OUTPUT.PUT_LINE('��� :'||V_MESSAGE);  
        END;
    
    2) �ݺ���
     . ����Ŭ�� �ݺ����� LOOP, WHILE, FOR���� �����ȴ�.
    (1)LOOP�� --������ ���̵ɶ� �������´�.
     - �ݺ����� �⺻ ����
     (�������)
      LOOP
        �ݺ�ó����ɹ�(��);
        [EXIT WHEN ����;]
      END LOOP;
       . �⺻������ ���ѷ���
       . 'EXIT WHEN ����': ������ ��(true)�̸� �ݺ��� ���(END LOOP �������� ���� �̵�)
       
��뿹) �������� 7���� ����ϴ� ����� �ۼ��Ͻÿ�
     DECLARE 
        V_CNT NUMBER:=1;
        V_RES NUMBER:=0;
       BEGIN
         LOOP
           V_RES:=V_CNT*7;
           EXIT WHEN V_CNT>9;
           DBMS_OUTPUT.PUT_LINE(7||'*'||V_CNT||'='||V_RES);
           V_CNT:=V_CNT+1;
         END LOOP;
       END;
       
       
     (2) WHILE ��
      - ���߾���� WHILE���� ���� ��� �� ����
      (�������)
      WHILE ���� LOOP
        �ݺ�ó����ɹ�(��);
      END LOOP;
       .'����'�� ���̸� �ݺ� ����
       
��뿹)�������� 7���� ����Ͻÿ�
    DECLARE
      V_CNT NUMBER:=0;
      V_RES NUMBER:=0;
    BEGIN
       WHILE V_CNT<9 LOOP
       V_CNT:=V_CNT+1;
       V_RES:=7*V_CNT;
       DBMS_OUTPUT.PUT_LINE(7||'*'||V_CNT||'='||V_RES);
       END LOOP;
      END;
     












        
        
        
        
        
        
        
        
        

         