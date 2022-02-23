2021-0727-01)
**재고 수불처리를 위한 테이블을 생성하시오
1)테이블명: REMAIN
2)컬럼명
-------------------------------------------------------
  컬럼명       데이터타입       NULL허용여부    제약사항
-------------------------------------------------------
REMAIN_YEAR    CHAR(4)         N.N           PK
PROD_ID       VARCHAR2(10)     N.N           PK/FK
REMAIN_J_00   NUMBER(5)                      DEFAULT 0 --기초재고
REMAIN_I      NUMBER(5)                      DEFAULT 0
REMAIN_O      NUMBER(5)                      DEFAULT 0
REMAIN_J_99   NUMBER(5)                      DEFAULT 0 --기말재고(기초재고+입고-출고)
REMAIN_DATE   DATE                  
-------------------------------------------------------

CREATE TABLE REMAIN(
REMAIN_YEAR    CHAR(4),     
PROD_ID       VARCHAR2(10), 
REMAIN_J_00   NUMBER(5)   DEFAULT 0, 
REMAIN_I      NUMBER(5)   DEFAULT 0,
REMAIN_O      NUMBER(5)   DEFAULT 0,
REMAIN_J_99   NUMBER(5)   DEFAULT 0,
REMAIN_DATE   DATE,

CONSTRAINT pk_remain PRIMARY KEY(REMAIN_YEAR,PROD_ID),
CONSTRAINT fk_remain_prod FOREIGN KEY(PROD_ID)
   REFERENCES PROD(PROD_ID));
   
4)DML 명령에 서브쿼리 사용 --INSERT문에서는 서브쿼리를 괄호로 묶어주지 않는다.
 (1)INSERT 문에 서브쿼리 사용
  . '( )'를 사용하지 않고 서브쿼리 기술
  . INSERT 문의 VALUES절도 생략 

사용예) 재고수불테이블(REMAIN)에 PROD 테이블의 자료를 이용하여 기초데이터를 입력하시오
      년도: '2005'
      상품코드: PROD테이블의 상품코드(PROD_ID)
      기초재고수량: PROD테이블의 PROD_PROPERSTOCK
      입고 및 출고 수량: 없음
      기말재고수량 : PROD테이블의 PROD_PROPERSTOCK
      날짜 : '2004-12-31'
      
      INSERT INTO REMAIN (REMAIN_YEAR,PROD_ID,REMAIN_J_00,REMAIN_J_99,REMAIN_DATE)
         SELECT '2005',PROD_ID,PROD_PROPERSTOCK,PROD_PROPERSTOCK,TO_DATE('20041231')
           FROM PROD;
        
        
      (2) UPDATE 문에 서브쿼리 사용
      . 복수개의 컬럼을 갱신하는 경우 '( )'안에 변경할 컬럼을 기술하여 하나늬 SET절로 처리
      
사용예)2005년1월 상품별 매입정보를 이용하여 REMAIN테이블을 변경하시오

  메임쿼리
     UPDATE REMAIN
         SET REMAIN_I=(서브쿼리1),
             REMAIN_J_99=(서브쿼리2),
             REMAIN_DATE=TO_DATE('20050131')
        WHERE 조건
   서브쿼리:2005년 1월 상품별 매입정보
    SELECT BUY_PROD,
           SUM(BUY_QTY)
        FROM BUYPROD
        WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
        GROUP BY BUY_PROD;
        
        
(결합)--복수개의 기본키가 사용되었을때 WHERE절에 복수개의 기본키가 모두 언급되어져야 한다.
       UPDATE REMAIN B
         SET (B.REMAIN_I,B.REMAIN_J_99,B.REMAIN_DATE)=
             (SELECT REMAIN_I+A.AMT,REMAIN_J_99+A.AMT,TO_DATE('20050131') 
              FROM(SELECT BUY_PROD AS BID,
                       SUM(BUY_QTY) AS AMT
                   FROM BUYPROD
                  WHERE BUY_DATE BETWEEN TO_DATE('20050101') AND TO_DATE('20050131')
                  GROUP BY BUY_PROD) A
            WHERE B.PROD_ID=A.BID)
        WHERE B.REMAIN_YEAR='2005'
          AND B.PROD_ID IN (SELECT DISTINCT BUY_PROD AS BID
                                FROM BUYPROD
                                WHERE BUY_DATE BETWEEN TO_DATE('20050101')
                                AND TO_DATE('20050131'));    
                COMMIT;
                
        
   SELECT * FROM REMAIN;
   
  (3)DELETE문에 서브쿼리 사용
    .WHERE 조건절에 IN이나 EXISTS 연산자를 사용하여 삭제할 자료를 좀 더 세밀하게 선택 할 수 있음

사용예)장바구니테이블에서 2005년 5월 회원번호가 'p001'인 자료를 삭제하시오.
       
메인쿼리)  DELETE CART C
     WHERE C.CART_MEMBER='p001'
       AND C.CART_NO LIKE '200505%';  
                      
사용예)2005년 6월 상품 'P302000001'의 매출자료 중 판매 수량이 5개 이상인 자료만 삭제하시오
         DELETE FROM CART C
         WHERE EXISTS(SELECT A.CART_MEMBER,
                               A.CART_PROD,
                               A.CART_QTY,
                               A.CART_NO
                               FROM CART A,PROD B
                            WHERE A.CART_PROD=B.PROD_ID
                            AND A.CART_PROD='P302000001'
                            AND A.CART_NO LIKE '200506%'
                            AND A.CART_QTY>=5)
                  AND A.CART_NO LIKE '200506%';
서브쿼리)
SELECT A.CART_PROD,
       A.CART_QTY,
       A.CART_NO
  FROM CART A,PROD B
  WHERE A.CART_PROD=B.PROD_ID
    AND A.CART_PROD='P302000001'
    AND A.CART_NO LIKE '200506%'
    AND A.CART_QTY>=5;
    
사용예)2005년 4월 판매자료 중 판매 금액이 5만원 이하의 자료만 삭제하시오
  (서브쿼리:2005년 4월 판매자료 중 판매 금액이 5만원 이하의 자료 검색)
   DELETE FROM CART A
   WHERE EXISTS (SELECT 1
                   FROM PROD
                  WHERE A.CART_PROD=PROD_ID
                    AND A.CART_QTY*PROD_PRICE<=50000)
          AND A.CART_NO LIKE '200504%';
                  
   ROLLBACK;
   
   
   
   
         
      



