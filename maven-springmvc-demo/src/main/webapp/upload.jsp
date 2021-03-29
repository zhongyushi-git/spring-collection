<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <!--文件上传必须按照下面的格式写，缺一不可-->
    <form action="upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <input type="submit">
    </form>
</body>
</html>
