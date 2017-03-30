$(function() {
	var wjx_none = '☆',
		wjx_sel = '★';
	$(wjx_none).addClass('starnone');
	$(wjx_sel).addClass('starsel');
	$(".star i").mouseover(function() {
		//鼠标移入: 自己和前面的兄弟变实心，其余变空心
		$(this).addClass('starsel').prevAll().addClass('starsel').end().nextAll().removeClass('starsel').addClass('starnone');
	});
	$(".star i").click(function() {
		//鼠标点击后，把自己添加clicked类，其余的清除clicked类
		$(this).addClass('clicke').siblings().removeClass('clicke');
	});
	//当鼠标移开评分控件时，实心显示到被点击的五角星的上
	$(".star").mouseout(function() {
		$(".star i").removeClass('starsel').addClass('starnone'); //先给所有五角星都变空心
		$(".clicke").addClass('starsel').prevAll().addClass('starsel').end().nextAll().removeClass('starsel').addClass('starnone');
	});
	
});