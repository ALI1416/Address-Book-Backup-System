<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8' %>
  <!doctype html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>自动备份软件</title>
    <link href="css/1.css" type="text/css" rel="stylesheet">
  </head>
  <script src="js/md5.js" type="text/javascript"></script>
  <script src="js/1.js" type="text/javascript"></script>
  <script>
    window.onload = function () {
      var error = getParameter("error");
      if (error != null) {
        switch (error) {
          case "1":
            showP("账号或密码错误！");
            break;
          default:
            showP("未知错误！");
        }
      } else {
        showP("请输入账号密码！");
      }
    }
    function login() {
      var show = document.getElementById("show");
      var user_name = document.getElementById("user_name");
      var user_pwd = document.getElementById("user_pwd");
      if (user_name.value == "" | user_pwd.value == "") {
        showP("账号或密码不能为空！");
        return false;
      } else {
        var md5_pwd = document.getElementById("md5_pwd");
        md5_pwd.value = hex_md5(user_pwd.value); //md5加密
        return true;
      }
    }
  </script>

  <body>
    <h1>登录</h1>
    <form action="servlet/Login" method="get" onsubmit="return login()">
      <table align="center">
        <tr>
          <td>用户名：</td>
          <td>
            <input type="text" id="user_name" name="user_name" size="16" value="">
          </td>
        </tr>
        <tr>
          <td>密&ensp;&ensp;码：</td>
          <td>
            <input type="hidden" name="user_pwd" id="md5_pwd" value=""> <input type="password" name="user_pwd"
              id="user_pwd" size="16" value="">
          </td>
        </tr>
        <tr>
          <td>
            <button type="button" class="i" onClick="skip('register.jsp')">注册</button>
          </td>
          <td>
            <button type="submit" class="i">登录</button>
            <a href="forgetPwd.jsp" style="font-size: 10px;">忘记密码</a>
          </td>
        </tr>
      </table>
    </form>
    <p id="show"></p>
  </body>

  </html>