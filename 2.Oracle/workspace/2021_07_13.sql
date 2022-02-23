)2020_07_13


 CREATE TABLE T_DATE(
 COL1    DATE,
 COL2    DATE,
 COL3    TIMESTAMP,
 COL4    TIMESTAMP WITH TIME ZONE,
 COL5    TIMESTAMP WITH LOCAL TIME ZONE);
 
 INSERT INTO T_DATE VALUES(SYSDATE,TO_DATE('20201015')+30,SYSDATE,SYSDATE,SYSDATE);
 
 SELECT TO_CHAR(COL1, 'YYYY-MM-DD FM HH24:MI:SS'),
        TRUNC(COL1-COL2)
    FROM T_DATE;
    
4.기타자료
-2진 자료를 저장
-RAW,LONG RAW, BLOB(컬럼안에 저자), BFILE(데이터베이스 밖에 저장)
 
1) BFILE
. 2진 자료 저장
. 원본자료를 데이터베이스 외부에 저장하고 데이터베이스에는 경로정보만 보관
. 40GB 까지 저장
(사용형식)
컬럼명 BFILE;
 - 오라클에서는 원본자료(2진자료)에 대하여 해석하거나 변환하지 않음
 - 2진자료 저장을 위해 DIRECTORY 객체가 필요
사용예)
    CREATE TABLE T_BFILE(
      COL1 BFILE);
      
    1.디렉토리 객체 생성
    CREATE DIRECTORY  디렉토리별칭 AS '절대경로명';
    
    CREATE DIRECTORY TEMP_DIR AS 'D:\A_TeachingMaterial\2.Oracle';
    
    2.이미지 자료 저장
    INSERT INTO 테이블명 
      VALUES(BFILENAME('디렉토리별칭','파일명'));
      
      INSERT INTO T_BFILE
      VALUES(BFILENAME('TEMP_DIR','sample.jpg'));
      
      SELECT * FROM T_BFILE;
2)BLOB
.2진 자료저장
.4GB 까지 저장 가능
.원본자료를 데이터베이스 내부에 저장
(사용형식)
  컬럼명 BLOB;
  **BLOB 사용순서
  1.테이블 생성
  2.디렉토리객체 생성
  3.익명블록 생성
  
  사용예)
     a)테이블 생성
     CREATE TABLE T_BLOB(
        COL1 BLOB);
    b)디렉토리 생성
      TEMP_DIR 사용
      
      c)익명블록 생성
      
      DECLARE
      L_DIR VARCHAR2(20) := 'TEMP_DIR';
      L_FILE VARCHAR2(30) := 'sample.jpg';
      L_BFILE BFILE;
      L_BLOB BLOB;
      BEGIN
       INSERT INTO T_BLOB(COL1) VALUES(EMPTY_BLOB())
           RETURN COL1 INTO L_BLOB;
        L_BFILE:=BFILENAME(L_DIR, L_FILE);
        DBMS_LOB.FILEOPEN(L_BFILE,DBMS_LOB.FILE_READONLY);
        DBMS_LOB.LOADFROMFILE(L_BLOB,L_BFILE,DBMS_LOB.GETLENGTH(L_BFILE));
        DBMS_LOB.FILECLOSE(L_BFILE);
        
        COMMIT;
    END;
    
    SELECT * FROM T_BLOB;
      
      
 
