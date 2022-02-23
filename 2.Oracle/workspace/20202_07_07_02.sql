2021-0707-02 Query 문
-자료 검색(조회) 명령
-SELECT 문
-가장 많이 사용되는 SQL문
(사용형식)
SELECT [DISTINCT] 컬럼명 AS ["]별칭["], --DISTINCT:중복배제를 위해 사용,여러 컬럼을 쓸때 한번만 사용해도 뒤에 컬럼들도 영향을 받는다.
                                        --특수문자를 사용할때는 반스시 ["]를 사용한다.
       .
       .
       컬럼면 AS ["]별칭["]
  FROM 테이블명 [별칭]--별칭은 두개 이상 테이블을 사용할때
 [WHERE] 조건
 [GROUP BY 컬럼명[,컬럼명,...]] --SUM,AVG,COUNT,MAX,MIN이 나왔을때 사용
 [HAVING 조건] --GROUP BY절 조건문
 [ORDER BY 컬럼명|컬럼인덱스[ASC|DESC] --정렬
           [,컬럼명|컬럼인덱스[ASC|DESC],...]]
--실행순서 FROM-WHERE-SELECT--
COMMIT;

--DUAL 실제 가져올 TABLE이 없을때 사용하는 가상의 TABLE EX-FROM DUAL