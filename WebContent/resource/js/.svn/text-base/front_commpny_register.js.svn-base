(function($) {
	var phoneok=false;
	var passwordok=false;
	var repasswordok=false;
	var companyType=false;
	var companyNameOk=false;
	var organizationOk=false;
	var nameOk=false;

	$('#userId>input').on('blur', function() {
		isphone($('#userId>input').val().trim());
	})
	$('.checkbox').on('click', function() {
		if($('.checkbox')[0].checked) {
			$('#submit')[0].disabled = false;
		} else {
			$('#submit')[0].disabled = true;
		}
	})
	$('#password>input').on('blur',function(){
		var reg=/^[0-9A-Za-z]{6,18}$/;
		if(!reg.test($('#password>input').val().trim())) {
			$("#password").find('span').html("密码长度应为6-18位");
			passwordok=false;
		} else {
			$("#password").find('span').html("");
			passwordok=true;
		}
	})
	$('#logsure>input').on('blur',function(){
		var reg=/^[a-zA-Z]\w{5,17}$/;
		if($('#logsure>input').val().trim()!=$('#password>input').val().trim()) {
			$("#logsure").find('span').html("密码不一致");
			repasswordok=false;
		} else {
			$("#logsure").find('span').html("");
			repasswordok=true;
		}
	})
	function isphone(obj) {
		obj=obj.replace(/\s/g, "");
	    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if(!myreg.test(obj)) {
			$("#userId").find('span').html("请输入正确的手机号码");
			$("#userId").fous();
		} else {
			$("#userId").find('span').html("");
		}
		$.ajax({
		    type : 'post',
		    url : 'company_mobilRepCHeck.html',
		    dataType : 'text',
		    data : $('#userId1').serialize(),
		    success : function (date) {
		    	if(date=="1")
		    	{
		    		$("#userId").find('span').html("");
		    		phoneok=true;
		    	}
		    	else{
		    		phoneok=false;
		    		$("#userId").find('span').html("该手机号已经注册！");
		    	}
		    },
		    error : function (xmlq, errq) {
//		    	alert("xmlq:"+xmlq);
//		        alert(errq);
		    }
		});
	}
	
	
	$('#companytype>select').on('change',function() {
		var num=$('#type').prop('selectedIndex');
		if(num==0){
			$("#companytype").find('span').html("请选择公司类型");
			$('#type').focus();
			companyType=false;
		}
		else {
			$("#cimpanytype").find('span').html("");
			companyType=true;
		}
	})
	
	$('#companyName>input').on('blur',function(){
		var companyName=$('#companyName>input').val().trim();
		if(companyName==""||companyName==null){
			$("#companyName").find('span').html("请输入公司名称");
			$('#companyName').focus();
			companyNameOk=false;
		}	
		else{
			$.ajax({
			    type : 'post',
			    url : 'company_nameRep.html',
			    dataType : 'text',
			    data : {"name":companyName},
			   //1：查询到表示有公司存在，重复  0：表示未重复
			    success : function (date) {
			    	if("1"==date)
			    	{
			    		$("#companyName").find('span').html("公司已经注册");
			    		companyNameOk=false;
			    	}
			    	else{
			    		$("#companyName").find('span').html("");
			    		companyNameOk=true;
			    	}
			    },
			    error : function (xmlq, errq) {
			    	alert("xmlq:"+xmlq);
			        alert(errq);
			    }
			});
		}
	})
	
	$('#organizationDiv>input').on('blur',function(){
		organization = $('#organizationDiv>input').val().replace(/\s/g, "");
		if(organization==""||organization==null){
			$("#organizationDiv").find('span').html("请输入组织机构代码");
			$('#organizationDiv').focus();
			organizationOk=false;
		}	
		else if(organization.length!=15&&organization.length!=18)
		{
			$("#organizationDiv").find('span').html("请输入15位或者18位统一社会信用代码");
			$('#organizationDiv').focus();
			organizationOk=false;
		}
		else{
			$("#organizationDiv").find('span').html("");
			$.ajax({
			    type : 'post',
			    url : 'company_organizationRep.html',
			    dataType : 'text',
			    data : {"organization":organization},
			   //1：查询到表示有公司存在，重复  0：表示未重复
			    success : function (date) {
			    	if("1"==date)
			    	{
			    		$("#organizationDiv").find('span').html("公司已经注册");
			    		organizationOk=false;
			    	}
			    	else
			    	{
			    		$("#organizationDiv").find('span').html("");
			    		organizationOk=true;
			    	}
			    },
			    error : function (xmlq, errq) {
			    	alert("xmlq:"+xmlq);
			        alert(errq);
			    }
			});
		}
	})
	
	
	/**
	 * 校验姓名
	 */
	$('#leaderName>input').on('blur', function() {
		check_leaderName($('#leaderName>input').val().trim());
	})
	function check_leaderName(str) {  
	    var str = str.substr(0, 1); //截取用户提交的用户名的前两字节，也就是姓。   
	    var surname = " 赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤 滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵堪汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董粱杜阮蓝闵席季麻强贾路娄危江童颜郭 梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松 井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双 闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍郤璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东 殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊 澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱 晋楚闫法汝鄢涂钦段干百里东郭南门呼延妫海羊舌微生岳帅缑亢况後有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福";  
	    r = surname.search(str); // 查找字符串。  
	    if (r == -1) {  
	    	$("#leaderName").find('span').html("请输入真实姓名");
	    	nameOk=false;
	    } 
	    if (str == "") {  
	    	$("#leaderName").find('span').html("联系人不准为空");
	    	nameOk=false;
	    } 
	    else{  
	    	$("#leaderName").find('span').html("");
	    	nameOk=true;
	    }  
	} 
	
	$('#submit').click(function(){
        if(phoneok && passwordok&& repasswordok&&companyType&&nameOk&&organizationOk&&companyNameOk){
            $('form').submit();
        }else{ 
        	if(!phoneok){	
	        	$("#userId").find('span').html("请输入正确的手机号码");
				$("#userId").focus();
	        	return false;
	        }else if(!passwordok){
	        	$("#userPassword").find('span').html("密码长度应为6-18位");
	        	$("#userPassword").find('span').css("color","red");
	        	$("#userPassword").focus();
	            return false;
	        }else if(!repasswordok){
	        	$("#logsure").find('span').html("密码不一致");
	        	$("#logsure").find('span').css("color","red");
	            return false;
	        }else if(!companyType){
	        	$("#companytype").find('span').html("请选择公司类型");
				$('#type').focus();	
	            return false;
	        }
	        else if(!companyNameOk){
	        	$("#companyName").find('span').html("请输入正确的公司名称");
				$('#companyName').focus();
	            return false;
	        }
	        else if(!organizationOk){
	        	$("#organizationDiv").find('span').html("请输入组织机构代码");
				$('#organizationDiv').focus();
	            return false;
	        }
	        else if(!nameOk){
	        	$("#leaderName").find('span').html("请输入真实姓名");
	        	$("#leaderName").find('span').css("color","red");
	            return false;
	        }
        }
    });
})(jQuery)