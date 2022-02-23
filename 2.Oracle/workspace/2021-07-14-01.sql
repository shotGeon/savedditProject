2021-0714-01)
2. 숫자함수
1) GREATEST(n1,n2[,n3,....]), LEAST(n1,n2[,n3,....])
 -GREATEST : 주어진 수 (n1 ~..) 중 가장 큰값을 반환
 -LEAST : 주어진 수 (n1 ~..) 중 가장 작은 값을 반환
사용예)SELECT GREATEST(50,70,90),
             LEAST(50,70,90)
        FROM DUAL;
        
사용예)회원테이블에서 마일리지가 1000미만인 모든회원의 마일리지를 1000으로 수정 출력하시오
     Alias는 회원번호, 회원명,원본 마일리지, 수정 마일리지
     
     SELECT MEM_ID AS 회원번호,
            MEM_NAME AS 회원명,
            MEM_MILEAGE AS "원본 마일리지",
            GREATEST(MEM_MILEAGE,1000) AS "수정 마일리지"
        FROM MEMBER;
        
    SELECT MAX(MEM_NAME) FROM MEMBER;--MAX는 열적으로 비교할때, GREATEST는 행적으로 비교할때
    
2)ROUND(n[,i]),TRUNC(n[,i])
 -ROUND : 주어진 수 n의 소수점 이하 i+1번째 자리에서 반올림하여 i번째 까지 출력
          i가 음수이면 정수부분 i 번째에서 반올림
          i가 생략되면 0으로 간주됨
 -TRUNC : ROUND와 같이 수행되나 반올림이 아니라 절삭처리
 
 사용예)사원테이블에서 급여의 지급액을 계산하여 출력하시오
    Alias는 사원번호,사원명,급여,세금,지급액
    세금=급여액의 17%
    지급액은 급여 - 세금
    소숫점 1자리까지 출력
    
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명, 
           SALARY AS 급여, 
           ROUND(SALARY*0.17,1) AS 세금,
           SALARY-TRUNC(SALARY*0.17,1)AS 지급액
       FROM HR.EMPLOYEES;   
       
  사용예)2005년 1월~3월 제품분류별 평균매입액을 조회하시오 ---~별이나오면 GROUP BY를 사용한다.
  Alias 분류코드, 분류명, 평균매입금액(소숫점없이)
  SELECT C.PROD_LGU AS 분류코드,
         B.LPROD_NM AS 분류명,
         ROUND(AVG(A.BUY_QTY*C.PROD_COST)) AS 평균매입금액
         FROM LPROD B,BUYPROD A, PROD C
         WHERE A.BUY_PROD=C.PROD_ID
           AND C.PROD_LGU=B.LPROD_GU
           AND A.BUY_DATE BETWEEN '20050101' AND '20050331'
           GROUP BY C.PROD_LGU,B.LPROD_NM--집계함수를 사용하지않은컬럼들
           ORDER BY 1;
3)FLOOR(n), CEIL(n)
-n에 가까운 정수를 반환
-FLOOR:n과 같거나 크지않은 정수 중 가장 큰 정수
-CEIL: n과 같거나 큰 정수 중 가장 작은 정수
-세금, 급여 처럼 금액과 관련된 수식에 주로 사용
사용예) SELECT FLOOR(12.5), CEIL(12.5),
              FLOOR(12), CEIL(12),
              FLOOR(-12.5), CEIL(-12.5)
          FROM DUAL;
4)MOD(n,i), REMAINDER(n,i)
 -나머지를 반환
 -MOD : n을 i로 나눈 나머지 반환
        나머지= 피젯수 - 젯수*(FLOOR(피젯수/젯수))
    ex) 15/6 의 나머지 = 15-6*(FLOOR(15/6))
                      = 15-6*(FLOOR(2,5))
                      =15-12
                      =3
                      
 -REMAINDER :n을 i로 나눈 나머지가 i의 절반 이하의 값이면 MOD와 같은 나머지를
             반환하고 나머지가 그 이상의 값이면 다음몫이 되기위해 더해져야 할 수를 반환
    ex) 15/6 의 나머지 = 15-6*(ROUND(15/6))
                      = 15-6*(ROUND(2,5))
                      =15-12
                      =3

사용예) SELECT MOD(15,6),REMAINDER(17,6),
              MOD(15,7),REMAINDER(15,7)
           FROM DUAL;   
           
사용예)임의의 년도를 입력 받아 윤년과 평년을 구별하시오
      윤년 : (4의 배수이면서 100의 배수가 아니거나) (400의 배수가 되는 해)
      
      ACCEPT P_YEAR PROMPT '년도 입력'
      DECLARE
            V_YEAR NUMBER(4):= TO_NUMBER('&P_YEAR');
            V_RES VARCHAR2(100);
         BEGIN
           IF (MOD(V_YEAR,4)=0 AND MOD(V_YEAR,100)!=0) OR MOD(V_YEAR,400)=0 THEN
              V_RES:=TO_CHAR(V_YEAR)||'해는 윤년입니다.';
           ELSE
              V_RES:=TO_CHAR(V_YEAR)||'해는 평년입니다.';
           END IF;
           
           DBMS_OUTPUT.PUT_LINE(V_RES);
        END;
              
5)WIDTH_BUCKET(n, min, max b)
-min에서 max값 까지를 b개의 구간으로 나누고 주어진 수 n이 그 구간 중 어느 구간에 속하는지를
 판별하여 구간의 인덱스를 반환함
사용예) SELECT WIDTH_BUCKET(100,0,100,10)FROM DUAL;

사용예) 회원테이블에서 회원들의 마일리지를 3개의 그룹으로 나누고 각 회원들의 마일리지가 속한 그룹을
       조회하여 1그룹에 속한 회원은 '새싹회원', 2그룹에 속한 회원은 '정 회원', 3그룹에 속한 
       회원은 'VIP 회원'을 비고란에 출력하시오 (Alias는 회원번호,회원명,직업,마일리지,비고)
       
       SELECT  MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
               MEM_JOB AS 직업,
               MEM_MILEAGE AS 마일리지,
               CASE WHEN WIDTH_BUCKET (MEM_MILEAGE,500,9000,3) =1 THEN
                  '새싹회원'
                    WHEN WIDTH_BUCKET (MEM_MILEAGE,500,9000,3) =2 THEN
                  '정규회원'
               ELSE
                  'VIP회원'
              END AS 비고            
          FROM MEMBER;
         
사용예) 회원테이블에서 회원들의 마일리지를 5개의 그룹으로 나누고 등급을 비고난에 출력
       Alias는 (회원번호,회원명,직업,마일리지,비고)이며 등급은 마일리지가 많은 회원이 1등급이고,
       제일 작은 회원이 5등급이다.
       
       SELECT  MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
               MEM_JOB AS 직업,
               MEM_MILEAGE AS 마일리지,
               WIDTH_BUCKET (MEM_MILEAGE,9000,500,5)||'등급' AS 비고
        FROM MEMBER;
          
          
          
