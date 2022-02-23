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
	res_no NUMBER NOT NULL, /* 예약번호 */
	res_date1 DATE, /* 인수일 */
	res_date2 DATE, /* 반납예정일 */
	res_date3 DATE, /* 반납일 */
	res_price NUMBER, /* 결제금액 */
	res_Payment NUMBER, /* 추가결제금액 */
	res_user_id VARCHAR2(50), /* 회원아이디 */
	res_car_no VARCHAR2(50) /* 차량번호 */
);

CREATE TABLE tbl_user (
	user_id VARCHAR2(50) NOT NULL, /* 회원아이디 */
	user_pass VARCHAR2(50), /* 패스워드 */
	user_name VARCHAR2(50), /* 회원명 */
	user_birth DATE, /* 생년월일 */
	user_gender VARCHAR2(50), /* 성별 */
	user_tel VARCHAR2(50) /* 전화번호 */
);

CREATE TABLE tbl_ceo (
	ceo_id VARCHAR2(50) NOT NULL, /* 사업자아이디 */
	ceo_no VARCHAR2(50) NOT NULL, /* 사업자번호 */
	ceo_cname VARCHAR2(50) NOT NULL, /* 법인명 */
	ceo_name VARCHAR2(50), /* 대표자 */
	ceo_pass VARCHAR2(50), /* 패스워드 */
	ceo_addr VARCHAR2(50), /* 주소 */
	ceo_tel VARCHAR2(50), /* 전화번호 */
	ceo_email VARCHAR2(50) /* 이메일 */
);

CREATE TABLE tbl_car (
	car_no VARCHAR2(50) NOT NULL, /* 차량번호 */
	car_mno VARCHAR2(50), /* 차량모델 */
	car_mname VARCHAR2(50), /* 차량 명 */
	car_air CHAR(2), /* 에어백 */
	car_sun CHAR(2), /* 선루프 */
	car_back CHAR(2), /* 후방카메라 */
	car_navi CHAR(2), /* 네비게이션 */
	car_nsmoke CHAR(2), /* 금연차 */
	car_open CHAR(2), /* 오픈카 */
	car_fuel NUMBER, /* 연료 */
	car_peo NUMBER, /* 인승 */
	car_price NUMBER /* 금액 */
);

CREATE TABLE tbl_qna (
	qna_no NUMBER NOT NULL, /* Q&A번호 */
	qna_title VARCHAR2(50) NOT NULL, /* 제목 */
	qna_content VARCHAR2(250) NOT NULL, /* 내용 */
	qna_comment VARCHAR2(250), /* 답변 */
	qna_content_date DATE NOT NULL, /* 내용작성일 */
	qna_comment_date DATE, /* 답변작성일 */
	qna_user_id VARCHAR2(50), /* 회원아이디 */
	qna_ceo_id VARCHAR2(50) /* 사업자아이디 */
);

CREATE TABLE tbl_faq (
	faq_no NUMBER NOT NULL, /* FAQ번호 */
	faq_title VARCHAR2(50), /* 제목 */
	faq_content VARCHAR2(250), /* 내용 */
	faq_date DATE, /* 작성일 */
	faq_ceo_id VARCHAR2(50) /* 사업자아이디 */
);

CREATE TABLE tbl_notice (
	notice_no NUMBER NOT NULL, /* 공지사항번호 */
	notice_title VARCHAR2(50), /* 제목 */
	notice_content VARCHAR2(250), /* 내용 */
	notice_date DATE, /* 작성일 */
	notice_ceo_id VARCHAR2(50) /* 사업자아이디 */
);

