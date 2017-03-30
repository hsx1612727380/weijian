(function($) {
	var add = document.getElementsByClassName('add');
	var del = document.getElementsByClassName('del');
	var addform = document.getElementById('addForm');
	var cancel = document.getElementById('cancel');
	var sure = document.getElementById('sure');
	var formvalue = addform.getElementsByClassName('val');
	var querytable = document.getElementsByClassName('querytable')[0];
	var addnote = document.getElementById('addnote');
	var addnotesure = addnote.getElementsByClassName('sure')[0];
	var addnotecan = addnote.getElementsByClassName('cancel')[0];
	var delnote = document.getElementById('delnote');
	var delnotesure = delnote.getElementsByClassName('sure')[0];
	var delnotecan = delnote.getElementsByClassName('cancel')[0];
	var flag,table;
	$(document).on('click', '.add', myclick);
	$(document).on('click', '.del', delform);
	//增加信息表单取消按钮
	cancel.onclick = function() {
		addform.style.display = 'none';
	}
	//信息增加弹框确认按钮
	addnotesure.onclick = function() {
		var tr = document.createElement('tr');
		var str = '';
		for(var j = 0; j < formvalue.length; j++) {
			str += '<td>' + formvalue[j].value + "</td>";

		}
		str += '<td></td><td></td>';
		str += '<td><span class="add">增加</span>&nbsp;&nbsp;<span class="del">删除</span></td>';
		tr.innerHTML = str;
		querytable.appendChild(tr);
		addform.style.display = 'none';
		addnote.style.display = 'none';
	};
	//信息增加弹框取消按钮
	addnotecan.onclick = function() {
		addnote.style.display = 'none';
	}
	//信息删除弹框取消按钮
	delnotecan.onclick=function(){
		delnote.style.display='none';
	}
	//信息删除弹框确认按钮
	delnotesure.onclick=function(){
		table.removeChild(tablechild);
		delnote.style.display='none';
	}
	//增加按钮确认效果
	$(document).on('click', '#sure', function() {
		addnote.style.display = 'block';
	});

	
	function myclick() {
		addform.style.display = 'block';
	}

	function delform() {
		table = this.parentElement.parentElement.parentElement;
		tablechild=this.parentElement.parentElement;
		delnote.style.display='block';
	}
})(jQuery)