<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Invoice</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body>
<div class="wrapper" style="max-width: 1280px; margin: 0 auto;">
	<div class="invoice p-3 mb-3">
	<strong>로고자리</strong>
	</div>
	<div class="invoice p-3 mb-3">
              <!-- title row -->
              <div class="row">
                <div class="col-12">
                  <h4  style="text-align: center">
                     <!-- <strong class="float-center">AdminLTE, Inc.</strong> -->
                    <strong>대한민국</strong>
                    <!-- <small class="float-right">Date: 2/10/2014</small> -->
                  </h4>
                </div>
                <!-- /.col -->
              </div>
              <!-- info row -->
              <div class="row invoice-info">
                <div class="col-sm-2 invoice-col">
                  <address>
                    <strong>642,207</strong><br>
                    <strong>확진자</strong><br>
                    <br>
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-2 invoice-col">
                  <address>
                    <strong style="color: red">5,730</strong><br>
                    <strong>사망자</strong><br>
                    <br>
                  </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-2 invoice-col">
                  <strong>1,015</strong><br>
                    <strong>위중증</strong><br>
                    <br>
                </div>
                
                <div class="col-sm-2 invoice-col">
                  <strong>524,883</strong><br>
                    <strong>격리해제</strong><br>
                    <br>
                </div>
                
                <div class="col-sm-2 invoice-col">
                 <strong>0.89</strong><br>
                    <strong>치명률</strong><br>
                    <br>
                </div>
                
                
                <!-- /.col -->
              </div>
              <!-- /.row -->
     
              
               <div class="row">
                <div class="col-12">
                  <h4 style="text-align: center">
                     <!-- <strong class="float-center">AdminLTE, Inc.</strong> -->
                    <strong>백신접종현황</strong>
                    <!-- <small class="float-right">Date: 2/10/2014</small> -->
                  </h4>
                </div>
                <!-- /.col -->
              </div>
              
               <div class="row invoice-info">
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>44,284,702</strong><br>
	                    <strong>1차 접종</strong><br>
	                    <br>
	                  </address>
	                 </div>
	                <!-- /.col -->
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>42,603,909</strong><br>
	                    <strong>2차 접종</strong><br>
	                    <br>
	                  </address>
	                </div>
	                <!-- /.col -->
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>18,493,909</strong><br>
	                    <strong>3차 접종</strong><br>
	                    <br>
	                  </address>
	                </div>
	                <!-- /.col -->
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>86.29%</strong><br>
	                    <strong>1차 접종률</strong><br>
	                    <br>
	                  </address>
	                </div>
	                
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>83.01%</strong><br>
	                    <strong>2차 접종률</strong><br>
	                    <br>
	                  </address>
	                </div>
	                
	                <div class="col-sm-2 invoice-col">
	                  <address>
	                    <strong>36.04%</strong><br>
	                    <strong>3차 접종률</strong><br>
	                    <br>
	                  </address>
	                </div>
              </div>
              <div class="col-1" style="margin-left: 93%;">
              <button type="button" onclick="location.href='<%=request.getContextPath()%>/chartdetail.do'" class="btn btn-block btn-primary btn-sm ">상세현황</button>
              </div>
              

      </div>
              <!-- this row will not appear when printing -->
              <div class="row no-print">
                <div class="col-12">
                  <button type="button" class="btn btn-success"><i class="fas fa-bookmark">문진표작성</i></button>
                  <button type="button" class="btn btn-primary" style="margin-right: 5px;"><i class="fas fa-download">확진결과조회</i></button>
                  <button type="button" class="btn btn-info" style="margin-right: 5px;"><i class="fas fa-download">증명서발급</i></button>
                  <button type="button" class="btn btn-warning" style="margin-right: 5px;"><i class="fas fa-bus">검사소찾기</i></button>
                  
                </div>
              </div>
              
          	  <br>
          	  <br>
          	  
        	<div>
        		<h4 style="text-align : center">[공지사항]</h4>
        		<div style="text-align:center">
        		<p>"- 사적모임규제 : 전국 4인, (식당·카페)방역패스 적용하되, 미접종자는 1인 단독이용만 예외 인정<br>
        		- 운영시간 제한 : 식당·카페, 유흥시설 등 21시까지 / 학원·PC방 등 22시 까지<br>
        		- ‘영화관·공연장’ 현행 22시 영업제한에서 → 상영·시작시간 기준으로 21시까지 입장 허용으로 변경 - 백화점 및 대형마트도 접종증명·음성확인제(방역패스) 적용 - 대규모 행사·집회 규모 축소 : (50명미만)가능 (50명이상)접종완료자등으로만 구성 299명까지 가능"</p>
        		</div>
        		
        	</div>  	  	
              
 </div>
   
   
</body>
</html>