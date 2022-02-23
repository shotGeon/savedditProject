<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chart.js</title>
<head>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
</head>
<body>
	<canvas id="myChart" style="height:30vh; width:50vw"></canvas>

	<script>
	var ctx = document.getElementById('myChart');
	var myChart = new Chart(ctx, {
	    type: 'line',
	    data: {
			labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
			datasets: [{
				label: '# of Votes',
				data: [12, 19, 3, 5, 2, 3],
				backgroundColor: [
						'rgba(0, 0, 0, 0)'
				],
				borderColor: [
						'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
				],
				borderWidth: 2
			}]
		},
		options: {
			//크기
			//responsive: false,
			//마우스오버 이벤트 끄기
			/*  tooltips: {
				enabled: false
			}, */ 
			//마우스 갖다대면 값이 사라졌다 나타남 (애니메이션)
			 hover: {
				animationDuration: 0
			}, 
			animation: {
				duration: 1,
				onComplete: function () {
					var chartInstance = this.chart,
					ctx = chartInstance.ctx;
					ctx.font = Chart.helpers.fontString(Chart.defaults.global.defaultFontSize, Chart.defaults.global.defaultFontStyle, Chart.defaults.global.defaultFontFamily);
					ctx.fillStyle = 'purple';
					ctx.textAlign = 'center';
					ctx.textBaseline = 'bottom';

					this.data.datasets.forEach(function (dataset, i) {
						var meta = chartInstance.controller.getDatasetMeta(i);
						meta.data.forEach(function (bar, index) {
							var data = dataset.data[index];							
							ctx.fillText(data, bar._model.x, bar._model.y - 5);
						});
					});
				}
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true,
						stepSize : 2,
						fontSize : 14,
					}
				}]
			}
		}
	});
	</script>
</body>