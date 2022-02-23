2021-0708-01
1)SELECT 절 구성
  SELECT DISTINCT 컬럼명[수식]데이터 [AS]["][별칭]["]
    'DISTINCT': 중복된 값을 배제
    '[AS]["][별칭]["]': 컬럼에 부여된 또다른 이름으로 특수문자 사용시 " "로 묶어 사용
    -출력시 컬럼의 제목으로 사용되어 진다.
    
사용예)학원테이블(MEMBER)의 주민번호(MEM_REGNO1)을 사용하여 회원의 나이를 
      조회하시오.
      Alias는 회원번호,회원명,주민번호,나이
      --SUBSTR추줄-SUBSTR(MEM_REGNO1,1,2)--1996(96만)
      
      SELECT MEM_ID AS 회원번호,
                      MEM_NAME AS 회원명,
                      MEM_REGNO1 ||'-'||MEM_REGNO2 AS "주민 번호", --" "를사용하면 문자열로 인식한다.EX="FROM"도 문자열로 인식
                      EXTRACT (YEAR FROM SYSDATE)-(TO_NUMBER(SUBSTR(MEM_REGNO1,1,2))+1900)AS 나이
                      FROM MEMBER; 
                      
 (1) 연산자(OPERATER)
     산술연산자: (+,-,/,*)--MOD,REMINDER(나머지구할때사용)
사용예)HR계정의 사원테이블에서 보너스를 계산하여 급여의 지급액을 조회하시오
      보너스=급여*영업실적코드(COMMISSION_PCT)의 35%
      지급액=급여+보너스
      출력:사원번호,사원명,급여,보너스,지급액
      
    SELECT EMPLOYEE_ID AS 사원번호,
           FIRST_NAME||' '||LAST_NAME AS 사원명,
           SALARY AS 급여,
           NVL(SALARY*COMMISSION_PCT*035,0) AS 보너스,
           SALARY+NVL(SALARY*COMMISSION_PCT*035,0) AS 지급액
           FROM HR.EMPLOYEES;
        
      
     
     관계연산자: (>, <, >=, <=, =, !=(<>)) 대소비교, TRUE/FALSE를 결과로 반환 --주로 조건에 사용되어 진다.(WHERE 절)
사용예)회원테이블에서 마일리지가 4000이상인 회원의 회원번호,회원명,직업,마일리지를 조회하시오   
마일리지가 많은 회원부터 조회
    SELECT MEM_ID AS 회원번호, --1
           MEM_NAME AS 회원명, --2
           MEM_JOB AS 직업, --3
           MEM_MILEAGE AS 마일리지 --4
           FROM MEMBER
           WHERE MEM_MILEAGE >=4000
           ORDER BY 4 DESC;
           --ORDER BY 4 DESC; --컬럼명 대신 컬럼 인덱스인 4를 써도 된다. 
           --ORDER BY MEM_ID,MEM_HP DESC 인경우에는 정렬조건이 적혀있지 않은 MEM_ID로 ASC로 정렬한 후에 혹시 값이 같은 값이 있다면 차선책으로 
           --MEM_HP를 기준으로 DESC로 정렬한다.
           
**회원테이블정보변경
1)d001회원의 주민번호460409 2000000 생년월일1946/04/09
            주민번호010409 4234565 생년월일2001/04/09
            
2)n001회원의 주민번호750323 1011014 생년월일 1975/03/23
            주민번호000409 3011014 생년월일 2000/03/23

3)v001회원의 주민번호520131 2402712 생년월일 1952/01/31
            주민번호020131 4402712 생년월일 2002/03/23            

**정보변경:UPDATE문
  UPDATE 테이블명
     SET 컬럼명=값[,
         컬럼명=값]
  [WHERE 조건];
  
  UPDATE MEMBER
     SET MEM_REGNO1='010409',
         MEM_REGNO2='4234565',
         MEM_BIR=TO_DATE('20010409')
     WHERE MEM_ID='d001';    

UPDATE MEMBER
     SET MEM_REGNO1='000323',
         MEM_REGNO2='3011014',
         MEM_BIR=TO_DATE('20000323')
     WHERE MEM_ID='n001';
     
UPDATE MEMBER
     SET MEM_REGNO1='020131',
         MEM_REGNO2='4402712',
         MEM_BIR=TO_DATE('20020131')
     WHERE MEM_ID='v001'; 
     
       SELECT  MEM_ID,MEM_REGNO1,MEM_REGNO2,MEM_BIR
           FROM MEMBER
           WHERE MEM_ID IN('doo1','v001','n001');

사용예)회원테이블에서 여성회원정보를 조회한다.(회원번호, 회원명, 생년월일, 마일리지, 비고)
      
    SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_BIR AS 생년월일,
           MEM_MILEAGE AS 마일리지,
    CASE WHEN SUBSTR(MEM_REGNO2,1,1)='2' OR
              SUBSTR(MEM_REGNO2,1,1)='4' THEN
                         '여성회원'
                   ELSE      
                         '남성회원'
            END AS 비고
       FROM MEMBER
      WHERE SUBSTR(MEM_REGNO2,1,1)='2' --ANY('2','4')로 사용해도 됨
          OR
            SUBSTR(MEM_REGNO2,1,1)='4';
      
     
     논리연산자: (NOT, AND, OR)--우선순위NOT-AND-OR
     .NOT: 논리부정
     ------------------------------------
      입력         출력
     A   B        (OR)    (AND)   (EX-OR)
     ------------------------------------
     0   1         0        0       0
     0   1         1        0       1
     1   0         1        0       1
     1   1         1        1       0
     ------------------------------------
     
사용예)사원테이블에서 평균급여 이상 급여를 받는 사원을 조회하시오

    SELECT EMPLOYEE_ID AS 사원번호,
           FIRST_NAME||' '||LAST_NAME AS 사원명,
           SALARY AS 급여,
           DEPARTMENT_ID AS 부서번호,
           ROUND((SELECT AVG(SALARY)
                     FROM HR.EMPLOYEES),0) AS 평균급여
        FROM HR.EMPLOYEES
        WHERE NOT SALARY < (SELECT AVG(SALARY)
                            FROM HR.EMPLOYEES)
        ORDER BY 4;                    
     기타연산자: (IN, ANY, SOME, ALL, EXISTS, BETWEEN(범위를비교할때)_, LIKE(패턴을 비교할때)등 제공)
     --IN,ANY,SOME,ALL,EXISTS는 우측데이터가 하나이상 존재해야한다.
     
     1.IN--범위내에서 불규칙한 데이터를 비교할때 사용한다,
     -주어진 값 중 어는 하나와 일치하면 TRUE를 반환
     -OR 연산자로 치환 가능
     -NOT 연산자와 함께 사용가능
     (사용형식)
    expr IN(값1[,값2,....)

사용예)사원테이블에서 10,30,40,60번 부서에 속한 사람들의 사원번호,사원명,부서코드,입사일을 조히하시오
  