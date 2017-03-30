(function($) {
	var myChart = echarts.init(document.getElementById('echart'));
	// 显示标题，图例和空的坐标轴
	myChart.setOption({
		title: {
			text: '7天出勤率'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data: ['施工班组', '材料班组', '设备班组']
		},
		toolbox: {
			show: true,
			feature: {
				saveAsImage: {
					show: true
				}
			}
		},
		xAxis: {
			type: 'category',
			boundaryGap: false,
			data: ['12-04', '12-05', '12-06', '12-07', '12-08', '12-04', '12-10']
		},
		yAxis: {
			type: 'value'
		},
		series: [{
			name: '施工班组',
			type: 'line',
			data: [0.7, 0.7, 0.7, 0.7, 0.7, 0.7, 0.7]
		}, {
			name: '材料班组',
			type: 'line',
			data: [0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5]
		}, {
			name: '设备班组',
			type: 'line',
			data: [0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3]
		}]
	});
})(jQuery)