$(this).ready(function(){
	var isLeader = $("#isLeader").val();
	console.log(isLeader);
	var teamOrProject = $("#teamOrProject");
	var role = $("#role");
	console.log(teamOrProject.html());
	if(isLeader=='1'){			//班组长
		$(".individual").hide();
		teamOrProject.html("所在项目");
		role.html("班组长");
	}else if(isLeader=='0'){	//未加入班组
		$(".team").hide();
		teamOrProject.html("未加入班组");
		role.html("个人");
	}else if(isLeader=="2"){	//已加入班组
		$(".team").hide();
		$(".individual.inteam").hide();
		teamOrProject.html("所在班组");
		role.html("个人");
	}
	
});
