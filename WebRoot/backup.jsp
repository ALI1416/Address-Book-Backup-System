<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8'%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>本地通讯录备份</title>
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
			td.innerHTML = "<input type='checkbox' checked>姓名&ensp;<input type='text' value='联系人" + i + "' size='5'>&ensp;手机&ensp;<input type='text' value='188088888" + i + "' size='11'>";
		}
		div.appendChild(t);
	}
	function backup() {
		showP("同步成功！");
	}
</script>
<body>
	<h2>本地通讯录备份</h2>
	<div id="div" class="a"></div>
	<div>
		<p id="show">选择联系人并同步到云端</p>
		<button onClick="backup()" class="c">
			同步到<br>云端
		</button>
		<div class="c" style="display:inline-block;">&ensp;</div>
		<button onClick="skip('main.jsp')" class="c">
			返回<br>主界面
		</button>
	</div>
</body>
</html>