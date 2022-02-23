<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
 <!-- Font Awesome -->
 <link rel="stylesheet" href="../resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
 <!-- Theme style -->
 <link rel="stylesheet" href="../resources/bootstrap/dist/css/adminlte.min.css">
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=553e55e7a953a05a2adfe2bfc2932452&libraries=services"></script>
 
</head>
<body>
	<div class="card-body">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>#</th>
                      <th>User</th>
                      <th>Date</th>
                      <th>Status</th>
                      <th>Reason</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>183</td>
                      <td>John Doe</td>
                      <td>11-7-2014</td>
                      <td>Approved</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                      <div class="panel">
                        	<p style="display: none;">
                        	제발좀
                        	</p>
                       </div>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>219</td>
                      <td>Alexander Pierce</td>
                      <td>11-7-2014</td>
                      <td>Pending</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                        <div id="map">
                        </div>
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>657</td>
                      <td>Alexander Pierce</td>
                      <td>11-7-2014</td>
                      <td>Approved</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>175</td>
                      <td>Mike Doe</td>
                      <td>11-7-2014</td>
                      <td>Denied</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>134</td>
                      <td>Jim Doe</td>
                      <td>11-7-2014</td>
                      <td>Approved</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>494</td>
                      <td>Victoria Doe</td>
                      <td>11-7-2014</td>
                      <td>Pending</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>832</td>
                      <td>Michael Doe</td>
                      <td>11-7-2014</td>
                      <td>Approved</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                    <tr data-widget="expandable-table" aria-expanded="false">
                      <td>982</td>
                      <td>Rocky Doe</td>
                      <td>11-7-2014</td>
                      <td>Denied</td>
                      <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                    </tr>
                    <tr class="expandable-body d-none">
                      <td colspan="5">
                        <p style="display: none;">
                          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </p>
                      </td>
                    </tr>
                  </tbody>
                </table>
      </div>
      
      
     <!-- jQuery -->
	<script src="../resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="../resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="../resources/bootstrap/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../resources/bootstrap/dist/js/demo.js"></script>
	
	
	<script>
		function mapOpen(addr){
			var mapContainer = document.getElementById('map'); // 지도를 표시할 div
			
			var mapOption = {
				center : new kakao.maps.LatLng(36.35043075681321,
						127.3848294267714), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption);

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
				
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr,function(result, status) {
									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {
										
										// 이동할 위도 경도 위치를 생성합니다 
									    var moveLatLon = new kakao.maps.LatLng(result[0].y, result[0].x);
									    
									    // 지도 중심을 이동 시킵니다
									    map.setCenter(moveLatLon);

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});

										/* // 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow({
											content : '<div style="width:150px;text-align:center;padding:6px 0;">'+obj.name+'</div>'
										});
										
										infowindow.open(map, marker); */

										// 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
										var iwContent = '<div class="markerInfo" style="width:150px;text-align:center;padding:6px 0;">'
												+ "생활치료센터(이름)" +'<br>병상수:'
												+ '<br><a href="https://map.kakao.com/link/to/33.450701,126.570667" style="color:blue" target="_blank">길찾기</a>'+ '</div>'; 

										// 인포윈도우를 생성합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : iwContent
												});

										// 마커에 마우스오버 이벤트를 등록합니다
										/* kakao.maps.event.addListener(marker,
												'mouseover', function() {
													// 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
													infowindow
															.open(map, marker);
												});

										// 마커에 마우스아웃 이벤트를 등록합니다
										kakao.maps.event.addListener(marker,
												'mouseout', function() {
													// 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
													infowindow.close();
												}); */
									infowindow.open(map,marker);
									}
								});
			

			var zoomControl = new kakao.maps.ZoomControl();
			map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

			// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
			kakao.maps.event.addListener(map, 'zoom_changed', function() {

				// 지도의 현재 레벨을 얻어옵니다
				var level = map.getLevel();

				var message = '현재 지도 레벨은 ' + level + ' 입니다';
				var resultDiv = document.getElementById('result');

			});
		}
		</script>
	
	
	
</body>
</html>