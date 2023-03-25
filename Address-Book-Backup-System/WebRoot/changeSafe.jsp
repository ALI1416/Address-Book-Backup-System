<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8' %>
  <!doctype html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>修改密保</title>
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
            showP("旧密保错误！");
            break;
          default:
            showP("未知错误！");
        }
      } else {
        showP("请填写以上所有内容！");
      }
    }
    function changeSafe() {
      var user_safe = document.getElementById("user_safe");
      var user_safe2 = document.getElementById("user_safe2");
      var user_old_safe = document.getElementById("user_old_safe");
      if (user_safe.value == "" || user_old_safe.value == "" || user_safe.value != user_safe2.value) {
        showP("必须全部填写！<br>密保和确认密保必须相同！");
        return false;
      } else {
        var md5_safe = document.getElementById("md5_safe");
        md5_safe.value = hex_md5(user_safe.value); //md5加密
        var md5_old_safe = document.getElementById("md5_old_safe");
        md5_old_safe.value = hex_md5(user_old_safe.value); //md5加密
        return true;
      }
    }
  </script>

  <body>
    <h1>修改密码</h1>
    <form action="servlet/ChangeSafe" method="get" onsubmit="return changeSafe()">
      <table align="center">
        <tr>
          <td>旧&ensp;密&ensp;保：</td>
          <td>
            <input type="hidden" name="user_old_safe" id="md5_old_safe" value=""> <input type="text" id="user_old_safe"
              size="16" value="">
          </td>
        </tr>
        <tr>
          <td>新&ensp;密&ensp;保：</td>
          <td>
            <input type="hidden" name="user_safe" id="md5_safe" value=""> <input type="text" id="user_safe" size="16"
              value="">
          </td>
        </tr>
        <tr>
          <td>确认密保：</td>
          <td>
            <input type="text" id="user_safe2" size="16" value="">
          </td>
        </tr>
        <tr>
          <td>
            <button type="reset" class="i">重填</button>
          </td>
          <td>
            <button type="submit" class="i">修改</button>
            <a href="main.jsp" style="font-size: 10px;">返回首页</a>
          </td>
        </tr>
      </table>
    </form>
    <p id="show"></p>
  </body>

  </html>