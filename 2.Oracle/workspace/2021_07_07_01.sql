2021_07_07_01)
1)자료 삽입 명령(INSERT)
-생성된 테이블에 새로운 자료를 삽입함
(사용형식)
INSERT INTO 테이블명[(컬럼명1[,컬럼명,....])]
  VALUES(값1[,값2,....]);
     '테이블명':자료 삽입 대상 테이블명
     '컬럼명1,..': 이 옵션을 생략하면 테이블에 기술된 모든 컬럼에 기술된 순서에 맞도록 VALUES절에 값을 기술해야함
     '컬럼명1,..': 이 옵션이 사용되면 필요한 컬럼에만 값(데이터)을 저장하여 자료를 삽입할 수 있음.
     기술된 '컬럼명'의 갯수 및 순서와 VALUES절의 값의 갯수 및 순서가 일치해야하고, NOT NULL항목은 반드시 기술해야함(생략될 수 없다)
     ----기본키에서만 char을 쓴다 주로---
사용예)사원테이블(EMPLOYEE)에 다음 자료를 입력하시오.
     -----------------------------------------------------
     사원번호 이름 주소          전하번호          직위    부서
     -----------------------------------------------------
     a101   홍길동  대전시 중구 대흥동  042-222-8202  사원 공공 개발부
     a104','강감찬','대리','기술영업부
     a105','이순신','042-222-8202','부장
     ------------------------------------------------------
INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,E_ADDR,E_TEL,E_POSITION,E_DEPT) 
  VALUES('a101','홍길동','대전시 중구 대흥동','042-222-8202','사원','공공 개발부');
INSERT INTO EMPLOYEE 
  VALUES('a104','강감찬','','','대리','기술영업부');
INSERT INTO EMPLOYEE(EMP_ID,EMP_NAME,E_POSITION) 
  VALUES('a105','이순신','부장');
  
  SELECT * FROM EMPLOYEE;
  
  -----------------------------------------------------------
  사업장번호 사업장명        주소              비고
  -----------------------------------------------------------
  S100     대흥초등학교보수공사 대전시 중구 대흥동
  S200     건물 신축          
  ------------------------------------------------------------
  예)1.홍길동 사원이 오늘부로 'S200'사업장에서 근무
  예)2.이순신 부장이 2020년 10월 1일부터 'S200'사업장에서 근무
  예)3.강감찬대리가 S100사업장에 근무
  ----------------------------------------------------
  SELECT* FROM WORK;
  
  INSERT INTO SITE
  VALUES('S200','건물신축',NULL,'');
  INSERT INTO SITE(SITE_ID,SITE_NAME,SITE_ADDR)
  VALUES('S100','대흥초등학교보수공사','대전시 중구 대흥동');
  
  INSERT INTO WORK VALUES('a105','S200',TO_DATE('20201001'));
  INSERT INTO WORK VALUES('a101','S200',TO_DATE(SYSDATE)); ---SYSDATE:오늘날짜
  INSERT INTO WORK(EMP_ID,SITE_ID) VALUES('a104','S100');
  
  SELECT MOD((TRUNC(SYSDATE)-TO_DATE('00010101'))-1,7) FROM DUAL; ---MOD:나머지
  
  
  **S200에 근무하는 사원정보를 조회하시오
  --SELECT A.SITE_NAME AS 사업자명,
         --B.EMP_ID AS 사원번호,
         --B.EMP_NAME AS 사원명,
         --B.E_POSITION AS 직위,
         --B.E_TEL AS 전화번호
         --FROM SITE A, EMPLOYEE B,WORK C --(테이블명을 간단하게 구별짓기 위해서 A,B,C 를 설정)
        --WHERE A.SITE_ID=C.SITE_ID
        --AND B.EMP_ID=C.EMP_ID
        --AND A.SITE_ID=UPPER('S200'); --UPPER:대문자로 변경
  
  2)자료 삭제 명령(DELETE)
  -존재하는 자료를 삭제
  (사용형식)-
  DELETE 테이블명
  WHERE 조건
  '테이블명': 삭제할 자료가 저장된 테이블 
  '조건': 삭제할 조건 기술하며 생략하면 모든 자료 삭제
  ROLLBACK의 대상(다시 복구할 수 있다.)
  관계가 설정된 자료는 삭제할 수 없다.
  
  DELETE EMPLOYEE
  WHERE EMP_ID='a101'; --EMP_ID에 모든 데이터를 대문자로 만들려면(WHERE UPPER(EMP_ID)='A101';
  
  DELETE WORK;    --참조하는 자식테이블부터 삭제해야지 삭제가능
  
  COMMIT;
  
  객체삭제
  DROP 객체타입(TABLE,VIEW,INDEX,...) 객체명
  --DROP은 ROLLBACK의 대상이아니다.
  
  
  DROP TABLE WORK;
  DROP TABLE EMPLOYEE;
  DROP TABLE SITE;
  
  ROLLBACK;