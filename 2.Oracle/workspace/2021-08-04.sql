2021-0804-01)
  (3)FOR 문
   . 개발언어의 FOR문과 유사한 구조
   . 일반 반복처리를 위한 FOR문과 CURSOR처리를 위한 FOR문이 제공
   (일반 FOR문 사용형식)
     FOR 인덱스 IN [REVERSE] 초기값..최대값  LOOP
      반복처리명령문(들);
     END LOOP;
     - '인덱스' : 제어변수로 사용될 인덱스로 시스템에서 자동 설정
     - 'REVERSE' : 역순으로 반복처리시 사용
     
사용예) 구구단의 7단을 출력하시오

DECLARE
  BEGIN
   FOR I IN 1..9 LOOP
      DBMS_OUTPUT.PUT_LINE(7||'*'||I||'='||7*I);
     END LOOP; 
   END;
   
 
사용예)
DECLARE
  V_SUM NUMBER:=0; --저축 총 합계
  V_DSUM NUMBER:=100; --일별 저축금액
  V_DAYS NUMBER:=0;
  BEGIN
   FOR I IN 1..1000 LOOP
    V_SUM:=V_SUM+V_DSUM;
      V_DAYS:=I;
     IF V_SUM >=2000000 THEN
       EXIT;
     END IF;
     V_DSUM:=V_DSUM*2;
     END LOOP;
     DBMS_OUTPUT.PUT_LINE('일수: '||V_DAYS);
     DBMS_OUTPUT.PUT_LINE('금액: '||V_SUM);
  END;
  
  (CURSOR를 위한 FOR문 사용형식)
     FOR 레코드명 IN 커서명|커서선언문  LOOP
      반복처리명령문(들);
     END LOOP;
      .'레코드명' : 커서가 가르키는 행의 값을 가지고 있는 변수로 시스템에서 정의
      . 커서내의 값들(컬럼)의 참조는 '레코드명.커서의 컬럼명' 형식으로 기술
      . 커서의 OPEN, FETCH, CLOSE 명령 생략
      . '커서선언문':선언영역에서 선언해야할 커서선언문 중 'SELECCT'문을 서브쿼리형식으로 기술  
      
      
  1번))2005년 5월 입고상품별 출고현황을 조회하는 블록을 작성하시오.
      Alias는 상품코드,상품명,수량    
  
   DECLARE
     CURSOR CUR_BUY01 IS 
        SELECT B.BUY_PROD AS BID,
               A.PROD_NAME AS PNAME,
               SUM(B.BUY_QTY) AS AMT 
          FROM PROD A,BUYPROD B
         WHERE A.PROD_ID=B.BUY_PROD
           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
         GROUP BY B.BUY_PROD,A.PROD_NAME;
    BEGIN 
      FOR REC1 IN CUR_BUY01 LOOP 
        DBMS_OUTPUT.PUT_LINE('상품코드 : '||REC1.BID);
        DBMS_OUTPUT.PUT_LINE('상품명 : '||REC1.PNAME);
        DBMS_OUTPUT.PUT_LINE('입고수량 : '||REC1.AMT);
        DBMS_OUTPUT.PUT_LINE('---------------------');
      END LOOP;
    END;
     
   DECLARE  
    BEGIN 
      FOR REC1 IN(SELECT B.BUY_PROD AS BID,
                         A.PROD_NAME AS PNAME,
                         SUM(B.BUY_QTY) AS AMT 
                         FROM PROD A,BUYPROD B
                         WHERE A.PROD_ID=B.BUY_PROD
                           AND EXTRACT(YEAR FROM B.BUY_DATE)=2005
                         GROUP BY B.BUY_PROD,A.PROD_NAME) 
      LOOP 
        DBMS_OUTPUT.PUT_LINE('상품코드 : '||REC1.BID);
        DBMS_OUTPUT.PUT_LINE('상품명 : '||REC1.PNAME);
        DBMS_OUTPUT.PUT_LINE('입고수량 : '||REC1.AMT);
        DBMS_OUTPUT.PUT_LINE('---------------------');
      END LOOP;
    END;  
  
  
  
  
  
  
  
  
  
  
  
  
  