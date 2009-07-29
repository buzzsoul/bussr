<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
</head>
<body>
<div>
    <stripes:form beanclass="org.dataport.bussr.action.SearchActionBean">
        Que quieres consultar ... <stripes:text name="query" />
        <stripes:submit name="search" />
    </stripes:form>
</div>
</body>
</html>