<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bussr.css" type="text/css" media="screen" />
</head>
<body>
<div id="container">
    <form action="/do_login" method="POST">
        <input type='text' name='j_username'/>
        <input name="submit" type="submit"/>
    </form>
</div>
</body>
</html>
