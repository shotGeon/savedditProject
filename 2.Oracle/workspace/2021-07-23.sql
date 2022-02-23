2021-0723-01)
4.SELF JOIN
-하나의 테이블에 서로 다른 별칭을 부여하여 수행하는 조인
사용예)거래처 '마르죠'와 동일한 지역(광역시도)에 소재하고 있는 거래처 정보를 
      조회하시오.
      Alias는 거래처코드, 거채처명, 주소, 담당자이다.
      SELECT B.BUYER_ID AS 거래처코드,
             B.BUYER_NAME AS 거채처명,
             B.BUYER_ADD1||''||B.BUYER_ADD2 AS 주소,
             B.BUYER_CHARGER AS 담당자
        FROM BUYER A, BUYER B
        WHERE A.BUYER_NAME='마르죠'
          AND SUBSTR(A.BUYER_ADD1,1,2)=SUBSTR(B.BUYER_ADD1,1,2);
          
사용예)사원번호 108번의 사원과 같은 부서에 속한 사원의 사원번호,사원명,부서명,직무코드를
      조회하시오
      SELECT B.EMPLOYEE_ID AS 사원번호,
             B.EMP_NAME AS 사원명,
             C.DEPARTMENT_NAME AS 부서코드,
             B.JOB_ID AS 직무코드
      FROM HR.EMPLOYEES A,HR.EMPLOYEES B,HR.DEPARTMENTS C
      WHERE A.EMPLOYEE_ID=108
        AND A.DEPARTMENT_ID=B.DEPARTMENT_ID
        AND A.DEPARTMENT_ID=C.DEPARTMENT_ID;
5.외부조인(OUTER JOIN)
 -내부조인은 조인조건을 만족하는 데이터를 기준으로 결과를 반환
 -외부조인은 조인조건을 만족하지 못하는 데이터를 기준으로 부족한 테이블에
  NULL 값으로 채워진 행을 삽입하여 조인 수행
 -부족한 데이터를 가지고 있는 테이블에 속한 열이름 다음에 '(+)'연산자를 추가함
 -여러 조인조건이 외부조인이 수행되어야 하는 경우 모두'(+)'연산자를 사용해야 함
 -동시에 한 테이블에 복수개의 '(+)'연산자를 사용할 수 없다. 즉, A,B,C테이블이
  외부조인에 참여할 때 A를 기준으로 B를 확장함과 동시에 C를 기준으로 B를 
  확장할 수 없음(WHERE A=B(+) AND C=B(+)=>허용안됨)
 -일반 외부조인인 경우 일반조건이 사용되면 내부조인 결과를 반환(해결방법 : ANSI
  외부조인 또는 서브쿼리 사용)
 -외부조인의 사용은 처리속도의 저하를 유발
 
 (일반외부조인 사용형식)
   SELECT 컬럼list
    FROM 테이블명1, 테이블명2[,테이블명3,....]
   WHERE 테이블명1.컬럼명[(+)]=테이블명2.컬럼명[(+)]
   
   .양쪽 모두 부족한 외부조인은 허용안됨( WHERE A.COL(+)=B.COL(+))
   
   (ANSI외부조인 사용형식)
   SELECT 컬럼list
    FROM 테이블명1
   LEFT|RIGHT\FULL OUTER JOIN 테이블명2 ON(조인조건1 [AND 일반조건1])
  [LEFT|RIGHT\FULL OUTER JOIN 테이블명2 ON(조인조건1 [AND 일반조건1])]
   
  [WHERE 일반조건n]
 .테이블명1과 테이블명2는 반드시 조인 가능 할것
 .일반조건1은 테이블명1 또는 테이블명2에 국한된 조건
 .일반조건n은 전체 테이블에 적용되는 조건으로 조인이 모두 수행 한 후 적용됨
 .LEFT|RIGHT\FULL : 테이블명1의 데이터 종류가 더 많은 경우 LEFT, 반대인 경우
  RIGHT, 양쪽 모두 부족한 경우 FULL 사용
  
사용예)2005년 1월 모든(OUTER) 상품별 매입현황을 조회하시오.
      출력할 컬럼은 상품코드,상품명,매입수량,매입금액이다.
      
      SELECT B.PROD_ID AS 상품코드, --양쪽에 동시에 존재하는 컬럼인 경우에 많은쪽거를 써라
             B.PROD_NAME AS 상품명,
             NVL(SUM(A.BUY_QTY),0) AS 매입수량,
             NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS 매입금액
      FROM BUYPROD A,PROD B
      WHERE A.BUY_PROD(+)=B.PROD_ID
      AND BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
      GROUP BY B.PROD_ID,B.PROD_NAME
      ORDER BY 1;
      
      SELECT B.PROD_ID AS 상품코드, 
             B.PROD_NAME AS 상품명,
             NVL(SUM(A.BUY_QTY),0) AS 매입수량,
             NVL(SUM(A.BUY_QTY*B.PROD_COST),0) AS 매입금액
      FROM BUYPROD A
      RIGHT OUTER JOIN PROD B ON(A.BUY_PROD=B.PROD_ID 
      AND BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131'))
      GROUP BY B.PROD_ID,B.PROD_NAME
      ORDER BY 1;
      
      서브쿼리+일반외부조인
      SELECT B.PROD_ID AS 상품코드,
              B.PROD_NAME AS 상품명,
              NVL(A.BPO,0) AS 매입수량,
              NVL(A.BDT,0) AS 매입금액
    FROM PROD B, (SELECT BUY_PROD AS BPD, 
                       SUM(BUY_QTY) AS BPO,
                       SUM(BUY_QTY*BUY_COST)AS BDT
                       FROM BUYPROD 
                       WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                       GROUP BY BUY_PROD) A
                  WHERE B.PROD_ID=A.BPD(+) 
                  ORDER BY 1;
                  
사용예) 모든 부서별 사원수를 조회하시오.

    SELECT LPAD(NVL(TO_CHAR(B.DEPARTMENT_ID),'없음'),4) AS 부서코드,
           NVL(B.DEPARTMENT_NAME,'없음') AS 부서명,
           COUNT(A.EMPLOYEE_ID) AS 사원수
    FROM  HR.EMPLOYEES A 
    FULL OUTER JOIN HR.DEPARTMENTS B ON(A.DEPARTMENT_ID=B.DEPARTMENT_ID)
    GROUP BY  B.DEPARTMENT_ID,B.DEPARTMENT_NAME
    ORDER BY 1;
    
사용예)2005년 4월 모든 상품에 대한 판매현황을 조회하시오
     출력할 내용은 상품코드, 상품명, 판매수량, 판매금액이다.
     
     SELECT B.PROD_ID AS 상품코드,
            B.PROD_NAME AS 상품명,
            NVL(SUM(A.CART_QTY),0) AS 판매수량,
            NVL(SUM(A.CART_QTY*B.PROD_PRICE),0) AS 판매금액
     FROM CART A
     RIGHT OUTER JOIN PROD B ON(A.CART_PROD=B.PROD_ID
     AND CART_NO LIKE '200504%')
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
     
     사용예)2005년 4월 모든 상품에 대한 매입현황과 판매현황을 조회하시오
     출력할 내용은 상품코드, 상품명, 매입수량, 매입금액, 판매수량, 판매금액이다.
     
      SELECT B.PROD_ID AS 상품코드,
            B.PROD_NAME AS 상품명,
            NVL(SUM(A.CART_QTY),0) AS 판매수량,
            NVL(SUM(A.CART_QTY*C.PROD_PRICE),0) AS 판매금액,
            NVL(SUM(B.BUY_QTY),0) AS 매입수량,
            NVL(SUM(B.BUY_QTY*C.PROD_PRICE),0) AS 매입금액
     FROM CART A 
     RIGHT OUTER JOIN PROD C ON(A.CART_PROD=C.PROD_ID)
     LEFT OUTER JOIN BUYPROD B ON(B.BUY_PROD=C.PROD_ID
     AND CART_NO LIKE '200504%')
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
  