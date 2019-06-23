<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8'%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>自动备份设置</title>
<link href="css/1.css" type="text/css" rel="stylesheet">
</head>
<script src="js/1.js" type="text/javascript"></script>
<script>
	function save() {
		showP("保存成功！");
	}
</script>
<body>
	<h2>自动备份设置</h2>
	<div id="div" class="a">
		<input type="checkbox" checked>开启自动备份<br> 自动备份间隔时间&ensp;<input type="text" size="1" value="30">天<br> <input type="checkbox" checked>开启通讯录更改自动备份
	</div>
	<div>
		<p id="show">&ensp;</p>
		<button onClick="save()" class="c">
			保存<br>更改
		</button>
		<div class="c" style="display:inline-block;">&ensp;</div>
		<button onClick="skip('main.jsp')" class="c">
			返回<br>主界面
		</button>
	</div>
</body>
</html>