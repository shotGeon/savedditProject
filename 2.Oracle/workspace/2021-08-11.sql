alter table tbl_car

INSERT INTO TBL_FAQ       
VALUES((SELECT NVL(MAX(FAQ_NO),0)+1 FROM TBL_FAQ),
'�����' , '�ϱ���' , SYSDATE , (SELECT CEO_ID FROM TBL_CEO))