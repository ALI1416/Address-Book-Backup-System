<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8'%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>设置</title>
<link href="css/1.css" type="text/css" rel="stylesheet">
</head>
<script src="js/1.js" type="text/javascript"></script>
<body>
	<h1>设置</h1>
	<table align="center">
		<tr>
			<td>
				<button class="b" onClick="skip('changePwd.jsp')">修改密码</button>
			</td>
			<td>
				<button class="b" onClick="skip('changeSafe.jsp')">修改密保</button>
			</td>
		</tr>
		<tr>
			<td>
				<button class="b" onClick="skip('main.jsp')">
					返回<br>主界面
				</button>
			</td>
			<td>
				<button class="b" onClick="skip('login.jsp')">退出登录</button>
			</td>
		</tr>
	</table>
</body>
</html>