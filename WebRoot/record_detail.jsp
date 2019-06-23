<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8'%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>备份记录详细信息</title>
<link href="css/1.css" type="text/css" rel="stylesheet">
</head>
<script src="js/1.js" type="text/javascript"></script>
<script>
	window.onload = function() {
		var div = document.getElementById("div");
		var t = document.createElement("table");
		t.id = "table";
		var tr,
			td;
		for (var i = 0; i < 20; i++) {
			tr = t.insertRow(i);
			td = tr.insertCell(0);
			td.innerHTML = "姓名&ensp;<input type='text' value='联系人" + i + "' size='5'>&ensp;手机&ensp;<input type='text' value='188088888" + i + "' size='11'><input type='button' value='x' onClick='del(this)'>";
		}
		div.appendChild(t);
	}
	function add() {
		var t = document.getElementById("table");
		var tr = t.insertRow(0);
		var td = tr.insertCell(0);
		td.innerHTML = "姓名&ensp;<input type='text' value='' size='5'>&ensp;手机&ensp;<input type='text' value='' size='11'><input type='button' value='x' onClick='del(this)'>";
		showP("请输入新增信息！");
	}
	function del(obj) {
		obj.parentNode.parentNode.parentNode.removeChild(obj.parentNode.parentNode);
		showP("删除成功！");
	}
	function back() {
		history.back(-1);
	}
	function save() {
		showP("保存成功！正在到跳转上一页。");
		setTimeout(function() {
			history.back(-1);
		}, 500);
	}
</script>
<body>
	<h2>备份记录详细信息</h2>
	<div id="div" class="a"></div>
	<div>
		<p id="show">&ensp;</p>
		<button onClick="save()" class="c">
			保存<br>更改
		</button>
		<button onClick="add()" class="c">
			新增<br>联系人
		</button>
		<button onClick="back()" class="c">
			返回<br>上一页
		</button>
	</div>
</body>
</html>