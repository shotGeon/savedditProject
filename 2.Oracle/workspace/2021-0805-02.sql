2021-0805-02)트리거 TRIGGER
 -특정 이벤트의 발생 전 또는 이후 자동으로 실행되어야할 프로시저
 -트리거는 문장단위 트리거와 행단위 트리거로 구분
 -문장단위 트리거 수행 시 트리거가 완료되지 않은 상태에서 또다른 트리거 호출시
 -테이블의 일관성 유지를 위해 해당 테이블의 접근이 금지됨
 -DML명령 사용후 항상 COMMIT한다.
 (사용형식)
 CREATE [OR REPLACE] TRIGGER 트리거명
    timming[BEFORE|AFTER] event[INSERT|UPDATE|DELETE]
    ON 테이블명
     [FOR EACH ROW]--행단위 트리거(생략되어 지면 문장단위 트리거)
     [WHEN 조건]
     [DECLARE
        선언부
     ]
     BEGIN
       실행부
     END;
     .'BEFORE|AFTER':'실행부'(트리거 본문)가 실행될 시점
     .'INSERT|UPDATE|DELETE' : 트리거를 발생시키는 이벤트로 OR 연산자로 복수개 사용 가능
      ex) INSERT OR DELETE, INSERT OR UPDATE OR DELETE ETC..
     . 'FOR EACH ROW' : 행단위 트리거 시 기술(생략하면 문장단위 트리거
     . 'WHEN 조건' : 행단위 트리거에서만 사용 가능하며, 이벤트 발생에 대한 구체적인 조건 기술
     
 문장단위 트리거)분류테이블에 새로운 분류코드를 삽입하시오. 삽입 후
   '새로운 분류가 추가되었습니다.'를 출력하는 트리것를 작성하시오.
   [분류코드 'P502',분류명: '임산물', 순번 : 11]
   
   CREATE OR REPLACE TRIGGER TG_LPROD_INSERT
     AFTER DELETE ON LPROD
    BEGIN
      DBMS_OUTPUT.PUT_LINE('분류가 삭제되었습니다.');
    END;
 
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(11,'P502','임산물');
      
      COMMIT;
      SELECT * FROM LPROD;
      
      
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(12,'P503','농산물');
      
      COMMIT;
      SELECT * FROM LPROD;
    
    
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(13,'P504','농축산물');
      
      COMMIT;
      
      DELETE LPROD 
        WHERE LPROD_ID=13;
      SELECT * FROM LPROD;
    
행단위 트리거) 오늘이 2005년 6월11일이라고 가정하고, 제품코드가 'P102000005'인 상품을
             10대를 매입했다고 하자. 이 정보를 매입테이블에 저장한 후 재고 수불테이블을
             변경하는 트리거를 작성하시오.
             
             CREATE OR REPLACE TRIGGER TG_BUYPROD_INSERT
              AFTER INSERT ON BUYPROD
              FOR EACH ROW
             DECLARE
              V_QTY NUMBER := :NEW.BUY_QTY;
              V_PROD PROD.PROD_ID%TYPE := :NEW.BUY_PROD;
             BEGIN
               UPDATE REMAIN
                  SET REMAIN_I=REMAIN_I+V_QTY,
                      REMAIN_J_99=REMAIN_J_99+V_QTY,
                      REMAIN_DATE=TO_DATE('20050611')
                WHERE REMAIN_YEAR='2005'
                  AND PROD_ID = :NEW.BUY_PROD;
                  
                DBMS_OUTPUT.PUT_LINE(V_PROD||'상품이 '||V_QTY||'개 입고되었습니다');  
             END;     
 
            INSERT INTO BUYPROD
             SELECT TO_DATE('20050611'),PROD_ID,10,PROD_COST
               FROM PROD
              WHERE PROD_ID='P102000005';
              
              COMMIT;
            
          1)트리거 의사레코드 - 행단위 트리거에만 사용 가능
          (1) :NEW - INSERT, UPDATE 이벤트시 사용
                     데이터가 삽입(갱신)되는 경우 새롭게 들어온 값
                     DELETE 시에는 모두 NULL임
                     
          (2) :OLD - DELETE, UPDATE 이벤트시 사용
                     데이터가 삭제(갱신)되는 경우 이미 존재하고 있던 값
                     INSERT 시에는 모두 NULL임
                     
          2)트리거 함수
           - 트리거의 이벤트 구별하기 위한 함수
          (1) INSERTING : 트리거의 이벤트가 INSERT 이면 참
          (2) UPDATING : 트리거의 이벤트가 UPDATE 이면 참
          (3) DELETING : 트리거의 이벤트가 DELETE 이면 참
          
       사용예) 오늘(2005/08/06) 'h001'회원(라준호)이 상품 'P202000019'을 5개 구입했을때 
              CART테이블과 재고수불테이블에 자료를 삽입 및 갱신하시오(트리거 이용) 
                
            CREATE OR REPLACE TRIGGER tg_cart_chance AFTER
    INSERT OR UPDATE OR DELETE ON cart
    FOR EACH ROW
DECLARE
    v_qty    NUMBER := 0;
    v_pid    prod.prod_id%TYPE;
    v_date   DATE;
BEGIN
    IF
        inserting
    THEN
        v_qty := nvl(:new.cart_qty,0);
        v_pid :=:new.cart_prod;
        v_date := TO_DATE(substr(:new.cart_no,1,8) );
    ELSIF updating THEN
        v_qty := nvl(:new.cart_qty,0) - nvl(:old.cart_qty,0);

        v_pid :=:new.cart_prod;
        v_date := TO_DATE(substr(:new.cart_no,1,8) );
    ELSE
        v_qty :=- ( nvl(:old.cart_qty,0) );
        v_pid :=:old.cart_prod;
        v_date := TO_DATE(substr(:old.cart_no,1,8) );
    END IF;

    UPDATE remain
        SET
            remain_o = remain_o + v_qty,
            remain_j_99 = remain_j_99 - v_qty,
            remain_date = v_date
    WHERE
        remain_year = '2005'
        AND   prod_id = v_pid;

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('오류발생 : '
        || sqlerrm);
END;    
     
(실행)
   ACCEPT P_AMT PROMPT '수량 : ' 
    
    DECLARE
      V_CNT NUMBER:=0;
      V_CARTNO CHAR(13);
      V_AMT NUMBER:=TO_NUMBER('&P_AMT');
    BEGIN
      SELECT COUNT(*) INTO V_CNT
        FROM CART
       WHERE CART_NO LIKE '20050806%';
       
     IF V_CNT = 0 THEN
        V_CARTNO:='2005080600001';
        INSERT INTO CART(CART_MEMBER,CART_NO,CART_PROD,CART_QTY)
          VALUES('h001',V_CARTNO,'P202000019',V_AMT);
     ELSE
      IF V_AMT !=0 THEN
         UPDATE CART
            SET CART_QTY=V_AMT
          WHERE CART_NO='2005080600001'
            AND CART_PROD='P202000019';
      ELSE
        DELETE CART
         WHERE CART_NO='2005080600001'
           AND CART_PROD='P202000019';
      END IF;
    END IF;
    COMMIT;
 END;
 
 ROLLBACK;   
    
    
    