2021-0729-02)VIEW 객체
-가상의 테이블
-SELECT 문에 종속되지 않고 독립적 객체
-필요한 자료가 복수개의 테이블에 분산되어 있는 경우
-특정 테이블의 접근을 차단하고 필요한 정보를 제공해야하는 경우 사용
(사용형식)
 CREATE [OR REPLACE] VIEW 뷰이름[(컬럼list)]
 AS 
  SELECT 문
  [WITH CHECK OPTION]
  [WITH READ ONLY];
  .'OR REPLACE' :같은 이름의 뷰가 존재하면 대치하고 없으면 새롭게 생성
  .'컬럼list' :뷰에서 사용할 컬럼명, 생략하면 SELECT문에 사용된 컬럼별칭 또는 컬럼명이 뷰의
               컬럼명으로 사용됨
  .'WITH CHECK OPTION':뷰를 생성하는 SELECT문에 사용된 조건을 체크하여 이를 위배하는 
   DML명령을 뷰에 사용하지 못하게 함
  .'WITH READ ONLY': 읽기전용 뷰 생성
  
  
사용예)회원테이블에서 마일리지가 3000 이상인 회원의 회원번호, 회원명, 직업, 마일리지를
      뷰로 생성하시오.
      
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE(MID,MNAME,MJOB,MMILE)
      AS
       SELECT MEM_ID AS 회원번호,
                     MEM_NAME AS 회원명,
                     MEM_JOB AS 직업,
                     MEM_MILEAGE AS 마일리지
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
                
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE 
      AS
       SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_JOB AS 직업,
              MEM_MILEAGE AS 마일리지
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
                
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE
      AS
       SELECT MEM_ID ,
              MEM_NAME,
              MEM_JOB,
              MEM_MILEAGE
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000;
      
                               
      SELECT MEM_ID,
             MEM_NAME,
             MEM_MILEAGE
         FROM MEMBER
         WHERE MEM_ID='e001';
         
  **생성된 뷰 'VIEW_MEM_MILEAGE'에서 회원번호 'e001'회원의 마일리지를 500으로 조정하시오
  UPDATE VIEW_MEM_MILEAGE
     SET 마일리지=500
     WHERE 회원번호='e001';
     
  **회원테이블에서 회원번호 'g001'회원의 마일리지를 600에서 15000으로 변경하시오
  UPDATE MEMBER
     SET MEM_MILEAGE=15000
     WHERE MEM_ID='g001';
     
      UPDATE MEMBER
     SET MEM_MILEAGE=15000
     WHERE MEM_ID='g001';
      
  SELECT *
    FROM VIEW_MEM_MILEAGE;
  **VIEW 사용시 주의사항
   .WITH 절이 사용된 경우 ORDER BY절 사용 금지
   .집계함수, DISTINCT 가 사용된 VIEW를 대상으로 DML명령 사용할 수 없음
   .표현식(CASE WHEN-THEN,DECODE 등)이나 일반 함수를 적용하여 뷰가 생성된 경우
    해당 컬럼을 대상으로 수정,삭제 등 사용금지
   .CURRVAL, NEXTVAL 등 의사컬럼(Pseudo Column)사용 금지
   .ROWNUM, ROWID 등 사용시 별칭을 사용해야 함.
      
사용예)상품분류별 상품의 수를 출력하는 뷰생성
   ROLLBACK;
   
      CREATE OR REPLACE VIEW VIEW_PROD_LGU
      AS
       SELECT PROD_LGU AS PLGU,
              COUNT(*) AS CNT
         FROM PROD
        GROUP BY PROD_LGU;
      
    SELECT *
      FROM VIEW_PROD_LGU
    
   **뷰 VIEW_PROD_LGU에서 'P102' 자료를 삭제하시오
     DELETE VIEW_PROD_LGU
       WHERE PLGU='P102';
       --집계함수가 사용되어 생성된 뷰는 DML명령어를 사용할 수 없다.
       
사용예)회원테이블에서 마일리지가 3000이상인 회원들로 구성되고 제약조건(CHECK OPTION)을 사용한
      뷰를 생성
      CREATE OR REPLACE VIEW VIEW_MEM_MILEAGE 
      AS
       SELECT MEM_ID AS 회원번호,
              MEM_NAME AS 회원명,
              MEM_JOB AS 직업,
              MEM_MILEAGE AS 마일리지
                FROM MEMBER
                WHERE MEM_MILEAGE>=3000
      WITH READ ONLY;
      
      SELECT *
        FROM VIEW_MEM_MILEAGE; 
    **뷰에서 이혜나 회원의 마일리지를 1500으로 변경
    UPDATE VIEW_MEM_MILEAGE
       SET 마일리지=1500
       WHERE 회원번호='e001';
      
      
      UPDATE MEMBER
         SET MEM_MILEAGE=6500
         WHERE MEM_ID='e001';
         
           UPDATE MEMBER
         SET MEM_MILEAGE=800
         WHERE MEM_ID='g001';
      
      
      
      
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  