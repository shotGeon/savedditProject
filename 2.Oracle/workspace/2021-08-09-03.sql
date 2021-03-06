**사원테이블에 퇴직일자컬럼을 추가하시오 컬럼명:RETIRE_DATE DATE
  ALTER TABLE EMPLOYEES
    ADD RETIRE_DATE DATE;
    
    COMMIT;
    
    사용예)
     사원관리에 필요한 함수 등을 관리
     - 패키지명 :PKG_EMP
     - FN_GET_NAME: 사원번호를 입력받아 이름을 반환하는 함수
     - PROC_NEW_EMP: 신규사원정보 입력 프로시저(사원번호,LAST_NAME,이메일,입사일,JOB_ID)--NULLABLE을 허용하지 않는것들
     - PROC_RETIRE_EMP: 퇴직자처리 프로시저(사원번호 입력)
     
     패키지선언)
     
     CREATE OR REPLACE PACKAGE PKG_EMP
     IS
      --이름반환 함수
      FUNCTION FN_GET_NAME(
      P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
      RETURN VARCHAR2;--이름 반환
      
      --신규사원정보 입력 프로시저
      PROCEDURE PROC_NEW_EMP(
        P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE,
        P_LNAME IN EMPLOYEES.LAST_NAME%TYPE,
        P_EMAIL IN EMPLOYEES.EMAIL%TYPE,
        P_JOB_ID IN JOBS.JOB_ID%TYPE);
        
      --퇴직자처리 프로시저
      PROCEDURE PROC_RETIRE_EMP(
      P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE);
      
     END PKG_EMP; 
     
 (패키지 본문부)
      CREATE OR REPLACE PACKAGE BODY PKG_EMP
      IS 
         FUNCTION FN_GET_NAME(
            P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
           RETURN VARCHAR2
         IS
           V_ENAME EMPLOYEES.EMP_NAME%TYPE;
         BEGIN
           SELECT EMP_NAME INTO V_ENAME
             FROM EMPLOYEES
            WHERE EMPLOYEE_ID=P_EID;
            
            RETURN V_ENAME;
           END FN_GET_NAME; 
           
         PROCEDURE PROC_NEW_EMP(
           P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE,
           P_LNAME IN EMPLOYEES.LAST_NAME%TYPE,
           P_EMAIL IN EMPLOYEES.EMAIL%TYPE,
           P_JOB_ID IN JOBS.JOB_ID%TYPE)
         IS
         BEGIN
           INSERT INTO EMPLOYEES(EMPLOYEE_ID,LAST_NAME,EMAIL,JOB_ID,HIRE_DATE,EMP_NAME)
            VALUES(P_EID,P_LNAME,P_EMAIL,P_JOB_ID,SYSDATE-1,P_LNAME||'길동');
          COMMIT;
         END PROC_NEW_EMP;
         
         PROCEDURE PROC_RETIRE_EMP(
             P_EID IN EMPLOYEES.EMPLOYEE_ID%TYPE)
         IS
         BEGIN
           UPDATE EMPLOYEES
              SET RETIRE_DATE=SYSDATE
            WHERE EMPLOYEE_ID=P_EID;
           COMMIT;
        END PROC_RETIRE_EMP;
      END PKG_EMP;           
     
     실행)
      SELECT EMPLOYEE_ID,PKG_EMP.FN_GET_NAME(EMPLOYEE_ID)
        FROM EMPLOYEES
       WHERE DEPARTMENT_ID=60;
       
      EXECUTE PKG_EMP.PROC_NEW_EMP(250,'홍','gdhong@gmail.com','FI_ACCOUNT');
      
      EXECUTE PKG_EMP.PROC_RETIRE_EMP(150);
     
     
     
     ROLLBACK;
     
     
     
     
     
     
     
     
     
     