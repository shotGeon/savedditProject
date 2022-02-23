2021_07_06_02)SQL 명령의 구분
 1)Query
   질의 및 조회
   SELECT 문
   
 2)DML(Data Manipulation Language:데이터 조작어)
  INSERT, UPDATE, DELETE 문
  
 3)DCL(Data Control Language:데이터 제어어)
  COMMIT, ROLLBACK, SAVEPOINT, GRANT

 4)DDL(Data Definition Language:데이터 정의어)
  CREATE, DROP, ALTER
  
 (1) CREATE
  . 오라클 객체를 생성
  (사용형식)
  CREATE 객체타입 객체명;
   - 객체타입: 생성하려 하는 객체의 종류로 USER,VIEW,INDEX,SYNONYM,TABLE...etc
   **테이블 생성명령
  CREATE TABLE 테이블명(
    컬럼명 데이터타입[(크기)] [NOT NULL] [DEFAULT 값][,]
    
    컬럼명 데이터타입[(크기)] [NOT NULL] [DEFAULT 값][,]
    
    [CONSTRAINT 기본키설정명(PK_테이블명,(인덱스역할을 해주기 때문에 절대 중복되어서는 안된다.)) PRIMARY KEY(컬럼명[,컬럼명,...])][,]
    [CONSTRAINT 외래키설정명(FK_테이블명,(인덱스역할을 해주기 때문에 절대 중복되어서는 안된다.)) FOREIGN KEY(컬럼명[,컬럼명,...])]
        REFERENCE 테이블명(컬럼명)[,]
        
    [CONSTRAINT 기본키설정명 FOREIGN KEY(컬럼명[,컬럼명,...])]
        REFERENCE 테이블명(컬럼명)]);
        
         '데이터타입' : CHAR, VARCHAR, DATE, NUMBER, CLOB, BLOB 등 사용
         'DEFAULT 값' : 사용자가 데이터 입력시(INSERT문)데이터를 기술하지 않은경우
         저장되는 값
         '기본키설명','외래키설명': 기본키 및 외래키 설정을 구별하기위해 부여된
         인덱스명으로 고유한 식별자 이어야 함
         'REFERENCES 테이블명(컬럼명)' : 원본테이블명(부모테이블명)과 그곳에서 사용된
         컬럼명

(사원테이블)
1)테이블명:EMPLOYEE
2)컬럼
---------------------------------
컬럼명 데이터타입(크기) N.N PK/FK
---------------------------------
EMP_ID CHAR(4) N.N PK
EMP_NAME VARCHAR2(30)N.N 
E_ADDR VARCHAR2(80)--주소
E_TEL VARCHAR2(20)--전화번호
E_POSITION VARCHAR2(30)--직위
E_DEPT VARCHAR2(50)
----------------------------------

CREATE TABLE EMPLOYEE(
EMP_ID CHAR(4) NOT NULL,
EMP_NAME VARCHAR2(30) NOT NULL,
E_ADDR VARCHAR2(80),
E_TEL VARCHAR2(20),
E_POSITION VARCHAR(30),
E_DEPT VARCHAR2(50),
CONSTRAINT PK_EMPLOYEE PRIMARY KEY(EMP_ID));
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         


        
    