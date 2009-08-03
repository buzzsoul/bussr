<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bussr.css" type="text/css" media="screen" />

</head>
<body>
<div id="container">
    <div id="topnav">
     	  <p>bussr account</p>
    </div>

    <div id="header">
    <div id="header2">
    <h1 id="slogan">Discover what's telling about you on the net</h1>
    <a class="logo" href="/bussr/">bussr</a>
    <stripes:form id="home-search" beanclass="org.dataport.bussr.action.SearchActionBean">
        <div>
	        <stripes:text id="home-search-q" tabindex="1" size="40" name="query" />
	        <stripes:submit id="home-search-submit" value="search" tabindex="2" name="search" />
        </div>
    </stripes:form>
    </div>
    </div>

     <div id="trends-tags">
       <p>popular tags</p>
       <c:if test="${not empty actionBean.searchTerms}">
            <ul>
	            <c:forEach items="${actionBean.searchTerms}" var="current">
	               <li>${current.term}</li>
	               <%-- use count field for setting the size of the font --%>
	            </c:forEach>
            </ul>
        </c:if>
       <div>
       </div>
     </div>
</div>
</body>
</html>
