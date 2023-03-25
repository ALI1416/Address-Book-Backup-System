<%@ page language='java' import='java.util.*' contentType='text/html; charset=utf-8' %>
  <!doctype html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>主界面</title>
    <link href="css/1.css" type="text/css" rel="stylesheet">
  </head>
  <script src="js/1.js" type="text/javascript"></script>

  <body>
    <h1>主界面</h1>
    <table align="center">
      <tr>
        <td>
          <button class="b" onClick="skip('backup.jsp')">
            本地通讯录<br>备份
          </button>
        </td>
        <td>
          <button class="b" onClick="skip('recover.jsp')">
            本地通讯录<br>恢复
          </button>
        </td>
      </tr>
      <tr>
        <td>
          <button class="b" onClick="skip('book.jsp')">
            云端<br>通讯录
          </button>
        </td>
        <td>
          <button class="b" onClick="skip('record.jsp')">
            云端<br>备份记录
          </button>
        </td>
      </tr>
      <tr>
        <td>
          <button class="b" onClick="skip('auto.jsp')">
            自动备份<br>设置
          </button>
        </td>
        <td>
          <button class="b" onClick="skip('set.jsp')">设置</button>
        </td>
      </tr>
    </table>
  </body>

  </html>