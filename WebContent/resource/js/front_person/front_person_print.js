function printit() {
	if (confirm("确认打印页面表格？")) {
		$("table").attr({border:"1px"});
		var bdhtml = window.document.body.innerHTML;//获取当前页的html代码  
//		console.log(window.document.body);
		var sprnstr = null;
		var eprnstr = null;
//		debugger;
//		console.log("=========="+bdhtml.indexOf("<!--startprint-->"));
		sprnstr = "<!--startprint-->";//设置打印开始区域  
		eprnstr = "<!--endprint-->";//设置打印结束区域  
		var prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 17); //从开始代码向后取html  
		var prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //从结束代码向前取html  
		window.document.body.innerHTML = prnhtml;
		window.print();
		window.document.body.innerHTML = bdhtml;
		location.reload(true);//刷新页面，恢复原来的边框
	}
}
function printit1() {
	if (confirm("确认打印页面表格？")) {
		$("table").attr({border:"1px solid #CCC"});
		var bdhtml = window.document.body.innerHTML;//获取当前页的html代码  
//		console.log(window.document.body);
		var sprnstr = null;
		var eprnstr = null;
//		debugger;
//		console.log("=========="+bdhtml.indexOf("<!--startprint1-->"));
		sprnstr = "<!--startprint1-->";//设置打印开始区域  
		eprnstr = "<!--endprint1-->";//设置打印结束区域  
		var prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 17); //从开始代码向后取html  
		var prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //从结束代码向前取html  
		window.document.body.innerHTML = prnhtml;
		window.print();
		window.document.body.innerHTML = bdhtml;
		location.reload(true);//刷新页面，恢复原来的边框
	}
}
function printit2() {
	if (confirm("确认打印页面表格？")) {
		$("table").attr({border:"1px solid #CCC"});
		var bdhtml = window.document.body.innerHTML;//获取当前页的html代码  
//		console.log(window.document.body);
		var sprnstr = null;
		var eprnstr = null;
//		debugger;
//		console.log("=========="+bdhtml.indexOf("<!--startprint2-->"));
		sprnstr = "<!--startprint2-->";//设置打印开始区域  
		eprnstr = "<!--endprint2-->";//设置打印结束区域  
		var prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 17); //从开始代码向后取html  
		var prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //从结束代码向前取html  
		window.document.body.innerHTML = prnhtml;
		window.print();
		window.document.body.innerHTML = bdhtml;
		location.reload(true);//刷新页面，恢复原来的边框
	}
}
