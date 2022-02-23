2021-0804-02)저장 프로시저(stored Procedure)
 -서버에 저장된 컴파일된 특정목적을 위한 모듈
 -처리속도의 향상 : 프로시저 내의 모든 구문을 하나의 Batch로 인식하여 한번에 분석 및
  최적화 시키고 실행 시킴
 -네트워크의 Traffic 감소 : Client에서 Server로 전송할 SQL구문을 서버가 미리 저장
  하고 있어 Client에서 다량의 SQL구문대신 프로시저 이름과 매개변수만 전송
 -반환값이 없음
 
 (사용형식)
   CREATE [OR REPLACE] PROCEDURE 프로시져명[(
     매개변수 [MODE] 타입 [:=값][, 
         :
     매개변수 [MODE] 타입 [:=값]])]
    IS|AS
      선언영역
    BEGIN
      실행영역
    END;
     .'OR REPLACE' : 같은 이름의 프로시져가 존재하면 OVERWRITE, 없으면, 새롭게 생성
     .'MODE' : 매개변수의 성격을 나타내며 IN (입력용), OUT (출력용), INOUT(입출력 공용)
      을 사용할 수 있으며 생략하면 IN으로 간주 
     .'타입' : 매개변수의 데이터 타입으로 크기를 지정하지 않음 
     
    (사용형식-실행)
      EXEC|EXECUTE 프로시저명[(매개변수list)];
      
      OR
      
      프로시저명[(매개변수list)]; --익명블록이나 다른 PL/SQL객체 내에서 실행
      
사용예)년도와 월과 제품코드를 입력 받아 해당제품의 입고수량을 집계하여 재고수불테이블
      에서 해당 제품의 재고를 갱신하는 프로시져 작성
      
      CREATE OR REPLACE PROCEDURE PROC_BUY_REMAIN(
       P_YEAR IN CHAR,
       P_MONTH IN VARCHAR2,
       P_PID   IN VARCHAR2)
       IS
         V_IAMT  NUMBER(5):=0;   --매입수량
         V_FLAG  NUMBER:=0; --매입사실의 존재유무를 판단
         V_DATE  DATE:=TO_DATE(P_YEAR||P_MONTH||'01'); --날짜
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
         
       (실행)
       EXECUTE PROC_BUY_REMAIN('2005','03','P201000017');

   ROLLBACK;
   
사용예) 사원번호를 입력받아 해당사원이 소속된 부서의 부서명, 인원수, 평균급여를
       반환받는 프로시져를 작성하시오.
       
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
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      