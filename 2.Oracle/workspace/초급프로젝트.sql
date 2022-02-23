INSERT INTO TBL_RES         
VALUES((SELECT NVL(MAX(CAR_COUNT),0)+1 FROM TBL_CAR) RES_INSU = TO_DATE('202182116'))

INSERT INTO TBL_RES 
VALUES((SELECT NVL(MAX(RES_NO),0)+1 FROM TBL_RES),RES_INSU = TO_DATE('202182116'))


INSERT INTO TBL_RES(RES_NO,RES_INSU)
VALUES((SELECT NVL(MAX(RES_NO), 0) + 1 FROM TBL_RES), TO_DATE('2021082116','YYYY-MM-DD-HH24'));

INSERT INTO TBL_RES(RES_NO,RES_INSU)
VALUES((SELECT NVL(MAX(RES_NO), 0) + 1 FROM TBL_RES), TO_DATE('2021082114','YYYY-MM-DD-HH24'));

select (select res_insu
         from tbl_res
        where res_no=1)as resr,
      (select res_insu
         from tbl_res
        where res_no=2)as rest
 from tbl_res;
 
 select to_char(res_insu)
   from tbl_res
 where res_no = 1;

DELETE TBL_RES;
commit;

SELECT QNA_USER_ID   FROM TBL_QNA   WHERE QNA_NO= 1


delete tbl_res;
delete tbl_qna;
delete tbl_notice;
delete tbl_faq;
delete tbl_ceo;
delete tbl_user;
delete tbl_car;

drop table tbl_res; 
drop table tbl_qna; 
drop table tbl_notice; 
drop table tbl_faq; 
drop table tbl_ceo; 
drop table tbl_user; 
drop table tbl_car; 

CREATE TABLE tbl_res (
	res_no NUMBER NOT NULL, /* �����ȣ */
	res_date1 DATE, /* �μ��� */
	res_date2 DATE, /* �ݳ������� */
	res_date3 DATE, /* �ݳ��� */
	res_price NUMBER, /* �����ݾ� */
	res_Payment NUMBER, /* �߰������ݾ� */
	res_user_id VARCHAR2(50), /* ȸ�����̵� */
	res_car_no VARCHAR2(50) /* ������ȣ */
);

CREATE TABLE tbl_user (
	user_id VARCHAR2(50) NOT NULL, /* ȸ�����̵� */
	user_pass VARCHAR2(50), /* �н����� */
	user_name VARCHAR2(50), /* ȸ���� */
	user_birth DATE, /* ������� */
	user_gender VARCHAR2(50), /* ���� */
	user_tel VARCHAR2(50) /* ��ȭ��ȣ */
);

CREATE TABLE tbl_ceo (
	ceo_id VARCHAR2(50) NOT NULL, /* ����ھ��̵� */
	ceo_no VARCHAR2(50) NOT NULL, /* ����ڹ�ȣ */
	ceo_cname VARCHAR2(50) NOT NULL, /* ���θ� */
	ceo_name VARCHAR2(50), /* ��ǥ�� */
	ceo_pass VARCHAR2(50), /* �н����� */
	ceo_addr VARCHAR2(50), /* �ּ� */
	ceo_tel VARCHAR2(50), /* ��ȭ��ȣ */
	ceo_email VARCHAR2(50) /* �̸��� */
);

CREATE TABLE tbl_car (
	car_no VARCHAR2(50) NOT NULL, /* ������ȣ */
	car_mno VARCHAR2(50), /* ������ */
	car_mname VARCHAR2(50), /* ���� �� */
	car_air CHAR(2), /* ����� */
	car_sun CHAR(2), /* ������ */
	car_back CHAR(2), /* �Ĺ�ī�޶� */
	car_navi CHAR(2), /* �׺���̼� */
	car_nsmoke CHAR(2), /* �ݿ��� */
	car_open CHAR(2), /* ����ī */
	car_fuel NUMBER, /* ���� */
	car_peo NUMBER, /* �ν� */
	car_price NUMBER /* �ݾ� */
);

CREATE TABLE tbl_qna (
	qna_no NUMBER NOT NULL, /* Q&A��ȣ */
	qna_title VARCHAR2(50) NOT NULL, /* ���� */
	qna_content VARCHAR2(250) NOT NULL, /* ���� */
	qna_comment VARCHAR2(250), /* �亯 */
	qna_content_date DATE NOT NULL, /* �����ۼ��� */
	qna_comment_date DATE, /* �亯�ۼ��� */
	qna_user_id VARCHAR2(50), /* ȸ�����̵� */
	qna_ceo_id VARCHAR2(50) /* ����ھ��̵� */
);

CREATE TABLE tbl_faq (
	faq_no NUMBER NOT NULL, /* FAQ��ȣ */
	faq_title VARCHAR2(50), /* ���� */
	faq_content VARCHAR2(250), /* ���� */
	faq_date DATE, /* �ۼ��� */
	faq_ceo_id VARCHAR2(50) /* ����ھ��̵� */
);

CREATE TABLE tbl_notice (
	notice_no NUMBER NOT NULL, /* �������׹�ȣ */
	notice_title VARCHAR2(50), /* ���� */
	notice_content VARCHAR2(250), /* ���� */
	notice_date DATE, /* �ۼ��� */
	notice_ceo_id VARCHAR2(50) /* ����ھ��̵� */
);

