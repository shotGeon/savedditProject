2021-0804-02)���� ���ν���(stored Procedure)
 -������ ����� �����ϵ� Ư�������� ���� ���
 -ó���ӵ��� ��� : ���ν��� ���� ��� ������ �ϳ��� Batch�� �ν��Ͽ� �ѹ��� �м� ��
  ����ȭ ��Ű�� ���� ��Ŵ
 -��Ʈ��ũ�� Traffic ���� : Client���� Server�� ������ SQL������ ������ �̸� ����
  �ϰ� �־� Client���� �ٷ��� SQL������� ���ν��� �̸��� �Ű������� ����
 -��ȯ���� ����
 
 (�������)
   CREATE [OR REPLACE] PROCEDURE ���ν�����[(
     �Ű����� [MODE] Ÿ�� [:=��][, 
         :
     �Ű����� [MODE] Ÿ�� [:=��]])]
    IS|AS
      ���𿵿�
    BEGIN
      ���࿵��
    END;
     .'OR REPLACE' : ���� �̸��� ���ν����� �����ϸ� OVERWRITE, ������, ���Ӱ� ����
     .'MODE' : �Ű������� ������ ��Ÿ���� IN (�Է¿�), OUT (��¿�), INOUT(����� ����)
      �� ����� �� ������ �����ϸ� IN���� ���� 
     .'Ÿ��' : �Ű������� ������ Ÿ������ ũ�⸦ �������� ���� 
     
    (�������-����)
      EXEC|EXECUTE ���ν�����[(�Ű�����list)];
      
      OR
      
      ���ν�����[(�Ű�����list)]; --�͸����̳� �ٸ� PL/SQL��ü ������ ����
      
��뿹)�⵵�� ���� ��ǰ�ڵ带 �Է� �޾� �ش���ǰ�� �԰������ �����Ͽ� ���������̺�
      ���� �ش� ��ǰ�� ��� �����ϴ� ���ν��� �ۼ�
      
      CREATE OR REPLACE PROCEDURE PROC_BUY_REMAIN(
       P_YEAR IN CHAR,
       P_MONTH IN VARCHAR2,
       P_PID   IN VARCHAR2)
       IS
         V_IAMT  NUMBER(5):=0;   --���Լ���
         V_FLAG  NUMBER:=0; --���Ի���� ���������� �Ǵ�
         V_DATE  DATE:=TO_DATE(P_YEAR||P_MONTH||'01'); --��¥
        BEGIN
          SELECT COUNT(*),SUM(BUY_QTY) INTO V_FLAG,V_IAMT
            FROM BUYPROD
           WHERE BUY_PROD=P_PID 
             AND BUY_DATE BETWEEN V_DATE AND LAST_DAY(V_DATE);
             
             IF V_FLAG !=0 THEN
             UPDATE REMAIN
                SET REMAIN_I=REMAIN_I+V_IAMT,
                    REMAIN_J_99=REMAIN_J_99+V_IAMT,
                    REMAIN_DATE=LAST_DAY(V_DATE)
              WHERE REMAIN_YEAR=P_YEAR
                AND PROD_ID=P_PID;
             END IF;       
         END;
         
       (����)
       EXECUTE PROC_BUY_REMAIN('2005','03','P201000017');

   ROLLBACK;
   
��뿹) �����ȣ�� �Է¹޾� �ش����� �Ҽӵ� �μ��� �μ���, �ο���, ��ձ޿���
       ��ȯ�޴� ���ν����� �ۼ��Ͻÿ�.
       
       CREATE OR REPLACE PROCEDURE PROC_EMP01(
       P_EID IN HR.EMPLOYEES.EMPLOYEE_ID%TYPE,
       P_DNAME OUT HR.EMPLOYEES.DEPARTMENT_NAME%TYPE,
       P_CNT OUT NUMBER,
       P_SAL OUT NUMBER)   
     IS 
     BEGIN
       SELECT B.DEPARTMENT_NAME,COUNT(*),ROUND(AVG(A.SALARY)) 
         INTO P_DNAME,P_CNT,P_SAL
         FROM HR.EMPLOYEES A,HR.DEPARTMENTS B
         WHERE A.EMPLOYEE_ID=P_EID
           AND A.DEPARTMENT_ID=B.DEPARTMENT_ID 
      GROUP BY B.DEPARTMENT_NAME;  
     END;
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      