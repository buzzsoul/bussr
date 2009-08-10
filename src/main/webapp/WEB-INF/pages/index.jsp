<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bussr.css" type="text/css" media="screen" />
</head>
<body>

<div id="container">
    <div id="topnav">
        <security:authentication property="principal" scope="page" var="userPrincipal"/>
        <c:choose>
            <c:when test="${not empty userPrincipal}">
                <fmt:message key="user.welcome"/> ${userPrincipal} | <stripes:link href="/logout"><fmt:message key="user.logout"/></stripes:link>
            </c:when>
            <c:otherwise>
                <p><stripes:link beanclass="org.dataport.bussr.action.LoginActionBean">bussr <fmt:message key="user.account"/></stripes:link></p>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="header">
	    <div id="header2">
		<h1 id="slogan"><fmt:message key="search.legend"/></h1>
		<a class="logo" href="/">bussr</a>
		<stripes:form id="home-search" beanclass="org.dataport.bussr.action.SearchActionBean">
	          <div>
	            <stripes:text id="home-search-q" tabindex="1" size="40" name="query" />
	            <stripes:submit id="home-search-submit" value="search" tabindex="2" name="search" />
	          </div>
		</stripes:form>
	    </div>
    </div>

    <div id="trends-tags">
        <h2><fmt:message key="search.popular"/></h2>
        <c:if test="${not empty actionBean.searchTerms}">
        <ul>  
        <c:forEach items="${actionBean.searchTerms}" var="current">
            <li><stripes:link beanclass="org.dataport.bussr.action.SearchActionBean" class="tag${fn:substring((current.total * 10 / actionBean.totalSearchTermHits), 0, 1)}"><stripes:param name="query" value="${current.term}"/>${current.term}</stripes:link></li>
        </c:forEach>
        </ul>
        </c:if>
      </div>
</div>
</body>
</html>
