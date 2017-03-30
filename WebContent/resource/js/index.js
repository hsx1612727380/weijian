$(function() {
	$('.user').on('mouseover', function() {
		console.log(1)
		$('.logout').show();
	});
	$('.login').on('mouseleave', function() {
		$('.logout').hide();
	});
	// 开关
	var isFinish = false;
	// 滑动函数
	function slide(config, elms, zIndex) {

		$.each(config, function(i, arrElm) {

			elms.eq(i).css("z-index", zIndex[i])
				.stop().animate(arrElm, 800, "swing", function() {
					isFinish = false;
				});
		});
	}

	// 配置文件
	var config = [{
		width: 100,
		top: 80,
		left: 320,
		opacity: 0.2
	}, {
		width: 150,
		top: 60,
		left: 220,
		opacity: 0.8
	}, {
		width: 300,
		top: 0,
		left: 420,
		opacity: 1
	}, {
		width: 150,
		top: 60,
		left: 770,
		opacity: 0.8
	}, {
		width: 100,
		top: 80,
		left: 720,
		opacity: 0.2
	}];
	// z-index处理
	var zIndex = [2, 3, 4, 3, 2];

	// 获取相关元素
	var $arrow = $("#arrow"),
		$slide = $("#slide"),
		$lis = $slide.find("li");

	// 调用滑动函数
	slide(config, $lis, zIndex);

	// 绑定事件 让左右箭头展示和隐藏
	$slide.hover(function() {
		$arrow.toggle(400);
	});

	// 给左右箭头绑定单击事件,让轮播图滑动
	$arrow.on("click", "a", function() {
		if(!isFinish) {
			isFinish = true;
			var $this = $(this);

			if($this.hasClass("next")) {
				// 前一个
				config.unshift(config.pop());
				zIndex.unshift(zIndex.pop());
			} else {
				// 后一个
				config.push(config.shift());
				zIndex.push(zIndex.shift());
			}

			slide(config, $lis, zIndex);
		}

	});
	$('#searchsel').find('span').on('click',function(){
		$('#searchsel').find('ul').toggle();
	})
	$('#searchsel').find('li').on('click',function(){
		var $html=$(this).html();
		$('#searchbar').find('span').html($html);
		$('#searchbar').find('ul').hide();
	})
});