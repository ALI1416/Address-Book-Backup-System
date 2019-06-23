<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8'%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>云端备份记录</title>
<link href="css/1.css" type="text/css" rel="stylesheet">
</head>
<script src="js/1.js" type="text/javascript"></script>
<script>
	window.onload = function() {
		var div = document.getElementById("div");
		var t = document.createElement("table");
		t.id = "table";
		t.width = "290px;";
		t.style = "text-align: left;";
		var tr,
			td;
		for (var i = 0; i < 10; i++) {
			tr = t.insertRow(i * 2);
			td = tr.insertCell(0);
			td.innerHTML = "记录" + i + "&ensp;联系人1" + i + "个";
			td = tr.insertCell(1);
			td.innerHTML = "<input type='button' value='查看详情' onClick=\"skip('record_detail.jsp')\">";
			tr = t.insertRow(i * 2 + 1);
			td = tr.insertCell(0);
			td.innerHTML = "&ensp;&ensp;2018-12-1" + i + " 13:14:15";
			td = tr.insertCell(1);
			td.innerHTML = "<input type='button' value='删除' onClick='del(this)'>";
		}
		div.appendChild(t);
	}
	function del(obj) {
		var o = obj.parentNode.parentNode;
		o.parentNode.removeChild(o.previousElementSibling);
		o.parentNode.removeChild(o);
		showP("删除成功！");
	}
	function save() {
		showP("保存成功！");
	}
</script>
<body>
	<h2>云端备份记录</h2>
	<div id="div" class="a"></div>
	<div>
		<p id="show">&ensp;</p>
		<button onClick="save()" class="c">
			保存<br>更改
		</button>
		<button onClick="skip('record_add.jsp')" class="c">
			新增<br>备份记录
		</button>
		<button onClick="skip('main.jsp')" class="c">
			返回<br>主界面
		</button>
	</div>
</body>
</html>