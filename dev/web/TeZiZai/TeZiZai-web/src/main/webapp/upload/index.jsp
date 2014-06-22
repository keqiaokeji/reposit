<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="<%=path%>/upload/ajaxFileUploader/ajaxfileupload.css" type="text/css"></link>

    <script type="text/javascript" src="<%=path%>/upload/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/upload/ajaxFileUploader/ajaxfileupload.js"></script>
    <script type="text/javascript" src="<%=path%>/upload/myJs.js"></script>
</head>
<body>
<div id="fileQueue">
    <img id="loadingimg" style="display: none;" src="<%=path%>/upload/ajaxFileUploader/loading.gif"></img>
</div>
<input id="avatar" name="avatar" type="file" value="请选择上传的文件">
<input type="button" onclick="contactAjaxFileUpload()" value="上传">
</body>
</html>
