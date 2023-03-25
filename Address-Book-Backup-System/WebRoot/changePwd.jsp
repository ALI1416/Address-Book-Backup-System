<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8' %>
  <!doctype html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>修改密码</title>
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
            showP("旧密码错误！");
            break;
          default:
            showP("未知错误！");
        }
      } else {
        showP("请填写以上所有内容！");
      }
    }
    function changePwd() {
      var user_pwd = document.getElementById("user_pwd");
      var user_pwd2 = document.getElementById("user_pwd2");
      var user_old_pwd = document.getElementById("user_old_pwd");
      if (user_pwd.value == "" || user_old_pwd.value == "" || user_pwd.value != user_pwd2.value) {
        showP("必须全部填写！<br>密码和确认密码必须相同！");
        return false;
      } else {
        var md5_pwd = document.getElementById("md5_pwd");
        md5_pwd.value = hex_md5(user_pwd.value); //md5加密
        var md5_old_pwd = document.getElementById("md5_old_pwd");
        md5_old_pwd.value = hex_md5(user_old_pwd.value); //md5加密
        return true;
      }
    }
  </script>

  <body>
    <h1>修改密码</h1>
    <form action="servlet/ChangePwd" method="get" onsubmit="return changePwd()">
      <table align="center">
        <tr>
          <td>旧&ensp;密&ensp;码：</td>
          <td>
            <input type="hidden" name="user_old_pwd" id="md5_old_pwd" value=""> <input type="password" id="user_old_pwd"
              size="16" value="">
          </td>
        </tr>
        <tr>
          <td>新&ensp;密&ensp;码：</td>
          <td>
            <input type="hidden" name="user_pwd" id="md5_pwd" value=""> <input type="password" id="user_pwd" size="16"
              value="">
          </td>
        </tr>
        <tr>
          <td>确认密码：</td>
          <td>
            <input type="password" id="user_pwd2" size="16" value="">
          </td>
        </tr>
        <tr>
          <td>
            <button type="reset" class="i">重填</button>
          </td>
          <td>
            <button type="submit" class="i">确定</button>
            <a href="main.jsp" style="font-size: 10px;">返回首页</a>
          </td>
        </tr>
      </table>
    </form>
    <p id="show"></p>
  </body>

  </html>