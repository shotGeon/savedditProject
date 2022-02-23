2021-0809-01) ������̺��� �����ȣ 125��(Julia Nayer)����� ������ 'ST_CLEAR'���� 
              'ST_MAN'���� �����Ǿ���. �� ������ ������̺� �ݿ��ϰ� �� �� 
              �������� ���̺��� �����Ͻÿ�.
              
    CREATE OR REPLACE TRIGGER TG_JOB_CHANGE
    AFTER UPDATE ON EMPLOYEES
    FOR EACH ROW -- NEW, OLD �� ������.
    DECLARE
      V_EID EMPLOYEES.EMPLOYEE_ID%TYPE:= :OLD.EMPLOYEE_ID; --125�� ���� �־��൵�ȴ�.
      V_CNT NUMBER := 0; 
      V_SDATE DATE; --���� ����
      V_EDATE DATE; --���� ����
    BEGIN
    SELECT COUNT(*) INTO V_CNT
        FROM JOB_HISTORY
       WHERE EMPLOYEE_ID = 125; 

       IF V_CNT = 0 THEN
          V_SDATE := :OLD.HIRE_DATE+1;
          V_EDATE := SYSDATE-1;
       ELSE 
          SELECT A.END_DATE INTO V_SDATE
            FROM (SELECT START_DATE, END_DATE
                    FROM JOB_HISTORY
                   WHERE EMPLOYEE_ID = 125
                   ORDER BY 2 DESC)A
           WHERE ROWNUM = 1;
          V_SDATE:= V_SDATE + 1;
          V_EDATE:= SYSDATE - 1;
        END IF;
         INSERT INTO JOB_HISTORY
           VALUES(V_EID, V_SDATE, V_EDATE, :OLD.JOB_ID, :OLD.DEPARTMENT_ID);
    END;
                  
        ����)
        DECLARE
        BEGIN     
         UPDATE EMPLOYEES
            SET (SALARY,JOB_ID)=(SELECT A.MIN_SALARY,'ST_MAN'
                                   FROM (SELECT MIN_SALARY
                                           FROM JOBS
                                          WHERE JOB_ID='ST_MAN')A)    
         WHERE EMPLOYEE_ID=125;
        END;
           
      ROLLBACK;     
        
                             