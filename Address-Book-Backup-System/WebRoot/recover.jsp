<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8' %>
  <!doctype html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>本地通讯录恢复</title>
    <link href="css/1.css" type="text/css" rel="stylesheet">
  </head>
  <script src="js/1.js" type="text/javascript"></script>
  <script>
    window.onload = function () {
      var div = document.getElementById("div");
      var t = document.createElement("table");
      t.id = "table";
      t.width = "290px;";
      t.style = "text-align: left;";
      var tr,
        td;
      for (var i = 0; i < 20; i++) {
        tr = t.insertRow(i * 2);
        td = tr.insertCell(0);
        td.innerHTML = "记录" + i + "&ensp;联系人1" + i + "个";
        td = tr.insertCell(1);
        td.innerHTML = "<input type='button' value='查看详情' onClick=\"skip('record_detail.jsp')\">";
        tr = t.insertRow(i * 2 + 1);
        td = tr.insertCell(0);
        td.innerHTML = "&ensp;&ensp;2018-12-2" + i + " 13:14:15";
        td = tr.insertCell(1);
        td.innerHTML = "<input type='button' value='恢复' onClick='recover()'>";
      }
      div.appendChild(t);
    }
    function recover() {
      showP("恢复成功！");
    }
  </script>

  <body>
    <h2>本地通讯录恢复</h2>
    <div id="div" class="a"></div>
    <div>
      <p id="show">&ensp;</p>
      <div class="c" style="display:inline-block;">&ensp;</div>
      <div class="c" style="display: inline-block;">&ensp;</div>
      <button onClick="skip('main.jsp')" class="c">
        返回<br>主界面
      </button>
    </div>
  </body>

  </html>