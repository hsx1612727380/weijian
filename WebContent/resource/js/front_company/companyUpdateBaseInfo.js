$(function(){
	$("#updateSubmit").click(function() {
		var name = $("#name").val().trim();
		var code = $("#code").val().trim();
		var leaderName = $("#leaderName").val().trim();
		var tel = $("#tel").val().trim();
		if (name == "") {
			alert("姓名不能修改为空");
			return false;
		}
		if (code == "") {
			alert("组织机构代码不能修改为空");
			return false;
		}
		if (leaderName == "") {
			alert("联系人不能修改为空");
			return false;
		}
		if (tel == "") {
			alert("联系方式不能修改为空");
			return false;
		}
		if ((name != "") && (code != "") && (leaderName != "") && (tel != "")) {
			$('form').submit();
		}
	});
	
	//去掉左边的空白  
	function trimLeft(s){  
	    if(s == null) {  
	        return "";  
	    }  
	    var whitespace = new String(" \t\n\r");  
	    var str = new String(s);  
	    if (whitespace.indexOf(str.charAt(0)) != -1) {  
	        var j=0, i = str.length;  
	        while (j < i && whitespace.indexOf(str.charAt(j)) != -1){  
	            j++;  
	        }  
	        str = str.substring(j, i);  
	    }  
	    return str;  
	}
	
});