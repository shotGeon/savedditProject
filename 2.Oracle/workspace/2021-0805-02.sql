2021-0805-02)Ʈ���� TRIGGER
 -Ư�� �̺�Ʈ�� �߻� �� �Ǵ� ���� �ڵ����� ����Ǿ���� ���ν���
 -Ʈ���Ŵ� ������� Ʈ���ſ� ����� Ʈ���ŷ� ����
 -������� Ʈ���� ���� �� Ʈ���Ű� �Ϸ���� ���� ���¿��� �Ǵٸ� Ʈ���� ȣ���
 -���̺��� �ϰ��� ������ ���� �ش� ���̺��� ������ ������
 -DML��� ����� �׻� COMMIT�Ѵ�.
 (�������)
 CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ�
    timming[BEFORE|AFTER] event[INSERT|UPDATE|DELETE]
    ON ���̺��
     [FOR EACH ROW]--����� Ʈ����(�����Ǿ� ���� ������� Ʈ����)
     [WHEN ����]
     [DECLARE
        �����
     ]
     BEGIN
       �����
     END;
     .'BEFORE|AFTER':'�����'(Ʈ���� ����)�� ����� ����
     .'INSERT|UPDATE|DELETE' : Ʈ���Ÿ� �߻���Ű�� �̺�Ʈ�� OR �����ڷ� ������ ��� ����
      ex) INSERT OR DELETE, INSERT OR UPDATE OR DELETE ETC..
     . 'FOR EACH ROW' : ����� Ʈ���� �� ���(�����ϸ� ������� Ʈ����
     . 'WHEN ����' : ����� Ʈ���ſ����� ��� �����ϸ�, �̺�Ʈ �߻��� ���� ��ü���� ���� ���
     
 ������� Ʈ����)�з����̺� ���ο� �з��ڵ带 �����Ͻÿ�. ���� ��
   '���ο� �з��� �߰��Ǿ����ϴ�.'�� ����ϴ� Ʈ���͸� �ۼ��Ͻÿ�.
   [�з��ڵ� 'P502',�з���: '�ӻ깰', ���� : 11]
   
   CREATE OR REPLACE TRIGGER TG_LPROD_INSERT
     AFTER DELETE ON LPROD
    BEGIN
      DBMS_OUTPUT.PUT_LINE('�з��� �����Ǿ����ϴ�.');
    END;
 
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(11,'P502','�ӻ깰');
      
      COMMIT;
      SELECT * FROM LPROD;
      
      
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(12,'P503','��깰');
      
      COMMIT;
      SELECT * FROM LPROD;
    
    
    INSERT INTO LPROD(LPROD_ID,LPROD_GU,LPROD_NM)
      VALUES(13,'P504','����깰');
      
      COMMIT;
      
      DELETE LPROD 
        WHERE LPROD_ID=13;
      SELECT * FROM LPROD;
    
����� Ʈ����) ������ 2005�� 6��11���̶�� �����ϰ�, ��ǰ�ڵ尡 'P102000005'�� ��ǰ��
             10�븦 �����ߴٰ� ����. �� ������ �������̺� ������ �� ��� �������̺���
             �����ϴ� Ʈ���Ÿ� �ۼ��Ͻÿ�.
             
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
                  
                DBMS_OUTPUT.PUT_LINE(V_PROD||'��ǰ�� '||V_QTY||'�� �԰�Ǿ����ϴ�');  
             END;     
 
            INSERT INTO BUYPROD
             SELECT TO_DATE('20050611'),PROD_ID,10,PROD_COST
               FROM PROD
              WHERE PROD_ID='P102000005';
              
              COMMIT;
            
          1)Ʈ���� �ǻ緹�ڵ� - ����� Ʈ���ſ��� ��� ����
          (1) :NEW - INSERT, UPDATE �̺�Ʈ�� ���
                     �����Ͱ� ����(����)�Ǵ� ��� ���Ӱ� ���� ��
                     DELETE �ÿ��� ��� NULL��
                     
          (2) :OLD - DELETE, UPDATE �̺�Ʈ�� ���
                     �����Ͱ� ����(����)�Ǵ� ��� �̹� �����ϰ� �ִ� ��
                     INSERT �ÿ��� ��� NULL��
                     
          2)Ʈ���� �Լ�
           - Ʈ������ �̺�Ʈ �����ϱ� ���� �Լ�
          (1) INSERTING : Ʈ������ �̺�Ʈ�� INSERT �̸� ��
          (2) UPDATING : Ʈ������ �̺�Ʈ�� UPDATE �̸� ��
          (3) DELETING : Ʈ������ �̺�Ʈ�� DELETE �̸� ��
          
       ��뿹) ����(2005/08/06) 'h001'ȸ��(����ȣ)�� ��ǰ 'P202000019'�� 5�� ���������� 
              CART���̺�� ���������̺� �ڷḦ ���� �� �����Ͻÿ�(Ʈ���� �̿�) 
                
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
        dbms_output.put_line('�����߻� : '
        || sqlerrm);
END;    
     
(����)
   ACCEPT P_AMT PROMPT '���� : ' 
    
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
    
    
    