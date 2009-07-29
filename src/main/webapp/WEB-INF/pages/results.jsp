<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"	uri="http://stripes.sourceforge.net/stripes.tld"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
</head>
<body>
<div>
    <h1>Resultado de su busqueda</h1> 
    <c:choose>
        <c:when test="${not empty actionBean.results}">
            <ul>
            <c:forEach items="${actionBean.results}" var="current">
                <li>
                    <h3>${current.title}</h3>
                    <span><a href="${current.link}">Quiero ver que se dice...</a></span>
                    <br/>
                    <sub>Encontrado en ${current.provider} (aca dependiendo del valor de la enum, mostramos el icono del sitio donde se encontro)</sub>
                    <span>${current.rating}</span>
                </li>
            </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <span>No hay resultados</span>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>